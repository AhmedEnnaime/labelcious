import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/FeedbackController.dart';
import 'package:mobilelabelcious/models/Feedback.dart' as MyFeedback;

class FeedbacksWidget extends StatefulWidget {
  const FeedbacksWidget({Key? key});

  @override
  State<FeedbacksWidget> createState() => _FeedbacksWidgetState();
}

class _FeedbacksWidgetState extends State<FeedbacksWidget> {
  final FeedbackController feedbackController = Get.find<FeedbackController>();
  final TextEditingController messageController = TextEditingController();

  @override
  void dispose() {
    messageController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        color: Colors.white,
        borderRadius: BorderRadius.circular(20),
      ),
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
                  color: Color(0xFF4C53A5),
                ),
              ),
            ),
          ),
          Obx(() {
            List<MyFeedback.Feedback> feedbacks = feedbackController.feedbacks;
            if (feedbacks.isNotEmpty) {
              return ListView.builder(
                shrinkWrap: true,
                itemCount: feedbacks.length,
                itemBuilder: (context, index) {
                  MyFeedback.Feedback feedback = feedbacks[index];
                  return ListTile(
                    leading: Icon(
                      Icons.person_2,
                      size: 30,
                    ),
                    title: Text(
                      '${feedback.user?.firstName ?? "Anonymous"} ${feedback.user?.lastName ?? ""}',
                      style: TextStyle(
                        fontSize: 18,
                        color: Color(0xFF4C53A5),
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    subtitle: Text(
                      feedback.message ?? "",
                      textAlign: TextAlign.justify,
                      style: TextStyle(
                        fontSize: 14,
                      ),
                    ),
                  );
                },
              );
            } else {
              return Column(
                children: [
                  Image.asset(
                    'assets/not_found.png',
                    width: 200,
                    height: 200,
                  ),
                  Text(
                    "No feedback available.",
                    style: TextStyle(fontSize: 16),
                  ),
                ],
              );
            }
          }),
          ListTile(
            leading: Icon(
              Icons.person_2_outlined,
              size: 30,
            ),
            title: TextField(
              controller: messageController,
              decoration: InputDecoration(
                hintText: "Give your feedback",
                border: OutlineInputBorder(
                  borderRadius: BorderRadius.circular(20),
                ),
              ),
            ),
            trailing: IconButton(
              icon: Icon(
                Icons.send_outlined,
                size: 30,
              ),
              onPressed: () {
                MyFeedback.Feedback feedback = MyFeedback.Feedback(
                  message: messageController.text,
                );
                feedbackController.addFeedback(feedback);
                messageController.clear();
              },
            ),
          ),
        ],
      ),
    );
  }
}
