package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.v2.common.view.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V2MyQrcodeBindingImpl extends V2MyQrcodeBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(6);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v2_pub_title"}, new int[]{1}, new int[]{2131428100});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131233111, 2);
        sparseIntArray.put(2131231400, 3);
        sparseIntArray.put(2131233040, 4);
        sparseIntArray.put(2131231393, 5);
    }

    public V2MyQrcodeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private boolean onChangeIncludeTitle(V2PubTitleBinding IncludeTitle, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        a aVar = this.mBackEvent;
        String str = this.mTitle;
        long j5 = 10 & j4;
        if ((j4 & 12) != 0) {
            this.includeTitle.setTitle(str);
        }
        if (j5 != 0) {
            this.includeTitle.setActivity(aVar);
        }
        ViewDataBinding.executeBindingsOn(this.includeTitle);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.includeTitle.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
        }
        this.includeTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeIncludeTitle((V2PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.V2MyQrcodeBinding
    public void setBackEvent(@Nullable a BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeTitle.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.V2MyQrcodeBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (3 == variableId) {
            setBackEvent((a) variable);
        } else if (28 != variableId) {
            return false;
        } else {
            setTitle((String) variable);
        }
        return true;
    }

    private V2MyQrcodeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (V2PubTitleBinding) bindings[1], (ImageView) bindings[5], (ImageView) bindings[3], (TextView) bindings[4], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.includeTitle);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
