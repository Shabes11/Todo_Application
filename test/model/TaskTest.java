/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shoaib
 */
public class TaskTest {
    
    public TaskTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    
    @Before
    public void setUp() {
        Date d = new Date();
        Task instance = new Task("Hello", d,  "project");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTaskTitle method, of class Task.
     */
    @Test
    public void testGetTaskTitle() {
        Date d = new Date();
        Task instance = new Task("Hello", d,  "project");
        String expResult = "Hello";
        String result = instance.getTaskTitle();
        assertEquals(expResult, result);
       
    }

    

    /**
     * Test of getProjectTitle method, of class Task.
     */
    @Test
    public void testGetProjectTitle() {
        Date d = new Date();
        Task instance = new Task("Hello", d,  "projectTitle");
        String expResult = "projectTitle";
        String result = instance.getProjectTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class Task.
     */
    @Test
    public void testGetStatus() {
        Date d = new Date();
        Task instance = new Task("Hello", d,  "projectTitle");
        boolean expResult = false;
        boolean result = instance.getStatus();
        assertEquals(expResult, result);
    }

  
    
}
