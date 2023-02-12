package jdbc;

import java.sql.*;

public class Execute2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");


        Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/day3","postgres","19122008");
/*
"jdbc:postgresql:// bura standart
localhost:5432/day3","postgres","19122localhost:5432/day3","postgres","19122 kendi çalışmamızın olduğu yer

 */
        Statement st=con.createStatement();

        //1 region idsi 1 olan country name cağır

        String sql1="select country_name from countries where region_id =1";
        // boolean r1=st.execute(sql1);//bu sadece boolean sonuc verir tabloyu bana göstermez
       // System.out.println(r1);tru verdi

     //recordları görmrkiçin select data çağırır

         ResultSet result1=st.executeQuery(sql1);
         //resultları görmek için eexecuteQuery kullanılr
         //executeQuery(sql1) resultset verir set olduğu için içinde tek  bir veri yok tek tek almak için while kullandık
         while (result1.next()){
             //sıradaki data olduğu müdettece calışır gösterir
            System.out.println(result1.getString("country_name"));


        }

        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql2="select country_id, country_name fron countries where region_id>2";

         ResultSet result2=st.executeQuery(sql2);

         while(result2.next()){
             System.out.println(result2.getString("country_id")+"-->"+result2.getString("country_name"));
         }

        //3.Example: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.

       // String str="select * from companies where number_of_employees=(select min(number_of_employees)from companies)";

         //ResultSet resultt=st.executeQuery(str);

        //while(resultt.next()){
           //  System.out.println(resultt.getInt(1) +
                 //    resultt.getString(2) +
                   //  resultt.getInt(3));
        // }

    }



}
