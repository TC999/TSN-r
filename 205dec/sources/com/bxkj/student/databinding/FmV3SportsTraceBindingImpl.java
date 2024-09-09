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
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.TextureMapView;
import com.bxkj.base.v2.common.utils.e;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.i;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FmV3SportsTraceBindingImpl extends FmV3SportsTraceBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232258, 8);
        sparseIntArray.put(2131232539, 9);
        sparseIntArray.put(2131232167, 10);
        sparseIntArray.put(2131231060, 11);
        sparseIntArray.put(2131231426, 12);
        sparseIntArray.put(2131232942, 13);
        sparseIntArray.put(2131233302, 14);
    }

    public FmV3SportsTraceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        String str;
        CharSequence charSequence;
        String str2;
        String str3;
        CharSequence charSequence2;
        int i4;
        CharSequence charSequence3;
        CharSequence charSequence4;
        Object obj;
        CharSequence charSequence5;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mDataMap;
        long j5 = j4 & 3;
        if (j5 != 0) {
            long j6 = JsonParse.getLong(map, "startTime");
            boolean z3 = map == null;
            long j7 = JsonParse.getLong(map, "sportTime", 0L);
            double f4 = l.f18624a.f(map, "sportRange");
            if (j5 != 0) {
                j4 |= z3 ? 8L : 4L;
            }
            if (map != null) {
                Object obj2 = map.get("userName");
                charSequence2 = map.get("speed");
                charSequence = map.get("stepCount");
                obj = map.get("nickName");
                charSequence5 = obj2;
            } else {
                obj = null;
                charSequence = null;
                charSequence2 = null;
                charSequence5 = null;
            }
            str2 = i.h(j6, "");
            int i5 = z3 ? 8 : 0;
            str3 = i.g(j7);
            String a4 = e.f18604a.a(f4);
            i4 = i5;
            CharSequence charSequence6 = charSequence5;
            charSequence4 = obj;
            str = a4;
            charSequence3 = charSequence6;
        } else {
            str = null;
            charSequence = null;
            str2 = null;
            str3 = null;
            charSequence2 = null;
            i4 = 0;
            charSequence3 = null;
            charSequence4 = null;
        }
        if ((j4 & 3) != 0) {
            this.mboundView0.setVisibility(i4);
            TextViewBindingAdapter.setText(this.tvAccount, charSequence3);
            TextViewBindingAdapter.setText(this.tvDistance, str);
            TextViewBindingAdapter.setText(this.tvName, charSequence4);
            TextViewBindingAdapter.setText(this.tvPace, charSequence2);
            TextViewBindingAdapter.setText(this.tvStartTime, str2);
            TextViewBindingAdapter.setText(this.tvStep, charSequence);
            TextViewBindingAdapter.setText(this.tvTime, str3);
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

    @Override // com.bxkj.student.databinding.FmV3SportsTraceBinding
    public void setDataMap(@Nullable Map<String, Object> DataMap) {
        this.mDataMap = DataMap;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (7 == variableId) {
            setDataMap((Map) variable);
            return true;
        }
        return false;
    }

    private FmV3SportsTraceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (MaterialCardView) bindings[11], (ShapeableImageView) bindings[12], (LinearLayout) bindings[10], (TextureMapView) bindings[8], (RecordPathView) bindings[9], (TextView) bindings[2], (TextView) bindings[4], (TextView) bindings[13], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[3], (TextView) bindings[6], (TextView) bindings[7], (View) bindings[14]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvAccount.setTag(null);
        this.tvDistance.setTag(null);
        this.tvName.setTag(null);
        this.tvPace.setTag(null);
        this.tvStartTime.setTag(null);
        this.tvStep.setTag(null);
        this.tvTime.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
