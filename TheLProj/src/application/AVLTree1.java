package application;

import java.util.Date;

//the AVLTree to implement the trees
public class AVLTree1 {
	// general node
	private AVLNode root;
	String s = new String();

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public AVLNode getRoot() {
		return root;
	}

	public void setRoot(AVLNode root) {
		this.root = root;
	}

//to insert martyr to name AVLTree
	public void insert(String name, Martyr record) {
		root = insert((AVLNodeByName) root, name, record);
	}

	private AVLNodeByName insert(AVLNodeByName node, String name, Martyr record) {
		if (node == null) {
			return new AVLNodeByName(name, record);
		}

		if (name.compareToIgnoreCase(node.getName()) < 0) {
			node.setLeft(insert((AVLNodeByName) node.getLeft(), name, record));
		} else if (name.compareToIgnoreCase(node.getName()) > 0) {
			node.setRight(insert((AVLNodeByName) node.getRight(), name, record));
		} else {

		}

		node.setHeight(Math.max(height((AVLNodeByName) node.getLeft()), height((AVLNodeByName) node.getRight())) + 1);
		int balance = getBalance(node);

		if (balance > 1 && name.compareToIgnoreCase(((AVLNodeByName) node.getLeft()).getName()) < 0) {
			return rotateRight(node);
		}

		if (balance < -1 && name.compareToIgnoreCase(((AVLNodeByName) node.getRight()).getName()) > 0) {
			return rotateLeft(node);
		}

		if (balance > 1 && name.compareToIgnoreCase(((AVLNodeByName) node.getLeft()).getName()) > 0) {
			node.setLeft(rotateLeft((AVLNodeByName) node.getLeft()));
			return rotateRight(node);
		}

		if (balance < -1 && name.compareToIgnoreCase(((AVLNodeByName) node.getRight()).getName()) < 0) {
			node.setRight(rotateRight((AVLNodeByName) node.getRight()));
			return rotateLeft(node);
		}

		return node;
	}

	// to delete martyr from name AVLTree
	public void delete(String subName) {
		root = delete((AVLNodeByName) root, subName);
	}

	private AVLNodeByName delete(AVLNodeByName node, String subName) {
		if (node == null) {
			return null;
		}

		if (subName.compareToIgnoreCase(node.getName().substring(0, subName.length())) < 0) {
			node.setLeft(delete((AVLNodeByName) node.getLeft(), subName));
		} else if (subName.compareToIgnoreCase(node.getName().substring(0, subName.length())) > 0) {
			node.setRight(delete((AVLNodeByName) node.getRight(), subName));
		} else {
			if (node.getLeft() == null || node.getRight() == null) {
				node = (node.getLeft() != null) ? (AVLNodeByName) node.getLeft() : (AVLNodeByName) node.getRight();
			} else {
				AVLNodeByName successor = findMinNode((AVLNodeByName) node.getRight());
				node.setName(successor.getName());
				node.setRecord(successor.getRecord());
				node.setRight(delete((AVLNodeByName) node.getRight(), successor.getName()));
			}
		}

		if (node == null) {
			return null;
		}

		node.setHeight(Math.max(height((AVLNodeByName) node.getLeft()), height((AVLNodeByName) node.getRight())) + 1);
		int balance = getBalance(node);

		if (balance > 1 && getBalance((AVLNodeByName) node.getLeft()) >= 0) {
			return rotateRight(node);
		}

		if (balance < -1 && getBalance((AVLNodeByName) node.getRight()) <= 0) {
			return rotateLeft(node);
		}

		if (balance > 1 && getBalance((AVLNodeByName) node.getLeft()) < 0) {
			node.setLeft(rotateLeft((AVLNodeByName) node.getLeft()));
			return rotateRight(node);
		}

		if (balance < -1 && getBalance((AVLNodeByName) node.getRight()) > 0) {
			node.setRight(rotateRight((AVLNodeByName) node.getRight()));
			return rotateLeft(node);
		}

		return node;
	}

	// to insert martyr to date AVLTree
	public void insert(Date date, Martyr record) {
		root = insert((AVLNodeByDate) root, date, record);
	}

