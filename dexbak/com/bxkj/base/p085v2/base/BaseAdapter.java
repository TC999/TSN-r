package com.bxkj.base.p085v2.base;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.kuaishou.weapon.p205p0.C7304t;
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

/* compiled from: BaseAdapter.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0011\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00050\u0004:\u0001/B\u0019\u0012\u0010\b\u0002\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016¢\u0006\u0004\b-\u0010.J9\u0010\u000e\u001a\u00028\u0002\"\b\b\u0002\u0010\u0003*\u00020\u0006*\u00020\u00072\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0016J\u001e\u0010\u0015\u001a\u00020\u00142\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0016\u0010\u0018\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016J)\u0010\u0019\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00162\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0019\u0010\u001aJ/\u0010 \u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0014¢\u0006\u0004\b \u0010!J\u001f\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\u00142\u0006\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b&\u0010'J\b\u0010(\u001a\u00020\fH\u0016J\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0016R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+¨\u00060"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/databinding/ViewDataBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bxkj/base/v2/base/BaseAdapter$BaseViewHolder;", "Landroidx/viewbinding/ViewBinding;", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "position", "h", "(Ljava/lang/Object;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/viewbinding/ViewBinding;", "parent", "viewType", "k", "holder", "Lkotlin/f1;", "j", "", "data", C7304t.f25048d, "b", "(Ljava/util/List;Ljava/lang/Integer;)V", "oldItem", "newItem", "oldItemPosition", "newItemPosition", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;II)Z", "e", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "itemBinding", "bean", "f", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/Object;I)V", "getItemCount", "g", "a", "Ljava/util/List;", "dataList", "<init>", "(Ljava/util/List;)V", "BaseViewHolder", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.BaseAdapter */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseAdapter<T, VB extends ViewDataBinding> extends RecyclerView.Adapter<BaseViewHolder<VB>> {
    @Nullable

    /* renamed from: a */
    private List<? extends T> f14973a;

    /* compiled from: BaseAdapter.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00028\u0002¢\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00028\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m12616d2 = {"Lcom/bxkj/base/v2/base/BaseAdapter$BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/databinding/ViewDataBinding;", "()Landroidx/databinding/ViewDataBinding;", "b", "(Landroidx/databinding/ViewDataBinding;)V", "binding", "<init>", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.base.BaseAdapter$BaseViewHolder */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class BaseViewHolder<VB extends ViewDataBinding> extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: a */
        private VB f14974a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull VB binding) {
            super(binding.getRoot());
            C14342f0.m8184p(binding, "binding");
            this.f14974a = binding;
        }

        @NotNull
        /* renamed from: a */
        public final VB m43986a() {
            return this.f14974a;
        }

        /* renamed from: b */
        public final void m43985b(@NotNull VB vb) {
            C14342f0.m8184p(vb, "<set-?>");
            this.f14974a = vb;
        }
    }

    public BaseAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ BaseAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    /* renamed from: c */
    public static /* synthetic */ void m43995c(BaseAdapter baseAdapter, List list, Integer num, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addData");
        }
        if ((i & 2) != 0) {
            num = null;
        }
        baseAdapter.m43996b(list, num);
    }

    /* renamed from: h */
    private final <VB extends ViewBinding> VB m43991h(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
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
                return (VB) ((ViewBinding) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.BaseAdapter.getViewBinding");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    /* renamed from: i */
    static /* synthetic */ ViewBinding m43990i(BaseAdapter baseAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return baseAdapter.m43991h(obj, layoutInflater, viewGroup, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
    }

    /* renamed from: b */
    public final void m43996b(@Nullable List<? extends T> list, @Nullable Integer num) {
        Boolean valueOf;
        int i = 0;
        if (list == null || list.isEmpty()) {
            return;
        }
        LinkedList linkedList = new LinkedList(this.f14973a);
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
        m43987l(linkedList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public boolean m43994d(T t, T t2, int i, int i2) {
        return C14342f0.m8193g(t, t2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public boolean m43993e(T t, T t2) {
        return C14342f0.m8193g(t, t2);
    }

    /* renamed from: f */
    public abstract void mo38351f(@NotNull VB vb, T t, int i);

    @Nullable
    /* renamed from: g */
    public final List<T> m43992g() {
        return (List<? extends T>) this.f14973a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.f14973a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@NotNull BaseViewHolder<VB> holder, int i) {
        C14342f0.m8184p(holder, "holder");
        VB m43986a = holder.m43986a();
        List<? extends T> list = this.f14973a;
        C14342f0.m8187m(list);
        mo38351f(m43986a, list.get(i), i);
        holder.m43986a().executePendingBindings();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: k */
    public BaseViewHolder<VB> onCreateViewHolder(@NotNull ViewGroup parent, int i) {
        C14342f0.m8184p(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        C14342f0.m8185o(from, "from(parent.context)");
        return new BaseViewHolder<>(m43991h(this, from, parent, 0));
    }

    /* renamed from: l */
    public final void m43987l(@Nullable final List<? extends T> list) {
        Unit unit;
        if (list == null) {
            unit = null;
        } else {
            DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback(this) { // from class: com.bxkj.base.v2.base.BaseAdapter$setData$1$result$1

                /* renamed from: a */
                final /* synthetic */ BaseAdapter<T, VB> f14975a;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f14975a = this;
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areContentsTheSame(int i, int i2) {
                    List list2;
                    list2 = ((BaseAdapter) this.f14975a).f14973a;
                    C14342f0.m8187m(list2);
                    return this.f14975a.m43994d(list2.get(i), list.get(i2), i, i2);
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public boolean areItemsTheSame(int i, int i2) {
                    List list2;
                    list2 = ((BaseAdapter) this.f14975a).f14973a;
                    C14342f0.m8187m(list2);
                    return this.f14975a.m43993e(list2.get(i), list.get(i2));
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getNewListSize() {
                    return list.size();
                }

                @Override // androidx.recyclerview.widget.DiffUtil.Callback
                public int getOldListSize() {
                    return this.f14975a.getItemCount();
                }
            });
            C14342f0.m8185o(calculateDiff, "fun setData(data: List<T…emCount)\n        }\n\n    }");
            this.f14973a = list;
            calculateDiff.dispatchUpdatesTo(this);
            unit = Unit.f41048a;
        }
        if (unit == null) {
            this.f14973a = new ArrayList();
            notifyItemRangeChanged(0, getItemCount());
        }
    }

    public BaseAdapter(@Nullable List<? extends T> list) {
        this.f14973a = list;
    }
}
