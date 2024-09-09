package com.bytedance.android.openliveplugin.process.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformServerManager;
import com.bytedance.android.dy.sdk.pangle.ZeusPlatformUtils;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class LiveServerManager extends ZeusPlatformServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        TTLogger.d("LiveServerManager onCreate");
        Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
        if (origApplicationContext instanceof Application) {
            TTLogger.d("LiveServerManager initZeus");
            ZeusPlatformUtils.initZeus((Application) origApplicationContext, true, "com.byted.live.lite");
        }
        return super.onCreate();
    }
}
