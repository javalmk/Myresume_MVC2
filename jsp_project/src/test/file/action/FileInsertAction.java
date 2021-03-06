package test.file.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FileInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		/*
			http://mvnrepository.com/ 에서 
			commons io 검색해서 commons-io.jar 파일 다운로드
			commons fileupload 검색해서 commons-fileupload 파일 다운로드
			해서 
			WEB-INF/lib/ 폴더 안에 넣으면 
			아래와 같이 파일 업로드 처리를 할수 있다. 
		*/

		//삭제할 파일의 아이디를 읽어와서 삭제하고 새로운 사진 삽입하기
				HttpSession session = request.getSession();
				String id =(String)session.getAttribute("id");
				//1. 삭제할 파일의 저장된 파일명을 읽어온다.
				FileDto deleteDto=FileDao.getInstance().getData(id);
				if(deleteDto!=null) {
					String saveFileName=deleteDto.getSaveFileName();
					//2. DB 에서 파일 정보 삭제
					FileDao.getInstance().delete(id);
					//3. 파일 시스템에서 삭제 
					ServletContext application=request.getServletContext();
					//삭제할 파일의 절대 경로 구성하기 
					
					String path=application.getRealPath("/upload")+
			 		File.separator+saveFileName;
					//File 객체생성해서 삭제하기 
					new File(path).delete();
				}
		
		//업로드 설정
		final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
		final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
		final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB	
		
		
	    //실제로 업로드한 파일이 있는지 체크 한다.
	    if (!ServletFileUpload.isMultipartContent(request)) {
	        //업로드한 파일이 없다면 예외 처리를 한다. 
	        PrintWriter writer=null;
			try {
				writer = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        writer.println("Error: Form must has enctype=multipart/form-data.");
	        writer.flush();
	        
	    }
	
	    // configures upload settings
	    DiskFileItemFactory factory = new DiskFileItemFactory();
	    // sets memory threshold - beyond which files are stored in disk
	    factory.setSizeThreshold(MEMORY_THRESHOLD);
	    // sets temporary location to store files
	    factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    // sets maximum size of upload file
	    upload.setFileSizeMax(MAX_FILE_SIZE);
	    // sets maximum size of request (include file + form data)
	    upload.setSizeMax(MAX_REQUEST_SIZE);
	    
	    // request 로 부터 ServletContext 객체의 참조값 얻어오기 
	    ServletContext application=request.getServletContext();
	    //WebContent 하위의 upload 폴더 절대 경로 얻어오기 
	    String uploadPath = application.getRealPath("/upload");
	    //전송된 파라미터의 한글 인코딩 설정 
	    upload.setHeaderEncoding("utf-8");
	    
	    try {
	        //폼전송된 아이템 목록 얻어오기 
	        List<FileItem> formItems = upload.parseRequest(request);
	        //폼전송된 아이템이 존재 한다면 
	        if (formItems != null && formItems.size() > 0) {
	        	//파일 정보를 담을 Dto 객체 생성
	        	FileDto dto=new FileDto();
	            //반복문 돌면서 FileItem 객체를 불러온다. 
	            for (FileItem item : formItems) {
	                	//전송된 원본 파일명을 얻어온다. 
	                    String orgFileName = new File(item.getName()).getName();
	                	//저장할 파일명 구성
	                	String saveFileName = System.currentTimeMillis()+orgFileName;
	                	//파일 시스템에 저장할 전체 경로를 구성한다.
	                    String filePath = 
	                    	uploadPath + File.separator + saveFileName;
	                	//파일을 파일시스템에 저장한다.
	                    File storeFile = new File(filePath);
	                    item.write(storeFile);
	                    //원본 파일명과 저장된 파일명을 FileDto 객체에 담는다.
	                   	dto.setOrgFileName(orgFileName);
	                   	dto.setSaveFileName(saveFileName);
	                   	//파일 사이즈도 담는다?
	                   	dto.setFileSize(item.getSize());
	                   	dto.setId(id);                   
	          
	            }//for
	            //DB 에 파일 정보를 저장한다.
	            FileDao.getInstance().insert(dto);
	        }//if
	        
	    } catch (Exception ex) {
	     
	        System.out.println(ex.getMessage());
	    }
	   		
		return new ActionForward("/users/list.do?id="+id,true);
	}

}











