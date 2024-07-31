package com.bytedance.android.openliveplugin.process.server;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.openliveplugin.stub.logger.TTLogger;
import com.bytedance.android.p112dy.sdk.pangle.ZeusPlatformServerManager;
import com.bytedance.android.p112dy.sdk.pangle.ZeusPlatformUtils;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LiveServerManager extends ZeusPlatformServerManager {
    @Override // com.bytedance.pangle.servermanager.AbsServerManager, android.content.ContentProvider
    public boolean onCreate() {
        TTLogger.m37909d("LiveServerManager onCreate");
        Context origApplicationContext = StubApp.getOrigApplicationContext(getContext().getApplicationContext());
        if (origApplicationContext instanceof Application) {
            TTLogger.m37909d("LiveServerManager initZeus");
            ZeusPlatformUtils.initZeus((Application) origApplicationContext, true, "com.byted.live.lite");
        }
        return super.onCreate();
    }
}
