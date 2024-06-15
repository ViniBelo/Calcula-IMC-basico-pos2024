package br.edu.utfpr.calculaimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etWidth;
    private EditText etHeight;
    private TextView tvResult;
    private Button btCalculate;
    private Button btClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etWidth = findViewById(R.id.etWidth);
        etHeight = findViewById(R.id.etHeight);
        tvResult = findViewById(R.id.tvResult);
        btCalculate = findViewById(R.id.btCalculate);
        btClear = findViewById(R.id.btClear);

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btClearOnClick();
            }
        });
    }

    public void btCalculateOnClick(View view) {

        if (etWidth.getText().toString().isEmpty()) {
            etWidth.setError("Campo peso deve ser preenchido!");
            etWidth.requestFocus();
            return;
        }

        if (etHeight.getText().toString().isEmpty()) {
            etHeight.setError("Campo altura deve ser preenchido!");
            etHeight.requestFocus();
            return;
        }

        double width = Double.parseDouble(etWidth.getText().toString());
        double height = Double.parseDouble(etHeight.getText().toString());
        double result = width / Math.pow(height, 2);
        DecimalFormat decimalFormat = new DecimalFormat("00.00");
        tvResult.setText(decimalFormat.format(result));
    }

    private void btClearOnClick() {
        etWidth.setText("");
        etHeight.setText("");
        tvResult.setText("0.0");
        etWidth.requestFocus();
    }
}