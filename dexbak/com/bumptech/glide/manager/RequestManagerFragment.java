package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.C3558j;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
/* renamed from: com.bumptech.glide.manager.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestManagerFragment extends Fragment {

    /* renamed from: g */
    private static final String f14281g = "RMFragment";

    /* renamed from: a */
    private final ActivityFragmentLifecycle f14282a;

    /* renamed from: b */
    private final RequestManagerTreeNode f14283b;

    /* renamed from: c */
    private final Set<RequestManagerFragment> f14284c;
    @Nullable

    /* renamed from: d */
    private C3558j f14285d;
    @Nullable

    /* renamed from: e */
    private RequestManagerFragment f14286e;
    @Nullable

    /* renamed from: f */
    private Fragment f14287f;

    /* compiled from: RequestManagerFragment.java */
    /* renamed from: com.bumptech.glide.manager.k$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C3738a implements RequestManagerTreeNode {
        C3738a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        /* renamed from: a */
        public Set<C3558j> mo44726a() {
            Set<RequestManagerFragment> m44759b = RequestManagerFragment.this.m44759b();
            HashSet hashSet = new HashSet(m44759b.size());
            for (RequestManagerFragment requestManagerFragment : m44759b) {
                if (requestManagerFragment.m44756e() != null) {
                    hashSet.add(requestManagerFragment.m44756e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    /* renamed from: a */
    private void m44760a(RequestManagerFragment requestManagerFragment) {
        this.f14284c.add(requestManagerFragment);
    }

    @Nullable
    @TargetApi(17)
    /* renamed from: d */
    private Fragment m44757d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f14287f;
    }

    @TargetApi(17)
    /* renamed from: g */
    private boolean m44754g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    /* renamed from: h */
    private void m44753h(@NonNull Activity activity) {
        m44749l();
        RequestManagerFragment m44733p = Glide.m45744d(activity).m45735m().m44733p(activity);
        this.f14286e = m44733p;
        if (equals(m44733p)) {
            return;
        }
        this.f14286e.m44760a(this);
    }

    /* renamed from: i */
    private void m44752i(RequestManagerFragment requestManagerFragment) {
        this.f14284c.remove(requestManagerFragment);
    }

    /* renamed from: l */
    private void m44749l() {
        RequestManagerFragment requestManagerFragment = this.f14286e;
        if (requestManagerFragment != null) {
            requestManagerFragment.m44752i(this);
            this.f14286e = null;
        }
    }

    @NonNull
    @TargetApi(17)
    /* renamed from: b */
    Set<RequestManagerFragment> m44759b() {
        if (equals(this.f14286e)) {
            return Collections.unmodifiableSet(this.f14284c);
        }
        if (this.f14286e != null) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment : this.f14286e.m44759b()) {
                if (m44754g(requestManagerFragment.getParentFragment())) {
                    hashSet.add(requestManagerFragment);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: c */
    public ActivityFragmentLifecycle m44758c() {
        return this.f14282a;
    }

    @Nullable
    /* renamed from: e */
    public C3558j m44756e() {
        return this.f14285d;
    }

    @NonNull
    /* renamed from: f */
    public RequestManagerTreeNode m44755f() {
        return this.f14283b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public void m44751j(@Nullable Fragment fragment) {
        this.f14287f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m44753h(fragment.getActivity());
    }

    /* renamed from: k */
    public void m44750k(@Nullable C3558j c3558j) {
        this.f14285d = c3558j;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            m44753h(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable(f14281g, 5)) {
                Log.w(f14281g, "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14282a.m44770c();
        m44749l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        m44749l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f14282a.m44769d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f14282a.m44768e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m44757d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    RequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f14283b = new C3738a();
        this.f14284c = new HashSet();
        this.f14282a = activityFragmentLifecycle;
    }
}
