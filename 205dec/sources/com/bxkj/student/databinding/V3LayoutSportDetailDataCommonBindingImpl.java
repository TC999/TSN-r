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
import com.bxkj.base.v2.common.utils.e;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V3LayoutSportDetailDataCommonBindingImpl extends V3LayoutSportDetailDataCommonBinding implements a.InterfaceC0220a {
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
        sparseIntArray.put(2131233280, 15);
        sparseIntArray.put(2131233281, 16);
        sparseIntArray.put(2131231410, 17);
        sparseIntArray.put(2131232942, 18);
        sparseIntArray.put(2131232945, 19);
        sparseIntArray.put(2131231498, 20);
        sparseIntArray.put(2131233200, 21);
        sparseIntArray.put(2131231492, 22);
        sparseIntArray.put(2131233172, 23);
        sparseIntArray.put(2131233173, 24);
        sparseIntArray.put(2131231493, 25);
        sparseIntArray.put(2131233175, 26);
        sparseIntArray.put(2131233176, 27);
        sparseIntArray.put(2131231491, 28);
        sparseIntArray.put(2131233178, 29);
        sparseIntArray.put(2131233184, 30);
        sparseIntArray.put(2131231430, 31);
        sparseIntArray.put(2131232986, 32);
        sparseIntArray.put(2131232987, 33);
        sparseIntArray.put(2131231432, 34);
        sparseIntArray.put(2131232998, 35);
        sparseIntArray.put(2131232999, 36);
        sparseIntArray.put(2131231467, 37);
        sparseIntArray.put(2131233091, 38);
        sparseIntArray.put(2131233092, 39);
        sparseIntArray.put(2131231510, 40);
        sparseIntArray.put(2131233251, 41);
        sparseIntArray.put(2131233252, 42);
        sparseIntArray.put(2131231468, 43);
        sparseIntArray.put(2131233094, 44);
        sparseIntArray.put(2131233095, 45);
        sparseIntArray.put(2131231417, 46);
        sparseIntArray.put(2131232962, 47);
        sparseIntArray.put(2131232963, 48);
        sparseIntArray.put(2131231484, 49);
        sparseIntArray.put(2131233157, 50);
        sparseIntArray.put(2131233158, 51);
    }

    public V3LayoutSportDetailDataCommonBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 52, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3RecordDetailActivity v3RecordDetailActivity = this.mMActivity;
            if (v3RecordDetailActivity != null) {
                v3RecordDetailActivity.R();
            }
        } else if (sourceId != 2) {
        } else {
            V3RecordDetailActivity v3RecordDetailActivity2 = this.mMActivity;
            if (v3RecordDetailActivity2 != null) {
                v3RecordDetailActivity2.R();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        long j5;
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
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j6 = j4 & 5;
        String str12 = null;
        if (j6 != 0) {
            l lVar = l.f18624a;
            str7 = lVar.t(map, "app_format_sportTime");
            str8 = lVar.t(map, "stepDistance");
            str9 = lVar.t(map, "slowSpeed");
            str10 = lVar.t(map, "rate");
            String t3 = lVar.t(map, "stepMinute");
            String t4 = lVar.t(map, "exceptionData");
            String t5 = lVar.t(map, "stepCount");
            String t6 = lVar.t(map, "calorie");
            String t7 = lVar.t(map, "fastSpeed");
            double f4 = lVar.f(map, "app_format_sportRange");
            String t8 = lVar.t(map, "bestPaceKm");
            String t9 = lVar.t(map, "heartRate");
            String t10 = lVar.t(map, "app_format_avgspeed");
            if (t4 != null) {
                z3 = t4.contains("\u6b65\u9891");
                z4 = t4.contains("\u6b65\u5e45");
            } else {
                z3 = false;
                z4 = false;
            }
            if (j6 != 0) {
                j4 |= z3 ? 16L : 8L;
            }
            if ((j4 & 5) != 0) {
                j4 |= z4 ? 64L : 32L;
            }
            String a4 = e.f18604a.a(f4);
            i4 = z3 ? 0 : 8;
            str5 = t3;
            str4 = t10;
            i5 = z4 ? 0 : 8;
            str3 = t6;
            str6 = t5;
            str11 = t8;
            str2 = t9;
            j5 = 5;
            str12 = a4;
            str = t7;
        } else {
            j5 = 5;
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
            i4 = 0;
            i5 = 0;
        }
        int i6 = ((j4 & j5) > 0L ? 1 : ((j4 & j5) == 0L ? 0 : -1));
        long j7 = j4;
        if (i6 != 0) {
            this.tvBfException.setVisibility(i5);
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
            this.tvStepException.setVisibility(i4);
            TextViewBindingAdapter.setText(this.tvTime, str7);
            TextViewBindingAdapter.setText(this.tvZjps, str11);
        }
        if ((j7 & 4) != 0) {
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
        this.mCallback62 = new a(this, 1);
        this.mCallback63 = new a(this, 2);
        invalidateAll();
    }
}
