package com.example.image;

import android.app.Activity;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Random;


public class DocumentContainer {

    private static DocumentContainer mDocumentContainer;




    private static XWPFDocument document ;
    public static FileOutputStream out = null;

    public static String fileName;
    public static File file;

    private Context mContext;


    public static InputStream InputstreamFourhoursPhotos3;

    public DocumentContainer(Context context) {
        mContext = context;
        initProperties();

    }
    public static DocumentContainer get(Context c){
        if(mDocumentContainer==null){
            mDocumentContainer = new DocumentContainer(c.getApplicationContext());
        }
        return mDocumentContainer;
    }


    public static XWPFDocument getDocument(){
        return document;
    }
    private static void initProperties(){
        System.setProperty("org.apache.poi.javax.xml.stream.XMLInputFactory", "com.fasterxml.aalto.stax.InputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLOutputFactory", "com.fasterxml.aalto.stax.OutputFactoryImpl");
        System.setProperty("org.apache.poi.javax.xml.stream.XMLEventFactory", "com.fasterxml.aalto.stax.EventFactoryImpl");
    }

    //1stform
    public static boolean openDocument(Context context, LayoutInflater inflator,InputStream imageFile, String filen,String p1,
                                       String p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,String p10,
    String p11,String p12,String p13,String p14,String p15,String p16,String p17,String p18,String p19,String p20,String p22,String p23) {
        initProperties();
        document = new XWPFDocument();

        //file name here

        fileName = filen;

        ///
        String subfolder=filen;

        String formFinal="sameet";

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        fileName ="सूचना478_"+ fileName +".docx";
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/PCM_APP/"+subfolder);
            myDir.mkdirs();
            file = new File(myDir, fileName);
            if (file.exists()) {
                MessageHelper.showCustomToastSuccess(context,inflator,"Please wait updating "+fileName+". . . ");
                file.delete();
            }
            out = new FileOutputStream(file);

            ////

            ////logo and address
            XWPFTable tabletemp = DocumentContainer.get(context).getDocument().createTable();
            tabletemp.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);
            CTTblWidth widthTable = tabletemp.getCTTbl().addNewTblPr().addNewTblW();
            widthTable.setType(STTblWidth.DXA);
            widthTable.setW(BigInteger.valueOf(10000));

            //create first row left
            XWPFTableRow tableRowOnetemp = tabletemp.getRow(0);
            CTTblWidth cellwidth1=tableRowOnetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW();
            cellwidth1.setW(BigInteger.valueOf(5000));
            cellwidth1.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp = tableRowOnetemp.getCell(0).addParagraph().createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            runRowOnetemp.addPicture(imageFile, format, "logo.png", Units.toEMU(100), Units.toEMU(100));

            //create first row right
            tableRowOnetemp.createCell();
            CTTblWidth cellwidth2=tableRowOnetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW();
            cellwidth2.setW(BigInteger.valueOf(5000));
            cellwidth2.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp2 = tableRowOnetemp.getCell(1).addParagraph().createRun();
            runRowOnetemp2.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी पुणे – "+p20);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("कार्यकारी अभियंता तथा पदनिर्देशित अधिकारी");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("बांधकाम परवानगी  व अनधिकृत बांधकाम नियंत्रण विभाग ");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("जवाक - "+p1);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("दिनांक -"+ p2+"          ");

            XWPFRun addRun = DocumentContainer.get(context).getDocument().createParagraph().createRun();


