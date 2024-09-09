package XI.xo.XI.XI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.Cursor;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class CA {
    public static volatile CA J9;
    public BroadcastReceiver vs;

    /* renamed from: XI  reason: collision with root package name */
    public XI f83XI = new XI("udid");
    public XI K0 = new XI(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);
    public XI xo = new XI("vaid");
    public XI kM = new XI("aaid");
    public K0 CA = new K0();

    public static final CA XI() {
        if (J9 == null) {
            synchronized (CA.class) {
                if (J9 == null) {
                    J9 = new CA();
                }
            }
        }
        return J9;
    }

    public static kM XI(Cursor cursor) {
        kM kMVar = new kM(null, 0);
        if (cursor.isClosed()) {
            return kMVar;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            kMVar.f86XI = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            kMVar.K0 = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            kMVar.kM = cursor.getLong(columnIndex3);
        }
        return kMVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String XI(android.content.Context r14, XI.xo.XI.XI.XI r15) {
        /*
            r13 = this;
            r0 = 0
            if (r15 != 0) goto L4
            return r0
        L4:
            long r1 = r15.f85XI
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 0
            r6 = 1
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L12
            r1 = 1
            goto L13
        L12:
            r1 = 0
        L13:
            if (r1 == 0) goto L18
            java.lang.String r14 = r15.K0
            return r14
        L18:
            boolean r1 = r13.XI(r14, r6)
            if (r1 != 0) goto L1f
            return r0
        L1f:
            java.lang.String r1 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r8 = android.net.Uri.parse(r1)
            android.content.ContentResolver r7 = r14.getContentResolver()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            r9 = 0
            r10 = 0
            java.lang.String[] r11 = new java.lang.String[r6]     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            java.lang.String r1 = r15.kM     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            r11[r5] = r1     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            r12 = 0
            android.database.Cursor r1 = r7.query(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L87
            if (r1 == 0) goto L66
            XI.xo.XI.XI.kM r2 = XI(r1)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r0 = r2.f86XI     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.K0 = r0     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            long r3 = r2.kM     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.f85XI = r3     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            int r3 = r2.K0     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.xo = r3     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            int r15 = r2.K0     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r15 == r2) goto L7b
            r13.XI(r14)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            boolean r15 = r13.XI(r14, r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            if (r15 != 0) goto L7b
            boolean r14 = r13.XI(r14, r6)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.<init>()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r2 = "not support, forceQuery isSupported: "
        L62:
            r15.append(r2)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            goto L78
        L66:
            boolean r15 = r13.XI(r14, r5)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            if (r15 == 0) goto L7b
            boolean r14 = r13.XI(r14, r6)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            r15.<init>()     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
            java.lang.String r2 = "forceQuery isSupported : "
            goto L62
        L78:
            r15.append(r14)     // Catch: java.lang.Throwable -> L7e java.lang.Exception -> L81
        L7b:
            if (r1 == 0) goto L95
            goto L90
        L7e:
            r14 = move-exception
            r0 = r1
            goto L96
        L81:
            r14 = move-exception
            r15 = r0
            r0 = r1
            goto L89
        L85:
            r14 = move-exception
            goto L96
        L87:
            r14 = move-exception
            r15 = r0
        L89:
            r14.getMessage()     // Catch: java.lang.Throwable -> L85
            if (r0 == 0) goto L94
            r1 = r0
            r0 = r15
        L90:
            r1.close()
            goto L95
        L94:
            r0 = r15
        L95:
            return r0
        L96:
            if (r0 == 0) goto L9b
            r0.close()
        L9b:
            goto L9d
        L9c:
            throw r14
        L9d:
            goto L9c
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.xo.XI.XI.CA.XI(android.content.Context, XI.xo.XI.XI.XI):java.lang.String");
    }

    public final synchronized void XI(Context context) {
        if (this.vs != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        xo xoVar = new xo();
        this.vs = xoVar;
        context.registerReceiver(xoVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ad, code lost:
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00b6, code lost:
        if (r1 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b8, code lost:
        r1.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean XI(android.content.Context r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.xo.XI.XI.CA.XI(android.content.Context, boolean):boolean");
    }
}
