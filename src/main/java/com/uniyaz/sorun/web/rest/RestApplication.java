package com.uniyaz.sorun.web.rest;


import com.sun.jersey.spi.container.servlet.ServletContainer;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by AKARTAL on 27.12.2019.
 */
@WebServlet(urlPatterns = "/rest/*", name = "RestServlet",
        initParams =
                {
                        @WebInitParam(name = "com.sun.jersey.config.property.packages", value = "com.uniyaz.sorun.web.rest"),
                        @WebInitParam(name = "com.sun.jersey.api.json.POJOMappingFeature", value = "true"),
                })
public class RestApplication extends ServletContainer {
}