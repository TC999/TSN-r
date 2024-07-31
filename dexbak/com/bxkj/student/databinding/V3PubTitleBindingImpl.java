package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3PubTitleBindingImpl extends V3PubTitleBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback37;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232779, 3);
    }

    public V3PubTitleBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        OnBackPress onBackPress = this.mActivity;
        if (onBackPress != null) {
            onBackPress.onBackPressed();
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
            this.ibBack.setOnClickListener(this.mCallback37);
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

    @Override // com.bxkj.student.databinding.V3PubTitleBinding
    public void setActivity(@Nullable OnBackPress Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3PubTitleBinding
    public void setIsHideBack(@Nullable Boolean IsHideBack) {
        this.mIsHideBack = IsHideBack;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3PubTitleBinding
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
            setActivity((OnBackPress) variable);
            return true;
        } else {
            return false;
        }
    }

    private V3PubTitleBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatImageButton) bindings[1], (ConstraintLayout) bindings[0], (Toolbar) bindings[3], (MarqueeTextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.llTitle.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        this.mCallback37 = new View$OnClickListenerC4297a(this, 1);
        invalidateAll();
    }
}
