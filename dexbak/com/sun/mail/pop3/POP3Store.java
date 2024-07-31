package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Properties;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

/* renamed from: com.sun.mail.pop3.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class POP3Store extends Store {

    /* renamed from: a */
    private String f36206a;

    /* renamed from: b */
    private int f36207b;

    /* renamed from: c */
    private boolean f36208c;

    /* renamed from: d */
    private C12763f f36209d;

    /* renamed from: e */
    private POP3Folder f36210e;

    /* renamed from: f */
    private String f36211f;

    /* renamed from: g */
    private int f36212g;

    /* renamed from: h */
    private String f36213h;

    /* renamed from: i */
    private String f36214i;

    /* renamed from: j */
    boolean f36215j;

    /* renamed from: k */
    boolean f36216k;

    /* renamed from: l */
    boolean f36217l;

    /* renamed from: m */
    Constructor f36218m;

    public POP3Store(Session session, URLName uRLName) {
        this(session, uRLName, "pop3", 110, false);
    }

    private void checkConnected() throws MessagingException {
        if (!super.isConnected()) {
            throw new MessagingException("Not connected");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void m16069b(POP3Folder pOP3Folder) {
        if (this.f36210e == pOP3Folder) {
            this.f36209d = null;
            this.f36210e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized C12763f m16068c(POP3Folder pOP3Folder) throws IOException {
        C12763f c12763f = this.f36209d;
        if (c12763f != null && this.f36210e == null) {
            this.f36210e = pOP3Folder;
            return c12763f;
        }
        String str = this.f36211f;
        int i = this.f36212g;
        boolean debug = this.session.getDebug();
        PrintStream debugOut = this.session.getDebugOut();
        Properties properties = this.session.getProperties();
        C12763f c12763f2 = new C12763f(str, i, debug, debugOut, properties, "mail." + this.f36206a, this.f36208c);
        String m16063e = c12763f2.m16063e(this.f36213h, this.f36214i);
        if (m16063e == null) {
            if (this.f36209d == null && pOP3Folder != null) {
                this.f36209d = c12763f2;
                this.f36210e = pOP3Folder;
            }
            if (this.f36210e == null) {
                this.f36210e = pOP3Folder;
            }
            return c12763f2;
        }
        try {
            c12763f2.m16060h();
        } catch (Throwable unused) {
        }
        throw new EOFException(m16063e);
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        try {
            try {
                C12763f c12763f = this.f36209d;
                if (c12763f != null) {
                    c12763f.m16060h();
                }
                this.f36209d = null;
            } catch (IOException unused) {
                this.f36209d = null;
            } catch (Throwable th) {
                this.f36209d = null;
                super.close();
                throw th;
            }
            super.close();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Service
    public void finalize() throws Throwable {
        super.finalize();
        if (this.f36209d != null) {
            close();
        }
    }

    @Override // javax.mail.Store
    public Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new C12762a(this);
    }

    @Override // javax.mail.Store
    public Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, str);
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (super.isConnected()) {
            synchronized (this) {
                try {
                    try {
                        C12763f c12763f = this.f36209d;
                        if (c12763f == null) {
                            this.f36209d = m16068c(null);
                        } else {
                            c12763f.m16061g();
                        }
                        return true;
                    } catch (Throwable unused) {
                        return false;
                    }
                } catch (IOException unused2) {
                    super.close();
                    return false;
                }
            }
        }
        return false;
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        if (str == null || str3 == null || str2 == null) {
            return false;
        }
        if (i == -1) {
            try {
                Session session = this.session;
                String property = session.getProperty("mail." + this.f36206a + ".port");
                if (property != null) {
                    i = Integer.parseInt(property);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i == -1) {
            i = this.f36207b;
        }
        this.f36211f = str;
        this.f36212g = i;
        this.f36213h = str2;
        this.f36214i = str3;
        try {
            this.f36209d = m16068c(null);
            return true;
        } catch (EOFException e) {
            throw new AuthenticationFailedException(e.getMessage());
        } catch (IOException e2) {
            throw new MessagingException("Connect failed", e2);
        }
    }

    public POP3Store(Session session, URLName uRLName, String str, int i, boolean z) {
        super(session, uRLName);
        Class<?> cls;
        this.f36206a = "pop3";
        this.f36207b = 110;
        this.f36208c = false;
        this.f36209d = null;
        this.f36210e = null;
        this.f36211f = null;
        this.f36212g = -1;
        this.f36213h = null;
        this.f36214i = null;
        this.f36215j = false;
        this.f36216k = false;
        this.f36217l = false;
        this.f36218m = null;
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f36206a = str;
        this.f36207b = i;
        this.f36208c = z;
        String property = session.getProperty("mail." + str + ".rsetbeforequit");
        if (property != null && property.equalsIgnoreCase("true")) {
            this.f36215j = true;
        }
        String property2 = session.getProperty("mail." + str + ".disabletop");
        if (property2 != null && property2.equalsIgnoreCase("true")) {
            this.f36216k = true;
        }
        String property3 = session.getProperty("mail." + str + ".forgettopheaders");
        if (property3 != null && property3.equalsIgnoreCase("true")) {
            this.f36217l = true;
        }
        String property4 = session.getProperty("mail." + str + ".message.class");
        if (property4 != null) {
            if (session.getDebug()) {
                PrintStream debugOut = session.getDebugOut();
                debugOut.println("DEBUG: POP3 message class: " + property4);
            }
            try {
                try {
                    cls = getClass().getClassLoader().loadClass(property4);
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(property4);
                }
                this.f36218m = cls.getConstructor(Folder.class, Integer.TYPE);
            } catch (Exception e) {
                if (session.getDebug()) {
                    PrintStream debugOut2 = session.getDebugOut();
                    debugOut2.println("DEBUG: failed to load POP3 message class: " + e);
                }
            }
        }
    }

    @Override // javax.mail.Store
    public Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, uRLName.getFile());
    }
}
