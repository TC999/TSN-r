package com.sun.mail.imap;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;
import kotlin.UByte;

/* renamed from: com.sun.mail.imap.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IMAPInputStream extends InputStream {

    /* renamed from: k */
    private static final int f35973k = 64;

    /* renamed from: a */
    private IMAPMessage f35974a;

    /* renamed from: b */
    private String f35975b;

    /* renamed from: c */
    private int f35976c = 0;

    /* renamed from: d */
    private int f35977d;

    /* renamed from: e */
    private int f35978e;

    /* renamed from: f */
    private byte[] f35979f;

    /* renamed from: g */
    private int f35980g;

    /* renamed from: h */
    private int f35981h;

    /* renamed from: i */
    private boolean f35982i;

    /* renamed from: j */
    private ByteArray f35983j;

    public IMAPInputStream(IMAPMessage iMAPMessage, String str, int i, boolean z) {
        this.f35974a = iMAPMessage;
        this.f35975b = str;
        this.f35978e = i;
        this.f35982i = z;
        this.f35977d = iMAPMessage.mo16293r();
    }

    /* renamed from: a */
    private void m16329a() {
        if (this.f35982i) {
            return;
        }
        try {
            Folder folder = this.f35974a.getFolder();
            if (folder == null || folder.getMode() == 1) {
                return;
            }
            IMAPMessage iMAPMessage = this.f35974a;
            Flags.Flag flag = Flags.Flag.SEEN;
            if (iMAPMessage.isSet(flag)) {
                return;
            }
            this.f35974a.setFlag(flag, true);
        } catch (MessagingException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050 A[Catch: all -> 0x00a3, FolderClosedException -> 0x00a5, ProtocolException -> 0x00b4, TryCatch #1 {ProtocolException -> 0x00b4, blocks: (B:15:0x0028, B:17:0x0036, B:19:0x0042, B:21:0x0048, B:23:0x004c, B:25:0x0050, B:26:0x005b, B:38:0x009b, B:39:0x00a2), top: B:50:0x0028, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[Catch: all -> 0x00a3, FolderClosedException -> 0x00a5, ProtocolException -> 0x00b4, TRY_LEAVE, TryCatch #1 {ProtocolException -> 0x00b4, blocks: (B:15:0x0028, B:17:0x0036, B:19:0x0042, B:21:0x0048, B:23:0x004c, B:25:0x0050, B:26:0x005b, B:38:0x009b, B:39:0x00a2), top: B:50:0x0028, outer: #0 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m16328b() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f35978e
            r1 = -1
            if (r0 == r1) goto L12
            int r2 = r9.f35976c
            if (r2 < r0) goto L12
            if (r2 != 0) goto Le
            r9.m16329a()
        Le:
            r0 = 0
            r9.f35983j = r0
            return
        L12:
            com.sun.mail.iap.d r0 = r9.f35983j
            if (r0 != 0) goto L21
            com.sun.mail.iap.d r0 = new com.sun.mail.iap.d
            int r2 = r9.f35977d
            int r2 = r2 + 64
            r0.<init>(r2)
            r9.f35983j = r0
        L21:
            com.sun.mail.imap.g r0 = r9.f35974a
            java.lang.Object r0 = r0.mo16292t()
            monitor-enter(r0)
            com.sun.mail.imap.g r2 = r9.f35974a     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.protocol.h r3 = r2.mo16291v()     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.g r2 = r9.f35974a     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            boolean r2 = r2.isExpunged()     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            if (r2 != 0) goto L9b
            com.sun.mail.imap.g r2 = r9.f35974a     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r4 = r2.mo16290w()     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r2 = r9.f35977d     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r5 = r9.f35978e     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            if (r5 == r1) goto L4b
            int r1 = r9.f35976c     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r6 = r1 + r2
            if (r6 <= r5) goto L4b
            int r5 = r5 - r1
            r7 = r5
            goto L4c
        L4b:
            r7 = r2
        L4c:
            boolean r1 = r9.f35982i     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            if (r1 == 0) goto L5b
            java.lang.String r5 = r9.f35975b     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r6 = r9.f35976c     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.iap.d r8 = r9.f35983j     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.protocol.c r1 = r3.m16129w0(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            goto L65
        L5b:
            java.lang.String r5 = r9.f35975b     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r6 = r9.f35976c     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.iap.d r8 = r9.f35983j     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.protocol.c r1 = r3.m16178O(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
        L65:
            if (r1 == 0) goto L90
            com.sun.mail.iap.d r1 = r1.m16221a()     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto L90
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La3
            int r0 = r9.f35976c
            if (r0 != 0) goto L75
            r9.m16329a()
        L75:
            byte[] r0 = r1.m16428a()
            r9.f35979f = r0
            int r0 = r1.m16425d()
            r9.f35981h = r0
            int r0 = r1.m16427b()
            int r1 = r9.f35981h
            int r1 = r1 + r0
            r9.f35980g = r1
            int r1 = r9.f35976c
            int r1 = r1 + r0
            r9.f35976c = r1
            return
        L90:
            r9.m16327c()     // Catch: java.lang.Throwable -> La3
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> La3
            java.lang.String r2 = "No content"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La3
            throw r1     // Catch: java.lang.Throwable -> La3
        L9b:
            com.sun.mail.util.MessageRemovedIOException r1 = new com.sun.mail.util.MessageRemovedIOException     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            java.lang.String r2 = "No content for expunged message"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            throw r1     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
        La3:
            r1 = move-exception
            goto Lc2
        La5:
            r1 = move-exception
            com.sun.mail.util.FolderClosedIOException r2 = new com.sun.mail.util.FolderClosedIOException     // Catch: java.lang.Throwable -> La3
            javax.mail.Folder r3 = r1.getFolder()     // Catch: java.lang.Throwable -> La3
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> La3
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> La3
            throw r2     // Catch: java.lang.Throwable -> La3
        Lb4:
            r1 = move-exception
            r9.m16327c()     // Catch: java.lang.Throwable -> La3
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> La3
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> La3
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La3
            throw r2     // Catch: java.lang.Throwable -> La3
        Lc2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La3
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPInputStream.m16328b():void");
    }

    /* renamed from: c */
    private void m16327c() throws MessageRemovedIOException, FolderClosedIOException {
        synchronized (this.f35974a.mo16292t()) {
            try {
                try {
                    this.f35974a.mo16291v().m16139r0();
                } catch (ProtocolException unused) {
                } catch (FolderClosedException e) {
                    throw new FolderClosedIOException(e.getFolder(), e.getMessage());
                }
            } catch (ConnectionException e2) {
                throw new FolderClosedIOException(this.f35974a.getFolder(), e2.getMessage());
            }
        }
        if (this.f35974a.isExpunged()) {
            throw new MessageRemovedIOException();
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        return this.f35980g - this.f35981h;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.f35981h >= this.f35980g) {
            m16328b();
            if (this.f35981h >= this.f35980g) {
                return -1;
            }
        }
        byte[] bArr = this.f35979f;
        int i = this.f35981h;
        this.f35981h = i + 1;
        return bArr[i] & UByte.f41242c;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f35980g - this.f35981h;
        if (i3 <= 0) {
            m16328b();
            i3 = this.f35980g - this.f35981h;
            if (i3 <= 0) {
                return -1;
            }
        }
        if (i3 < i2) {
            i2 = i3;
        }
        System.arraycopy(this.f35979f, this.f35981h, bArr, i, i2);
        this.f35981h += i2;
        return i2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
