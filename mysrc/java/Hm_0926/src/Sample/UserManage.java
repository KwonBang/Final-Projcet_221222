package Sample;

import User.User;

public class UserManage {
	User user = new User();
	UserManage() {
		user.set_name("ABC");
		user.set_age(29);
		user.prt();
		user.age_up();
		user.prt();
	}
}
