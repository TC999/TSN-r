package cn.bluemobi.dylan.http.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.http.C1175R;
import cn.bluemobi.dylan.http.Http;
import com.bjtsn.dylan.lifecycleobserver.LifecycleCallback;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class LoadingDialog {
    protected Context context;
    protected Dialog dialog;
    private TextView tv_text;

    public LoadingDialog(Context context) {
        this.context = context;
        Dialog dialog = new Dialog(context, C1175R.C1181style.loadingDialogStyle);
        this.dialog = dialog;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.setCanceledOnTouchOutside(false);
        addLifeCycle(context);
    }

    private void addLifeCycle(Context context) {
        if (context instanceof FragmentActivity) {
            new LifecycleObserver((FragmentActivity) context).m45791c(new LifecycleCallback() { // from class: cn.bluemobi.dylan.http.dialog.LoadingDialog.1
                @Override // com.bjtsn.dylan.lifecycleobserver.LifecycleCallback
                public void onDestroy() {
                    Dialog dialog = LoadingDialog.this.dialog;
                    if (dialog != null && dialog.isShowing()) {
                        LoadingDialog.this.dialog.dismiss();
                    }
                    super.onDestroy();
                }
            });
        }
    }

    public void dismiss() {
        hideProgress();
    }

    public void hideProgress() {
        Dialog dialog = this.dialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        Context baseContext = ((ContextWrapper) this.dialog.getContext()).getBaseContext();
        if (baseContext instanceof Activity) {
            Activity activity = (Activity) baseContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            this.dialog.dismiss();
            return;
        }
        this.dialog.dismiss();
    }

    public boolean isShowing() {
        Dialog dialog = this.dialog;
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public void setMessage(String str) {
        TextView textView = this.tv_text;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.dialog.setOnDismissListener(onDismissListener);
    }

    public void setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        this.dialog.setOnKeyListener(onKeyListener);
    }

    public Dialog show() {
        return show(null);
    }

    public Dialog showDefaultStyle(String str) {
        this.dialog.setContentView(LayoutInflater.from(this.context).inflate(C1175R.C1179layout.pub_loading, (ViewGroup) null));
        try {
            TextView textView = (TextView) this.dialog.findViewById(C1175R.C1178id.tv_text);
            this.tv_text = textView;
            if (textView != null && !TextUtils.isEmpty(str)) {
                this.tv_text.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.dialog.isShowing()) {
            Context baseContext = ((ContextWrapper) this.dialog.getContext()).getBaseContext();
            if (baseContext instanceof Activity) {
                if (!((Activity) baseContext).isFinishing()) {
                    this.dialog.show();
                }
            } else {
                this.dialog.show();
            }
        }
        return this.dialog;
    }

    public Dialog show(String str) {
        if (Http.getHttp().getLoadingDialogLayoutId() != null) {
            this.dialog.setContentView(Http.getHttp().getLoadingDialogLayoutId().intValue());
        } else {
            this.dialog.setContentView(LayoutInflater.from(this.context).inflate(C1175R.C1179layout.pub_loading, (ViewGroup) null));
        }
        try {
            TextView textView = (TextView) this.dialog.findViewById(C1175R.C1178id.tv_text);
            this.tv_text = textView;
            if (textView != null && !TextUtils.isEmpty(str)) {
                this.tv_text.setText(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!this.dialog.isShowing()) {
            if (((ContextWrapper) this.dialog.getContext()).getBaseContext() instanceof Activity) {
                Activity activity = (Activity) this.context;
                if (!activity.isFinishing() && !activity.isDestroyed()) {
                    this.dialog.show();
                }
            } else {
                this.dialog.show();
            }
        }
        return this.dialog;
    }
}
