/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            System.out.println("there is ");
        }
        return s;
    }

}
