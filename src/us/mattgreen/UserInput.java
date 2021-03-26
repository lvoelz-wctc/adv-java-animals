package us.mattgreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private ArrayList<Talkable> zoo;

    public UserInput(ArrayList<Talkable> zoo) {
        this.zoo = zoo;
    }

    public String getInput() throws Exception {
        ArrayList<String> animalOptions = new ArrayList<String>();
        animalOptions.add("dog");
        animalOptions.add("cat");
        animalOptions.add("teacher");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What animal do you want to add? Enter dog, cat, or teacher.");

        String userInput = scanner.nextLine();

        if (!animalOptions.contains(userInput)){
            throw new Exception("Must enter dog, cat, or teacher");
        }
        else {
            return userInput;
        }
    }

    public Talkable buildDog() throws Exception {
        Scanner scanner = new Scanner(System.in);
            boolean isFriendly = false;
            System.out.println("What is the dog's name?");
            String dogName = scanner.nextLine();
            System.out.println("Is the dog friendly? Y/N");
            if (!scanner.nextLine().equals("Y") && !scanner.nextLine().equals("N")) {
                throw new Exception("Must enter Y or N");
            }
            else if (scanner.nextLine().equals("Y")){
                isFriendly = true;
            }
            else if (scanner.nextLine().equals("N")) {
                isFriendly = false;
            }
            Dog d = new Dog(isFriendly, dogName);
            return d;
        }

    public Talkable buildCat(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the cat's name?");
        String catName = scanner.nextLine();

        System.out.println("How many mice did the cat kill?");
        int mouseKilled = Integer.parseInt(scanner.nextLine());

        Cat c = new Cat(mouseKilled, catName);
        return c;
    }

    public Talkable buildTeacher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How old is the teacher?");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("What is the teacher's name?");
        String teacherName = scanner.nextLine();

        Teacher t = new Teacher(age, teacherName);
        return t;
        }

    public void addAnimal(String animal) throws Exception {
        if (animal.equals("dog")){
            zoo.add(buildDog());
        }
        else if (animal.equals("cat")){
            zoo.add(buildCat());
        }
        else if (animal.equals("teacher")){
            zoo.add(buildTeacher());
        }
    }
}
