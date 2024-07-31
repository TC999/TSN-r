package javax.mail;

import java.util.Vector;
import javax.mail.event.FolderEvent;
import javax.mail.event.FolderListener;
import javax.mail.event.StoreEvent;
import javax.mail.event.StoreListener;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class Store extends Service {
    private volatile Vector folderListeners;
    private volatile Vector storeListeners;

    /* JADX INFO: Access modifiers changed from: protected */
    public Store(Session session, URLName uRLName) {
        super(session, uRLName);
        this.storeListeners = null;
        this.folderListeners = null;
    }

    public synchronized void addFolderListener(FolderListener folderListener) {
        if (this.folderListeners == null) {
            this.folderListeners = new Vector();
        }
        this.folderListeners.addElement(folderListener);
    }

    public synchronized void addStoreListener(StoreListener storeListener) {
        if (this.storeListeners == null) {
            this.storeListeners = new Vector();
        }
        this.storeListeners.addElement(storeListener);
    }

    public abstract Folder getDefaultFolder() throws MessagingException;

    public abstract Folder getFolder(String str) throws MessagingException;

    public abstract Folder getFolder(URLName uRLName) throws MessagingException;

    public Folder[] getPersonalNamespaces() throws MessagingException {
        return new Folder[]{getDefaultFolder()};
    }

    public Folder[] getSharedNamespaces() throws MessagingException {
        return new Folder[0];
    }

    public Folder[] getUserNamespaces(String str) throws MessagingException {
        return new Folder[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyFolderListeners(int i, Folder folder) {
        if (this.folderListeners == null) {
            return;
        }
        queueEvent(new FolderEvent(this, folder, i), this.folderListeners);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyFolderRenamedListeners(Folder folder, Folder folder2) {
        if (this.folderListeners == null) {
            return;
        }
        queueEvent(new FolderEvent(this, folder, folder2, 3), this.folderListeners);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyStoreListeners(int i, String str) {
        if (this.storeListeners == null) {
            return;
        }
        queueEvent(new StoreEvent(this, i, str), this.storeListeners);
    }

    public synchronized void removeFolderListener(FolderListener folderListener) {
        if (this.folderListeners != null) {
            this.folderListeners.removeElement(folderListener);
        }
    }

    public synchronized void removeStoreListener(StoreListener storeListener) {
        if (this.storeListeners != null) {
            this.storeListeners.removeElement(storeListener);
        }
    }
}
