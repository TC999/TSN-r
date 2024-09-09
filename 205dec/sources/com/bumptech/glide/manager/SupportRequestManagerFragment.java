package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: g  reason: collision with root package name */
    private static final String f17578g = "SupportRMFragment";

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.manager.a f17579a;

    /* renamed from: b  reason: collision with root package name */
    private final m f17580b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f17581c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private SupportRequestManagerFragment f17582d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private com.bumptech.glide.j f17583e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Fragment f17584f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class a implements m {
        a() {
        }

        @Override // com.bumptech.glide.manager.m
        @NonNull
        public Set<com.bumptech.glide.j> a() {
            Set<SupportRequestManagerFragment> c4 = SupportRequestManagerFragment.this.c();
            HashSet hashSet = new HashSet(c4.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : c4) {
                if (supportRequestManagerFragment.f() != null) {
                    hashSet.add(supportRequestManagerFragment.f());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new com.bumptech.glide.manager.a());
    }

    private void b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f17581c.add(supportRequestManagerFragment);
    }

    @Nullable
    private Fragment e() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f17584f;
    }

    private boolean h(@NonNull Fragment fragment) {
        Fragment e4 = e();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(e4)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void i(@NonNull FragmentActivity fragmentActivity) {
        m();
        SupportRequestManagerFragment r3 = com.bumptech.glide.d.d(fragmentActivity).m().r(fragmentActivity);
        this.f17582d = r3;
        if (equals(r3)) {
            return;
        }
        this.f17582d.b(this);
    }

    private void j(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f17581c.remove(supportRequestManagerFragment);
    }

    private void m() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f17582d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.j(this);
            this.f17582d = null;
        }
    }

    @NonNull
    Set<SupportRequestManagerFragment> c() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f17582d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f17581c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f17582d.c()) {
            if (h(supportRequestManagerFragment2.e())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.bumptech.glide.manager.a d() {
        return this.f17579a;
    }

    @Nullable
    public com.bumptech.glide.j f() {
        return this.f17583e;
    }

    @NonNull
    public m g() {
        return this.f17580b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(@Nullable Fragment fragment) {
        this.f17584f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        i(fragment.getActivity());
    }

    public void l(@Nullable com.bumptech.glide.j jVar) {
        this.f17583e = jVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            i(getActivity());
        } catch (IllegalStateException e4) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e4);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f17579a.c();
        m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f17584f = null;
        m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f17579a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f17579a.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f17580b = new a();
        this.f17581c = new HashSet();
        this.f17579a = aVar;
    }
}
