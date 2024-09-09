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
import com.bxkj.base.v2.common.utils.e;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.v3.V3SportsHomeActivity;
import com.google.android.material.tabs.TabLayout;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV3SportsHomeBindingImpl extends AcV3SportsHomeBinding implements a.InterfaceC0220a {
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
        sparseIntArray.put(2131232258, 14);
        sparseIntArray.put(2131232230, 15);
        sparseIntArray.put(2131232695, 16);
        sparseIntArray.put(2131231112, 17);
        sparseIntArray.put(2131232916, 18);
        sparseIntArray.put(2131233227, 19);
        sparseIntArray.put(2131231113, 20);
        sparseIntArray.put(2131232979, 21);
        sparseIntArray.put(2131231423, 22);
        sparseIntArray.put(2131232939, 23);
    }

    public AcV3SportsHomeBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
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
                    v3SportsHomeActivity2.G0();
                    return;
                }
                return;
            case 3:
                V3SportsHomeActivity v3SportsHomeActivity3 = this.mBackEvent;
                if (v3SportsHomeActivity3 != null) {
                    v3SportsHomeActivity3.F0();
                    return;
                }
                return;
            case 4:
                V3SportsHomeActivity v3SportsHomeActivity4 = this.mBackEvent;
                if (v3SportsHomeActivity4 != null) {
                    v3SportsHomeActivity4.F0();
                    return;
                }
                return;
            case 5:
                V3SportsHomeActivity v3SportsHomeActivity5 = this.mBackEvent;
                if (v3SportsHomeActivity5 != null) {
                    v3SportsHomeActivity5.F0();
                    return;
                }
                return;
            case 6:
                V3SportsHomeActivity v3SportsHomeActivity6 = this.mBackEvent;
                if (v3SportsHomeActivity6 != null) {
                    v3SportsHomeActivity6.F0();
                    return;
                }
                return;
            case 7:
                V3SportsHomeActivity v3SportsHomeActivity7 = this.mBackEvent;
                if (v3SportsHomeActivity7 != null) {
                    v3SportsHomeActivity7.D0();
                    return;
                }
                return;
            case 8:
                V3SportsHomeActivity v3SportsHomeActivity8 = this.mBackEvent;
                if (v3SportsHomeActivity8 != null) {
                    v3SportsHomeActivity8.D0();
                    return;
                }
                return;
            case 9:
                V3SportsHomeActivity v3SportsHomeActivity9 = this.mBackEvent;
                if (v3SportsHomeActivity9 != null) {
                    v3SportsHomeActivity9.C0();
                    return;
                }
                return;
            case 10:
                V3SportsHomeActivity v3SportsHomeActivity10 = this.mBackEvent;
                if (v3SportsHomeActivity10 != null) {
                    v3SportsHomeActivity10.E0();
                    return;
                }
                return;
            case 11:
                V3SportsHomeActivity v3SportsHomeActivity11 = this.mBackEvent;
                if (v3SportsHomeActivity11 != null) {
                    v3SportsHomeActivity11.E0();
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
        String str;
        String str2;
        int i4;
        int i5;
        long j5;
        long j6;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mRecordMap;
        long j7 = j4 & 9;
        String str3 = null;
        if (j7 != 0) {
            l lVar = l.f18624a;
            int k4 = lVar.k(map, "sportType");
            double f4 = lVar.f(map, "runSportRange");
            String u3 = lVar.u(map, "succeed", "0");
            String u4 = lVar.u(map, "sumTime", "0");
            boolean z3 = k4 == 5;
            str2 = e.f18604a.a(f4);
            if (j7 != 0) {
                if (z3) {
                    j5 = j4 | 32;
                    j6 = 128;
                } else {
                    j5 = j4 | 16;
                    j6 = 64;
                }
                j4 = j5 | j6;
            }
            int i6 = z3 ? 0 : 8;
            int i7 = z3 ? 8 : 0;
            str = u4;
            str3 = u3;
            i4 = i7;
            i5 = i6;
        } else {
            str = null;
            str2 = null;
            i4 = 0;
            i5 = 0;
        }
        if ((8 & j4) != 0) {
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
        if ((j4 & 9) != 0) {
            this.ivTimeArrow.setVisibility(i5);
            this.mboundView5.setVisibility(i4);
            TextViewBindingAdapter.setText(this.tvCount, str3);
            this.tvDistance.setVisibility(i4);
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
        this.mCallback47 = new a(this, 8);
        this.mCallback43 = new a(this, 4);
        this.mCallback42 = new a(this, 3);
        this.mCallback50 = new a(this, 11);
        this.mCallback48 = new a(this, 9);
        this.mCallback44 = new a(this, 5);
        this.mCallback49 = new a(this, 10);
        this.mCallback45 = new a(this, 6);
        this.mCallback40 = new a(this, 1);
        this.mCallback46 = new a(this, 7);
        this.mCallback41 = new a(this, 2);
        invalidateAll();
    }
}
