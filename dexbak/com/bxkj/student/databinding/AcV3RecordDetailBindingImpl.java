package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.base.view.NoSlidingViewPager;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.google.android.material.tabs.TabLayout;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AcV3RecordDetailBindingImpl extends AcV3RecordDetailBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback25;
    @Nullable
    private final View.OnClickListener mCallback26;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232832, 3);
        sparseIntArray.put(C4215R.C4219id.f16009tb, 4);
        sparseIntArray.put(C4215R.C4219id.viewPager, 5);
    }

    public AcV3RecordDetailBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
            if (v3RecordDetailActivity != null) {
                v3RecordDetailActivity.onBackPressed();
            }
        } else if (sourceId != 2) {
        } else {
            V3RecordDetailActivity v3RecordDetailActivity2 = this.mMActivity;
            if (v3RecordDetailActivity2 != null) {
                v3RecordDetailActivity2.m38443Q();
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
        if ((j & 2) != 0) {
            this.ibBack.setOnClickListener(this.mCallback25);
            this.toolbar.setOnClickListener(this.mCallback26);
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

    @Override // com.bxkj.student.databinding.AcV3RecordDetailBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
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
            setMActivity((V3RecordDetailActivity) variable);
            return true;
        }
        return false;
    }

    private AcV3RecordDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatImageButton) bindings[1], (TabLayout) bindings[4], (TextView) bindings[2], (MarqueeTextView) bindings[3], (NoSlidingViewPager) bindings[5]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.toolbar.setTag(null);
        setRootTag(root);
        this.mCallback25 = new View$OnClickListenerC4297a(this, 1);
        this.mCallback26 = new View$OnClickListenerC4297a(this, 2);
        invalidateAll();
    }
}
