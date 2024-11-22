package com.exam.cmd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

	@RequestMapping("/req")
	public String mtdReq(HttpServletRequest req, Model model) {
		String uid = null;
		String uname = null;
		try {
			req.setCharacterEncoding("UTF-8");
			uid = req.getParameter("uid");
			uname = req.getParameter("uname");
		} catch (Exception e) {
			e.getMessage();
		}
		model.addAttribute("uid", uid);
		model.addAttribute("uname", uname);
		return "mtdReq";
	}

	// @RequestParam 애너테이션 시작
	@RequestMapping("/reqParam")
	public String mtdReqParam(@RequestParam("uid") String uid, @RequestParam("uname") String uname, Model model) {
		model.addAttribute("uid", uid);
		model.addAttribute("uname", uname);
		return "mtdReq"; // 동일한 View 사용하여 확인
	}
		@RequestMapping("/reqCmd")
		public String mtdReqCmd(Member member) {
			return "mtdReq";
		}
		
	
}