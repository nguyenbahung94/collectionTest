package com.example.collectionlabtest.mockio.mvp_login.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.collectionlabtest.R;
import com.example.collectionlabtest.mockio.mvp_login.Contract;
import com.example.collectionlabtest.mockio.mvp_login.LoginPresenter;
import com.example.collectionlabtest.mockio.mvp_login.data.LoginCredentials;
import com.example.collectionlabtest.mockio.mvp_login.data.LoginRepositoryImpl;


public class LoginActivity extends AppCompatActivity implements Contract.LoginView {

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(new LoginRepositoryImpl(), this);

        final EditText emailView = findViewById(R.id.email);
        final EditText passwordView = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(v -> {
            String email = emailView.getText().toString();
            String password = passwordView.getText().toString();

            LoginCredentials credentials = new LoginCredentials(email, password);
            presenter.login(credentials);
        });
    }

    @Override
    public void onSuccess() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
