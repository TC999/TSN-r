package com.kwad.components.core.proxy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import com.kwad.sdk.k;
import com.kwad.sdk.n.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class d extends AlertDialog {
    public Activity mActivity;
    protected final Context mContext;
    protected ViewGroup zg;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = l.wrapContextIfNeed(activity);
    }

    protected float cj() {
        return -1.0f;
    }

    protected ViewGroup ck() {
        return null;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    @CallSuper
    public void dismiss() {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        try {
            l.h(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i4) {
        T t3 = (T) this.zg.findViewById(i4);
        return t3 != null ? t3 : (T) super.findViewById(i4);
    }

    protected abstract void g(View view);

    @LayoutRes
    protected abstract int getLayoutId();

    protected boolean ns() {
        return false;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.zg = (ViewGroup) l.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.zg = ck();
            }
            setContentView(this.zg);
            setCanceledOnTouchOutside(ns());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (cj() != -1.0f) {
                attributes.dimAmount = cj();
            }
            getWindow().setAttributes(attributes);
            setCancelable(true);
            g(this.zg);
        } catch (Throwable th) {
            if (k.zd().yp()) {
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                dismiss();
                return;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    @CallSuper
    public void onStart() {
        super.onStart();
        setTitle((CharSequence) null);
    }

    @Override // android.app.Dialog
    public void setContentView(int i4) {
        super.setContentView(i4);
        this.zg = (ViewGroup) l.inflate(this.mContext, i4, null);
    }
}