	private AVLNodeByDate insert(AVLNodeByDate node, Date date, Martyr record) {
		if (node == null) {
			AVLNodeByDate avlNodeByDate = new AVLNodeByDate(record, date);
			avlNodeByDate.getStack().push(record);
			return avlNodeByDate;
		}

		if (date.compareTo(node.getDate()) < 0) {
			node.setLeft(insert((AVLNodeByDate) node.getLeft(), date, record));
		} else if (date.compareTo(node.getDate()) > 0) {
			node.setRight(insert((AVLNodeByDate) node.getRight(), date, record));
		} else {
			node.getStack().push(record);
		}

		node.setHeight(Math.max(height((AVLNodeByDate) node.getLeft()), height((AVLNodeByDate) node.getRight())) + 1);
		int balance = getBalance(node);

		// Perform rotations if necessary to maintain balance
		if (balance > 1 && date.compareTo(((AVLNodeByDate) node.getLeft()).getDate()) < 0) {
			return rotateRight(node);
		}

		if (balance < -1 && date.compareTo(((AVLNodeByDate) node.getRight()).getDate()) > 0) {
			return rotateLeft(node);
		}

		if (balance > 1 && date.compareTo(((AVLNodeByDate) node.getLeft()).getDate()) > 0) {
			node.setLeft(rotateLeft((AVLNodeByDate) node.getLeft()));
			return rotateRight(node);
		}

		if (balance < -1 && date.compareTo(((AVLNodeByDate) (node.getRight())).getDate()) < 0) {
			node.setRight(rotateRight((AVLNodeByDate) node.getRight()));
			return rotateLeft(node);
		}

		return node;
	}

	// to delete martyr from date AVLTree
//	public void delete(Date date) {
//		root = delete((AVLNodeByDate) root, date);
//	}
//
//	private AVLNodeByDate delete(AVLNodeByDate node, Date date) {
//		if (node == null) {
//			return null;
//		}
//
//		if (date.compareTo(node.getDate()) < 0) {
//			node.setLeft(delete((AVLNodeByDate) node.getLeft(), date));
//		} else if (date.compareTo(node.getDate()) > 0) {
//			node.setRight(delete((AVLNodeByDate) node.getRight(), date));
//		} else {
//			if (!node.getStack().isEmpty()) {
//				node.getStack().pop();
//			} else {
//				if (node.getLeft() == null || node.getRight() == null) {
//					node = (AVLNodeByDate) ((node.getLeft() != null) ? node.getLeft() : node.getRight());
//				} else {
//					AVLNodeByDate successor = findMinNode((AVLNodeByDate) node.getRight());
//					node.setDate(successor.getDate());
//					node.setStack(successor.getStack());
//					node.setRight(delete((AVLNodeByDate) node.getRight(), successor.getDate()));
//				}
//			}
//		}
//
//		if (node == null) {
//			return null;
//		}
//
//		node.setHeight(Math.max(height((AVLNodeByDate) node.getLeft()), height((AVLNodeByDate) node.getRight())) + 1);
//		int balance = getBalance(node);
//
//		if (balance > 1 && getBalance((AVLNodeByDate) node.getLeft()) >= 0) {
//			return rotateRight(node);
//		}
//
//		if (balance < -1 && getBalance((AVLNodeByDate) node.getRight()) <= 0) {
//			return rotateLeft(node);
//		}
//
//		if (balance > 1 && getBalance((AVLNodeByDate) node.getLeft()) < 0) {
//			node.setLeft(rotateLeft((AVLNodeByDate) node.getLeft()));
//			return rotateRight(node);
//		}
//
//		if (balance < -1 && getBalance((AVLNodeByDate) node.getRight()) > 0) {
//			node.setRight(rotateRight((AVLNodeByDate) node.getRight()));
//			return rotateLeft(node);
//		}
//
//		return node;
//	}

	private AVLNodeByName findMinNode(AVLNodeByName node) {
		AVLNodeByName current = node;
		while (current.getLeft() != null) {
			current = (AVLNodeByName) current.getLeft();
		}
		return current;
	}

