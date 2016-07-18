package com.o2o.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDataSource extends AbstractRoutingDataSource{
    
	public static final String DATA_SOURCE_READ = "dataSourceRead";
	
	public static final String DATA_SOURCE_WRITE = "dataSourceWrite";
	
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    
    public static void setCustomerType(String customerType) {
            contextHolder.set(customerType);
    }
    public static String getCustomerType() {
            return contextHolder.get();
    }
    public static void clearCustomerType() {
            contextHolder.remove();
    }
	
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return getCustomerType();
	}

}
