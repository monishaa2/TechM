import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

/// A service that handles localization (translations) for the application.
/// Supports multiple languages and provides methods to load and switch between locales.
class LocalizationService {
  /// The base path for language JSON files
  static const String _assetsPath = 'assets/lang/';

  /// List of supported locales in the application
  static const List<Locale> supportedLocales = [
    Locale('en'), // English
    Locale('ta'), // Tamil
    Locale('hi'), // Hindi
    Locale('ml'), // Malayalam
  ];

  /// Stores the loaded translations
  Map<String, dynamic> _localizedStrings = {};

  /// Current active locale, defaults to English
  Locale _currentLocale = const Locale('en');

  /// Singleton instance
  static final LocalizationService _instance = LocalizationService._internal();

  /// Factory constructor to return the singleton instance
  factory LocalizationService() => _instance;

  /// Private constructor for singleton pattern
  LocalizationService._internal();

  /// Gets the current locale
  Locale get currentLocale => _currentLocale;

  /// Initializes the localization service with the specified locale
  /// [locale] The locale to initialize with
  Future<void> init(Locale locale) async {
    _currentLocale = locale;
    await _loadLocalization(locale);
  }

  /// Loads the localization file for the specified locale
  /// [locale] The locale to load translations for
  Future<void> _loadLocalization(Locale locale) async {
    try {
      String jsonString = await rootBundle.loadString('$_assetsPath${locale.languageCode}.json');
      _localizedStrings = json.decode(jsonString);
      debugPrint("✅ Loaded localization for ${locale.languageCode}: $_localizedStrings");
    } catch (e) {
      debugPrint("❌ Error loading localization: $e");
      _localizedStrings = {};
    }
  }

  /// Changes the current locale and loads its translations
  /// [newLocale] The new locale to switch to
  /// Returns immediately if the locale is not supported
  Future<void> changeLocale(Locale newLocale) async {
    if (!supportedLocales.contains(newLocale)) {
      debugPrint("⚠️ Unsupported locale: ${newLocale.languageCode}");
      return;
    }
    _currentLocale = newLocale;
    await _loadLocalization(newLocale);
    debugPrint("🌍 Locale changed to ${newLocale.languageCode}");
  }

  /// Translates a key to its corresponding value in the current locale
  /// [key] The translation key in dot notation (e.g., 'home.title')
  /// Returns the translated string or the key in brackets if not found
  String translate(String key) {
    if (_localizedStrings.isEmpty) {
      debugPrint("⚠️ Localization data not loaded yet!");
      return '[$key]';
    }

    List<String> keys = key.split('.');
    dynamic value = _localizedStrings;

    for (String k in keys) {
      if (value == null || !value.containsKey(k)) {
        return '[$key]';
      }
      value = value[k];
    }

    return value?.toString() ?? '[$key]';
  }

  /// Translates a key and replaces parameters in the translation
  /// [key] The translation key
  /// [params] Map of parameters to replace in the translation
  /// Returns the translated string with parameters replaced
  // Add this method to your LocalizationService class
  String translateWithParams(String key, Map<String, String> params) {
    String translation = translate(key);
    params.forEach((paramKey, paramValue) {
      translation = translation.replaceAll('{$paramKey}', paramValue);
    });
    return translation;
  }
}
