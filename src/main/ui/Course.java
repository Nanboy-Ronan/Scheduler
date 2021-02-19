package ui;

import model.CourseComponent;
import model.CourseDuty;
import model.TeachingAssistant;
import model.exceptions.NoCourseComponentException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents a course with CourseDuty and TAs
public class Course implements Writable {
    private String name;
    private CourseDuty courseDuty;
    private List<TeachingAssistant> tas;


    // EFFECTS: constructs a new course with name, courseDuty and TAs
    public Course() {
        this.name = "";
        courseDuty = new CourseDuty();
        tas = new ArrayList<>();
    }


    // EFFECTS: get the name of this course
    public String getName() {
        return name;
    }


    // EFFECTS: get the CourseDuty
    public CourseDuty getCourseDuty() {
        return courseDuty;
    }

    // EFFECTS: get all TAs in the course
    public List<TeachingAssistant> getTas() {
        return tas;
    }

    // MODIFIES: this
    // EFFECTS: add the name to this course
    public void addName(String name) {
        this.name = name;
    }


    // MODIFIES: this
    // EFFECTS: add duty to this course
    public boolean addDuty(CourseComponent duty) {
        try {
            courseDuty.addDuty(duty);
            return true;
        } catch (NoCourseComponentException e) {
            return false;
        }
    }


    // MODIFIES: this
    // EFFECTS: add ta to this course
    public void addTA(TeachingAssistant ta) {
        tas.add(ta);
    }


    // EFFECTS: return the course information as a string
    public String displayCourse() {
        String name = "This course is " + this.name;
        String numDuties = "It has " + courseDuty.getDutyNum() + " Duties";

        List<CourseComponent> lecture = courseDuty.getLectures();
        List<CourseComponent> tutorial = courseDuty.getTutorials();
        List<CourseComponent> lab = courseDuty.getLabs();


        String ta = "It has " + tas.size() + " TAs";

        String display = "<html>" + name + "<br>" + numDuties + "<br>" + "<br>" + "Lectures: "
                + displayCourseComponent(lecture) + "<br>" + "<br>" + "Tutorials: "
                + displayCourseComponent(tutorial) + "<br>" + "<br>" + "Labs: " + displayCourseComponent(lab)
                + "<br>" + "<br>" + ta + "</html>";

        return display;
    }


//    // EFFECTS: print out general information of this course
//    public void printCourse() {
//        System.out.println("This course is " + name);
//        System.out.println("It has " + courseDuty.getDutyNum() + " Duty");
//        List<CourseComponent> lecture = courseDuty.getLectures();
//        List<CourseComponent> tutorial = courseDuty.getTutorials();
//        List<CourseComponent> lab = courseDuty.getLabs();
//        printCourseComponent(lecture);
//        printCourseComponent(tutorial);
//        printCourseComponent(lab);
//        System.out.println("It has " + tas.size() + " TAs");
//        int i = 1;
//        for (TeachingAssistant ta : tas) {
//
//            System.out.println(i + "." + " " + ta.getName());
//            System.out.println("Maximum work hour: " + ta.getMaxWorkHours());
////            for (String preferDuty : ta.getPreferDuty()) {
////                System.out.println("Prefer to working on " + preferDuty);
////            }
//            i++;
//            printTASchedule(ta);
//        }
//    }
//
//
//    // EFFECTS: print the schedule of the given TA
//    public void printTASchedule(TeachingAssistant ta) {
//        System.out.println("Monday");
//        ta.getSchedule().printMonday();
//        System.out.println("Tuesday");
//        ta.getSchedule().printTuesday();
//        System.out.println("Wednesday");
//        ta.getSchedule().printWednesday();
//        System.out.println("Thursday");
//        ta.getSchedule().printThursday();
//        System.out.println("Friday");
//        ta.getSchedule().printFriday();
//    }


    // EFFECTS: display course component for GUI
    public String displayCourseComponent(List<CourseComponent> c) {
        String display = "";
        int i = 1;
        for (CourseComponent a : c) {
            String basicInformation = i + "." + " " + a.getName() + " section: " + a.getSection();
            display = display + "<br>" + basicInformation;
            i++;
        }
        return display;
    }


//    // EFFECTS: print out course component one by one
//    public void printCourseComponent(List<CourseComponent> c) {
//        int i = 1;
//        for (CourseComponent a : c) {
//            System.out.println(i + "." + " " + a.getName());
//            System.out.println("section: " + a.getSection());
//            System.out.println("Monday");
//            a.getSchedule().printMonday();
//            System.out.println("Tuesday");
//            a.getSchedule().printThursday();
//            System.out.println("Wednesday");
//            a.getSchedule().printWednesday();
//            System.out.println("Thursday");
//            a.getSchedule().printThursday();
//            System.out.println("Friday");
//            a.getSchedule().printFriday();
//            i++;
//        }
//    }

    // EFFECTS: save course duty and TAs in json.
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("course", name);
        json.put("courseDuty", courseDuty.toJson());
        json.put("TA", tasToJson());

        return json;
    }


    // EFFECTS: put each TA in JSONArray
    private JSONArray tasToJson() {
        JSONArray jsonArray = new JSONArray();

        for (TeachingAssistant ta : tas) {
            jsonArray.put(ta.toJson());
        }

        return jsonArray;
    }

}
