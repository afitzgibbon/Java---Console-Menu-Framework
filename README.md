# Java---Console-Menu-Framework

The console is a great way to test program logic or test an idea quickly without overloading it with GUI elements. However, in many cases a menu system may be required, and anyone who has built a console menu will know that it is a repetitive and tiresome process. It can become quite ugly and hard to read if you have many nested sub-menus, it requires user input-handling and, if implemented, validation and finally a selection process based on the input. So with the above in mind I decided to create this project. It is a small framework which provides a mechanism for creating a console menu tree quickly. It consists of the following Objects:

	org.andy.ui.console.ConsoleUtils
	org.andy.ui.console.Menu
	org.andy.ui.console.MenuItem

I have also added a test class to demonstrate just how easy it is to utilise this framework. As can be seen from the test class, menu construction and user input-handling and validation is taken care of, all you are required to do is map a MenuItem to a target method or sub-menu and Menu will 'invoke' this mapping when the MenuItem is chosen.
