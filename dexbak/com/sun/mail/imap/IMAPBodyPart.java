package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import javax.activation.DataHandler;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;

/* renamed from: com.sun.mail.imap.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPBodyPart extends MimeBodyPart {

    /* renamed from: a */
    private IMAPMessage f35894a;

    /* renamed from: b */
    private BODYSTRUCTURE f35895b;

    /* renamed from: c */
    private String f35896c;

    /* renamed from: d */
    private String f35897d;

    /* renamed from: e */
    private String f35898e;

    /* renamed from: f */
    private boolean f35899f = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPBodyPart(BODYSTRUCTURE bodystructure, String str, IMAPMessage iMAPMessage) {
        this.f35895b = bodystructure;
        this.f35896c = str;
        this.f35894a = iMAPMessage;
        this.f35897d = new ContentType(bodystructure.f36085b, bodystructure.f36086c, bodystructure.f36095l).toString();
    }

    /* renamed from: a */
    private synchronized void m16375a() throws MessagingException {
        if (this.f35899f) {
            return;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        synchronized (this.f35894a.mo16292t()) {
            try {
                IMAPProtocol mo16291v = this.f35894a.mo16291v();
                this.f35894a.mo16294n();
                if (mo16291v.m16152i0()) {
                    int mo16290w = this.f35894a.mo16290w();
                    BODY m16133u0 = mo16291v.m16133u0(mo16290w, String.valueOf(this.f35896c) + ".MIME");
                    if (m16133u0 != null) {
                        ByteArrayInputStream m16220b = m16133u0.m16220b();
                        if (m16220b != null) {
                            this.headers.load(m16220b);
                        } else {
                            throw new MessagingException("Failed to fetch headers");
                        }
                    } else {
                        throw new MessagingException("Failed to fetch headers");
                    }
                } else {
                    this.headers.addHeader("Content-Type", this.f35897d);
                    this.headers.addHeader(HttpHeaders.Names.CONTENT_TRANSFER_ENCODING, this.f35895b.f36087d);
                    String str = this.f35895b.f36092i;
                    if (str != null) {
                        this.headers.addHeader("Content-Description", str);
                    }
                    String str2 = this.f35895b.f36091h;
                    if (str2 != null) {
                        this.headers.addHeader("Content-ID", str2);
                    }
                    String str3 = this.f35895b.f36093j;
                    if (str3 != null) {
                        this.headers.addHeader(HttpHeaders.Names.CONTENT_MD5, str3);
                    }
                }
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.f35894a.getFolder(), e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
        this.f35899f = true;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        m16375a();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        m16375a();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        return this.f35895b.f36091h;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        return this.f35895b.f36093j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeBodyPart
    public InputStream getContentStream() throws MessagingException {
        BODY m16182M;
        boolean m16299u = this.f35894a.m16299u();
        synchronized (this.f35894a.mo16292t()) {
            try {
                IMAPProtocol mo16291v = this.f35894a.mo16291v();
                this.f35894a.mo16294n();
                if (mo16291v.m16152i0() && this.f35894a.mo16293r() != -1) {
                    return new IMAPInputStream(this.f35894a, this.f35896c, this.f35895b.f36089f, m16299u);
                }
                int mo16290w = this.f35894a.mo16290w();
                if (m16299u) {
                    m16182M = mo16291v.m16133u0(mo16290w, this.f35896c);
                } else {
                    m16182M = mo16291v.m16182M(mo16290w, this.f35896c);
                }
                ByteArrayInputStream m16220b = m16182M != null ? m16182M.m16220b() : null;
                if (m16220b != null) {
                    return m16220b;
                }
                throw new MessagingException("No content");
            } catch (ConnectionException e) {
                throw new FolderClosedException(this.f35894a.getFolder(), e.getMessage());
            } catch (ProtocolException e2) {
                throw new MessagingException(e2.getMessage(), e2);
            }
        }
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getContentType() throws MessagingException {
        return this.f35897d;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        if (this.f40792dh == null) {
            if (this.f35895b.m16219a()) {
                this.f40792dh = new DataHandler(new IMAPMultipartDataSource(this, this.f35895b.f36098o, this.f35896c, this.f35894a));
            } else if (this.f35895b.m16218b() && this.f35894a.mo16295A()) {
                IMAPMessage iMAPMessage = this.f35894a;
                BODYSTRUCTURE bodystructure = this.f35895b;
                this.f40792dh = new DataHandler(new IMAPNestedMessage(iMAPMessage, bodystructure.f36098o[0], bodystructure.f36099p, this.f35896c), this.f35897d);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDescription() throws MessagingException {
        String str = this.f35898e;
        if (str != null) {
            return str;
        }
        String str2 = this.f35895b.f36092i;
        if (str2 == null) {
            return null;
        }
        try {
            this.f35898e = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f35898e = this.f35895b.f36092i;
        }
        return this.f35898e;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDisposition() throws MessagingException {
        return this.f35895b.f36090g;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        return this.f35895b.f36087d;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getFileName() throws MessagingException {
        ParameterList parameterList;
        ParameterList parameterList2 = this.f35895b.f36096m;
        String str = parameterList2 != null ? parameterList2.get("filename") : null;
        return (str != null || (parameterList = this.f35895b.f36095l) == null) ? str : parameterList.get("name");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        m16375a();
        return super.getHeader(str);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getLineCount() throws MessagingException {
        return this.f35895b.f36088e;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        m16375a();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        m16375a();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        m16375a();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        m16375a();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f35895b.f36089f;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Object obj, String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeBodyPart
    public void updateHeaders() {
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Multipart multipart) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }
}
