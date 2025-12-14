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
    public final static String ACTIVE_COURSES_LIST_EMPTY = "Active courses list is empty";

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

    //Student create
    public final static String ACTIVE_STUDENTS_LIST_EMPTY = "Active student list is empty";
    public final static String STUDENT_ID_IS_NOT_VALID = "Student id is not valid";
    public final static String STUDENT_DELETED_SUCCESS = "Student deleted successfully";
    public final static String STUDENT_FIRST_NAME_NOT_VALID = "Student first name cannot be null";
    public final static String STUDENT_Last_NAME_NOT_VALID = "Student last name cannot be null";
    public final static String STUDENT_EMAIL_NAME_NOT_VALID = "Student email cannot be null";
    public final static String STUDENT_DATE_OF_BIRTH_NOT_VALID = "Student date of birth cannot be null";
    public final static String STUDENT_GENDER_NOT_VALID = "Student gender cannot be null";
    public final static String STUDENT_PHONE_NUMBER_NOT_VALID = "Student must have at least one phone number";
    public final static String STUDENT_ADDRESS_NOT_VALID = "Student address cannot be null";
    public final static String STUDENT_PHONE_NUMBERS_IS_NULL = "Student Phone Numbers is null";

    //Phone Number Create Constants
    public final static String STUDENT_PHONE_NUMBER_NOT_FOUND = "Student Phone Number not valid";
    public final static String PHONE_NUMBER_NOT_VALID = "Phone Number not valid";
    public final static String PHONE_NUMBER_COUNTRY_CODE_NOT_VALID = "Phone Number country code is not valid";
    public final static String PHONE_NUMBER_LAND_LINE_NOT_VALID = "Phone Number land line is not valid";
    public final static String PHONE_NUMBER_STUDENT_ID_NOT_VALID = "Phone Number student id is not valid";

    //Address Create Constants
    public final static String ADDRESS_HOUSE_NUMBER_NOT_VALID = "Address house number cannot be null";
    public final static String ADDRESS_STREET_NOT_VALID = "Address street cannot be null";
    public final static String ADDRESS_CITY_NOT_VALID = "Address city cannot be null";
    public final static String ADDRESS_STATE_OR_PROVINCE_NOT_VALID = "Address state/Province cannot be null";
    public final static String ADDRESS_COUNTRY_NOT_VALID = "Address country cannot be null";
    public final static String ADDRESS_POSTAL_CODE_NOT_VALID = "Address Postal Code cannot be null";
    public final static String ADDRESS_STUDENT_ID_NOT_VALID = "Address Student id cannot be null";
    public final static String ADDRESS_NOT_FOUND = "Address not found";
    public final static String PHONE_NUMBER_NOT_FOUND = "Phone Number not found";
    public final static String PHONE_NUMBER_DELETED_SUCCESS = "Phone Number deleted successfully";

    public final static String STUDENT_OBJECT_NOT_VALID = "Student details cannot be empty";
}
