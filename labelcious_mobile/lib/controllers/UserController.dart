import 'package:get/get.dart';
import 'package:google_sign_in/google_sign_in.dart';
import 'package:mobilelabelcious/models/User.dart';
import 'package:mobilelabelcious/services/UserService.dart';

class UserController extends GetxController {
  GoogleSignInAccount? googleUser;

  var authUser = User().obs();

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

  void findUserById() async {
    try {
      var user = await UserService.getUserById(googleUser!.id.hashCode);
      if (user != null) {
        authUser = user;
      } else {
        print('User not found.');
      }
    } catch (e) {
      print('Failed to retrieve user: $e');
      // Handle the error
    }
  }

  void updateUser(User user, int id) {
    var updatedUser = User(
      firstName: user.firstName,
      lastName: user.lastName,
      number: user.number,
      job: user.job,
    );

    try {
      var editedUser = UserService.updateUser(updatedUser, id);
      if (editedUser != null) {
        print("User updated successfully");
      } else {
        print("Error in updating user in controller");
      }
    } catch (e) {
      print("Error: $e");
      rethrow;
    }
  }

  void setGoogleUser(GoogleSignInAccount user) {
    googleUser = user;
  }
}
