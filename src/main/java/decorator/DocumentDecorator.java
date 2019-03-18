package decorator;

import document.CusomDocument;

import java.util.ArrayList;

public class DocumentDecorator extends CusomDocument {

    private CusomDocument wrappee;

    public DocumentDecorator(CusomDocument wrappee) {
        this.wrappee = wrappee;
    }

    public boolean save(CusomDocument document) {
        wrappee.save(document);
        ListTemplates.add(document);
        return true;
    }
}
