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
import com.bxkj.base.R;
import com.bxkj.base.generated.callback.a;
import com.bxkj.base.view.MarqueeTextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class NewPubTitleBindingImpl extends NewPubTitleBinding implements a.InterfaceC0195a {
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
        sparseIntArray.put(R.id.toolbar, 3);
    }

    public NewPubTitleBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.base.generated.callback.a.InterfaceC0195a
    public final void _internalCallbackOnClick(int i4, View view) {
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
            this.ibBack.setOnClickListener(this.mCallback1);
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
    protected boolean onFieldChange(int i4, Object obj, int i5) {
        return false;
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setActivity(@Nullable com.bxkj.base.v2.common.view.a aVar) {
        this.mActivity = aVar;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(com.bxkj.base.a.f18108b);
        super.requestRebind();
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setIsHideBack(@Nullable Boolean bool) {
        this.mIsHideBack = bool;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(com.bxkj.base.a.f18117k);
        super.requestRebind();
    }

    @Override // com.bxkj.base.databinding.NewPubTitleBinding
    public void setTitle(@Nullable String str) {
        this.mTitle = str;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(com.bxkj.base.a.C);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i4, @Nullable Object obj) {
        if (com.bxkj.base.a.C == i4) {
            setTitle((String) obj);
        } else if (com.bxkj.base.a.f18117k == i4) {
            setIsHideBack((Boolean) obj);
        } else if (com.bxkj.base.a.f18108b != i4) {
            return false;
        } else {
            setActivity((com.bxkj.base.v2.common.view.a) obj);
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
        this.mCallback1 = new a(this, 1);
        invalidateAll();
    }
}
