package com.edu.conf;

import org.hibernate.dialect.MySQL5InnoDBDialect;

@SuppressWarnings("deprecation")
public class LocalMysqlDialect extends MySQL5InnoDBDialect{

	@Override
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}
}
