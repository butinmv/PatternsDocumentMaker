package decorator;

import document.CusomDocument;

import java.util.ArrayList;

public class ListTemplates {
    private static ArrayList<CusomDocument> listOfTemplate = new ArrayList<CusomDocument>();

    public static void add(CusomDocument document) {
        listOfTemplate.add(document);
    }
}
