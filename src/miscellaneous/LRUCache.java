package miscellaneous;

import java.util.HashMap;

public class LRUCache {

	private int capacity;
	private int len;
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	
	//Constructor
	public LRUCache(int capacity)	{
		this.capacity = capacity;
		this.len = 0;
	}
	
	// Get value if key exists
	public int get(int key)	{
		if(map.containsKey(key))	{
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.value;
		}
		else	{
			return -1;
		}
	}
	
	// Change value if key exists, insert new node if it doesn't exist. Watch out for capacity limits.
	public void set(int key, int value)	{
		if(map.containsKey(key))	{
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.value = value;
			removeNode(oldNode);
			setHead(oldNode);
		}
		else	{
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
			
			if(len < capacity)	{
				setHead(newNode);
				map.put(key, newNode);
				len++;
			}
			else	{
				map.remove(end.key);
				end = end.pre;
				
				if(end != null)
					end.post = null;

				setHead(newNode);
				map.put(key, newNode);
			}
			
			
		}
	}
	
	/**
	 * Removes node from cache
	 * @param node
	 */
	public void removeNode(DoubleLinkedListNode node)	{
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.post;
		if(pre != null)	{
			pre.post = post;
		}
		else	{
			head = post;
		}
		
		if(post != null)	{
			post.pre = pre;
		}
		else
			end = pre;
	}
	
	/**
	 * Sets node as head node of DoubleLinkedList
	 * @param node
	 */
	public void setHead(DoubleLinkedListNode node)	{
		node.post = head;
		node.pre = null;
		
		if(head != null)
			head.pre = node;
		
		head = node;
		if(end == null)
			end = node;
	}
}

class DoubleLinkedListNode	{
	
	public int key;
	public int value;
	public DoubleLinkedListNode pre;
	public DoubleLinkedListNode post;
	
	//Constructor
	public DoubleLinkedListNode(int key, int value)	{
		this.key = key;
		this.value = value;
	}
}
