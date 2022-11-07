/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pets;
import java.util.*;

/**
 *
 * @author arthu
 */
class myPet {
    private int id = 0;
    private String name = "";
    private int age = 0;
    private Date dateCreated = new Date();
    
    public myPet() {
        dateCreated = new Date();
    }
    
    public myPet(int id, String name, int age){
        this();
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateCreated = new Date();
    }
    
    //get and set id
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    //get and set name 
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    //get and set age
    public int getAge(){
        return this.age;
    }
    public void setAge(int age){
        this.age = age;
    }
}

public class Pets {

    public static void main(String[] args) {
        myPet[] petArray = new myPet[50];
        
        boolean isReady = true;
        
        int arrayAddStop = 0;
        
        while(isReady){
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Search pets by name");
            System.out.println("4) Search pets by age");
            System.out.println("5) Exit program");
            
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();
            
            while (choice < 0 || choice > 5){
                choice = scanner.nextInt();
            }
           
            scanner.nextLine();//clear leftover 
            switch(choice){
                case 1:
                    System.out.printf("+--------------------+%n");
                    System.out.printf("| %s | %s      | %s%n", "ID","Name","AGE");
                    System.out.printf("+--------------------+%n");
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                System.out.printf("| %d | %s      |%d%n", pet.getId(),pet.getName(),pet.getAge());
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.printf("+--------------------+%n");
                    
                    break;
                case 2:
                    boolean isAdding = true;
                    while(isAdding){
                        System.out.println("add pet (name, age): ");
                        String petInfo = scanner.nextLine();
                        if(petInfo.equals((String)"done")){
                            isAdding = false;
                        }else {
                            String[] petInfoSplit = petInfo.split(" ",2);
                            String name = petInfoSplit[0];
                            int age = Integer.parseInt(petInfoSplit[1]);
                            if(name.length() > 0 && age == (int)age){
                                myPet pet = new myPet(arrayAddStop,name,age);
                                petArray[arrayAddStop] = pet;
                                arrayAddStop++;
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter a name to search: ");
                    String name = scanner.nextLine();
                    System.out.printf("+--------------------+%n");
                    System.out.printf("| %s | %s      | %s%n", "ID","Name","AGE");
                    System.out.printf("+--------------------+%n");
                    int rows = 0;
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                if(pet.getName().equals(name)){
                                    rows++;
                                    System.out.printf("| %d | %s      |%d%n", pet.getId(),pet.getName(),pet.getAge());
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.printf("+--------------------+%n");
                    
                    System.out.println(rows + " rows in set ");
                    break;
                case 4:
                    System.out.println("Enter age to search: ");
                    int age = scanner.nextInt();
                    System.out.printf("+--------------------+%n");
                    System.out.printf("| %s | %s      | %s%n", "ID","Name","AGE");
                    System.out.printf("+--------------------+%n");
                    int row = 0;
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                if(pet.getAge() == (int)age){
                                    row++;
                                    System.out.printf("| %d | %s      |%d%n", pet.getId(),pet.getName(),pet.getAge());
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.printf("+--------------------+%n");
                    
                    System.out.println(row + " rows in set ");
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    isReady = false;
                    break;
                default:
                    break;
                    
            }
        }
        
    }
}
