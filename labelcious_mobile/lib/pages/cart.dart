import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:mobilelabelcious/widgets/cartAppBar.dart';
import 'package:mobilelabelcious/widgets/cartBottomNavBar.dart';
import 'package:mobilelabelcious/widgets/cartItem.dart';

class Cart extends StatefulWidget {
  const Cart({super.key});

  @override
  State<Cart> createState() => _CartState();
}

class _CartState extends State<Cart> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: ListView(
        children: [
          CartAppBar(),
          Container(
            // Temporary height
            height: 700,
            padding: EdgeInsets.only(top: 15),
            decoration: BoxDecoration(
              color: Color(0xFFEDECF2),
              borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(35), topRight: Radius.circular(35)),
            ),
            child: Column(children: [
              CartItem(),
            ]),
          )
        ],
      ),
      bottomNavigationBar: CartBottomNavBar(),
    );
  }
}
