package site.nomoreparties.stellarburgers.models.login.request;

public class RequestLogin {
    private String email;
    private String password;
    public RequestLogin withEmail(String email) {
        this.email = email;
        return this;
    }
    public RequestLogin withPassword(String password) {
        this.password = password;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}

