package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V2ItemForClassifyTitleBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvName;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2ItemForClassifyTitleBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tvName = tvName;
    }

    public static V2ItemForClassifyTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V2ItemForClassifyTitleBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2ItemForClassifyTitleBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v2_item_for_classify_title);
    }

    @NonNull
    @Deprecated
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2ItemForClassifyTitleBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_item_for_classify_title, root, attachToRoot, component);
    }

    @NonNull
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2ItemForClassifyTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2ItemForClassifyTitleBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_item_for_classify_title, null, false, component);
    }
}
