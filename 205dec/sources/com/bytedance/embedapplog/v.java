package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.f;
import com.bytedance.embedapplog.xv;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class v extends xg<f> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public v() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.xg
    protected xv.w<f, String> c() {
        return new xv.w<f, String>() { // from class: com.bytedance.embedapplog.v.1
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public f c(IBinder iBinder) {
                return f.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public String c(f fVar) {
                return fVar.c();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xg
    protected Intent xv(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
