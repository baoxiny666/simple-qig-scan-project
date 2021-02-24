package com.tglh.simpleqigscanproject.entity;

import lombok.Data;

@Data
public class InsertAdvise {
    private Integer id;
    private Integer depart_ment;
    private String depart_ment_fu_name;
    private Integer depart_ment_son;
    private String depart_ment_son_name;
    private String rules_name;
    private String flow_name;

    private String advise_yij;
    private String submit_person;
    private String tele_phone;
    private String create_time;

}
