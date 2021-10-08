package umn.ac.id.ryanhertanto_00000036526_if570_el_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    private Button btnLogin;
    private EditText loginName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        btnLogin = findViewById(R.id.login);
        loginName = findViewById(R.id.login_name);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textString = loginName.getText().toString();
                if(textString.isEmpty()){
                    loginName.setError("Harap diisi");
                } else {
                    Intent intentLogin = new Intent(LoginPage.this, LibraryActivity.class);
                    String nama = loginName.getText().toString();
                    intentLogin.putExtra("Nama", nama);
                    startActivity(intentLogin);
                }
            }
        });
    }
}