package site.nomoreparties.stellarburgers.util;

import site.nomoreparties.stellarburgers.models.delete.Delete;
import site.nomoreparties.stellarburgers.models.registration.request.RequestRegistration;

public class GeneratorUsersDelete {
    public static Delete userDelete(RequestRegistration requestRegistration) {
        return new Delete()
                .withEmail(requestRegistration.getEmail())
                .withPassword(requestRegistration.getPassword());
    }
}
