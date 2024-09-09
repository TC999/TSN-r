package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.face.FaceCollectConfirmActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V3FaceCollectConfirmBindingImpl extends V3FaceCollectConfirmBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback67;
    @Nullable
    private final View.OnClickListener mCallback68;
    private long mDirtyFlags;
    @NonNull
    private final NestedScrollView mboundView0;
    @NonNull
    private final ConstraintLayout mboundView1;
    @NonNull
    private final Button mboundView2;
    @NonNull
    private final Button mboundView3;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(8);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"v3_pub_title"}, new int[]{4}, new int[]{2131428115});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131231416, 5);
        sparseIntArray.put(2131233005, 6);
        sparseIntArray.put(2131233004, 7);
    }

    public V3FaceCollectConfirmBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }

    private boolean onChangeLayoutTitle(V3PubTitleBinding LayoutTitle, int fieldId) {
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
            FaceCollectConfirmActivity faceCollectConfirmActivity = this.mActivity;
            if (faceCollectConfirmActivity != null) {
                faceCollectConfirmActivity.finish();
            }
        } else if (sourceId != 2) {
        } else {
            FaceCollectConfirmActivity faceCollectConfirmActivity2 = this.mActivity;
            if (faceCollectConfirmActivity2 != null) {
                faceCollectConfirmActivity2.N();
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
        FaceCollectConfirmActivity faceCollectConfirmActivity = this.mActivity;
        if ((6 & j4) != 0) {
            this.layoutTitle.setActivity(faceCollectConfirmActivity);
        }
        if ((j4 & 4) != 0) {
            this.layoutTitle.setTitle("\u4eba\u8138\u4fe1\u606f\u786e\u8ba4");
            this.mboundView2.setOnClickListener(this.mCallback67);
            this.mboundView3.setOnClickListener(this.mCallback68);
        }
        ViewDataBinding.executeBindingsOn(this.layoutTitle);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.layoutTitle.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        this.layoutTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeLayoutTitle((V3PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.V3FaceCollectConfirmBinding
    public void setActivity(@Nullable FaceCollectConfirmActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.layoutTitle.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (1 == variableId) {
            setActivity((FaceCollectConfirmActivity) variable);
            return true;
        }
        return false;
    }

    private V3FaceCollectConfirmBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (ImageView) bindings[5], (V3PubTitleBinding) bindings[4], (TextView) bindings[7], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.layoutTitle);
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        Button button = (Button) bindings[2];
        this.mboundView2 = button;
        button.setTag(null);
        Button button2 = (Button) bindings[3];
        this.mboundView3 = button2;
        button2.setTag(null);
        setRootTag(root);
        this.mCallback67 = new a(this, 1);
        this.mCallback68 = new a(this, 2);
        invalidateAll();
    }
}
