import 'package:get/get.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:mobilelabelcious/models/User.dart';
import 'package:mobilelabelcious/services/UserService.dart';

class UserController extends GetxController {
  GoogleSignInAccount? googleUser;

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

    print("google id: ${googleUser.id}");
    var userId = int.tryParse(googleUser.id) ?? 5;

    var newUser = User(
      id: googleUser.id.hashCode,
      firstName: firstName,
      lastName: lastName,
      email: googleUser.email,
      image: googleUser.photoUrl,
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

  void setGoogleUser(GoogleSignInAccount user) {
    googleUser = user;
  }
}
