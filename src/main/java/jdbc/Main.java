package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        DBWork db = new DBWork();


        Connection con = db.connect_to_db("Techpro","postgres","1234");


        db.createTable(con,"employees");

    }
}