package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.p085v2.common.view.EmptyRecyclerView;
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.base.view.SearchView;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcSchoolListV2Binding extends ViewDataBinding {
    @NonNull
    public final View emptyLayout;
    @Bindable
    protected OnBackPress mActivity;
    @NonNull
    public final EmptyRecyclerView rvSchool;
    @NonNull
    public final SearchView searchView;
    @NonNull
    public final V3PubTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcSchoolListV2Binding(Object _bindingComponent, View _root, int _localFieldCount, View emptyLayout, EmptyRecyclerView rvSchool, SearchView searchView, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.emptyLayout = emptyLayout;
        this.rvSchool = rvSchool;
        this.searchView = searchView;
        this.titleLayout = titleLayout;
    }

    public static AcSchoolListV2Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OnBackPress getActivity() {
        return this.mActivity;
    }

    public abstract void setActivity(@Nullable OnBackPress activity);

    @Deprecated
    public static AcSchoolListV2Binding bind(@NonNull View view, @Nullable Object component) {
        return (AcSchoolListV2Binding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_school_list_v2);
    }

    @NonNull
    @Deprecated
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_school_list_v2, root, attachToRoot, component);
    }

    @NonNull
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcSchoolListV2Binding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcSchoolListV2Binding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_school_list_v2, null, false, component);
    }
}
