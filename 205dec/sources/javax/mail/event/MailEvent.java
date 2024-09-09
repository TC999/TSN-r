package javax.mail.event;

import java.util.EventObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class MailEvent extends EventObject {
    private static final long serialVersionUID = 1846275636325456631L;

    public MailEvent(Object obj) {
        super(obj);
    }

    public abstract void dispatch(Object obj);
}
