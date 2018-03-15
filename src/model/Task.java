/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


/**
 *
 * @author shoaib
 */
public class Task {
    
    private String taskTitle;
    private LocalDate dueDate;
    private String project;
    private boolean isDone;
    
   /** 
    * Constructor for class Task
    * @param Title- Title of the task
    * @param project- Name of the project that task belongs to
    */
    
  public Task(String Title, String project){
      
      this.taskTitle = Title;
      this.dueDate = LocalDate.now();
      this.project = project;
      this.isDone = false;
  
  }  
  
    /**
     * Get method to get the Task title
     * @return task title
     */
    public String getTaskTitle(){
        return this.taskTitle;
    }
   
    /**
     * Get method to get the due date of the Task
     * @return Due date
     */
    public LocalDate getDate(){
        return this.dueDate;
    
    }
    
    public String getProject(){
        return this.project;
    }
    
    public boolean getStatus(){
        return this.isDone;
    
    }
    
    /**
     * Setters
     */
    
    
   public void setTitle(String title){
    this.taskTitle = title;
   }
   
   public void setDueDate(LocalDate date){
    this.dueDate = date;
   }
    
   public void setProject(String project){
    this.project= project;
   }
   
   public void setStatusDone(){
       this.isDone = true;
   }
   
   
   public void setStatusNotDone(){
       this.isDone = false;
   
   }
   
   
    @Override
    
   public String toString(){

        return "Title: "+ taskTitle +  ",   "  + "DueDate: " 
                + dueDate +  ",   " +  "Project: " + project;
   }
   
   
   public static void main(String[] args){
   
       Task t = new Task("landury", "hello" );
       System.out.println(t.toString());
   
   }
}
