package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.*;
class FileOperations{
	static File f = null;
	static Scanner sc = null;
	static {
		 f = new File("C:\\Users\\anjan\\eclipse-workspace\\_My Programs\\Projects\\1_LockedMe\\");
		sc = new Scanner(System.in);
	}

	static void displayAscending() {
		List<String> file_name = new ArrayList<String>();
		
		
		String[] s = f.list();
		int cnt = 0;
		int count = 0;
		for(String s1:s) {
			File f1 = new File(f,s1);
			if(f1.isFile()) {
				count++;
			}	
		}
		String []temp = new String[count];
		for(String s1:s) {
			File f1=new File(f,s1);
			if(f1.isFile()) {
				
				temp[cnt++] = s1;
			}	
		}
		for(int i = 0; i<temp.length-1; i++) {
			for(int j=i+1; j<temp.length; j++) {
				if(temp[i].toLowerCase().charAt(0)>temp[j].toLowerCase().charAt(0)) {
					String a = temp[i];
					temp[i] = temp[j];
					temp[j] = a;
				}
			}
		}
		Collections.addAll(file_name, temp);
		//Collections.sort(file_name);
		Iterator i = file_name.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		
	}
	
	// FILE ADD -----
	static void addingNewFile() {
		System.out.println("\n< Add New File Selected >");
		System.out.print("Enter file name (eg: abc.txt) : ");
		String name = null;
		try {
		name = sc.next();
		}catch(InputMismatchException e) {
			System.out.println("Invalid input!! Please try again.");
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		name="C:\\Users\\anjan\\eclipse-workspace\\_My Programs\\Projects\\1_LockedMe\\"+name;
		File newFile=new File(name);
		
			Boolean b = null;
			try {
				b = newFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(b == false) {
				System.out.println("File already exists !!!\n");
			}else {
				System.out.println("File Created Succesfully !!!\n");
			}
		}
	// -----x
	
	// FILE DELETE -----
	static void deletingFile() throws FileNotFoundException, IOException {
		System.out.println("\n< Delete File Selected >");
		System.out.print("Enter file name : ");
		String name = sc.next();
		name = "C:\\Users\\anjan\\eclipse-workspace\\_My Programs\\Projects\\1_LockedMe\\"+name;
		File newFile=new File(name);
		
			Boolean bool  = null;
			bool = newFile.delete();
			if(bool == true) {
				System.out.println("Your File has been Deleted Successfully !!!\n");
			}else {
				throw new FileNotFoundException();
			}
	}
	// -----x
	
	// FILE SEARCH -----
	static void searchFileName() {
		List<String> file_name = new ArrayList<String>();
		System.out.println("\n< Search for File Selected >");
		System.out.print("Enter file name : ");
		String name = sc.next();
		String[] s = f.list();
		int cnt = 0;
		int count = 0;
		for(String s1:s) {
			File f1 = new File(f,s1);
			if(f1.isFile()) {
				if(s1.equals(name)){
					System.out.println(name + " File found succesfully !!\n ");
					return;
				}
			}else {
				System.out.println(name + " File not found !\n");
			}
		} 
	}
	// -----x
}


// MAIN MENU ----------------------
public class UI_HomePage extends FileOperations{
	static Scanner sc=new Scanner(System.in);
	private static void userDetails() {
		System.out.println("\n<< Welcome to LockedMe.com >>\n\n");
		System.out.println(".....................................................\nDeveloper Details\n==================");
		System.out.println("Name    : Anjana Jayan Kizhiyapat");
		System.out.println("Project : LockedMe.com");
		System.out.println("Feel free to contact me at anjanajayan1232@gmail.com\n.....................................................\n");
		
	}
	 static void option2() {
		 int ch = 0;
	
	// file operations
	 breakMe: while(true) {
		System.out.println("[1] Add a new file"); 
		System.out.println("[2] Delete a file"); 
		System.out.println("[3] Search a file"); 
		System.out.println("[4] Back to Main Menu"); 
		boolean flag = true;
			while(flag) try {
					System.out.print("Enter your choice : ");
					ch = sc.nextInt();
					flag = false;
			}
			catch(InputMismatchException e){
				System.out.println("Enter the correct input !! Try again.");
				
				sc.nextLine();
			}
			switch(ch) {
				case 1:
						addingNewFile();
					break;
				case 2:
						try{deletingFile();}
						catch(FileNotFoundException e) {
							System.out.println("File Not Found with this name");
						}
						catch(IOException e) {
							e.printStackTrace();
						}
					break;
				case 3:
					searchFileName();
					break;
				case 4:
					System.out.println("****************************************");
					break breakMe;
				default:
					System.out.println("Wrong input , given try again !!!");
			}//try
		}// while close
	}
	public static void main(String[] args) {
			int ch=0;
			
			UI_HomePage.userDetails();
			while(true) {
			System.out.println("____________\n\nMain Menu \n____________\n");
			System.out.println("[1] Display file names (ascending order)");
			System.out.println("[2] Add/Delete/Search files");
			System.out.println("[3] Exit");
			System.out.println();
			
			boolean flag=true;
	
		
			while(flag) try {
				System.out.print("Enter your choice : ");
				ch = sc.nextInt();
				flag = false;
		}
		catch(InputMismatchException e){
			System.out.println("*** Invalid Input !! Please Try Again. ***");
			
			sc.nextLine();
		}
	
			switch(ch) {
				case 1:
					displayAscending();
					break;
				case 2:
					UI_HomePage.option2();
					break;
				case 3:
					System.out.println(".....Thank you for using LockedMe.....\n");
					System.out.println("exiting....");
					System.out.println("See you soon!\n-----x-----");
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input , given try again !!!");
			}
	
		}
	}

}
