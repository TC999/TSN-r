package com.kwad.sdk.api.proxy.app;

import androidx.annotation.Keep;
import androidx.core.content.FileProvider;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
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
