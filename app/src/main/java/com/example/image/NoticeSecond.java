package com.example.image;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


public class NoticeSecond extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText t11,t12,t13,t14;
    Button submit;
    File file;
    String sp1,sp2,sp3,sp4;
    OutputStream outputStream;
    String p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25;

    //dropdown
    String[] users = { "श्री.", "श्रीमती"};

    String[] type1={"अ","ब","क","ड","ई","फ","ह","ग"};
    String[] daytype={"दिवसांच्या","महिन्याच्या","तासांच्या"};

    String[] types={"आर सी सी फुटिंग (जोते बांधकाम)","आर सी सी बांधकाम (तळमजला)","आर सी सी बांधकाम पहिला मजला (वाढीव बांधकाम)",
            "आर सी सी बांधकाम पहिला मजला व दुसरा मजला (वाढीव बांधकाम)","आर सी सी बांधकाम दुसरा मजला (वाढीव बांधकाम)",
            "आर सी सी बांधकाम दुसरा मजला व तिसरा मजला (वाढीव बांधकाम)","आर सी सी बांधकाम तिसरा मजला (वाढीव बांधकाम)",
            "आर सी सी बांधकाम तिसरा मजला व चौथा मजला (वाढीव बांधकाम)","साधे वीटबांधकाम व पत्रा ",
            "आर सी सी बांधकाम (तळमजला व पहिला मजला)"};

    //dropdownend

    //camera
    private static int IMG_RESULT = 1;
    String ImageDecode;
    ImageView imageViewLoad,imageViewLoad1,imageViewLoad2,imageViewLoad3;
    Button LoadImage,LoadImage1,LoadImage2,LoadImage3;
    Intent intent;
    String[] FILE;
    String cameras1 ="";
    String cameras2 ="";
    String cameras3 ="";
    String cameras4 ="";
    private final int SELECT_PHOTO1 = 1;
    private final int SELECT_PHOTO2 = 2;
    private final int SELECT_PHOTO3 = 3;
    private final int SELECT_PHOTO4 = 4;

    //image save
    private static final int PERMISSION_REQUEST_CODE = 100;
    Button save1;
    Button capture1,capture2,capture3,capture4;
    Bitmap bitmap;


    ImageView imageView,imageView2,imageView3,imageView4;
    //image save end
    EditText t5;

    //cameraend
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_second);

        t5 = (EditText) findViewById(R.id.t5);

        //image

        imageView = (ImageView) findViewById(R.id.img1);
        imageView2 = (ImageView) findViewById(R.id.img2);
        imageView3 = (ImageView) findViewById(R.id.img3);
        imageView4 = (ImageView) findViewById(R.id.img4);

        capture1 = (Button) findViewById(R.id.capture1);

        capture2 = (Button) findViewById(R.id.capture2);

        capture3 = (Button) findViewById(R.id.capture3);

        capture4 = (Button) findViewById(R.id.capture4);


        capture1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cameras1="cam1";

                Intent cameraIntent=new Intent();
                cameraIntent.setType("image/*");
                cameraIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(cameraIntent,"Select Picture"), SELECT_PHOTO1);

            }
        });

        capture2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameras2="cam2";

                Intent cameraIntent=new Intent();
                cameraIntent.setType("image/*");
                cameraIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(cameraIntent,"Select Picture"), SELECT_PHOTO2);

            }
        });


        capture3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameras3="cam3";

                Intent cameraIntent=new Intent();
                cameraIntent.setType("image/*");
                cameraIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(cameraIntent,"Select Picture"), SELECT_PHOTO3);

            }
        });

        capture4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameras4="cam4";

                Intent cameraIntent=new Intent();
                cameraIntent.setType("image/*");
                cameraIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(cameraIntent,"Select Picture"), SELECT_PHOTO4);

            }
        });


        //submitt end button
        submit = (Button) findViewById(R.id.Submit);
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent Fir   = new Intent(NoticeSecond.this,NoticePanel.class);
                startActivity(Fir);
            }
        });
        ///
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText t1 = (EditText) findViewById(R.id.t1);
                p1 = t1.getText().toString();

                EditText t3 = (EditText) findViewById(R.id.t3);
                p3 = t3.getText().toString();

                 p4 = sp1;


                p5 = t5.getText().toString();

                EditText t6 = (EditText) findViewById(R.id.t6);
                p6 = t6.getText().toString();


                EditText t7 = (EditText) findViewById(R.id.t7);
                 p7 = t7.getText().toString();

                EditText t8 = (EditText) findViewById(R.id.t8);
                p8 = t8.getText().toString();

                EditText t9 = (EditText) findViewById(R.id.t9);
                 p9 = t9.getText().toString();

                EditText t10 = (EditText) findViewById(R.id.t10);
                 p10 = t10.getText().toString();

                EditText t11 = (EditText) findViewById(R.id.t11);
                p11 = t11.getText().toString();

                EditText t12 = (EditText) findViewById(R.id.t12);
                p12 = t12.getText().toString();

                EditText t13 = (EditText) findViewById(R.id.t13);
                p13 = t13.getText().toString();

                EditText t14 = (EditText) findViewById(R.id.t14);
                p14 = t14.getText().toString();


                EditText t15 = (EditText) findViewById(R.id.t15);
                p15 = t15.getText().toString();

                EditText t16 = (EditText) findViewById(R.id.t16);
                p16 = t16.getText().toString();

                EditText t17 = (EditText) findViewById(R.id.t17);
                p17 = t17.getText().toString();

                EditText t18 = (EditText) findViewById(R.id.t18);
                p18 = t18.getText().toString();

                EditText t19 = (EditText) findViewById(R.id.t19);
                 p19 = t19.getText().toString();

                EditText t20 = (EditText) findViewById(R.id.t20);
                 p20 = t20.getText().toString();

                p21 = sp2;

                EditText t22 = (EditText) findViewById(R.id.t22);
                p22 = t22.getText().toString();

                 p23 = sp3;

                p25 = sp4;


                EditText d = (EditText) findViewById(R.id.days1);
               p24 = d.getText().toString();
                // Toast.makeText(NoticeOne.this,p1+p2+p3+p4+p5+p8,Toast.LENGTH_SHORT).show();

                /*
                try {

                    ContentValues values = new ContentValues();
                    String folder = "/" + "PCM_APP" + "/" + p5 + "/";
                    String filename = "कलम_५३_" + p5;
                    values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);       //file name
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "application/msword");        //file extension, will automatically add to file
                    values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + folder);     //end "/" is not mandatory

                    Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write(("\t\t\t\t\t\t      पिंपरी चिंचवड महानगरपालिका\n\t\t\t\t" +
                            "\t\t      पिंपरी पुणे – " + p22 + "\n\t\t\t\t" +
                            "\t\t      बांधकाम परवानगी  व अनधिकृत \n\t\t\t\t" +
                            "\t\t      बांधकाम नियंत्रण विभाग \n\t\t\t\t" +
                            "\t\t     " + p1 + " \n\t\t\t\t" +
                            "\t\t      दिनांक -" + p3 +
                            "\n\n\t\t\t\t\t\tपरिशिष्ट-६" +
                            "\n\t\tमहाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ कलम ५३ अन्वये नोटीस" +
                            "\n\nप्रति," +
                            "\n\tमालक / विकसक / ऑक्युपायर :-" +
                            "\n\t" + p4 + " -" + p5 + "" +
                            "\n\tपत्ता :- " + p6 + " \n" +
                            "\n        ज्या अर्थी खाली सही करणा-यास महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ " +
                            "चे कलम ५३ अन्वये कारवाई करणेचे अधिकार महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ अन्वये प्रदान केलेले आहेत.\n" +
                            "     आणि ज्या अर्थी माझे असे निदर्शनास आले आहे की तुम्ही खालीलप्रमाणे अनधिकृत/विनापरवाना बांधकाम/विकास केला आहे. " +
                            "त्याअर्थी या नोटीसद्वारे सदरचे तात्पुरते स्वरुपाचे बांधकाम ही नोटीस मिळालेपासून " + p24 + " " + p23 + " आत हलविण्याचा / काढून टाकणेचा आदेश देणेत येत आहे. " +
                            "तसेच सदरच्या बांधकामाचा/जमिनीचा अनधिकृत वापर तात्काळ थांबविणेचा आदेश देणेत येत आहे. \n" +
                            "     या नोटीशीप्रमाणे तुम्ही अनधिकृत बांधकाम/विकास काढून टाकले नाही तर सदरचे बांधकाम/विकास प्राप्त अधिकाराचा वापर करून तुमचे जबाबदारीवर व" +
                            " खर्चाने काढून टाकणेत येवून येणारा खर्च तुमचेकडून वसूल केला जाईल.  \n\n" +
                            "   सदरच्या अनधिकृत/अनियमित बांधकाम/विकास याची माहिती पुढील प्रमाणे-\n\n" +
                            "   १) गाव    -  " + p7 + "\n " +
                            "   २) ठिकाण -  " + p8 + " \n" +
                            "   ३) स.नं.  -  " + p9 + "\n" +
                            "   ४) अंदाजे क्षेत्र -  " + p10 + "\n" +
                            "   अंदाजे मोजमाप - " + p11 + " मी. X " + p12 + " मी. X " + p13 + " मजले = " + p14 + " चौ.मी.\n" +
                            "   ५)  अनधिकृत बांधकामाची चतु:सिमा :-\n" +
                            "\t पूर्वेस     –   " + p15 + "\n" +
                            "\t पश्चिमेस   –   " + p16 + "\n" +
                            "\t दक्षिणेस   –   " + p17 + "\n" +
                            "\t उत्तरेस    –   " + p18 + "\n\n" +
                            "दिनांक  -" + p19 +
                            "\nठिकाण - " + p20 +
                            "\n\n\n\n\t\t\t\t\t\t         पदनिर्देशित अधिकारी तथा \n" +
                            "\t\t\t\t\t             कार्यकारी अभियंता ( ‘" + p21 + " ’ क्षेत्रिय कार्यालय ) \n" +
                            "\t\t\t\t\t          बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग\n" +
                            "\t\t\t\t\t              पिंपरी चिंचवड महानगरपालिका,\n" +
                            "  \t\t\t\t\t                  पिंपरी, पुणे– " + p22 + "" +
                            "\n\nटीप:- याबाबतीतील खटल्यामध्ये ३ वर्ष कारावासाची शिक्षा आणि रक्कम रु. ५,०००/- दंड " +
                            "अथवा दोन्हीही व अनियमित बांधकाम काढून टाकण्याच्या विलंबा पोटी प्रति दिन रक्कम रु. १००/- याप्रमाणे शिक्षा होऊ शकतात. ").getBytes());

                    outputStream.close();

                    Toast.makeText(NoticeSecond.this, "File created successfully", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(NoticeSecond.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }






                ///camera start
                if(cameras1.equals("cam1"))
                {
                    //Drawable drawable = getResources().getDrawable(R.drawable.sam);
                    Drawable drawable=imageView.getDrawable();

                    bitmap = ((BitmapDrawable)drawable).getBitmap();

                    String state = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state)) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (checkPermission()) {
                                String path = Environment.getExternalStorageDirectory().toString();
                                Random random = new Random();
                                int x = random.nextInt(6000);
                                File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                if (!file.exists()) {
                                    Log.d("path", file.toString());
                                    try {
                                        FileOutputStream fos = new FileOutputStream(file);
                                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                        fos.flush();
                                        fos.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                requestPermission(); // Code for permission
                            }
                        } else {
                            String path = Environment.getExternalStorageDirectory().toString();
                            Random random = new Random();
                            int x = random.nextInt(6000);
                            File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                            if (!file.exists()) {
                                Log.d("path", file.toString());
                                FileOutputStream fos = null;
                                try {
                                    fos = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                    fos.flush();
                                    fos.close();
                                } catch (java.io.IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }

                //cam2
                if(cameras2.equals("cam2"))
                {
                    Drawable drawable1=imageView2.getDrawable();

                    bitmap = ((BitmapDrawable)drawable1).getBitmap();

                    String state1 = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state1)) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (checkPermission()) {
                                String path = Environment.getExternalStorageDirectory().toString();
                                Random random = new Random();
                                int x = random.nextInt(6000);
                                File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                if (!file.exists()) {
                                    Log.d("path", file.toString());
                                    try {
                                        FileOutputStream fos = new FileOutputStream(file);
                                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                        fos.flush();
                                        fos.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                requestPermission(); // Code for permission
                            }
                        } else {
                            String path = Environment.getExternalStorageDirectory().toString();
                            Random random = new Random();
                            int x = random.nextInt(6000);
                            File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                            if (!file.exists()) {
                                Log.d("path", file.toString());
                                FileOutputStream fos = null;
                                try {
                                    fos = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                    fos.flush();
                                    fos.close();
                                } catch (java.io.IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    //

                }
                //Drawable drawable = getResources().getDrawable(R.drawable.sam);

                if(cameras3.equals("cam3"))
                {

                    Drawable drawable2=imageView3.getDrawable();

                    bitmap = ((BitmapDrawable)drawable2).getBitmap();

                    String state2 = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state2)) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (checkPermission()) {
                                String path = Environment.getExternalStorageDirectory().toString();
                                Random random = new Random();
                                int x = random.nextInt(6000);
                                File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                if (!file.exists()) {
                                    Log.d("path", file.toString());
                                    try {
                                        FileOutputStream fos = new FileOutputStream(file);
                                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                        fos.flush();
                                        fos.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                requestPermission(); // Code for permission
                            }
                        } else {
                            String path = Environment.getExternalStorageDirectory().toString();
                            Random random = new Random();
                            int x = random.nextInt(6000);
                            File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                            if (!file.exists()) {
                                Log.d("path", file.toString());
                                FileOutputStream fos = null;
                                try {
                                    fos = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                    fos.flush();
                                    fos.close();
                                } catch (java.io.IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }

                }
                //Drawable drawable = getResources().getDrawable(R.drawable.sam);

                ///
                if(cameras4.equals("cam4")) {
                    Drawable drawable3 = imageView4.getDrawable();

                    bitmap = ((BitmapDrawable) drawable3).getBitmap();

                    String state3 = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state3)) {
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (checkPermission()) {
                                String path = Environment.getExternalStorageDirectory().toString();
                                Random random = new Random();
                                int x = random.nextInt(6000);
                                File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                if (!file.exists()) {
                                    Log.d("path", file.toString());
                                    try {
                                        FileOutputStream fos = new FileOutputStream(file);
                                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                        fos.flush();
                                        fos.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                requestPermission(); // Code for permission
                            }
                        } else {
                            String path = Environment.getExternalStorageDirectory().toString();
                            Random random = new Random();
                            int x = random.nextInt(6000);
                            File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                            if (!file.exists()) {
                                Log.d("path", file.toString());
                                FileOutputStream fos = null;
                                try {
                                    fos = new FileOutputStream(file);
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                    fos.flush();
                                    fos.close();
                                } catch (java.io.IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeSecond.this);
                alertDialogBuilder.setMessage("Do You Want To Fill FIR");

                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent Fir = new Intent(NoticeSecond.this, NoticeFive.class);

                                Fir.putExtra("name", p5);
                                Fir.putExtra("address", p6);

                                Fir.putExtra("typeB", p25);

                                Fir.putExtra("m1", p11);
                                Fir.putExtra("m2", p12);
                                Fir.putExtra("m3", p13);
                                Fir.putExtra("cal", p14);

                                Fir.putExtra("c1", p15);
                                Fir.putExtra("c2", p16);
                                Fir.putExtra("c3", p17);
                                Fir.putExtra("c4", p18);

                                Fir.putExtra("D1", p3);

                                startActivity(Fir);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent Fir   = new Intent(NoticeSecond.this,NoticePanel.class);
                        startActivity(Fir);
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                */

                try {
                    //Word save path
                    Uri path = Uri.parse("android.resource://com.example.image/" + R.drawable.pcmc);
                    //end
                    DocumentContainer.InputstreamFourhoursPhotos3 = getContentResolver().openInputStream(path);
                    generateReport();

                } catch (IOException e) {
                    Toast.makeText(NoticeSecond.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }

            }
        });

