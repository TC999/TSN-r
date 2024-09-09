package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import cn.bingoogolapple.qrcode.zbar.ZBarView;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.run.extraclass.QrScanSignActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AcQrcodeScanBindingImpl extends AcQrcodeScanBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(3);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"new_pub_title"}, new int[]{1}, new int[]{2131427995});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131233335, 2);
    }

    public AcQrcodeScanBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private boolean onChangeToolbar(NewPubTitleBinding Toolbar, int fieldId) {
        if (fieldId == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j4;
        synchronized (this) {
            j4 = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        QrScanSignActivity qrScanSignActivity = this.mQrScanActivity;
        if ((6 & j4) != 0) {
            this.toolbar.setActivity(qrScanSignActivity);
        }
        if ((j4 & 4) != 0) {
            this.toolbar.setTitle("\u8bf7\u626b\u63cf\u573a\u9986\u7ba1\u7406\u5458\u4e8c\u7ef4\u7801\u7b7e\u5230");
        }
        ViewDataBinding.executeBindingsOn(this.toolbar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.toolbar.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.toolbar.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeToolbar((NewPubTitleBinding) object, fieldId);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.toolbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.AcQrcodeScanBinding
    public void setQrScanActivity(@Nullable QrScanSignActivity QrScanActivity) {
        this.mQrScanActivity = QrScanActivity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (21 == variableId) {
            setQrScanActivity((QrScanSignActivity) variable);
            return true;
        }
        return false;
    }

    private AcQrcodeScanBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (NewPubTitleBinding) bindings[1], (ZBarView) bindings[2]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        setContainedBinding(this.toolbar);
        setRootTag(root);
        invalidateAll();
    }
}
