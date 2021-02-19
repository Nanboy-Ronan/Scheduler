package model;

import org.json.JSONObject;
import persistence.Writable;
import ui.Schedule;

// Represents a TA with name, maximum work hours, and his/her available schedule.
public class TeachingAssistant implements Writable {
    private String name;
    private double maxWorkHours;
    private Schedule schedule; // list of time interval


    // MODIFIES: this
    // EFFECTS: construct TA with his/her available schedule and list of preferred duty.
    public TeachingAssistant() {
        schedule = new Schedule();

    }


    // MODIFIES: this
    // EFFECTS: deduct the given time from maxWorkHours
    public void deductMaxWorkHours(double t) {
        maxWorkHours = maxWorkHours - t;
    }

    // MODIFIES: this
    // EFFECTS: add the name to this TA
    public void addName(String name) {
        this.name = name;
    }


    // MODIFIES: this
    // EFFECTS: add the maximum work hour for this TA
    public void addMaxHour(int maxHours) {
        this.maxWorkHours = maxHours;
    }


    // MODIFIES: this
    // EFFECTS: add the schedule to the TA
    public void addSchedule(Schedule schedule) {
        this.schedule = schedule;
    }


    // EFFECTS: return the name of TA
    public String getName() {
        return name;
    }


    // EFFECTS: return the maximum work hours of TA
    public double getMaxWorkHours() {
        return maxWorkHours;
    }


    // EFFECTS: return the schedule of TA
    public Schedule getSchedule() {
        return schedule;
    }


    // EFFECTS: convert Teaching Assistant to Json object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("Max Working Time", maxWorkHours);
        json.put("schedule", schedule.toJson());
        return json;

    }


}
