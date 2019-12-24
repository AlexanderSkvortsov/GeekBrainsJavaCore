package server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
    void  setNicknameByLogin(String login, String nickname);
    boolean registration(String login, String password, String nickname);
}
