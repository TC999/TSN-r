package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.LoginActivity;
import com.bxkj.student.v2.vm.LoginViewModel;
import com.google.android.material.button.MaterialButton;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V2AcLoginBindingImpl extends V2AcLoginBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private InverseBindingListener etAccountandroidTextAttrChanged;
    private InverseBindingListener etPasswordandroidTextAttrChanged;
    @Nullable
    private final View.OnClickListener mCallback14;
    @Nullable
    private final View.OnClickListener mCallback15;
    @Nullable
    private final View.OnClickListener mCallback16;
    @Nullable
    private final View.OnClickListener mCallback17;
    @Nullable
    private final View.OnClickListener mCallback18;
    @Nullable
    private final View.OnClickListener mCallback19;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;
    @NonNull
    private final TextView mboundView1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements InverseBindingListener {
        a() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(V2AcLoginBindingImpl.this.etAccount);
            LoginViewModel loginViewModel = V2AcLoginBindingImpl.this.mLoginViewModel;
            if (loginViewModel != null) {
                ObservableField<String> z3 = loginViewModel.z();
                if (z3 != null) {
                    z3.set(textString);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements InverseBindingListener {
        b() {
        }

        @Override // androidx.databinding.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(V2AcLoginBindingImpl.this.etPassword);
            LoginViewModel loginViewModel = V2AcLoginBindingImpl.this.mLoginViewModel;
            if (loginViewModel != null) {
                ObservableField<String> y3 = loginViewModel.y();
                if (y3 != null) {
                    y3.set(textString);
                }
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131231451, 10);
        sparseIntArray.put(2131231080, 11);
        sparseIntArray.put(2131232842, 12);
        sparseIntArray.put(2131233061, 13);
    }

    public V2AcLoginBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private boolean onChangeLoginViewModelPassword(ObservableField<String> LoginViewModelPassword, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeLoginViewModelUsername(ObservableField<String> LoginViewModelUsername, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                LoginActivity loginActivity = this.mActivity;
                if (loginActivity != null) {
                    loginActivity.Q();
                    return;
                }
                return;
            case 2:
                LoginActivity loginActivity2 = this.mActivity;
                if (loginActivity2 != null) {
                    loginActivity2.N();
                    return;
                }
                return;
            case 3:
                LoginActivity loginActivity3 = this.mActivity;
                if (loginActivity3 != null) {
                    loginActivity3.O();
                    return;
                }
                return;
            case 4:
                LoginActivity loginActivity4 = this.mActivity;
                if (loginActivity4 != null) {
                    loginActivity4.U();
                    return;
                }
                return;
            case 5:
                LoginActivity loginActivity5 = this.mActivity;
                if (loginActivity5 != null) {
                    loginActivity5.S();
                    return;
                }
                return;
            case 6:
                LoginActivity loginActivity6 = this.mActivity;
                if (loginActivity6 != null) {
                    loginActivity6.R();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.databinding.V2AcLoginBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            if (localFieldId != 1) {
                return false;
            }
            return onChangeLoginViewModelPassword((ObservableField) object, fieldId);
        }
        return onChangeLoginViewModelUsername((ObservableField) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setActivity(@Nullable LoginActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setLoginInUser(@Nullable com.bxkj.base.v2.data.a LoginInUser) {
        this.mLoginInUser = LoginInUser;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setLoginViewModel(@Nullable LoginViewModel LoginViewModel) {
        this.mLoginViewModel = LoginViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (29 == variableId) {
            setVersion((String) variable);
            return true;
        } else if (13 == variableId) {
            setLoginInUser((com.bxkj.base.v2.data.a) variable);
            return true;
        } else if (1 == variableId) {
            setActivity((LoginActivity) variable);
            return true;
        } else if (14 == variableId) {
            setLoginViewModel((LoginViewModel) variable);
            return true;
        } else {
            return false;
        }
    }

    @Override // com.bxkj.student.databinding.V2AcLoginBinding
    public void setVersion(@Nullable String Version) {
        this.mVersion = Version;
    }

    private V2AcLoginBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (MaterialButton) bindings[4], (CheckBox) bindings[11], (EditText) bindings[2], (EditText) bindings[3], (ImageView) bindings[10], (ImageView) bindings[9], (ImageView) bindings[8], (TextView) bindings[12], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[13], (TextView) bindings[7]);
        this.etAccountandroidTextAttrChanged = new a();
        this.etPasswordandroidTextAttrChanged = new b();
        this.mDirtyFlags = -1L;
        this.btLogin.setTag(null);
        this.etAccount.setTag(null);
        this.etPassword.setTag(null);
        this.ivQq.setTag(null);
        this.ivWechat.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.mboundView1 = textView;
        textView.setTag(null);
        this.tvFindPassword.setTag(null);
        this.tvHelp.setTag(null);
        this.tvSwitchSchool.setTag(null);
        setRootTag(root);
        this.mCallback17 = new com.bxkj.student.generated.callback.a(this, 4);
        this.mCallback15 = new com.bxkj.student.generated.callback.a(this, 2);
        this.mCallback19 = new com.bxkj.student.generated.callback.a(this, 6);
        this.mCallback16 = new com.bxkj.student.generated.callback.a(this, 3);
        this.mCallback14 = new com.bxkj.student.generated.callback.a(this, 1);
        this.mCallback18 = new com.bxkj.student.generated.callback.a(this, 5);
        invalidateAll();
    }
}
