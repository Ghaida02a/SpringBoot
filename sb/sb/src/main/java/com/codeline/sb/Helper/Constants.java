package com.codeline.sb.Helper;

public class Constants {

    public final static String Success = "Success";
    public final static String Bad_Request = "Bad Request";
    public final static String Not_Found = "Not Found";
    public final static String No_Data_Found = "No Data Found";

    // Course Create Request Constants
    public final static String COURSE_NAME = "Course name cannot be null";
    public final static String COURSE_HOURS_NOT_VALID = "Course hours are not valid";
    public final static String COURSE_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID = "Instructor ID is not valid";
    public final static String COURSE_CREATE_REQUEST_MARKS_NOT_VALID = "Marks are not valid";

    // Instructor Create Request Constants
    public final static String INSTRUCTOR_NAME = "Instructor name cannot be null";
    public final static String INSTRUCTOR_EMAIL = "Instructor email cannot be null";
    public final static String INSTRUCTOR_PHONE_NUMBER = "Instructor phone number cannot be null";
    public final static String INSTRUCTOR_DESIGNATION = "Instructor designation cannot be null";
    public final static String INSTRUCTOR_CREATE_REQUEST_DEPARTMENT_ID_NOT_VALID = "Instructor designation cannot be null";
    public final static String INSTRUCTOR_CREATE_REQUEST_COURSE_NOT_VALID = "Instructor course ID is not valid";

    //Department Create Request Constants
    public final static String DEPARTMENT_NAME = "Department Name cannot be null";

    // Mark Create Request Constants
    public final static String MARK_STUDENT_NAME_NOT_VALID = "Mark Student name cannot be null";
    public final static String MARK_SCORE_NOT_VALID = "Mark score is not valid";
    public final static String MARK_COURSE_ID_NOT_VALID = "Mark course ID is not valid";
    public final static String MARK_NOT_FOUND = "Mark not found";
    public final static String MARK_CREATE_REQUEST_COURSE_ID_NOT_VALID = "Mark course ID is not valid";
}
