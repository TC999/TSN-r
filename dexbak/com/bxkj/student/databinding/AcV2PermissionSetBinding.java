package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.sports.set.PermissionSetActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcV2PermissionSetBinding extends ViewDataBinding {
    @NonNull
    public final Button btFastSet;
    @NonNull
    public final CardView cardBatteryOptimizations;
    @NonNull
    public final CardView cardGpsAlways;
    @NonNull
    public final CardView cardSaveModel;
    @NonNull
    public final CardView cardWhy;
    @Bindable
    protected PermissionSetActivity mMActivity;
    @NonNull

    /* renamed from: sw */
    public final SmartWebView f16276sw;
    @NonNull
    public final V3PubTitleBinding titleLayout;
    @NonNull
    public final TextView tvHint;
    @NonNull
    public final TextView tvHint2;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV2PermissionSetBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btFastSet, CardView cardBatteryOptimizations, CardView cardGpsAlways, CardView cardSaveModel, CardView cardWhy, SmartWebView sw, V3PubTitleBinding titleLayout, TextView tvHint, TextView tvHint2) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btFastSet = btFastSet;
        this.cardBatteryOptimizations = cardBatteryOptimizations;
        this.cardGpsAlways = cardGpsAlways;
        this.cardSaveModel = cardSaveModel;
        this.cardWhy = cardWhy;
        this.f16276sw = sw;
        this.titleLayout = titleLayout;
        this.tvHint = tvHint;
        this.tvHint2 = tvHint2;
    }

    public static AcV2PermissionSetBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public PermissionSetActivity getMActivity() {
        return this.mMActivity;
    }

    public abstract void setMActivity(@Nullable PermissionSetActivity mActivity);

    @Deprecated
    public static AcV2PermissionSetBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2PermissionSetBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v2_permission_set);
    }

    @NonNull
    @Deprecated
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2PermissionSetBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_permission_set, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2PermissionSetBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2PermissionSetBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_permission_set, null, false, component);
    }
}
