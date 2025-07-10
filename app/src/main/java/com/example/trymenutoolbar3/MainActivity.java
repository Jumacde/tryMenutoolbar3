package com.example.trymenutoolbar3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ImageButton imageButton;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        textView = findViewById(R.id.textMain);
        //clickMenu(R.id.menuIcon);
        setUpMenuIcon();
        setupDrawerBackIcon();

    }


    /*
    *     private void clickMenu(int id) {
        imageButton = findViewById(id);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActitivity.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "test successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
    * */

    private void setUpMenuIcon() {
        imageButton = findViewById(R.id.menuIcon);
        if ( imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.END);
                    Toast.makeText(MainActivity.this, "drawer success", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    private void setupDrawerBackIcon() {
        imageButton = findViewById(R.id.backIcon);
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "close drawer", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.END);
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

}