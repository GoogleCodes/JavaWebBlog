package codeing.Web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/UploadServlet")
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
	
	// 上传配置
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE    = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	
	public FileUploadServlet() {
		super();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(req)) {
            // 如果不是则停止
            PrintWriter writer = resp.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        
        //	配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //	设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        //	设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        //	获取图片信息
//        Part part = req.getPart("uploadFile");
//        //	获取请求信息
//        String name = part.getHeader("content-disposition");
//        System.out.println(name);
        
        //	设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        
        //	设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
		
        //	中文处理
        upload.setHeaderEncoding("UTF-8");

        String userDir = req.getParameter("dirpath");
//        String uploadPath = req.getServletContext().getRealPath("/WEB-INF/upload");
//        System.out.println(uploadPath + "-------------------------------path");
    	
        //	构造临时路径来存储上传的文件
        //	这个路径相对当前应用的目录
//        System.out.println(req.getServletContext().getRealPath("/WEB-INF") + File.separator + UPLOAD_DIRECTORY + "---------------------------");
        String uploadPath = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\webapps\\ROOT\\images";	//req.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
	
        //	如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
	
        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(req);
 
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        req.setAttribute("message",
                            "文件上传成功!");
                    }
                }
            }
        } catch (Exception ex) {
            req.setAttribute("message","错误信息: " + ex.getMessage());
        }
        
        //	跳转到 message.jsp
        req.getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);
        
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);

		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

	}

}
