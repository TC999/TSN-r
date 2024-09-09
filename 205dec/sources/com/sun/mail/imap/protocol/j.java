package com.sun.mail.imap.protocol;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPSaslAuthenticator.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j implements s {

    /* renamed from: a  reason: collision with root package name */
    private h f50544a;

    /* renamed from: b  reason: collision with root package name */
    private String f50545b;

    /* renamed from: c  reason: collision with root package name */
    private Properties f50546c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f50547d;

    /* renamed from: e  reason: collision with root package name */
    private PrintStream f50548e;

    /* renamed from: f  reason: collision with root package name */
    private String f50549f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPSaslAuthenticator.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements CallbackHandler {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ String f50551b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ String f50552c;

        /* renamed from: d  reason: collision with root package name */
        private final /* synthetic */ String f50553d;

        a(String str, String str2, String str3) {
            this.f50551b = str;
            this.f50552c = str2;
            this.f50553d = str3;
        }

        @Override // javax.security.auth.callback.CallbackHandler
        public void handle(Callback[] callbackArr) {
            if (j.this.f50547d) {
                PrintStream printStream = j.this.f50548e;
                printStream.println("IMAP SASL DEBUG: callback length: " + callbackArr.length);
            }
            for (int i4 = 0; i4 < callbackArr.length; i4++) {
                if (j.this.f50547d) {
                    PrintStream printStream2 = j.this.f50548e;
                    printStream2.println("IMAP SASL DEBUG: callback " + i4 + ": " + callbackArr[i4]);
                }
                if (callbackArr[i4] instanceof NameCallback) {
                    ((NameCallback) callbackArr[i4]).setName(this.f50551b);
                } else if (callbackArr[i4] instanceof PasswordCallback) {
                    ((PasswordCallback) callbackArr[i4]).setPassword(this.f50552c.toCharArray());
                } else if (callbackArr[i4] instanceof RealmCallback) {
                    RealmCallback realmCallback = (RealmCallback) callbackArr[i4];
                    String str = this.f50553d;
                    if (str == null) {
                        str = realmCallback.getDefaultText();
                    }
                    realmCallback.setText(str);
                } else if (callbackArr[i4] instanceof RealmChoiceCallback) {
                    RealmChoiceCallback realmChoiceCallback = (RealmChoiceCallback) callbackArr[i4];
                    if (this.f50553d == null) {
                        realmChoiceCallback.setSelectedIndex(realmChoiceCallback.getDefaultChoice());
                    } else {
                        String[] choices = realmChoiceCallback.getChoices();
                        int i5 = 0;
                        while (true) {
                            if (i5 < choices.length) {
                                if (choices[i5].equals(this.f50553d)) {
                                    realmChoiceCallback.setSelectedIndex(i5);
                                    break;
                                }
                                i5++;
                            }
                        }
                    }
                }
            }
        }
    }

    public j(h hVar, String str, Properties properties, boolean z3, PrintStream printStream, String str2) {
        this.f50544a = hVar;
        this.f50545b = str;
        this.f50546c = properties;
        this.f50547d = z3;
        this.f50548e = printStream;
        this.f50549f = str2;
    }

    @Override // com.sun.mail.imap.protocol.s
    public boolean a(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        String str5;
        byte[] bArr;
        synchronized (this.f50544a) {
            Vector vector = new Vector();
            if (this.f50547d) {
                this.f50548e.print("IMAP SASL DEBUG: Mechanisms:");
                for (int i4 = 0; i4 < strArr.length; i4++) {
                    this.f50548e.print(" " + strArr[i4]);
                }
                this.f50548e.println();
            }
            try {
                SaslClient createSaslClient = Sasl.createSaslClient(strArr, str2, this.f50545b, this.f50549f, this.f50546c, new a(str3, str4, str));
                if (createSaslClient == null) {
                    if (this.f50547d) {
                        this.f50548e.println("IMAP SASL DEBUG: No SASL support");
                    }
                    return false;
                }
                if (this.f50547d) {
                    this.f50548e.println("IMAP SASL DEBUG: SASL client " + createSaslClient.getMechanismName());
                }
                try {
                    String q3 = this.f50544a.q("AUTHENTICATE " + createSaslClient.getMechanismName(), null);
                    OutputStream b02 = this.f50544a.b0();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    boolean z3 = true;
                    byte[] bArr2 = {13, 10};
                    boolean equals = createSaslClient.getMechanismName().equals("XGWTRUSTEDAPP");
                    com.sun.mail.iap.g gVar = null;
                    boolean z4 = false;
                    while (!z4) {
                        try {
                            gVar = this.f50544a.l();
                        } catch (Exception e4) {
                            if (this.f50547d) {
                                e4.printStackTrace();
                            }
                            gVar = com.sun.mail.iap.g.a(e4);
                        }
                        if (gVar.f()) {
                            if (createSaslClient.isComplete()) {
                                bArr = null;
                            } else {
                                byte[] c4 = gVar.s().c();
                                if (c4.length > 0) {
                                    c4 = BASE64DecoderStream.decode(c4);
                                }
                                if (this.f50547d) {
                                    this.f50548e.println("IMAP SASL DEBUG: challenge: " + ASCIIUtility.toString(c4, 0, c4.length) + " :");
                                }
                                bArr = createSaslClient.evaluateChallenge(c4);
                            }
                            if (bArr == null) {
                                if (this.f50547d) {
                                    this.f50548e.println("IMAP SASL DEBUG: no response");
                                }
                                b02.write(bArr2);
                                b02.flush();
                                byteArrayOutputStream.reset();
                            } else {
                                if (this.f50547d) {
                                    this.f50548e.println("IMAP SASL DEBUG: response: " + ASCIIUtility.toString(bArr, 0, bArr.length) + " :");
                                }
                                byte[] encode = BASE64EncoderStream.encode(bArr);
                                if (equals) {
                                    byteArrayOutputStream.write("XGWTRUSTEDAPP ".getBytes());
                                }
                                byteArrayOutputStream.write(encode);
                                byteArrayOutputStream.write(bArr2);
                                b02.write(byteArrayOutputStream.toByteArray());
                                b02.flush();
                                byteArrayOutputStream.reset();
                            }
                        } else {
                            if ((!gVar.j() || !gVar.c().equals(q3)) && !gVar.e()) {
                                vector.addElement(gVar);
                            }
                            z4 = true;
                        }
                        z3 = true;
                    }
                    if (createSaslClient.isComplete() && (str5 = (String) createSaslClient.getNegotiatedProperty("javax.security.sasl.qop")) != null && (str5.equalsIgnoreCase("auth-int") || str5.equalsIgnoreCase("auth-conf"))) {
                        if (this.f50547d) {
                            this.f50548e.println("IMAP SASL DEBUG: Mechanism requires integrity or confidentiality");
                        }
                        return false;
                    }
                    com.sun.mail.iap.g[] gVarArr = new com.sun.mail.iap.g[vector.size()];
                    vector.copyInto(gVarArr);
                    this.f50544a.j(gVarArr);
                    this.f50544a.h(gVar);
                    this.f50544a.H0(gVar);
                    return z3;
                } catch (Exception e5) {
                    if (this.f50547d) {
                        this.f50548e.println("IMAP SASL DEBUG: AUTHENTICATE Exception: " + e5);
                    }
                    return false;
                }
            } catch (SaslException e6) {
                if (this.f50547d) {
                    this.f50548e.println("IMAP SASL DEBUG: Failed to create SASL client: " + e6);
                }
                return false;
            }
        }
    }
}
