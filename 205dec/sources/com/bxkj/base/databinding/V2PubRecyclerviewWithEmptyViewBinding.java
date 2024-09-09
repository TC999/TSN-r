package com.bxkj.base.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import com.bxkj.base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class V2PubRecyclerviewWithEmptyViewBinding extends ViewDataBinding {
    @NonNull
    public final EmptyRecyclerView recyclerView;
    @NonNull
    public final SmartRefreshLayout refresh;
    @NonNull
    public final TextView tvEmptyView;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2PubRecyclerviewWithEmptyViewBinding(Object obj, View view, int i4, EmptyRecyclerView emptyRecyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView) {
        super(obj, view, i4);
        this.recyclerView = emptyRecyclerView;
        this.refresh = smartRefreshLayout;
        this.tvEmptyView = textView;
    }

    public static V2PubRecyclerviewWithEmptyViewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        return inflate(layoutInflater, viewGroup, z3, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2PubRecyclerviewWithEmptyViewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (V2PubRecyclerviewWithEmptyViewBinding) ViewDataBinding.bind(obj, view, R.layout.v2_pub_recyclerview_with_empty_view);
    }

    @NonNull
    @Deprecated
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3, @Nullable Object obj) {
        return (V2PubRecyclerviewWithEmptyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.v2_pub_recyclerview_with_empty_view, viewGroup, z3, obj);
    }

    @NonNull
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2PubRecyclerviewWithEmptyViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (V2PubRecyclerviewWithEmptyViewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.v2_pub_recyclerview_with_empty_view, null, false, obj);
    }
}
