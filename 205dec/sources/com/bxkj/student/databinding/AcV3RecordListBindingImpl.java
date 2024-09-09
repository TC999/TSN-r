package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.google.android.material.tabs.TabLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV3RecordListBindingImpl extends AcV3RecordListBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback61;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232832, 2);
        sparseIntArray.put(2131231481, 3);
        sparseIntArray.put(2131232711, 4);
        sparseIntArray.put(2131232182, 5);
    }

    public AcV3RecordListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3RecordListActivity v3RecordListActivity = this.mMActivity;
        if (v3RecordListActivity != null) {
            v3RecordListActivity.onBackPressed();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j4 & 2) != 0) {
            this.ibBack.setOnClickListener(this.mCallback61);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.AcV3RecordListBinding
    public void setMActivity(@Nullable V3RecordListActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (15 == variableId) {
            setMActivity((V3RecordListActivity) variable);
            return true;
        }
        return false;
    }

    private AcV3RecordListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatImageButton) bindings[1], (AppCompatImageView) bindings[3], (LinearLayout) bindings[5], (TabLayout) bindings[4], (MarqueeTextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        this.mCallback61 = new a(this, 1);
        invalidateAll();
    }
}
