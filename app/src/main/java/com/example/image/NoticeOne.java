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
import java.util.Random;


public class NoticeOne extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText t10,t11,t12,t13;
    Button submit;
    String sp1,sp2,sp3,sp4;

    //dropdown
    String[] users = { "श्री.", "श्रीमती"};

    String[] types={"आर सी सी फुटिंग (जोते बांधकाम)","आर सी सी बांधकाम (तळमजला)","आर सी सी बांधकाम पहिला मजला (वाढीव बांधकाम)",
            "आर सी सी बांधकाम पहिला मजला व दुसरा मजला (वाढीव बांधकाम)","आर सी सी बांधकाम दुसरा मजला (वाढीव बांधकाम)",
            "आर सी सी बांधकाम दुसरा मजला व तिसरा मजला (वाढीव बांधकाम)","आर सी सी बांधकाम तिसरा मजला (वाढीव बांधकाम)",
            "आर सी सी बांधकाम तिसरा मजला व चौथा मजला (वाढीव बांधकाम)","साधे वीटबांधकाम व पत्रा ",
            "आर सी सी बांधकाम (तळमजला व पहिला मजला)"};

    String[] type1={"अ","ब","क","ड","ई","फ","ह","ग"};
    String[] daytype={"दिवसांच्या","महिन्याच्या","तासांच्या"};

    //dropdownend

    //camera
    private static int IMG_RESULT = 1;
    String ImageDecode;

    String cameras1 ="";
    String cameras2 ="";
    String cameras3 ="";
    String cameras4 ="";
    private final int SELECT_PHOTO1 = 1;
    private final int SELECT_PHOTO2 = 2;
    private final int SELECT_PHOTO3 = 3;
    private final int SELECT_PHOTO4 = 4;

    String p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25;
    EditText t21;


    //image save
    private static final int PERMISSION_REQUEST_CODE = 100;
    Button save1;
    Button capture1,capture2,capture3,capture4;
    Bitmap bitmap;


    ImageView imageView,imageView2,imageView3,imageView4;
    //image save end


    //cameraend
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_one);

        t21= findViewById(R.id.t21);

        //image

        imageView = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        imageView3 = findViewById(R.id.img3);
        imageView4 = findViewById(R.id.img4);

        capture1 = findViewById(R.id.capture1);
        capture2 = findViewById(R.id.capture2);
        capture3 = findViewById(R.id.capture3);
        capture4 = findViewById(R.id.capture4);


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


        //image

        //submitt end button
        submit=(Button) findViewById(R.id.Submit);
        Button back=(Button) findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent Fir   = new Intent(NoticeOne.this,NoticePanel.class);
                startActivity(Fir);
            }
        });
        ///
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    EditText t1=(EditText) findViewById(R.id.t1);
                    p1=t1.getText().toString();

                    EditText t2=(EditText) findViewById(R.id.t2);
                    p2=t2.getText().toString();

                     p3=sp1;

                    EditText t4=(EditText) findViewById(R.id.t4);
                    p4=t4.getText().toString();

                    EditText t5=(EditText) findViewById(R.id.t5);
                     p5=t5.getText().toString();

                    EditText t6=(EditText) findViewById(R.id.t6);
                    p6=t6.getText().toString();

                    EditText t7=(EditText) findViewById(R.id.t7);
                     p7=t7.getText().toString();

                    EditText t8=(EditText) findViewById(R.id.t8);
                     p8=t8.getText().toString();

                    EditText t9=(EditText) findViewById(R.id.t9);
                    p9=t9.getText().toString();

                    EditText t10=(EditText) findViewById(R.id.t10);
                    p10=t10.getText().toString();

                    EditText t11=(EditText) findViewById(R.id.t11);
                    p11=t11.getText().toString();

                    EditText t12=(EditText) findViewById(R.id.t12);
                    p12=t12.getText().toString();

                    EditText t13=(EditText) findViewById(R.id.t13);
                    p13=t13.getText().toString();

                    p14=sp2;

                    EditText t15=(EditText) findViewById(R.id.t15);
                    p15=t15.getText().toString();

                    EditText t16=(EditText) findViewById(R.id.t16);
                    p16=t16.getText().toString();

                    EditText t17=(EditText) findViewById(R.id.t17);
                    p17=t17.getText().toString();

                    EditText t18=(EditText) findViewById(R.id.t18);
                    p18=t18.getText().toString();

                    p19=sp3;

                    EditText t20=(EditText) findViewById(R.id.t20);
                    p20=t20.getText().toString();



                    p21=t21.getText().toString();



                    p22=sp4;

                    EditText t23=(EditText) findViewById(R.id.days1);
                    p23=t23.getText().toString();

                    /*
                   // Toast.makeText(NoticeOne.this,p1+p2+p3+p4+p5+p8,Toast.LENGTH_SHORT).show();
                    try {

                        ContentValues values = new ContentValues();
                        String filename="सूचना478_"+p21;
                        String folder="/"+"PCM_APP"+"/"+p21+"/";
                        values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);       //file name
                        values.put(MediaStore.MediaColumns.MIME_TYPE, "application/msword");        //file extension, will automatically add to file
                        values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + folder);     //end "/" is not mandatory

                        Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                        OutputStream outputStream = getContentResolver().openOutputStream(uri);

                        String a="sameet";

                        outputStream.write(("\t\t\t\t\t\t\t पिंपरी चिंचवड महानगरपालिका\n\t\t\t\t" +
                                "\t\t\t पिंपरी पुणे – "+p20+"\n\t\t\t\t" +
                                "\t\t\t बांधकाम परवानगी  व अनधिकृत \n\t\t\t\t" +
                                "\t\t\t बांधकाम नियंत्रण विभाग \n\t\t\t\t" +
                                "\t\t\t "+p1+" \n\t\t\t\t" +
                                "\t\t\t दिनांक -"+ p2 +
                                "\n\n\t\t\t\t\t\tसूचना" +
                                "\n\nप्रति,"+
                                "\n\tमालक / विकसक / ऑक्युपायर :-" +
                                "\n\t"+p3+" -"+p21+"" +
                                "\n\tपत्ता :- "+p4+" \n" +
                                "       \n   महाराष्ट्र महानगरपालिका अधिनियम चे कलम ४७८(१), कलम ४३३(क) अन्वये सूचना देण्यात येते की  " +
                                "तुम्ही पिंपरी चिंचवड महानगरपालिकेची बांधकाम परवानगी न घेता बिगर परवाना अनधिकृत बांधकाम केलेचे  " +
                                "निदर्शनास आले आहे. सदर बिगर परवाना अनधिकृत बांधकामाची माहिती खालीलप्रमाणे :-  \n\n" +
                                "\nगाव  –  "+p5+"          मोजे  –  "+p6+"       ता. –  "+p7+"        जि. पुणे\n" +
                                "ठिकाण  –  "+p8+" \n" +
                                "स.नं. / सि.टी.स.नं. / गट नं. – "+p9+"\n" +
                                "बांधकामाचे मोजमाप – अंदाजे "+p10+" मी. X "+p11+" मी. X "+p12+" मजले = "+p13+" चौ.मी.\n" +
                                "बांधकामाचा प्रकार :-  "+p14+"\n" +
                                "चतु:सिमा –\n" +
                                "\tपूर्वेस     –   "+p15+"\n" +
                                "\tपश्चिमेस   –   "+p16+"\n" +
                                "\tदक्षिणेस   –   "+p17+"\n" +
                                "\tउत्तरेस    –   "+p18+"\n\n" +
                                "    आपण केलेले सर्व बांधकाम अनधिकृत आहे. सदरचे वरीलप्रमाणे केलेले अनधिकृत बांधकाम तुम्ही ही सूचना पोहोचविल्यापासून "+p23+" "+p22+" " +
                                "आत काढून टाकावे. वेळ प्रसंग पडल्यास प्रत्यक्ष कारवाईच्या वेळी सदरच्या बांधकामाच्या जागेवर भरतील ती व असतील ती स्थितीप्रमाणे, त्यासहचे सर्व बांधकाम याप्रमाणे" +
                                " तुम्ही बिगर परवाना बांधकाम काढून टाकण्याची व्यवस्था न केल्यास ते बांधकाम आम्ही काढून टाकू, त्याबाबत होणारा खर्च तुमच्याकडून वसूल करण्यात येईल. तसेच सदरच्या " +
                                "सूचनेबाबत आपल्याकडील कोणताही खुलासा/ पत्र ग्राहय धरता येणार नाही.\n" +
                                "\t  सदरचे अनधिकृत/बिगर परवाना बांधकामाबाबत महाराष्ट्र महानगरपालिका अधिनियम चे कलम २६१, २६४, २६७ आणि ४७८ मधील तरतुदीनुसार मा. आयुक्त यांचे आदेश क्रमांक " +
                                "अति/३/कावि/१००/२०१२ दि.१६/६/२०१२अन्वये पदनिर्देशित" +
                                " अधिकारी म्हणुन कारवाई करण्याचे आधिकारी आम्हाला आहेत याची नोंद घ्यावी.\n\n\n\n" +
                                "\t\t\t\t\t\t               पदनिर्देशित अधिकारी तथा \n" +
                                "\t\t\t\t\t\t         कार्यकारी अभियंता ( ‘"+p19+" ’ क्षेत्रिय कार्यालय ) \n" +
                                "\t\t\t\t           बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग\n" +
                                "  \t\t\t\t\t   पिंपरी चिंचवड महानगरपालिका, पिंपरी, पुणे– "+p20+"").getBytes());

                        outputStream.close();

                        Toast.makeText(NoticeOne.this, "File created successfully", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        Toast.makeText(NoticeOne.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                    }

                    */

                    try {
                        //Word save path
                        Uri path = Uri.parse("android.resource://com.example.image/" + R.drawable.pcmc);
                        //end
                        DocumentContainer.InputstreamFourhoursPhotos3 = getContentResolver().openInputStream(path);
                        generateReport();

                    } catch (IOException e) {
                        Toast.makeText(NoticeOne.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                    }








                }
            });

