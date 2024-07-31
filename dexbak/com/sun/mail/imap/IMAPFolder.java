package com.sun.mail.imap;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.IMAPResponse;
import com.sun.mail.imap.protocol.ListInfo;
import com.sun.mail.imap.protocol.MailboxInfo;
import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.Status;
import com.sun.mail.imap.protocol.UID;
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

/* renamed from: com.sun.mail.imap.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPFolder extends Folder implements UIDFolder, ResponseHandler {

    /* renamed from: C */
    protected static final char f35900C = 65535;

    /* renamed from: D */
    private static final int f35901D = 0;

    /* renamed from: E */
    private static final int f35902E = 1;

    /* renamed from: F */
    private static final int f35903F = 2;

    /* renamed from: G */
    static final /* synthetic */ boolean f35904G = false;

    /* renamed from: A */
    private PrintStream f35905A;

    /* renamed from: B */
    private boolean f35906B;

    /* renamed from: a */
    protected String f35907a;

    /* renamed from: b */
    protected String f35908b;

    /* renamed from: c */
    protected int f35909c;

    /* renamed from: d */
    protected char f35910d;

    /* renamed from: e */
    protected Flags f35911e;

    /* renamed from: f */
    protected Flags f35912f;

    /* renamed from: g */
    protected boolean f35913g;

    /* renamed from: h */
    protected boolean f35914h;

    /* renamed from: i */
    protected String[] f35915i;

    /* renamed from: j */
    protected IMAPProtocol f35916j;

    /* renamed from: k */
    protected Vector f35917k;

    /* renamed from: l */
    protected Object f35918l;

    /* renamed from: m */
    protected Hashtable f35919m;

    /* renamed from: n */
    private boolean f35920n;

    /* renamed from: o */
    private boolean f35921o;

    /* renamed from: p */
    private int f35922p;

    /* renamed from: r */
    private int f35923r;

    /* renamed from: s */
    private int f35924s;

    /* renamed from: t */
    private int f35925t;

    /* renamed from: u */
    private long f35926u;

    /* renamed from: v */
    private long f35927v;

    /* renamed from: w */
    private boolean f35928w;

    /* renamed from: x */
    private Status f35929x;

    /* renamed from: y */
    private long f35930y;

    /* renamed from: z */
    private boolean f35931z;

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12731a implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ Flags f35933b;

        /* renamed from: c */
        private final /* synthetic */ Date f35934c;

        /* renamed from: d */
        private final /* synthetic */ C12755m f35935d;

        C12731a(Flags flags, Date date, C12755m c12755m) {
            this.f35933b = flags;
            this.f35934c = date;
            this.f35935d = c12755m;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.m16140r(IMAPFolder.this.f35907a, this.f35933b, this.f35934c, this.f35935d);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12732b implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ Flags f35937b;

        /* renamed from: c */
        private final /* synthetic */ Date f35938c;

        /* renamed from: d */
        private final /* synthetic */ C12755m f35939d;

        C12732b(Flags flags, Date date, C12755m c12755m) {
            this.f35937b = flags;
            this.f35938c = date;
            this.f35939d = c12755m;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16138s(IMAPFolder.this.f35907a, this.f35937b, this.f35938c, this.f35939d);
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12733c implements InterfaceC12751u {
        C12733c() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16158d0(IMAPFolder.this.f35907a);
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12734d implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ Quota f35942b;

        C12734d(Quota quota) {
            this.f35942b = quota;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.m16189I0(this.f35942b);
            return null;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12735e implements InterfaceC12751u {
        C12735e() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16164Y(IMAPFolder.this.f35907a);
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$f */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12736f implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ String f35945b;

        C12736f(String str) {
            this.f35945b = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.m16198E(IMAPFolder.this.f35907a, this.f35945b);
            return null;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$g */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12737g implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ String f35947b;

        C12737g(String str) {
            this.f35947b = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16147l0(IMAPFolder.this.f35907a, this.f35947b);
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$h */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12738h implements InterfaceC12751u {
        C12738h() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16142p0(IMAPFolder.this.f35907a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$i */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12739i implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ char f35950b;

        /* renamed from: c */
        private final /* synthetic */ ACL f35951c;

        C12739i(char c, ACL acl) {
            this.f35950b = c;
            this.f35951c = acl;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.m16193G0(IMAPFolder.this.f35907a, this.f35950b, this.f35951c);
            return null;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$j */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12740j implements InterfaceC12751u {
        C12740j() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            if (IMAPFolder.this.f35922p == 0) {
                iMAPProtocol.m16154g0();
                IMAPFolder.this.f35922p = 1;
                return Boolean.TRUE;
            }
            try {
                IMAPFolder.this.f35918l.wait();
            } catch (InterruptedException unused) {
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$k */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12741k implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ String f35954b;

        C12741k(String str) {
            this.f35954b = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16149k0("", this.f35954b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$l */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12742l implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ boolean f35956b;

        /* renamed from: c */
        private final /* synthetic */ char f35957c;

        /* renamed from: d */
        private final /* synthetic */ String f35958d;

        C12742l(boolean z, char c, String str) {
            this.f35956b = z;
            this.f35957c = c;
            this.f35958d = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            if (this.f35956b) {
                return iMAPProtocol.m16144o0("", String.valueOf(IMAPFolder.this.f35907a) + this.f35957c + this.f35958d);
            }
            return iMAPProtocol.m16149k0("", String.valueOf(IMAPFolder.this.f35907a) + this.f35957c + this.f35958d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$m */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12743m implements InterfaceC12751u {
        C12743m() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            if (iMAPProtocol.m16152i0()) {
                return iMAPProtocol.m16149k0(IMAPFolder.this.f35907a, "");
            }
            return iMAPProtocol.m16149k0("", IMAPFolder.this.f35907a);
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$n */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12744n implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ String f35961b;

        C12744n(String str) {
            this.f35961b = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.m16144o0("", this.f35961b);
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$o */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12745o implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ boolean f35963b;

        C12745o(boolean z) {
            this.f35963b = z;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            if (this.f35963b) {
                iMAPProtocol.m16175P0(IMAPFolder.this.f35907a);
                return null;
            }
            iMAPProtocol.m16171R0(IMAPFolder.this.f35907a);
            return null;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$p */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12746p implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ int f35965b;

        /* renamed from: c */
        private final /* synthetic */ char f35966c;

        C12746p(int i, char c) {
            this.f35965b = i;
            this.f35966c = c;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            ListInfo[] m16149k0;
            if ((this.f35965b & 1) == 0) {
                iMAPProtocol.m16202C(String.valueOf(IMAPFolder.this.f35907a) + this.f35966c);
            } else {
                iMAPProtocol.m16202C(IMAPFolder.this.f35907a);
                if ((this.f35965b & 2) != 0 && (m16149k0 = iMAPProtocol.m16149k0("", IMAPFolder.this.f35907a)) != null && !m16149k0[0].f36154c) {
                    iMAPProtocol.delete(IMAPFolder.this.f35907a);
                    throw new ProtocolException("Unsupported type");
                }
            }
            return Boolean.TRUE;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$q */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12747q implements InterfaceC12751u {
        C12747q() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            ListInfo[] m16149k0 = iMAPProtocol.m16149k0("", IMAPFolder.this.f35907a);
            if (m16149k0 != null) {
                if (m16149k0[0].f36156e == 1) {
                    return Boolean.TRUE;
                }
                if (m16149k0[0].f36156e == 2) {
                    return Boolean.FALSE;
                }
            }
            if (IMAPFolder.this.m16372C().f36184c > 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$r */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12748r implements InterfaceC12751u {
        C12748r() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.delete(IMAPFolder.this.f35907a);
            return Boolean.TRUE;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$s */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12749s implements InterfaceC12751u {

        /* renamed from: b */
        private final /* synthetic */ Folder f35970b;

        C12749s(Folder folder) {
            this.f35970b = folder;
        }

        @Override // com.sun.mail.imap.IMAPFolder.InterfaceC12751u
        /* renamed from: a */
        public Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.m16205A0(IMAPFolder.this.f35907a, this.f35970b.getFullName());
            return Boolean.TRUE;
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$t */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12750t extends FetchProfile.Item {

        /* renamed from: a */
        public static final C12750t f35971a = new C12750t("HEADERS");

        /* renamed from: b */
        public static final C12750t f35972b = new C12750t("SIZE");

        protected C12750t(String str) {
            super(str);
        }
    }

    /* compiled from: IMAPFolder.java */
    /* renamed from: com.sun.mail.imap.e$u */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12751u {
        /* renamed from: a */
        Object mo16330a(IMAPProtocol iMAPProtocol) throws ProtocolException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPFolder(String str, char c, IMAPStore iMAPStore) {
        super(iMAPStore);
        int indexOf;
        this.f35913g = false;
        this.f35914h = false;
        this.f35920n = false;
        this.f35921o = true;
        this.f35922p = 0;
        this.f35923r = -1;
        this.f35924s = -1;
        this.f35925t = -1;
        this.f35926u = -1L;
        this.f35927v = -1L;
        this.f35928w = true;
        this.f35929x = null;
        this.f35930y = 0L;
        this.f35931z = false;
        if (str != null) {
            this.f35907a = str;
            this.f35910d = c;
            this.f35918l = new Object();
            this.f35931z = iMAPStore.m16277l().getDebug();
            this.f35906B = iMAPStore.m16282g();
            PrintStream debugOut = iMAPStore.m16277l().getDebugOut();
            this.f35905A = debugOut;
            if (debugOut == null) {
                this.f35905A = System.out;
            }
            this.f35914h = false;
            if (c == 65535 || c == 0 || (indexOf = this.f35907a.indexOf(c)) <= 0 || indexOf != this.f35907a.length() - 1) {
                return;
            }
            this.f35907a = this.f35907a.substring(0, indexOf);
            this.f35914h = true;
            return;
        }
        throw new NullPointerException("Folder name is null");
    }

    /* renamed from: A */
    private IMAPProtocol m16374A() throws ProtocolException {
        m16356S();
        return this.f35916j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public Status m16372C() throws ProtocolException {
        IMAPProtocol m16371D;
        int m16276m = ((IMAPStore) this.store).m16276m();
        if (m16276m > 0 && this.f35929x != null && System.currentTimeMillis() - this.f35930y < m16276m) {
            return this.f35929x;
        }
        IMAPProtocol iMAPProtocol = null;
        try {
            m16371D = m16371D();
        } catch (Throwable th) {
            th = th;
        }
        try {
            Status m16185K0 = m16371D.m16185K0(this.f35907a, null);
            if (m16276m > 0) {
                this.f35929x = m16185K0;
                this.f35930y = System.currentTimeMillis();
            }
            m16362M(m16371D);
            return m16185K0;
        } catch (Throwable th2) {
            th = th2;
            iMAPProtocol = m16371D;
            m16362M(iMAPProtocol);
            throw th;
        }
    }

    /* renamed from: H */
    private boolean m16367H() {
        return (this.f35909c & 2) != 0;
    }

    /* renamed from: I */
    private void m16366I(boolean z) throws ProtocolException {
        if (System.currentTimeMillis() - this.f35916j.m16417g() > 1000) {
            m16356S();
            this.f35916j.m16139r0();
        }
        if (z && ((IMAPStore) this.store).m16272q()) {
            IMAPProtocol iMAPProtocol = null;
            try {
                iMAPProtocol = ((IMAPStore) this.store).m16275n();
                if (System.currentTimeMillis() - iMAPProtocol.m16417g() > 1000) {
                    iMAPProtocol.m16139r0();
                }
            } finally {
                ((IMAPStore) this.store).m16266w(iMAPProtocol);
            }
        }
    }

    /* renamed from: L */
    private void m16363L(boolean z) {
        IMAPProtocol iMAPProtocol = this.f35916j;
        if (iMAPProtocol != null) {
            iMAPProtocol.m16413m(this);
            if (z) {
                ((IMAPStore) this.store).m16267v(this, this.f35916j);
            } else {
                ((IMAPStore) this.store).m16267v(this, null);
            }
        }
    }

    /* renamed from: P */
    private void m16359P(ACL acl, char c) throws MessagingException {
        m16338s("ACL not supported", new C12739i(c, acl));
    }

    /* renamed from: R */
    private synchronized void m16357R(ConnectionException connectionException) throws FolderClosedException, StoreClosedException {
        if ((this.f35916j != null && connectionException.getProtocol() == this.f35916j) || (this.f35916j == null && !this.f35921o)) {
            throw new FolderClosedException(this, connectionException.getMessage());
        }
        throw new StoreClosedException(this.store, connectionException.getMessage());
    }

    /* renamed from: i */
    private void m16348i() {
        if (this.f35920n) {
            throw new IllegalStateException("This operation is not allowed on an open folder");
        }
    }

    /* renamed from: j */
    private void m16347j() throws MessagingException {
        if (this.f35913g || exists()) {
            return;
        }
        throw new FolderNotFoundException(this, String.valueOf(this.f35907a) + " not found");
    }

    /* renamed from: k */
    private void m16346k(Flags flags) throws MessagingException {
        if (this.mode == 2) {
            return;
        }
        throw new IllegalStateException("Cannot change flags on READ_ONLY folder: " + this.f35907a);
    }

    /* renamed from: l */
    private void m16345l() throws FolderClosedException {
        if (this.f35920n) {
            return;
        }
        if (this.f35921o) {
            throw new IllegalStateException("This operation is not allowed on a closed folder");
        }
        throw new FolderClosedException(this, "Lost folder connection to server");
    }

    /* renamed from: m */
    private void m16344m(int i) throws MessagingException {
        if (i >= 1) {
            if (i <= this.f35923r) {
                return;
            }
            synchronized (this.f35918l) {
                try {
                    m16366I(false);
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            if (i > this.f35923r) {
                throw new IndexOutOfBoundsException();
            }
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    /* renamed from: n */
    private void m16343n(boolean z) {
        m16363L(z);
        this.f35916j = null;
        this.f35917k = null;
        this.f35919m = null;
        this.f35913g = false;
        this.f35915i = null;
        this.f35920n = false;
        this.f35922p = 0;
        notifyConnectionListeners(3);
    }

    /* renamed from: o */
    private void m16342o(boolean z, boolean z2) throws MessagingException {
        synchronized (this.f35918l) {
            boolean z3 = this.f35920n;
            if (!z3 && this.f35921o) {
                throw new IllegalStateException("This operation is not allowed on a closed folder");
            }
            this.f35921o = true;
            if (z3) {
                try {
                    m16356S();
                    if (z2) {
                        if (this.f35931z) {
                            PrintStream printStream = this.f35905A;
                            printStream.println("DEBUG: forcing folder " + this.f35907a + " to close");
                        }
                        IMAPProtocol iMAPProtocol = this.f35916j;
                        if (iMAPProtocol != null) {
                            iMAPProtocol.mo16160c();
                        }
                    } else if (((IMAPStore) this.store).m16270s()) {
                        if (this.f35931z) {
                            this.f35905A.println("DEBUG: pool is full, not adding an Authenticated connection");
                        }
                        if (z) {
                            this.f35916j.m16126y();
                        }
                        IMAPProtocol iMAPProtocol2 = this.f35916j;
                        if (iMAPProtocol2 != null) {
                            iMAPProtocol2.m16145n0();
                        }
                    } else {
                        if (!z && this.mode == 2) {
                            try {
                                this.f35916j.m16194G(this.f35907a);
                            } catch (ProtocolException unused) {
                                IMAPProtocol iMAPProtocol3 = this.f35916j;
                                if (iMAPProtocol3 != null) {
                                    iMAPProtocol3.mo16160c();
                                }
                            }
                        }
                        IMAPProtocol iMAPProtocol4 = this.f35916j;
                        if (iMAPProtocol4 != null) {
                            iMAPProtocol4.m16126y();
                        }
                    }
                    if (this.f35920n) {
                        m16343n(true);
                    }
                } catch (ProtocolException e) {
                    throw new MessagingException(e.getMessage(), e);
                }
            }
        }
    }

    /* renamed from: r */
    private synchronized Folder[] m16339r(String str, boolean z) throws MessagingException {
        m16347j();
        int i = 0;
        if (!m16367H()) {
            return new Folder[0];
        }
        char separator = getSeparator();
        ListInfo[] listInfoArr = (ListInfo[]) m16340q(new C12742l(z, separator, str));
        if (listInfoArr == null) {
            return new Folder[0];
        }
        if (listInfoArr.length > 0) {
            String str2 = listInfoArr[0].f36152a;
            if (str2.equals(String.valueOf(this.f35907a) + separator)) {
                i = 1;
            }
        }
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[listInfoArr.length - i];
        for (int i2 = i; i2 < listInfoArr.length; i2++) {
            iMAPFolderArr[i2 - i] = new IMAPFolder(listInfoArr[i2], (IMAPStore) this.store);
        }
        return iMAPFolderArr;
    }

    /* renamed from: v */
    private int m16335v(ListInfo[] listInfoArr, String str) {
        int i = 0;
        while (i < listInfoArr.length && !listInfoArr[i].f36152a.equals(str)) {
            i++;
        }
        if (i >= listInfoArr.length) {
            return 0;
        }
        return i;
    }

    /* renamed from: B */
    public Quota[] m16373B() throws MessagingException {
        return (Quota[]) m16338s("QUOTA not supported", new C12733c());
    }

    /* renamed from: D */
    protected synchronized IMAPProtocol m16371D() throws ProtocolException {
        if (this.f35906B) {
            this.f35905A.println("DEBUG: getStoreProtocol() - borrowing a connection");
        }
        return ((IMAPStore) this.store).m16275n();
    }

    /* renamed from: E */
    public synchronized long m16370E() throws MessagingException {
        Throwable th;
        ProtocolException e;
        IMAPProtocol iMAPProtocol;
        BadCommandException e2;
        if (this.f35920n) {
            return this.f35927v;
        }
        Status status = null;
        try {
            try {
                iMAPProtocol = m16371D();
            } catch (BadCommandException e3) {
                e2 = e3;
            } catch (ConnectionException e4) {
                e = e4;
                iMAPProtocol = null;
            } catch (ProtocolException e5) {
                e = e5;
            } catch (Throwable th2) {
                th = th2;
                m16362M(null);
                throw th;
            }
            try {
                status = iMAPProtocol.m16185K0(this.f35907a, new String[]{"UIDNEXT"});
            } catch (BadCommandException e6) {
                e2 = e6;
                throw new MessagingException("Cannot obtain UIDNext", e2);
            } catch (ConnectionException e7) {
                e = e7;
                m16357R(e);
                m16362M(iMAPProtocol);
                return status.f36185d;
            } catch (ProtocolException e8) {
                e = e8;
                throw new MessagingException(e.getMessage(), e);
            }
            m16362M(iMAPProtocol);
            return status.f36185d;
        } catch (Throwable th3) {
            th = th3;
            m16362M(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: F */
    public void m16369F(C12728g[] c12728gArr) {
        for (int i = 0; i < c12728gArr.length; i++) {
            if (c12728gArr[i] != null) {
                mo16288a(c12728gArr[i]);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        r0 = ((com.sun.mail.imap.IMAPStore) r3.store).m16280i();
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
    /* renamed from: G */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m16368G() throws javax.mail.MessagingException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.m16345l()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r0 = "IDLE not supported"
            com.sun.mail.imap.e$j r1 = new com.sun.mail.imap.e$j     // Catch: java.lang.Throwable -> L5d
            r1.<init>()     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r0 = r3.m16338s(r0, r1)     // Catch: java.lang.Throwable -> L5d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L5d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L5d
            if (r0 != 0) goto L19
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
            return
        L19:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L5d
        L1a:
            com.sun.mail.imap.protocol.h r0 = r3.f35916j
            com.sun.mail.iap.g r0 = r0.m16123z0()
            java.lang.Object r1 = r3.f35918l     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
            monitor-enter(r1)     // Catch: com.sun.mail.iap.ProtocolException -> L4d com.sun.mail.iap.ConnectionException -> L58
            if (r0 == 0) goto L32
            com.sun.mail.imap.protocol.h r2 = r3.f35916j     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L32
            boolean r0 = r2.m16127x0(r0)     // Catch: java.lang.Throwable -> L4a
            if (r0 != 0) goto L30
            goto L32
        L30:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            goto L1a
        L32:
            r0 = 0
            r3.f35922p = r0     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r0 = r3.f35918l     // Catch: java.lang.Throwable -> L4a
            r0.notifyAll()     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4a
            javax.mail.Store r0 = r3.store
            com.sun.mail.imap.k r0 = (com.sun.mail.imap.IMAPStore) r0
            int r0 = r0.m16280i()
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
            r3.m16357R(r0)
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
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.m16368G():void");
    }

    /* renamed from: J */
    public Rights[] m16365J(String str) throws MessagingException {
        return (Rights[]) m16338s("ACL not supported", new C12737g(str));
    }

    /* renamed from: K */
    public Rights m16364K() throws MessagingException {
        return (Rights) m16338s("ACL not supported", new C12738h());
    }

    /* renamed from: M */
    protected synchronized void m16362M(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol != this.f35916j) {
            ((IMAPStore) this.store).m16266w(iMAPProtocol);
        }
    }

    /* renamed from: N */
    public void m16361N(String str) throws MessagingException {
        m16338s("ACL not supported", new C12736f(str));
    }

    /* renamed from: O */
    public void m16360O(ACL acl) throws MessagingException {
        m16359P(acl, '-');
    }

    /* renamed from: Q */
    public void m16358Q(Quota quota) throws MessagingException {
        m16338s("QUOTA not supported", new C12734d(quota));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: S */
    public void m16356S() throws ProtocolException {
        while (true) {
            int i = this.f35922p;
            if (i == 0) {
                return;
            }
            if (i == 1) {
                this.f35916j.m16155f0();
                this.f35922p = 2;
            }
            try {
                this.f35918l.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // com.sun.mail.iap.ResponseHandler
    /* renamed from: a */
    public void mo16288a(C12728g c12728g) {
        IMAPMessage m16331z;
        if (c12728g.m16399h() || c12728g.m16400g() || c12728g.m16403d() || c12728g.m16402e()) {
            ((IMAPStore) this.store).m16274o(c12728g);
        }
        if (c12728g.m16402e()) {
            if (this.f35920n) {
                m16343n(false);
            }
        } else if (!c12728g.m16399h() && c12728g.m16396k()) {
            if (!(c12728g instanceof IMAPResponse)) {
                this.f35905A.println("UNEXPECTED RESPONSE : " + c12728g.toString());
                this.f35905A.println("CONTACT javamail@sun.com");
                return;
            }
            IMAPResponse iMAPResponse = (IMAPResponse) c12728g;
            if (iMAPResponse.m16120F("EXISTS")) {
                int m16121E = iMAPResponse.m16121E();
                int i = this.f35925t;
                if (m16121E <= i) {
                    return;
                }
                int i2 = m16121E - i;
                Message[] messageArr = new Message[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    int i4 = this.f35923r + 1;
                    this.f35923r = i4;
                    int i5 = this.f35925t + 1;
                    this.f35925t = i5;
                    IMAPMessage iMAPMessage = new IMAPMessage(this, i4, i5);
                    messageArr[i3] = iMAPMessage;
                    this.f35917k.addElement(iMAPMessage);
                }
                notifyMessageAddedListeners(messageArr);
            } else if (iMAPResponse.m16120F("EXPUNGE")) {
                IMAPMessage m16331z2 = m16331z(iMAPResponse.m16121E());
                m16331z2.setExpunged(true);
                for (int messageNumber = m16331z2.getMessageNumber(); messageNumber < this.f35923r; messageNumber++) {
                    IMAPMessage iMAPMessage2 = (IMAPMessage) this.f35917k.elementAt(messageNumber);
                    if (!iMAPMessage2.isExpunged()) {
                        iMAPMessage2.m16319I(iMAPMessage2.mo16290w() - 1);
                    }
                }
                this.f35925t--;
                if (this.f35928w) {
                    notifyMessageRemovedListeners(false, new Message[]{m16331z2});
                }
            } else if (iMAPResponse.m16120F("FETCH")) {
                FetchResponse fetchResponse = (FetchResponse) iMAPResponse;
                Flags flags = (Flags) fetchResponse.m16212J(Flags.class);
                if (flags == null || (m16331z = m16331z(fetchResponse.m16121E())) == null) {
                    return;
                }
                m16331z.m16312e(flags);
                notifyMessageChangedListeners(1, m16331z);
            } else if (iMAPResponse.m16120F("RECENT")) {
                this.f35924s = iMAPResponse.m16121E();
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized void appendMessages(Message[] messageArr) throws MessagingException {
        m16347j();
        int m16283f = ((IMAPStore) this.store).m16283f();
        for (Message message : messageArr) {
            try {
                C12755m c12755m = new C12755m(message, message.getSize() > m16283f ? 0 : m16283f);
                Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                m16341p(new C12731a(message.getFlags(), receivedDate, c12755m));
            } catch (IOException e) {
                throw new MessagingException("IOException while appending messages", e);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z) throws MessagingException {
        m16342o(z, false);
    }

    @Override // javax.mail.Folder
    public synchronized void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        m16345l();
        if (messageArr.length == 0) {
            return;
        }
        if (folder.getStore() == this.store) {
            synchronized (this.f35918l) {
                try {
                    try {
                        try {
                            IMAPProtocol m16374A = m16374A();
                            MessageSet[] m16230a = C12757o.m16230a(messageArr, null);
                            if (m16230a != null) {
                                m16374A.m16204B(m16230a, folder.getFullName());
                            } else {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                        } catch (ConnectionException e) {
                            throw new FolderClosedException(this, e.getMessage());
                        }
                    } catch (ProtocolException e2) {
                        throw new MessagingException(e2.getMessage(), e2);
                    }
                } catch (CommandFailedException e3) {
                    if (e3.getMessage().indexOf("TRYCREATE") != -1) {
                        throw new FolderNotFoundException(folder, String.valueOf(folder.getFullName()) + " does not exist");
                    }
                    throw new MessagingException(e3.getMessage(), e3);
                }
            }
        } else {
            super.copyMessages(messageArr, folder);
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean create(int i) throws MessagingException {
        if (m16340q(new C12746p(i, (i & 1) == 0 ? getSeparator() : (char) 0)) == null) {
            return false;
        }
        boolean exists = exists();
        if (exists) {
            notifyFolderListeners(1);
        }
        return exists;
    }

    @Override // javax.mail.Folder
    public synchronized boolean delete(boolean z) throws MessagingException {
        m16348i();
        if (z) {
            for (Folder folder : list()) {
                folder.delete(z);
            }
        }
        if (m16340q(new C12748r()) == null) {
            return false;
        }
        this.f35913g = false;
        this.f35915i = null;
        notifyFolderListeners(2);
        return true;
    }

    /* renamed from: e */
    public void m16352e(ACL acl) throws MessagingException {
        m16359P(acl, (char) 0);
    }

    @Override // javax.mail.Folder
    public synchronized boolean exists() throws MessagingException {
        String str;
        if (this.f35914h && this.f35910d != 0) {
            str = String.valueOf(this.f35907a) + this.f35910d;
        } else {
            str = this.f35907a;
        }
        ListInfo[] listInfoArr = (ListInfo[]) m16341p(new C12741k(str));
        if (listInfoArr != null) {
            int m16335v = m16335v(listInfoArr, str);
            String str2 = listInfoArr[m16335v].f36152a;
            this.f35907a = str2;
            this.f35910d = listInfoArr[m16335v].f36153b;
            int length = str2.length();
            if (this.f35910d != 0 && length > 0) {
                int i = length - 1;
                if (this.f35907a.charAt(i) == this.f35910d) {
                    this.f35907a = this.f35907a.substring(0, i);
                }
            }
            this.f35909c = 0;
            if (listInfoArr[m16335v].f36154c) {
                this.f35909c = 0 | 2;
            }
            if (listInfoArr[m16335v].f36155d) {
                this.f35909c |= 1;
            }
            this.f35913g = true;
            this.f35915i = listInfoArr[m16335v].f36157f;
        } else {
            this.f35913g = this.f35920n;
            this.f35915i = null;
        }
        return this.f35913g;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] expunge() throws MessagingException {
        return m16336u(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public synchronized Message[] m16351f(Message[] messageArr) throws MessagingException {
        MimeMessage[] mimeMessageArr;
        m16345l();
        mimeMessageArr = new MimeMessage[messageArr.length];
        AppendUID[] m16349h = m16349h(messageArr);
        for (int i = 0; i < m16349h.length; i++) {
            AppendUID appendUID = m16349h[i];
            if (appendUID != null && appendUID.f35888a == this.f35926u) {
                try {
                    mimeMessageArr[i] = getMessageByUID(appendUID.f35889b);
                } catch (MessagingException unused) {
                }
            }
        }
        return mimeMessageArr;
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        m16345l();
        IMAPMessage.m16302p(this, messageArr, fetchProfile);
    }

    /* renamed from: g */
    public void m16350g(ACL acl) throws MessagingException {
        m16359P(acl, '+');
    }

    @Override // javax.mail.Folder
    public synchronized int getDeletedMessageCount() throws MessagingException {
        int length;
        if (!this.f35920n) {
            m16347j();
            return -1;
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.DELETED);
        try {
            synchronized (this.f35918l) {
                length = m16374A().m16199D0(new FlagTerm(flags, true)).length;
            }
            return length;
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        if (this.f35915i != null && !m16367H()) {
            throw new MessagingException("Cannot contain subfolders");
        }
        char separator = getSeparator();
        return new IMAPFolder(String.valueOf(this.f35907a) + separator + str, separator, (IMAPStore) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized String getFullName() {
        return this.f35907a;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i) throws MessagingException {
        m16345l();
        m16344m(i);
        return (Message) this.f35917k.elementAt(i - 1);
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message getMessageByUID(long j) throws MessagingException {
        int i;
        m16345l();
        IMAPMessage iMAPMessage = null;
        try {
            synchronized (this.f35918l) {
                Long l = new Long(j);
                Hashtable hashtable = this.f35919m;
                if (hashtable != null) {
                    iMAPMessage = (IMAPMessage) hashtable.get(l);
                    if (iMAPMessage != null) {
                        return iMAPMessage;
                    }
                } else {
                    this.f35919m = new Hashtable();
                }
                UID m16168U = m16374A().m16168U(j);
                if (m16168U != null && (i = m16168U.f36189a) <= this.f35923r) {
                    iMAPMessage = m16331z(i);
                    iMAPMessage.m16318J(m16168U.f36190b);
                    this.f35919m.put(l, iMAPMessage);
                }
                return iMAPMessage;
            }
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        int i;
        if (!this.f35920n) {
            m16347j();
            try {
                try {
                    try {
                        return m16372C().f36183b;
                    } catch (ConnectionException e) {
                        throw new StoreClosedException(this.store, e.getMessage());
                    }
                } catch (BadCommandException unused) {
                    try {
                        IMAPProtocol m16371D = m16371D();
                        MailboxInfo m16194G = m16371D.m16194G(this.f35907a);
                        m16371D.m16126y();
                        int i2 = m16194G.f36160c;
                        m16362M(m16371D);
                        return i2;
                    } catch (ProtocolException e2) {
                        throw new MessagingException(e2.getMessage(), e2);
                    }
                }
            } catch (ProtocolException e3) {
                throw new MessagingException(e3.getMessage(), e3);
            }
        }
        synchronized (this.f35918l) {
            try {
                m16366I(true);
                i = this.f35923r;
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        return i;
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long j, long j2) throws MessagingException {
        Message[] messageArr;
        m16345l();
        try {
            synchronized (this.f35918l) {
                if (this.f35919m == null) {
                    this.f35919m = new Hashtable();
                }
                UID[] m16167V = m16374A().m16167V(j, j2);
                messageArr = new Message[m16167V.length];
                for (int i = 0; i < m16167V.length; i++) {
                    IMAPMessage m16331z = m16331z(m16167V[i].f36189a);
                    m16331z.m16318J(m16167V[i].f36190b);
                    messageArr[i] = m16331z;
                    this.f35919m.put(new Long(m16167V[i].f36190b), m16331z);
                }
            }
        } catch (ConnectionException e) {
            throw new FolderClosedException(this, e.getMessage());
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
        return messageArr;
    }

    @Override // javax.mail.Folder
    public synchronized String getName() {
        if (this.f35908b == null) {
            try {
                String str = this.f35907a;
                this.f35908b = str.substring(str.lastIndexOf(getSeparator()) + 1);
            } catch (MessagingException unused) {
            }
        }
        return this.f35908b;
    }

    @Override // javax.mail.Folder
    public synchronized int getNewMessageCount() throws MessagingException {
        int i;
        if (!this.f35920n) {
            m16347j();
            try {
                try {
                    try {
                        return m16372C().f36184c;
                    } catch (ConnectionException e) {
                        throw new StoreClosedException(this.store, e.getMessage());
                    }
                } catch (BadCommandException unused) {
                    try {
                        IMAPProtocol m16371D = m16371D();
                        MailboxInfo m16194G = m16371D.m16194G(this.f35907a);
                        m16371D.m16126y();
                        int i2 = m16194G.f36161d;
                        m16362M(m16371D);
                        return i2;
                    } catch (ProtocolException e2) {
                        throw new MessagingException(e2.getMessage(), e2);
                    }
                }
            } catch (ProtocolException e3) {
                throw new MessagingException(e3.getMessage(), e3);
            }
        }
        synchronized (this.f35918l) {
            try {
                m16366I(true);
                i = this.f35924s;
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        return i;
    }

    @Override // javax.mail.Folder
    public synchronized Folder getParent() throws MessagingException {
        char separator = getSeparator();
        int lastIndexOf = this.f35907a.lastIndexOf(separator);
        if (lastIndexOf != -1) {
            return new IMAPFolder(this.f35907a.substring(0, lastIndexOf), separator, (IMAPStore) this.store);
        }
        return new DefaultFolder((IMAPStore) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized Flags getPermanentFlags() {
        return (Flags) this.f35912f.clone();
    }

    @Override // javax.mail.Folder
    public synchronized char getSeparator() throws MessagingException {
        if (this.f35910d == 65535) {
            ListInfo[] listInfoArr = (ListInfo[]) m16341p(new C12743m());
            if (listInfoArr != null) {
                this.f35910d = listInfoArr[0].f36153b;
            } else {
                this.f35910d = '/';
            }
        }
        return this.f35910d;
    }

    @Override // javax.mail.Folder
    public synchronized int getType() throws MessagingException {
        if (this.f35920n) {
            if (this.f35915i == null) {
                exists();
            }
        } else {
            m16347j();
        }
        return this.f35909c;
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUID(Message message) throws MessagingException {
        if (message.getFolder() == this) {
            m16345l();
            IMAPMessage iMAPMessage = (IMAPMessage) message;
            long m16298x = iMAPMessage.m16298x();
            if (m16298x != -1) {
                return m16298x;
            }
            synchronized (this.f35918l) {
                try {
                    IMAPProtocol m16374A = m16374A();
                    iMAPMessage.mo16294n();
                    UID m16165X = m16374A.m16165X(iMAPMessage.mo16290w());
                    if (m16165X != null) {
                        m16298x = m16165X.f36190b;
                        iMAPMessage.m16318J(m16298x);
                        if (this.f35919m == null) {
                            this.f35919m = new Hashtable();
                        }
                        this.f35919m.put(new Long(m16298x), iMAPMessage);
                    }
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            return m16298x;
        }
        throw new NoSuchElementException("Message does not belong to this folder");
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUIDValidity() throws MessagingException {
        Throwable th;
        ProtocolException e;
        IMAPProtocol iMAPProtocol;
        BadCommandException e2;
        if (this.f35920n) {
            return this.f35926u;
        }
        Status status = null;
        try {
            try {
                iMAPProtocol = m16371D();
            } catch (BadCommandException e3) {
                e2 = e3;
            } catch (ConnectionException e4) {
                e = e4;
                iMAPProtocol = null;
            } catch (ProtocolException e5) {
                e = e5;
            } catch (Throwable th2) {
                th = th2;
                m16362M(null);
                throw th;
            }
            try {
                status = iMAPProtocol.m16185K0(this.f35907a, new String[]{"UIDVALIDITY"});
            } catch (BadCommandException e6) {
                e2 = e6;
                throw new MessagingException("Cannot obtain UIDValidity", e2);
            } catch (ConnectionException e7) {
                e = e7;
                m16357R(e);
                m16362M(iMAPProtocol);
                return status.f36186e;
            } catch (ProtocolException e8) {
                e = e8;
                throw new MessagingException(e.getMessage(), e);
            }
            m16362M(iMAPProtocol);
            return status.f36186e;
        } catch (Throwable th3) {
            th = th3;
            m16362M(null);
            throw th;
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getUnreadMessageCount() throws MessagingException {
        int length;
        if (!this.f35920n) {
            m16347j();
            try {
                try {
                    return m16372C().f36187f;
                } catch (BadCommandException unused) {
                    return -1;
                } catch (ProtocolException e) {
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (ConnectionException e2) {
                throw new StoreClosedException(this.store, e2.getMessage());
            }
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.SEEN);
        try {
            synchronized (this.f35918l) {
                length = m16374A().m16199D0(new FlagTerm(flags, false)).length;
            }
            return length;
        } catch (ConnectionException e3) {
            throw new FolderClosedException(this, e3.getMessage());
        } catch (ProtocolException e4) {
            throw new MessagingException(e4.getMessage(), e4);
        }
    }

    /* renamed from: h */
    public synchronized AppendUID[] m16349h(Message[] messageArr) throws MessagingException {
        AppendUID[] appendUIDArr;
        m16347j();
        int m16283f = ((IMAPStore) this.store).m16283f();
        appendUIDArr = new AppendUID[messageArr.length];
        for (int i = 0; i < messageArr.length; i++) {
            Message message = messageArr[i];
            try {
                C12755m c12755m = new C12755m(message, message.getSize() > m16283f ? 0 : m16283f);
                Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                appendUIDArr[i] = (AppendUID) m16341p(new C12732b(message.getFlags(), receivedDate, c12755m));
            } catch (IOException e) {
                throw new MessagingException("IOException while appending messages", e);
            } catch (MessageRemovedException unused) {
            }
        }
        return appendUIDArr;
    }

    @Override // javax.mail.Folder
    public synchronized boolean hasNewMessages() throws MessagingException {
        boolean z;
        if (this.f35920n) {
            synchronized (this.f35918l) {
                try {
                    m16366I(true);
                    z = this.f35924s > 0;
                } catch (ConnectionException e) {
                    throw new FolderClosedException(this, e.getMessage());
                } catch (ProtocolException e2) {
                    throw new MessagingException(e2.getMessage(), e2);
                }
            }
            return z;
        }
        m16347j();
        Boolean bool = (Boolean) m16340q(new C12747q());
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // javax.mail.Folder
    public synchronized boolean isOpen() {
        synchronized (this.f35918l) {
            if (this.f35920n) {
                try {
                    m16366I(false);
                } catch (ProtocolException unused) {
                }
            }
        }
        return this.f35920n;
    }

    @Override // javax.mail.Folder
    public synchronized boolean isSubscribed() {
        String str;
        ListInfo[] listInfoArr = null;
        if (this.f35914h && this.f35910d != 0) {
            str = String.valueOf(this.f35907a) + this.f35910d;
        } else {
            str = this.f35907a;
        }
        try {
            listInfoArr = (ListInfo[]) m16337t(new C12744n(str));
        } catch (ProtocolException unused) {
        }
        if (listInfoArr != null) {
            return listInfoArr[m16335v(listInfoArr, str)].f36155d;
        }
        return false;
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return m16339r(str, false);
    }

    @Override // javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        return m16339r(str, true);
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i) throws MessagingException {
        MailboxInfo m16195F0;
        m16348i();
        this.f35916j = ((IMAPStore) this.store).m16278k(this);
        synchronized (this.f35918l) {
            this.f35916j.m16421a(this);
            int i2 = 0;
            try {
                if (i == 1) {
                    m16195F0 = this.f35916j.m16194G(this.f35907a);
                } else {
                    m16195F0 = this.f35916j.m16195F0(this.f35907a);
                }
                int i3 = m16195F0.f36165h;
                if (i3 != i && (i != 2 || i3 != 1 || !((IMAPStore) this.store).m16287b())) {
                    try {
                        try {
                            try {
                                this.f35916j.m16126y();
                                m16363L(true);
                            } catch (ProtocolException unused) {
                                m16363L(false);
                                this.f35916j = null;
                                throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                            } catch (Throwable th) {
                                m16363L(false);
                                throw th;
                            }
                        } catch (Throwable unused2) {
                            this.f35916j = null;
                            throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                        }
                    } catch (ProtocolException unused3) {
                        this.f35916j.m16145n0();
                        m16363L(false);
                        this.f35916j = null;
                        throw new ReadOnlyFolderException(this, "Cannot open in desired mode");
                    }
                } else {
                    this.f35920n = true;
                    this.f35921o = false;
                    this.mode = m16195F0.f36165h;
                    this.f35911e = m16195F0.f36158a;
                    this.f35912f = m16195F0.f36159b;
                    int i4 = m16195F0.f36160c;
                    this.f35925t = i4;
                    this.f35923r = i4;
                    this.f35924s = m16195F0.f36161d;
                    this.f35926u = m16195F0.f36163f;
                    this.f35927v = m16195F0.f36164g;
                    this.f35917k = new Vector(this.f35923r);
                    while (i2 < this.f35923r) {
                        i2++;
                        this.f35917k.addElement(new IMAPMessage(this, i2, i2));
                    }
                }
            } catch (CommandFailedException e) {
                e = e;
                m16363L(true);
                this.f35916j = null;
            } catch (ProtocolException e2) {
                try {
                    this.f35916j.m16145n0();
                } catch (Throwable unused4) {
                }
                m16363L(false);
                this.f35916j = null;
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        e = null;
        if (e != null) {
            m16347j();
            if ((this.f35909c & 1) == 0) {
                throw new MessagingException("folder cannot contain messages");
            }
            throw new MessagingException(e.getMessage(), e);
        }
        this.f35913g = true;
        this.f35915i = null;
        this.f35909c = 1;
        notifyConnectionListeners(1);
    }

    /* renamed from: p */
    public Object m16341p(InterfaceC12751u interfaceC12751u) throws MessagingException {
        try {
            return m16337t(interfaceC12751u);
        } catch (ConnectionException e) {
            m16357R(e);
            return null;
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    /* renamed from: q */
    public Object m16340q(InterfaceC12751u interfaceC12751u) throws MessagingException {
        try {
            return m16337t(interfaceC12751u);
        } catch (CommandFailedException unused) {
            return null;
        } catch (ConnectionException e) {
            m16357R(e);
            return null;
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean renameTo(Folder folder) throws MessagingException {
        m16348i();
        m16347j();
        if (folder.getStore() == this.store) {
            if (m16340q(new C12749s(folder)) == null) {
                return false;
            }
            this.f35913g = false;
            this.f35915i = null;
            notifyFolderRenamedListeners(folder);
            return true;
        }
        throw new MessagingException("Can't rename across Stores");
    }

    /* renamed from: s */
    public Object m16338s(String str, InterfaceC12751u interfaceC12751u) throws MessagingException {
        try {
            return m16337t(interfaceC12751u);
        } catch (BadCommandException e) {
            throw new MessagingException(str, e);
        } catch (ConnectionException e2) {
            m16357R(e2);
            return null;
        } catch (ProtocolException e3) {
            throw new MessagingException(e3.getMessage(), e3);
        }
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm) throws MessagingException {
        IMAPMessage[] iMAPMessageArr;
        m16345l();
        iMAPMessageArr = null;
        try {
            try {
                synchronized (this.f35918l) {
                    int[] m16199D0 = m16374A().m16199D0(searchTerm);
                    if (m16199D0 != null) {
                        iMAPMessageArr = new IMAPMessage[m16199D0.length];
                        for (int i = 0; i < m16199D0.length; i++) {
                            iMAPMessageArr[i] = m16331z(m16199D0[i]);
                        }
                    }
                }
            } catch (ProtocolException e) {
                throw new MessagingException(e.getMessage(), e);
            } catch (SearchException unused) {
                return super.search(searchTerm);
            }
        } catch (CommandFailedException unused2) {
            return super.search(searchTerm);
        } catch (ConnectionException e2) {
            throw new FolderClosedException(this, e2.getMessage());
        }
        return iMAPMessageArr;
    }

    @Override // javax.mail.Folder
    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z) throws MessagingException {
        m16345l();
        m16346k(flags);
        if (messageArr.length == 0) {
            return;
        }
        synchronized (this.f35918l) {
            try {
                IMAPProtocol m16374A = m16374A();
                MessageSet[] m16230a = C12757o.m16230a(messageArr, null);
                if (m16230a != null) {
                    m16374A.m16177O0(m16230a, flags, z);
                } else {
                    throw new MessageRemovedException("Messages have been removed");
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized void setSubscribed(boolean z) throws MessagingException {
        m16340q(new C12745o(z));
    }

    /* renamed from: t */
    protected Object m16337t(InterfaceC12751u interfaceC12751u) throws ProtocolException {
        Object mo16330a;
        synchronized (this) {
            if (this.f35920n && !((IMAPStore) this.store).m16272q()) {
                synchronized (this.f35918l) {
                    mo16330a = interfaceC12751u.mo16330a(m16374A());
                }
                return mo16330a;
            }
            IMAPProtocol iMAPProtocol = null;
            try {
                iMAPProtocol = m16371D();
                return interfaceC12751u.mo16330a(iMAPProtocol);
            } finally {
                m16362M(iMAPProtocol);
            }
        }
    }

    /* renamed from: u */
    public synchronized Message[] m16336u(Message[] messageArr) throws MessagingException {
        Message[] messageArr2;
        m16345l();
        Vector vector = new Vector();
        if (messageArr != null) {
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(UIDFolder.FetchProfileItem.UID);
            fetch(messageArr, fetchProfile);
        }
        synchronized (this.f35918l) {
            int i = 0;
            this.f35928w = false;
            try {
                try {
                    try {
                        IMAPProtocol m16374A = m16374A();
                        if (messageArr != null) {
                            m16374A.m16173Q0(C12757o.m16229b(messageArr));
                        } else {
                            m16374A.m16192H();
                        }
                        while (i < this.f35917k.size()) {
                            IMAPMessage iMAPMessage = (IMAPMessage) this.f35917k.elementAt(i);
                            if (iMAPMessage.isExpunged()) {
                                vector.addElement(iMAPMessage);
                                this.f35917k.removeElementAt(i);
                                if (this.f35919m != null) {
                                    long m16298x = iMAPMessage.m16298x();
                                    if (m16298x != -1) {
                                        this.f35919m.remove(new Long(m16298x));
                                    }
                                }
                            } else {
                                iMAPMessage.setMessageNumber(iMAPMessage.mo16290w());
                                i++;
                            }
                        }
                    } catch (CommandFailedException e) {
                        if (this.mode != 2) {
                            throw new IllegalStateException("Cannot expunge READ_ONLY folder: " + this.f35907a);
                        }
                        throw new MessagingException(e.getMessage(), e);
                    } catch (ProtocolException e2) {
                        throw new MessagingException(e2.getMessage(), e2);
                    }
                } catch (ConnectionException e3) {
                    throw new FolderClosedException(this, e3.getMessage());
                }
            } finally {
                this.f35928w = true;
            }
        }
        this.f35923r = this.f35917k.size();
        int size = vector.size();
        messageArr2 = new Message[size];
        vector.copyInto(messageArr2);
        if (size > 0) {
            notifyMessageRemovedListeners(true, messageArr2);
        }
        return messageArr2;
    }

    /* renamed from: w */
    public synchronized void m16334w() throws MessagingException {
        m16342o(false, true);
    }

    /* renamed from: x */
    public ACL[] m16333x() throws MessagingException {
        return (ACL[]) m16338s("ACL not supported", new C12735e());
    }

    /* renamed from: y */
    public String[] m16332y() throws MessagingException {
        if (this.f35915i == null) {
            exists();
        }
        return (String[]) this.f35915i.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: z */
    public IMAPMessage m16331z(int i) {
        for (int i2 = i - 1; i2 < this.f35923r; i2++) {
            IMAPMessage iMAPMessage = (IMAPMessage) this.f35917k.elementAt(i2);
            if (iMAPMessage.mo16290w() == i) {
                return iMAPMessage;
            }
        }
        return null;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        IMAPMessage[] iMAPMessageArr;
        m16345l();
        if (messageArr.length == 0) {
            return messageArr;
        }
        try {
            try {
                try {
                    try {
                        synchronized (this.f35918l) {
                            IMAPProtocol m16374A = m16374A();
                            iMAPMessageArr = null;
                            MessageSet[] m16230a = C12757o.m16230a(messageArr, null);
                            if (m16230a != null) {
                                int[] m16197E0 = m16374A.m16197E0(m16230a, searchTerm);
                                if (m16197E0 != null) {
                                    iMAPMessageArr = new IMAPMessage[m16197E0.length];
                                    for (int i = 0; i < m16197E0.length; i++) {
                                        iMAPMessageArr[i] = m16331z(m16197E0[i]);
                                    }
                                }
                            } else {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                        }
                        return iMAPMessageArr;
                    } catch (ConnectionException e) {
                        throw new FolderClosedException(this, e.getMessage());
                    }
                } catch (SearchException unused) {
                    return super.search(searchTerm, messageArr);
                }
            } catch (CommandFailedException unused2) {
                return super.search(searchTerm, messageArr);
            }
        } catch (ProtocolException e2) {
            throw new MessagingException(e2.getMessage(), e2);
        }
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long[] jArr) throws MessagingException {
        long[] jArr2;
        Message[] messageArr;
        m16345l();
        try {
            try {
                synchronized (this.f35918l) {
                    if (this.f35919m != null) {
                        Vector vector = new Vector();
                        for (long j : jArr) {
                            Hashtable hashtable = this.f35919m;
                            Long l = new Long(j);
                            if (!hashtable.containsKey(l)) {
                                vector.addElement(l);
                            }
                        }
                        int size = vector.size();
                        jArr2 = new long[size];
                        for (int i = 0; i < size; i++) {
                            jArr2[i] = ((Long) vector.elementAt(i)).longValue();
                        }
                    } else {
                        this.f35919m = new Hashtable();
                        jArr2 = jArr;
                    }
                    if (jArr2.length > 0) {
                        UID[] m16166W = m16374A().m16166W(jArr2);
                        for (int i2 = 0; i2 < m16166W.length; i2++) {
                            IMAPMessage m16331z = m16331z(m16166W[i2].f36189a);
                            m16331z.m16318J(m16166W[i2].f36190b);
                            this.f35919m.put(new Long(m16166W[i2].f36190b), m16331z);
                        }
                    }
                    messageArr = new Message[jArr.length];
                    for (int i3 = 0; i3 < jArr.length; i3++) {
                        messageArr[i3] = (Message) this.f35919m.get(new Long(jArr[i3]));
                    }
                }
            } catch (ProtocolException e) {
                throw new MessagingException(e.getMessage(), e);
            }
        } catch (ConnectionException e2) {
            throw new FolderClosedException(this, e2.getMessage());
        }
        return messageArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPFolder(String str, char c, IMAPStore iMAPStore, boolean z) {
        this(str, c, iMAPStore);
        this.f35914h = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPFolder(ListInfo listInfo, IMAPStore iMAPStore) {
        this(listInfo.f36152a, listInfo.f36153b, iMAPStore);
        if (listInfo.f36154c) {
            this.f35909c |= 2;
        }
        if (listInfo.f36155d) {
            this.f35909c |= 1;
        }
        this.f35913g = true;
        this.f35915i = listInfo.f36157f;
    }
}
