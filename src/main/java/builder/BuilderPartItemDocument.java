package builder;

import document.PartItemDocument;

public interface BuilderPartItemDocument {
    PartItemDocument createHeader(String text);
    PartItemDocument createItem(String text);
}
