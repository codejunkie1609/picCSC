package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import android.widget.TextView;
import android.widget.Toast;


import com.theartofdev.edmodo.cropper.CropImage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;



public class CaptureImage extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private static final int GALLERY =0;
    private static final int CAMERA =1;
    private Button b,share;
    private ConstraintLayout ll;
    private ImageView iv;
    private TextView tv,tv1,tv2;
    private Uri filePath;
  //  private boolean flag=false;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_image);
        b=findViewById(R.id.setpic);
        ll=findViewById(R.id.layout);
      share=findViewById(R.id.share);
        iv=findViewById(R.id.imageView3);
        tv=findViewById(R.id.textView);
        tv1=findViewById(R.id.textView2);
        tv2=findViewById(R.id.textView3);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        b.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = getIntent();
                        String name = i.getStringExtra("name");
                        String state = i.getStringExtra("state");
                        String district = i.getStringExtra("district");
                        String installations=i.getStringExtra("installations");
                        tv.setTextColor(Color.WHITE);
                        tv.setText(name);
                        tv1.setTextColor(Color.WHITE);
                        tv1.setText(district+", "+state);
                        tv2.setTextColor(Color.WHITE);
                        tv2.setText("completed "+installations+" Aarogya Setu app installations");
                        //onChooseFile(v);
                        showPictureDialog();
                    }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                share();
            }
        });


    }

    private void share()
    {
        share.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);
        Bitmap bmap=getBitmapFromView(ll);
        try{
            File file=new File(this.getExternalCacheDir(),"template.jpg");
            FileOutputStream fout=new FileOutputStream(file);
            bmap.compress(Bitmap.CompressFormat.JPEG,100,fout);
            fout.flush();
            fout.close();
            file.setReadable(true,false);
            Intent intent=new Intent(Intent.ACTION_SEND);

            //intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/jpg");
            startActivity(Intent.createChooser(intent,"share by"));


        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


    }
    private Bitmap getBitmapFromView(View view)
    {
        Bitmap bmap=Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bmap);
        Drawable bgDrawable=view.getBackground();
        if(bgDrawable!=null)
        {
            bgDrawable.draw(canvas);
        }
        else{
            canvas.drawColor(getResources().getColor(android.R.color.white));
        }
        view.draw(canvas);
        return bmap;
    }
    private void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Select photo from gallery","camera"};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                checkPermission(
                                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        STORAGE_PERMISSION_CODE);

                                break;
                            case 1:
                                checkPermission(Manifest.permission.CAMERA,
                                        CAMERA_PERMISSION_CODE);

                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallary() {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Image"),GALLERY);
    }
    private void takePhotoFromCamera() {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) !=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[] { Manifest.permission.CAMERA},101);
        }
        else
        {
            Intent cam=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cam, CAMERA);
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }

        if(requestCode==GALLERY && resultCode==RESULT_OK && data!=null&&data.getData()!=null)
        {
            filePath=data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                iv.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (requestCode==CAMERA)
        {
            Bitmap bitmap=(Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(bitmap);
        }

    }
    public void checkPermission(String permission, int requestCode)
    {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(this,
                    new String[] { permission },
                    requestCode);
        }
        else {
            if(requestCode==100)
                takePhotoFromCamera();
            else
                choosePhotoFromGallary();
        }
    }
    //@Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults)
    {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);

        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
            else {
                Toast.makeText(getApplicationContext(),
                        "Camera Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
                takePhotoFromCamera();
            }
        }
        else if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    choosePhotoFromGallary();
            }
            else {
                Toast.makeText(getApplicationContext(),
                        "Storage Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();

            }
        }
    }
    public void onChooseFile(View v)
    {
        CropImage.activity().start(this);
    }

}

