package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.amap.api.maps.TextureMapView;
import com.bxkj.student.run.app.utils.RecordPathView;
import com.bxkj.student.run.app.utils.SportTrailView;
import com.bxkj.student.run.app.utils.i;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FmV2SportsTraceBindingImpl extends FmV2SportsTraceBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232258, 5);
        sparseIntArray.put(2131232539, 6);
        sparseIntArray.put(2131232677, 7);
        sparseIntArray.put(2131232167, 8);
        sparseIntArray.put(2131233166, 9);
        sparseIntArray.put(2131232838, 10);
        sparseIntArray.put(2131233144, 11);
        sparseIntArray.put(2131233040, 12);
        sparseIntArray.put(2131231015, 13);
    }

    public FmV2SportsTraceBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        CharSequence charSequence;
        CharSequence charSequence2;
        String str;
        Object obj;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, Object> map = this.mDataMap;
        long j5 = j4 & 3;
        Object obj2 = null;
        if (j5 != 0) {
            boolean z3 = map == null;
            long j6 = JsonParse.getLong(map, "sportTime", 0L);
            if (j5 != 0) {
                j4 |= z3 ? 8L : 4L;
            }
            if (map != null) {
                obj2 = map.get("avgspeed");
                charSequence2 = map.get("speed");
                obj = map.get("sportRange");
            } else {
                obj = null;
                charSequence2 = null;
            }
            r10 = z3 ? 8 : 0;
            str = i.g(j6);
            Object obj3 = obj2;
            obj2 = obj;
            charSequence = obj3;
        } else {
            charSequence = null;
            charSequence2 = null;
            str = null;
        }
        if ((j4 & 3) != 0) {
            this.llRoot.setVisibility(r10);
            TextViewBindingAdapter.setText(this.tvDistance, (CharSequence) obj2);
            TextViewBindingAdapter.setText(this.tvPeisu, charSequence2);
            TextViewBindingAdapter.setText(this.tvSpeed, charSequence);
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
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // com.bxkj.student.databinding.FmV2SportsTraceBinding
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

    private FmV2SportsTraceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[13], (LinearLayout) bindings[8], (LinearLayout) bindings[0], (TextureMapView) bindings[5], (RecordPathView) bindings[6], (SportTrailView) bindings[7], (TextView) bindings[10], (TextView) bindings[4], (TextView) bindings[12], (TextView) bindings[3], (TextView) bindings[11], (TextView) bindings[1], (TextView) bindings[9], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.llRoot.setTag(null);
        this.tvDistance.setTag(null);
        this.tvPeisu.setTag(null);
        this.tvSpeed.setTag(null);
        this.tvTime.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}