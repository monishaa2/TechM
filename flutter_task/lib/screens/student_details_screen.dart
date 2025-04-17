import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import '../models/student.dart';
import '../services/localization_service.dart';

class StudentDetailsScreen extends StatelessWidget {
  final Student student;
  final _localizationService = LocalizationService();

  StudentDetailsScreen({Key? key, required this.student}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(_localizationService.translate('student.details')),
      ),
      body: SingleChildScrollView(
        padding: EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            // Profile Picture Section
            Center(
              child: CircleAvatar(
                radius: 60,
                backgroundImage:
                    student.profilePictureUrl.isNotEmpty
                        ? NetworkImage(student.profilePictureUrl)
                        : null,
                child:
                    student.profilePictureUrl.isEmpty
                        ? Text(
                          student.name.isNotEmpty
                              ? student.name[0].toUpperCase()
                              : '?',
                          style: TextStyle(fontSize: 40),
                        )
                        : null,
              ),
            ),
            SizedBox(height: 20),

            _buildBasicInfoSection(context),
            _buildInfoSection('Personal Information', [
              _buildInfoRow('Name', student.name),
              _buildInfoRow('Roll Number', student.rollNumber),
              _buildInfoRow(
                'Date of Birth',
                DateFormat('dd/MM/yyyy').format(student.dateOfBirth),
              ),
              // Remove or replace bloodGroup as it doesn't exist in your Student model
              // _buildInfoRow('Blood Group', student.bloodGroup),
            ]),

            SizedBox(height: 20),
            _buildInfoSection('Contact Information', [
              _buildInfoRow('Email', student.email),
              _buildInfoRow('Contact Number', student.phoneNumber),
              // Replace emergencyContactNumber with parentContact
              _buildInfoRow('Parent Contact', student.parentContact),
              _buildInfoRow('Address', student.address),
            ]),

            SizedBox(height: 20),
            _buildInfoSection('Family Information', [
              // Replace fatherName and motherName with parentName
              _buildInfoRow('Parent Name', student.parentName),
            ]),

            SizedBox(height: 20),
            _buildInfoSection('Academic Information', [
              _buildSubjectMarks(student.subjectMarks),
              _buildCertifications(student.certifications),
            ]),

            SizedBox(height: 20),
            _buildInfoSection('Hobbies & Interests', [
              _buildHobbiesList(student.hobbies),
            ]),
          ],
        ),
      ),
    );
  }

  Widget _buildInfoSection(String title, List<Widget> children) {
    return Card(
      child: Padding(
        padding: EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              title,
              style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
            ),
            SizedBox(height: 12),
            ...children,
          ],
        ),
      ),
    );
  }

  Widget _buildInfoRow(String label, String value) {
    return Padding(
      padding: EdgeInsets.symmetric(vertical: 4),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          SizedBox(
            width: 120,
            child: Text(label, style: TextStyle(fontWeight: FontWeight.w500)),
          ),
          Expanded(child: Text(value.isEmpty ? 'Not provided' : value)),
        ],
      ),
    );
  }

  Widget _buildSubjectMarks(Map<String, double> marks) {
    if (marks.isEmpty) return Text('No marks recorded');
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children:
          marks.entries.map((entry) {
            return _buildInfoRow(entry.key, entry.value.toString());
          }).toList(),
    );
  }

  Widget _buildCertifications(List<String> certifications) {
    if (certifications.isEmpty) return Text('No certifications added');
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children:
          certifications
              .map(
                (cert) => Padding(
                  padding: EdgeInsets.symmetric(vertical: 2),
                  child: Text('• $cert'),
                ),
              )
              .toList(),
    );
  }

  Widget _buildHobbiesList(List<String> hobbies) {
    if (hobbies.isEmpty) return Text('No hobbies listed');
    return Wrap(
      spacing: 8,
      runSpacing: 8,
      children: hobbies.map((hobby) => Chip(label: Text(hobby))).toList(),
    );
  }

  Widget _buildBasicInfoSection(BuildContext context) {
    return Card(
      margin: const EdgeInsets.all(8.0),
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              _localizationService.translate('student.basic_info'),
              style: Theme.of(context).textTheme.titleLarge,
            ),
            const SizedBox(height: 16),
            // Profile picture is already shown at the top, so we don't need it here
            _buildInfoRow(
              _localizationService.translate('student.name'),
              student.name,
            ),
            _buildInfoRow(
              _localizationService.translate('student.roll_number'),
              student.rollNumber,
            ),
            _buildInfoRow(
              _localizationService.translate('student.date_of_birth'),
              DateFormat.yMMMMd().format(student.dateOfBirth),
            ),
          ],
        ),
      ),
    );
  }
}
