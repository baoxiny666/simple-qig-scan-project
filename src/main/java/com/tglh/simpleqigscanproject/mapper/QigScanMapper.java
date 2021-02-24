package com.tglh.simpleqigscanproject.mapper;

import com.tglh.simpleqigscanproject.entity.DepartMent;
import com.tglh.simpleqigscanproject.entity.InsertAdvise;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QigScanMapper {
    @Select("select id,depart_name departName,depart_pid departPid from sys_department where depart_pid = 0")
    public List<DepartMent> selectFuSelect();
    @Select("select\n " +
            "                id,\n" +
            "                depart_name departName,\n" +
            "                depart_pid departPid\n " +
            "             from sys_department\n " +
            "             where depart_pid = #{fuNumber}")
    public List<DepartMent> selectSonSelect(String fuNumber);

    @Insert("insert into qig_advise (depart_ment,depart_ment_son,rules_name,flow_name,advise_yij,submit_person,tele_phone,create_time,depart_ment_fu_name,depart_ment_son_name) " +
            " values (#{depart_ment},#{depart_ment_son},#{rules_name},#{flow_name},#{advise_yij},#{submit_person},#{tele_phone},STR_TO_DATE(#{create_time},'%Y-%m-%d %H:%i:%s')" +
            ",#{depart_ment_fu_name},#{depart_ment_son_name})")
    public int  insertData(InsertAdvise insertAdvise);

}
