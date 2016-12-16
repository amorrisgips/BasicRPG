package com.example.sierra.basicrpg;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public final static String KVFILENAME = "rpg_basic_save";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toNewGame(View view){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        dialogBuilder.setTitle("Are You Sure?");
        dialogBuilder.setMessage("This will delete any previously saved data");
        dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), CharacterScreen.class);
                startActivity(intent);
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        dialogBuilder.show();
    }

    public void toLoadGame(View view){

        Intent intent = new Intent(this, LoadGame.class);
        startActivity(intent);

    }

    public void toSettings(View view) {
        Intent intent = new Intent(this, InvView.class);
        startActivity(intent);
    }

    public void makeToast(View view) {
        Toast.makeText(getApplicationContext(),R.string.versionToast, Toast.LENGTH_LONG).show();
    }


}
