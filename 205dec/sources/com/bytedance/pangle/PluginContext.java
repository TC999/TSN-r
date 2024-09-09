package com.bytedance.pangle;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class PluginContext extends f {
    private LayoutInflater mInflater;
    public boolean mIsHostApplicationContext;
    public Context mOriginContext;
    private Configuration mOverrideConfiguration;
    public Plugin mPlugin;

    public PluginContext() {
    }

    public static Context getContextWithoutTheme(Context context) {
        while (true) {
            if (context instanceof ContextThemeWrapper) {
                context = ((ContextThemeWrapper) context).getBaseContext();
            } else if (!(context instanceof androidx.appcompat.view.ContextThemeWrapper)) {
                return context;
            } else {
                context = ((androidx.appcompat.view.ContextThemeWrapper) context).getBaseContext();
            }
        }
    }

    @RequiresApi(api = 17)
    private Resources getResourcesInternal() {
        return this.mPlugin.mResources;
    }

    public static int getThemeResourceId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            try {
                return ((Integer) FieldUtils.readField(context, "mThemeResource")).intValue();
            } catch (IllegalAccessException e4) {
                e4.printStackTrace();
            }
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.mPlugin.mResources == null) {
            if (this.mOverrideConfiguration == null) {
                this.mOverrideConfiguration = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        Context createConfigurationContext = super.createConfigurationContext(configuration);
        try {
            try {
                FieldUtils.writeField(createConfigurationContext, "mResources", this.mPlugin.mResources);
            } catch (Throwable unused) {
                com.bytedance.pangle.b.b.a.a(createConfigurationContext.getClass(), "mResources").set(createConfigurationContext, this.mPlugin.mResources);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return createConfigurationContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context context = this.mOriginContext;
        return context instanceof PluginApplicationWrapper ? context : ZeusTransformUtils.wrapperContext(StubApp.getOrigApplicationContext(context.getApplicationContext()), this.mPlugin.mPkgName);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mPlugin.mHostApplicationInfoHookSomeField;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mPlugin.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        return baseContext instanceof ContextWrapper ? ((ContextWrapper) baseContext).getBaseContext() : baseContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mPlugin.mClassLoader;
    }

    public Configuration getOverrideConfiguration() {
        return this.mOverrideConfiguration;
    }

    public String getPluginPackageName() {
        return this.mPlugin.mPkgName;
    }

    @Override // com.bytedance.pangle.f
    protected String getPluginPkg() {
        return this.mPlugin.mPkgName;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mPlugin.mResources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mInflater == null) {
                LayoutInflater cloneInContext = LayoutInflater.from(getBaseContext()).cloneInContext(this);
                this.mInflater = cloneInContext;
                com.bytedance.pangle.res.b.a(cloneInContext);
            }
            return this.mInflater;
        }
        Context context = this.mOriginContext;
        if (context != null) {
            return context.getSystemService(str);
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.registerComponentCallbacks(componentCallbacks);
        } else {
            super.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.unregisterComponentCallbacks(componentCallbacks);
        } else {
            super.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    public PluginContext(Context context, Plugin plugin, boolean z3) {
        super(getContextWithoutTheme(context), getThemeResourceId(context));
        this.mPlugin = plugin;
        this.mOriginContext = context;
        this.mIsHostApplicationContext = z3;
    }
}
