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


public class NoticeFiveA extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14,g15,g16,g17,g18,g19,g20,g21;
    String p1,p2,p3,p33,p333,p22,p222;
    EditText t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_five2);

        Intent i =getIntent();
        g20=i.getStringExtra("bipi");
        g21=i.getStringExtra("pin");
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
                Intent Fir   = new Intent(NoticeFiveA.this,NoticePanel.class);
                startActivity(Fir);
            }
        });
        ///

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //intent get data






                Intent i =getIntent();
                g20=i.getStringExtra("bipi");
                g21=i.getStringExtra("pin");

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

                g19=i.getStringExtra("ps");

                //


                p1=t1.getText().toString();


                EditText t2=(EditText) findViewById(R.id.t2);
                p2=t2.getText().toString();

                EditText t22=(EditText) findViewById(R.id.t22);
                p22=t2.getText().toString();

                EditText t222=(EditText) findViewById(R.id.t222);
                p222=t222.getText().toString();

                EditText t3=(EditText) findViewById(R.id.t3);
                p3=t3.getText().toString();

                EditText t33=(EditText) findViewById(R.id.t33);
                p33=t3.getText().toString();

                EditText t333=(EditText) findViewById(R.id.t333);
                p333=t333.getText().toString();




                // Toast.makeText(NoticeOne.this,p1+p2+p3+p4+p5+p8,Toast.LENGTH_SHORT).show();
                try {

                    ContentValues values = new ContentValues();
                    String filename="जबाब_"+g1;
                    String folder="/"+"PCM_APP"+"/"+g1+"/";
                    values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);       //file name
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "application/msword");        //file extension, will automatically add to file
                    values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + folder);     //end "/" is not mandatory

                    Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write(("\t\t\t            जबाब दिनांक "+p1+"\n\n" +

                            "       मी "+g13+" वय "+g14+" वर्षे व्यवसाय - नोकरी - उप अभियंता पिंपरी चिंचवड महानगरपालिका पिंपरी " +
                            ", पुणे-"+g15+". "+g17+" मो.नं "+g16+".\n"+

                            "     समक्ष हजर राहून  जबाब लिहून  देतो की, मी वरील ठिकाणी माझे कुटुंबासह राहण्यास असून,  मी पिंपरी चिंचवड महानगरपालिकेमध्ये " +
                            "पदनिर्देशित अधिकारी तथा उप अभियंता या पदावर लोकसेवक  म्हणून कार्यरत आहे. माझ्याकडे बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण " +
                            "विभागामधील प्रभाग क्र."+g18+" या प्रभागाचा कार्यभार आहे. बांधकाम परवानगी देणे व अनधिकृत बांधकामांवर कारवाई करणे असे आमचे" +
                            " कामाचे स्वरूप आहे. आम्ही आमचे प्रभागात स्टाफ सह फिरून अनधिकृत बांधकामाची पहाणी करून, त्याची माहिती घेतो व त्याचे फोटो आम्ही " +
                            "आमचे  कॅमे-यामध्ये स्टाफचे मदतीने काढत असतो.\n\n"+

                            "      मालक / भोगवटादार / ऑक्युपायर / विकसक - "+g1+" \n"+
                            "      पत्ता- "+g2+"\n "+
                            "      अनधिकृत बांधकामाचे वर्णन – "+g3+" \n"+
                            "      अनधिकृत बांधकामाचे अंदाजे क्षेत्रफळ – "+g4+" मी. X  "+g5+" मी.  X "+g6+" मजले = "+g7+" चौ.मी. \n"+
                            "चतु:सिमा :-\n" +
                            "\tपूर्वेस     –  "+g8+" \n" +
                            "\tपश्चिमेस   –  "+g9+" \n"+
                            "\tदक्षिणेस   –  "+g10+" \n"+
                            "\tउत्तरेस    –  "+g11+" \n" +

                            "\n     सदर चतुःसीमा असलेले बांधकाम महाराष्ट्र महानगरपालिका अधिनियम, २०१२ (जुना मुंबई प्रांतीक महानगरपालिका अधिनियम १९४९) चे कलम ४७८ (१)" +
                            ",कलम ४३३ तसेच पिंपरी चिंचवड महानगरपालिकेच्या विकास नियंत्रण नियमावलीतील तरतूदीनुसार बांधकामाची परवानगी न घेता अनधिकृतपणे बांधकाम चालू केलेले " +
                            "आहे. त्यामुळे मी दि. "+p1+" रोजी माझे कनिष्ठ कर्मचारी नामे श्री. "+p2+" "+p222+" व श्री. "+p3+" "+p333+"" +
                            " यांचे करवी सदर अनधिकृत बांधकाम केलेबाबत समक्ष सही घेऊन त्यांना महाराष्ट्र महानगरपालिका अधिनियम, २०१२ (जुना मुंबई प्रांतीक महानगरपालिका " +
                            "अधिनियम १९४९ ) चे कलम ४७८ (१), कलम ४३३ अन्वये नोटीसची बजावणी केली आहे." +
                            " सदर नोटीसीस अनुसरून मालक / भोगवटादार / ऑक्युपायर / विकसक "+g1+" यांनी चालू असलेल्या बांधकामास महानगरपालिकेची परवानगी घेतली" +
                            " असल्याबाबतचा लेखी पुरावा नोटीसीचा कालावधी संपूनही, नोटीस दिलेल्या पदनिर्देशित अधिकारी यांचेकडे सादर केलेला नाही. वर नमूद केलेल्या नोटीसीनुसार अनधिकृतपणे " +
                            "बांधकाम हटविणे अथवा पाडून टाकणेचे अनुपालन न केल्याने सदर आरोपीने महाराष्ट्र महानगरपालिका अधिनियम, २०१२ (जुना मुंबई प्रांतीक महानगरपालिका अधिनियम १९४९ ) " +
                            "चे कलम ३९७ अ (१) (ब) या प्रमाणे गंभीर गुन्हा केलेला आहे." +
                            " म्हणून माझी मालक / भोगवटादार / ऑक्युपायर / विकसक "+g1+" यांच्या  विरूद्ध फिर्याद आहे. "+
                            "  \n      माझा वरील जबाब मी वाचून पाहिला असून, तो मी यापूर्वी दिलेल्या फिर्यादी रिपोर्टप्रमाणेच बरोबर व खरा टंकलिखित केला असून, तो माझे सांगणेप्रमाणे बरोबर आहे. \n\n "+
                            "समक्ष"+
                            "\n\t\t\t\t\t\tहा जबाब दिला स.ता.म."+
                            "\n\t\t\t\t\t\tपदनिर्देशित अधिकारी तथा उप अभियंता \n" +
                            "\t\t\t\t\t\tपिंपरी चिंचवड महानगरपालिका, पिंपरी "+g15+".\n").getBytes());

                    outputStream.close();

                    Toast.makeText(NoticeFiveA.this, "File created successfully", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(NoticeFiveA.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeFiveA.this);
                alertDialogBuilder.setMessage("Do You Want To Fill फिर्याद ");

                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent Fir   = new Intent(NoticeFiveA.this,NoticeFiveB.class);

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

                                Fir.putExtra("e1",p2);
                                Fir.putExtra("e2",p22);
                                Fir.putExtra("e3",p222);
                                Fir.putExtra("f1",p3);
                                Fir.putExtra("f2",p33);
                                Fir.putExtra("f3",p333);

                                Fir.putExtra("ps",g19);

                                Fir.putExtra("bipi",g20);
                                Fir.putExtra("pin",g21);
                                Fir.putExtra("age2", p33);







                                startActivity(Fir);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent Fir   = new Intent(NoticeFiveA.this,NoticePanel.class);
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

