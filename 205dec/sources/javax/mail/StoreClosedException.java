package javax.mail;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class StoreClosedException extends MessagingException {
    private static final long serialVersionUID = -3145392336120082655L;
    private transient Store store;

    public StoreClosedException(Store store) {
        this(store, null);
    }

    public Store getStore() {
        return this.store;
    }

    public StoreClosedException(Store store, String str) {
        super(str);
        this.store = store;
    }
}
