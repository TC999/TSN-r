package com.sun.mail.imap;

import com.sun.mail.iap.C12728g;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.C12757o;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.INTERNALDATE;
import com.sun.mail.imap.protocol.Item;
import com.sun.mail.imap.protocol.RFC822DATA;
import com.sun.mail.imap.protocol.RFC822SIZE;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.UIDFolder;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;

/* renamed from: com.sun.mail.imap.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPMessage extends MimeMessage {

    /* renamed from: n */
    private static String f35984n = "ENVELOPE INTERNALDATE RFC822.SIZE";

    /* renamed from: a */
    protected BODYSTRUCTURE f35985a;

    /* renamed from: b */
    protected ENVELOPE f35986b;

    /* renamed from: c */
    private Date f35987c;

    /* renamed from: d */
    private int f35988d;

    /* renamed from: e */
    private boolean f35989e;

    /* renamed from: f */
    private int f35990f;

    /* renamed from: g */
    private long f35991g;

    /* renamed from: h */
    protected String f35992h;

    /* renamed from: i */
    private String f35993i;

    /* renamed from: j */
    private String f35994j;

    /* renamed from: k */
    private String f35995k;

    /* renamed from: l */
    private boolean f35996l;

    /* renamed from: m */
    private Hashtable f35997m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IMAPMessage.java */
    /* renamed from: com.sun.mail.imap.g$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C12752a implements C12757o.InterfaceC12758a {

        /* renamed from: a */
        private boolean f35998a;

        /* renamed from: b */
        private boolean f35999b;

        /* renamed from: c */
        private boolean f36000c;

        /* renamed from: d */
        private boolean f36001d;

        /* renamed from: e */
        private boolean f36002e;

        /* renamed from: f */
        private boolean f36003f;

        /* renamed from: g */
        private String[] f36004g;

        public C12752a(FetchProfile fetchProfile) {
            this.f35998a = false;
            this.f35999b = false;
            this.f36000c = false;
            this.f36001d = false;
            this.f36002e = false;
            this.f36003f = false;
            this.f36004g = null;
            if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
                this.f35998a = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
                this.f35999b = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
                this.f36000c = true;
            }
            if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
                this.f36001d = true;
            }
            if (fetchProfile.contains(IMAPFolder.C12750t.f35971a)) {
                this.f36002e = true;
            }
            if (fetchProfile.contains(IMAPFolder.C12750t.f35972b)) {
                this.f36003f = true;
            }
            this.f36004g = fetchProfile.getHeaderNames();
        }

        @Override // com.sun.mail.imap.C12757o.InterfaceC12758a
        /* renamed from: a */
        public boolean mo16228a(IMAPMessage iMAPMessage) {
            if (this.f35998a && iMAPMessage.m16315b() == null) {
                return true;
            }
            if (this.f35999b && iMAPMessage.m16314c() == null) {
                return true;
            }
            if (this.f36000c && iMAPMessage.m16316a() == null) {
                return true;
            }
            if (this.f36001d && iMAPMessage.m16298x() == -1) {
                return true;
            }
            if (this.f36002e && !iMAPMessage.m16304m()) {
                return true;
            }
            if (this.f36003f && iMAPMessage.f35988d == -1) {
                return true;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.f36004g;
                if (i >= strArr.length) {
                    return false;
                }
                if (!iMAPMessage.m16296z(strArr[i])) {
                    return true;
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMessage(IMAPFolder iMAPFolder, int i, int i2) {
        super(iMAPFolder, i);
        this.f35988d = -1;
        this.f35991g = -1L;
        this.f35996l = false;
        this.f35990f = i2;
        this.flags = null;
    }

    /* renamed from: B */
    private synchronized void m16326B() throws MessagingException {
        if (this.f35985a != null) {
            return;
        }
        synchronized (mo16292t()) {
            try {
                IMAPProtocol mo16291v = mo16291v();
                mo16294n();
                BODYSTRUCTURE m16172R = mo16291v.m16172R(mo16290w());
                this.f35985a = m16172R;
                if (m16172R == null) {
                    m16301q();
                    throw new MessagingException("Unable to load BODYSTRUCTURE");
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                m16301q();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    /* renamed from: C */
    private synchronized void m16325C() throws MessagingException {
        if (this.f35986b != null) {
            return;
        }
        synchronized (mo16292t()) {
            try {
                IMAPProtocol mo16291v = mo16291v();
                mo16294n();
                int mo16290w = mo16290w();
                C12728g[] m16188J = mo16291v.m16188J(mo16290w, f35984n);
                for (int i = 0; i < m16188J.length; i++) {
                    if (m16188J[i] != null && (m16188J[i] instanceof FetchResponse) && ((FetchResponse) m16188J[i]).m16121E() == mo16290w) {
                        FetchResponse fetchResponse = (FetchResponse) m16188J[i];
                        int m16210L = fetchResponse.m16210L();
                        for (int i2 = 0; i2 < m16210L; i2++) {
                            Item m16213I = fetchResponse.m16213I(i2);
                            if (m16213I instanceof ENVELOPE) {
                                this.f35986b = (ENVELOPE) m16213I;
                            } else if (m16213I instanceof INTERNALDATE) {
                                this.f35987c = ((INTERNALDATE) m16213I).m16114b();
                            } else if (m16213I instanceof RFC822SIZE) {
                                this.f35988d = ((RFC822SIZE) m16213I).f36178b;
                            }
                        }
                    }
                }
                mo16291v.m16414j(m16188J);
                mo16291v.m16416h(m16188J[m16188J.length - 1]);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                m16301q();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (this.f35986b == null) {
            throw new MessagingException("Failed to load IMAP envelope");
        }
    }

    /* renamed from: D */
    private synchronized void m16324D() throws MessagingException {
        if (this.flags != null) {
            return;
        }
        synchronized (mo16292t()) {
            try {
                try {
                    IMAPProtocol mo16291v = mo16291v();
                    mo16294n();
                    this.flags = mo16291v.m16170S(mo16290w());
                } catch (ProtocolException e) {
                    m16301q();
                    throw new MessagingException(e.getMessage(), e);
                }
            } catch (ConnectionException e2) {
                throw new FolderClosedException(this.folder, e2.getMessage());
            }
        }
    }

    /* renamed from: E */
    private synchronized void m16323E() throws MessagingException {
        if (this.f35996l) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        synchronized (mo16292t()) {
            try {
                IMAPProtocol mo16291v = mo16291v();
                mo16294n();
                if (mo16291v.m16152i0()) {
                    BODY m16133u0 = mo16291v.m16133u0(mo16290w(), m16317K("HEADER"));
                    if (m16133u0 != null) {
                        byteArrayInputStream = m16133u0.m16220b();
                    }
                } else {
                    RFC822DATA m16169T = mo16291v.m16169T(mo16290w(), "HEADER");
                    if (m16169T != null) {
                        byteArrayInputStream = m16169T.m16107b();
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                m16301q();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream != null) {
            this.headers = new InternetHeaders(byteArrayInputStream);
            this.f35996l = true;
            return;
        }
        throw new MessagingException("Cannot load header");
    }

    /* renamed from: F */
    private synchronized void m16322F(String str) {
        if (this.f35997m == null) {
            this.f35997m = new Hashtable(1);
        }
        this.f35997m.put(str.toUpperCase(Locale.ENGLISH), str);
    }

    /* renamed from: G */
    private synchronized void m16321G(boolean z) {
        this.f35996l = z;
    }

    /* renamed from: K */
    private String m16317K(String str) {
        String str2 = this.f35992h;
        if (str2 == null) {
            return str;
        }
        return String.valueOf(str2) + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public BODYSTRUCTURE m16316a() {
        return this.f35985a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public ENVELOPE m16315b() {
        return this.f35986b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public Flags m16314c() {
        return this.flags;
    }

    /* renamed from: f */
    private InternetAddress[] m16311f(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public synchronized boolean m16304m() {
        return this.f35996l;
    }

    /* renamed from: o */
    private static String m16303o(IMAPProtocol iMAPProtocol, String[] strArr) {
        StringBuffer stringBuffer;
        if (iMAPProtocol.m16152i0()) {
            stringBuffer = new StringBuffer("BODY.PEEK[HEADER.FIELDS (");
        } else {
            stringBuffer = new StringBuffer("RFC822.HEADER.LINES (");
        }
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(strArr[i]);
        }
        if (iMAPProtocol.m16152i0()) {
            stringBuffer.append(")]");
        } else {
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ec A[Catch: all -> 0x0211, TryCatch #0 {, blocks: (B:55:0x00b4, B:57:0x00ba, B:59:0x00bc, B:60:0x00c1, B:67:0x00da, B:70:0x00dd, B:72:0x00e0, B:74:0x00e6, B:75:0x00ee, B:77:0x00f0, B:87:0x011a, B:80:0x00f5, B:82:0x00fb, B:83:0x0101, B:86:0x0117, B:88:0x011d, B:90:0x0125, B:94:0x0130, B:141:0x01f6, B:96:0x013d, B:98:0x0141, B:101:0x014c, B:103:0x0150, B:104:0x0159, B:106:0x015d, B:107:0x0164, B:109:0x0168, B:110:0x016d, B:112:0x0171, B:114:0x017b, B:115:0x0182, B:116:0x0193, B:118:0x019b, B:120:0x019f, B:122:0x01a3, B:124:0x01b0, B:128:0x01bf, B:129:0x01c3, B:137:0x01ec, B:139:0x01f3, B:142:0x01fe, B:132:0x01ca, B:134:0x01da, B:135:0x01e8, B:123:0x01aa, B:63:0x00cd, B:64:0x00d6, B:144:0x0207, B:145:0x0210), top: B:151:0x00b4, inners: #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f1  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m16302p(com.sun.mail.imap.IMAPFolder r17, javax.mail.Message[] r18, javax.mail.FetchProfile r19) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.m16302p(com.sun.mail.imap.e, javax.mail.Message[], javax.mail.FetchProfile):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public synchronized boolean m16296z(String str) {
        if (this.f35996l) {
            return true;
        }
        Hashtable hashtable = this.f35997m;
        return hashtable != null ? hashtable.containsKey(str.toUpperCase(Locale.ENGLISH)) : false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A */
    public boolean mo16295A() throws FolderClosedException {
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).f35916j;
        if (iMAPProtocol != null) {
            return iMAPProtocol.m16152i0();
        }
        throw new FolderClosedException(this.folder);
    }

    /* renamed from: H */
    public synchronized void m16320H(boolean z) {
        this.f35989e = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I */
    public void m16319I(int i) {
        this.f35990f = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J */
    public void m16318J(long j) {
        this.f35991g = j;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addFrom(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Session m16313d() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m16312e(Flags flags) {
        this.flags = flags;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        mo16294n();
        m16323E();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        mo16294n();
        m16323E();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        mo16294n();
        m16326B();
        return this.f35985a.f36091h;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        mo16294n();
        m16326B();
        String[] strArr = this.f35985a.f36097n;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        mo16294n();
        m16326B();
        return this.f35985a.f36093j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        ByteArrayInputStream m16107b;
        BODY m16182M;
        boolean m16299u = m16299u();
        synchronized (mo16292t()) {
            try {
                IMAPProtocol mo16291v = mo16291v();
                mo16294n();
                if (mo16291v.m16152i0()) {
                    if (mo16293r() != -1) {
                        String m16317K = m16317K("TEXT");
                        BODYSTRUCTURE bodystructure = this.f35985a;
                        return new IMAPInputStream(this, m16317K, bodystructure != null ? bodystructure.f36089f : -1, m16299u);
                    }
                }
                if (mo16291v.m16152i0()) {
                    if (m16299u) {
                        m16182M = mo16291v.m16133u0(mo16290w(), m16317K("TEXT"));
                    } else {
                        m16182M = mo16291v.m16182M(mo16290w(), m16317K("TEXT"));
                    }
                    if (m16182M != null) {
                        m16107b = m16182M.m16220b();
                    }
                    m16107b = null;
                } else {
                    RFC822DATA m16169T = mo16291v.m16169T(mo16290w(), "TEXT");
                    if (m16169T != null) {
                        m16107b = m16169T.m16107b();
                    }
                    m16107b = null;
                }
                if (m16107b != null) {
                    return m16107b;
                }
                throw new MessagingException("No content");
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                m16301q();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getContentType() throws MessagingException {
        mo16294n();
        if (this.f35993i == null) {
            m16326B();
            BODYSTRUCTURE bodystructure = this.f35985a;
            this.f35993i = new ContentType(bodystructure.f36085b, bodystructure.f36086c, bodystructure.f36095l).toString();
        }
        return this.f35993i;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        String str;
        String str2;
        mo16294n();
        if (this.f40793dh == null) {
            m16326B();
            if (this.f35993i == null) {
                BODYSTRUCTURE bodystructure = this.f35985a;
                this.f35993i = new ContentType(bodystructure.f36085b, bodystructure.f36086c, bodystructure.f36095l).toString();
            }
            if (this.f35985a.m16219a()) {
                this.f40793dh = new DataHandler(new IMAPMultipartDataSource(this, this.f35985a.f36098o, this.f35992h, this));
            } else if (this.f35985a.m16218b() && mo16295A()) {
                BODYSTRUCTURE bodystructure2 = this.f35985a;
                BODYSTRUCTURE bodystructure3 = bodystructure2.f36098o[0];
                ENVELOPE envelope = bodystructure2.f36099p;
                if (this.f35992h == null) {
                    str2 = "1";
                } else {
                    str2 = String.valueOf(str) + ".1";
                }
                this.f40793dh = new DataHandler(new IMAPNestedMessage(this, bodystructure3, envelope, str2), this.f35993i);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDescription() throws MessagingException {
        mo16294n();
        String str = this.f35995k;
        if (str != null) {
            return str;
        }
        m16326B();
        String str2 = this.f35985a.f36092i;
        if (str2 == null) {
            return null;
        }
        try {
            this.f35995k = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f35995k = this.f35985a.f36092i;
        }
        return this.f35995k;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDisposition() throws MessagingException {
        mo16294n();
        m16326B();
        return this.f35985a.f36090g;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        mo16294n();
        m16326B();
        return this.f35985a.f36087d;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getFileName() throws MessagingException {
        ParameterList parameterList;
        mo16294n();
        m16326B();
        ParameterList parameterList2 = this.f35985a.f36096m;
        String str = parameterList2 != null ? parameterList2.get("filename") : null;
        return (str != null || (parameterList = this.f35985a.f36095l) == null) ? str : parameterList.get("name");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized Flags getFlags() throws MessagingException {
        mo16294n();
        m16324D();
        return super.getFlags();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getFrom() throws MessagingException {
        mo16294n();
        m16325C();
        return m16311f(this.f35986b.f36106d);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream m16107b;
        mo16294n();
        if (m16296z(str)) {
            return this.headers.getHeader(str);
        }
        synchronized (mo16292t()) {
            try {
                IMAPProtocol mo16291v = mo16291v();
                mo16294n();
                if (mo16291v.m16152i0()) {
                    BODY m16133u0 = mo16291v.m16133u0(mo16290w(), m16317K("HEADER.FIELDS (" + str + ")"));
                    if (m16133u0 != null) {
                        m16107b = m16133u0.m16220b();
                    }
                    m16107b = null;
                } else {
                    RFC822DATA m16169T = mo16291v.m16169T(mo16290w(), "HEADER.LINES (" + str + ")");
                    if (m16169T != null) {
                        m16107b = m16169T.m16107b();
                    }
                    m16107b = null;
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                m16301q();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (m16107b == null) {
            return null;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        this.headers.load(m16107b);
        m16322F(str);
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getLineCount() throws MessagingException {
        mo16294n();
        m16326B();
        return this.f35985a.f36088e;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        mo16294n();
        m16323E();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        mo16294n();
        m16323E();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage
    public String getMessageID() throws MessagingException {
        mo16294n();
        m16325C();
        return this.f35986b.f36113k;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        mo16294n();
        m16323E();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        mo16294n();
        m16323E();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getReceivedDate() throws MessagingException {
        mo16294n();
        m16325C();
        if (this.f35987c == null) {
            return null;
        }
        return new Date(this.f35987c.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        mo16294n();
        m16325C();
        if (recipientType == Message.RecipientType.f40788TO) {
            return m16311f(this.f35986b.f36109g);
        }
        if (recipientType == Message.RecipientType.f40787CC) {
            return m16311f(this.f35986b.f36110h);
        }
        if (recipientType == Message.RecipientType.BCC) {
            return m16311f(this.f35986b.f36111i);
        }
        return super.getRecipients(recipientType);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getReplyTo() throws MessagingException {
        mo16294n();
        m16325C();
        return m16311f(this.f35986b.f36108f);
    }

    @Override // javax.mail.internet.MimeMessage
    public Address getSender() throws MessagingException {
        mo16294n();
        m16325C();
        InternetAddress[] internetAddressArr = this.f35986b.f36107e;
        if (internetAddressArr != null) {
            return internetAddressArr[0];
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getSentDate() throws MessagingException {
        mo16294n();
        m16325C();
        if (this.f35986b.f36104b == null) {
            return null;
        }
        return new Date(this.f35986b.f36104b.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        mo16294n();
        if (this.f35988d == -1) {
            m16325C();
        }
        return this.f35988d;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public String getSubject() throws MessagingException {
        mo16294n();
        String str = this.f35994j;
        if (str != null) {
            return str;
        }
        m16325C();
        String str2 = this.f35986b.f36105c;
        if (str2 == null) {
            return null;
        }
        try {
            this.f35994j = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f35994j = this.f35986b.f36105c;
        }
        return this.f35994j;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        mo16294n();
        m16324D();
        return super.isSet(flag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public void mo16294n() throws MessageRemovedException {
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    /* renamed from: q */
    protected void m16301q() throws MessageRemovedException, FolderClosedException {
        synchronized (mo16292t()) {
            try {
                mo16291v().m16139r0();
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException unused) {
            }
        }
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public int mo16293r() {
        return ((IMAPStore) this.folder.getStore()).m16281h();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* renamed from: s */
    public String m16300s() throws MessagingException {
        mo16294n();
        m16325C();
        return this.f35986b.f36112j;
    }

    @Override // javax.mail.internet.MimeMessage
    public void setContentID(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Message
    public void setExpunged(boolean z) {
        super.setExpunged(z);
        this.f35990f = -1;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z) throws MessagingException {
        synchronized (mo16292t()) {
            try {
                IMAPProtocol mo16291v = mo16291v();
                mo16294n();
                mo16291v.m16181M0(mo16290w(), flags, z);
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFrom(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Message
    public void setMessageNumber(int i) {
        super.setMessageNumber(i);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSender(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setSentDate(Date date) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSubject(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public Object mo16292t() {
        return ((IMAPFolder) this.folder).f35918l;
    }

    /* renamed from: u */
    public synchronized boolean m16299u() {
        return this.f35989e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public IMAPProtocol mo16291v() throws ProtocolException, FolderClosedException {
        ((IMAPFolder) this.folder).m16356S();
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).f35916j;
        if (iMAPProtocol != null) {
            return iMAPProtocol;
        }
        throw new FolderClosedException(this.folder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public int mo16290w() {
        return this.f35990f;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        BODY m16182M;
        boolean m16299u = m16299u();
        synchronized (mo16292t()) {
            try {
                IMAPProtocol mo16291v = mo16291v();
                mo16294n();
                byteArrayInputStream = null;
                if (mo16291v.m16152i0()) {
                    if (m16299u) {
                        m16182M = mo16291v.m16133u0(mo16290w(), this.f35992h);
                    } else {
                        m16182M = mo16291v.m16182M(mo16290w(), this.f35992h);
                    }
                    if (m16182M != null) {
                        byteArrayInputStream = m16182M.m16220b();
                    }
                } else {
                    RFC822DATA m16169T = mo16291v.m16169T(mo16290w(), null);
                    if (m16169T != null) {
                        byteArrayInputStream = m16169T.m16107b();
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.folder, e.getMessage());
            } catch (ProtocolException e2) {
                m16301q();
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        if (byteArrayInputStream == null) {
            throw new MessagingException("No content");
        }
        byte[] bArr = new byte[1024];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read == -1) {
                return;
            }
            outputStream.write(bArr, 0, read);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public long m16298x() {
        return this.f35991g;
    }

    /* renamed from: y */
    public synchronized void m16297y() {
        this.f35996l = false;
        this.f35997m = null;
        this.f35986b = null;
        this.f35985a = null;
        this.f35987c = null;
        this.f35988d = -1;
        this.f35993i = null;
        this.f35994j = null;
        this.f35995k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMessage(Session session) {
        super(session);
        this.f35988d = -1;
        this.f35991g = -1L;
        this.f35996l = false;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        mo16294n();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }
}
