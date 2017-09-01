package net.simplifiedcoding.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.firebase.client.realtime.util.StringListReader;

import java.util.HashMap;
import java.util.Map;

import static net.simplifiedcoding.firebaseexample.Config.FIREBASE_URL;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAddress;
    private  EditText editTextOption;
    private EditText textViewPersons;
    private Button buttonSave;
    private TextView mvalue;
    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mvalue = (TextView) findViewById(R.id.valueview);
        Firebase.setAndroidContext(this);
        mRef = new Firebase("https://herbs-e7bc7.firebaseio.com/");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                   Map<String,String>map= dataSnapshot.getValue(Map.class);
                String name = map.get("name");
                String option=map.get("option");
                Log.v("E_VALUE","NAME : "+name);
                Log.v("E_VALUE","option : "+option);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);


        textViewPersons = (EditText) findViewById(R.id.textViewPersons);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
                Firebase ref = new Firebase(FIREBASE_URL);

                //Getting values to store
                String name = editTextName.getText().toString().trim();
                String op = editTextAddress.getText().toString().trim();


                //Creating Person object
                Person person = new Person();

                //Adding values
                person.setName(name);
                person.setoption(op);


                //Storing values to firebase
                ref.child(name).setValue(person);




            }
        });
    }


}
