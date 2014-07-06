/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package initializers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Khafaga
 */
public class HuContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
  
        System.out.println("-----------------------------------------------------------------started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed.");
    }
    
}
