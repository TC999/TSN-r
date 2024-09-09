package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.databinding.ViewDataBindingKtx;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.flow.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: ViewDataBindingKtx.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Landroidx/databinding/ViewDataBindingKtx;", "", "Landroidx/databinding/ViewDataBinding;", "viewDataBinding", "", "localFieldId", "Lkotlinx/coroutines/flow/h;", "observable", "", "updateStateFlowRegistration", "Landroidx/databinding/CreateWeakListener;", "CREATE_STATE_FLOW_LISTENER", "Landroidx/databinding/CreateWeakListener;", "<init>", "()V", "StateFlowListener", "databindingKtx_release"}, k = 1, mv = {1, 5, 1})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class ViewDataBindingKtx {
    @NotNull
    public static final ViewDataBindingKtx INSTANCE = new ViewDataBindingKtx();
    @NotNull
    private static final CreateWeakListener CREATE_STATE_FLOW_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBindingKtx$CREATE_STATE_FLOW_LISTENER$1
        @Override // androidx.databinding.CreateWeakListener
        public final WeakListener create(ViewDataBinding viewDataBinding, int i4, ReferenceQueue<ViewDataBinding> referenceQueue) {
            f0.o(referenceQueue, "referenceQueue");
            return new ViewDataBindingKtx.StateFlowListener(viewDataBinding, i4, referenceQueue).getListener();
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: ViewDataBindingKtx.kt */
    @Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001B'\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\tH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u001a\u0010\r\u001a\u00020\u00072\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006 "}, d2 = {"Landroidx/databinding/ViewDataBindingKtx$StateFlowListener;", "Landroidx/databinding/ObservableReference;", "Lkotlinx/coroutines/flow/h;", "", "Landroidx/lifecycle/LifecycleOwner;", "owner", "flow", "Lkotlin/f1;", "startCollection", "Landroidx/databinding/WeakListener;", "getListener", "target", "addListener", "removeListener", "lifecycleOwner", "setLifecycleOwner", "Ljava/lang/ref/WeakReference;", "_lifecycleOwnerRef", "Ljava/lang/ref/WeakReference;", "Lkotlinx/coroutines/e2;", "observerJob", "Lkotlinx/coroutines/e2;", "listener", "Landroidx/databinding/WeakListener;", "Landroidx/databinding/ViewDataBinding;", "binder", "", "localFieldId", "Ljava/lang/ref/ReferenceQueue;", "referenceQueue", "<init>", "(Landroidx/databinding/ViewDataBinding;ILjava/lang/ref/ReferenceQueue;)V", "databindingKtx_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static final class StateFlowListener implements ObservableReference<h<? extends Object>> {
        @Nullable
        private WeakReference<LifecycleOwner> _lifecycleOwnerRef;
        @NotNull
        private final WeakListener<h<Object>> listener;
        @Nullable
        private e2 observerJob;

        public StateFlowListener(@Nullable ViewDataBinding viewDataBinding, int i4, @NotNull ReferenceQueue<ViewDataBinding> referenceQueue) {
            f0.p(referenceQueue, "referenceQueue");
            this.listener = new WeakListener<>(viewDataBinding, i4, this, referenceQueue);
        }

        private final void startCollection(LifecycleOwner lifecycleOwner, h<? extends Object> hVar) {
            e2 e2Var = this.observerJob;
            if (e2Var != null) {
                e2.a.b(e2Var, null, 1, null);
            }
            this.observerJob = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenCreated(new ViewDataBindingKtx$StateFlowListener$startCollection$1(hVar, this, null));
        }

        @Override // androidx.databinding.ObservableReference
        @NotNull
        public WeakListener<h<? extends Object>> getListener() {
            return this.listener;
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if ((weakReference == null ? null : weakReference.get()) == lifecycleOwner) {
                return;
            }
            e2 e2Var = this.observerJob;
            if (e2Var != null) {
                e2.a.b(e2Var, null, 1, null);
            }
            if (lifecycleOwner == null) {
                this._lifecycleOwnerRef = null;
                return;
            }
            this._lifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            h<Object> target = this.listener.getTarget();
            if (target != null) {
                startCollection(lifecycleOwner, target);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(@Nullable h<? extends Object> hVar) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            LifecycleOwner lifecycleOwner = weakReference == null ? null : weakReference.get();
            if (lifecycleOwner == null || hVar == null) {
                return;
            }
            startCollection(lifecycleOwner, hVar);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(@Nullable h<? extends Object> hVar) {
            e2 e2Var = this.observerJob;
            if (e2Var != null) {
                e2.a.b(e2Var, null, 1, null);
            }
            this.observerJob = null;
        }
    }

    private ViewDataBindingKtx() {
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean updateStateFlowRegistration(@NotNull ViewDataBinding viewDataBinding, int i4, @Nullable h<?> hVar) {
        f0.p(viewDataBinding, "viewDataBinding");
        viewDataBinding.mInStateFlowRegisterObserver = true;
        try {
            return viewDataBinding.updateRegistration(i4, hVar, CREATE_STATE_FLOW_LISTENER);
        } finally {
            viewDataBinding.mInStateFlowRegisterObserver = false;
        }
    }
}
