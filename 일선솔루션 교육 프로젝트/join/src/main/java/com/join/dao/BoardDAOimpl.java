package com.join.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.join.vo.BoardVO;
import com.join.vo.FileVO;
import com.join.vo.PageVO;
@Repository
public class BoardDAOimpl implements IF_BoardDAO{
	private static String mapperQuery = "boardMapper";
	@Inject
	private SqlSession sqlsession;
	@Override
	public List<BoardVO> selectAll(PageVO pvo) throws Exception {
		return sqlsession.selectList(mapperQuery+".selectAll",pvo);
	}
	@Override
	public int insert(BoardVO vo,List<FileVO> flist) throws Exception {
		int cnt = 0;
		sqlsession.insert(mapperQuery+".insert", vo);
		for(FileVO fvo : flist) {
			sqlsession.insert("fileMapper.fileInsert", fvo);
			cnt++;
		}
		return cnt;
	}
	@Override
	public int delete(String seq) throws Exception {
		return sqlsession.delete(mapperQuery+".delete", seq);
	}
	@Override
	public List<Map<String, Object>> selectOne(Map<String, Object> seq) throws Exception {
		return sqlsession.selectList(mapperQuery+".selectOne", seq);
	}
	@Override
	public int update(Map<String, Object> board) throws Exception {
		return sqlsession.update(mapperQuery+".update", board);
	}
	@Override
	public int totalCount(PageVO pvo) throws Exception {
		return sqlsession.selectOne(mapperQuery+".totalCount",pvo);
	}
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception {
		return sqlsession.selectList(mapperQuery+".list", map);
	}
	@Override
	public int selectSeq(BoardVO bvo) throws Exception {
		return sqlsession.selectOne(mapperQuery+".selectSeq", bvo);
	}

}
