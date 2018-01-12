package main.fi;

import main.persistence.HibernateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Longbridge PC on 1/10/2018.
 */
public class Helper {

    private static final Logger logger = LoggerFactory.getLogger(Helper.class);

    private final static SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy");

    public Helper() {
    }

    public static String isSystemApproved(String ipAddress) {
        String isApproved="N";
        logger.info("Begin check for system approved status on  {}",ipAddress);
        try {
            //todo
            HibernateUtil.beginTransaction();
            String e = "select k.system_desc from kas_approved_systems_tbl k where k.IP_ADDRESS=:ipAddress";
            List entities = HibernateUtil.getSession().createSQLQuery(e).setParameter("ipAddress",ipAddress).list();
            if (entities.size() > 0) {
                isApproved ="Y";
            }
            HibernateUtil.commitTransaction();
        } catch (Exception e) {
            isApproved = e.toString();
            logger.error("Error encountered wile  Fetching Approved system stattus  {}", e.toString());
        }
        finally {
            HibernateUtil.closeSession();
        }
        logger.info("Result for IP Address "+ipAddress+"  is "+isApproved);
        return isApproved;
    }
}
