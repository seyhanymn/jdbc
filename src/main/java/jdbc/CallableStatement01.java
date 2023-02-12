package jdbc;

import java.sql.*;

public class CallableStatement01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","1234");
        Statement st = con.createStatement();

        //1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.
        String sql1 = "CREATE OR REPLACE FUNCTION toplamaF(x NUMERIC, y NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                " BEGIN\n" +
                " \n" +
                " RETURN x+y;\n" +
                " \n" +
                " END\n" +
                "$$";


        st.execute(sql1);


        CallableStatement cst1 = con.prepareCall("{? = call toplamaF(?, ?)}");

        cst1.registerOutParameter(1, Types.NUMERIC);
        cst1.setInt(2,-5);
        cst1.setInt(3,5);


        cst1.execute();


        System.out.println(cst1.getBigDecimal(1));

//              =============================================


        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.

        String sql2 = "CREATE OR REPLACE FUNCTION koniHacmi(r NUMERIC, h NUMERIC)\n" +
                "RETURNS NUMERIC\n" +
                "LANGUAGE plpgsql\n" +
                "AS\n" +
                "$$\n" +
                " BEGIN\n" +
                " \n" +
                " RETURN 3.14 * r * r * h / 3;\n" +
                " \n" +
                " END\n" +
                "$$";

        st.execute(sql2);
        CallableStatement cst2 = con.prepareCall("{? = call koniHacmi(?, ?)}");
        cst2.registerOutParameter(1, Types.NUMERIC);
        cst2.setInt(2,1);
        cst2.setInt(3,1);
        cst2.execute();
        System.out.println(cst2.getBigDecimal(1));
    }
}