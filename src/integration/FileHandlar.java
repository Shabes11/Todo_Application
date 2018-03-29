/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

import controller.TaskController;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author tmp-sda-1178
 */
public class FileHandlar {


   public void writeFile(List<Task> taskList) {

        try {
             
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("task.txt"));
            for (Task t : taskList) {
                outStream.writeObject(t);
            }
            outStream.close();
        }
         catch(FileNotFoundException ef){
             System.out.print(ef.getMessage() + "File not found");
         }
        catch(IOException e){
            System.out.print(e.getMessage());
        }

    }
   
    public List<Task> readFile() {
        
        List<Task> inputList = new ArrayList();

        try {
            ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("task.txt"));
            Object record = inStream.readObject();
            Task t = (Task) record;
            while(record != null){
                inputList.add(t);
                t = (Task) inStream.readObject();
                
            }
            
            inStream.close();

        } catch (FileNotFoundException ef) {
            System.out.print(ef.getMessage() + "File not found");
        } catch (IOException e) {
            System.out.print(e.getMessage());
        } catch(ClassNotFoundException e ){
            System.out.print(e.getMessage()+ "class not found");
        }
        
        return inputList;
    }

}
