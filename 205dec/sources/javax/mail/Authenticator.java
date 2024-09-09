package javax.mail;

import java.net.InetAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class Authenticator {
    private int requestingPort;
    private String requestingPrompt;
    private String requestingProtocol;
    private InetAddress requestingSite;
    private String requestingUserName;

    private void reset() {
        this.requestingSite = null;
        this.requestingPort = -1;
        this.requestingProtocol = null;
        this.requestingPrompt = null;
        this.requestingUserName = null;
    }

    protected final String getDefaultUserName() {
        return this.requestingUserName;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return null;
    }

    protected final int getRequestingPort() {
        return this.requestingPort;
    }

    protected final String getRequestingPrompt() {
        return this.requestingPrompt;
    }

    protected final String getRequestingProtocol() {
        return this.requestingProtocol;
    }

    protected final InetAddress getRequestingSite() {
        return this.requestingSite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PasswordAuthentication requestPasswordAuthentication(InetAddress inetAddress, int i4, String str, String str2, String str3) {
        reset();
        this.requestingSite = inetAddress;
        this.requestingPort = i4;
        this.requestingProtocol = str;
        this.requestingPrompt = str2;
        this.requestingUserName = str3;
        return getPasswordAuthentication();
    }
}
