package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.e;
import com.sun.mail.imap.o;
import com.sun.mail.imap.protocol.q;
import com.sun.mail.imap.protocol.r;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPMessage.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class g extends MimeMessage {

    /* renamed from: n  reason: collision with root package name */
    private static String f50398n = "ENVELOPE INTERNALDATE RFC822.SIZE";

    /* renamed from: a  reason: collision with root package name */
    protected com.sun.mail.imap.protocol.d f50399a;

    /* renamed from: b  reason: collision with root package name */
    protected com.sun.mail.imap.protocol.e f50400b;

    /* renamed from: c  reason: collision with root package name */
    private Date f50401c;

    /* renamed from: d  reason: collision with root package name */
    private int f50402d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f50403e;

    /* renamed from: f  reason: collision with root package name */
    private int f50404f;

    /* renamed from: g  reason: collision with root package name */
    private long f50405g;

    /* renamed from: h  reason: collision with root package name */
    protected String f50406h;

    /* renamed from: i  reason: collision with root package name */
    private String f50407i;

    /* renamed from: j  reason: collision with root package name */
    private String f50408j;

    /* renamed from: k  reason: collision with root package name */
    private String f50409k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f50410l;

    /* renamed from: m  reason: collision with root package name */
    private Hashtable f50411m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IMAPMessage.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a implements o.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f50412a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f50413b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f50414c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f50415d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f50416e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f50417f;

        /* renamed from: g  reason: collision with root package name */
        private String[] f50418g;

        public a(FetchProfile fetchProfile) {
            this.f50412a = false;
            this.f50413b = false;
            this.f50414c = false;
            this.f50415d = false;
            this.f50416e = false;
            this.f50417f = false;
            this.f50418g = null;
            if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
                this.f50412a = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
                this.f50413b = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
                this.f50414c = true;
            }
            if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
                this.f50415d = true;
            }
            if (fetchProfile.contains(e.t.f50385a)) {
                this.f50416e = true;
            }
            if (fetchProfile.contains(e.t.f50386b)) {
                this.f50417f = true;
            }
            this.f50418g = fetchProfile.getHeaderNames();
        }

        @Override // com.sun.mail.imap.o.a
        public boolean a(g gVar) {
            if (this.f50412a && gVar.b() == null) {
                return true;
            }
            if (this.f50413b && gVar.c() == null) {
                return true;
            }
            if (this.f50414c && gVar.a() == null) {
                return true;
            }
            if (this.f50415d && gVar.x() == -1) {
                return true;
            }
            if (this.f50416e && !gVar.m()) {
                return true;
            }
            if (this.f50417f && gVar.f50402d == -1) {
                return true;
            }
            int i4 = 0;
            while (true) {
                String[] strArr = this.f50418g;
                if (i4 >= strArr.length) {
                    return false;
                }
                if (!gVar.z(strArr[i4])) {
                    return true;
                }
                i4++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(e eVar, int i4, int i5) {
        super(eVar, i4);
        this.f50402d = -1;
        this.f50405g = -1L;
        this.f50410l = false;
        this.f50404f = i5;
        this.flags = null;
    }

    private synchronized void B() throws MessagingException {
        if (this.f50399a != null) {
            return;
        }
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = v();
                n();
                com.sun.mail.imap.protocol.d R = v3.R(w());
                this.f50399a = R;
                if (R == null) {
                    q();
                    throw new MessagingException("Unable to load BODYSTRUCTURE");
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                q();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    private synchronized void C() throws MessagingException {
        if (this.f50400b != null) {
            return;
        }
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = v();
                n();
                int w3 = w();
                com.sun.mail.iap.g[] J = v3.J(w3, f50398n);
                for (int i4 = 0; i4 < J.length; i4++) {
                    if (J[i4] != null && (J[i4] instanceof com.sun.mail.imap.protocol.f) && ((com.sun.mail.imap.protocol.f) J[i4]).E() == w3) {
                        com.sun.mail.imap.protocol.f fVar = (com.sun.mail.imap.protocol.f) J[i4];
                        int L2 = fVar.L();
                        for (int i5 = 0; i5 < L2; i5++) {
                            com.sun.mail.imap.protocol.l I = fVar.I(i5);
                            if (I instanceof com.sun.mail.imap.protocol.e) {
                                this.f50400b = (com.sun.mail.imap.protocol.e) I;
                            } else if (I instanceof com.sun.mail.imap.protocol.k) {
                                this.f50401c = ((com.sun.mail.imap.protocol.k) I).b();
                            } else if (I instanceof r) {
                                this.f50402d = ((r) I).f50588b;
                            }
                        }
                    }
                }
                v3.j(J);
                v3.h(J[J.length - 1]);
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                q();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        if (this.f50400b == null) {
            throw new MessagingException("Failed to load IMAP envelope");
        }
    }

    private synchronized void D() throws MessagingException {
        if (this.flags != null) {
            return;
        }
        synchronized (t()) {
            try {
                try {
                    com.sun.mail.imap.protocol.h v3 = v();
                    n();
                    this.flags = v3.S(w());
                } catch (ProtocolException e4) {
                    q();
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new FolderClosedException(this.folder, e5.getMessage());
            }
        }
    }

    private synchronized void E() throws MessagingException {
        if (this.f50410l) {
            return;
        }
        ByteArrayInputStream byteArrayInputStream = null;
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = v();
                n();
                if (v3.i0()) {
                    com.sun.mail.imap.protocol.c u02 = v3.u0(w(), K("HEADER"));
                    if (u02 != null) {
                        byteArrayInputStream = u02.b();
                    }
                } else {
                    q T = v3.T(w(), "HEADER");
                    if (T != null) {
                        byteArrayInputStream = T.b();
                    }
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                q();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        if (byteArrayInputStream != null) {
            this.headers = new InternetHeaders(byteArrayInputStream);
            this.f50410l = true;
            return;
        }
        throw new MessagingException("Cannot load header");
    }

    private synchronized void F(String str) {
        if (this.f50411m == null) {
            this.f50411m = new Hashtable(1);
        }
        this.f50411m.put(str.toUpperCase(Locale.ENGLISH), str);
    }

    private synchronized void G(boolean z3) {
        this.f50410l = z3;
    }

    private String K(String str) {
        String str2 = this.f50406h;
        if (str2 == null) {
            return str;
        }
        return String.valueOf(str2) + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.imap.protocol.d a() {
        return this.f50399a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.imap.protocol.e b() {
        return this.f50400b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flags c() {
        return this.flags;
    }

    private InternetAddress[] f(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean m() {
        return this.f50410l;
    }

    private static String o(com.sun.mail.imap.protocol.h hVar, String[] strArr) {
        StringBuffer stringBuffer;
        if (hVar.i0()) {
            stringBuffer = new StringBuffer("BODY.PEEK[HEADER.FIELDS (");
        } else {
            stringBuffer = new StringBuffer("RFC822.HEADER.LINES (");
        }
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (i4 > 0) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(strArr[i4]);
        }
        if (hVar.i0()) {
            stringBuffer.append(")]");
        } else {
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ec A[Catch: all -> 0x0211, TryCatch #0 {, blocks: (B:55:0x00b4, B:57:0x00ba, B:59:0x00bc, B:60:0x00c1, B:67:0x00da, B:70:0x00dd, B:72:0x00e0, B:74:0x00e6, B:75:0x00ee, B:77:0x00f0, B:87:0x011a, B:80:0x00f5, B:82:0x00fb, B:83:0x0101, B:86:0x0117, B:88:0x011d, B:90:0x0125, B:94:0x0130, B:141:0x01f6, B:96:0x013d, B:98:0x0141, B:101:0x014c, B:103:0x0150, B:104:0x0159, B:106:0x015d, B:107:0x0164, B:109:0x0168, B:110:0x016d, B:112:0x0171, B:114:0x017b, B:115:0x0182, B:116:0x0193, B:118:0x019b, B:120:0x019f, B:122:0x01a3, B:124:0x01b0, B:128:0x01bf, B:129:0x01c3, B:137:0x01ec, B:139:0x01f3, B:142:0x01fe, B:132:0x01ca, B:134:0x01da, B:135:0x01e8, B:123:0x01aa, B:63:0x00cd, B:64:0x00d6, B:144:0x0207, B:145:0x0210), top: B:151:0x00b4, inners: #1, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void p(com.sun.mail.imap.e r17, javax.mail.Message[] r18, javax.mail.FetchProfile r19) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.g.p(com.sun.mail.imap.e, javax.mail.Message[], javax.mail.FetchProfile):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean z(String str) {
        if (this.f50410l) {
            return true;
        }
        Hashtable hashtable = this.f50411m;
        return hashtable != null ? hashtable.containsKey(str.toUpperCase(Locale.ENGLISH)) : false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean A() throws FolderClosedException {
        com.sun.mail.imap.protocol.h hVar = ((e) this.folder).f50330j;
        if (hVar != null) {
            return hVar.i0();
        }
        throw new FolderClosedException(this.folder);
    }

    public synchronized void H(boolean z3) {
        this.f50403e = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(int i4) {
        this.f50404f = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(long j4) {
        this.f50405g = j4;
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
    public Session d() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Flags flags) {
        this.flags = flags;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        n();
        E();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        n();
        E();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        n();
        B();
        return this.f50399a.f50503h;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        n();
        B();
        String[] strArr = this.f50399a.f50509n;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        n();
        B();
        return this.f50399a.f50505j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        ByteArrayInputStream b4;
        com.sun.mail.imap.protocol.c M;
        boolean u3 = u();
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = v();
                n();
                if (v3.i0()) {
                    if (r() != -1) {
                        String K = K("TEXT");
                        com.sun.mail.imap.protocol.d dVar = this.f50399a;
                        return new f(this, K, dVar != null ? dVar.f50501f : -1, u3);
                    }
                }
                if (v3.i0()) {
                    if (u3) {
                        M = v3.u0(w(), K("TEXT"));
                    } else {
                        M = v3.M(w(), K("TEXT"));
                    }
                    if (M != null) {
                        b4 = M.b();
                    }
                    b4 = null;
                } else {
                    q T = v3.T(w(), "TEXT");
                    if (T != null) {
                        b4 = T.b();
                    }
                    b4 = null;
                }
                if (b4 != null) {
                    return b4;
                }
                throw new MessagingException("No content");
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                q();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getContentType() throws MessagingException {
        n();
        if (this.f50407i == null) {
            B();
            com.sun.mail.imap.protocol.d dVar = this.f50399a;
            this.f50407i = new ContentType(dVar.f50497b, dVar.f50498c, dVar.f50507l).toString();
        }
        return this.f50407i;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        String str;
        String str2;
        n();
        if (this.dh == null) {
            B();
            if (this.f50407i == null) {
                com.sun.mail.imap.protocol.d dVar = this.f50399a;
                this.f50407i = new ContentType(dVar.f50497b, dVar.f50498c, dVar.f50507l).toString();
            }
            if (this.f50399a.a()) {
                this.dh = new DataHandler(new h(this, this.f50399a.f50510o, this.f50406h, this));
            } else if (this.f50399a.b() && A()) {
                com.sun.mail.imap.protocol.d dVar2 = this.f50399a;
                com.sun.mail.imap.protocol.d dVar3 = dVar2.f50510o[0];
                com.sun.mail.imap.protocol.e eVar = dVar2.f50511p;
                if (this.f50406h == null) {
                    str2 = "1";
                } else {
                    str2 = String.valueOf(str) + ".1";
                }
                this.dh = new DataHandler(new i(this, dVar3, eVar, str2), this.f50407i);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDescription() throws MessagingException {
        n();
        String str = this.f50409k;
        if (str != null) {
            return str;
        }
        B();
        String str2 = this.f50399a.f50504i;
        if (str2 == null) {
            return null;
        }
        try {
            this.f50409k = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f50409k = this.f50399a.f50504i;
        }
        return this.f50409k;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDisposition() throws MessagingException {
        n();
        B();
        return this.f50399a.f50502g;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        n();
        B();
        return this.f50399a.f50499d;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getFileName() throws MessagingException {
        ParameterList parameterList;
        n();
        B();
        ParameterList parameterList2 = this.f50399a.f50508m;
        String str = parameterList2 != null ? parameterList2.get("filename") : null;
        return (str != null || (parameterList = this.f50399a.f50507l) == null) ? str : parameterList.get("name");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized Flags getFlags() throws MessagingException {
        n();
        D();
        return super.getFlags();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getFrom() throws MessagingException {
        n();
        C();
        return f(this.f50400b.f50518d);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream b4;
        n();
        if (z(str)) {
            return this.headers.getHeader(str);
        }
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = v();
                n();
                if (v3.i0()) {
                    com.sun.mail.imap.protocol.c u02 = v3.u0(w(), K("HEADER.FIELDS (" + str + ")"));
                    if (u02 != null) {
                        b4 = u02.b();
                    }
                    b4 = null;
                } else {
                    q T = v3.T(w(), "HEADER.LINES (" + str + ")");
                    if (T != null) {
                        b4 = T.b();
                    }
                    b4 = null;
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                q();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        if (b4 == null) {
            return null;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        this.headers.load(b4);
        F(str);
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getLineCount() throws MessagingException {
        n();
        B();
        return this.f50399a.f50500e;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage
    public String getMessageID() throws MessagingException {
        n();
        C();
        return this.f50400b.f50525k;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        n();
        E();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getReceivedDate() throws MessagingException {
        n();
        C();
        if (this.f50401c == null) {
            return null;
        }
        return new Date(this.f50401c.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        n();
        C();
        if (recipientType == Message.RecipientType.TO) {
            return f(this.f50400b.f50521g);
        }
        if (recipientType == Message.RecipientType.CC) {
            return f(this.f50400b.f50522h);
        }
        if (recipientType == Message.RecipientType.BCC) {
            return f(this.f50400b.f50523i);
        }
        return super.getRecipients(recipientType);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getReplyTo() throws MessagingException {
        n();
        C();
        return f(this.f50400b.f50520f);
    }

    @Override // javax.mail.internet.MimeMessage
    public Address getSender() throws MessagingException {
        n();
        C();
        InternetAddress[] internetAddressArr = this.f50400b.f50519e;
        if (internetAddressArr != null) {
            return internetAddressArr[0];
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getSentDate() throws MessagingException {
        n();
        C();
        if (this.f50400b.f50516b == null) {
            return null;
        }
        return new Date(this.f50400b.f50516b.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        n();
        if (this.f50402d == -1) {
            C();
        }
        return this.f50402d;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public String getSubject() throws MessagingException {
        n();
        String str = this.f50408j;
        if (str != null) {
            return str;
        }
        C();
        String str2 = this.f50400b.f50517c;
        if (str2 == null) {
            return null;
        }
        try {
            this.f50408j = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f50408j = this.f50400b.f50517c;
        }
        return this.f50408j;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        n();
        D();
        return super.isSet(flag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() throws MessageRemovedException {
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    protected void q() throws MessageRemovedException, FolderClosedException {
        synchronized (t()) {
            try {
                v().r0();
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException unused) {
            }
        }
        if (this.expunged) {
            throw new MessageRemovedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int r() {
        return ((k) this.folder.getStore()).h();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    public String s() throws MessagingException {
        n();
        C();
        return this.f50400b.f50524j;
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
    public void setExpunged(boolean z3) {
        super.setExpunged(z3);
        this.f50404f = -1;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z3) throws MessagingException {
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = v();
                n();
                v3.M0(w(), flags, z3);
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
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
    public void setMessageNumber(int i4) {
        super.setMessageNumber(i4);
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
    public Object t() {
        return ((e) this.folder).f50332l;
    }

    public synchronized boolean u() {
        return this.f50403e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.sun.mail.imap.protocol.h v() throws ProtocolException, FolderClosedException {
        ((e) this.folder).S();
        com.sun.mail.imap.protocol.h hVar = ((e) this.folder).f50330j;
        if (hVar != null) {
            return hVar;
        }
        throw new FolderClosedException(this.folder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w() {
        return this.f50404f;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        com.sun.mail.imap.protocol.c M;
        boolean u3 = u();
        synchronized (t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = v();
                n();
                byteArrayInputStream = null;
                if (v3.i0()) {
                    if (u3) {
                        M = v3.u0(w(), this.f50406h);
                    } else {
                        M = v3.M(w(), this.f50406h);
                    }
                    if (M != null) {
                        byteArrayInputStream = M.b();
                    }
                } else {
                    q T = v3.T(w(), null);
                    if (T != null) {
                        byteArrayInputStream = T.b();
                    }
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                q();
                throw new MessagingException(e5.getMessage(), e5);
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
    public long x() {
        return this.f50405g;
    }

    public synchronized void y() {
        this.f50410l = false;
        this.f50411m = null;
        this.f50400b = null;
        this.f50399a = null;
        this.f50401c = null;
        this.f50402d = -1;
        this.f50407i = null;
        this.f50408j = null;
        this.f50409k = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Session session) {
        super(session);
        this.f50402d = -1;
        this.f50405g = -1L;
        this.f50410l = false;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        n();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }
}
