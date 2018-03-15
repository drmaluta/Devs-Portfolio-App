package com.madonasyombua.growwithgoogleteamproject.actvities;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.madonasyombua.growwithgoogleteamproject.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.madonasyombua.growwithgoogleteamproject.R;
import com.madonasyombua.growwithgoogleteamproject.models.Project;
import com.madonasyombua.growwithgoogleteamproject.util.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProjectsActivity extends AppCompatActivity {
    private static final String TAG = "AddFeeds";

    @BindView(R.id.project_title_text)
    EditText project_title;
    @BindView(R.id.shortDescription_text)
    EditText short_description;
    @BindView(R.id.longDescription_text)
    EditText long_description;
    @BindView(R.id.project_url_text)
    EditText project_url;
    @BindView(R.id.btn_add_project)
    Button add;
    @BindView(R.id.btn_cancel)
    Button cancel;

    private String title, shortDescription, longDescription;
    private int portfolioImage;
    private String url;
    private String userKey;
// Start Activity Projects here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        ButterKnife.bind(this);

        Spinner staticSpinner = (Spinner) findViewById(R.id.project_img);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(this, R.array.project_image_values,
                        android.R.layout.simple_spinner_item);


        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
        staticSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position) {
                    case 0:
                        portfolioImage = R.drawable.ic_facebook;
                        break;
                    case 1:
                        portfolioImage = R.drawable.logo;
                        break;
                    case 2:
                        portfolioImage = R.drawable.ic_google;
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


    }
}
