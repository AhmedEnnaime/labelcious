import 'package:get/get.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:mobilelabelcious/models/User.dart';
import 'package:mobilelabelcious/services/UserService.dart';

class UserController extends GetxController {
  var userList = <User>[].obs;

  void signupFromGoogle(GoogleSignInAccount googleUser) async {
    var displayName = googleUser.displayName;
    var firstName = '';
    var lastName = '';

    var nameParts = displayName!.split(' ');
    if (nameParts.length >= 2) {
      firstName = nameParts[0];
      lastName = nameParts.sublist(1).join(' ');
    } else if (nameParts.length == 1) {
      firstName = nameParts[0];
    }

    var newUser = User(
      firstName: firstName,
      lastName: lastName,
      email: googleUser.email,
      image: googleUser.photoUrl,
      password: googleUser.displayName,
      // Set other attributes as needed
    );

    try {
      var addedUser = await UserService.addUser(newUser);
      if (addedUser != null) {
        print('User added successfully');
      } else {
        print("You have an account already, you can proceed.");
      }
    } catch (e) {
      print('Failed to add user: $e');
      // Handle the error
    }
  }
}
