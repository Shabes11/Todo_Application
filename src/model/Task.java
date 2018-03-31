/*
 * This class is the part of the Todo application. To do application is a simple application that
 *allows user to add, remove and a edit a Task. Application receives input via console.
 *
 * This class is provides the Task object that stores information of Task. 
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author shoaib
 */
public class Task implements Serializable {

    private String taskTitle;
    private Date dueDate;
    private String projectTitle;
    private boolean isDone;

    /**
     * Constructor for class Task, Creates the object Task
     *
     * @param Title- Title of the task
     * @param project- Name of the project that task belongs to
     * @param date - the date object that contain the due date of the task
     */
    public Task(String Title, Date date ,String project) {

        this.taskTitle = Title;
        this.dueDate = date;
        this.projectTitle = project;
        this.isDone = false;

    }

    /**
     * Return the <code> Title </code> of the task
     * @return task title
     */
    public String getTaskTitle() {
        return this.taskTitle;
    }

    /**
     * Returns the due date
     * @return due date
     */
    public Date getDate() {
        return this.dueDate;

    }
    

    public String getProjectTitle() {
        return this.projectTitle;
    }

    public boolean getStatus() {
        return this.isDone;

    }

    /**
     * Sets the new value to the Title
     * @param title string title
     */
    public void setTitle(String title) {
        this.taskTitle = title;
    }
    
    /**
     * Sets the new date
     * @param date object date
     */
    public void setDueDate(Date date) {
        this.dueDate = date;
    }

    public void setProjectTitle(String project) {
        projectTitle = project;
    }

    public void setStatusDone() {
        this.isDone = true;
    }

    public void setStatusNotDone() {
        this.isDone = false;

    }
    
    private String printStatus(){
        if(isDone == true){
               return "Task is Complected";
         } else{
        return "Task is Uncomplete";}
    }
    
     String formatOutputDate(){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       String date = simpleDateFormat.format(getDate());
       return date;
     } 

    @Override
    /**
     * Override the String method, representing the string representation of Task object
     * @return the string representation of Task object
     */
    public String toString() {

        return String.format("%-30s%-30s%-20s%20s","Title: "+taskTitle, "DueDate: "
                + formatOutputDate(), "Project: "+projectTitle, " Status:  "+ printStatus());
    }

}
