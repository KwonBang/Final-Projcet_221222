package com.payment.dao;

import java.util.List;
import java.util.Map;

public interface IF_PaymentDAO {
	public Map<String, Object> login(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> list(Map<String, Object> map) throws Exception;
	public Map<String, Object> listCount() throws Exception;
	public Map<String,Object> listNo(Map<String, Object> map) throws Exception;
	public List<Map<String, Object>> statusList(Map<String, Object> map) throws Exception;
	public int insert(Map<String,Object> map) throws Exception;
	public int historyInsert(Map<String,Object> map) throws Exception;
	public int update(Map<String,Object> map) throws Exception;
	public List<Map<String, Object>> historyList(Map<String, Object> map) throws Exception;
}
