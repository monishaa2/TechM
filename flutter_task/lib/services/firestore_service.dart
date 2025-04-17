import 'package:cloud_firestore/cloud_firestore.dart';
import '../models/student.dart';

class FirestoreService {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  Future<void> addStudent(Student student) async {
    try {
      await _firestore.collection('students').doc(student.id).set(student.toMap());
    } catch (e) {
      print('Error adding student: $e');
      rethrow;
    }
  }

  Future<void> updateStudent(Student student) async {
    try {
      await _firestore.collection('students').doc(student.id).update(student.toMap());
    } catch (e) {
      print('Error updating student: $e');
      rethrow;
    }
  }
}