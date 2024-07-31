package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.core.videocache.p413a.C10550b;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.core.videocache.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10568e extends C10578k {
    private final AbstractC10584p aBR;
    private final C10550b aBS;
    private InterfaceC10558b aBT;

    public C10568e(AbstractC10584p abstractC10584p, C10550b c10550b) {
        super(abstractC10584p, c10550b);
        this.aBS = c10550b;
        this.aBR = abstractC10584p;
    }

    /* renamed from: b */
    private String m25454b(C10563d c10563d) {
        String mo25393Gy = this.aBR.mo25393Gy();
        boolean z = !TextUtils.isEmpty(mo25393Gy);
        long mo25489Go = this.aBS.isCompleted() ? this.aBS.mo25489Go() : this.aBR.length();
        boolean z2 = mo25489Go >= 0;
        boolean z3 = c10563d.aBQ;
        long j = z3 ? mo25489Go - c10563d.aBP : mo25489Go;
        boolean z4 = z2 && z3;
        StringBuilder sb = new StringBuilder();
        sb.append(c10563d.aBQ ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        sb.append(z2 ? format("Content-Length: %d\n", Long.valueOf(j)) : "");
        sb.append(z4 ? format("Content-Range: bytes %d-%d/%d\n", Long.valueOf(c10563d.aBP), Long.valueOf(mo25489Go - 1), Long.valueOf(mo25489Go)) : "");
        sb.append(z ? format("Content-Type: %s\n", mo25393Gy) : "");
        sb.append(ShellAdbUtils.f33810d);
        return sb.toString();
    }

    private static String format(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    /* renamed from: a */
    public final void m25458a(InterfaceC10558b interfaceC10558b) {
        this.aBT = interfaceC10558b;
    }

    @Override // com.kwad.sdk.core.videocache.C10578k
    /* renamed from: dr */
    protected final void mo25400dr(int i) {
        InterfaceC10558b interfaceC10558b = this.aBT;
        if (interfaceC10558b != null) {
            interfaceC10558b.mo25421a(this.aBS.file, i);
        }
    }

    /* renamed from: a */
    public final void m25456a(C10563d c10563d, Socket socket) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(m25454b(c10563d).getBytes("UTF-8"));
        long j = c10563d.aBP;
        if (m25457a(c10563d)) {
            m25455a(bufferedOutputStream, j);
        } else {
            m25453b(bufferedOutputStream, j);
        }
    }

    /* renamed from: a */
    private boolean m25457a(C10563d c10563d) {
        long length = this.aBR.length();
        return (((length > 0L ? 1 : (length == 0L ? 0 : -1)) > 0) && c10563d.aBQ && ((float) c10563d.aBP) > ((float) this.aBS.mo25489Go()) + (((float) length) * 0.2f)) ? false : true;
    }

    /* renamed from: a */
    private void m25455a(OutputStream outputStream, long j) {
        byte[] bArr = new byte[1024];
        while (true) {
            int m25401a = m25401a(bArr, j, 1024);
            if (m25401a == -1) {
                break;
            }
            try {
                outputStream.write(bArr, 0, m25401a);
                j += m25401a;
            } catch (Exception unused) {
            }
        }
        outputStream.flush();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[Catch: all -> 0x0037, LOOP:0: B:11:0x0024->B:13:0x002b, LOOP_END, TryCatch #0 {all -> 0x0037, blocks: (B:10:0x001d, B:11:0x0024, B:13:0x002b, B:14:0x0030), top: B:21:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0030 A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m25453b(java.io.OutputStream r3, long r4) {
        /*
            r2 = this;
            com.kwad.sdk.core.videocache.p r0 = r2.aBR
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.C10575h
            if (r1 == 0) goto Lf
            com.kwad.sdk.core.videocache.h r1 = new com.kwad.sdk.core.videocache.h
            com.kwad.sdk.core.videocache.h r0 = (com.kwad.sdk.core.videocache.C10575h) r0
            r1.<init>(r0)
        Ld:
            r0 = r1
            goto L1b
        Lf:
            boolean r1 = r0 instanceof com.kwad.sdk.core.videocache.C10577j
            if (r1 == 0) goto L1b
            com.kwad.sdk.core.videocache.j r1 = new com.kwad.sdk.core.videocache.j
            com.kwad.sdk.core.videocache.j r0 = (com.kwad.sdk.core.videocache.C10577j) r0
            r1.<init>(r0)
            goto Ld
        L1b:
            int r5 = (int) r4
            long r4 = (long) r5
            r0.mo25395at(r4)     // Catch: java.lang.Throwable -> L37
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L37
        L24:
            int r5 = r0.read(r4)     // Catch: java.lang.Throwable -> L37
            r1 = -1
            if (r5 == r1) goto L30
            r1 = 0
            r3.write(r4, r1, r5)     // Catch: java.lang.Throwable -> L37
            goto L24
        L30:
            r3.flush()     // Catch: java.lang.Throwable -> L37
            r0.close()
            return
        L37:
            r3 = move-exception
            r0.close()
            goto L3d
        L3c:
            throw r3
        L3d:
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.videocache.C10568e.m25453b(java.io.OutputStream, long):void");
    }
}
