package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.bytedance.embedapplog.lf;
import com.bytedance.embedapplog.xv;
import com.bytedance.embedapplog.zg;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class lw extends xg<lf> {

    /* renamed from: c  reason: collision with root package name */
    final eb f26760c;

    /* renamed from: w  reason: collision with root package name */
    final rh f26761w;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lw() {
        super("com.hihonor.id");
        this.f26760c = new eb();
        this.f26761w = new rh();
    }

    @Override // com.bytedance.embedapplog.xg, com.bytedance.embedapplog.zg
    public /* bridge */ /* synthetic */ boolean c(Context context) {
        return super.c(context);
    }

    @Override // com.bytedance.embedapplog.xg, com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        new xv(context, xv(context), c()).c();
        zg.c cVar = new zg.c();
        cVar.f26861w = this.f26760c.w();
        cVar.xv = this.f26761w.w();
        return cVar;
    }

    @Override // com.bytedance.embedapplog.xg
    protected Intent xv(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.embedapplog.xg
    protected xv.w<lf, String> c() {
        return new xv.w<lf, String>() { // from class: com.bytedance.embedapplog.lw.1
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public lf c(IBinder iBinder) {
                return lf.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public String c(lf lfVar) {
                if (lfVar == null) {
                    Log.e("honor# ", "service is null");
                    return null;
                }
                Log.d("honor# ", "service.get is start");
                lfVar.c(lw.this.f26760c);
                lfVar.w(lw.this.f26761w);
                Log.d("honor# ", "service.get is end");
                return "";
            }
        };
    }
}
