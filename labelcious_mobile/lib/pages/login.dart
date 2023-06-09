import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:mobilelabelcious/pages/home.dart';

class Login extends StatefulWidget {
  const Login({Key? key}) : super(key: key);

  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  Future<void> signInWithGoogle() async {
    FirebaseAuth auth = FirebaseAuth.instance;
    final GoogleSignIn googleSignIn = GoogleSignIn();
    final GoogleSignInAccount? googleUser = await googleSignIn.signIn();
    final GoogleSignInAuthentication googleAuth =
        await googleUser!.authentication;
    final AuthCredential credential = GoogleAuthProvider.credential(
      accessToken: googleAuth.accessToken,
      idToken: googleAuth.idToken,
    );

    final String email = googleUser.email;
    final bool hasLabelvieEmail = email.contains('@gmail');

    if (hasLabelvieEmail) {
      final UserCredential userCredential =
          await auth.signInWithCredential(credential);
      print(googleUser);
      print(credential);
      Navigator.push(context, MaterialPageRoute(builder: (_) => const Home()));
    } else {
      // Show an error message
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(
          content: Text('The email address must contain @labelvie.'),
        ),
      );

      // Sign out the user
      await googleSignIn.signOut();
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
            image: AssetImage("assets/auth_img.jpg"),
            fit: BoxFit.cover,
          ),
        ),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.end,
          children: [
            Padding(
              padding:
                  const EdgeInsets.only(bottom: 120.0, right: 20, left: 20),
              child: GestureDetector(
                onTap: () async {
                  try {
                    await signInWithGoogle();
                  } catch (e) {
                    print('Error signing in with Google: $e');
                    // Handle the error
                  }
                },
                child: Container(
                  height: 65,
                  decoration: BoxDecoration(
                      border: Border.all(color: Colors.black),
                      borderRadius: BorderRadius.circular(20),
                      color: Colors.grey),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    children: [
                      Image.asset("assets/google.png"),
                      Text(
                        "Signin with Google",
                        style: TextStyle(color: Colors.black, fontSize: 17),
                      )
                    ],
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
