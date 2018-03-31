/*
 * This class is the part of the Todo application. To do application is a simple application that
 *allows user to add, remove and a edit a Task. Application receives input via console.
 *
 * This class contains the list of task objects. and contains the method to filter ,adding and editing a task
 */
package controller;

import integration.FileHandlar;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import model.Task;
import java.util.List;
import java.util.stream.Collectors;
import view.UserInput;

/**
 *
 * @author shoaib
 */
public class TaskController {

    private List<Task> taskList;
    private UserInput userInput;
    FileHandlar fileHandlar;

    public TaskController() {
        taskList = new ArrayList<>();
        userInput = new UserInput();
        fileHandlar = new FileHandlar();

    }

    /**
     * Makes a new task by taking user input and Adds the task to the
     * <code>taskList</code>
     */
    public void addNewTask() {
        String taskTitle = getInputTaskTitle();
        Date dueDate = getInputDueDate();
        String projectTitle = getInputProjectTitle();
        Task t = new Task(taskTitle, dueDate, projectTitle);
        taskList.add(t);
    }

    public List<Task> getTaskList() {
        return taskList;

    }

    /**
     * Edits the Specific Task, Update the task title, project title and the project title inputed by user
     * @param title Title of the task to be edited
     */
    public void editTask(String searchTitle) {
        if (taskList != null) {
            Iterator<Task> it = taskList.iterator();
            boolean isUppdated = false;
            while (it.hasNext()) {
                Task t = it.next();
                if (t.getTaskTitle().equalsIgnoreCase(searchTitle)) {
                    String title = getInputTaskTitle();
                    t.setTitle(title);
                    Date date = getInputDueDate();
                    t.setDueDate(date);
                    String projectTitle = getInputProjectTitle();
                    t.setProjectTitle(projectTitle);
                    isUppdated = true;
                }
            }
            if (isUppdated == false) {
                System.out.println("Item not found!");
            }
        }
    }
  

    /**
     * Marks the specific task as done
     * @param index
     */
    public void markAsDone(String searchTitle) {
        if (taskList != null) {
            Iterator<Task> it = taskList.iterator();
            boolean isUppdated = false;
            while (it.hasNext()) {
                Task t = it.next();
                if (t.getTaskTitle().equalsIgnoreCase(searchTitle)) {
                    t.setStatusDone();
                    isUppdated = true;
                    System.out.println("Task uppdated .......");
                }
            }
            if (isUppdated == false) {
                System.out.println("Item not found!");
            }
        }
    }

    private String getInputMsg(String msg) {
        System.out.println("Please enter " + msg);
        return userInput.getInput();
    }

    /**
     * Gets the task title from the user
     * @return Task title
     */
    public String getInputTaskTitle() {
        return getInputMsg("Task Title");
    }

    /**
     * Gets the project title from the user
     * @return Project title
     */
    public String getInputProjectTitle() {
        return getInputMsg("Project Title ");
    }

    /**
     * Gets the due date from the user and parse it to date formate
     * @return Due date in String formate
     */
    public Date getInputDueDate() {
        Date date = new Date();
        boolean isParsed = false;
        while (isParsed == false) {
            String dateStr = getInputMsg("Due Date in YYYY-MM-DD format");

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = formatter.parse(dateStr);
                isParsed = true;

            } catch (ParseException pe) {
                System.out.print(pe.getMessage());
            }
        }
        return date;
    }

    /**
     * Prints the list of <code> Task </code> filtered by project
     * @param projectTitle to filter the tasks
     */
    public void filterByProject(String projectTitle) {
        taskList.stream()
                .filter(s -> projectTitle.equals(s.getProjectTitle()))
                .forEach(s -> System.out.println(s.toString()));
    }

    /**
     * Prints the list of <code> Task </code> filtered by Title
     * @param taskTitle to filter the task
     * @return List of tasks
     */
    public List<Task> filteredByTaskTitle(String taskTitle) {
        List<Task> result = taskList.stream()
                .filter(t -> taskTitle.equals(t.getTaskTitle()))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * List out the Completed tasks
     * @return List of tasks
     */
    public List<Task> getCompletedTasks() {
        return taskList.stream()
                .filter(t -> t.getStatus() == true)
                .collect(Collectors.toList());
    }

    /**
     * return the list the UnCompleted tasks
     * @return List of tasks
     */
    public List<Task> getUnCompletedTasks() {
        return taskList.stream()
                .filter(t -> t.getStatus() == false)
                .collect(Collectors.toList());

    }

    /**
     * Counts the no of completed task and returns the no. of them
     * @return no of complected tasks
     */
    public int countComplectedTasks() {
        return getCompletedTasks().size();
    }

    /**
     * Counts the no of uncompleted tasks
     * @return no of complected tasks
     */
    public int countUnCompletedTask() {
        return getUnCompletedTasks().size();
    }

    /**
     * Sorts the tasks according to the due date and returns the list
     * @return the sorted array
     */
    public List<Task> sortByDate() {
        return taskList.stream()
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toList());
    }
    
   /**
    * Sorts the task by project and returns the list of sorted tasks
    * @return the list of sorted tasks 
    */
    public List<Task> sortByProject() {
        return taskList.stream()
                .sorted((a, b) -> a.getProjectTitle().compareToIgnoreCase(b.getProjectTitle()))
                .collect(Collectors.toList());
    }
    
    /**
    * Sorts the task by <code> Title </code> and returns the list of sorted tasks
    * @return the list of sorted tasks 
    */
    public List<Task> sortByTitle() {
        return taskList.stream()
                .sorted((a, b) -> a.getTaskTitle().compareToIgnoreCase(b.getTaskTitle()))
                .collect(Collectors.toList());
    }

    /**
     * Removes the task from the list and searched by title
     * @param input the title of the task to be deleted 
     */
    public void removeTask(String input) {
        boolean isFound = false;
        Iterator<Task> it = taskList.iterator();
        while (it.hasNext()) {
            if (it.next().getTaskTitle().equals(input)) {
                it.remove();
                System.out.println("Item Deleted......");
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("Item does not exist");
        }
    }

    /**
     * Writes list to the file
     */
    public void writeFile() {
        fileHandlar.writeFile(taskList);

    }

    /**
     * reads the file from the list
     */
     public void readFile() {
        List<Task> outTaskList = fileHandlar.readFile();
        for (Task t : outTaskList) {
            taskList.add(t);
        }
    }

}
