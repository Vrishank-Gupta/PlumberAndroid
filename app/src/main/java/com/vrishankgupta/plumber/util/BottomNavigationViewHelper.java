package com.vrishankgupta.plumber.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.vrishankgupta.plumber.BookingActivity;
import com.vrishankgupta.plumber.HomeActivity;
import com.vrishankgupta.plumber.MainActivtity;
import com.vrishankgupta.plumber.R;

public class BottomNavigationViewHelper {
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx)
    {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(true);
    }


    public static void enableNavigation(final Context context, BottomNavigationViewEx view)
    {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, HomeActivity.class); //act0
                        context.startActivity(intent1);
                        break;

//                    case R.id.ic_booking:
//                        context.startActivity(new Intent(context, MainActivtity.class)); //act1
//                        break;
                    case R.id.ic_account:
                        context.startActivity(new Intent(context, MainActivtity.class)); //act2..
                        break;

//                    case R.id.ic_contact:
//                        context.startActivity(new Intent(context, BookingActivity.class));
//                        break;
//
//                    case R.id.ic_voucher:
//                        context.startActivity(new Intent(context, BookingActivity.class));
//                        break;
                }



                return false;
            }
        });
    }
}
