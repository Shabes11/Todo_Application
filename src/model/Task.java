/*
 * This class is the part of the Todo application. To do application is a simple application that
 *allows user to add, remove and a edit a Task. Application receives input via console.
 *
 * This class is provides the Task object that stores information of Task. 
 */
package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author shoaib
 */
public class Task {

    private String taskTitle;
    private Date dueDate;
    private String project;
    private boolean isDone;

    /**
     * Constructor for class Task, Creates the object Task
     *
     * @param Title- Title of the task
     * @param project- Name of the project that task belongs to
     * @param date - the date object that contain the due date of the task
     */
    public Task(String Title, Date date, String project) {

        this.taskTitle = Title;
        this.dueDate = date;
        this.project = project;
        this.isDone = false;

    }

    /**
     * Get method to get the Task title
     *
     * @return task title
     */
    public String getTaskTitle() {
        return this.taskTitle;
    }

    /**
     * Get method to get the due date of the Task
     *
     * @return Due date
     */
    public Date getDate() {
        return this.dueDate;

    }

    public String getProject() {
        return this.project;
    }

    public boolean getStatus() {
        return this.isDone;

    }

    /**
     * Setters
     */
    public void setTitle(String title) {
        this.taskTitle = title;
    }

    public void setDueDate(Date date) {
        this.dueDate = date;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setStatusDone() {
        this.isDone = true;
    }

    public void setStatusNotDone() {
        this.isDone = false;

    }

    @Override
    /**
     * Override the String method, representing the string representation of Task object
     * @return the string representation of Task object
     */
    public String toString() {

        return "Title: " + taskTitle + ",   " + "DueDate: "
                + dueDate + ",   " + "Project: " + project;
    }

}
