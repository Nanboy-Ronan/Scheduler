package model;


import model.exceptions.NoCourseComponentException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents the duties of a course
public class CourseDuty implements Writable {
    private List<CourseComponent> lectures;
    private List<CourseComponent> tutorials;
    private List<CourseComponent> labs;

    // EFFECTS: constructs course duties with initial no duty
    public CourseDuty() {
        this.lectures = new ArrayList<>();
        this.tutorials = new ArrayList<>();
        this.labs = new ArrayList<>();
    }


    // MODIFIES: this
    // EFFECTS: add given course Component in CourseDuty, throw the NoCourseComponentException if name is not one of
    // "lecture" "lab" "tutorial"
    public void addDuty(CourseComponent c) throws NoCourseComponentException {
        if (c.getName().equals("lecture")) {
            lectures.add(c);
        } else if (c.getName().equals("lab")) {
            labs.add(c);
        } else if (c.getName().equals("tutorial")) {
            tutorials.add(c);
        } else {
            throw new NoCourseComponentException();
        }
    }

    // EFFECTS: return lectures
    public List<CourseComponent> getLectures() {
        return lectures;
    }


    // EFFECTS: return labs
    public List<CourseComponent> getLabs() {
        return labs;
    }


    // EFFECTS: return tutorials
    public List<CourseComponent> getTutorials() {
        return tutorials;
    }


    // EFFECTS: return number of duties in the CourseDuty
    public int getDutyNum() {
        return lectures.size() + tutorials.size() + labs.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("lectures", courseComponentsToJson(lectures));
        json.put("tutorials", courseComponentsToJson(tutorials));
        json.put("labs", courseComponentsToJson(labs));
        return json;
    }

    // EFFECTS: put each course component in JSONArray
    private JSONArray courseComponentsToJson(List<CourseComponent> courseComponents) {
        JSONArray jsonArray = new JSONArray();

        for (CourseComponent c : courseComponents) {
            jsonArray.put(c.toJson());
        }

        return jsonArray;
    }
}
