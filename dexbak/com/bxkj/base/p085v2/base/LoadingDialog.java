package com.bxkj.base.p085v2.base;

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
import com.bjtsn.dylan.lifecycleobserver.LifecycleCallback;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bxkj.base.C3801R;

/* renamed from: com.bxkj.base.v2.base.m */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LoadingDialog {

    /* renamed from: a */
    protected Dialog f15041a;

    /* renamed from: b */
    protected Context f15042b;

    /* renamed from: c */
    private TextView f15043c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LoadingDialog.java */
    /* renamed from: com.bxkj.base.v2.base.m$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C3935a extends LifecycleCallback {
        C3935a() {
        }

        @Override // com.bjtsn.dylan.lifecycleobserver.LifecycleCallback
        public void onDestroy() {
            Dialog dialog = LoadingDialog.this.f15041a;
            if (dialog != null && dialog.isShowing()) {
                LoadingDialog.this.f15041a.dismiss();
            }
            super.onDestroy();
        }
    }

    public LoadingDialog(Context context) {
        this.f15042b = context;
        this.f15041a = new Dialog(context, C3801R.C3810style.loadingDialogStyle);
        View inflate = LayoutInflater.from(context).inflate(C3801R.C3807layout.fragment_progress_dialog, (ViewGroup) null);
        this.f15043c = (TextView) inflate.findViewById(C3801R.C3805id.tv_msg);
        this.f15041a.setContentView(inflate);
        this.f15041a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f15041a.setCanceledOnTouchOutside(false);
        m43875a(context);
    }

    /* renamed from: a */
    private void m43875a(Context context) {
        if (context instanceof FragmentActivity) {
            new LifecycleObserver((FragmentActivity) context).m45791c(new C3935a());
        }
    }

    /* renamed from: b */
    public void m43874b() {
        m43873c();
    }

    /* renamed from: c */
    public void m43873c() {
        Dialog dialog = this.f15041a;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        Context baseContext = ((ContextWrapper) this.f15041a.getContext()).getBaseContext();
        if (baseContext instanceof Activity) {
            Activity activity = (Activity) baseContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            this.f15041a.dismiss();
            return;
        }
        this.f15041a.dismiss();
    }

    /* renamed from: d */
    public boolean m43872d() {
        Dialog dialog = this.f15041a;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    /* renamed from: e */
    public void m43871e(String str) {
        TextView textView = this.f15043c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: f */
    public void m43870f(DialogInterface.OnDismissListener onDismissListener) {
        this.f15041a.setOnDismissListener(onDismissListener);
    }

    /* renamed from: g */
    public void m43869g(DialogInterface.OnKeyListener onKeyListener) {
        this.f15041a.setOnKeyListener(onKeyListener);
    }

    /* renamed from: h */
    public Dialog m43868h() {
        return m43867i(null);
    }

    /* renamed from: i */
    public Dialog m43867i(String str) {
        try {
            if (this.f15043c != null && !TextUtils.isEmpty(str)) {
                this.f15043c.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.f15041a.isShowing()) {
            if (((ContextWrapper) this.f15041a.getContext()).getBaseContext() instanceof Activity) {
                Activity activity = (Activity) this.f15042b;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    this.f15041a.show();
                }
            } else {
                this.f15041a.show();
            }
        }
        return this.f15041a;
    }

    /* renamed from: j */
    public Dialog m43866j(String str) {
        this.f15041a.setContentView(LayoutInflater.from(this.f15042b).inflate(C3801R.C3807layout.pub_loading, (ViewGroup) null));
        try {
            TextView textView = (TextView) this.f15041a.findViewById(C3801R.C3805id.tv_text);
            this.f15043c = textView;
            if (textView != null && !TextUtils.isEmpty(str)) {
                this.f15043c.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.f15041a.isShowing()) {
            Context baseContext = ((ContextWrapper) this.f15041a.getContext()).getBaseContext();
            if (baseContext instanceof Activity) {
                if (!((Activity) baseContext).isFinishing()) {
                    this.f15041a.show();
                }
            } else {
                this.f15041a.show();
            }
        }
        return this.f15041a;
    }
}
