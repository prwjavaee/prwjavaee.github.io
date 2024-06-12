package com.four.products.util;

import java.util.ArrayList;
import java.util.List;

import com.four.products.dao.ProductImageDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class ProductInit implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	if(!ProductImageDAO.check()) {
			List<String> images = new ArrayList<>();
			images.add("belt.webp");
			images.add("watch.jpg");
			images.add("waterbottle.jpg");
			int productID = 101;
			for (String image : images) {
				String searchPath = "/four/products/image/" + image;
				String imageAbsolutePath = context.getRealPath(searchPath);
				insertProductPic(imageAbsolutePath, image, productID);
				productID++;
			}			
		}
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }
	
    public static void insertProductPic(String filePath, String fileName, int productID) {
		String workspacePath = "Workout/src/main/webapp/four/products/image/";
		String parentDir = filePath.replaceAll("(.*)\\.metadata.*", "$1");
        String converted = parentDir.replaceAll("\\\\", "/");
        StringBuilder absolutePath = new StringBuilder();
		absolutePath.append(converted);
		absolutePath.append(workspacePath + fileName);
		ProductImageDAO.initInsert(absolutePath.toString(), productID);
	}
}
