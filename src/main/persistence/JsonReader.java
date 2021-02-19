package persistence;

import model.CourseComponent;
import model.TeachingAssistant;
import org.json.JSONArray;
import org.json.JSONObject;
import ui.Course;
import ui.Schedule;
import ui.TimeSlot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads Course from JSON data stored in file (reference:
// some of the method are from JsonSerializationDemo)
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Course read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseCourse(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    // MODIFIES: c
    // EFFECTS: parses course from JSON object and returns it
    private Course parseCourse(JSONObject jsonObject) {
        String name = jsonObject.getString("course");
        JSONObject courseDuty = jsonObject.getJSONObject("courseDuty");
        Course c = new Course();
        c.addName(name);
        addDuties(c, courseDuty);
        addTAs(c, jsonObject);
        return c;
    }


    // MODIFIES: c
    // EFFECTS: parses TAs from JSON object and add them to course
    private void addTAs(Course c, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("TA");
        for (Object json : jsonArray) {
            JSONObject nextTA = (JSONObject) json;
            addTA(c, nextTA);
        }
    }


    // MODIFIES: c
    // EFFECTS: parses Duties from JSON object and add them to the course
    private void addDuties(Course c, JSONObject jsonObject) {
        JSONArray lecture = jsonObject.getJSONArray("lectures");
        JSONArray tutorial = jsonObject.getJSONArray("tutorials");
        JSONArray lab = jsonObject.getJSONArray("labs");

        for (Object json : lecture) {
            JSONObject l = (JSONObject) json;
            addCourseComponent(c, l);
        }

        for (Object json : tutorial) {
            JSONObject t = (JSONObject) json;
            addCourseComponent(c, t);
        }

        for (Object json : lab) {
            JSONObject l = (JSONObject) json;
            addCourseComponent(c, l);
        }
    }


    // MODIFIES: c
    //EFFECTS: parses course component from Json and adds it to the course
    private void addCourseComponent(Course c, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String section = jsonObject.getString("section");
        int numTA = jsonObject.getInt("numTA");
        Schedule schedule = parseSchedule(jsonObject);

        CourseComponent courseComponent = new CourseComponent();
        courseComponent.addName(name);
        courseComponent.addSection(section);
        courseComponent.addSchedule(schedule);
        courseComponent.addNumTA(numTA);
        c.addDuty(courseComponent);

    }


    // MODIFIES: c
    // EFFECTS: parses TA from JSON object and adds it to course
    private void addTA(Course c, JSONObject jsonObject) {
        int max = jsonObject.getInt("Max Working Time");
        String name = jsonObject.getString("name");
        Schedule schedule = parseSchedule(jsonObject);


        TeachingAssistant ta = new TeachingAssistant();
        ta.addName(name);
        ta.addMaxHour(max);
        ta.addSchedule(schedule);
        c.addTA(ta);
    }


    // EFFECTS: parses schedule from JSON object
    private Schedule parseSchedule(JSONObject jsonObject) {
        Schedule schedule = new Schedule();

        JSONObject savedSchedule = jsonObject.getJSONObject("schedule");
        TimeSlot monday = parseTimeSlot(savedSchedule.getJSONObject("monday"));
        TimeSlot tuesday = parseTimeSlot(savedSchedule.getJSONObject("tuesday"));
        TimeSlot wednesday = parseTimeSlot(savedSchedule.getJSONObject("wednesday"));
        TimeSlot thursday = parseTimeSlot(savedSchedule.getJSONObject("thursday"));
        TimeSlot friday = parseTimeSlot(savedSchedule.getJSONObject("friday"));

        schedule.addMonday(monday);
        schedule.addTuesday(tuesday);
        schedule.addWednesday(wednesday);
        schedule.addThursday(thursday);
        schedule.addFriday(friday);

        return schedule;

    }


    // EFFECTS: parses timeslots from JSON object
    private TimeSlot parseTimeSlot(JSONObject jsonObject) {
        TimeSlot timeSlot = new TimeSlot();
        boolean eightHalf = jsonObject.getBoolean("8:00 - 8:30");
        boolean halfNine = jsonObject.getBoolean("8:30 - 9:00");
        boolean nineHalf = jsonObject.getBoolean("9:00 - 9:30");
        boolean halfTen = jsonObject.getBoolean("9:30 - 10:00");

        boolean tenHalf = jsonObject.getBoolean("10:00 - 10:30");
        boolean halfEleven = jsonObject.getBoolean("10:30 - 11:00");
        boolean elevenHalf = jsonObject.getBoolean("11:00 - 11:30");
        boolean halfTwelve = jsonObject.getBoolean("11:30 - 12:00");

        boolean twelveHalf = jsonObject.getBoolean("12:00 - 12:30");
        boolean halfThirteen = jsonObject.getBoolean("12:30 - 13:00");
        boolean thirteenHalf = jsonObject.getBoolean("13:00 - 13:30");
        boolean halfFourteen = jsonObject.getBoolean("13:30 - 14:00");

        boolean fourteenHalf = jsonObject.getBoolean("14:00 - 14:30");
        boolean halfFifteen = jsonObject.getBoolean("14:30 - 15:00");
        boolean fifteenHalf = jsonObject.getBoolean("15:00 - 15:30");
        boolean halfSixteen = jsonObject.getBoolean("15:30 - 16:00");

        boolean sixteenHalf = jsonObject.getBoolean("16:00 - 16:30");
        boolean halfSeventeen = jsonObject.getBoolean("16:30 - 17:00");
        boolean seventeenHalf = jsonObject.getBoolean("17:00 - 17:30");
        boolean halfEighteen = jsonObject.getBoolean("17:30 - 18:00");

        timeSlot.setTimeSlot(eightHalf, halfNine, nineHalf, halfTen, tenHalf, halfEleven, elevenHalf,
                halfTwelve, twelveHalf, halfThirteen, thirteenHalf, halfFourteen, fourteenHalf, halfFifteen,
                fifteenHalf, halfSixteen, sixteenHalf, halfSeventeen, seventeenHalf, halfEighteen);

        return timeSlot;
    }
}
