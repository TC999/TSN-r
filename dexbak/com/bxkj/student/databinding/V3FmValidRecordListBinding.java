package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.p085v2.common.view.EmptyRecyclerView;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V3FmValidRecordListBinding extends ViewDataBinding {
    @NonNull
    public final EmptyRecyclerView recyclerView;
    @NonNull
    public final SmartRefreshLayout refresh;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3FmValidRecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, EmptyRecyclerView recyclerView, SmartRefreshLayout refresh) {
        super(_bindingComponent, _root, _localFieldCount);
        this.recyclerView = recyclerView;
        this.refresh = refresh;
    }

    public static V3FmValidRecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V3FmValidRecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v3_fm_valid_record_list);
    }

    @NonNull
    @Deprecated
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_fm_valid_record_list, root, attachToRoot, component);
    }

    @NonNull
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_fm_valid_record_list, null, false, component);
    }
}
