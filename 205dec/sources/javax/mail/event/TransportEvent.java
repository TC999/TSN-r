package javax.mail.event;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Transport;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class TransportEvent extends MailEvent {
    public static final int MESSAGE_DELIVERED = 1;
    public static final int MESSAGE_NOT_DELIVERED = 2;
    public static final int MESSAGE_PARTIALLY_DELIVERED = 3;
    private static final long serialVersionUID = -4729852364684273073L;
    protected transient Address[] invalid;
    protected transient Message msg;
    protected int type;
    protected transient Address[] validSent;
    protected transient Address[] validUnsent;

    public TransportEvent(Transport transport, int i4, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        super(transport);
        this.type = i4;
        this.validSent = addressArr;
        this.validUnsent = addressArr2;
        this.invalid = addressArr3;
        this.msg = message;
    }

    @Override // javax.mail.event.MailEvent
    public void dispatch(Object obj) {
        int i4 = this.type;
        if (i4 == 1) {
            ((TransportListener) obj).messageDelivered(this);
        } else if (i4 == 2) {
            ((TransportListener) obj).messageNotDelivered(this);
        } else {
            ((TransportListener) obj).messagePartiallyDelivered(this);
        }
    }

    public Address[] getInvalidAddresses() {
        return this.invalid;
    }

    public Message getMessage() {
        return this.msg;
    }

    public int getType() {
        return this.type;
    }

    public Address[] getValidSentAddresses() {
        return this.validSent;
    }

    public Address[] getValidUnsentAddresses() {
        return this.validUnsent;
    }
}
