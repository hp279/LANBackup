package com.crossover.lanbackup.client;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class App {
	public static void main(String[] args) {
        Collection<File> files = FileUtils.listFiles(new File("."), null, true);
        for (File f : files) {
            System.out.println(f.getName());
        }
        
        Client c = Client.create();
        WebResource resource = c.resource("http://192.168.0.181:81/api/hello/say/test");
        String response = resource.get(String.class);
        
        System.out.println(response);
	}
}
