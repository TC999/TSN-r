package com.bxkj.base.v2.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseMultiItemAdapter.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00019B\u0019\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c\u00a2\u0006\u0004\b7\u00108J9\u0010\r\u001a\u00028\u0001\"\b\b\u0001\u0010\u0005*\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u001e\u001a\u00020\u00172\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cJ)\u0010\u001f\u001a\u00020\u00172\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u001f\u0010 J/\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0014\u00a2\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020%2\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b(\u0010)J'\u0010-\u001a\u00020\u00172\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH&\u00a2\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u000bH\u0016J\u0017\u00100\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b0\u00101J\u000e\u00102\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cR\u001e\u00105\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00106\u00a8\u0006:"}, d2 = {"Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter$BaseViewHolder;", "Landroidx/viewbinding/ViewBinding;", "VB", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "position", "k", "(Ljava/lang/Object;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/viewbinding/ViewBinding;", "getItemViewType", "itemType", "j", "parent", "viewType", "n", "Landroid/view/View;", "emptyView", "Lkotlin/f1;", "p", "f", "holder", "m", "", "data", "o", "b", "(Ljava/util/List;Ljava/lang/Integer;)V", "oldItem", "newItem", "oldItemPosition", "newItemPosition", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;II)Z", "e", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Landroidx/databinding/ViewDataBinding;", "itemBinding", "bean", "g", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/Object;I)V", "getItemCount", "i", "(I)Ljava/lang/Object;", "h", "a", "Ljava/util/List;", "dataList", "Landroid/view/View;", "<init>", "(Ljava/util/List;)V", "BaseViewHolder", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class BaseMultiItemAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private List<? extends T> f18478a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private View f18479b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BaseMultiItemAdapter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/bxkj/base/v2/base/BaseMultiItemAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/databinding/ViewDataBinding;", "a", "Landroidx/databinding/ViewDataBinding;", "()Landroidx/databinding/ViewDataBinding;", "b", "(Landroidx/databinding/ViewDataBinding;)V", "binding", "<init>", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class BaseViewHolder extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private ViewDataBinding f18481a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull ViewDataBinding binding) {
            super(binding.getRoot());
            f0.p(binding, "binding");
            this.f18481a = binding;
        }

        @NotNull
        public final ViewDataBinding a() {
            return this.f18481a;
        }

        public final void b(@NotNull ViewDataBinding viewDataBinding) {
            f0.p(viewDataBinding, "<set-?>");
            this.f18481a = viewDataBinding;
        }
    }

    public BaseMultiItemAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ BaseMultiItemAdapter(List list, int i4, u uVar) {
        this((i4 & 1) != 0 ? new ArrayList() : list);
    }

    public static /* synthetic */ void c(BaseMultiItemAdapter baseMultiItemAdapter, List list, Integer num, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addData");
        }
        if ((i4 & 2) != 0) {
            num = null;
        }
        baseMultiItemAdapter.b(list, num);
    }

    private final <VB extends ViewBinding> VB k(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i4) {
        Method declaredMethod;
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            f0.o(actualTypeArguments, "javaClass.genericSupercl\u2026Type).actualTypeArguments");
            ArrayList arrayList = new ArrayList();
            for (Type type : actualTypeArguments) {
                if (type instanceof Class) {
                    arrayList.add(type);
                }
            }
            Class<? super T> superclass = ((Class) arrayList.get(0)).getSuperclass();
            if (f0.g(superclass == null ? null : superclass.getSimpleName(), n0.d(ViewDataBinding.class).u())) {
                declaredMethod = ((Class) arrayList.get(i4)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE);
                f0.o(declaredMethod, "{\n                vbClas\u2026          )\n            }");
            } else {
                declaredMethod = ((Class) arrayList.get(1)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE);
                f0.o(declaredMethod, "{\n                vbClas\u2026          )\n            }");
            }
            Object invoke = declaredMethod.invoke(null, layoutInflater, viewGroup, Boolean.FALSE);
            if (invoke != null) {
                return (VB) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseMultiItemAdapter.getViewBinding");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    static /* synthetic */ ViewBinding l(BaseMultiItemAdapter baseMultiItemAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i4, int i5, Object obj2) {
        if (obj2 == null) {
            if ((i5 & 4) != 0) {
                i4 = 0;
            }
            return baseMultiItemAdapter.k(obj, layoutInflater, viewGroup, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
    }

    public final void b(@Nullable List<? extends T> list, @Nullable Integer num) {
        Boolean valueOf;
        int i4 = 0;
        if (list == null || list.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.f18478a);
        if (num == null) {
            valueOf = null;
        } else {
            int intValue = num.intValue();
            if (intValue >= 0) {
                i4 = intValue >= linkedList.size() ? linkedList.size() : intValue;
            }
            valueOf = Boolean.valueOf(linkedList.addAll(i4, list));
        }
        if (valueOf == null) {
            linkedList.addAll(list);
        } else {
            valueOf.booleanValue();
        }
        o(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(T t3, T t4, int i4, int i5) {
        return f0.g(t3, t4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(T t3, T t4) {
        return f0.g(t3, t4);
    }

    public void f() {
        View view = this.f18479b;
        if (view == null) {
            return;
        }
        view.setVisibility(getItemCount() > 0 ? 8 : 0);
    }

    public abstract void g(@NotNull ViewDataBinding viewDataBinding, T t3, int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.f18478a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract int getItemViewType(int i4);

    @Nullable
    public final List<T> h() {
        return (List<? extends T>) this.f18478a;
    }

    @Nullable
    public final T i(int i4) {
        List<T> h4 = h();
        if (h4 == null) {
            return null;
        }
        if (i4 == -1) {
            i4 = 0;
        }
        return h4.get(i4);
    }

    public abstract int j(int i4);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int i4) {
        f0.p(holder, "holder");
        ViewDataBinding a4 = holder.a();
        List<? extends T> list = this.f18478a;
        f0.m(list);
        g(a4, list.get(i4), i4);
        holder.a().executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n */
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        f0.p(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), j(i4), parent, false);
        if (inflate == null) {
            RecyclerView.ViewHolder createViewHolder = super.createViewHolder(parent, i4);
            f0.o(createViewHolder, "{\n            super.crea\u2026rent, viewType)\n        }");
            return (BaseViewHolder) createViewHolder;
        }
        return new BaseViewHolder(inflate);
    }

    public final void o(@Nullable final List<? extends T> list) {
        f1 f1Var;
        if (list == null) {
            f1Var = null;
        } else {
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: com.bxkj.base.v2.base.BaseMultiItemAdapter$setData$1$result$1

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ BaseMultiItemAdapter<T> f18482a;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f18482a = this;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i4, int i5) {
                    List list2;
                    list2 = ((BaseMultiItemAdapter) this.f18482a).f18478a;
                    f0.m(list2);
                    return this.f18482a.d(list2.get(i4), list.get(i5), i4, i5);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i4, int i5) {
                    List list2;
                    list2 = ((BaseMultiItemAdapter) this.f18482a).f18478a;
                    f0.m(list2);
                    return this.f18482a.e(list2.get(i4), list.get(i5));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.f18482a.getItemCount();
                }
            });
            f0.o(calculateDiff, "fun setData(data: List<T\u2026emCount)\n        }\n\n    }");
            this.f18478a = list;
            calculateDiff.dispatchUpdatesTo(this);
            f1Var = f1.f55527a;
        }
        if (f1Var == null) {
            this.f18478a = new ArrayList();
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    public void p(@NotNull View emptyView) {
        f0.p(emptyView, "emptyView");
        this.f18479b = emptyView;
        f();
    }

    public BaseMultiItemAdapter(@Nullable List<? extends T> list) {
        this.f18478a = list;
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: com.bxkj.base.v2.base.BaseMultiItemAdapter.1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ BaseMultiItemAdapter<T> f18480a;

            {
                this.f18480a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                this.f18480a.f();
            }
        });
    }
}
