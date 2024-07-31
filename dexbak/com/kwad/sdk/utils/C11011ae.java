package com.kwad.sdk.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;

/* renamed from: com.kwad.sdk.utils.ae */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11011ae {
    private static String aPp;
    private static boolean aPq;

    /* renamed from: ci */
    public static String m24139ci(Context context) {
        if (TextUtils.isEmpty(aPp) && !aPq && C11027at.m24079Me()) {
            Cursor cursor = null;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://com.xiaomi.market.provider.DirectMailProvider"), null, null, null, null);
                aPp = m24138k(cursor);
            } catch (Throwable unused) {
            }
            C10738b.closeQuietly(cursor);
            aPq = TextUtils.isEmpty(aPp);
            return aPp;
        }
        return aPp;
    }

    /* renamed from: k */
    private static String m24138k(Cursor cursor) {
        int columnIndex;
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex2 = cursor.getColumnIndex("support");
            return ((columnIndex2 <= 0 || cursor.getInt(columnIndex2) != 0) && (columnIndex = cursor.getColumnIndex("detailStyle")) > 0) ? cursor.getString(columnIndex) : "";
        }
        C10331c.m26248i("MiMarketHelper", "cursor is null");
        return "";
    }
}