            XWPFParagraph paragraph3 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);

            run3.setText("सूचना");
            run3.addBreak();
            //

            //
            XWPFParagraph paragraph4 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.LEFT);


            run4.setText("प्रति,");
            run4.addBreak();
            run4.setText("मालक / विकसक / ऑक्युपायर :-");
            run4.addBreak();
            run4.setText(p3+" "+filen);
            run4.addBreak();
            run4.setText("पत्ता :- "+p4);
            run4.addBreak();

            //

            //
            XWPFParagraph paragraph5 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.LEFT);


            run5.setText("         महाराष्ट्र महानगरपालिका अधिनियम चे कलम ४७८(१), कलम ४३३(क) अन्वये सूचना देण्यात येते की " +
                    " तुम्ही पिंपरी चिंचवड महानगरपालिकेची बांधकाम परवानगी न घेता बिगर परवाना अनधिकृत बांधकाम केलेचे " +
                    " निदर्शनास आले आहे. सदर बिगर परवाना अनधिकृत बांधकामाची माहिती खालीलप्रमाणे :- ");
            run5.addBreak();
            run5.addBreak();
            run5.setText( "गाव  –  "+p5+"      मोजे  –  "+p6+"       ता. –  "+p7+"    जि. पुणे" );
            run5.addBreak();
            run5.setText("ठिकाण  – "+p8);
            run5.addBreak();
            run5.setText("स.नं. / सि.टी.स.नं. / गट नं. – "+p9);
            run5.addBreak();
            run5.addBreak();
            run5.setText("बांधकामाचे मोजमाप – अंदाजे "+p10+" मी. X "+p11+" मी. X "+p12+" मजले = "+p13+" चौ.मी.");
            run5.addBreak();
            run5.setText("बांधकामाचा प्रकार :-  "+p14);
            run5.addBreak();
            run5.setText("चतु:सिमा – ");
            run5.addBreak();
            run5.setText("    पूर्वेस     –   "+p15);
            run5.addBreak();
            run5.setText("    पश्चिमेस   –   "+p16);
            run5.addBreak();
            run5.setText("    दक्षिणेस   –   "+p17);
            run5.addBreak();
            run5.setText("    उत्तरेस    –   "+p18);
            run5.addBreak();
            run5.addBreak();

            run5.setText("             आपण केलेले सर्व बांधकाम अनधिकृत आहे. सदरचे वरीलप्रमाणे केलेले अनधिकृत बांधकाम तुम्ही ही सूचना पोहोचविल्यापासून "+p23+" "+p22+" " +
                         "आत काढून टाकावे. वेळ प्रसंग पडल्यास प्रत्यक्ष कारवाईच्या वेळी सदरच्या बांधकामाच्या जागेवर भरतील ती व असतील ती स्थितीप्रमाणे, त्यासहचे सर्व बांधकाम याप्रमाणे" +
                         " तुम्ही बिगर परवाना बांधकाम काढून टाकण्याची व्यवस्था न केल्यास ते बांधकाम आम्ही काढून टाकू, त्याबाबत होणारा खर्च तुमच्याकडून वसूल करण्यात येईल. तसेच सदरच्या " +
                         "सूचनेबाबत आपल्याकडील कोणताही खुलासा/ पत्र ग्राहय धरता येणार नाही. " );
            run5.addBreak();
            run5.setText("               सदरचे अनधिकृत/बिगर परवाना बांधकामाबाबत महाराष्ट्र महानगरपालिका अधिनियम चे कलम २६१, २६४,  \"२६७ आणि ४७८ मधील तरतुदीनुसार मा. आयुक्त यांचे आदेश क्रमांक" +
                    "अति/३/कावि/१००/२०१२ दि.१६/६/२०१२अन्वये पदनिर्देशित  अधिकारी म्हणुन कारवाई करण्याचे आधिकारी आम्हाला आहेत याची नोंद घ्यावी.");
            run5.addBreak();
            //
            //
            XWPFParagraph paragraph6 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            paragraph6.setAlignment(ParagraphAlignment.RIGHT);

            run6.addBreak();
            run5.addBreak();
            run6.setText( "पदनिर्देशित अधिकारी तथा कार्यकारी अभियंता  ");

            XWPFParagraph paragraph7 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run7 = paragraph7.createRun();
            paragraph7.setAlignment(ParagraphAlignment.RIGHT);
            run7.setText("क्षेत्रिय कार्यालय (‘"+p19+" ’)");


            XWPFParagraph paragraph8 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            paragraph8.setAlignment(ParagraphAlignment.RIGHT);
            run8.setText("बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग");

            XWPFParagraph paragraph9 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            paragraph9.setAlignment(ParagraphAlignment.RIGHT);
            run9.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी, पुणे– "+p20);

            //

            //




            return true;
        } catch (InvalidFormatException | IOException e) {
            MessageHelper.showCustomToastError(context,inflator,"Please Enable Permissions from settings");

            e.printStackTrace();
            return false;
        }
    }


    ///2ndform

    public static boolean openDocument2(Context context, LayoutInflater inflator,InputStream imageFile, String filen,String p1,
                                       String p2,String p3,String p4,String p6,String p7,String p8,String p9,String p10,
                                       String p11,String p12,String p13,String p14,String p15,String p16,String p17,String p18,String p19,String p20,String p21,String p22,String p23,String p24,String p25) {
        initProperties();
        document = new XWPFDocument();

        //file name here

        fileName = filen;
        ///all data




        ///
        String subfolder=filen;

        String formFinal="sameet";

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        fileName ="कलम_५३_"+ fileName +".docx";
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/PCM_APP/"+subfolder);
            myDir.mkdirs();
            file = new File(myDir, fileName);
            if (file.exists()) {
                MessageHelper.showCustomToastSuccess(context,inflator,"Please wait updating "+fileName+". . . ");
                file.delete();
            }
            out = new FileOutputStream(file);


            ////logo and address
            XWPFTable tabletemp = DocumentContainer.get(context).getDocument().createTable();
            tabletemp.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);
            CTTblWidth widthTable = tabletemp.getCTTbl().addNewTblPr().addNewTblW();
            widthTable.setType(STTblWidth.DXA);
            widthTable.setW(BigInteger.valueOf(10000));

            //create first row left
            XWPFTableRow tableRowOnetemp = tabletemp.getRow(0);
            CTTblWidth cellwidth1=tableRowOnetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW();
            cellwidth1.setW(BigInteger.valueOf(5000));
            cellwidth1.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp = tableRowOnetemp.getCell(0).addParagraph().createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            runRowOnetemp.addPicture(imageFile, format, "logo.png", Units.toEMU(100), Units.toEMU(100));

            //create first row right
            tableRowOnetemp.createCell();
            CTTblWidth cellwidth2=tableRowOnetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW();
            cellwidth2.setW(BigInteger.valueOf(5000));
            cellwidth2.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp2 = tableRowOnetemp.getCell(1).addParagraph().createRun();
            runRowOnetemp2.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी पुणे – "+p22);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("कार्यकारी अभियंता तथा पदनिर्देशित अधिकारी");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("बांधकाम परवानगी  व अनधिकृत बांधकाम नियंत्रण विभाग ");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("जवाक - "+p1);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("दिनांक -"+ p3+"          ");

            XWPFRun addRun = DocumentContainer.get(context).getDocument().createParagraph().createRun();

            ///


            XWPFParagraph paragraph3 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);


            run3.setText("परिशिष्ट-६");
            run3.addBreak();
            run3.setText("महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ कलम ५३ अन्वये नोटीस");
            //

            //
            XWPFParagraph paragraph4 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.LEFT);


            run4.setText("प्रति,");
            run4.addBreak();
            run4.setText("मालक / विकसक / ऑक्युपायर :-");
            run4.addBreak();
            run4.setText(p4+" "+filen);
            run4.addBreak();
            run4.setText("पत्ता :- "+p6);
            run4.addBreak();
            //

            //
            XWPFParagraph paragraph5 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.LEFT);


            run5.setText("         ज्या अर्थी खाली सही करणा-यास महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ " +
                    "चे कलम ५३ अन्वये कारवाई करणेचे अधिकार महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ अन्वये प्रदान केलेले आहेत.");
            run5.addBreak();
            run5.setText("         आणि ज्या अर्थी माझे असे निदर्शनास आले आहे की तुम्ही खालीलप्रमाणे अनधिकृत/विनापरवाना बांधकाम / विकास केला आहे. त्याअर्थी या नोटीसद्वारे सदरचे तात्पुरते स्वरुपाचे बांधकाम " +
                    "ही नोटीस मिळालेपासून " + p24 + " " + p23 + " आत हलविण्याचा / काढून टाकणेचा आदेश देणेत येत आहे.तसेच सदरच्या बांधकामाचा/जमिनीचा अनधिकृत वापर तात्काळ थांबविणेचा आदेश देणेत येत आहे.");
            run5.addBreak();
            run5.setText("         या नोटीशीप्रमाणे तुम्ही अनधिकृत बांधकाम/विकास काढून टाकले नाही तर सदरचे बांधकाम/विकास प्राप्त अधिकाराचा वापर " +
                    " करून तुमचे जबाबदारीवर व  खर्चाने काढून टाकणेत येवून येणारा खर्च तुमचेकडून वसूल केला जाईल. ");
            run5.addBreak();
            run5.addBreak();
            run5.setText("सदरच्या अनधिकृत/अनियमित बांधकाम/विकास याची माहिती पुढील प्रमाणे - ");
            run5.addBreak();
            run5.addBreak();
            run5.setText( "     १) गाव    -  " + p7  );
            run5.addBreak();
            run5.setText("      २) ठिकाण -  " + p8  );
            run5.addBreak();
            run5.setText("      ३) स.नं.  -  " + p9 );
            run5.addBreak();
            run5.setText("      ४) अंदाजे क्षेत्र -  " + p10  );
            run5.addBreak();
            run5.addBreak();
            run5.setText("अंदाजे मोजमाप - "+p11+" मी. X "+p12+" मी. X "+p13+" मजले = "+p14+" चौ.मी.");
            run5.addBreak();
            run5.addBreak();
            run5.setText(" ५)  अनधिकृत बांधकामाची चतु:सिमा :- " );
            run5.addBreak();
            run5.setText("     पूर्वेस     –   "+p15);
            run5.addBreak();
            run5.setText( "    पश्चिमेस   –   "+p16);
            run5.addBreak();
            run5.setText( "    दक्षिणेस   –   "+p17);
            run5.addBreak();
            run5.setText("     उत्तरेस    –   "+p18);
            run5.addBreak();
            run5.addBreak();
            run5.setText("दिनांक  -" + p19);
            run5.addBreak();
            run5.setText("ठिकाण - " + p20);
            run5.addBreak();
            run5.addBreak();
            run5.addBreak();

            //
            //

            XWPFParagraph paragraph6 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            paragraph6.setAlignment(ParagraphAlignment.RIGHT);

            run6.addBreak();
            run5.addBreak();
            run6.setText( "पदनिर्देशित अधिकारी तथा कार्यकारी अभियंता  ");

            XWPFParagraph paragraph7 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run7 = paragraph7.createRun();
            paragraph7.setAlignment(ParagraphAlignment.RIGHT);
            run7.setText("क्षेत्रिय कार्यालय (‘"+p21+" ’)");


            XWPFParagraph paragraph8 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            paragraph8.setAlignment(ParagraphAlignment.RIGHT);
            run8.setText("बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग");

            XWPFParagraph paragraph9 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            paragraph9.setAlignment(ParagraphAlignment.RIGHT);
            run9.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी, पुणे– "+p22);

            //

            //
            XWPFParagraph paragraph10 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run10 = paragraph10.createRun();
            paragraph10.setAlignment(ParagraphAlignment.RIGHT);

            run10.addBreak();
            run10.setText( " टीप:- याबाबतीतील खटल्यामध्ये ३ वर्ष कारावासाची शिक्षा आणि रक्कम रु. ५,०००/- दंड " +
                    "अथवा दोन्हीही व अनियमित बांधकाम काढून टाकण्याच्या विलंबा पोटी प्रति दिन रक्कम रु. १००/- याप्रमाणे शिक्षा होऊ शकतात.");


            //





            return true;
        } catch (InvalidFormatException | IOException e) {
            MessageHelper.showCustomToastError(context,inflator,"Please Enable Permissions from settings");

            e.printStackTrace();
            return false;
        }
    }


    //end2from
    ///3rdform

    public static boolean openDocument3(Context context, LayoutInflater inflator,InputStream imageFile, String filen,String p1,
                                        String p2,String p3,String p4,String p6,String p7,String p8,String p9,String p10,
                                        String p11,String p12,String p13,String p14,String p15,String p16,String p17,String p18,String p19,String p20,String p21,String p22,String p23,String p24,String p25) {
        initProperties();
        document = new XWPFDocument();

        //file name here

        fileName = filen;
        ///all data




        ///
        String subfolder=filen;

        String formFinal="sameet";

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        fileName ="कलम_५३_(१)_(अ)_"+ fileName +".docx";
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/PCM_APP/"+subfolder);
            myDir.mkdirs();
            file = new File(myDir, fileName);
            if (file.exists()) {
                MessageHelper.showCustomToastSuccess(context,inflator,"Please wait updating "+fileName+". . . ");
                file.delete();
            }
            out = new FileOutputStream(file);

            ////logo and address
            XWPFTable tabletemp = DocumentContainer.get(context).getDocument().createTable();
            tabletemp.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);
            CTTblWidth widthTable = tabletemp.getCTTbl().addNewTblPr().addNewTblW();
            widthTable.setType(STTblWidth.DXA);
            widthTable.setW(BigInteger.valueOf(10000));

            //create first row left
            XWPFTableRow tableRowOnetemp = tabletemp.getRow(0);
            CTTblWidth cellwidth1=tableRowOnetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW();
            cellwidth1.setW(BigInteger.valueOf(5000));
            cellwidth1.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp = tableRowOnetemp.getCell(0).addParagraph().createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            runRowOnetemp.addPicture(imageFile, format, "logo.png", Units.toEMU(100), Units.toEMU(100));

            //create first row right
            tableRowOnetemp.createCell();
            CTTblWidth cellwidth2=tableRowOnetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW();
            cellwidth2.setW(BigInteger.valueOf(5000));
            cellwidth2.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp2 = tableRowOnetemp.getCell(1).addParagraph().createRun();
            runRowOnetemp2.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी पुणे – "+p22);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("कार्यकारी अभियंता तथा पदनिर्देशित अधिकारी");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("बांधकाम परवानगी  व अनधिकृत बांधकाम नियंत्रण विभाग ");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("जवाक - "+p1);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("दिनांक -"+ p3+"          ");

            XWPFRun addRun = DocumentContainer.get(context).getDocument().createParagraph().createRun();


            ///


            XWPFParagraph paragraph = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.RIGHT);
            //
            XWPFParagraph paragraph3 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);

            run3.setText("परिशिष्ट-६");
            run3.addBreak();
            run3.setText("महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ कलम ५३ (१)(अ) अन्वये नोटीस");
            //

            //
            XWPFParagraph paragraph4 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.LEFT);


            run4.setText("प्रति,");
            run4.addBreak();
            run4.setText("मालक / विकसक / ऑक्युपायर :-");
            run4.addBreak();
            run4.setText(p4+" "+filen);
            run4.addBreak();
            run4.setText("पत्ता :- "+p6);
            run4.addBreak();
            //

            //
            XWPFParagraph paragraph5 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.LEFT);


            run5.setText("         ज्या अर्थी खाली सही करणा-यास महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ चे कलम ५३ (१) (अ)" +
                    " अन्वये कारवाई करणेचे अधिकार महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ अन्वये प्रदान केलेले आहेत.");
            run5.addBreak();
            run5.setText("        आणि ज्या अर्थी माझे असे निदर्शनास आले आहे की तुम्ही खालीलप्रमाणे अनधिकृत/विनापरवाना बांधकाम/विकास केला आहे. " +
                    " त्याअर्थी या नोटीसद्वारे सदरचे तात्पुरते स्वरुपाचे बांधकाम ही नोटीस मिळालेपासून " +
                    ""+p24+" "+p23+"आत हलविण्याचा / काढून टाकणेचा आदेश देणेत येत आहे. तसेच सदरच्या बांधकामाचा/जमिनीचा अनधिकृत वापर तात्काळ थांबविणेचा आदेश देणेत येत आहे");
            run5.addBreak();
            run5.setText("         या नोटीशीप्रमाणे तुम्ही अनधिकृत बांधकाम/विकास काढून टाकले नाही तर सदरचे बांधकाम/विकास प्राप्त  " +
                    "अधिकाराचा वापर करून तुमचे जबाबदारीवर व खर्चाने काढून टाकणेत येवून येणारा खर्च तुमचेकडून वसूल केला जाईल.  ");
            run5.addBreak();
            run5.addBreak();
            run5.setText(" सदरच्या अनधिकृत/अनियमित बांधकाम/विकास याची माहिती पुढील प्रमाणे-");
            run5.addBreak();
            run5.addBreak();
            run5.setText( "     १) गाव    -  " + p7  );
            run5.addBreak();
            run5.setText("      २) ठिकाण -  " + p8  );
            run5.addBreak();
            run5.setText("      ३) स.नं.  -  " + p9 );
            run5.addBreak();
            run5.setText("      ४) अंदाजे क्षेत्र -  " + p10  );
            run5.addBreak();
            run5.addBreak();
            run5.setText("अंदाजे मोजमाप - "+p11+" मी. X "+p12+" मी. X "+p13+" मजले = "+p14+" चौ.मी.");
            run5.addBreak();
            run5.addBreak();
            run5.setText(" ५)  अनधिकृत बांधकामाची चतु:सिमा :- " );
            run5.addBreak();
            run5.setText("       पूर्वेस     –   "+p15);
            run5.addBreak();
            run5.setText( "      पश्चिमेस   –   "+p16);
            run5.addBreak();
            run5.setText( "      दक्षिणेस   –   "+p17);
            run5.addBreak();
            run5.setText("       उत्तरेस    –   "+p18);
            run5.addBreak();
            run5.addBreak();
            run5.setText("दिनांक  -" + p20);
            run5.addBreak();
            run5.setText("ठिकाण - " + p19);
            run5.addBreak();
            run5.addBreak();
            run5.addBreak();

            //
            //
            XWPFParagraph paragraph6 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            paragraph6.setAlignment(ParagraphAlignment.RIGHT);

            run6.addBreak();
            run5.addBreak();
            run6.setText( "पदनिर्देशित अधिकारी तथा कार्यकारी अभियंता  ");

            XWPFParagraph paragraph7 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run7 = paragraph7.createRun();
            paragraph7.setAlignment(ParagraphAlignment.RIGHT);
            run7.setText("क्षेत्रिय कार्यालय (‘"+p21+" ’)");


            XWPFParagraph paragraph8 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            paragraph8.setAlignment(ParagraphAlignment.RIGHT);
            run8.setText("बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग");

            XWPFParagraph paragraph9 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            paragraph9.setAlignment(ParagraphAlignment.RIGHT);
            run9.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी, पुणे– "+p22);


            //

            run.setFontFamily("Calibri (Body)");
            // run.setBold(true);
            run.addBreak();
            //




            return true;
        } catch (InvalidFormatException | IOException e) {
            MessageHelper.showCustomToastError(context,inflator,"Please Enable Permissions from settings");

            e.printStackTrace();
            return false;
        }
    }


    //end3from

    ///4rdform

    public static boolean openDocument4(Context context, LayoutInflater inflator,InputStream imageFile, String filen,String p1,
                                        String p2,String p3,String p4,String p6,String p7,String p8,String p9,String p10,
                                        String p11,String p12,String p13,String p14,String p15,String p16,String p17,String p18,String p19,String p20,String p21,String p22,String p23,String p24,String p25) {
        initProperties();
        document = new XWPFDocument();

        //file name here

        fileName = filen;
        ///all data
        String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25;



        ///
        String subfolder=filen;

        String formFinal="sameet";

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        fileName ="कलम_५५_" +fileName +".docx";
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/PCM_APP/"+subfolder);
            myDir.mkdirs();
            file = new File(myDir, fileName);
            if (file.exists()) {
                MessageHelper.showCustomToastSuccess(context,inflator,"Please wait updating "+fileName+". . . ");
                file.delete();
            }
            out = new FileOutputStream(file);

            ////logo and address
            XWPFTable tabletemp = DocumentContainer.get(context).getDocument().createTable();
            tabletemp.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);
            CTTblWidth widthTable = tabletemp.getCTTbl().addNewTblPr().addNewTblW();
            widthTable.setType(STTblWidth.DXA);
            widthTable.setW(BigInteger.valueOf(10000));

            //create first row left
            XWPFTableRow tableRowOnetemp = tabletemp.getRow(0);
            CTTblWidth cellwidth1=tableRowOnetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW();
            cellwidth1.setW(BigInteger.valueOf(5000));
            cellwidth1.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp = tableRowOnetemp.getCell(0).addParagraph().createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            runRowOnetemp.addPicture(imageFile, format, "logo.png", Units.toEMU(100), Units.toEMU(100));

            //create first row right
            tableRowOnetemp.createCell();
            CTTblWidth cellwidth2=tableRowOnetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW();
            cellwidth2.setW(BigInteger.valueOf(5000));
            cellwidth2.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp2 = tableRowOnetemp.getCell(1).addParagraph().createRun();
            runRowOnetemp2.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी पुणे – "+p23);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("कार्यकारी अभियंता तथा पदनिर्देशित अधिकारी");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("बांधकाम परवानगी  व अनधिकृत बांधकाम नियंत्रण विभाग ");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("जवाक - "+p1);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("दिनांक -"+ p3+"       ");

            XWPFRun addRun = DocumentContainer.get(context).getDocument().createParagraph().createRun();


            ///

