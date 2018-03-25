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
    
    
    @Before
    public void setUp() {
        
        Task instance = new Task("Hello", "project");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTaskTitle method, of class Task.
     */
    @Test
    public void testGetTaskTitle() {
        Task instance = new Task("Hello", "project");
        String expResult = "Hello";
        String result = instance.getTaskTitle();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getDate method, of class Task.
     */
//    @Test
//    public void testGetDate() {
//        System.out.println("getTit");
//        Task instance = null;
//        Date expResult = null;
//        Date result = instance.getDate();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

  
    
}
