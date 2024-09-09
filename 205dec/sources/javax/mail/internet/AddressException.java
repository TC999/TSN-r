package javax.mail.internet;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class AddressException extends ParseException {
    private static final long serialVersionUID = 9134583443539323120L;
    protected int pos;
    protected String ref;

    public AddressException() {
        this.ref = null;
        this.pos = -1;
    }

    public int getPos() {
        return this.pos;
    }

    public String getRef() {
        return this.ref;
    }

    @Override // javax.mail.MessagingException, java.lang.Throwable
    public String toString() {
        String messagingException = super.toString();
        if (this.ref == null) {
            return messagingException;
        }
        String str = String.valueOf(messagingException) + " in string ``" + this.ref + "''";
        if (this.pos < 0) {
            return str;
        }
        return String.valueOf(str) + " at position " + this.pos;
    }

    public AddressException(String str) {
        super(str);
        this.ref = null;
        this.pos = -1;
    }

    public AddressException(String str, String str2) {
        super(str);
        this.pos = -1;
        this.ref = str2;
    }

    public AddressException(String str, String str2, int i4) {
        super(str);
        this.ref = str2;
        this.pos = i4;
    }
}
