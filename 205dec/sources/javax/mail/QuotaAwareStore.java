package javax.mail;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface QuotaAwareStore {
    Quota[] getQuota(String str) throws MessagingException;

    void setQuota(Quota quota) throws MessagingException;
}
