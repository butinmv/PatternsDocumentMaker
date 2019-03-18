package document;

public abstract class CusomDocument {
    public boolean open() {
        return true;
    }

    public abstract boolean save(CusomDocument document);

    public boolean close(CusomDocument document) {
        return true;
    }
}
