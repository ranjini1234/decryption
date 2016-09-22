

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import jxl.write.WriteException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		DAO d2=new DAO();
		d2.instantiate();
		System.out.println(request.getParameter("comment"));
		Employee r=d2.displayEmployee(Integer.parseInt(request.getParameter("find")));
		System.out.println(r.getFirstname());
		out.println("<table class='table table-responsive table-bordered table-condensed'>");
		out.println("<thead><tr><th>Emp Id</th><th>Firstname</th><th>Email</th></tr></thead>");
		out.println("<tr><td>"+r.getEmpid()+"</td><td>"+r.getFirstname()+"</td><td>"+r.getEmail()+"</td></tr>");
		out.print("</table>");
		out.println("<form name='update' action='SendReceive' method='get'>");
		out.println("<input type='hidden' name='details' value='"+r.getEmpid()+"'>");
		out.println("<input type='submit' class='btn btn-primary' value='Update details'>");
		out.println("</form>");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
		// TODO Auto-generated method stub
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		System.out.println("Hello");
		String UPLOAD_DIRECTORY = "upload";
		// Configure a repository (to ensure a secure temp location is used)
		factory.setSizeThreshold(50*1024);
		
		List formItems;
		try {
			ServletFileUpload upload = new ServletFileUpload(factory);
			formItems = upload.parseRequest(request);
			Iterator iter = formItems.iterator();
			String uploadPath = "C:\\Users\\Sunandan\\Documents\\NetBeansProjects\\NaveenPro\\NaveenPro-war\\web";
			 
			// iterates over form's fields
			while (iter.hasNext()) {
			    FileItem item = (FileItem) iter.next();
			    // processes only fields that are not form fields
			    if (!item.isFormField()) {
			        String fileName = new File(item.getName()).getName();
			        String filePath = uploadPath + File.separator + fileName;
			        File storeFile = new File(filePath);
			        System.out.println(filePath);
			 
			        // saves the file on disk
			        item.write(storeFile);
			    }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReadFileEnc rfe = new ReadFileEnc();
            try {
                rfe.readExcelEnc();
            } catch (WriteException ex) {
                Logger.getLogger(DisplayServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(DisplayServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
	
	}
	

}
