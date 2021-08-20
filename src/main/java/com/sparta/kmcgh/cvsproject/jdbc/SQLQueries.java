package com.sparta.kmcgh.cvsproject.jdbc;

public interface SQLQueries {
    String SELECT_ALL = "SELECT * FROM user_db.users";
    String INSERT_INTO_DB = "INSERT INTO `employee_db`.`employees` (`id`, `prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `date_of_birth`, `date_of_joining`, `salary`) VALUES (?,?,?,?,?,?,?,?,?,?);";
    String UPDATE = "UPDATE `user_db`.`users` SET `user_name` = ?, `email` = ? WHERE `id` = ?";
    String DELETE = "DELETE FROM `user_db`.`users` WHERE `id` = ?";
}
