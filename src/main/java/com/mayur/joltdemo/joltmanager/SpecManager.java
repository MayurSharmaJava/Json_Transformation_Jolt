package com.mayur.joltdemo.joltmanager;

import com.mayur.joltdemo.entity.JoltSpecHistory;

import java.sql.Timestamp;
import java.util.Map;

public interface SpecManager extends SpecProvider{

    Map<Timestamp, JoltSpecHistory> getSpecHistory();

    int addUpdateSpec(String name,String specJson);
}
