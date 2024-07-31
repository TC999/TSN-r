package com.sun.mail.imap.protocol;

import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Vector;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.sasl.RealmCallback;
import javax.security.sasl.RealmChoiceCallback;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;

/* renamed from: com.sun.mail.imap.protocol.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPSaslAuthenticator implements SaslAuthenticator {

    /* renamed from: a */
    private IMAPProtocol f36134a;

    /* renamed from: b */
    private String f36135b;

    /* renamed from: c */
    private Properties f36136c;

    /* renamed from: d */
    private boolean f36137d;

    /* renamed from: e */
    private PrintStream f36138e;

    /* renamed from: f */
    private String f36139f;

    /* compiled from: IMAPSaslAuthenticator.java */
    /* renamed from: com.sun.mail.imap.protocol.j$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12760a implements CallbackHandler {

        /* renamed from: b */
        private final /* synthetic */ String f36141b;

        /* renamed from: c */
        private final /* synthetic */ String f36142c;

        /* renamed from: d */
        private final /* synthetic */ String f36143d;

        C12760a(String str, String str2, String str3) {
            this.f36141b = str;
            this.f36142c = str2;
            this.f36143d = str3;
        }

        @Override // javax.security.auth.callback.CallbackHandler
        public void handle(Callback[] callbackArr) {
            if (IMAPSaslAuthenticator.this.f36137d) {
                PrintStream printStream = IMAPSaslAuthenticator.this.f36138e;
                printStream.println("IMAP SASL DEBUG: callback length: " + callbackArr.length);
            }
            for (int i = 0; i < callbackArr.length; i++) {
                if (IMAPSaslAuthenticator.this.f36137d) {
                    PrintStream printStream2 = IMAPSaslAuthenticator.this.f36138e;
                    printStream2.println("IMAP SASL DEBUG: callback " + i + ": " + callbackArr[i]);
                }
                if (callbackArr[i] instanceof NameCallback) {
                    ((NameCallback) callbackArr[i]).setName(this.f36141b);
                } else if (callbackArr[i] instanceof PasswordCallback) {
                    ((PasswordCallback) callbackArr[i]).setPassword(this.f36142c.toCharArray());
                } else if (callbackArr[i] instanceof RealmCallback) {
                    RealmCallback realmCallback = (RealmCallback) callbackArr[i];
                    String str = this.f36143d;
                    if (str == null) {
                        str = realmCallback.getDefaultText();
                    }
                    realmCallback.setText(str);
                } else if (callbackArr[i] instanceof RealmChoiceCallback) {
                    RealmChoiceCallback realmChoiceCallback = (RealmChoiceCallback) callbackArr[i];
                    if (this.f36143d == null) {
                        realmChoiceCallback.setSelectedIndex(realmChoiceCallback.getDefaultChoice());
                    } else {
                        String[] choices = realmChoiceCallback.getChoices();
                        int i2 = 0;
                        while (true) {
                            if (i2 < choices.length) {
                                if (choices[i2].equals(this.f36143d)) {
                                    realmChoiceCallback.setSelectedIndex(i2);
                                    break;
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
        }
    }

    public IMAPSaslAuthenticator(IMAPProtocol iMAPProtocol, String str, Properties properties, boolean z, PrintStream printStream, String str2) {
        this.f36134a = iMAPProtocol;
        this.f36135b = str;
        this.f36136c = properties;
        this.f36137d = z;
        this.f36138e = printStream;
        this.f36139f = str2;
    }

    @Override // com.sun.mail.imap.protocol.SaslAuthenticator
    /* renamed from: a */
    public boolean mo16106a(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        String str5;
        byte[] bArr;
        synchronized (this.f36134a) {
            Vector vector = new Vector();
            if (this.f36137d) {
                this.f36138e.print("IMAP SASL DEBUG: Mechanisms:");
                for (int i = 0; i < strArr.length; i++) {
                    this.f36138e.print(" " + strArr[i]);
                }
                this.f36138e.println();
            }
            try {
                SaslClient createSaslClient = Sasl.createSaslClient(strArr, str2, this.f36135b, this.f36139f, this.f36136c, new C12760a(str3, str4, str));
                if (createSaslClient == null) {
                    if (this.f36137d) {
                        this.f36138e.println("IMAP SASL DEBUG: No SASL support");
                    }
                    return false;
                }
                if (this.f36137d) {
                    this.f36138e.println("IMAP SASL DEBUG: SASL client " + createSaslClient.getMechanismName());
                }
                try {
                    String m16410q = this.f36134a.m16410q("AUTHENTICATE " + createSaslClient.getMechanismName(), null);
                    OutputStream m16161b0 = this.f36134a.m16161b0();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    boolean z = true;
                    byte[] bArr2 = {13, 10};
                    boolean equals = createSaslClient.getMechanismName().equals("XGWTRUSTEDAPP");
                    C12728g c12728g = null;
                    boolean z2 = false;
                    while (!z2) {
                        try {
                            c12728g = this.f36134a.mo16148l();
                        } catch (Exception e) {
                            if (this.f36137d) {
                                e.printStackTrace();
                            }
                            c12728g = C12728g.m16406a(e);
                        }
                        if (c12728g.m16401f()) {
                            if (createSaslClient.isComplete()) {
                                bArr = null;
                            } else {
                                byte[] m16426c = c12728g.m16388s().m16426c();
                                if (m16426c.length > 0) {
                                    m16426c = BASE64DecoderStream.decode(m16426c);
                                }
                                if (this.f36137d) {
                                    this.f36138e.println("IMAP SASL DEBUG: challenge: " + ASCIIUtility.toString(m16426c, 0, m16426c.length) + " :");
                                }
                                bArr = createSaslClient.evaluateChallenge(m16426c);
                            }
                            if (bArr == null) {
                                if (this.f36137d) {
                                    this.f36138e.println("IMAP SASL DEBUG: no response");
                                }
                                m16161b0.write(bArr2);
                                m16161b0.flush();
                                byteArrayOutputStream.reset();
                            } else {
                                if (this.f36137d) {
                                    this.f36138e.println("IMAP SASL DEBUG: response: " + ASCIIUtility.toString(bArr, 0, bArr.length) + " :");
                                }
                                byte[] encode = BASE64EncoderStream.encode(bArr);
                                if (equals) {
                                    byteArrayOutputStream.write("XGWTRUSTEDAPP ".getBytes());
                                }
                                byteArrayOutputStream.write(encode);
                                byteArrayOutputStream.write(bArr2);
                                m16161b0.write(byteArrayOutputStream.toByteArray());
                                m16161b0.flush();
                                byteArrayOutputStream.reset();
                            }
                        } else {
                            if ((!c12728g.m16397j() || !c12728g.m16404c().equals(m16410q)) && !c12728g.m16402e()) {
                                vector.addElement(c12728g);
                            }
                            z2 = true;
                        }
                        z = true;
                    }
                    if (createSaslClient.isComplete() && (str5 = (String) createSaslClient.getNegotiatedProperty("javax.security.sasl.qop")) != null && (str5.equalsIgnoreCase("auth-int") || str5.equalsIgnoreCase("auth-conf"))) {
                        if (this.f36137d) {
                            this.f36138e.println("IMAP SASL DEBUG: Mechanism requires integrity or confidentiality");
                        }
                        return false;
                    }
                    C12728g[] c12728gArr = new C12728g[vector.size()];
                    vector.copyInto(c12728gArr);
                    this.f36134a.m16414j(c12728gArr);
                    this.f36134a.m16416h(c12728g);
                    this.f36134a.m16191H0(c12728g);
                    return z;
                } catch (Exception e2) {
                    if (this.f36137d) {
                        this.f36138e.println("IMAP SASL DEBUG: AUTHENTICATE Exception: " + e2);
                    }
                    return false;
                }
            } catch (SaslException e3) {
                if (this.f36137d) {
                    this.f36138e.println("IMAP SASL DEBUG: Failed to create SASL client: " + e3);
                }
                return false;
            }
        }
    }
}
