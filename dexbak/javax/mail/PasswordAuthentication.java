package javax.mail;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
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
