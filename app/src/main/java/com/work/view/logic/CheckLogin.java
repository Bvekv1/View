package com.work.view.logic;




import com.work.view.model.Users;

import java.util.List;

public class CheckLogin {
    private static List<Users> UserListLogin;
    private boolean result = false;
    private String CheckLoginname, checkPassword;

    public boolean check() {
        if (getUserListLogin() != null) {
            for (int i = 0; i < getUserListLogin().size(); i++) {
                final Users users = getUserListLogin().get(i);
                //logic to check if password and username matches
                result = CheckLoginname.equals(users.getUser()) && checkPassword.equals(users.getUserPassword());
            }
        } else {
            result = false;
        }
        return result;
    }

    public List<Users> getUserListLogin() {
        return UserListLogin;
    }

    public void setUserListLogin(List<Users> userListLogin) {
        UserListLogin = userListLogin;
    }

    public String getCheckLoginname() {
        return CheckLoginname;
    }

    public void setCheckLoginname(String CheckLoginname) {
        this.CheckLoginname = CheckLoginname;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }
}
