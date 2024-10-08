package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.base.view.MyGridView;
import com.bxkj.base.v2.common.view.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV3SportsAppealBinding extends ViewDataBinding {
    @NonNull
    public final Button btCommit;
    @NonNull
    public final EditText etReason;
    @NonNull
    public final MyGridView gvImages;
    @Bindable
    protected a mBackEvent;
    @NonNull
    public final V3PubTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3SportsAppealBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btCommit, EditText etReason, MyGridView gvImages, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btCommit = btCommit;
        this.etReason = etReason;
        this.gvImages = gvImages;
        this.titleLayout = titleLayout;
    }

    public static AcV3SportsAppealBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public a getBackEvent() {
        return this.mBackEvent;
    }

    public abstract void setBackEvent(@Nullable a backEvent);

    @Deprecated
    public static AcV3SportsAppealBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3SportsAppealBinding) ViewDataBinding.bind(component, view, 2131427515);
    }

    @NonNull
    @Deprecated
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3SportsAppealBinding) ViewDataBinding.inflateInternal(inflater, 2131427515, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3SportsAppealBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3SportsAppealBinding) ViewDataBinding.inflateInternal(inflater, 2131427515, null, false, component);
    }
}
