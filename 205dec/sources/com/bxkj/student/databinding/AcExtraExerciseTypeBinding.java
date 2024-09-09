package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.run.extraclass.SignTypeActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcExtraExerciseTypeBinding extends ViewDataBinding {
    @NonNull
    public final Button btIn;
    @NonNull
    public final Button btOut;
    @Bindable
    protected SignTypeActivity mSignTypeActivity;
    @NonNull
    public final NewPubTitleBinding toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcExtraExerciseTypeBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btIn, Button btOut, NewPubTitleBinding toolbar) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btIn = btIn;
        this.btOut = btOut;
        this.toolbar = toolbar;
    }

    public static AcExtraExerciseTypeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public SignTypeActivity getSignTypeActivity() {
        return this.mSignTypeActivity;
    }

    public abstract void setSignTypeActivity(@Nullable SignTypeActivity signTypeActivity);

    @Deprecated
    public static AcExtraExerciseTypeBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcExtraExerciseTypeBinding) ViewDataBinding.bind(component, view, 2131427398);
    }

    @NonNull
    @Deprecated
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcExtraExerciseTypeBinding) ViewDataBinding.inflateInternal(inflater, 2131427398, root, attachToRoot, component);
    }

    @NonNull
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcExtraExerciseTypeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcExtraExerciseTypeBinding) ViewDataBinding.inflateInternal(inflater, 2131427398, null, false, component);
    }
}
