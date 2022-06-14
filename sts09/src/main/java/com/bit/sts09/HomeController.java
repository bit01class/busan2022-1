package com.bit.sts09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;


@Controller
public class HomeController {
	String upPath="C:/framework/sts10/src/upload/";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/upload", method= RequestMethod.POST)
	public String upload(MultipartHttpServletRequest req,Model model ) throws IOException {
		String uploadPath=req.getRealPath("/resources/upload");
		System.out.println("call upload..."+req.getRealPath("/resources/upload"));
		MultipartFile mfile = req.getFile("file");
		String origin=mfile.getOriginalFilename();
		
		InputStream is = mfile.getInputStream();
		
		File file=new File(uploadPath+"/"+origin);
		OutputStream os=new FileOutputStream(file);
		
		while(true) {
			int su=is.read();
			if(su==-1)break;
			os.write(su);
		}
		model.addAttribute("filename", origin);
		return "down";
//		Iterator<String> ite= req.getFileNames();
//		while(ite.hasNext()) {
//			System.out.println(ite.next());
//		}
	}

	//<a href="down?file=${filename }">
	@RequestMapping(value = "/down",method = RequestMethod.GET)
	public void down1(HttpServletResponse res,@RequestParam("file") String filename,@RequestParam("origin") String origin){
		File file=new File(upPath+filename);
		
		res.setContentType("application/octet-stream");
//		Content-Disposition: attachment; filename=\"filename.jpg\"
		res.setHeader("Content-Disposition", "attachment; filename=\""+origin+"\"");
		try(
			OutputStream os = res.getOutputStream();
			InputStream is=new FileInputStream(file);
		){
			while(true) {
				int su=is.read();
				if(su==-1)break;
				os.write(su);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


