	private int height(AVLNodeByName node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

	private int getBalance(AVLNodeByName node) {
		if (node == null) {
			return 0;
		}
		return height((AVLNodeByName) node.getLeft()) - height((AVLNodeByName) node.getRight());
	}

	private AVLNodeByName rotateRight(AVLNodeByName z) {
		AVLNodeByName y = (AVLNodeByName) z.getLeft();
		AVLNodeByName T3 = (AVLNodeByName) y.getRight();

		y.setRight(z);
		z.setLeft(T3);

		z.setHeight(Math.max(height((AVLNodeByName) z.getLeft()), height((AVLNodeByName) z.getRight())) + 1);
		y.setHeight(Math.max(height((AVLNodeByName) y.getLeft()), height((AVLNodeByName) y.getRight())) + 1);

		return y;
	}

	private AVLNodeByName rotateLeft(AVLNodeByName z) {
		AVLNodeByName y = (AVLNodeByName) z.getRight();
		AVLNodeByName T2 = (AVLNodeByName) y.getLeft();

		y.setLeft(z);
		z.setRight(T2);

		z.setHeight(Math.max(height((AVLNodeByName) z.getLeft()), height((AVLNodeByName) z.getRight())) + 1);
		y.setHeight(Math.max(height((AVLNodeByName) y.getLeft()), height((AVLNodeByName) y.getRight())) + 1);

		return y;
	}

	private AVLNodeByDate findMinNode(AVLNodeByDate node) {
		AVLNodeByDate current = node;
		while (current.getLeft() != null) {
			current = (AVLNodeByDate) current.getLeft();
		}
		return current;
	}

	private int height(AVLNodeByDate node) {
		if (node == null) {
			return 0;
		}
		return node.getHeight();
	}

	private int getBalance(AVLNodeByDate node) {
		if (node == null) {
			return 0;
		}
		return height((AVLNodeByDate) node.getLeft()) - height((AVLNodeByDate) node.getRight());
	}

	private AVLNodeByDate rotateRight(AVLNodeByDate z) {
		AVLNodeByDate y = (AVLNodeByDate) z.getLeft();
		AVLNodeByDate T3 = (AVLNodeByDate) y.getRight();

		y.setRight(z);
		z.setLeft(T3);

		z.setHeight(Math.max(height((AVLNodeByDate) z.getLeft()), height((AVLNodeByDate) z.getRight())) + 1);
		y.setHeight(Math.max(height((AVLNodeByDate) y.getLeft()), height((AVLNodeByDate) y.getRight())) + 1);

		return y;
	}

	private AVLNodeByDate rotateLeft(AVLNodeByDate z) {
		AVLNodeByDate y = (AVLNodeByDate) z.getRight();
		AVLNodeByDate T2 = (AVLNodeByDate) y.getLeft();

		y.setLeft(z);
		z.setRight(T2);

		z.setHeight(Math.max(height((AVLNodeByDate) z.getLeft()), height((AVLNodeByDate) z.getRight())) + 1);
		y.setHeight(Math.max(height((AVLNodeByDate) y.getLeft()), height((AVLNodeByDate) y.getRight())) + 1);

		return y;
	}

	public String findMaxMartyrsDate() {
		AVLNodeByDate maxNode = findMaxMartyrsDate((AVLNodeByDate) root);

		if (maxNode != null) {
			return maxNode.getRecord().getDateOfDeath();
		}

		return null;
	}

	private AVLNodeByDate findMaxMartyrsDate(AVLNodeByDate node) {
		if (node == null) {
			return null;
		}

		AVLNodeByDate maxNode = null;
		int maxMartyrs = 0;

		AVLNodeByDate leftMaxNode = findMaxMartyrsDate((AVLNodeByDate) node.getLeft());
		if (leftMaxNode != null) {
			int leftMartyrs = leftMaxNode.getStack().size();
			if (leftMartyrs > maxMartyrs) {
				maxMartyrs = leftMartyrs;
				maxNode = leftMaxNode;
			}
		}

		int nodeMartyrs = node.getStack().size();
		if (nodeMartyrs > maxMartyrs) {
			maxMartyrs = nodeMartyrs;
			maxNode = node;
		}

		AVLNodeByDate rightMaxNode = findMaxMartyrsDate((AVLNodeByDate) node.getRight());
		if (rightMaxNode != null) {
			int rightMartyrs = rightMaxNode.getStack().size();
			if (rightMartyrs > maxMartyrs) {
				maxMartyrs = rightMartyrs;
				maxNode = rightMaxNode;
			}
		}

		return maxNode;
	}

//traverse Backward from the AVL2
	public void traverseBackward(String Locate) {
		s = "";
		if (root == null) {
			s = ("AVL tree is empty.");
			return;
		}

		Stack stack = new Stack();
		AVLNodeByDate current = (AVLNodeByDate) root;

		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = (AVLNodeByDate) current.getRight();
			}

			current = (AVLNodeByDate) stack.pop();
			Stack martyrStack = current.getStack();

			while (!martyrStack.isEmpty()) {
				Martyr martyr = (Martyr) martyrStack.pop();
				martyr.setLocation(Locate);
				s += (martyr.toString() + "\n");
			 }
			s += "@";
			current = (AVLNodeByDate) current.getLeft();
		}
	}

	public int calculateHeight() {
		return calculateHeight(root);
	}

	private int calculateHeight(AVLNode node) {
		if (node == null) {
			return 0;
		}

		int leftHeight = calculateHeight(node.getLeft());
		int rightHeight = calculateHeight(node.getRight());

		return 1 + Math.max(leftHeight, rightHeight);
	}

	// traverse from the AVL1
	public void traverseAVLLevelByLevel(int levelNumber) {
		s = "" + levelNumber + "\n";
		if (root == null) {
			s += ("AVL tree is empty.");
			return;
		}

		Queue queue = new Queue();
		queue.enqueue(root);

		int currentLevel = 1;
		int nodesInCurrentLevel = 1;
		int nodesInNextLevel = 0;
		int level = 1;

		while (!queue.isEmpty()) {
			AVLNodeByName node = (AVLNodeByName) queue.dequeue();
			Martyr martyr = node.getRecord();

			if (level == levelNumber) {

				s += (martyr.print()) + "\n";

			}

			nodesInCurrentLevel--;

			if (node.getLeft() != null) {
				queue.enqueue(node.getLeft());
				nodesInNextLevel++;
			}

			if (node.getRight() != null) {
				queue.enqueue(node.getRight());
				nodesInNextLevel++;
			}

			if (nodesInCurrentLevel == 0) {
				if (level == levelNumber) {
//					System.out.println();
					return;
				}

				level++;
				nodesInCurrentLevel = nodesInNextLevel;
				nodesInNextLevel = 0;
			}
		}

		s += ("Level " + levelNumber + " not found in the AVL tree.");
	}

