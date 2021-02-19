package tests;

import model.TeachingAssistant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Schedule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeachingAssistantTest {
    private TeachingAssistant ta;
    private Schedule schedule;

    @BeforeEach
    public void runBefore() {
        List<String> p = new ArrayList<>();
        p.add("lab");
        p.add("lecture");
        p.add("tutorial");
        schedule = new Schedule();
        ta = new TeachingAssistant();
        ta.addName("Mike");
        ta.addSchedule(schedule);
        ta.addMaxHour(12);
        ta.addSchedule(schedule);
    }

    @Test
    public void testConstructor() {
        assertEquals("Mike", ta.getName());
        assertEquals(12, ta.getMaxWorkHours());
        assertEquals(schedule, ta.getSchedule());
//        assertEquals(0, ta.getPreferDuty().size());
    }

}
