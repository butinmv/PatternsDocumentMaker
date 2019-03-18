package itext.test;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class DataBase {

    public static final String DEST = "results/chapter01/DataBase.pdf";
    public static final String DATA = "src/main/resources/database.csv";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new DataBase().createPdf(DEST);
    }

    private void createPdf(String dest) throws IOException {

        PdfWriter writer = new PdfWriter(dest);

        PdfDocument pdf = new PdfDocument(writer);

        Document document = new Document(pdf, PageSize.A4.rotate());
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        Table table = new Table(new float[]{4, 1, 3, 4, 4, 4, 4, 4, 1});
        table.setWidthPercent(100);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(DATA));
        String line = bufferedReader.readLine();
        process(table, line, bold, true);
        while ((line = bufferedReader.readLine()) != null) {
            process(table, line, font, false);
        }
        bufferedReader.close();
        document.add(table);

        document.close();
    }

    private void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreElements()) {
            if (isHeader) {
                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            } else {
                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            }
        }
    }

}