//submitt end button end

        //spinnerdropdown

        Spinner spin = (Spinner) findViewById(R.id.t4);
        Spinner spin2 = (Spinner) findViewById(R.id.t21);
        Spinner spin3 = (Spinner) findViewById(R.id.days2);
        Spinner spin4 = (Spinner) findViewById(R.id.typo);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daytype);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter4);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(adapter5);


        spin.setOnItemSelectedListener(NoticeSecond.this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);
        spin4.setOnItemSelectedListener(this);


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                sp1 = users[position];

                // Toast.makeText(getApplicationContext(), "Selected User: "+users[position] , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                sp2 = type1[position];
                //Toast.makeText(getApplicationContext(), "Selected types: "+types[position] , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                sp3 = daytype[position];
                //Toast.makeText(getApplicationContext(), "Selected types: "+types[position] , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });


        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                sp4 = types[position];
                //Toast.makeText(getApplicationContext(), "Selected types: "+types[position] , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //spinnerenddropdown

//calculation
        t11 = (EditText) findViewById(R.id.t11);
        t12 = (EditText) findViewById(R.id.t12);
        t13 = (EditText) findViewById(R.id.t13);
        t14 = (EditText) findViewById(R.id.t14);

        t14.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                try {
                    if (hasFocus) {
                        double f1=Double.parseDouble(t11.getText().toString());
                        double f2=Double.parseDouble(t12.getText().toString());
                        double f3=Double.parseDouble(t13.getText().toString());
                        double resp =Math.ceil(f1*f2*f3) ;

                        /// int v1 = Integer.parseInt(t10.getText().toString());
                        //// int v2 = Integer.parseInt(t11.getText().toString());
                        // int v3 = Integer.parseInt(t12.getText().toString());
                        // int res = v1 * v2 * v3;
                        String result = String.valueOf(resp);

                        t14.setText(result);
                        t14.setEnabled(false);
                    }
                } catch (Exception e) {
                    Toast.makeText(NoticeSecond.this, "Please try again", Toast.LENGTH_LONG).show();
                }
            }
        });
        //calculationend

    }
    //camera start
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(NoticeSecond.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(NoticeSecond.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(NoticeSecond.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(NoticeSecond.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




        if(requestCode==1)
        {

            Uri selectedImageUri=data.getData();
            imageView.setImageURI(selectedImageUri);

        }


        if(requestCode==2)
        {

            Uri selectedImageUri=data.getData();
            imageView2.setImageURI(selectedImageUri);

        }


        if(requestCode==3)
        {

            Uri selectedImageUri=data.getData();
            imageView3.setImageURI(selectedImageUri);

        }


        if(requestCode==4)
        {

            Uri selectedImageUri=data.getData();
            imageView4.setImageURI(selectedImageUri);

        }


    }

    //cameraend



    //spinner method
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
//spinner method end
private void generateReport()
{


    p5 = t5.getText().toString();

    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            if (DocumentContainer.openDocument2(NoticeSecond.this,getLayoutInflater(),DocumentContainer.InputstreamFourhoursPhotos3,p5,
                    p1,p2,p3,p4,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25)){//create doc in file manager and open document first
                if (DocumentContainer.InputstreamFourhoursPhotos3 != null){

                }


                DocumentContainer.saveReportExternally(NoticeSecond.this,getLayoutInflater());//save doc file in the file manager

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(NoticeSecond.this,"Report Genrated Successfully",Toast.LENGTH_LONG).show();

                        ///camera start
                        if(cameras1.equals("cam1"))
                        {
                            //Drawable drawable = getResources().getDrawable(R.drawable.sam);
                            Drawable drawable=imageView.getDrawable();

                            bitmap = ((BitmapDrawable)drawable).getBitmap();

                            String state = Environment.getExternalStorageState();
                            if (Environment.MEDIA_MOUNTED.equals(state)) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    if (checkPermission()) {
                                        String path = Environment.getExternalStorageDirectory().toString();
                                        Random random = new Random();
                                        int x = random.nextInt(6000);
                                        File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                        if (!file.exists()) {
                                            Log.d("path", file.toString());
                                            try {
                                                FileOutputStream fos = new FileOutputStream(file);
                                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                                fos.flush();
                                                fos.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } else {
                                        requestPermission(); // Code for permission
                                    }
                                } else {
                                    String path = Environment.getExternalStorageDirectory().toString();
                                    Random random = new Random();
                                    int x = random.nextInt(6000);
                                    File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                    if (!file.exists()) {
                                        Log.d("path", file.toString());
                                        FileOutputStream fos = null;
                                        try {
                                            fos = new FileOutputStream(file);
                                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                            fos.flush();
                                            fos.close();
                                        } catch (java.io.IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }

                        }

                        //cam2
                        if(cameras2.equals("cam2"))
                        {
                            Drawable drawable1=imageView2.getDrawable();

                            bitmap = ((BitmapDrawable)drawable1).getBitmap();

                            String state1 = Environment.getExternalStorageState();
                            if (Environment.MEDIA_MOUNTED.equals(state1)) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    if (checkPermission()) {
                                        String path = Environment.getExternalStorageDirectory().toString();
                                        Random random = new Random();
                                        int x = random.nextInt(6000);
                                        File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                        if (!file.exists()) {
                                            Log.d("path", file.toString());
                                            try {
                                                FileOutputStream fos = new FileOutputStream(file);
                                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                                fos.flush();
                                                fos.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } else {
                                        requestPermission(); // Code for permission
                                    }
                                } else {
                                    String path = Environment.getExternalStorageDirectory().toString();
                                    Random random = new Random();
                                    int x = random.nextInt(6000);
                                    File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                    if (!file.exists()) {
                                        Log.d("path", file.toString());
                                        FileOutputStream fos = null;
                                        try {
                                            fos = new FileOutputStream(file);
                                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                            fos.flush();
                                            fos.close();
                                        } catch (java.io.IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            //

                        }
                        //Drawable drawable = getResources().getDrawable(R.drawable.sam);

                        if(cameras3.equals("cam3"))
                        {

                            Drawable drawable2=imageView3.getDrawable();

                            bitmap = ((BitmapDrawable)drawable2).getBitmap();

                            String state2 = Environment.getExternalStorageState();
                            if (Environment.MEDIA_MOUNTED.equals(state2)) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    if (checkPermission()) {
                                        String path = Environment.getExternalStorageDirectory().toString();
                                        Random random = new Random();
                                        int x = random.nextInt(6000);
                                        File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                        if (!file.exists()) {
                                            Log.d("path", file.toString());
                                            try {
                                                FileOutputStream fos = new FileOutputStream(file);
                                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                                fos.flush();
                                                fos.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } else {
                                        requestPermission(); // Code for permission
                                    }
                                } else {
                                    String path = Environment.getExternalStorageDirectory().toString();
                                    Random random = new Random();
                                    int x = random.nextInt(6000);
                                    File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                    if (!file.exists()) {
                                        Log.d("path", file.toString());
                                        FileOutputStream fos = null;
                                        try {
                                            fos = new FileOutputStream(file);
                                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                            fos.flush();
                                            fos.close();
                                        } catch (java.io.IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }

                        }
                        //Drawable drawable = getResources().getDrawable(R.drawable.sam);

                        ///
                        if(cameras4.equals("cam4")) {
                            Drawable drawable3 = imageView4.getDrawable();

                            bitmap = ((BitmapDrawable) drawable3).getBitmap();

                            String state3 = Environment.getExternalStorageState();
                            if (Environment.MEDIA_MOUNTED.equals(state3)) {
                                if (Build.VERSION.SDK_INT >= 23) {
                                    if (checkPermission()) {
                                        String path = Environment.getExternalStorageDirectory().toString();
                                        Random random = new Random();
                                        int x = random.nextInt(6000);
                                        File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                        if (!file.exists()) {
                                            Log.d("path", file.toString());
                                            try {
                                                FileOutputStream fos = new FileOutputStream(file);
                                                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                                fos.flush();
                                                fos.close();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } else {
                                        requestPermission(); // Code for permission
                                    }
                                } else {
                                    String path = Environment.getExternalStorageDirectory().toString();
                                    Random random = new Random();
                                    int x = random.nextInt(6000);
                                    File file = new File(path, "/documents/PCM_APP/"+p5+"/"+p5+x+".jpg");
                                    if (!file.exists()) {
                                        Log.d("path", file.toString());
                                        FileOutputStream fos = null;
                                        try {
                                            fos = new FileOutputStream(file);
                                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                                            fos.flush();
                                            fos.close();
                                        } catch (java.io.IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }


                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeSecond.this);
                        alertDialogBuilder.setMessage("Do You Want To Fill FIR");

                        alertDialogBuilder.setPositiveButton("yes",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface arg0, int arg1) {
                                        Intent Fir = new Intent(NoticeSecond.this, NoticeFive.class);

                                        Fir.putExtra("name", p5);
                                        Fir.putExtra("address", p6);

                                        Fir.putExtra("typeB", p25);

                                        Fir.putExtra("m1", p11);
                                        Fir.putExtra("m2", p12);
                                        Fir.putExtra("m3", p13);
                                        Fir.putExtra("cal", p14);

                                        Fir.putExtra("c1", p15);
                                        Fir.putExtra("c2", p16);
                                        Fir.putExtra("c3", p17);
                                        Fir.putExtra("c4", p18);

                                        Fir.putExtra("D1", p3);

                                        Fir.putExtra("D1",p3);
                                        Fir.putExtra("bipi",p1);
                                        Fir.putExtra("pin",p22);

                                        startActivity(Fir);
                                    }
                                });

                        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Intent Fir   = new Intent(NoticeSecond.this,NoticePanel.class);
                                startActivity(Fir);
                            }
                        });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                        //



                    }
                });
            }
        }
    });

}


}

