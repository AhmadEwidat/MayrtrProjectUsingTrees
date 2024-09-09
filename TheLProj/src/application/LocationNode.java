package application;

//node of location
class LocationNode {
	private String location;
	private AVLTree1 AVLByName;
	private AVLTree1 AVLByDate;
	private LocationNode prev;
	private LocationNode next;

	public LocationNode(String location) {
		this.location = location;
		AVLByDate = new AVLTree1();
		AVLByName = new AVLTree1();
		this.prev = null;
		this.next = null;
	}

	public AVLTree1 getAVLByName() {
		return AVLByName;
	}

	public void setAVLByName(AVLTree1 aVLByName) {
		AVLByName = aVLByName;
	}

	public AVLTree1 getAVLByDate() {
		return AVLByDate;
	}

	public void setAVLByDate(AVLTree1 aVLByDate) {
		AVLByDate = aVLByDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocationNode getPrev() {
		return prev;
	}

	public void setPrev(LocationNode prev) {
		this.prev = prev;
	}

	public LocationNode getNext() {
		return next;
	}

	public void setNext(LocationNode next) {
		this.next = next;
	}
}
