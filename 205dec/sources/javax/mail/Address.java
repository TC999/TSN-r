package javax.mail;

import java.io.Serializable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Address implements Serializable {
    private static final long serialVersionUID = -5822459626751992278L;

    public abstract boolean equals(Object obj);

    public abstract String getType();

    public abstract String toString();
}
