package com.kwad.sdk.api.proxy.app;

import androidx.annotation.Keep;
import androidx.core.content.FileProvider;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.stub.StubApp;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class AdSdkFileProvider extends FileProvider {
    public static long sLaunchTime;

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        sLaunchTime = System.currentTimeMillis();
        try {
            KSLifecycleObserver.getInstance().init(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        } catch (Throwable unused) {
        }
        return super.onCreate();
    }
}
