package tests;

import model.CourseComponent;
import model.TeachingAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Schedule;
import ui.TimeSlot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CourseComponentTest {
    private CourseComponent courseComponent;


    @BeforeEach
    public void runBefore() {
        courseComponent = new CourseComponent();
    }

    @Test
    public void testConstructor() {
        assertNull(courseComponent.getName());
        assertNull(courseComponent.getSection());
        assertEquals(0, courseComponent.getNumTA());
        assertEquals(0, courseComponent.getTAs().size());
    }

    @Test
    public void testAddName() {
        courseComponent.addName("lecture");
        assertEquals("lecture", courseComponent.getName());
    }

    @Test
    public void testAddSection() {
        courseComponent.addSection("101");
        assertEquals("101", courseComponent.getSection());
    }

    @Test
    public void testAddSchedule() {
        Schedule schedule = new Schedule();
        TimeSlot timeSlot = new TimeSlot();
        schedule.addMonday(timeSlot);
        courseComponent.addSchedule(schedule);
        assertEquals(timeSlot, courseComponent.getSchedule().getMonday());
    }

    @Test
    public void testAddNumTA() {
        courseComponent.addNumTA(3);
        assertEquals(3, courseComponent.getNumTA());
    }

    @Test
    public void testAddTA() {
        TeachingAssistant ta = new TeachingAssistant();
        courseComponent.addTA(ta);
        assertEquals(1, courseComponent.getTAs().size());
    }
}