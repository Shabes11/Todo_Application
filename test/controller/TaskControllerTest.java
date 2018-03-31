/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.List;
import model.Task;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

/**
 *
 * @author tmp-sda-1178
 */
public class TaskControllerTest {
    
    public TaskControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addNewTask method, of class TaskController.
     */
    @Test
    public void testAddNewTask() {
        System.out.println("addNewTask");
        TaskController instance = new TaskController();
        instance.addNewTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskList method, of class TaskController.
     */
    @Test
    public void testGetTaskList() {
        System.out.println("getTaskList");
        TaskController instance = new TaskController();
        Date d = new Date();
        Task t = new Task("TaskTitle", d, "projectTitle");
        List<Task> expResult = 
        List<Task> result = instance.getTaskList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editTask method, of class TaskController.
     */
    @Test
    public void testEditTask() {
        System.out.println("editTask");
        String searchTitle = "";
        TaskController instance = new TaskController();
        instance.editTask(searchTitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of markAsDone method, of class TaskController.
     */
    @Test
    public void testMarkAsDone() {
        System.out.println("markAsDone");
        String searchTitle = "";
        TaskController instance = new TaskController();
        instance.markAsDone(searchTitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputTaskTitle method, of class TaskController.
     */
    @Test
    public void testGetInputTaskTitle() {
        System.out.println("getInputTaskTitle");
        TaskController instance = new TaskController();
        String expResult = "";
        String result = instance.getInputTaskTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputProjectTitle method, of class TaskController.
     */
    @Test
    public void testGetInputProjectTitle() {
        System.out.println("getInputProjectTitle");
        TaskController instance = new TaskController();
        String expResult = "";
        String result = instance.getInputProjectTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInputDueDate method, of class TaskController.
     */
    @Test
    public void testGetInputDueDate() {
        System.out.println("getInputDueDate");
        TaskController instance = new TaskController();
        Date expResult = null;
        Date result = instance.getInputDueDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterByProject method, of class TaskController.
     */
    @Test
    public void testFilterByProject() {
        System.out.println("filterByProject");
        String projectTitle = "";
        TaskController instance = new TaskController();
        instance.filterByProject(projectTitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filteredByTaskTitle method, of class TaskController.
     */
    @Test
    public void testFilteredByTaskTitle() {
        System.out.println("filteredByTaskTitle");
        String taskTitle = "";
        TaskController instance = new TaskController();
        List<Task> expResult = null;
        List<Task> result = instance.filteredByTaskTitle(taskTitle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompletedTasks method, of class TaskController.
     */
    @Test
    public void testGetCompletedTasks() {
        System.out.println("getCompletedTasks");
        TaskController instance = new TaskController();
        List<Task> expResult = null;
        List<Task> result = instance.getCompletedTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnCompletedTasks method, of class TaskController.
     */
    @Test
    public void testGetUnCompletedTasks() {
        System.out.println("getUnCompletedTasks");
        TaskController instance = new TaskController();
        List<Task> expResult = null;
        List<Task> result = instance.getUnCompletedTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countComplectedTasks method, of class TaskController.
     */
    @Test
    public void testCountComplectedTasks() {
        System.out.println("countComplectedTasks");
        TaskController instance = new TaskController();
        int expResult = 0;
        int result = instance.countComplectedTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countUnCompletedTask method, of class TaskController.
     */
    @Test
    public void testCountUnCompletedTask() {
        System.out.println("countUnCompletedTask");
        TaskController instance = new TaskController();
        int expResult = 0;
        int result = instance.countUnCompletedTask();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByDate method, of class TaskController.
     */
    @Test
    public void testSortByDate() {
        System.out.println("sortByDate");
        TaskController instance = new TaskController();
        List<Task> expResult = null;
        List<Task> result = instance.sortByDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByProject method, of class TaskController.
     */
    @Test
    public void testSortByProject() {
        System.out.println("sortByProject");
        TaskController instance = new TaskController();
        List<Task> expResult = null;
        List<Task> result = instance.sortByProject();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortByTitle method, of class TaskController.
     */
    @Test
    public void testSortByTitle() {
        System.out.println("sortByTitle");
        TaskController instance = new TaskController();
        List<Task> expResult = null;
        List<Task> result = instance.sortByTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeTask method, of class TaskController.
     */
    @Test
    public void testRemoveTask() {
        System.out.println("removeTask");
        String input = "";
        TaskController instance = new TaskController();
        instance.removeTask(input);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeFile method, of class TaskController.
     */
    @Test
    public void testWriteFile() {
        System.out.println("writeFile");
        TaskController instance = new TaskController();
        instance.writeFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readFile method, of class TaskController.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        TaskController instance = new TaskController();
        instance.readFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