/*

            XWPFParagraph paragraph2 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            paragraph2.setAlignment(ParagraphAlignment.LEFT);

            run2.addPicture(imageFile, format, "logo.png", Units.toEMU(30), Units.toEMU(30));
            //

            //
            XWPFParagraph paragraph = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.RIGHT);

            run.setText("पिंपरी चिंचवड महानगरपालिका");
            run.addBreak();
            run.setText("पिंपरी पुणे –   "+p23);
            run.addBreak();
            run.setText("बांधकाम परवानगी  व अनधिकृत");
            run.addBreak();
            run.setText("बांधकाम नियंत्रण विभाग       ");
            run.addBreak();
            run.setText(p1);
            run.addBreak();
            run.setText("दिनांक -"+ p3+"          ");
            run.addBreak();

            //


 */


            //
            XWPFParagraph paragraph3 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);

            run3.setText("परिशिष्ट-६");
            run3.addBreak();
            run3.setText("महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ कलम ५५ अन्वये नोटीस");
            //

            //
            XWPFParagraph paragraph4 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.LEFT);


            run4.setText("प्रति,");
            run4.addBreak();
            run4.setText("मालक / विकसक / ऑक्युपायर :-");
            run4.addBreak();
            run4.setText(p4+" "+filen);
            run4.addBreak();
            run4.setText("पत्ता :- "+p6);
            run4.addBreak();
                //

            //
            XWPFParagraph paragraph5 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.LEFT);


            run5.setText("          ज्या अर्थी खाली सही करणा-यास महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ चे कलम ५५" +
                    " अन्वये कारवाई करणेचे अधिकार महाराष्ट्र प्रादेशिक नगररचना अधिनियम १९६६ अन्वये प्रदान केलेले आहेत.");
            run5.addBreak();
            run5.setText("       आणि ज्या अर्थी माझे असे निदर्शनास आले आहे की तुम्ही खालीलप्रमाणे अनधिकृत/विनापरवाना बांधकाम/विकास केला आहे. त्याअर्थी या  " +
                    "नोटीसद्वारे सदरचे तात्पुरते स्वरुपाचे बांधकाम ही नोटीस मिळालेपासून" +
                    ""+p25+" "+p24+" आत हलविण्याचा / काढून टाकणेचा आदेश देणेत येत आहे. तसेच सदरच्या बांधकामाचा/जमिनीचा अनधिकृत वापर तात्काळ थांबविणेचा आदेश देणेत येत आहे.");
            run5.addBreak();
            run5.setText("         या नोटीशीप्रमाणे तुम्ही अनधिकृत बांधकाम/विकास काढून टाकले नाही तर सदरचे बांधकाम/विकास प्राप्त अधिकाराचा " +
                    "वापर करून तुमचे जबाबदारीवर व खर्चाने काढून टाकणेत येवून येणारा खर्च तुमचेकडून वसूल केला जाईल.   ");
            run5.addBreak();
            run5.addBreak();
            run5.setText(" सदरच्या अनधिकृत/अनियमित बांधकाम/विकास याची माहिती पुढील प्रमाणे-");
            run5.addBreak();

            run5.setText( "     १) गाव    -  " + p7  );
            run5.addBreak();
            run5.setText("      २) ठिकाण -  " + p8  );
            run5.addBreak();
            run5.setText("      ३) स.नं.  -  " + p9 );
            run5.addBreak();
            run5.setText("      ४) अंदाजे क्षेत्र -  " + p10  );
            run5.addBreak();
            run5.addBreak();
            run5.setText("अंदाजे मोजमाप - "+p12+" मी. X "+p13+" मी. X "+p14+" मजले = "+p15+" चौ.मी.");
            run5.addBreak();
            run5.addBreak();
            run5.setText(" ५)  अनधिकृत बांधकामाची चतु:सिमा :- " );
            run5.addBreak();
            run5.setText("     पूर्वेस     –   "+p16);
            run5.addBreak();
            run5.setText( "    पश्चिमेस   –   "+p17);
            run5.addBreak();
            run5.setText( "    दक्षिणेस   –   "+p18);
            run5.addBreak();
            run5.setText("     उत्तरेस    –   "+p19);
            run5.addBreak();
            run5.addBreak();
            run5.setText("दिनांक  -" + p21);
            run5.addBreak();
            run5.setText("ठिकाण - " + p20);
            run5.addBreak();
            run5.addBreak();
            run5.addBreak();

            //
            XWPFParagraph paragraph6 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            paragraph6.setAlignment(ParagraphAlignment.RIGHT);

            run6.addBreak();
            run5.addBreak();
            run6.setText( "पदनिर्देशित अधिकारी तथा कार्यकारी अभियंता  ");

            XWPFParagraph paragraph7 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run7 = paragraph7.createRun();
            paragraph7.setAlignment(ParagraphAlignment.RIGHT);
            run7.setText("क्षेत्रिय कार्यालय (‘"+p22+" ’)");


            XWPFParagraph paragraph8 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            paragraph8.setAlignment(ParagraphAlignment.RIGHT);
            run8.setText("बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग");

            XWPFParagraph paragraph9 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            paragraph9.setAlignment(ParagraphAlignment.RIGHT);
            run9.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी, पुणे– "+p23);


            //


            //




            return true;
        } catch (InvalidFormatException | IOException e) {
            MessageHelper.showCustomToastError(context,inflator,"Please Enable Permissions from settings");

            e.printStackTrace();
            return false;
        }
    }


    //end4from

    ///5rdform

    public static boolean openDocument5(Context context, LayoutInflater inflator,InputStream imageFile, String filen,String p1,
                                        String p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,
                                        String g2,String g3,String g4,String g5,String g6,String g7,String g8,String g9,String g10,String g11,String g12) {
        initProperties();
        document = new XWPFDocument();

        //file name here

        fileName = filen;
        ///all data
        String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25;



        ///
        String subfolder=filen;

        String formFinal="sameet";

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        fileName ="FIR_"+ fileName +".docx";
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/PCM_APP/"+subfolder);
            myDir.mkdirs();
            file = new File(myDir, fileName);
            if (file.exists()) {
                MessageHelper.showCustomToastSuccess(context,inflator,"Please wait updating "+fileName+". . . ");
                file.delete();
            }
            out = new FileOutputStream(file);

            ////logo and address
            XWPFTable tabletemp = DocumentContainer.get(context).getDocument().createTable();
            tabletemp.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);
            CTTblWidth widthTable = tabletemp.getCTTbl().addNewTblPr().addNewTblW();
            widthTable.setType(STTblWidth.DXA);
            widthTable.setW(BigInteger.valueOf(10000));

            //create first row left
            XWPFTableRow tableRowOnetemp = tabletemp.getRow(0);
            CTTblWidth cellwidth1=tableRowOnetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW();
            cellwidth1.setW(BigInteger.valueOf(5000));
            cellwidth1.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp = tableRowOnetemp.getCell(0).addParagraph().createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            runRowOnetemp.addPicture(imageFile, format, "logo.png", Units.toEMU(100), Units.toEMU(100));

            //create first row right
            tableRowOnetemp.createCell();
            CTTblWidth cellwidth2=tableRowOnetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW();
            cellwidth2.setW(BigInteger.valueOf(5000));
            cellwidth2.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp2 = tableRowOnetemp.getCell(1).addParagraph().createRun();
            runRowOnetemp2.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी पुणे – "+p9);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("कार्यकारी अभियंता तथा पदनिर्देशित अधिकारी");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("बांधकाम परवानगी  व अनधिकृत बांधकाम नियंत्रण विभाग ");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("जवाक - "+p1);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("दिनांक -"+ p2+"       ");


            XWPFRun addRun = DocumentContainer.get(context).getDocument().createParagraph().createRun();


            ///



            //
            XWPFParagraph paragraph4 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.LEFT);


            run4.setText("प्रति,");
            run4.addBreak();
            run4.setText("मा.पोलिस निरीक्षक :-");
            run4.addBreak();
            run4.setText(p3);
            run4.addBreak();
            run4.setText("पिंपरी चिंचवड, पुणे.");
            run4.addBreak();

            //




            //
            XWPFParagraph paragraph3 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);

            run3.setText("        विषय -  महाराष्ट्र महानगरपालिका अधिनियम २०१२ (जुना मुंबई प्रांतिक महानगरपालिका  अधिनियम १९४९) चे कलम ३९७ अ (१) (ब) प्रमाणेफिर्याद.");
            run3.addBreak();
            run3.addBreak();
            run3.setText("  फिर्यादी -  पदनिर्देशित अधिकारी तथा उप अभियंता "+p4);
            //

            //
            XWPFParagraph paragraph5 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.LEFT);

            run5.setText("महोदय,");
            run5.addBreak();
            run5.setText("                   मी "+p4+" पिंपरी चिंचवड महानगरपालिकेमध्ये पदनिर्देशित अधिकारी तथा " +
                    " उप अभियंता या पदावर लोकसेवक म्हणून कार्यरत आहे. माझ्याकडे प्रभाग क्र. "+p8+" या विभागाचा कार्यभाग आहे.");
            run5.addBreak();
            run5.addBreak();
            run5.setText("मालक / भोगवटादार / ऑक्युपायर / विकसक - "+filen);
            run5.addBreak();
            run5.setText("पत्ता- "+g2);
            run5.addBreak();
            run5.setText("अनधिकृत बांधकामाचे वर्णन -"+g3);
            run5.addBreak();
            run5.setText(" सदरच्या अनधिकृत/अनियमित बांधकाम/विकास याची माहिती पुढील प्रमाणे-");
            run5.addBreak();
            run5.setText("अनधिकृत बांधकामाचे अंदाजे क्षेत्रफळ – "+g4+" मी. X  "+g5+" मी.  X "+g6+" मजले = "+g7+" चौ.मी");
            run5.addBreak();
            run5.addBreak();
            run5.setText("चतु:सिमा :- " );
            run5.addBreak();
            run5.setText("     पूर्वेस     –   "+g8);
            run5.addBreak();
            run5.setText( "    पश्चिमेस   –   "+g9);
            run5.addBreak();
            run5.setText( "    दक्षिणेस   –   "+g10);
            run5.addBreak();
            run5.setText("     उत्तरेस    –   "+g11);
            run5.addBreak();
            run5.addBreak();
            run5.setText("              या चतु: सिमा असलेले बांधकाम महाराष्ट्र महानगरपालिका अधिनियम २०१२, महाराष्ट्र प्रादेशिक व नगररचना अधिनियम १९६६ व " +
                    "जुना मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९,  तसेच पिंपरी  चिंचवड महानगरपालिकेच्या विकास नियंत्रण नियमावलीतील तरतुदीनुसार " +
                    "बांधकामाची परवानगी न घेता अनधिकृतपणे इमारतीचे बांधकाम  चालू केलेले आहे. त्यामुळे महाराष्ट्र महानगरपालिका अधिनियम २०१२ चे कलम ४७८" +
                    "(१) व कलम ४३३ (जुना मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९ ) अन्वये सदर अनधिकृत बांधकामास    दि. "+g12+" रोजी  नोटीस दिलेली आहे.");
            run5.addBreak();
            run5.setText("              सदर नोटीसीस अनुसरुन "+filen+" यांनी चालु असलेल्या बांधकामास महानगरपालिकेची परवानगी घेतली असल्याबाबतचा लेखी पुरावा नोटीसीचा " +
                    "कालावधी संपुनही नोटीस दिलेल्या पदनिर्देशीत अधिकारी यांचेकडे सादर केलेला नाही व नमूद केलेल्या नोटीसीनुसार अनधिकृत बांधकाम हलविणे अथवा पाडून टाकणेचे " +
                    "अनुपालन न केल्याने तसेच बांधकाम विकास पुढे चालू ठेवून सदर आरोपीने महाराष्ट्र महानगरपालिका अधिनियम २०१२ (मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९)" +
                    " चे कलम ३९७ अ (१) (ब) याप्रमाणे गंभीर गुन्हा केलेला आहे.");
            run5.addBreak();
            run5.setText("               तरी "+filen+" यांनी नोटीसीनुसार अनधिकृत बांधकाम हटविणे अथवा पाडून टाकणेचे अनुपालन न केल्याने तसेच बांधकाम विकास पूर्ण करून वापर चालू " +
                    "ठेवल्याने माझी यांचे विरुध्द फिर्याद असून मेहेरबानास विंनती की, महाराष्ट्र महानगरपालिका अधिनियम २०१२ ( मुंबई प्रांतिक महानगरपालिका अधिनियम १९४९ ) चे कलम " +
                    "३९७ अ (१) (ब)  नुसार गुन्हा दाखल करण्यात यावा.");
            run5.addBreak();
            run5.addBreak();
            run5.addBreak();
            run5.setText("सोबत -");
            run5.addBreak();
            run5.setText("१. पंचनामा मूळ प्रत                                                         पदनिर्देशित अधिकारी तथा उप अभियंता ");
            run5.addBreak();
            run5.setText("२. नोटीसीची मूळ प्रत                                                        पिंपरी चिंचवड महानगरपालिका, पिंपरी "+p9+" ");
            run5.addBreak();
            run5.setText("३. फोटोग्राफची मूळ प्रत ");
            run5.addBreak();
            run5.setText("४. मिळकत कर बिल प्रत ");
            run5.addBreak();
            run5.setText("५. दि.१७/०६/२०१५ आदेशाची प्रत ");

            run5.addBreak();
            run5.addBreak();
            run5.addBreak();

            //






            return true;
        } catch (InvalidFormatException | IOException e) {
            MessageHelper.showCustomToastError(context,inflator,"Please Enable Permissions from settings");

            e.printStackTrace();
            return false;
        }
    }


    //6from

    public static boolean openDocument6(Context context, LayoutInflater inflator,InputStream imageFile, String filen,String p1,
                                        String p2,String p3,String p4,String p5,String p6,String p7,String p8,String p9,
                                        String g2,String g3,String g4,String g5,String g6,String g7,String g8,String g9,String g10,String g11,String g15,String g25) {
        initProperties();
        document = new XWPFDocument();

        //file name here

        fileName = filen;
        ///all data
        String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,s20,s21,s22,s23,s24,s25;



        ///
        String subfolder=filen;

        String formFinal="sameet";

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        fileName ="Evacuation_"+ fileName +".docx";
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/PCM_APP/"+subfolder);
            myDir.mkdirs();
            file = new File(myDir, fileName);
            if (file.exists()) {
                MessageHelper.showCustomToastSuccess(context,inflator,"Please wait updating "+fileName+". . . ");
                file.delete();
            }
            out = new FileOutputStream(file);

            ////logo and address
            XWPFTable tabletemp = DocumentContainer.get(context).getDocument().createTable();
            tabletemp.getCTTbl().getTblPr().getTblBorders().getLeft().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getRight().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getTop().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getBottom().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideH().setVal(STBorder.NONE);
            tabletemp.getCTTbl().getTblPr().getTblBorders().getInsideV().setVal(STBorder.NONE);
            CTTblWidth widthTable = tabletemp.getCTTbl().addNewTblPr().addNewTblW();
            widthTable.setType(STTblWidth.DXA);
            widthTable.setW(BigInteger.valueOf(10000));

            //create first row left
            XWPFTableRow tableRowOnetemp = tabletemp.getRow(0);
            CTTblWidth cellwidth1=tableRowOnetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW();
            cellwidth1.setW(BigInteger.valueOf(5000));
            cellwidth1.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp = tableRowOnetemp.getCell(0).addParagraph().createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            runRowOnetemp.addPicture(imageFile, format, "logo.png", Units.toEMU(100), Units.toEMU(100));

            //create first row right
            tableRowOnetemp.createCell();
            CTTblWidth cellwidth2=tableRowOnetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW();
            cellwidth2.setW(BigInteger.valueOf(5000));
            cellwidth2.setType(STTblWidth.DXA);
            XWPFRun runRowOnetemp2 = tableRowOnetemp.getCell(1).addParagraph().createRun();
            runRowOnetemp2.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी पुणे – "+g15);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("कार्यकारी अभियंता तथा पदनिर्देशित अधिकारी");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("बांधकाम परवानगी  व अनधिकृत बांधकाम नियंत्रण विभाग ");
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("जवाक - "+p1);
            runRowOnetemp2.addBreak();
            runRowOnetemp2.setText("दिनांक -"+ p2+"          ");

            XWPFRun addRun = DocumentContainer.get(context).getDocument().createParagraph().createRun();


            ///

/*

            XWPFParagraph paragraph2 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            paragraph2.setAlignment(ParagraphAlignment.LEFT);
            run2.addPicture(imageFile, format, "logo.png", Units.toEMU(100), Units.toEMU(100));
            //


            //
            XWPFParagraph paragraph = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.RIGHT);

            run.setText("पिंपरी चिंचवड महानगरपालिका");
            run.addBreak();
            run.setText("पिंपरी पुणे –   "+g15);
            run.addBreak();
            run.setText("बांधकाम परवानगी  व अनधिकृत");
            run.addBreak();
            run.setText("बांधकाम नियंत्रण विभाग       ");
            run.addBreak();
            run.setText(p1);
            run.addBreak();
            run.setText("दिनांक -"+ p2+"          ");
            run.addBreak();

            //


 */


            //
            XWPFParagraph paragraph7 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run7 = paragraph7.createRun();
            paragraph7.setAlignment(ParagraphAlignment.CENTER);

            run7.setText("सूचना");
            run7.addBreak();
            run7.setText("बांधकाम वापर निर्वासन बाबत सूचना ( Evacuation Notice )"+p4);
            //


            //
            XWPFParagraph paragraph4 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run4 = paragraph4.createRun();
            paragraph4.setAlignment(ParagraphAlignment.LEFT);


            run4.setText("प्रति,");
            run4.addBreak();
            run4.setText("मालक / विकसक / ऑक्युपायर :-");
            run4.addBreak();
            run4.setText("श्री.-"+filen);
            run4.addBreak();
            run4.setText("पत्ता :- "+g2);
            run4.addBreak();

            //

            //
            XWPFParagraph paragraph3 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            paragraph3.setAlignment(ParagraphAlignment.CENTER);

            run3.setText("संदर्भ – इकडील नोटीस "+p3+" दिनांक- "+p2);
            run3.addBreak();
                     //



            //
            XWPFParagraph paragraph5 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run5 = paragraph5.createRun();
            paragraph5.setAlignment(ParagraphAlignment.LEFT);
            run5.setText("         महाराष्ट्र महानगरपालिका अधिनियम २०१२चे कलम ४७८ (१), कलम ४३३ (क) अन्वये सूचना देण्यात येते की," +
                    " तुम्ही पिंपरी चिंचवड महानगरपालिकेची बांधकाम परवानगी  न घेता खालील नमुद बिगर परवाना / अनाधिकृत बांधकामामध्ये " +
                    "मालकी हक्काने/ अन्य अधिकाराने रहिवासी व्यावसायिक वास्तव्य/ वापर (ऑक्युपाय) करत असल्याचे निदर्शनास आले आहे." +
                    " सदर बिगरपरवाना/अनाधिकृत बांधकामांची माहिती खालीलप्रमाणे.");
            run5.addBreak();
            run5.setText("गाव/मौजे   -  "+p4+"/"+p5+"स.नं.- "+p6);
            run5.addBreak();
            run5.setText("अबांधकामाचे क्षेत्रफळ अंदाजे - "+g4+" मी. X "+g5+" मी. X "+g6+" मजले = "+g7+" चौ.मी.");
            run5.addBreak();
            run5.setText("बांधकामाचा प्रकार – "+g3);
            run5.addBreak();
            run5.setText("चतु:सिमा :- " );
            run5.addBreak();
            run5.setText("     पूर्वेस     –   "+g8);
            run5.addBreak();
            run5.setText( "    पश्चिमेस   –   "+g9);
            run5.addBreak();
            run5.setText( "    दक्षिणेस   –   "+g10);
            run5.addBreak();
            run5.setText("     उत्तरेस    –   "+g11);
            run5.addBreak();
            run5.addBreak();
            run5.setText("          याबाबत आपल्यास संदर्भ क्र.१ अन्वये नोटीस देणेत आलेली आहे.त्याप्रमाणे आपण अनुपालन केलेले नाही." +
                    " सबब वर नमुद अनाधिकृत बांधकाम तुम्ही ही सूचना पोहोचल्यापासून "+p7+" "+p8+" आत काढून टाकावे/रिकामे करावे. वेळ प्रसंग पडल्यास प्रत्यक्ष कारवाईच्या वेळी सदरच्या " +
                    "बांधकामाची जागेवर भरतील ती व असतील ती मोजमापे, त्यासहचे संपूर्ण बांधकाम याप्रमाणे तुम्ही बिगरपरवाना बांधकाम काढून टाकण्याची/ रिकामी करण्याची व्यवस्था न " +
                    " केल्यास ते बांधकाम आम्ही काढून टाकू. त्याबाबत होणारा खर्च तुमच्याकडून वसूल करण्यात येईल. तसेच सदरच्या सुचनेवरती " +
                    "आपल्याकडील कोणताही खुलासा / पत्र ग्राह्य धरता येणार नाही.");
            run5.addBreak();
            run5.setText("        सदरचे अनधिकृत बिगरपरवाना बांधकामाबाबत महाराष्ट्र महानगरपालिका अधिनियम २०१२ चे कलम २६१, २६४, २६७ आणि ४७८ मधील तरतुदी नुसार " +
                    "मा.आयुक्त यांचे आदेशक्र. अति/३/कावि/१००/२०१२ दि.१६/६/२०१२ अन्वये पदनिर्देशित अधिकारी म्हणुन कारवाई करण्याचे अधिकार आम्हाला आहेत, याची नोंद घ्यावी. कळावे.");
            run5.addBreak();
            run5.addBreak();

            //
            XWPFParagraph paragraph6 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run6 = paragraph6.createRun();
            paragraph6.setAlignment(ParagraphAlignment.RIGHT);
            run6.setText( "पदनिर्देशित अधिकारी तथा कार्यकारी अभियंता  ");

            XWPFParagraph paragraph11 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run11 = paragraph11.createRun();
            paragraph11.setAlignment(ParagraphAlignment.RIGHT);
            run11.setText("क्षेत्रिय कार्यालय (‘"+p9+" ’)");


            XWPFParagraph paragraph8 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run8 = paragraph8.createRun();
            paragraph8.setAlignment(ParagraphAlignment.RIGHT);
            run8.setText("बांधकाम परवानगी व अनधिकृत बांधकाम नियंत्रण विभाग");

            XWPFParagraph paragraph9 = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run9 = paragraph9.createRun();
            paragraph9.setAlignment(ParagraphAlignment.RIGHT);
            run9.setText("पिंपरी चिंचवड महानगरपालिका, पिंपरी, पुणे– "+g15);


            //







            return true;
        } catch (InvalidFormatException | IOException e) {
            MessageHelper.showCustomToastError(context,inflator,"Please Enable Permissions from settings");

            e.printStackTrace();
            return false;
        }
    }


    //end6from


    //7from

    public static boolean openDocument7(Context context, LayoutInflater inflator,InputStream imageFile, String filen,String p1) {
        initProperties();
        document = new XWPFDocument();

        //file name here

        fileName = filen;
        ///all data




        ///
        String subfolder=filen;

        String formFinal="sameet";

        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        fileName ="डी_सी_आर_ता_"+ fileName +".docx";
        try {
            String root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString();
            File myDir = new File(root + "/PCM_APP/"+subfolder);
            myDir.mkdirs();
            file = new File(myDir, fileName);
            if (file.exists()) {
                MessageHelper.showCustomToastSuccess(context,inflator,"Please wait updating "+fileName+". . . ");
                file.delete();
            }
            out = new FileOutputStream(file);


            XWPFParagraph paragraph = DocumentContainer.get(context).getDocument().createParagraph();
            XWPFRun run = paragraph.createRun();
            paragraph.setAlignment(ParagraphAlignment.CENTER);

            run.setText("  डी.सी.आर.ता. "+p1);
            run.addBreak();
            run.setFontFamily("Calibri (Body)");
            // run.setBold(true);
            run.addBreak();
            run.setBold(true);
            run.setFontSize(14);




            return true;
        } catch (IOException e) {
            MessageHelper.showCustomToastError(context,inflator,"Please Enable Permissions from settings");

            e.printStackTrace();
            return false;
        }
    }


    //end7from



    public static void closeDocument() {
        try {
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void scanMedia(Context context) {
        MediaScannerConnection.scanFile(context, new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });
    }

    public static void saveReportExternally(final Context context, final LayoutInflater inflater) {
        try {

            DocumentContainer.get(context).getDocument().write(out);
            DocumentContainer.closeDocument();
            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    MessageHelper.showCustomToastSuccess(context, inflater, fileName + " written successfully");
                }
            });

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DocumentContainer.scanMedia(context);

    }





    public static void DocTable(Context context, String p1,String p2,String p3,String p4,String p6,String p7,
                                          String p8,String g1,String g2,String g4,String g5,String g6,String g7,
                                          String g13,String g14,String g15,String g16,String g17,String g22,String g23,String g24,String g25,String g28) {//bike share table formating


        XWPFTable tabletemp = DocumentContainer.get(context).getDocument().createTable();


        CTTblWidth widthTable = tabletemp.getCTTbl().addNewTblPr().addNewTblW();
        widthTable.setType(STTblWidth.DXA);
        widthTable.setW(BigInteger.valueOf(10000));


        //create first row
        XWPFTableRow tableRowOnetemp = tabletemp.getRow(0);
        CTTblWidth cellwidth1=tableRowOnetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW();
        cellwidth1.setW(BigInteger.valueOf(5000));
        cellwidth1.setType(STTblWidth.DXA);

        XWPFRun runRowOnetemp = tableRowOnetemp.getCell(0).addParagraph().createRun();
        runRowOnetemp.setText("१) पोलीस स्टेशन ");
        tableRowOnetemp.setHeight(10);



        tableRowOnetemp.createCell();
        CTTblWidth cellwidth2=tableRowOnetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW();
        cellwidth2.setW(BigInteger.valueOf(5000));
        cellwidth2.setType(STTblWidth.DXA);


        XWPFRun runRowOnetemp2 = tableRowOnetemp.getCell(1).addParagraph().createRun();
        runRowOnetemp2.setText(g25+ " पिंपरी चिंचवड. ");
      ///  runRowOnetemp2.setFontSize(12);

        //create second row
        XWPFTableRow tableRowTwotemp = tabletemp.createRow();
        tableRowTwotemp.getCell(0).setText("२) गु. र. नं. ");
        tableRowTwotemp.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
        tableRowTwotemp.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
       /// tableRowTwotemp.setHeight(10);



        XWPFRun runRowTwotemp2 = tableRowTwotemp .getCell(1).addParagraph().createRun();
        runRowTwotemp2.setText(p2);


        //create third row
        XWPFTableRow tableRowThreetemp = tabletemp.createRow();
        tableRowThreetemp.getCell(0).setText("३)  कलम  ");
        tableRowThreetemp.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
        tableRowThreetemp.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));

        XWPFRun runRowTwotemp3 = tableRowThreetemp .getCell(1).addParagraph().createRun();
        runRowTwotemp3.setText(" महराष्ट्र महानगरपालिका अधिनियम १९४९ चे कलम ३४७ (१)(अ) ब ");

        //create 4 row
        XWPFTableRow t4 = tabletemp.createRow();
        t4.getCell(0).setText("४) फिर्यादी नाव पत्ता  ");
        t4.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
        t4.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));

        XWPFRun r4 = t4.getCell(1).addParagraph().createRun();
        r4.setText(g13 +", वय - "+g14+" , वर्षे व्यवसाय - नोकरी - उप अभियंता पिंपरी चिंचवड महानगरपालिका पिंपरी , पुणे," +
                ""+g17+", पुणे- "+g15+". मो.नं - "+g16);

        //create 5 row
        XWPFTableRow t5 = tabletemp.createRow();
        t5.getCell(0).setText("५ | आरोपी नाव व पत्ता ");
        t5.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
        t5.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));

        XWPFRun r5 = t5.getCell(1).addParagraph().createRun();
        r5.setText(" श्री. "+g1+", पत्ता- स. नं. "+p3+","+g2+", पुणे- "+g15);

        //create 6 row
        XWPFTableRow t6 = tabletemp.createRow();
        t6.getCell(0).setText("६ | आरोपी अटक ता.वेळ");
        t6.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
        t6.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));

        XWPFRun r6 = t6.getCell(1).addParagraph().createRun();
        r6.setText(" नाही ");

        //create 7 row
        XWPFTableRow t7 = tabletemp.createRow();
        t7.getCell(0).setText("७ | पाहिजे आरोपी ");
        t7.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
        t7.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));

        XWPFRun r7 = t7.getCell(1).addParagraph().createRun();
        r7.setText("   ");


        //create 8 row
        XWPFTableRow t8 = tabletemp.createRow();
        t8.getCell(0).setText("८ | गु.घडला ता.वेळ ठिकाण  ");
        t8.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t8.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r8 = t8.getCell(1).addParagraph().createRun();
        r8.setText(" दि."+p1+", वेळ – "+p4+" वाजता,  स. नं. "+p3+", "+g2+", पुणे-"+g15);


        //create 9 row
        XWPFTableRow t9 = tabletemp.createRow();
        t9.getCell(0).setText("९ | गु.घडला ता.वे ठिकाण ");
        t9.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t9.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r9 = t9.getCell(1).addParagraph().createRun();
        r9.setText(" दिनांक- "+p1+"   वा -"+p4);


        //create 10 row
        XWPFTableRow t10 = tabletemp.createRow();
        t10.getCell(0).setText("१० | विलंबाचे कारण ");
        t10.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t10.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r10 = t10.getCell(1).addParagraph().createRun();
        r10.setText("  फिर्यादी उशिरा आल्याने");

        //create 11 row
        XWPFTableRow t11 = tabletemp.createRow();
        t11.getCell(0).setText("११ | घटनास्थळ   ");
        t11.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t11.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));


        //changes to be done
        XWPFRun r11 = t11.getCell(1).addParagraph().createRun();
        r11.setText(" स.नं. -"+p3+","+g2+", पुणे-"+g15);


        //create 12 row
        XWPFTableRow t12 = tabletemp.createRow();
        t12.getCell(0).setText("१२ | दिशा व अंतर  ");
        t12.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t12.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r12 = t12.getCell(1).addParagraph().createRun();
        r12.setText(p6);


        //create 13 row
        XWPFTableRow t13 = tabletemp.createRow();
        t13.getCell(0).setText("१३ | गुन्हयाचे कारण  ");
        t13.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t13.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r13 = t13.getCell(1).addParagraph().createRun();
        r13.setText("स्वतःचा फायदा ");


        //create 14 row
        XWPFTableRow t14 = tabletemp.createRow();
        t14.getCell(0).setText("१४ | गुन्ह्यात वापरलेले हत्यार   ");
        t14.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t14.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r14 = t14.getCell(1).addParagraph().createRun();
        r14.setText(" निरंक ");


        //create 15 row
        XWPFTableRow t15 = tabletemp.createRow();
        t15.getCell(0).setText("१५ | गुन्ह्यात हस्तगर हत्यार  ");
        t15.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t15.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r15 = t15.getCell(1).addParagraph().createRun();
        r15.setText("  निरंक ");


        //create 16 row
        XWPFTableRow t16 = tabletemp.createRow();
        t16.getCell(0).setText("१६ | गेला माल   ");
        t16.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t16.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r16 = t16.getCell(1).addParagraph().createRun();
        r16.setText(" निरंक");

        //create 17 row
        XWPFTableRow t17 = tabletemp.createRow();
        t17.getCell(0).setText("१७ | मिळाला माल ");
        t17.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t17.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r17 = t17.getCell(1).addParagraph().createRun();
        r17.setText(" निरंक निरंक");

        //create 18 row
        XWPFTableRow t18 = tabletemp.createRow();
        t18.getCell(0).setText("१८ | पिडीत व्यक्तीचे नाव  ");
        t18.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t18.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r18 = t18.getCell(1).addParagraph().createRun();
        r18.setText(" निरंक");

        //create 19 row
        XWPFTableRow t19 = tabletemp.createRow();
        t19.getCell(0).setText("१९ | मयताचे नाव  ");
        t19.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t19.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r19 = t19.getCell(1).addParagraph().createRun();
        r19.setText(" निरंक ");

        //create 20 row
        XWPFTableRow t20 = tabletemp.createRow();
        t20.getCell(0).setText("२० | जखमीचे नाव   ");
        t20.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t20.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r20 = t20.getCell(1).addParagraph().createRun();
        r20.setText("  निरंक");

        //create 21 row
        XWPFTableRow t21 = tabletemp.createRow();
        t21.getCell(0).setText("२१ | रुग्णालयाचे नाव ");
        t21.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t21.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r21 = t21.getCell(1).addParagraph().createRun();
        r21.setText("  निरंक");


        //create 22 row
        XWPFTableRow t22 = tabletemp.createRow();
        t22.getCell(0).setText("२२ | तपासी अधिकारी  ");
        t22.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t22.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r22 = t22.getCell(1).addParagraph().createRun();
        r22.setText("   ");

        //create 23 row
        XWPFTableRow t23 = tabletemp.createRow();
        t23.getCell(0).setText("२३ | दाखल अमलदार  ");
        t23.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t23.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r23 = t23.getCell(1).addParagraph().createRun();
        r23.setText(g25);

        //create 24 row
        XWPFTableRow t24 = tabletemp.createRow();
        t24.getCell(0).setText("२४ | प्रभारी अधिकारी  ");
        t24.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t24.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r24 = t24.getCell(1).addParagraph().createRun();
        r24.setText(p7+",वरिष्ठ पोलीस निरीक्षक,"+g25);
        r24.setFontSize(12);


        //create 25 row
        XWPFTableRow t25 = tabletemp.createRow();
        t25.getCell(0).setText("२५ | भेट देणारे अधिकारी  ");
        t25.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t25.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r25 = t25.getCell(1).addParagraph().createRun();
        r25.setText(p8+",पोलीस उप निरीक्षक,"+g25);

        //create 26 row
        XWPFTableRow t26 = tabletemp.createRow();
        t26.getCell(0).setText("२६ | थोडक्यात हकीकत  ");
        t26.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t26.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r26 = t26.getCell(1).addParagraph().createRun();
        r26.setText("  यातील फिर्यादी याची फिर्यादी कि,वर नमूद ता.वेळ व ठिकाणी यातील \n" +
                "आरोपी श्री. "+g1+",यांनी सदरची जागा मध्ये त्यांनी" +
                "बांधकामाकरिता पिंपरी चिंचवड महानगरपालिकेची परवानगी न घेता" +
                g4+" मी. X "+g5+" मी.X "+g6+" मजले = "+g7+" चौ.मी." +
                "बांधकाम विनापरवाना अनधिकृतपणे केले असल्याने फिर्यादी यांनी त्यांचे " +
                "विरुद्ध महाराष्ट्र महानगरपालिका अधिनियम१९४९चे कलम३९७ (१) (अ) (ब)" +
                "{clause 397A (1) (b)} अन्वये कायदेशीर दिली आहे." +
                "म्हणून वरील प्रमाणे गुन्हा दाखल आहे.");

        //create 27 row
        XWPFTableRow t27 = tabletemp.createRow();
        t27.getCell(0).setText("२७ | सध्याची परिस्थिती  ");
        t27.getCell(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));
        t27.getCell(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(5000));

        XWPFRun r27 = t27.getCell(1).addParagraph().createRun();
        r27.setText(" ");





        XWPFRun addRun = DocumentContainer.get(context).getDocument().createParagraph().createRun();
        addRun.addBreak();
    }


}