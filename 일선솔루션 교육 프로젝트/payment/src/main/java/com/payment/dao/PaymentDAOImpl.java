package com.payment.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDAOImpl implements IF_PaymentDAO{
	
	@Inject
	SqlSession sqlsession;
	
	@Override
	public Map<String, Object> login(Map<String, Object> map) throws Exception {
		return sqlsession.selectOne("paymentMapper.login", map);
	}
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception {
		return sqlsession.selectList("paymentMapper.list", map);
	}

	@Override
	public Map<String, Object> listCount() throws Exception {
		return sqlsession.selectOne("paymentMapper.listCount");
	}

	@Override
	public Map<String, Object> listNo(Map<String, Object> map) throws Exception {
		return sqlsession.selectOne("paymentMapper.listNo", map);
	}

	@Override
	public List<Map<String, Object>> statusList(Map<String, Object> map) throws Exception {
		return sqlsession.selectList("paymentMapper.statusList", map);
	}

	@Override
	public int insert(Map<String, Object> map) throws Exception {
		return sqlsession.insert("paymentMapper.listInsert", map);
	}

	@Override
	public int historyInsert(Map<String, Object> map) throws Exception {
		return sqlsession.insert("paymentMapper.historyInsert", map);
	}

	@Override
	public int update(Map<String, Object> map) throws Exception {
		return sqlsession.update("paymentMapper.listUpdate", map);
	}

	@Override
	public List<Map<String, Object>> historyList(Map<String, Object> map) throws Exception {
		return sqlsession.selectList("paymentMapper.historyList", map);
	}

}
