package com.bytedance.sdk.openadsdk.core.multipro.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class BinderPoolService extends Service {

    /* renamed from: c  reason: collision with root package name */
    private Binder f33902c = new c.BinderC0498c();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a.w("MultiProcess", "BinderPoolService onBind ! ");
        return this.f33902c;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a.w("MultiProcess", "BinderPoolService has been created ! ");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        a.w("MultiProcess", "BinderPoolService is destroy ! ");
    }
}
