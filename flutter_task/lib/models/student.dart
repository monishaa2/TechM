import 'package:cloud_firestore/cloud_firestore.dart';

// Update the Student class to handle local image paths
class Student {
  final String id;
  final String name;
  final String rollNumber;
  final DateTime dateOfBirth;
  final String profilePictureUrl;
  final String? localProfileImagePath; // Add this field
  final String email;
  final String phoneNumber;
  final String address;
  final String parentName;
  final String parentContact;
  final List<String> hobbies;
  final List<String> certifications;
  final Map<String, double> subjectMarks;

  Student({
    required this.id,
    required this.name,
    required this.rollNumber,
    required this.dateOfBirth,
    this.profilePictureUrl = '',
    this.localProfileImagePath, // Add this parameter
    required this.email,
    required this.phoneNumber,
    required this.address,
    required this.parentName,
    required this.parentContact,
    required this.hobbies,
    required this.certifications,
    required this.subjectMarks,
  });
  
  // Update the fromMap method
  factory Student.fromMap(Map<String, dynamic> map, String id) {
    // Handle Timestamp conversion properly
    DateTime dob;
    if (map['dateOfBirth'] is Timestamp) {
      dob = (map['dateOfBirth'] as Timestamp).toDate();
    } else if (map['dateOfBirth'] is String) {
      dob = DateTime.parse(map['dateOfBirth'] as String);
    } else {
      dob = DateTime.now(); // Fallback
    }

    return Student(
      id: id,
      name: map['name'] ?? '',
      rollNumber: map['rollNumber'] ?? '',
      dateOfBirth: dob,
      profilePictureUrl: map['profilePictureUrl'] ?? '',
      localProfileImagePath: map['localProfileImagePath'],
      email: map['email'] ?? '',
      phoneNumber: map['phoneNumber'] ?? '',
      address: map['address'] ?? '',
      parentName: map['parentName'] ?? '',
      parentContact: map['parentContact'] ?? '',
      hobbies: List<String>.from(map['hobbies'] ?? []),
      certifications: List<String>.from(map['certifications'] ?? []),
      subjectMarks: Map<String, double>.from(map['subjectMarks']?.map(
            (key, value) => MapEntry(key, value.toDouble()),
          ) ??
          {}),
    );
  }
  
  // Update the toMap method
  Map<String, dynamic> toMap() {
    return {
      'name': name,
      'rollNumber': rollNumber,
      'dateOfBirth': Timestamp.fromDate(dateOfBirth),
      'profilePictureUrl': profilePictureUrl,
      'localProfileImagePath': localProfileImagePath,
      'email': email,
      'phoneNumber': phoneNumber,
      'address': address,
      'parentName': parentName,
      'parentContact': parentContact,
      'hobbies': hobbies,
      'certifications': certifications,
      'subjectMarks': subjectMarks,
    };
  }

  bool hasBirthdayToday() {
    final today = DateTime.now();
    return today.month == dateOfBirth.month && today.day == dateOfBirth.day;
  }
}