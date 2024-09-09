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
import com.bxkj.student.generated.callback.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PubTitleBindingImpl extends PubTitleBinding implements a.InterfaceC0220a {
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

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
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
            this.ibBack.setOnClickListener(this.mCallback38);
            this.ibRight.setOnClickListener(this.mCallback39);
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
        this.mCallback38 = new a(this, 1);
        this.mCallback39 = new a(this, 2);
        invalidateAll();
    }
}
