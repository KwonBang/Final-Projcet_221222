package com.human.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_VipcusDAO;
import com.human.vo.VipcusVO;

@Service
public class VipcusserviceImpl implements IF_Vipcusservice{

	@Inject
	IF_VipcusDAO vdao;
	@Override
	public void insert(VipcusVO vvo) throws Exception {
		vdao.insert(vvo);
		
	}
	@Override
	public List<VipcusVO> select() throws Exception {
		// TODO Auto-generated method stub
		return vdao.select();
	}
	@Override
	public VipcusVO selectOne(VipcusVO vvo) throws Exception {
		// TODO Auto-generated method stub
		return vdao.selectOne(vvo);
	}
	@Override
	public void mod(VipcusVO vvo) throws Exception {
		vdao.mod(vvo);
	}
	@Override
	public void del(VipcusVO vvo) throws Exception {
		vdao.del(vvo);
	}

}
