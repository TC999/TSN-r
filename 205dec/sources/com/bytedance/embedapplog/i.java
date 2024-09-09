package com.bytedance.embedapplog;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class i {

    /* renamed from: c  reason: collision with root package name */
    boolean f26746c;
    boolean sr;

    /* renamed from: w  reason: collision with root package name */
    boolean f26747w;
    boolean xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(boolean z3, boolean z4) {
        this.f26747w = z3;
        this.xv = z4;
        this.sr = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String c(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = android.os.Environment.getExternalStorageState()
            java.lang.String r1 = "mounted"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto Ld
            return r9
        Ld:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r1 = r1.getPath()
            r0.append(r1)
            java.lang.String r1 = "/Android/data/com.snssdk.api.embed/cache"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r2 = "/"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            r2.<init>(r0)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            if (r0 != 0) goto L4d
            boolean r0 = r2.mkdirs()     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            if (r0 != 0) goto L4d
            return r9
        L4d:
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            r0.<init>(r8)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            java.lang.String r2 = "rwd"
            r8.<init>(r0, r2)     // Catch: java.lang.Throwable -> La8 java.io.IOException -> Lab
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            java.nio.channels.FileLock r1 = r2.lock()     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            boolean r0 = r0.isFile()     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            java.lang.String r2 = "UTF-8"
            if (r0 == 0) goto L8a
            r0 = 129(0x81, float:1.81E-43)
            byte[] r3 = new byte[r0]     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            r4 = 0
            int r5 = r8.read(r3, r4, r0)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            if (r5 <= 0) goto L8a
            if (r5 >= r0) goto L8a
            java.lang.String r0 = new java.lang.String     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            r0.<init>(r3, r4, r5, r2)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            boolean r3 = com.bytedance.embedapplog.ck.c(r0)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            if (r3 == 0) goto L8a
            if (r1 == 0) goto L86
            r1.release()     // Catch: java.lang.Exception -> L86
        L86:
            r8.close()     // Catch: java.lang.Exception -> L89
        L89:
            return r0
        L8a:
            byte[] r0 = r9.getBytes(r2)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            r2 = 0
            r8.setLength(r2)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            r8.write(r0)     // Catch: java.lang.Throwable -> L9f java.io.IOException -> La3
            if (r1 == 0) goto L9b
            r1.release()     // Catch: java.lang.Exception -> L9b
        L9b:
            r8.close()     // Catch: java.lang.Exception -> L9e
        L9e:
            return r9
        L9f:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto Ld9
        La3:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
            goto Lad
        La8:
            r8 = move-exception
            r0 = r1
            goto Ld9
        Lab:
            r8 = move-exception
            r0 = r1
        Lad:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Ld8
            r3 = 23
            if (r2 < r3) goto Lcb
            com.bytedance.embedapplog.ys r2 = com.bytedance.embedapplog.ys.f()     // Catch: java.lang.Throwable -> Ld8
            android.app.Application r2 = r2.f26855c     // Catch: java.lang.Throwable -> Ld8
            java.lang.String r3 = "android.permission.READ_EXTERNAL_STORAGE"
            int r2 = r2.checkSelfPermission(r3)     // Catch: java.lang.Throwable -> Ld8
            if (r2 != 0) goto Lc5
            com.bytedance.embedapplog.be.w(r8)     // Catch: java.lang.Throwable -> Ld8
            goto Lcb
        Lc5:
            java.lang.SecurityException r9 = new java.lang.SecurityException     // Catch: java.lang.Throwable -> Ld8
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Ld8
            throw r9     // Catch: java.lang.Throwable -> Ld8
        Lcb:
            if (r1 == 0) goto Ld2
            r1.release()     // Catch: java.lang.Exception -> Ld1
            goto Ld2
        Ld1:
        Ld2:
            if (r0 == 0) goto Ld7
            r0.close()     // Catch: java.lang.Exception -> Ld7
        Ld7:
            return r9
        Ld8:
            r8 = move-exception
        Ld9:
            if (r1 == 0) goto Le0
            r1.release()     // Catch: java.lang.Exception -> Ldf
            goto Le0
        Ldf:
        Le0:
            if (r0 == 0) goto Le5
            r0.close()     // Catch: java.lang.Exception -> Le5
        Le5:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.i.c(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean c(JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(boolean z3, boolean z4, boolean z5) {
        this.f26747w = z3;
        this.xv = z4;
        this.sr = z5;
    }
}
