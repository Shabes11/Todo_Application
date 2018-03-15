/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Task;
import java.util.List;
import view.UserInput;

/**
 *
 * @author shoaib
 */
public class TaskController {
    
    private List<Task> taskList;
    
    
    public TaskController(){
        taskList  = new ArrayList <>();
        
    }
    
  
    public boolean addTask(Task t){
        //Task t = new Task();
       taskList.add(t);
       return true;
      
   }
   
   public Task getTask(int index){ 
       
      return this.taskList.get(index);
   
   }
   
   public void removeTask(int i){
      this.taskList.remove(i);
     }
   
     public void editTask(int index, String title, String projectTitle){
      Task t = this.taskList.get(index);
      
      String name = getInput();
      t.setTitle(title);
      //t.setDueDate(LocalDate.MAX);
      t.setProject(projectTitle);
   }
   
   public void markAsDone(int index){
       this.taskList.get(index).setStatusDone();
   
    }
    
   
   public static void main(String[] args){
    
       TaskController tc = new TaskController();
       int i = 0;
       while (i<=5){
       tc.addTask(new Task("Do home work", "Home work")); 
       i++;
       }
       
       tc.editTask(2, "new Title is", "new project");
       
       for(Task t : tc.taskList){
           
           System.out.println(t);
       }
    

    
    
    }

    private String getInput() {
        System.out.println("Please enter input");
       String name = UserInput.getInput();
        return (name);
    }
    
}
