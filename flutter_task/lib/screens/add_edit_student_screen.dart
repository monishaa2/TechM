import 'package:flutter/material.dart';
import '../models/student.dart';
import '../services/student_service.dart';
import '../services/localization_service.dart';
import 'package:intl/intl.dart';
import '../widgets/add_subject_dialog.dart';
import '../widgets/edit_mark_dialog.dart';
import 'package:image_picker/image_picker.dart';
import 'dart:io';

class AddEditStudentScreen extends StatefulWidget {
  final Student? student;

  const AddEditStudentScreen({super.key, this.student});

  @override
  State<AddEditStudentScreen> createState() => _AddEditStudentScreenState();
}

class _AddEditStudentScreenState extends State<AddEditStudentScreen> {
  final _formKey = GlobalKey<FormState>();
  final _studentService = StudentService();
  final _localizationService = LocalizationService();

  // Add all controller declarations
  late TextEditingController _nameController;
  late TextEditingController _rollNumberController;
  late TextEditingController _profilePictureUrlController;
  late TextEditingController _emailController;
  late TextEditingController _phoneController;
  late TextEditingController _addressController;
  late TextEditingController _parentNameController;
  late TextEditingController _parentContactController;
  late DateTime _selectedDate; // Keep only one declaration
  List<String> _hobbies = [];
  List<String> _certifications = [];
  Map<String, double> _subjectMarks = {};
  int _currentStep = 0;
  
  // Add image picker variables
  File? _image;
  final _picker = ImagePicker();
  
  @override
  void initState() {
    super.initState();
    _initializeControllers();
  }
  
  // Add image picker method
  Future<void> _pickImage() async {
    final XFile? pickedFile = await _picker.pickImage(source: ImageSource.gallery);
    
    if (pickedFile != null) {
      setState(() {
        _image = File(pickedFile.path);
      });
    }
  }
  
