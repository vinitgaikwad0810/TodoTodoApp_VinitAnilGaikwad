package com.example.vinit.todoapp_vinitanilgaikwad;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActivity extends AppCompatActivity {

    int positionFromMainActivity;
    String initialTextBeforeEditing;
    EditText etEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        positionFromMainActivity = getIntent().getIntExtra("position", 0);
        initialTextBeforeEditing = getIntent().getStringExtra("text");

        etEditText = (EditText)findViewById(R.id.etEditText);
        etEditText.setText(initialTextBeforeEditing);
        etEditText.setSelection(etEditText.getText().length());


    }



    public void onSubmit(View view) {
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("editedItem", etEditText.getText().toString());
        data.putExtra("code", positionFromMainActivity); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        // closes the activity, pass data to parent
        this.finish();
    }
}

