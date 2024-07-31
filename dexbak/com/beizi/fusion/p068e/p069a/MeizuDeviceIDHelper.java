package com.beizi.fusion.p068e.p069a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* renamed from: com.beizi.fusion.e.a.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MeizuDeviceIDHelper {

    /* renamed from: a */
    private Context f11183a;

    public MeizuDeviceIDHelper(Context context) {
        this.f11183a = context;
    }

    /* renamed from: a */
    public void m48558a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        try {
            this.f11183a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Cursor query = this.f11183a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            String m48559a = m48559a(query);
            if (interfaceC3094a != null) {
                interfaceC3094a.mo48445a(m48559a);
            }
            query.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private String m48559a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE);
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }
}
