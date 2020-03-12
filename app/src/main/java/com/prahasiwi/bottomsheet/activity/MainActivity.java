package com.prahasiwi.bottomsheet.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prahasiwi.bottomsheet.R;
import com.prahasiwi.bottomsheet.fragment.BottomSheetListFragment;

public class MainActivity extends AppCompatActivity {

    private CardView bt_klik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_klik = findViewById(R.id.bt_klik);

        bt_klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragmentOnTop(BottomSheetListFragment.newInstance("LOGIN", "LUPA PASSWORD"));
            }
        });
    }

    public void addFragmentOnTop(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}
