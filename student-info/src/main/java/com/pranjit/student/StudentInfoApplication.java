package com.pranjit.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class StudentInfoApplication {

	public static void main(String[] args) {
		mysqlConnection();
		SpringApplication.run(StudentInfoApplication.class, args);

	}

	private static void mysqlConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			// here root is username and password
			Statement stmt = con.createStatement();
			stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS college");
			stmt.executeUpdate(
					"CREATE TABLE IF NOT EXISTS college.studentinfo(slno int primary key AUTO_INCREMENT, fname VARCHAR(50),mname VARCHAR(50),lname VARCHAR(50),email VARCHAR(50),gender VARCHAR(50), rollNo INT, PRN INT,sem VARCHAR(50), dept VARCHAR(50))");

			stmt.close();
			con.close();
			System.out.println("connection successful");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
