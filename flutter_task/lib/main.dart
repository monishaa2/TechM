import 'package:flutter/material.dart';
import 'package:firebase_core/firebase_core.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:student1/screens/home_screen.dart';
import 'firebase_options.dart';
import 'services/localization_service.dart';


void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  final LocalizationService _localizationService = LocalizationService();
  bool _isLocalizationLoaded = false;

  @override
  void initState() {
    super.initState();
    _initializeLocalization();
  }

  Future<void> _initializeLocalization() async {
    await _localizationService.init(const Locale('en'));
    if (mounted) {
      setState(() {
        _isLocalizationLoaded = true;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    if (!_isLocalizationLoaded) {
      return const MaterialApp(
        home: Scaffold(
          body: Center(child: CircularProgressIndicator()),
        ),
      );
    }

    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: _localizationService.translate('app.title') == '[app.title]'
          ? 'My App' // Fallback title if localization isn't loaded
          : _localizationService.translate('app.title'),
      theme: ThemeData(primarySwatch: Colors.blue, useMaterial3: true),
      supportedLocales: LocalizationService.supportedLocales,
      localizationsDelegates: const [
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        GlobalCupertinoLocalizations.delegate,
      ],
      locale: _localizationService.currentLocale,
      home: const HomeScreen(),
    );
  }
}
