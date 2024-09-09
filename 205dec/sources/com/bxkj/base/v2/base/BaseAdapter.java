package com.bxkj.base.v2.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;
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
/* compiled from: BaseAdapter.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004:\u0001/B\u0019\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016\u00a2\u0006\u0004\b-\u0010.J9\u0010\u000e\u001a\u00028\u0002\"\b\b\u0002\u0010\u0003*\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001e\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u0018\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016J)\u0010\u0019\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ/\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0014\u00a2\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0000H\u0014\u00a2\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\u00142\u0006\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH&\u00a2\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020\fH\u0016J\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/bxkj/base/v2/base/BaseAdapter;", "T", "Landroidx/databinding/ViewDataBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bxkj/base/v2/base/BaseAdapter$BaseViewHolder;", "Landroidx/viewbinding/ViewBinding;", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "position", "h", "(Ljava/lang/Object;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/viewbinding/ViewBinding;", "parent", "viewType", "k", "holder", "Lkotlin/f1;", "j", "", "data", "l", "b", "(Ljava/util/List;Ljava/lang/Integer;)V", "oldItem", "newItem", "oldItemPosition", "newItemPosition", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;II)Z", "e", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "itemBinding", "bean", "f", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/Object;I)V", "getItemCount", "g", "a", "Ljava/util/List;", "dataList", "<init>", "(Ljava/util/List;)V", "BaseViewHolder", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class BaseAdapter<T, VB extends ViewDataBinding> extends RecyclerView.Adapter<BaseViewHolder<VB>> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private List<? extends T> f18457a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BaseAdapter.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00028\u0002\u00a2\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00028\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/bxkj/base/v2/base/BaseAdapter$BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/databinding/ViewDataBinding;", "()Landroidx/databinding/ViewDataBinding;", "b", "(Landroidx/databinding/ViewDataBinding;)V", "binding", "<init>", "base_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class BaseViewHolder<VB extends ViewDataBinding> extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private VB f18458a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull VB binding) {
            super(binding.getRoot());
            f0.p(binding, "binding");
            this.f18458a = binding;
        }

        @NotNull
        public final VB a() {
            return this.f18458a;
        }

        public final void b(@NotNull VB vb) {
            f0.p(vb, "<set-?>");
            this.f18458a = vb;
        }
    }

    public BaseAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ BaseAdapter(List list, int i4, u uVar) {
        this((i4 & 1) != 0 ? new ArrayList() : list);
    }

    public static /* synthetic */ void c(BaseAdapter baseAdapter, List list, Integer num, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addData");
        }
        if ((i4 & 2) != 0) {
            num = null;
        }
        baseAdapter.b(list, num);
    }

    private final <VB extends ViewBinding> VB h(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i4) {
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
                return (VB) ((ViewBinding) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseAdapter.getViewBinding");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    static /* synthetic */ ViewBinding i(BaseAdapter baseAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i4, int i5, Object obj2) {
        if (obj2 == null) {
            if ((i5 & 4) != 0) {
                i4 = 0;
            }
            return baseAdapter.h(obj, layoutInflater, viewGroup, i4);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
    }

    public final void b(@Nullable List<? extends T> list, @Nullable Integer num) {
        Boolean valueOf;
        int i4 = 0;
        if (list == null || list.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.f18457a);
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
        l(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(T t3, T t4, int i4, int i5) {
        return f0.g(t3, t4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(T t3, T t4) {
        return f0.g(t3, t4);
    }

    public abstract void f(@NotNull VB vb, T t3, int i4);

    @Nullable
    public final List<T> g() {
        return (List<? extends T>) this.f18457a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.f18457a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@NotNull BaseViewHolder<VB> holder, int i4) {
        f0.p(holder, "holder");
        VB a4 = holder.a();
        List<? extends T> list = this.f18457a;
        f0.m(list);
        f(a4, list.get(i4), i4);
        holder.a().executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k */
    public BaseViewHolder<VB> onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        f0.p(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        f0.o(from, "from(parent.context)");
        return new BaseViewHolder<>(h(this, from, parent, 0));
    }

    public final void l(@Nullable final List<? extends T> list) {
        f1 f1Var;
        if (list == null) {
            f1Var = null;
        } else {
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: com.bxkj.base.v2.base.BaseAdapter$setData$1$result$1

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ BaseAdapter<T, VB> f18459a;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f18459a = this;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i4, int i5) {
                    List list2;
                    list2 = ((BaseAdapter) this.f18459a).f18457a;
                    f0.m(list2);
                    return this.f18459a.d(list2.get(i4), list.get(i5), i4, i5);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i4, int i5) {
                    List list2;
                    list2 = ((BaseAdapter) this.f18459a).f18457a;
                    f0.m(list2);
                    return this.f18459a.e(list2.get(i4), list.get(i5));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.f18459a.getItemCount();
                }
            });
            f0.o(calculateDiff, "fun setData(data: List<T\u2026emCount)\n        }\n\n    }");
            this.f18457a = list;
            calculateDiff.dispatchUpdatesTo(this);
            f1Var = f1.f55527a;
        }
        if (f1Var == null) {
            this.f18457a = new ArrayList();
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    public BaseAdapter(@Nullable List<? extends T> list) {
        this.f18457a = list;
    }
}
