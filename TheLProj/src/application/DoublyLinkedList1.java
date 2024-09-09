package application;

import java.util.ArrayList;
import java.util.Date;

import javafx.scene.control.Label;

//the double linked list of locations
public class DoublyLinkedList1 {
	private LocationNode head;
	private LocationNode tail;
	private String string = new String();
	private int numberOfMartyrs;
	private Martyr martyr;
	private LocationNode locationNode;
	private String Report = "";
	private String locate;

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	private ArrayList arrayList = new ArrayList();

	public ArrayList getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList arrayList) {
		this.arrayList = arrayList;
	}

	public String getReport() {
		return Report;
	}

	public void setReport(String report) {
		Report = report;
	}

	public LocationNode getTail() {
		return tail;
	}

	public void setTail(LocationNode tail) {
		this.tail = tail;
	}

	public LocationNode getHead() {
		return head;
	}

	public void setHead(LocationNode head) {
		this.head = head;
	}

	public LocationNode getLocationNode() {
		return locationNode;
	}

	public void setLocationNode(LocationNode locationNode) {
		this.locationNode = locationNode;
	}

	public Martyr getMartyr() {
		return martyr;
	}

	public void setMartyr(Martyr martyr) {
		this.martyr = martyr;
	}

	public int getNumberOfMartyrs() {
		return numberOfMartyrs;
	}

	public void setNumberOfMartyrs(int numberOfMartyrs) {
		this.numberOfMartyrs = numberOfMartyrs;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public DoublyLinkedList1() {

	}

//add sorted location
	public void insertOrderedLocation(String location) {
		LocationNode newNode = new LocationNode(location);

		if (head == null) {
			head = newNode;
			tail = newNode;
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
		} else {
			LocationNode current = head;
			while (current != null) {
				int comparison = location.compareToIgnoreCase(current.getLocation());
				if (comparison == 0) {

					return;
				} else if (comparison < 0) {
					// Insert newNode before current node
					if (current == head) {
						newNode.setNext(current);
						newNode.setPrev(tail);
						current.setPrev(newNode);
						tail.setNext(newNode);
						head = newNode;
					} else {
						newNode.setPrev(current.getPrev());
						newNode.setNext(current);
						current.getPrev().setNext(newNode);
						current.setPrev(newNode);
					}
					return;
				}
				current = current.getNext();
				if (current == head) {
					break;
				}
			}

			// Insert newNode at the end of the list
			newNode.setPrev(tail);
			newNode.setNext(head);
			tail.setNext(newNode);
			head.setPrev(newNode);
			tail = newNode;
		}
	}

	public void insertOrUpdateLocation(String location, Martyr martyr) {
		if (head == null) {
			LocationNode newNode = new LocationNode(location);
			newNode.getAVLByName().insert(martyr.getName(), martyr);
			newNode.getAVLByDate().insert(martyr.getDateOfDeathAsDate(), martyr);
			newNode.setNext(newNode);
			newNode.setPrev(newNode);
			head = newNode;
			tail = newNode;
		} else {
			LocationNode current = head;

			while (current != null) {
				if (current.getLocation().equalsIgnoreCase(location)) {
					current.getAVLByName().insert(martyr.getName(), martyr);
					current.getAVLByDate().insert(martyr.getDateOfDeathAsDate(), martyr);
					return;
				}
				current = current.getNext();
				if (current == head) {
					break;
				}
			}

			// Add new location
			LocationNode newNode = new LocationNode(location);
			newNode.getAVLByName().insert(martyr.getName(), martyr);
			newNode.getAVLByDate().insert(martyr.getDateOfDeathAsDate(), martyr);

			if (location.compareToIgnoreCase(head.getLocation()) < 0) {
				newNode.setNext(head);
				newNode.setPrev(tail);
				head.setPrev(newNode);
				tail.setNext(newNode);
				head = newNode;
			} else if (location.compareToIgnoreCase(tail.getLocation()) > 0) {
				newNode.setPrev(tail);
				newNode.setNext(head);
				tail.setNext(newNode);
				head.setPrev(newNode);
				tail = newNode;
			} else {
				current = head.getNext();
				while (current != null) {
					if (location.compareToIgnoreCase(current.getLocation()) < 0) {
						newNode.setPrev(current.getPrev());
						newNode.setNext(current);
						current.getPrev().setNext(newNode);
						current.setPrev(newNode);
						break;
					}
					current = current.getNext();
				}
			}
		}
	}

	// search location
	public boolean searchLocation(String location) {
		if (head == null) {
			return false; // Empty list
		}

		LocationNode current = head;

		do {
			if (current.getLocation().equalsIgnoreCase(location)) {
				return true;
			}
			current = current.getNext();
		} while (current != head);

		return false;
	}

	public boolean updateLocation(String oldLocation, String newLocation) {
		if (head == null) {
			return false; // Empty list
		}

		LocationNode current = head;
		boolean locationUpdated = false;

		do {
			if (current.getLocation().equalsIgnoreCase(oldLocation)) {
				current.setLocation(newLocation);
				locationUpdated = true;
			}
			current = current.getNext();
		} while (current != head);

		return locationUpdated;
	}

	public void deleteLocation(String location) {
		if (head == null) {
			return; // Empty list
		}

		LocationNode current = head;

		do {
			if (current.getLocation().equalsIgnoreCase(location)) {
				LocationNode prev = current.getPrev();
				LocationNode next = current.getNext();

				if (prev != null) {
					prev.setNext(next);
				} else {
					head = next;
				}

				if (next != null) {
					next.setPrev(prev);
				} else {
					tail = prev;
				}

				break;
			}

			current = current.getNext();
		} while (current != head);
	}

	public void deleteMartyr(String martyrName) {
		LocationNode current = head;

		do {
			AVLTree1 avlTreeByName = current.getAVLByName();
			AVLTree1 avlTreeByDate = current.getAVLByDate();

			// Search and delete in AVLTreeByName
			avlTreeByName.delete(martyrName);

			avlTreeByDate.remove(martyrName);

			current = current.getNext();
		} while (current != head);
	}

//to add martyr in location
	public void addMartyrInLocation(String location, Martyr newMartyr) {
		LocationNode current = head;

		do {
			if (current.getLocation().equalsIgnoreCase(location)) {
				AVLTree1 avlTreeByName = current.getAVLByName();
				AVLTree1 avlTreeByDate = current.getAVLByDate();

				avlTreeByName.insert(newMartyr.getName(), newMartyr);
				avlTreeByDate.insert(newMartyr.getDateOfDeathAsDate(), newMartyr);

				return;
			}

			current = current.getNext();
		} while (current != head);
	}

//to print all martyrs to input location
	public void displayAllMartyrsByLocation(String location) {
		LocationNode current = head;
		boolean locationFound = false;
		if (current != null) {
			do {
				if (current.getLocation().equalsIgnoreCase(location)) {
					AVLTree1 avlTreeByName = current.getAVLByName();
					StringBuilder stringBuilder = new StringBuilder();

					stringBuilder.append("Location: ").append(current.getLocation()).append("\n");
					displayMartyrsInOrder((AVLNodeByName) avlTreeByName.getRoot(), stringBuilder);
					string = stringBuilder.toString();

					locationFound = true;
					break;
				}

				current = current.getNext();
			} while (current != head);
		}

		if (!locationFound) {
			string += "Location not found: " + location;
		}
	}

	private void displayMartyrsInOrder(AVLNodeByName node, StringBuilder stringBuilder) {
		if (node != null) {
			displayMartyrsInOrder((AVLNodeByName) node.getLeft(), stringBuilder);
			stringBuilder.append(node.getRecord().print()).append("\n");
			displayMartyrsInOrder((AVLNodeByName) node.getRight(), stringBuilder);
		}
	}

	public void printAllMartyrsWithLocations() {
		string = "";
		LocationNode current = head;
		String s = "Name,Age,location,Date of death,Gender\n";
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(s);
		do {
			AVLTree1 avlTreeByName = current.getAVLByName();

			printMartyrsInOrder((AVLNodeByName) avlTreeByName.getRoot(), stringBuilder, current);
			string += stringBuilder.toString();
			stringBuilder.setLength(0);
			current = current.getNext();
		} while (current != head);
	}

	private void printMartyrsInOrder(AVLNodeByName node, StringBuilder stringBuilder, LocationNode c) {
		if (node != null) {
			printMartyrsInOrder((AVLNodeByName) node.getLeft(), stringBuilder, c);
			node.getRecord().setLocation(c.getLocation());
			stringBuilder.append(node.getRecord().toString()).append("\n");
			printMartyrsInOrder((AVLNodeByName) node.getRight(), stringBuilder, c);
		}
	}

	private void printMartyrsInOrder(AVLNodeByName node) {
		if (node != null) {
			printMartyrsInOrder((AVLNodeByName) node.getLeft());
			Martyr martyr = node.getRecord();
			string += martyr.getName() + ", " + martyr.getAge() + ", " + martyr.getDateOfDeath() + ", "
					+ martyr.getGender() + "\n";
			printMartyrsInOrder((AVLNodeByName) node.getRight());
		}
	}

//search by part of name 
	public void searchMartyrByName(String name) {
		string = "";
		numberOfMartyrs = 0;
		LocationNode current = head;

		if (head != null && current == head) {
			AVLNodeByName rootNode = (AVLNodeByName) current.getAVLByName().getRoot();
			searchMartyrByNameRecursive(rootNode, name);
			locationNode = current;
			current = current.getNext();
		}
		while (current != head) {
			AVLNodeByName rootNode = (AVLNodeByName) current.getAVLByName().getRoot();
			searchMartyrByNameRecursive(rootNode, name);
			locationNode = current;
			current = current.getNext();

		}

		if (numberOfMartyrs == 0) {
			string += ("No martyrs found with the given name: ") + (name);
		}

	}

	private void searchMartyrByNameRecursive(AVLNodeByName node, String name) {
		if (node == null) {
			return;
		}

		searchMartyrByNameRecursive((AVLNodeByName) node.getLeft(), name);

		if (node.getRecord().getName().contains(name)) {
			string += (node.getRecord().toString()) + ("\n");
			martyr = node.getRecord();
			numberOfMartyrs++;
		}

		searchMartyrByNameRecursive((AVLNodeByName) node.getRight(), name);
	}

	private int countMartyrsInAVL(AVLNodeByName node) {
		if (node == null) {
			return 0;
		}
		return 1 + countMartyrsInAVL((AVLNodeByName) node.getLeft())
				+ countMartyrsInAVL((AVLNodeByName) node.getRight());
	}

	// to get node
//	public LocationNode getLocationNode(String locationName) {
//		LocationNode currentNode = head;
//
//		while (currentNode != null) {
//			if (currentNode.getLocation().equalsIgnoreCase(locationName)) {
//				return currentNode;
//			}
//			currentNode = currentNode.getNext();
//		}
//
//		// Location not found
//		return null;
//	}
	public void display() {
		LocationNode current = head;
		arrayList.removeAll(arrayList);
		if (current != null) {
			do {
				arrayList.add(current.getLocation());
				current = current.getNext();
			} while (current != head);
		}
	}

	public void Report(String location) {
		string = "";
		LocationNode current = head;
		if (current != null) {
			do {
				if (current.getLocation().equalsIgnoreCase(location)) {
					string = "The numbers of martyrs in the selected location :"
							+ countMartyrsInAVL((AVLNodeByName) current.getAVLByName().getRoot()) + "\n"
							+ "The height of the 1st AVL tree :" + current.getAVLByName().calculateHeight() + "\n"
							+ "The height of the 2nd AVL tree :" + current.getAVLByDate().calculateHeight() + "\n"
							+ "the date that had the maximum number of martyrs :"
							+ current.getAVLByDate().findMaxMartyrsDate();
					break;
				}
				current = current.getNext();
			} while (current != head);
		}
	}

	public void traverseAVLLevelByLevel(String locat, int x) {
		string = "";
		if (x < 1) {
			string = "not exist level";
		}
		LocationNode current = head;

		if (current != null) {
			do {
				if (current.getLocation() == locat) {
					current.getAVLByName().traverseAVLLevelByLevel(x);
					string = current.getAVLByName().getS();
					break;
				}
				current = current.getNext();
			} while (current != head);
		}
	}

	public void traverseBackward(String locat) {
		LocationNode current = head;

		if (current != null) {
			do {
				if (current.getLocation().equalsIgnoreCase(locat)) {

					current.getAVLByDate().traverseBackward(locat);
					string = current.getAVLByDate().getS();
					break;
				}
				current = current.getNext();
			} while (current != head);
		}
	}

}
