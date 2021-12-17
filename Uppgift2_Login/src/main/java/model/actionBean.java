package model;

import java.util.ArrayList;
import java.util.List;

public class actionBean {
	
	userBean user1 = new userBean("Daniel", "admin");
	userBean user2 = new userBean("Peter", "fisk");
	
	
	List<userBean> users = new ArrayList<userBean>();
	{
		users.add(user1);
		users.add(user2);	
	}

	 public boolean createUser(String userName, String password) {
	        int targetIndexNr = findUser(userName);
	        if (targetIndexNr == -1) {
	            users.add(new userBean(userName, password));
	        }
	        return targetIndexNr == -1;
	    }

	
	public int findUser(String userName) {

        int targetIndexNr = -1;

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName() == userName) {
                targetIndexNr = i;
            }
        }
        return targetIndexNr;
    }
	
}
