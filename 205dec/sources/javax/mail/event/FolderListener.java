package javax.mail.event;

import java.util.EventListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface FolderListener extends EventListener {
    void folderCreated(FolderEvent folderEvent);

    void folderDeleted(FolderEvent folderEvent);

    void folderRenamed(FolderEvent folderEvent);
}
