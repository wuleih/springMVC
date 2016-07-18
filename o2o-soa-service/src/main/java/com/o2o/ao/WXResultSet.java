package com.o2o.ao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;

public class WXResultSet<T> implements Serializable{
	private static final long serialVersionUID = -5143446276966950022L;
	private long total = 0;
	private List<T> result;
	private String modifyTime; 
	private Object ext;
	
	public WXResultSet(){
		
	}
	
	public WXResultSet(long total,List<T> result){
		this.total=total;
		this.result=result;
	}
	
	public WXResultSet(long total,List<T> result,String modifyTime){
		this.total=total;
		this.result=result;
		this.modifyTime = modifyTime;
	}
	
	public WXResultSet(List<T> result){		
		this.total=result == null ? 0 : result.size();		
		this.result=result;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	public String getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Object getExt() {
		return ext;
	}

	public void setExt(Object ext) {
		this.ext = ext;
	}	
	
	public Map<String,Object> toJq(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("total", this.total);
		map.put("rows", this.result);
		
		return map;
	}
	
	public Map<String,Object> toDatatables(String sEcho){
		Map<String,Object> map = new HashMap<String,Object>();
        map.put("data", result);
        map.put("iTotalRecords",total);
        map.put("iTotalDisplayRecords",total);
        map.put("sEcho", sEcho); 
        return map;
	}
	
	public List convertResult(Class<?> clz){
		if(this.result == null) return null;
		List result = new ArrayList();
		try {
			for(T t : this.result){
				Object obj = clz.newInstance();
				BeanUtils.copyProperties(t, obj);
				result.add(obj);
			}
			return result;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
