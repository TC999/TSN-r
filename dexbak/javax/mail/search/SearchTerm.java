package javax.mail.search;

import java.io.Serializable;
import javax.mail.Message;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class SearchTerm implements Serializable {
    private static final long serialVersionUID = -6652358452205992789L;

    public abstract boolean match(Message message);
}
