/*   __________________________________________________
    |  ABC Company Inventory System                    |
    |              on 2022-11-28 06:30:00              |
    |    Developer: John Ray D. Paulin                 |
    |    ** Helper class for the inventory system.     |
    |__________________________________________________|
*/
// package genman;

class Peripheral {
    private String code;
    private String name;
    private String peripheral;
    private String assignedTo;
    
    Peripheral(String code, String name, String peripheral, String assignedTo){
        this.code = code;
        this.name = name;
        this.peripheral = peripheral;
        this.assignedTo = assignedTo;
    }

    public String getCode(){
        return this.code;
    }
    public void setName(String name){
        this.name = name;   
    }
    public String getName(){
        return this.name;
    }
    public void setPeripheral(String peripheral){
        this.peripheral = peripheral;
    }
    public String getPeripheral(){
        return this.peripheral;
    }
    public void setAssignedTo(String assignedTo){
        this.assignedTo = assignedTo;
    }
    public String getAssignedTo(){
        return this.assignedTo;
    }
    public void display(){
        System.out.println("Peripheral code is " + code + " " + " and Peripheral name is " + name + ". Assigned to " + assignedTo );
    }
}
