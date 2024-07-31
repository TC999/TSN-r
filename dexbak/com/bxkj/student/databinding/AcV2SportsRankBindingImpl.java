package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.base.p085v2.common.utils.NumberFormatUtils;
import com.bxkj.base.p085v2.common.view.OnBackPress;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AcV2SportsRankBindingImpl extends AcV2SportsRankBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;
    @NonNull
    private final LinearLayout mboundView1;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(7);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{6}, new int[]{2131427995});
        sViewsWithIds = null;
    }

    public AcV2SportsRankBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
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

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        Object obj;
        Object obj2;
        Object obj3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, Object> map = this.mDataMap;
        OnBackPress onBackPress = this.mMActvity;
        long j2 = j & 10;
        String str4 = null;
        Object obj4 = null;
        if (j2 != 0) {
            if (map != null) {
                obj4 = map.get("majorRank");
                obj = map.get("deptRank");
                obj2 = map.get("schoolRank");
                obj3 = map.get("clazzRank");
            } else {
                obj = null;
                obj2 = null;
                obj3 = null;
            }
            boolean z = map == null;
            if (j2 != 0) {
                j |= z ? 32L : 16L;
            }
            String m43753a = NumberFormatUtils.m43753a(obj4);
            str2 = NumberFormatUtils.m43753a(obj);
            str3 = NumberFormatUtils.m43753a(obj2);
            String m43753a2 = NumberFormatUtils.m43753a(obj3);
            r11 = z ? 8 : 0;
            str = m43753a;
            str4 = m43753a2;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        long j3 = 12 & j;
        if ((10 & j) != 0) {
            this.mboundView1.setVisibility(r11);
            TextViewBindingAdapter.setText(this.tvRunClassRank, str4);
            TextViewBindingAdapter.setText(this.tvRunDepartmentRank, str2);
            TextViewBindingAdapter.setText(this.tvRunMajorRank, str);
            TextViewBindingAdapter.setText(this.tvRunSchoolRank, str3);
        }
        if (j3 != 0) {
            this.titleLayout.setActivity(onBackPress);
        }
        if ((j & 8) != 0) {
            this.titleLayout.setTitle("锻炼排名");
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
            this.mDirtyFlags = 8L;
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

    @Override // com.bxkj.student.databinding.AcV2SportsRankBinding
    public void setDataMap(@Nullable Map<String, Object> DataMap) {
        this.mDataMap = DataMap;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.AcV2SportsRankBinding
    public void setMActvity(@Nullable OnBackPress MActvity) {
        this.mMActvity = MActvity;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (7 == variableId) {
            setDataMap((Map) variable);
        } else if (16 != variableId) {
            return false;
        } else {
            setMActvity((OnBackPress) variable);
        }
        return true;
    }

    private AcV2SportsRankBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (NewPubTitleBinding) bindings[6], (TextView) bindings[2], (TextView) bindings[4], (TextView) bindings[3], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[1];
        this.mboundView1 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.titleLayout);
        this.tvRunClassRank.setTag(null);
        this.tvRunDepartmentRank.setTag(null);
        this.tvRunMajorRank.setTag(null);
        this.tvRunSchoolRank.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
