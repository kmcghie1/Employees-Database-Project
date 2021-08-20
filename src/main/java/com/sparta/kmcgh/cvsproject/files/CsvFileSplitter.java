package com.sparta.kmcgh.cvsproject.files;

import com.sparta.kmcgh.cvsproject.dto.EmployeeDTO;

import java.util.*;

public class CsvFileSplitter {

    public static ArrayList<List<EmployeeDTO>> splitFiles(ArrayList<EmployeeDTO> employeeList, ArrayList<EmployeeDTO> cleanEmployeeList, int threadNum) throws InterruptedException, IllegalThreadStateException {

//        int originalSize = employeeList.size();
        if(threadNum == 0){
            return null;
        }

        int startingIndex = 0;
        ArrayList<List<EmployeeDTO>> listStorer = new ArrayList<>();
        ArrayList<CsvFilePusher> threadStorer = new ArrayList<>();

        for(int i = 1; i < threadNum + 1; i++){
            List<EmployeeDTO> listArray = cleanEmployeeList.subList(startingIndex, (cleanEmployeeList.size()*(i) / threadNum));
            listStorer.add(listArray);
            startingIndex = (cleanEmployeeList.size()*(i) / threadNum);
        }

        for(int j = 1; j < threadNum + 1; j++){
            CsvFilePusher thread = new CsvFilePusher(j, listStorer.get(j-1));
            threadStorer.add(thread);
        }

        CsvFileTimer.timeFiles(threadNum, employeeList, cleanEmployeeList, threadStorer);

        return listStorer;

//        double start = System.nanoTime();
//
//        for(int k = 0; k < threadNum*2; k++){
//            if(k < threadNum){
//                threadStorer.get(k).start();
//            }
//            else {
//                threadStorer.get(k - threadNum).join();
//            }
//        }
//
//        double finish = System.nanoTime();
//        double totalTime = finish - start;
//        System.out.println("Original Size of List: " + originalSize + "\n" +
//                "Size without Duplicates: " + cleanEmployeeList.size() + "\n" +
//                "Number of Duplicates: " + (originalSize - cleanEmployeeList.size()) + "\n" +
//                "Total Time Taken: " + totalTime/1_000_000_000 + " seconds.");


    }
}
