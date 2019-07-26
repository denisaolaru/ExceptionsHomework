package com.siit.exceptionsHomework.studentRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Student implements StudentMethod {
    private String firstName;
    private String LastName;
    private String birthDate;
    private char gender;
    private String CNP;

    private Set<Student> lista = new LinkedHashSet<> ( );

    public Student ( String firstName , String lastName , String birthDate , char gender , String CNP ) {
        this.firstName = firstName;
        LastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.CNP = CNP;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return LastName;
    }

    public LocalDate getBirthDate () {
        // String string = "January 2, 2010";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "MMMM d, yyyy" , Locale.ENGLISH );
        LocalDate date = LocalDate.parse ( birthDate , formatter );
        return date;
    }

    public char getGender () {
        return gender;
    }

    public String getCNP () {
        return CNP;
    }

    public int studentAge () {
        int currentYear = Calendar.getInstance ( ).get ( Calendar.YEAR );
        return (currentYear - getBirthDate ( ).getYear ( ));
    }


    @Override
    public void addStudent ( Student student ) {
        lista.add ( student );


    }

    @Override
    public void deletestudent ( Student student , String CNP ) {
        lista.remove ( student.getCNP ( ) );

    }

    @Override
    public int retrieveStudentsWithAgeX ( int age , Student student ) {
        int age1 = studentAge ( );
        if ( age1 == age )
            return studentAge ( );
        else return Integer.parseInt ( null );
    }


    @Override
    public String toString () {
        return "firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}

