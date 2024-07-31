package com.bxkj.base.p085v2.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseUI;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseDialog.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006B\u0007¢\u0006\u0004\bV\u0010WJ&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0012J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\"\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u001bR\"\u0010&\u001a\u00020\u001f8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00109\u001a\u00028\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u001e\u00105\u001a\u0004\b6\u00107\"\u0004\b \u00108R\"\u0010?\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010N\u001a\u00020\u00128\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010U\u001a\u0004\u0018\u00010O8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006X"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseDialog;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/fragment/app/DialogFragment;", "Lcom/bxkj/base/v2/base/g;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "Lkotlin/f1;", "b", "onDestroy", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", TTLogUtil.TAG_EVENT_SHOW, "showNow", "fragmentManager", "c", "h", "", "cancelAble", "e", "d", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", IAdInterListener.AdReqParam.WIDTH, "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "Lcom/bxkj/base/v2/base/BaseViewModel;", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "Landroidx/databinding/ViewDataBinding;", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "g", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", UMCommonContent.f37777aG, "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.BaseDialog */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseDialog<VB extends ViewDataBinding, VM extends BaseViewModel> extends DialogFragment implements BaseUI<VB, VM> {

    /* renamed from: a */
    public FragmentActivity f14977a;

    /* renamed from: b */
    public Fragment f14978b;

    /* renamed from: c */
    public Context f14979c;

    /* renamed from: d */
    public VM f14980d;

    /* renamed from: e */
    public VB f14981e;

    /* renamed from: f */
    public LifecycleOwner f14982f;

    /* renamed from: g */
    public FragmentManager f14983g;
    @Nullable

    /* renamed from: h */
    private LoadingDialog f14984h;

    /* renamed from: f */
    public static /* synthetic */ void m43980f(BaseDialog baseDialog, FragmentManager fragmentManager, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        baseDialog.m43982d(fragmentManager, str, z);
    }

    /* renamed from: g */
    public static /* synthetic */ void m43979g(BaseDialog baseDialog, FragmentManager fragmentManager, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        baseDialog.m43981e(fragmentManager, z);
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: A */
    public void mo43928A(@NotNull Fragment fragment) {
        C14342f0.m8184p(fragment, "<set-?>");
        this.f14978b = fragment;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: B */
    public LifecycleOwner mo43927B() {
        LifecycleOwner lifecycleOwner = this.f14982f;
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
        Context context = this.f14979c;
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
        FragmentManager fragmentManager = this.f14983g;
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
        this.f14979c = context;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: M */
    public VB mo43920M() {
        VB vb = this.f14981e;
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
        this.f14980d = vm;
    }

    /* renamed from: b */
    public final void m43984b() {
        FragmentActivity requireActivity = requireActivity();
        C14342f0.m8185o(requireActivity, "requireActivity()");
        mo43919a(mo43914u(this, requireActivity));
    }

    /* renamed from: c */
    public final void m43983c(@NotNull FragmentManager fragmentManager) {
        C14342f0.m8184p(fragmentManager, "fragmentManager");
        m43982d(fragmentManager, "TSNDialog", true);
    }

    /* renamed from: d */
    public final void m43982d(@NotNull FragmentManager fragmentManager, @Nullable String str, boolean z) {
        C14342f0.m8184p(fragmentManager, "fragmentManager");
        try {
            if (fragmentManager.isDestroyed()) {
                return;
            }
            setCancelable(z);
            if (isAdded() || isVisible() || isRemoving()) {
                return;
            }
            super.showNow(fragmentManager, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public final void m43981e(@NotNull FragmentManager fragmentManager, boolean z) {
        C14342f0.m8184p(fragmentManager, "fragmentManager");
        m43982d(fragmentManager, "TSNDialog", z);
    }

    /* renamed from: h */
    public final void m43978h(@NotNull FragmentManager fragmentManager) {
        C14342f0.m8184p(fragmentManager, "fragmentManager");
        m43982d(fragmentManager, "TSNDialog", true);
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @Nullable
    /* renamed from: o */
    public LoadingDialog mo43918o() {
        return this.f14984h;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Window window;
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
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.requestFeature(1);
        }
        mo43910y();
        mo38206E();
        mo38205p();
        return mo43920M().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        mo43925F();
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: q */
    public void mo43917q(@NotNull VB vb) {
        C14342f0.m8184p(vb, "<set-?>");
        this.f14981e = vb;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: r */
    public void mo43916r(@NotNull FragmentActivity fragmentActivity) {
        C14342f0.m8184p(fragmentActivity, "<set-?>");
        this.f14977a = fragmentActivity;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: s */
    public Fragment mo43915s() {
        Fragment fragment = this.f14978b;
        if (fragment != null) {
            return fragment;
        }
        C14342f0.m8200S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        C14342f0.m8184p(lifecycleOwner, "<set-?>");
        this.f14982f = lifecycleOwner;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String str) {
        C14342f0.m8184p(manager, "manager");
        m43982d(manager, "TSNDialog", true);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void showNow(@NotNull FragmentManager manager, @Nullable String str) {
        C14342f0.m8184p(manager, "manager");
        m43982d(manager, "TSNDialog", true);
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
        this.f14984h = loadingDialog;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: w */
    public FragmentActivity mo43912w() {
        FragmentActivity fragmentActivity = this.f14977a;
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
        VM vm = this.f14980d;
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
        this.f14983g = fragmentManager;
    }
}
