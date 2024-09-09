package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.embedapplog.ux;
import com.bytedance.embedapplog.xv;
import com.bytedance.embedapplog.zg;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class tl extends xg<ux> {

    /* renamed from: c  reason: collision with root package name */
    private final Context f26804c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public tl(Context context) {
        super("com.coolpad.deviceidsupport");
        this.f26804c = context;
    }

    @Override // com.bytedance.embedapplog.xg, com.bytedance.embedapplog.zg
    public zg.c w(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                zg.c cVar = new zg.c();
                cVar.f26861w = string;
                return cVar;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.w(context);
    }

    @Override // com.bytedance.embedapplog.xg
    protected Intent xv(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.xg, com.bytedance.embedapplog.zg
    public /* bridge */ /* synthetic */ boolean c(Context context) {
        return super.c(context);
    }

    @Override // com.bytedance.embedapplog.xg
    protected xv.w<ux, String> c() {
        return new xv.w<ux, String>() { // from class: com.bytedance.embedapplog.tl.1
            @Override // com.bytedance.embedapplog.xv.w
            /* renamed from: w */
            public ux c(IBinder iBinder) {
                return ux.c.c(iBinder);
            }

            @Override // com.bytedance.embedapplog.xv.w
            public String c(ux uxVar) {
                if (uxVar == null) {
                    return null;
                }
                return uxVar.w(tl.this.f26804c.getPackageName());
            }
        };
    }
}
