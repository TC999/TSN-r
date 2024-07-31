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
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.student.C4215R;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcV2SportsRankBinding extends ViewDataBinding {
    @Bindable
    protected Map<String, Object> mDataMap;
    @Bindable
    protected OnBackPress mMActvity;
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
    public OnBackPress getMActvity() {
        return this.mMActvity;
    }

    public abstract void setDataMap(@Nullable Map<String, Object> dataMap);

    public abstract void setMActvity(@Nullable OnBackPress mActvity);

    @Deprecated
    public static AcV2SportsRankBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v2_sports_rank);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_sports_rank, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsRankBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsRankBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_sports_rank, null, false, component);
    }
}
