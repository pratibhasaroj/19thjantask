package com.DaoImpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Dao.UserDao;
import com.Model.USer;


@Repository("userdao")
public  class UserDaoImpl implements UserDao
{
	
	
List<USer> users;

public UserDaoImpl(){
	users = new ArrayList<USer>();
  USer user1 = new USer("prati","abc123","pqr@gmail.com","mumbai","9853356379");
  USer user2 = new USer("sonakshi","abc123","pqr@gmail.com","mumbai","9853356379");
  users.add(user1);
  users.add(user2);
}


public List<USer> getAllUsers() {
		return users;
}


}