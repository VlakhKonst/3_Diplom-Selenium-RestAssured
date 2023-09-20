package site.nomoreparties.stellarburgers.util;

import site.nomoreparties.stellarburgers.models.login.request.RequestLogin;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;

public class GeneratorUserLogin {
    public static RequestLogin userLogin(RequestRegistration requestRegistration) {
        return new RequestLogin()
                .withEmail(requestRegistration.getEmail())
                .withPassword(requestRegistration.getPassword());
    }
}
