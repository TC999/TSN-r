package javax.mail.event;

import javax.mail.Store;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class StoreEvent extends MailEvent {
    public static final int ALERT = 1;
    public static final int NOTICE = 2;
    private static final long serialVersionUID = 1938704919992515330L;
    protected String message;
    protected int type;

    public StoreEvent(Store store, int i, String str) {
        super(store);
        this.type = i;
        this.message = str;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        ((StoreListener) obj).notification(this);
    }

    public String getMessage() {
        return this.message;
    }

    public int getMessageType() {
        return this.type;
    }
}
