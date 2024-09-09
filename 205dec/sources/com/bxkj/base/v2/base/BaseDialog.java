package com.bxkj.base.v2.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
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
/* compiled from: BaseDialog.kt */
@Metadata(bv = {}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006B\u0007\u00a2\u0006\u0004\bV\u0010WJ&\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0012J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\"\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001c\u001a\u00020\u001bR\"\u0010&\u001a\u00020\u001f8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001a\u00020.8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00109\u001a\u00028\u00018\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u001e\u00105\u001a\u0004\b6\u00107\"\u0004\b \u00108R\"\u0010?\u001a\u00028\u00008\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010N\u001a\u00020\u00128\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010U\u001a\u0004\u0018\u00010O8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T\u00a8\u0006X"}, d2 = {"Lcom/bxkj/base/v2/base/BaseDialog;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/fragment/app/DialogFragment;", "Lcom/bxkj/base/v2/base/g;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "Lkotlin/f1;", "b", "onDestroy", "Landroidx/fragment/app/FragmentManager;", "manager", "", "tag", "show", "showNow", "fragmentManager", "c", "h", "", "cancelAble", "e", "d", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "w", "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", "A", "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "Lcom/bxkj/base/v2/base/BaseViewModel;", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "Landroidx/databinding/ViewDataBinding;", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "g", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", "z", "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class BaseDialog<VB extends ViewDataBinding, VM extends BaseViewModel> extends DialogFragment implements g<VB, VM> {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f18461a;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f18462b;

    /* renamed from: c  reason: collision with root package name */
    public Context f18463c;

    /* renamed from: d  reason: collision with root package name */
    public VM f18464d;

    /* renamed from: e  reason: collision with root package name */
    public VB f18465e;

    /* renamed from: f  reason: collision with root package name */
    public LifecycleOwner f18466f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentManager f18467g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private m f18468h;

    public static /* synthetic */ void f(BaseDialog baseDialog, FragmentManager fragmentManager, String str, boolean z3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i4 & 4) != 0) {
            z3 = true;
        }
        baseDialog.d(fragmentManager, str, z3);
    }

    public static /* synthetic */ void g(BaseDialog baseDialog, FragmentManager fragmentManager, boolean z3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        baseDialog.e(fragmentManager, z3);
    }

    @Override // com.bxkj.base.v2.base.g
    public void A(@NotNull Fragment fragment) {
        f0.p(fragment, "<set-?>");
        this.f18462b = fragment;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public LifecycleOwner B() {
        LifecycleOwner lifecycleOwner = this.f18466f;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        f0.S("lifecycleOwner");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public Context C() {
        Context context = this.f18463c;
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
        FragmentManager fragmentManager = this.f18467g;
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
        this.f18463c = context;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public VB M() {
        VB vb = this.f18465e;
        if (vb != null) {
            return vb;
        }
        f0.S("mDataBinding");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void a(@NotNull VM vm) {
        f0.p(vm, "<set-?>");
        this.f18464d = vm;
    }

    public final void b() {
        FragmentActivity requireActivity = requireActivity();
        f0.o(requireActivity, "requireActivity()");
        a(u(this, requireActivity));
    }

    public final void c(@NotNull FragmentManager fragmentManager) {
        f0.p(fragmentManager, "fragmentManager");
        d(fragmentManager, "TSNDialog", true);
    }

    public final void d(@NotNull FragmentManager fragmentManager, @Nullable String str, boolean z3) {
        f0.p(fragmentManager, "fragmentManager");
        try {
            if (fragmentManager.isDestroyed()) {
                return;
            }
            setCancelable(z3);
            if (isAdded() || isVisible() || isRemoving()) {
                return;
            }
            super.showNow(fragmentManager, str);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void e(@NotNull FragmentManager fragmentManager, boolean z3) {
        f0.p(fragmentManager, "fragmentManager");
        d(fragmentManager, "TSNDialog", z3);
    }

    public final void h(@NotNull FragmentManager fragmentManager) {
        f0.p(fragmentManager, "fragmentManager");
        d(fragmentManager, "TSNDialog", true);
    }

    @Override // com.bxkj.base.v2.base.g
    @Nullable
    public m o() {
        return this.f18468h;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Window window;
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
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.requestFeature(1);
        }
        y();
        E();
        p();
        return M().getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        F();
    }

    @Override // com.bxkj.base.v2.base.g
    public void q(@NotNull VB vb) {
        f0.p(vb, "<set-?>");
        this.f18465e = vb;
    }

    @Override // com.bxkj.base.v2.base.g
    public void r(@NotNull FragmentActivity fragmentActivity) {
        f0.p(fragmentActivity, "<set-?>");
        this.f18461a = fragmentActivity;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public Fragment s() {
        Fragment fragment = this.f18462b;
        if (fragment != null) {
            return fragment;
        }
        f0.S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        f0.p(lifecycleOwner, "<set-?>");
        this.f18466f = lifecycleOwner;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(@NotNull FragmentManager manager, @Nullable String str) {
        f0.p(manager, "manager");
        d(manager, "TSNDialog", true);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void showNow(@NotNull FragmentManager manager, @Nullable String str) {
        f0.p(manager, "manager");
        d(manager, "TSNDialog", true);
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public <VM extends ViewModel> VM u(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        return (VM) g.a.n(this, obj, viewModelStoreOwner);
    }

    @Override // com.bxkj.base.v2.base.g
    public void v(@Nullable m mVar) {
        this.f18468h = mVar;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public FragmentActivity w() {
        FragmentActivity fragmentActivity = this.f18461a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        f0.S("mActivity");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public VM x() {
        VM vm = this.f18464d;
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
        this.f18467g = fragmentManager;
    }
}
