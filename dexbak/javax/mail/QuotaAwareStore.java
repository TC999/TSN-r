package javax.mail;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface QuotaAwareStore {
    Quota[] getQuota(String str) throws MessagingException;

    void setQuota(Quota quota) throws MessagingException;
}
