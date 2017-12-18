package br.com.smartzig.rest.service.listener;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppWebListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {

		ServletContext context = event.getServletContext();
		loadProperties();
		putMaxUploadSize(context);

	}

	private void loadProperties() {
		File confRootDir = new File(System.getProperty("br.com.smartzig.rest.service.properties.root.path"));
		loadPropertyFiles(confRootDir);
	}

	private static final void loadPropertyFiles(File root) {
		if (root.isDirectory()) {
			File[] files = root.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					loadPropertyFiles(file);
				} else {
					if (file.getName().endsWith(".properties")) {
						try {
							Properties prop = new Properties();
							FileInputStream fis = new FileInputStream(file);
							prop.load(fis);
							fis.close();
							loadSysProp(prop);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		}
	}

	private static final void loadSysProp(Properties prop) {
		Set<Object> keys = prop.keySet();
		for (Object obj : keys) {
			String key = obj.toString();
			System.setProperty(key, prop.getProperty(key));
		}
	}

	private void putMaxUploadSize(ServletContext context) {
		Long size = 0L;
		try {
			size = Long.valueOf(System.getProperty("br.com.smartzig.rest.service.web.max.upload.size"));
		} catch (Exception ex) {
			size = 1024000L;
		}
		context.setAttribute("maxUploadSize", size);
	}

	@Override
	public void contextDestroyed(ServletContextEvent evt) {

	}

}
