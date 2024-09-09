package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3ItemForInvalidRecordListBinding extends ViewDataBinding {
    @NonNull
    public final Button btAppeal;
    @NonNull
    public final CardView card;
    @NonNull
    public final ImageView ivArrow;
    @Bindable
    protected V3RecordInValidFragment mMActivity;
    @Bindable
    protected Map<String, Object> mMap;
    @NonNull
    public final TextView status;
    @NonNull
    public final TextView tvDistance;
    @NonNull
    public final TextView tvNo;
    @NonNull
    public final TextView tvStartTime;
    @NonNull
    public final TextView tvStatus;
    @NonNull
    public final TextView tvStepCount;
    @NonNull
    public final TextView tvTimeCount;
    @NonNull
    public final TextView tvUploadType;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3ItemForInvalidRecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btAppeal, CardView card, ImageView ivArrow, TextView status, TextView tvDistance, TextView tvNo, TextView tvStartTime, TextView tvStatus, TextView tvStepCount, TextView tvTimeCount, TextView tvUploadType) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btAppeal = btAppeal;
        this.card = card;
        this.ivArrow = ivArrow;
        this.status = status;
        this.tvDistance = tvDistance;
        this.tvNo = tvNo;
        this.tvStartTime = tvStartTime;
        this.tvStatus = tvStatus;
        this.tvStepCount = tvStepCount;
        this.tvTimeCount = tvTimeCount;
        this.tvUploadType = tvUploadType;
    }

    public static V3ItemForInvalidRecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3RecordInValidFragment getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    public abstract void setMActivity(@Nullable V3RecordInValidFragment mActivity);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V3ItemForInvalidRecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3ItemForInvalidRecordListBinding) ViewDataBinding.bind(component, view, 2131428109);
    }

    @NonNull
    @Deprecated
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3ItemForInvalidRecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131428109, root, attachToRoot, component);
    }

    @NonNull
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3ItemForInvalidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3ItemForInvalidRecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131428109, null, false, component);
    }
}
