package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3FmDataBindingImpl extends V3FmDataBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final NestedScrollView mboundView0;
    @NonNull
    private final ConstraintLayout mboundView1;
    @Nullable
    private final V3LayoutSportDetailDataCommonBinding mboundView11;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(35);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"v3_layout_sport_detail_data_common"}, new int[]{2}, new int[]{C4215R.C4221layout.v3_layout_sport_detail_data_common});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.card1, 3);
        sparseIntArray.put(C4215R.C4219id.tv1, 4);
        sparseIntArray.put(C4215R.C4219id.tv2, 5);
        sparseIntArray.put(C4215R.C4219id.card_total_tagrt, 6);
        sparseIntArray.put(C4215R.C4219id.tv_zdbsj, 7);
        sparseIntArray.put(C4215R.C4219id.iv_yxlc, 8);
        sparseIntArray.put(C4215R.C4219id.tv_yxlc_hint, 9);
        sparseIntArray.put(C4215R.C4219id.tv_yxlc, 10);
        sparseIntArray.put(C4215R.C4219id.tv_yxlc_unit, 11);
        sparseIntArray.put(C4215R.C4219id.iv_dblc, 12);
        sparseIntArray.put(C4215R.C4219id.tv_dblc_hint, 13);
        sparseIntArray.put(C4215R.C4219id.tv_dblc, 14);
        sparseIntArray.put(C4215R.C4219id.tv_dblc_unit, 15);
        sparseIntArray.put(C4215R.C4219id.pb_distance, 16);
        sparseIntArray.put(C4215R.C4219id.iv_yxxs, 17);
        sparseIntArray.put(C4215R.C4219id.tv_yxcs_hint, 18);
        sparseIntArray.put(C4215R.C4219id.tv_yxcs, 19);
        sparseIntArray.put(C4215R.C4219id.tv_yxcs_unit, 20);
        sparseIntArray.put(C4215R.C4219id.iv_dbcs, 21);
        sparseIntArray.put(C4215R.C4219id.tv_dbcs_hint, 22);
        sparseIntArray.put(C4215R.C4219id.tv_dbcs, 23);
        sparseIntArray.put(C4215R.C4219id.tv_dbcs_unit, 24);
        sparseIntArray.put(C4215R.C4219id.pb_count, 25);
        sparseIntArray.put(C4215R.C4219id.iv_ljsc, 26);
        sparseIntArray.put(C4215R.C4219id.tv_lssc_hint, 27);
        sparseIntArray.put(C4215R.C4219id.tv_ljsc, 28);
        sparseIntArray.put(C4215R.C4219id.tv_ljsc_unit, 29);
        sparseIntArray.put(C4215R.C4219id.iv_pbts, 30);
        sparseIntArray.put(C4215R.C4219id.tv_pbts_hint, 31);
        sparseIntArray.put(C4215R.C4219id.tv_pbts, 32);
        sparseIntArray.put(C4215R.C4219id.tv_pbts_unit, 33);
        sparseIntArray.put(C4215R.C4219id.bt_appeal, 34);
    }

    public V3FmDataBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 35, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
        Map<String, Object> map = this.mMap;
        long j2 = 5 & j;
        if ((j & 6) != 0) {
            this.mboundView11.setMap(map);
        }
        if (j2 != 0) {
            this.mboundView11.setMActivity(v3RecordDetailActivity);
        }
        ViewDataBinding.executeBindingsOn(this.mboundView11);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.mboundView11.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.mboundView11.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.mboundView11.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.V3FmDataBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3FmDataBinding
    public void setMap(@Nullable Map<String, Object> Map) {
        this.mMap = Map;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (15 == variableId) {
            setMActivity((V3RecordDetailActivity) variable);
        } else if (18 != variableId) {
            return false;
        } else {
            setMap((Map) variable);
        }
        return true;
    }

    private V3FmDataBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[34], (MaterialCardView) bindings[3], (MaterialCardView) bindings[6], (ImageView) bindings[21], (ImageView) bindings[12], (ImageView) bindings[26], (ImageView) bindings[30], (ImageView) bindings[8], (ImageView) bindings[17], (ProgressBar) bindings[25], (ProgressBar) bindings[16], (TextView) bindings[4], (TextView) bindings[5], (TextView) bindings[23], (TextView) bindings[22], (TextView) bindings[24], (TextView) bindings[14], (TextView) bindings[13], (TextView) bindings[15], (TextView) bindings[28], (TextView) bindings[29], (TextView) bindings[27], (TextView) bindings[32], (TextView) bindings[31], (TextView) bindings[33], (TextView) bindings[19], (TextView) bindings[18], (TextView) bindings[20], (TextView) bindings[10], (TextView) bindings[9], (TextView) bindings[11], (TextView) bindings[7]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        V3LayoutSportDetailDataCommonBinding v3LayoutSportDetailDataCommonBinding = (V3LayoutSportDetailDataCommonBinding) bindings[2];
        this.mboundView11 = v3LayoutSportDetailDataCommonBinding;
        setContainedBinding(v3LayoutSportDetailDataCommonBinding);
        setRootTag(root);
        invalidateAll();
    }
}
