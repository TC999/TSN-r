package com.bytedance.sdk.openadsdk.stub.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.xv.xv;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MainServerManager extends AbsServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
        TTAppContextHolder.setContext(origApplicationContext);
        if (origApplicationContext instanceof Application) {
            ((Application) origApplicationContext).registerActivityLifecycleCallbacks(xv.c().w());
        }
        return super.onCreate();
    }
}
