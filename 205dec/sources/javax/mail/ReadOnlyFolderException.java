package javax.mail;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
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
