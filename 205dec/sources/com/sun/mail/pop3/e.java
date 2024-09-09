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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: POP3Store.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e extends Store {

    /* renamed from: a  reason: collision with root package name */
    private String f50616a;

    /* renamed from: b  reason: collision with root package name */
    private int f50617b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f50618c;

    /* renamed from: d  reason: collision with root package name */
    private f f50619d;

    /* renamed from: e  reason: collision with root package name */
    private b f50620e;

    /* renamed from: f  reason: collision with root package name */
    private String f50621f;

    /* renamed from: g  reason: collision with root package name */
    private int f50622g;

    /* renamed from: h  reason: collision with root package name */
    private String f50623h;

    /* renamed from: i  reason: collision with root package name */
    private String f50624i;

    /* renamed from: j  reason: collision with root package name */
    boolean f50625j;

    /* renamed from: k  reason: collision with root package name */
    boolean f50626k;

    /* renamed from: l  reason: collision with root package name */
    boolean f50627l;

    /* renamed from: m  reason: collision with root package name */
    Constructor f50628m;

    public e(Session session, URLName uRLName) {
        this(session, uRLName, "pop3", 110, false);
    }

    private void checkConnected() throws MessagingException {
        if (!super.isConnected()) {
            throw new MessagingException("Not connected");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(b bVar) {
        if (this.f50620e == bVar) {
            this.f50619d = null;
            this.f50620e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized f c(b bVar) throws IOException {
        f fVar = this.f50619d;
        if (fVar != null && this.f50620e == null) {
            this.f50620e = bVar;
            return fVar;
        }
        String str = this.f50621f;
        int i4 = this.f50622g;
        boolean debug = this.session.getDebug();
        PrintStream debugOut = this.session.getDebugOut();
        Properties properties = this.session.getProperties();
        f fVar2 = new f(str, i4, debug, debugOut, properties, "mail." + this.f50616a, this.f50618c);
        String e4 = fVar2.e(this.f50623h, this.f50624i);
        if (e4 == null) {
            if (this.f50619d == null && bVar != null) {
                this.f50619d = fVar2;
                this.f50620e = bVar;
            }
            if (this.f50620e == null) {
                this.f50620e = bVar;
            }
            return fVar2;
        }
        try {
            fVar2.h();
        } catch (Throwable unused) {
        }
        throw new EOFException(e4);
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        try {
            try {
                f fVar = this.f50619d;
                if (fVar != null) {
                    fVar.h();
                }
                this.f50619d = null;
            } catch (IOException unused) {
                this.f50619d = null;
            } catch (Throwable th) {
                this.f50619d = null;
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
        if (this.f50619d != null) {
            close();
        }
    }

    @Override // javax.mail.Store
    public Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new a(this);
    }

    @Override // javax.mail.Store
    public Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new b(this, str);
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (super.isConnected()) {
            synchronized (this) {
                try {
                    try {
                        f fVar = this.f50619d;
                        if (fVar == null) {
                            this.f50619d = c(null);
                        } else {
                            fVar.g();
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
    protected synchronized boolean protocolConnect(String str, int i4, String str2, String str3) throws MessagingException {
        if (str == null || str3 == null || str2 == null) {
            return false;
        }
        if (i4 == -1) {
            try {
                Session session = this.session;
                String property = session.getProperty("mail." + this.f50616a + ".port");
                if (property != null) {
                    i4 = Integer.parseInt(property);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i4 == -1) {
            i4 = this.f50617b;
        }
        this.f50621f = str;
        this.f50622g = i4;
        this.f50623h = str2;
        this.f50624i = str3;
        try {
            this.f50619d = c(null);
            return true;
        } catch (EOFException e4) {
            throw new AuthenticationFailedException(e4.getMessage());
        } catch (IOException e5) {
            throw new MessagingException("Connect failed", e5);
        }
    }

    public e(Session session, URLName uRLName, String str, int i4, boolean z3) {
        super(session, uRLName);
        Class<?> cls;
        this.f50616a = "pop3";
        this.f50617b = 110;
        this.f50618c = false;
        this.f50619d = null;
        this.f50620e = null;
        this.f50621f = null;
        this.f50622g = -1;
        this.f50623h = null;
        this.f50624i = null;
        this.f50625j = false;
        this.f50626k = false;
        this.f50627l = false;
        this.f50628m = null;
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f50616a = str;
        this.f50617b = i4;
        this.f50618c = z3;
        String property = session.getProperty("mail." + str + ".rsetbeforequit");
        if (property != null && property.equalsIgnoreCase("true")) {
            this.f50625j = true;
        }
        String property2 = session.getProperty("mail." + str + ".disabletop");
        if (property2 != null && property2.equalsIgnoreCase("true")) {
            this.f50626k = true;
        }
        String property3 = session.getProperty("mail." + str + ".forgettopheaders");
        if (property3 != null && property3.equalsIgnoreCase("true")) {
            this.f50627l = true;
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
                this.f50628m = cls.getConstructor(Folder.class, Integer.TYPE);
            } catch (Exception e4) {
                if (session.getDebug()) {
                    PrintStream debugOut2 = session.getDebugOut();
                    debugOut2.println("DEBUG: failed to load POP3 message class: " + e4);
                }
            }
        }
    }

    @Override // javax.mail.Store
    public Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new b(this, uRLName.getFile());
    }
}
