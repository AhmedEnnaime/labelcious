import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:line_awesome_flutter/line_awesome_flutter.dart';

class Profile extends StatefulWidget {
  const Profile({super.key});

  @override
  State<Profile> createState() => _ProfileState();
}

class _ProfileState extends State<Profile> {
  Future<void> logout() async {
    final GoogleSignIn googleSignIn = GoogleSignIn();
    await googleSignIn.signOut();
  }

  TextEditingController firstNameController = TextEditingController();
  TextEditingController lastNameController = TextEditingController();
  TextEditingController emailController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: IconButton(
          icon: Icon(
            LineAwesomeIcons.angle_left,
            size: 30,
          ),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
        title: Text(
          "Profile",
          style: TextStyle(
              fontSize: 22,
              fontWeight: FontWeight.bold,
              color: Color(0xFF4C53A5)),
        ),
      ),
      body: SingleChildScrollView(
        child: Container(
          padding: EdgeInsets.all(20),
          child: Column(
            children: [
              Stack(
                children: [
                  SizedBox(
                    width: 120,
                    height: 120,
                    child: ClipRRect(
                      borderRadius: BorderRadius.circular(100),
                      child: Image.asset("assets/avatar.jpg"),
                    ),
                  ),
                  Positioned(
                      bottom: 0,
                      right: 0,
                      child: Container(
                        width: 35,
                        height: 35,
                        decoration: BoxDecoration(
                            borderRadius: BorderRadius.circular(100),
                            color: Color(0xFF4C53A5)),
                        child: Icon(
                          LineAwesomeIcons.camera,
                          color: Colors.white,
                          size: 20,
                        ),
                      ))
                ],
              ),
              SizedBox(
                height: 50,
              ),
              Form(
                  child: Column(
                children: [
                  TextFormField(
                    controller: firstNameController,
                    decoration: InputDecoration(
                        label: Text("First name"),
                        prefixIcon: Icon(
                          LineAwesomeIcons.user,
                          size: 30,
                        ),
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(100)),
                        focusedBorder: OutlineInputBorder(
                            borderSide:
                                BorderSide(width: 2, color: Colors.black))),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    controller: lastNameController,
                    decoration: InputDecoration(
                        label: Text("Last name"),
                        prefixIcon: Icon(
                          LineAwesomeIcons.user_1,
                          size: 30,
                        ),
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(100)),
                        focusedBorder: OutlineInputBorder(
                            borderSide:
                                BorderSide(width: 2, color: Colors.black))),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    controller: emailController,
                    decoration: InputDecoration(
                        label: Text("Email"),
                        prefixIcon: Icon(
                          LineAwesomeIcons.envelope_1,
                          size: 30,
                        ),
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(100)),
                        focusedBorder: OutlineInputBorder(
                            borderSide:
                                BorderSide(width: 2, color: Colors.black))),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    decoration: InputDecoration(
                        label: Text("Password"),
                        prefixIcon: Icon(
                          LineAwesomeIcons.fingerprint,
                          size: 30,
                        ),
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(100)),
                        focusedBorder: OutlineInputBorder(
                            borderSide:
                                BorderSide(width: 2, color: Colors.black))),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    decoration: InputDecoration(
                        label: Text("Badge number"),
                        prefixIcon: Icon(
                          LineAwesomeIcons.identification_badge,
                          size: 30,
                        ),
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(100)),
                        focusedBorder: OutlineInputBorder(
                            borderSide:
                                BorderSide(width: 2, color: Colors.black))),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  TextFormField(
                    decoration: InputDecoration(
                        label: Text("Job"),
                        prefixIcon: Icon(
                          LineAwesomeIcons.briefcase,
                          size: 30,
                        ),
                        border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(100)),
                        focusedBorder: OutlineInputBorder(
                            borderSide:
                                BorderSide(width: 2, color: Colors.black))),
                  ),
                  SizedBox(
                    height: 40,
                  ),
                  SizedBox(
                    width: double.infinity,
                    height: 60,
                    child: ElevatedButton(
                      onPressed: () {},
                      child: Text(
                        "Edit Profile",
                        style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                            color: Colors.white),
                      ),
                      style: ElevatedButton.styleFrom(
                          backgroundColor: Color(0xFF4C53A5),
                          side: BorderSide.none,
                          shape: StadiumBorder()),
                    ),
                  ),
                  SizedBox(
                    height: 20,
                  ),
                  Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    children: [
                      Text.rich(TextSpan(
                        text: "Logout here",
                        style: TextStyle(
                            fontSize: 16,
                            fontWeight: FontWeight.bold,
                            color: Color(0xFF4C53A5)),
                      )),
                      ElevatedButton(
                        onPressed: () async {
                          try {
                            logout();
                            if (mounted) {
                              Navigator.pushNamed(context, "/");
                            }
                          } catch (e) {
                            print(e);
                          }
                        },
                        child: Icon(
                          Icons.logout,
                          size: 30,
                        ),
                        style: ElevatedButton.styleFrom(
                            backgroundColor: Colors.redAccent.withOpacity(0.1),
                            elevation: 0,
                            foregroundColor: Colors.red,
                            shape: StadiumBorder(),
                            side: BorderSide.none),
                      )
                    ],
                  )
                ],
              ))
            ],
          ),
        ),
      ),
    );
  }
}
