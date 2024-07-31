package javax.mail.event;

import java.util.EventListener;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface TransportListener extends EventListener {
    void messageDelivered(TransportEvent transportEvent);

    void messageNotDelivered(TransportEvent transportEvent);

    void messagePartiallyDelivered(TransportEvent transportEvent);
}
