<p align="center">
  <a href="https://getbootstrap.com/">
    <img src="https://github.com/dev-nicelee/jsp_project/blob/master/WebContent/resources/images/myresume-logo.png" alt="" width=250 height=72>
  </a>
</p>


# Project My Resume

> 프로젝트 타이틀
- [Myresume](http://192.168.0.39:8888)
- 나만의 이력서 만들기 사이트

> 프로젝트 설명
- 제공되는 템플릿 이력서에 맞춰 자신만의 이력서를 만들 수 있는 서비스
- 채용 담당자들이 자유롭게 구직자의 이력서를 열람할 수 있는 서비스

> 서비스 구성
- 홈페이지 : 웹사이트의 첫 페이지이며, 간단한 서비스 설명 및 등록 된 사용자들을 조회 할 수 있다.
- 관리자 서비스 : 로그인, 회원가입, 사용자별 프로필 등록 등의 서비스를 이용할 수 있다.
- 이력서 조회 서비스 : 사용자별 이력서를 조회 할 수 있다. 관리자를 통해 입력된 정보를 조회한다.

> 사용기술
* [javascript](https://developer.mozilla.org/ko/docs/Learn/JavaScript/First_steps/What_is_JavaScript)
* [jquery 3.2.1](https://jquery.com/)
* [bootstrap3.3](https://getbootstrap.com/docs/3.3/)
* [java8](http://www.oracle.com/technetwork/java/javaee/overview/index.html)
* [jsp](http://www.oracle.com/technetwork/java/javaee/jsp/index.html)
* [MVC Pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)

> DB 테이블 명세
* TB_USER 테이블을 중심으로 ID를 키값으로 하는 프로필 상세 테이블들로 구성(TB_EDU 등등)
* https://goo.gl/KFFN5D

> 프로젝트 구조

```
MyProject/
├── Deployment Descriptor/
├── JAX-WS Web Services/
├── Java Resources/
│   ├── src/
│   │    ├── test.controller/
│   │    ├── test.file.action/
│   │    ├── test.file.dao/
│   │    ├── test.file.dto/
│   │    ├── test.file.filter/
│   │    ├── test.home.action/
│   │    ├── test.mybatis/
│   │    ├── test.profile.action/
│   │    ├── test.profile.dao/
│   │    ├── test.profile.dto/
│   │    ├── test.users.action/
│   │    ├── test.users.dao/
│   │    ├── test.users.dto/
│   ├── Libraries/
├── JavaScript Resources/
├── bin/
├── build/
├── WebContent/
│   ├── META-INF/
│   ├── resources/
│   ├── upload/
│   ├── views/
│   │    ├── pages/
│   │    ├── profile/
│   │    ├── users/
│   │    ├── home.jsp
│   │    ├── profile.jsp
│   ├── WEB-INF/
│   ├── index.jsp
```

# Works

> 팀원 구성
- 문용범, 문지상, 이민경, 이종서 (팀장)

> 업무 분장

-------
#### 로그인
- 담당자 : 문용범
- 설명 : 사용자 계정을 이용해 로그인 할 수 있다.
- 주요작업 : 로그인 유효성검사(정규식 사용), 로그인 폼 전송
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
TB_UserDao, TB_UserDto, UsersMapper |LoginForm |LoginAction, LoginFormAction

-------

#### 회원가입
- 담당자 : 문용범
- 설명 : 사용자 계정을 생성할 수 있다.
- 주요작업 : 회원가입 유효성 검사(정규식 사용), 회원가입 폼 전송
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
TB_UserDao, TB_UserDto, UsersMapper |SignupForm |SignupFormAction, SignupAction

-------

#### 회원목록 리스트 조회
- 담당자 : 문용범
- 설명 : 회원목록을 조회할 있다.
- 주요작업 : 회원 목록 리스트를 가져와 출력한다.
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
TB_UserDao, TB_UserDto, UsersMapper | list.jsp | ListAction

-------

#### 회원별 사진 업로드 등록, 수정, 조회
- 담당자 : 이민경
- 설명 : 회원별로 사진을 업로드, 수정, 조회할 수 있다.
- 주요작업 : tb_user 테이블과 tb_file 테이블을 join 하여 로그인된 회원의 프로필 사진을 등록, 수정 하고 사진을 출력할 수 있다. 
- 관련 DB: TB_USER, TB_FILE
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
TB_USER Dto.java, TB_USERDao.java, TB_USERMapper.xml, FileDto.java, FileDao.java, FileMapper.xml | fileInsertForm.jsp | FileInsertAction.java, FileInsertFormAction.java

-------

#### 회원 프로필 : 관심사(Interest) 등록, 수정, 삭제, 출력
- 담당자 : 이민경
- 설명 : 회원별로 관심사(Interest) 항목을 입력, 수정, 삭제, 조회 할 수 있다.
- 주요작업 : 로그인된 회원의 관심사를 등록,수정 삭제 출력이 가능하게 한다.
- 관련 DB: TB_INTS
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
IntsDto.java, IntsDao.java, IntsMapper.xml| intsInsertForm.jsp, intsUpdateForm.jsp | intsInsertAction.java, intsInsertFormAction.java

-------

#### 회원 프로필 : 기술(Skills) 등록, 수정, 삭제, 출력
- 담당자 : 이민경
- 설명 : 회원별로 기술(Skills) 항목을 입력, 수정, 삭제, 조회 할 수 있다.
- 주요작업 : 로그인된 회원의 관심사을 등록, 수정, 삭제 출력이 가능하게 한다.
- 관련 DB: TB_SKILLS
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
Skills.java, SkillsDao.java, SkillsMapper.xml | skillsInsertForm.jsp, skillsUpdateForm.jsp | skillsInsertAction.java, skillsInsertFormAction.java

-------

#### 메인페이지 & 이력서 : 회원 정보 조회
- 담당자 : 이민경
- 설명 : 회원별로 기술(Skills) 항목을 입력, 수정, 삭제, 조회 할 수 있다.
- 주요작업 : 메인 페이지에 이력서를 올린 회원에 대한 정보를 출력하고 각 유저의 데이터를 프로필페이지에서 출력해 준다.
- 관련 DB: TB_USER, TB_SKILLS, TB_INTS, TB_AC, TB_EXPS, TB_EDU, TB_FILE
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
회원 관련 전체 Model 파일 | profile.jsp | HomeAction.java, ProfileSelectAction.java

-------

#### 수상목록, 교육내역, 경험목록 등록, 수정, 삭제, 출력
- 담당자 : 문지상
- 설명 : 로그인된 회원의 수상목록, 교육내역, 경험목록을 수정, 삭제, 출력한다
- 주요작업 : 메인 페이지에 이력서를 올린 회원에 대한 정보를 출력하고 각 유저의 데이터를 프로필페이지에서 출력해 준다.
- 관련 DB: TB_AC, TB_EDU, TB_EXP
- 관련파일

Model                                  | View                                  | Controller                              
-------------------------------------- |---------------------------------------|--------------------------------------------
AcDto.java, EduDto.java, ExpDto.java, AcDao.java, EduDao.java, ExpDao.java | acInsertForm.jsp, eduInsertForm.jsp,  expInsertForm.jsp, acUpdateForm.jsp, eduUpdateForm.jsp, expInsertForm.jsp | acInsertAction.java, eduInsertAction.java, expInsertAction.java, acInsertFormAction.java, eduInsertFormAction.java, expInsertFormAction.java

# References

- [관리자 Bootstrap Template](https://github.com/gurayyarar/AdminBSBMaterialDesign)
- [메인페이지 Bootstrap Template](https://startbootstrap.com/template-overviews/agency/)
- [이력서 Bootstrap Template](https://startbootstrap.com/template-overviews/resume/)

# Sample Data
* https://drive.google.com/file/d/17xnTSPixNeyB7drMVvHtkc7s2p9oreLa/view?usp=sharing

