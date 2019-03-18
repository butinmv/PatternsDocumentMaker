package itext.test;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;

public class ImagePdf {

    public static final String DEST = "results/chapter01/ImageInPdf.pdf";
    public static final String FOX = "src/main/resources/fox.png";
    public static final String DOG = "src/main/resources/dog.png";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ImagePdf().createPdf(DEST);
    }

    private void createPdf(String dest) throws IOException {
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Image fox = new Image(ImageDataFactory.create(FOX));
        Image dog = new Image(ImageDataFactory.create(DOG));


        Paragraph p = new Paragraph("The quick brown ")
                .add(fox)
                .add(" jump over the lazy ")
                .add(dog);
        document.add(p);

        document.close();
    }

}
