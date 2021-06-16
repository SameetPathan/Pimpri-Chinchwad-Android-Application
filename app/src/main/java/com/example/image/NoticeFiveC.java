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


public class NoticeFiveC extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    File file;
    OutputStream outputStream;

    //camera
    private static int IMG_RESULT = 1;
    String ImageDecode;
    ImageView imageViewLoad,imageViewLoad1,imageViewLoad2,imageViewLoad3;
    Button LoadImage,LoadImage1,LoadImage2,LoadImage3;
    Intent intent;
    String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14,g15,g16,g17,g18,g19,g20,g21,g22,g23,g24,g25,g26,g27,g28;
    String p21,p1,p2,p3,p4,p5,p6;
    String[] FILE;
    String camerastate="";
    EditText t1,t2;


    //cameraend
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_five_c);

        Intent i =getIntent();

        g12=i.getStringExtra("D1");
         t1=(EditText) findViewById(R.id.t1);
        t1.setText(g12);

        g26=i.getStringExtra("bipi");

        g27=i.getStringExtra("pin");
       t2=(EditText) findViewById(R.id.t2);
        t2.setText(g27);

        //submitt end button


        Button submit=(Button) findViewById(R.id.Submit);
        Button back=(Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent Fir   = new Intent(NoticeFiveC.this,NoticePanel.class);
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


                String p1=t1.getText().toString();


                String p2=t2.getText().toString();

                EditText t3=(EditText) findViewById(R.id.t3);
                String p3=t3.getText().toString();


                // Toast.makeText(NoticeOne.this,p1+p2+p3+p4+p5+p8,Toast.LENGTH_SHORT).show();
                try {

                    ContentValues values = new ContentValues();
                    String folder="/"+"PCM_APP"+"/"+g1+"/";
                    String filename="तपास_टिपण_"+g1;
                    values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);       //file name
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "application/msword");        //file extension, will automatically add to file
                    values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + folder);     //end "/" is not mandatory

                    Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write(("\t\t\t\t  तपास टिपण दिनांक  "+p1+"\n\n\n" +

                            "      मी श्री. "+g22+" , वय - "+g28+", व्यवसाय- नोकरी स्थापत्य ,"+g24+" पिंपरी चिंचवड महानगरपालिका पिंपरी, पुणे," +
                            "पुणे -"+p2+" , मोबाईल क्र. "+p3+".\n\n"+

                            "\n      समक्ष हजर राहून  जबाब लिहून  देतो की, मी बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग, पिंपरी चिंचवड महानगरपालिका, पिंपरी -१८. " +
                            "येथे कार्यरत असून प्रभाग क्र.०४ दिघी - बोपखेल हा भाग माझ्या कार्यक्षेत्रात आहेस. "+g2+", पुणे-"+p2+".\n"+

                            "\n      या ठिकाणी मालक / भोगवटादार / ऑक्युपायर / विकसक श्री. "+g1+" यांचे अनधिकृत बांधकाम सुरु असल्याचे निदर्शनास आले." +
                            " मालक / भोगवटादार / ऑक्युपायर / विकसक श्री. "+g1+" यांचे अनधिकृत बांधकामास या विभागामार्फत दि. "+p1+" रोजी महाराष्ट्र महानगरपालिका अधिनियम, २०१२ (जुना मुंबई प्रांतीक महानगरपालिका अधिनियम १९४९ ) चे कलम ४७८ (१), कलम ४३३ अन्वये नोटीस काढणेत आलेली आहे." +
                            " सदरची नोटीस बजाविणेकामी मी स्वत: जागेवर गेलो असता सदरची नोटीसचे स्थळप्रतीवर श्री. "+g1+" ( मालक / भोगवटादार / ऑक्युपायर / विकसक ) यांची स्वाक्षरी घेतलेली आहे. \n\n\n"+

                            "\t\t\t\t\tश्री. "+g22+", \n" +
                            "\t\t\t\t\tमोबाईल क्र. "+p3+", \n" +
                            "\t\t\t\t\tस्थापत्य अभियांत्रिकी सहाय्यक तथा बीट निरीक्षक,\n" +
                            "\t\t\t\t\tबांधकाम परवानगी  व अनधिकृत  बांधकाम नियंत्रण विभाग \n" +
                            "\t\t\t\t\tपिंपरी चिंचवड महानगरपालिका  पिंपरी पुणे – "+p2+"\n").getBytes());

                    outputStream.close();

                    Toast.makeText(NoticeFiveC.this, "File created successfully", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(NoticeFiveC.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeFiveC.this);
                alertDialogBuilder.setMessage("Do You Want To Fill डी.सी.आर.ता. ");

                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent Fir   = new Intent(NoticeFiveC.this,NoticeFiveD.class);

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
                        Intent Fir   = new Intent(NoticeFiveC.this,NoticePanel.class);
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

