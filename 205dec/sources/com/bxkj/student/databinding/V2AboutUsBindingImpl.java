package com.bxkj.student.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import com.bxkj.base.util.z;
import com.bxkj.student.generated.callback.a;
import com.bxkj.student.v2.ui.my.AboutUsActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class V2AboutUsBindingImpl extends V2AboutUsBinding implements a.InterfaceC0220a {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final SparseIntArray sViewsWithIds;
    @Nullable
    private final View.OnClickListener mCallback10;
    @Nullable
    private final View.OnClickListener mCallback11;
    @Nullable
    private final View.OnClickListener mCallback12;
    @Nullable
    private final View.OnClickListener mCallback13;
    @Nullable
    private final View.OnClickListener mCallback9;
    private long mDirtyFlags;
    @NonNull
    private final ConstraintLayout mboundView0;
    @NonNull
    private final LinearLayoutCompat mboundView2;
    @NonNull
    private final LinearLayoutCompat mboundView3;
    @NonNull
    private final LinearLayoutCompat mboundView4;
    @NonNull
    private final LinearLayoutCompat mboundView5;
    @NonNull
    private final LinearLayoutCompat mboundView6;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(12);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"v2_pub_title"}, new int[]{7}, new int[]{2131428100});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(2131231312, 8);
        sparseIntArray.put(2131231451, 9);
        sparseIntArray.put(2131231433, 10);
        sparseIntArray.put(2131233040, 11);
    }

    public V2AboutUsBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private boolean onChangeIncludeTitle(V2PubTitleBinding IncludeTitle, int fieldId) {
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
            AboutUsActivity aboutUsActivity = this.mActivity;
            if (aboutUsActivity != null) {
                aboutUsActivity.S();
            }
        } else if (sourceId == 2) {
            AboutUsActivity aboutUsActivity2 = this.mActivity;
            if (aboutUsActivity2 != null) {
                aboutUsActivity2.Q();
            }
        } else if (sourceId == 3) {
            AboutUsActivity aboutUsActivity3 = this.mActivity;
            if (aboutUsActivity3 != null) {
                aboutUsActivity3.O();
            }
        } else if (sourceId == 4) {
            AboutUsActivity aboutUsActivity4 = this.mActivity;
            if (aboutUsActivity4 != null) {
                aboutUsActivity4.P();
            }
        } else if (sourceId != 5) {
        } else {
            AboutUsActivity aboutUsActivity5 = this.mActivity;
            if (aboutUsActivity5 != null) {
                aboutUsActivity5.N();
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
        String str = null;
        com.bxkj.base.v2.common.view.a aVar = this.mBackEvent;
        String str2 = this.mTitle;
        AboutUsActivity aboutUsActivity = this.mActivity;
        long j5 = 18 & j4;
        long j6 = 20 & j4;
        long j7 = 24 & j4;
        if (j7 != 0) {
            str = "\u7248\u672c\u53f7\uff1a" + z.h(aboutUsActivity);
        }
        if (j5 != 0) {
            this.includeTitle.setActivity(aVar);
        }
        if (j6 != 0) {
            this.includeTitle.setTitle(str2);
        }
        if ((j4 & 16) != 0) {
            this.mboundView2.setOnClickListener(this.mCallback9);
            this.mboundView3.setOnClickListener(this.mCallback10);
            this.mboundView4.setOnClickListener(this.mCallback11);
            this.mboundView5.setOnClickListener(this.mCallback12);
            this.mboundView6.setOnClickListener(this.mCallback13);
        }
        if (j7 != 0) {
            TextViewBindingAdapter.setText(this.tvVersion, str);
        }
        ViewDataBinding.executeBindingsOn(this.includeTitle);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.includeTitle.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
        }
        this.includeTitle.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeIncludeTitle((V2PubTitleBinding) object, fieldId);
    }

    @Override // com.bxkj.student.databinding.V2AboutUsBinding
    public void setActivity(@Nullable AboutUsActivity Activity) {
        this.mActivity = Activity;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // com.bxkj.student.databinding.V2AboutUsBinding
    public void setBackEvent(@Nullable com.bxkj.base.v2.common.view.a BackEvent) {
        this.mBackEvent = BackEvent;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(3);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.includeTitle.setLifecycleOwner(lifecycleOwner);
    }

    @Override // com.bxkj.student.databinding.V2AboutUsBinding
    public void setTitle(@Nullable String Title) {
        this.mTitle = Title;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(28);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (3 == variableId) {
            setBackEvent((com.bxkj.base.v2.common.view.a) variable);
            return true;
        } else if (28 == variableId) {
            setTitle((String) variable);
            return true;
        } else if (1 == variableId) {
            setActivity((AboutUsActivity) variable);
            return true;
        } else {
            return false;
        }
    }

    private V2AboutUsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (FrameLayout) bindings[8], (V2PubTitleBinding) bindings[7], (ImageView) bindings[10], (ImageView) bindings[9], (TextView) bindings[11], (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        setContainedBinding(this.includeTitle);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[2];
        this.mboundView2 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) bindings[3];
        this.mboundView3 = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) bindings[4];
        this.mboundView4 = linearLayoutCompat3;
        linearLayoutCompat3.setTag(null);
        LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) bindings[5];
        this.mboundView5 = linearLayoutCompat4;
        linearLayoutCompat4.setTag(null);
        LinearLayoutCompat linearLayoutCompat5 = (LinearLayoutCompat) bindings[6];
        this.mboundView6 = linearLayoutCompat5;
        linearLayoutCompat5.setTag(null);
        this.tvVersion.setTag(null);
        setRootTag(root);
        this.mCallback12 = new a(this, 4);
        this.mCallback13 = new a(this, 5);
        this.mCallback10 = new a(this, 2);
        this.mCallback11 = new a(this, 3);
        this.mCallback9 = new a(this, 1);
        invalidateAll();
    }
}
