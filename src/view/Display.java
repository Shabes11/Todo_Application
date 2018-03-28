/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TaskController;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Task;

/**
 *
 * @author shoaib
 */
public class Display {

    TaskController tc = new TaskController();
    Scanner sc = new Scanner(System.in);
    int userInput;

    public void mainMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("************* WelCome to the ToDo List *******************");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(">> You have  " + tc.countUnCompletedTask() + "  Tasks to do and  " + tc.countComplectedTasks() + "  Tasks are done ");
        System.out.println(">> Pick an option: ");
        System.out.println(">> (1) Show the task list ");
        System.out.println(">> (2) Add new task ");
        System.out.println(">> (3) Edit a Task ");
        System.out.println(">> (4) Save and quit ");
        System.out.print(">");

    }

    public void userOptions() {

        mainMenu();

        while (true) {

            int userInput1 = readInt();

            switch (userInput1) {
                case 1:
                    option2();
                    break;

                case 2:
                    tc.addNewTask();
                    break;

                case 3:
                    option3();
                    break;

                case 4:
                    //Save n quit
                    break;

                case 9:
                    System.out.println("Thanks See you soon!!!!!");
                    return;

                default:
                    System.out.println("Please enter the correct value or Enter (9) to exit!");

            }

            try {
                Thread.sleep(2000);
                mainMenu();
            } catch (InterruptedException ex) {
                Logger.getLogger(Display.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void option2() {
        System.out.println("~~~~SHOWING print options: Please pick one option below~~~~~~");
        System.out.println(">>(1) Show Tasks By Date ");
        System.out.println(">>(2) Show Tasks By Projet ");

        int option2Input = readInt();

        switch (option2Input) {
            case 1:
                List<Task> result = tc.sortByDate();
                result.stream().forEach(
                        (t -> System.out.println(t)));
                break;

            case 2:
                List<Task> sortResult = tc.sortByProject();
                sortResult.stream().forEach(t -> f(t, sortResult));
                //t -> System.out.println("(" + tc.getIndexOf(t) +  ")"+ t)
                break;

            default:
                System.out.print("Please enter the correct no.");
        }
    }

    void f(Task t, List<Task> tasks) {
        System.out.println("( " + tasks.indexOf(t) + " ) " + t);
    }

    private void option3() {
        System.out.println("~~~~SHOWING Edit Options: Please pick one option below ~~~~~~");
        System.out.println(">>(1) Update a task ");
        System.out.println(">>(2) Mark as done ");
        System.out.println(">>(3) Remove a task ");

        int option3Input = readInt();
        
        switch (option3Input) {
            case 1:
                while (true) {
                    System.out.println("Please enter of task number which you want to edit");
                    int userIndex = readInt();
                    if (tc.getTaskList() != null && userInput < tc.getTaskList().size()) {
                        tc.editTask(userIndex);
                        break;
                    } else {
                        System.out.println("Please enter the correct digit");
                    }
                }
                break;
                
            case 2:
                System.out.println("Please enter of task number which you want to mark as done");
                tc.markAsDone(readInt());
                break;
                
            case 3:
                List<Task> result = tc.sortByDate();
                result.stream().forEach(
                        (t -> System.out.println(t)));
                
                tc.removeTask(readString("Enter the Title of Task you want to Remove"));
        }
    }
    
    /**
     * 
     * @param msg
     * @return 
     */
    int readInt(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a digit ");
                sc.next();
            }
        }
    }

    int readInt() {
        return readInt(null);
    }
    
    /**
     * 
     * @param msg
     * @return 
     */
    String readString(String msg){
        if (msg != null) {
            System.out.println(msg);
        }
        return sc.next();
    }
            


    public static void main(String[] args) {
        Display dp = new Display();
        dp.userOptions();

    }

}
