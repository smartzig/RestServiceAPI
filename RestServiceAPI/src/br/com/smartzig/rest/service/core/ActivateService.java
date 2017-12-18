package br.com.smartzig.rest.service.core;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import br.com.smartzig.rest.service.basic.BasicService;

public class ActivateService extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public ActivateService() {

		singletons.add(new BasicService());
		
	}

	public Set<Object> getSingletons() {

		return singletons;
	}

	public Set<Class<?>> getEmpty() {

		return empty;
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		// TODO Auto-generated method stub
		return null;
	}

}