//submitt end button end

        //spinnerdropdown

        Spinner spin = (Spinner) findViewById(R.id.t3);
        Spinner spin2=(Spinner) findViewById(R.id.t14);
        Spinner spin3=(Spinner)findViewById(R.id.t19);
        Spinner spin4=(Spinner)findViewById(R.id.days2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, types);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, type1);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin3.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daytype);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin4.setAdapter(adapter4);


        spin.setOnItemSelectedListener(NoticeOne.this);
        spin2.setOnItemSelectedListener(this);
        spin3.setOnItemSelectedListener(this);
        spin4.setOnItemSelectedListener(this);


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                sp1=users[position];

               // Toast.makeText(getApplicationContext(), "Selected User: "+users[position] , Toast.LENGTH_SHORT).show();
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

                sp4=daytype[position];

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

                sp2=types[position];
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
                sp3=type1[position];
                //Toast.makeText(getApplicationContext(), "Selected types: "+type1[position] , Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

    //spinnerenddropdown

//calculation
        t10=(EditText)findViewById(R.id.t10);
        t11=(EditText)findViewById(R.id.t11);
        t12=(EditText)findViewById(R.id.t12);
        t13=(EditText)findViewById(R.id.t13);

         t13.setOnFocusChangeListener(new View.OnFocusChangeListener() {
             @Override
             public void onFocusChange(View v, boolean hasFocus) {

                 try{
                     if(hasFocus) {
                         double f1=Double.parseDouble(t10.getText().toString());
                         double f2=Double.parseDouble(t11.getText().toString());
                         double f3=Double.parseDouble(t12.getText().toString());
                         double resp =f1*f2*f3;

                        /// int v1 = Integer.parseInt(t10.getText().toString());
                        //// int v2 = Integer.parseInt(t11.getText().toString());
                        // int v3 = Integer.parseInt(t12.getText().toString());
                        // int res = v1 * v2 * v3;
                         String result = String.valueOf(resp);

                         t13.setText(result);
                         t13.setEnabled(false);
                     }
                 }catch (Exception e){
                     Toast.makeText(NoticeOne.this, "Please try again", Toast.LENGTH_LONG).show();
                 }
             }
         });
         //calculationend


    }


    //camera start
    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(NoticeOne.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(NoticeOne.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(NoticeOne.this, "Write External Storage permission allows us to save files. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(NoticeOne.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
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
    private void generateReport()
    {


        p21=t21.getText().toString();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (DocumentContainer.openDocument(NoticeOne.this,getLayoutInflater(),DocumentContainer.InputstreamFourhoursPhotos3,p21,
                        p1,p2,p3,p4, p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p22,p23)){//create doc in file manager and open document first
                    if (DocumentContainer.InputstreamFourhoursPhotos3 != null){

                    }


                    DocumentContainer.saveReportExternally(NoticeOne.this,getLayoutInflater());//save doc file in the file manager

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(NoticeOne.this,"Report Genrated Successfully",Toast.LENGTH_LONG).show();


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

                                            File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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
                                        File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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

                                            File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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
                                        File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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

                                            File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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
                                        File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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
                            if(cameras4.equals("cam4"))
                            {
                                Drawable drawable3=imageView4.getDrawable();

                                bitmap = ((BitmapDrawable)drawable3).getBitmap();

                                String state3 = Environment.getExternalStorageState();
                                if (Environment.MEDIA_MOUNTED.equals(state3)) {
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        if (checkPermission()) {
                                            String path = Environment.getExternalStorageDirectory().toString();
                                            Random random = new Random();
                                            int x = random.nextInt(6000);

                                            File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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
                                        File file = new File(path, "/documents/PCM_APP/"+p21+"/"+p21+x+".jpg");
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
                            //end camera


                            // next activity

                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeOne.this);
                                    alertDialogBuilder.setMessage("Do You Want To Fill FIR");

                                    alertDialogBuilder.setPositiveButton("yes",
                                            new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface arg0, int arg1) {
                                                    Intent Fir   = new Intent(NoticeOne.this,NoticeFive.class);
                                                    Fir.putExtra("name",p21);
                                                    Fir.putExtra("address",p4);

                                                    Fir.putExtra("typeB",p14);

                                                    Fir.putExtra("m1",p10);
                                                    Fir.putExtra("m2",p11);
                                                    Fir.putExtra("m3",p12);
                                                    Fir.putExtra("cal",p13);

                                                    Fir.putExtra("c1",p15);
                                                    Fir.putExtra("c2",p16);
                                                    Fir.putExtra("c3",p17);
                                                    Fir.putExtra("c4",p18);


                                                    Fir.putExtra("D1",p2);
                                                    Fir.putExtra("bipi",p1);
                                                    Fir.putExtra("pin",p20);

                                                    startActivity(Fir);
                                                }
                                            });

                                    alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {


                                            finish();
                                        }
                                    });

                                    AlertDialog alertDialog = alertDialogBuilder.create();
                                    alertDialog.show();







                            //end next activity

                        }
                    });
                }
            }
        });

    }




//spinner method end
}

