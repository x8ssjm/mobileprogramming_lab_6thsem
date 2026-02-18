package com.app.labbca6thsem;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SqliteActivity extends AppCompatActivity {

    DatabaseHelper dbHelper;
    EditText etId, etName, etAddress, etContact;
    Button btnAdd, btnView, btnUpdate, btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dbHelper = new DatabaseHelper(this);

        etId = findViewById(R.id.et_id);
        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);
        etContact = findViewById(R.id.et_contact);

        btnAdd = findViewById(R.id.btn_add_data);
        btnView = findViewById(R.id.btn_view_data);
        btnUpdate = findViewById(R.id.btn_update_data);
        btnDelete = findViewById(R.id.btn_delete_data);

        // ADD DATA
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String address = etAddress.getText().toString();
                String contact = etContact.getText().toString();

                if (name.isEmpty() || address.isEmpty() || contact.isEmpty()) {
                    Toast.makeText(SqliteActivity.this, "Fill all required fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isInserted = dbHelper.insertData(name, address, contact);
                if (isInserted) {
                    Toast.makeText(SqliteActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(SqliteActivity.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // VIEW DATA (Show in Dialog)
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.getAllData();
                if (cursor.getCount() == 0) {
                    Toast.makeText(SqliteActivity.this, "No Data Found", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder builder = new StringBuilder();
                while (cursor.moveToNext()) {
                    builder.append("ID: ").append(cursor.getString(0)).append("\n");
                    builder.append("Name: ").append(cursor.getString(1)).append("\n");
                    builder.append("Address: ").append(cursor.getString(2)).append("\n");
                    builder.append("Contact: ").append(cursor.getString(3)).append("\n\n");
                    builder.append("----------------------------\n\n");
                }

                // Show in a Dialog so it's visible on screen
                AlertDialog.Builder dialog = new AlertDialog.Builder(SqliteActivity.this);
                dialog.setTitle("Stored Student Data");
                dialog.setMessage(builder.toString());
                dialog.setPositiveButton("OK", null);
                dialog.show();

                Log.d("SQLiteData", builder.toString());
            }
        });

        // UPDATE DATA
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                String address = etAddress.getText().toString();
                String contact = etContact.getText().toString();

                if (id.isEmpty()) {
                    Toast.makeText(SqliteActivity.this, "Enter ID to update", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean isUpdated = dbHelper.updateData(id, name, address, contact);
                if (isUpdated) {
                    Toast.makeText(SqliteActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SqliteActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // DELETE DATA
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                if (id.isEmpty()) {
                    Toast.makeText(SqliteActivity.this, "Enter ID to delete", Toast.LENGTH_SHORT).show();
                    return;
                }

                int deletedRows = dbHelper.deleteData(id);
                if (deletedRows > 0) {
                    Toast.makeText(SqliteActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                    clearFields();
                } else {
                    Toast.makeText(SqliteActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void clearFields() {
        etId.setText("");
        etName.setText("");
        etAddress.setText("");
        etContact.setText("");
    }
}
