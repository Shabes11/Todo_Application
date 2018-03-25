/*
 * This class is the part of the Todo application. To do application is a simple application that
 *allows user to add, remove and a edit a Task. Application receives input via console.
 *
 * This is a view class which is responsible for taking the user input.
 */
package view;

import controller.TaskController;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author shoaib
 */
public class UserInput {

    Scanner sc;

    public String getInput() {
        sc = new Scanner(System.in);
        String s = "";

        try {
            s = sc.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return s;
    }

}
