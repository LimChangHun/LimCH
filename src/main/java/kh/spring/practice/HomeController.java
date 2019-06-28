package kh.spring.practice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.MemberDTO;
import kh.spring.impl.BoardDAOImpl;
import kh.spring.impl.MemberDAOImpl;

@Controller
public class HomeController {
	
	@Autowired
	private MemberDAOImpl dao;
	@Autowired
	private BoardDAOImpl bdao;
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/")
	public String main(HttpServletRequest request) {
		request.getSession().invalidate();
		return "home";
	}
	
	@RequestMapping("loginProc")
	public String login(MemberDTO dto,HttpServletRequest request) {
		int result = dao.LoginOk(dto);
		request.getSession().setAttribute("id", dto.getId());
		request.setAttribute("result", result);
		request.getSession().setAttribute("profile", dao.image(dto.getId()));
		return "home";
	}
	
	@RequestMapping("memberJoinForm") //회원가입 폼으로 가는 거
	public String MemberJoinProc() {
		return "memberJoinForm";
	}
	
	@ResponseBody
	@RequestMapping("loginCheck")
	public String loginCheck(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		int result = dao.LoginId(id);
		if(result==1) {
			return "false";
		}else {
			return "Success";
		}
	}
	
	@ResponseBody
	@RequestMapping("pwConfirmAjax")
	public String pwConfirmAjax() {
		return "a";
	}
	
	@RequestMapping("join") //회원가입 입력하고 회원가입됐다고 알리는 차응로 가게
	public String JoinOk(MemberDTO dto) {
		String uploadPath = session.getServletContext().getRealPath("/resources/"+dto.getId());
		dao.memberJoin(dto);
		try {
			dto.getImg().transferTo(new File(uploadPath+"/"+dto.getImg().getOriginalFilename()));
			session.setAttribute("profile", dao.image(dto.getId()));
			session.setAttribute("id", dto.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "home";
	}
	
	@RequestMapping("mypageProc")
	public String mypageProc(MemberDTO dto,HttpServletRequest request) {		
		return "mypage";
	}
	
	@RequestMapping("board")
	public String board(BoardDTO dto,int currentPage) {
		List<BoardDTO> result = bdao.boardContents(currentPage);
		String getNavi = bdao.getNaviforMySupport(currentPage);
		session.setAttribute("result", result);
		session.setAttribute("getNavi", getNavi);
		return "board";
	}
	
	@RequestMapping("writePage")
	public String writePage(){
		return "write";
	}
	@ResponseBody
	@RequestMapping("imageUpdate")
	public String image(MultipartFile formData) {
		String uploadPath = session.getServletContext().getRealPath("/resources/img");
		String name = uploadPath+"/"+System.currentTimeMillis()+"_a.png";
		String result=null;
		try {
			File newFile = new File(name);
			formData.transferTo(newFile);
			result=newFile.getName();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("writeComplete")
	public String writeComplete(BoardDTO dto,HttpServletRequest request,int currentPage) {
		String name = (String) request.getSession().getAttribute("id");
		try {
			bdao.boardWriteInsert(dto,name);
			List<BoardDTO> result = bdao.boardContents(currentPage);
			String getNavi = bdao.getNaviforMySupport(currentPage);
			session.setAttribute("getNavi", getNavi);
			session.setAttribute("result", result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:board?currentPage="+currentPage;
	}
	@RequestMapping("boardView")
	public String boardView(BoardDTO dto,int seq_board) {
		bdao.boardViewCountUp(dto, seq_board);
		BoardDTO li = bdao.boardView(seq_board);
		session.setAttribute("li", li);
		return "boardView";
	}
	@RequestMapping("writeModify")
	public String writeModify(int seq_board) {
		BoardDTO li = bdao.boardView(seq_board);
		session.setAttribute("li", li);
		return "writeModify";
	}
	@RequestMapping("writeDelete")
	public String writeDelete(int seq_board) {
		bdao.deleteWrite(seq_board);
		List<BoardDTO> result = bdao.boardContents(1);
		String getNavi = bdao.getNaviforMySupport(1);
		session.setAttribute("getNavi", getNavi);
		session.setAttribute("result", result);
		return "board";
	}
	@RequestMapping("writeModifyComplete")
	public String writeModifyComplete(BoardDTO dto,int seq_board) {
		bdao.modifyWrite(dto,seq_board);
		List<BoardDTO> result = bdao.boardContents(1);
		String getNavi = bdao.getNaviforMySupport(1);
		session.setAttribute("getNavi", getNavi);
		session.setAttribute("result", result);
		return "board";
	}
	@RequestMapping("webchat")
	public String webChat() {
		return "webchat";
	}
	
	@ResponseBody
	@RequestMapping("comment")
	public String comment(HttpServletRequest request) {
		String contents = request.getParameter("comment");
		String writer = request.getParameter("writer");
		bdao.commentInsert(contents, writer);
		return contents;
	}
	
}
