package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.v2.common.view.a;
import com.bxkj.student.common.view.ToggleButton;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V2AdSwitchBindingImpl extends V2AdSwitchBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v2_pub_title"}, new int[]{1}, new int[]{2131428100});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232701, 2);
    }

    public V2AdSwitchBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
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
        if ((6 & j4) != 0) {
            this.includeTitle.setActivity(aVar);
        }
        if ((j4 & 4) != 0) {
            this.includeTitle.setTitle("\u9690\u79c1\u8bbe\u7f6e");
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
            this.mDirtyFlags = 4L;
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

    @Override // com.bxkj.student.databinding.V2AdSwitchBinding
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

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (3 == variableId) {
            setBackEvent((a) variable);
            return true;
        }
        return false;
    }

    private V2AdSwitchBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (V2PubTitleBinding) bindings[1], (ToggleButton) bindings[2]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.includeTitle);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
