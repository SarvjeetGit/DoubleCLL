import java.io.*;
public class DoubleCLL
{
	Node head;
	Node tail;
	int size=1;
	static class Node
	{
		int data;
		Node next;
		Node prev;
		Node(int d)
		{
			data=d;
			prev=null;
			next=null;
		}
	}
	public static void insert(DoubleCLL list,int d)
	{
		Node newNode= new Node(d);
		if(list.head==null)
		{
			newNode.next=newNode;
			newNode.prev=newNode;
			list.head=newNode;
			list.tail=newNode;
		}
		else
		{
			newNode.prev=list.tail;
			newNode.next=list.head;
			list.tail.next=newNode;
			list.head.prev=newNode;
			list.size++;
		}
		list.tail=newNode;
		list.tail.next=list.head;
	}
	public static void print(DoubleCLL list)
	{
		Node currNode = list.head;
		System.out.print("LINKED LIST:");
		do
		{
			System.out.print(currNode.data+" ");
			currNode=currNode.next;
		}
		while(currNode!=list.head);
	}
	public static void add(DoubleCLL list,int index,int data)
	{
		Node newNode=new Node(data);
		Node currNode=list.head;
		for(int i=0;i<index;i++)
		{
			currNode=currNode.next;
		}
		newNode.prev=currNode;
		newNode.next=currNode.next;
		currNode.next.prev=newNode;
		currNode.next=newNode;
		list.size++;
		
	}
	
	public static void printRev(DoubleCLL list)
	{
		Node currNode = list.tail;
		System.out.print("LINKED LIST:");
		do
		{
			System.out.print(currNode.data+" ");
			currNode=currNode.prev;
		}
		while(currNode!=list.tail);
	}
	public static void main(String[] args)
	{
		DoubleCLL list =new DoubleCLL();
		int i=1;
		for(i=1;i<=5;i++)
		{
			insert(list,i);
		}
		print(list);
		System.out.println();
		printRev(list);
		add(list,8,50);
		System.out.println();
		print(list);
		System.out.println("Size="+list.size);
	}
}
