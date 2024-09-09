package application;
//class of node by name 

public class AVLNodeByName extends AVLNode {
    private String name;
  

    public AVLNodeByName(String name, Martyr record) {
    	super(record);
        this.name = name;
    }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

   

}