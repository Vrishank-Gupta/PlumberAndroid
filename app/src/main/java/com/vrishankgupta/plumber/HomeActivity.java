package com.vrishankgupta.plumber;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.vrishankgupta.plumber.util.BottomNavigationViewHelper;

import mehdi.sakout.fancybuttons.FancyButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FancyButton btnLocation,customLoc;

        btnLocation = findViewById(R.id.btn_location);
        customLoc = findViewById(R.id.btn_custom);

        btnLocation.setIconResource(R.drawable.ic_location);
        customLoc.setIconResource(R.drawable.ic_custom);
        setupBottomNavigationView();

        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int perm = ContextCompat.checkSelfPermission(
                        HomeActivity.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION);

                if (perm == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(HomeActivity.this, MainActivtity.class);
                    intent.putExtra("Loc",1);
                    startActivity(intent);
                } else {
                    ActivityCompat.requestPermissions(
                            HomeActivity.this,
                            new String[] {Manifest.permission.ACCESS_COARSE_LOCATION},
                            44
                    );
                }

            }
        });

        customLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainActivtity.class);
                intent.putExtra("Cust",2);
                startActivity(intent);
            }
        });
    }
    private void setupBottomNavigationView()
    {
        Log.d("HomeActivity", "setupBottomNavigationView: setting up botNavView");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bnve);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(HomeActivity.this,bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == 44) { //write request
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(HomeActivity.this, MainActivtity.class);
                intent.putExtra("Loc",1);
                startActivity(intent);            } else {
                Toast.makeText(this, "Location Access Required!", Toast.LENGTH_SHORT).show();
            }
        }
        else if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
            Toast.makeText(HomeActivity.this, "Go to Settings and Grant the permission to use this feature.", Toast.LENGTH_SHORT).show();
        }
    }
}
