package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.amap.api.maps.MapView;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.V3SportsMapActivity;
import com.google.android.material.tabs.TabLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV3SportsMapBindingImpl extends AcV3SportsMapBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback56;
    @Nullable
    private final View.OnClickListener mCallback57;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;
    @NonNull
    private final TextView mboundView5;
    @NonNull
    private final TextView mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232769, 8);
        sparseIntArray.put(2131232695, 9);
        sparseIntArray.put(2131232256, 10);
        sparseIntArray.put(2131231113, 11);
        sparseIntArray.put(2131232979, 12);
        sparseIntArray.put(2131231423, 13);
        sparseIntArray.put(2131233198, 14);
        sparseIntArray.put(2131232167, 15);
        sparseIntArray.put(2131233076, 16);
    }

    public AcV3SportsMapBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3SportsMapActivity v3SportsMapActivity = this.mBackEvent;
            if (v3SportsMapActivity != null) {
                v3SportsMapActivity.onBackPressed();
            }
        } else if (sourceId != 2) {
        } else {
            V3SportsMapActivity v3SportsMapActivity2 = this.mBackEvent;
            if (v3SportsMapActivity2 != null) {
                v3SportsMapActivity2.U();
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
        int i4 = this.mSportType;
        String str = this.mNotice;
        long j5 = j4 & 34;
        int i5 = 0;
        if (j5 != 0) {
            boolean z3 = i4 == 5;
            if (j5 != 0) {
                j4 |= z3 ? 128L : 64L;
            }
            if (z3) {
                i5 = 8;
            }
        }
        long j6 = 48 & j4;
        if ((32 & j4) != 0) {
            this.ibBack.setOnClickListener(this.mCallback56);
            this.ibSet.setOnClickListener(this.mCallback57);
        }
        if ((j4 & 34) != 0) {
            this.mboundView5.setVisibility(i5);
            this.mboundView7.setVisibility(i5);
            this.tvDistance.setVisibility(i5);
            this.tvStep.setVisibility(i5);
        }
        if (j6 != 0) {
            TextViewBindingAdapter.setText(this.tvDescription, str);
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
            this.mDirtyFlags = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.AcV3SportsMapBinding
    public void setBackEvent(@Nullable V3SportsMapActivity BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsMapBinding
    public void setIsClock(@Nullable String IsClock) {
        this.mIsClock = IsClock;
    }

    @Override // com.bxkj.student.databinding.AcV3SportsMapBinding
    public void setNotice(@Nullable String Notice) {
        this.mNotice = Notice;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsMapBinding
    public void setSportType(int SportType) {
        this.mSportType = SportType;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(25);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsMapBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (9 == variableId) {
            setIsClock((String) variable);
        } else if (25 == variableId) {
            setSportType(((Integer) variable).intValue());
        } else if (3 == variableId) {
            setBackEvent((V3SportsMapActivity) variable);
        } else if (28 == variableId) {
            setTitle((String) variable);
        } else if (20 != variableId) {
            return false;
        } else {
            setNotice((String) variable);
        }
        return true;
    }

    private AcV3SportsMapBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[11], (AppCompatImageButton) bindings[1], (ConstraintLayout) bindings[2], (AppCompatImageView) bindings[13], (LinearLayout) bindings[15], (MapView) bindings[10], (TabLayout) bindings[9], (ConstraintLayout) bindings[8], (MarqueeTextView) bindings[3], (TextView) bindings[4], (TextView) bindings[12], (TextView) bindings[16], (TextView) bindings[6], (TextView) bindings[14]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.ibSet.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[7];
        this.mboundView7 = textView2;
        textView2.setTag(null);
        this.tvDescription.setTag(null);
        this.tvDistance.setTag(null);
        this.tvStep.setTag(null);
        setRootTag(root);
        this.mCallback57 = new a(this, 2);
        this.mCallback56 = new a(this, 1);
        invalidateAll();
    }
}
