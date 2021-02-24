package com.tglh.simpleqigscanproject.service;

import com.tglh.simpleqigscanproject.entity.DepartMent;
import com.tglh.simpleqigscanproject.entity.InsertAdvise;

import java.util.List;

public interface QigScanService {
    public List<DepartMent> selectFuSelectFu();

    public List<DepartMent> selectFuSelectSon(String fuNumber);

    public int insertData(InsertAdvise insertAdvise);

}
