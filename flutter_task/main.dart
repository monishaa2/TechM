import 'package:flutter/material.dart';
import 'pages/home_page.dart';

void main() {
  runApp(ClassMateApp());
}

class ClassMateApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'ClassMate',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomePage(),
    );
  }
}
