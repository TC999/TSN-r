package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.common.view.TrackProgressView;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.google.android.material.card.MaterialCardView;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3FmBasicBindingImpl extends V3FmBasicBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback60;
    private long mDirtyFlags;
    @NonNull
    private final NestedScrollView mboundView0;
    @NonNull
    private final ConstraintLayout mboundView1;
    @Nullable
    private final V3LayoutSportDetailDataCommonBinding mboundView11;
    @NonNull
    private final ImageView mboundView2;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(27);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"v3_layout_sport_detail_data_common"}, new int[]{3}, new int[]{C4215R.C4221layout.v3_layout_sport_detail_data_common});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.card1, 4);
        sparseIntArray.put(C4215R.C4219id.tp_step, 5);
        sparseIntArray.put(C4215R.C4219id.tp_time, 6);
        sparseIntArray.put(C4215R.C4219id.tp_distance, 7);
        sparseIntArray.put(C4215R.C4219id.tv_current_step, 8);
        sparseIntArray.put(C4215R.C4219id.tv_current_time, 9);
        sparseIntArray.put(C4215R.C4219id.tv_current_distance, 10);
        sparseIntArray.put(C4215R.C4219id.tv1, 11);
        sparseIntArray.put(C4215R.C4219id.card2, 12);
        sparseIntArray.put(C4215R.C4219id.tv_rank_hint, 13);
        sparseIntArray.put(C4215R.C4219id.card_rank_line, 14);
        sparseIntArray.put(C4215R.C4219id.tv_result_hint, 15);
        sparseIntArray.put(2131233116, 16);
        sparseIntArray.put(C4215R.C4219id.tv_rank_unit, 17);
        sparseIntArray.put(C4215R.C4219id.tv_result, 18);
        sparseIntArray.put(C4215R.C4219id.card3, 19);
        sparseIntArray.put(C4215R.C4219id.tv_cj_hint, 20);
        sparseIntArray.put(C4215R.C4219id.card_cj_line, 21);
        sparseIntArray.put(C4215R.C4219id.tv_cj, 22);
        sparseIntArray.put(C4215R.C4219id.iv_jb1, 23);
        sparseIntArray.put(C4215R.C4219id.iv_jb2, 24);
        sparseIntArray.put(C4215R.C4219id.iv_jb3, 25);
        sparseIntArray.put(2131232182, 26);
    }

    public V3FmBasicBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 27, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
        if (v3RecordDetailActivity != null) {
            v3RecordDetailActivity.m38441S();
        }
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
        long j2 = 6 & j;
        if ((5 & j) != 0) {
            this.mboundView11.setMActivity(v3RecordDetailActivity);
        }
        if (j2 != 0) {
            this.mboundView11.setMap(map);
        }
        if ((j & 4) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback60);
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

    @Override // com.bxkj.student.databinding.V3FmBasicBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3FmBasicBinding
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

    private V3FmBasicBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[4], (MaterialCardView) bindings[12], (MaterialCardView) bindings[19], (MaterialCardView) bindings[21], (MaterialCardView) bindings[14], (ImageView) bindings[23], (ImageView) bindings[24], (ImageView) bindings[25], (LinearLayout) bindings[26], (TrackProgressView) bindings[7], (TrackProgressView) bindings[5], (TrackProgressView) bindings[6], (TextView) bindings[11], (TextView) bindings[22], (TextView) bindings[20], (TextView) bindings[10], (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[16], (TextView) bindings[13], (TextView) bindings[17], (TextView) bindings[18], (TextView) bindings[15]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        V3LayoutSportDetailDataCommonBinding v3LayoutSportDetailDataCommonBinding = (V3LayoutSportDetailDataCommonBinding) bindings[3];
        this.mboundView11 = v3LayoutSportDetailDataCommonBinding;
        setContainedBinding(v3LayoutSportDetailDataCommonBinding);
        ImageView imageView = (ImageView) bindings[2];
        this.mboundView2 = imageView;
        imageView.setTag(null);
        setRootTag(root);
        this.mCallback60 = new View$OnClickListenerC4297a(this, 1);
        invalidateAll();
    }
}
