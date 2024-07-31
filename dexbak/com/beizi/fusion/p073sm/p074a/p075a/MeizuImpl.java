package com.beizi.fusion.p073sm.p074a.p075a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.fusion.sm.a.a.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MeizuImpl implements IOAID {

    /* renamed from: a */
    private final Context f11503a;

    public MeizuImpl(Context context) {
        this.f11503a = context;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        Context context = this.f11503a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null;
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11503a == null || iGetter == null) {
            return;
        }
        try {
            Cursor query = this.f11503a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            query.getClass();
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex(DomainCampaignEx.LOOPBACK_VALUE));
            if (string != null && string.length() != 0) {
                OAIDLog.m48130a("OAID query success: " + string);
                iGetter.mo48133a(string);
                query.close();
                return;
            }
            throw new OAIDException("OAID query failed");
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            iGetter.mo48134a(e);
        }
    }
}