  void _initializeControllers() {
    // Existing initializations
    _nameController = TextEditingController(text: widget.student?.name);
    _rollNumberController = TextEditingController(text: widget.student?.rollNumber);
    _profilePictureUrlController = TextEditingController(text: widget.student?.profilePictureUrl);
    _selectedDate = widget.student?.dateOfBirth ?? DateTime.now();

    // New initializations
    _emailController = TextEditingController(text: widget.student?.email);
    _phoneController = TextEditingController(text: widget.student?.phoneNumber);
    _addressController = TextEditingController(text: widget.student?.address);
    _parentNameController = TextEditingController(text: widget.student?.parentName);
    _parentContactController = TextEditingController(text: widget.student?.parentContact);
    _hobbies = List.from(widget.student?.hobbies ?? []);
    _certifications = List.from(widget.student?.certifications ?? []);
    _subjectMarks = Map.from(widget.student?.subjectMarks ?? {});
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.student == null
            ? _localizationService.translate('home.add_student')
            : _localizationService.translate('student.edit')),
      ),
      body: Form(
        key: _formKey,
        child: Column(
          children: [
            Expanded(
              child: Stepper(
                currentStep: _currentStep,
                onStepContinue: () {
                  if (_currentStep < 3) {
                    setState(() => _currentStep++);
                  } else {
                    _saveStudent();
                  }
                },
                onStepCancel: () {
                  if (_currentStep > 0) {
                    setState(() => _currentStep--);
                  }
                },
                controlsBuilder: (context, details) {
                  return Row(
                    children: [
                      ElevatedButton(
                        onPressed: details.onStepContinue,
                        child: Text(_localizationService.translate('common.continue')),
                      ),
                      const SizedBox(width: 8),
                      TextButton(
                        onPressed: details.onStepCancel,
                        child: Text(_localizationService.translate('common.cancel')),
                      ),
                    ],
                  );
                },
                steps: [
                  _buildBasicInfoStep(),
                  _buildContactInfoStep(),
                  _buildParentInfoStep(),
                  _buildAcademicInfoStep(),
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: SizedBox(
                width: double.infinity,
                child: ElevatedButton(
                  onPressed: _saveStudent,
                  style: ElevatedButton.styleFrom(
                    padding: const EdgeInsets.symmetric(vertical: 16.0),
                    backgroundColor: const Color(0xFF6750A4), // Purple color to match the image
                    foregroundColor: Colors.white,
                    shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(28.0),
                    ),
                  ),
                  child: Text(
                    _localizationService.translate('common.submit'),
                    style: const TextStyle(fontSize: 16),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Step _buildBasicInfoStep() {
    return Step(
      title: Text(_localizationService.translate('student.basic_info')),
      content: Column(
        children: [
          Center(
            child: GestureDetector(
              onTap: _pickImage,
              child: CircleAvatar(
                radius: 50,
                backgroundColor: Colors.grey[300],
                backgroundImage: _image != null 
                    ? FileImage(_image!) 
                    : (widget.student?.profilePictureUrl != null && widget.student!.profilePictureUrl.isNotEmpty
                        ? NetworkImage(widget.student!.profilePictureUrl) as ImageProvider
                        : null),
                child: _image == null && (widget.student?.profilePictureUrl == null || widget.student!.profilePictureUrl.isEmpty)
                    ? const Icon(Icons.add_a_photo, size: 40, color: Colors.white)
                    : null,
              ),
            ),
          ),
          const SizedBox(height: 16),
          TextFormField(
            controller: _nameController,
            decoration: InputDecoration(
              labelText: _localizationService.translate('student.name'),
            ),
            validator: (value) => value?.isEmpty ?? true
                ? _localizationService.translate('validation.required')
                : null,
          ),
          const SizedBox(height: 16),
          TextFormField(
            controller: _rollNumberController,
            decoration: InputDecoration(
              labelText: _localizationService.translate('student.roll_number'),
            ),
            validator: (value) => value?.isEmpty ?? true
                ? _localizationService.translate('validation.required')
                : null,
          ),
          const SizedBox(height: 16),
          ListTile(
            title: Text(_localizationService.translate('student.date_of_birth')),
            subtitle: Text(DateFormat.yMMMMd().format(_selectedDate)),
            trailing: const Icon(Icons.calendar_today),
            onTap: () => _selectDate(context),
          ),
        ],
      ),
      isActive: _currentStep >= 0,
    );
  }

  Step _buildContactInfoStep() {
    return Step(
      title: Text(_localizationService.translate('student.contact_info')),
      content: Column(
        children: [
          TextFormField(
            controller: _emailController,
            decoration: InputDecoration(
              labelText: _localizationService.translate('student.email'),
            ),
            validator: (value) {
              if (value == null || value.isEmpty) {
                return _localizationService.translate('validation.required');
              }
              // Email validation using regex
              final emailRegex = RegExp(r'^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$');
              if (!emailRegex.hasMatch(value)) {
                return _localizationService.translate('validation.invalid_email') ?? 'Please enter a valid email';
              }
              return null;
            },
          ),
          const SizedBox(height: 16),
          TextFormField(
            controller: _phoneController,
            decoration: InputDecoration(
              labelText: _localizationService.translate('student.phone_number'),
            ),
            keyboardType: TextInputType.phone,
            validator: (value) {
              if (value == null || value.isEmpty) {
                return _localizationService.translate('validation.required');
              }
              // Phone number validation - exactly 10 digits
              final phoneRegex = RegExp(r'^\d{10}$');
              if (!phoneRegex.hasMatch(value)) {
                return _localizationService.translate('validation.invalid_phone') ?? 'Phone number must be 10 digits';
              }
              return null;
            },
          ),
          const SizedBox(height: 16),
          TextFormField(
            controller: _addressController,
            decoration: InputDecoration(
              labelText: _localizationService.translate('student.address'),
            ),
            validator: (value) => value?.isEmpty ?? true
                ? _localizationService.translate('validation.required')
                : null,
          ),
        ],
      ),
      isActive: _currentStep >= 0,
    );
  }

  Step _buildParentInfoStep() {
    return Step(
      title: Text(_localizationService.translate('student.parent_info')),
      content: Column(
        children: [
          TextFormField(
            controller: _parentNameController,
            decoration: InputDecoration(
              labelText: _localizationService.translate('student.parent_name'),
            ),
            validator: (value) => value?.isEmpty ?? true
                ? _localizationService.translate('validation.required')
                : null,
          ),
          const SizedBox(height: 16),
          TextFormField(
            controller: _parentContactController,
            decoration: InputDecoration(
              labelText: _localizationService.translate('student.parent_contact'),
            ),
            validator: (value) => value?.isEmpty ?? true
                ? _localizationService.translate('validation.required')
                : null,
          ),
        ],
      ),
      isActive: _currentStep >= 0,
    );
  }

  Step _buildAcademicInfoStep() {
    return Step(
      title: Text(_localizationService.translate('student.academic_info')),
      content: Column(
        children: [
          // Add subject marks
          _buildSubjectMarksSection(),
          const SizedBox(height: 16),
          // Add hobbies
          _buildHobbiesSection(),
          const SizedBox(height: 16),
          // Add certifications
          _buildCertificationsSection(),
        ],
      ),
      isActive: _currentStep >= 0,
    );
  }

  Widget _buildSubjectMarksSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(_localizationService.translate('student.marks')),
        ..._subjectMarks.entries.map((entry) => ListTile(
              title: Text(entry.key),
              trailing: Text(entry.value.toString()),
              onTap: () => _editMark(entry.key),
            )),
        TextButton(
          onPressed: _addNewSubject,
          child: Text(_localizationService.translate('student.add_subject')),
        ),
      ],
    );
  }

  Future<void> _addNewSubject() async {
    final result = await showDialog<Map<String, dynamic>>(
      context: context,
      builder: (context) => AddSubjectDialog(
        localizationService: _localizationService,
      ),
    );
    if (result != null) {
      setState(() {
        _subjectMarks[result['name']] = result['mark'];
      });
    }
  }
  
  Future<void> _editMark(String subject) async {
      final result = await showDialog<double>(
        context: context,
        builder: (context) => EditMarkDialog(
          subject: subject,
          mark: _subjectMarks[subject] ?? 0,
          localizationService: _localizationService,
        ),
      );
      if (result != null) {
        setState(() {
          _subjectMarks[subject] = result;
        });
      }
    }
  Widget _buildHobbiesSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(_localizationService.translate('student.hobbies')),
        Wrap(
          spacing: 8,
          children: [
            ..._hobbies.map((hobby) => Chip(
                  label: Text(hobby),
                  onDeleted: () => setState(() => _hobbies.remove(hobby)),
                )),
            ActionChip(
              label: const Icon(Icons.add),
              onPressed: _addHobby,
            ),
          ],
        ),
      ],
    );
  }

  Widget _buildCertificationsSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(_localizationService.translate('student.certifications')),
        Wrap(
          spacing: 8,
          children: [
            ..._certifications.map((cert) => Chip(
                  label: Text(cert),
                  onDeleted: () => setState(() => _certifications.remove(cert)),
                )),
            ActionChip(
              label: const Icon(Icons.add),
              onPressed: _addCertification,
            ),
          ],
        ),
      ],
    );
  }

  Future<void> _addHobby() async {
    final hobby = await _showInputDialog('student.add_hobby');
    if (hobby != null && hobby.isNotEmpty) {
      setState(() => _hobbies.add(hobby));
    }
  }

  Future<void> _addCertification() async {
    final cert = await _showInputDialog('student.add_certification');
    if (cert != null && cert.isNotEmpty) {
      setState(() => _certifications.add(cert));
    }
  }

  Future<String?> _showInputDialog(String titleKey) async {
    final controller = TextEditingController();
    return showDialog<String>(
      context: context,
      builder: (context) => AlertDialog(
        title: Text(_localizationService.translate(titleKey)),
        content: TextField(controller: controller),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context),
            child: Text(_localizationService.translate('common.cancel')),
          ),
          TextButton(
            onPressed: () => Navigator.pop(context, controller.text),
            child: Text(_localizationService.translate('common.add')),
          ),
        ],
      ),
    );
  }

  // In the _saveStudent method
  Future<void> _saveStudent() async {
    if (_formKey.currentState?.validate() ?? false) {
      final student = Student(
        id: widget.student?.id ?? '',
        name: _nameController.text,
        rollNumber: _rollNumberController.text,
        dateOfBirth: _selectedDate,
        profilePictureUrl: widget.student?.profilePictureUrl ?? '',
        localProfileImagePath: _image?.path, // Use the local image path
        email: _emailController.text,
        phoneNumber: _phoneController.text,
        address: _addressController.text,
        parentName: _parentNameController.text,
        parentContact: _parentContactController.text,
        hobbies: _hobbies,
        certifications: _certifications,
        subjectMarks: _subjectMarks,
      );
  
      try {
        if (widget.student == null) {
          await _studentService.addStudent(student);
        } else {
          await _studentService.updateStudent(student);
        }
        if (mounted) Navigator.pop(context);
      } catch (e) {
        ScaffoldMessenger.of(context).showSnackBar(
          SnackBar(content: Text('Error: $e')),
        );
      }
    }
  }
  
  Future<void> _selectDate(BuildContext context) async {
    final DateTime? picked = await showDatePicker(
      context: context,
      initialDate: _selectedDate,
      firstDate: DateTime(1900),
      lastDate: DateTime.now(),
    );
    if (picked != null && picked != _selectedDate) {
      setState(() {
        _selectedDate = picked;
      });
    }
  }

  @override
  void dispose() {
    _nameController.dispose();
    _rollNumberController.dispose();
    _profilePictureUrlController.dispose();
    _emailController.dispose();
    _phoneController.dispose();
    _addressController.dispose();
    _parentNameController.dispose();
    _parentContactController.dispose();
    super.dispose();
  }
}
