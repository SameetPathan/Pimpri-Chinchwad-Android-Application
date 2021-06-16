package com.example.image;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;


public class NoticeFive extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14;
    String p1,p2,p3,p4,p5,p6,p7,p8,p9;

    EditText t1,t2,t9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_five);

        Intent i =getIntent();

        g12=i.getStringExtra("D1");
        t2=(EditText) findViewById(R.id.t2);
        t2.setText(g12);

        g13=i.getStringExtra("bipi");
        t1=(EditText) findViewById(R.id.t1);
        t1.setText(g13);

        g14=i.getStringExtra("pin");
        t9=(EditText) findViewById(R.id.t9);
        t9.setText(g14);

        // submitt end button

        Button submit=(Button) findViewById(R.id.Submit);
        Button back=(Button) findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent Fir   = new Intent(NoticeFive.this,NoticePanel.class);
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










                //


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

                EditText t8=(EditText) findViewById(R.id.t8);
                p8=t8.getText().toString();


                 p9=t9.getText().toString();


                 /*

                // Toast.makeText(NoticeOne.this,p1+p2+p3+p4+p5+p8,Toast.LENGTH_SHORT).show();
                try {


                    ContentValues values = new ContentValues();
                    String folder="/"+"PCM_APP"+"/"+g1+"/";
                    String filename="FIR_"+g1;
                    values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);       //file name
                    values.put(MediaStore.MediaColumns.MIME_TYPE, "application/msword");        //file extension, will automatically add to file
                    values.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOCUMENTS + folder);     //end "/" is not mandatory

                    Uri uri = getContentResolver().insert(MediaStore.Files.getContentUri("external"), values);      //important!

                    OutputStream outputStream = getContentResolver().openOutputStream(uri);

                    outputStream.write(("\t\t\t\t\t\t\t\t  पिंपरी चिंचवड महानगरपालिका\n\t\t\t\t" +
                            "\t\t\t\t पिंपरी पुणे – "+p9+"\n\t\t\t\t" +
                            "\t\t\t\t बांधकाम परवानगी  व अनधिकृत \n\t\t\t\t" +
                            "\t\t\t\t बांधकाम नियंत्रण विभाग \n\t\t\t\t" +
                            "\t\t\t\t "+p1+" \n\t\t\t\t" +
                            "\t\t\t\t दिनांक -"+ p2 +
                            "\n\nप्रति,"+
                            "\n\tमा.पोलिस निरीक्षक"+
                            "\n\t"+p3+"" +
                            "\n\tपिंपरी चिंचवड, पुणे." +

                            "\n\t\t   विषय -  महाराष्ट्र महानगरपालिका अधिनियम २०१२ (जुना मुंबई प्रांतिक महानगरपालिका \n" +
                            "                 अधिनियम १९४९) चे कलम ३९७ अ (१) (ब) प्रमाणेफिर्याद.\n\n" +
                            "\t\tफिर्यादी -  पदनिर्देशित अधिकारी तथा उप अभियंता "+p4+"\n"+
                            "महोदय,\n" +
                            "      मी "+p4+" पिंपरी चिंचवड महानगरपालिकेमध्ये पदनिर्देशित अधिकारी तथा " +
                            "उप अभियंता या पदावर लोकसेवक म्हणून कार्यरत आहे. माझ्याकडे प्रभाग क्र."+p8+" या विभागाचा कार्यभाग आहे.\n\n" +

                            "मालक / भोगवटादार / ऑक्युपायर / विकसक - "+g1+"\n"+
                            "पत्ता- "+g2+"\n"+
                            "अनधिकृत बांधकामाचे वर्णन -"+g3+" \n"+
                            "अनधिकृत बांधकामाचे अंदाजे क्षेत्रफळ – "+g4+" मी. X  "+g5+" मी.  X "+g6+" मजले = "+g7+" चौ.मी\n"+
                            "चतु:सिमा :-\n" +
                            "\tपूर्वेस     – "+g8+" \n" +
                            "\tपश्चिमेस   – "+g9+" \n"+
                            "\tदक्षिणेस   – "+g10+" \n"+
                            "\tउत्तरेस    – "+g11+" \n" +
                            "      या चतु: सिमा असलेले बांधकाम महाराष्ट्र महानगरपालिका अधिनियम २०१२, महाराष्ट्र प्रादेशिक व नगररचना अधिनियम १९६६ व " +
                            "जुना मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९,  तसेच पिंपरी  चिंचवड महानगरपालिकेच्या विकास नियंत्रण नियमावलीतील तरतुदीनुसार " +
                            "बांधकामाची परवानगी न घेता अनधिकृतपणे इमारतीचे बांधकाम  चालू केलेले आहे. त्यामुळे महाराष्ट्र महानगरपालिका अधिनियम २०१२ चे कलम ४७८ " +
                            "(१) व कलम ४३३ (जुना मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९ ) अन्वये सदर अनधिकृत बांधकामास दि. "+g12+" रोजी  नोटीस दिलेली आहे.\n"+
                            "      सदर नोटीसीस अनुसरुन "+g1+" यांनी चालु असलेल्या बांधकामास महानगरपालिकेची परवानगी घेतली असल्याबाबतचा लेखी पुरावा नोटीसीचा " +
                            "कालावधी संपुनही नोटीस दिलेल्या पदनिर्देशीत अधिकारी यांचेकडे सादर केलेला नाही व नमूद केलेल्या नोटीसीनुसार अनधिकृत बांधकाम हलविणे अथवा पाडून टाकणेचे " +
                            "अनुपालन न केल्याने तसेच बांधकाम विकास पुढे चालू ठेवून सदर आरोपीने महाराष्ट्र महानगरपालिका अधिनियम २०१२ (मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९)" +
                            " चे कलम ३९७ अ (१) (ब) याप्रमाणे गंभीर गुन्हा केलेला आहे.\n"+
                            "      तरी "+g1+" यांनी नोटीसीनुसार अनधिकृत बांधकाम हटविणे अथवा पाडून टाकणेचे अनुपालन न केल्याने तसेच बांधकाम विकास पूर्ण करून वापर चालू " +
                            "ठेवल्याने माझी यांचे विरुध्द फिर्याद असून मेहेरबानास विंनती की, महाराष्ट्र महानगरपालिका अधिनियम २०१२ ( मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९ ) चे कलम " +
                            "३९७ अ (१) (ब)  नुसार गुन्हा दाखल करण्यात यावा.\n\n"+
                            "सोबत - \n" +
                            "१. पंचनामा मूळ प्रत\t\t\t             पदनिर्देशित अधिकारी तथा उप अभियंता  \n "+
                            "२. नोटीसीची मूळ प्रत\t\t\t\t                  पिंपरी चिंचवड महानगरपालिका, पिंपरी "+p9+" \n "+
                            "३. फोटोग्राफची मूळ प्रत \n"+
                            "४. मिळकत कर बिल प्रत \n"+
                            "५. दि.१७/०६/२०१५ आदेशाची प्रत \n").getBytes());

                    outputStream.close();

                    Toast.makeText(NoticeFive.this, "File created successfully", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(NoticeFive.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }


                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeFive.this);
                alertDialogBuilder.setMessage("Do You Want To Fill जबाब ");

                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent Fir   = new Intent(NoticeFive.this,NoticeFiveA.class);

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

                                Fir.putExtra("name2",p4);
                                Fir.putExtra("age",p5);
                                Fir.putExtra("pc",p9);
                                Fir.putExtra("mbn",p6);
                                Fir.putExtra("address2",p7);
                                Fir.putExtra("depart",p8);

                                Fir.putExtra("ps",p3);

                                startActivity(Fir);
                            }
                        });

                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        Intent Fir   = new Intent(NoticeFive.this,NoticePanel.class);
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
                    Toast.makeText(NoticeFive.this, "Fail to create file", Toast.LENGTH_SHORT).show();
                }

            }
        });
//submitt end button end
    }


    private void generateReport()
    {
        Intent i2 =getIntent();

        g1=i2.getStringExtra("name");




        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                if (DocumentContainer.openDocument5(NoticeFive.this,getLayoutInflater(),DocumentContainer.InputstreamFourhoursPhotos3,g1,
                        p1,p2,p3,p4, p5,p6,p7,p8,p9,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12)){//create doc in file manager and open document first
                    if (DocumentContainer.InputstreamFourhoursPhotos3 != null){

                    }


                    DocumentContainer.saveReportExternally(NoticeFive.this,getLayoutInflater());//save doc file in the file manager

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(NoticeFive.this,"Report Genrated Successfully",Toast.LENGTH_LONG).show();

                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(NoticeFive.this);
                            alertDialogBuilder.setMessage("Do You Want To Fill जबाब ");

                            alertDialogBuilder.setPositiveButton("yes",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface arg0, int arg1) {
                                            Intent Fir   = new Intent(NoticeFive.this,NoticeFiveA.class);

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
                                            Fir.putExtra("bipi",g13);
                                            Fir.putExtra("pin",g14);

                                            Fir.putExtra("name2",p4);
                                            Fir.putExtra("age",p5);
                                            Fir.putExtra("pc",p9);
                                            Fir.putExtra("mbn",p6);
                                            Fir.putExtra("address2",p7);
                                            Fir.putExtra("depart",p8);

                                            Fir.putExtra("ps",p3);

                                            startActivity(Fir);
                                        }
                                    });

                            alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                    Intent Fir   = new Intent(NoticeFive.this,NoticePanel.class);
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

    //spinner method
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
//spinner method end
}

