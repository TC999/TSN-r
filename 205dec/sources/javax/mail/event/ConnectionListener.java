package javax.mail.event;

import java.util.EventListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface ConnectionListener extends EventListener {
    void closed(ConnectionEvent connectionEvent);

    void disconnected(ConnectionEvent connectionEvent);

    void opened(ConnectionEvent connectionEvent);
}
