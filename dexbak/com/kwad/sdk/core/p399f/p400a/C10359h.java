package com.kwad.sdk.core.p399f.p400a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.kwad.sdk.crash.utils.C10738b;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: com.kwad.sdk.core.f.a.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10359h {
    private Context mContext;

    public C10359h(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        String str = "";
        Cursor cursor = null;
        try {
            cursor = this.mContext.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursor != null && cursor.moveToNext()) {
                str = cursor.getString(cursor.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE));
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            C10738b.closeQuietly(cursor);
            throw th;
        }
        C10738b.closeQuietly(cursor);
        return str;
    }
}
