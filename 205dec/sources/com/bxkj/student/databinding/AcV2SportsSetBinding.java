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
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV2SportsSetBinding extends ViewDataBinding {
    @Bindable
    protected SportsSetActivity mMSportsSetActivity;
    @NonNull
    public final NewPubTitleBinding titleLayout;
    @NonNull
    public final TextView tvDescription;
    @NonNull
    public final TextView tvPermissionSet;
    @NonNull
    public final TextView tvQuestion;
    @NonNull
    public final TextView tvRank;
    @NonNull
    public final TextView tvRecord;
    @NonNull
    public final TextView tvSoundSet;
    @NonNull
    public final TextView tvStatistics;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV2SportsSetBinding(Object _bindingComponent, View _root, int _localFieldCount, NewPubTitleBinding titleLayout, TextView tvDescription, TextView tvPermissionSet, TextView tvQuestion, TextView tvRank, TextView tvRecord, TextView tvSoundSet, TextView tvStatistics) {
        super(_bindingComponent, _root, _localFieldCount);
        this.titleLayout = titleLayout;
        this.tvDescription = tvDescription;
        this.tvPermissionSet = tvPermissionSet;
        this.tvQuestion = tvQuestion;
        this.tvRank = tvRank;
        this.tvRecord = tvRecord;
        this.tvSoundSet = tvSoundSet;
        this.tvStatistics = tvStatistics;
    }

    public static AcV2SportsSetBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public SportsSetActivity getMSportsSetActivity() {
        return this.mMSportsSetActivity;
    }

    public abstract void setMSportsSetActivity(@Nullable SportsSetActivity mSportsSetActivity);

    @Deprecated
    public static AcV2SportsSetBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SportsSetBinding) ViewDataBinding.bind(component, view, 2131427511);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsSetBinding) ViewDataBinding.inflateInternal(inflater, 2131427511, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsSetBinding) ViewDataBinding.inflateInternal(inflater, 2131427511, null, false, component);
    }
}
