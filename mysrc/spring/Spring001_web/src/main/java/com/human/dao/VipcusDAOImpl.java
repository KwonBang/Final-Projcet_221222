package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.VipcusVO;

@Repository
public class VipcusDAOImpl implements IF_VipcusDAO{
	@Inject
	private SqlSession sql;
	public static String mquery = "com.human.dao.IF_VipcusDAO";
	@Override
	public void insert(VipcusVO vvo) throws Exception {
		sql.insert(mquery+".put", vvo);
	}

	@Override
	public List<VipcusVO> select() throws Exception {
		return sql.selectList(mquery+".show");
	}

	@Override
	public VipcusVO selectOne(VipcusVO vvo) throws Exception {
		
		return sql.selectOne(mquery+".one", vvo);
	}

	@Override
	public void mod(VipcusVO vvo) throws Exception {
		
		sql.insert(mquery+".mod",vvo);
	}

	@Override
	public void del(VipcusVO vvo) throws Exception {
		sql.delete(mquery+".del",vvo);
	}

}
