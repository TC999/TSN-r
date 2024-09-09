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
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.generated.callback.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V3PubTitleBindingImpl extends V3PubTitleBinding implements a.InterfaceC0220a {
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

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        com.bxkj.base.v2.common.view.a aVar = this.mActivity;
        if (aVar != null) {
            aVar.onBackPressed();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        String str = this.mTitle;
        Boolean bool = this.mIsHideBack;
        long j5 = j4 & 10;
        int i4 = 0;
        if (j5 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (j5 != 0) {
                j4 |= safeUnbox ? 32L : 16L;
            }
            if (safeUnbox) {
                i4 = 4;
            }
        }
        if ((8 & j4) != 0) {
            this.ibBack.setOnClickListener(this.mCallback37);
        }
        if ((10 & j4) != 0) {
            this.ibBack.setVisibility(i4);
        }
        if ((j4 & 9) != 0) {
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
    public void setActivity(@Nullable com.bxkj.base.v2.common.view.a Activity) {
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
            setActivity((com.bxkj.base.v2.common.view.a) variable);
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
        this.mCallback37 = new a(this, 1);
        invalidateAll();
    }
}
