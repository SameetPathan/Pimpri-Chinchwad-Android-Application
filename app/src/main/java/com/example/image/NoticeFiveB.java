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


public class NoticeFiveB extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    File file;
    OutputStream outputStream;


    String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14,g15,g16,g17,g18,g19,g20,g21,g22,g23,g24,g25,g26,g27,g28;

    String p21,p1,p2,p3,p4,p5,p6;
    EditText t1,t2,t6;

    //cameraend
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_five_b);


        Intent i =getIntent();
        g26=i.getStringExtra("bipi");
        EditText t2=(EditText) findViewById(R.id.t2);
        t2.setText(g26);

        g27=i.getStringExtra("pin");
       t6=(EditText) findViewById(R.id.t6);
        t6.setText(g27);

        g12=i.getStringExtra("D1");
         t1=(EditText) findViewById(R.id.t1);
        t1.setText(g12);


        //submitt end button


        Button submit=(Button) findViewById(R.id.Submit);
        Button back=(Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent Fir   = new Intent(NoticeFiveB.this,NoticePanel.class);
                startActivity(Fir);
            }
        });
        ///

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent get data

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

                g28=i.getStringExtra("age2");



                //

                p1=t1.getText().toString();


                p2=t2.getText().toString();

                EditText t3=(EditText) findViewById(R.id.t3);
                 p3=t3.getText().toString();

                EditText t4=(EditText) findViewById(R.id.t4);
                p4=t4.getText().toString();

                EditText t5=(EditText) findViewById(R.id.t5);
                p5=t5.getText().toString();


                 p6=t6.getText().toString();




                // Toast.makeText(NoticeOne.this,p1+p2+p3+p4+p5+p8,Toast.LENGTH_SHORT).show();
                try {

                    ContentValues values = new ContentValues();
                    String folder="/"+"PCM_APP"+"/"+g1+"/";
                    String filename="फिर्याद_"+g1;
                    values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);       //file name
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "application/msword");        //file extension, will automatically add to file
                    values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + folder);     //end "/" is not mandatory

                    Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write(("\t\t\t\t         फिर्याद\n\n" +
                            "\t\t\t\t\t\t\t       दिनांक -"+ p1 +"\n"+
                            "      मी श्री. "+g13+" वय :- "+g14 +" वर्षे, व्यवसाय - उपअभियंता, पिंपरी चिंचवड" +
                            " महानगरपालिका पिंपरी, पुणे, "+g15+" "+g17+" ,फोन:- "+g16+".\n\n "+

                            "     समक्ष हजर राहून सरकार तर्फे फिर्यादी जबाब लिहून देतो की, मी वरील पत्यावर माझे कुटुंबासह राहण्यास असून मी पिंपरी चिंचवड महानगरपालिका, " +
                            "पुणे येथे उप अभियंता म्हणून सुमारे १३ वर्षापासून कार्यरत असून सध्या बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग येथे नेमणुकीस आहे व पदनिर्देशीत " +
                            "अधिकारी म्हणून माझ्याकडे प्रभाग क्र.०४ दिघी- बोपखेल या विभागाचा कार्यभार आहे. पिंपरी चिंचवड महानगरपालिका मा.सह-शहर अभियंता कार्यालय," +
                            ""+p1+", दि."+p2+" अन्वये प्रभाग ‘"+p4+"’ मधील वॉर्ड क्रं. "+p5+" मधील " +
                            "या विभागातील बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण करणे असे माझे कामाचे स्वरूप आहे. " +
                            "माझे सोबत श्री. "+g22+"  हे " +
                            " स्थापत्य अभियांत्रिकी सहाय्यक तथा "+g24+" म्हणून व श्री. "+g19+" हे "+g21+" म्हणून काम करतात. प्रभागातील अनधिकृत बांधकामाचा " +
                            "सर्व्हे करून रिपोर्ट कार्यालयास सादर करणे असे सोबत श्री. "+g22+"   यांचे काम आहे. \n"+

                            " \n     दि."+p1+" रोजी बीट निरीक्षक सोबत श्री. "+g22+"  यांनी प्रभागातील अनधिकृत बांधकामाबाबत सर्व्हे करून दिघी, पुणे- "+p6+"" +
                            " येथे :- श्री. "+g1+"  "+g4+" मी. X  "+g5+" मी.  X "+g6+" मजले = "+g7+" चौ.मी.  "+g3+" नवीन बांधकाम विनापरवाना केल्याचे लेखी व तोंडी माहिती दिली." +
                            " त्यानुसार मी बांधकामाची खात्री केली असता सदर बांधकाम अनधिकृतपणे केल्याचे आढळून आले लागलीच मी माझे सहकारी श्री. "+g22+"  यांचे सोबत जावून बांधकामाचा पंचनामा केला. " +
                            "सदर बांधकाम १ दिवसात काढून टाकण्याबाबतची नोटिस कार्यकारी अभियंता यांचे आदेशाने "+p2+", दि. "+p1+" अन्वये श्री. "+g22+" यांनी :- श्री "+g1+"  "+

                            " \n      यांना बजावली परंतू नोटिस प्राप्त झालेपासून दिलेल्या मुदतीत बांधकाम काढून टाकणे बंधनकारक असताना :- श्री. "+g1+" यांनी बांधकाम काढले नाही.\n"+

                            " \n        मा. आयुक्त, पिंपरी चिंचवड महानगरपालिकायांनी महाराष्ट्र महानगरपालिका अधिनियम १९४९ चे कलम २६१, २६४, २६७, ४७८ मधील तरतुदींनुसार मला पदनिर्देशित अधिकारी म्हणून कारवाई करण्याचे अधिकार दिल्याने दिघी, पुणे" +
                            " येथे :- श्री. "+g1+"  यांनी "+g4+" मी. X  "+g5+" मी.  X "+g6+" मजले = "+g7+" चौ.मी. "+g3+" नवीन बांधकाम विनापरवाना अनधिकृतपणे केले " +
                            "असल्याने माझी त्यांचेविरुद्ध महाराष्ट्र महानगरपालिका अधिनियम १९४९ चे कलम३९७(अ)(१)(ब) (clause 397A (1)(b)अन्वये कायदेशीर फिर्याद आहे.\n"+

                            " \n  माझी फिर्याद मी वाचून पहिली ती माझे सांगणेप्रमाणे बरोबर व खरी आहे.\n\n\n"+

                            "समक्ष\t\t\t\t\t\t\t ही फिर्याद दिली स.ता.म."+
                            "\n\n\n\t\t\t\t\t\tपदनिर्देशित अधिकारी तथा उप अभियंता \n" +
                            "\t\t\t\t\t\tपिंपरी चिंचवड महानगरपालिका, पिंपरी "+p6+".\n").getBytes());


                    outputStream.close();

                    Toast.makeText(NoticeFiveB.this, "File created successfully", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(NoticeFiveB.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeFiveB.this);
                alertDialogBuilder.setMessage("Do You Want To Fill तपास टिपण ");

                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent Fir   = new Intent(NoticeFiveB.this,NoticeFiveC.class);

                                Fir.putExtra("name",g1);
                                Fir.putExtra("address",g2);

                                Fir.putExtra("typeB",g3);

                                Fir.putExtra("m1",g4);
                                Fir.putExtra("m2",g5);
                                Fir.putExtra("m3",g6);
                                Fir.putExtra("cal",g7);

                                Fir.putExtra("c1",g8);
                                Fir.putExtra("c2",g9);
                                Fir.putExtra("c3",g10);
                                Fir.putExtra("c4",g11);

                                Fir.putExtra("D1",g12);


                                Fir.putExtra("name2",g13);
                                Fir.putExtra("age",g14);
                                Fir.putExtra("pc",g15);
                                Fir.putExtra("mbn",g16);
                                Fir.putExtra("address2",g17);
                                Fir.putExtra("depart",g18);

                                Fir.putExtra("e1",g19);
                                Fir.putExtra("e2",g20);
                                Fir.putExtra("e3",g21);
                                Fir.putExtra("f1",g22);
                                Fir.putExtra("f2",g23);
                                Fir.putExtra("f3",g24);

                                Fir.putExtra("ps",g25);

                                Fir.putExtra("bipi",g26);
                                Fir.putExtra("pin",g27);
                                Fir.putExtra("age2",g28);


                                startActivity(Fir);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent Fir   = new Intent(NoticeFiveB.this,NoticePanel.class);
                        startActivity(Fir);
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();





            }
        });





//submitt end button end

    }

    //spinner method
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
//spinner method end
}

