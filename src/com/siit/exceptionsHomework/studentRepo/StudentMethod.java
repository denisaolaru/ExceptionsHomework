package com.siit.exceptionsHomework.studentRepo;

import java.util.List;

public interface StudentMethod {

    void addStudent ( Student student );

    void deletestudent ( Student student , String CNP );

    int retrieveStudentsWithAgeX ( int age , Student student );

}
