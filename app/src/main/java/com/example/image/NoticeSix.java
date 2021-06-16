package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class NoticeSix extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button submit;
    File file;
    String sp1,sp2;
    OutputStream outputStream;

    //dropdown

    String[] type1={"अ","ब","क","ड","ई","फ","ह","ग"};

    String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14,g15,g16,g17,g18,g19,g20,g21,g22,g23,g24,g25,g26,g27;
    String p1,p2,p3,p4,p5,p6,p7,p8,p9;

    String[] daytype={"दिवसांच्या","महिन्याच्या","तासांच्या"};

    EditText t2,t1;

    //dropdownend

    //cameraend
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_six);

        Intent i =getIntent();
        g12=i.getStringExtra("D1");
        t2=(EditText) findViewById(R.id.t2);
        t2.setText(g12);

        g26=i.getStringExtra("bipi");
        t1=(EditText) findViewById(R.id.t1);
        t1.setText(g26);
        g27=i.getStringExtra("pin");

        //submitt end button
        submit=(Button) findViewById(R.id.Submit);
        Button back=(Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent Fir   = new Intent(NoticeSix.this,NoticePanel.class);
                startActivity(Fir);


            }
        });
        ///
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i =getIntent();
                g1=i.getStringExtra("name");
                g2=i.getStringExtra("address");
                g3=i.getStringExtra("typeB");
                g4=i.getStringExtra("m1");
                g5=i.getStringExtra("m2");
                g6=i.getStringExtra("m3");
                g7=i.getStringExtra("cal");
                g8=i.getStringExtra("c1");
                g9=i.getStringExtra("c2");
                g10=i.getStringExtra("c3");
                g11=i.getStringExtra("c4");


                g13=i.getStringExtra("name2");
                g14=i.getStringExtra("age");
                g15=i.getStringExtra("pc");
                g16=i.getStringExtra("mbn");
                g17=i.getStringExtra("address2");
                g18=i.getStringExtra("depart");

                g19=i.getStringExtra("e1");
                g20=i.getStringExtra("e2");
                g21=i.getStringExtra("e3");
                g22=i.getStringExtra("f1");
                g23=i.getStringExtra("f2");
                g24=i.getStringExtra("f3");

                g25=i.getStringExtra("ps");



                 p1=t1.getText().toString();


                 p2=t2.getText().toString();


                EditText t3=(EditText) findViewById(R.id.t3);
                 p3=t3.getText().toString();

                EditText t4=(EditText) findViewById(R.id.t4);
                p4=t4.getText().toString();

                EditText t5=(EditText) findViewById(R.id.t5);
                 p5=t5.getText().toString();

                EditText t6=(EditText) findViewById(R.id.t6);
                 p6=t6.getText().toString();


                EditText t7=(EditText) findViewById(R.id.t7);
                p7=t7.getText().toString();


                 p8=sp1;


                 p9=sp2;

