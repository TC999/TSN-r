package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.set.SportsSetActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV2SportsSetBindingImpl extends AcV2SportsSetBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback31;
    @Nullable
    private final View.OnClickListener mCallback32;
    @Nullable
    private final View.OnClickListener mCallback33;
    @Nullable
    private final View.OnClickListener mCallback34;
    @Nullable
    private final View.OnClickListener mCallback35;
    @Nullable
    private final View.OnClickListener mCallback36;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(9);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{7}, new int[]{2131427995});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131233112, 8);
    }

    public AcV2SportsSetBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleLayout(NewPubTitleBinding TitleLayout, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                SportsSetActivity sportsSetActivity = this.mMSportsSetActivity;
                if (sportsSetActivity != null) {
                    sportsSetActivity.N();
                    return;
                }
                return;
            case 2:
                SportsSetActivity sportsSetActivity2 = this.mMSportsSetActivity;
                if (sportsSetActivity2 != null) {
                    sportsSetActivity2.P();
                    return;
                }
                return;
            case 3:
                SportsSetActivity sportsSetActivity3 = this.mMSportsSetActivity;
                if (sportsSetActivity3 != null) {
                    sportsSetActivity3.O();
                    return;
                }
                return;
            case 4:
                SportsSetActivity sportsSetActivity4 = this.mMSportsSetActivity;
                if (sportsSetActivity4 != null) {
                    sportsSetActivity4.R();
                    return;
                }
                return;
            case 5:
                SportsSetActivity sportsSetActivity5 = this.mMSportsSetActivity;
                if (sportsSetActivity5 != null) {
                    sportsSetActivity5.S();
                    return;
                }
                return;
            case 6:
                SportsSetActivity sportsSetActivity6 = this.mMSportsSetActivity;
                if (sportsSetActivity6 != null) {
                    sportsSetActivity6.Q();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SportsSetActivity sportsSetActivity = this.mMSportsSetActivity;
        if ((6 & j4) != 0) {
            this.titleLayout.setActivity(sportsSetActivity);
        }
        if ((j4 & 4) != 0) {
            this.titleLayout.setTitle("\u953b\u70bc\u8bbe\u7f6e");
            this.tvDescription.setOnClickListener(this.mCallback31);
            this.tvPermissionSet.setOnClickListener(this.mCallback35);
            this.tvRank.setOnClickListener(this.mCallback33);
            this.tvRecord.setOnClickListener(this.mCallback32);
            this.tvSoundSet.setOnClickListener(this.mCallback36);
            this.tvStatistics.setOnClickListener(this.mCallback34);
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.titleLayout.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((NewPubTitleBinding) object, fieldId);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.AcV2SportsSetBinding
    public void setMSportsSetActivity(@Nullable SportsSetActivity MSportsSetActivity) {
        this.mMSportsSetActivity = MSportsSetActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (17 == variableId) {
            setMSportsSetActivity((SportsSetActivity) variable);
            return true;
        }
        return false;
    }

    private AcV2SportsSetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (NewPubTitleBinding) bindings[7], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[8], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[6], (TextView) bindings[4]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        this.tvDescription.setTag(null);
        this.tvPermissionSet.setTag(null);
        this.tvRank.setTag(null);
        this.tvRecord.setTag(null);
        this.tvSoundSet.setTag(null);
        this.tvStatistics.setTag(null);
        setRootTag(root);
        this.mCallback36 = new a(this, 6);
        this.mCallback34 = new a(this, 4);
        this.mCallback35 = new a(this, 5);
        this.mCallback32 = new a(this, 2);
        this.mCallback33 = new a(this, 3);
        this.mCallback31 = new a(this, 1);
        invalidateAll();
    }
}
