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
import com.bxkj.base.util.z;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.sports.set.PermissionSetActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcV2PermissionSetBindingImpl extends AcV2PermissionSetBinding implements a.InterfaceC0220a {
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
        includedLayouts.setIncludes(0, new String[]{"v3_pub_title"}, new int[]{6}, new int[]{2131428115});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131231077, 7);
        sparseIntArray.put(2131232991, 8);
        sparseIntArray.put(2131232685, 9);
        sparseIntArray.put(2131231073, 10);
        sparseIntArray.put(2131231059, 11);
        sparseIntArray.put(2131231063, 12);
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

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            PermissionSetActivity permissionSetActivity = this.mMActivity;
            if (permissionSetActivity != null) {
                permissionSetActivity.O();
            }
        } else if (sourceId == 2) {
            PermissionSetActivity permissionSetActivity2 = this.mMActivity;
            if (permissionSetActivity2 != null) {
                permissionSetActivity2.P();
            }
        } else if (sourceId == 3) {
            PermissionSetActivity permissionSetActivity3 = this.mMActivity;
            if (permissionSetActivity3 != null) {
                permissionSetActivity3.Q();
            }
        } else if (sourceId != 4) {
        } else {
            PermissionSetActivity permissionSetActivity4 = this.mMActivity;
            if (permissionSetActivity4 != null) {
                permissionSetActivity4.Q();
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        PermissionSetActivity permissionSetActivity = this.mMActivity;
        long j5 = 6 & j4;
        if ((j4 & 4) != 0) {
            this.btFastSet.setOnClickListener(this.mCallback52);
            this.mboundView3.setOnClickListener(this.mCallback53);
            this.mboundView4.setOnClickListener(this.mCallback54);
            this.mboundView5.setOnClickListener(this.mCallback55);
            this.titleLayout.setTitle("\u6743\u9650\u8bbe\u7f6e");
            TextView textView = this.tvHint2;
            TextViewBindingAdapter.setText(textView, "\u60a8\u7684\u624b\u673a" + z.d() + "-" + z.e() + "\u8bbe\u7f6e\u6b65\u9aa4\u5982\u4e0b\uff1a");
        }
        if (j5 != 0) {
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
        this.mCallback55 = new a(this, 4);
        this.mCallback52 = new a(this, 1);
        this.mCallback54 = new a(this, 3);
        this.mCallback53 = new a(this, 2);
        invalidateAll();
    }
}
