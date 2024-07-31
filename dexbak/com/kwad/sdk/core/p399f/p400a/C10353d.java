package com.kwad.sdk.core.p399f.p400a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.crash.utils.C10738b;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: com.kwad.sdk.core.f.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10353d {
    private Context mContext;

    public C10353d(Context context) {
        this.mContext = context;
    }

    /* renamed from: f */
    private static String m26229f(Cursor cursor) {
        String str;
        str = "";
        if (cursor != null && !cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE);
            str = columnIndex > 0 ? cursor.getString(columnIndex) : "";
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 > 0) {
                cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 > 0) {
                cursor.getLong(columnIndex3);
            }
        }
        return str;
    }

    public final String getOAID() {
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            m26229f(query);
            C10738b.closeQuietly(query);
        } catch (Exception unused) {
            return "";
        }
    }
}
