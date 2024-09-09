package javax.mail.search;

import java.io.Serializable;
import javax.mail.Message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class SearchTerm implements Serializable {
    private static final long serialVersionUID = -6652358452205992789L;

    public abstract boolean match(Message message);
}
