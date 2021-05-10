# Program for Assigning TAs

## Assigning TA based on their preferred work and schedule

This is a program helps assign Teaching Assistants given the course duties and TA’s personal schedule. The course
includes schedule for **lecture**, **lab**, and **tutorial**. Teaching Assistants need to input their personal
*schedule*，*maximum work time*.
  
I am currently working on adding function to help Teaching Assistants input their personal schedule through website.

This program can be easily changed and be further used to assign employees to their suitable duties according to
their personal schedule and maximum working time.

There are several .json file in the **test** folder for you to test the functionality of the program.

I appreciate any of your feedback.


## User Stories
- As a user, I want to be able to give course components of its name, section, schedule.
- As a user, I want to be able to add TAs with their schedule and max working time in a week.
- As a user, I want to be able to save the course to file.
- As a user, I want to be able to load the course from file.
- As a user, I want to be able to assign TA in the time given by the program .


## Instruction
This program requires the user to first input (course) duties and TAs (employees). One can input these information
in two ways.

First way:

1. In the program window, enter the course name add click ADD button. The system will play audio "Added successfully"
once the information is been added successfully.

2. In the program window, choose the classification of course duty (lecture, tutorial ...), enter the section (name),
  and number of TA needed, and choose the schedule. Click ADD button. The system will play audio "Added successfully"
  once the information is been added successfully.
  
3. In the program window, enter the name of the TA, give the max working time per week.Click ADD button. 
The system will play audio "Added successfully" once the information is been added successfully.

4. Click the view button any time if you want to see the information you have added anytime.

5. Click the save button if you want to save the information you entered anytime. WARNING: You must save the information
before click ASSIGN button, in case losing the information.

Second way, strongly recommend if you want to input a lot of information:

1. Open the JSON file "./data/course.json", and change the information according to the current template.

2. In the schedule, "true" stands for available, while "false" stands for unavailable. The name of the timeslot is
every half an hour. For example, eightHalf stands for 8:00 - 8:30, and halfNine stands for 8:30 - 9:00.

3. Once input all the information, open the program window and click LOAD button. You will hear an audio once data is
successfully loaded.

4. You can use the ASSIGN button to assign TAs. The program will display the assignment at the end of the window once
finished.
