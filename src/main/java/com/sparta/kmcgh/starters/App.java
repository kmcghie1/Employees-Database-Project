package com.sparta.kmcgh.starters;

import com.sparta.kmcgh.cvsproject.files.CsvFileReader;

public class App {
    public static void main( String[] args ) {
        CsvFileReader.readFromFile("src/main/resources/EmployeeRecords.csv");
    }

}
