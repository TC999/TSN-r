package com.bxkj.base.databinding;

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
import com.bxkj.base.BR;
import com.bxkj.base.C3801R;
import com.bxkj.base.generated.callback.OnClickListener;
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.base.view.MarqueeTextView;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class NewPubTitleBindingImpl extends NewPubTitleBinding implements OnClickListener.InterfaceC3872a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback1;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C3801R.C3805id.toolbar, 3);
    }

    public NewPubTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.base.generated.callback.OnClickListener.InterfaceC3872a
    public final void _internalCallbackOnClick(int i, View view) {
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
            this.ibBack.setOnClickListener(this.mCallback1);
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
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setActivity(@Nullable OnBackPress onBackPress) {
        this.mActivity = onBackPress;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.f14619b);
        super.requestRebind();
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setIsHideBack(@Nullable Boolean bool) {
        this.mIsHideBack = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.f14628k);
        super.requestRebind();
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setTitle(@Nullable String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.f14616C);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.f14616C == i) {
            setTitle((String) obj);
        } else if (BR.f14628k == i) {
            setIsHideBack((Boolean) obj);
        } else if (BR.f14619b != i) {
            return false;
        } else {
            setActivity((OnBackPress) obj);
        }
        return true;
    }

    private NewPubTitleBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (AppCompatImageButton) objArr[1], (ConstraintLayout) objArr[0], (Toolbar) objArr[3], (MarqueeTextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.llTitle.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(view);
        this.mCallback1 = new OnClickListener(this, 1);
        invalidateAll();
    }
}
