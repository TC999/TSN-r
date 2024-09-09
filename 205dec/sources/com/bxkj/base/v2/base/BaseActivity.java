package com.bxkj.base.v2.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
/* compiled from: BaseActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u00020\u0007B\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\nH\u0014R\"\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00028\u00018\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u000e\u0010)R\"\u00101\u001a\u00028\u00008\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0016@\u0016X\u0096.\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006L"}, d2 = {"Lcom/bxkj/base/v2/base/BaseActivity;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bxkj/base/v2/base/g;", "Lcom/bxkj/base/v2/common/view/a;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", "w", "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", "A", "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "c", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "d", "Lcom/bxkj/base/v2/base/BaseViewModel;", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "e", "Landroidx/databinding/ViewDataBinding;", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "g", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", "z", "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "h", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class BaseActivity<VB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements g<VB, VM>, com.bxkj.base.v2.common.view.a {

    /* renamed from: a  reason: collision with root package name */
    public FragmentActivity f18449a;

    /* renamed from: b  reason: collision with root package name */
    public Fragment f18450b;

    /* renamed from: c  reason: collision with root package name */
    public Context f18451c;

    /* renamed from: d  reason: collision with root package name */
    public VM f18452d;

    /* renamed from: e  reason: collision with root package name */
    public VB f18453e;

    /* renamed from: f  reason: collision with root package name */
    public LifecycleOwner f18454f;

    /* renamed from: g  reason: collision with root package name */
    public FragmentManager f18455g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private m f18456h;

    @Override // com.bxkj.base.v2.base.g
    public void A(@NotNull Fragment fragment) {
        f0.p(fragment, "<set-?>");
        this.f18450b = fragment;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public LifecycleOwner B() {
        LifecycleOwner lifecycleOwner = this.f18454f;
        if (lifecycleOwner != null) {
            return lifecycleOwner;
        }
        f0.S("lifecycleOwner");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public Context C() {
        Context context = this.f18451c;
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
        FragmentManager fragmentManager = this.f18455g;
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
        this.f18451c = context;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public VB M() {
        VB vb = this.f18453e;
        if (vb != null) {
            return vb;
        }
        f0.S("mDataBinding");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void a(@NotNull VM vm) {
        f0.p(vm, "<set-?>");
        this.f18452d = vm;
    }

    @Override // com.bxkj.base.v2.base.g
    @Nullable
    public m o() {
        return this.f18456h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        r(this);
        L(this);
        a(u(this, this));
        LayoutInflater layoutInflater = getLayoutInflater();
        f0.o(layoutInflater, "layoutInflater");
        q(G(this, layoutInflater));
        setLifecycleOwner(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        f0.o(supportFragmentManager, "supportFragmentManager");
        z(supportFragmentManager);
        setContentView(M().getRoot());
        y();
        E();
        p();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        cn.bluemobi.dylan.base.utils.a.n().c(w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cn.bluemobi.dylan.base.utils.a.n().s(w());
        F();
    }

    @Override // com.bxkj.base.v2.base.g
    public void q(@NotNull VB vb) {
        f0.p(vb, "<set-?>");
        this.f18453e = vb;
    }

    @Override // com.bxkj.base.v2.base.g
    public void r(@NotNull FragmentActivity fragmentActivity) {
        f0.p(fragmentActivity, "<set-?>");
        this.f18449a = fragmentActivity;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public Fragment s() {
        Fragment fragment = this.f18450b;
        if (fragment != null) {
            return fragment;
        }
        f0.S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        f0.p(lifecycleOwner, "<set-?>");
        this.f18454f = lifecycleOwner;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public <VM extends ViewModel> VM u(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner) {
        return (VM) g.a.n(this, obj, viewModelStoreOwner);
    }

    @Override // com.bxkj.base.v2.base.g
    public void v(@Nullable m mVar) {
        this.f18456h = mVar;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public FragmentActivity w() {
        FragmentActivity fragmentActivity = this.f18449a;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        f0.S("mActivity");
        return null;
    }

    @Override // com.bxkj.base.v2.base.g
    @NotNull
    public VM x() {
        VM vm = this.f18452d;
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
        this.f18455g = fragmentManager;
    }
}
