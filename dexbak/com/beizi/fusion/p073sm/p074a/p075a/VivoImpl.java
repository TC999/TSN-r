package com.beizi.fusion.p073sm.p074a.p075a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;
import com.beizi.fusion.p073sm.p074a.OAIDRom;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.fusion.sm.a.a.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class VivoImpl implements IOAID {

    /* renamed from: a */
    private final Context f11516a;

    public VivoImpl(Context context) {
        this.f11516a = context;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return OAIDRom.m48127a("persist.sys.identifierid.supported", "0").equals("1");
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11516a == null || iGetter == null) {
            return;
        }
        try {
            Cursor query = this.f11516a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
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
