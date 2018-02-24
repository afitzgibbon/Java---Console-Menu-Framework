package org.andy.ui.console;

import java.lang.reflect.Method;

/*
 * MenuItem is used by a Menu object to map a menu option to a target method. With the 
 * use of reflection MenuItem is able to invoke the target. The object where the target
 * resides is also provided and this allows for a method in any Object to be invoked for 
 * a MenuItem. Each Menu object will also have a MenuItem instance used to define an exit
 * opiton in the menu. This will be a 'dummy' MenuItem meaning it cannot be invoked but 
 * is simply used as a identifier.
 */ 
public class MenuItem {
	private Object obj;
	private String label;
	private String target;
	private boolean isExitItem;
	
	/* 
	 * Use this constructor to create an exit option for a parent menu. It can also be
	 * used in the design phase when target methods have not yet been developed but you
	 * want the menu to be executable.
	 */
	public MenuItem(String label) { this(label, null, null); } // cannot invoke this MenuItem ie. dummy item
	/*
	 * Use this constructor to create a MenuItem to be used in a parent Menu. 
	 * label - is the menu option text or description.
	 * obj - is the parent of the target method
	 * target - the String name of the method to invoke when this MenuItem is selected
	 */
	public MenuItem(String label, Object obj, String target) {
		this.label = label;
		this.obj = obj;
		this.target = target;
	}
	
	public String getLabel() { return label; }
	
	/*
	 * This method is called by a parent Menu when the option that this MenuItem is
	 * associated with has been selected. It will attempt to create a Method object
	 * provided the method exists, and it will then attempt to invoke it. This 
	 * approach eliminates the need for a selection process in Menu as each MenuIeem 
	 * can invoke itself.
	 */
	void invoke() {
		if (target == null) return;
		
		try {
			Method method = obj.getClass().getMethod(target);
			method.invoke(obj);
		}
		catch (Exception ex) { ex.printStackTrace(); }
	}
	
	/* This method tells Menu if 'this' is an exit option or not. */
	boolean isExitItem() { return isExitItem; }
	
	/* Menu uses this method to tell 'this' it will be an exit option */
	void setExitItem(boolean isExitItem) { this.isExitItem = isExitItem; }
	
	public String toString() { return getLabel(); }
}