package com.kwad.sdk.api.proxy;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class BaseProxyService extends Service {
    private IServiceProxy mDelegate;
    private Context mNewBase;

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        this.mNewBase = context;
        this.mDelegate = getDelegate(context);
        super.attachBaseContext(Wrapper.wrapContextIfNeed(context));
    }

    @NonNull
    protected abstract IServiceProxy getDelegate(Context context);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        return this.mDelegate.onBind(this, intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDelegate.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDelegate.onDestroy(this);
        Wrapper.onDestroy(this.mNewBase);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        this.mDelegate.onRebind(this, intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null && intent != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        return this.mDelegate.onStartCommand(this, intent, i4, i5);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.mDelegate.onUnbind(this, intent);
    }

    public int superOnStartCommand(Intent intent, int i4, int i5) {
        return super.onStartCommand(intent, i4, i5);
    }

    public boolean superOnUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
