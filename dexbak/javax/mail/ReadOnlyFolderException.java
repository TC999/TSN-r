package javax.mail;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ReadOnlyFolderException extends MessagingException {
    private static final long serialVersionUID = 5711829372799039325L;
    private transient Folder folder;

    public ReadOnlyFolderException(Folder folder) {
        this(folder, null);
    }

    public Folder getFolder() {
        return this.folder;
    }

    public ReadOnlyFolderException(Folder folder, String str) {
        super(str);
        this.folder = folder;
    }
}
