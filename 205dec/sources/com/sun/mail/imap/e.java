package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.v;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Vector;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.ReadOnlyFolderException;
import javax.mail.StoreClosedException;
import javax.mail.UIDFolder;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPFolder.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e extends Folder implements UIDFolder, com.sun.mail.iap.h {
    protected static final char C = '\uffff';
    private static final int D = 0;
    private static final int E = 1;
    private static final int F = 2;
    static final /* synthetic */ boolean G = false;
    private PrintStream A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    protected String f50321a;

    /* renamed from: b  reason: collision with root package name */
    protected String f50322b;

    /* renamed from: c  reason: collision with root package name */
    protected int f50323c;

    /* renamed from: d  reason: collision with root package name */
    protected char f50324d;

    /* renamed from: e  reason: collision with root package name */
    protected Flags f50325e;

    /* renamed from: f  reason: collision with root package name */
    protected Flags f50326f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f50327g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f50328h;

    /* renamed from: i  reason: collision with root package name */
    protected String[] f50329i;

    /* renamed from: j  reason: collision with root package name */
    protected com.sun.mail.imap.protocol.h f50330j;

    /* renamed from: k  reason: collision with root package name */
    protected Vector f50331k;

    /* renamed from: l  reason: collision with root package name */
    protected Object f50332l;

    /* renamed from: m  reason: collision with root package name */
    protected Hashtable f50333m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f50334n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f50335o;

    /* renamed from: p  reason: collision with root package name */
    private int f50336p;

    /* renamed from: r  reason: collision with root package name */
    private int f50337r;

    /* renamed from: s  reason: collision with root package name */
    private int f50338s;

    /* renamed from: t  reason: collision with root package name */
    private int f50339t;

    /* renamed from: u  reason: collision with root package name */
    private long f50340u;

    /* renamed from: v  reason: collision with root package name */
    private long f50341v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f50342w;

    /* renamed from: x  reason: collision with root package name */
    private com.sun.mail.imap.protocol.u f50343x;

    /* renamed from: y  reason: collision with root package name */
    private long f50344y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f50345z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ Flags f50347b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ Date f50348c;

        /* renamed from: d  reason: collision with root package name */
        private final /* synthetic */ com.sun.mail.imap.m f50349d;

        a(Flags flags, Date date, com.sun.mail.imap.m mVar) {
            this.f50347b = flags;
            this.f50348c = date;
            this.f50349d = mVar;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.r(e.this.f50321a, this.f50347b, this.f50348c, this.f50349d);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ Flags f50351b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ Date f50352c;

        /* renamed from: d  reason: collision with root package name */
        private final /* synthetic */ com.sun.mail.imap.m f50353d;

        b(Flags flags, Date date, com.sun.mail.imap.m mVar) {
            this.f50351b = flags;
            this.f50352c = date;
            this.f50353d = mVar;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.s(e.this.f50321a, this.f50351b, this.f50352c, this.f50353d);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class c implements u {
        c() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.d0(e.this.f50321a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class d implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ Quota f50356b;

        d(Quota quota) {
            this.f50356b = quota;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.I0(this.f50356b);
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class C1027e implements u {
        C1027e() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.Y(e.this.f50321a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class f implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ String f50359b;

        f(String str) {
            this.f50359b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.E(e.this.f50321a, this.f50359b);
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class g implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ String f50361b;

        g(String str) {
            this.f50361b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.l0(e.this.f50321a, this.f50361b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class h implements u {
        h() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.p0(e.this.f50321a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class i implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ char f50364b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ com.sun.mail.imap.a f50365c;

        i(char c4, com.sun.mail.imap.a aVar) {
            this.f50364b = c4;
            this.f50365c = aVar;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.G0(e.this.f50321a, this.f50364b, this.f50365c);
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class j implements u {
        j() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (e.this.f50336p == 0) {
                hVar.g0();
                e.this.f50336p = 1;
                return Boolean.TRUE;
            }
            try {
                e.this.f50332l.wait();
            } catch (InterruptedException unused) {
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class k implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ String f50368b;

        k(String str) {
            this.f50368b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.k0("", this.f50368b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class l implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ boolean f50370b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ char f50371c;

        /* renamed from: d  reason: collision with root package name */
        private final /* synthetic */ String f50372d;

        l(boolean z3, char c4, String str) {
            this.f50370b = z3;
            this.f50371c = c4;
            this.f50372d = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (this.f50370b) {
                return hVar.o0("", String.valueOf(e.this.f50321a) + this.f50371c + this.f50372d);
            }
            return hVar.k0("", String.valueOf(e.this.f50321a) + this.f50371c + this.f50372d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class m implements u {
        m() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (hVar.i0()) {
                return hVar.k0(e.this.f50321a, "");
            }
            return hVar.k0("", e.this.f50321a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class n implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ String f50375b;

        n(String str) {
            this.f50375b = str;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            return hVar.o0("", this.f50375b);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class o implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ boolean f50377b;

        o(boolean z3) {
            this.f50377b = z3;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            if (this.f50377b) {
                hVar.P0(e.this.f50321a);
                return null;
            }
            hVar.R0(e.this.f50321a);
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class p implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ int f50379b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ char f50380c;

        p(int i4, char c4) {
            this.f50379b = i4;
            this.f50380c = c4;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            com.sun.mail.imap.protocol.m[] k02;
            if ((this.f50379b & 1) == 0) {
                hVar.C(String.valueOf(e.this.f50321a) + this.f50380c);
            } else {
                hVar.C(e.this.f50321a);
                if ((this.f50379b & 2) != 0 && (k02 = hVar.k0("", e.this.f50321a)) != null && !k02[0].f50564c) {
                    hVar.delete(e.this.f50321a);
                    throw new ProtocolException("Unsupported type");
                }
            }
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class q implements u {
        q() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            com.sun.mail.imap.protocol.m[] k02 = hVar.k0("", e.this.f50321a);
            if (k02 != null) {
                if (k02[0].f50566e == 1) {
                    return Boolean.TRUE;
                }
                if (k02[0].f50566e == 2) {
                    return Boolean.FALSE;
                }
            }
            if (e.this.C().f50594c > 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class r implements u {
        r() {
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.delete(e.this.f50321a);
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class s implements u {

        /* renamed from: b  reason: collision with root package name */
        private final /* synthetic */ Folder f50384b;

        s(Folder folder) {
            this.f50384b = folder;
        }

        @Override // com.sun.mail.imap.e.u
        public Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException {
            hVar.A0(e.this.f50321a, this.f50384b.getFullName());
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class t extends FetchProfile.Item {

        /* renamed from: a  reason: collision with root package name */
        public static final t f50385a = new t("HEADERS");

        /* renamed from: b  reason: collision with root package name */
        public static final t f50386b = new t("SIZE");

        protected t(String str) {
            super(str);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPFolder.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface u {
        Object a(com.sun.mail.imap.protocol.h hVar) throws ProtocolException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str, char c4, com.sun.mail.imap.k kVar) {
        super(kVar);
        int indexOf;
        this.f50327g = false;
        this.f50328h = false;
        this.f50334n = false;
        this.f50335o = true;
        this.f50336p = 0;
        this.f50337r = -1;
        this.f50338s = -1;
        this.f50339t = -1;
        this.f50340u = -1L;
        this.f50341v = -1L;
        this.f50342w = true;
        this.f50343x = null;
        this.f50344y = 0L;
        this.f50345z = false;
        if (str != null) {
            this.f50321a = str;
            this.f50324d = c4;
            this.f50332l = new Object();
            this.f50345z = kVar.l().getDebug();
            this.B = kVar.g();
            PrintStream debugOut = kVar.l().getDebugOut();
            this.A = debugOut;
            if (debugOut == null) {
                this.A = System.out;
            }
            this.f50328h = false;
            if (c4 == '\uffff' || c4 == 0 || (indexOf = this.f50321a.indexOf(c4)) <= 0 || indexOf != this.f50321a.length() - 1) {
                return;
            }
            this.f50321a = this.f50321a.substring(0, indexOf);
            this.f50328h = true;
            return;
        }
        throw new NullPointerException("Folder name is null");
    }

    private com.sun.mail.imap.protocol.h A() throws ProtocolException {
        S();
        return this.f50330j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.imap.protocol.u C() throws ProtocolException {
        com.sun.mail.imap.protocol.h D2;
        int m4 = ((com.sun.mail.imap.k) this.store).m();
        if (m4 > 0 && this.f50343x != null && System.currentTimeMillis() - this.f50344y < m4) {
            return this.f50343x;
        }
        com.sun.mail.imap.protocol.h hVar = null;
        try {
            D2 = D();
        } catch (Throwable th) {
            th = th;
        }
        try {
            com.sun.mail.imap.protocol.u K0 = D2.K0(this.f50321a, null);
            if (m4 > 0) {
                this.f50343x = K0;
                this.f50344y = System.currentTimeMillis();
            }
            M(D2);
            return K0;
        } catch (Throwable th2) {
            th = th2;
            hVar = D2;
            M(hVar);
            throw th;
        }
    }

    private boolean H() {
        return (this.f50323c & 2) != 0;
    }

    private void I(boolean z3) throws ProtocolException {
        if (System.currentTimeMillis() - this.f50330j.g() > 1000) {
            S();
            this.f50330j.r0();
        }
        if (z3 && ((com.sun.mail.imap.k) this.store).q()) {
            com.sun.mail.imap.protocol.h hVar = null;
            try {
                hVar = ((com.sun.mail.imap.k) this.store).n();
                if (System.currentTimeMillis() - hVar.g() > 1000) {
                    hVar.r0();
                }
            } finally {
                ((com.sun.mail.imap.k) this.store).w(hVar);
            }
        }
    }

    private void L(boolean z3) {
        com.sun.mail.imap.protocol.h hVar = this.f50330j;
        if (hVar != null) {
            hVar.m(this);
            if (z3) {
                ((com.sun.mail.imap.k) this.store).v(this, this.f50330j);
            } else {
                ((com.sun.mail.imap.k) this.store).v(this, null);
            }
        }
    }

    private void P(com.sun.mail.imap.a aVar, char c4) throws MessagingException {
        s("ACL not supported", new i(c4, aVar));
    }

    private synchronized void R(ConnectionException connectionException) throws FolderClosedException, StoreClosedException {
        if ((this.f50330j != null && connectionException.getProtocol() == this.f50330j) || (this.f50330j == null && !this.f50335o)) {
            throw new FolderClosedException(this, connectionException.getMessage());
        }
        throw new StoreClosedException(this.store, connectionException.getMessage());
    }

    private void i() {
        if (this.f50334n) {
            throw new IllegalStateException("This operation is not allowed on an open folder");
        }
    }

    private void j() throws MessagingException {
        if (this.f50327g || exists()) {
            return;
        }
        throw new FolderNotFoundException(this, String.valueOf(this.f50321a) + " not found");
    }

    private void k(Flags flags) throws MessagingException {
        if (this.mode == 2) {
            return;
        }
        throw new IllegalStateException("Cannot change flags on READ_ONLY folder: " + this.f50321a);
    }

    private void l() throws FolderClosedException {
        if (this.f50334n) {
            return;
        }
        if (this.f50335o) {
            throw new IllegalStateException("This operation is not allowed on a closed folder");
        }
        throw new FolderClosedException(this, "Lost folder connection to server");
    }

    private void m(int i4) throws MessagingException {
        if (i4 >= 1) {
            if (i4 <= this.f50337r) {
                return;
            }
            synchronized (this.f50332l) {
                try {
                    I(false);
                } catch (ConnectionException e4) {
                    throw new FolderClosedException(this, e4.getMessage());
                } catch (ProtocolException e5) {
                    throw new MessagingException(e5.getMessage(), e5);
                }
            }
            if (i4 > this.f50337r) {
                throw new IndexOutOfBoundsException();
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    private void n(boolean z3) {
        L(z3);
        this.f50330j = null;
        this.f50331k = null;
        this.f50333m = null;
        this.f50327g = false;
        this.f50329i = null;
        this.f50334n = false;
        this.f50336p = 0;
        notifyConnectionListeners(3);
    }

    private void o(boolean z3, boolean z4) throws MessagingException {
        synchronized (this.f50332l) {
            boolean z5 = this.f50334n;
            if (!z5 && this.f50335o) {
                throw new IllegalStateException("This operation is not allowed on a closed folder");
            }
            this.f50335o = true;
            if (z5) {
                try {
                    S();
                    if (z4) {
                        if (this.f50345z) {
                            PrintStream printStream = this.A;
                            printStream.println("DEBUG: forcing folder " + this.f50321a + " to close");
                        }
                        com.sun.mail.imap.protocol.h hVar = this.f50330j;
                        if (hVar != null) {
                            hVar.c();
                        }
                    } else if (((com.sun.mail.imap.k) this.store).s()) {
                        if (this.f50345z) {
                            this.A.println("DEBUG: pool is full, not adding an Authenticated connection");
                        }
                        if (z3) {
                            this.f50330j.y();
                        }
                        com.sun.mail.imap.protocol.h hVar2 = this.f50330j;
                        if (hVar2 != null) {
                            hVar2.n0();
                        }
                    } else {
                        if (!z3 && this.mode == 2) {
                            try {
                                this.f50330j.G(this.f50321a);
                            } catch (ProtocolException unused) {
                                com.sun.mail.imap.protocol.h hVar3 = this.f50330j;
                                if (hVar3 != null) {
                                    hVar3.c();
                                }
                            }
                        }
                        com.sun.mail.imap.protocol.h hVar4 = this.f50330j;
                        if (hVar4 != null) {
                            hVar4.y();
                        }
                    }
                    if (this.f50334n) {
                        n(true);
                    }
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            }
        }
    }

    private synchronized Folder[] r(String str, boolean z3) throws MessagingException {
        j();
        int i4 = 0;
        if (!H()) {
            return new Folder[0];
        }
        char separator = getSeparator();
        com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) q(new l(z3, separator, str));
        if (mVarArr == null) {
            return new Folder[0];
        }
        if (mVarArr.length > 0) {
            String str2 = mVarArr[0].f50562a;
            if (str2.equals(String.valueOf(this.f50321a) + separator)) {
                i4 = 1;
            }
        }
        e[] eVarArr = new e[mVarArr.length - i4];
        for (int i5 = i4; i5 < mVarArr.length; i5++) {
            eVarArr[i5 - i4] = new e(mVarArr[i5], (com.sun.mail.imap.k) this.store);
        }
        return eVarArr;
    }

    private int v(com.sun.mail.imap.protocol.m[] mVarArr, String str) {
        int i4 = 0;
        while (i4 < mVarArr.length && !mVarArr[i4].f50562a.equals(str)) {
            i4++;
        }
        if (i4 >= mVarArr.length) {
            return 0;
        }
        return i4;
    }

    public Quota[] B() throws MessagingException {
        return (Quota[]) s("QUOTA not supported", new c());
    }

    protected synchronized com.sun.mail.imap.protocol.h D() throws ProtocolException {
        if (this.B) {
            this.A.println("DEBUG: getStoreProtocol() - borrowing a connection");
        }
        return ((com.sun.mail.imap.k) this.store).n();
    }

    public synchronized long E() throws MessagingException {
        Throwable th;
        ProtocolException e4;
        com.sun.mail.imap.protocol.h hVar;
        BadCommandException e5;
        if (this.f50334n) {
            return this.f50341v;
        }
        com.sun.mail.imap.protocol.u uVar = null;
        try {
            try {
                hVar = D();
            } catch (BadCommandException e6) {
                e5 = e6;
            } catch (ConnectionException e7) {
                e = e7;
                hVar = null;
            } catch (ProtocolException e8) {
                e4 = e8;
            } catch (Throwable th2) {
                th = th2;
                M(null);
                throw th;
            }
            try {
                uVar = hVar.K0(this.f50321a, new String[]{"UIDNEXT"});
            } catch (BadCommandException e9) {
                e5 = e9;
                throw new MessagingException("Cannot obtain UIDNext", e5);
            } catch (ConnectionException e10) {
                e = e10;
                R(e);
                M(hVar);
                return uVar.f50595d;
            } catch (ProtocolException e11) {
                e4 = e11;
                throw new MessagingException(e4.getMessage(), e4);
            }
            M(hVar);
            return uVar.f50595d;
        } catch (Throwable th3) {
            th = th3;
            M(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(com.sun.mail.iap.g[] gVarArr) {
        for (int i4 = 0; i4 < gVarArr.length; i4++) {
            if (gVarArr[i4] != null) {
                a(gVarArr[i4]);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        r0 = ((com.sun.mail.imap.k) r3.store).i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
        if (r0 <= 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
        java.lang.Thread.sleep(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0049, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void G() throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.l()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = "IDLE not supported"
            com.sun.mail.imap.e$j r1 = new com.sun.mail.imap.e$j     // Catch: java.lang.Throwable -> L5d
            r1.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r0 = r3.s(r0, r1)     // Catch: java.lang.Throwable -> L5d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L5d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L5d
            if (r0 != 0) goto L19
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
            return
        L19:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
        L1a:
            com.sun.mail.imap.protocol.h r0 = r3.f50330j
            com.sun.mail.iap.g r0 = r0.z0()
            java.lang.Object r1 = r3.f50332l     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
            monitor-enter(r1)     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
            if (r0 == 0) goto L32
            com.sun.mail.imap.protocol.h r2 = r3.f50330j     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L32
            boolean r0 = r2.x0(r0)     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L30
            goto L32
        L30:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            goto L1a
        L32:
            r0 = 0
            r3.f50336p = r0     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r0 = r3.f50332l     // Catch: java.lang.Throwable -> L4a
            r0.notifyAll()     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            javax.mail.Store r0 = r3.store
            com.sun.mail.imap.k r0 = (com.sun.mail.imap.k) r0
            int r0 = r0.i()
            if (r0 <= 0) goto L49
            long r0 = (long) r0
            java.lang.Thread.sleep(r0)     // Catch: java.lang.InterruptedException -> L49
        L49:
            return
        L4a:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            throw r0     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
        L4d:
            r0 = move-exception
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = r0.getMessage()
            r1.<init>(r2, r0)
            throw r1
        L58:
            r0 = move-exception
            r3.R(r0)
            goto L1a
        L5d:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
            goto L61
        L60:
            throw r0
        L61:
            goto L60
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.e.G():void");
    }

    public com.sun.mail.imap.n[] J(String str) throws MessagingException {
        return (com.sun.mail.imap.n[]) s("ACL not supported", new g(str));
    }

    public com.sun.mail.imap.n K() throws MessagingException {
        return (com.sun.mail.imap.n) s("ACL not supported", new h());
    }

    protected synchronized void M(com.sun.mail.imap.protocol.h hVar) {
        if (hVar != this.f50330j) {
            ((com.sun.mail.imap.k) this.store).w(hVar);
        }
    }

    public void N(String str) throws MessagingException {
        s("ACL not supported", new f(str));
    }

    public void O(com.sun.mail.imap.a aVar) throws MessagingException {
        P(aVar, '-');
    }

    public void Q(Quota quota) throws MessagingException {
        s("QUOTA not supported", new d(quota));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S() throws ProtocolException {
        while (true) {
            int i4 = this.f50336p;
            if (i4 == 0) {
                return;
            }
            if (i4 == 1) {
                this.f50330j.f0();
                this.f50336p = 2;
            }
            try {
                this.f50332l.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // com.sun.mail.iap.h
    public void a(com.sun.mail.iap.g gVar) {
        com.sun.mail.imap.g z3;
        if (gVar.h() || gVar.g() || gVar.d() || gVar.e()) {
            ((com.sun.mail.imap.k) this.store).o(gVar);
        }
        if (gVar.e()) {
            if (this.f50334n) {
                n(false);
            }
        } else if (!gVar.h() && gVar.k()) {
            if (!(gVar instanceof com.sun.mail.imap.protocol.i)) {
                this.A.println("UNEXPECTED RESPONSE : " + gVar.toString());
                this.A.println("CONTACT javamail@sun.com");
                return;
            }
            com.sun.mail.imap.protocol.i iVar = (com.sun.mail.imap.protocol.i) gVar;
            if (iVar.F("EXISTS")) {
                int E2 = iVar.E();
                int i4 = this.f50339t;
                if (E2 <= i4) {
                    return;
                }
                int i5 = E2 - i4;
                Message[] messageArr = new Message[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = this.f50337r + 1;
                    this.f50337r = i7;
                    int i8 = this.f50339t + 1;
                    this.f50339t = i8;
                    com.sun.mail.imap.g gVar2 = new com.sun.mail.imap.g(this, i7, i8);
                    messageArr[i6] = gVar2;
                    this.f50331k.addElement(gVar2);
                }
                notifyMessageAddedListeners(messageArr);
            } else if (iVar.F("EXPUNGE")) {
                com.sun.mail.imap.g z4 = z(iVar.E());
                z4.setExpunged(true);
                for (int messageNumber = z4.getMessageNumber(); messageNumber < this.f50337r; messageNumber++) {
                    com.sun.mail.imap.g gVar3 = (com.sun.mail.imap.g) this.f50331k.elementAt(messageNumber);
                    if (!gVar3.isExpunged()) {
                        gVar3.I(gVar3.w() - 1);
                    }
                }
                this.f50339t--;
                if (this.f50342w) {
                    notifyMessageRemovedListeners(false, new Message[]{z4});
                }
            } else if (iVar.F("FETCH")) {
                com.sun.mail.imap.protocol.f fVar = (com.sun.mail.imap.protocol.f) iVar;
                Flags flags = (Flags) fVar.J(Flags.class);
                if (flags == null || (z3 = z(fVar.E())) == null) {
                    return;
                }
                z3.e(flags);
                notifyMessageChangedListeners(1, z3);
            } else if (iVar.F("RECENT")) {
                this.f50338s = iVar.E();
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized void appendMessages(Message[] messageArr) throws MessagingException {
        j();
        int f4 = ((com.sun.mail.imap.k) this.store).f();
        for (Message message : messageArr) {
            try {
                com.sun.mail.imap.m mVar = new com.sun.mail.imap.m(message, message.getSize() > f4 ? 0 : f4);
                Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                p(new a(message.getFlags(), receivedDate, mVar));
            } catch (IOException e4) {
                throw new MessagingException("IOException while appending messages", e4);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z3) throws MessagingException {
        o(z3, false);
    }

    @Override // javax.mail.Folder
    public synchronized void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        l();
        if (messageArr.length == 0) {
            return;
        }
        if (folder.getStore() == this.store) {
            synchronized (this.f50332l) {
                try {
                    try {
                        try {
                            com.sun.mail.imap.protocol.h A = A();
                            com.sun.mail.imap.protocol.o[] a4 = com.sun.mail.imap.o.a(messageArr, null);
                            if (a4 != null) {
                                A.B(a4, folder.getFullName());
                            } else {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                        } catch (ConnectionException e4) {
                            throw new FolderClosedException(this, e4.getMessage());
                        }
                    } catch (ProtocolException e5) {
                        throw new MessagingException(e5.getMessage(), e5);
                    }
                } catch (CommandFailedException e6) {
                    if (e6.getMessage().indexOf("TRYCREATE") != -1) {
                        throw new FolderNotFoundException(folder, String.valueOf(folder.getFullName()) + " does not exist");
                    }
                    throw new MessagingException(e6.getMessage(), e6);
                }
            }
        } else {
            super.copyMessages(messageArr, folder);
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean create(int i4) throws MessagingException {
        if (q(new p(i4, (i4 & 1) == 0 ? getSeparator() : (char) 0)) == null) {
            return false;
        }
        boolean exists = exists();
        if (exists) {
            notifyFolderListeners(1);
        }
        return exists;
    }

    @Override // javax.mail.Folder
    public synchronized boolean delete(boolean z3) throws MessagingException {
        i();
        if (z3) {
            for (Folder folder : list()) {
                folder.delete(z3);
            }
        }
        if (q(new r()) == null) {
            return false;
        }
        this.f50327g = false;
        this.f50329i = null;
        notifyFolderListeners(2);
        return true;
    }

    public void e(com.sun.mail.imap.a aVar) throws MessagingException {
        P(aVar, (char) 0);
    }

    @Override // javax.mail.Folder
    public synchronized boolean exists() throws MessagingException {
        String str;
        if (this.f50328h && this.f50324d != 0) {
            str = String.valueOf(this.f50321a) + this.f50324d;
        } else {
            str = this.f50321a;
        }
        com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new k(str));
        if (mVarArr != null) {
            int v3 = v(mVarArr, str);
            String str2 = mVarArr[v3].f50562a;
            this.f50321a = str2;
            this.f50324d = mVarArr[v3].f50563b;
            int length = str2.length();
            if (this.f50324d != 0 && length > 0) {
                int i4 = length - 1;
                if (this.f50321a.charAt(i4) == this.f50324d) {
                    this.f50321a = this.f50321a.substring(0, i4);
                }
            }
            this.f50323c = 0;
            if (mVarArr[v3].f50564c) {
                this.f50323c = 0 | 2;
            }
            if (mVarArr[v3].f50565d) {
                this.f50323c |= 1;
            }
            this.f50327g = true;
            this.f50329i = mVarArr[v3].f50567f;
        } else {
            this.f50327g = this.f50334n;
            this.f50329i = null;
        }
        return this.f50327g;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] expunge() throws MessagingException {
        return u(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Message[] f(Message[] messageArr) throws MessagingException {
        MimeMessage[] mimeMessageArr;
        l();
        mimeMessageArr = new MimeMessage[messageArr.length];
        com.sun.mail.imap.b[] h4 = h(messageArr);
        for (int i4 = 0; i4 < h4.length; i4++) {
            com.sun.mail.imap.b bVar = h4[i4];
            if (bVar != null && bVar.f50309a == this.f50340u) {
                try {
                    mimeMessageArr[i4] = getMessageByUID(bVar.f50310b);
                } catch (MessagingException unused) {
                }
            }
        }
        return mimeMessageArr;
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        l();
        com.sun.mail.imap.g.p(this, messageArr, fetchProfile);
    }

    public void g(com.sun.mail.imap.a aVar) throws MessagingException {
        P(aVar, '+');
    }

    @Override // javax.mail.Folder
    public synchronized int getDeletedMessageCount() throws MessagingException {
        int length;
        if (!this.f50334n) {
            j();
            return -1;
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.DELETED);
        try {
            synchronized (this.f50332l) {
                length = A().D0(new FlagTerm(flags, true)).length;
            }
            return length;
        } catch (ConnectionException e4) {
            throw new FolderClosedException(this, e4.getMessage());
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        if (this.f50329i != null && !H()) {
            throw new MessagingException("Cannot contain subfolders");
        }
        char separator = getSeparator();
        return new e(String.valueOf(this.f50321a) + separator + str, separator, (com.sun.mail.imap.k) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized String getFullName() {
        return this.f50321a;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i4) throws MessagingException {
        l();
        m(i4);
        return (Message) this.f50331k.elementAt(i4 - 1);
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message getMessageByUID(long j4) throws MessagingException {
        int i4;
        l();
        com.sun.mail.imap.g gVar = null;
        try {
            synchronized (this.f50332l) {
                Long l4 = new Long(j4);
                Hashtable hashtable = this.f50333m;
                if (hashtable != null) {
                    gVar = (com.sun.mail.imap.g) hashtable.get(l4);
                    if (gVar != null) {
                        return gVar;
                    }
                } else {
                    this.f50333m = new Hashtable();
                }
                v U = A().U(j4);
                if (U != null && (i4 = U.f50599a) <= this.f50337r) {
                    gVar = z(i4);
                    gVar.J(U.f50600b);
                    this.f50333m.put(l4, gVar);
                }
                return gVar;
            }
        } catch (ConnectionException e4) {
            throw new FolderClosedException(this, e4.getMessage());
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        int i4;
        if (!this.f50334n) {
            j();
            try {
                try {
                    try {
                        return C().f50593b;
                    } catch (ConnectionException e4) {
                        throw new StoreClosedException(this.store, e4.getMessage());
                    }
                } catch (BadCommandException unused) {
                    try {
                        com.sun.mail.imap.protocol.h D2 = D();
                        com.sun.mail.imap.protocol.n G2 = D2.G(this.f50321a);
                        D2.y();
                        int i5 = G2.f50570c;
                        M(D2);
                        return i5;
                    } catch (ProtocolException e5) {
                        throw new MessagingException(e5.getMessage(), e5);
                    }
                }
            } catch (ProtocolException e6) {
                throw new MessagingException(e6.getMessage(), e6);
            }
        }
        synchronized (this.f50332l) {
            try {
                I(true);
                i4 = this.f50337r;
            } catch (ConnectionException e7) {
                throw new FolderClosedException(this, e7.getMessage());
            } catch (ProtocolException e8) {
                throw new MessagingException(e8.getMessage(), e8);
            }
        }
        return i4;
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long j4, long j5) throws MessagingException {
        Message[] messageArr;
        l();
        try {
            synchronized (this.f50332l) {
                if (this.f50333m == null) {
                    this.f50333m = new Hashtable();
                }
                v[] V = A().V(j4, j5);
                messageArr = new Message[V.length];
                for (int i4 = 0; i4 < V.length; i4++) {
                    com.sun.mail.imap.g z3 = z(V[i4].f50599a);
                    z3.J(V[i4].f50600b);
                    messageArr[i4] = z3;
                    this.f50333m.put(new Long(V[i4].f50600b), z3);
                }
            }
        } catch (ConnectionException e4) {
            throw new FolderClosedException(this, e4.getMessage());
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
        return messageArr;
    }

    @Override // javax.mail.Folder
    public synchronized String getName() {
        if (this.f50322b == null) {
            try {
                String str = this.f50321a;
                this.f50322b = str.substring(str.lastIndexOf(getSeparator()) + 1);
            } catch (MessagingException unused) {
            }
        }
        return this.f50322b;
    }

    @Override // javax.mail.Folder
    public synchronized int getNewMessageCount() throws MessagingException {
        int i4;
        if (!this.f50334n) {
            j();
            try {
                try {
                    try {
                        return C().f50594c;
                    } catch (ConnectionException e4) {
                        throw new StoreClosedException(this.store, e4.getMessage());
                    }
                } catch (BadCommandException unused) {
                    try {
                        com.sun.mail.imap.protocol.h D2 = D();
                        com.sun.mail.imap.protocol.n G2 = D2.G(this.f50321a);
                        D2.y();
                        int i5 = G2.f50571d;
                        M(D2);
                        return i5;
                    } catch (ProtocolException e5) {
                        throw new MessagingException(e5.getMessage(), e5);
                    }
                }
            } catch (ProtocolException e6) {
                throw new MessagingException(e6.getMessage(), e6);
            }
        }
        synchronized (this.f50332l) {
            try {
                I(true);
                i4 = this.f50338s;
            } catch (ConnectionException e7) {
                throw new FolderClosedException(this, e7.getMessage());
            } catch (ProtocolException e8) {
                throw new MessagingException(e8.getMessage(), e8);
            }
        }
        return i4;
    }

    @Override // javax.mail.Folder
    public synchronized Folder getParent() throws MessagingException {
        char separator = getSeparator();
        int lastIndexOf = this.f50321a.lastIndexOf(separator);
        if (lastIndexOf != -1) {
            return new e(this.f50321a.substring(0, lastIndexOf), separator, (com.sun.mail.imap.k) this.store);
        }
        return new com.sun.mail.imap.c((com.sun.mail.imap.k) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized Flags getPermanentFlags() {
        return (Flags) this.f50326f.clone();
    }

    @Override // javax.mail.Folder
    public synchronized char getSeparator() throws MessagingException {
        if (this.f50324d == '\uffff') {
            com.sun.mail.imap.protocol.m[] mVarArr = (com.sun.mail.imap.protocol.m[]) p(new m());
            if (mVarArr != null) {
                this.f50324d = mVarArr[0].f50563b;
            } else {
                this.f50324d = '/';
            }
        }
        return this.f50324d;
    }

    @Override // javax.mail.Folder
    public synchronized int getType() throws MessagingException {
        if (this.f50334n) {
            if (this.f50329i == null) {
                exists();
            }
        } else {
            j();
        }
        return this.f50323c;
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUID(Message message) throws MessagingException {
        if (message.getFolder() == this) {
            l();
            com.sun.mail.imap.g gVar = (com.sun.mail.imap.g) message;
            long x3 = gVar.x();
            if (x3 != -1) {
                return x3;
            }
            synchronized (this.f50332l) {
                try {
                    com.sun.mail.imap.protocol.h A = A();
                    gVar.n();
                    v X = A.X(gVar.w());
                    if (X != null) {
                        x3 = X.f50600b;
                        gVar.J(x3);
                        if (this.f50333m == null) {
                            this.f50333m = new Hashtable();
                        }
                        this.f50333m.put(new Long(x3), gVar);
                    }
                } catch (ConnectionException e4) {
                    throw new FolderClosedException(this, e4.getMessage());
                } catch (ProtocolException e5) {
                    throw new MessagingException(e5.getMessage(), e5);
                }
            }
            return x3;
        }
        throw new NoSuchElementException("Message does not belong to this folder");
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUIDValidity() throws MessagingException {
        Throwable th;
        ProtocolException e4;
        com.sun.mail.imap.protocol.h hVar;
        BadCommandException e5;
        if (this.f50334n) {
            return this.f50340u;
        }
        com.sun.mail.imap.protocol.u uVar = null;
        try {
            try {
                hVar = D();
            } catch (BadCommandException e6) {
                e5 = e6;
            } catch (ConnectionException e7) {
                e = e7;
                hVar = null;
            } catch (ProtocolException e8) {
                e4 = e8;
            } catch (Throwable th2) {
                th = th2;
                M(null);
                throw th;
            }
            try {
                uVar = hVar.K0(this.f50321a, new String[]{"UIDVALIDITY"});
            } catch (BadCommandException e9) {
                e5 = e9;
                throw new MessagingException("Cannot obtain UIDValidity", e5);
            } catch (ConnectionException e10) {
                e = e10;
                R(e);
                M(hVar);
                return uVar.f50596e;
            } catch (ProtocolException e11) {
                e4 = e11;
                throw new MessagingException(e4.getMessage(), e4);
            }
            M(hVar);
            return uVar.f50596e;
        } catch (Throwable th3) {
            th = th3;
            M(null);
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getUnreadMessageCount() throws MessagingException {
        int length;
        if (!this.f50334n) {
            j();
            try {
                try {
                    return C().f50597f;
                } catch (BadCommandException unused) {
                    return -1;
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new StoreClosedException(this.store, e5.getMessage());
            }
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.SEEN);
        try {
            synchronized (this.f50332l) {
                length = A().D0(new FlagTerm(flags, false)).length;
            }
            return length;
        } catch (ConnectionException e6) {
            throw new FolderClosedException(this, e6.getMessage());
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
    }

    public synchronized com.sun.mail.imap.b[] h(Message[] messageArr) throws MessagingException {
        com.sun.mail.imap.b[] bVarArr;
        j();
        int f4 = ((com.sun.mail.imap.k) this.store).f();
        bVarArr = new com.sun.mail.imap.b[messageArr.length];
        for (int i4 = 0; i4 < messageArr.length; i4++) {
            Message message = messageArr[i4];
            try {
                com.sun.mail.imap.m mVar = new com.sun.mail.imap.m(message, message.getSize() > f4 ? 0 : f4);
                Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                bVarArr[i4] = (com.sun.mail.imap.b) p(new b(message.getFlags(), receivedDate, mVar));
            } catch (IOException e4) {
                throw new MessagingException("IOException while appending messages", e4);
            } catch (MessageRemovedException unused) {
            }
        }
        return bVarArr;
    }

    @Override // javax.mail.Folder
    public synchronized boolean hasNewMessages() throws MessagingException {
        boolean z3;
        if (this.f50334n) {
            synchronized (this.f50332l) {
                try {
                    I(true);
                    z3 = this.f50338s > 0;
                } catch (ConnectionException e4) {
                    throw new FolderClosedException(this, e4.getMessage());
                } catch (ProtocolException e5) {
                    throw new MessagingException(e5.getMessage(), e5);
                }
            }
            return z3;
        }
        j();
        Boolean bool = (Boolean) q(new q());
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // javax.mail.Folder
    public synchronized boolean isOpen() {
        synchronized (this.f50332l) {
            if (this.f50334n) {
                try {
                    I(false);
                } catch (ProtocolException unused) {
                }
            }
        }
        return this.f50334n;
    }

    @Override // javax.mail.Folder
    public synchronized boolean isSubscribed() {
        String str;
        com.sun.mail.imap.protocol.m[] mVarArr = null;
        if (this.f50328h && this.f50324d != 0) {
            str = String.valueOf(this.f50321a) + this.f50324d;
        } else {
            str = this.f50321a;
        }
        try {
            mVarArr = (com.sun.mail.imap.protocol.m[]) t(new n(str));
        } catch (ProtocolException unused) {
        }
        if (mVarArr != null) {
            return mVarArr[v(mVarArr, str)].f50565d;
        }
        return false;
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return r(str, false);
    }

    @Override // javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        return r(str, true);
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i4) throws MessagingException {
        com.sun.mail.imap.protocol.n F0;
        i();
        this.f50330j = ((com.sun.mail.imap.k) this.store).k(this);
        synchronized (this.f50332l) {
            this.f50330j.a(this);
            int i5 = 0;
            try {
                if (i4 == 1) {
                    F0 = this.f50330j.G(this.f50321a);
                } else {
                    F0 = this.f50330j.F0(this.f50321a);
                }
                int i6 = F0.f50575h;
                if (i6 != i4 && (i4 != 2 || i6 != 1 || !((com.sun.mail.imap.k) this.store).b())) {
                    try {
                        try {
                            try {
                                this.f50330j.y();
                                L(true);
                            } catch (ProtocolException unused) {
                                L(false);
                                this.f50330j = null;
                                throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                            } catch (Throwable th) {
                                L(false);
                                throw th;
                            }
                        } catch (Throwable unused2) {
                            this.f50330j = null;
                            throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                        }
                    } catch (ProtocolException unused3) {
                        this.f50330j.n0();
                        L(false);
                        this.f50330j = null;
                        throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                    }
                } else {
                    this.f50334n = true;
                    this.f50335o = false;
                    this.mode = F0.f50575h;
                    this.f50325e = F0.f50568a;
                    this.f50326f = F0.f50569b;
                    int i7 = F0.f50570c;
                    this.f50339t = i7;
                    this.f50337r = i7;
                    this.f50338s = F0.f50571d;
                    this.f50340u = F0.f50573f;
                    this.f50341v = F0.f50574g;
                    this.f50331k = new Vector(this.f50337r);
                    while (i5 < this.f50337r) {
                        i5++;
                        this.f50331k.addElement(new com.sun.mail.imap.g(this, i5, i5));
                    }
                }
            } catch (CommandFailedException e4) {
                e = e4;
                L(true);
                this.f50330j = null;
            } catch (ProtocolException e5) {
                try {
                    this.f50330j.n0();
                } catch (Throwable unused4) {
                }
                L(false);
                this.f50330j = null;
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        e = null;
        if (e != null) {
            j();
            if ((this.f50323c & 1) == 0) {
                throw new MessagingException("folder cannot contain messages");
            }
            throw new MessagingException(e.getMessage(), e);
        }
        this.f50327g = true;
        this.f50329i = null;
        this.f50323c = 1;
        notifyConnectionListeners(1);
    }

    public Object p(u uVar) throws MessagingException {
        try {
            return t(uVar);
        } catch (ConnectionException e4) {
            R(e4);
            return null;
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    public Object q(u uVar) throws MessagingException {
        try {
            return t(uVar);
        } catch (CommandFailedException unused) {
            return null;
        } catch (ConnectionException e4) {
            R(e4);
            return null;
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean renameTo(Folder folder) throws MessagingException {
        i();
        j();
        if (folder.getStore() == this.store) {
            if (q(new s(folder)) == null) {
                return false;
            }
            this.f50327g = false;
            this.f50329i = null;
            notifyFolderRenamedListeners(folder);
            return true;
        }
        throw new MessagingException("Can't rename across Stores");
    }

    public Object s(String str, u uVar) throws MessagingException {
        try {
            return t(uVar);
        } catch (BadCommandException e4) {
            throw new MessagingException(str, e4);
        } catch (ConnectionException e5) {
            R(e5);
            return null;
        } catch (ProtocolException e6) {
            throw new MessagingException(e6.getMessage(), e6);
        }
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm) throws MessagingException {
        com.sun.mail.imap.g[] gVarArr;
        l();
        gVarArr = null;
        try {
            try {
                synchronized (this.f50332l) {
                    int[] D0 = A().D0(searchTerm);
                    if (D0 != null) {
                        gVarArr = new com.sun.mail.imap.g[D0.length];
                        for (int i4 = 0; i4 < D0.length; i4++) {
                            gVarArr[i4] = z(D0[i4]);
                        }
                    }
                }
            } catch (ProtocolException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            } catch (SearchException unused) {
                return super.search(searchTerm);
            }
        } catch (CommandFailedException unused2) {
            return super.search(searchTerm);
        } catch (ConnectionException e5) {
            throw new FolderClosedException(this, e5.getMessage());
        }
        return gVarArr;
    }

    @Override // javax.mail.Folder
    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z3) throws MessagingException {
        l();
        k(flags);
        if (messageArr.length == 0) {
            return;
        }
        synchronized (this.f50332l) {
            try {
                com.sun.mail.imap.protocol.h A = A();
                com.sun.mail.imap.protocol.o[] a4 = com.sun.mail.imap.o.a(messageArr, null);
                if (a4 != null) {
                    A.O0(a4, flags, z3);
                } else {
                    throw new MessageRemovedException("Messages have been removed");
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized void setSubscribed(boolean z3) throws MessagingException {
        q(new o(z3));
    }

    protected Object t(u uVar) throws ProtocolException {
        Object a4;
        synchronized (this) {
            if (this.f50334n && !((com.sun.mail.imap.k) this.store).q()) {
                synchronized (this.f50332l) {
                    a4 = uVar.a(A());
                }
                return a4;
            }
            com.sun.mail.imap.protocol.h hVar = null;
            try {
                hVar = D();
                return uVar.a(hVar);
            } finally {
                M(hVar);
            }
        }
    }

    public synchronized Message[] u(Message[] messageArr) throws MessagingException {
        Message[] messageArr2;
        l();
        Vector vector = new Vector();
        if (messageArr != null) {
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(UIDFolder.FetchProfileItem.UID);
            fetch(messageArr, fetchProfile);
        }
        synchronized (this.f50332l) {
            int i4 = 0;
            this.f50342w = false;
            try {
                try {
                    try {
                        com.sun.mail.imap.protocol.h A = A();
                        if (messageArr != null) {
                            A.Q0(com.sun.mail.imap.o.b(messageArr));
                        } else {
                            A.H();
                        }
                        while (i4 < this.f50331k.size()) {
                            com.sun.mail.imap.g gVar = (com.sun.mail.imap.g) this.f50331k.elementAt(i4);
                            if (gVar.isExpunged()) {
                                vector.addElement(gVar);
                                this.f50331k.removeElementAt(i4);
                                if (this.f50333m != null) {
                                    long x3 = gVar.x();
                                    if (x3 != -1) {
                                        this.f50333m.remove(new Long(x3));
                                    }
                                }
                            } else {
                                gVar.setMessageNumber(gVar.w());
                                i4++;
                            }
                        }
                    } catch (CommandFailedException e4) {
                        if (this.mode != 2) {
                            throw new IllegalStateException("Cannot expunge READ_ONLY folder: " + this.f50321a);
                        }
                        throw new MessagingException(e4.getMessage(), e4);
                    } catch (ProtocolException e5) {
                        throw new MessagingException(e5.getMessage(), e5);
                    }
                } catch (ConnectionException e6) {
                    throw new FolderClosedException(this, e6.getMessage());
                }
            } finally {
                this.f50342w = true;
            }
        }
        this.f50337r = this.f50331k.size();
        int size = vector.size();
        messageArr2 = new Message[size];
        vector.copyInto(messageArr2);
        if (size > 0) {
            notifyMessageRemovedListeners(true, messageArr2);
        }
        return messageArr2;
    }

    public synchronized void w() throws MessagingException {
        o(false, true);
    }

    public com.sun.mail.imap.a[] x() throws MessagingException {
        return (com.sun.mail.imap.a[]) s("ACL not supported", new C1027e());
    }

    public String[] y() throws MessagingException {
        if (this.f50329i == null) {
            exists();
        }
        return (String[]) this.f50329i.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.sun.mail.imap.g z(int i4) {
        for (int i5 = i4 - 1; i5 < this.f50337r; i5++) {
            com.sun.mail.imap.g gVar = (com.sun.mail.imap.g) this.f50331k.elementAt(i5);
            if (gVar.w() == i4) {
                return gVar;
            }
        }
        return null;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        com.sun.mail.imap.g[] gVarArr;
        l();
        if (messageArr.length == 0) {
            return messageArr;
        }
        try {
            try {
                try {
                    try {
                        synchronized (this.f50332l) {
                            com.sun.mail.imap.protocol.h A = A();
                            gVarArr = null;
                            com.sun.mail.imap.protocol.o[] a4 = com.sun.mail.imap.o.a(messageArr, null);
                            if (a4 != null) {
                                int[] E0 = A.E0(a4, searchTerm);
                                if (E0 != null) {
                                    gVarArr = new com.sun.mail.imap.g[E0.length];
                                    for (int i4 = 0; i4 < E0.length; i4++) {
                                        gVarArr[i4] = z(E0[i4]);
                                    }
                                }
                            } else {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                        }
                        return gVarArr;
                    } catch (ConnectionException e4) {
                        throw new FolderClosedException(this, e4.getMessage());
                    }
                } catch (SearchException unused) {
                    return super.search(searchTerm, messageArr);
                }
            } catch (CommandFailedException unused2) {
                return super.search(searchTerm, messageArr);
            }
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long[] jArr) throws MessagingException {
        long[] jArr2;
        Message[] messageArr;
        l();
        try {
            try {
                synchronized (this.f50332l) {
                    if (this.f50333m != null) {
                        Vector vector = new Vector();
                        for (long j4 : jArr) {
                            Hashtable hashtable = this.f50333m;
                            Long l4 = new Long(j4);
                            if (!hashtable.containsKey(l4)) {
                                vector.addElement(l4);
                            }
                        }
                        int size = vector.size();
                        jArr2 = new long[size];
                        for (int i4 = 0; i4 < size; i4++) {
                            jArr2[i4] = ((Long) vector.elementAt(i4)).longValue();
                        }
                    } else {
                        this.f50333m = new Hashtable();
                        jArr2 = jArr;
                    }
                    if (jArr2.length > 0) {
                        v[] W = A().W(jArr2);
                        for (int i5 = 0; i5 < W.length; i5++) {
                            com.sun.mail.imap.g z3 = z(W[i5].f50599a);
                            z3.J(W[i5].f50600b);
                            this.f50333m.put(new Long(W[i5].f50600b), z3);
                        }
                    }
                    messageArr = new Message[jArr.length];
                    for (int i6 = 0; i6 < jArr.length; i6++) {
                        messageArr[i6] = (Message) this.f50333m.get(new Long(jArr[i6]));
                    }
                }
            } catch (ProtocolException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            }
        } catch (ConnectionException e5) {
            throw new FolderClosedException(this, e5.getMessage());
        }
        return messageArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str, char c4, com.sun.mail.imap.k kVar, boolean z3) {
        this(str, c4, kVar);
        this.f50328h = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(com.sun.mail.imap.protocol.m mVar, com.sun.mail.imap.k kVar) {
        this(mVar.f50562a, mVar.f50563b, kVar);
        if (mVar.f50564c) {
            this.f50323c |= 2;
        }
        if (mVar.f50565d) {
            this.f50323c |= 1;
        }
        this.f50327g = true;
        this.f50329i = mVar.f50567f;
    }
}
