package com.crossover.lanbackup.client;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class App {
	
	public static final String BASE_URL = "http://192.168.0.181:81/api/";
	public static final String LOGIN = "backupworker";
	public static final String PASSWORD = "backupworker";
	
	
	public static void main(String[] args) {
        Collection<File> folders = FileUtils.listFilesAndDirs(new File("."), 
        		new NotFileFilter(TrueFileFilter.INSTANCE), DirectoryFileFilter.DIRECTORY);
        		
        for (File f : folders) {
            System.out.println(f.getName());
        }
        
        StringBuilder foldersSB = new StringBuilder();
        for (File folder : folders) {
        	foldersSB.append(folder.getAbsolutePath());
        	foldersSB.append(",");
        }
        String foldersString = foldersSB.length() > 0 ? foldersSB.substring(0, foldersSB.length() - 1) : "";
        
        Client c = Client.create();
        c.addFilter(new HTTPBasicAuthFilter(LOGIN, PASSWORD));
        WebResource webResource = c.resource(BASE_URL).path("backupworker").path("updateFolders");

        String response = webResource.accept("application/json")
                .type("application/json").post(String.class, foldersString);
        
    /*    
        
      
        String response = resource.get(String.class);
        
        System.out.println(response);
        
        resource = c.resource(BASE_URL);
        
         // POST method
        ClientResponse response = resource.accept("application/json")
                .type("application/json").post(ClientResponse.class, folders);

        // check response status code
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        // display response
        String output = response.getEntity(String.class);
        System.out.println("Output from Server .... ");
        System.out.println(output + "\n");
        
        */
	}
}
