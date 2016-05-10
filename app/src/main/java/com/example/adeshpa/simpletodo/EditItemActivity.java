package com.example.adeshpa.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edit_item);

        String name = this.getIntent().getStringExtra("itemText");
        position = this.getIntent().getIntExtra("itemPosition", -1);

        EditText saveItem = (EditText) findViewById(R.id.etSaveItem);
        saveItem.setText(name);
        saveItem.setSelection(saveItem.getText().length());
    }

    public void saveItem(View v) {
        EditText etSaveItem = (EditText) findViewById(R.id.etSaveItem);
        String itemText = etSaveItem.getText().toString();

        switchView(itemText);
    }

    private void switchView(String itemText) {
        Intent appInfo = new Intent(EditItemActivity.this, MainActivity.class);
        appInfo.putExtra("itemText", itemText);
        appInfo.putExtra("itemPosition", position);
        startActivity(appInfo);
    }
}
