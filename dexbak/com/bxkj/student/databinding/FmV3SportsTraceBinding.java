package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.amap.api.maps.TextureMapView;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class FmV3SportsTraceBinding extends ViewDataBinding {
    @NonNull
    public final MaterialCardView cardBottom;
    @NonNull
    public final ShapeableImageView ivHead;
    @NonNull
    public final LinearLayout llBottom;
    @Bindable
    protected Map<String, Object> mDataMap;
    @NonNull
    public final TextureMapView map;
    @NonNull
    public final RecordPathView rpv;
    @NonNull
    public final TextView tvAccount;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvDistanceHint;
    @NonNull
    public final TextView tvName;
    @NonNull
    public final TextView tvPace;
    @NonNull
    public final TextView tvStartTime;
    @NonNull
    public final TextView tvStep;
    @NonNull
    public final TextView tvTime;
    @NonNull
    public final View viewDivider;

    /* JADX INFO: Access modifiers changed from: protected */
    public FmV3SportsTraceBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialCardView cardBottom, ShapeableImageView ivHead, LinearLayout llBottom, TextureMapView map, RecordPathView rpv, TextView tvAccount, TextView tvDistance, TextView tvDistanceHint, TextView tvName, TextView tvPace, TextView tvStartTime, TextView tvStep, TextView tvTime, View viewDivider) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardBottom = cardBottom;
        this.ivHead = ivHead;
        this.llBottom = llBottom;
        this.map = map;
        this.rpv = rpv;
        this.tvAccount = tvAccount;
        this.tvDistance = tvDistance;
        this.tvDistanceHint = tvDistanceHint;
        this.tvName = tvName;
        this.tvPace = tvPace;
        this.tvStartTime = tvStartTime;
        this.tvStep = tvStep;
        this.tvTime = tvTime;
        this.viewDivider = viewDivider;
    }

    public static FmV3SportsTraceBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV3SportsTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Map<String, Object> getDataMap() {
        return this.mDataMap;
    }

    public abstract void setDataMap(@Nullable Map<String, Object> dataMap);

    @Deprecated
    public static FmV3SportsTraceBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV3SportsTraceBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.fm_v3_sports_trace);
    }

    @NonNull
    @Deprecated
    public static FmV3SportsTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV3SportsTraceBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.fm_v3_sports_trace, root, attachToRoot, component);
    }

    @NonNull
    public static FmV3SportsTraceBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV3SportsTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV3SportsTraceBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.fm_v3_sports_trace, null, false, component);
    }
}
