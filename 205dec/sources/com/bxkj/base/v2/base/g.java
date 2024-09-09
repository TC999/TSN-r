package com.bxkj.base.v2.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
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
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.base.v2.base.g;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.text.x;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseUI.kt */
@Metadata(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005J%\u0010\n\u001a\u00028\u0002\"\b\b\u0002\u0010\u0002*\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\u000e\u001a\u00028\u0002\"\b\b\u0002\u0010\u0002*\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00028\u0002\"\b\b\u0002\u0010\u0004*\u00020\u0010*\u00020\u00072\b\b\u0001\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\u0014\u0010\u001a\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002R\u001c\u0010 \u001a\u00020\u001b8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010&\u001a\u00020!8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010,\u001a\u00020'8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u00101\u001a\u00028\u00018&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00106\u001a\u00028\u00008&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010<\u001a\u0002078&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010B\u001a\u00020=8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010H\u001a\u0004\u0018\u00010C8&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G\u00a8\u0006I"}, d2 = {"Lcom/bxkj/base/v2/base/g;", "Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Lcom/bxkj/base/v2/base/a;", "Landroidx/viewbinding/ViewBinding;", "", "Landroid/view/LayoutInflater;", "inflater", "G", "(Ljava/lang/Object;Landroid/view/LayoutInflater;)Landroidx/viewbinding/ViewBinding;", "Landroid/view/ViewGroup;", "container", "K", "(Ljava/lang/Object;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "u", "(Ljava/lang/Object;Landroidx/lifecycle/ViewModelStoreOwner;)Landroidx/lifecycle/ViewModel;", "Lkotlin/f1;", "y", "F", "", "message", "showProgressDialog", "Landroidx/fragment/app/FragmentActivity;", "w", "()Landroidx/fragment/app/FragmentActivity;", "r", "(Landroidx/fragment/app/FragmentActivity;)V", "mActivity", "Landroidx/fragment/app/Fragment;", "s", "()Landroidx/fragment/app/Fragment;", "A", "(Landroidx/fragment/app/Fragment;)V", "mFragment", "Landroid/content/Context;", "C", "()Landroid/content/Context;", "L", "(Landroid/content/Context;)V", "mContext", "x", "()Lcom/bxkj/base/v2/base/BaseViewModel;", "a", "(Lcom/bxkj/base/v2/base/BaseViewModel;)V", "mViewModel", "M", "()Landroidx/databinding/ViewDataBinding;", CampaignEx.JSON_KEY_AD_Q, "(Landroidx/databinding/ViewDataBinding;)V", "mDataBinding", "Landroidx/lifecycle/LifecycleOwner;", "B", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/fragment/app/FragmentManager;", "J", "()Landroidx/fragment/app/FragmentManager;", "z", "(Landroidx/fragment/app/FragmentManager;)V", "dialogFagmentManager", "Lcom/bxkj/base/v2/base/m;", "o", "()Lcom/bxkj/base/v2/base/m;", "v", "(Lcom/bxkj/base/v2/base/m;)V", "loadingDialog", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface g<VB extends ViewDataBinding, VM extends BaseViewModel> extends com.bxkj.base.v2.base.a<VB> {

    /* compiled from: BaseUI.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BaseUI.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.base.g$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class C0199a extends Lambda implements l1.l<iOSOneButtonDialog, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f18519a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ g<VB, VM> f18520b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0199a(String str, g<VB, VM> gVar) {
                super(1);
                this.f18519a = str;
                this.f18520b = gVar;
            }

            public final void a(@NotNull iOSOneButtonDialog it) {
                boolean V2;
                f0.p(it, "it");
                String msg = this.f18519a;
                f0.o(msg, "msg");
                V2 = x.V2(msg, "\u767b\u5f55\u5931\u6548", false, 2, null);
                if (V2) {
                    this.f18520b.w().startActivity(new Intent().setClassName(this.f18520b.C(), f0.g(this.f18520b.C().getPackageName(), "com.bxkj.student") ? "com.bxkj.student.v2.ui.LoginActivity" : "com.bxkj.teacher.v2.ui.LoginActivity").setFlags(268468224));
                }
            }

            @Override // l1.l
            public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
                a(iosonebuttondialog);
                return f1.f55527a;
            }
        }

        /* compiled from: BaseUI.kt */
        @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/base/g$a$b", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "base_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class b implements DialogInterface.OnKeyListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g<VB, VM> f18521a;

            b(g<VB, VM> gVar) {
                this.f18521a = gVar;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(@Nullable DialogInterface dialogInterface, int i4, @Nullable KeyEvent keyEvent) {
                if (i4 == 4) {
                    m o4 = this.f18521a.o();
                    if (o4 != null) {
                        o4.b();
                    }
                    e2 b4 = this.f18521a.x().b();
                    if (b4 == null) {
                        return true;
                    }
                    b4.b(new CancellationException());
                    return true;
                }
                return false;
            }
        }

        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void f(@NotNull final g<VB, VM> gVar) {
            f0.p(gVar, "this");
            VM x3 = gVar.x();
            x3.c().observe(gVar.B(), new Observer() { // from class: com.bxkj.base.v2.base.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.g(g.this, (Integer) obj);
                }
            });
            x3.e().observe(gVar.B(), new Observer() { // from class: com.bxkj.base.v2.base.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.h(g.this, (String) obj);
                }
            });
            x3.f().observe(gVar.B(), new Observer() { // from class: com.bxkj.base.v2.base.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.i(g.this, (String) obj);
                }
            });
            x3.h().observe(gVar.B(), new Observer() { // from class: com.bxkj.base.v2.base.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.j(g.this, (String) obj);
                }
            });
            x3.g().observe(gVar.B(), new Observer() { // from class: com.bxkj.base.v2.base.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.k(g.this, (String) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(g this$0, Integer it) {
            f0.p(this$0, "this$0");
            f0.o(it, "it");
            if (it.intValue() > 0) {
                p(this$0, this$0.x().d().getValue());
            } else {
                this$0.F();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(g this$0, String msg) {
            f0.p(this$0, "this$0");
            if (msg == null) {
                return;
            }
            Context C = this$0.C();
            f0.o(msg, "msg");
            ContextExtKt.n(C, msg, new C0199a(msg, this$0)).setCancelable(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(g this$0, String str) {
            f0.p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExtKt.m(this$0.C(), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(g this$0, String str) {
            f0.p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExtKt.q(this$0.C(), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(g this$0, String str) {
            f0.p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExtKt.p(this$0.C(), str);
        }

        @NotNull
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB l(@NotNull g<VB_I1, VM> gVar, @NotNull Object receiver, @NotNull LayoutInflater inflater) {
            f0.p(gVar, "this");
            f0.p(receiver, "receiver");
            f0.p(inflater, "inflater");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                f0.o(actualTypeArguments, "javaClass.genericSupercl\u2026Type).actualTypeArguments");
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
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB m(@NotNull g<VB_I1, VM> gVar, @NotNull Object receiver, @NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup) {
            f0.p(gVar, "this");
            f0.p(receiver, "receiver");
            f0.p(inflater, "inflater");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                f0.o(actualTypeArguments, "javaClass.genericSupercl\u2026Type).actualTypeArguments");
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
        public static <VB extends ViewDataBinding, VM_I1 extends BaseViewModel, VM extends ViewModel> VM n(@NotNull g<VB, VM_I1> gVar, @NotNull Object receiver, @NonNull @NotNull ViewModelStoreOwner owner) {
            f0.p(gVar, "this");
            f0.p(receiver, "receiver");
            f0.p(owner, "owner");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                f0.o(actualTypeArguments, "this.javaClass.genericSu\u2026Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                for (Type type : actualTypeArguments) {
                    if (type instanceof Class) {
                        arrayList.add(type);
                    }
                }
                VM vm = (VM) new ViewModelProvider(owner).get((Class) arrayList.get(1));
                f0.o(vm, "ViewModelProvider(owner).get(vmClass)");
                return vm;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }

        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void o(@NotNull g<VB, VM> gVar) {
            f0.p(gVar, "this");
            m o4 = gVar.o();
            if (o4 == null) {
                return;
            }
            o4.b();
        }

        private static <VB extends ViewDataBinding, VM extends BaseViewModel> void p(g<VB, VM> gVar, String str) {
            if (gVar.o() == null) {
                gVar.v(new m(gVar.C()));
                m o4 = gVar.o();
                if (o4 != null) {
                    o4.g(new b(gVar));
                }
            }
            m o5 = gVar.o();
            if (o5 == null) {
                return;
            }
            o5.i(str);
        }

        public static /* synthetic */ void q(g gVar, String str, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgressDialog");
            }
            if ((i4 & 1) != 0) {
                str = "loading...";
            }
            p(gVar, str);
        }
    }

    void A(@NotNull Fragment fragment);

    @NotNull
    LifecycleOwner B();

    @NotNull
    Context C();

    void F();

    @NotNull
    <VB extends ViewBinding> VB G(@NotNull Object obj, @NotNull LayoutInflater layoutInflater);

    @NotNull
    FragmentManager J();

    @NotNull
    <VB extends ViewBinding> VB K(@NotNull Object obj, @NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup);

    void L(@NotNull Context context);

    @NotNull
    VB M();

    void a(@NotNull VM vm);

    @Nullable
    m o();

    void q(@NotNull VB vb);

    void r(@NotNull FragmentActivity fragmentActivity);

    @NotNull
    Fragment s();

    void setLifecycleOwner(@NotNull LifecycleOwner lifecycleOwner);

    @NotNull
    <VM extends ViewModel> VM u(@NotNull Object obj, @NonNull @NotNull ViewModelStoreOwner viewModelStoreOwner);

    void v(@Nullable m mVar);

    @NotNull
    FragmentActivity w();

    @NotNull
    VM x();

    void y();

    void z(@NotNull FragmentManager fragmentManager);
}
