package com.sparta.kmcgh.cvsproject.files;

import com.sparta.kmcgh.cvsproject.dto.EmployeeDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvFileReader {
    public static void readFromFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<EmployeeDTO> employeeList = new ArrayList<>();

            for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()){
                employeeList.add(new EmployeeDTO(line.split(",")));
            }

            CsvFileCleaner.cleanFile(employeeList);

            bufferedReader.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.err.println("File not found.");
        }
    }
}
