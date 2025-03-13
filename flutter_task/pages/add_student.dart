import 'package:flutter/material.dart';
import '../database/db_helper.dart';

class AddStudentPage extends StatefulWidget {
  @override
  _AddStudentPageState createState() => _AddStudentPageState();
}

class _AddStudentPageState extends State<AddStudentPage> {
  final _formKey = GlobalKey<FormState>();
  final TextEditingController nameController = TextEditingController();
  final TextEditingController classController = TextEditingController();
  final TextEditingController ageController = TextEditingController();
  final TextEditingController imageController = TextEditingController();
  final TextEditingController addressController = TextEditingController();
  final dbHelper = DatabaseHelper();

  void _saveStudent() {
    if (_formKey.currentState!.validate()) {
      final student = {
        'name': nameController.text,
        'studentClass': classController.text,
        'age': int.parse(ageController.text),
        'imageUrl': imageController.text,
        'address': addressController.text,
      };
      dbHelper.insertStudent(student).then((_) {
        ScaffoldMessenger.of(context).showSnackBar(SnackBar(content: Text('Student Added!')));
        Navigator.pop(context);
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Enter Student Details')),
      body: Padding(
        padding: EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(controller: nameController, decoration: InputDecoration(labelText: 'Name'), validator: (value) => value!.isEmpty ? 'Enter name' : null),
              TextFormField(controller: classController, decoration: InputDecoration(labelText: 'Class'), validator: (value) => value!.isEmpty ? 'Enter class' : null),
              TextFormField(controller: ageController, decoration: InputDecoration(labelText: 'Age'), keyboardType: TextInputType.number, validator: (value) => value!.isEmpty ? 'Enter age' : null),
              TextFormField(controller: imageController, decoration: InputDecoration(labelText: 'Image URL')),
              TextFormField(controller: addressController, decoration: InputDecoration(labelText: 'Address')),
              SizedBox(height: 20),
              ElevatedButton(onPressed: _saveStudent, child: Text('Save')),
            ],
          ),
        ),
      ),
    );
  }
}
