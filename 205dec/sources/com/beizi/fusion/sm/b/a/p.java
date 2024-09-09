package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;

/* compiled from: VivoImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class p implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15103a;

    public p(Context context) {
        this.f15103a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return com.beizi.fusion.sm.b.f.a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15103a == null || bVar == null) {
            return;
        }
        try {
            Cursor query = this.f15103a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
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
