package com.app.labbca6thsem;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {

    Button btnOpenDialog;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btnOpenDialog = findViewById(R.id.btn_open_input_dialog);
        tvDisplay = findViewById(R.id.tv_display_details);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });
    }

    private void showInputDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_custom_dialog);
        dialog.setCancelable(true);

        final EditText etName = dialog.findViewById(R.id.et_dialog_name);
        final EditText etRoll = dialog.findViewById(R.id.et_dialog_roll);
        final EditText etResult = dialog.findViewById(R.id.et_dialog_result);
        final EditText etGrade = dialog.findViewById(R.id.et_dialog_grade);
        Button btnSave = dialog.findViewById(R.id.btn_save_dialog_data);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String roll = etRoll.getText().toString();
                String result = etResult.getText().toString();
                String grade = etGrade.getText().toString();

                if (name.isEmpty() || roll.isEmpty() || result.isEmpty() || grade.isEmpty()) {
                    Toast.makeText(DialogActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    String info = "Student Detail:\n" +
                            "Name: " + name + "\n" +
                            "Roll: " + roll + "\n" +
                            "Result: " + result + "\n" +
                            "Grade: " + grade;

                    tvDisplay.setText(info);
                    dialog.dismiss();
                    Toast.makeText(DialogActivity.this, "Details Displayed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }
}
