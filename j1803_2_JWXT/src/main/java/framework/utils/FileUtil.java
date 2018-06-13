/**
 * 
 */
package framework.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 * @Author QinPeng
 *
 * @Date 2018年5月25日
 */
public class FileUtil {
	public static String upload(HttpServletRequest request) {
		// 1:转化request为：MultipartHttpServletRequest
		MultipartHttpServletRequest mhsRequest = (MultipartHttpServletRequest) request;
		// 2:获取上传文件
		CommonsMultipartFile cmFlie = (CommonsMultipartFile) mhsRequest.getFile("uploadFile");
		// 3:获取上传文件的：字节数组
		byte[] byteNum = cmFlie.getBytes();
		// 4:获取文件的后缀名
		String oldFliename = cmFlie.getOriginalFilename();
		if("".equals(oldFliename)) {
			return null;
		}
		String suffix = oldFliename.substring(oldFliename.lastIndexOf("."));
		// 5:获取当前项目路径
		String path = request.getSession().getServletContext().getRealPath("/");
		// 6:构建路径
		String url =null;
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String filename = sdf.format(date);
			// 存储图片的物理路径
			String upload = "D:/programmingRelated/upload/";
			url = upload + filename + suffix;

			OutputStream os = new FileOutputStream(url);
			os.write(byteNum);
			os.flush();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("----------------url---"+url);
		return url;
	}
}
