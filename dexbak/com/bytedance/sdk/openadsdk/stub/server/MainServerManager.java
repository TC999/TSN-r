package com.bytedance.sdk.openadsdk.stub.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.p175ok.C6500bl;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MainServerManager extends AbsServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
        TTAppContextHolder.setContext(origApplicationContext);
        if (origApplicationContext instanceof Application) {
            ((Application) origApplicationContext).registerActivityLifecycleCallbacks(C6500bl.m36198ok().m36199a());
        }
        return super.onCreate();
    }
}
