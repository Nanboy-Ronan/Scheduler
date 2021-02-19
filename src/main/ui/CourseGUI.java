package ui;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import model.CourseComponent;
import model.TeachingAssistant;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


// Represent a class with GUI and Course
public class CourseGUI extends JFrame {
    private static final String JSON_STORE = "./data/course.json";
    private static final String ADDED_SUCCESSFULLY = "./data/addedSuccessfully.mp3";
    private static final String ASSIGN = "./data/voiceForAssign.mp3";
    private static final String PERSISTENCE = "./data/voiceForPersistence.mp3";
    private static final File ADDED_SUCCESSFULLY_VOICE = new File(ADDED_SUCCESSFULLY);
    private static final File ASSIGN_VOICE = new File(ASSIGN);
    private static final File PERSISTENCE_VOICE = new File(PERSISTENCE);
    public static Course course;
    private JPanel assignPanel;
    private JTextField courseName;
    private JTextField taName;
    private JTextField maxHours;
    private JLabel courseEnter;
    private JLabel welcome;
    private JLabel taLabel;
    private JLabel courseComponentLabel;
    private JLabel maxHourLabel;
    private JLabel scheduleLabel;
    private JLabel mondayLabel;
    private JLabel tuesdayLabel;
    private JLabel wednesdayLabel;
    private JLabel thursdayLabel;
    private JLabel fridayLabel;
    private JButton addCourseButton;
    private JButton addTAButton;
    private JCheckBox monday800;
    private JCheckBox monday830;
    private JCheckBox monday900;
    private JCheckBox monday930;
    private JCheckBox lectureCheckBox;
    private JCheckBox tutorialCheckBox;
    private JCheckBox labCheckBox;
    private JButton addCourseComponentButton;
    private JTextField section;
    private JTextField numTACourseComponent;
    private JCheckBox tuesday800;
    private JCheckBox tuesday830;
    private JCheckBox tuesday900;
    private JCheckBox tuesday930;
    private JCheckBox wednesday800;
    private JCheckBox wednesday830;
    private JCheckBox wednesday900;
    private JCheckBox wednesday930;
    private JCheckBox thursday800;
    private JCheckBox thursday830;
    private JCheckBox thursday900;
    private JCheckBox thursday930;
    private JCheckBox friday800;
    private JCheckBox friday830;
    private JCheckBox friday900;
    private JCheckBox friday930;
    private JButton assign;
    private JButton saveButton;
    private JButton loadButton;
    private JLabel displayCourse;
    private JButton viewButton;
    private JCheckBox monday1000;
    private JCheckBox monday1030;
    private JCheckBox monday1100;
    private JCheckBox monday1130;
    private JCheckBox tuesday1000;
    private JCheckBox tuesday1030;
    private JCheckBox tuesday1100;
    private JCheckBox tuesday1130;
    private JCheckBox wednesday1000;
    private JCheckBox wednesday1030;
    private JCheckBox wednesday1100;
    private JCheckBox wednesday1130;
    private JCheckBox thursday1000;
    private JCheckBox thursday1030;
    private JCheckBox thursday1100;
    private JCheckBox thursday1130;
    private JCheckBox friday1000;
    private JCheckBox friday1030;
    private JCheckBox friday1100;
    private JCheckBox friday1130;
    private JCheckBox monday1200;
    private JCheckBox monday1230;
    private JCheckBox monday1300;
    private JCheckBox monday1330;
    private JCheckBox tuesday1200;
    private JCheckBox tuesday1230;
    private JCheckBox tuesday1300;
    private JCheckBox tuesday1330;
    private JCheckBox wednesday1200;
    private JCheckBox wednesday1230;
    private JCheckBox wednesday1300;
    private JCheckBox wednesday1330;
    private JCheckBox thursday1200;
    private JCheckBox thursday1230;
    private JCheckBox thursday1300;
    private JCheckBox thursday1330;
    private JCheckBox friday1200;
    private JCheckBox friday1230;
    private JCheckBox friday1300;
    private JCheckBox friday1330;
    private JButton clearButton;
    private JCheckBox monday1400;
    private JCheckBox monday1430;
    private JCheckBox monday1500;
    private JCheckBox monday1530;
    private JCheckBox monday1600;
    private JCheckBox monday1630;
    private JCheckBox monday1700;
    private JCheckBox monday1730;
    private JCheckBox tuesday1400;
    private JCheckBox tuesday1430;
    private JCheckBox tuesday1500;
    private JCheckBox tuesday1530;
    private JCheckBox tuesday1600;
    private JCheckBox tuesday1630;
    private JCheckBox tuesday1700;
    private JCheckBox tuesday1730;
    private JCheckBox wednesday1400;
    private JCheckBox wednesday1430;
    private JCheckBox wednesday1500;
    private JCheckBox wednesday1530;
    private JCheckBox wednesday1600;
    private JCheckBox wednesday1630;
    private JCheckBox wednesday1700;
    private JCheckBox wednesday1730;
    private JCheckBox thursday1400;
    private JCheckBox thursday1430;
    private JCheckBox thursday1500;
    private JCheckBox thursday1530;
    private JCheckBox thursday1600;
    private JCheckBox thursday1630;
    private JCheckBox thursday1700;
    private JCheckBox thursday1730;
    private JCheckBox friday1400;
    private JCheckBox friday1430;
    private JCheckBox friday1500;
    private JCheckBox friday1530;
    private JCheckBox friday1600;
    private JCheckBox friday1630;
    private JCheckBox friday1700;
    private JCheckBox friday1730;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // EFFECTS: construct the GUI and course
    public CourseGUI() {
        // construct the GUI now
        super("TA Assign Application");
        constructGUI();

        constructCourse();

    }


