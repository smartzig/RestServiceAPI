package br.com.smartzig.rest.service.basic.bo.facade;


import java.util.Map;

import br.com.smartzig.rest.service.basic.bo.BasicBO;


public class BasicFacade {

	public Map<String, Integer> fetchMockUpInfo() throws Exception {
		// TODO create dao connection
		BasicBO bo = new BasicBO();

		try{
			return bo.fetchMockUpInfo();
		}finally {
			try{
				//TODO close conn.
			}catch (Exception e) {
				// TODO do some error control
			}

		}
	}

}
