package ca.credativ.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Array;

/**
 * Created by davec on 2014-04-16.
 */
public class SpringTransactionExample
{

    public static void main(String []args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");


        try
        {
            PostgresArray postgresArray = (PostgresArray)applicationContext.getBean("postgresArrayImpl");

            String []strings = postgresArray.get() ;
            for (int i=0;i < strings.length;i++)
            {
                System.out.println(strings[i]);
            }
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
