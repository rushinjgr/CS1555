/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dbfiller;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author wille
 */
public class DBFiller {

    //JDBC driver name and database URL
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("STARTIN UP!\n");
        executeSQLQuery("INSERT INTO player VALUES(5,'Roberto','Ramirez',to_date('1985/05/06','yyyy/mm/dd'),'USA')");
    }
    
    private static void executeSQLQuery(String sql){
        try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createSQLQuery(sql);
        q.executeUpdate();
        session.getTransaction().commit();       
        }
        catch (HibernateException he){
            he.printStackTrace();
         }
    }
 
}