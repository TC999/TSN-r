package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.v2.ui.sports.set.SportsDescriptionActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV2SportsDescriptionBinding extends ViewDataBinding {
    @NonNull
    public final Button btStart;
    @NonNull
    public final CheckBox cbIgnore;
    @Bindable
    protected SportsDescriptionActivity mMActivity;
    @Bindable
    protected Boolean mShowBottom;
    @Bindable
    protected Boolean mStartButtonEnable;
    @NonNull
    public final SmartWebView swv;
    @NonNull
    public final NewPubTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV2SportsDescriptionBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btStart, CheckBox cbIgnore, SmartWebView swv, NewPubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btStart = btStart;
        this.cbIgnore = cbIgnore;
        this.swv = swv;
        this.titleLayout = titleLayout;
    }

    public static AcV2SportsDescriptionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public SportsDescriptionActivity getMActivity() {
        return this.mMActivity;
    }

    @Nullable
    public Boolean getShowBottom() {
        return this.mShowBottom;
    }

    @Nullable
    public Boolean getStartButtonEnable() {
        return this.mStartButtonEnable;
    }

    public abstract void setMActivity(@Nullable SportsDescriptionActivity mActivity);

    public abstract void setShowBottom(@Nullable Boolean showBottom);

    public abstract void setStartButtonEnable(@Nullable Boolean startButtonEnable);

    @Deprecated
    public static AcV2SportsDescriptionBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.bind(component, view, 2131427509);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.inflateInternal(inflater, 2131427509, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.inflateInternal(inflater, 2131427509, null, false, component);
    }
}
