package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DataBaseOperation.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f61620b = "VMS_SDK_DB";

    /* renamed from: c  reason: collision with root package name */
    private static final String f61621c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d  reason: collision with root package name */
    private static final String f61622d = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: e  reason: collision with root package name */
    private static final String f61623e = "value";

    /* renamed from: f  reason: collision with root package name */
    private static final String f61624f = "OAID";

    /* renamed from: g  reason: collision with root package name */
    private static final String f61625g = "AAID";

    /* renamed from: h  reason: collision with root package name */
    private static final String f61626h = "VAID";

    /* renamed from: i  reason: collision with root package name */
    private static final String f61627i = "OAIDBLACK";

    /* renamed from: j  reason: collision with root package name */
    private static final String f61628j = "OAIDSTATUS";

    /* renamed from: k  reason: collision with root package name */
    private static final String f61629k = "STATISTICS";

    /* renamed from: l  reason: collision with root package name */
    private static final int f61630l = 0;

    /* renamed from: m  reason: collision with root package name */
    private static final int f61631m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f61632n = 2;

    /* renamed from: o  reason: collision with root package name */
    private static final int f61633o = 3;

    /* renamed from: p  reason: collision with root package name */
    private static final int f61634p = 4;

    /* renamed from: q  reason: collision with root package name */
    private static final int f61635q = 5;

    /* renamed from: r  reason: collision with root package name */
    private static final int f61636r = 6;

    /* renamed from: s  reason: collision with root package name */
    private static final int f61637s = 7;

    /* renamed from: t  reason: collision with root package name */
    private static final String f61638t = "UDID";

    /* renamed from: a  reason: collision with root package name */
    private Context f61639a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f61639a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
        if (r9 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0099, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a5, code lost:
        if (r9 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a8, code lost:
        return r1;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r9v13, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r9v16, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r9v18, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r9v21, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r9v23, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r9v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "VMS_SDK_DB"
            r1 = 0
            if (r9 == 0) goto L66
            r2 = 1
            if (r9 == r2) goto L50
            r2 = 2
            if (r9 == r2) goto L3a
            r2 = 3
            if (r9 == r2) goto L33
            r2 = 4
            if (r9 == r2) goto L1d
            r10 = 5
            if (r9 == r10) goto L16
            r3 = r1
            goto L6d
        L16:
            java.lang.String r9 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L1d:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L33:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L3a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L50:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r9.append(r2)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L6c
        L66:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
        L6c:
            r3 = r9
        L6d:
            if (r3 != 0) goto L70
            return r1
        L70:
            android.content.Context r9 = r8.f61639a     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            android.content.ContentResolver r2 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
            if (r9 == 0) goto L92
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> La9
            if (r10 == 0) goto L97
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> La9
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> La9
            r1 = r10
            goto L97
        L92:
            java.lang.String r10 = "return cursor is null,return"
            android.util.Log.d(r0, r10)     // Catch: java.lang.Exception -> La0 java.lang.Throwable -> La9
        L97:
            if (r9 == 0) goto La8
        L99:
            r9.close()
            goto La8
        L9d:
            r10 = move-exception
            goto Lab
        L9f:
            r9 = r1
        La0:
            java.lang.String r10 = "return cursor is error"
            android.util.Log.e(r0, r10)     // Catch: java.lang.Throwable -> La9
            if (r9 == 0) goto La8
            goto L99
        La8:
            return r1
        La9:
            r10 = move-exception
            r1 = r9
        Lab:
            if (r1 == 0) goto Lb0
            r1.close()
        Lb0:
            goto Lb2
        Lb1:
            throw r10
        Lb2:
            goto Lb1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.vivo.identifier.b.a(int, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i4, String str, String str2, String str3) {
        Uri parse;
        int delete;
        if (i4 != 6) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            delete = this.f61639a.getContentResolver().delete(parse, "packageName=? and uid=?", new String[]{str2, str3});
            Log.d("VMS_SDK_DB", "delete:" + delete);
        } catch (Exception unused) {
            Log.e("VMS_SDK_DB", "return delete is error");
        }
        return delete != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i4, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        int bulkInsert;
        if (i4 == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i4 != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.f61639a.getContentResolver().bulkInsert(parse, contentValuesArr);
            Log.d("VMS_SDK_DB", "insert:" + bulkInsert);
        } catch (Exception unused) {
            Log.e("VMS_SDK_DB", "return insert is error");
        }
        return bulkInsert != 0;
    }
}
