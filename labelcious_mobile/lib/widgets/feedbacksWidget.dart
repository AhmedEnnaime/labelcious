import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class feedbacksWidget extends StatefulWidget {
  const feedbacksWidget({super.key});

  @override
  State<feedbacksWidget> createState() => _feedbacksWidgetState();
}

class _feedbacksWidgetState extends State<feedbacksWidget> {
  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
          color: Colors.white, borderRadius: BorderRadius.circular(20)),
      padding: EdgeInsets.all(8),
      child: Column(
        children: [
          Align(
            alignment: AlignmentDirectional.centerStart,
            child: Padding(
              padding: const EdgeInsets.symmetric(vertical: 20, horizontal: 20),
              child: Text(
                "Feedbacks",
                textAlign: TextAlign.left,
                style: TextStyle(
                    fontSize: 26,
                    fontWeight: FontWeight.bold,
                    color: Color(0xFF4C53A5)),
              ),
            ),
          ),
          for (int i = 0; i < 7; i++)
            ListTile(
              leading: Icon(
                Icons.person_2,
                size: 30,
              ),
              title: Text(
                "Abdelilah El asri",
                style: TextStyle(
                    fontSize: 18,
                    color: Color(0xFF4C53A5),
                    fontWeight: FontWeight.bold),
              ),
              subtitle: Text(
                "This chicken plate is so good i hope it's prepared every day",
                textAlign: TextAlign.justify,
                style: TextStyle(
                  fontSize: 14,
                ),
              ),
            ),
          ListTile(
            leading: Icon(
              Icons.person_2_outlined,
              size: 30,
            ),
            title: TextField(
              decoration: InputDecoration(
                  hintText: "Give your feedback",
                  border: OutlineInputBorder(
                      borderRadius: BorderRadius.circular(20))),
            ),
            trailing: Icon(
              Icons.send_outlined,
              size: 30,
            ),
          )
        ],
      ),
    );
  }
}
