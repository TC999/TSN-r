package javax.mail.event;

import java.util.EventListener;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface ConnectionListener extends EventListener {
    void closed(ConnectionEvent connectionEvent);

    void disconnected(ConnectionEvent connectionEvent);

    void opened(ConnectionEvent connectionEvent);
}
