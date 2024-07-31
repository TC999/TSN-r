package com.bxkj.base.p085v2.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u00052\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u00020\u0007B\u0007¢\u0006\u0004\bJ\u0010KJ\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\nH\u0014R\"\u0010\u0014\u001a\u00020\r8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00028\u00018\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b\u000e\u0010)R\"\u00101\u001a\u00028\u00008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00109\u001a\u0002028\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010I\u001a\u0004\u0018\u00010B8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H¨\u0006L"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseActivity;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bxkj/base/v2/base/g;", "Lcom/bxkj/base/v2/common/view/a;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f1;", "onCreate", "onDestroy", "Landroidx/fragment/app/FragmentActivity;", "a", "Landroidx/fragment/app/FragmentActivity;", IAdInterListener.AdReqParam.WIDTH, "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroidx/fragment/app/Fragment;", "b", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "c", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "d", "Lcom/bxkj/base/v2/base/BaseViewModel;", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "e", "Landroidx/databinding/ViewDataBinding;", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "f", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "g", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", UMCommonContent.f37777aG, "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "h", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.BaseActivity */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseActivity<VB extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity implements BaseUI<VB, VM>, OnBackPress {

    /* renamed from: a */
    public FragmentActivity f14965a;

    /* renamed from: b */
    public Fragment f14966b;

    /* renamed from: c */
    public Context f14967c;

    /* renamed from: d */
    public VM f14968d;

    /* renamed from: e */
    public VB f14969e;

    /* renamed from: f */
    public LifecycleOwner f14970f;

    /* renamed from: g */
    public FragmentManager f14971g;
    @Nullable

    /* renamed from: h */
    private LoadingDialog f14972h;

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: A */
    public void mo43928A(@NotNull Fragment fragment) {
        C14342f0.m8184p(fragment, "<set-?>");
        this.f14966b = fragment;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: B */
    public LifecycleOwner mo43927B() {
        LifecycleOwner lifecycleOwner = this.f14970f;
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
        Context context = this.f14967c;
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
        FragmentManager fragmentManager = this.f14971g;
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
        this.f14967c = context;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: M */
    public VB mo43920M() {
        VB vb = this.f14969e;
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
        this.f14968d = vm;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @Nullable
    /* renamed from: o */
    public LoadingDialog mo43918o() {
        return this.f14972h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        mo43916r(this);
        mo43921L(this);
        mo43919a(mo43914u(this, this));
        LayoutInflater layoutInflater = getLayoutInflater();
        C14342f0.m8185o(layoutInflater, "layoutInflater");
        mo43917q(mo43924G(this, layoutInflater));
        setLifecycleOwner(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        C14342f0.m8185o(supportFragmentManager, "supportFragmentManager");
        mo43909z(supportFragmentManager);
        setContentView(mo43920M().getRoot());
        mo43910y();
        mo38206E();
        mo38205p();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        AppManager.m57776n().m57787c(mo43912w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AppManager.m57776n().m57771s(mo43912w());
        mo43925F();
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: q */
    public void mo43917q(@NotNull VB vb) {
        C14342f0.m8184p(vb, "<set-?>");
        this.f14969e = vb;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    /* renamed from: r */
    public void mo43916r(@NotNull FragmentActivity fragmentActivity) {
        C14342f0.m8184p(fragmentActivity, "<set-?>");
        this.f14965a = fragmentActivity;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: s */
    public Fragment mo43915s() {
        Fragment fragment = this.f14966b;
        if (fragment != null) {
            return fragment;
        }
        C14342f0.m8200S("mFragment");
        return null;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    public void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner) {
        C14342f0.m8184p(lifecycleOwner, "<set-?>");
        this.f14970f = lifecycleOwner;
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
        this.f14972h = loadingDialog;
    }

    @Override // com.bxkj.base.p085v2.base.BaseUI
    @NotNull
    /* renamed from: w */
    public FragmentActivity mo43912w() {
        FragmentActivity fragmentActivity = this.f14965a;
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
        VM vm = this.f14968d;
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
        this.f14971g = fragmentManager;
    }
}
