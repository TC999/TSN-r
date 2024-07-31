package com.sun.mail.pop3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.IllegalWriteException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.SharedInputStream;

/* renamed from: com.sun.mail.pop3.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class POP3Message extends MimeMessage {

    /* renamed from: e */
    static final String f36201e = "UNKNOWN";

    /* renamed from: a */
    private POP3Folder f36202a;

    /* renamed from: b */
    private int f36203b;

    /* renamed from: c */
    private int f36204c;

    /* renamed from: d */
    String f36205d;

    public POP3Message(Folder folder, int i) throws MessagingException {
        super(folder, i);
        this.f36203b = -1;
        this.f36204c = -1;
        this.f36205d = "UNKNOWN";
        this.f36202a = (POP3Folder) folder;
    }

    /* renamed from: b */
    private void m16071b() throws MessagingException {
        InputStream m16054n;
        try {
            synchronized (this) {
                if (this.headers != null) {
                    return;
                }
                if (!((POP3Store) this.f36202a.getStore()).f36216k && (m16054n = this.f36202a.m16077g().m16054n(this.msgnum, 0)) != null) {
                    this.f36203b = m16054n.available();
                    this.headers = new InternetHeaders(m16054n);
                }
                getContentStream().close();
            }
        } catch (EOFException e) {
            this.f36202a.close(false);
            throw new FolderClosedException(this.f36202a, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error loading POP3 headers", e2);
        }
    }

    /* renamed from: a */
    public synchronized void m16072a(boolean z) {
        this.content = null;
        this.contentStream = null;
        this.f36204c = -1;
        if (z) {
            this.headers = null;
            this.f36203b = -1;
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    /* renamed from: c */
    public InputStream m16070c(int i) throws MessagingException {
        InputStream m16054n;
        try {
            synchronized (this) {
                m16054n = this.f36202a.m16077g().m16054n(this.msgnum, i);
            }
            return m16054n;
        } catch (EOFException e) {
            this.f36202a.close(false);
            throw new FolderClosedException(this.f36202a, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error getting size", e2);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getAllHeaders();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        int i;
        try {
            synchronized (this) {
                if (this.contentStream == null) {
                    C12763f m16077g = this.f36202a.m16077g();
                    int i2 = this.msgnum;
                    int i3 = this.f36204c;
                    InputStream m16059i = m16077g.m16059i(i2, i3 > 0 ? i3 + this.f36203b : 0);
                    if (m16059i != null) {
                        if (this.headers != null && !((POP3Store) this.f36202a.getStore()).f36217l) {
                            do {
                                i = 0;
                                while (true) {
                                    int read = m16059i.read();
                                    if (read >= 0 && read != 10) {
                                        if (read != 13) {
                                            i++;
                                        } else if (m16059i.available() > 0) {
                                            m16059i.mark(1);
                                            if (m16059i.read() != 10) {
                                                m16059i.reset();
                                            }
                                        }
                                    }
                                }
                                if (m16059i.available() == 0) {
                                    break;
                                }
                            } while (i != 0);
                            this.f36203b = (int) ((SharedInputStream) m16059i).getPosition();
                            this.contentStream = ((SharedInputStream) m16059i).newStream(this.f36203b, -1L);
                        }
                        this.headers = new InternetHeaders(m16059i);
                        this.f36203b = (int) ((SharedInputStream) m16059i).getPosition();
                        this.contentStream = ((SharedInputStream) m16059i).newStream(this.f36203b, -1L);
                    } else {
                        this.expunged = true;
                        throw new MessageRemovedException();
                    }
                }
            }
            return super.getContentStream();
        } catch (EOFException e) {
            this.f36202a.close(false);
            throw new FolderClosedException(this.f36202a, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error fetching POP3 content", e2);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        try {
            synchronized (this) {
                int i = this.f36204c;
                if (i >= 0) {
                    return i;
                }
                if (i < 0) {
                    if (this.headers == null) {
                        m16071b();
                    }
                    InputStream inputStream = this.contentStream;
                    if (inputStream != null) {
                        this.f36204c = inputStream.available();
                    } else {
                        this.f36204c = this.f36202a.m16077g().m16065c(this.msgnum) - this.f36203b;
                    }
                }
                return this.f36204c;
            }
        } catch (EOFException e) {
            this.f36202a.close(false);
            throw new FolderClosedException(this.f36202a, e.toString());
        } catch (IOException e2) {
            throw new MessagingException("error getting size", e2);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void saveChanges() throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFlags(Flags flags, boolean z) throws MessagingException {
        super.setFlags(flags, z);
        if (this.flags.equals((Flags) this.flags.clone())) {
            return;
        }
        this.f36202a.notifyMessageChangedListeners(1, this);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        if (this.headers == null) {
            m16071b();
        }
        return this.headers.getHeader(str, str2);
    }
}
