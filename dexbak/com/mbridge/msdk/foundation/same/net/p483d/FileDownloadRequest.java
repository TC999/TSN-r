package com.mbridge.msdk.foundation.same.net.p483d;

import com.mbridge.msdk.foundation.same.net.AbstractC11354i;
import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p484e.NetworkResponse;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.File;

/* renamed from: com.mbridge.msdk.foundation.same.net.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class FileDownloadRequest extends AbstractC11354i<Void> {

    /* renamed from: c */
    private static final String f30725c = FileDownloadRequest.class.getSimpleName();

    /* renamed from: d */
    private File f30726d;

    /* renamed from: e */
    private File f30727e;

    public FileDownloadRequest(File file, String str) {
        super(0, str);
        this.f30726d = file;
        this.f30727e = new File(file + ".tmp");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: a */
    public final C11356k<Void> mo22205a(NetworkResponse networkResponse) {
        if (!m22196c()) {
            if (this.f30727e.canRead() && this.f30727e.length() > 0) {
                if (this.f30727e.renameTo(this.f30726d)) {
                    return C11356k.m22175a(null, networkResponse);
                }
                SameLogTool.m21736b(f30725c, "Can't rename the download temporary file!");
                return C11356k.m22176a(new CommonError(4, networkResponse));
            }
            SameLogTool.m21736b(f30725c, "Download temporary file was invalid!");
            return C11356k.m22176a(new CommonError(4, networkResponse));
        }
        return C11356k.m22176a(new CommonError(-2, networkResponse));
    }

    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: g */
    public final int mo22192g() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
        r18.mo22285b(r16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a1, code lost:
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a5, code lost:
        com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(com.mbridge.msdk.foundation.same.net.p483d.FileDownloadRequest.f30725c, "Error occured when calling InputStream.close");
     */
    @Override // com.mbridge.msdk.foundation.same.net.AbstractC11354i
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] mo22206a(com.mbridge.msdk.foundation.same.net.p484e.C11348b r17, com.mbridge.msdk.foundation.same.net.Delivery r18) throws java.io.IOException {
        /*
            r16 = this;
            r7 = r16
            java.lang.String r8 = "Error occured when calling InputStream.close"
            java.util.List r0 = r17.m22270b()
            java.lang.String r1 = "Content-Length"
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.p485f.HttpUtils.m22256a(r0, r1)
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
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.p483d.FileDownloadRequest.f30725c
            java.lang.String r1 = "Response doesn't present Content-Length!"
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r0, r1)
        L2c:
            r11 = 0
            int r0 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r0 <= 0) goto L4c
            java.io.File r0 = r7.f30726d
            long r0 = r0.length()
            int r4 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r4 != 0) goto L4c
            java.io.File r0 = r7.f30726d
            java.io.File r1 = r7.f30727e
            r0.renameTo(r1)
            r1 = r18
            r2 = r16
            r3 = r9
            r5 = r9
            r1.mo22288a(r2, r3, r5)
            return r11
        L4c:
            java.io.RandomAccessFile r12 = new java.io.RandomAccessFile
            java.io.File r0 = r7.f30727e
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.String r1 = "rw"
            r12.<init>(r0, r1)
            r12.setLength(r2)
            java.io.InputStream r1 = r17.m22269c()     // Catch: java.lang.Throwable -> Lb4
            java.util.List r0 = r17.m22270b()     // Catch: java.lang.Throwable -> Lb1
            boolean r0 = com.mbridge.msdk.foundation.same.net.p485f.HttpUtils.m22255b(r0)     // Catch: java.lang.Throwable -> Lb1
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
            r1.mo22288a(r2, r3, r5)     // Catch: java.lang.Throwable -> Lae
            boolean r1 = r16.m22196c()     // Catch: java.lang.Throwable -> Lae
            if (r1 == 0) goto L9d
            r1 = r18
            r1.mo22285b(r7)     // Catch: java.lang.Throwable -> Lae
            goto La1
        L9d:
            r1 = r18
            r2 = r14
            goto L7a
        La1:
            r13.close()     // Catch: java.lang.Exception -> La5
            goto Laa
        La5:
            java.lang.String r0 = com.mbridge.msdk.foundation.same.net.p483d.FileDownloadRequest.f30725c
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r0, r8)
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
            java.lang.String r1 = com.mbridge.msdk.foundation.same.net.p483d.FileDownloadRequest.f30725c
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r1, r8)
        Lc0:
            r12.close()
            goto Lc5
        Lc4:
            throw r0
        Lc5:
            goto Lc4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.p483d.FileDownloadRequest.mo22206a(com.mbridge.msdk.foundation.same.net.e.b, com.mbridge.msdk.foundation.same.net.c):byte[]");
    }
}
