package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "D:/Github/project/JSP-Project/WebContent/image/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*System.out.println("Servlet Upload File Start !!!");
		if(ServletFileUpload.isMultipartContent(request)){
			System.out.println(ServletFileUpload.isMultipartContent(request));
			            try {
			                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			                for(FileItem item : multiparts){
			                	System.out.println(item);
			                    if(!item.isFormField()){
			                        String name = new File(item.getName()).getName();
			                        System.out.println(name);
			                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
			                        request.setAttribute("image", name);
			                    }
			                }

			               //File uploaded successfully
			
			               request.setAttribute("message", "File Uploaded Successfully");
			
			            } catch (Exception ex) {
			               request.setAttribute("message", "File Upload Failed due to " + ex);
			            }         
			        }else{
			            request.setAttribute("message","Sorry this Servlet only handles file upload request");
			        }
		
		request.getRequestDispatcher("/result.jsp").forward(request, response);*/
		
		File filenameImg;
        List<FileItem> items = null;
        try {
            items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        } catch (FileUploadException e) {
            throw new ServletException("Cannot parse multipart request.", e);
        }

        for (FileItem item : items) {
            if (item.isFormField()) {
                // Process regular form fields here the same way as
                // request.getParameter().
                // You can get parameter name by
                item.getFieldName();
                // You can get parameter value by item.getString();
            } else {

                try{
                    // Process uploaded fields here.
                    String filename = FilenameUtils.getName(item.getName());

                    File file =  new File(UPLOAD_DIRECTORY + File.separator + filename);


                    //File file = new File("C:\\", filename);

                    // Define destination file.

                    item.write(file);
                    System.out.println("filename: "+filename);
                    System.out.println("file: "+file);
                    request.setAttribute("image", "image/"+filename);
                    filenameImg = file;
                    // Write to destination file.
                //  request.setAttribute("image", filename);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        // Show result page.


        System.out.println("request : "+request.getAttribute("image"));
        response.setContentType("image/jpeg"); 
        request.getRequestDispatcher("result.jsp").forward(request, response);

        /*String nextJSP = "/result.jsp";
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);*/
		
	}

}
