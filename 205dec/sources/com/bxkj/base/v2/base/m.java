package com.bxkj.base.v2.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bxkj.base.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: LoadingDialog.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    protected Dialog f18528a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f18529b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18530c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadingDialog.java */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends com.bjtsn.dylan.lifecycleobserver.b {
        a() {
        }

        @Override // com.bjtsn.dylan.lifecycleobserver.b
        public void onDestroy() {
            Dialog dialog = m.this.f18528a;
            if (dialog != null && dialog.isShowing()) {
                m.this.f18528a.dismiss();
            }
            super.onDestroy();
        }
    }

    public m(Context context) {
        this.f18529b = context;
        this.f18528a = new Dialog(context, R.style.loadingDialogStyle);
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_progress_dialog, (ViewGroup) null);
        this.f18530c = (TextView) inflate.findViewById(R.id.tv_msg);
        this.f18528a.setContentView(inflate);
        this.f18528a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f18528a.setCanceledOnTouchOutside(false);
        a(context);
    }

    private void a(Context context) {
        if (context instanceof FragmentActivity) {
            new LifecycleObserver((FragmentActivity) context).c(new a());
        }
    }

    public void b() {
        c();
    }

    public void c() {
        Dialog dialog = this.f18528a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        Context baseContext = ((ContextWrapper) this.f18528a.getContext()).getBaseContext();
        if (baseContext instanceof Activity) {
            Activity activity = (Activity) baseContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            this.f18528a.dismiss();
            return;
        }
        this.f18528a.dismiss();
    }

    public boolean d() {
        Dialog dialog = this.f18528a;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void e(String str) {
        TextView textView = this.f18530c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        this.f18528a.setOnDismissListener(onDismissListener);
    }

    public void g(DialogInterface.OnKeyListener onKeyListener) {
        this.f18528a.setOnKeyListener(onKeyListener);
    }

    public Dialog h() {
        return i(null);
    }

    public Dialog i(String str) {
        try {
            if (this.f18530c != null && !TextUtils.isEmpty(str)) {
                this.f18530c.setText(str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (!this.f18528a.isShowing()) {
            if (((ContextWrapper) this.f18528a.getContext()).getBaseContext() instanceof Activity) {
                Activity activity = (Activity) this.f18529b;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    this.f18528a.show();
                }
            } else {
                this.f18528a.show();
            }
        }
        return this.f18528a;
    }

    public Dialog j(String str) {
        this.f18528a.setContentView(LayoutInflater.from(this.f18529b).inflate(R.layout.pub_loading, (ViewGroup) null));
        try {
            TextView textView = (TextView) this.f18528a.findViewById(R.id.tv_text);
            this.f18530c = textView;
            if (textView != null && !TextUtils.isEmpty(str)) {
                this.f18530c.setText(str);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (!this.f18528a.isShowing()) {
            Context baseContext = ((ContextWrapper) this.f18528a.getContext()).getBaseContext();
            if (baseContext instanceof Activity) {
                if (!((Activity) baseContext).isFinishing()) {
                    this.f18528a.show();
                }
            } else {
                this.f18528a.show();
            }
        }
        return this.f18528a;
    }
}
