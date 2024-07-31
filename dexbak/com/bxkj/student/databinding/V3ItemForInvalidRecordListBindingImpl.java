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
import com.bxkj.base.p085v2.common.utils.DataFormatUtils;
import com.bxkj.base.p085v2.common.utils.DecimalFormatUtils;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.common.utils.UploadTypeUtils;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab.V3RecordInValidFragment;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.umeng.analytics.AnalyticsConfig;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3ItemForInvalidRecordListBindingImpl extends V3ItemForInvalidRecordListBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
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

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            V3RecordInValidFragment v3RecordInValidFragment = this.mMActivity;
            Map<String, ? extends Object> map = this.mMap;
            if (v3RecordInValidFragment != null) {
                v3RecordInValidFragment.m38374m(map);
            }
        } else if (sourceId != 2) {
        } else {
            V3RecordInValidFragment v3RecordInValidFragment2 = this.mMActivity;
            Map<String, ? extends Object> map2 = this.mMap;
            if (v3RecordInValidFragment2 != null) {
                v3RecordInValidFragment2.m38376k(map2);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CharSequence charSequence;
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        long j2;
        long j3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        Map<String, ? extends Object> map = this.mMap;
        long j4 = j & 5;
        Drawable drawable = null;
        Object obj4 = null;
        if (j4 != 0) {
            if (map != null) {
                obj4 = map.get("stepNumbers");
                obj = map.get(AnalyticsConfig.RTD_START_TIME);
                obj2 = map.get("sportTypeName");
                obj3 = map.get("status");
                charSequence = map.get("remark");
            } else {
                obj = null;
                obj2 = null;
                obj3 = null;
                charSequence = null;
            }
            long j5 = JsonParse.getLong(map, "sportTime");
            JsonGet jsonGet = JsonGet.f15134a;
            int m43769k = jsonGet.m43769k(map, "sportType");
            double m43774f = jsonGet.m43774f(map, "sportRange");
            int i2 = JsonParse.getInt(map, "uploadType");
            String valueOf = String.valueOf(obj4);
            String m43808a = DataFormatUtils.m43808a(obj);
            String str7 = obj2 + " ";
            str6 = FormatUtils.m39630g(j5);
            boolean z = m43769k == 5;
            String m43806a = DecimalFormatUtils.f15114a.m43806a(m43774f);
            String m39052a = UploadTypeUtils.m39052a(i2);
            if (j4 != 0) {
                j |= z ? 16L : 8L;
            }
            boolean equals = obj3 != null ? obj3.equals("1") : false;
            if ((j & 5) != 0) {
                if (equals) {
                    j2 = j | 64;
                    j3 = 256;
                } else {
                    j2 = j | 32;
                    j3 = 128;
                }
                j = j2 | j3;
            }
            int m39617t = FormatUtils.m39617t(valueOf);
            String str8 = str7 + m43808a;
            i = z ? 8 : 0;
            str2 = m43806a + "KM";
            String str9 = "上传方式:" + m39052a;
            Drawable drawable2 = AppCompatResources.getDrawable(this.status.getContext(), equals ? C4215R.C4218drawable.round_blue : C4215R.C4218drawable.red_round);
            str3 = equals ? "√" : "×";
            str5 = String.valueOf(m39617t);
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
            i = 0;
        }
        if ((4 & j) != 0) {
            this.btAppeal.setOnClickListener(this.mCallback59);
            this.mboundView2.setOnClickListener(this.mCallback58);
        }
        if ((j & 5) != 0) {
            this.mboundView4.setVisibility(i);
            this.mboundView7.setVisibility(i);
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
        this.mCallback59 = new View$OnClickListenerC4297a(this, 2);
        this.mCallback58 = new View$OnClickListenerC4297a(this, 1);
        invalidateAll();
    }
}