    // EFFECTS: constructs the GUI
    private void constructGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(assignPanel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }


    // EFFECTS: construct the course
    public void constructCourse() {
        course = new Course();

        // construct the json function
        //jsonWriter = new JsonWriter(JSON_STORE);
        // jsonReader = new JsonReader(JSON_STORE);

        setCourseName();
        addCourseComponent();
        addTA();
        view();
        assign();
        clear();

        saveFile();
        loadFile();
    }


    // MODIFIES: this
    // EFFECTS: add the name to this course
    private void setCourseName() {
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic(ADDED_SUCCESSFULLY_VOICE);
                course.addName(courseName.getText());
                //System.out.println(course.getName());
            }
        });
    }


    // MODIFIES: this
    // EFFECTS: add course component when add button is pressed
    private void addCourseComponent() {
        addCourseComponentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic(ADDED_SUCCESSFULLY_VOICE);
                course.addDuty(readCourseComponent());
            }
        });
    }


    // MODIFIES: this
    // EFFECTS: add this TA into course when add button is pressed
    private void addTA() {
        addTAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic(ADDED_SUCCESSFULLY_VOICE);
                course.addTA(readTA());
                //course.printCourse();
            }
        });
    }


    // EFFECTS: assign TAs for this course when "assign" button is pressed and display image and play sound
    private void assign() {
        assign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic(ASSIGN_VOICE);
                Assignment assignment = new Assignment(course);
                // assign.setIcon(new ImageIcon("./data/Finish.jpg"));
                JOptionPane.showMessageDialog(null, assignment.displayLectureAssignment(),
                        "Lecture Assignment", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, assignment.displayTutorialAssignment(),
                        "Tutorial Assignment", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, assignment.displayLabAssignment(),
                        "Lab Assignment", JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }


    // EFFECTS: view the course information in GUI
    private void view() {
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, course.displayCourse(), "Course Information",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }


    // EFFECTS: call saveIt if the save button is pressed
    private void saveFile() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // playMusic(PERSISTENCE_VOICE);
                saveIt();
            }
        });
    }


    // EFFECTS: call loadIt if the load button is pressed
    private void loadFile() {
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // playMusic(PERSISTENCE_VOICE);
                openFile();
                //course.printCourse();
            }
        });
    }


