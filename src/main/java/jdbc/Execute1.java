package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");


      Connection con=   DriverManager.getConnection("jdbc:postgresql://localhost:5432/day3","postgres","19122008");


       Statement st= con.createStatement();


        String sql1="Create table workers(worker_id varchar(50),worker_name varchar(50),worker_salary int)";

        boolean result =st.execute(sql1);
        System.out.println(result);


        //2.örnek
        String sql2= "alter table workers add worker_adress varchar(80)";
        st.execute(sql2);




        String sql3="drop table workers";
        st.execute(sql3);



        con.close();
        st.close();
    }
}
