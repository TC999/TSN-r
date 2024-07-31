package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
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
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity;
import com.google.android.material.tabs.TabLayout;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AcV3SportsHomeBindingImpl extends AcV3SportsHomeBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback40;
    @Nullable
    private final View.OnClickListener mCallback41;
    @Nullable
    private final View.OnClickListener mCallback42;
    @Nullable
    private final View.OnClickListener mCallback43;
    @Nullable
    private final View.OnClickListener mCallback44;
    @Nullable
    private final View.OnClickListener mCallback45;
    @Nullable
    private final View.OnClickListener mCallback46;
    @Nullable
    private final View.OnClickListener mCallback47;
    @Nullable
    private final View.OnClickListener mCallback48;
    @Nullable
    private final View.OnClickListener mCallback49;
    @Nullable
    private final View.OnClickListener mCallback50;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;
    @NonNull
    private final TextView mboundView5;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.map, 14);
        sparseIntArray.put(2131232230, 15);
        sparseIntArray.put(C4215R.C4219id.tab, 16);
        sparseIntArray.put(C4215R.C4219id.cl_data, 17);
        sparseIntArray.put(C4215R.C4219id.tv_count_hint, 18);
        sparseIntArray.put(C4215R.C4219id.tv_weather, 19);
        sparseIntArray.put(C4215R.C4219id.cl_gps, 20);
        sparseIntArray.put(C4215R.C4219id.tv_gps, 21);
        sparseIntArray.put(C4215R.C4219id.iv_gps, 22);
        sparseIntArray.put(2131232939, 23);
    }

    public AcV3SportsHomeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                V3SportsHomeActivity v3SportsHomeActivity = this.mBackEvent;
                if (v3SportsHomeActivity != null) {
                    v3SportsHomeActivity.onBackPressed();
                    return;
                }
                return;
            case 2:
                V3SportsHomeActivity v3SportsHomeActivity2 = this.mBackEvent;
                if (v3SportsHomeActivity2 != null) {
                    v3SportsHomeActivity2.m38542G0();
                    return;
                }
                return;
            case 3:
                V3SportsHomeActivity v3SportsHomeActivity3 = this.mBackEvent;
                if (v3SportsHomeActivity3 != null) {
                    v3SportsHomeActivity3.m38543F0();
                    return;
                }
                return;
            case 4:
                V3SportsHomeActivity v3SportsHomeActivity4 = this.mBackEvent;
                if (v3SportsHomeActivity4 != null) {
                    v3SportsHomeActivity4.m38543F0();
                    return;
                }
                return;
            case 5:
                V3SportsHomeActivity v3SportsHomeActivity5 = this.mBackEvent;
                if (v3SportsHomeActivity5 != null) {
                    v3SportsHomeActivity5.m38543F0();
                    return;
                }
                return;
            case 6:
                V3SportsHomeActivity v3SportsHomeActivity6 = this.mBackEvent;
                if (v3SportsHomeActivity6 != null) {
                    v3SportsHomeActivity6.m38543F0();
                    return;
                }
                return;
            case 7:
                V3SportsHomeActivity v3SportsHomeActivity7 = this.mBackEvent;
                if (v3SportsHomeActivity7 != null) {
                    v3SportsHomeActivity7.m38545D0();
                    return;
                }
                return;
            case 8:
                V3SportsHomeActivity v3SportsHomeActivity8 = this.mBackEvent;
                if (v3SportsHomeActivity8 != null) {
                    v3SportsHomeActivity8.m38545D0();
                    return;
                }
                return;
            case 9:
                V3SportsHomeActivity v3SportsHomeActivity9 = this.mBackEvent;
                if (v3SportsHomeActivity9 != null) {
                    v3SportsHomeActivity9.m38546C0();
                    return;
                }
                return;
            case 10:
                V3SportsHomeActivity v3SportsHomeActivity10 = this.mBackEvent;
                if (v3SportsHomeActivity10 != null) {
                    v3SportsHomeActivity10.m38544E0();
                    return;
                }
                return;
            case 11:
                V3SportsHomeActivity v3SportsHomeActivity11 = this.mBackEvent;
                if (v3SportsHomeActivity11 != null) {
                    v3SportsHomeActivity11.m38544E0();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mRecordMap;
        long j4 = j & 9;
        String str3 = null;
        if (j4 != 0) {
            JsonGet jsonGet = JsonGet.f15134a;
            int m43769k = jsonGet.m43769k(map, "sportType");
            double m43774f = jsonGet.m43774f(map, "runSportRange");
            String m43759u = jsonGet.m43759u(map, "succeed", "0");
            String m43759u2 = jsonGet.m43759u(map, "sumTime", "0");
            boolean z = m43769k == 5;
            str2 = DecimalFormatUtils.f15114a.m43806a(m43774f);
            if (j4 != 0) {
                if (z) {
                    j2 = j | 32;
                    j3 = 128;
                } else {
                    j2 = j | 16;
                    j3 = 64;
                }
                j = j2 | j3;
            }
            int i3 = z ? 0 : 8;
            int i4 = z ? 8 : 0;
            str = m43759u2;
            str3 = m43759u;
            i = i4;
            i2 = i3;
        } else {
            str = null;
            str2 = null;
            i = 0;
            i2 = 0;
        }
        if ((8 & j) != 0) {
            this.ibBack.setOnClickListener(this.mCallback40);
            this.ibSet.setOnClickListener(this.mCallback41);
            this.ivDescription.setOnClickListener(this.mCallback46);
            this.ivPermission.setOnClickListener(this.mCallback49);
            this.ivStart.setOnClickListener(this.mCallback48);
            this.ivTimeArrow.setOnClickListener(this.mCallback45);
            this.mboundView5.setOnClickListener(this.mCallback43);
            this.tvDescriptionV3.setOnClickListener(this.mCallback47);
            this.tvDistance.setOnClickListener(this.mCallback42);
            this.tvPermissionV3.setOnClickListener(this.mCallback50);
            this.tvTimeUnit.setOnClickListener(this.mCallback44);
        }
        if ((j & 9) != 0) {
            this.ivTimeArrow.setVisibility(i2);
            this.mboundView5.setVisibility(i);
            TextViewBindingAdapter.setText(this.tvCount, str3);
            this.tvDistance.setVisibility(i);
            TextViewBindingAdapter.setText(this.tvDistance, str2);
            TextViewBindingAdapter.setText(this.tvTime, str);
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
            this.mDirtyFlags = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.AcV3SportsHomeBinding
    public void setBackEvent(@Nullable V3SportsHomeActivity BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsHomeBinding
    public void setRecordMap(@Nullable Map<String, Object> RecordMap) {
        this.mRecordMap = RecordMap;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(22);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.AcV3SportsHomeBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (22 == variableId) {
            setRecordMap((Map) variable);
        } else if (3 == variableId) {
            setBackEvent((V3SportsHomeActivity) variable);
        } else if (28 != variableId) {
            return false;
        } else {
            setTitle((String) variable);
        }
        return true;
    }

    private AcV3SportsHomeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[17], (ConstraintLayout) bindings[20], (AppCompatImageButton) bindings[1], (ConstraintLayout) bindings[2], (ImageView) bindings[9], (AppCompatImageView) bindings[22], (ImageView) bindings[12], (ImageView) bindings[11], (ImageView) bindings[8], (ConstraintLayout) bindings[15], (MapView) bindings[14], (TabLayout) bindings[16], (TextView) bindings[3], (TextView) bindings[18], (TextView) bindings[23], (TextView) bindings[10], (TextView) bindings[4], (TextView) bindings[21], (TextView) bindings[13], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[19]);
        this.mDirtyFlags = -1L;
        this.ibBack.setTag(null);
        this.ibSet.setTag(null);
        this.ivDescription.setTag(null);
        this.ivPermission.setTag(null);
        this.ivStart.setTag(null);
        this.ivTimeArrow.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) bindings[5];
        this.mboundView5 = textView;
        textView.setTag(null);
        this.tvCount.setTag(null);
        this.tvDescriptionV3.setTag(null);
        this.tvDistance.setTag(null);
        this.tvPermissionV3.setTag(null);
        this.tvTime.setTag(null);
        this.tvTimeUnit.setTag(null);
        setRootTag(root);
        this.mCallback47 = new View$OnClickListenerC4297a(this, 8);
        this.mCallback43 = new View$OnClickListenerC4297a(this, 4);
        this.mCallback42 = new View$OnClickListenerC4297a(this, 3);
        this.mCallback50 = new View$OnClickListenerC4297a(this, 11);
        this.mCallback48 = new View$OnClickListenerC4297a(this, 9);
        this.mCallback44 = new View$OnClickListenerC4297a(this, 5);
        this.mCallback49 = new View$OnClickListenerC4297a(this, 10);
        this.mCallback45 = new View$OnClickListenerC4297a(this, 6);
        this.mCallback40 = new View$OnClickListenerC4297a(this, 1);
        this.mCallback46 = new View$OnClickListenerC4297a(this, 7);
        this.mCallback41 = new View$OnClickListenerC4297a(this, 2);
        invalidateAll();
    }
}
