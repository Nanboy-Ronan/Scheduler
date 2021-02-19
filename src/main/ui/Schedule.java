package ui;

import org.json.JSONObject;
import persistence.Writable;

// Represents timeslots in each weekday
public class Schedule implements Writable {
    private TimeSlot monday;
    private TimeSlot tuesday;
    private TimeSlot wednesday;
    private TimeSlot thursday;
    private TimeSlot friday;


    // EFFECTS: set up schedule with all unavailable in each week
    public Schedule() {
        monday = new TimeSlot();
        tuesday = new TimeSlot();
        wednesday = new TimeSlot();
        thursday = new TimeSlot();
        friday = new TimeSlot();
    }


    // EFFECTS: return true if the this schedule contains the given schedule, otherwise false
    public boolean contain(Schedule schedule) {
        return this.monday.contain(schedule.getMonday()) && this.tuesday.contain(schedule.getTuesday())
                && this.wednesday.contain(schedule.getWednesday()) && this.thursday.contain(schedule.getThursday())
                && this.friday.contain(schedule.getFriday());
    }


    // EFFECTS: return the total time in this schedule
    public double totalTime() {
        double time = 0;
        time = monday.countTime() + tuesday.countTime() + wednesday.countTime()
                + thursday.countTime() + friday.countTime();

        return time;
    }

    // EFFECTS: set this schedule to be unavailable whenever the given schedule is available
    public void turnOffSchedule(Schedule schedule) {
        this.monday.turnOffTimeSlot(schedule.getMonday());
        this.tuesday.turnOffTimeSlot(schedule.getTuesday());
        this.wednesday.turnOffTimeSlot(schedule.getWednesday());
        this.thursday.turnOffTimeSlot(schedule.getThursday());
        this.friday.turnOffTimeSlot(schedule.getFriday());
    }


    // EFFECTS: convert schedule to json object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("monday", monday.toJson());
        json.put("tuesday", tuesday.toJson());
        json.put("wednesday", wednesday.toJson());
        json.put("thursday", thursday.toJson());
        json.put("friday", friday.toJson());

        return json;
    }


    // MODIFIES: this
    // EFFECTS: add timeslot to monday
    public void addMonday(TimeSlot timeSlot) {
        this.monday = timeSlot;
    }

    // MODIFIES: this
    // EFFECTS: add timeslot to Tuesday
    public void addTuesday(TimeSlot timeSlot) {
        this.tuesday = timeSlot;
    }


    // MODIFIES: this
    // EFFECTS: add timeslot to Wednesday
    public void addWednesday(TimeSlot timeSlot) {
        this.wednesday = timeSlot;
    }


    // MODIFIES: this
    // EFFECTS: add timeslot to Thursday
    public void addThursday(TimeSlot timeSlot) {
        this.thursday = timeSlot;
    }


    // MODIFIES: this
    // EFFECTS: add timeslot to Friday
    public void addFriday(TimeSlot timeSlot) {
        this.friday = timeSlot;
    }


//    // EFFECTS: print out schedule on Monday for test purpose
//    public void printMonday() {
//        monday.printTimeSlot();
//    }
//
//
//    // EFFECTS: print out schedule on Tuesday for test purpose
//    public void printTuesday() {
//        tuesday.printTimeSlot();
//    }
//
//
//    // EFFECTS: print out schedule on Wednesday for test purpose
//    public void printWednesday() {
//        wednesday.printTimeSlot();
//    }
//
//
//    // EFFECTS: print out schedule on Thursday for test purpose
//    public void printThursday() {
//        thursday.printTimeSlot();
//    }
//
//
//    // EFFECTS: print out schedule on Friday for test purpose
//    public void printFriday() {
//        friday.printTimeSlot();
//    }


    public TimeSlot getMonday() {
        return monday;
    }


    public TimeSlot getTuesday() {
        return tuesday;
    }


    public TimeSlot getWednesday() {
        return wednesday;
    }


    public TimeSlot getThursday() {
        return thursday;
    }


    public TimeSlot getFriday() {
        return friday;
    }

}
