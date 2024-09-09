package com.sun.mail.imap;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IMAPInputStream.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class f extends InputStream {

    /* renamed from: k  reason: collision with root package name */
    private static final int f50387k = 64;

    /* renamed from: a  reason: collision with root package name */
    private g f50388a;

    /* renamed from: b  reason: collision with root package name */
    private String f50389b;

    /* renamed from: c  reason: collision with root package name */
    private int f50390c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f50391d;

    /* renamed from: e  reason: collision with root package name */
    private int f50392e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f50393f;

    /* renamed from: g  reason: collision with root package name */
    private int f50394g;

    /* renamed from: h  reason: collision with root package name */
    private int f50395h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f50396i;

    /* renamed from: j  reason: collision with root package name */
    private com.sun.mail.iap.d f50397j;

    public f(g gVar, String str, int i4, boolean z3) {
        this.f50388a = gVar;
        this.f50389b = str;
        this.f50392e = i4;
        this.f50396i = z3;
        this.f50391d = gVar.r();
    }

    private void a() {
        if (this.f50396i) {
            return;
        }
        try {
            Folder folder = this.f50388a.getFolder();
            if (folder == null || folder.getMode() == 1) {
                return;
            }
            g gVar = this.f50388a;
            Flags.Flag flag = Flags.Flag.SEEN;
            if (gVar.isSet(flag)) {
                return;
            }
            this.f50388a.setFlag(flag, true);
        } catch (MessagingException unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0050 A[Catch: all -> 0x00a3, FolderClosedException -> 0x00a5, ProtocolException -> 0x00b4, TryCatch #1 {ProtocolException -> 0x00b4, blocks: (B:15:0x0028, B:17:0x0036, B:19:0x0042, B:21:0x0048, B:23:0x004c, B:25:0x0050, B:26:0x005b, B:38:0x009b, B:39:0x00a2), top: B:50:0x0028, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[Catch: all -> 0x00a3, FolderClosedException -> 0x00a5, ProtocolException -> 0x00b4, TRY_LEAVE, TryCatch #1 {ProtocolException -> 0x00b4, blocks: (B:15:0x0028, B:17:0x0036, B:19:0x0042, B:21:0x0048, B:23:0x004c, B:25:0x0050, B:26:0x005b, B:38:0x009b, B:39:0x00a2), top: B:50:0x0028, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f50392e
            r1 = -1
            if (r0 == r1) goto L12
            int r2 = r9.f50390c
            if (r2 < r0) goto L12
            if (r2 != 0) goto Le
            r9.a()
        Le:
            r0 = 0
            r9.f50397j = r0
            return
        L12:
            com.sun.mail.iap.d r0 = r9.f50397j
            if (r0 != 0) goto L21
            com.sun.mail.iap.d r0 = new com.sun.mail.iap.d
            int r2 = r9.f50391d
            int r2 = r2 + 64
            r0.<init>(r2)
            r9.f50397j = r0
        L21:
            com.sun.mail.imap.g r0 = r9.f50388a
            java.lang.Object r0 = r0.t()
            monitor-enter(r0)
            com.sun.mail.imap.g r2 = r9.f50388a     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.protocol.h r3 = r2.v()     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.g r2 = r9.f50388a     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            boolean r2 = r2.isExpunged()     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            if (r2 != 0) goto L9b
            com.sun.mail.imap.g r2 = r9.f50388a     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r4 = r2.w()     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r2 = r9.f50391d     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r5 = r9.f50392e     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            if (r5 == r1) goto L4b
            int r1 = r9.f50390c     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r6 = r1 + r2
            if (r6 <= r5) goto L4b
            int r5 = r5 - r1
            r7 = r5
            goto L4c
        L4b:
            r7 = r2
        L4c:
            boolean r1 = r9.f50396i     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            if (r1 == 0) goto L5b
            java.lang.String r5 = r9.f50389b     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r6 = r9.f50390c     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.iap.d r8 = r9.f50397j     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.protocol.c r1 = r3.w0(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            goto L65
        L5b:
            java.lang.String r5 = r9.f50389b     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            int r6 = r9.f50390c     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.iap.d r8 = r9.f50397j     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
            com.sun.mail.imap.protocol.c r1 = r3.O(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> La3 javax.mail.FolderClosedException -> La5 com.sun.mail.iap.ProtocolException -> Lb4
        L65:
            if (r1 == 0) goto L90
            com.sun.mail.iap.d r1 = r1.a()     // Catch: java.lang.Throwable -> La3
            if (r1 == 0) goto L90
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La3
            int r0 = r9.f50390c
            if (r0 != 0) goto L75
            r9.a()
        L75:
            byte[] r0 = r1.a()
            r9.f50393f = r0
            int r0 = r1.d()
            r9.f50395h = r0
            int r0 = r1.b()
            int r1 = r9.f50395h
            int r1 = r1 + r0
            r9.f50394g = r1
            int r1 = r9.f50390c
            int r1 = r1 + r0
            r9.f50390c = r1
            return
        L90:
            r9.c()     // Catch: java.lang.Throwable -> La3
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
            r9.c()     // Catch: java.lang.Throwable -> La3
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> La3
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> La3
            r2.<init>(r1)     // Catch: java.lang.Throwable -> La3
            throw r2     // Catch: java.lang.Throwable -> La3
        Lc2:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La3
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.f.b():void");
    }

    private void c() throws MessageRemovedIOException, FolderClosedIOException {
        synchronized (this.f50388a.t()) {
            try {
                try {
                    this.f50388a.v().r0();
                } catch (ProtocolException unused) {
                } catch (FolderClosedException e4) {
                    throw new FolderClosedIOException(e4.getFolder(), e4.getMessage());
                }
            } catch (ConnectionException e5) {
                throw new FolderClosedIOException(this.f50388a.getFolder(), e5.getMessage());
            }
        }
        if (this.f50388a.isExpunged()) {
            throw new MessageRemovedIOException();
        }
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        return this.f50394g - this.f50395h;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.f50395h >= this.f50394g) {
            b();
            if (this.f50395h >= this.f50394g) {
                return -1;
            }
        }
        byte[] bArr = this.f50393f;
        int i4 = this.f50395h;
        this.f50395h = i4 + 1;
        return bArr[i4] & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.f50394g - this.f50395h;
        if (i6 <= 0) {
            b();
            i6 = this.f50394g - this.f50395h;
            if (i6 <= 0) {
                return -1;
            }
        }
        if (i6 < i5) {
            i5 = i6;
        }
        System.arraycopy(this.f50393f, this.f50395h, bArr, i4, i5);
        this.f50395h += i5;
        return i5;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
