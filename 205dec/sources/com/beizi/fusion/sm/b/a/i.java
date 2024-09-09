package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: MeizuImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class i implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15090a;

    public i(Context context) {
        this.f15090a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f15090a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15090a == null || bVar == null) {
            return;
        }
        try {
            Cursor query = this.f15090a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY}, null);
            query.getClass();
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("value"));
            if (string != null && string.length() != 0) {
                com.beizi.fusion.sm.b.e.a("OAID query success: " + string);
                bVar.a(string);
                query.close();
                return;
            }
            throw new com.beizi.fusion.sm.b.d("OAID query failed");
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            bVar.a(e4);
        }
    }
}
