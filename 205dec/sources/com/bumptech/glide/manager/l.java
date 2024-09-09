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
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestManagerRetriever.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class l implements Handler.Callback {
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static final String f17606i = "com.bumptech.glide.manager";

    /* renamed from: j  reason: collision with root package name */
    private static final String f17607j = "RMRetriever";

    /* renamed from: k  reason: collision with root package name */
    private static final int f17608k = 1;

    /* renamed from: l  reason: collision with root package name */
    private static final int f17609l = 2;

    /* renamed from: m  reason: collision with root package name */
    private static final String f17610m = "key";

    /* renamed from: n  reason: collision with root package name */
    private static final b f17611n = new a();

    /* renamed from: a  reason: collision with root package name */
    private volatile com.bumptech.glide.j f17612a;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f17615d;

    /* renamed from: e  reason: collision with root package name */
    private final b f17616e;
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    final Map<FragmentManager, k> f17613b = new HashMap();
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f17614c = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final ArrayMap<View, Fragment> f17617f = new ArrayMap<>();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f17618g = new ArrayMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Bundle f17619h = new Bundle();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.manager.l.b
        @NonNull
        public com.bumptech.glide.j a(@NonNull com.bumptech.glide.d dVar, @NonNull h hVar, @NonNull m mVar, @NonNull Context context) {
            return new com.bumptech.glide.j(dVar, hVar, mVar, context);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestManagerRetriever.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface b {
        @NonNull
        com.bumptech.glide.j a(@NonNull com.bumptech.glide.d dVar, @NonNull h hVar, @NonNull m mVar, @NonNull Context context);
    }

    public l(@Nullable b bVar) {
        this.f17616e = bVar == null ? f17611n : bVar;
        this.f17615d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    private Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void c(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    c(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        d(fragmentManager, arrayMap);
    }

    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            this.f17619h.putInt(DomainCampaignEx.LOOPBACK_KEY, i4);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f17619h, DomainCampaignEx.LOOPBACK_KEY);
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                c(fragment.getChildFragmentManager(), arrayMap);
            }
            i4 = i5;
        }
    }

    private static void e(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                e(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private android.app.Fragment f(@NonNull View view, @NonNull Activity activity) {
        this.f17618g.clear();
        c(activity.getFragmentManager(), this.f17618g);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f17618g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f17618g.clear();
        return fragment;
    }

    @Nullable
    private Fragment g(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f17617f.clear();
        e(fragmentActivity.getSupportFragmentManager().getFragments(), this.f17617f);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.f17617f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f17617f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private com.bumptech.glide.j h(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z3) {
        k q3 = q(fragmentManager, fragment, z3);
        com.bumptech.glide.j e4 = q3.e();
        if (e4 == null) {
            com.bumptech.glide.j a4 = this.f17616e.a(com.bumptech.glide.d.d(context), q3.c(), q3.f(), context);
            q3.k(a4);
            return a4;
        }
        return e4;
    }

    @NonNull
    private com.bumptech.glide.j o(@NonNull Context context) {
        if (this.f17612a == null) {
            synchronized (this) {
                if (this.f17612a == null) {
                    this.f17612a = this.f17616e.a(com.bumptech.glide.d.d(StubApp.getOrigApplicationContext(context.getApplicationContext())), new com.bumptech.glide.manager.b(), new g(), StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return this.f17612a;
    }

    @NonNull
    private k q(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z3) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f17613b.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.j(fragment);
            if (z3) {
                kVar.c().d();
            }
            this.f17613b.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f17615d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    @NonNull
    private SupportRequestManagerFragment s(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z3) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.f17614c.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.k(fragment);
            if (z3) {
                supportRequestManagerFragment.d().d();
            }
            this.f17614c.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f17615d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    private static boolean t(Activity activity) {
        return !activity.isFinishing();
    }

    @NonNull
    private com.bumptech.glide.j u(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z3) {
        SupportRequestManagerFragment s3 = s(fragmentManager, fragment, z3);
        com.bumptech.glide.j f4 = s3.f();
        if (f4 == null) {
            com.bumptech.glide.j a4 = this.f17616e.a(com.bumptech.glide.d.d(context), s3.d(), s3.g(), context);
            s3.l(a4);
            return a4;
        }
        return f4;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i4 = message.what;
        Object obj3 = null;
        boolean z3 = true;
        if (i4 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.f17613b.remove(obj);
        } else if (i4 == 2) {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.f17614c.remove(obj);
        } else {
            z3 = false;
            obj2 = null;
            if (z3 && obj3 == null && Log.isLoggable("RMRetriever", 5)) {
                Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z3;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z3) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z3;
    }

    @NonNull
    public com.bumptech.glide.j i(@NonNull Activity activity) {
        if (com.bumptech.glide.util.k.s()) {
            return k(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        }
        a(activity);
        return h(activity, activity.getFragmentManager(), null, t(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.j j(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!com.bumptech.glide.util.k.s()) {
                return h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return k(StubApp.getOrigApplicationContext(fragment.getActivity().getApplicationContext()));
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    @NonNull
    public com.bumptech.glide.j k(@NonNull Context context) {
        if (context != null) {
            if (com.bumptech.glide.util.k.t() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return n((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return i((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return k(((ContextWrapper) context).getBaseContext());
                }
            }
            return o(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public com.bumptech.glide.j l(@NonNull View view) {
        if (com.bumptech.glide.util.k.s()) {
            return k(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext()));
        }
        com.bumptech.glide.util.j.d(view);
        com.bumptech.glide.util.j.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity b4 = b(view.getContext());
        if (b4 == null) {
            return k(StubApp.getOrigApplicationContext(view.getContext().getApplicationContext()));
        }
        if (b4 instanceof FragmentActivity) {
            Fragment g4 = g(view, (FragmentActivity) b4);
            return g4 != null ? m(g4) : i(b4);
        }
        android.app.Fragment f4 = f(view, b4);
        if (f4 == null) {
            return i(b4);
        }
        return j(f4);
    }

    @NonNull
    public com.bumptech.glide.j m(@NonNull Fragment fragment) {
        com.bumptech.glide.util.j.e(fragment.getActivity(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (com.bumptech.glide.util.k.s()) {
            return k(StubApp.getOrigApplicationContext(fragment.getActivity().getApplicationContext()));
        }
        return u(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public com.bumptech.glide.j n(@NonNull FragmentActivity fragmentActivity) {
        if (com.bumptech.glide.util.k.s()) {
            return k(StubApp.getOrigApplicationContext(fragmentActivity.getApplicationContext()));
        }
        a(fragmentActivity);
        return u(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, t(fragmentActivity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    public k p(Activity activity) {
        return q(activity.getFragmentManager(), null, t(activity));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public SupportRequestManagerFragment r(FragmentActivity fragmentActivity) {
        return s(fragmentActivity.getSupportFragmentManager(), null, t(fragmentActivity));
    }
}
