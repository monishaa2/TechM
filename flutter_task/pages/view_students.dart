import 'package:flutter/material.dart';
import '../database/db_helper.dart';

class ViewStudentsPage extends StatefulWidget {
  @override
  _ViewStudentsPageState createState() => _ViewStudentsPageState();
}

class _ViewStudentsPageState extends State<ViewStudentsPage> {
  final dbHelper = DatabaseHelper();
  List<Map<String, dynamic>> students = [];

  @override
  void initState() {
    super.initState();
    _loadStudents();
  }

  void _loadStudents() async {
    List<Map<String, dynamic>> data = await dbHelper.getStudents();
    setState(() {
      students = data;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Student Details')),
      body: students.isEmpty
          ? Center(child: Text('No students added yet!'))
          : ListView.builder(
              itemCount: students.length,
              itemBuilder: (context, index) {
                final student = students[index];
                return Card(
                  child: ListTile(
                    leading: student['imageUrl'].isNotEmpty
                        ? Image.network(student['imageUrl'], width: 50, height: 50, fit: BoxFit.cover)
                        : Icon(Icons.person, size: 50),
                    title: Text(student['name']),
                    subtitle: Text('Class: ${student['studentClass']} | Age: ${student['age']}'),
                    trailing: Text(student['address']),
                  ),
                );
              },
            ),
    );
  }
}
