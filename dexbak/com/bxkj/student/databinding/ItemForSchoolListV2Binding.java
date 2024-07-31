package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class ItemForSchoolListV2Binding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final TextView tvName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemForSchoolListV2Binding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardView, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardView = cardView;
        this.tvName = tvName;
    }

    public static ItemForSchoolListV2Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForSchoolListV2Binding bind(@NonNull View view, @Nullable Object component) {
        return (ItemForSchoolListV2Binding) ViewDataBinding.bind(component, view, C4215R.C4221layout.item_for_school_list_v2);
    }

    @NonNull
    @Deprecated
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ItemForSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.item_for_school_list_v2, root, attachToRoot, component);
    }

    @NonNull
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemForSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ItemForSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.item_for_school_list_v2, null, false, component);
    }
}
