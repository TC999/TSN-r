package javax.mail.event;

import javax.mail.Folder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class FolderEvent extends MailEvent {
    public static final int CREATED = 1;
    public static final int DELETED = 2;
    public static final int RENAMED = 3;
    private static final long serialVersionUID = 5278131310563694307L;
    protected transient Folder folder;
    protected transient Folder newFolder;
    protected int type;

    public FolderEvent(Object obj, Folder folder, int i4) {
        this(obj, folder, folder, i4);
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i4 = this.type;
        if (i4 == 1) {
            ((FolderListener) obj).folderCreated(this);
        } else if (i4 == 2) {
            ((FolderListener) obj).folderDeleted(this);
        } else if (i4 == 3) {
            ((FolderListener) obj).folderRenamed(this);
        }
    }

    public Folder getFolder() {
        return this.folder;
    }

    public Folder getNewFolder() {
        return this.newFolder;
    }

    public int getType() {
        return this.type;
    }

    public FolderEvent(Object obj, Folder folder, Folder folder2, int i4) {
        super(obj);
        this.folder = folder;
        this.newFolder = folder2;
        this.type = i4;
    }
}
