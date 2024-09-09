package com.bytedance.sdk.component.ev.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.t;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends xv {

    /* renamed from: c  reason: collision with root package name */
    public File f29736c;

    /* renamed from: w  reason: collision with root package name */
    public File f29737w;

    public c(a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long f(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey("Content-Length") ? map.get("Content-Length") : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean r(Map<String, String> map) {
        return TextUtils.equals(map.get("Content-Encoding"), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sr() {
        try {
            this.f29736c.delete();
        } catch (Throwable unused) {
        }
        try {
            this.f29737w.delete();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ux(Map<String, String> map) {
        if (TextUtils.equals(map.get("Accept-Ranges"), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get("Content-Range");
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    public void c(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f29736c = new File(str, str2);
        this.f29737w = new File(str, str2 + ".temp");
    }

    public void c(final com.bytedance.sdk.component.ev.c.c cVar) {
        File file = this.f29736c;
        if (file == null || this.f29737w == null) {
            if (cVar != null) {
                cVar.c(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.f29736c.length() != 0 && cVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.ev.w wVar = new com.bytedance.sdk.component.ev.w(true, 200, "Success", null, null, currentTimeMillis, currentTimeMillis);
            wVar.c(this.f29736c);
            cVar.c(this, wVar);
            return;
        }
        long length = this.f29737w.length();
        final long j4 = length >= 0 ? length : 0L;
        t.c cVar2 = new t.c();
        cVar2.c((Object) w());
        w("Range", "bytes=" + j4 + "-");
        if (TextUtils.isEmpty(this.f29749f)) {
            cVar.c(this, new IOException("Url is Empty"));
            return;
        }
        try {
            cVar2.c(this.f29749f);
            c(cVar2);
            this.xv.c(cVar2.c().w()).c(new com.bytedance.sdk.component.w.c.xv() { // from class: com.bytedance.sdk.component.ev.w.c.1
                @Override // com.bytedance.sdk.component.w.c.xv
                public void onFailure(com.bytedance.sdk.component.w.c.w wVar2, IOException iOException) {
                    com.bytedance.sdk.component.ev.c.c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.c(c.this, iOException);
                    }
                    c.this.sr();
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:141:0x01bb A[EDGE_INSN: B:141:0x01bb->B:64:0x01bb ?: BREAK  , SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:52:0x0170 A[Catch: all -> 0x025f, TRY_LEAVE, TryCatch #11 {all -> 0x025f, blocks: (B:44:0x014f, B:46:0x0155, B:48:0x0159, B:49:0x015f, B:50:0x0166, B:52:0x0170), top: B:138:0x014f }] */
                /* JADX WARN: Removed duplicated region for block: B:66:0x01c2 A[Catch: all -> 0x01cd, TryCatch #9 {all -> 0x01cd, blocks: (B:56:0x0182, B:62:0x0192, B:63:0x019c, B:66:0x01c2, B:72:0x01d8, B:74:0x01e2, B:76:0x01ee, B:78:0x01fa, B:79:0x0217, B:80:0x0224, B:84:0x0243), top: B:135:0x0182 }] */
                /* JADX WARN: Removed duplicated region for block: B:69:0x01d0  */
                /* JADX WARN: Removed duplicated region for block: B:82:0x0240  */
                /* JADX WARN: Removed duplicated region for block: B:83:0x0242  */
                /* JADX WARN: Type inference failed for: r13v1 */
                @Override // com.bytedance.sdk.component.w.c.xv
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResponse(com.bytedance.sdk.component.w.c.w r29, com.bytedance.sdk.component.w.c.fp r30) throws java.io.IOException {
                    /*
                        Method dump skipped, instructions count: 690
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ev.w.c.AnonymousClass1.onResponse(com.bytedance.sdk.component.w.c.w, com.bytedance.sdk.component.w.c.fp):void");
                }
            });
        } catch (IllegalArgumentException unused) {
            cVar.c(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f8, code lost:
        r5.seek(r14);
        r5.write(r0, 0, r9);
        r14 = r14 + r9;
        r9 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0209 A[EDGE_INSN: B:173:0x0209->B:82:0x0209 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dd A[Catch: all -> 0x029f, TryCatch #9 {all -> 0x029f, blocks: (B:64:0x01b9, B:66:0x01bf, B:68:0x01c3, B:69:0x01c9, B:70:0x01d0, B:72:0x01dd, B:74:0x01ed, B:79:0x01f8, B:84:0x020e, B:94:0x022a, B:96:0x0232, B:98:0x023c, B:100:0x0246, B:116:0x026b, B:120:0x0282, B:91:0x0220), top: B:168:0x01b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x020e A[Catch: all -> 0x029f, TryCatch #9 {all -> 0x029f, blocks: (B:64:0x01b9, B:66:0x01bf, B:68:0x01c3, B:69:0x01c9, B:70:0x01d0, B:72:0x01dd, B:74:0x01ed, B:79:0x01f8, B:84:0x020e, B:94:0x022a, B:96:0x0232, B:98:0x023c, B:100:0x0246, B:116:0x026b, B:120:0x0282, B:91:0x0220), top: B:168:0x01b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x022a A[Catch: all -> 0x029f, TryCatch #9 {all -> 0x029f, blocks: (B:64:0x01b9, B:66:0x01bf, B:68:0x01c3, B:69:0x01c9, B:70:0x01d0, B:72:0x01dd, B:74:0x01ed, B:79:0x01f8, B:84:0x020e, B:94:0x022a, B:96:0x0232, B:98:0x023c, B:100:0x0246, B:116:0x026b, B:120:0x0282, B:91:0x0220), top: B:168:0x01b9 }] */
    @Override // com.bytedance.sdk.component.ev.w.xv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.ev.w c() {
        /*
            Method dump skipped, instructions count: 744
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ev.w.c.c():com.bytedance.sdk.component.ev.w");
    }

    protected void c(long j4, long j5, com.bytedance.sdk.component.ev.c.c cVar) {
        if (cVar != null) {
            cVar.c(this, j4, j5);
        }
    }
}
