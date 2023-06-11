import 'package:firebase_core/firebase_core.dart';
import 'package:flutter/material.dart';
import 'package:mobilelabelcious/firebase_options.dart';
import 'package:mobilelabelcious/pages/cart.dart';
import 'package:mobilelabelcious/pages/home.dart';
import 'package:mobilelabelcious/pages/login.dart';
import 'package:mobilelabelcious/pages/plate.dart';
import 'package:mobilelabelcious/pages/profile.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await Firebase.initializeApp(options: DefaultFirebaseOptions.currentPlatform);
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        scaffoldBackgroundColor: Colors.white,
        useMaterial3: true,
      ),
      initialRoute: '/',
      routes: {
        '/': (context) => Login(),
        '/home': (context) => Home(),
        'cart': (context) => Cart(),
        'plate': (context) => Plate(),
        'profile': (context) => Profile(),
      },
    );
  }
}
