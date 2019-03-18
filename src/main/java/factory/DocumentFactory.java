package factory;

import document.CusomDocument;
import document.PdfCustomDoucment;

public class DocumentFactory {

    public static CusomDocument createPdf(String name) {
        return new PdfCustomDoucment();
    }

    public static CusomDocument createWord(String name) {
        return null;
    }

}


