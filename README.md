# ShoeInventoryApp

This project consist of five screens.

1. Login screen: Email and password fields and labels plus create and login buttons
2. Welcome onboarding screen
3. Instructions onboarding screen
4. Shoe Listing screen
5. Shoe Detail screen for adding a new shoe

1. Login destination.
- Include email and password labels
- Include email and password fields
- Create buttons for creating a new login and logging in with an existing account
- Clicking either button should navigate to the Welcome Screen.

2. Welcome screen destination that includes:
- A new layout
- At least 2 textviews and use any text you would like
- A navigation button with actions to navigate to the instructions screen.

3. Instruction destination that includes:
- A new layout
- At least 2 textviews with appropriate information
- A navigation button with actions to navigate to the shoe list screen.

4. Create a class that extends ViewModel
- Use a LiveData field that returns the list of shoes.

5. Create a new Shoe List destination that includes:
- A new layout
- A ScrollView
- A LinearLayout inside the ScrollView for Shoe Items
- A FloatingActionButton with an action to navigate to the shoe detail screen.

6. In MainActivity, setup the nav controller with the toolbar and an AppBarConfiguration.

7. In the shoe list screen, add a Logout menu. This Logout menu will appear only on the shoe list screen and will return the user to the login screen.

8. Create a new Shoe Detail destination that includes:
- A new layout
- A TextView label and EditView for the Shoe Name, Company, Shoe Size and Description
- A Cancel button with an action to navigate back to the shoe list screen
- A Save button with an action to navigate back to the shoe list screen and add a new Shoe to the Shoe View Model.

Hint: In the Shoe List destination, to add a child view programmatically to a ViewGroup, such as LinearLayout, use the addView() method. Refer to a sample implementation in the StackOverflow discussion here.

9. Make sure you can’t go back to onboarding screens In the Shoe List screen:
- Use an Activity level ViewModel to hold a list of Shoes (use by activityViewModels)
- Observe the shoes variable from the ViewModel
- Add a new layout item into the scrollview for each shoe.


# Tech-Stack 

* Languages: Kotlin
* Architecture: MVVM design principles 
* Software: Android Studio, Git
