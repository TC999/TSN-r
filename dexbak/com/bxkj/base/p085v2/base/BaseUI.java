package com.bxkj.base.p085v2.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewbinding.ViewBinding;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bxkj.base.p085v2.base.BaseUI;
import com.bxkj.base.p085v2.base.BaseViewModel;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.student.C4229c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.C14579x;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005J%\u0010\n\u001a\u00028\u0002\"\b\b\u0002\u0010\u0002*\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00028\u0002\"\b\b\u0002\u0010\u0002*\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00028\u0002\"\b\b\u0002\u0010\u0004*\u00020\u0010*\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0014\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002R\u001c\u0010 \u001a\u00020\u001b8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u00020!8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010,\u001a\u00020'8&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u00101\u001a\u00028\u00018&@&X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00106\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010<\u001a\u0002078&@&X¦\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010B\u001a\u00020=8&@&X¦\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010H\u001a\u0004\u0018\u00010C8&@&X¦\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006I"}, m12616d2 = {"Lcom/bxkj/base/v2/base/g;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Lcom/bxkj/base/v2/base/a;", "Landroidx/viewbinding/ViewBinding;", "", "Landroid/view/LayoutInflater;", "inflater", "G", "(Ljava/lang/Object;Landroid/view/LayoutInflater;)Landroidx/viewbinding/ViewBinding;", "Landroid/view/ViewGroup;", "container", "K", "(Ljava/lang/Object;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "u", "(Ljava/lang/Object;Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/ViewModel;", "Lkotlin/f1;", "y", "F", "", "message", "showProgressDialog", "Landroidx/fragment/app/FragmentActivity;", IAdInterListener.AdReqParam.WIDTH, "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "a", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", UMCommonContent.f37777aG, "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface BaseUI<VB extends ViewDataBinding, VM extends BaseViewModel> extends BaseDataBinding<VB> {

    /* compiled from: BaseUI.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1}, m12612xi = 48)
    /* renamed from: com.bxkj.base.v2.base.g$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C3928a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BaseUI.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, m12616d2 = {"Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.base.g$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class C3929a extends Lambda implements InterfaceC15280l<iOSOneButtonDialog, Unit> {

            /* renamed from: a */
            final /* synthetic */ String f15035a;

            /* renamed from: b */
            final /* synthetic */ BaseUI<VB, VM> f15036b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C3929a(String str, BaseUI<VB, VM> baseUI) {
                super(1);
                this.f15035a = str;
                this.f15036b = baseUI;
            }

            /* renamed from: a */
            public final void m43891a(@NotNull iOSOneButtonDialog it) {
                boolean m6465V2;
                C14342f0.m8184p(it, "it");
                String msg = this.f15035a;
                C14342f0.m8185o(msg, "msg");
                m6465V2 = C14579x.m6465V2(msg, "登录失效", false, 2, null);
                if (m6465V2) {
                    this.f15036b.mo43912w().startActivity(new Intent().setClassName(this.f15036b.mo43926C(), C14342f0.m8193g(this.f15036b.mo43926C().getPackageName(), C4229c.f16086b) ? "com.bxkj.student.v2.ui.LoginActivity" : "com.bxkj.teacher.v2.ui.LoginActivity").setFlags(268468224));
                }
            }

            @Override // p617l1.InterfaceC15280l
            public /* bridge */ /* synthetic */ Unit invoke(iOSOneButtonDialog iosonebuttondialog) {
                m43891a(iosonebuttondialog);
                return Unit.f41048a;
            }
        }

        /* compiled from: BaseUI.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, m12616d2 = {"com/bxkj/base/v2/base/g$a$b", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.base.g$a$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public static final class DialogInterface$OnKeyListenerC3930b implements DialogInterface.OnKeyListener {

            /* renamed from: a */
            final /* synthetic */ BaseUI<VB, VM> f15037a;

            DialogInterface$OnKeyListenerC3930b(BaseUI<VB, VM> baseUI) {
                this.f15037a = baseUI;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(@Nullable DialogInterface dialogInterface, int i, @Nullable KeyEvent keyEvent) {
                if (i == 4) {
                    LoadingDialog mo43918o = this.f15037a.mo43918o();
                    if (mo43918o != null) {
                        mo43918o.m43874b();
                    }
                    Job m43957b = this.f15037a.mo43911x().m43957b();
                    if (m43957b == null) {
                        return true;
                    }
                    m43957b.mo3827b(new CancellationException());
                    return true;
                }
                return false;
            }
        }

        /* renamed from: f */
        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void m43903f(@NotNull final BaseUI<VB, VM> baseUI) {
            C14342f0.m8184p(baseUI, "this");
            VM mo43911x = baseUI.mo43911x();
            mo43911x.m43956c().observe(baseUI.mo43927B(), new Observer() { // from class: com.bxkj.base.v2.base.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseUI.C3928a.m43902g(BaseUI.this, (Integer) obj);
                }
            });
            mo43911x.m43954e().observe(baseUI.mo43927B(), new Observer() { // from class: com.bxkj.base.v2.base.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseUI.C3928a.m43901h(BaseUI.this, (String) obj);
                }
            });
            mo43911x.m43953f().observe(baseUI.mo43927B(), new Observer() { // from class: com.bxkj.base.v2.base.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseUI.C3928a.m43900i(BaseUI.this, (String) obj);
                }
            });
            mo43911x.m43951h().observe(baseUI.mo43927B(), new Observer() { // from class: com.bxkj.base.v2.base.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseUI.C3928a.m43899j(BaseUI.this, (String) obj);
                }
            });
            mo43911x.m43952g().observe(baseUI.mo43927B(), new Observer() { // from class: com.bxkj.base.v2.base.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseUI.C3928a.m43898k(BaseUI.this, (String) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: g */
        public static final void m43902g(BaseUI this$0, Integer it) {
            C14342f0.m8184p(this$0, "this$0");
            C14342f0.m8185o(it, "it");
            if (it.intValue() > 0) {
                m43893p(this$0, this$0.mo43911x().m43955d().getValue());
            } else {
                this$0.mo43925F();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: h */
        public static final void m43901h(BaseUI this$0, String msg) {
            C14342f0.m8184p(this$0, "this$0");
            if (msg == null) {
                return;
            }
            Context mo43926C = this$0.mo43926C();
            C14342f0.m8185o(msg, "msg");
            ContextExt.m43850n(mo43926C, msg, new C3929a(msg, this$0)).setCancelable(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: i */
        public static final void m43900i(BaseUI this$0, String str) {
            C14342f0.m8184p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExt.m43851m(this$0.mo43926C(), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: j */
        public static final void m43899j(BaseUI this$0, String str) {
            C14342f0.m8184p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExt.m43847q(this$0.mo43926C(), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: k */
        public static final void m43898k(BaseUI this$0, String str) {
            C14342f0.m8184p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExt.m43848p(this$0.mo43926C(), str);
        }

        @NotNull
        /* renamed from: l */
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB m43897l(@NotNull BaseUI<VB_I1, VM> baseUI, @NotNull Object receiver, @NotNull LayoutInflater inflater) {
            C14342f0.m8184p(baseUI, "this");
            C14342f0.m8184p(receiver, "receiver");
            C14342f0.m8184p(inflater, "inflater");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                C14342f0.m8185o(actualTypeArguments, "javaClass.genericSupercl…Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        arrayList.add(type);
                    }
                }
                Object invoke = ((Class) arrayList.get(0)).getDeclaredMethod("inflate", LayoutInflater.class).invoke(null, inflater);
                if (invoke != null) {
                    return (VB) ((ViewBinding) invoke);
                }
                throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseUI.getActivityViewBinding");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }

        @NotNull
        /* renamed from: m */
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB m43896m(@NotNull BaseUI<VB_I1, VM> baseUI, @NotNull Object receiver, @NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup) {
            C14342f0.m8184p(baseUI, "this");
            C14342f0.m8184p(receiver, "receiver");
            C14342f0.m8184p(inflater, "inflater");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                C14342f0.m8185o(actualTypeArguments, "javaClass.genericSupercl…Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        arrayList.add(type);
                    }
                }
                Object invoke = ((Class) arrayList.get(0)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, inflater, viewGroup, Boolean.FALSE);
                if (invoke != null) {
                    return (VB) ((ViewBinding) invoke);
                }
                throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseUI.getFragmentViewBinding");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }

        @NotNull
        /* renamed from: n */
        public static <VB extends ViewDataBinding, VM_I1 extends BaseViewModel, VM extends ViewModel> VM m43895n(@NotNull BaseUI<VB, VM_I1> baseUI, @NotNull Object receiver, @NonNull @NotNull ViewModelStoreOwner owner) {
            C14342f0.m8184p(baseUI, "this");
            C14342f0.m8184p(receiver, "receiver");
            C14342f0.m8184p(owner, "owner");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                C14342f0.m8185o(actualTypeArguments, "this.javaClass.genericSu…Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        arrayList.add(type);
                    }
                }
                VM vm = (VM) new ViewModelProvider(owner).get((Class) arrayList.get(1));
                C14342f0.m8185o(vm, "ViewModelProvider(owner).get(vmClass)");
                return vm;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }

        /* renamed from: o */
        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void m43894o(@NotNull BaseUI<VB, VM> baseUI) {
            C14342f0.m8184p(baseUI, "this");
            LoadingDialog mo43918o = baseUI.mo43918o();
            if (mo43918o == null) {
                return;
            }
            mo43918o.m43874b();
        }

        /* renamed from: p */
        private static <VB extends ViewDataBinding, VM extends BaseViewModel> void m43893p(BaseUI<VB, VM> baseUI, String str) {
            if (baseUI.mo43918o() == null) {
                baseUI.mo43913v(new LoadingDialog(baseUI.mo43926C()));
                LoadingDialog mo43918o = baseUI.mo43918o();
                if (mo43918o != null) {
                    mo43918o.m43869g(new DialogInterface$OnKeyListenerC3930b(baseUI));
                }
            }
            LoadingDialog mo43918o2 = baseUI.mo43918o();
            if (mo43918o2 == null) {
                return;
            }
            mo43918o2.m43867i(str);
        }

        /* renamed from: q */
        public static /* synthetic */ void m43892q(BaseUI baseUI, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgressDialog");
            }
            if ((i & 1) != 0) {
                str = "loading...";
            }
            m43893p(baseUI, str);
        }
    }

    /* renamed from: A */
    void mo43928A(@NotNull Fragment fragment);

    @NotNull
    /* renamed from: B */
    LifecycleOwner mo43927B();

    @NotNull
    /* renamed from: C */
    Context mo43926C();

    /* renamed from: F */
    void mo43925F();

    @NotNull
    /* renamed from: G */
    <VB extends ViewBinding> VB mo43924G(@NotNull Object obj, @NotNull LayoutInflater layoutInflater);

    @NotNull
    /* renamed from: J */
    FragmentManager mo43923J();

    @NotNull
    /* renamed from: K */
    <VB extends ViewBinding> VB mo43922K(@NotNull Object obj, @NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    /* renamed from: L */
    void mo43921L(@NotNull Context context);

    @NotNull
    /* renamed from: M */
    VB mo43920M();

    /* renamed from: a */
    void mo43919a(@NotNull VM vm);

    @Nullable
    /* renamed from: o */
    LoadingDialog mo43918o();

    /* renamed from: q */
    void mo43917q(@NotNull VB vb);

    /* renamed from: r */
    void mo43916r(@NotNull FragmentActivity fragmentActivity);

    @NotNull
    /* renamed from: s */
    Fragment mo43915s();

    void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner);

    @NotNull
    /* renamed from: u */
    <VM extends ViewModel> VM mo43914u(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner);

    /* renamed from: v */
    void mo43913v(@Nullable LoadingDialog loadingDialog);

    @NotNull
    /* renamed from: w */
    FragmentActivity mo43912w();

    @NotNull
    /* renamed from: x */
    VM mo43911x();

    /* renamed from: y */
    void mo43910y();

    /* renamed from: z */
    void mo43909z(@NotNull FragmentManager fragmentManager);
}
