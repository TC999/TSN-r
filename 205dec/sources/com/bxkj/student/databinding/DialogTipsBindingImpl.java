package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.dialog.NoticeDialog;
import com.google.android.material.imageview.ShapeableImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class DialogTipsBindingImpl extends DialogTipsBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback27;
    @Nullable
    private final View.OnClickListener mCallback28;
    @Nullable
    private final View.OnClickListener mCallback29;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;
    @NonNull
    private final ShapeableImageView mboundView1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131232205, 4);
        sparseIntArray.put(2131233204, 5);
        sparseIntArray.put(2131232911, 6);
    }

    public DialogTipsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    @Override // com.bxkj.student.generated.callback.a.InterfaceC0220a
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            NoticeDialog noticeDialog = this.mDialog;
            if (noticeDialog != null) {
                noticeDialog.dismiss();
            }
        } else if (sourceId == 2) {
            NoticeDialog noticeDialog2 = this.mDialog;
            if (noticeDialog2 != null) {
                noticeDialog2.j();
            }
        } else if (sourceId != 3) {
        } else {
            NoticeDialog noticeDialog3 = this.mDialog;
            if (noticeDialog3 != null) {
                noticeDialog3.i();
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
        if ((j4 & 2) != 0) {
            this.bt.setOnClickListener(this.mCallback29);
            this.iv.setOnClickListener(this.mCallback28);
            this.mboundView1.setOnClickListener(this.mCallback27);
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

    @Override // com.bxkj.student.databinding.DialogTipsBinding
    public void setDialog(@Nullable NoticeDialog Dialog) {
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
            setDialog((NoticeDialog) variable);
            return true;
        }
        return false;
    }

    private DialogTipsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatButton) bindings[3], (ImageView) bindings[2], (LinearLayout) bindings[4], (TextView) bindings[6], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        this.bt.setTag(null);
        this.iv.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ShapeableImageView shapeableImageView = (ShapeableImageView) bindings[1];
        this.mboundView1 = shapeableImageView;
        shapeableImageView.setTag(null);
        setRootTag(root);
        this.mCallback27 = new a(this, 1);
        this.mCallback28 = new a(this, 2);
        this.mCallback29 = new a(this, 3);
        invalidateAll();
    }
}
