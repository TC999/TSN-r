package javax.mail;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class PasswordAuthentication {
    private String password;
    private String userName;

    public PasswordAuthentication(String str, String str2) {
        this.userName = str;
        this.password = str2;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }
}
