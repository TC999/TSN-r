package javax.mail;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SendFailedException extends MessagingException {
    private static final long serialVersionUID = -6457531621682372913L;
    protected transient Address[] invalid;
    protected transient Address[] validSent;
    protected transient Address[] validUnsent;

    public SendFailedException() {
    }

    public Address[] getInvalidAddresses() {
        return this.invalid;
    }

    public Address[] getValidSentAddresses() {
        return this.validSent;
    }

    public Address[] getValidUnsentAddresses() {
        return this.validUnsent;
    }

    public SendFailedException(String str) {
        super(str);
    }

    public SendFailedException(String str, Exception exc) {
        super(str, exc);
    }

    public SendFailedException(String str, Exception exc, Address[] addressArr, Address[] addressArr2, Address[] addressArr3) {
        super(str, exc);
        this.validSent = addressArr;
        this.validUnsent = addressArr2;
        this.invalid = addressArr3;
    }
}
