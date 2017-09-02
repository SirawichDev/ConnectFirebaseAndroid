package net.simplifiedcoding.firebaseexample;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class Uploadimage extends AppCompatActivity {


    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private ImageView imgview;
    private EditText editext;
    private Uri imgUrl;

    public static final String STORAGE_URL = "สมุนไพร/";
    public static final String DATABASE_PATH ="สมุนไพร";
    public static final int REQ_CODE= 1234;


    @Override

    public void btnBrow(View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select image"),REQ_CODE) ;


    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQ_CODE && resultCode == RESULT_OK && data != null && data.getData() != null){
            imgUrl = data.getData();

            try{
                Bitmap bm = MediaStore.Images.Media.getBitmap(getContentResolver(),imgUrl);
                imgview.setImageBitmap(bm);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


       ests")
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Inmage Uploaded",Toast.LENGTH_SHORT).show();
                    ImageUploadConfig imgup = new ImageUploadConfig(editext.getText().toString(),taskSnapshot.getDownloadUrl().toString());

                    String uploadedid = mDatabaseRef.push().getKey();
                    mDatabaseRef.child(uploadedid).setValue(imgup);


                }
            })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            dialog.dismiss();
                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();


                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @SuppressWarnings("VisibleForTests")
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progres = (100 * taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                            dialog.setMessage("Uploaded"+(int)progres+"%");
                        }
                    });
        }
        else
            Toast.makeText(getApplicationContext(),"please select image",Toast.LENGTH_SHORT).show();


    }
}