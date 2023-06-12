import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:mobilelabelcious/controllers/PlateController.dart';
import 'package:mobilelabelcious/models/Plate.dart' as Model;
import 'package:mobilelabelcious/models/Feedback.dart' as FeedbackModel;

class FeedbacksWidget extends StatefulWidget {
  const FeedbacksWidget({Key? key});

  @override
  State<FeedbacksWidget> createState() => _FeedbacksWidgetState();
}

class _FeedbacksWidgetState extends State<FeedbacksWidget> {
  @override
  Widget build(BuildContext context) {
    PlateController plateController = Get.find<PlateController>();

    // Access the selected plate
    Model.Plate selectedPlate = plateController.selectedPlate.value;

    List<FeedbackModel.Feedback>? feedbacks = selectedPlate.feedbacks;

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
          if (feedbacks != null && feedbacks.isNotEmpty)
            for (int i = 0; i < feedbacks.length; i++)
              ListTile(
                leading: Icon(
                  Icons.person_2,
                  size: 30,
                ),
                title: Text(
                  '${feedbacks[i].user?.firstName ?? "Anonymous"} ${feedbacks[i].user?.lastName ?? ""}',
                  style: TextStyle(
                      fontSize: 18,
                      color: Color(0xFF4C53A5),
                      fontWeight: FontWeight.bold),
                ),
                subtitle: Text(
                  feedbacks[i].message ?? "",
                  textAlign: TextAlign.justify,
                  style: TextStyle(
                    fontSize: 14,
                  ),
                ),
              ),
          if (feedbacks == null || feedbacks.isEmpty)
            Column(
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
