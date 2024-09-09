package javax.mail.event;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class ConnectionEvent extends MailEvent {
    public static final int CLOSED = 3;
    public static final int DISCONNECTED = 2;
    public static final int OPENED = 1;
    private static final long serialVersionUID = -1855480171284792957L;
    protected int type;

    public ConnectionEvent(Object obj, int i4) {
        super(obj);
        this.type = i4;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i4 = this.type;
        if (i4 == 1) {
            ((ConnectionListener) obj).opened(this);
        } else if (i4 == 2) {
            ((ConnectionListener) obj).disconnected(this);
        } else if (i4 == 3) {
            ((ConnectionListener) obj).closed(this);
        }
    }

    public int getType() {
        return this.type;
    }
}
