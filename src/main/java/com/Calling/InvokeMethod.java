package com.Calling;

import com.Dao.UserDao;

import com.DaoImpl.UserDaoImpl;
import com.Model.USer;

public class InvokeMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
UserDao userDao = new UserDaoImpl();

//print all students
for (USer user : userDao.getAllUsers()) {
   System.out.println("user: [ Name : " + user.getName() + ",Password:"+user.getPassword() +",Email:"+user.getEmail()+",Address:"+user.getAddress()+",Phone:"+user.getPhone()+"]");
}
}
}