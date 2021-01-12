package com.example.demo.cmm.enm;

public enum Sql {
	CREATE_MANAGERS, CREATE_SUBJECTS, CREATE_STUDENTS, CREATE_TEACHERS, 
	CREATE_GRADES, CREATE_ARTICLES, CREATE_REPLIES,
	TRUNCATE, COUNT, DROP;
	
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case CREATE_MANAGERS:
			query = "create table managers(\n" + 
					"   mgr_num int primary key auto_increment,\n" + 
					"   email varchar(20),\n" + 
					"   password varchar(20))"; 
			break;
		case CREATE_SUBJECTS:
			query = "create table subjects\n" + 
					"	 (sub_num int primary key auto_increment, subject varchar(30), description varchar(100));"; 
			break;
		case CREATE_STUDENTS:
			query = "create table students(\n" + 
					"   stu_num int primary key auto_increment,\n" + 
					"   userid varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   name varchar(20),\n" + 
					"   ssn varchar(20),\r\n" + 
					"   reg_date varchar(20),\n" + 
					"   profile_image varchar(100)\n" + 
					"   mgr_num int,\n" + 
					"   sub_num int,\n" + 
					"   constraint students_fk foreign key(mgr_num) references teachers(mgr_num))"; 
			break;
		case CREATE_TEACHERS:
			query = "create table teachers(\n" + 
					"   tea_num int primary key auto_increment,\n" + 
					"   name varchar(20),\n" + 
					"   password varchar(20),\n" + 
					"   subject varchar(20),\n" + 
					"   profile_image varchar(100)\n" +
					"   sub_num int,\n" + 
					"   constraint students_fk foreign key(sub_num) references teachers(sub_num))"; 
; 
			break;
		case CREATE_GRADES:
			query = "create table grades(\n" + 
					"	grd_num int primary key auto_increment,\n" + 
					"	subject varchar(20),\n" + 
					"	score varchar(20),\n" + 
					"	grade varchar(20),\n" + 
					"	stu_num int,\n" + 
					"	exam_date varchar(20))\n" + 
					"	constraint grades_fk foreign key(stu_num) references students(stu_num))"; 
			break;
		case CREATE_ARTICLES:
			query = "create table articles(\n" + 
					"	art_num int primary key auto_increment,n" + 
					"	title varchar(20),\n" + 
					"	content varchar(20),\n" + 
					"	count varchar(20),\n" + 
					"	writer_num int)";	
			break;
		case CREATE_REPLIES:
			query = "create table replies(\n" + 
					"	rep_num int primary key auto_increment,\n" + 
					"	content varchar(20),\n" + 
					"	art_num int,\n" + 
					"	constraint replies_fk foreign key(art_num) references articles(art_num))"; 
			break;
		case TRUNCATE:
			query = "truncate table "; 
			break;
		case COUNT:
			query = "select count(*) count from "; 
			break;
		case DROP:
			query = "drop table "; 
			break;
		}
		return query;
	}
}