package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.C9702c;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.api.core.KSLifecycleObserver;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.proxy.IComponentProxy;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class Loader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    /* renamed from: JB */
    private final AtomicBoolean f29509JB;
    private IKsAdSDK amG;
    private C9729k amH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.Loader$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9708a {
        private static final Loader amI = new Loader((byte) 0);
    }

    /* synthetic */ Loader(byte b) {
        this();
    }

    /* renamed from: Ah */
    private static void m28005Ah() {
        try {
            int m28011zX = C9702c.m28011zX();
            if (m28011zX > 0) {
                C9718d.m27947ay(mContext).setDefaultUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler());
                Thread.setDefaultUncaughtExceptionHandler(C9718d.m27947ay(mContext));
                C9718d.m27947ay(mContext).m27946bW(m28011zX);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @MainThread
    /* renamed from: a */
    public static synchronized IKsAdSDK m28004a(ClassLoader classLoader) {
        IKsAdSDK iKsAdSDK;
        synchronized (Loader.class) {
            try {
                Object invoke = Class.forName(((KsAdSdkDynamicApi) IKsAdSDK.class.getAnnotation(KsAdSdkDynamicApi.class)).value(), true, classLoader).getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
                if (invoke != null) {
                    iKsAdSDK = (IKsAdSDK) invoke;
                } else {
                    throw new RuntimeException("Can not get sdk form " + classLoader);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return iKsAdSDK;
    }

    /* renamed from: aD */
    private boolean m28003aD(Context context) {
        try {
            String m27934az = C9723g.m27934az(context);
            String m27936aA = C9723g.m27936aA(context);
            if (TextUtils.isEmpty(m27934az) && TextUtils.isEmpty(m27936aA)) {
                return false;
            }
            if (!TextUtils.isEmpty(m27936aA) && C9723g.m27937K(m27936aA, m27934az)) {
                C9723g.m27932m(context, m27936aA);
                m28001w(context, m27934az);
                C9723g.m27931n(context, "");
                m27934az = m27936aA;
            }
            return !TextUtils.isEmpty(m27934az);
        } catch (Throwable th) {
            C9702c.m28016m(th);
            return false;
        }
    }

    /* renamed from: aE */
    private static void m28002aE(Context context) {
        try {
            String m27935aB = C9723g.m27935aB(context);
            boolean m27842b = C9757t.m27842b(context, C9723g.amm, false);
            if (TextUtils.isEmpty(m27935aB) || !m27935aB.equals(BuildConfig.VERSION_NAME) || m27842b) {
                String m27934az = C9723g.m27934az(context);
                C9723g.m27932m(context, "");
                C9723g.m27931n(context, "");
                C9757t.m27845a(context, C9723g.amm, false);
                C9724h.m27926j(C9724h.m27923r(context, m27934az));
                C9723g.m27930o(context, BuildConfig.VERSION_NAME);
            }
        } catch (Throwable th) {
            C9702c.m28016m(th);
        }
    }

    public static void checkInitSDK(Context context) {
        if (KsAdSDK.sHasInit.get()) {
            return;
        }
        if (context == null) {
            context = KSLifecycleObserver.getInstance().getApplication();
        }
        KsAdSDK.init(context, SdkConfig.create(C9757t.getString(context, "sdkconfig")));
    }

    public static Loader get() {
        return C9708a.amI;
    }

    /* renamed from: w */
    private static void m28001w(Context context, String str) {
        C9724h.m27919v(context, str);
    }

    public Context getContext() {
        return mContext;
    }

    @MainThread
    public ClassLoader getExternalClassLoader() {
        C9729k c9729k = this.amH;
        if (c9729k != null) {
            return c9729k.getClassLoader();
        }
        return null;
    }

    @MainThread
    public Resources getExternalResource() {
        C9729k c9729k = this.amH;
        if (c9729k != null) {
            return c9729k.m27893Ae();
        }
        return null;
    }

    public ClassLoader getRealClassLoader() {
        C9729k c9729k = this.amH;
        if (c9729k != null) {
            return c9729k.getClassLoader();
        }
        return getClass().getClassLoader();
    }

    public IKsAdSDK init(@NonNull Context context, ClassLoader classLoader) {
        if (this.f29509JB.get()) {
            return this.amG;
        }
        mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        m28002aE(context);
        if (m28003aD(context)) {
            this.amH = C9729k.m27889a(context, classLoader, C9723g.m27934az(context));
        }
        C9729k c9729k = this.amH;
        if (c9729k == null) {
            IKsAdSDK m28004a = m28004a(getClass().getClassLoader());
            this.amG = m28004a;
            m28004a.setIsExternal(false);
        } else {
            IKsAdSDK m27892Af = c9729k.m27892Af();
            this.amG = m27892Af;
            m27892Af.setIsExternal(true);
        }
        C9702c.m28020a(this.amG);
        if (this.amH != null) {
            m28005Ah();
        }
        this.f29509JB.set(true);
        return this.amG;
    }

    public boolean isExternalLoaded() {
        return this.amH != null;
    }

    @MainThread
    public <T extends IComponentProxy> T newComponentProxy(Context context, Class<?> cls, Object obj) {
        checkInitSDK(context);
        return (T) this.amG.newComponentProxy(cls, obj);
    }

    @MainThread
    public <T> T newInstance(Class<T> cls) {
        checkInitSDK(mContext);
        return (T) this.amG.newInstance(cls);
    }

    public void rest() {
        this.f29509JB.set(false);
        mContext = null;
        this.amG = null;
        this.amH = null;
    }

    private Loader() {
        this.amH = null;
        this.f29509JB = new AtomicBoolean(false);
    }
}
