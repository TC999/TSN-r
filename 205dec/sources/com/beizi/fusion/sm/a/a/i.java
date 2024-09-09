package com.beizi.fusion.sm.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* compiled from: MeizuImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class i implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15053a;

    public i(Context context) {
        this.f15053a = context;
    }

    @Override // com.beizi.fusion.sm.a.d
    public boolean a() {
        Context context = this.f15053a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        if (this.f15053a == null || cVar == null) {
            return;
        }
        try {
            Cursor query = this.f15053a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY}, null);
            query.getClass();
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("value"));
            if (string != null && string.length() != 0) {
                com.beizi.fusion.sm.a.f.a("OAID query success: " + string);
                cVar.a(string);
                query.close();
                return;
            }
            throw new com.beizi.fusion.sm.a.e("OAID query failed");
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            cVar.a(e4);
        }
    }
}
