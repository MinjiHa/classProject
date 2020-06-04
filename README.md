# classProject / For deploy test Server  
**클래스 프로젝트 테스트용 서버입니다.**  


# 사용 방법 #  
1. 먼저 우측 위의 녹색 Clone or Download를 눌러 자신의 PC로 내려받는다.  
2. VS CODE로 열어서 편집을 시작한다.  
3. 작성을 마친 파트별로 깃허브에 **브랜치로 커밋**한다.   

<hr>

# 백앤드 파트 #  
1. 백앤드 파트는 JSP 파일을 작성하게 됩니다.  
2. 폴더 경로는 src/main/webapp/WEB-INF/views 이고 여기에 JSP페이지를 작성해서 담아줍니다.  
3. src/main/java/com.classproject.testServer/MainController.java로 이동  
   [public class MainController] 클래스 내에 메소드를 추가해줍니다. (제일 중요합니다!)  
   
   @RequestMapping(value="/")    --> 맵핑되고자 하는 URI  
    public String index() {      --> 맵핑 간 호출되는 메소드 이름  
        return "index";          --> 내가 작성한 JSP파일의 이름  
    }  
    
  **_EX) 만약에 내가 작성해서 추가하고자 하는 JSP 파일의 이름이 [Apple.jsp] 라고 하고, /Apple로 URI를 맵핑하고 싶다면.._**  
      **_ @RequestMapping(value="/Apple")    --> 맵핑되고자 하는 URI   
         public String Apple() {      --> 맵핑 간 호출되는 메소드 이름  
        return "Apple";          --> 내가 작성한 JSP파일의 이름  
    }_**  
  
4. 코드 내에서 연결하고자하는 JSP파일간 연결해준다.  
  - form action으로 이동 / input type="button" ..(중략).. onclick=["location.href='backend'"]/>로  
  **_EX.1) index.jsp -> Apple.jsp로 이동하는데 Form을 활용해서 페이지 이동 ::  
                     ==> '<form action = Apple.jsp..' 중략  
  **_EX.2) index.jps -> Apple.jsp로 이동하는데 Button을 활용해서 페이지 이동 ::  
                     ==> Input type=Button.. 중략 .. onclick="location.href='Apple'"  
                    

<hr>

# 프론트 파트 #  
1. CSS : CSS작성 후 파일은 src/main/resource/static/css에 넣어주시면 됩니다.  
2. JavaScript : JS 작성 후 파일은 src/main/resource/static/js에 넣어주시면 됩니다.  
3. Image : 첨부하는 img 파일은 src/main/resource/static/images에 넣어주시면 됩니다.  
  --> _이미지 첨부 후 경로 명시 놓치지 말기!_   
4. 각 css, js파일은 JSP파일에서 연결 필수! 
  **_EX ) Apple.jsp에서 Apple.css, Apple.js를 사용할 경우 JSP에서 명시해줘야 합니다.
  
  
<hr>

# 데이터 관리 #  

<hr>

# 데이터 분석 #  

<hr>

# 서버 #  

<hr>