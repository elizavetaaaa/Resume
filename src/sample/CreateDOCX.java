package sample;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class CreateDOCX {

    public static void main(String[] args){
    }
   public  void creatDOCX(String name) {
        try {

            XWPFDocument document = new XWPFDocument();
            System.out.println("1 done");
            FileOutputStream out = new FileOutputStream(new File("/home/elizaveta/Desktop/" +name +".docx"));
            System.out.println("2 done");
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Welcome to my channel. Chillyfacts.com created word document. Test test");

            document.write(out);
            out.close();
            System.out.println("createparagraph.docx written successfully");
        } catch (Exception e) {
            System.out.println("something wrong");
            // TODO: handle exception
        }}}


