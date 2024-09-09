package application;
//the Father node of the two nodes 
public class AVLNode {
	  private Martyr record;
	    private AVLNode left;
	    private AVLNode right;
	    private int height;
		public AVLNode(Martyr record) {
			this.record = record;
			this.height = 1;
			
		}
		public Martyr getRecord() {
			return record;
		}
		public void setRecord(Martyr record) {
			this.record = record;
		}
		
		public AVLNode getLeft() {
			return left;
		}
		public void setLeft(AVLNode left) {
			this.left = left;
		}
		public AVLNode getRight() {
			return right;
		}
		public void setRight(AVLNode right) {
			this.right = right;
		}
		public void setRight(AVLNodeByDate right) {
			this.right = right;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		
	    
}
