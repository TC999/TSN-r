package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.p098ui.sports.set.PermissionSetActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AcV2PermissionSetBindingImpl extends AcV2PermissionSetBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback52;
    @Nullable
    private final View.OnClickListener mCallback53;
    @Nullable
    private final View.OnClickListener mCallback54;
    @Nullable
    private final View.OnClickListener mCallback55;
    private long mDirtyFlags;
    @NonNull
    private final RelativeLayout mboundView0;
    @NonNull
    private final Button mboundView3;
    @NonNull
    private final Button mboundView4;
    @NonNull
    private final Button mboundView5;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v3_pub_title"}, new int[]{6}, new int[]{C4215R.C4221layout.v3_pub_title});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.card_why, 7);
        sparseIntArray.put(C4215R.C4219id.tv_hint, 8);
        sparseIntArray.put(C4215R.C4219id.f16008sw, 9);
        sparseIntArray.put(C4215R.C4219id.card_save_model, 10);
        sparseIntArray.put(C4215R.C4219id.card_battery_optimizations, 11);
        sparseIntArray.put(C4215R.C4219id.card_gps_always, 12);
    }

    public AcV2PermissionSetBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private boolean onChangeTitleLayout(V3PubTitleBinding TitleLayout, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            PermissionSetActivity permissionSetActivity = this.mMActivity;
            if (permissionSetActivity != null) {
                permissionSetActivity.m38614O();
            }
        } else if (sourceId == 2) {
            PermissionSetActivity permissionSetActivity2 = this.mMActivity;
            if (permissionSetActivity2 != null) {
                permissionSetActivity2.m38613P();
            }
        } else if (sourceId == 3) {
            PermissionSetActivity permissionSetActivity3 = this.mMActivity;
            if (permissionSetActivity3 != null) {
                permissionSetActivity3.m38612Q();
            }
        } else if (sourceId != 4) {
        } else {
            PermissionSetActivity permissionSetActivity4 = this.mMActivity;
            if (permissionSetActivity4 != null) {
                permissionSetActivity4.m38612Q();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PermissionSetActivity permissionSetActivity = this.mMActivity;
        long j2 = 6 & j;
        if ((j & 4) != 0) {
            this.btFastSet.setOnClickListener(this.mCallback52);
            this.mboundView3.setOnClickListener(this.mCallback53);
            this.mboundView4.setOnClickListener(this.mCallback54);
            this.mboundView5.setOnClickListener(this.mCallback55);
            this.titleLayout.setTitle("权限设置");
            TextView textView = this.tvHint2;
            TextViewBindingAdapter.setText(textView, "您的手机" + SystemUtils.m44002d() + "-" + SystemUtils.m44001e() + "设置步骤如下：");
        }
        if (j2 != 0) {
            this.titleLayout.setActivity(permissionSetActivity);
        }
        ViewDataBinding.executeBindingsOn(this.titleLayout);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.titleLayout.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.titleLayout.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeTitleLayout((V3PubTitleBinding) object, fieldId);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.titleLayout.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.AcV2PermissionSetBinding
    public void setMActivity(@Nullable PermissionSetActivity MActivity) {
        this.mMActivity = MActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (15 == variableId) {
            setMActivity((PermissionSetActivity) variable);
            return true;
        }
        return false;
    }

    private AcV2PermissionSetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (Button) bindings[1], (CardView) bindings[11], (CardView) bindings[12], (CardView) bindings[10], (CardView) bindings[7], (SmartWebView) bindings[9], (V3PubTitleBinding) bindings[6], (TextView) bindings[8], (TextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.btFastSet.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) bindings[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        Button button = (Button) bindings[3];
        this.mboundView3 = button;
        button.setTag(null);
        Button button2 = (Button) bindings[4];
        this.mboundView4 = button2;
        button2.setTag(null);
        Button button3 = (Button) bindings[5];
        this.mboundView5 = button3;
        button3.setTag(null);
        setContainedBinding(this.titleLayout);
        this.tvHint2.setTag(null);
        setRootTag(root);
        this.mCallback55 = new View$OnClickListenerC4297a(this, 4);
        this.mCallback52 = new View$OnClickListenerC4297a(this, 1);
        this.mCallback54 = new View$OnClickListenerC4297a(this, 3);
        this.mCallback53 = new View$OnClickListenerC4297a(this, 2);
        invalidateAll();
    }
}
