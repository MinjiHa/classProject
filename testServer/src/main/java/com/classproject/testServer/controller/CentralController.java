package com.classproject.testServer.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.classproject.testServer.dao.*; // DAO 임포트
import com.classproject.testServer.model.*;//Model전부 불러옴
import com.classproject.testServer.model.CentralLogin;
import com.classproject.testServer.service.CentralMemberService;
import com.classproject.testServer.service.CentralService; // Service 임포트
import com.classproject.testServer.service.CentralLoginService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller // Beans에게 지금 이 클래스는 Controller라고 Anotation(@)으로 알려줌
public class CentralController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired // Beans의 서비스와 연결해서 사용하겠다고 Anotation 선언
    CentralService centralservice;
    @Autowired
    CentralMemberService centralmemberservice; // 여기서 선언해줬다.
    @Autowired
    CentralBoardDAO centralboarddao;
    @Autowired
    CentralLoginService centralloginservice;

    @Autowired
    CentralBoardListDAO centralboardlistdao;
    @Autowired
    CentralCommentDAO centralcommentdao;

    @RequestMapping(value="/")
    public String index(Locale locale, Model model) {
//     // 위의 메소드 내 인스턴스로 최초 페이지 로딩할 떄 변수(데이터)를 넘길 수 있어요.
// 	// Locale은 지역 객체, Model은 로딩하고자 하는 JSP객체(그냥 Model model을 선언해서 사용하면 된다.)
	    
//         logger.info("Access Index Page"); 
// 	// 현재 실행중인 터미널(콘솔)에 현재 상태를 띄운다. 즉 System.out.print와 같다고 보면 된다.
// 	// logger를 사용하려면 import org.slf4j.Logger; import org.slf4j.LoggerFactory; 가 있어야 한다.
	    
//         Date date = new Date();
// 		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
// 		String formattedDate = dateFormat.format(date);
// 		model.addAttribute("serverTime", formattedDate);

        return "main";
    }

    @RequestMapping(value="/main")
    public String main() {
        logger.info("Access Main Page");
        return "main";
    }


    @RequestMapping(value="/backend")
    public String backend() {
        logger.info("Access BackEnd Page");
        return "backend";
    }

    //값을 넘겨줄때 이방식을 사용한다.
    @RequestMapping(value="/test")
    public String test(Model model) throws Exception {
        logger.info("Access test Page");
        model.addAttribute("list", centralservice.selectUserList());

        return "test";
    }
    //소개 페이지 
     @RequestMapping(value="/sogae_1") 
     public String sogae_1() {
         logger.info("Access sogae_1 Page");
         return "sogae_1";
     }
     @RequestMapping(value="/sogae_2") 
     public String sogae_2() {
         logger.info("Access sogae_2 Page");
         return "sogae_2";
     }
     @RequestMapping(value="/sogae_3") 
     public String sogae_3() {
         logger.info("Access sogae_3 Page");
         return "sogae_3";
     }
     @RequestMapping(value="/sogae_4") 
     public String sogae_4() {
         logger.info("Access sogae_4 Page");
         return "sogae_4";
     }
     @RequestMapping(value="/sogae_5") 
     public String sogae_5() {
         logger.info("Access sogae_5 Page");
         return "sogae_5";
     }
    //학습페이지
    @RequestMapping(value="/haksoup_1") 
    public String haksoup_1(Model model)throws Exception {
        logger.info("Access haksoup_1 Page");
        CentralBoard centralboard = new  CentralBoard();
        centralboard.setBoard_code(1);

        CentralBoardlist centralboardlist = new CentralBoardlist();
        centralboardlist.setBoard_code(1);

        model.addAttribute("Boardcode", centralboardlistdao.selectBoardByCode(1));
        model.addAttribute("Boardlist", centralboarddao.selectWriteList(1));
        return "haksoup_1";
    }
     @RequestMapping(value="/haksoup_2") 
    public String haksoup_2(Model model)throws Exception {
        logger.info("Access haksoup_2 Page");
        CentralBoard centralboard = new  CentralBoard();
        centralboard.setBoard_code(2);

        CentralBoardlist centralboardlist = new CentralBoardlist();
        centralboardlist.setBoard_code(2);

        model.addAttribute("Boardcode", centralboardlistdao.selectBoardByCode(2));
        model.addAttribute("Boardlist", centralboarddao.selectWriteList(2));
        return "haksoup_2";
    }
     @RequestMapping(value="/haksoup_3") 
    public String haksoup_3() {
        logger.info("Access haksoup_3 Page");
        return "haksoup_3";
    }
     @RequestMapping(value="/haksoup_4") 
    public String haksoup_4() {
        logger.info("Access haksoup_4 Page");
        return "haksoup_4";
    }
    //분석
     @RequestMapping(value="/bunsuk_1") 
    public String bunsuk_1() {
        logger.info("Access bunsuk_1 Page");
        return "bunsuk_1";
    }
     @RequestMapping(value="/bunsuk_2") 
    public String bunsuk_2() {
        logger.info("Access bunsuk_2 Page");
        return "bunsuk_2";
    }
    //스터디 
     @RequestMapping(value="/study_1") 
    public String study_1() {
        logger.info("Access study_1 Page");
        return "study_1";
    }
     @RequestMapping(value="/study_2") 
    public String study_2() {
        logger.info("Access study_2 Page");
        return "study_2";
    }
     @RequestMapping(value="/study_3") 
    public String study_3() {
        logger.info("Access study_3 Page");
        return "study_3";
    }
    //운영
    @RequestMapping(value="/manage_1") //게시판 테스트로 만든 controller 메소드======
    public String manage_1(Model model)throws Exception {
        logger.info("Access manage_1 Page");

        CentralBoard centralboard = new  CentralBoard();
        centralboard.setBoard_code(3);

        CentralBoardlist centralboardlist = new CentralBoardlist();
        centralboardlist.setBoard_code(3);

        model.addAttribute("Boardcode", centralboardlistdao.selectBoardByCode(3));
        model.addAttribute("Boardlist", centralboarddao.selectWriteList(3));
        
        return "manage_1";
    }


    @RequestMapping(value="/manage_4") 
    public String manage_4(Model model)throws Exception {
        logger.info("Access manage_4 Page");
        CentralBoard centralboard = new  CentralBoard();
        centralboard.setBoard_code(4);

        CentralBoardlist centralboardlist = new CentralBoardlist();
        centralboardlist.setBoard_code(4);

        model.addAttribute("Boardcode", centralboardlistdao.selectBoardByCode(4));
        model.addAttribute("Boardlist", centralboarddao.selectWriteList(4));
        return "manage_4";
    }
    //게시판 ======
    @RequestMapping(value="board_content") //글 자세히 보기 manage_1page에 있는 글제목을 클릭시 글 내용을 볼수 있음
    public String board_content(Model model,@RequestParam("write_code")int write_code,HttpServletRequest request) throws Exception {

        

        model.addAttribute("Boardlist", centralboarddao.selectWriteByCode(write_code));
        model.addAttribute("Commentlist", centralcommentdao.selectCommentList(write_code));
        String MC = Integer.toString(centralboarddao.selectMCByCode(write_code));
        HttpSession session = request.getSession();
        session.setAttribute("MC", MC);
        logger.info("Access board_content Page");
        return "board_content";
    }

    @RequestMapping("boardinsert") //게시판 입력
    public String boardinsert(HttpServletRequest request) throws Exception {
        CentralBoard centralboard = new CentralBoard();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        String datestr = sdf.format(cal.getTime());

        centralboard.setBoard_code(Integer.parseInt(request.getParameter("board_code")));
        //insert 게시판에 따라서 페이지별 게시판 고유 값을 받아야 하지만 정해진게 없어서 추후 업데이트하는게 좋을듯
        HttpSession session=request.getSession();
        int code= Integer.parseInt((String)session.getAttribute("CODE"));
        centralboard.setMember_code(code);
        // Integer.parseInt(request.getParameter("password"))
        // 로그인 유지 상태에서 로그인자의 정보중 member_code를 받아와야 하지만 현재 로그인 섹션유지 불가로 현재있는 코드인 100으로 고정
        centralboard.setWrite_content(request.getParameter("write_content"));
        centralboard.setWrite_title(request.getParameter("write_title"));
        centralboard.setWrite_date(datestr);
        //날자를 jsp에서 받아와서 String타입으로 변환해야하는 어려움있음
       
        centralboarddao.insertWrite(centralboard);
        int codenume = Integer.parseInt(request.getParameter("board_code"));
        String url="";
        switch(codenume){
            case 1 : url = "haksoup_1";
                    break;
            case 2 : url = "haksoup_2";
                    break;
            case 3 : url = "manage_1";
                    break;
            case 4 : url = "manage_4";
                    break;
        }
        logger.info(url);
        return "redirect:"+ url; // 입력이 다되면 원래페이지로 이동 이것도 고유 값을 받는게 좋을듯
    }
    @RequestMapping("boardwrite") //
    public String boardwrite(Model model,@RequestParam("board_code")int board_code) throws Exception {
        CentralBoardlist centralboardlist = new CentralBoardlist();
        centralboardlist.setBoard_code(board_code);
        model.addAttribute("Boardcode", centralboardlistdao.selectBoardByCode(board_code));
        return "boardwrite";
    }
    
    @RequestMapping("board_commit") //board uapte_commmit 하는 부분
    public String board_update(HttpServletRequest request)throws Exception {
        CentralBoard centralboard = new CentralBoard();
        HttpSession session=request.getSession();
        int code= Integer.parseInt((String)session.getAttribute("CODE"));
        centralboard.setWrite_code(Integer.parseInt(request.getParameter("write_code")));
        centralboard.setMember_code(code);
        centralboard.setWrite_content(request.getParameter("write_content"));
        centralboard.setWrite_title(request.getParameter("write_title"));
       
        centralboarddao.updateWrite(centralboard);
        return "redirect:/board_content?write_code="+ centralboard.getWrite_code();
    }
    @RequestMapping("board_update") //
    public String board_commit(Model model,@RequestParam("write_code")int write_code)throws Exception {
        model.addAttribute("Boardlist", centralboarddao.selectWriteByCode(write_code));
        return "board_update";
    }
    @RequestMapping("comment_insert") //게시판 입력
    public String commet_insert(HttpServletRequest request,RedirectAttributes redirectAttributes) throws Exception {
        //RedirectAttributes :이전페이지로 돌아가기 위함
        CentralComment centralcomment = new CentralComment();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
        String datestr = sdf.format(cal.getTime());
        
        HttpSession session=request.getSession();
        int code= Integer.parseInt((String)session.getAttribute("CODE"));

         //???
        //insert 게시판에 따라서 페이지별 게시판 고유 값을 받아야 하지만 정해진게 없어서 추후 업데이트하는게 좋을듯
        centralcomment.setMember_code(code);
        // Integer.parseInt(request.getParameter("member_code")) 후에 member코드 구현할때
        // 로그인 유지 상태에서 로그인자의 정보중 member_code를 받아와야 하지만 현재 로그인 섹션유지 불가로 현재있는 코드인 100으로 고정
        centralcomment.setWrite_code(Integer.parseInt(request.getParameter("write_code")));
        centralcomment.setComment_write(request.getParameter("comment_write"));
        centralcomment.setComment_date(datestr);
        //날자를 jsp에서 받아와서 String타입으로 변환해야하는 어려움있음
    
        centralcommentdao.insertComment(centralcomment);
        String url=request.getParameter("write_code");
        logger.info(url);
        return "redirect:/board_content?write_code="+ url; // 입력이 다되면 원래페이지로 이동 이것도 고유 값을 받는게 좋을듯
        //이것도 다시 원래 페이지로 가야함
    }

    //로그인 ====
    @RequestMapping(value="/loginform") 
    public String login() {
        logger.info("Access login Page");
        return "loginform";
    }
    @RequestMapping(value ="/logout")
    public String logout(HttpSession session)throws Exception{
        session.invalidate();
        return "redirect:/main";
    }


    // 회원가입 페이지(Registerform.jsp에서 가입을 누르면 join.jsp로 넘어갑니다. 그때 join.jsp를 받아서 실행하는 메소드입니다.)
    @RequestMapping(value="/join") 
    public String join(HttpServletRequest request) throws Exception {

        // 객체를 선언해준다. Member = DTO이다.
        CentralMember centralmember = new CentralMember(); // 여기에 선언했다.

        // 현재 RegisterForm에서 code와 isadmin을 받지 않고 있으므로 임의로 1 설정
        //centralmember.setmember_code(Integer.parseInt(request.getParameter("code")));

        // centralmember 객체에 값을 할당해준다.
        // centralmember.setmember_code(2); //<-- 여기를 수정해준다.
        centralmember.setmember_id(request.getParameter("id")); 
        centralmember.setmember_pw(request.getParameter("password"));
        centralmember.setmember_nick(request.getParameter("nick"));
        centralmember.setmember_tel(request.getParameter("tel"));
        centralmember.setmember_name(request.getParameter("name"));

        //왜 메일이 안넘어오지.. 메일이 안넘어 오니 수정해주셔야 해요
        centralmember.setmember_email(request.getParameter("email"));
        // centralmember.setmember_email("KKK@KKK.com");
        // centralmember.setmember_isadmin(true);

        // centralmemberservice 얘는 위의 32번째 줄에서 선언해줬다. 객체이름이 centralmemberservice이다.
        // 객체 내의 insertUser 메소드를 호출하고 파라미터는 centralmember로 한다.
        // centralmember로 얘는 180번째 줄에 선언 되어 있다. 
        //여기까지 이해가 되었으면 centralmemberservice.java로 가보자.
        centralmemberservice.insertUser(centralmember);

        // 위의 과정이 완료되면 터미널에 메세지를 출력해준다.
        logger.info("Success Join");
        logger.info("return to main Page");
        // Mapper.xml까지 처리하고 나면 리턴으로 돌아온다. 리턴으로 돌아와서 우리가 띄우고자 하는 페이지를 띄워준다.
        // redirect:는 문법이고 /main페이지로 리다이렉팅(돌아간다)한다는 뜻이다. 여기까지가 끝이다.
        return "redirect:/main";// 회원가입이 완료되면 메인페이지를 띄워준다.
    }

    @RequestMapping(value="/registerform") 
    public String register() {
        logger.info("Access register Page");
        return "registerform";
    }
    @RequestMapping(value="/login")
    public String login(HttpServletRequest request ) throws Exception {
        //아이디와 비밀번호 가져오기
        final String id= request.getParameter("id");
        final String password= request.getParameter("password");
        //로그인 정보 저장
        final CentralLogin centrallogin =new CentralLogin();
        CentralMember centralmember=new CentralMember();
        centrallogin.setlogin_id(request.getParameter("id")); 
        centrallogin.setlogin_password(request.getParameter("password"));
        final HttpSession session=request.getSession();
        final boolean idcheck=centralloginservice.loginCheckID(centrallogin);
        final boolean pwcheck=centralloginservice.loginCheckPW(centrallogin);
    

        logger.info(id+" "+password);
        if(idcheck){
            if(pwcheck){
                String code= Integer.toString(centralloginservice.loginmembercode(centrallogin));
                //세션 생성
                session.setAttribute("ID", id);
                session.setAttribute("PASSWORD", password);
                session.setAttribute("CODE", code);
                
                // 세션 동작 확인
                logger.info(id+" "+password);
                logger.info("return to main Page");
                return "redirect:/main";
            }else{
                logger.info("비밀번호입력실패"+pwcheck+" "+password);
                return "loginform";
            }
        }
        else {
            return "loginform";
        }
    }
}
