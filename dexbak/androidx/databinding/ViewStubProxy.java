package androidx.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ViewStubProxy {
    private ViewDataBinding mContainingBinding;
    private ViewStub.OnInflateListener mOnInflateListener;
    private ViewStub.OnInflateListener mProxyListener;
    private View mRoot;
    private ViewDataBinding mViewDataBinding;
    private ViewStub mViewStub;

    public ViewStubProxy(@NonNull ViewStub viewStub) {
        ViewStub.OnInflateListener onInflateListener = new ViewStub.OnInflateListener() { // from class: androidx.databinding.ViewStubProxy.1
            @Override // android.view.ViewStub.OnInflateListener
            public void onInflate(ViewStub viewStub2, View view) {
                ViewStubProxy.this.mRoot = view;
                ViewStubProxy viewStubProxy = ViewStubProxy.this;
                viewStubProxy.mViewDataBinding = DataBindingUtil.bind(viewStubProxy.mContainingBinding.mBindingComponent, view, viewStub2.getLayoutResource());
                ViewStubProxy.this.mViewStub = null;
                if (ViewStubProxy.this.mOnInflateListener != null) {
                    ViewStubProxy.this.mOnInflateListener.onInflate(viewStub2, view);
                    ViewStubProxy.this.mOnInflateListener = null;
                }
                ViewStubProxy.this.mContainingBinding.invalidateAll();
                ViewStubProxy.this.mContainingBinding.forceExecuteBindings();
            }
        };
        this.mProxyListener = onInflateListener;
        this.mViewStub = viewStub;
        viewStub.setOnInflateListener(onInflateListener);
    }

    @Nullable
    public ViewDataBinding getBinding() {
        return this.mViewDataBinding;
    }

    public View getRoot() {
        return this.mRoot;
    }

    @Nullable
    public ViewStub getViewStub() {
        return this.mViewStub;
    }

    public boolean isInflated() {
        return this.mRoot != null;
    }

    public void setContainingBinding(@NonNull ViewDataBinding viewDataBinding) {
        this.mContainingBinding = viewDataBinding;
    }

    public void setOnInflateListener(@Nullable ViewStub.OnInflateListener onInflateListener) {
        if (this.mViewStub != null) {
            this.mOnInflateListener = onInflateListener;
        }
    }
}
