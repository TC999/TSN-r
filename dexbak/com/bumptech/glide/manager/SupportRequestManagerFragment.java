package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.C3558j;
import com.bumptech.glide.Glide;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: g */
    private static final String f14261g = "SupportRMFragment";

    /* renamed from: a */
    private final ActivityFragmentLifecycle f14262a;

    /* renamed from: b */
    private final RequestManagerTreeNode f14263b;

    /* renamed from: c */
    private final Set<SupportRequestManagerFragment> f14264c;
    @Nullable

    /* renamed from: d */
    private SupportRequestManagerFragment f14265d;
    @Nullable

    /* renamed from: e */
    private C3558j f14266e;
    @Nullable

    /* renamed from: f */
    private Fragment f14267f;

    /* renamed from: com.bumptech.glide.manager.SupportRequestManagerFragment$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C3735a implements RequestManagerTreeNode {
        C3735a() {
        }

        @Override // com.bumptech.glide.manager.RequestManagerTreeNode
        @NonNull
        /* renamed from: a */
        public Set<C3558j> mo44726a() {
            Set<SupportRequestManagerFragment> m44781c = SupportRequestManagerFragment.this.m44781c();
            HashSet hashSet = new HashSet(m44781c.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : m44781c) {
                if (supportRequestManagerFragment.m44778f() != null) {
                    hashSet.add(supportRequestManagerFragment.m44778f());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    /* renamed from: b */
    private void m44782b(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f14264c.add(supportRequestManagerFragment);
    }

    @Nullable
    /* renamed from: e */
    private Fragment m44779e() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.f14267f;
    }

    /* renamed from: h */
    private boolean m44776h(@NonNull Fragment fragment) {
        Fragment m44779e = m44779e();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(m44779e)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    /* renamed from: i */
    private void m44775i(@NonNull FragmentActivity fragmentActivity) {
        m44771m();
        SupportRequestManagerFragment m44731r = Glide.m45744d(fragmentActivity).m45735m().m44731r(fragmentActivity);
        this.f14265d = m44731r;
        if (equals(m44731r)) {
            return;
        }
        this.f14265d.m44782b(this);
    }

    /* renamed from: j */
    private void m44774j(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f14264c.remove(supportRequestManagerFragment);
    }

    /* renamed from: m */
    private void m44771m() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f14265d;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.m44774j(this);
            this.f14265d = null;
        }
    }

    @NonNull
    /* renamed from: c */
    Set<SupportRequestManagerFragment> m44781c() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f14265d;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f14264c);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.f14265d.m44781c()) {
            if (m44776h(supportRequestManagerFragment2.m44779e())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: d */
    public ActivityFragmentLifecycle m44780d() {
        return this.f14262a;
    }

    @Nullable
    /* renamed from: f */
    public C3558j m44778f() {
        return this.f14266e;
    }

    @NonNull
    /* renamed from: g */
    public RequestManagerTreeNode m44777g() {
        return this.f14263b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m44773k(@Nullable Fragment fragment) {
        this.f14267f = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        m44775i(fragment.getActivity());
    }

    /* renamed from: l */
    public void m44772l(@Nullable C3558j c3558j) {
        this.f14266e = c3558j;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            m44775i(getActivity());
        } catch (IllegalStateException e) {
            if (Log.isLoggable(f14261g, 5)) {
                Log.w(f14261g, "Unable to register fragment with root", e);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f14262a.m44770c();
        m44771m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f14267f = null;
        m44771m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f14262a.m44769d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f14262a.m44768e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + m44779e() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f14263b = new C3735a();
        this.f14264c = new HashSet();
        this.f14262a = activityFragmentLifecycle;
    }
}
