package com.bxkj.base.p085v2.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
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
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseMultiItemAdapter.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00019B\u0019\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c¢\u0006\u0004\b7\u00108J9\u0010\r\u001a\u00028\u0001\"\b\b\u0001\u0010\u0005*\u00020\u0004*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u001e\u001a\u00020\u00172\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cJ)\u0010\u001f\u001a\u00020\u00172\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001f\u0010 J/\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH\u0014¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020%2\u0006\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000H\u0014¢\u0006\u0004\b(\u0010)J'\u0010-\u001a\u00020\u00172\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\u000bH\u0016J\u0017\u00100\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b0\u00101J\u000e\u00102\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001cR\u001e\u00105\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00106¨\u0006:"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter$BaseViewHolder;", "Landroidx/viewbinding/ViewBinding;", "VB", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "position", "k", "(Ljava/lang/Object;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/viewbinding/ViewBinding;", "getItemViewType", "itemType", "j", "parent", "viewType", "n", "Landroid/view/View;", "emptyView", "Lkotlin/f1;", "p", "f", "holder", "m", "", "data", "o", "b", "(Ljava/util/List;Ljava/lang/Integer;)V", "oldItem", "newItem", "oldItemPosition", "newItemPosition", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;II)Z", "e", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Landroidx/databinding/ViewDataBinding;", "itemBinding", "bean", "g", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/Object;I)V", "getItemCount", "i", "(I)Ljava/lang/Object;", "h", "a", "Ljava/util/List;", "dataList", "Landroid/view/View;", "<init>", "(Ljava/util/List;)V", "BaseViewHolder", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.BaseMultiItemAdapter */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class BaseMultiItemAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    @Nullable

    /* renamed from: a */
    private List<? extends T> f14994a;
    @Nullable

    /* renamed from: b */
    private View f14995b;

    /* compiled from: BaseMultiItemAdapter.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0007R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseMultiItemAdapter$BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/databinding/ViewDataBinding;", "a", "Landroidx/databinding/ViewDataBinding;", "()Landroidx/databinding/ViewDataBinding;", "b", "(Landroidx/databinding/ViewDataBinding;)V", "binding", "<init>", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.base.BaseMultiItemAdapter$BaseViewHolder */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class BaseViewHolder extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: a */
        private ViewDataBinding f14997a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull ViewDataBinding binding) {
            super(binding.getRoot());
            C14342f0.m8184p(binding, "binding");
            this.f14997a = binding;
        }

        @NotNull
        /* renamed from: a */
        public final ViewDataBinding m43960a() {
            return this.f14997a;
        }

        /* renamed from: b */
        public final void m43959b(@NotNull ViewDataBinding viewDataBinding) {
            C14342f0.m8184p(viewDataBinding, "<set-?>");
            this.f14997a = viewDataBinding;
        }
    }

    public BaseMultiItemAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ BaseMultiItemAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    /* renamed from: c */
    public static /* synthetic */ void m43972c(BaseMultiItemAdapter baseMultiItemAdapter, List list, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addData");
        }
        if ((i & 2) != 0) {
            num = null;
        }
        baseMultiItemAdapter.m43973b(list, num);
    }

    /* renamed from: k */
    private final <VB extends ViewBinding> VB m43966k(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        Method declaredMethod;
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (genericSuperclass != null) {
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            C14342f0.m8185o(actualTypeArguments, "javaClass.genericSupercl…Type).actualTypeArguments");
            ArrayList arrayList = new ArrayList();
            for (Type type : actualTypeArguments) {
                if (type instanceof Class) {
                    arrayList.add(type);
                }
            }
            Class<? super T> superclass = ((Class) arrayList.get(0)).getSuperclass();
            if (C14342f0.m8193g(superclass == null ? null : superclass.getSimpleName(), Reflection.m8123d(ViewDataBinding.class).mo7348u())) {
                declaredMethod = ((Class) arrayList.get(i)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE);
                C14342f0.m8185o(declaredMethod, "{\n                vbClas…          )\n            }");
            } else {
                declaredMethod = ((Class) arrayList.get(1)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE);
                C14342f0.m8185o(declaredMethod, "{\n                vbClas…          )\n            }");
            }
            Object invoke = declaredMethod.invoke(null, layoutInflater, viewGroup, Boolean.FALSE);
            if (invoke != null) {
                return (VB) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseMultiItemAdapter.getViewBinding");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    /* renamed from: l */
    static /* synthetic */ ViewBinding m43965l(BaseMultiItemAdapter baseMultiItemAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return baseMultiItemAdapter.m43966k(obj, layoutInflater, viewGroup, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
    }

    /* renamed from: b */
    public final void m43973b(@Nullable List<? extends T> list, @Nullable Integer num) {
        Boolean valueOf;
        int i = 0;
        if (list == null || list.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.f14994a);
        if (num == null) {
            valueOf = null;
        } else {
            int intValue = num.intValue();
            if (intValue >= 0) {
                i = intValue >= linkedList.size() ? linkedList.size() : intValue;
            }
            valueOf = Boolean.valueOf(linkedList.addAll(i, list));
        }
        if (valueOf == null) {
            linkedList.addAll(list);
        } else {
            valueOf.booleanValue();
        }
        m43962o(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public boolean m43971d(T t, T t2, int i, int i2) {
        return C14342f0.m8193g(t, t2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public boolean m43970e(T t, T t2) {
        return C14342f0.m8193g(t, t2);
    }

    /* renamed from: f */
    public void m43969f() {
        View view = this.f14995b;
        if (view == null) {
            return;
        }
        view.setVisibility(getItemCount() > 0 ? 8 : 0);
    }

    /* renamed from: g */
    public abstract void mo38659g(@NotNull ViewDataBinding viewDataBinding, T t, int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.f14994a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public abstract int getItemViewType(int i);

    @Nullable
    /* renamed from: h */
    public final List<T> m43968h() {
        return (List<? extends T>) this.f14994a;
    }

    @Nullable
    /* renamed from: i */
    public final T m43967i(int i) {
        List<T> m43968h = m43968h();
        if (m43968h == null) {
            return null;
        }
        if (i == -1) {
            i = 0;
        }
        return m43968h.get(i);
    }

    /* renamed from: j */
    public abstract int mo38658j(int i);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@NotNull BaseViewHolder holder, int i) {
        C14342f0.m8184p(holder, "holder");
        ViewDataBinding m43960a = holder.m43960a();
        List<? extends T> list = this.f14994a;
        C14342f0.m8187m(list);
        mo38659g(m43960a, list.get(i), i);
        holder.m43960a().executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n */
    public BaseViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        C14342f0.m8184p(parent, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mo38658j(i), parent, false);
        if (inflate == null) {
            RecyclerView.ViewHolder createViewHolder = super.createViewHolder(parent, i);
            C14342f0.m8185o(createViewHolder, "{\n            super.crea…rent, viewType)\n        }");
            return (BaseViewHolder) createViewHolder;
        }
        return new BaseViewHolder(inflate);
    }

    /* renamed from: o */
    public final void m43962o(@Nullable final List<? extends T> list) {
        Unit unit;
        if (list == null) {
            unit = null;
        } else {
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: com.bxkj.base.v2.base.BaseMultiItemAdapter$setData$1$result$1

                /* renamed from: a */
                final /* synthetic */ BaseMultiItemAdapter<T> f14998a;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f14998a = this;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i, int i2) {
                    List list2;
                    list2 = ((BaseMultiItemAdapter) this.f14998a).f14994a;
                    C14342f0.m8187m(list2);
                    return this.f14998a.m43971d(list2.get(i), list.get(i2), i, i2);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i, int i2) {
                    List list2;
                    list2 = ((BaseMultiItemAdapter) this.f14998a).f14994a;
                    C14342f0.m8187m(list2);
                    return this.f14998a.m43970e(list2.get(i), list.get(i2));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.f14998a.getItemCount();
                }
            });
            C14342f0.m8185o(calculateDiff, "fun setData(data: List<T…emCount)\n        }\n\n    }");
            this.f14994a = list;
            calculateDiff.dispatchUpdatesTo(this);
            unit = Unit.f41048a;
        }
        if (unit == null) {
            this.f14994a = new ArrayList();
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    /* renamed from: p */
    public void m43961p(@NotNull View emptyView) {
        C14342f0.m8184p(emptyView, "emptyView");
        this.f14995b = emptyView;
        m43969f();
    }

    public BaseMultiItemAdapter(@Nullable List<? extends T> list) {
        this.f14994a = list;
        registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) { // from class: com.bxkj.base.v2.base.BaseMultiItemAdapter.1

            /* renamed from: a */
            final /* synthetic */ BaseMultiItemAdapter<T> f14996a;

            {
                this.f14996a = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                this.f14996a.m43969f();
            }
        });
    }
}
