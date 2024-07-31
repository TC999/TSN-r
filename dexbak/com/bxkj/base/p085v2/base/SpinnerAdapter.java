package com.bxkj.base.p085v2.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpinnerAdapter.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0004:\u0001\"B\u0019\u0012\u0010\b\u0002\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d¢\u0006\u0004\b \u0010!J9\u0010\r\u001a\u00028\u0002\"\b\b\u0002\u0010\u0003*\u00020\u0005*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u0019\u0010\u0013\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J'\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001e¨\u0006#"}, m12616d2 = {"Lcom/bxkj/base/v2/base/SpinnerAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/databinding/ViewDataBinding;", "VB", "Landroid/widget/BaseAdapter;", "Landroidx/viewbinding/ViewBinding;", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "", "position", "b", "(Ljava/lang/Object;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Landroidx/viewbinding/ViewBinding;", "Landroid/view/View;", "convertView", "parent", "getView", "getItem", "(I)Ljava/lang/Object;", "", "getItemId", "getCount", "itemBinding", "bean", "Lkotlin/f1;", "a", "(Landroidx/databinding/ViewDataBinding;Ljava/lang/Object;I)V", "", "Ljava/util/List;", "dataList", "<init>", "(Ljava/util/List;)V", "BaseViewHolder", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.base.v2.base.SpinnerAdapter */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class SpinnerAdapter<T, VB extends ViewDataBinding> extends BaseAdapter {
    @Nullable

    /* renamed from: a */
    private List<? extends T> f15028a;

    /* compiled from: SpinnerAdapter.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0002\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\t\u001a\u00028\u0002¢\u0006\u0004\b\n\u0010\bR\"\u0010\t\u001a\u00028\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m12616d2 = {"Lcom/bxkj/base/v2/base/SpinnerAdapter$BaseViewHolder;", "Landroidx/databinding/ViewDataBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "Landroidx/databinding/ViewDataBinding;", "()Landroidx/databinding/ViewDataBinding;", "b", "(Landroidx/databinding/ViewDataBinding;)V", "binding", "<init>", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.base.SpinnerAdapter$BaseViewHolder */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class BaseViewHolder<VB extends ViewDataBinding> extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: a */
        private VB f15029a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseViewHolder(@NotNull VB binding) {
            super(binding.getRoot());
            C14342f0.m8184p(binding, "binding");
            this.f15029a = binding;
        }

        @NotNull
        /* renamed from: a */
        public final VB m43930a() {
            return this.f15029a;
        }

        /* renamed from: b */
        public final void m43929b(@NotNull VB vb) {
            C14342f0.m8184p(vb, "<set-?>");
            this.f15029a = vb;
        }
    }

    public SpinnerAdapter() {
        this(null, 1, null);
    }

    public /* synthetic */ SpinnerAdapter(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list);
    }

    /* renamed from: b */
    private final <VB extends ViewBinding> VB m43932b(Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
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
            Object invoke = ((Class) arrayList.get(i)).getDeclaredMethod("inflate", LayoutInflater.class, ViewGroup.class, Boolean.TYPE).invoke(null, layoutInflater, viewGroup, Boolean.FALSE);
            if (invoke != null) {
                return (VB) ((ViewBinding) invoke);
            }
            throw new NullPointerException("null cannot be cast to non-null type VB of com.bxkj.base.v2.base.SpinnerAdapter.getViewBinding");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
    }

    /* renamed from: c */
    static /* synthetic */ ViewBinding m43931c(SpinnerAdapter spinnerAdapter, Object obj, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                i = 0;
            }
            return spinnerAdapter.m43932b(obj, layoutInflater, viewGroup, i);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getViewBinding");
    }

    /* renamed from: a */
    public abstract void m43933a(@NotNull VB vb, T t, int i);

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends T> list = this.f15028a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    @Nullable
    public T getItem(int i) {
        List<? extends T> list = this.f15028a;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.Adapter
    @NotNull
    public View getView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(viewGroup == null ? null : viewGroup.getContext());
        C14342f0.m8185o(from, "from(parent?.context)");
        BaseViewHolder baseViewHolder = new BaseViewHolder((ViewDataBinding) m43932b(this, from, viewGroup, 0));
        List<? extends T> list = this.f15028a;
        C14342f0.m8187m(list);
        m43933a(baseViewHolder.m43930a(), list.get(i), i);
        View view2 = baseViewHolder.itemView;
        C14342f0.m8185o(view2, "baseViewHolder.itemView");
        return view2;
    }

    public SpinnerAdapter(@Nullable List<? extends T> list) {
        this.f15028a = list;
    }
}
