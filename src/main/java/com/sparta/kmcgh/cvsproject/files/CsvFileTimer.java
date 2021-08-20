package com.sparta.kmcgh.cvsproject.files;

import com.sparta.kmcgh.cvsproject.dto.EmployeeDTO;

import java.util.ArrayList;

public class CsvFileTimer {
    public static int timeFiles(int threadNum, ArrayList<EmployeeDTO> employeeList, ArrayList<EmployeeDTO> cleanEmployeeList, ArrayList<CsvFilePusher> threadStorer) throws InterruptedException {

        int originalSize = employeeList.size();

        double start = System.nanoTime();

        for(int k = 0; k < threadNum*2; k++){
            if(k < threadNum){
                threadStorer.get(k).start();
            }
            else {
                threadStorer.get(k - threadNum).join();
            }
        }

        double finish = System.nanoTime();
        double totalTime = finish - start;
        System.out.println("Original Size of List: " + originalSize + "\n" +
                "Size without Duplicates: " + cleanEmployeeList.size() + "\n" +
                "Number of Duplicates: " + (originalSize - cleanEmployeeList.size()) + "\n" +
                "Total Time Taken: " + totalTime/1_000_000_000 + " seconds.");

        return (int)totalTime;
    }
}
