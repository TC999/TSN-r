package com.bykv.vk.openvk.component.video.c.c.c;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w implements xv {
    private RandomAccessFile gd;

    /* renamed from: p  reason: collision with root package name */
    private final sr f24980p;
    private File sr;
    private long ux;
    private File xv;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f24978c = -2147483648L;

    /* renamed from: w  reason: collision with root package name */
    private final Object f24982w = new Object();

    /* renamed from: f  reason: collision with root package name */
    private volatile long f24979f = -1;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f24981r = false;
    private volatile boolean ev = false;

    public w(Context context, sr srVar) {
        this.ux = 0L;
        this.gd = null;
        this.f24980p = srVar;
        try {
            this.xv = com.bykv.vk.openvk.component.video.c.ux.xv.w(srVar.ux(), srVar.ia());
            this.sr = com.bykv.vk.openvk.component.video.c.ux.xv.xv(srVar.ux(), srVar.ia());
            if (sr()) {
                this.gd = new RandomAccessFile(this.sr, "r");
            } else {
                this.gd = new RandomAccessFile(this.xv, "rw");
            }
            if (sr()) {
                return;
            }
            this.ux = this.xv.length();
            c();
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "Error using file ", srVar.fp(), " as disc cache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() throws IOException {
        synchronized (this.f24982w) {
            if (sr()) {
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "complete: isCompleted ", this.f24980p.fp(), this.f24980p.ia());
            } else if (this.xv.renameTo(this.sr)) {
                RandomAccessFile randomAccessFile = this.gd;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.gd = new RandomAccessFile(this.sr, "rw");
                com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "complete: rename ", this.f24980p.ia(), this.f24980p.fp());
            } else {
                throw new IOException("Error renaming file " + this.xv + " to " + this.sr + " for completion!");
            }
        }
    }

    private boolean sr() {
        return this.sr.exists();
    }

    private long ux() {
        if (sr()) {
            return this.sr.length();
        }
        return this.xv.length();
    }

    @Override // com.bykv.vk.openvk.component.video.c.c.c.xv
    public void w() {
        try {
            if (!this.f24981r) {
                this.gd.close();
            }
            File file = this.xv;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.sr;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } finally {
            this.f24981r = true;
        }
        this.f24981r = true;
    }

    @Override // com.bykv.vk.openvk.component.video.c.c.c.xv
    public long xv() throws IOException {
        if (sr()) {
            this.f24978c = this.sr.length();
        } else {
            synchronized (this.f24982w) {
                int i4 = 0;
                do {
                    if (this.f24978c == -2147483648L) {
                        try {
                            com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "totalLength: wait");
                            i4 += 15;
                            this.f24982w.wait(5L);
                        } catch (InterruptedException e4) {
                            e4.printStackTrace();
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i4 <= 20000);
                return -1L;
            }
        }
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.f24978c));
        return this.f24978c;
    }

    public void c() {
        a.c cVar;
        if (com.bykv.vk.openvk.component.video.api.xv.xv() != null) {
            cVar = com.bykv.vk.openvk.component.video.api.xv.xv().w();
        } else {
            cVar = new a.c("v_cache");
        }
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        cVar.c(this.f24980p.fz(), timeUnit).w(this.f24980p.u(), timeUnit).xv(this.f24980p.i(), timeUnit);
        a c4 = cVar.c();
        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "RANGE, bytes=", Long.valueOf(this.ux), " file hash=", this.f24980p.ia());
        t.c cVar2 = new t.c();
        c4.c(cVar2.c("RANGE", "bytes=" + this.ux + "-").c(this.f24980p.fp()).c().w()).c(new com.bytedance.sdk.component.w.c.xv() { // from class: com.bykv.vk.openvk.component.video.c.c.c.w.1
            @Override // com.bytedance.sdk.component.w.c.xv
            public void onFailure(com.bytedance.sdk.component.w.c.w wVar, IOException iOException) {
                w.this.ev = false;
                w.this.f24978c = -1L;
            }

            /* JADX WARN: Removed duplicated region for block: B:113:0x0155 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:40:0x012b A[Catch: all -> 0x01bb, TryCatch #4 {all -> 0x01bb, blocks: (B:8:0x001b, B:11:0x0025, B:28:0x0073, B:29:0x007f, B:31:0x009a, B:33:0x00a5, B:38:0x00ba, B:40:0x012b, B:41:0x0131, B:49:0x0159, B:53:0x019f, B:42:0x0132, B:43:0x014d, B:44:0x014e), top: B:108:0x001b }] */
            @Override // com.bytedance.sdk.component.w.c.xv
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.w.c.w r25, com.bytedance.sdk.component.w.c.fp r26) throws java.io.IOException {
                /*
                    Method dump skipped, instructions count: 652
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.c.c.c.w.AnonymousClass1.onResponse(com.bytedance.sdk.component.w.c.w, com.bytedance.sdk.component.w.c.fp):void");
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.c.c.c.xv
    public int c(long j4, byte[] bArr, int i4, int i5) throws IOException {
        try {
            if (j4 == this.f24978c) {
                return -1;
            }
            int i6 = 0;
            int i7 = 0;
            while (!this.f24981r) {
                synchronized (this.f24982w) {
                    long ux = ux();
                    if (j4 < ux) {
                        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "read:  read " + j4 + " success");
                        this.gd.seek(j4);
                        i7 = this.gd.read(bArr, i4, i5);
                    } else {
                        com.bykv.vk.openvk.component.video.api.f.xv.w("CSJ_MediaDLPlay", "read: wait at ", Long.valueOf(j4), "  file size = ", Long.valueOf(ux));
                        i6 += 33;
                        this.f24982w.wait(33L);
                    }
                }
                if (i7 > 0) {
                    return i7;
                }
                if (i6 >= 20000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }
}
