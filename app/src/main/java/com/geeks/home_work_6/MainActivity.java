package com.geeks.home_work_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView enter = findViewById(R.id.tv_enter);
        TextView welcome = findViewById(R.id.tv_welcome);
        TextView doEnter = findViewById(R.id.tv_do_enter);
        Button button = findViewById(R.id.button);
        TextView register = findViewById(R.id.tv_register);
        EditText email = findViewById(R.id.edit_text_1);
        EditText password = findViewById(R.id.edit_text_2);
        LinearLayout linearLayout = findViewById(R.id.liner_layout);
        LinearLayout ll = findViewById(R.id.ll);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    button.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    button.setBackgroundColor(getResources().getColor(R.color.grey));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence t, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence t, int start, int before, int count) {
                if (t.length() > 0) {
                    button.setBackgroundColor(getResources().getColor(R.color.orange));
                }else{
                    button.setBackgroundColor(getResources().getColor(R.color.grey));
                }
            }

            @Override
            public void afterTextChanged(Editable t) {

            }
        });
        button.setOnClickListener(view ->{

            String login = email.getText().toString();
            String pass = password.getText().toString();

            if (login.equals("admin") && pass.equals("admin")){
                linearLayout.setVisibility(View.GONE);
                enter.setVisibility(View.GONE);
                doEnter.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
                ll.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_LONG).show();
            }

        });
    }

}