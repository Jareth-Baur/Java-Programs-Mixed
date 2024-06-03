package inventorySystem;
/*   __________________________________________________
|  ABC Company Inventory System                    |
|              on 2022-11-28 06:30:00              |
|    Developer: John Ray D. Paulin                 |
|    ** Helper class for the inventory system.     |
|__________________________________________________|
*/

//package genman;

class Employee {
	private String id;
	private String fname;
	private String lname;

	Employee(String id, String fname, String lname) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}

	public String getId() {
		return this.id;
	}

	public String getFname() {
		return this.fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void display() {
		System.out.println("Employee id is " + id + " " + " and Employee name is " + fname + " " + lname);
	}
}
