package com.soapui.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.mock.WsdlMockService;
import com.eviware.soapui.model.mock.MockService;
import com.eviware.soapui.tools.SoapUIMockServiceRunner;


public class SoapUIMain {

	public static void main(String[] args) {
		List<String> pathsList = new ArrayList<>();
		try {
			String projectsListPath = System.getenv("SOAP_PROJECTS");
			populateProjectsList(pathsList,projectsListPath);

		} catch (Throwable th) {
			th.printStackTrace();
		}
		
		for(int i=0;i<pathsList.size();i++) {
			String pathToProject = pathsList.get(i);
			try {
				WsdlProject project = new WsdlProject(pathToProject);
				System.out.printf("MOCK SERVICES COUNT for project %s: %s %n",pathToProject,+project.getMockServiceCount());
				for (int c = 0; c < project.getMockServiceCount(); c++) {
					MockService ms = project.getMockServiceAt(c);
					new SoapUIMockServiceRunner().runMockService((WsdlMockService)ms);
				}
			}
			catch(Throwable e) {
				e.printStackTrace();
			}	
		}
		 
		System.out.println("End of Class: SoapUIMain");
	}
	
	private static void populateProjectsList(List<String> pathsList,String projectsListPath) {
		File file = new File(projectsListPath);
		for(File f : file.listFiles()){
			pathsList.add(f.getAbsolutePath());
			System.out.println(f.getAbsolutePath());
		}
	}
}
