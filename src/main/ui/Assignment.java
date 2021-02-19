package ui;

import model.CourseComponent;
import model.TeachingAssistant;

import java.util.List;

public class Assignment {
    public Course course;

    public Assignment(Course course) {
        this.course = course;

        assignLectures();
        assignTutorials();
        assignLabs();
//        printAssignment(lectures);
//        printAssignment(tutorials);
//        printAssignment(labs);
    }


    // MODIFIES: this
    // EFFECTS: assign tas into lectures
    private void assignLectures() {
        for (CourseComponent lecture : course.getCourseDuty().getLectures()) {
            assignTA(lecture);

        }
    }


    // MODIFIES: this
    // EFFECTS: assign tas into lectures
    private void assignTutorials() {
        for (CourseComponent tutorial : course.getCourseDuty().getTutorials()) {
            assignTA(tutorial);

        }
    }


    // MODIFIES: this
    // EFFECTS: assign tas into lectures
    private void assignLabs() {
        for (CourseComponent lab : course.getCourseDuty().getLabs()) {
            assignTA(lab);

        }
    }

    // MODIFIES: this
    // EFFECTS: assign ta to the course component
    private void assignTA(CourseComponent courseComponent) {
        Schedule courseSchedule = courseComponent.getSchedule();
        int num = 0;
        for (TeachingAssistant ta : course.getTas()) {
            if (num < courseComponent.getNumTA()) {
                if (ta.getSchedule().contain(courseSchedule) && (ta.getMaxWorkHours() > courseSchedule.totalTime())) {
                    courseComponent.addTA(ta);
                    ta.getSchedule().turnOffSchedule(courseSchedule);
                    ta.deductMaxWorkHours(courseSchedule.totalTime());
                    num++;
                }
            }
        }
    }


    // EFFECTS: display lecture assignments information
    public String displayLectureAssignment() {
        String lecture = displayCourseComponent(course.getCourseDuty().getLectures());

        return "<html>" + lecture + "</html>";
    }


    // EFFECTS: display tutorial assignments information
    public String displayTutorialAssignment() {
        String tutorial = displayCourseComponent(course.getCourseDuty().getTutorials());

        return "<html>" + tutorial + "</html>";
    }


    // EFFECTS: display lab assignments information
    public String displayLabAssignment() {
        String lab = displayCourseComponent(course.getCourseDuty().getLabs());

        return "<html>" + lab + "</html>";
    }


    // EFFECTS: display Course Component information
    public String displayCourseComponent(List<CourseComponent> courseComponents) {
        String basic = "";
        String number = "";
        String part = "";
        for (CourseComponent courseComponent : courseComponents) {
            basic = courseComponent.getName() + " " + courseComponent.getSection();
            number = "It requires " + courseComponent.getNumTA() + " TAs: ";

            String name = "";
            for (TeachingAssistant ta : courseComponent.getTAs()) {
                name = name + "<br>" + ta.getName();
            }

            part = part + "<br>" + "" + "<br>" + basic + "<br>" + number + name;
        }


        return part;
    }


    // EFFECTS: print the lecture assignment for testing
    private void printAssignment(List<CourseComponent> courseComponents) {
        for (CourseComponent courseComponent : courseComponents) {
            System.out.println(courseComponent.getName() + "" + courseComponent.getSection());
            System.out.println("It requires " + courseComponent.getNumTA() + " TAs");

            for (TeachingAssistant ta : courseComponent.getTAs()) {
                System.out.println(ta.getName());
            }
        }
    }
}
