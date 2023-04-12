package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job a=new Job();
        Job b=new Job();
        assertNotEquals(a.getId(),b.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(test.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", test.getCoreCompetency().getValue());
        assertTrue(test.getPositionType() instanceof PositionType);
        assertEquals("Quality control", test.getPositionType().getValue());
        assertTrue(test.getLocation() instanceof Location);
        assertEquals("Desert", test.getLocation().getValue());
        assertTrue(test.getEmployer() instanceof Employer);
        assertEquals("ACME", test.getEmployer().getValue());
        assertTrue(test instanceof Job);
        assertEquals("Product tester", test.getName());

    }

    @Test
    public void testJobsForEquality(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(test.equals(test2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', test.toString().charAt(0));
        assertEquals('\n', test.toString().charAt(test.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(
                "\nID: " + test.getId() +"\n" +
                        "Name: " + test.getName() + "\n" +
                        "Employer: " + test.getEmployer() + "\n"+
                        "Location: " + test.getLocation() + "\n"+
                        "Position Type: " + test.getPositionType() + "\n"+
                        "Core Competency: " + test.getCoreCompetency() +"\n",
                test.toString()

        );
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job test = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(
                "\nID: " + test.getId() +"\n" +
                        "Name: " + test.getName() + "\n" +
                        "Employer: Data not available\n"+
                        "Location: " + test.getLocation() + "\n"+
                        "Position Type: " + test.getPositionType() + "\n"+
                        "Core Competency: " + test.getCoreCompetency() +"\n",
                test.toString()

        );
    }

    @Test
    public void testBonus(){
        Job test = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("OOPS! This job does not seem to exist.", test.toString());
    }
}
