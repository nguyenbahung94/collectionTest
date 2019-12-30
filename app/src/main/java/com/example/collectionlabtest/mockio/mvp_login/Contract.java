package com.example.collectionlabtest.mockio.mvp_login;


import com.example.collectionlabtest.mockio.mvp_login.data.LoginCredentials;

public interface Contract {

    interface LoginView {

        void onSuccess();

        void onFailed(String message);

    }

    interface Presenter {

        void login(LoginCredentials loginCredentials);

    }

}
