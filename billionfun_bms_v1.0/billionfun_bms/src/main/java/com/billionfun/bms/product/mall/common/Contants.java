package com.billionfun.bms.product.mall.common;

public class Contants {
	public static final String SESSION_USER = "SESSION_USER";
	
	public static final String REMIND_LIST_SQL = "SELECT NAME,DESCRIPTION,START_DATE,END_DATE,REMIND,REMIND_WAY,PLACE,STATUS,USER_ID"
			+ " FROM SYS_EVENT E WHERE DATE_SUB(START_DATE, INTERVAL REMIND HOUR) < NOW() AND NOW() <=START_DATE AND  REMIND >0 AND STATUS = 1 "
			+ " ORDER BY USER_ID DESC";
}
