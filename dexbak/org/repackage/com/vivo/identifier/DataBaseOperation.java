package org.repackage.com.vivo.identifier;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

/* renamed from: org.repackage.com.vivo.identifier.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DataBaseOperation {

    /* renamed from: b */
    private static final String f44194b = "VMS_SDK_DB";

    /* renamed from: c */
    private static final String f44195c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d */
    private static final String f44196d = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: e */
    private static final String f44197e = "value";

    /* renamed from: f */
    private static final String f44198f = "OAID";

    /* renamed from: g */
    private static final String f44199g = "AAID";

    /* renamed from: h */
    private static final String f44200h = "VAID";

    /* renamed from: i */
    private static final String f44201i = "OAIDBLACK";

    /* renamed from: j */
    private static final String f44202j = "OAIDSTATUS";

    /* renamed from: k */
    private static final String f44203k = "STATISTICS";

    /* renamed from: l */
    private static final int f44204l = 0;

    /* renamed from: m */
    private static final int f44205m = 1;

    /* renamed from: n */
    private static final int f44206n = 2;

    /* renamed from: o */
    private static final int f44207o = 3;

    /* renamed from: p */
    private static final int f44208p = 4;

    /* renamed from: q */
    private static final int f44209q = 5;

    /* renamed from: r */
    private static final int f44210r = 6;

    /* renamed from: s */
    private static final int f44211s = 7;

    /* renamed from: t */
    private static final String f44212t = "UDID";

    /* renamed from: a */
    private Context f44213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataBaseOperation(Context context) {
        this.f44213a = context;
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m2765a(int r9, java.lang.String r10) {
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
            android.content.Context r9 = r8.f44213a     // Catch: java.lang.Throwable -> L9d java.lang.Exception -> L9f
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
        throw new UnsupportedOperationException("Method not decompiled: org.repackage.com.vivo.identifier.DataBaseOperation.m2765a(int, java.lang.String):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean m2764b(int i, String str, String str2, String str3) {
        Uri parse;
        int delete;
        if (i != 6) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            delete = this.f44213a.getContentResolver().delete(parse, "packageName=? and uid=?", new String[]{str2, str3});
            Log.d(f44194b, "delete:" + delete);
        } catch (Exception unused) {
            Log.e(f44194b, "return delete is error");
        }
        return delete != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m2763c(int i, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        int bulkInsert;
        if (i == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.f44213a.getContentResolver().bulkInsert(parse, contentValuesArr);
            Log.d(f44194b, "insert:" + bulkInsert);
        } catch (Exception unused) {
            Log.e(f44194b, "return insert is error");
        }
        return bulkInsert != 0;
    }
}
