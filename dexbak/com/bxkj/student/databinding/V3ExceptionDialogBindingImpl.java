package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;
import com.bxkj.student.generated.callback.View$OnClickListenerC4297a;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3ExceptionDialog;
import com.google.android.material.imageview.ShapeableImageView;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class V3ExceptionDialogBindingImpl extends V3ExceptionDialogBinding implements View$OnClickListenerC4297a.InterfaceC4298a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback20;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;
    @NonNull
    private final ShapeableImageView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C4215R.C4219id.rl_threetwoone, 2);
        sparseIntArray.put(C4215R.C4219id.tv_title_hint, 3);
        sparseIntArray.put(2131233036, 4);
    }

    public V3ExceptionDialogBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.View$OnClickListenerC4297a.InterfaceC4298a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        V3ExceptionDialog v3ExceptionDialog = this.mDialog;
        if (v3ExceptionDialog != null) {
            v3ExceptionDialog.dismiss();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        if ((j & 2) != 0) {
            this.mboundView1.setOnClickListener(this.mCallback20);
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

    @Override // com.bxkj.student.databinding.V3ExceptionDialogBinding
    public void setDialog(@Nullable V3ExceptionDialog Dialog) {
        this.mDialog = Dialog;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (8 == variableId) {
            setDialog((V3ExceptionDialog) variable);
            return true;
        }
        return false;
    }

    private V3ExceptionDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[2], (TextView) bindings[4], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ShapeableImageView shapeableImageView = (ShapeableImageView) bindings[1];
        this.mboundView1 = shapeableImageView;
        shapeableImageView.setTag(null);
        setRootTag(root);
        this.mCallback20 = new View$OnClickListenerC4297a(this, 1);
        invalidateAll();
    }
}