//update martyr from the AVL1
//	public void updateByName(String name, Martyr newRecord) {
//		root = updateNodeByName((AVLNodeByName) root, name, newRecord);
//	}
//
//	private AVLNodeByName updateNodeByName(AVLNodeByName node, String name, Martyr newRecord) {
//		if (node == null) {
//			return null;
//		}
//
//		if (name.compareTo(node.getName()) < 0) {
//			node.setLeft(updateNodeByName((AVLNodeByName) node.getLeft(), name, newRecord));
//		} else if (name.compareTo(node.getName()) > 0) {
//			node.setRight(updateNodeByName((AVLNodeByName) node.getRight(), name, newRecord));
//		} else {
//			node.setRecord(newRecord);
//		}
//
//		node.setHeight(1 + Math.max(height((AVLNodeByName) node.getLeft()), height((AVLNodeByName) node.getRight())));
//
//		int balanceFactor = getBalance(node);
//
//		if (balanceFactor > 1) {
//			if (getBalance((AVLNodeByName) node.getLeft()) >= 0) {
//				return rotateRight(node);
//			} else {
//				node.setLeft(rotateRight((AVLNodeByName) node.getLeft()));
//				return rotateRight(node);
//			}
//		}
//
//		if (balanceFactor < -1) {
//			if (getBalance((AVLNodeByName) node.getRight()) <= 0) {
//				return rotateLeft(node);
//			} else {
//				node.setRight(rotateRight((AVLNodeByName) node.getRight()));
//				return rotateLeft(node);
//			}
//		}
//
//		return node;
//	}

