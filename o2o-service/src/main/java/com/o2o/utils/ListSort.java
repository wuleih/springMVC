package com.o2o.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 此方法慎用  测试中出现达不到预期效果
 * @author wl
 *
 * @param <E>
 */
public class ListSort<E> {  
    /** 
     *  
     * @param list 要排序的集合 
     * @param method 要排序的实体的属性所对应的get方法 
     * @param sort desc 为正序   
     */  
    public  void Sort(List<E> list, final String method, final String sort) {  
        // 用内部类实现排序  
        Collections.sort(list, new Comparator<E>() {  
  
            public int compare(E a, E b) {
                int ret = 0;  
                try {  
                    // 获取m1的方法名  
                    Method m1 = a.getClass().getMethod(method, null);  
                    // 获取m2的方法名  
                    Method m2 = b.getClass().getMethod(method, null);  
                      
                    if (sort != null && "desc".equals(sort)) {  
  
                        ret = m2.invoke(((E)b), null).toString().compareTo(m1.invoke(((E)a),null).toString());  
  
                    } else {  
                        // 正序排序  
                        ret = m1.invoke(((E)a), null).toString().compareTo(m2.invoke(((E)b), null).toString());  
                    }  
                } catch (NoSuchMethodException ne) {  
                } catch (IllegalArgumentException e) {  
                    e.printStackTrace();  
                } catch (IllegalAccessException e) {  
                    e.printStackTrace();  
                } catch (InvocationTargetException e) {  
                    e.printStackTrace();  
                }  
                return ret;  
            }  
        });  
    } 
   /* public static void main(String[] args) {
		
    	ArrayList<S> list= new ArrayList<S>();  
        list.add(new S(1,"张三",5));  
        list.add(new S(2,"张四",4));  
        list.add(new S(3,"张五",3));  
        list.add(new S(4,"张明",2));  
        list.add(new S(5,"张黑",1));  
        ListSort<S> listSort= new ListSort<S>();  
        listSort.Sort(list, "getAge", "desc");  
        for(S s:list){  
            System.out.println(s.getId()+s.getName()+s.getAge());  
        }  
  
    } */ 
}  