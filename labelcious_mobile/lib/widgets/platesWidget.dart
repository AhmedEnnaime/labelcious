import 'package:flutter/material.dart';

class PlatesWidget extends StatefulWidget {
  const PlatesWidget({super.key});

  @override
  State<PlatesWidget> createState() => _PlatesWidgetState();
}

class _PlatesWidgetState extends State<PlatesWidget> {
  @override
  Widget build(BuildContext context) {
    return GridView.count(
      crossAxisCount: 2,
      physics: NeverScrollableScrollPhysics(),
      childAspectRatio: 0.68,
      shrinkWrap: true,
      children: [
        for (int i = 0; i < 10; i++)
          Container(
            padding: EdgeInsets.only(left: 15, right: 15, top: 10),
            margin: EdgeInsets.symmetric(vertical: 8, horizontal: 10),
            decoration: BoxDecoration(
                color: Colors.white, borderRadius: BorderRadius.circular(20)),
            child: Column(children: [
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                children: [
                  Container(
                    padding: EdgeInsets.all(5),
                    decoration: BoxDecoration(
                        color: Color(0xFF4C53A5),
                        borderRadius: BorderRadius.circular(20)),
                    child: Text(
                      "-50%",
                      style: TextStyle(
                          fontSize: 14,
                          color: Colors.white,
                          fontWeight: FontWeight.bold),
                    ),
                  ),
                  Icon(
                    Icons.favorite_border,
                    color: Colors.red,
                  )
                ],
              ),
              InkWell(
                onTap: () {},
                child: Container(
                  margin: EdgeInsets.all(10),
                  child: Image.asset(
                    "assets/pastry.png",
                    height: 120,
                    width: 120,
                  ),
                ),
              ),
              Container(
                padding: EdgeInsets.only(bottom: 8),
                alignment: Alignment.centerLeft,
                child: Text(
                  "Plate title",
                  style: TextStyle(
                      fontSize: 18,
                      color: Color(0xFF4C53A5),
                      fontWeight: FontWeight.bold),
                ),
              ),
              Container(
                alignment: Alignment.centerLeft,
                child: Text(
                  "Tap to see details",
                  style: TextStyle(fontSize: 15, color: Color(0xFF4C53A5)),
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 2),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      "\$55",
                      style: TextStyle(
                          fontSize: 16,
                          fontWeight: FontWeight.bold,
                          color: Color(0xFF4C53A5)),
                    ),
                    Icon(
                      Icons.shopping_cart_checkout,
                      color: Color(0xFF4C53A5),
                    )
                  ],
                ),
              )
            ]),
          )
      ],
    );
  }
}