//	// update martyr from the AVL2
//	public void updateByDate(Date date, Martyr newRecord) {
//		updateNodeByDate((AVLNodeByDate) root, date, newRecord);
//	}
//
//	private void updateNodeByDate(AVLNodeByDate node, Date date, Martyr newRecord) {
//		if (node == null) {
//			return;
//		}
//
//		if (date.compareTo(node.getDate()) < 0) {
//			updateNodeByDate((AVLNodeByDate) node.getLeft(), date, newRecord);
//		} else if (date.compareTo(node.getDate()) > 0) {
//			updateNodeByDate((AVLNodeByDate) node.getRight(), date, newRecord);
//		} else {
//			Stack stack = node.getStack();
//			if (!stack.isEmpty()) {
//				stack.pop();
//				stack.push(newRecord);
//			}
//		}
//	}

	// search martyr by name
	public Martyr searchByName(String name) {
		return searchNodeByName((AVLNodeByName) root, name);
	}

	private Martyr searchNodeByName(AVLNodeByName node, String name) {
		if (node == null) {
			return null;
		}

		if (name.compareTo(node.getName()) < 0) {
			return searchNodeByName((AVLNodeByName) node.getLeft(), name);
		} else if (name.compareTo(node.getName()) > 0) {
			return searchNodeByName((AVLNodeByName) node.getRight(), name);
		} else {
			return node.getRecord();
			
		}
	}

	// remove martyr by name
	public void remove(String name) {
		root = delete((AVLNodeByDate) root, name);
	}

	private AVLNodeByDate delete(AVLNodeByDate node, String name) {
		if (node == null) {
			return null;
		}

		if (name.compareToIgnoreCase(node.getRecord().getName()) < 0) {
			node.setLeft(delete((AVLNodeByDate) node.getLeft(), name));
		} else if (name.compareToIgnoreCase(node.getRecord().getName()) > 0) {
			node.setRight(delete((AVLNodeByDate) node.getRight(), name));
		} else {
			node.getStack().remove(name);

			if (node.getStack().isEmpty()) {

				if (node.getLeft() == null) {
					return (AVLNodeByDate) node.getRight();
				}

				else if (node.getRight() == null) {
					return (AVLNodeByDate) node.getLeft();
				}

				else {
					AVLNodeByDate successor = findMinNode((AVLNodeByDate) node.getRight());
					node.setDate(successor.getDate());
					node.setStack(successor.getStack());
					node.setRight(delete((AVLNodeByDate) node.getRight(), successor.getRecord().getName()));
				}
			}
		}

		// Update the height and balance factor
		node.setHeight(Math.max(height((AVLNodeByDate) node.getLeft()), height((AVLNodeByDate) node.getRight())) + 1);
		int balance = getBalance(node);

		// Perform rotations if necessary to maintain balance
		if (balance > 1 && name.compareToIgnoreCase(((AVLNodeByDate) node.getLeft()).getRecord().getName()) < 0) {
			return rotateRight(node);
		}

		if (balance < -1 && name.compareToIgnoreCase(((AVLNodeByDate) node.getRight()).getRecord().getName()) > 0) {
			return rotateLeft(node);
		}

		if (balance > 1 && name.compareToIgnoreCase(((AVLNodeByDate) node.getLeft()).getRecord().getName()) > 0) {
			node.setLeft(rotateLeft((AVLNodeByDate) node.getLeft()));
			return rotateRight(node);
		}

		if (balance < -1 && name.compareToIgnoreCase(((AVLNodeByDate) node.getRight()).getRecord().getName()) < 0) {
			node.setRight(rotateRight((AVLNodeByDate) node.getRight()));
			return rotateLeft(node);
		}

		return node;
	}

}
