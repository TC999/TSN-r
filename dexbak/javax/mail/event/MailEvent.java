package javax.mail.event;

import java.util.EventObject;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class MailEvent extends EventObject {
    private static final long serialVersionUID = 1846275636325456631L;

    public MailEvent(Object obj) {
        super(obj);
    }

    public abstract void dispatch(Object obj);
}
