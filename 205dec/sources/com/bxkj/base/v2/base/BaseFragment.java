package com.bxkj.base.v2.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.base.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseFragment.kt */
@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006B\u0007\u00a2\u0006\u0004\bU\u0010VJ&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0011H\u0016R\"\u0010\u001b\u001a\u00020\u00148\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010/\u001a\u00028\u00018\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010-\"\u0004\b\u0015\u0010.R\"\u00106\u001a\u00028\u00008\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010F\u001a\u00020?8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010N\u001a\u0004\u0018\u00010G8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010T\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\b\u001c\u0010R\"\u0004\b$\u0010S\u00a8\u0006W"}, d2 = {"Lcom/bxkj/base/v2/base/BaseFragment;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Lcom/bxkj/base/v2/base/g;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lkotlin/f1;", "d", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "w", "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "b", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", "A", "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "c", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "Lcom/bxkj/base/v2/base/BaseViewModel;", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "e", "Landroidx/databinding/ViewDataBinding;", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "g", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", "z", "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "h", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "", "i", "Z", "()Z", "(Z)V", "isInitFinish", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class BaseFragment<VB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment implements g<VB, VM> {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f18469a;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f18470b;

    /* renamed from: c  reason: collision with root package name */
    public Context f18471c;

    /* renamed from: d  reason: collision with root package name */
    public VM f18472d;

    /* renamed from: e  reason: collision with root package name */
    public VB f18473e;

    /* renamed from: f  reason: collision with root package name */
    public LifecycleOwner f18474f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentManager f18475g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private m f18476h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18477i;

    @Override // com.bxkj.base.v2.base.g
    public void A(@NotNull Fragment fragment) {
        f0.p(fragment, "<set-?>");
        this.f18470b = fragment;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public LifecycleOwner B() {
        LifecycleOwner lifecycleOwner = this.f18474f;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        f0.S("lifecycleOwner");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public Context C() {
        Context context = this.f18471c;
        if (context != null) {
            return context;
        }
        f0.S("mContext");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void F() {
        g.a.o(this);
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public <VB extends ViewBinding> VB G(@NotNull Object obj, @NotNull LayoutInflater layoutInflater) {
        return (VB) g.a.l(this, obj, layoutInflater);
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public FragmentManager J() {
        FragmentManager fragmentManager = this.f18475g;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        f0.S("dialogFagmentManager");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public <VB extends ViewBinding> VB K(@NotNull Object obj, @NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return (VB) g.a.m(this, obj, layoutInflater, viewGroup);
    }

    @Override // com.bxkj.base.v2.base.g
    public void L(@NotNull Context context) {
        f0.p(context, "<set-?>");
        this.f18471c = context;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public VB M() {
        VB vb = this.f18473e;
        if (vb != null) {
            return vb;
        }
        f0.S("mDataBinding");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void a(@NotNull VM vm) {
        f0.p(vm, "<set-?>");
        this.f18472d = vm;
    }

    public final boolean b() {
        return this.f18477i;
    }

    public final void c(boolean z3) {
        this.f18477i = z3;
    }

    public final void d(@NotNull ViewModelStoreOwner owner) {
        f0.p(owner, "owner");
        a(u(this, owner));
    }

    @Override // com.bxkj.base.v2.base.g
    @Nullable
    public m o() {
        return this.f18476h;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        f0.p(inflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        f0.o(requireActivity, "requireActivity()");
        r(requireActivity);
        Context requireContext = requireContext();
        f0.o(requireContext, "requireContext()");
        L(requireContext);
        A(this);
        a(u(this, this));
        q(K(this, inflater, viewGroup));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        f0.o(viewLifecycleOwner, "viewLifecycleOwner");
        setLifecycleOwner(viewLifecycleOwner);
        FragmentManager childFragmentManager = getChildFragmentManager();
        f0.o(childFragmentManager, "childFragmentManager");
        z(childFragmentManager);
        y();
        E();
        p();
        cn.bluemobi.dylan.base.utils.a.n().d(s());
        this.f18477i = true;
        return M().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BaseFragment<VB, VM> baseFragment = this.f18470b != null ? this : null;
        if (baseFragment != null) {
            cn.bluemobi.dylan.base.utils.a.n().t(baseFragment.s());
        }
        F();
        this.f18477i = false;
    }

    @Override // com.bxkj.base.v2.base.g
    public void q(@NotNull VB vb) {
        f0.p(vb, "<set-?>");
        this.f18473e = vb;
    }

    @Override // com.bxkj.base.v2.base.g
    public void r(@NotNull FragmentActivity fragmentActivity) {
        f0.p(fragmentActivity, "<set-?>");
        this.f18469a = fragmentActivity;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public Fragment s() {
        Fragment fragment = this.f18470b;
        if (fragment != null) {
            return fragment;
        }
        f0.S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        f0.p(lifecycleOwner, "<set-?>");
        this.f18474f = lifecycleOwner;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public <VM extends ViewModel> VM u(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        return (VM) g.a.n(this, obj, viewModelStoreOwner);
    }

    @Override // com.bxkj.base.v2.base.g
    public void v(@Nullable m mVar) {
        this.f18476h = mVar;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public FragmentActivity w() {
        FragmentActivity fragmentActivity = this.f18469a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        f0.S("mActivity");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public VM x() {
        VM vm = this.f18472d;
        if (vm != null) {
            return vm;
        }
        f0.S("mViewModel");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void y() {
        g.a.f(this);
    }

    @Override // com.bxkj.base.v2.base.g
    public void z(@NotNull FragmentManager fragmentManager) {
        f0.p(fragmentManager, "<set-?>");
        this.f18475g = fragmentManager;
    }
}
