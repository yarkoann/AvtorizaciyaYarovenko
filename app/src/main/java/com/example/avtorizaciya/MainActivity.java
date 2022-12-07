package com.example.avtorizaciya;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Объявляем об использовании следующих объектов:
    private EditText username111;
    private EditText pass111;
    private Button log;
    private TextView login;
    private TextView numbers111;

    // Число для подсчета попыток залогиниться:
    int numbersss = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Связываемся с элементами нашего интерфейса:
        username111 = (EditText) findViewById(R.id.name1);
        pass111 = (EditText) findViewById(R.id.pass1);
        log = (Button) findViewById(R.id.button);
        login = (TextView) findViewById(R.id.block);
        numbers111 = (TextView) findViewById(R.id.numbers);
        numbers111.setText(Integer.toString(numbersss));

        log.setOnClickListener(view -> {
            Login(view);
        });

    }

    // Обрабатываем нажатие кнопки "Войти":
    public void Login(View view) {


        // Если введенные логин и пароль будут словом "admin",
        // показываем Toast сообщение об успешном входе:
        if (username111.getText().toString().equals("admin") &&
                pass111.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Вход совершен",Toast.LENGTH_SHORT).show();

            // Выполняем переход на другой экран:
            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
        }

        // В другом случае выдаем сообщение с ошибкой:
        else {
            Toast.makeText(getApplicationContext(), "Некорректные данные",Toast.LENGTH_SHORT).show();
            numbersss--;

            // Делаем видимыми текстовые поля, указывающие на количество оставшихся попыток:
            numbers111.setVisibility(View.VISIBLE);
            numbers111.setText(Integer.toString(numbersss));

            // Когда выполнено 3 безуспешных попытки залогиниться,
            // делаем видимым текстовое поле с надписью, что все пропало и выставляем
            // кнопке настройку невозможности нажатия setEnabled(false):
            if (numbersss == 0) {
                login.setEnabled(false);
                login.setVisibility(View.VISIBLE);
                login.setBackgroundColor(Color.RED);
                login.setText("Заблокировано");
            }
        }
    }
}