package main.persistence;

/**
 * Created by wale on 2/2/15.
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.LoggerFactory;

public class HibernateUtil
{
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    private static final String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
    private static SessionFactory sessionFactory;
    private static Configuration configuration = new Configuration();
    private static String configFile = CONFIG_FILE_LOCATION;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static Session getSession() {
        logger.info("Get Session from session factory");
        return sessionFactory.getCurrentSession();
    }

    public static Session beginTransaction() {
        Session hibernateSession = getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }

    public static void commitTransaction() {
        getSession().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        try {
            getSession().getTransaction().rollback();
        } catch (Exception e) {
            logger.error("Session rollback error {}", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void closeSession() {
        try{
            getSession().close();
        }catch(Exception e){
            logger.error("Could not close session", e.toString());
        }

    }

    public static void setConfigFile(Configuration configFile) {
        configuration = configFile;
        sessionFactory = null;
    }

    public static Configuration getConfiguration()
    {
        return configuration;
    }
}
