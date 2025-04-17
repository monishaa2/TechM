import 'package:flutter/material.dart';
import '../services/localization_service.dart';

class EditMarkDialog extends StatefulWidget {
  final String subject;
  final double mark;
  final LocalizationService localizationService;

  const EditMarkDialog({
    super.key,
    required this.subject,
    required this.mark,
    required this.localizationService,
  });

  @override
  State<EditMarkDialog> createState() => _EditMarkDialogState();
}

class _EditMarkDialogState extends State<EditMarkDialog> {
  late TextEditingController _markController;

  @override
  void initState() {
    super.initState();
    _markController = TextEditingController(text: widget.mark.toString());
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text(widget.localizationService.translate('student.edit_mark')),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text('${widget.localizationService.translate('student.subject')}: ${widget.subject}'),
          const SizedBox(height: 16),
          TextField(
            controller: _markController,
            decoration: InputDecoration(
              labelText: widget.localizationService.translate('student.mark'),
            ),
            keyboardType: TextInputType.number,
          ),
        ],
      ),
      actions: [
        TextButton(
          onPressed: () => Navigator.pop(context),
          child: Text(widget.localizationService.translate('common.cancel')),
        ),
        TextButton(
          onPressed: () {
            final mark = double.tryParse(_markController.text);
            if (mark != null) {
              Navigator.pop(context, mark);
            }
          },
          child: Text(widget.localizationService.translate('common.save')),
        ),
      ],
    );
  }

  @override
  void dispose() {
    _markController.dispose();
    super.dispose();
  }
}