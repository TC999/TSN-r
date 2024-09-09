package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.LoginViewModel;
import com.google.android.material.button.MaterialButton;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2AcLoginBinding extends ViewDataBinding {
    @NonNull
    public final MaterialButton btLogin;
    @NonNull
    public final CheckBox cbAgree;
    @NonNull
    public final EditText etAccount;
    @NonNull
    public final EditText etPassword;
    @NonNull
    public final ImageView ivLogo;
    @NonNull
    public final ImageView ivQq;
    @NonNull
    public final ImageView ivWechat;
    @Bindable
    protected LoginActivity mActivity;
    @Bindable
    protected a mLoginInUser;
    @Bindable
    protected LoginViewModel mLoginViewModel;
    @Bindable
    protected String mVersion;
    @NonNull
    public final TextView tvAgree;
    @NonNull
    public final TextView tvFindPassword;
    @NonNull
    public final TextView tvHelp;
    @NonNull
    public final TextView tvOtherLogin;
    @NonNull
    public final TextView tvSwitchSchool;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2AcLoginBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btLogin, CheckBox cbAgree, EditText etAccount, EditText etPassword, ImageView ivLogo, ImageView ivQq, ImageView ivWechat, TextView tvAgree, TextView tvFindPassword, TextView tvHelp, TextView tvOtherLogin, TextView tvSwitchSchool) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btLogin = btLogin;
        this.cbAgree = cbAgree;
        this.etAccount = etAccount;
        this.etPassword = etPassword;
        this.ivLogo = ivLogo;
        this.ivQq = ivQq;
        this.ivWechat = ivWechat;
        this.tvAgree = tvAgree;
        this.tvFindPassword = tvFindPassword;
        this.tvHelp = tvHelp;
        this.tvOtherLogin = tvOtherLogin;
        this.tvSwitchSchool = tvSwitchSchool;
    }

    public static V2AcLoginBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public LoginActivity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public a getLoginInUser() {
        return this.mLoginInUser;
    }

    @Nullable
    public LoginViewModel getLoginViewModel() {
        return this.mLoginViewModel;
    }

    @Nullable
    public String getVersion() {
        return this.mVersion;
    }

    public abstract void setActivity(@Nullable LoginActivity activity);

    public abstract void setLoginInUser(@Nullable a loginInUser);

    public abstract void setLoginViewModel(@Nullable LoginViewModel loginViewModel);

    public abstract void setVersion(@Nullable String version);

    @Deprecated
    public static V2AcLoginBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AcLoginBinding) ViewDataBinding.bind(component, view, 2131428082);
    }

    @NonNull
    @Deprecated
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AcLoginBinding) ViewDataBinding.inflateInternal(inflater, 2131428082, root, attachToRoot, component);
    }

    @NonNull
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AcLoginBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AcLoginBinding) ViewDataBinding.inflateInternal(inflater, 2131428082, null, false, component);
    }
}
