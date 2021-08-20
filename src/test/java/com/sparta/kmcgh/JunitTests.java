package com.sparta.kmcgh;

import com.sparta.kmcgh.cvsproject.dto.EmployeeDTO;
import com.sparta.kmcgh.cvsproject.files.CsvFileCleaner;
import com.sparta.kmcgh.cvsproject.files.CsvFileReader;
import com.sparta.kmcgh.cvsproject.files.CsvFileSplitter;
import com.sparta.kmcgh.cvsproject.files.CsvFileTimer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JunitTests {

    ArrayList<EmployeeDTO> fileReaderTest = CsvFileReader.readFromFile("src/main/resources/EmployeeRecords.csv");
    ArrayList<EmployeeDTO> bigFileReaderTest = CsvFileReader.readFromFile("src/main/resources/EmployeeRecordsLarge.csv");
    ArrayList<EmployeeDTO> fileCleanerTest = CsvFileCleaner.cleanFile(fileReaderTest);
    ArrayList<EmployeeDTO> bigFileCleanerTest = CsvFileCleaner.cleanFile(bigFileReaderTest);
    ArrayList<List<EmployeeDTO>> fileSplitterTest = CsvFileSplitter.splitFiles(fileReaderTest, fileCleanerTest, 32);


    public JunitTests() throws InterruptedException {
    }

    @Test // Tests whether the ArrayList is successfully returned if the PATH string for the file name can be found.
    void fileIsAvailable(){
        Assertions.assertEquals(fileReaderTest, CsvFileReader.readFromFile("src/main/resources/EmployeeRecords.csv"));
    }

    @Test // Tests whether null is returned if the PATH string for the file name cannot be found.
    void fileIsNotAvailable(){
        Assertions.assertEquals(null, CsvFileReader.readFromFile("..."));
    }

    @Test // Tests whether the original ArrayList gets cleaned (duplicates removed), leaving the correct size of the array.
    void removingDuplicates(){
        Assertions.assertEquals(9943, fileCleanerTest.size());
    }

    @Test // Tests whether the program ignores non-duplicate values if the ArrayList has no duplicates.
    void keepingNonDuplicates(){
        Assertions.assertEquals(65499, bigFileCleanerTest.size());
    }

    @Test // Tests whether List is split into the correct number of Lists (and have those Lists stored within an ArrayList).
    void splittingArrayIntoCorrectAmount() throws InterruptedException {
        Assertions.assertEquals(32, fileSplitterTest.size());
    }

    @Test // Tests whether null is returned (ending the program) if the number of threads is reduced to 0.
    void zeroThreadsReturnMinusOne() throws InterruptedException {
        Assertions.assertEquals(null, CsvFileSplitter.splitFiles(fileReaderTest, fileCleanerTest, 0));
    }



}
