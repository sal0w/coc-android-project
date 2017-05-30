package com.parse.starter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetDataCallback;
import com.parse.ParseFile;
import com.parse.ParseImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ScrollingActivity extends AppCompatActivity {

    ParseImageView scrollingImage;
    TextView dateView;
    TextView viewsView;
    TextView description;
    ParseFile ImageDownlosd;
    Bitmap bitmap;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Base base;
        base = CopyBase.getBase();

        Date createdAt = base.getCreatedAt();
        ImageDownlosd = base.getImage();
        String ad = base.getObjectId();
        String views = String.valueOf(base.getViews());
        fileName = base.getName();

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String reportDate = df.format(createdAt);

        base.increment("Views");
        base.saveInBackground();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(base.getName());
        scrollingImage = (ParseImageView) findViewById(R.id.scrollingImage);
        dateView = (TextView)findViewById(R.id.dateView);
        viewsView = (TextView)findViewById(R.id.ViewsView);
        description = (TextView)findViewById((R.id.description));

        viewsView.setText(views);
        dateView.setText(reportDate);
        description.setText(base.getDescription());

       ParseFile imagefile  = base.getImage();
        if (imagefile != null){
            scrollingImage.setParseFile(imagefile);
            scrollingImage.loadInBackground();
        }






        Toast.makeText(ScrollingActivity.this, "Clicked " + ad, Toast.LENGTH_SHORT).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                ImageDownlosd.getDataInBackground(new GetDataCallback() {


                    @Override
                    public void done(byte[] data, com.parse.ParseException e) {
                        if (e == null) {

                            bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
                            //use this bitmap as you want
                            String root = Environment.getExternalStorageDirectory().toString();
                            File myDir = new File(root + "/saved_images_COC_base");
                            myDir.mkdirs();
                            Random generator = new Random();
                            int n = 10000;
                            n = generator.nextInt(n);
                            String fname =fileName + n +".jpg";
                            File file = new File(myDir, fname);
                            if (file.exists ()) file.delete ();
                            try {
                                FileOutputStream out = new FileOutputStream(file);
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
                                out.flush();
                                out.close();

                            } catch (Exception as) {
                                as.printStackTrace();
                            }


                            Snackbar.make(view,"Download in Progress", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();

                        } else {
                            // something went wrong
                            Snackbar.make(view, "Download Failed try again", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                    }
                });





            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
