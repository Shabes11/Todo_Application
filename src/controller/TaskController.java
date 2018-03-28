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

    public TaskController() {
        taskList = new ArrayList<>();
        userInput = new UserInput();

        // TO BE REMOVED
        // ONLY FOR TESTING
        TestControllerMockup();

    }

    // TO BE REMOVED 
    // ONLY FOR TESTING
    void TestControllerMockup() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = formatter.parse("2018-03-04");
            Date d2 = formatter.parse("2018-03-04");
            Task t1 = new Task("Title1", d1, "P1");
            Task t2 = new Task("Title2", d2, "P2");
            taskList.add(t1);
            taskList.add(t2);
        } catch (Exception e) { // 
        }
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

    public Task getTask(int index) {
        return taskList.get(index);

    }

//    public void removeTask(int i) {
//        boolean run = true;
//        while (run) {
//            if (i < taskList.size() && taskList != null) {
//                taskList.remove(i);
//                run = false;
//            } else {
//                throw new ArrayIndexOutOfBoundsException("No should be between limits");
//            }
//        }
//    }
//    public void removeTask(int i) {
//            taskList.remove(i);
//        }
    /**
     * Edits the Specific Task
     *
     * @param index No. of task to be edited
     */
    public void editTask(int index) {
        if (taskList != null && index < taskList.size()) {
            Task t = getTask(index);
            String newTaskTitle = getInputTaskTitle();
            t.setTitle(newTaskTitle);

            String newProjectTitle = getInputProjectTitle();
            t.setProjectTitle(newProjectTitle);

            Date dueDate = getInputDueDate();
            t.setDueDate(dueDate);
        } else {
            System.out.println("Please enter the correct digit");
        }
    }

    /**
     * Marks the specific task as done
     *
     * @param index
     */
    public void markAsDone(int index) {
        this.taskList.get(index).setStatusDone();
    }

    private String getInputMsg(String msg) {
        System.out.println("Please enter " + msg);
        return userInput.getInput();
    }

    /**
     * Gets the task title from the user
     *
     * @return Task title
     */
    public String getInputTaskTitle() {
        return getInputMsg("Task Title");
    }

    /**
     * Gets the project title from the user
     *
     * @return Project title
     */
    public String getInputProjectTitle() {
        return getInputMsg("Project Title ");
    }

    /**
     * Gets the due date from the user
     *
     * @return Due date
     */
    public Date getInputDueDate() {
        Date date = new Date();
        boolean userInput = false;
        while (userInput == false) {
            String dateStr = getInputMsg("Due Date in YYYY-MM-DD format");

            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = formatter.parse(dateStr);
                userInput = true;

            } catch (ParseException pe) {
                System.out.print(pe.getMessage());
            }
        }
        return date;
    }

    /**
     * Prints the list of Tasks
     */
    public void printTaskList() {
        taskList.forEach(Task -> System.out.println(Task.toString()));

    }

    /**
     * Prints the list of <code> Task </code> filtered by project
     *
     * @param projectTitle to filter the tasks
     */
    public void filterByProject(String projectTitle) {
        taskList.stream()
                .filter(s -> projectTitle.equals(s.getProjectTitle()))
                .forEach(s -> System.out.println(s.toString()));
    }

    /**
     * Prints the list of <code> Task </code> filtered by Title
     *
     * @param Title to filter the task
     */
    public List<Task> filteredByTaskTitle(String taskTitle) {
        List<Task> result = taskList.stream()
                .filter(t -> taskTitle.equals(t.getTaskTitle()))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * List out the Completed tasks
     *
     * @return List of tasks
     */
    public List<Task> getCompletedTasks() {
        return taskList.stream()
                .filter(t -> t.getStatus() == true)
                .collect(Collectors.toList());
    }

    /**
     * List out the UnCompleted tasks
     *
     * @return List of tasks
     */
    public List<Task> getUnCompletedTasks() {
        return taskList.stream()
                .filter(t -> t.getStatus() == false)
                .collect(Collectors.toList());

    }

    /**
     * Counts the no of completed tasks
     *
     * @return no of complected tasks
     */
    public int countComplectedTasks() {
        return getCompletedTasks().size();
    }

    /**
     * Counts the no of uncompleted tasks
     *
     * @return no of complected tasks
     */
    public int countUnCompletedTask() {
        return getUnCompletedTasks().size();
    }

    /**
     * Sorts the tasks according to the due date
     * @return the sorted array
     */
    
    public List<Task> sortByDate() {
        return taskList.stream()
                .sorted(Comparator.comparing(Task::getDate))
                .collect(Collectors.toList());
    }

    public List<Task> sortByProject() {
        return taskList.stream()
                .sorted((a, b) -> a.getProjectTitle().compareToIgnoreCase(b.getProjectTitle()))
                .collect(Collectors.toList());
    }

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
        if(!isFound){
        System.out.println("Item does not exist");}
    }

}
