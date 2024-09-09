package com.bxkj.student.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.v2.common.utils.d;
import com.bxkj.base.v2.common.utils.e;
import com.bxkj.base.v2.common.utils.l;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.v2.common.utils.q;
import com.bxkj.student.v2.ui.sports.v3.record.tab.V3RecordInValidFragment;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V3ItemForInvalidRecordListBindingImpl extends V3ItemForInvalidRecordListBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback58;
    @Nullable
    private final View.OnClickListener mCallback59;
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;
    @NonNull
    private final LinearLayout mboundView2;
    @NonNull
    private final LinearLayout mboundView4;
    @NonNull
    private final LinearLayout mboundView7;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131231051, 12);
        sparseIntArray.put(2131233045, 13);
        sparseIntArray.put(2131231389, 14);
    }

    public V3ItemForInvalidRecordListBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3RecordInValidFragment v3RecordInValidFragment = this.mMActivity;
            Map<String, ? extends Object> map = this.mMap;
            if (v3RecordInValidFragment != null) {
                v3RecordInValidFragment.m(map);
            }
        } else if (sourceId != 2) {
        } else {
            V3RecordInValidFragment v3RecordInValidFragment2 = this.mMActivity;
            Map<String, ? extends Object> map2 = this.mMap;
            if (v3RecordInValidFragment2 != null) {
                v3RecordInValidFragment2.k(map2);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CharSequence charSequence;
        int i4;
        Object obj;
        Object obj2;
        Object obj3;
        long j5;
        long j6;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j7 = j4 & 5;
        Drawable drawable = null;
        Object obj4 = null;
        if (j7 != 0) {
            if (map != null) {
                obj4 = map.get("stepNumbers");
                obj = map.get("startTime");
                obj2 = map.get("sportTypeName");
                obj3 = map.get("status");
                charSequence = map.get("remark");
            } else {
                obj = null;
                obj2 = null;
                obj3 = null;
                charSequence = null;
            }
            long j8 = JsonParse.getLong(map, "sportTime");
            l lVar = l.f18624a;
            int k4 = lVar.k(map, "sportType");
            double f4 = lVar.f(map, "sportRange");
            int i5 = JsonParse.getInt(map, "uploadType");
            String valueOf = String.valueOf(obj4);
            String a4 = d.a(obj);
            String str7 = obj2 + " ";
            str6 = i.g(j8);
            boolean z3 = k4 == 5;
            String a5 = e.f18604a.a(f4);
            String a6 = q.a(i5);
            if (j7 != 0) {
                j4 |= z3 ? 16L : 8L;
            }
            boolean equals = obj3 != null ? obj3.equals("1") : false;
            if ((j4 & 5) != 0) {
                if (equals) {
                    j5 = j4 | 64;
                    j6 = 256;
                } else {
                    j5 = j4 | 32;
                    j6 = 128;
                }
                j4 = j5 | j6;
            }
            int t3 = i.t(valueOf);
            String str8 = str7 + a4;
            i4 = z3 ? 8 : 0;
            str2 = a5 + "KM";
            String str9 = "\u4e0a\u4f20\u65b9\u5f0f:" + a6;
            Drawable drawable2 = AppCompatResources.getDrawable(this.status.getContext(), equals ? 2131165921 : 2131165919);
            str3 = equals ? "\u221a" : "\u00d7";
            str5 = String.valueOf(t3);
            str4 = str9;
            str = str8;
            drawable = drawable2;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            charSequence = null;
            i4 = 0;
        }
        if ((4 & j4) != 0) {
            this.btAppeal.setOnClickListener(this.mCallback59);
            this.mboundView2.setOnClickListener(this.mCallback58);
        }
        if ((j4 & 5) != 0) {
            this.mboundView4.setVisibility(i4);
            this.mboundView7.setVisibility(i4);
            ViewBindingAdapter.setBackground(this.status, drawable);
            TextViewBindingAdapter.setText(this.status, str3);
            TextViewBindingAdapter.setText(this.tvDistance, str2);
            TextViewBindingAdapter.setText(this.tvStartTime, str);
            TextViewBindingAdapter.setText(this.tvStatus, charSequence);
            TextViewBindingAdapter.setText(this.tvStepCount, str5);
            TextViewBindingAdapter.setText(this.tvTimeCount, str6);
            this.tvUploadType.setText(str4);
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

    @Override // com.bxkj.student.databinding.V3ItemForInvalidRecordListBinding
    public void setMActivity(@Nullable V3RecordInValidFragment MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V3ItemForInvalidRecordListBinding
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
            setMActivity((V3RecordInValidFragment) variable);
        }
        return true;
    }

    private V3ItemForInvalidRecordListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[10], (CardView) bindings[12], (ImageView) bindings[14], (TextView) bindings[1], (TextView) bindings[5], (TextView) bindings[13], (TextView) bindings[3], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[6], (TextView) bindings[11]);
        this.mDirtyFlags = -1L;
        this.btAppeal.setTag(null);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[2];
        this.mboundView2 = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[4];
        this.mboundView4 = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) bindings[7];
        this.mboundView7 = linearLayout4;
        linearLayout4.setTag(null);
        this.status.setTag(null);
        this.tvDistance.setTag(null);
        this.tvStartTime.setTag(null);
        this.tvStatus.setTag(null);
        this.tvStepCount.setTag(null);
        this.tvTimeCount.setTag(null);
        this.tvUploadType.setTag(null);
        setRootTag(root);
        this.mCallback59 = new a(this, 2);
        this.mCallback58 = new a(this, 1);
        invalidateAll();
    }
}
