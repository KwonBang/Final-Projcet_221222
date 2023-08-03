package com.payment.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.payment.dao.IF_PaymentDAO;

@Service
public class PaymentServiceImpl implements IF_PaymentService{
	@Inject
	IF_PaymentDAO paymentDao;
	public Map<String, Object> login(Map<String, Object> map) throws Exception {
		return paymentDao.login(map);
	}
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception {
		return paymentDao.list(map);
	}

	@Override
	public Map<String, Object> listCount() throws Exception {
		return paymentDao.listCount();
	}

	@Override
	public Map<String, Object> listNo(Map<String, Object> map) throws Exception {
		return paymentDao.listNo(map);
	}

	@Override
	public List<Map<String, Object>> statusList(Map<String, Object> map) throws Exception {
		return paymentDao.statusList(map);
	}

	@Override
	public int insert(Map<String, Object> map) throws Exception {
		int cnt = paymentDao.insert(map);
		paymentDao.historyInsert(map);
		return cnt;
	}

	@Override
	public int update(Map<String, Object> map) throws Exception {
		int cnt = paymentDao.update(map);
		paymentDao.historyInsert(map);
		return cnt;
	}

	@Override
	public List<Map<String, Object>> historyList(Map<String, Object> map) throws Exception {
		return paymentDao.historyList(map);
	}

}
