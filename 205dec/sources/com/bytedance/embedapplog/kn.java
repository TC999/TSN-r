package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.r;
import com.bytedance.embedapplog.xv;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class kn extends xg<r> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public kn() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.xg
    protected xv.w<r, String> c() {
        return new xv.w<r, String>() { // from class: com.bytedance.embedapplog.kn.1
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public r c(IBinder iBinder) {
                return r.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public String c(r rVar) {
                if (rVar == null) {
                    return null;
                }
                return rVar.c();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xg
    protected Intent xv(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
