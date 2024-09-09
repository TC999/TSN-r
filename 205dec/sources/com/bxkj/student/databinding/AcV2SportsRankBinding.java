package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.base.v2.common.view.a;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV2SportsRankBinding extends ViewDataBinding {
    @Bindable
    protected Map<String, Object> mDataMap;
    @Bindable
    protected a mMActvity;
    @NonNull
    public final NewPubTitleBinding titleLayout;
    @NonNull
    public final TextView tvRunClassRank;
    @NonNull
    public final TextView tvRunDepartmentRank;
    @NonNull
    public final TextView tvRunMajorRank;
    @NonNull
    public final TextView tvRunSchoolRank;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV2SportsRankBinding(Object _bindingComponent, View _root, int _localFieldCount, NewPubTitleBinding titleLayout, TextView tvRunClassRank, TextView tvRunDepartmentRank, TextView tvRunMajorRank, TextView tvRunSchoolRank) {
        super(_bindingComponent, _root, _localFieldCount);
        this.titleLayout = titleLayout;
        this.tvRunClassRank = tvRunClassRank;
        this.tvRunDepartmentRank = tvRunDepartmentRank;
        this.tvRunMajorRank = tvRunMajorRank;
        this.tvRunSchoolRank = tvRunSchoolRank;
    }

    public static AcV2SportsRankBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Map<String, Object> getDataMap() {
        return this.mDataMap;
    }

    @Nullable
    public a getMActvity() {
        return this.mMActvity;
    }

    public abstract void setDataMap(@Nullable Map<String, Object> dataMap);

    public abstract void setMActvity(@Nullable a mActvity);

    @Deprecated
    public static AcV2SportsRankBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.bind(component, view, 2131427510);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.inflateInternal(inflater, 2131427510, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.inflateInternal(inflater, 2131427510, null, false, component);
    }
}
