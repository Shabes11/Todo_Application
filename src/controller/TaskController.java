/*
 * This class is the part of the Todo application. To do application is a simple application that
 *allows user to add, remove and a edit a Task. Application receives input via console.
 *
 * This class contains the list of task objects. and contains the method to filter ,adding and editing a task
 */
package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import model.Task;
import java.util.List;
import view.UserInput;

/**
 *
 * @author shoaib
 */
public class TaskController {

    private List<Task> taskList;
    private UserInput userInput;

    public TaskController() {
        taskList = new ArrayList<>();
        userInput = new UserInput();

    }

    /**
     * Makes a new task by taking user input and Adds the task to the
     * <code>taskList</code>
     */
    public void AddnewTask() {
        String taskTitle = getInputTaskTitle();
        Date dueDate = getInputDueDate();
        String projectTitle = getInputProjectTitle();
        Task t = new Task(taskTitle, dueDate, projectTitle);
        taskList.add(t);

    }

    public Task getTask(int index) {
        return this.taskList.get(index);

    }

    public void removeTask(int i) {
        this.taskList.remove(i);
    }

    /**
     * Edits the Specific Task
     *
     * @param index No. of task to be edited
     * @param taskTitle The new Task title
     * @param projectTitle The new project title
     */
    
    public void editTask(int index, String taskTitle, String projectTitle) {
        Task t = this.taskList.get(index);

        taskTitle = getInputTaskTitle();
        t.setTitle(taskTitle);

        projectTitle = getInputProjectTitle();
        t.getProject();
        t.setProject(projectTitle);
    }

    /**
     * Marks the specific task as done
     *
     * @param index
     */
    public void markAsDone(int index) {
        this.taskList.get(index).setStatusDone();

    }

    private String getInput2(String msg) {
        System.out.println("Please enter input " + msg);
        return userInput.getInput();

    }

    /**
     * Gets the task title from the user
     *
     * @return Task title
     */
    public String getInputTaskTitle() {
        return getInput2("Task Title");

    }

    /**
     * Gets the project title from the user
     *
     * @return Project title
     */
    public String getInputProjectTitle() {
        return getInput2("Project Title ");
    }

    /**
     * Gets the due date from the user
     *
     * @return Due date
     */
    public Date getInputDueDate() {
        String dateStr = getInput2("Due Date");
        Date date = new Date();

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
            date = formatter.parse(dateStr);

        } catch (ParseException pe) {
            System.out.print(pe.getMessage());
        }
        return date;
    }

}
