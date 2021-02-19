package model;

import org.json.JSONObject;
import persistence.Writable;
import ui.Schedule;

import java.util.ArrayList;
import java.util.List;

//Represents a course component
public class CourseComponent implements Writable {
    public List<TeachingAssistant> tas;
    private String name;
    private String section;
    private Schedule schedule;
    private int numTA;


    // EFFECTS: constructs a course component with name, section and timeInterval
    public CourseComponent() {
        this.schedule = new Schedule();
        tas = new ArrayList<>();
    }


    // MODIFIES: this
    // EFFECTS: add the name to this course component
    public void addName(String name) {
        this.name = name;
    }


    // MODIFIES: this
    // EFFECTS: add section to this course component
    public void addSection(String section) {
        this.section = section;
    }


    // MODIFIES: this
    // EFFECTS: add schedule to this course component
    public void addSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    // MODIFIES: this
    // EFFECTS: add section to this course component
    public void addNumTA(int num) {
        this.numTA = num;
    }


    // MODIFIES: this
    // EFFECTS: add TA to tas
    public void addTA(TeachingAssistant ta) {
        tas.add(ta);
    }


    // EFFECTS: return the name of the component
    public String getName() {
        return name;
    }


    // EFFECTS: return the section number of the component
    public String getSection() {
        return section;
    }


    // EFFECTS: return the schedule of the course component
    public Schedule getSchedule() {
        return schedule;
    }


    // EFFECTS: return the number of TAs needed in this course
    public int getNumTA() {
        return numTA;
    }


    // EFFECTS: get all TAs in this course component
    public List<TeachingAssistant> getTAs() {
        return tas;
    }

    // EFFECTS: put this courseComponent to JSON
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("section", section);
        json.put("schedule", schedule.toJson());
        json.put("numTA", numTA);
        return json;
    }


}
