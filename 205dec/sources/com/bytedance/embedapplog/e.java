package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import com.bytedance.embedapplog.p;
import com.bytedance.embedapplog.xv;
import com.bytedance.embedapplog.zg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class e extends xg<p> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.xg
    protected xv.w<p, String> c() {
        return new xv.w<p, String>() { // from class: com.bytedance.embedapplog.e.1
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public p c(IBinder iBinder) {
                return p.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public String c(p pVar) {
                if (pVar == null) {
                    return null;
                }
                return pVar.c();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xg, com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        c(context, context.getPackageName());
        return super.w(context);
    }

    @Override // com.bytedance.embedapplog.xg
    protected Intent xv(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, context.getPackageName());
        return intent;
    }

    private void c(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e4) {
            be.c(e4);
        }
    }
}
