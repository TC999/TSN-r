package com.mbridge.msdk.foundation.same.net.d;

import com.mbridge.msdk.foundation.same.net.i;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;

/* compiled from: FileDownloadRequest.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a extends i<Void> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f39516c = a.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private File f39517d;

    /* renamed from: e  reason: collision with root package name */
    private File f39518e;

    public a(File file, String str) {
        super(0, str);
        this.f39517d = file;
        this.f39518e = new File(file + ".tmp");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.i
    public final k<Void> a(com.mbridge.msdk.foundation.same.net.e.c cVar) {
        if (!c()) {
            if (this.f39518e.canRead() && this.f39518e.length() > 0) {
                if (this.f39518e.renameTo(this.f39517d)) {
                    return k.a(null, cVar);
                }
                x.b(f39516c, "Can't rename the download temporary file!");
                return k.a(new com.mbridge.msdk.foundation.same.net.a.a(4, cVar));
            }
            x.b(f39516c, "Download temporary file was invalid!");
            return k.a(new com.mbridge.msdk.foundation.same.net.a.a(4, cVar));
        }
        return k.a(new com.mbridge.msdk.foundation.same.net.a.a(-2, cVar));
    }

    @Override // com.mbridge.msdk.foundation.same.net.i
    public final int g() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
        r18.b(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a5, code lost:
        com.mbridge.msdk.foundation.tools.x.d(com.mbridge.msdk.foundation.same.net.d.a.f39516c, "Error occured when calling InputStream.close");
     */
    @Override // com.mbridge.msdk.foundation.same.net.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] a(com.mbridge.msdk.foundation.same.net.e.b r17, com.mbridge.msdk.foundation.same.net.c r18) throws java.io.IOException {
        /*
            r16 = this;
            r7 = r16
            java.lang.String r8 = "Error occured when calling InputStream.close"
            java.util.List r0 = r17.b()
            java.lang.String r1 = "Content-Length"
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.f.b.a(r0, r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r1 != 0) goto L20
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r0 = r0.longValue()
            r9 = r0
            goto L21
        L20:
            r9 = r2
        L21:
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 > 0) goto L2c
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.d.a.f39516c
            java.lang.String r1 = "Response doesn't present Content-Length!"
            com.mbridge.msdk.foundation.tools.x.b(r0, r1)
        L2c:
            r11 = 0
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 <= 0) goto L4c
            java.io.File r0 = r7.f39517d
            long r0 = r0.length()
            int r4 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r4 != 0) goto L4c
            java.io.File r0 = r7.f39517d
            java.io.File r1 = r7.f39518e
            r0.renameTo(r1)
            r1 = r18
            r2 = r16
            r3 = r9
            r5 = r9
            r1.a(r2, r3, r5)
            return r11
        L4c:
            java.io.RandomAccessFile r12 = new java.io.RandomAccessFile
            java.io.File r0 = r7.f39518e
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r1 = "rw"
            r12.<init>(r0, r1)
            r12.setLength(r2)
            java.io.InputStream r1 = r17.c()     // Catch: java.lang.Throwable -> Lb4
            java.util.List r0 = r17.b()     // Catch: java.lang.Throwable -> Lb1
            boolean r0 = com.mbridge.msdk.foundation.same.net.f.b.b(r0)     // Catch: java.lang.Throwable -> Lb1
            if (r0 == 0) goto L75
            boolean r0 = r1 instanceof java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> Lb1
            if (r0 != 0) goto L75
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> Lb1
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lb1
            r13 = r0
            goto L76
        L75:
            r13 = r1
        L76:
            r0 = 6144(0x1800, float:8.61E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> Lae
        L7a:
            int r1 = r13.read(r0)     // Catch: java.lang.Throwable -> Lae
            r4 = -1
            if (r1 == r4) goto La1
            r4 = 0
            r12.write(r0, r4, r1)     // Catch: java.lang.Throwable -> Lae
            long r4 = (long) r1     // Catch: java.lang.Throwable -> Lae
            long r14 = r2 + r4
            r1 = r18
            r2 = r16
            r3 = r9
            r5 = r14
            r1.a(r2, r3, r5)     // Catch: java.lang.Throwable -> Lae
            boolean r1 = r16.c()     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto L9d
            r1 = r18
            r1.b(r7)     // Catch: java.lang.Throwable -> Lae
            goto La1
        L9d:
            r1 = r18
            r2 = r14
            goto L7a
        La1:
            r13.close()     // Catch: java.lang.Exception -> La5
            goto Laa
        La5:
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.d.a.f39516c
            com.mbridge.msdk.foundation.tools.x.d(r0, r8)
        Laa:
            r12.close()
            return r11
        Lae:
            r0 = move-exception
            r11 = r13
            goto Lb5
        Lb1:
            r0 = move-exception
            r11 = r1
            goto Lb5
        Lb4:
            r0 = move-exception
        Lb5:
            if (r11 == 0) goto Lc0
            r11.close()     // Catch: java.lang.Exception -> Lbb
            goto Lc0
        Lbb:
            java.lang.String r1 = com.mbridge.msdk.foundation.same.net.d.a.f39516c
            com.mbridge.msdk.foundation.tools.x.d(r1, r8)
        Lc0:
            r12.close()
            goto Lc5
        Lc4:
            throw r0
        Lc5:
            goto Lc4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.d.a.a(com.mbridge.msdk.foundation.same.net.e.b, com.mbridge.msdk.foundation.same.net.c):byte[]");
    }
}
