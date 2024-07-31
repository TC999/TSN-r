package com.sun.mail.imap;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.Namespaces;
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
import kotlin.jvm.internal.C14356p;

/* renamed from: com.sun.mail.imap.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPStore extends Store implements QuotaAwareStore, ResponseHandler {

    /* renamed from: A */
    public static final int f36007A = 1000;

    /* renamed from: B */
    static final /* synthetic */ boolean f36008B = false;

    /* renamed from: a */
    private String f36009a;

    /* renamed from: b */
    private int f36010b;

    /* renamed from: c */
    private boolean f36011c;

    /* renamed from: d */
    private int f36012d;

    /* renamed from: e */
    private int f36013e;

    /* renamed from: f */
    private int f36014f;

    /* renamed from: g */
    private int f36015g;

    /* renamed from: h */
    private int f36016h;

    /* renamed from: i */
    private String f36017i;

    /* renamed from: j */
    private String f36018j;

    /* renamed from: k */
    private String f36019k;

    /* renamed from: l */
    private String f36020l;

    /* renamed from: m */
    private String f36021m;

    /* renamed from: n */
    private String f36022n;

    /* renamed from: o */
    private Namespaces f36023o;

    /* renamed from: p */
    private boolean f36024p;

    /* renamed from: r */
    private boolean f36025r;

    /* renamed from: s */
    private boolean f36026s;

    /* renamed from: t */
    private boolean f36027t;

    /* renamed from: u */
    private String[] f36028u;

    /* renamed from: v */
    private boolean f36029v;

    /* renamed from: w */
    private boolean f36030w;

    /* renamed from: x */
    private volatile boolean f36031x;

    /* renamed from: y */
    private PrintStream f36032y;

    /* renamed from: z */
    private C12753a f36033z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMAPStore.java */
    /* renamed from: com.sun.mail.imap.k$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12753a {

        /* renamed from: m */
        private static final int f36034m = 0;

        /* renamed from: n */
        private static final int f36035n = 1;

        /* renamed from: o */
        private static final int f36036o = 2;

        /* renamed from: b */
        private Vector f36038b;

        /* renamed from: g */
        private long f36043g;

        /* renamed from: l */
        private IMAPProtocol f36048l;

        /* renamed from: a */
        private Vector f36037a = new Vector();

        /* renamed from: c */
        private boolean f36039c = false;

        /* renamed from: d */
        private boolean f36040d = false;

        /* renamed from: e */
        private long f36041e = 45000;

        /* renamed from: f */
        private long f36042f = 1800000;

        /* renamed from: h */
        private int f36044h = 1;

        /* renamed from: i */
        private long f36045i = 60000;

        /* renamed from: j */
        private boolean f36046j = false;

        /* renamed from: k */
        private int f36047k = 0;

        C12753a() {
        }
    }

    public IMAPStore(Session session, URLName uRLName) {
        this(session, uRLName, "imap", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, false);
    }

    /* renamed from: A */
    private void m16289A() throws ProtocolException {
        while (this.f36033z.f36047k != 0) {
            if (this.f36033z.f36047k == 1) {
                this.f36033z.f36048l.m16155f0();
                this.f36033z.f36047k = 2;
            }
            try {
                this.f36033z.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    /* renamed from: c */
    private void m16286c() {
        m16285d(false);
    }

    private void checkConnected() {
        if (this.f36031x) {
            return;
        }
        super.setConnected(false);
        throw new IllegalStateException("Not connected");
    }

    /* renamed from: d */
    private void m16285d(boolean z) {
        boolean z2;
        if (this.debug) {
            this.f36032y.println("DEBUG: IMAPStore cleanup, force " + z);
        }
        Vector vector = null;
        while (true) {
            synchronized (this.f36033z) {
                if (this.f36033z.f36038b != null) {
                    vector = this.f36033z.f36038b;
                    this.f36033z.f36038b = null;
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                break;
            }
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                IMAPFolder iMAPFolder = (IMAPFolder) vector.elementAt(i);
                if (z) {
                    try {
                        if (this.debug) {
                            this.f36032y.println("DEBUG: force folder to close");
                        }
                        iMAPFolder.m16334w();
                    } catch (IllegalStateException | MessagingException unused) {
                    }
                } else {
                    if (this.debug) {
                        this.f36032y.println("DEBUG: close folder");
                    }
                    iMAPFolder.close(false);
                }
            }
        }
        synchronized (this.f36033z) {
            m16284e(z);
        }
        this.f36031x = false;
        notifyConnectionListeners(3);
        if (this.debug) {
            this.f36032y.println("DEBUG: IMAPStore cleanup done");
        }
    }

    /* renamed from: e */
    private void m16284e(boolean z) {
        synchronized (this.f36033z) {
            for (int size = this.f36033z.f36037a.size() - 1; size >= 0; size--) {
                try {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.f36033z.f36037a.elementAt(size);
                    iMAPProtocol.m16413m(this);
                    if (z) {
                        iMAPProtocol.mo16160c();
                    } else {
                        iMAPProtocol.m16145n0();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.f36033z.f36037a.removeAllElements();
        }
        if (this.f36033z.f36046j) {
            this.f36032y.println("DEBUG: removed all authenticated connections");
        }
    }

    /* renamed from: j */
    private synchronized Namespaces m16279j() throws MessagingException {
        checkConnected();
        IMAPProtocol iMAPProtocol = null;
        if (this.f36023o == null) {
            try {
                iMAPProtocol = m16275n();
                this.f36023o = iMAPProtocol.m16141q0();
                m16266w(iMAPProtocol);
            } catch (BadCommandException unused) {
                m16266w(iMAPProtocol);
                if (iMAPProtocol == null) {
                    m16286c();
                }
            } catch (ConnectionException e) {
                throw new StoreClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        return this.f36023o;
    }

    /* renamed from: t */
    private void m16269t(IMAPProtocol iMAPProtocol, String str, String str2) throws ProtocolException {
        if (this.f36026s && iMAPProtocol.m16157e0("STARTTLS")) {
            iMAPProtocol.m16187J0();
            iMAPProtocol.m16130w();
        }
        if (iMAPProtocol.m16153h0()) {
            return;
        }
        iMAPProtocol.m16162a0().put("__PRELOGIN__", "");
        String str3 = this.f36021m;
        if (str3 == null && (str3 = this.f36020l) == null) {
            str3 = str;
        }
        if (this.f36027t) {
            iMAPProtocol.m16203B0(this.f36028u, this.f36022n, str3, str, str2);
        }
        if (!iMAPProtocol.m16153h0()) {
            if (iMAPProtocol.m16157e0("AUTH=PLAIN") && !this.f36025r) {
                iMAPProtocol.m16132v(str3, str, str2);
            } else if ((iMAPProtocol.m16157e0("AUTH-LOGIN") || iMAPProtocol.m16157e0("AUTH=LOGIN")) && !this.f36024p) {
                iMAPProtocol.m16134u(str, str2);
            } else if (!iMAPProtocol.m16157e0("LOGINDISABLED")) {
                iMAPProtocol.m16146m0(str, str2);
            } else {
                throw new ProtocolException("No login methods supported!");
            }
        }
        String str4 = this.f36020l;
        if (str4 != null) {
            iMAPProtocol.m16125y0(str4);
        }
        if (iMAPProtocol.m16157e0("__PRELOGIN__")) {
            try {
                iMAPProtocol.m16130w();
            } catch (ConnectionException e) {
                throw e;
            } catch (ProtocolException unused) {
            }
        }
    }

    /* renamed from: u */
    private Folder[] m16268u(Namespaces.C12761a[] c12761aArr, String str) {
        int length = c12761aArr.length;
        Folder[] folderArr = new Folder[length];
        for (int i = 0; i < length; i++) {
            String str2 = c12761aArr[i].f36171a;
            if (str == null) {
                int length2 = str2.length();
                if (length2 > 0) {
                    int i2 = length2 - 1;
                    if (str2.charAt(i2) == c12761aArr[i].f36172b) {
                        str2 = str2.substring(0, i2);
                    }
                }
            } else {
                str2 = String.valueOf(str2) + str;
            }
            folderArr[i] = new IMAPFolder(str2, c12761aArr[i].f36172b, this, str == null);
        }
        return folderArr;
    }

    /* renamed from: z */
    private void m16263z() {
        synchronized (this.f36033z) {
            if (System.currentTimeMillis() - this.f36033z.f36043g > this.f36033z.f36045i && this.f36033z.f36037a.size() > 1) {
                if (this.f36033z.f36046j) {
                    this.f36032y.println("DEBUG: checking for connections to prune: " + (System.currentTimeMillis() - this.f36033z.f36043g));
                    this.f36032y.println("DEBUG: clientTimeoutInterval: " + this.f36033z.f36041e);
                }
                for (int size = this.f36033z.f36037a.size() - 1; size > 0; size--) {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.f36033z.f36037a.elementAt(size);
                    if (this.f36033z.f36046j) {
                        this.f36032y.println("DEBUG: protocol last used: " + (System.currentTimeMillis() - iMAPProtocol.m16417g()));
                    }
                    if (System.currentTimeMillis() - iMAPProtocol.m16417g() > this.f36033z.f36041e) {
                        if (this.f36033z.f36046j) {
                            this.f36032y.println("DEBUG: authenticated connection timed out");
                            this.f36032y.println("DEBUG: logging out the connection");
                        }
                        iMAPProtocol.m16413m(this);
                        this.f36033z.f36037a.removeElementAt(size);
                        try {
                            iMAPProtocol.m16145n0();
                        } catch (ProtocolException unused) {
                        }
                    }
                }
                this.f36033z.f36043g = System.currentTimeMillis();
            }
        }
    }

    @Override // com.sun.mail.iap.ResponseHandler
    /* renamed from: a */
    public void mo16288a(C12728g c12728g) {
        if (c12728g.m16399h() || c12728g.m16400g() || c12728g.m16403d() || c12728g.m16402e()) {
            m16274o(c12728g);
        }
        if (c12728g.m16402e()) {
            if (this.debug) {
                this.f36032y.println("DEBUG: IMAPStore connection dead");
            }
            if (this.f36031x) {
                m16285d(c12728g.m16398i());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m16287b() {
        Session session = this.session;
        String property = session.getProperty("mail." + this.f36009a + ".allowreadonlyselect");
        return property != null && property.equalsIgnoreCase("true");
    }

    @Override // javax.mail.Service
    public synchronized void close() throws MessagingException {
        boolean isEmpty;
        if (super.isConnected()) {
            try {
                synchronized (this.f36033z) {
                    isEmpty = this.f36033z.f36037a.isEmpty();
                }
                if (isEmpty) {
                    if (this.f36033z.f36046j) {
                        this.f36032y.println("DEBUG: close() - no connections ");
                    }
                    m16286c();
                    m16266w(null);
                    return;
                }
                IMAPProtocol m16275n = m16275n();
                synchronized (this.f36033z) {
                    this.f36033z.f36037a.removeElement(m16275n);
                }
                m16275n.m16145n0();
                m16266w(m16275n);
            } catch (ProtocolException e) {
                m16286c();
                throw new MessagingException(e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public int m16283f() {
        return this.f36015g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Service
    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean m16282g() {
        return this.f36033z.f36046j;
    }

    @Override // javax.mail.Store
    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new IMAPFolder(str, C14356p.f41165b, this);
    }

    @Override // javax.mail.Store
    public Folder[] getPersonalNamespaces() throws MessagingException {
        Namespaces.C12761a[] c12761aArr;
        Namespaces m16279j = m16279j();
        if (m16279j != null && (c12761aArr = m16279j.f36168a) != null) {
            return m16268u(c12761aArr, null);
        }
        return super.getPersonalNamespaces();
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized Quota[] getQuota(String str) throws MessagingException {
        Quota[] m16158d0;
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol m16275n = m16275n();
                    m16158d0 = m16275n.m16158d0(str);
                    m16266w(m16275n);
                } catch (ProtocolException e) {
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this, e2.getMessage());
            }
        } catch (BadCommandException e3) {
            throw new MessagingException("QUOTA not supported", e3);
        }
        return m16158d0;
    }

    @Override // javax.mail.Store
    public Folder[] getSharedNamespaces() throws MessagingException {
        Namespaces.C12761a[] c12761aArr;
        Namespaces m16279j = m16279j();
        if (m16279j != null && (c12761aArr = m16279j.f36170c) != null) {
            return m16268u(c12761aArr, null);
        }
        return super.getSharedNamespaces();
    }

    @Override // javax.mail.Store
    public Folder[] getUserNamespaces(String str) throws MessagingException {
        Namespaces.C12761a[] c12761aArr;
        Namespaces m16279j = m16279j();
        if (m16279j != null && (c12761aArr = m16279j.f36169b) != null) {
            return m16268u(c12761aArr, str);
        }
        return super.getUserNamespaces(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public int m16281h() {
        return this.f36013e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public int m16280i() {
        return this.f36016h;
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!this.f36031x) {
            super.setConnected(false);
            return false;
        }
        IMAPProtocol iMAPProtocol = null;
        try {
            iMAPProtocol = m16275n();
            iMAPProtocol.m16139r0();
        } catch (ProtocolException unused) {
            if (iMAPProtocol == null) {
                m16286c();
            }
        }
        m16266w(iMAPProtocol);
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
        r1.mo16160c();
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
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sun.mail.imap.protocol.IMAPProtocol m16278k(com.sun.mail.imap.IMAPFolder r13) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.m16278k(com.sun.mail.imap.e):com.sun.mail.imap.protocol.h");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public Session m16277l() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public int m16276m() {
        return this.f36014f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0059 A[Catch: all -> 0x00cb, TRY_ENTER, TryCatch #4 {, blocks: (B:7:0x0008, B:9:0x0017, B:11:0x001f, B:12:0x0026, B:13:0x0046, B:21:0x0059, B:28:0x00a0, B:30:0x00a8, B:32:0x00af, B:34:0x00bd, B:36:0x00c5, B:37:0x00c8, B:22:0x0066, B:23:0x006d, B:18:0x0053, B:24:0x006e, B:26:0x0076, B:27:0x0093), top: B:54:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0066 A[SYNTHETIC] */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sun.mail.imap.protocol.IMAPProtocol m16275n() throws com.sun.mail.iap.ProtocolException {
        /*
            r12 = this;
            r0 = 0
            r1 = r0
        L2:
            if (r1 == 0) goto L5
            return r1
        L5:
            com.sun.mail.imap.k$a r2 = r12.f36033z
            monitor-enter(r2)
            r12.m16289A()     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r3 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r3 = com.sun.mail.imap.IMAPStore.C12753a.m16260c(r3)     // Catch: java.lang.Throwable -> Lcb
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> Lcb
            if (r3 == 0) goto L6e
            com.sun.mail.imap.k$a r3 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            boolean r3 = com.sun.mail.imap.IMAPStore.C12753a.m16247p(r3)     // Catch: java.lang.Throwable -> Lcb
            if (r3 == 0) goto L26
            java.io.PrintStream r3 = r12.f36032y     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r4 = "DEBUG: getStoreProtocol() - no connections in the pool, creating a new one"
            r3.println(r4)     // Catch: java.lang.Throwable -> Lcb
        L26:
            com.sun.mail.imap.protocol.h r11 = new com.sun.mail.imap.protocol.h     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.lang.String r4 = r12.f36009a     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.lang.String r5 = r12.f36017i     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            int r6 = r12.f36012d     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            javax.mail.Session r3 = r12.session     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            boolean r7 = r3.getDebug()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            javax.mail.Session r3 = r12.session     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.io.PrintStream r8 = r3.getDebugOut()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            javax.mail.Session r3 = r12.session     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.util.Properties r9 = r3.getProperties()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            boolean r10 = r12.f36011c     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> Lcb
            java.lang.String r1 = r12.f36018j     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> Lcb
            java.lang.String r3 = r12.f36019k     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> Lcb
            r12.m16269t(r11, r1, r3)     // Catch: java.lang.Exception -> L4e java.lang.Throwable -> Lcb
            goto L57
        L4e:
            r1 = r11
            goto L51
        L50:
        L51:
            if (r1 == 0) goto L56
            r1.m16145n0()     // Catch: java.lang.Exception -> L56 java.lang.Throwable -> Lcb
        L56:
            r11 = r0
        L57:
            if (r11 == 0) goto L66
            r11.m16421a(r12)     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r1 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r1 = com.sun.mail.imap.IMAPStore.C12753a.m16260c(r1)     // Catch: java.lang.Throwable -> Lcb
            r1.addElement(r11)     // Catch: java.lang.Throwable -> Lcb
            goto La0
        L66:
            com.sun.mail.iap.ConnectionException r0 = new com.sun.mail.iap.ConnectionException     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r1 = "failed to create new store connection"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lcb
            throw r0     // Catch: java.lang.Throwable -> Lcb
        L6e:
            com.sun.mail.imap.k$a r1 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = com.sun.mail.imap.IMAPStore.C12753a.m16247p(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto L93
            java.io.PrintStream r1 = r12.f36032y     // Catch: java.lang.Throwable -> Lcb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r4 = "DEBUG: getStoreProtocol() - connection available -- size: "
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r4 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r4 = com.sun.mail.imap.IMAPStore.C12753a.m16260c(r4)     // Catch: java.lang.Throwable -> Lcb
            int r4 = r4.size()     // Catch: java.lang.Throwable -> Lcb
            r3.append(r4)     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lcb
            r1.println(r3)     // Catch: java.lang.Throwable -> Lcb
        L93:
            com.sun.mail.imap.k$a r1 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            java.util.Vector r1 = com.sun.mail.imap.IMAPStore.C12753a.m16260c(r1)     // Catch: java.lang.Throwable -> Lcb
            java.lang.Object r1 = r1.firstElement()     // Catch: java.lang.Throwable -> Lcb
            r11 = r1
            com.sun.mail.imap.protocol.h r11 = (com.sun.mail.imap.protocol.IMAPProtocol) r11     // Catch: java.lang.Throwable -> Lcb
        La0:
            com.sun.mail.imap.k$a r1 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = com.sun.mail.imap.IMAPStore.C12753a.m16258e(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Laf
            com.sun.mail.imap.k$a r1 = r12.f36033z     // Catch: java.lang.InterruptedException -> Lad java.lang.Throwable -> Lcb
            r1.wait()     // Catch: java.lang.InterruptedException -> Lad java.lang.Throwable -> Lcb
        Lad:
            r1 = r0
            goto Lc5
        Laf:
            com.sun.mail.imap.k$a r1 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            r3 = 1
            com.sun.mail.imap.IMAPStore.C12753a.m16255h(r1, r3)     // Catch: java.lang.Throwable -> Lcb
            com.sun.mail.imap.k$a r1 = r12.f36033z     // Catch: java.lang.Throwable -> Lcb
            boolean r1 = com.sun.mail.imap.IMAPStore.C12753a.m16247p(r1)     // Catch: java.lang.Throwable -> Lcb
            if (r1 == 0) goto Lc4
            java.io.PrintStream r1 = r12.f36032y     // Catch: java.lang.Throwable -> Lcb
            java.lang.String r3 = "DEBUG: getStoreProtocol() -- storeConnectionInUse"
            r1.println(r3)     // Catch: java.lang.Throwable -> Lcb
        Lc4:
            r1 = r11
        Lc5:
            r12.m16263z()     // Catch: java.lang.Throwable -> Lcb
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
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.m16275n():com.sun.mail.imap.protocol.h");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m16274o(C12728g c12728g) {
        String m16405b = c12728g.m16405b();
        boolean z = false;
        if (m16405b.startsWith("[")) {
            int indexOf = m16405b.indexOf(93);
            if (indexOf > 0 && m16405b.substring(0, indexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z = true;
            }
            m16405b = m16405b.substring(indexOf + 1).trim();
        }
        if (z) {
            notifyStoreListeners(1, m16405b);
        } else if (!c12728g.m16396k() || m16405b.length() <= 0) {
        } else {
            notifyStoreListeners(2, m16405b);
        }
    }

    /* renamed from: p */
    public synchronized boolean m16273p(String str) throws MessagingException {
        boolean m16157e0;
        IMAPProtocol iMAPProtocol = null;
        try {
            iMAPProtocol = m16275n();
            m16157e0 = iMAPProtocol.m16157e0(str);
            m16266w(iMAPProtocol);
        } catch (ProtocolException e) {
            if (iMAPProtocol == null) {
                m16286c();
            }
            throw new MessagingException(e.getMessage(), e);
        }
        return m16157e0;
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i, String str2, String str3) throws MessagingException {
        boolean isEmpty;
        IMAPProtocol iMAPProtocol = null;
        if (str != null && str3 != null && str2 != null) {
            if (i != -1) {
                this.f36012d = i;
            } else {
                Session session = this.session;
                String property = session.getProperty("mail." + this.f36009a + ".port");
                if (property != null) {
                    this.f36012d = Integer.parseInt(property);
                }
            }
            if (this.f36012d == -1) {
                this.f36012d = this.f36010b;
            }
            try {
                try {
                    try {
                        synchronized (this.f36033z) {
                            isEmpty = this.f36033z.f36037a.isEmpty();
                        }
                        if (isEmpty) {
                            IMAPProtocol iMAPProtocol2 = new IMAPProtocol(this.f36009a, str, this.f36012d, this.session.getDebug(), this.session.getDebugOut(), this.session.getProperties(), this.f36011c);
                            try {
                                if (this.debug) {
                                    PrintStream printStream = this.f36032y;
                                    printStream.println("DEBUG: protocolConnect login, host=" + str + ", user=" + str2 + ", password=<non-null>");
                                }
                                m16269t(iMAPProtocol2, str2, str3);
                                iMAPProtocol2.m16421a(this);
                                this.f36017i = str;
                                this.f36018j = str2;
                                this.f36019k = str3;
                                synchronized (this.f36033z) {
                                    this.f36033z.f36037a.addElement(iMAPProtocol2);
                                }
                            } catch (CommandFailedException e) {
                                e = e;
                                iMAPProtocol = iMAPProtocol2;
                                if (iMAPProtocol != null) {
                                    iMAPProtocol.mo16160c();
                                }
                                throw new AuthenticationFailedException(e.getResponse().m16405b());
                            }
                        }
                        this.f36031x = true;
                        return true;
                    } catch (ProtocolException e2) {
                        throw new MessagingException(e2.getMessage(), e2);
                    }
                } catch (CommandFailedException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            }
        } else {
            if (this.debug) {
                PrintStream printStream2 = this.f36032y;
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
    /* renamed from: q */
    public boolean m16272q() {
        return this.f36033z.f36039c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
        if (r5.f36030w == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003d, code lost:
        if (r1.m16396k() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
        notifyStoreListeners(1000, r1.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m16271r() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.m16271r():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public boolean m16270s() {
        boolean z;
        synchronized (this.f36033z) {
            if (this.f36033z.f36046j) {
                PrintStream printStream = this.f36032y;
                printStream.println("DEBUG: current size: " + this.f36033z.f36037a.size() + "   pool size: " + this.f36033z.f36044h);
            }
            z = this.f36033z.f36037a.size() >= this.f36033z.f36044h;
        }
        return z;
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized void setQuota(Quota quota) throws MessagingException {
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol m16275n = m16275n();
                    m16275n.m16189I0(quota);
                    m16266w(m16275n);
                } catch (ProtocolException e) {
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this, e2.getMessage());
            }
        } catch (BadCommandException e3) {
            throw new MessagingException("QUOTA not supported", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: v */
    public void m16267v(IMAPFolder iMAPFolder, IMAPProtocol iMAPProtocol) {
        synchronized (this.f36033z) {
            if (iMAPProtocol != null) {
                if (!m16270s()) {
                    iMAPProtocol.m16421a(this);
                    this.f36033z.f36037a.addElement(iMAPProtocol);
                    if (this.debug) {
                        PrintStream printStream = this.f36032y;
                        printStream.println("DEBUG: added an Authenticated connection -- size: " + this.f36033z.f36037a.size());
                    }
                } else {
                    if (this.debug) {
                        this.f36032y.println("DEBUG: pool is full, not adding an Authenticated connection");
                    }
                    try {
                        iMAPProtocol.m16145n0();
                    } catch (ProtocolException unused) {
                    }
                }
            }
            if (this.f36033z.f36038b != null) {
                this.f36033z.f36038b.removeElement(iMAPFolder);
            }
            m16263z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public void m16266w(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol == null) {
            return;
        }
        synchronized (this.f36033z) {
            this.f36033z.f36040d = false;
            this.f36033z.notifyAll();
            if (this.f36033z.f36046j) {
                this.f36032y.println("DEBUG: releaseStoreProtocol()");
            }
            m16263z();
        }
    }

    /* renamed from: x */
    public synchronized void m16265x(String str) {
        this.f36019k = str;
    }

    /* renamed from: y */
    public synchronized void m16264y(String str) {
        this.f36018j = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPStore(Session session, URLName uRLName, String str, int i, boolean z) {
        super(session, uRLName);
        this.f36009a = "imap";
        this.f36010b = TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE;
        this.f36011c = false;
        this.f36012d = -1;
        this.f36013e = 16384;
        this.f36014f = 1000;
        this.f36015g = -1;
        this.f36016h = 10;
        this.f36024p = false;
        this.f36025r = false;
        this.f36026s = false;
        this.f36027t = false;
        this.f36029v = false;
        this.f36030w = false;
        this.f36031x = false;
        this.f36033z = new C12753a();
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f36009a = str;
        this.f36010b = i;
        this.f36011c = z;
        this.f36033z.f36043g = System.currentTimeMillis();
        this.debug = session.getDebug();
        PrintStream debugOut = session.getDebugOut();
        this.f36032y = debugOut;
        if (debugOut == null) {
            this.f36032y = System.out;
        }
        String property = session.getProperty("mail." + str + ".connectionpool.debug");
        if (property != null && property.equalsIgnoreCase("true")) {
            this.f36033z.f36046j = true;
        }
        String property2 = session.getProperty("mail." + str + ".partialfetch");
        if (property2 != null && property2.equalsIgnoreCase("false")) {
            this.f36013e = -1;
            if (this.debug) {
                this.f36032y.println("DEBUG: mail.imap.partialfetch: false");
            }
        } else {
            String property3 = session.getProperty("mail." + str + ".fetchsize");
            if (property3 != null) {
                this.f36013e = Integer.parseInt(property3);
            }
            if (this.debug) {
                PrintStream printStream = this.f36032y;
                printStream.println("DEBUG: mail.imap.fetchsize: " + this.f36013e);
            }
        }
        String property4 = session.getProperty("mail." + str + ".statuscachetimeout");
        if (property4 != null) {
            this.f36014f = Integer.parseInt(property4);
            if (this.debug) {
                PrintStream printStream2 = this.f36032y;
                printStream2.println("DEBUG: mail.imap.statuscachetimeout: " + this.f36014f);
            }
        }
        String property5 = session.getProperty("mail." + str + ".appendbuffersize");
        if (property5 != null) {
            this.f36015g = Integer.parseInt(property5);
            if (this.debug) {
                PrintStream printStream3 = this.f36032y;
                printStream3.println("DEBUG: mail.imap.appendbuffersize: " + this.f36015g);
            }
        }
        String property6 = session.getProperty("mail." + str + ".minidletime");
        if (property6 != null) {
            this.f36016h = Integer.parseInt(property6);
            if (this.debug) {
                PrintStream printStream4 = this.f36032y;
                printStream4.println("DEBUG: mail.imap.minidletime: " + this.f36016h);
            }
        }
        String property7 = session.getProperty("mail." + str + ".connectionpoolsize");
        if (property7 != null) {
            try {
                int parseInt = Integer.parseInt(property7);
                if (parseInt > 0) {
                    this.f36033z.f36044h = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            if (this.f36033z.f36046j) {
                PrintStream printStream5 = this.f36032y;
                printStream5.println("DEBUG: mail.imap.connectionpoolsize: " + this.f36033z.f36044h);
            }
        }
        String property8 = session.getProperty("mail." + str + ".connectionpooltimeout");
        if (property8 != null) {
            try {
                int parseInt2 = Integer.parseInt(property8);
                if (parseInt2 > 0) {
                    this.f36033z.f36041e = parseInt2;
                }
            } catch (NumberFormatException unused2) {
            }
            if (this.f36033z.f36046j) {
                PrintStream printStream6 = this.f36032y;
                printStream6.println("DEBUG: mail.imap.connectionpooltimeout: " + this.f36033z.f36041e);
            }
        }
        String property9 = session.getProperty("mail." + str + ".servertimeout");
        if (property9 != null) {
            try {
                int parseInt3 = Integer.parseInt(property9);
                if (parseInt3 > 0) {
                    this.f36033z.f36042f = parseInt3;
                }
            } catch (NumberFormatException unused3) {
            }
            if (this.f36033z.f36046j) {
                PrintStream printStream7 = this.f36032y;
                printStream7.println("DEBUG: mail.imap.servertimeout: " + this.f36033z.f36042f);
            }
        }
        String property10 = session.getProperty("mail." + str + ".separatestoreconnection");
        if (property10 != null && property10.equalsIgnoreCase("true")) {
            if (this.f36033z.f36046j) {
                this.f36032y.println("DEBUG: dedicate a store connection");
            }
            this.f36033z.f36039c = true;
        }
        String property11 = session.getProperty("mail." + str + ".proxyauth.user");
        if (property11 != null) {
            this.f36020l = property11;
            if (this.debug) {
                PrintStream printStream8 = this.f36032y;
                printStream8.println("DEBUG: mail.imap.proxyauth.user: " + this.f36020l);
            }
        }
        String property12 = session.getProperty("mail." + str + ".auth.login.disable");
        if (property12 != null && property12.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f36032y.println("DEBUG: disable AUTH=LOGIN");
            }
            this.f36024p = true;
        }
        String property13 = session.getProperty("mail." + str + ".auth.plain.disable");
        if (property13 != null && property13.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f36032y.println("DEBUG: disable AUTH=PLAIN");
            }
            this.f36025r = true;
        }
        String property14 = session.getProperty("mail." + str + ".starttls.enable");
        if (property14 != null && property14.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f36032y.println("DEBUG: enable STARTTLS");
            }
            this.f36026s = true;
        }
        String property15 = session.getProperty("mail." + str + ".sasl.enable");
        if (property15 != null && property15.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f36032y.println("DEBUG: enable SASL");
            }
            this.f36027t = true;
        }
        if (this.f36027t) {
            String property16 = session.getProperty("mail." + str + ".sasl.mechanisms");
            if (property16 != null && property16.length() > 0) {
                if (this.debug) {
                    PrintStream printStream9 = this.f36032y;
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
                this.f36028u = strArr;
                vector.copyInto(strArr);
            }
        }
        String property17 = session.getProperty("mail." + str + ".sasl.authorizationid");
        if (property17 != null) {
            this.f36021m = property17;
            if (this.debug) {
                PrintStream printStream10 = this.f36032y;
                printStream10.println("DEBUG: mail.imap.sasl.authorizationid: " + this.f36021m);
            }
        }
        String property18 = session.getProperty("mail." + str + ".sasl.realm");
        if (property18 != null) {
            this.f36022n = property18;
            if (this.debug) {
                PrintStream printStream11 = this.f36032y;
                printStream11.println("DEBUG: mail.imap.sasl.realm: " + this.f36022n);
            }
        }
        String property19 = session.getProperty("mail." + str + ".forcepasswordrefresh");
        if (property19 != null && property19.equalsIgnoreCase("true")) {
            if (this.debug) {
                this.f36032y.println("DEBUG: enable forcePasswordRefresh");
            }
            this.f36029v = true;
        }
        String property20 = session.getProperty("mail." + str + ".enableimapevents");
        if (property20 == null || !property20.equalsIgnoreCase("true")) {
            return;
        }
        if (this.debug) {
            this.f36032y.println("DEBUG: enable IMAP events");
        }
        this.f36030w = true;
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new IMAPFolder(uRLName.getFile(), C14356p.f41165b, this);
    }
}
