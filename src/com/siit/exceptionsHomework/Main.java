package com.siit.exceptionsHomework;


import com.siit.exceptionsHomework.studentRepo.Student;
import com.siit.exceptionsHomework.studentRepo.StudentMethod;
import com.siit.exceptionsHomework.utils.ValidationExeption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static final Logger LOGGER = Logger.getLogger ( Main.class.getTypeName ( ) );


    public static void main ( String args[] ) {

        Student student1 = new Student ( "" , "" , "January 2, 2067" , 'g' , "" );
        Student student2 = new Student ( "pal" , "mara" , "March 25, 1991" , 'F' , "2910125039945" );
        Student student3 = new Student ( "popa" , "andrei" , "July 10, 1986" , 'M' , "1860710652241" );


        HashMap<String, Student> studentHashMap = new HashMap<String, Student> ( );
        studentHashMap.put ( student1.getCNP ( ) , student1 );
        studentHashMap.put ( student2.getCNP ( ) , student2 );
        studentHashMap.put ( student3.getCNP ( ) , student3 );

        System.out.println ( "The list before removing a Student is:" );
        System.out.println ( studentHashMap );

        // delete student by ID (CNP)
        System.out.println ( "The list after removing a student is:" );
        studentHashMap.remove ( student2.getCNP ( ) );
        System.out.println ( studentHashMap );

        LOGGER.log ( Level.INFO , "test" );
        try {
            verifyDateOfBirth ( student1 );
        } catch (ValidationExeption e) {
            System.out.println ( "birth date invalid :" + e.getMessage ( ) );
        } finally {
            System.out.println ( " Program terminat" );
        }

        LOGGER.log ( Level.INFO , "test2" );
        try {
            verifyFistName ( student1.getFirstName ( ) );
        } catch (ValidationExeption e) {
            System.out.println ( "first name invalid :" + e.getMessage ( ) );
        } finally {
            System.out.println ( " Program terminat" );
        }


        try {
            verifyLastName ( student1.getLastName ( ) );
        } catch (ValidationExeption e) {
            System.out.println ( "last name invalid :" + e.getMessage ( ) );
        } finally {
            System.out.println ( " Program terminat" );
        }


        try {
            verifyGender ( student1.getGender ( ) );

        } catch (ValidationExeption e) {
            System.out.println ( "gender invalid :" + e.getMessage ( ) );
        } finally {
            System.out.println ( " Program terminat" );
        }


        try {
            verifyID ( student1.getCNP ( ) );
        } catch (ValidationExeption e) {
            System.out.println ( "Empty ID" + e.getMessage ( ) );
        }


        try {
            verifyAge ( student1 , student1.getBirthDate ( ).getYear ( ) - 2019 );
        } catch (ValidationExeption e) {
            System.out.println ( "Age is not a number " + e.getMessage ( ) );
        }
    }

    public static int verifyDateOfBirth ( Student student ) throws ValidationExeption {
        if ( student.getBirthDate ( ).getYear ( ) < 1900 )
            throw new ValidationExeption ( "the year should be higher than 1900" );
        else if ( student.getBirthDate ( ).getYear ( ) > Calendar.getInstance ( ).get ( Calendar.YEAR ) )
            throw new ValidationExeption ( "you can't be born in the future" );
        else return student.getBirthDate ( ).getYear ( );
    }

    public static String verifyFistName ( String firstName ) throws ValidationExeption {

        if ( firstName == null || firstName == "" ) {
            throw new ValidationExeption ( "first name empty" );
        } else return firstName;
    }

    public static String verifyLastName ( String lastName ) throws ValidationExeption {

        if ( lastName == null || lastName == "" ) {
            throw new ValidationExeption ( "last name  empty" );
        } else return lastName;
    }

    public static char verifyGender ( char gender ) throws ValidationExeption {
        if ( !(gender == 'm' || gender == 'M' || gender == 'f' || gender == 'F') ) {
            throw new ValidationExeption ( "gender should be F/f or M/m" );
        } else return gender;

    }

    public static String verifyID ( String CNP ) throws ValidationExeption {
        if ( CNP == null || CNP == "" ) {
            throw new ValidationExeption ( "Student does not exist" );
        } else return CNP;

    }

    public static int verifyAge ( Student student , int age ) throws ValidationExeption {
        if ( student.studentAge ( ) < 0 ) {
            throw new ValidationExeption ( "age is negative" );
        } else return student.studentAge ( );

    }

}


