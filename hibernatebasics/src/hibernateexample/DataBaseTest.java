package hibernateexample;
/**
 * Aaron Foote
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StringRepresentableType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.TransactionScoped;
import java.util.*;

public class DataBaseTest {
    SessionFactory factory = null;
    Session session = null;

    private static DataBaseTest single_instance = null;

    private DataBaseTest()
    {
        factory = HibernateUtil.getSessionFactory();
    }

    /** This is what makes this class a singleton.  You use this
     *  class to get an instance of the class. */
    public static DataBaseTest getInstance()
    {
        if (single_instance == null) {
            single_instance = new DataBaseTest();
        }

        return single_instance;
    }

    /** Used to get more than one customer from database
     *  Uses the OpenSession construct rather than the
     *  getCurrentSession method so that I control the
     *  session.  Need to close the session myself in finally.*/
    public List<Bikes> getBikes() {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernateexample.Bikes";
            List<Bikes> bl = (List<Bikes>)session.createQuery(sql).getResultList();
            session.getTransaction().commit();
            return bl;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }

    }

    /** Used to get a single customer from database */
    public Bikes getBikes(int bike_id) {

        try {
            session = factory.openSession();
            session.getTransaction().begin();
            String sql = "from hibernateexample.Bikes where bike_id=" + Integer.toString(bike_id);
            Bikes c = (Bikes) session.createQuery(sql).getSingleResult();
            session.getTransaction().commit();
            return c;

        } catch (Exception e) {
            e.printStackTrace();
            // Rollback in case of an error occurred.
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }


}//end DataBaseTest
