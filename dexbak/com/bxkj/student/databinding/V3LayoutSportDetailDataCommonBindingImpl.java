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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3LayoutSportDetailDataCommonBindingImpl extends V3LayoutSportDetailDataCommonBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback62;
    @Nullable
    private final View.OnClickListener mCallback63;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.v_left, 15);
        sparseIntArray.put(C4215R.C4219id.v_right, 16);
        sparseIntArray.put(C4215R.C4219id.iv_distance, 17);
        sparseIntArray.put(C4215R.C4219id.tv_distance_hint, 18);
        sparseIntArray.put(C4215R.C4219id.tv_distance_unit, 19);
        sparseIntArray.put(C4215R.C4219id.iv_time, 20);
        sparseIntArray.put(C4215R.C4219id.tv_time_hint, 21);
        sparseIntArray.put(C4215R.C4219id.iv_step_count, 22);
        sparseIntArray.put(C4215R.C4219id.tv_step_count_hint, 23);
        sparseIntArray.put(C4215R.C4219id.tv_step_count_unit, 24);
        sparseIntArray.put(C4215R.C4219id.iv_step_distance, 25);
        sparseIntArray.put(C4215R.C4219id.tv_step_distance_hint, 26);
        sparseIntArray.put(C4215R.C4219id.tv_step_distance_unit, 27);
        sparseIntArray.put(C4215R.C4219id.iv_step, 28);
        sparseIntArray.put(C4215R.C4219id.tv_step_hint, 29);
        sparseIntArray.put(C4215R.C4219id.tv_step_unit, 30);
        sparseIntArray.put(C4215R.C4219id.iv_heart, 31);
        sparseIntArray.put(C4215R.C4219id.tv_heart_hint, 32);
        sparseIntArray.put(C4215R.C4219id.tv_heart_unit, 33);
        sparseIntArray.put(C4215R.C4219id.iv_hot, 34);
        sparseIntArray.put(C4215R.C4219id.tv_hot_hint, 35);
        sparseIntArray.put(C4215R.C4219id.tv_hot_unit, 36);
        sparseIntArray.put(C4215R.C4219id.iv_pjpl, 37);
        sparseIntArray.put(C4215R.C4219id.tv_pjpl_hint, 38);
        sparseIntArray.put(C4215R.C4219id.tv_pjpl_unit, 39);
        sparseIntArray.put(C4215R.C4219id.iv_zjps, 40);
        sparseIntArray.put(C4215R.C4219id.tv_zjps_hint, 41);
        sparseIntArray.put(C4215R.C4219id.tv_zjps_unit, 42);
        sparseIntArray.put(C4215R.C4219id.iv_pjsd, 43);
        sparseIntArray.put(C4215R.C4219id.tv_pjsd_hint, 44);
        sparseIntArray.put(C4215R.C4219id.tv_pjsd_unit, 45);
        sparseIntArray.put(C4215R.C4219id.iv_fast_speed, 46);
        sparseIntArray.put(C4215R.C4219id.tv_fast_speed_hint, 47);
        sparseIntArray.put(C4215R.C4219id.tv_fast_speed_unit, 48);
        sparseIntArray.put(C4215R.C4219id.iv_slow_speed, 49);
        sparseIntArray.put(C4215R.C4219id.tv_slow_speed_hint, 50);
        sparseIntArray.put(C4215R.C4219id.tv_slow_speed_unit, 51);
    }

    public V3LayoutSportDetailDataCommonBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 52, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
            if (v3RecordDetailActivity != null) {
                v3RecordDetailActivity.m38442R();
            }
        } else if (sourceId != 2) {
        } else {
            V3RecordDetailActivity v3RecordDetailActivity2 = this.mMActivity;
            if (v3RecordDetailActivity2 != null) {
                v3RecordDetailActivity2.m38442R();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i;
        int i2;
        boolean z;
        boolean z2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j3 = j & 5;
        String str12 = null;
        if (j3 != 0) {
            JsonGet jsonGet = JsonGet.f15134a;
            str7 = jsonGet.m43760t(map, "app_format_sportTime");
            str8 = jsonGet.m43760t(map, "stepDistance");
            str9 = jsonGet.m43760t(map, "slowSpeed");
            str10 = jsonGet.m43760t(map, "rate");
            String m43760t = jsonGet.m43760t(map, "stepMinute");
            String m43760t2 = jsonGet.m43760t(map, "exceptionData");
            String m43760t3 = jsonGet.m43760t(map, "stepCount");
            String m43760t4 = jsonGet.m43760t(map, "calorie");
            String m43760t5 = jsonGet.m43760t(map, "fastSpeed");
            double m43774f = jsonGet.m43774f(map, "app_format_sportRange");
            String m43760t6 = jsonGet.m43760t(map, "bestPaceKm");
            String m43760t7 = jsonGet.m43760t(map, "heartRate");
            String m43760t8 = jsonGet.m43760t(map, "app_format_avgspeed");
            if (m43760t2 != null) {
                z = m43760t2.contains("步频");
                z2 = m43760t2.contains("步幅");
            } else {
                z = false;
                z2 = false;
            }
            if (j3 != 0) {
                j |= z ? 16L : 8L;
            }
            if ((j & 5) != 0) {
                j |= z2 ? 64L : 32L;
            }
            String m43806a = DecimalFormatUtils.f15114a.m43806a(m43774f);
            i = z ? 0 : 8;
            str5 = m43760t;
            str4 = m43760t8;
            i2 = z2 ? 0 : 8;
            str3 = m43760t4;
            str6 = m43760t3;
            str11 = m43760t6;
            str2 = m43760t7;
            j2 = 5;
            str12 = m43806a;
            str = m43760t5;
        } else {
            j2 = 5;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            i = 0;
            i2 = 0;
        }
        int i3 = ((j & j2) > 0L ? 1 : ((j & j2) == 0L ? 0 : -1));
        long j4 = j;
        if (i3 != 0) {
            this.tvBfException.setVisibility(i2);
            TextViewBindingAdapter.setText(this.tvDistance, str12);
            TextViewBindingAdapter.setText(this.tvFastSpeed, str);
            TextViewBindingAdapter.setText(this.tvHeart, str2);
            TextViewBindingAdapter.setText(this.tvHot, str3);
            TextViewBindingAdapter.setText(this.tvPjpl, str10);
            TextViewBindingAdapter.setText(this.tvPjsd, str4);
            TextViewBindingAdapter.setText(this.tvSlowSpeed, str9);
            TextViewBindingAdapter.setText(this.tvStep, str5);
            TextViewBindingAdapter.setText(this.tvStepCount, str6);
            TextViewBindingAdapter.setText(this.tvStepDistance, str8);
            this.tvStepException.setVisibility(i);
            TextViewBindingAdapter.setText(this.tvTime, str7);
            TextViewBindingAdapter.setText(this.tvZjps, str11);
        }
        if ((j4 & 4) != 0) {
            this.tvBfException.setOnClickListener(this.mCallback62);
            this.tvStepException.setOnClickListener(this.mCallback63);
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
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.V3LayoutSportDetailDataCommonBinding
    public void setMActivity(@Nullable V3RecordDetailActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3LayoutSportDetailDataCommonBinding
    public void setMap(@Nullable Map<String, Object> Map) {
        this.mMap = Map;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(18);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (18 == variableId) {
            setMap((Map) variable);
        } else if (15 != variableId) {
            return false;
        } else {
            setMActivity((V3RecordDetailActivity) variable);
        }
        return true;
    }

    private V3LayoutSportDetailDataCommonBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[17], (ImageView) bindings[46], (ImageView) bindings[31], (ImageView) bindings[34], (ImageView) bindings[37], (ImageView) bindings[43], (ImageView) bindings[49], (ImageView) bindings[28], (ImageView) bindings[22], (ImageView) bindings[25], (ImageView) bindings[20], (ImageView) bindings[40], (TextView) bindings[4], (TextView) bindings[1], (TextView) bindings[18], (TextView) bindings[19], (TextView) bindings[13], (TextView) bindings[47], (TextView) bindings[48], (TextView) bindings[8], (TextView) bindings[32], (TextView) bindings[33], (TextView) bindings[12], (TextView) bindings[35], (TextView) bindings[36], (TextView) bindings[10], (TextView) bindings[38], (TextView) bindings[39], (TextView) bindings[9], (TextView) bindings[44], (TextView) bindings[45], (TextView) bindings[14], (TextView) bindings[50], (TextView) bindings[51], (TextView) bindings[7], (TextView) bindings[3], (TextView) bindings[23], (TextView) bindings[24], (TextView) bindings[5], (TextView) bindings[26], (TextView) bindings[27], (TextView) bindings[6], (TextView) bindings[29], (TextView) bindings[30], (TextView) bindings[2], (TextView) bindings[21], (TextView) bindings[11], (TextView) bindings[41], (TextView) bindings[42], (View) bindings[15], (View) bindings[16]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvBfException.setTag(null);
        this.tvDistance.setTag(null);
        this.tvFastSpeed.setTag(null);
        this.tvHeart.setTag(null);
        this.tvHot.setTag(null);
        this.tvPjpl.setTag(null);
        this.tvPjsd.setTag(null);
        this.tvSlowSpeed.setTag(null);
        this.tvStep.setTag(null);
        this.tvStepCount.setTag(null);
        this.tvStepDistance.setTag(null);
        this.tvStepException.setTag(null);
        this.tvTime.setTag(null);
        this.tvZjps.setTag(null);
        setRootTag(root);
        this.mCallback62 = new View$OnClickListenerC4297a(this, 1);
        this.mCallback63 = new View$OnClickListenerC4297a(this, 2);
        invalidateAll();
    }
}