//    // EFFECTS: call json to save the file
//    private void saveIt() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(course);
//            jsonWriter.close();
//            JOptionPane.showMessageDialog(null,
//                    "Saved " + course.getName() + " to " + JSON_STORE,
//                    "Loading Information", JOptionPane.INFORMATION_MESSAGE);
//        } catch (FileNotFoundException e) {
//            JOptionPane.showMessageDialog(null,
//                    "Unable to write to file: " + JSON_STORE,
//                    "Loading Information", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//
//
//    // EFFECTS: call json to load the file
//    private void loadIt() {
//        try {
//            course = jsonReader.read();
//            JOptionPane.showMessageDialog(null,
//                    "Loaded " + course.getName() + " from " + JSON_STORE,
//                    "Loading Information", JOptionPane.INFORMATION_MESSAGE);
//        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null,
//                    "Unable to read from file: " + JSON_STORE,
//                    "Loading Information", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }


    // EFFECTS: guide the user to choose a file
    private void openFile() {
        // construct JFileChooser
        JFileChooser openFileChooser = new JFileChooser();
        File file;
        String jsonStore = "";

        //openFileChooser.setDialogTitle("Please choose JSON file here");
        openFileChooser.setFileFilter(new FileNameExtensionFilter("JSON file", "json"));

        if (openFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                file = openFileChooser.getSelectedFile();
                jsonStore = "" + openFileChooser.getCurrentDirectory() + "/" + file.getName();

                jsonReader = new JsonReader(jsonStore);
                course = jsonReader.read();
                JOptionPane.showMessageDialog(null,
                        "Loaded " + course.getName() + " from " + jsonStore,
                        "Loading Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Unable to read from file: " + jsonStore,
                        "Loading Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "No file chosen!",
                    "Loading Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // EFFECTS: guide the user to save the course information
    private void saveIt() {
        // construct a JFileChooser
        JFileChooser saveFileChooser = new JFileChooser();
        String jsonSave = "";

        saveFileChooser.setFileFilter(new FileNameExtensionFilter("JSON file", "json"));
        if (saveFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                jsonSave = "" + saveFileChooser.getSelectedFile();

                // Write to the selected path
                jsonWriter = new JsonWriter(jsonSave);

                jsonWriter.open();
                jsonWriter.write(course);
                jsonWriter.close();

                // show the saving information
                JOptionPane.showMessageDialog(null,
                        "Saved " + course.getName() + " to " + jsonSave,
                        "Loading Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Unable to write to file: " + jsonSave,
                        "Loading Information", JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null,
                    "No pathway chosen!",
                    "Loading Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }


    // EFFECTS: clear all JCheckBox in Schedule
    private void clear() {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uncheckMondayTimeSlot();
                uncheckTuesdayTimeSlot();
                uncheckWednesdayTimeSlot();
                uncheckThursdayTimeSlot();
                uncheckFridayTimeSlot();

                clearCourseComponent();
                clearTA();
            }
        });
    }


    // EFFECTS: read the information and return a course component according to it
    private CourseComponent readCourseComponent() {
        CourseComponent c = new CourseComponent();

        c.addName(readComponentKind());
        c.addSection(section.getText());
        c.addSchedule(readSchedule());
        c.addNumTA(Integer.parseInt(numTACourseComponent.getText()));

        return c;
    }

    // EFFECTS: read the given information and return a Teaching Assistant according to it
    private TeachingAssistant readTA() {
        TeachingAssistant ta = new TeachingAssistant();

        // add name for TA
        String input = taName.getText();
        ta.addName(input);

        // add maximum work hour for ta
        ta.addMaxHour(Integer.parseInt(maxHours.getText()));


        ta.addSchedule(readSchedule());

        return ta;
    }


    // EFFECTS: read the schedule from the panel
    private Schedule readSchedule() {
        Schedule schedule = new Schedule();

        mondayScheduleReader(schedule);
        tuesdayScheduleReader(schedule);
        wednesdayScheduleReader(schedule);
        thursdayScheduleReader(schedule);
        fridayScheduleReader(schedule);

        return schedule;
    }


    // EFFECTS: clear all information in courseComponent panel
    private void clearCourseComponent() {
        lectureCheckBox.setSelected(false);
        tutorialCheckBox.setSelected(false);
        labCheckBox.setSelected(false);

        section.setText("");
        numTACourseComponent.setText("");
    }


    // EFFECTS: clear all information in TA panel
    private void clearTA() {
        taName.setText("");
        maxHours.setText("");
    }

    // EFFECTS: read Monday's the schedule from the panel (first part)
    private void mondayScheduleReader(Schedule schedule) {
        if (monday800.isSelected()) {
            schedule.getMonday().setEightHalf();
        }

        if (monday830.isSelected()) {
            schedule.getMonday().setHalfNine();
        }

        if (monday900.isSelected()) {
            schedule.getMonday().setNineHalf();
        }

        if (monday930.isSelected()) {
            schedule.getMonday().setHalfTen();
        }
        if (monday1000.isSelected()) {
            schedule.getMonday().setTenHalf();
        }

        if (monday1030.isSelected()) {
            schedule.getMonday().setHalfEleven();
        }

        if (monday1100.isSelected()) {
            schedule.getMonday().setElevenHalf();
        }

        if (monday1130.isSelected()) {
            schedule.getMonday().setHalfTwelve();
        }
        if (monday1200.isSelected()) {
            schedule.getMonday().setTwelveHalf();
        }

        if (monday1230.isSelected()) {
            schedule.getMonday().setHalfThirteen();
        }

        if (monday1300.isSelected()) {
            schedule.getMonday().setThirteenHalf();
        }

        if (monday1330.isSelected()) {
            schedule.getMonday().setHalfFourteen();
        }

        if (monday1400.isSelected()) {
            schedule.getMonday().setFourteenHalf();
        }

        if (monday1430.isSelected()) {
            schedule.getMonday().setHalfFifteen();
        }

        if (monday1500.isSelected()) {
            schedule.getMonday().setFifteenHalf();
        }

        if (monday1530.isSelected()) {
            schedule.getMonday().setHalfSixteen();
        }

        if (monday1600.isSelected()) {
            schedule.getMonday().setSixteenHalf();
        }

        if (monday1630.isSelected()) {
            schedule.getMonday().setHalfSeventeen();
        }

        if (monday1700.isSelected()) {
            schedule.getMonday().setSeventeenHalf();
        }

        if (monday1730.isSelected()) {
            schedule.getMonday().setHalfEighteen();
        }
    }


    // EFFECTS: read Tuesday's the schedule from the panel (first part)
    private void tuesdayScheduleReader(Schedule schedule) {
        if (tuesday800.isSelected()) {
            schedule.getTuesday().setEightHalf();
        }

        if (tuesday830.isSelected()) {
            schedule.getTuesday().setHalfNine();
        }

        if (tuesday900.isSelected()) {
            schedule.getTuesday().setNineHalf();
        }

        if (tuesday930.isSelected()) {
            schedule.getTuesday().setHalfTen();
        }
        if (tuesday1000.isSelected()) {
            schedule.getTuesday().setTenHalf();
        }

        if (tuesday1030.isSelected()) {
            schedule.getTuesday().setHalfEleven();
        }

        if (tuesday1100.isSelected()) {
            schedule.getTuesday().setElevenHalf();
        }

        if (tuesday1130.isSelected()) {
            schedule.getTuesday().setHalfTwelve();
        }

        if (tuesday1200.isSelected()) {
            schedule.getTuesday().setTwelveHalf();
        }

        if (tuesday1230.isSelected()) {
            schedule.getTuesday().setHalfThirteen();
        }

        if (tuesday1300.isSelected()) {
            schedule.getTuesday().setThirteenHalf();
        }

        if (tuesday1330.isSelected()) {
            schedule.getTuesday().setHalfFourteen();
        }

        if (tuesday1400.isSelected()) {
            schedule.getTuesday().setFourteenHalf();
        }

        if (tuesday1430.isSelected()) {
            schedule.getTuesday().setHalfFifteen();
        }

        if (tuesday1500.isSelected()) {
            schedule.getTuesday().setFifteenHalf();
        }

        if (tuesday1530.isSelected()) {
            schedule.getTuesday().setHalfSixteen();
        }

        if (tuesday1600.isSelected()) {
            schedule.getTuesday().setSixteenHalf();
        }

        if (tuesday1630.isSelected()) {
            schedule.getTuesday().setHalfSeventeen();
        }

        if (tuesday1700.isSelected()) {
            schedule.getTuesday().setSeventeenHalf();
        }

        if (tuesday1730.isSelected()) {
            schedule.getTuesday().setHalfEighteen();
        }
    }


    // EFFECTS: read Wednesday's the schedule from the panel (first part)
    private void wednesdayScheduleReader(Schedule schedule) {
        if (wednesday800.isSelected()) {
            schedule.getWednesday().setEightHalf();
        }

        if (wednesday830.isSelected()) {
            schedule.getWednesday().setHalfNine();
        }

        if (wednesday900.isSelected()) {
            schedule.getWednesday().setNineHalf();
        }

        if (wednesday930.isSelected()) {
            schedule.getWednesday().setHalfTen();
        }
        if (wednesday1000.isSelected()) {
            schedule.getWednesday().setTenHalf();
        }

        if (wednesday1030.isSelected()) {
            schedule.getWednesday().setHalfEleven();
        }

        if (wednesday1100.isSelected()) {
            schedule.getWednesday().setElevenHalf();
        }

        if (wednesday1130.isSelected()) {
            schedule.getWednesday().setHalfTwelve();
        }

        if (wednesday1200.isSelected()) {
            schedule.getWednesday().setTwelveHalf();
        }

        if (wednesday1230.isSelected()) {
            schedule.getWednesday().setHalfThirteen();
        }

        if (wednesday1300.isSelected()) {
            schedule.getWednesday().setThirteenHalf();
        }

        if (wednesday1330.isSelected()) {
            schedule.getWednesday().setHalfFourteen();
        }

        if (wednesday1400.isSelected()) {
            schedule.getWednesday().setFourteenHalf();
        }

        if (wednesday1430.isSelected()) {
            schedule.getWednesday().setHalfFifteen();
        }

        if (wednesday1500.isSelected()) {
            schedule.getWednesday().setFifteenHalf();
        }

        if (wednesday1530.isSelected()) {
            schedule.getWednesday().setHalfSixteen();
        }

        if (wednesday1600.isSelected()) {
            schedule.getWednesday().setSixteenHalf();
        }

        if (wednesday1630.isSelected()) {
            schedule.getWednesday().setHalfSeventeen();
        }

        if (wednesday1700.isSelected()) {
            schedule.getWednesday().setSeventeenHalf();
        }

        if (wednesday1730.isSelected()) {
            schedule.getWednesday().setHalfEighteen();
        }
    }


    // EFFECTS: read Thursday's the schedule from the panel (first part)
    private void thursdayScheduleReader(Schedule schedule) {
        if (thursday800.isSelected()) {
            schedule.getThursday().setEightHalf();
        }

        if (thursday830.isSelected()) {
            schedule.getThursday().setHalfNine();
        }

        if (thursday900.isSelected()) {
            schedule.getThursday().setNineHalf();
        }

        if (thursday930.isSelected()) {
            schedule.getThursday().setHalfTen();
        }
        if (thursday1000.isSelected()) {
            schedule.getThursday().setTenHalf();
        }

        if (thursday1030.isSelected()) {
            schedule.getThursday().setHalfEleven();
        }

        if (thursday1100.isSelected()) {
            schedule.getThursday().setElevenHalf();
        }

        if (thursday1130.isSelected()) {
            schedule.getThursday().setHalfTwelve();
        }

        if (thursday1200.isSelected()) {
            schedule.getThursday().setTwelveHalf();
        }

        if (thursday1230.isSelected()) {
            schedule.getThursday().setHalfThirteen();
        }

        if (thursday1300.isSelected()) {
            schedule.getThursday().setThirteenHalf();
        }

        if (thursday1330.isSelected()) {
            schedule.getThursday().setHalfFourteen();
        }

        if (thursday1400.isSelected()) {
            schedule.getThursday().setFourteenHalf();
        }

        if (thursday1430.isSelected()) {
            schedule.getThursday().setHalfFifteen();
        }

        if (thursday1500.isSelected()) {
            schedule.getThursday().setFifteenHalf();
        }

        if (thursday1530.isSelected()) {
            schedule.getThursday().setHalfSixteen();
        }

        if (thursday1600.isSelected()) {
            schedule.getThursday().setSixteenHalf();
        }

        if (thursday1630.isSelected()) {
            schedule.getThursday().setHalfSeventeen();
        }

        if (thursday1700.isSelected()) {
            schedule.getThursday().setSeventeenHalf();
        }

        if (thursday1730.isSelected()) {
            schedule.getThursday().setHalfEighteen();
        }
    }


    // EFFECTS: read Friday's the schedule from the panel (first part)
    private void fridayScheduleReader(Schedule schedule) {
        if (friday800.isSelected()) {
            schedule.getFriday().setEightHalf();
        }

        if (friday830.isSelected()) {
            schedule.getFriday().setHalfNine();
        }

        if (friday900.isSelected()) {
            schedule.getFriday().setNineHalf();
        }

        if (friday930.isSelected()) {
            schedule.getFriday().setHalfTen();
        }
        if (friday1000.isSelected()) {
            schedule.getFriday().setTenHalf();
        }

        if (friday1030.isSelected()) {
            schedule.getFriday().setHalfEleven();
        }

        if (friday1100.isSelected()) {
            schedule.getFriday().setElevenHalf();
        }

        if (friday1130.isSelected()) {
            schedule.getFriday().setHalfTwelve();
        }

        if (friday1200.isSelected()) {
            schedule.getFriday().setTwelveHalf();
        }

        if (friday1230.isSelected()) {
            schedule.getFriday().setHalfThirteen();
        }

        if (friday1300.isSelected()) {
            schedule.getFriday().setThirteenHalf();
        }

        if (friday1330.isSelected()) {
            schedule.getFriday().setHalfFourteen();
        }

        if (friday1400.isSelected()) {
            schedule.getFriday().setFourteenHalf();
        }

        if (friday1430.isSelected()) {
            schedule.getFriday().setHalfFifteen();
        }

        if (friday1500.isSelected()) {
            schedule.getFriday().setFifteenHalf();
        }

        if (friday1530.isSelected()) {
            schedule.getFriday().setHalfSixteen();
        }

        if (friday1600.isSelected()) {
            schedule.getFriday().setSixteenHalf();
        }

        if (friday1630.isSelected()) {
            schedule.getFriday().setHalfSeventeen();
        }

        if (friday1700.isSelected()) {
            schedule.getFriday().setSeventeenHalf();
        }

        if (friday1730.isSelected()) {
            schedule.getFriday().setHalfEighteen();
        }
    }

    // EFFECTS: read the kind of course component and return its kind as string
    private String readComponentKind() {
        if (lectureCheckBox.isSelected()) {
            return "lecture";
        }

        if (tutorialCheckBox.isSelected()) {
            return "tutorial";
        }

        if (labCheckBox.isSelected()) {
            return "lab";
        }

        return "";
    }


    // EFFECTS: set all JCheckBox in Monday to be unchecked (false)
    private void uncheckMondayTimeSlot() {
        monday800.setSelected(false);
        monday830.setSelected(false);
        monday900.setSelected(false);
        monday930.setSelected(false);

        monday1000.setSelected(false);
        monday1030.setSelected(false);
        monday1100.setSelected(false);
        monday1130.setSelected(false);

        monday1200.setSelected(false);
        monday1230.setSelected(false);
        monday1300.setSelected(false);
        monday1330.setSelected(false);

        monday1400.setSelected(false);
        monday1430.setSelected(false);
        monday1500.setSelected(false);
        monday1530.setSelected(false);

        monday1600.setSelected(false);
        monday1630.setSelected(false);
        monday1700.setSelected(false);
        monday1730.setSelected(false);
    }

    // EFFECTS: set all JCheckBox in Monday to be unchecked (false)
    private void uncheckTuesdayTimeSlot() {
        tuesday800.setSelected(false);
        tuesday830.setSelected(false);
        tuesday900.setSelected(false);
        tuesday930.setSelected(false);

        tuesday1000.setSelected(false);
        tuesday1030.setSelected(false);
        tuesday1100.setSelected(false);
        tuesday1130.setSelected(false);

        tuesday1200.setSelected(false);
        tuesday1230.setSelected(false);
        tuesday1300.setSelected(false);
        tuesday1330.setSelected(false);

        tuesday1400.setSelected(false);
        tuesday1430.setSelected(false);
        tuesday1500.setSelected(false);
        tuesday1530.setSelected(false);

        tuesday1600.setSelected(false);
        tuesday1630.setSelected(false);
        tuesday1700.setSelected(false);
        tuesday1730.setSelected(false);
    }

    // EFFECTS: set all JCheckBox in Monday to be unchecked (false)
    private void uncheckWednesdayTimeSlot() {
        wednesday800.setSelected(false);
        wednesday830.setSelected(false);
        wednesday900.setSelected(false);
        wednesday930.setSelected(false);

        wednesday1000.setSelected(false);
        wednesday1030.setSelected(false);
        wednesday1100.setSelected(false);
        wednesday1130.setSelected(false);

        wednesday1200.setSelected(false);
        wednesday1230.setSelected(false);
        wednesday1300.setSelected(false);
        wednesday1330.setSelected(false);

        wednesday1400.setSelected(false);
        wednesday1430.setSelected(false);
        wednesday1500.setSelected(false);
        wednesday1530.setSelected(false);

        wednesday1600.setSelected(false);
        wednesday1630.setSelected(false);
        wednesday1700.setSelected(false);
        wednesday1730.setSelected(false);
    }

    // EFFECTS: set all JCheckBox in Monday to be unchecked (false)
    private void uncheckThursdayTimeSlot() {
        thursday800.setSelected(false);
        thursday830.setSelected(false);
        thursday900.setSelected(false);
        thursday930.setSelected(false);

        thursday1000.setSelected(false);
        thursday1030.setSelected(false);
        thursday1100.setSelected(false);
        thursday1130.setSelected(false);

        thursday1200.setSelected(false);
        thursday1230.setSelected(false);
        thursday1300.setSelected(false);
        thursday1330.setSelected(false);

        thursday1400.setSelected(false);
        thursday1430.setSelected(false);
        thursday1500.setSelected(false);
        thursday1530.setSelected(false);

        thursday1600.setSelected(false);
        thursday1630.setSelected(false);
        thursday1700.setSelected(false);
        thursday1730.setSelected(false);
    }

    // EFFECTS: set all JCheckBox in Monday to be unchecked (false)
    private void uncheckFridayTimeSlot() {
        friday800.setSelected(false);
        friday830.setSelected(false);
        friday900.setSelected(false);
        friday930.setSelected(false);

        friday1000.setSelected(false);
        friday1030.setSelected(false);
        friday1100.setSelected(false);
        friday1130.setSelected(false);

        friday1200.setSelected(false);
        friday1230.setSelected(false);
        friday1300.setSelected(false);
        friday1330.setSelected(false);

        friday1400.setSelected(false);
        friday1430.setSelected(false);
        friday1500.setSelected(false);
        friday1530.setSelected(false);

        friday1600.setSelected(false);
        friday1630.setSelected(false);
        friday1700.setSelected(false);
        friday1730.setSelected(false);
    }

    // EFFECTS: play the music according to the given file
    private void playMusic(File file) {
        try {
            Player player = new Player(new FileInputStream(file));
            player.play();
        } catch (JavaLayerException javaLayerException) {
            javaLayerException.printStackTrace();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}



