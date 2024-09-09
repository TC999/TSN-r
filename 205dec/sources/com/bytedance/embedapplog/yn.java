package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.bytedance.embedapplog.gd;
import com.bytedance.embedapplog.xv;
import com.bytedance.embedapplog.zg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class yn implements zg {

    /* renamed from: c  reason: collision with root package name */
    private final zg f26848c;

    /* renamed from: w  reason: collision with root package name */
    private oh<Boolean> f26849w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yn() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d A[Catch: Exception -> 0x0054, TryCatch #0 {Exception -> 0x0054, blocks: (B:14:0x0025, B:16:0x002d, B:18:0x0039, B:19:0x004f), top: B:24:0x0025 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String xv(android.content.Context r8) {
        /*
            r7 = this;
            r0 = 0
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch: java.lang.Exception -> L14
            java.lang.String r8 = r8.getPackageName()     // Catch: java.lang.Exception -> L14
            r2 = 64
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r2)     // Catch: java.lang.Exception -> L14
            if (r8 == 0) goto L18
            android.content.pm.Signature[] r8 = r8.signatures     // Catch: java.lang.Exception -> L14
            goto L19
        L14:
            r8 = move-exception
            com.bytedance.embedapplog.be.c(r8)
        L18:
            r8 = r0
        L19:
            if (r8 == 0) goto L58
            int r1 = r8.length
            if (r1 <= 0) goto L58
            r1 = 0
            r8 = r8[r1]
            byte[] r8 = r8.toByteArray()
            java.lang.String r2 = "SHA1"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch: java.lang.Exception -> L54
            if (r2 == 0) goto L58
            byte[] r8 = r2.digest(r8)     // Catch: java.lang.Exception -> L54
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L54
            r2.<init>()     // Catch: java.lang.Exception -> L54
            int r3 = r8.length     // Catch: java.lang.Exception -> L54
        L37:
            if (r1 >= r3) goto L4f
            r4 = r8[r1]     // Catch: java.lang.Exception -> L54
            r4 = r4 & 255(0xff, float:3.57E-43)
            r4 = r4 | 256(0x100, float:3.59E-43)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch: java.lang.Exception -> L54
            r5 = 3
            r6 = 1
            java.lang.String r4 = r4.substring(r6, r5)     // Catch: java.lang.Exception -> L54
            r2.append(r4)     // Catch: java.lang.Exception -> L54
            int r1 = r1 + 1
            goto L37
        L4f:
            java.lang.String r8 = r2.toString()     // Catch: java.lang.Exception -> L54
            return r8
        L54:
            r8 = move-exception
            com.bytedance.embedapplog.be.c(r8)
        L58:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.yn.xv(android.content.Context):java.lang.String");
    }

    @Override // com.bytedance.embedapplog.zg
    public zg.c w(final Context context) {
        if (this.f26848c != null && !this.f26849w.w(new Object[0]).booleanValue()) {
            return this.f26848c.w(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        zg.c cVar = new zg.c();
        cVar.f26861w = (String) new xv(context, intent, new xv.w<gd, String>() { // from class: com.bytedance.embedapplog.yn.2
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public gd c(IBinder iBinder) {
                return gd.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public String c(gd gdVar) {
                if (gdVar == null) {
                    return null;
                }
                String xv = yn.this.xv(context);
                if (TextUtils.isEmpty(xv)) {
                    return null;
                }
                return gdVar.c(context.getPackageName(), xv, "OUID");
            }
        }).c();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public yn(zg zgVar) {
        this.f26849w = new oh<Boolean>() { // from class: com.bytedance.embedapplog.yn.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.embedapplog.oh
            /* renamed from: xv */
            public Boolean c(Object... objArr) {
                long j4;
                try {
                    PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                    if (packageInfo == null) {
                        return Boolean.FALSE;
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        j4 = packageInfo.getLongVersionCode();
                    } else {
                        j4 = packageInfo.versionCode;
                    }
                    return Boolean.valueOf(j4 >= 1);
                } catch (PackageManager.NameNotFoundException unused) {
                    return Boolean.FALSE;
                } catch (Throwable th) {
                    be.c(th);
                    return Boolean.FALSE;
                }
            }
        };
        this.f26848c = zgVar;
    }

    @Override // com.bytedance.embedapplog.zg
    public boolean c(Context context) {
        if (context == null) {
            return false;
        }
        Boolean w3 = this.f26849w.w(context);
        if (this.f26848c != null && !w3.booleanValue()) {
            return this.f26848c.c(context);
        }
        return w3.booleanValue();
    }
}
