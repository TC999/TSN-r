package com.beizi.fusion.e.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.beizi.fusion.e.a.b;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MeizuDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f14701a;

    public e(Context context) {
        this.f14701a = context;
    }

    public void a(b.a aVar) {
        try {
            this.f14701a.getPackageManager().getPackageInfo("com.meizu.flyme.openidsdk", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Uri parse = Uri.parse("content://com.meizu.flyme.openidsdk/");
        try {
            Cursor query = this.f14701a.getContentResolver().query(parse, null, null, new String[]{AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY}, null);
            String a4 = a(query);
            if (aVar != null) {
                aVar.a(a4);
            }
            query.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
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
