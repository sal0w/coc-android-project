package com.parse.starter;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseFile;

import java.io.ByteArrayOutputStream;

public class UploadActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    ParseFile file ;
    String item;
    EditText uploaddescription,Name;
    Button UploadButton;
    Boolean Village= false,War =false;
    private ImageView imgView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        uploaddescription = (EditText)findViewById(R.id.Uploaddescription);
        Name=(EditText)findViewById(R.id.Name);
        UploadButton = (Button)findViewById(R.id.UploadButton);
        //final ImageView imgView = null;


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




        UploadButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String description = String.valueOf(uploaddescription.getText());
                String Namee = String.valueOf(Name.getText());
                boolean Base;
                int TownHall = 0;

                if (item.equals("One")){
                    TownHall =1;


                }else if(item.equals("Two"))
                {
                    TownHall =2;

                }
                else if(item.equals("Three"))
                {
                    TownHall =3;

                }
                else if(item.equals("Four"))
                {
                    TownHall =4;

                }
                else if(item.equals("Five"))
                {
                    TownHall =5;

                }
                else if(item.equals("Six"))
                {
                    TownHall =6;

                }
                else if(item.equals("Seven"))
                {
                    TownHall =7;

                }
                else if(item.equals("Eight"))
                {
                    TownHall =8;

                }
                else if(item.equals("Nine"))
                {
                    TownHall =9;

                }
                else if(item.equals("Ten"))
                {
                    TownHall =10;

                }
                else if(item.equals("Eleven"))
                {
                    TownHall =11;

                }


                if (imgView!= null){
                    if (War ^ Village) {

                        if(Village){
                            Base = true;
                        }
                        else{
                            Base = false;
                        }

                        if (TextUtils.isEmpty(Namee) || TextUtils.isEmpty(description)) {
                            if (TextUtils.isEmpty(Namee)) {
                                Name.setError("Enter a name");
                                return;


                                //Toast.makeText(UploadActivity.this, "wrng " , Toast.LENGTH_SHORT).show();



                            } else {
                                uploaddescription.setError("Enter a description");
                                return;
                            }
                        } else {
                            //Toast.makeText(UploadActivity.this, "right ", Toast.LENGTH_SHORT).show();


                            /*ParseObject newObject = new ParseObject("salow");
                            newObject.put("Base",true);
                            newObject.put("Townhall",1);
                            newObject.put("Name","abhbaj");
                            //newObject.put("Image",file);
                            newObject.put("String","gajhjh");
                            newObject.saveInBackground();*/
                            Base testbae = new Base();
                            testbae.setTownhall(TownHall);
                            testbae.setBase(Base);
                            testbae.setName(Namee);
                            testbae.setImage(file);
                            testbae.setDescription(description);
                            testbae.setViews(1);
                            testbae.saveInBackground();







                        }

                    } else {
                        Toast.makeText(UploadActivity.this, "Select correct base ", Toast.LENGTH_SHORT).show();
                    }
            }

                else{

                    Toast.makeText(UploadActivity.this, "Select a Picture!!! " , Toast.LENGTH_SHORT).show();

                }

            }
        });







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadImagefromGallery(view);

                Snackbar.make(view, "hi", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.VillagecheckBox:
                if (checked){
                    Village = checked;

                }
                // Put some meat on the sandwich
                else{
                    Village = false;

                }
                // Remove the meat
                break;
            case R.id.WarcheckBox:
                if (checked){

                    War= checked;

                }
                // Cheese me
                else{
                    War = false;

                }
                // I'm lactose intolerant
                break;

        }
    }



    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                imgView = (ImageView) findViewById(R.id.placeImage);
                // Set the Image in ImageView after decoding the String

                ;
                Bitmap bitmap = BitmapFactory.decodeFile(imgDecodableString);
                // Convert it to byte
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                // Compress image to lower quality scale 1 - 100
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] image = stream.toByteArray();

                // Create the ParseFile
                file = new ParseFile("androidbegin.jpg", image);




                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        item = String.valueOf(parent.getItemAtPosition(position));
        //Toast.makeText(UploadActivity.this, "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

