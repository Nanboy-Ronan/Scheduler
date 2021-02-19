package tests.persistence;

import model.CourseComponent;
import model.TeachingAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.Course;
import ui.Schedule;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    Course c;

    @BeforeEach
    public void runBefore() {
        c = new Course();
    }


    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyCourse() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCourse.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCourse.json");
            c = reader.read();
            assertEquals("", c.getName());
            assertEquals(0, c.getCourseDuty().getDutyNum());
            assertEquals(0, c.getTas().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralCourse() {
        // construct some basic elements of the course
        CourseComponent lecture = new CourseComponent();
        lecture.addName("lecture");
        lecture.addSection("101");
        CourseComponent tutorial = new CourseComponent();
        tutorial.addName("tutorial");
        tutorial.addSection("T1A");
        CourseComponent lab = new CourseComponent();
        lab.addName("lab");
        lab.addSection("L1A");
        TeachingAssistant ta = new TeachingAssistant();
        ta.addName("Mike");
        ta.addMaxHour(12);
        ta.addSchedule(new Schedule());

        try {
            c.addName("cpsc 210");
            c.addDuty(lecture);
            c.addDuty(tutorial);
            c.addDuty(lab);
            c.addTA(ta);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCourse.json");
            writer.open();
            writer.write(c);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCourse.json");
            c = reader.read();
            assertEquals("cpsc 210", c.getName());
            assertEquals(3, c.getCourseDuty().getDutyNum());
            assertEquals(1, c.getTas().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
