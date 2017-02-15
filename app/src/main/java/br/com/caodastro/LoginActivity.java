package br.com.caodastro;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText mPasswordView;
    private View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        mProgressView = findViewById(R.id.login_progress);
    }

    private void login() {
        AsyncTask<Void, Void, Boolean> asyncTask = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected void onPreExecute() {
                mProgressView.setVisibility(View.VISIBLE);
            }

            @Override
            protected Boolean doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000); //2 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }

            @Override
            protected void onPostExecute(Boolean result) {
                mProgressView.setVisibility(View.GONE);
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        };
        asyncTask.execute();
    }
}

