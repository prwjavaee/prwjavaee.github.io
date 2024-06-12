package com.four.memberAdm.controller;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.four.memberAdm.bean.MemberBean;
import com.four.memberAdm.dao.MemberDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet("/UpdateMem")
@MultipartConfig(maxFileSize = 16177215) // 16MB
public class UpdateMem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDao memberDao = new MemberDao();
	
 	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 		
 		String memNoStr = request.getParameter("memNo");
 		String memName = request.getParameter("memName");
 		String memEmail = request.getParameter("memEmail");
 		String memPassword = request.getParameter("memPassword");
 		String genderStr = request.getParameter("gender");
 		String birth = request.getParameter("birth");
 		String phone = request.getParameter("phone");
 		String statusStr = request.getParameter("status");
 		String nickName = request.getParameter("nickName");
// 		String memPic = request.getParameter("memPic");
 		Part memPicP = request.getPart("memPic");
 		String hiddenImage = request.getParameter("hiddenImage");
 		byte[] memPic = null;
 		
 		if (memPicP != null && memPicP.getSize() > 0) {
 	        // 新圖片被上傳
 	        InputStream inputStream = memPicP.getInputStream();
 	        memPic = inputStream.readAllBytes();
 	    } else if (hiddenImage != null && !hiddenImage.isEmpty()) {
 	        // 使用隱藏字段中的原始圖片數據
 	        memPic = Base64.getDecoder().decode(hiddenImage);
 	    }
 		
// 		if (memPicP != null ) {
// 			try (InputStream inputStream = memPicP.getInputStream()) {
//	            memPic = inputStream.readAllBytes();
//	        } catch (Exception ex) {
//	            ex.printStackTrace();
//	        }
// 		} else {
//            response.getWriter().println("Name or File part missing");
//        }
 		
 		MemberBean newMem = new MemberBean(Integer.parseInt(memNoStr), memName, memEmail, memPassword, Integer.parseInt(genderStr), birth, phone,Integer.parseInt(statusStr), nickName, memPic);
 		MemberBean member = memberDao.updateMem(newMem);

        member =  memberDao.getMem(member.getMemNo() + "");
        request.setAttribute("member", member);
		request.getRequestDispatcher("/four/memberAdm/jsp/GetMem.jsp").forward(request, response);
 		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
