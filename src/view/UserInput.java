/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author shoaib
 */
public class UserInput {
       
Scanner sc = new Scanner (System.in); 

public String getInput(){
  return sc.nextLine();
}

}
