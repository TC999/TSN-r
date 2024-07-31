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
import com.kwad.components.core.p288d.C8571a;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p445n.C10887l;

/* renamed from: com.kwad.components.core.proxy.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractAlertDialogC8887d extends AlertDialog {
    public Activity mActivity;
    protected final Context mContext;

    /* renamed from: zg */
    protected ViewGroup f28746zg;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractAlertDialogC8887d(Activity activity) {
        super(activity);
        setOwnerActivity(activity);
        this.mActivity = activity;
        this.mContext = C10887l.wrapContextIfNeed(activity);
    }

    /* renamed from: cj */
    protected float mo29675cj() {
        return -1.0f;
    }

    /* renamed from: ck */
    protected ViewGroup mo29674ck() {
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
            C10887l.m24550h(activity);
        } catch (Throwable unused) {
        }
        try {
            super.dismiss();
        } catch (Throwable th) {
            C10331c.printStackTrace(th);
        }
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        T t = (T) this.f28746zg.findViewById(i);
        return t != null ? t : (T) super.findViewById(i);
    }

    /* renamed from: g */
    protected abstract void mo28085g(View view);

    @LayoutRes
    protected abstract int getLayoutId();

    /* renamed from: ns */
    protected boolean mo29673ns() {
        return false;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            if (getLayoutId() != 0) {
                this.f28746zg = (ViewGroup) C10887l.inflate(this.mContext, getLayoutId(), null);
            } else {
                this.f28746zg = mo29674ck();
            }
            setContentView(this.f28746zg);
            setCanceledOnTouchOutside(mo29673ns());
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().clearFlags(131072);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            if (mo29675cj() != -1.0f) {
                attributes.dimAmount = mo29675cj();
            }
            getWindow().setAttributes(attributes);
            setCancelable(true);
            mo28085g(this.f28746zg);
        } catch (Throwable th) {
            if (C10829k.m24699zd().m24703yp()) {
                C8571a.reportSdkCaughtException(th);
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
    public void setContentView(int i) {
        super.setContentView(i);
        this.f28746zg = (ViewGroup) C10887l.inflate(this.mContext, i, null);
    }
}
