package server;

import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {


    private List<UserData> users;

    public SimpleAuthService(ArrayList<UserData> usersDB) {
        users = new ArrayList<>();
        users.addAll(usersDB);
    }

    public SimpleAuthService() {
        this.users = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new UserData("login" + i, "pass" + i, "nick" + i));
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData o:users ) {
            if(o.getLogin().equals(login) && o.getPassword().equals(password)){
                return o.getNickname();
            }
        }
        return null;
    }

    public void setNicknameByLogin(String login, String newnickname) {
        for (UserData o:users ) {
            if(o.getLogin().equals(login)){
                o.setNickname(newnickname);
                break;
            }
        }
    }

    @Override
    public boolean registration(String login, String password, String nickname) {
        for (UserData o:users ) {
            if(o.getLogin().equals(login)){
                return false;
            }
        }

        users.add(new UserData(login, password, nickname));
        return true;
    }
}
