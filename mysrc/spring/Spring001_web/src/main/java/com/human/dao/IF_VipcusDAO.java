package com.human.dao;

import java.util.List;

import com.human.vo.VipcusVO;

public interface IF_VipcusDAO {
	public void insert(VipcusVO vvo) throws Exception;
	public List<VipcusVO> select() throws Exception;
	public VipcusVO selectOne(VipcusVO vvo) throws Exception;
	public void mod(VipcusVO vvo) throws Exception;
	public void del(VipcusVO vvo) throws Exception;
}
