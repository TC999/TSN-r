package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.C3558j;
import com.bumptech.glide.Glide;
import com.bumptech.glide.util.C3770j;
import com.bumptech.glide.util.C3771k;
import com.stub.StubApp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.manager.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestManagerRetriever implements Handler.Callback {
    @VisibleForTesting

    /* renamed from: i */
    static final String f14289i = "com.bumptech.glide.manager";

    /* renamed from: j */
    private static final String f14290j = "RMRetriever";

    /* renamed from: k */
    private static final int f14291k = 1;

    /* renamed from: l */
    private static final int f14292l = 2;

    /* renamed from: m */
    private static final String f14293m = "key";

    /* renamed from: n */
    private static final InterfaceC3740b f14294n = new C3739a();

    /* renamed from: a */
    private volatile C3558j f14295a;

    /* renamed from: d */
    private final Handler f14298d;

    /* renamed from: e */
    private final InterfaceC3740b f14299e;
    @VisibleForTesting

    /* renamed from: b */
    final Map<FragmentManager, RequestManagerFragment> f14296b = new HashMap();
    @VisibleForTesting

    /* renamed from: c */
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f14297c = new HashMap();

    /* renamed from: f */
    private final ArrayMap<View, Fragment> f14300f = new ArrayMap<>();

    /* renamed from: g */
    private final ArrayMap<View, android.app.Fragment> f14301g = new ArrayMap<>();

    /* renamed from: h */
    private final Bundle f14302h = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: com.bumptech.glide.manager.l$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3739a implements InterfaceC3740b {
        C3739a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerRetriever.InterfaceC3740b
        @NonNull
        /* renamed from: a */
        public C3558j mo44727a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new C3558j(glide, lifecycle, requestManagerTreeNode, context);
        }
    }

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: com.bumptech.glide.manager.l$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3740b {
        @NonNull
        /* renamed from: a */
        C3558j mo44727a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public RequestManagerRetriever(@Nullable InterfaceC3740b interfaceC3740b) {
        this.f14299e = interfaceC3740b == null ? f14294n : interfaceC3740b;
        this.f14298d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    /* renamed from: a */
    private static void m44748a(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    /* renamed from: b */
    private Activity m44747b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m44747b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    /* renamed from: c */
    private void m44746c(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    m44746c(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        m44745d(fragmentManager, arrayMap);
    }

    @Deprecated
    /* renamed from: d */
    private void m44745d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            this.f14302h.putInt("key", i);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f14302h, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                m44746c(fragment.getChildFragmentManager(), arrayMap);
            }
            i = i2;
        }
    }

    /* renamed from: e */
    private static void m44744e(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                m44744e(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    /* renamed from: f */
    private android.app.Fragment m44743f(@NonNull View view, @NonNull Activity activity) {
        this.f14301g.clear();
        m44746c(activity.getFragmentManager(), this.f14301g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f14301g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f14301g.clear();
        return fragment;
    }

    @Nullable
    /* renamed from: g */
    private Fragment m44742g(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f14300f.clear();
        m44744e(fragmentActivity.getSupportFragmentManager().getFragments(), this.f14300f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f14300f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f14300f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    /* renamed from: h */
    private C3558j m44741h(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment m44732q = m44732q(fragmentManager, fragment, z);
        C3558j m44756e = m44732q.m44756e();
        if (m44756e == null) {
            C3558j mo44727a = this.f14299e.mo44727a(Glide.m45744d(context), m44732q.m44758c(), m44732q.m44755f(), context);
            m44732q.m44750k(mo44727a);
            return mo44727a;
        }
        return m44756e;
    }

    @NonNull
    /* renamed from: o */
    private C3558j m44734o(@NonNull Context context) {
        if (this.f14295a == null) {
            synchronized (this) {
                if (this.f14295a == null) {
                    this.f14295a = this.f14299e.mo44727a(Glide.m45744d(StubApp.getOrigApplicationContext(context.getApplicationContext())), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return this.f14295a;
    }

    @NonNull
    /* renamed from: q */
    private RequestManagerFragment m44732q(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(f14289i);
        if (requestManagerFragment == null && (requestManagerFragment = this.f14296b.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.m44751j(fragment);
            if (z) {
                requestManagerFragment.m44758c().m44769d();
            }
            this.f14296b.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, f14289i).commitAllowingStateLoss();
            this.f14298d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    /* renamed from: s */
    private SupportRequestManagerFragment m44730s(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(f14289i);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f14297c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.m44773k(fragment);
            if (z) {
                supportRequestManagerFragment.m44780d().m44769d();
            }
            this.f14297c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, f14289i).commitAllowingStateLoss();
            this.f14298d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    /* renamed from: t */
    private static boolean m44729t(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    /* renamed from: u */
    private C3558j m44728u(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment m44730s = m44730s(fragmentManager, fragment, z);
        C3558j m44778f = m44730s.m44778f();
        if (m44778f == null) {
            C3558j mo44727a = this.f14299e.mo44727a(Glide.m45744d(context), m44730s.m44780d(), m44730s.m44777g(), context);
            m44730s.m44772l(mo44727a);
            return mo44727a;
        }
        return m44778f;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i = message.what;
        Object obj3 = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f14296b.remove(obj);
        } else if (i == 2) {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f14297c.remove(obj);
        } else {
            z = false;
            obj2 = null;
            if (z && obj3 == null && Log.isLoggable(f14290j, 5)) {
                Log.w(f14290j, "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z) {
            Log.w(f14290j, "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z;
    }

    @NonNull
    /* renamed from: i */
    public C3558j m44740i(@NonNull Activity activity) {
        if (C3771k.m44372s()) {
            return m44738k(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        }
        m44748a(activity);
        return m44741h(activity, activity.getFragmentManager(), null, m44729t(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    /* renamed from: j */
    public C3558j m44739j(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!C3771k.m44372s()) {
                return m44741h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return m44738k(StubApp.getOrigApplicationContext(fragment.getActivity().getApplicationContext()));
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    /* renamed from: k */
    public C3558j m44738k(@NonNull Context context) {
        if (context != null) {
            if (C3771k.m44371t() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return m44735n((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return m44740i((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return m44738k(((ContextWrapper) context).getBaseContext());
                }
            }
            return m44734o(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    /* renamed from: l */
    public C3558j m44737l(@NonNull View view) {
        if (C3771k.m44372s()) {
            return m44738k(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext()));
        }
        C3770j.m44392d(view);
        C3770j.m44391e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity m44747b = m44747b(view.getContext());
        if (m44747b == null) {
            return m44738k(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext()));
        }
        if (m44747b instanceof FragmentActivity) {
            Fragment m44742g = m44742g(view, (FragmentActivity) m44747b);
            return m44742g != null ? m44736m(m44742g) : m44740i(m44747b);
        }
        android.app.Fragment m44743f = m44743f(view, m44747b);
        if (m44743f == null) {
            return m44740i(m44747b);
        }
        return m44739j(m44743f);
    }

    @NonNull
    /* renamed from: m */
    public C3558j m44736m(@NonNull Fragment fragment) {
        C3770j.m44391e(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (C3771k.m44372s()) {
            return m44738k(StubApp.getOrigApplicationContext(fragment.getActivity().getApplicationContext()));
        }
        return m44728u(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    /* renamed from: n */
    public C3558j m44735n(@NonNull FragmentActivity fragmentActivity) {
        if (C3771k.m44372s()) {
            return m44738k(StubApp.getOrigApplicationContext(fragmentActivity.getApplicationContext()));
        }
        m44748a(fragmentActivity);
        return m44728u(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, m44729t(fragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    /* renamed from: p */
    public RequestManagerFragment m44733p(Activity activity) {
        return m44732q(activity.getFragmentManager(), null, m44729t(activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: r */
    public SupportRequestManagerFragment m44731r(FragmentActivity fragmentActivity) {
        return m44730s(fragmentActivity.getSupportFragmentManager(), null, m44729t(fragmentActivity));
    }
}
