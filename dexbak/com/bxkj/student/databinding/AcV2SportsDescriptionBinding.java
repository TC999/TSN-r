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
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.sports.set.SportsDescriptionActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
        return (AcV2SportsDescriptionBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v2_sports_description);
    }

    @NonNull
    @Deprecated
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_sports_description, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SportsDescriptionBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SportsDescriptionBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_sports_description, null, false, component);
    }
}
