package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.ev;
import com.bytedance.embedapplog.xv;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ba extends xg<ev> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ba() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.xg
    protected xv.w<ev, String> c() {
        return new xv.w<ev, String>() { // from class: com.bytedance.embedapplog.ba.1
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public ev c(IBinder iBinder) {
                return ev.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public String c(ev evVar) {
                if (evVar == null) {
                    return null;
                }
                return evVar.xv();
            }
        };
    }

    @Override // com.bytedance.embedapplog.xg
    protected Intent xv(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
