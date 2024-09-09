package org.repackage.com.meizu.flyme.openidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class f {

    /* renamed from: g  reason: collision with root package name */
    private static volatile f f61606g;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f61607h;

    /* renamed from: f  reason: collision with root package name */
    private BroadcastReceiver f61613f;

    /* renamed from: a  reason: collision with root package name */
    a f61608a = new a("udid");

    /* renamed from: b  reason: collision with root package name */
    a f61609b = new a(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);

    /* renamed from: d  reason: collision with root package name */
    a f61611d = new a("vaid");

    /* renamed from: c  reason: collision with root package name */
    a f61610c = new a("aaid");

    /* renamed from: e  reason: collision with root package name */
    private c f61612e = new c();

    private f() {
    }

    private static String b(PackageManager packageManager, String str) {
        ProviderInfo resolveContentProvider;
        if (packageManager == null || (resolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (resolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return resolveContentProvider.packageName;
    }

    private static d c(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.f61603a = cursor.getString(columnIndex);
            } else {
                e("parseValue fail, index < 0.");
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.f61604b = cursor.getInt(columnIndex2);
            } else {
                e("parseCode fail, index < 0.");
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.f61605c = cursor.getLong(columnIndex3);
            } else {
                e("parseExpired fail, index < 0.");
            }
            return dVar;
        } else {
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return dVar;
    }

    public static final f d() {
        if (f61606g == null) {
            synchronized (f.class) {
                if (f61606g == null) {
                    f61606g = new f();
                }
            }
        }
        return f61606g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(String str) {
        if (f61607h) {
            Log.d("OpenIdManager", str);
        }
    }

    public static void f(boolean z3) {
        f61607h = z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r7 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0033, code lost:
        if ("0".equals(r1.f61603a) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean g(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r3 = 0
            r4 = 0
            r8 = 1
            java.lang.String[] r5 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            java.lang.String r6 = "supported"
            r5[r0] = r6     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r7 == 0) goto L3a
            org.repackage.com.meizu.flyme.openidsdk.d r1 = c(r7)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            r2 = 1000(0x3e8, float:1.401E-42)
            int r3 = r1.f61604b     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r2 != r3) goto L35
            java.lang.String r2 = "0"
            java.lang.String r1 = r1.f61603a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L42
            if (r1 == 0) goto L36
        L35:
            r0 = 1
        L36:
            r7.close()
            return r0
        L3a:
            if (r7 == 0) goto L5b
        L3c:
            r7.close()
            goto L5b
        L40:
            r8 = move-exception
            goto L5c
        L42:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L40
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L40
            r1.append(r8)     // Catch: java.lang.Throwable -> L40
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L40
            e(r8)     // Catch: java.lang.Throwable -> L40
            if (r7 == 0) goto L5b
            goto L3c
        L5b:
            return r0
        L5c:
            if (r7 == 0) goto L61
            r7.close()
        L61:
            goto L63
        L62:
            throw r8
        L63:
            goto L62
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.f.g(android.content.Context):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String i(android.content.Context r10, org.repackage.com.meizu.flyme.openidsdk.a r11) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f61597c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r6 = r11.f61597c     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 == 0) goto L7e
            org.repackage.com.meizu.flyme.openidsdk.d r2 = c(r1)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r0 = r2.f61603a     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.c(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            long r3 = r2.f61605c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.b(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r3 = r2.f61604b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.a(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r4 = r11.f61597c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.append(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r11 = r11.f61598d     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.append(r11)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            e(r11)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r11 = r2.f61604b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L93
            r9.k(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            boolean r11 = r9.h(r10, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            if (r11 != 0) goto L93
            boolean r10 = r9.h(r10, r7)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
        L7a:
            e(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            goto L93
        L7e:
            boolean r11 = r9.h(r10, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            if (r11 == 0) goto L93
            boolean r10 = r9.h(r10, r7)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            goto L7a
        L93:
            if (r1 == 0) goto Lbf
            r1.close()
            goto Lbf
        L99:
            r10 = move-exception
            r0 = r1
            goto Lc0
        L9c:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto La4
        La0:
            r10 = move-exception
            goto Lc0
        La2:
            r10 = move-exception
            r11 = r0
        La4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> La0
            r1.append(r10)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> La0
            e(r10)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto Lbe
            r0.close()
        Lbe:
            r0 = r11
        Lbf:
            return r0
        Lc0:
            if (r0 == 0) goto Lc5
            r0.close()
        Lc5:
            goto Lc7
        Lc6:
            throw r10
        Lc7:
            goto Lc6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.meizu.flyme.openidsdk.f.i(android.content.Context, org.repackage.com.meizu.flyme.openidsdk.a):java.lang.String");
    }

    private static String j(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e4) {
            e4.printStackTrace();
            e("getAppVersion, Exception : " + e4.getMessage());
            return null;
        }
    }

    private synchronized void k(Context context) {
        if (this.f61613f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f61613f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else if (aVar.d()) {
            return aVar.f61596b;
        } else {
            if (h(context, true)) {
                return i(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        e(str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(Context context, boolean z3) {
        if (!this.f61612e.b() || z3) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            String b4 = b(packageManager, "com.meizu.flyme.openidsdk");
            if (TextUtils.isEmpty(b4)) {
                return false;
            }
            String j4 = j(packageManager, b4);
            if (this.f61612e.b() && this.f61612e.c(j4)) {
                e("use same version cache, safeVersion : ".concat(String.valueOf(j4)));
                return this.f61612e.e();
            }
            this.f61612e.d(j4);
            boolean g4 = g(context);
            e("query support, result : ".concat(String.valueOf(g4)));
            this.f61612e.a(g4);
            return g4;
        }
        return this.f61612e.e();
    }
}
