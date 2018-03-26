package com.example.gand.myfirstapp;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class LaunchActivity extends AppCompatActivity implements View.OnClickListener, FrDialog.DialogCallback {
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        mButton1 = findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mButton3 = findViewById(R.id.button3);
        mButton3.setOnClickListener(this);

//Debug.waitForDebugger();

        Bundle bundle = new Bundle();
        bundle.putString("KEY", "SAD");

    }
    public void showCustomToast(){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_lo, null);
        TextView text = layout.findViewById(R.id.textView2);
        ImageView image = layout.findViewById(R.id.imageView);
        Toast toast = new Toast(this);
        toast.setView(layout);
        toast.show();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.settings:
                Toast.makeText(this,"Settings clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this,"Logout clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        mText = findViewById(R.id.textView);
        switch (v.getId()){
            case R.id.button1:
                showDialog();
                mText.setText(getString(R.string.bt1_text));
                break;
            case R.id.button2:
                switchFragment("Two",  ContextCompat.getColor(this, R.color.green));
                mText.setText(getString(R.string.bt2_text));
                break;
            case R.id.button3:
                switchFragment("Three", ContextCompat.getColor(this, R.color.blue));
                mText.setText(getString(R.string.bt3_text));
                break;
        }
    }

    void switchFragment(String name, int color){
        Fragment fragment;
        fragment = getSupportFragmentManager().findFragmentByTag(name);
        if (fragment == null){
            fragment = ExampleFragment.newInstance(name, color);
            getSupportFragmentManager().beginTransaction().replace(R.id.fr_container, fragment, name).commit();
        } else {
            Toast.makeText(this, "Не меняем", Toast.LENGTH_SHORT).show();
        }

    }

    private void showInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Info")
                .setMessage(R.string.dlg_msg)
                .setPositiveButton("true", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LaunchActivity.this, "Rigth!!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("false", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LaunchActivity.this, "Wrong...", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    void showDialog(){
        FrDialog.show(getSupportFragmentManager());
    }

    @Override
    public void setPositiveResult(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

}
