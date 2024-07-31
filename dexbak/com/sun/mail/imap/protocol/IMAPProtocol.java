package com.sun.mail.imap.protocol;

import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.C12725b;
import com.sun.mail.iap.C12727f;
import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.Literal;
import com.sun.mail.iap.LiteralException;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.ACL;
import com.sun.mail.imap.AppendUID;
import com.sun.mail.imap.Rights;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import io.netty.handler.codec.http.HttpConstants;
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

/* renamed from: com.sun.mail.imap.protocol.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPProtocol extends C12727f {

    /* renamed from: A */
    private static final byte[] f36120A = {13, 10};

    /* renamed from: B */
    private static final byte[] f36121B = {68, 79, 78, 69, 13, 10};

    /* renamed from: q */
    private boolean f36122q;

    /* renamed from: r */
    private boolean f36123r;

    /* renamed from: s */
    private boolean f36124s;

    /* renamed from: t */
    private Map f36125t;

    /* renamed from: u */
    private List f36126u;

    /* renamed from: v */
    private String[] f36127v;

    /* renamed from: w */
    private String f36128w;

    /* renamed from: x */
    private SaslAuthenticator f36129x;

    /* renamed from: y */
    private ByteArray f36130y;

    /* renamed from: z */
    private String f36131z;

    public IMAPProtocol(String str, String str2, int i, boolean z, PrintStream printStream, Properties properties, boolean z2) throws IOException, ProtocolException {
        super(str2, i, z, printStream, properties, "mail." + str, z2);
        this.f36122q = false;
        this.f36123r = false;
        this.f36125t = null;
        this.f36126u = null;
        try {
            this.f36128w = str;
            m16130w();
            if (m16157e0("IMAP4rev1")) {
                this.f36123r = true;
            }
            this.f36127v = r0;
            String[] strArr = {"UTF-8", MimeUtility.mimeCharset(MimeUtility.getDefaultJavaCharset())};
            this.f36122q = true;
        } catch (Throwable th) {
            if (!this.f36122q) {
                mo16160c();
            }
            throw th;
        }
    }

    /* renamed from: A */
    private void m16206A(String str, String str2) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str2);
        C12725b c12725b = new C12725b();
        c12725b.m16436i(str);
        c12725b.m16430o(m16225a);
        m16412n("COPY", c12725b);
    }

    /* renamed from: C0 */
    private int[] m16201C0(String str, SearchTerm searchTerm) throws ProtocolException, SearchException {
        if (SearchSequence.m16098h(searchTerm)) {
            try {
                return m16151j0(str, searchTerm, null);
            } catch (IOException unused) {
            }
        }
        int i = 0;
        while (true) {
            String[] strArr = this.f36127v;
            if (i < strArr.length) {
                if (strArr[i] != null) {
                    try {
                        return m16151j0(str, searchTerm, strArr[i]);
                    } catch (CommandFailedException unused2) {
                        this.f36127v[i] = null;
                    } catch (ProtocolException e) {
                        throw e;
                    } catch (IOException unused3) {
                    } catch (SearchException e2) {
                        throw e2;
                    }
                }
                i++;
            } else {
                throw new SearchException("Search failed");
            }
        }
    }

    /* renamed from: D */
    private String m16200D(Flags flags) {
        Flags.Flag[] systemFlags;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        boolean z = true;
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
            if (z) {
                z = false;
            } else {
                stringBuffer.append(HttpConstants.SP_CHAR);
            }
            stringBuffer.append(str);
        }
        String[] userFlags = flags.getUserFlags();
        for (String str2 : userFlags) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(HttpConstants.SP_CHAR);
            }
            stringBuffer.append(str2);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    /* renamed from: F */
    private ListInfo[] m16196F(String str, String str2, String str3) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str2);
        String m16225a2 = BASE64MailboxEncoder.m16225a(str3);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        c12725b.m16430o(m16225a2);
        C12728g[] m16420b = m16420b(str, c12725b);
        C12728g c12728g = m16420b[m16420b.length - 1];
        ListInfo[] listInfoArr = null;
        if (c12728g.m16399h()) {
            Vector vector = new Vector(1);
            int length = m16420b.length;
            for (int i = 0; i < length; i++) {
                if (m16420b[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                    if (iMAPResponse.m16120F(str)) {
                        vector.addElement(new ListInfo(iMAPResponse));
                        m16420b[i] = null;
                    }
                }
            }
            if (vector.size() > 0) {
                listInfoArr = new ListInfo[vector.size()];
                vector.copyInto(listInfoArr);
            }
        }
        m16414j(m16420b);
        m16416h(c12728g);
        return listInfoArr;
    }

    /* renamed from: K */
    private C12728g[] m16186K(String str, String str2, boolean z) throws ProtocolException {
        if (z) {
            return m16420b("UID FETCH " + str + " (" + str2 + ")", null);
        }
        return m16420b("FETCH " + str + " (" + str2 + ")", null);
    }

    /* renamed from: N0 */
    private void m16179N0(String str, Flags flags, boolean z) throws ProtocolException {
        C12728g[] m16420b;
        if (z) {
            m16420b = m16420b("STORE " + str + " +FLAGS " + m16200D(flags), null);
        } else {
            m16420b = m16420b("STORE " + str + " -FLAGS " + m16200D(flags), null);
        }
        m16414j(m16420b);
        m16416h(m16420b[m16420b.length - 1]);
    }

    /* renamed from: Z */
    private AppendUID m16163Z(C12728g c12728g) {
        byte m16389r;
        if (c12728g.m16399h()) {
            do {
                m16389r = c12728g.m16389r();
                if (m16389r <= 0) {
                    break;
                }
            } while (m16389r != 91);
            if (m16389r != 0 && c12728g.m16392o().equalsIgnoreCase("APPENDUID")) {
                return new AppendUID(c12728g.m16386u(), c12728g.m16386u());
            }
            return null;
        }
        return null;
    }

    /* renamed from: j0 */
    private int[] m16151j0(String str, SearchTerm searchTerm, String str2) throws ProtocolException, SearchException, IOException {
        int[] iArr = null;
        C12725b m16101e = SearchSequence.m16101e(searchTerm, str2 == null ? null : MimeUtility.javaCharset(str2));
        m16101e.m16436i(str);
        C12728g[] m16420b = str2 == null ? m16420b("SEARCH", m16101e) : m16420b("SEARCH CHARSET " + str2, m16101e);
        C12728g c12728g = m16420b[m16420b.length - 1];
        if (c12728g.m16399h()) {
            Vector vector = new Vector();
            int length = m16420b.length;
            for (int i = 0; i < length; i++) {
                if (m16420b[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                    if (iMAPResponse.m16120F("SEARCH")) {
                        while (true) {
                            int m16385v = iMAPResponse.m16385v();
                            if (m16385v == -1) {
                                break;
                            }
                            vector.addElement(new Integer(m16385v));
                        }
                        m16420b[i] = null;
                    }
                }
            }
            int size = vector.size();
            int[] iArr2 = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr2[i2] = ((Integer) vector.elementAt(i2)).intValue();
            }
            iArr = iArr2;
        }
        m16414j(m16420b);
        m16416h(c12728g);
        return iArr;
    }

    /* renamed from: t0 */
    private Quota m16135t0(C12728g c12728g) throws ParsingException {
        Quota quota = new Quota(c12728g.m16390q());
        c12728g.m16408B();
        if (c12728g.m16389r() == 40) {
            Vector vector = new Vector();
            while (c12728g.m16393n() != 41) {
                String m16392o = c12728g.m16392o();
                if (m16392o != null) {
                    vector.addElement(new Quota.Resource(m16392o, c12728g.m16386u(), c12728g.m16386u()));
                }
            }
            c12728g.m16389r();
            Quota.Resource[] resourceArr = new Quota.Resource[vector.size()];
            quota.resources = resourceArr;
            vector.copyInto(resourceArr);
            return quota;
        }
        throw new ParsingException("parse error in QUOTA");
    }

    /* renamed from: A0 */
    public void m16205A0(String str, String str2) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str);
        String m16225a2 = BASE64MailboxEncoder.m16225a(str2);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        c12725b.m16430o(m16225a2);
        m16412n("RENAME", c12725b);
    }

    /* renamed from: B */
    public void m16204B(MessageSet[] messageSetArr, String str) throws ProtocolException {
        m16206A(MessageSet.m16110d(messageSetArr), str);
    }

    /* renamed from: B0 */
    public void m16203B0(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        List list;
        if (this.f36129x == null) {
            try {
                Constructor constructor = IMAPSaslAuthenticator.class.getConstructor(IMAPProtocol.class, String.class, Properties.class, Boolean.TYPE, PrintStream.class, String.class);
                Object[] objArr = new Object[6];
                objArr[0] = this;
                objArr[1] = this.f36128w;
                objArr[2] = this.f35855f;
                objArr[3] = this.f35852c ? Boolean.TRUE : Boolean.FALSE;
                objArr[4] = this.f35854e;
                objArr[5] = this.f35850a;
                this.f36129x = (SaslAuthenticator) constructor.newInstance(objArr);
            } catch (Exception e) {
                if (this.f35852c) {
                    PrintStream printStream = this.f35854e;
                    printStream.println("IMAP DEBUG: Can't load SASL authenticator: " + e);
                    return;
                }
                return;
            }
        }
        if (strArr != null && strArr.length > 0) {
            list = new ArrayList(strArr.length);
            for (int i = 0; i < strArr.length; i++) {
                if (this.f36126u.contains(strArr[i])) {
                    list.add(strArr[i]);
                }
            }
        } else {
            list = this.f36126u;
        }
        if (this.f36129x.mo16106a((String[]) list.toArray(new String[list.size()]), str, str2, str3, str4)) {
            this.f36124s = true;
        }
    }

    /* renamed from: C */
    public void m16202C(String str) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        m16412n("CREATE", c12725b);
    }

    /* renamed from: D0 */
    public int[] m16199D0(SearchTerm searchTerm) throws ProtocolException, SearchException {
        return m16201C0("ALL", searchTerm);
    }

    /* renamed from: E */
    public void m16198E(String str, String str2) throws ProtocolException {
        if (m16157e0("ACL")) {
            String m16225a = BASE64MailboxEncoder.m16225a(str);
            C12725b c12725b = new C12725b();
            c12725b.m16430o(m16225a);
            c12725b.m16430o(str2);
            C12728g[] m16420b = m16420b("DELETEACL", c12725b);
            C12728g c12728g = m16420b[m16420b.length - 1];
            m16414j(m16420b);
            m16416h(c12728g);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    /* renamed from: E0 */
    public int[] m16197E0(MessageSet[] messageSetArr, SearchTerm searchTerm) throws ProtocolException, SearchException {
        return m16201C0(MessageSet.m16110d(messageSetArr), searchTerm);
    }

    /* renamed from: F0 */
    public MailboxInfo m16195F0(String str) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        C12728g[] m16420b = m16420b("SELECT", c12725b);
        MailboxInfo mailboxInfo = new MailboxInfo(m16420b);
        m16414j(m16420b);
        C12728g c12728g = m16420b[m16420b.length - 1];
        if (c12728g.m16399h()) {
            if (c12728g.toString().indexOf("READ-ONLY") != -1) {
                mailboxInfo.f36165h = 1;
            } else {
                mailboxInfo.f36165h = 2;
            }
        }
        m16416h(c12728g);
        return mailboxInfo;
    }

    /* renamed from: G */
    public MailboxInfo m16194G(String str) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        C12728g[] m16420b = m16420b("EXAMINE", c12725b);
        MailboxInfo mailboxInfo = new MailboxInfo(m16420b);
        mailboxInfo.f36165h = 1;
        m16414j(m16420b);
        m16416h(m16420b[m16420b.length - 1]);
        return mailboxInfo;
    }

    /* renamed from: G0 */
    public void m16193G0(String str, char c, ACL acl) throws ProtocolException {
        if (m16157e0("ACL")) {
            String m16225a = BASE64MailboxEncoder.m16225a(str);
            C12725b c12725b = new C12725b();
            c12725b.m16430o(m16225a);
            c12725b.m16430o(acl.m16378a());
            String rights = acl.m16377b().toString();
            if (c == '+' || c == '-') {
                rights = String.valueOf(c) + rights;
            }
            c12725b.m16430o(rights);
            C12728g[] m16420b = m16420b("SETACL", c12725b);
            C12728g c12728g = m16420b[m16420b.length - 1];
            m16414j(m16420b);
            m16416h(c12728g);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    /* renamed from: H */
    public void m16192H() throws ProtocolException {
        m16412n("EXPUNGE", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H0 */
    public void m16191H0(C12728g c12728g) {
        byte m16389r;
        do {
            m16389r = c12728g.m16389r();
            if (m16389r <= 0) {
                break;
            }
        } while (m16389r != 91);
        if (m16389r != 0 && c12728g.m16392o().equalsIgnoreCase("CAPABILITY")) {
            this.f36125t = new HashMap(10);
            this.f36126u = new ArrayList(5);
            m16137s0(c12728g);
        }
    }

    /* renamed from: I */
    public C12728g[] m16190I(int i, int i2, String str) throws ProtocolException {
        return m16186K(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), str, false);
    }

    /* renamed from: I0 */
    public void m16189I0(Quota quota) throws ProtocolException {
        if (m16157e0("QUOTA")) {
            C12725b c12725b = new C12725b();
            c12725b.m16430o(quota.quotaRoot);
            C12725b c12725b2 = new C12725b();
            if (quota.resources != null) {
                int i = 0;
                while (true) {
                    Quota.Resource[] resourceArr = quota.resources;
                    if (i >= resourceArr.length) {
                        break;
                    }
                    c12725b2.m16436i(resourceArr[i].name);
                    c12725b2.m16431n(quota.resources[i].limit);
                    i++;
                }
            }
            c12725b.m16437h(c12725b2);
            C12728g[] m16420b = m16420b("SETQUOTA", c12725b);
            C12728g c12728g = m16420b[m16420b.length - 1];
            m16414j(m16420b);
            m16416h(c12728g);
            return;
        }
        throw new BadCommandException("QUOTA not supported");
    }

    /* renamed from: J */
    public C12728g[] m16188J(int i, String str) throws ProtocolException {
        return m16186K(String.valueOf(i), str, false);
    }

    /* renamed from: J0 */
    public void m16187J0() throws ProtocolException {
        try {
            super.m16411o("STARTTLS");
        } catch (ProtocolException e) {
            throw e;
        } catch (Exception e2) {
            m16414j(new C12728g[]{C12728g.m16406a(e2)});
            mo16160c();
        }
    }

    /* renamed from: K0 */
    public Status m16185K0(String str, String[] strArr) throws ProtocolException {
        if (!m16152i0() && !m16157e0("IMAP4SUNVERSION")) {
            throw new BadCommandException("STATUS not supported");
        }
        String m16225a = BASE64MailboxEncoder.m16225a(str);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        C12725b c12725b2 = new C12725b();
        if (strArr == null) {
            strArr = Status.f36181g;
        }
        for (String str2 : strArr) {
            c12725b2.m16436i(str2);
        }
        c12725b.m16437h(c12725b2);
        C12728g[] m16420b = m16420b("STATUS", c12725b);
        C12728g c12728g = m16420b[m16420b.length - 1];
        Status status = null;
        if (c12728g.m16399h()) {
            int length = m16420b.length;
            Status status2 = null;
            for (int i = 0; i < length; i++) {
                if (m16420b[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                    if (iMAPResponse.m16120F("STATUS")) {
                        if (status2 == null) {
                            status2 = new Status(iMAPResponse);
                        } else {
                            Status.m16088a(status2, new Status(iMAPResponse));
                        }
                        m16420b[i] = null;
                    }
                }
            }
            status = status2;
        }
        m16414j(m16420b);
        m16416h(c12728g);
        return status;
    }

    /* renamed from: L */
    public C12728g[] m16184L(MessageSet[] messageSetArr, String str) throws ProtocolException {
        return m16186K(MessageSet.m16110d(messageSetArr), str, false);
    }

    /* renamed from: L0 */
    public void m16183L0(int i, int i2, Flags flags, boolean z) throws ProtocolException {
        m16179N0(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), flags, z);
    }

    /* renamed from: M */
    public BODY m16182M(int i, String str) throws ProtocolException {
        return m16174Q(i, str, false);
    }

    /* renamed from: M0 */
    public void m16181M0(int i, Flags flags, boolean z) throws ProtocolException {
        m16179N0(String.valueOf(i), flags, z);
    }

    /* renamed from: N */
    public BODY m16180N(int i, String str, int i2, int i3) throws ProtocolException {
        return m16176P(i, str, i2, i3, false, null);
    }

    /* renamed from: O */
    public BODY m16178O(int i, String str, int i2, int i3, ByteArray byteArray) throws ProtocolException {
        return m16176P(i, str, i2, i3, false, byteArray);
    }

    /* renamed from: O0 */
    public void m16177O0(MessageSet[] messageSetArr, Flags flags, boolean z) throws ProtocolException {
        m16179N0(MessageSet.m16110d(messageSetArr), flags, z);
    }

    /* renamed from: P */
    protected BODY m16176P(int i, String str, int i2, int i3, boolean z, ByteArray byteArray) throws ProtocolException {
        this.f36130y = byteArray;
        StringBuilder sb = new StringBuilder(z ? "BODY.PEEK[" : "BODY[");
        String str2 = "]<";
        if (str != null) {
            str2 = str + "]<";
        }
        sb.append(str2);
        sb.append(String.valueOf(i2));
        sb.append(".");
        sb.append(String.valueOf(i3));
        sb.append(">");
        C12728g[] m16188J = m16188J(i, sb.toString());
        m16414j(m16188J);
        C12728g c12728g = m16188J[m16188J.length - 1];
        if (c12728g.m16399h()) {
            return (BODY) FetchResponse.m16211K(m16188J, i, BODY.class);
        }
        if (c12728g.m16400g()) {
            return null;
        }
        m16416h(c12728g);
        return null;
    }

    /* renamed from: P0 */
    public void m16175P0(String str) throws ProtocolException {
        C12725b c12725b = new C12725b();
        c12725b.m16430o(BASE64MailboxEncoder.m16225a(str));
        m16412n("SUBSCRIBE", c12725b);
    }

    /* renamed from: Q */
    protected BODY m16174Q(int i, String str, boolean z) throws ProtocolException {
        C12728g[] m16188J;
        String str2 = "]";
        if (z) {
            StringBuilder sb = new StringBuilder("BODY.PEEK[");
            if (str != null) {
                str2 = str + "]";
            }
            sb.append(str2);
            m16188J = m16188J(i, sb.toString());
        } else {
            StringBuilder sb2 = new StringBuilder("BODY[");
            if (str != null) {
                str2 = str + "]";
            }
            sb2.append(str2);
            m16188J = m16188J(i, sb2.toString());
        }
        m16414j(m16188J);
        C12728g c12728g = m16188J[m16188J.length - 1];
        if (c12728g.m16399h()) {
            return (BODY) FetchResponse.m16211K(m16188J, i, BODY.class);
        }
        if (c12728g.m16400g()) {
            return null;
        }
        m16416h(c12728g);
        return null;
    }

    /* renamed from: Q0 */
    public void m16173Q0(UIDSet[] uIDSetArr) throws ProtocolException {
        if (m16157e0("UIDPLUS")) {
            m16412n("UID EXPUNGE " + UIDSet.m16084d(uIDSetArr), null);
            return;
        }
        throw new BadCommandException("UID EXPUNGE not supported");
    }

    /* renamed from: R */
    public BODYSTRUCTURE m16172R(int i) throws ProtocolException {
        C12728g[] m16188J = m16188J(i, "BODYSTRUCTURE");
        m16414j(m16188J);
        C12728g c12728g = m16188J[m16188J.length - 1];
        if (c12728g.m16399h()) {
            return (BODYSTRUCTURE) FetchResponse.m16211K(m16188J, i, BODYSTRUCTURE.class);
        }
        if (c12728g.m16400g()) {
            return null;
        }
        m16416h(c12728g);
        return null;
    }

    /* renamed from: R0 */
    public void m16171R0(String str) throws ProtocolException {
        C12725b c12725b = new C12725b();
        c12725b.m16430o(BASE64MailboxEncoder.m16225a(str));
        m16412n("UNSUBSCRIBE", c12725b);
    }

    /* renamed from: S */
    public Flags m16170S(int i) throws ProtocolException {
        C12728g[] m16188J = m16188J(i, "FLAGS");
        int length = m16188J.length;
        int i2 = 0;
        Flags flags = null;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (m16188J[i2] != null && (m16188J[i2] instanceof FetchResponse) && ((FetchResponse) m16188J[i2]).m16121E() == i && (flags = (Flags) ((FetchResponse) m16188J[i2]).m16212J(Flags.class)) != null) {
                m16188J[i2] = null;
                break;
            } else {
                i2++;
            }
        }
        m16414j(m16188J);
        m16416h(m16188J[m16188J.length - 1]);
        return flags;
    }

    /* renamed from: T */
    public RFC822DATA m16169T(int i, String str) throws ProtocolException {
        String str2;
        if (str == null) {
            str2 = "RFC822";
        } else {
            str2 = "RFC822." + str;
        }
        C12728g[] m16188J = m16188J(i, str2);
        m16414j(m16188J);
        C12728g c12728g = m16188J[m16188J.length - 1];
        if (c12728g.m16399h()) {
            return (RFC822DATA) FetchResponse.m16211K(m16188J, i, RFC822DATA.class);
        }
        if (c12728g.m16400g()) {
            return null;
        }
        m16416h(c12728g);
        return null;
    }

    /* renamed from: U */
    public UID m16168U(long j) throws ProtocolException {
        C12728g[] m16186K = m16186K(String.valueOf(j), "UID", true);
        int length = m16186K.length;
        UID uid = null;
        for (int i = 0; i < length; i++) {
            if (m16186K[i] != null && (m16186K[i] instanceof FetchResponse) && (uid = (UID) ((FetchResponse) m16186K[i]).m16212J(UID.class)) != null) {
                if (uid.f36190b == j) {
                    break;
                }
                uid = null;
            }
        }
        m16414j(m16186K);
        m16416h(m16186K[m16186K.length - 1]);
        return uid;
    }

    /* renamed from: V */
    public UID[] m16167V(long j, long j2) throws ProtocolException {
        UID uid;
        StringBuilder sb = new StringBuilder(String.valueOf(String.valueOf(j)));
        sb.append(":");
        sb.append(j2 == -1 ? "*" : String.valueOf(j2));
        C12728g[] m16186K = m16186K(sb.toString(), "UID", true);
        Vector vector = new Vector();
        int length = m16186K.length;
        for (int i = 0; i < length; i++) {
            if (m16186K[i] != null && (m16186K[i] instanceof FetchResponse) && (uid = (UID) ((FetchResponse) m16186K[i]).m16212J(UID.class)) != null) {
                vector.addElement(uid);
            }
        }
        m16414j(m16186K);
        m16416h(m16186K[m16186K.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }

    /* renamed from: W */
    public UID[] m16166W(long[] jArr) throws ProtocolException {
        UID uid;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < jArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf(jArr[i]));
        }
        C12728g[] m16186K = m16186K(stringBuffer.toString(), "UID", true);
        Vector vector = new Vector();
        int length = m16186K.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m16186K[i2] != null && (m16186K[i2] instanceof FetchResponse) && (uid = (UID) ((FetchResponse) m16186K[i2]).m16212J(UID.class)) != null) {
                vector.addElement(uid);
            }
        }
        m16414j(m16186K);
        m16416h(m16186K[m16186K.length - 1]);
        UID[] uidArr = new UID[vector.size()];
        vector.copyInto(uidArr);
        return uidArr;
    }

    /* renamed from: X */
    public UID m16165X(int i) throws ProtocolException {
        C12728g[] m16188J = m16188J(i, "UID");
        m16414j(m16188J);
        C12728g c12728g = m16188J[m16188J.length - 1];
        if (c12728g.m16399h()) {
            return (UID) FetchResponse.m16211K(m16188J, i, UID.class);
        }
        if (c12728g.m16400g()) {
            return null;
        }
        m16416h(c12728g);
        return null;
    }

    /* renamed from: Y */
    public ACL[] m16164Y(String str) throws ProtocolException {
        String m16390q;
        if (m16157e0("ACL")) {
            String m16225a = BASE64MailboxEncoder.m16225a(str);
            C12725b c12725b = new C12725b();
            c12725b.m16430o(m16225a);
            C12728g[] m16420b = m16420b("GETACL", c12725b);
            C12728g c12728g = m16420b[m16420b.length - 1];
            Vector vector = new Vector();
            if (c12728g.m16399h()) {
                int length = m16420b.length;
                for (int i = 0; i < length; i++) {
                    if (m16420b[i] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                        if (iMAPResponse.m16120F("ACL")) {
                            iMAPResponse.m16390q();
                            while (true) {
                                String m16390q2 = iMAPResponse.m16390q();
                                if (m16390q2 != null && (m16390q = iMAPResponse.m16390q()) != null) {
                                    vector.addElement(new ACL(m16390q2, new Rights(m16390q)));
                                }
                            }
                            m16420b[i] = null;
                        }
                    }
                }
            }
            m16414j(m16420b);
            m16416h(c12728g);
            ACL[] aclArr = new ACL[vector.size()];
            vector.copyInto(aclArr);
            return aclArr;
        }
        throw new BadCommandException("ACL not supported");
    }

    /* renamed from: a0 */
    public Map m16162a0() {
        return this.f36125t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b0 */
    public OutputStream m16161b0() {
        return m16418e();
    }

    @Override // com.sun.mail.iap.C12727f
    /* renamed from: c */
    public void mo16160c() {
        super.mo16160c();
        this.f36124s = false;
    }

    /* renamed from: c0 */
    public Quota[] m16159c0(String str) throws ProtocolException {
        if (m16157e0("QUOTA")) {
            C12725b c12725b = new C12725b();
            c12725b.m16430o(str);
            C12728g[] m16420b = m16420b("GETQUOTA", c12725b);
            Vector vector = new Vector();
            C12728g c12728g = m16420b[m16420b.length - 1];
            if (c12728g.m16399h()) {
                int length = m16420b.length;
                for (int i = 0; i < length; i++) {
                    if (m16420b[i] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                        if (iMAPResponse.m16120F("QUOTA")) {
                            vector.addElement(m16135t0(iMAPResponse));
                            m16420b[i] = null;
                        }
                    }
                }
            }
            m16414j(m16420b);
            m16416h(c12728g);
            Quota[] quotaArr = new Quota[vector.size()];
            vector.copyInto(quotaArr);
            return quotaArr;
        }
        throw new BadCommandException("QUOTA not supported");
    }

    /* renamed from: d0 */
    public Quota[] m16158d0(String str) throws ProtocolException {
        if (m16157e0("QUOTA")) {
            String m16225a = BASE64MailboxEncoder.m16225a(str);
            C12725b c12725b = new C12725b();
            c12725b.m16430o(m16225a);
            C12728g[] m16420b = m16420b("GETQUOTAROOT", c12725b);
            C12728g c12728g = m16420b[m16420b.length - 1];
            Hashtable hashtable = new Hashtable();
            int i = 0;
            if (c12728g.m16399h()) {
                int length = m16420b.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (m16420b[i2] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i2];
                        if (iMAPResponse.m16120F("QUOTAROOT")) {
                            iMAPResponse.m16390q();
                            while (true) {
                                String m16390q = iMAPResponse.m16390q();
                                if (m16390q == null) {
                                    break;
                                }
                                hashtable.put(m16390q, new Quota(m16390q));
                            }
                            m16420b[i2] = null;
                        } else if (iMAPResponse.m16120F("QUOTA")) {
                            Quota m16135t0 = m16135t0(iMAPResponse);
                            Quota quota = (Quota) hashtable.get(m16135t0.quotaRoot);
                            hashtable.put(m16135t0.quotaRoot, m16135t0);
                            m16420b[i2] = null;
                        }
                    }
                }
            }
            m16414j(m16420b);
            m16416h(c12728g);
            Quota[] quotaArr = new Quota[hashtable.size()];
            Enumeration elements = hashtable.elements();
            while (elements.hasMoreElements()) {
                quotaArr[i] = (Quota) elements.nextElement();
                i++;
            }
            return quotaArr;
        }
        throw new BadCommandException("GETQUOTAROOT not supported");
    }

    public void delete(String str) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        m16412n("DELETE", c12725b);
    }

    /* renamed from: e0 */
    public boolean m16157e0(String str) {
        return this.f36125t.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.C12727f
    /* renamed from: f */
    public ByteArray mo16156f() {
        ByteArray byteArray = this.f36130y;
        this.f36130y = null;
        return byteArray;
    }

    /* renamed from: f0 */
    public void m16155f0() throws ProtocolException {
        OutputStream m16418e = m16418e();
        try {
            m16418e.write(f36121B);
            m16418e.flush();
        } catch (IOException unused) {
        }
    }

    /* renamed from: g0 */
    public synchronized void m16154g0() throws ProtocolException {
        C12728g m16406a;
        if (m16157e0("IDLE")) {
            try {
                this.f36131z = m16410q("IDLE", null);
                m16406a = mo16148l();
            } catch (LiteralException e) {
                m16406a = e.getResponse();
            } catch (Exception e2) {
                m16406a = C12728g.m16406a(e2);
            }
            if (!m16406a.m16401f()) {
                m16416h(m16406a);
            }
        } else {
            throw new BadCommandException("IDLE not supported");
        }
    }

    /* renamed from: h0 */
    public boolean m16153h0() {
        return this.f36124s;
    }

    /* renamed from: i0 */
    public boolean m16152i0() {
        return this.f36123r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.C12727f
    /* renamed from: k */
    public void mo16150k(C12728g c12728g) throws ProtocolException {
        super.mo16150k(c12728g);
        if (c12728g.m16399h()) {
            m16191H0(c12728g);
        } else if (((IMAPResponse) c12728g).m16120F("PREAUTH")) {
            this.f36124s = true;
            m16191H0(c12728g);
        } else {
            throw new ConnectionException(this, c12728g);
        }
    }

    /* renamed from: k0 */
    public ListInfo[] m16149k0(String str, String str2) throws ProtocolException {
        return m16196F("LIST", str, str2);
    }

    @Override // com.sun.mail.iap.C12727f
    /* renamed from: l */
    public C12728g mo16148l() throws IOException, ProtocolException {
        return IMAPResponse.m16119G(this);
    }

    /* renamed from: l0 */
    public Rights[] m16147l0(String str, String str2) throws ProtocolException {
        if (m16157e0("ACL")) {
            String m16225a = BASE64MailboxEncoder.m16225a(str);
            C12725b c12725b = new C12725b();
            c12725b.m16430o(m16225a);
            c12725b.m16430o(str2);
            C12728g[] m16420b = m16420b("LISTRIGHTS", c12725b);
            C12728g c12728g = m16420b[m16420b.length - 1];
            Vector vector = new Vector();
            if (c12728g.m16399h()) {
                int length = m16420b.length;
                for (int i = 0; i < length; i++) {
                    if (m16420b[i] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                        if (iMAPResponse.m16120F("LISTRIGHTS")) {
                            iMAPResponse.m16390q();
                            iMAPResponse.m16390q();
                            while (true) {
                                String m16390q = iMAPResponse.m16390q();
                                if (m16390q == null) {
                                    break;
                                }
                                vector.addElement(new Rights(m16390q));
                            }
                            m16420b[i] = null;
                        }
                    }
                }
            }
            m16414j(m16420b);
            m16416h(c12728g);
            Rights[] rightsArr = new Rights[vector.size()];
            vector.copyInto(rightsArr);
            return rightsArr;
        }
        throw new BadCommandException("ACL not supported");
    }

    /* renamed from: m0 */
    public void m16146m0(String str, String str2) throws ProtocolException {
        C12725b c12725b = new C12725b();
        c12725b.m16430o(str);
        c12725b.m16430o(str2);
        C12728g[] m16420b = m16420b("LOGIN", c12725b);
        m16414j(m16420b);
        m16416h(m16420b[m16420b.length - 1]);
        m16191H0(m16420b[m16420b.length - 1]);
        this.f36124s = true;
    }

    /* renamed from: n0 */
    public void m16145n0() throws ProtocolException {
        C12728g[] m16420b = m16420b("LOGOUT", null);
        this.f36124s = false;
        m16414j(m16420b);
        mo16160c();
    }

    /* renamed from: o0 */
    public ListInfo[] m16144o0(String str, String str2) throws ProtocolException {
        return m16196F("LSUB", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.C12727f
    /* renamed from: p */
    public boolean mo16143p() {
        return m16157e0("LITERAL+");
    }

    /* renamed from: p0 */
    public Rights m16142p0(String str) throws ProtocolException {
        if (m16157e0("ACL")) {
            String m16225a = BASE64MailboxEncoder.m16225a(str);
            C12725b c12725b = new C12725b();
            c12725b.m16430o(m16225a);
            C12728g[] m16420b = m16420b("MYRIGHTS", c12725b);
            C12728g c12728g = m16420b[m16420b.length - 1];
            Rights rights = null;
            if (c12728g.m16399h()) {
                int length = m16420b.length;
                Rights rights2 = null;
                for (int i = 0; i < length; i++) {
                    if (m16420b[i] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                        if (iMAPResponse.m16120F("MYRIGHTS")) {
                            iMAPResponse.m16390q();
                            String m16390q = iMAPResponse.m16390q();
                            if (rights2 == null) {
                                rights2 = new Rights(m16390q);
                            }
                            m16420b[i] = null;
                        }
                    }
                }
                rights = rights2;
            }
            m16414j(m16420b);
            m16416h(c12728g);
            return rights;
        }
        throw new BadCommandException("ACL not supported");
    }

    /* renamed from: q0 */
    public Namespaces m16141q0() throws ProtocolException {
        if (m16157e0("NAMESPACE")) {
            Namespaces namespaces = null;
            C12728g[] m16420b = m16420b("NAMESPACE", null);
            C12728g c12728g = m16420b[m16420b.length - 1];
            if (c12728g.m16399h()) {
                int length = m16420b.length;
                Namespaces namespaces2 = null;
                for (int i = 0; i < length; i++) {
                    if (m16420b[i] instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                        if (iMAPResponse.m16120F("NAMESPACE")) {
                            if (namespaces2 == null) {
                                namespaces2 = new Namespaces(iMAPResponse);
                            }
                            m16420b[i] = null;
                        }
                    }
                }
                namespaces = namespaces2;
            }
            m16414j(m16420b);
            m16416h(c12728g);
            return namespaces;
        }
        throw new BadCommandException("NAMESPACE not supported");
    }

    /* renamed from: r */
    public void m16140r(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        m16136t(str, flags, date, literal, false);
    }

    /* renamed from: r0 */
    public void m16139r0() throws ProtocolException {
        if (this.f35852c) {
            this.f35854e.println("IMAP DEBUG: IMAPProtocol noop");
        }
        m16412n("NOOP", null);
    }

    /* renamed from: s */
    public AppendUID m16138s(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        return m16136t(str, flags, date, literal, true);
    }

    /* renamed from: s0 */
    protected void m16137s0(C12728g c12728g) {
        while (true) {
            String m16391p = c12728g.m16391p(']');
            if (m16391p == null) {
                return;
            }
            if (m16391p.length() == 0) {
                if (c12728g.m16393n() == 93) {
                    return;
                }
                c12728g.m16407C();
            } else {
                this.f36125t.put(m16391p.toUpperCase(Locale.ENGLISH), m16391p);
                if (m16391p.regionMatches(true, 0, "AUTH=", 0, 5)) {
                    this.f36126u.add(m16391p.substring(5));
                    if (this.f35852c) {
                        PrintStream printStream = this.f35854e;
                        printStream.println("IMAP DEBUG: AUTH: " + m16391p.substring(5));
                    }
                }
            }
        }
    }

    /* renamed from: t */
    public AppendUID m16136t(String str, Flags flags, Date date, Literal literal, boolean z) throws ProtocolException {
        String m16225a = BASE64MailboxEncoder.m16225a(str);
        C12725b c12725b = new C12725b();
        c12725b.m16430o(m16225a);
        if (flags != null) {
            Flags.Flag flag = Flags.Flag.RECENT;
            if (flags.contains(flag)) {
                Flags flags2 = new Flags(flags);
                flags2.remove(flag);
                flags = flags2;
            }
            c12725b.m16436i(m16200D(flags));
        }
        if (date != null) {
            c12725b.m16430o(INTERNALDATE.m16115a(date));
        }
        c12725b.m16435j(literal);
        C12728g[] m16420b = m16420b("APPEND", c12725b);
        m16414j(m16420b);
        m16416h(m16420b[m16420b.length - 1]);
        if (z) {
            return m16163Z(m16420b[m16420b.length - 1]);
        }
        return null;
    }

    /* renamed from: u */
    public synchronized void m16134u(String str, String str2) throws ProtocolException {
        C12728g m16406a;
        boolean z;
        String str3;
        Vector vector = new Vector();
        String str4 = null;
        try {
            z = false;
            m16406a = null;
            str4 = m16410q("AUTHENTICATE LOGIN", null);
        } catch (Exception e) {
            m16406a = C12728g.m16406a(e);
            z = true;
        }
        OutputStream m16418e = m16418e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        boolean z2 = true;
        while (!z) {
            try {
                m16406a = mo16148l();
            } catch (Exception e2) {
                m16406a = C12728g.m16406a(e2);
            }
            if (m16406a.m16401f()) {
                if (z2) {
                    str3 = str;
                    z2 = false;
                } else {
                    str3 = str2;
                }
                bASE64EncoderStream.write(ASCIIUtility.getBytes(str3));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(f36120A);
                m16418e.write(byteArrayOutputStream.toByteArray());
                m16418e.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!m16406a.m16397j() || !m16406a.m16404c().equals(str4)) && !m16406a.m16402e()) {
                    vector.addElement(m16406a);
                }
                z = true;
            }
        }
        C12728g[] c12728gArr = new C12728g[vector.size()];
        vector.copyInto(c12728gArr);
        m16414j(c12728gArr);
        m16416h(m16406a);
        m16191H0(m16406a);
        this.f36124s = true;
    }

    /* renamed from: u0 */
    public BODY m16133u0(int i, String str) throws ProtocolException {
        return m16174Q(i, str, true);
    }

    /* renamed from: v */
    public synchronized void m16132v(String str, String str2, String str3) throws ProtocolException {
        C12728g m16406a;
        Vector vector = new Vector();
        boolean z = false;
        String str4 = null;
        try {
            m16406a = null;
            str4 = m16410q("AUTHENTICATE PLAIN", null);
        } catch (Exception e) {
            m16406a = C12728g.m16406a(e);
            z = true;
        }
        OutputStream m16418e = m16418e();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        while (!z) {
            try {
                m16406a = mo16148l();
            } catch (Exception e2) {
                m16406a = C12728g.m16406a(e2);
            }
            if (m16406a.m16401f()) {
                bASE64EncoderStream.write(ASCIIUtility.getBytes(String.valueOf(str) + "\u0000" + str2 + "\u0000" + str3));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(f36120A);
                m16418e.write(byteArrayOutputStream.toByteArray());
                m16418e.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!m16406a.m16397j() || !m16406a.m16404c().equals(str4)) && !m16406a.m16402e()) {
                    vector.addElement(m16406a);
                }
                z = true;
            }
        }
        C12728g[] c12728gArr = new C12728g[vector.size()];
        vector.copyInto(c12728gArr);
        m16414j(c12728gArr);
        m16416h(m16406a);
        m16191H0(m16406a);
        this.f36124s = true;
    }

    /* renamed from: v0 */
    public BODY m16131v0(int i, String str, int i2, int i3) throws ProtocolException {
        return m16176P(i, str, i2, i3, true, null);
    }

    /* renamed from: w */
    public void m16130w() throws ProtocolException {
        C12728g[] m16420b = m16420b("CAPABILITY", null);
        if (m16420b[m16420b.length - 1].m16399h()) {
            this.f36125t = new HashMap(10);
            this.f36126u = new ArrayList(5);
            int length = m16420b.length;
            for (int i = 0; i < length; i++) {
                if (m16420b[i] instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) m16420b[i];
                    if (iMAPResponse.m16120F("CAPABILITY")) {
                        m16137s0(iMAPResponse);
                    }
                }
            }
            return;
        }
        throw new ProtocolException(m16420b[m16420b.length - 1].toString());
    }

    /* renamed from: w0 */
    public BODY m16129w0(int i, String str, int i2, int i3, ByteArray byteArray) throws ProtocolException {
        return m16176P(i, str, i2, i3, true, byteArray);
    }

    /* renamed from: x */
    public void m16128x() throws ProtocolException {
        m16412n("CHECK", null);
    }

    /* renamed from: x0 */
    public boolean m16127x0(C12728g c12728g) throws ProtocolException {
        m16414j(new C12728g[]{c12728g});
        boolean m16402e = c12728g.m16402e();
        if (c12728g.m16397j() && c12728g.m16404c().equals(this.f36131z)) {
            m16402e = true;
        }
        if (m16402e) {
            this.f36131z = null;
        }
        m16416h(c12728g);
        return !m16402e;
    }

    /* renamed from: y */
    public void m16126y() throws ProtocolException {
        m16412n("CLOSE", null);
    }

    /* renamed from: y0 */
    public void m16125y0(String str) throws ProtocolException {
        C12725b c12725b = new C12725b();
        c12725b.m16430o(str);
        m16412n("PROXYAUTH", c12725b);
    }

    /* renamed from: z */
    public void m16124z(int i, int i2, String str) throws ProtocolException {
        m16206A(String.valueOf(String.valueOf(i)) + ":" + String.valueOf(i2), str);
    }

    /* renamed from: z0 */
    public synchronized C12728g m16123z0() {
        C12728g m16406a;
        if (this.f36131z == null) {
            return null;
        }
        try {
            m16406a = mo16148l();
        } catch (ProtocolException e) {
            m16406a = C12728g.m16406a(e);
        } catch (IOException e2) {
            m16406a = C12728g.m16406a(e2);
        }
        return m16406a;
    }
}
