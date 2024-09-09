package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestManagerFragment.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class k extends Fragment {

    /* renamed from: g  reason: collision with root package name */
    private static final String f17598g = "RMFragment";

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.manager.a f17599a;

    /* renamed from: b  reason: collision with root package name */
    private final m f17600b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<k> f17601c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private com.bumptech.glide.j f17602d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private k f17603e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private Fragment f17604f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: RequestManagerFragment.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private class a implements m {
        a() {
        }

        @Override // com.bumptech.glide.manager.m
        @NonNull
        public Set<com.bumptech.glide.j> a() {
            Set<k> b4 = k.this.b();
            HashSet hashSet = new HashSet(b4.size());
            for (k kVar : b4) {
                if (kVar.e() != null) {
                    hashSet.add(kVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + k.this + "}";
        }
    }

    public k() {
        this(new com.bumptech.glide.manager.a());
    }

    private void a(k kVar) {
        this.f17601c.add(kVar);
    }

    @Nullable
    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f17604f;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
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

    private void h(@NonNull Activity activity) {
        l();
        k p3 = com.bumptech.glide.d.d(activity).m().p(activity);
        this.f17603e = p3;
        if (equals(p3)) {
            return;
        }
        this.f17603e.a(this);
    }

    private void i(k kVar) {
        this.f17601c.remove(kVar);
    }

    private void l() {
        k kVar = this.f17603e;
        if (kVar != null) {
            kVar.i(this);
            this.f17603e = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<k> b() {
        if (equals(this.f17603e)) {
            return Collections.unmodifiableSet(this.f17601c);
        }
        if (this.f17603e != null) {
            HashSet hashSet = new HashSet();
            for (k kVar : this.f17603e.b()) {
                if (g(kVar.getParentFragment())) {
                    hashSet.add(kVar);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.bumptech.glide.manager.a c() {
        return this.f17599a;
    }

    @Nullable
    public com.bumptech.glide.j e() {
        return this.f17602d;
    }

    @NonNull
    public m f() {
        return this.f17600b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@Nullable Fragment fragment) {
        this.f17604f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        h(fragment.getActivity());
    }

    public void k(@Nullable com.bumptech.glide.j jVar) {
        this.f17602d = jVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e4) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e4);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f17599a.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f17599a.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f17599a.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    k(@NonNull com.bumptech.glide.manager.a aVar) {
        this.f17600b = new a();
        this.f17601c = new HashSet();
        this.f17599a = aVar;
    }
}
