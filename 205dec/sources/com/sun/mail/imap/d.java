package com.sun.mail.imap;

import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPBodyPart.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends MimeBodyPart {

    /* renamed from: a  reason: collision with root package name */
    private g f50315a;

    /* renamed from: b  reason: collision with root package name */
    private com.sun.mail.imap.protocol.d f50316b;

    /* renamed from: c  reason: collision with root package name */
    private String f50317c;

    /* renamed from: d  reason: collision with root package name */
    private String f50318d;

    /* renamed from: e  reason: collision with root package name */
    private String f50319e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f50320f = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(com.sun.mail.imap.protocol.d dVar, String str, g gVar) {
        this.f50316b = dVar;
        this.f50317c = str;
        this.f50315a = gVar;
        this.f50318d = new ContentType(dVar.f50497b, dVar.f50498c, dVar.f50507l).toString();
    }

    private synchronized void a() throws MessagingException {
        if (this.f50320f) {
            return;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        synchronized (this.f50315a.t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = this.f50315a.v();
                this.f50315a.n();
                if (v3.i0()) {
                    int w3 = this.f50315a.w();
                    com.sun.mail.imap.protocol.c u02 = v3.u0(w3, String.valueOf(this.f50317c) + ".MIME");
                    if (u02 != null) {
                        ByteArrayInputStream b4 = u02.b();
                        if (b4 != null) {
                            this.headers.load(b4);
                        } else {
                            throw new MessagingException("Failed to fetch headers");
                        }
                    } else {
                        throw new MessagingException("Failed to fetch headers");
                    }
                } else {
                    this.headers.addHeader("Content-Type", this.f50318d);
                    this.headers.addHeader("Content-Transfer-Encoding", this.f50316b.f50499d);
                    String str = this.f50316b.f50504i;
                    if (str != null) {
                        this.headers.addHeader("Content-Description", str);
                    }
                    String str2 = this.f50316b.f50503h;
                    if (str2 != null) {
                        this.headers.addHeader("Content-ID", str2);
                    }
                    String str3 = this.f50316b.f50505j;
                    if (str3 != null) {
                        this.headers.addHeader("Content-MD5", str3);
                    }
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.f50315a.getFolder(), e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        this.f50320f = true;
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
        a();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        a();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        return this.f50316b.f50503h;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        return this.f50316b.f50505j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeBodyPart
    public InputStream getContentStream() throws MessagingException {
        com.sun.mail.imap.protocol.c M;
        boolean u3 = this.f50315a.u();
        synchronized (this.f50315a.t()) {
            try {
                com.sun.mail.imap.protocol.h v3 = this.f50315a.v();
                this.f50315a.n();
                if (v3.i0() && this.f50315a.r() != -1) {
                    return new f(this.f50315a, this.f50317c, this.f50316b.f50501f, u3);
                }
                int w3 = this.f50315a.w();
                if (u3) {
                    M = v3.u0(w3, this.f50317c);
                } else {
                    M = v3.M(w3, this.f50317c);
                }
                ByteArrayInputStream b4 = M != null ? M.b() : null;
                if (b4 != null) {
                    return b4;
                }
                throw new MessagingException("No content");
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.f50315a.getFolder(), e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getContentType() throws MessagingException {
        return this.f50318d;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        if (this.dh == null) {
            if (this.f50316b.a()) {
                this.dh = new DataHandler(new h(this, this.f50316b.f50510o, this.f50317c, this.f50315a));
            } else if (this.f50316b.b() && this.f50315a.A()) {
                g gVar = this.f50315a;
                com.sun.mail.imap.protocol.d dVar = this.f50316b;
                this.dh = new DataHandler(new i(gVar, dVar.f50510o[0], dVar.f50511p, this.f50317c), this.f50318d);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDescription() throws MessagingException {
        String str = this.f50319e;
        if (str != null) {
            return str;
        }
        String str2 = this.f50316b.f50504i;
        if (str2 == null) {
            return null;
        }
        try {
            this.f50319e = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f50319e = this.f50316b.f50504i;
        }
        return this.f50319e;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDisposition() throws MessagingException {
        return this.f50316b.f50502g;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        return this.f50316b.f50499d;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getFileName() throws MessagingException {
        ParameterList parameterList;
        ParameterList parameterList2 = this.f50316b.f50508m;
        String str = parameterList2 != null ? parameterList2.get("filename") : null;
        return (str != null || (parameterList = this.f50316b.f50507l) == null) ? str : parameterList.get("name");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        a();
        return super.getHeader(str);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getLineCount() throws MessagingException {
        return this.f50316b.f50500e;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        a();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        a();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        a();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        a();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f50316b.f50501f;
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
