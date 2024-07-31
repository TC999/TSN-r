package javax.mail;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class FolderClosedException extends MessagingException {
    private static final long serialVersionUID = 1687879213433302315L;
    private transient Folder folder;

    public FolderClosedException(Folder folder) {
        this(folder, null);
    }

    public Folder getFolder() {
        return this.folder;
    }

    public FolderClosedException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }
}
