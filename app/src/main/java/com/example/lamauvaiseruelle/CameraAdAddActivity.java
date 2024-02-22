package com.example.lamauvaiseruelle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CameraAdAddActivity extends AppCompatActivity {

    // Define the button and imageview type variable
    Button camera_open_id;
    Button gallery_open_id;
    ImageView click_image_id;

    ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Bitmap image = (Bitmap) data.getExtras().get("data");
                click_image_id.setImageBitmap(image);
            }
        }
    });

    ActivityResultLauncher<Intent> galleryActivityResultLauncher = registerForActivityResult( new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                Uri image = (Uri) result.getData().getData();
                click_image_id.setImageURI(image);
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_ad_add); // Complete with the identifier of your activity

        camera_open_id = findViewById(R.id.button_camera_open_id);
        gallery_open_id = findViewById(R.id.button_gallery_open_id);
        click_image_id = findViewById(R.id.imageview_click_image_id);

        // Camera_open button is for open the camera and add the setOnClickListener in this button
        camera_open_id.setOnClickListener(v -> {
            Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            cameraActivityResultLauncher.launch(camera);
        });

        gallery_open_id.setOnClickListener(v -> {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            galleryActivityResultLauncher.launch(gallery);
        });
/*
        Button send = findViewById(R.id.button_send_id);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImageView image = findViewById(R.id. ...);
                TextView title = findViewById(R.id. ...);
                TextView address = findViewById(R.id. ...);

                Intent intent = new Intent(CameraAdAddActivity.this, AdListViewActivity.class);
                intent.putExtra("image", R.drawable. ...); // Add a drawable image because image management is not implemented.
                intent.putExtra("title",  ...);
                intent.putExtra("address", ...);
                startActivity(intent);
            }


        });

 */
    }
}