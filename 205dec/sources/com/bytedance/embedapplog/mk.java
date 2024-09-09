package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemProperties;
import com.bytedance.embedapplog.zg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class mk implements zg {

    /* renamed from: c  reason: collision with root package name */
    private static final oh<Boolean> f26764c = new oh<Boolean>() { // from class: com.bytedance.embedapplog.mk.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.oh
        /* renamed from: xv */
        public Boolean c(Object... objArr) {
            return Boolean.valueOf("1".equals(mk.w("persist.sys.identifierid.supported", "0")));
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public mk(Context context) {
    }

    @Override // com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        zg.c cVar = new zg.c();
        cVar.f26861w = c(context, 0, null);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return f26764c.w(new Object[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String w(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // com.bytedance.embedapplog.zg
    public boolean c(Context context) {
        return c();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c(@androidx.annotation.NonNull android.content.Context r7, int r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 == 0) goto L37
            r1 = 1
            if (r8 == r1) goto L21
            r1 = 2
            if (r8 == r1) goto Lb
            r2 = r0
            goto L3e
        Lb:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L3d
        L21:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L3d
        L37:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L3d:
            r2 = r8
        L3e:
            if (r2 == 0) goto L74
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L68
            if (r7 == 0) goto L62
            boolean r8 = r7.moveToNext()     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L6e
            if (r8 == 0) goto L62
            java.lang.String r8 = "value"
            int r8 = r7.getColumnIndex(r8)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L6e
            java.lang.String r8 = r7.getString(r8)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L6e
            r0 = r8
            goto L62
        L60:
            r8 = move-exception
            goto L6a
        L62:
            com.bytedance.embedapplog.g.c(r7)
            goto L74
        L66:
            r8 = move-exception
            goto L70
        L68:
            r8 = move-exception
            r7 = r0
        L6a:
            com.bytedance.embedapplog.be.c(r8)     // Catch: java.lang.Throwable -> L6e
            goto L62
        L6e:
            r8 = move-exception
            r0 = r7
        L70:
            com.bytedance.embedapplog.g.c(r0)
            throw r8
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.mk.c(android.content.Context, int, java.lang.String):java.lang.String");
    }
}
