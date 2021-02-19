package tests.persistence;

import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import ui.Course;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Course c = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyCourse() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCourse.json");
        try {
            Course c = reader.read();
            assertEquals("", c.getName());
            assertEquals(0, c.getCourseDuty().getDutyNum());
            assertEquals(0, c.getTas().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralCourse() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCourse.json");
        try {
            Course c = reader.read();
            assertEquals("cpsc 210", c.getName());
            assertEquals(3, c.getCourseDuty().getDutyNum());
            assertEquals(1, c.getTas().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
