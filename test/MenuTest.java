package org.andy.test;

import org.andy.ui.console.ConsoleUtils;
import org.andy.ui.console.Menu;
import org.andy.ui.console.MenuItem;

/*
 * MenuTest has been created to demonstrate the simplicity of the Menu framework. All
 * you need to do is create a Menu instacne, setting a title is optional, and then add
 * the menu items you require. Execute the menu and you're done.
 */
public class MenuTest {	
	private void mainMenu() {
		Menu menu = new Menu();
		menu.setTitle("*** My Main Menu ***");
		menu.addItem(new MenuItem("Option A", this, "subMenuA"));
		menu.addItem(new MenuItem("Option B", this, "subMenuB"));
		menu.addItem(new MenuItem("Option C", this, "performOptionC"));
		menu.execute();
	}
	
	public void subMenuA() {
		Menu menu = new Menu();
		menu.setTitle("*** Sub Menu A ***");
		menu.addItem(new MenuItem("Option Aa"));
		menu.addItem(new MenuItem("Option Ab"));
		menu.execute();
	}
	
	/* This menu has no menu items but will still generate a single exit option. */
	public void subMenuB() {
		Menu menu = new Menu();
		menu.setTitle("*** Sub Menu B ***");
		menu.execute();
	}
	
	/* Added a confirmation request here to demonstrate how it could be used. */
	public void performOptionC() {
		boolean confirm = ConsoleUtils.requestConfirmation();
		if (confirm)
			System.out.println("\nDo Option C...");
		else System.out.println("\nOption C cancelled!");
		ConsoleUtils.pauseExecution();
	}
	
	public static void main(String[] args) { new MenuTest().mainMenu();	}
}