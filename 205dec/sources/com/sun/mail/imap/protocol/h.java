package com.sun.mail.imap.protocol;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.LiteralException;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import javax.mail.Flags;
import javax.mail.Quota;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPProtocol.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h extends com.sun.mail.iap.f {
    private static final byte[] A = {13, 10};
    private static final byte[] B = {68, 79, 78, 69, 13, 10};

    /* renamed from: q  reason: collision with root package name */
    private boolean f50532q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f50533r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f50534s;

    /* renamed from: t  reason: collision with root package name */
    private Map f50535t;

    /* renamed from: u  reason: collision with root package name */
    private List f50536u;

    /* renamed from: v  reason: collision with root package name */
    private String[] f50537v;

    /* renamed from: w  reason: collision with root package name */
    private String f50538w;

    /* renamed from: x  reason: collision with root package name */
    private s f50539x;

    /* renamed from: y  reason: collision with root package name */
    private com.sun.mail.iap.d f50540y;

    /* renamed from: z  reason: collision with root package name */
    private String f50541z;

    public h(String str, String str2, int i4, boolean z3, PrintStream printStream, Properties properties, boolean z4) throws IOException, ProtocolException {
        super(str2, i4, z3, printStream, properties, "mail." + str, z4);
        this.f50532q = false;
        this.f50533r = false;
        this.f50535t = null;
        this.f50536u = null;
        try {
            this.f50538w = str;
            w();
            if (e0("IMAP4rev1")) {
                this.f50533r = true;
            }
            this.f50537v = r0;
            String[] strArr = {"UTF-8", MimeUtility.mimeCharset(MimeUtility.getDefaultJavaCharset())};
            this.f50532q = true;
        } catch (Throwable th) {
            if (!this.f50532q) {
                c();
            }
            throw th;
        }
    }

    private void A(String str, String str2) throws ProtocolException {
        String a4 = b.a(str2);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.i(str);
        bVar.o(a4);
        n("COPY", bVar);
    }

    private int[] C0(String str, SearchTerm searchTerm) throws ProtocolException, SearchException {
        if (t.h(searchTerm)) {
            try {
                return j0(str, searchTerm, null);
            } catch (IOException unused) {
            }
        }
        int i4 = 0;
        while (true) {
            String[] strArr = this.f50537v;
            if (i4 < strArr.length) {
                if (strArr[i4] != null) {
                    try {
                        return j0(str, searchTerm, strArr[i4]);
                    } catch (CommandFailedException unused2) {
                        this.f50537v[i4] = null;
                    } catch (ProtocolException e4) {
                        throw e4;
                    } catch (IOException unused3) {
                    } catch (SearchException e5) {
                        throw e5;
                    }
                }
                i4++;
            } else {
                throw new SearchException("Search failed");
            }
        }
    }

    private String D(Flags flags) {
        Flags.Flag[] systemFlags;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        boolean z3 = true;
        for (Flags.Flag flag : flags.getSystemFlags()) {
            if (flag == Flags.Flag.ANSWERED) {
                str = "\\Answered";
            } else if (flag == Flags.Flag.DELETED) {
                str = "\\Deleted";
            } else if (flag == Flags.Flag.DRAFT) {
                str = "\\Draft";
            } else if (flag == Flags.Flag.FLAGGED) {
                str = "\\Flagged";
            } else if (flag == Flags.Flag.RECENT) {
                str = "\\Recent";
            } else if (flag == Flags.Flag.SEEN) {
                str = "\\Seen";
            }
            if (z3) {
                z3 = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str);
        }
        String[] userFlags = flags.getUserFlags();
        for (String str2 : userFlags) {
            if (z3) {
                z3 = false;
            } else {
                stringBuffer.append(' ');
            }
            stringBuffer.append(str2);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    private m[] F(String str, String str2, String str3) throws ProtocolException {
        String a4 = b.a(str2);
        String a5 = b.a(str3);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        bVar.o(a5);
        com.sun.mail.iap.g[] b4 = b(str, bVar);
        com.sun.mail.iap.g gVar = b4[b4.length - 1];
        m[] mVarArr = null;
        if (gVar.h()) {
            Vector vector = new Vector(1);
            int length = b4.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (b4[i4] instanceof i) {
                    i iVar = (i) b4[i4];
                    if (iVar.F(str)) {
                        vector.addElement(new m(iVar));
                        b4[i4] = null;
                    }
                }
            }
            if (vector.size() > 0) {
                mVarArr = new m[vector.size()];
                vector.copyInto(mVarArr);
            }
        }
        j(b4);
        h(gVar);
        return mVarArr;
    }

    private com.sun.mail.iap.g[] K(String str, String str2, boolean z3) throws ProtocolException {
        if (z3) {
            return b("UID FETCH " + str + " (" + str2 + ")", null);
        }
        return b("FETCH " + str + " (" + str2 + ")", null);
    }

    private void N0(String str, Flags flags, boolean z3) throws ProtocolException {
        com.sun.mail.iap.g[] b4;
        if (z3) {
            b4 = b("STORE " + str + " +FLAGS " + D(flags), null);
        } else {
            b4 = b("STORE " + str + " -FLAGS " + D(flags), null);
        }
        j(b4);
        h(b4[b4.length - 1]);
    }

    private com.sun.mail.imap.b Z(com.sun.mail.iap.g gVar) {
        byte r3;
        if (gVar.h()) {
            do {
                r3 = gVar.r();
                if (r3 <= 0) {
                    break;
                }
            } while (r3 != 91);
            if (r3 != 0 && gVar.o().equalsIgnoreCase("APPENDUID")) {
                return new com.sun.mail.imap.b(gVar.u(), gVar.u());
            }
            return null;
        }
        return null;
    }

    private int[] j0(String str, SearchTerm searchTerm, String str2) throws ProtocolException, SearchException, IOException {
        int[] iArr = null;
        com.sun.mail.iap.b e4 = t.e(searchTerm, str2 == null ? null : MimeUtility.javaCharset(str2));
        e4.i(str);
        com.sun.mail.iap.g[] b4 = str2 == null ? b("SEARCH", e4) : b("SEARCH CHARSET " + str2, e4);
        com.sun.mail.iap.g gVar = b4[b4.length - 1];
        if (gVar.h()) {
            Vector vector = new Vector();
            int length = b4.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (b4[i4] instanceof i) {
                    i iVar = (i) b4[i4];
                    if (iVar.F("SEARCH")) {
                        while (true) {
                            int v3 = iVar.v();
                            if (v3 == -1) {
                                break;
                            }
                            vector.addElement(new Integer(v3));
                        }
                        b4[i4] = null;
                    }
                }
            }
            int size = vector.size();
            int[] iArr2 = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr2[i5] = ((Integer) vector.elementAt(i5)).intValue();
            }
            iArr = iArr2;
        }
        j(b4);
        h(gVar);
        return iArr;
    }

    private Quota t0(com.sun.mail.iap.g gVar) throws ParsingException {
        Quota quota = new Quota(gVar.q());
        gVar.B();
        if (gVar.r() == 40) {
            Vector vector = new Vector();
            while (gVar.n() != 41) {
                String o4 = gVar.o();
                if (o4 != null) {
                    vector.addElement(new Quota.Resource(o4, gVar.u(), gVar.u()));
                }
            }
            gVar.r();
            Quota.Resource[] resourceArr = new Quota.Resource[vector.size()];
            quota.resources = resourceArr;
            vector.copyInto(resourceArr);
            return quota;
        }
        throw new ParsingException("parse error in QUOTA");
    }

    public void A0(String str, String str2) throws ProtocolException {
        String a4 = b.a(str);
        String a5 = b.a(str2);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        bVar.o(a5);
        n("RENAME", bVar);
    }

    public void B(o[] oVarArr, String str) throws ProtocolException {
        A(o.d(oVarArr), str);
    }

    public void B0(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        List list;
        if (this.f50539x == null) {
            try {
                Constructor constructor = j.class.getConstructor(h.class, String.class, Properties.class, Boolean.TYPE, PrintStream.class, String.class);
                Object[] objArr = new Object[6];
                objArr[0] = this;
                objArr[1] = this.f50538w;
                objArr[2] = this.f50276f;
                objArr[3] = this.f50273c ? Boolean.TRUE : Boolean.FALSE;
                objArr[4] = this.f50275e;
                objArr[5] = this.f50271a;
                this.f50539x = (s) constructor.newInstance(objArr);
            } catch (Exception e4) {
                if (this.f50273c) {
                    PrintStream printStream = this.f50275e;
                    printStream.println("IMAP DEBUG: Can't load SASL authenticator: " + e4);
                    return;
                }
                return;
            }
        }
        if (strArr != null && strArr.length > 0) {
            list = new ArrayList(strArr.length);
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (this.f50536u.contains(strArr[i4])) {
                    list.add(strArr[i4]);
                }
            }
        } else {
            list = this.f50536u;
        }
        if (this.f50539x.a((String[]) list.toArray(new String[list.size()]), str, str2, str3, str4)) {
            this.f50534s = true;
        }
    }

    public void C(String str) throws ProtocolException {
        String a4 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        n("CREATE", bVar);
    }

    public int[] D0(SearchTerm searchTerm) throws ProtocolException, SearchException {
        return C0("ALL", searchTerm);
    }

    public void E(String str, String str2) throws ProtocolException {
        if (e0("ACL")) {
            String a4 = b.a(str);
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(a4);
            bVar.o(str2);
            com.sun.mail.iap.g[] b4 = b("DELETEACL", bVar);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            j(b4);
            h(gVar);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    public int[] E0(o[] oVarArr, SearchTerm searchTerm) throws ProtocolException, SearchException {
        return C0(o.d(oVarArr), searchTerm);
    }

    public n F0(String str) throws ProtocolException {
        String a4 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        com.sun.mail.iap.g[] b4 = b("SELECT", bVar);
        n nVar = new n(b4);
        j(b4);
        com.sun.mail.iap.g gVar = b4[b4.length - 1];
        if (gVar.h()) {
            if (gVar.toString().indexOf("READ-ONLY") != -1) {
                nVar.f50575h = 1;
            } else {
                nVar.f50575h = 2;
            }
        }
        h(gVar);
        return nVar;
    }

    public n G(String str) throws ProtocolException {
        String a4 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        com.sun.mail.iap.g[] b4 = b("EXAMINE", bVar);
        n nVar = new n(b4);
        nVar.f50575h = 1;
        j(b4);
        h(b4[b4.length - 1]);
        return nVar;
    }

    public void G0(String str, char c4, com.sun.mail.imap.a aVar) throws ProtocolException {
        if (e0("ACL")) {
            String a4 = b.a(str);
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(a4);
            bVar.o(aVar.a());
            String nVar = aVar.b().toString();
            if (c4 == '+' || c4 == '-') {
                nVar = String.valueOf(c4) + nVar;
            }
            bVar.o(nVar);
            com.sun.mail.iap.g[] b4 = b("SETACL", bVar);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            j(b4);
            h(gVar);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    public void H() throws ProtocolException {
        n("EXPUNGE", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H0(com.sun.mail.iap.g gVar) {
        byte r3;
        do {
            r3 = gVar.r();
            if (r3 <= 0) {
                break;
            }
        } while (r3 != 91);
        if (r3 != 0 && gVar.o().equalsIgnoreCase("CAPABILITY")) {
            this.f50535t = new HashMap(10);
            this.f50536u = new ArrayList(5);
            s0(gVar);
        }
    }

    public com.sun.mail.iap.g[] I(int i4, int i5, String str) throws ProtocolException {
        return K(String.valueOf(String.valueOf(i4)) + ":" + String.valueOf(i5), str, false);
    }

    public void I0(Quota quota) throws ProtocolException {
        if (e0("QUOTA")) {
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(quota.quotaRoot);
            com.sun.mail.iap.b bVar2 = new com.sun.mail.iap.b();
            if (quota.resources != null) {
                int i4 = 0;
                while (true) {
                    Quota.Resource[] resourceArr = quota.resources;
                    if (i4 >= resourceArr.length) {
                        break;
                    }
                    bVar2.i(resourceArr[i4].name);
                    bVar2.n(quota.resources[i4].limit);
                    i4++;
                }
            }
            bVar.h(bVar2);
            com.sun.mail.iap.g[] b4 = b("SETQUOTA", bVar);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            j(b4);
            h(gVar);
            return;
        }
        throw new BadCommandException("QUOTA not supported");
    }

    public com.sun.mail.iap.g[] J(int i4, String str) throws ProtocolException {
        return K(String.valueOf(i4), str, false);
    }

    public void J0() throws ProtocolException {
        try {
            super.o("STARTTLS");
        } catch (ProtocolException e4) {
            throw e4;
        } catch (Exception e5) {
            j(new com.sun.mail.iap.g[]{com.sun.mail.iap.g.a(e5)});
            c();
        }
    }

    public u K0(String str, String[] strArr) throws ProtocolException {
        if (!i0() && !e0("IMAP4SUNVERSION")) {
            throw new BadCommandException("STATUS not supported");
        }
        String a4 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        com.sun.mail.iap.b bVar2 = new com.sun.mail.iap.b();
        if (strArr == null) {
            strArr = u.f50591g;
        }
        for (String str2 : strArr) {
            bVar2.i(str2);
        }
        bVar.h(bVar2);
        com.sun.mail.iap.g[] b4 = b("STATUS", bVar);
        com.sun.mail.iap.g gVar = b4[b4.length - 1];
        u uVar = null;
        if (gVar.h()) {
            int length = b4.length;
            u uVar2 = null;
            for (int i4 = 0; i4 < length; i4++) {
                if (b4[i4] instanceof i) {
                    i iVar = (i) b4[i4];
                    if (iVar.F("STATUS")) {
                        if (uVar2 == null) {
                            uVar2 = new u(iVar);
                        } else {
                            u.a(uVar2, new u(iVar));
                        }
                        b4[i4] = null;
                    }
                }
            }
            uVar = uVar2;
        }
        j(b4);
        h(gVar);
        return uVar;
    }

    public com.sun.mail.iap.g[] L(o[] oVarArr, String str) throws ProtocolException {
        return K(o.d(oVarArr), str, false);
    }

    public void L0(int i4, int i5, Flags flags, boolean z3) throws ProtocolException {
        N0(String.valueOf(String.valueOf(i4)) + ":" + String.valueOf(i5), flags, z3);
    }

    public c M(int i4, String str) throws ProtocolException {
        return Q(i4, str, false);
    }

    public void M0(int i4, Flags flags, boolean z3) throws ProtocolException {
        N0(String.valueOf(i4), flags, z3);
    }

    public c N(int i4, String str, int i5, int i6) throws ProtocolException {
        return P(i4, str, i5, i6, false, null);
    }

    public c O(int i4, String str, int i5, int i6, com.sun.mail.iap.d dVar) throws ProtocolException {
        return P(i4, str, i5, i6, false, dVar);
    }

    public void O0(o[] oVarArr, Flags flags, boolean z3) throws ProtocolException {
        N0(o.d(oVarArr), flags, z3);
    }

    protected c P(int i4, String str, int i5, int i6, boolean z3, com.sun.mail.iap.d dVar) throws ProtocolException {
        this.f50540y = dVar;
        StringBuilder sb = new StringBuilder(z3 ? "BODY.PEEK[" : "BODY[");
        String str2 = "]<";
        if (str != null) {
            str2 = str + "]<";
        }
        sb.append(str2);
        sb.append(String.valueOf(i5));
        sb.append(".");
        sb.append(String.valueOf(i6));
        sb.append(">");
        com.sun.mail.iap.g[] J = J(i4, sb.toString());
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (c) f.K(J, i4, c.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public void P0(String str) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(b.a(str));
        n("SUBSCRIBE", bVar);
    }

    protected c Q(int i4, String str, boolean z3) throws ProtocolException {
        com.sun.mail.iap.g[] J;
        String str2 = "]";
        if (z3) {
            StringBuilder sb = new StringBuilder("BODY.PEEK[");
            if (str != null) {
                str2 = str + "]";
            }
            sb.append(str2);
            J = J(i4, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder("BODY[");
            if (str != null) {
                str2 = str + "]";
            }
            sb2.append(str2);
            J = J(i4, sb2.toString());
        }
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (c) f.K(J, i4, c.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public void Q0(w[] wVarArr) throws ProtocolException {
        if (e0("UIDPLUS")) {
            n("UID EXPUNGE " + w.d(wVarArr), null);
            return;
        }
        throw new BadCommandException("UID EXPUNGE not supported");
    }

    public d R(int i4) throws ProtocolException {
        com.sun.mail.iap.g[] J = J(i4, "BODYSTRUCTURE");
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (d) f.K(J, i4, d.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public void R0(String str) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(b.a(str));
        n("UNSUBSCRIBE", bVar);
    }

    public Flags S(int i4) throws ProtocolException {
        com.sun.mail.iap.g[] J = J(i4, "FLAGS");
        int length = J.length;
        int i5 = 0;
        Flags flags = null;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (J[i5] != null && (J[i5] instanceof f) && ((f) J[i5]).E() == i4 && (flags = (Flags) ((f) J[i5]).J(Flags.class)) != null) {
                J[i5] = null;
                break;
            } else {
                i5++;
            }
        }
        j(J);
        h(J[J.length - 1]);
        return flags;
    }

    public q T(int i4, String str) throws ProtocolException {
        String str2;
        if (str == null) {
            str2 = "RFC822";
        } else {
            str2 = "RFC822." + str;
        }
        com.sun.mail.iap.g[] J = J(i4, str2);
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (q) f.K(J, i4, q.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public v U(long j4) throws ProtocolException {
        com.sun.mail.iap.g[] K = K(String.valueOf(j4), "UID", true);
        int length = K.length;
        v vVar = null;
        for (int i4 = 0; i4 < length; i4++) {
            if (K[i4] != null && (K[i4] instanceof f) && (vVar = (v) ((f) K[i4]).J(v.class)) != null) {
                if (vVar.f50600b == j4) {
                    break;
                }
                vVar = null;
            }
        }
        j(K);
        h(K[K.length - 1]);
        return vVar;
    }

    public v[] V(long j4, long j5) throws ProtocolException {
        v vVar;
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(j4)));
        sb.append(":");
        sb.append(j5 == -1 ? "*" : String.valueOf(j5));
        com.sun.mail.iap.g[] K = K(sb.toString(), "UID", true);
        Vector vector = new Vector();
        int length = K.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (K[i4] != null && (K[i4] instanceof f) && (vVar = (v) ((f) K[i4]).J(v.class)) != null) {
                vector.addElement(vVar);
            }
        }
        j(K);
        h(K[K.length - 1]);
        v[] vVarArr = new v[vector.size()];
        vector.copyInto(vVarArr);
        return vVarArr;
    }

    public v[] W(long[] jArr) throws ProtocolException {
        v vVar;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < jArr.length; i4++) {
            if (i4 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf(jArr[i4]));
        }
        com.sun.mail.iap.g[] K = K(stringBuffer.toString(), "UID", true);
        Vector vector = new Vector();
        int length = K.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (K[i5] != null && (K[i5] instanceof f) && (vVar = (v) ((f) K[i5]).J(v.class)) != null) {
                vector.addElement(vVar);
            }
        }
        j(K);
        h(K[K.length - 1]);
        v[] vVarArr = new v[vector.size()];
        vector.copyInto(vVarArr);
        return vVarArr;
    }

    public v X(int i4) throws ProtocolException {
        com.sun.mail.iap.g[] J = J(i4, "UID");
        j(J);
        com.sun.mail.iap.g gVar = J[J.length - 1];
        if (gVar.h()) {
            return (v) f.K(J, i4, v.class);
        }
        if (gVar.g()) {
            return null;
        }
        h(gVar);
        return null;
    }

    public com.sun.mail.imap.a[] Y(String str) throws ProtocolException {
        String q3;
        if (e0("ACL")) {
            String a4 = b.a(str);
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(a4);
            com.sun.mail.iap.g[] b4 = b("GETACL", bVar);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            Vector vector = new Vector();
            if (gVar.h()) {
                int length = b4.length;
                for (int i4 = 0; i4 < length; i4++) {
                    if (b4[i4] instanceof i) {
                        i iVar = (i) b4[i4];
                        if (iVar.F("ACL")) {
                            iVar.q();
                            while (true) {
                                String q4 = iVar.q();
                                if (q4 != null && (q3 = iVar.q()) != null) {
                                    vector.addElement(new com.sun.mail.imap.a(q4, new com.sun.mail.imap.n(q3)));
                                }
                            }
                            b4[i4] = null;
                        }
                    }
                }
            }
            j(b4);
            h(gVar);
            com.sun.mail.imap.a[] aVarArr = new com.sun.mail.imap.a[vector.size()];
            vector.copyInto(aVarArr);
            return aVarArr;
        }
        throw new BadCommandException("ACL not supported");
    }

    public Map a0() {
        return this.f50535t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStream b0() {
        return e();
    }

    @Override // com.sun.mail.iap.f
    public void c() {
        super.c();
        this.f50534s = false;
    }

    public Quota[] c0(String str) throws ProtocolException {
        if (e0("QUOTA")) {
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(str);
            com.sun.mail.iap.g[] b4 = b("GETQUOTA", bVar);
            Vector vector = new Vector();
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            if (gVar.h()) {
                int length = b4.length;
                for (int i4 = 0; i4 < length; i4++) {
                    if (b4[i4] instanceof i) {
                        i iVar = (i) b4[i4];
                        if (iVar.F("QUOTA")) {
                            vector.addElement(t0(iVar));
                            b4[i4] = null;
                        }
                    }
                }
            }
            j(b4);
            h(gVar);
            Quota[] quotaArr = new Quota[vector.size()];
            vector.copyInto(quotaArr);
            return quotaArr;
        }
        throw new BadCommandException("QUOTA not supported");
    }

    public Quota[] d0(String str) throws ProtocolException {
        if (e0("QUOTA")) {
            String a4 = b.a(str);
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(a4);
            com.sun.mail.iap.g[] b4 = b("GETQUOTAROOT", bVar);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            Hashtable hashtable = new Hashtable();
            int i4 = 0;
            if (gVar.h()) {
                int length = b4.length;
                for (int i5 = 0; i5 < length; i5++) {
                    if (b4[i5] instanceof i) {
                        i iVar = (i) b4[i5];
                        if (iVar.F("QUOTAROOT")) {
                            iVar.q();
                            while (true) {
                                String q3 = iVar.q();
                                if (q3 == null) {
                                    break;
                                }
                                hashtable.put(q3, new Quota(q3));
                            }
                            b4[i5] = null;
                        } else if (iVar.F("QUOTA")) {
                            Quota t02 = t0(iVar);
                            Quota quota = (Quota) hashtable.get(t02.quotaRoot);
                            hashtable.put(t02.quotaRoot, t02);
                            b4[i5] = null;
                        }
                    }
                }
            }
            j(b4);
            h(gVar);
            Quota[] quotaArr = new Quota[hashtable.size()];
            Enumeration elements = hashtable.elements();
            while (elements.hasMoreElements()) {
                quotaArr[i4] = (Quota) elements.nextElement();
                i4++;
            }
            return quotaArr;
        }
        throw new BadCommandException("GETQUOTAROOT not supported");
    }

    public void delete(String str) throws ProtocolException {
        String a4 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        n("DELETE", bVar);
    }

    public boolean e0(String str) {
        return this.f50535t.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.f
    public com.sun.mail.iap.d f() {
        com.sun.mail.iap.d dVar = this.f50540y;
        this.f50540y = null;
        return dVar;
    }

    public void f0() throws ProtocolException {
        OutputStream e4 = e();
        try {
            e4.write(B);
            e4.flush();
        } catch (IOException unused) {
        }
    }

    public synchronized void g0() throws ProtocolException {
        com.sun.mail.iap.g a4;
        if (e0("IDLE")) {
            try {
                this.f50541z = q("IDLE", null);
                a4 = l();
            } catch (LiteralException e4) {
                a4 = e4.getResponse();
            } catch (Exception e5) {
                a4 = com.sun.mail.iap.g.a(e5);
            }
            if (!a4.f()) {
                h(a4);
            }
        } else {
            throw new BadCommandException("IDLE not supported");
        }
    }

    public boolean h0() {
        return this.f50534s;
    }

    public boolean i0() {
        return this.f50533r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.f
    public void k(com.sun.mail.iap.g gVar) throws ProtocolException {
        super.k(gVar);
        if (gVar.h()) {
            H0(gVar);
        } else if (((i) gVar).F("PREAUTH")) {
            this.f50534s = true;
            H0(gVar);
        } else {
            throw new ConnectionException(this, gVar);
        }
    }

    public m[] k0(String str, String str2) throws ProtocolException {
        return F("LIST", str, str2);
    }

    @Override // com.sun.mail.iap.f
    public com.sun.mail.iap.g l() throws IOException, ProtocolException {
        return i.G(this);
    }

    public com.sun.mail.imap.n[] l0(String str, String str2) throws ProtocolException {
        if (e0("ACL")) {
            String a4 = b.a(str);
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(a4);
            bVar.o(str2);
            com.sun.mail.iap.g[] b4 = b("LISTRIGHTS", bVar);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            Vector vector = new Vector();
            if (gVar.h()) {
                int length = b4.length;
                for (int i4 = 0; i4 < length; i4++) {
                    if (b4[i4] instanceof i) {
                        i iVar = (i) b4[i4];
                        if (iVar.F("LISTRIGHTS")) {
                            iVar.q();
                            iVar.q();
                            while (true) {
                                String q3 = iVar.q();
                                if (q3 == null) {
                                    break;
                                }
                                vector.addElement(new com.sun.mail.imap.n(q3));
                            }
                            b4[i4] = null;
                        }
                    }
                }
            }
            j(b4);
            h(gVar);
            com.sun.mail.imap.n[] nVarArr = new com.sun.mail.imap.n[vector.size()];
            vector.copyInto(nVarArr);
            return nVarArr;
        }
        throw new BadCommandException("ACL not supported");
    }

    public void m0(String str, String str2) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(str);
        bVar.o(str2);
        com.sun.mail.iap.g[] b4 = b("LOGIN", bVar);
        j(b4);
        h(b4[b4.length - 1]);
        H0(b4[b4.length - 1]);
        this.f50534s = true;
    }

    public void n0() throws ProtocolException {
        com.sun.mail.iap.g[] b4 = b("LOGOUT", null);
        this.f50534s = false;
        j(b4);
        c();
    }

    public m[] o0(String str, String str2) throws ProtocolException {
        return F("LSUB", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.f
    public boolean p() {
        return e0("LITERAL+");
    }

    public com.sun.mail.imap.n p0(String str) throws ProtocolException {
        if (e0("ACL")) {
            String a4 = b.a(str);
            com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
            bVar.o(a4);
            com.sun.mail.iap.g[] b4 = b("MYRIGHTS", bVar);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            com.sun.mail.imap.n nVar = null;
            if (gVar.h()) {
                int length = b4.length;
                com.sun.mail.imap.n nVar2 = null;
                for (int i4 = 0; i4 < length; i4++) {
                    if (b4[i4] instanceof i) {
                        i iVar = (i) b4[i4];
                        if (iVar.F("MYRIGHTS")) {
                            iVar.q();
                            String q3 = iVar.q();
                            if (nVar2 == null) {
                                nVar2 = new com.sun.mail.imap.n(q3);
                            }
                            b4[i4] = null;
                        }
                    }
                }
                nVar = nVar2;
            }
            j(b4);
            h(gVar);
            return nVar;
        }
        throw new BadCommandException("ACL not supported");
    }

    public p q0() throws ProtocolException {
        if (e0("NAMESPACE")) {
            p pVar = null;
            com.sun.mail.iap.g[] b4 = b("NAMESPACE", null);
            com.sun.mail.iap.g gVar = b4[b4.length - 1];
            if (gVar.h()) {
                int length = b4.length;
                p pVar2 = null;
                for (int i4 = 0; i4 < length; i4++) {
                    if (b4[i4] instanceof i) {
                        i iVar = (i) b4[i4];
                        if (iVar.F("NAMESPACE")) {
                            if (pVar2 == null) {
                                pVar2 = new p(iVar);
                            }
                            b4[i4] = null;
                        }
                    }
                }
                pVar = pVar2;
            }
            j(b4);
            h(gVar);
            return pVar;
        }
        throw new BadCommandException("NAMESPACE not supported");
    }

    public void r(String str, Flags flags, Date date, com.sun.mail.iap.e eVar) throws ProtocolException {
        t(str, flags, date, eVar, false);
    }

    public void r0() throws ProtocolException {
        if (this.f50273c) {
            this.f50275e.println("IMAP DEBUG: IMAPProtocol noop");
        }
        n("NOOP", null);
    }

    public com.sun.mail.imap.b s(String str, Flags flags, Date date, com.sun.mail.iap.e eVar) throws ProtocolException {
        return t(str, flags, date, eVar, true);
    }

    protected void s0(com.sun.mail.iap.g gVar) {
        while (true) {
            String p3 = gVar.p(']');
            if (p3 == null) {
                return;
            }
            if (p3.length() == 0) {
                if (gVar.n() == 93) {
                    return;
                }
                gVar.C();
            } else {
                this.f50535t.put(p3.toUpperCase(Locale.ENGLISH), p3);
                if (p3.regionMatches(true, 0, "AUTH=", 0, 5)) {
                    this.f50536u.add(p3.substring(5));
                    if (this.f50273c) {
                        PrintStream printStream = this.f50275e;
                        printStream.println("IMAP DEBUG: AUTH: " + p3.substring(5));
                    }
                }
            }
        }
    }

    public com.sun.mail.imap.b t(String str, Flags flags, Date date, com.sun.mail.iap.e eVar, boolean z3) throws ProtocolException {
        String a4 = b.a(str);
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(a4);
        if (flags != null) {
            Flags.Flag flag = Flags.Flag.RECENT;
            if (flags.contains(flag)) {
                Flags flags2 = new Flags(flags);
                flags2.remove(flag);
                flags = flags2;
            }
            bVar.i(D(flags));
        }
        if (date != null) {
            bVar.o(k.a(date));
        }
        bVar.j(eVar);
        com.sun.mail.iap.g[] b4 = b("APPEND", bVar);
        j(b4);
        h(b4[b4.length - 1]);
        if (z3) {
            return Z(b4[b4.length - 1]);
        }
        return null;
    }

    public synchronized void u(String str, String str2) throws ProtocolException {
        com.sun.mail.iap.g a4;
        boolean z3;
        String str3;
        Vector vector = new Vector();
        String str4 = null;
        try {
            z3 = false;
            a4 = null;
            str4 = q("AUTHENTICATE LOGIN", null);
        } catch (Exception e4) {
            a4 = com.sun.mail.iap.g.a(e4);
            z3 = true;
        }
        OutputStream e5 = e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        boolean z4 = true;
        while (!z3) {
            try {
                a4 = l();
            } catch (Exception e6) {
                a4 = com.sun.mail.iap.g.a(e6);
            }
            if (a4.f()) {
                if (z4) {
                    str3 = str;
                    z4 = false;
                } else {
                    str3 = str2;
                }
                bASE64EncoderStream.write(ASCIIUtility.getBytes(str3));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(A);
                e5.write(byteArrayOutputStream.toByteArray());
                e5.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!a4.j() || !a4.c().equals(str4)) && !a4.e()) {
                    vector.addElement(a4);
                }
                z3 = true;
            }
        }
        com.sun.mail.iap.g[] gVarArr = new com.sun.mail.iap.g[vector.size()];
        vector.copyInto(gVarArr);
        j(gVarArr);
        h(a4);
        H0(a4);
        this.f50534s = true;
    }

    public c u0(int i4, String str) throws ProtocolException {
        return Q(i4, str, true);
    }

    public synchronized void v(String str, String str2, String str3) throws ProtocolException {
        com.sun.mail.iap.g a4;
        Vector vector = new Vector();
        boolean z3 = false;
        String str4 = null;
        try {
            a4 = null;
            str4 = q("AUTHENTICATE PLAIN", null);
        } catch (Exception e4) {
            a4 = com.sun.mail.iap.g.a(e4);
            z3 = true;
        }
        OutputStream e5 = e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        while (!z3) {
            try {
                a4 = l();
            } catch (Exception e6) {
                a4 = com.sun.mail.iap.g.a(e6);
            }
            if (a4.f()) {
                bASE64EncoderStream.write(ASCIIUtility.getBytes(String.valueOf(str) + "\u0000" + str2 + "\u0000" + str3));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(A);
                e5.write(byteArrayOutputStream.toByteArray());
                e5.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!a4.j() || !a4.c().equals(str4)) && !a4.e()) {
                    vector.addElement(a4);
                }
                z3 = true;
            }
        }
        com.sun.mail.iap.g[] gVarArr = new com.sun.mail.iap.g[vector.size()];
        vector.copyInto(gVarArr);
        j(gVarArr);
        h(a4);
        H0(a4);
        this.f50534s = true;
    }

    public c v0(int i4, String str, int i5, int i6) throws ProtocolException {
        return P(i4, str, i5, i6, true, null);
    }

    public void w() throws ProtocolException {
        com.sun.mail.iap.g[] b4 = b("CAPABILITY", null);
        if (b4[b4.length - 1].h()) {
            this.f50535t = new HashMap(10);
            this.f50536u = new ArrayList(5);
            int length = b4.length;
            for (int i4 = 0; i4 < length; i4++) {
                if (b4[i4] instanceof i) {
                    i iVar = (i) b4[i4];
                    if (iVar.F("CAPABILITY")) {
                        s0(iVar);
                    }
                }
            }
            return;
        }
        throw new ProtocolException(b4[b4.length - 1].toString());
    }

    public c w0(int i4, String str, int i5, int i6, com.sun.mail.iap.d dVar) throws ProtocolException {
        return P(i4, str, i5, i6, true, dVar);
    }

    public void x() throws ProtocolException {
        n("CHECK", null);
    }

    public boolean x0(com.sun.mail.iap.g gVar) throws ProtocolException {
        j(new com.sun.mail.iap.g[]{gVar});
        boolean e4 = gVar.e();
        if (gVar.j() && gVar.c().equals(this.f50541z)) {
            e4 = true;
        }
        if (e4) {
            this.f50541z = null;
        }
        h(gVar);
        return !e4;
    }

    public void y() throws ProtocolException {
        n("CLOSE", null);
    }

    public void y0(String str) throws ProtocolException {
        com.sun.mail.iap.b bVar = new com.sun.mail.iap.b();
        bVar.o(str);
        n("PROXYAUTH", bVar);
    }

    public void z(int i4, int i5, String str) throws ProtocolException {
        A(String.valueOf(String.valueOf(i4)) + ":" + String.valueOf(i5), str);
    }

    public synchronized com.sun.mail.iap.g z0() {
        com.sun.mail.iap.g a4;
        if (this.f50541z == null) {
            return null;
        }
        try {
            a4 = l();
        } catch (ProtocolException e4) {
            a4 = com.sun.mail.iap.g.a(e4);
        } catch (IOException e5) {
            a4 = com.sun.mail.iap.g.a(e5);
        }
        return a4;
    }
}
