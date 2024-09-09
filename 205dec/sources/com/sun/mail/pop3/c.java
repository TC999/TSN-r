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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: POP3Message.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c extends MimeMessage {

    /* renamed from: e  reason: collision with root package name */
    static final String f50611e = "UNKNOWN";

    /* renamed from: a  reason: collision with root package name */
    private b f50612a;

    /* renamed from: b  reason: collision with root package name */
    private int f50613b;

    /* renamed from: c  reason: collision with root package name */
    private int f50614c;

    /* renamed from: d  reason: collision with root package name */
    String f50615d;

    public c(Folder folder, int i4) throws MessagingException {
        super(folder, i4);
        this.f50613b = -1;
        this.f50614c = -1;
        this.f50615d = "UNKNOWN";
        this.f50612a = (b) folder;
    }

    private void b() throws MessagingException {
        InputStream n4;
        try {
            synchronized (this) {
                if (this.headers != null) {
                    return;
                }
                if (!((e) this.f50612a.getStore()).f50626k && (n4 = this.f50612a.g().n(this.msgnum, 0)) != null) {
                    this.f50613b = n4.available();
                    this.headers = new InternetHeaders(n4);
                }
                getContentStream().close();
            }
        } catch (EOFException e4) {
            this.f50612a.close(false);
            throw new FolderClosedException(this.f50612a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error loading POP3 headers", e5);
        }
    }

    public synchronized void a(boolean z3) {
        this.content = null;
        this.contentStream = null;
        this.f50614c = -1;
        if (z3) {
            this.headers = null;
            this.f50613b = -1;
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

    public InputStream c(int i4) throws MessagingException {
        InputStream n4;
        try {
            synchronized (this) {
                n4 = this.f50612a.g().n(this.msgnum, i4);
            }
            return n4;
        } catch (EOFException e4) {
            this.f50612a.close(false);
            throw new FolderClosedException(this.f50612a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error getting size", e5);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getAllHeaderLines() throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getAllHeaders() throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getAllHeaders();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        int i4;
        try {
            synchronized (this) {
                if (this.contentStream == null) {
                    f g4 = this.f50612a.g();
                    int i5 = this.msgnum;
                    int i6 = this.f50614c;
                    InputStream i7 = g4.i(i5, i6 > 0 ? i6 + this.f50613b : 0);
                    if (i7 != null) {
                        if (this.headers != null && !((e) this.f50612a.getStore()).f50627l) {
                            do {
                                i4 = 0;
                                while (true) {
                                    int read = i7.read();
                                    if (read >= 0 && read != 10) {
                                        if (read != 13) {
                                            i4++;
                                        } else if (i7.available() > 0) {
                                            i7.mark(1);
                                            if (i7.read() != 10) {
                                                i7.reset();
                                            }
                                        }
                                    }
                                }
                                if (i7.available() == 0) {
                                    break;
                                }
                            } while (i4 != 0);
                            this.f50613b = (int) ((SharedInputStream) i7).getPosition();
                            this.contentStream = ((SharedInputStream) i7).newStream(this.f50613b, -1L);
                        }
                        this.headers = new InternetHeaders(i7);
                        this.f50613b = (int) ((SharedInputStream) i7).getPosition();
                        this.contentStream = ((SharedInputStream) i7).newStream(this.f50613b, -1L);
                    } else {
                        this.expunged = true;
                        throw new MessageRemovedException();
                    }
                }
            }
            return super.getContentStream();
        } catch (EOFException e4) {
            this.f50612a.close(false);
            throw new FolderClosedException(this.f50612a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error fetching POP3 content", e5);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration getNonMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        try {
            synchronized (this) {
                int i4 = this.f50614c;
                if (i4 >= 0) {
                    return i4;
                }
                if (i4 < 0) {
                    if (this.headers == null) {
                        b();
                    }
                    InputStream inputStream = this.contentStream;
                    if (inputStream != null) {
                        this.f50614c = inputStream.available();
                    } else {
                        this.f50614c = this.f50612a.g().c(this.msgnum) - this.f50613b;
                    }
                }
                return this.f50614c;
            }
        } catch (EOFException e4) {
            this.f50612a.close(false);
            throw new FolderClosedException(this.f50612a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error getting size", e5);
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
    public void setFlags(Flags flags, boolean z3) throws MessagingException {
        super.setFlags(flags, z3);
        if (this.flags.equals((Flags) this.flags.clone())) {
            return;
        }
        this.f50612a.notifyMessageChangedListeners(1, this);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getHeader(str, str2);
    }
}
