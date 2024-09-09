package javax.mail.event;

import javax.mail.Message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MessageChangedEvent extends MailEvent {
    public static final int ENVELOPE_CHANGED = 2;
    public static final int FLAGS_CHANGED = 1;
    private static final long serialVersionUID = -4974972972105535108L;
    protected transient Message msg;
    protected int type;

    public MessageChangedEvent(Object obj, int i4, Message message) {
        super(obj);
        this.msg = message;
        this.type = i4;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        ((MessageChangedListener) obj).messageChanged(this);
    }

    public Message getMessage() {
        return this.msg;
    }

    public int getMessageChangeType() {
        return this.type;
    }
}
