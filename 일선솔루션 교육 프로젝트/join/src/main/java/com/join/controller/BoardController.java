package com.join.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.management.loading.PrivateClassLoader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.join.service.IF_BoardService;
import com.join.vo.BoardVO;
import com.join.vo.FileVO;
import com.join.vo.PageVO;
import com.nexacro.java.xapi.data.DataSet;
import com.nexacro.java.xapi.data.DataTypes;
import com.nexacro.java.xapi.data.PlatformData;
import com.nexacro.java.xapi.data.VariableList;
import com.nexacro.java.xapi.data.datatype.DataType;
import com.nexacro.java.xapi.tx.HttpPlatformRequest;
import com.nexacro.java.xapi.tx.HttpPlatformResponse;
import com.nexacro.java.xapi.tx.PlatformException;

@Controller
public class BoardController {
	
	@Resource(name="uploadPath")
	   private String uploadPath;
	
	@Inject
	private IF_BoardService boardservice;
	//게시글목록화면
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Locale locale, Model model, PageVO pvo) throws Exception {
		
		return "byeongkuk/board";	//게시판화면
	}
	//게시글작성화면
	@RequestMapping(value = "/board_insert_view", method = RequestMethod.GET)
	public String board_insert_view(Locale locale, Model model) throws Exception {
		model.addAttribute("display",1);
		return "byeongkuk/board_insert";	//글작성,수정,상세보기화면
	}
	//게시글상세보기화면
	@RequestMapping(value = "/board_one_view", method = RequestMethod.GET)
	public String board_one_view(Locale locale, Model model,@RequestParam Map<String, Object> seq) throws Exception {
		List<Map<String, Object>> list = boardservice.selectOne(seq);	//게시글번호1개로 검색
		model.addAttribute("list",list);
		model.addAttribute("display",2);
		return "byeongkuk/board_insert";	//글작성,수정,상세보기화면
	}
	//파일다운로드
	@RequestMapping(value = "/download",method = RequestMethod.GET)
	public String download(@RequestParam FileVO fvo, HttpServletRequest request, HttpServletResponse response)throws Exception {
		System.out.println(123456);
		System.out.println(fvo);
		request.setCharacterEncoding("UTF-8");
		// 파일 업로드된 경로
		String root = request.getSession().getServletContext().getRealPath("/");
		String savePath = root + "upload";
		// 서버에 실제 저장된 파일명
		String filename = fvo.getSave_name();
		// 실제 내보낼 파일명
		String orgfilename = fvo.getReal_name() ;
		InputStream in = null;
		OutputStream os = null;
		File file = null;
		boolean skip = false;
		String client = "";
		try{
			try{
				file = new File(savePath, filename);
				in = new FileInputStream(file);
			}catch(FileNotFoundException fe){
				skip = true;
			}
			client = request.getHeader("User-Agent");
			// 파일 다운로드 헤더 지정
			response.reset() ;
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Description", "JSP Generated Data");
			if(!skip){
				// IE
				if(client.indexOf("MSIE") != -1){
					response.setHeader ("Content-Disposition", "attachment; filename="+new String(orgfilename.getBytes("KSC5601"),"ISO8859_1"));

				}else{
					// 한글 파일명 처리
					orgfilename = new String(orgfilename.getBytes("utf-8"),"iso-8859-1");

					response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
					response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
				}  
				response.setHeader ("Content-Length", ""+file.length() );
				os = response.getOutputStream();
				byte b[] = new byte[(int)file.length()];
				int leng = 0;
				while( (leng = in.read(b)) > 0 ){
					os.write(b,0,leng);
				}

			}else{
				response.setContentType("text/html;charset=UTF-8");
				return "<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>";
			}
			
			in.close();
			os.close();
		}catch(Exception e){
		  e.printStackTrace();
		}
		return "";
	}
	//게시글작성
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "/board_insert", method =
	 * {RequestMethod.GET,RequestMethod.POST}) public int board_insert(BoardVO vo)
	 * throws Exception { int insert = boardservice.insert(vo); return insert;
	 * //게시판화면 }
	 */
	//파일업로드
	@RequestMapping(value = "/boardInsert", method = {RequestMethod.GET,RequestMethod.POST})
	public String boardInsert(BoardVO bvo, @RequestParam("file") MultipartFile[] file) throws Exception {
		bvo.setSeq(boardservice.selectSeq(bvo));
		List<FileVO> fileList = new ArrayList<FileVO>();
		for(int i=0; i<file.length; i++) {
			if(file[i].getOriginalFilename()!="") {
				String originalName = file[i].getOriginalFilename();
				UUID uid = UUID.randomUUID();
				String saveName = uid.toString() + "." + originalName.split("\\.")[1];
				File target = new File(uploadPath, saveName);
				// byte[] fileData = file[i].getBytes();
				//FileCopyUtils.copy(fileData, target);
				file[i].transferTo(target);
				FileVO fvo = new FileVO();
				fvo.setSeq(bvo.getSeq());
				fvo.setReal_name(originalName);
				fvo.setSave_name(saveName);
				fvo.setSave_path(uploadPath);
				fileList.add(fvo);
			}
		}
		//system.currentTimeMillis() UUID 둘중 하나 사용
		int insert = boardservice.insert(bvo,fileList);
		return "/byeongkuk/board";	//게시판화면
	}
	////게시글 삭제
	@ResponseBody
	@RequestMapping(value = "/delete_Controller", method = {RequestMethod.GET,RequestMethod.POST})
	public int delete_Controller(PageVO pvo,@RequestParam (value = "delList[]") List<String> delList) throws Exception {
		int cnt = 0;
		for(String i : delList) {//선택한 글번호 배열로 받아서 반복
			cnt += boardservice.delete(i);	//삭제된게시글 수 저장
		}
		return cnt;	//게시판화면
	}
	//게시글수정
	@ResponseBody
	@RequestMapping(value = "/board_update", method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> update(@RequestParam Map<String, Object> map) throws Exception {
		//boardservice.update(map);
		map.put("display", 2);
		return map;	//글작성,수정,상세보기화면
	}
	
	//검색 ajax
	@ResponseBody
	@RequestMapping(value = "/search", method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> search(PageVO pvo) throws Exception {
		pvo.setPage(1);
		pvo.setTotalCount(boardservice.totalCount(pvo));
		List<BoardVO> list = boardservice.selectAll(pvo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pvo", pvo);
		map.put("list", list);
		return map;
	}
	//페이징 ajax
	@ResponseBody
	@RequestMapping(value = "/paging", method = {RequestMethod.GET,RequestMethod.POST})
	public Map<String, Object> paging(PageVO pvo) throws Exception {
		pvo.setTotalCount(boardservice.totalCount(pvo));
		List<BoardVO> list = boardservice.selectAll(pvo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pvo", pvo);
		map.put("list", list);
		return map;
	}
	
	//ajax로 jsp받기
	@RequestMapping(value = "/pagingJSP", method = {RequestMethod.GET,RequestMethod.POST})
	public String search(Model model,PageVO pvo) throws Exception {
		pvo.setTotalCount(boardservice.totalCount(pvo));
		List<BoardVO> list = boardservice.selectAll(pvo);
		model.addAttribute("list",list);
		model.addAttribute("pvo",pvo);
		return "byeongkuk/ajax";
	}
	
	@Inject
	private SqlSession sqlsession;
	@RequestMapping("nexa")
	public void nexa(HttpServletRequest request, HttpServletResponse response) throws PlatformException {
		
		System.out.println("넥사크로 접속 성공");
		HttpPlatformRequest req = new HttpPlatformRequest(request);
		req.receiveData();
		PlatformData data = req.getData();
		DataSet searchDs = data.getDataSet("searchDs");
		/*
		 * for(int i = 0;i<searchDs.getRowCount();i++) {
		 * 
		 * }
		 */
		String searchType = searchDs.getString(0, "searchType");
		String keyword = searchDs.getString(0, "searchKeyword");
		System.out.println(searchType+"--"+keyword);
		
		VariableList vl = data.getVariableList();
		String vlsearch = vl.getString("type");
		String vlkeyword = vl.getString("keyword");
		System.out.println(vlsearch+"---"+vlkeyword);
		
		
		
		
		List<Map<String,Object>> list = sqlsession.selectList("boardMapper.nexaSelect");
		DataSet ds = new DataSet("javaDs");
		ds.addColumn("seq",DataTypes.INT,100);
		ds.addColumn("name",DataTypes.STRING,100);
		ds.addColumn("id",DataTypes.STRING,100);
		ds.addColumn("subject",DataTypes.STRING,100);
		
		for(int i = 0; i < list.size();i++) {
			int row = ds.newRow();
			ds.set(row,"seq",list.get(i).get("seq").toString());
			ds.set(row,"name",list.get(i).get("mem_name").toString());
			ds.set(row,"id",list.get(i).get("mem_id").toString());
			ds.set(row,"subject",list.get(i).get("board_subject").toString());
		}
		PlatformData pList = new PlatformData();
		pList.addDataSet(ds);
		
		HttpPlatformResponse res = new HttpPlatformResponse(response,req);
		res.setData(pList);
		res.sendData();
	}
	@RequestMapping("nexaSearch")
	public void nexaSearch(HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpPlatformRequest req = new HttpPlatformRequest(request);
		req.receiveData();
		PlatformData data = req.getData();
		VariableList vl = data.getVariableList();
		String search = vl.getString("search");
		System.out.println(search);
		Map<String,Object> seq = new HashMap<String, Object>();
		seq.put("seq", search);
		System.out.println(seq.toString());
		List<Map<String,Object>> list = boardservice.selectOne(seq);
		System.out.println(list.toString());
		DataSet searchDs = new DataSet("searchDs");
		searchDs.addColumn("seq",DataTypes.INT,100);
		searchDs.addColumn("mem_name",DataTypes.STRING,100);
		searchDs.addColumn("mem_id",DataTypes.STRING,100);
		searchDs.addColumn("board_subject",DataTypes.STRING,100);
		searchDs.addColumn("board_content",DataTypes.STRING,100);
		for(Map<String,Object> li : list) {
			int row = searchDs.newRow();
			searchDs.set(row, "seq", li.get("seq"));
			searchDs.set(row, "mem_name", li.get("mem_name"));
			searchDs.set(row, "mem_id", li.get("mem_id"));
			searchDs.set(row, "board_subject", li.get("board_subject"));
			searchDs.set(row, "board_content", li.get("board_content"));
		}
		PlatformData searchData = new PlatformData();
		searchData.addDataSet(searchDs);
		
		HttpPlatformResponse res = new HttpPlatformResponse(response,req);
		res.setData(searchData);
		res.sendData();
	}
}
