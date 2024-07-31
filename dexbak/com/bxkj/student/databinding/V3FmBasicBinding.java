package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.view.TrackProgressView;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V3FmBasicBinding extends ViewDataBinding {
    @NonNull
    public final MaterialCardView card1;
    @NonNull
    public final MaterialCardView card2;
    @NonNull
    public final MaterialCardView card3;
    @NonNull
    public final MaterialCardView cardCjLine;
    @NonNull
    public final MaterialCardView cardRankLine;
    @NonNull
    public final ImageView ivJb1;
    @NonNull
    public final ImageView ivJb2;
    @NonNull
    public final ImageView ivJb3;
    @NonNull
    public final LinearLayout llContent;
    @Bindable
    protected V3RecordDetailActivity mMActivity;
    @Bindable
    protected Map<String, Object> mMap;
    @NonNull
    public final TrackProgressView tpDistance;
    @NonNull
    public final TrackProgressView tpStep;
    @NonNull
    public final TrackProgressView tpTime;
    @NonNull
    public final TextView tv1;
    @NonNull
    public final TextView tvCj;
    @NonNull
    public final TextView tvCjHint;
    @NonNull
    public final TextView tvCurrentDistance;
    @NonNull
    public final TextView tvCurrentStep;
    @NonNull
    public final TextView tvCurrentTime;
    @NonNull
    public final TextView tvRank;
    @NonNull
    public final TextView tvRankHint;
    @NonNull
    public final TextView tvRankUnit;
    @NonNull
    public final TextView tvResult;
    @NonNull
    public final TextView tvResultHint;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3FmBasicBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView card1, MaterialCardView card2, MaterialCardView card3, MaterialCardView cardCjLine, MaterialCardView cardRankLine, ImageView ivJb1, ImageView ivJb2, ImageView ivJb3, LinearLayout llContent, TrackProgressView tpDistance, TrackProgressView tpStep, TrackProgressView tpTime, TextView tv1, TextView tvCj, TextView tvCjHint, TextView tvCurrentDistance, TextView tvCurrentStep, TextView tvCurrentTime, TextView tvRank, TextView tvRankHint, TextView tvRankUnit, TextView tvResult, TextView tvResultHint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.cardCjLine = cardCjLine;
        this.cardRankLine = cardRankLine;
        this.ivJb1 = ivJb1;
        this.ivJb2 = ivJb2;
        this.ivJb3 = ivJb3;
        this.llContent = llContent;
        this.tpDistance = tpDistance;
        this.tpStep = tpStep;
        this.tpTime = tpTime;
        this.tv1 = tv1;
        this.tvCj = tvCj;
        this.tvCjHint = tvCjHint;
        this.tvCurrentDistance = tvCurrentDistance;
        this.tvCurrentStep = tvCurrentStep;
        this.tvCurrentTime = tvCurrentTime;
        this.tvRank = tvRank;
        this.tvRankHint = tvRankHint;
        this.tvRankUnit = tvRankUnit;
        this.tvResult = tvResult;
        this.tvResultHint = tvResultHint;
    }

    public static V3FmBasicBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3RecordDetailActivity getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    public abstract void setMActivity(@Nullable V3RecordDetailActivity mActivity);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V3FmBasicBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FmBasicBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v3_fm_basic);
    }

    @NonNull
    @Deprecated
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FmBasicBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_fm_basic, root, attachToRoot, component);
    }

    @NonNull
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FmBasicBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FmBasicBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_fm_basic, null, false, component);
    }
}
