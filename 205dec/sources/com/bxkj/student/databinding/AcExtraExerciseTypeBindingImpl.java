package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.run.extraclass.SignTypeActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcExtraExerciseTypeBindingImpl extends AcExtraExerciseTypeBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback6;
    @Nullable
    private final View.OnClickListener mCallback7;
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(4);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{3}, new int[]{2131427995});
        sViewsWithIds = null;
    }

    public AcExtraExerciseTypeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    private boolean onChangeToolbar(NewPubTitleBinding Toolbar, int fieldId) {
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
        if (sourceId == 1) {
            SignTypeActivity signTypeActivity = this.mSignTypeActivity;
            if (signTypeActivity != null) {
                signTypeActivity.N();
            }
        } else if (sourceId != 2) {
        } else {
            SignTypeActivity signTypeActivity2 = this.mSignTypeActivity;
            if (signTypeActivity2 != null) {
                signTypeActivity2.O();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SignTypeActivity signTypeActivity = this.mSignTypeActivity;
        long j5 = 6 & j4;
        if ((j4 & 4) != 0) {
            this.btIn.setOnClickListener(this.mCallback6);
            this.btOut.setOnClickListener(this.mCallback7);
            this.toolbar.setTitle("\u9009\u62e9\u7b7e\u5230\u7c7b\u578b");
        }
        if (j5 != 0) {
            this.toolbar.setActivity(signTypeActivity);
        }
        ViewDataBinding.executeBindingsOn(this.toolbar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.toolbar.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.toolbar.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeToolbar((NewPubTitleBinding) object, fieldId);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.toolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.AcExtraExerciseTypeBinding
    public void setSignTypeActivity(@Nullable SignTypeActivity SignTypeActivity) {
        this.mSignTypeActivity = SignTypeActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(24);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (24 == variableId) {
            setSignTypeActivity((SignTypeActivity) variable);
            return true;
        }
        return false;
    }

    private AcExtraExerciseTypeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[1], (Button) bindings[2], (NewPubTitleBinding) bindings[3]);
        this.mDirtyFlags = -1L;
        this.btIn.setTag(null);
        this.btOut.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        this.mCallback7 = new a(this, 2);
        this.mCallback6 = new a(this, 1);
        invalidateAll();
    }
}
