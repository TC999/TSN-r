package com.bxkj.base.p085v2.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import cn.bluemobi.dylan.base.utils.AppManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseUI;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006B\u0007¢\u0006\u0004\bU\u0010VJ&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u0011H\u0016R\"\u0010\u001b\u001a\u00020\u00148\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00058\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010*\u001a\u00020#8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010/\u001a\u00028\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010-\"\u0004\b\u0015\u0010.R\"\u00106\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010>\u001a\u0002078\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010F\u001a\u00020?8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010N\u001a\u0004\u0018\u00010G8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010T\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\b\u001c\u0010R\"\u0004\b$\u0010S¨\u0006W"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseFragment;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "Lcom/bxkj/base/v2/base/g;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "Lkotlin/f1;", "d", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", IAdInterListener.AdReqParam.WIDTH, "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "b", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "c", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "Lcom/bxkj/base/v2/base/BaseViewModel;", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "e", "Landroidx/databinding/ViewDataBinding;", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "g", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", UMCommonContent.f37777aG, "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "h", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "", "i", "Z", "()Z", "(Z)V", "isInitFinish", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.BaseFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class BaseFragment<VB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment implements BaseUI<VB, VM> {

    /* renamed from: a */
    public FragmentActivity f14985a;

    /* renamed from: b */
    public Fragment f14986b;

    /* renamed from: c */
    public Context f14987c;

    /* renamed from: d */
    public VM f14988d;

    /* renamed from: e */
    public VB f14989e;

    /* renamed from: f */
    public LifecycleOwner f14990f;

    /* renamed from: g */
    public FragmentManager f14991g;
    @Nullable

    /* renamed from: h */
    private LoadingDialog f14992h;

    /* renamed from: i */
    private boolean f14993i;

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: A */
    public void mo43928A(@NotNull Fragment fragment) {
        C14342f0.m8184p(fragment, "<set-?>");
        this.f14986b = fragment;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: B */
    public LifecycleOwner mo43927B() {
        LifecycleOwner lifecycleOwner = this.f14990f;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        C14342f0.m8200S("lifecycleOwner");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: C */
    public Context mo43926C() {
        Context context = this.f14987c;
        if (context != null) {
            return context;
        }
        C14342f0.m8200S("mContext");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: F */
    public void mo43925F() {
        BaseUI.C3928a.m43894o(this);
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: G */
    public <VB extends ViewBinding> VB mo43924G(@NotNull Object obj, @NotNull LayoutInflater layoutInflater) {
        return (VB) BaseUI.C3928a.m43897l(this, obj, layoutInflater);
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: J */
    public FragmentManager mo43923J() {
        FragmentManager fragmentManager = this.f14991g;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        C14342f0.m8200S("dialogFagmentManager");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: K */
    public <VB extends ViewBinding> VB mo43922K(@NotNull Object obj, @NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return (VB) BaseUI.C3928a.m43896m(this, obj, layoutInflater, viewGroup);
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: L */
    public void mo43921L(@NotNull Context context) {
        C14342f0.m8184p(context, "<set-?>");
        this.f14987c = context;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: M */
    public VB mo43920M() {
        VB vb = this.f14989e;
        if (vb != null) {
            return vb;
        }
        C14342f0.m8200S("mDataBinding");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: a */
    public void mo43919a(@NotNull VM vm) {
        C14342f0.m8184p(vm, "<set-?>");
        this.f14988d = vm;
    }

    /* renamed from: b */
    public final boolean m43977b() {
        return this.f14993i;
    }

    /* renamed from: c */
    public final void m43976c(boolean z) {
        this.f14993i = z;
    }

    /* renamed from: d */
    public final void m43975d(@NotNull ViewModelStoreOwner owner) {
        C14342f0.m8184p(owner, "owner");
        mo43919a(mo43914u(this, owner));
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @Nullable
    /* renamed from: o */
    public LoadingDialog mo43918o() {
        return this.f14992h;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        C14342f0.m8184p(inflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        C14342f0.m8185o(requireActivity, "requireActivity()");
        mo43916r(requireActivity);
        Context requireContext = requireContext();
        C14342f0.m8185o(requireContext, "requireContext()");
        mo43921L(requireContext);
        mo43928A(this);
        mo43919a(mo43914u(this, this));
        mo43917q(mo43922K(this, inflater, viewGroup));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        C14342f0.m8185o(viewLifecycleOwner, "viewLifecycleOwner");
        setLifecycleOwner(viewLifecycleOwner);
        FragmentManager childFragmentManager = getChildFragmentManager();
        C14342f0.m8185o(childFragmentManager, "childFragmentManager");
        mo43909z(childFragmentManager);
        mo43910y();
        mo38206E();
        mo38205p();
        AppManager.m57776n().m57786d(mo43915s());
        this.f14993i = true;
        return mo43920M().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BaseFragment<VB, VM> baseFragment = this.f14986b != null ? this : null;
        if (baseFragment != null) {
            AppManager.m57776n().m57770t(baseFragment.mo43915s());
        }
        mo43925F();
        this.f14993i = false;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: q */
    public void mo43917q(@NotNull VB vb) {
        C14342f0.m8184p(vb, "<set-?>");
        this.f14989e = vb;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: r */
    public void mo43916r(@NotNull FragmentActivity fragmentActivity) {
        C14342f0.m8184p(fragmentActivity, "<set-?>");
        this.f14985a = fragmentActivity;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: s */
    public Fragment mo43915s() {
        Fragment fragment = this.f14986b;
        if (fragment != null) {
            return fragment;
        }
        C14342f0.m8200S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        C14342f0.m8184p(lifecycleOwner, "<set-?>");
        this.f14990f = lifecycleOwner;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: u */
    public <VM extends ViewModel> VM mo43914u(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        return (VM) BaseUI.C3928a.m43895n(this, obj, viewModelStoreOwner);
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: v */
    public void mo43913v(@Nullable LoadingDialog loadingDialog) {
        this.f14992h = loadingDialog;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: w */
    public FragmentActivity mo43912w() {
        FragmentActivity fragmentActivity = this.f14985a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        C14342f0.m8200S("mActivity");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: x */
    public VM mo43911x() {
        VM vm = this.f14988d;
        if (vm != null) {
            return vm;
        }
        C14342f0.m8200S("mViewModel");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: y */
    public void mo43910y() {
        BaseUI.C3928a.m43903f(this);
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: z */
    public void mo43909z(@NotNull FragmentManager fragmentManager) {
        C14342f0.m8184p(fragmentManager, "<set-?>");
        this.f14991g = fragmentManager;
    }
}
