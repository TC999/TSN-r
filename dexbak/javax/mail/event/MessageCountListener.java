package javax.mail.event;

import java.util.EventListener;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface MessageCountListener extends EventListener {
    void messagesAdded(MessageCountEvent messageCountEvent);

    void messagesRemoved(MessageCountEvent messageCountEvent);
}
