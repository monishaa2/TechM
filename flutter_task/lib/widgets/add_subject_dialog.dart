import 'package:flutter/material.dart';
import '../services/localization_service.dart';
import 'package:image_picker/image_picker.dart';
import 'dart:io';


// Remove the image section from the dialog
// Keep the subject name and mark fields
// Remove any image-related functionality

// Example modification (adjust based on your actual file):
class AddSubjectDialog extends StatefulWidget {
  final LocalizationService localizationService;

  const AddSubjectDialog({Key? key, required this.localizationService}) : super(key: key);

  @override
  State<AddSubjectDialog> createState() => _AddSubjectDialogState();
}

class _AddSubjectDialogState extends State<AddSubjectDialog> {
  final _nameController = TextEditingController();
  final _markController = TextEditingController();
  
  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text(widget.localizationService.translate('student.add_subject')),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          TextField(
            controller: _nameController,
            decoration: InputDecoration(
              labelText: widget.localizationService.translate('student.subject_name'),
            ),
          ),
          TextField(
            controller: _markController,
            decoration: InputDecoration(
              labelText: widget.localizationService.translate('student.mark'),
            ),
            keyboardType: TextInputType.number,
          ),
          // Image section removed
        ],
      ),
      actions: [
        TextButton(
          onPressed: () => Navigator.pop(context),
          child: Text(widget.localizationService.translate('common.cancel')),
        ),
        TextButton(
          onPressed: () {
            final name = _nameController.text;
            final mark = double.tryParse(_markController.text) ?? 0.0;
            if (name.isNotEmpty) {
              Navigator.pop(context, {'name': name, 'mark': mark});
            }
          },
          child: Text(widget.localizationService.translate('common.add')),
        ),
      ],
    );
  }
  
  @override
  void dispose() {
    _nameController.dispose();
    _markController.dispose();
    super.dispose();
  }
}