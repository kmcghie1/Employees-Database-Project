package com.sparta.kmcgh.cvsproject.files;

import com.sparta.kmcgh.cvsproject.dto.EmployeeDTO;
import com.sparta.kmcgh.cvsproject.jdbc.ConnectionManager;
import com.sparta.kmcgh.cvsproject.jdbc.UserDAO;

import java.sql.Connection;
import java.util.List;

public class CsvFilePusher extends Thread{
    private int listToDo;
    private List<EmployeeDTO> listPart;

    public CsvFilePusher(int listToDo, List<EmployeeDTO> listPart){
        this.listToDo = listToDo;
        this.listPart = listPart;
    }

    public static void pushFiles(List<EmployeeDTO> listPart){

        Connection connection = ConnectionManager.connectToDB();
        UserDAO userDAO = new UserDAO(connection);

        for(int i = 0; i < listPart.size(); i++){
            userDAO.createRecord(listPart.get(i).getEmployeeId(),
                    listPart.get(i).getNamePrefix(),
                    listPart.get(i).getFirstName(),
                    listPart.get(i).getMiddleInitial(),
                    listPart.get(i).getLastName(),
                    listPart.get(i).getGender(),
                    listPart.get(i).getEmail(),
                    listPart.get(i).getDateOfBirth(),
                    listPart.get(i).getDateOfJoining(),
                    listPart.get(i).getSalary());
        }
    }

    @Override
    public void run(){
        pushFiles(this.listPart);
    }


}
