import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';
import '../models/student.dart';
import '../services/localization_service.dart';
import 'package:intl/intl.dart';

class StudentDetailScreen extends StatelessWidget {
  final Student student;
  final _localizationService = LocalizationService();

  StudentDetailScreen({super.key, required this.student});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(_localizationService.translate('student.details')),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Center(
              child: CircleAvatar(
                radius: 60,
                backgroundImage: CachedNetworkImageProvider(
                  student.profilePictureUrl,
                ),
              ),
            ),
            const SizedBox(height: 16),
            _buildInfoSection('student.basic_info', [
              _buildInfoRow('student.name', student.name),
              _buildInfoRow('student.roll_number', student.rollNumber),
              _buildInfoRow('student.date_of_birth', 
                  DateFormat.yMMMMd().format(student.dateOfBirth)),
            ]),
            _buildInfoSection('student.contact_info', [
              _buildInfoRow('student.email', student.email),
              _buildInfoRow('student.phone_number', student.phoneNumber),
              _buildInfoRow('student.address', student.address),
            ]),
            _buildInfoSection('student.parent_info', [
              _buildInfoRow('student.parent_name', student.parentName),
              _buildInfoRow('student.parent_contact', student.parentContact),
            ]),
            _buildSubjectMarksSection(),
            _buildHobbiesSection(),
            _buildCertificationsSection(),
          ],
        ),
      ),
    );
  }

  Widget _buildInfoSection(String titleKey, List<Widget> children) {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          _localizationService.translate(titleKey),
          style: const TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
          ),
        ),
        const Divider(),
        ...children,
        const SizedBox(height: 16),
      ],
    );
  }

  Widget _buildInfoRow(String labelKey, String value) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8.0),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Expanded(
            flex: 2,
            child: Text(
              _localizationService.translate(labelKey),
              style: const TextStyle(fontWeight: FontWeight.w500),
            ),
          ),
          Expanded(
            flex: 3,
            child: Text(value),
          ),
        ],
      ),
    );
  }

  Widget _buildSubjectMarksSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          _localizationService.translate('student.marks'),
          style: const TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
          ),
        ),
        const Divider(),
        ...student.subjectMarks.entries.map((entry) => Padding(
              padding: const EdgeInsets.symmetric(vertical: 8.0),
              child: Row(
                children: [
                  Expanded(
                    flex: 2,
                    child: Text(entry.key),
                  ),
                  Expanded(
                    flex: 3,
                    child: Text(entry.value.toString()),
                  ),
                ],
              ),
            )),
        const SizedBox(height: 16),
      ],
    );
  }

  Widget _buildHobbiesSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          _localizationService.translate('student.hobbies'),
          style: const TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
          ),
        ),
        const Divider(),
        Wrap(
          spacing: 8,
          children: student.hobbies
              .map((hobby) => Chip(label: Text(hobby)))
              .toList(),
        ),
        const SizedBox(height: 16),
      ],
    );
  }

  Widget _buildCertificationsSection() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          _localizationService.translate('student.certifications'),
          style: const TextStyle(
            fontSize: 18,
            fontWeight: FontWeight.bold,
          ),
        ),
        const Divider(),
        Wrap(
          spacing: 8,
          children: student.certifications
              .map((cert) => Chip(label: Text(cert)))
              .toList(),
        ),
        const SizedBox(height: 16),
      ],
    );
  }
}