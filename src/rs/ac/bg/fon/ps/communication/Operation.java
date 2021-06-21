/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

import java.io.Serializable;

/**
 *
 * @author Cartman
 */
public enum Operation implements Serializable{
    LOGIN,
    GET_ALL_FACULTIES,
    GET_ALL_STUDENTS,
    GET_ALL_LOCATIONS,
    GET_ALL_LECTURERS,
    ADD_STUDENT,
    EDIT_STUDENT,
    DELETE_STUDENT,
    ADD_COURSE,
    GET_ALL_COURSES,
    DELETE_COURSE,
    DELETE_COURSE_ITEMS,
    EDIT_COURSE,
    LOGOUT,
    ADD_LECTURER
}
