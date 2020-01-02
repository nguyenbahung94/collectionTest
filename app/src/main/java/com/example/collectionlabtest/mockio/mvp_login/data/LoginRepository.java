package com.example.collectionlabtest.mockio.mvp_login.data;

public interface LoginRepository {

    interface LoginListener {

        void onSuccess();

        void onFailure(String message);

    }

    void login(LoginCredentials credentials, LoginListener loginListener);

}
