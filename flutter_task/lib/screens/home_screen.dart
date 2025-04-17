import 'dart:io';
import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';
import 'add_edit_student_screen.dart'; // Ensure correct import
import '../models/student.dart';
import '../services/student_service.dart';
import '../services/localization_service.dart';
import 'student_detail_screen.dart'; // Import StudentDetailScreen

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final StudentService _studentService = StudentService();
  final LocalizationService _localizationService = LocalizationService();
  final TextEditingController _searchController = TextEditingController();
  String _searchQuery = '';

  @override
  void initState() {
    super.initState();
    _checkBirthdays();
  }

  // Check if any student's birthday is today and show a notification
  void _checkBirthdays() {
    _studentService.getStudentsWithBirthdayToday().listen((students) {
      for (var student in students) {
        if (!mounted) return;
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(
            content: Text(
              _localizationService.translateWithParams(
                'home.birthday_today',
                {'name': student.name},
              ),
            ),
            duration: const Duration(seconds: 5),
          ),
        );
      }
    });
  }

  // Method to show delete confirmation dialog
  void _showDeleteConfirmationDialog(String studentId) {
    showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: Text(_localizationService.translate('home.delete_confirmation')),
          content: Text(_localizationService.translate('home.delete_message')),
          actions: [
            TextButton(
              onPressed: () {
                Navigator.of(context).pop(); // Close dialog
              },
              child: Text(_localizationService.translate('home.cancel')),
            ),
            TextButton(
              onPressed: () async {
                await _deleteStudent(studentId); // Delete student if confirmed
                Navigator.of(context).pop(); // Close dialog
              },
              child: Text(_localizationService.translate('home.delete')),
            ),
          ],
        );
      },
    );
  }

  // Method to delete student from the service
  Future<void> _deleteStudent(String studentId) async {
    try {
      await _studentService.deleteStudent(studentId);
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text(_localizationService.translate('student.deleted'))),
      );
    } catch (e) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Error deleting student: $e')),
      );
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(_localizationService.translate('home.title')),
        actions: [
          PopupMenuButton<Locale>(
            icon: const Icon(Icons.language),
            onSelected: (Locale locale) {
              _localizationService.changeLocale(locale);
              setState(() {}); // Rebuild UI after changing locale
            },
            itemBuilder: (context) => LocalizationService.supportedLocales
                .map(
                  (locale) => PopupMenuItem(
                    value: locale,
                    child: Text(
                      _localizationService.translate('languages.${locale.languageCode}'), // Fetch the full language name from the JSON
                    ),
                  ),
                )
                .toList(),
          ),
        ],
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: _searchController,
              decoration: InputDecoration(
                hintText: _localizationService.translate('home.search_hint'),
                prefixIcon: const Icon(Icons.search),
                border: const OutlineInputBorder(),
              ),
              onChanged: (value) {
                setState(() {
                  _searchQuery = value;
                });
              },
            ),
          ),
          Expanded(
            child: StreamBuilder<List<Student>>(
              stream: _searchQuery.isEmpty
                  ? _studentService.getStudents()
                  : _studentService.searchStudents(_searchQuery),
              builder: (context, snapshot) {
                if (snapshot.hasError) {
                  return Center(child: Text('Error: ${snapshot.error}'));
                }

                if (!snapshot.hasData) {
                  return const Center(child: CircularProgressIndicator());
                }

                final students = snapshot.data!;
                // In the ListView.builder in the build method
                return ListView.builder(
                  itemCount: students.length,
                  itemBuilder: (context, index) {
                    final student = students[index];
                    return ListTile(
                      leading: CircleAvatar(
                        backgroundImage: student.localProfileImagePath != null
                            ? FileImage(File(student.localProfileImagePath!))
                            : (student.profilePictureUrl.isNotEmpty
                                ? CachedNetworkImageProvider(student.profilePictureUrl)
                                : null),
                        child: (student.localProfileImagePath == null && student.profilePictureUrl.isEmpty)
                            ? Text(student.name.isNotEmpty ? student.name[0] : '?')
                            : null,
                      ),
                      title: Text(student.name),
                      subtitle: Text(student.rollNumber),
                      trailing: Row(
                        mainAxisSize: MainAxisSize.min,
                        children: [
                          if (student.hasBirthdayToday())
                            const Icon(Icons.cake, color: Colors.pink),
                          IconButton(
                            icon: const Icon(Icons.edit),
                            onPressed: () {
                              // Navigate to the edit screen and pass the student
                              Navigator.push(
                                context,
                                MaterialPageRoute(
                                  builder: (context) =>
                                      AddEditStudentScreen(student: student),
                                ),
                              );
                            },
                          ),
                          IconButton(
                            icon: const Icon(Icons.delete),
                            onPressed: () {
                              _showDeleteConfirmationDialog(student.id);
                            },
                          ),
                        ],
                      ),
                      onTap: () {
                        // Navigate to the Student Detail Screen
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => StudentDetailScreen(student: student),
                          ),
                        );
                      },
                    );
                  },
                );
              },
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          // Navigate to AddEditStudentScreen when the button is clicked
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) => const AddEditStudentScreen()),
          );
        },
        child: const Icon(Icons.add),
      ),
    );
  }

  @override
  void dispose() {
    _searchController.dispose();
    super.dispose();
  }
}
