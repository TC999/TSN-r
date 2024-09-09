package cn.jiguang.o;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f3748a;

    public a(Context context) {
        this.f3748a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[Catch: Exception -> 0x0071, TryCatch #0 {Exception -> 0x0071, blocks: (B:14:0x0045, B:16:0x0055, B:18:0x005b, B:19:0x0067, B:20:0x006b, B:9:0x000d, B:11:0x0038, B:10:0x0023, B:12:0x003d), top: B:25:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[Catch: Exception -> 0x0071, TRY_LEAVE, TryCatch #0 {Exception -> 0x0071, blocks: (B:14:0x0045, B:16:0x0055, B:18:0x005b, B:19:0x0067, B:20:0x006b, B:9:0x000d, B:11:0x0038, B:10:0x0023, B:12:0x003d), top: B:25:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "VivoDB"
            r1 = 0
            if (r9 == 0) goto L3d
            r2 = 1
            if (r9 == r2) goto L23
            r2 = 2
            if (r9 == r2) goto Ld
            r3 = r1
            goto L45
        Ld:
            java.lang.String r9 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1FXRr9EgPkoDQnyVgIu2tARnCHNUAAn6DU1ZkzxwPHKA=="
            java.lang.String r9 = cn.jiguang.ah.d.f(r9)     // Catch: java.lang.Exception -> L71
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L71
            r2.<init>()     // Catch: java.lang.Exception -> L71
            r2.append(r9)     // Catch: java.lang.Exception -> L71
            r2.append(r10)     // Catch: java.lang.Exception -> L71
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Exception -> L71
            goto L38
        L23:
            java.lang.String r9 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1mRRRjMzvkebo9eb3zqoVhCi2GjcOItUY/+C68T3lxGg=="
            java.lang.String r9 = cn.jiguang.ah.d.f(r9)     // Catch: java.lang.Exception -> L71
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L71
            r2.<init>()     // Catch: java.lang.Exception -> L71
            r2.append(r9)     // Catch: java.lang.Exception -> L71
            r2.append(r10)     // Catch: java.lang.Exception -> L71
            java.lang.String r9 = r2.toString()     // Catch: java.lang.Exception -> L71
        L38:
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch: java.lang.Exception -> L71
            goto L44
        L3d:
            java.lang.String r9 = "HDjJBOCwNx0aZi+Z7p83oR6X29bt13JSzReihhERik1zTqeaHqknpahXd0Fww8QTTjy7MHX7/1f2JKNuxQ9omA=="
            java.lang.String r9 = cn.jiguang.ah.d.f(r9)     // Catch: java.lang.Exception -> L71
            goto L38
        L44:
            r3 = r9
        L45:
            android.content.Context r9 = r8.f3748a     // Catch: java.lang.Exception -> L71
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Exception -> L71
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> L71
            if (r9 == 0) goto L6b
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Exception -> L71
            if (r10 == 0) goto L67
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Exception -> L71
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Exception -> L71
            r1 = r10
        L67:
            r9.close()     // Catch: java.lang.Exception -> L71
            goto L8a
        L6b:
            java.lang.String r9 = "return cursor is null,return"
            cn.jiguang.w.a.b(r0, r9)     // Catch: java.lang.Exception -> L71
            goto L8a
        L71:
            r9 = move-exception
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r2 = "get id error: "
            r10.append(r2)
            java.lang.String r9 = r9.getMessage()
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            cn.jiguang.w.a.f(r0, r9)
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.o.a.a(int, java.lang.String):java.lang.String");
    }
}
