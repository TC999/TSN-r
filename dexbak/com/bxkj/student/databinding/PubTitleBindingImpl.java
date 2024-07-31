package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PubTitleBindingImpl extends PubTitleBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = null;
    @Nullable
    private final View.OnClickListener mCallback38;
    @Nullable
    private final View.OnClickListener mCallback39;
    private long mDirtyFlags;

    public PubTitleBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            AppCompatActivity appCompatActivity = this.mActivity;
            if (appCompatActivity != null) {
                appCompatActivity.finish();
            }
        } else if (sourceId != 2) {
        } else {
            AppCompatActivity appCompatActivity2 = this.mActivity;
            if (appCompatActivity2 != null) {
                appCompatActivity2.finish();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mTitle;
        Boolean bool = this.mIsHideBack;
        long j2 = j & 10;
        int i = 0;
        if (j2 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j2 != 0) {
                j |= safeUnbox ? 32L : 16L;
            }
            if (safeUnbox) {
                i = 4;
            }
        }
        if ((8 & j) != 0) {
            this.ibBack.setOnClickListener(this.mCallback38);
            this.ibRight.setOnClickListener(this.mCallback39);
        }
        if ((10 & j) != 0) {
            this.ibBack.setVisibility(i);
        }
        if ((j & 9) != 0) {
            TextViewBindingAdapter.setText(this.tvTitle, str);
        }
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
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.PubTitleBinding
    public void setActivity(@Nullable AppCompatActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.PubTitleBinding
    public void setIsHideBack(@Nullable Boolean IsHideBack) {
        this.mIsHideBack = IsHideBack;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.PubTitleBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (28 == variableId) {
            setTitle((String) variable);
            return true;
        } else if (10 == variableId) {
            setIsHideBack((Boolean) variable);
            return true;
        } else if (1 == variableId) {
            setActivity((AppCompatActivity) variable);
            return true;
        } else {
            return false;
        }
    }

    private PubTitleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatImageButton) bindings[2], (AppCompatImageButton) bindings[3], (ConstraintLayout) bindings[0], (MarqueeTextView) bindings[1]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.ibRight.setTag(null);
        this.llTitle.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        this.mCallback38 = new View$OnClickListenerC4297a(this, 1);
        this.mCallback39 = new View$OnClickListenerC4297a(this, 2);
        invalidateAll();
    }
}
