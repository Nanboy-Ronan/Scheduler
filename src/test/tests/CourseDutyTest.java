package tests;

import model.CourseComponent;
import model.CourseDuty;
import model.exceptions.NoCourseComponentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CourseDutyTest {
    private CourseDuty courseDuty;

    @BeforeEach
    public void runBefore() {
        courseDuty = new CourseDuty();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, courseDuty.getLectures().size());
        assertEquals(0, courseDuty.getLabs().size());
        assertEquals(0, courseDuty.getTutorials().size());
    }


    @Test
    public void testAddDutyInRange() {
        // add one lab into it
        CourseComponent lab = new CourseComponent();
        lab.addName("lab");
        try {
            courseDuty.addDuty(lab);
        } catch (NoCourseComponentException e) {
            fail();
        }

        // test if added successful
        assertEquals(0, courseDuty.getLectures().size());
        assertEquals(1, courseDuty.getLabs().size());
        assertEquals(0, courseDuty.getTutorials().size());

        // add one lecture into it
        CourseComponent lecture = new CourseComponent();
        lecture.addName("lecture");
        try {
            courseDuty.addDuty(lecture);
        } catch (NoCourseComponentException e) {
            fail();
        }

        // test if added successful
        assertEquals(1, courseDuty.getLectures().size());
        assertEquals(1, courseDuty.getLabs().size());
        assertEquals(0, courseDuty.getTutorials().size());

        // add one tutorial into it
        CourseComponent tutorial = new CourseComponent();
        tutorial.addName("tutorial");
        try {
            courseDuty.addDuty(tutorial);
        } catch (NoCourseComponentException e) {
            fail();
        }

        // test if added successful
        assertEquals(1, courseDuty.getLectures().size());
        assertEquals(1, courseDuty.getLabs().size());
        assertEquals(1, courseDuty.getTutorials().size());
    }


    @Test
    public void testAddDutyBeyondRange() {
        CourseComponent lab = new CourseComponent();
        lab.addName("office hour");
        try {
            courseDuty.addDuty(lab);
            fail();
        } catch (NoCourseComponentException e) {
            // expected
        }
    }
}
