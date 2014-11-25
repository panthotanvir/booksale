package net.teamname.booksale.listener;

/**
 * Created by panthotanvir on 11/25/14.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private static final Logger log = LoggerFactory.getLogger(SessionListener.class);
    private int sessionCount = 0;

    public void sessionCreated(HttpSessionEvent event) {
        synchronized (this) {
            sessionCount++;
        }
        log.debug("Session Created " + event.getSession().getId());
        log.debug("Total Session " + sessionCount);

    }

    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized (this) {
            sessionCount--;
        }
        log.debug("Session Destroyed " + event.getSession().getId());
        log.debug("Total Session " + sessionCount);
    }
}
