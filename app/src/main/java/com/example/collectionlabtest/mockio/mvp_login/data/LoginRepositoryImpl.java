package com.example.collectionlabtest.mockio.mvp_login.data;

public class LoginRepositoryImpl implements LoginRepository {

    @Override
    public void login(LoginCredentials credentials, LoginListener loginListener) {

        if (credentials.isValid()) {
            loginListener.onSuccess();
        } else {
            loginListener.onFailure("Invalid credentials");
        }

    }

}
