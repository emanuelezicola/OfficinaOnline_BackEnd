package it.project.alpha.web.rest.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import it.project.alpha.web.rest.resources.AutoResource;
import it.project.alpha.web.rest.resources.UtenteResource;


public class RestServicesConfig extends Application {
	 public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(AutoResource.class);
        classes.add(UtenteResource.class);
        return classes;
	}
}