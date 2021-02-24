package com.tglh.simpleqigscanproject.service.impl;

import com.tglh.simpleqigscanproject.entity.DepartMent;
import com.tglh.simpleqigscanproject.entity.InsertAdvise;
import com.tglh.simpleqigscanproject.mapper.QigScanMapper;
import com.tglh.simpleqigscanproject.service.QigScanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QigScanServiceImpl implements QigScanService {

    @Autowired
    private QigScanMapper qigScanMapper;

    @Override
    public List<DepartMent> selectFuSelectFu() {
        List<DepartMent> departMents = qigScanMapper.selectFuSelect();
        return departMents;
    }

    @Override
    public List<DepartMent> selectFuSelectSon(String fuNumber) {
        List<DepartMent> departMents = qigScanMapper.selectSonSelect(fuNumber);
        return departMents;
    }

    @Override
    public int insertData(InsertAdvise insertAdvise) {
        int flag = qigScanMapper.insertData(insertAdvise);
        return flag;
    }
}
