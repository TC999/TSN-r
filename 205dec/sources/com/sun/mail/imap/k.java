package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.p;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.QuotaAwareStore;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.URLName;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPStore.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class k extends Store implements QuotaAwareStore, com.sun.mail.iap.h {
    public static final int A = 1000;
    static final /* synthetic */ boolean B = false;

    /* renamed from: a  reason: collision with root package name */
    private String f50421a;

    /* renamed from: b  reason: collision with root package name */
    private int f50422b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f50423c;

    /* renamed from: d  reason: collision with root package name */
    private int f50424d;

    /* renamed from: e  reason: collision with root package name */
    private int f50425e;

    /* renamed from: f  reason: collision with root package name */
    private int f50426f;

    /* renamed from: g  reason: collision with root package name */
    private int f50427g;

    /* renamed from: h  reason: collision with root package name */
    private int f50428h;

    /* renamed from: i  reason: collision with root package name */
    private String f50429i;

    /* renamed from: j  reason: collision with root package name */
    private String f50430j;

    /* renamed from: k  reason: collision with root package name */
    private String f50431k;

    /* renamed from: l  reason: collision with root package name */
    private String f50432l;

    /* renamed from: m  reason: collision with root package name */
    private String f50433m;

    /* renamed from: n  reason: collision with root package name */
    private String f50434n;

    /* renamed from: o  reason: collision with root package name */
    private p f50435o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f50436p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f50437r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f50438s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f50439t;

    /* renamed from: u  reason: collision with root package name */
    private String[] f50440u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f50441v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f50442w;

    /* renamed from: x  reason: collision with root package name */
    private volatile boolean f50443x;

    /* renamed from: y  reason: collision with root package name */
    private PrintStream f50444y;

    /* renamed from: z  reason: collision with root package name */
    private a f50445z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPStore.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: m  reason: collision with root package name */
        private static final int f50446m = 0;

        /* renamed from: n  reason: collision with root package name */
        private static final int f50447n = 1;

        /* renamed from: o  reason: collision with root package name */
        private static final int f50448o = 2;

        /* renamed from: b  reason: collision with root package name */
        private Vector f50450b;

        /* renamed from: g  reason: collision with root package name */
        private long f50455g;

        /* renamed from: l  reason: collision with root package name */
        private com.sun.mail.imap.protocol.h f50460l;

        /* renamed from: a  reason: collision with root package name */
        private Vector f50449a = new Vector();

        /* renamed from: c  reason: collision with root package name */
        private boolean f50451c = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f50452d = false;

        /* renamed from: e  reason: collision with root package name */
        private long f50453e = 45000;

        /* renamed from: f  reason: collision with root package name */
        private long f50454f = 1800000;

        /* renamed from: h  reason: collision with root package name */
        private int f50456h = 1;

        /* renamed from: i  reason: collision with root package name */
        private long f50457i = 60000;

        /* renamed from: j  reason: collision with root package name */
        private boolean f50458j = false;

        /* renamed from: k  reason: collision with root package name */
        private int f50459k = 0;

        a() {
        }
    }

    public k(Session session, URLName uRLName) {
        this(session, uRLName, "imap", 143, false);
    }

    private void A() throws ProtocolException {
        while (this.f50445z.f50459k != 0) {
            if (this.f50445z.f50459k == 1) {
                this.f50445z.f50460l.f0();
                this.f50445z.f50459k = 2;
            }
            try {
                this.f50445z.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private void c() {
        d(false);
    }

    private void checkConnected() {
        if (this.f50443x) {
            return;
        }
        super.setConnected(false);
        throw new IllegalStateException("Not connected");
    }

    private void d(boolean z3) {
        boolean z4;
        if (this.debug) {
            this.f50444y.println("DEBUG: IMAPStore cleanup, force " + z3);
        }
        Vector vector = null;
        while (true) {
            synchronized (this.f50445z) {
                if (this.f50445z.f50450b != null) {
                    vector = this.f50445z.f50450b;
                    this.f50445z.f50450b = null;
                    z4 = false;
                } else {
                    z4 = true;
                }
            }
            if (z4) {
                break;
            }
            int size = vector.size();
            for (int i4 = 0; i4 < size; i4++) {
                e eVar = (e) vector.elementAt(i4);
                if (z3) {
                    try {
                        if (this.debug) {
                            this.f50444y.println("DEBUG: force folder to close");
                        }
                        eVar.w();
                    } catch (IllegalStateException | MessagingException unused) {
                    }
                } else {
                    if (this.debug) {
                        this.f50444y.println("DEBUG: close folder");
                    }
                    eVar.close(false);
                }
            }
        }
        synchronized (this.f50445z) {
            e(z3);
        }
        this.f50443x = false;
        notifyConnectionListeners(3);
        if (this.debug) {
            this.f50444y.println("DEBUG: IMAPStore cleanup done");
        }
    }

    private void e(boolean z3) {
        synchronized (this.f50445z) {
            for (int size = this.f50445z.f50449a.size() - 1; size >= 0; size--) {
                try {
                    com.sun.mail.imap.protocol.h hVar = (com.sun.mail.imap.protocol.h) this.f50445z.f50449a.elementAt(size);
                    hVar.m(this);
                    if (z3) {
                        hVar.c();
                    } else {
                        hVar.n0();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.f50445z.f50449a.removeAllElements();
        }
        if (this.f50445z.f50458j) {
            this.f50444y.println("DEBUG: removed all authenticated connections");
        }
    }

    private synchronized p j() throws MessagingException {
        checkConnected();
        com.sun.mail.imap.protocol.h hVar = null;
        if (this.f50435o == null) {
            try {
                hVar = n();
                this.f50435o = hVar.q0();
                w(hVar);
            } catch (BadCommandException unused) {
                w(hVar);
                if (hVar == null) {
                    c();
                }
            } catch (ConnectionException e4) {
                throw new StoreClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        return this.f50435o;
    }

    private void t(com.sun.mail.imap.protocol.h hVar, String str, String str2) throws ProtocolException {
        if (this.f50438s && hVar.e0("STARTTLS")) {
            hVar.J0();
            hVar.w();
        }
        if (hVar.h0()) {
            return;
        }
        hVar.a0().put("__PRELOGIN__", "");
        String str3 = this.f50433m;
        if (str3 == null && (str3 = this.f50432l) == null) {
            str3 = str;
        }
        if (this.f50439t) {
            hVar.B0(this.f50440u, this.f50434n, str3, str, str2);
        }
        if (!hVar.h0()) {
            if (hVar.e0("AUTH=PLAIN") && !this.f50437r) {
                hVar.v(str3, str, str2);
            } else if ((hVar.e0("AUTH-LOGIN") || hVar.e0("AUTH=LOGIN")) && !this.f50436p) {
                hVar.u(str, str2);
            } else if (!hVar.e0("LOGINDISABLED")) {
                hVar.m0(str, str2);
            } else {
                throw new ProtocolException("No login methods supported!");
            }
        }
        String str4 = this.f50432l;
        if (str4 != null) {
            hVar.y0(str4);
        }
        if (hVar.e0("__PRELOGIN__")) {
            try {
                hVar.w();
            } catch (ConnectionException e4) {
                throw e4;
            } catch (ProtocolException unused) {
            }
        }
    }

    private Folder[] u(p.a[] aVarArr, String str) {
        int length = aVarArr.length;
        Folder[] folderArr = new Folder[length];
        for (int i4 = 0; i4 < length; i4++) {
            String str2 = aVarArr[i4].f50581a;
            if (str == null) {
                int length2 = str2.length();
                if (length2 > 0) {
                    int i5 = length2 - 1;
                    if (str2.charAt(i5) == aVarArr[i4].f50582b) {
                        str2 = str2.substring(0, i5);
                    }
                }
            } else {
                str2 = String.valueOf(str2) + str;
            }
            folderArr[i4] = new e(str2, aVarArr[i4].f50582b, this, str == null);
        }
        return folderArr;
    }

    private void z() {
        synchronized (this.f50445z) {
            if (System.currentTimeMillis() - this.f50445z.f50455g > this.f50445z.f50457i && this.f50445z.f50449a.size() > 1) {
                if (this.f50445z.f50458j) {
                    this.f50444y.println("DEBUG: checking for connections to prune: " + (System.currentTimeMillis() - this.f50445z.f50455g));
                    this.f50444y.println("DEBUG: clientTimeoutInterval: " + this.f50445z.f50453e);
                }
                for (int size = this.f50445z.f50449a.size() - 1; size > 0; size--) {
                    com.sun.mail.imap.protocol.h hVar = (com.sun.mail.imap.protocol.h) this.f50445z.f50449a.elementAt(size);
                    if (this.f50445z.f50458j) {
                        this.f50444y.println("DEBUG: protocol last used: " + (System.currentTimeMillis() - hVar.g()));
                    }
                    if (System.currentTimeMillis() - hVar.g() > this.f50445z.f50453e) {
                        if (this.f50445z.f50458j) {
                            this.f50444y.println("DEBUG: authenticated connection timed out");
                            this.f50444y.println("DEBUG: logging out the connection");
                        }
                        hVar.m(this);
                        this.f50445z.f50449a.removeElementAt(size);
                        try {
                            hVar.n0();
                        } catch (ProtocolException unused) {
                        }
                    }
                }
                this.f50445z.f50455g = System.currentTimeMillis();
            }
        }
    }

    @Override // com.sun.mail.iap.h
    public void a(com.sun.mail.iap.g gVar) {
        if (gVar.h() || gVar.g() || gVar.d() || gVar.e()) {
            o(gVar);
        }
        if (gVar.e()) {
            if (this.debug) {
                this.f50444y.println("DEBUG: IMAPStore connection dead");
            }
            if (this.f50443x) {
                d(gVar.i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        Session session = this.session;
        String property = session.getProperty("mail." + this.f50421a + ".allowreadonlyselect");
        return property != null && property.equalsIgnoreCase("true");
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        boolean isEmpty;
        if (super.isConnected()) {
            try {
                synchronized (this.f50445z) {
                    isEmpty = this.f50445z.f50449a.isEmpty();
                }
                if (isEmpty) {
                    if (this.f50445z.f50458j) {
                        this.f50444y.println("DEBUG: close() - no connections ");
                    }
                    c();
                    w(null);
                    return;
                }
                com.sun.mail.imap.protocol.h n4 = n();
                synchronized (this.f50445z) {
                    this.f50445z.f50449a.removeElement(n4);
                }
                n4.n0();
                w(n4);
            } catch (ProtocolException e4) {
                c();
                throw new MessagingException(e4.getMessage(), e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f50427g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Service
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.f50445z.f50458j;
    }

    @Override // javax.mail.Store
    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new c(this);
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new e(str, '\uffff', this);
    }

    @Override // javax.mail.Store
    public Folder[] getPersonalNamespaces() throws MessagingException {
        p.a[] aVarArr;
        p j4 = j();
        if (j4 != null && (aVarArr = j4.f50578a) != null) {
            return u(aVarArr, null);
        }
        return super.getPersonalNamespaces();
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized Quota[] getQuota(String str) throws MessagingException {
        Quota[] d02;
        checkConnected();
        try {
            try {
                try {
                    com.sun.mail.imap.protocol.h n4 = n();
                    d02 = n4.d0(str);
                    w(n4);
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new StoreClosedException(this, e5.getMessage());
            }
        } catch (BadCommandException e6) {
            throw new MessagingException("QUOTA not supported", e6);
        }
        return d02;
    }

    @Override // javax.mail.Store
    public Folder[] getSharedNamespaces() throws MessagingException {
        p.a[] aVarArr;
        p j4 = j();
        if (j4 != null && (aVarArr = j4.f50580c) != null) {
            return u(aVarArr, null);
        }
        return super.getSharedNamespaces();
    }

    @Override // javax.mail.Store
    public Folder[] getUserNamespaces(String str) throws MessagingException {
        p.a[] aVarArr;
        p j4 = j();
        if (j4 != null && (aVarArr = j4.f50579b) != null) {
            return u(aVarArr, str);
        }
        return super.getUserNamespaces(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f50425e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f50428h;
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!this.f50443x) {
            super.setConnected(false);
            return false;
        }
        com.sun.mail.imap.protocol.h hVar = null;
        try {
            hVar = n();
            hVar.r0();
        } catch (ProtocolException unused) {
            if (hVar == null) {
                c();
            }
        }
        w(hVar);
        return super.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:6|7|(8:16|(1:18)|19|20|(2:31|32)|22|23|(3:25|(1:27)|28))|39|(1:41)|42|43|(5:63|64|65|66|(1:68))|45|46|47|(3:49|23|(0))(1:50)) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e8, code lost:
        r1 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00eb, code lost:
        if (r1 != null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
        r1.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f0, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x011e, code lost:
        throw new javax.mail.MessagingException("connection failure");
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f9 A[Catch: all -> 0x011f, TryCatch #6 {, blocks: (B:8:0x0008, B:10:0x0014, B:12:0x0021, B:14:0x0029, B:17:0x0032, B:19:0x0036, B:20:0x0053, B:23:0x007b, B:28:0x0088, B:50:0x00f4, B:52:0x00f9, B:54:0x0101, B:55:0x010b, B:56:0x0114, B:26:0x0085, B:29:0x008d, B:31:0x0091, B:32:0x0098, B:34:0x009c, B:37:0x00a5, B:39:0x00b4, B:40:0x00c0, B:41:0x00e0, B:58:0x0117, B:59:0x011e, B:46:0x00ed), top: B:77:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0117 A[EDGE_INSN: B:81:0x0117->B:58:0x0117 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sun.mail.imap.protocol.h k(com.sun.mail.imap.e r13) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.k.k(com.sun.mail.imap.e):com.sun.mail.imap.protocol.h");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session l() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f50426f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[Catch: all -> 0x00cb, TRY_ENTER, TryCatch #4 {, blocks: (B:7:0x0008, B:9:0x0017, B:11:0x001f, B:12:0x0026, B:13:0x0046, B:21:0x0059, B:28:0x00a0, B:30:0x00a8, B:32:0x00af, B:34:0x00bd, B:36:0x00c5, B:37:0x00c8, B:22:0x0066, B:23:0x006d, B:18:0x0053, B:24:0x006e, B:26:0x0076, B:27:0x0093), top: B:54:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0066 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sun.mail.imap.protocol.h n() throws com.sun.mail.iap.ProtocolException {
        /*
            r12 = this;
            r0 = 0
            r1 = r0
        L2:
            if (r1 == 0) goto L5
            return r1
        L5:
            com.sun.mail.imap.k$a r2 = r12.f50445z
            monitor-enter(r2)
            r12.A()     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r3 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r3 = com.sun.mail.imap.k.a.c(r3)     // Catch: java.lang.Throwable -> Lcb
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> Lcb
            if (r3 == 0) goto L6e
            com.sun.mail.imap.k$a r3 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            boolean r3 = com.sun.mail.imap.k.a.p(r3)     // Catch: java.lang.Throwable -> Lcb
            if (r3 == 0) goto L26
            java.io.PrintStream r3 = r12.f50444y     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r4 = "DEBUG: getStoreProtocol() - no connections in the pool, creating a new one"
            r3.println(r4)     // Catch: java.lang.Throwable -> Lcb
        L26:
            com.sun.mail.imap.protocol.h r11 = new com.sun.mail.imap.protocol.h     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.lang.String r4 = r12.f50421a     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.lang.String r5 = r12.f50429i     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            int r6 = r12.f50424d     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            javax.mail.Session r3 = r12.session     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            boolean r7 = r3.getDebug()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            javax.mail.Session r3 = r12.session     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.io.PrintStream r8 = r3.getDebugOut()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            javax.mail.Session r3 = r12.session     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.util.Properties r9 = r3.getProperties()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            boolean r10 = r12.f50423c     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.lang.String r1 = r12.f50430j     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> Lcb
            java.lang.String r3 = r12.f50431k     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> Lcb
            r12.t(r11, r1, r3)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> Lcb
            goto L57
        L4e:
            r1 = r11
            goto L51
        L50:
        L51:
            if (r1 == 0) goto L56
            r1.n0()     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> Lcb
        L56:
            r11 = r0
        L57:
            if (r11 == 0) goto L66
            r11.a(r12)     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r1 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r1 = com.sun.mail.imap.k.a.c(r1)     // Catch: java.lang.Throwable -> Lcb
            r1.addElement(r11)     // Catch: java.lang.Throwable -> Lcb
            goto La0
        L66:
            com.sun.mail.iap.ConnectionException r0 = new com.sun.mail.iap.ConnectionException     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = "failed to create new store connection"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lcb
            throw r0     // Catch: java.lang.Throwable -> Lcb
        L6e:
            com.sun.mail.imap.k$a r1 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = com.sun.mail.imap.k.a.p(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto L93
            java.io.PrintStream r1 = r12.f50444y     // Catch: java.lang.Throwable -> Lcb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r4 = "DEBUG: getStoreProtocol() - connection available -- size: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r4 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r4 = com.sun.mail.imap.k.a.c(r4)     // Catch: java.lang.Throwable -> Lcb
            int r4 = r4.size()     // Catch: java.lang.Throwable -> Lcb
            r3.append(r4)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lcb
            r1.println(r3)     // Catch: java.lang.Throwable -> Lcb
        L93:
            com.sun.mail.imap.k$a r1 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r1 = com.sun.mail.imap.k.a.c(r1)     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r1 = r1.firstElement()     // Catch: java.lang.Throwable -> Lcb
            r11 = r1
            com.sun.mail.imap.protocol.h r11 = (com.sun.mail.imap.protocol.h) r11     // Catch: java.lang.Throwable -> Lcb
        La0:
            com.sun.mail.imap.k$a r1 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = com.sun.mail.imap.k.a.e(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Laf
            com.sun.mail.imap.k$a r1 = r12.f50445z     // Catch: java.lang.InterruptedException -> Lad java.lang.Throwable -> Lcb
            r1.wait()     // Catch: java.lang.InterruptedException -> Lad java.lang.Throwable -> Lcb
        Lad:
            r1 = r0
            goto Lc5
        Laf:
            com.sun.mail.imap.k$a r1 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            r3 = 1
            com.sun.mail.imap.k.a.h(r1, r3)     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r1 = r12.f50445z     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = com.sun.mail.imap.k.a.p(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Lc4
            java.io.PrintStream r1 = r12.f50444y     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r3 = "DEBUG: getStoreProtocol() -- storeConnectionInUse"
            r1.println(r3)     // Catch: java.lang.Throwable -> Lcb
        Lc4:
            r1 = r11
        Lc5:
            r12.z()     // Catch: java.lang.Throwable -> Lcb
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lcb
            goto L2
        Lcb:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lcb
            goto Lcf
        Lce:
            throw r0
        Lcf:
            goto Lce
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.k.n():com.sun.mail.imap.protocol.h");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(com.sun.mail.iap.g gVar) {
        String b4 = gVar.b();
        boolean z3 = false;
        if (b4.startsWith("[")) {
            int indexOf = b4.indexOf(93);
            if (indexOf > 0 && b4.substring(0, indexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z3 = true;
            }
            b4 = b4.substring(indexOf + 1).trim();
        }
        if (z3) {
            notifyStoreListeners(1, b4);
        } else if (!gVar.k() || b4.length() <= 0) {
        } else {
            notifyStoreListeners(2, b4);
        }
    }

    public synchronized boolean p(String str) throws MessagingException {
        boolean e02;
        com.sun.mail.imap.protocol.h hVar = null;
        try {
            hVar = n();
            e02 = hVar.e0(str);
            w(hVar);
        } catch (ProtocolException e4) {
            if (hVar == null) {
                c();
            }
            throw new MessagingException(e4.getMessage(), e4);
        }
        return e02;
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i4, String str2, String str3) throws MessagingException {
        boolean isEmpty;
        com.sun.mail.imap.protocol.h hVar = null;
        if (str != null && str3 != null && str2 != null) {
            if (i4 != -1) {
                this.f50424d = i4;
            } else {
                Session session = this.session;
                String property = session.getProperty("mail." + this.f50421a + ".port");
                if (property != null) {
                    this.f50424d = Integer.parseInt(property);
                }
            }
            if (this.f50424d == -1) {
                this.f50424d = this.f50422b;
            }
            try {
                try {
                    try {
                        synchronized (this.f50445z) {
                            isEmpty = this.f50445z.f50449a.isEmpty();
                        }
                        if (isEmpty) {
                            com.sun.mail.imap.protocol.h hVar2 = new com.sun.mail.imap.protocol.h(this.f50421a, str, this.f50424d, this.session.getDebug(), this.session.getDebugOut(), this.session.getProperties(), this.f50423c);
                            try {
                                if (this.debug) {
                                    PrintStream printStream = this.f50444y;
                                    printStream.println("DEBUG: protocolConnect login, host=" + str + ", user=" + str2 + ", password=<non-null>");
                                }
                                t(hVar2, str2, str3);
                                hVar2.a(this);
                                this.f50429i = str;
                                this.f50430j = str2;
                                this.f50431k = str3;
                                synchronized (this.f50445z) {
                                    this.f50445z.f50449a.addElement(hVar2);
                                }
                            } catch (CommandFailedException e4) {
                                e = e4;
                                hVar = hVar2;
                                if (hVar != null) {
                                    hVar.c();
                                }
                                throw new AuthenticationFailedException(e.getResponse().b());
                            }
                        }
                        this.f50443x = true;
                        return true;
                    } catch (ProtocolException e5) {
                        throw new MessagingException(e5.getMessage(), e5);
                    }
                } catch (CommandFailedException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                throw new MessagingException(e7.getMessage(), e7);
            }
        } else {
            if (this.debug) {
                PrintStream printStream2 = this.f50444y;
                StringBuilder sb = new StringBuilder("DEBUG: protocolConnect returning false, host=");
                sb.append(str);
                sb.append(", user=");
                sb.append(str2);
                sb.append(", password=");
                sb.append(str3 != null ? "<non-null>" : "<null>");
                printStream2.println(sb.toString());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f50445z.f50451c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        if (r5.f50442w == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
        if (r1.k() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        notifyStoreListeners(1000, r1.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.k.r():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        boolean z3;
        synchronized (this.f50445z) {
            if (this.f50445z.f50458j) {
                PrintStream printStream = this.f50444y;
                printStream.println("DEBUG: current size: " + this.f50445z.f50449a.size() + "   pool size: " + this.f50445z.f50456h);
            }
            z3 = this.f50445z.f50449a.size() >= this.f50445z.f50456h;
        }
        return z3;
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized void setQuota(Quota quota) throws MessagingException {
        checkConnected();
        try {
            try {
                try {
                    com.sun.mail.imap.protocol.h n4 = n();
                    n4.I0(quota);
                    w(n4);
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new StoreClosedException(this, e5.getMessage());
            }
        } catch (BadCommandException e6) {
            throw new MessagingException("QUOTA not supported", e6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(e eVar, com.sun.mail.imap.protocol.h hVar) {
        synchronized (this.f50445z) {
            if (hVar != null) {
                if (!s()) {
                    hVar.a(this);
                    this.f50445z.f50449a.addElement(hVar);
                    if (this.debug) {
                        PrintStream printStream = this.f50444y;
                        printStream.println("DEBUG: added an Authenticated connection -- size: " + this.f50445z.f50449a.size());
                    }
                } else {
                    if (this.debug) {
                        this.f50444y.println("DEBUG: pool is full, not adding an Authenticated connection");
                    }
                    try {
                        hVar.n0();
                    } catch (ProtocolException unused) {
                    }
                }
            }
            if (this.f50445z.f50450b != null) {
                this.f50445z.f50450b.removeElement(eVar);
            }
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(com.sun.mail.imap.protocol.h hVar) {
        if (hVar == null) {
            return;
        }
        synchronized (this.f50445z) {
            this.f50445z.f50452d = false;
            this.f50445z.notifyAll();
            if (this.f50445z.f50458j) {
                this.f50444y.println("DEBUG: releaseStoreProtocol()");
            }
            z();
        }
    }

    public synchronized void x(String str) {
        this.f50431k = str;
    }

    public synchronized void y(String str) {
        this.f50430j = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k(Session session, URLName uRLName, String str, int i4, boolean z3) {
        super(session, uRLName);
        this.f50421a = "imap";
        this.f50422b = 143;
        this.f50423c = false;
        this.f50424d = -1;
        this.f50425e = 16384;
        this.f50426f = 1000;
        this.f50427g = -1;
        this.f50428h = 10;
        this.f50436p = false;
        this.f50437r = false;
        this.f50438s = false;
        this.f50439t = false;
        this.f50441v = false;
        this.f50442w = false;
        this.f50443x = false;
        this.f50445z = new a();
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f50421a = str;
        this.f50422b = i4;
        this.f50423c = z3;
        this.f50445z.f50455g = System.currentTimeMillis();
        this.debug = session.getDebug();
        PrintStream debugOut = session.getDebugOut();
        this.f50444y = debugOut;
        if (debugOut == null) {
            this.f50444y = System.out;
        }
        String property = session.getProperty("mail." + str + ".connectionpool.debug");
        if (property != null && property.equalsIgnoreCase("true")) {
            this.f50445z.f50458j = true;
        }
        String property2 = session.getProperty("mail." + str + ".partialfetch");
        if (property2 != null && property2.equalsIgnoreCase("false")) {
            this.f50425e = -1;
            if (this.debug) {
                this.f50444y.println("DEBUG: mail.imap.partialfetch: false");
            }
        } else {
            String property3 = session.getProperty("mail." + str + ".fetchsize");
            if (property3 != null) {
                this.f50425e = Integer.parseInt(property3);
            }
            if (this.debug) {
                PrintStream printStream = this.f50444y;
                printStream.println("DEBUG: mail.imap.fetchsize: " + this.f50425e);
            }
        }
        String property4 = session.getProperty("mail." + str + ".statuscachetimeout");
        if (property4 != null) {
            this.f50426f = Integer.parseInt(property4);
            if (this.debug) {
                PrintStream printStream2 = this.f50444y;
                printStream2.println("DEBUG: mail.imap.statuscachetimeout: " + this.f50426f);
            }
        }
        String property5 = session.getProperty("mail." + str + ".appendbuffersize");
        if (property5 != null) {
            this.f50427g = Integer.parseInt(property5);
            if (this.debug) {
                PrintStream printStream3 = this.f50444y;
                printStream3.println("DEBUG: mail.imap.appendbuffersize: " + this.f50427g);
            }
        }
        String property6 = session.getProperty("mail." + str + ".minidletime");
        if (property6 != null) {
            this.f50428h = Integer.parseInt(property6);
            if (this.debug) {
                PrintStream printStream4 = this.f50444y;
                printStream4.println("DEBUG: mail.imap.minidletime: " + this.f50428h);
            }
        }
        String property7 = session.getProperty("mail." + str + ".connectionpoolsize");
        if (property7 != null) {
            try {
                int parseInt = Integer.parseInt(property7);
                if (parseInt > 0) {
                    this.f50445z.f50456h = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            if (this.f50445z.f50458j) {
                PrintStream printStream5 = this.f50444y;
                printStream5.println("DEBUG: mail.imap.connectionpoolsize: " + this.f50445z.f50456h);
            }
        }
        String property8 = session.getProperty("mail." + str + ".connectionpooltimeout");
        if (property8 != null) {
            try {
                int parseInt2 = Integer.parseInt(property8);
                if (parseInt2 > 0) {
                    this.f50445z.f50453e = parseInt2;
                }
            } catch (NumberFormatException unused2) {
            }
            if (this.f50445z.f50458j) {
                PrintStream printStream6 = this.f50444y;
                printStream6.println("DEBUG: mail.imap.connectionpooltimeout: " + this.f50445z.f50453e);
            }
        }
        String property9 = session.getProperty("mail." + str + ".servertimeout");
        if (property9 != null) {
            try {
                int parseInt3 = Integer.parseInt(property9);
                if (parseInt3 > 0) {
                    this.f50445z.f50454f = parseInt3;
                }
            } catch (NumberFormatException unused3) {
            }
            if (this.f50445z.f50458j) {
                PrintStream printStream7 = this.f50444y;
                printStream7.println("DEBUG: mail.imap.servertimeout: " + this.f50445z.f50454f);
            }
        }
        String property10 = session.getProperty("mail." + str + ".separatestoreconnection");
        if (property10 != null && property10.equalsIgnoreCase("true")) {
            if (this.f50445z.f50458j) {
                this.f50444y.println("DEBUG: dedicate a store connection");
            }
            this.f50445z.f50451c = true;
        }
        String property11 = session.getProperty("mail." + str + ".proxyauth.user");
        if (property11 != null) {
            this.f50432l = property11;
            if (this.debug) {
                PrintStream printStream8 = this.f50444y;
                printStream8.println("DEBUG: mail.imap.proxyauth.user: " + this.f50432l);
            }
        }
        String property12 = session.getProperty("mail." + str + ".auth.login.disable");
        if (property12 != null && property12.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f50444y.println("DEBUG: disable AUTH=LOGIN");
            }
            this.f50436p = true;
        }
        String property13 = session.getProperty("mail." + str + ".auth.plain.disable");
        if (property13 != null && property13.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f50444y.println("DEBUG: disable AUTH=PLAIN");
            }
            this.f50437r = true;
        }
        String property14 = session.getProperty("mail." + str + ".starttls.enable");
        if (property14 != null && property14.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f50444y.println("DEBUG: enable STARTTLS");
            }
            this.f50438s = true;
        }
        String property15 = session.getProperty("mail." + str + ".sasl.enable");
        if (property15 != null && property15.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f50444y.println("DEBUG: enable SASL");
            }
            this.f50439t = true;
        }
        if (this.f50439t) {
            String property16 = session.getProperty("mail." + str + ".sasl.mechanisms");
            if (property16 != null && property16.length() > 0) {
                if (this.debug) {
                    PrintStream printStream9 = this.f50444y;
                    printStream9.println("DEBUG: SASL mechanisms allowed: " + property16);
                }
                Vector vector = new Vector(5);
                StringTokenizer stringTokenizer = new StringTokenizer(property16, " ,");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.length() > 0) {
                        vector.addElement(nextToken);
                    }
                }
                String[] strArr = new String[vector.size()];
                this.f50440u = strArr;
                vector.copyInto(strArr);
            }
        }
        String property17 = session.getProperty("mail." + str + ".sasl.authorizationid");
        if (property17 != null) {
            this.f50433m = property17;
            if (this.debug) {
                PrintStream printStream10 = this.f50444y;
                printStream10.println("DEBUG: mail.imap.sasl.authorizationid: " + this.f50433m);
            }
        }
        String property18 = session.getProperty("mail." + str + ".sasl.realm");
        if (property18 != null) {
            this.f50434n = property18;
            if (this.debug) {
                PrintStream printStream11 = this.f50444y;
                printStream11.println("DEBUG: mail.imap.sasl.realm: " + this.f50434n);
            }
        }
        String property19 = session.getProperty("mail." + str + ".forcepasswordrefresh");
        if (property19 != null && property19.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f50444y.println("DEBUG: enable forcePasswordRefresh");
            }
            this.f50441v = true;
        }
        String property20 = session.getProperty("mail." + str + ".enableimapevents");
        if (property20 == null || !property20.equalsIgnoreCase("true")) {
            return;
        }
        if (this.debug) {
            this.f50444y.println("DEBUG: enable IMAP events");
        }
        this.f50442w = true;
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new e(uRLName.getFile(), '\uffff', this);
    }
}
