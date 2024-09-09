package application;
import java.util.Date;
//node of Date AVL
public class AVLNodeByDate extends AVLNode {
	private Date date;
    private Stack stack;
    public AVLNodeByDate(Martyr record,Date date) {
		super(record);
		stack=new Stack();
		this.date=date;
		
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Stack getStack() {
		return stack;
	}
	public void setStack(Stack stack) {
		this.stack = stack;
	}

	
  

    
    

}