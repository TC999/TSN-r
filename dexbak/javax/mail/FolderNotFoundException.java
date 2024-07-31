package javax.mail;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class FolderNotFoundException extends MessagingException {
    private static final long serialVersionUID = 472612108891249403L;
    private transient Folder folder;

    public FolderNotFoundException() {
    }

    public Folder getFolder() {
        return this.folder;
    }

    public FolderNotFoundException(Folder folder) {
        this.folder = folder;
    }

    public FolderNotFoundException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }

    public FolderNotFoundException(String str, Folder folder) {
        super(str);
        this.folder = folder;
    }
}
