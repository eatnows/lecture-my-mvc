package org.example;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.web_calculator.CustomWebApplicationServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

// GET /calculate?operand1=11&operator=*&operand2=55
public class WebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);

    public static void main(String[] args) throws LifecycleException, IOException {
//        String webappDirLocation = "webapps/";
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//
//        tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());
//        log.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());
//
//        tomcat.start();
//        tomcat.getServer().await();

        new CustomWebApplicationServer(8080).start();
    }
}