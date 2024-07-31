package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.bxkj.student.run.app.utils.SportTrailView;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class FmV2SportsTraceBinding extends ViewDataBinding {
    @NonNull
    public final Button btTrack;
    @NonNull
    public final LinearLayout llBottom;
    @NonNull
    public final LinearLayout llRoot;
    @Bindable
    protected Map<String, Object> mDataMap;
    @NonNull
    public final TextureMapView map;
    @NonNull
    public final RecordPathView rpv;
    @NonNull
    public final SportTrailView stv;
    @NonNull
    public final TextView tvAccount;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvName;
    @NonNull
    public final TextView tvPeisu;
    @NonNull
    public final TextView tvSchoolName;
    @NonNull
    public final TextView tvSpeed;
    @NonNull
    public final TextView tvStartTime;
    @NonNull
    public final TextView tvTime;

    /* JADX INFO: Access modifiers changed from: protected */
    public FmV2SportsTraceBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btTrack, LinearLayout llBottom, LinearLayout llRoot, TextureMapView map, RecordPathView rpv, SportTrailView stv, TextView tvAccount, TextView tvDistance, TextView tvName, TextView tvPeisu, TextView tvSchoolName, TextView tvSpeed, TextView tvStartTime, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btTrack = btTrack;
        this.llBottom = llBottom;
        this.llRoot = llRoot;
        this.map = map;
        this.rpv = rpv;
        this.stv = stv;
        this.tvAccount = tvAccount;
        this.tvDistance = tvDistance;
        this.tvName = tvName;
        this.tvPeisu = tvPeisu;
        this.tvSchoolName = tvSchoolName;
        this.tvSpeed = tvSpeed;
        this.tvStartTime = tvStartTime;
        this.tvTime = tvTime;
    }

    public static FmV2SportsTraceBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static FmV2SportsTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public Map<String, Object> getDataMap() {
        return this.mDataMap;
    }

    public abstract void setDataMap(@Nullable Map<String, Object> dataMap);

    @Deprecated
    public static FmV2SportsTraceBinding bind(@NonNull View view, @Nullable Object component) {
        return (FmV2SportsTraceBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.fm_v2_sports_trace);
    }

    @NonNull
    @Deprecated
    public static FmV2SportsTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (FmV2SportsTraceBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.fm_v2_sports_trace, root, attachToRoot, component);
    }

    @NonNull
    public static FmV2SportsTraceBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FmV2SportsTraceBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (FmV2SportsTraceBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.fm_v2_sports_trace, null, false, component);
    }
}