/*
                // Toast.makeText(NoticeOne.this,p1+p2+p3+p4+p5+p8,Toast.LENGTH_SHORT).show();
                try {

                    ContentValues values = new ContentValues();
                    String folder="/"+"PCM_APP"+"/"+g1+"/";
                    String filename="Evacuation_"+g1;
                    values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);       //file name
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "application/msword");        //file extension, will automatically add to file
                    values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + folder);     //end "/" is not mandatory

                    Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write(( "\t\t\t\t\t\t\t\t      पिंपरी चिंचवड महानगरपालिका\n\t\t\t\t" +
                            "\t\t\t\t      पिंपरी पुणे – "+g15+"\n\t\t\t\t" +
                            "\t\t\t\t      बांधकाम परवानगी  व अनधिकृत \n\t\t\t\t" +
                            "\t\t\t\t      बांधकाम नियंत्रण विभाग \n\t\t\t\t" +
                            "\t\t\t\t      "+p1+" \n\t\t\t\t" +
                            "\t\t\t\t      दिनांक -"+p2 +
                            "\n\n\t\t\t\t\t\tसूचना" +
                            "\n\t\tबांधकाम वापर निर्वासन बाबत सूचना ( Evacuation Notice )" +
                            "\n\nप्रति,"+
                            "\n\tमालक / विकसक / ऑक्युपायर :-\n" +
                            "\n\tश्री.-"+g1+"\n" +
                            "\n\tपत्ता :- "+g2+" \n" +
                            "\n\t\tसंदर्भ – इकडील नोटीस "+p3+" दिनांक- "+p2+"" +
                            "\n        महाराष्ट्र महानगरपालिका अधिनियम २०१२चे कलम ४७८ (१), कलम ४३३ (क) अन्वये सूचना देण्यात येते की, तुम्ही पिंपरी चिंचवड महानगरपालिकेची बांधकाम " +
                            "परवानगी  न घेता खालील नमुद बिगर परवाना/अनाधिकृत बांधकामामध्ये मालकी हक्काने/ " +
                            "अन्य अधिकाराने रहिवासी व्यावसायिक वास्तव्य/ वापर (ऑक्युपाय) करत असल्याचे निदर्शनास आले आहे. सदर बिगरपरवाना/अनाधिकृत बांधकामांची माहिती खालीलप्रमाणे.\n\n"+

                            "गाव/मौजे   -  "+p4+"/"+p5+" \t" +
                            "स.नं.-    -  "+p6+"\n " +
                            "अबांधकामाचे क्षेत्रफळ अंदाजे - "+g4+" मी. X "+g5+" मी. X "+g6+" मजले = "+g7+" चौ.मी.\n" +
                            "बांधकामाचा प्रकार – "+g3+""+
                            "चतु:सिमा :-\n" +
                            "\t पूर्वेस     –   "+g8+"\n" +
                            "\t पश्चिमेस   –   "+g9+"\n" +
                            "\t दक्षिणेस   –   "+g10+"\n" +
                            "\t उत्तरेस    –   "+g11+"\n\n" +
                            "    याबाबत आपल्यास संदर्भ क्र.१ अन्वये नोटीस देणेत आलेली आहे.त्याप्रमाणे आपण अनुपालन केलेले नाही. सबब वर नमुद अनाधिकृत बांधकाम तुम्ही ही सूचना पोहोचल्यापासून " +
                            ""+p7+" "+p8+" आत काढून टाकावे/रिकामे करावे. वेळ प्रसंग पडल्यास प्रत्यक्ष कारवाईच्या वेळी सदरच्या बांधकामाची जागेवर भरतील ती व असतील ती मोजमापे, " +
                            "त्यासहचे संपूर्ण बांधकाम याप्रमाणे तुम्ही बिगरपरवाना बांधकाम काढून टाकण्याची/ रिकामी करण्याची व्यवस्था न" +
                            " केल्यास ते बांधकाम आम्ही काढून टाकू. त्याबाबत होणारा खर्च तुमच्याकडून वसूल करण्यात येईल. तसेच सदरच्या सुचनेवरती " +
                            "आपल्याकडील कोणताही खुलासा / पत्र ग्राह्य धरता येणार नाही.\n"+
                            "    सदरचे अनधिकृत बिगरपरवाना बांधकामाबाबत महाराष्ट्र महानगरपालिका अधिनियम २०१२ चे कलम २६१, २६४, २६७ आणि ४७८ मधील तरतुदी नुसार मा.आयुक्त यांचे आदेशक्र." +
                            "अति/३/कावि/१००/२०१२ दि.१६/६/२०१२ अन्वये पदनिर्देशित अधिकारी म्हणुन कारवाई करण्याचे अधिकार आम्हाला आहेत, याची नोंद घ्यावी.\n"+
                            "कळावे.\n"+
                            "\n\n\t\t\t\t                   कार्यकारी अभियंता तथा पदनिर्देशित अधिकारी तथा \n" +
                            "\t\t\t\t\t             कार्यकारी अभियंता ( ‘"+p9+" ’ क्षेत्रिय कार्यालय ) \n" +
                            "\t\t\t\t\t          बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग\n" +
                            "\t\t\t\t\t              पिंपरी चिंचवड महानगरपालिका,\n" +
                            "  \t\t\t\t\t                  पिंपरी, पुणे– "+g15+"").getBytes());

                    outputStream.close();

                    Toast.makeText(NoticeSix.this, "File created successfully", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(NoticeSix.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeSix.this);
                alertDialogBuilder.setMessage("All Files Created Exit ?");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent Fir   = new Intent(NoticeSix.this,NoticePanel.class);
                                startActivity(Fir);
                            }
                        });
                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent Fir   = new Intent(NoticeSix.this,NoticePanel.class);
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
                    Toast.makeText(NoticeSix.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }


            }
        });

//submitt end button end

        //spinnerdropdown

        Spinner spin = (Spinner) findViewById(R.id.t8);
        Spinner spin2=(Spinner) findViewById(R.id.t9);



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,daytype );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);


        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,type1 );
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin2.setAdapter(adapter3);


        spin.setOnItemSelectedListener(NoticeSix.this);
        spin2.setOnItemSelectedListener(this);


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                sp1=daytype[position];

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

                sp2=type1[position];
                //Toast.makeText(getApplicationContext(), "Selected types: "+types[position] , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });




        //spinnerenddropdown



    }

    //spinner method
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    private void generateReport()
    {
        Intent i2 =getIntent();

        g1=i2.getStringExtra("name");




        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (DocumentContainer.openDocument6(NoticeSix.this,getLayoutInflater(),DocumentContainer.InputstreamFourhoursPhotos3,g1,
                        p1,p2,p3,p4, p5,p6,p7,p8,p9,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g15,g25)){//create doc in file manager and open document first
                    if (DocumentContainer.InputstreamFourhoursPhotos3 != null){

                    }


                    DocumentContainer.saveReportExternally(NoticeSix.this,getLayoutInflater());//save doc file in the file manager

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(NoticeSix.this,"Report Genrated Successfully",Toast.LENGTH_LONG).show();

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeSix.this);
                            alertDialogBuilder.setMessage("All Files Created Exit ?");
                            alertDialogBuilder.setPositiveButton("yes",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            Intent Fir   = new Intent(NoticeSix.this,NoticePanel.class);
                                            startActivity(Fir);
                                        }
                                    });
                            alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    Intent Fir   = new Intent(NoticeSix.this,NoticePanel.class);
                                    startActivity(Fir);
                                }
                            });
                            AlertDialog alertDialog = alertDialogBuilder.create();
                            alertDialog.show();




                        }
                    });
                }
            }
        });

    }

//spinner method end
}

