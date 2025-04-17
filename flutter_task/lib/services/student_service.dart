import 'package:cloud_firestore/cloud_firestore.dart';
import '../models/student.dart';

class StudentService {
  final CollectionReference _studentsCollection =
      FirebaseFirestore.instance.collection('students');

  Stream<List<Student>> getStudents() {
    return _studentsCollection.snapshots().map((snapshot) {
      return snapshot.docs.map((doc) {
        return Student.fromMap(doc.data() as Map<String, dynamic>, doc.id);
      }).toList();
    });
  }

  Future<void> addStudent(Student student) async {
    await _studentsCollection.add(student.toMap());
  }

  Future<void> updateStudent(Student student) async {
    await _studentsCollection.doc(student.id).update(student.toMap());
  }

  Future<void> deleteStudent(String studentId) async {
    await _studentsCollection.doc(studentId).delete();
  }

  Stream<List<Student>> searchStudents(String query) {
    return _studentsCollection
        .orderBy('name')
        .startAt([query])
        .endAt(['$query\uf8ff'])
        .snapshots()
        .map((snapshot) {
      return snapshot.docs.map((doc) {
        return Student.fromMap(doc.data() as Map<String, dynamic>, doc.id);
      }).toList();
    });
  }

  // Add this method to your StudentService class
  // Fix the getStudentsWithBirthdayToday method
  Stream<List<Student>> getStudentsWithBirthdayToday() {
    return _studentsCollection.snapshots().map((snapshot) {
      return snapshot.docs
          .map((doc) => Student.fromMap(doc.data() as Map<String, dynamic>, doc.id))
          .where((student) => student.hasBirthdayToday())
          .toList();
    });
  }
}