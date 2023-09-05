/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pets;
import java.io.*;
import java.util.*;

/**
 *
 * @author arthu
 */
class myPet {
    private int id = 0;
    private String name = "Hi";
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
    
    public static myPet[] removeArray(myPet[] arr, int index){
        if(arr == null || index < 0 || index > arr.length){
            return arr;
        }
        
        myPet[] newArray = new myPet[30];
        
        for(int i = 0, k = 0; i < arr.length; i++){
            if(i != index){
                newArray[k++] = arr[i];
            }
        }
        
        return newArray;
    }
    
    public static int arrayValueLen(myPet[] arr){
        if(arr == null){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != null){
                res++;
            }else {
                break;
            }
        }
        
        return res;
    }
    
    public static void writeToFile(String name, myPet[] arr){
        if(arr != null){
            try {
                FileWriter myWriter = new FileWriter(name);
                BufferedWriter writer = new BufferedWriter(myWriter);
                for(int i = 0; i < arr.length; i++){
                    myPet pet = arr[i];
                    if(pet != null){
                        writer.write(pet.getId() + " " + pet.getName() + " " + pet.getAge());
                        writer.newLine();
                    }
                }
                writer.close();
                System.out.println("Successfully wrote to the file.");
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
            
        }
    }

    public static void main(String[] args) {
        myPet[] petArray = new myPet[30];
        
        boolean isReady = true;
        
        int arrayAddStop = 0;
        
        //creates file if not exist
         File myObj;
         try {
            myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              Scanner myReader = new Scanner(myObj);
              while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] petInfoSplit = data.split(" ",3);
                int id = Integer.parseInt(petInfoSplit[0]);
                String name = petInfoSplit[1];
                int age = Integer.parseInt(petInfoSplit[2]);
                if(id == (int)id && name.length() > 0 && age == (int)age){
                    myPet pet = new myPet(id,name,age);
                    petArray[id] = pet;
                    arrayAddStop = id;
                }
              }
            }
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
         
         if(arrayAddStop != 0) arrayAddStop++;
         
        
        while(isReady){
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("What would you like to do?");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Update an existing pet");
            System.out.println("4) remove an existing pet");
            System.out.println("5) Search pets by name");
            System.out.println("6) Search pets by age");
            System.out.println("7) Exit program");
            
            System.out.println("Your choice: ");
            int choice = scanner.nextInt();
            
            while (choice < 0 || choice > 7){
                choice = scanner.nextInt();
            }
           
            scanner.nextLine();//clear leftover 
            
            int row = 0;
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
                                row++;
                                System.out.printf("| %d | %s      |%d%n", pet.getId(),pet.getName(),pet.getAge());
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.printf("+--------------------+%n");
                    System.out.println(row + " rows in set ");
                    
                    break;
                case 2:
                    boolean isAdding = true;
                    while(isAdding){
                        System.out.println("add pet (name, age): ");
                        String petInfo = scanner.nextLine();
                        if(petInfo.equals((String)"done")){
                            isAdding = false;
                        }else {
                            if(arrayValueLen(petArray) < 5){
                                String[] petInfoSplit = petInfo.split(" ",2);
                                if(petInfoSplit.length == 2){
                                    String name = petInfoSplit[0];
                                    int age = Integer.parseInt(petInfoSplit[1]);
                                    if(age > 1 && age < 20){
                                        if(name.length() > 0 && age == (int)age){
                                            myPet pet = new myPet(arrayAddStop,name,age);
                                            petArray[arrayAddStop] = pet;
                                            arrayAddStop++;
                                        }
                                    }else {
                                        System.out.println(age + " is not a valid age.");
                                    }
                                }else {
                                    System.out.println("Error: "+ petInfo + " is not a valid input.");
                                }
                            }else {
                                System.out.println("Database is full");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.printf("+--------------------+%n");
                    System.out.printf("| %s | %s      | %s%n", "ID","Name","AGE");
                    System.out.printf("+--------------------+%n");
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                row++;
                                System.out.printf("| %d | %s      |%d%n", pet.getId(),pet.getName(),pet.getAge());
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.printf("+--------------------+%n");
                    System.out.println(row + " rows in set ");
                    
                    System.out.println("Enter the pet ID you can to update: ");
                    myPet savePet = null;
                    int id = scanner.nextInt();
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                if(pet.getId() == (int)id){
                                    savePet = pet;
                                    break;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    
                    if(savePet != null){
                        scanner.nextLine();//clear leftover 
                        System.out.println("Enter new name and new age:");
                        String petInfo = scanner.nextLine();
                        
                        String[] petInfoSplit = petInfo.split(" ",2);
                        if(petInfoSplit.length == 2){
                            String name = petInfoSplit[0];
                            int age = Integer.parseInt(petInfoSplit[1]);
                            if(age > 1 && age < 20){
                                if(name.length() > 0 && age == (int)age){
                                    myPet pet = new myPet(savePet.getId(),name,age);
                                    petArray[id] = pet;

                                    System.out.println(savePet.getName() + " " + savePet.getAge() + " changed to " + name + " " + age);
                                }
                            }else {
                                System.out.println(age + " is not a valid age.");
                            }
                        }else {
                            System.out.println("Error: "+ petInfo + " is not a valid input.");
                        }
                    }
                    break;
                case 4:
                    System.out.printf("+--------------------+%n");
                    System.out.printf("| %s | %s      | %s%n", "ID","Name","AGE");
                    System.out.printf("+--------------------+%n");
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                row++;
                                System.out.printf("| %d | %s      |%d%n", pet.getId(),pet.getName(),pet.getAge());
                            }
                        } else {
                            break;
                        }
                    }
                    System.out.printf("+--------------------+%n");
                    System.out.println(row + " rows in set ");
                    
                    System.out.println("Enter the pet ID to remove");
                    id = scanner.nextInt();
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                if(pet.getId() == (int)id){
                                    petArray = removeArray(petArray, id);
                                    System.out.println(pet.getName() + " " +id + " is removed");
                                }
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter a name to search: ");
                    String name = scanner.nextLine();
                    System.out.printf("+--------------------+%n");
                    System.out.printf("| %s | %s      | %s%n", "ID","Name","AGE");
                    System.out.printf("+--------------------+%n");
                    for (myPet petArray1 : petArray) {
                        if (petArray1 == (myPet) petArray1) {
                            myPet pet = petArray1;
                            if(pet == null){
                                break;
                            }else {
                                if(pet.getName().equals(name)){
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
                case 6:
                    System.out.println("Enter age to search: ");
                    int age = scanner.nextInt();
                    System.out.printf("+--------------------+%n");
                    System.out.printf("| %s | %s      | %s%n", "ID","Name","AGE");
                    System.out.printf("+--------------------+%n");
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
                case 7:
                    System.out.println("Goodbye!");
                    writeToFile("filename.txt",petArray);
                    
                    isReady = false;
                    break;
                default:
                    break;
                    
            }
        }
        
    }
}
