package com.sparta.kmcgh.cvsproject.files;

import com.sparta.kmcgh.cvsproject.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CsvFileCleaner {
    public static ArrayList<EmployeeDTO> cleanFile(ArrayList<EmployeeDTO> employeeList) throws InterruptedException {

        ArrayList<EmployeeDTO> cleanEmployeeList = (ArrayList<EmployeeDTO>) employeeList.stream()
                .distinct()
                .collect(Collectors.toList());

        CsvFileSplitter.splitFiles(employeeList, cleanEmployeeList, 100);

        return cleanEmployeeList;
    }
}
