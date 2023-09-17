package site.nomoreparties.stellarburgers.models.login.response;

public class ResponseLogin {

    private boolean success;
    private String accessToken;
    private String refreshToken;
    private User user;

    public boolean isSuccess() {
        return success;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public User getUser() {
        return user;
    }
}
