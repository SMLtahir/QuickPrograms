package linkedList;

import java.util.ArrayList;
import java.util.List;

public class Link {

	public String bookName;
	public int millionsSold;
	
	public Link next;
	
	//Constructor for Link
	public Link(String bookName, int millionsSold)	{
		this.bookName = bookName;
		this.millionsSold = millionsSold;
		
	}
	
	//Method to display Link
	public void display()	{
		System.out.println(bookName+ ": "+ millionsSold+ ",000,000");
	}
	
	//Get book name of link
	public String toString()	{
		return bookName;
	}
	
	//Main method
	public static void main(String[] args) {

		LinkList theLinkedList = new LinkList();
		
		theLinkedList.insertFirstLink("Don Quixote", 500);
		theLinkedList.insertFirstLink("A Tale of Two Cities", 200);
		theLinkedList.insertFirstLink("The Lord of the Rings", 150);
		theLinkedList.insertFirstLink("Bible", 1000);
		theLinkedList.insertFirstLink("ABC", 1000);
		theLinkedList.insertFirstLink("ML Book", 1000);
		theLinkedList.insertFirstLink("Bible", 1000);
		theLinkedList.insertFirstLink("Bible", 1000);
		
		theLinkedList.display();
		
		theLinkedList.removeDuplicates2();
		System.out.println("\nAfter removing Duplicates...");
		theLinkedList.display();
	}

}

class LinkList {
	
	public Link firstLink;
	
	public LinkList(){
		
		firstLink = null;
		
	}
	
	public boolean isEmpty()	{
		
		return(firstLink == null);
		
	}
	
	public void insertFirstLink(String bookName, int millionsSold)	{
		Link newLink = new Link(bookName, millionsSold);
		newLink.next = firstLink;
		firstLink = newLink;
	}
	
	public Link removeFirstLink()	{
		Link linkReference = firstLink;
		
		if(!this.isEmpty())	{
			firstLink = firstLink.next;	
		}
		else	{
			System.out.println("Empty Linked List");
		}
		
		return linkReference;
	}
	
	public void display()	{
		
		Link theLink = firstLink;
		
		while( theLink != null)	{
			theLink.display();
			
			System.out.println("Next Link: "+ theLink.next+ "\n");
			
			theLink = theLink.next;
		}
		
	}
	
	public Link find(String bookName)	{
		Link theLink = firstLink;
		
		if(!isEmpty())	{
			while(theLink.bookName != bookName)	{
				if(theLink.next == null )	{
					System.out.println("No Link found!");
					return null;
				}
				else	{
					theLink = theLink.next;
				}
			}	
		}
		else	{
			System.out.println("Empty Linked List");
		}
		
		return theLink;
	}
	
	public Link removeLink(String bookName)	{
		
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		
		while(currentLink.bookName != bookName)	{
			
			if(currentLink.next == null)	{
				System.out.println("No Link found!");
				return null;
			}
			else	{
				previousLink = currentLink;
				currentLink = currentLink.next;
			}
		}
		
		if(currentLink == firstLink)	{
			firstLink = firstLink.next;
		}
		else	{
			previousLink.next = currentLink.next;
		}
		
		return currentLink;
	}
	
	//When it is allowed to use a buffer
	public void removeDuplicates()	{
		Link currentLink = firstLink;
		Link previousLink = firstLink;
		ArrayList<String> uniqueNames = new ArrayList<String>();
		
		while(currentLink != null)	{
			if(uniqueNames.contains(currentLink.bookName))	{
				previousLink.next = currentLink.next;
			}
			else	{
				uniqueNames.add(currentLink.bookName);
				previousLink = currentLink;
			}
			currentLink = currentLink.next;
		}
	}
	
	//Without using a buffer
	public void removeDuplicates2()	{
		Link currentLink1 = firstLink;
		if(!isEmpty())	{
			while(currentLink1 != null)	{
				Link previousLink = currentLink1;
				Link currentLink2 = currentLink1.next;
				
				while(currentLink2 != null)	{
					if(currentLink1.bookName == currentLink2.bookName)	{
						previousLink.next = currentLink2.next;
						System.out.println("Duplicate found: "+ currentLink2.bookName);
					}
					else	{
						previousLink = currentLink2;
					}
					currentLink2 = currentLink2.next;
				}
				currentLink1 = currentLink1.next;
			}
		}
		else	{
			return;
		}
	}
}
