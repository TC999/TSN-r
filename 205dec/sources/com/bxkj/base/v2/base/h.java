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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewbinding.ViewBinding;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.v2.base.g;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aX\u0010\u000b\u001a\u0004\u0018\u00018\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002\"\n\b\u0002\u0010\u0005\u0018\u0001*\u00020\u0004*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0086\b\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Landroidx/fragment/app/Fragment;", "F", "Lcom/bxkj/base/v2/base/g;", "Landroidx/navigation/fragment/NavHostFragment;", "navHostFragment", "Ljava/lang/Class;", "fragmentClass", "a", "(Lcom/bxkj/base/v2/base/g;Landroidx/navigation/fragment/NavHostFragment;Ljava/lang/Class;)Landroidx/fragment/app/Fragment;", "base_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class h {

    /* compiled from: BaseUI.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BaseUI.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\n"}, d2 = {"Landroidx/databinding/ViewDataBinding;", "VB", "Lcom/bxkj/base/v2/base/BaseViewModel;", "VM", "Lcn/bluemobi/dylan/base/view/iOSOneButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.bxkj.base.v2.base.h$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public static final class C0200a extends Lambda implements d2.l<iOSOneButtonDialog, f1> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f18522a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h<VB, VM> f18523b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0200a(String str, h<VB, VM> hVar) {
                super(1);
                this.f18522a = str;
                this.f18523b = hVar;
            }

            public final void a(@NotNull iOSOneButtonDialog it) {
                boolean V2;
                f0.p(it, "it");
                String msg = this.f18522a;
                f0.o(msg, "msg");
                V2 = x.V2(msg, "\u767b\u5f55\u5931\u6548", false, 2, null);
                if (V2) {
                    this.f18523b.w().startActivity(new Intent().setClassName(this.f18523b.C(), f0.g(this.f18523b.C().getPackageName(), "com.bxkj.student") ? "com.bxkj.student.v2.ui.LoginActivity" : "com.bxkj.teacher.v2.ui.LoginActivity").setFlags(268468224));
                }
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(iOSOneButtonDialog iosonebuttondialog) {
                a(iosonebuttondialog);
                return f1.f55527a;
            }
        }

        /* compiled from: BaseUI.kt */
        @Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/bxkj/base/v2/base/h$a$b", "Landroid/content/DialogInterface$OnKeyListener;", "Landroid/content/DialogInterface;", "dialog", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "base_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: E:\TSN-r\205dec\4499832.dex */
        public static final class b implements DialogInterface.OnKeyListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h<VB, VM> f18524a;

            b(h<VB, VM> hVar) {
                this.f18524a = hVar;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(@Nullable DialogInterface dialogInterface, int i4, @Nullable KeyEvent keyEvent) {
                if (i4 == 4) {
                    n o4 = this.f18524a.o();
                    if (o4 != null) {
                        o4.b();
                    }
                    e2 b4 = this.f18524a.x().b();
                    if (b4 == null) {
                        return true;
                    }
                    b4.b(new CancellationException());
                    return true;
                }
                return false;
            }
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.lifecycle.Observer, com.bxkj.base.v2.base.g] */
        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void f(@NotNull h<VB, VM> hVar) {
            f0.p(hVar, "this");
            BaseViewModel x3 = hVar.x();
            x3.c().observe(hVar.B(), new Observer(hVar) { // from class: com.bxkj.base.v2.base.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.k(g.this, (String) obj);
                }
            });
            x3.e().observe(hVar.B(), new g(hVar));
            x3.f().observe(hVar.B(), new Observer(hVar) { // from class: com.bxkj.base.v2.base.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.h(g.this, (String) obj);
                }
            });
            x3.h().observe(hVar.B(), new Observer(hVar) { // from class: com.bxkj.base.v2.base.e
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.i(g.this, (String) obj);
                }
            });
            x3.g().observe(hVar.B(), new Observer(hVar) { // from class: com.bxkj.base.v2.base.d
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    g.a.j(g.this, (String) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(h this$0, Integer it) {
            f0.p(this$0, "this$0");
            f0.o(it, "it");
            if (it.intValue() > 0) {
                p(this$0, this$0.x().d().getValue());
            } else {
                this$0.F();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(h this$0, String msg) {
            f0.p(this$0, "this$0");
            if (msg == null) {
                return;
            }
            Context C = this$0.C();
            f0.o(msg, "msg");
            ContextExtKt.n(C, msg, new C0200a(msg, this$0)).setCancelable(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(h this$0, String str) {
            f0.p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExtKt.m(this$0.C(), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(h this$0, String str) {
            f0.p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExtKt.q(this$0.C(), str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(h this$0, String str) {
            f0.p(this$0, "this$0");
            if (str == null) {
                return;
            }
            ContextExtKt.p(this$0.C(), str);
        }

        @NotNull
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB l(@NotNull h<VB_I1, VM> hVar, @NotNull Object receiver, @NotNull LayoutInflater inflater) {
            f0.p(hVar, "this");
            f0.p(receiver, "receiver");
            f0.p(inflater, "inflater");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                f0.o(actualTypeArguments, "javaClass.genericSupercl\u2026Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                int length = actualTypeArguments.length;
                int i4 = 0;
                while (i4 < length) {
                    Type type = actualTypeArguments[i4];
                    i4++;
                    if (type instanceof Class) {
                        arrayList.add(type);
                    }
                }
                Object invoke = ((Class) arrayList.get(0)).getDeclaredMethod("inflate", LayoutInflater.class).invoke(null, inflater);
                if (invoke != null) {
                    return (VB) invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseUI.getActivityViewBinding");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }

        @NotNull
        public static <VB_I1 extends ViewDataBinding, VM extends BaseViewModel, VB extends ViewBinding> VB m(@NotNull h<VB_I1, VM> hVar, @NotNull Object receiver, @NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup) {
            f0.p(hVar, "this");
            f0.p(receiver, "receiver");
            f0.p(inflater, "inflater");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                f0.o(actualTypeArguments, "javaClass.genericSupercl\u2026Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                int length = actualTypeArguments.length;
                int i4 = 0;
                while (i4 < length) {
                    Type type = actualTypeArguments[i4];
                    i4++;
                    if (type instanceof Class) {
                        arrayList.add(type);
                    }
                }
                Object invoke = ((Class) arrayList.get(0)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, inflater, viewGroup, Boolean.FALSE);
                if (invoke != null) {
                    return (VB) invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseUI.getFragmentViewBinding");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        }

        @NotNull
        public static <VB extends ViewDataBinding, VM_I1 extends BaseViewModel, VM extends ViewModel> VM n(@NotNull h<VB, VM_I1> hVar, @NotNull Object receiver, @NonNull @NotNull ViewModelStoreOwner owner) {
            f0.p(hVar, "this");
            f0.p(receiver, "receiver");
            f0.p(owner, "owner");
            Type genericSuperclass = receiver.getClass().getGenericSuperclass();
            if (genericSuperclass != null) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                f0.o(actualTypeArguments, "this.javaClass.genericSu\u2026Type).actualTypeArguments");
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                int length = actualTypeArguments.length;
                while (i4 < length) {
                    Type type = actualTypeArguments[i4];
                    i4++;
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

        public static <VB extends ViewDataBinding, VM extends BaseViewModel> void o(@NotNull h<VB, VM> hVar) {
            f0.p(hVar, "this");
            n o4 = hVar.o();
            if (o4 == null) {
                return;
            }
            o4.b();
        }

        private static <VB extends ViewDataBinding, VM extends BaseViewModel> void p(h<VB, VM> hVar, String str) {
            if (hVar.o() == null) {
                hVar.v(new n(hVar.C()));
                n o4 = hVar.o();
                if (o4 != null) {
                    o4.g(new b(hVar));
                }
            }
            n o5 = hVar.o();
            if (o5 == null) {
                return;
            }
            o5.i(str);
        }

        public static /* synthetic */ void q(h hVar, String str, int i4, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgressDialog");
            }
            if ((i4 & 1) != 0) {
                str = "loading...";
            }
            p(hVar, str);
        }
    }

    public static final /* synthetic */ <VB extends ViewDataBinding, VM extends BaseViewModel, F extends Fragment> F a(g<VB, VM> gVar, NavHostFragment navHostFragment, Class<F> fragmentClass) {
        f0.p(gVar, "<this>");
        f0.p(navHostFragment, "navHostFragment");
        f0.p(fragmentClass, "fragmentClass");
        List<Fragment> fragments = navHostFragment.getChildFragmentManager().getFragments();
        f0.o(fragments, "navHostFragment.childFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (it.hasNext()) {
            F f4 = (F) it.next();
            if (fragmentClass.isAssignableFrom(f4.getClass())) {
                f0.y(1, "F");
                return f4;
            }
        }
        return null;
    }
}
