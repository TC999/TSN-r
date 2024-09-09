package com.acse.ottn.b;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.R;
import com.acse.ottn.util.CommonUtil;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class H {

    /* renamed from: a  reason: collision with root package name */
    private static AlertDialog f5076a;

    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void onDismiss();

        void onOpen();
    }

    public static AlertDialog a(Activity activity, a aVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.main_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_but2);
        textView.setOnClickListener(new D(aVar, activity));
        ((TextView) inflate.findViewById(R.id.tv_button)).setOnClickListener(new E(activity));
        ((TextView) inflate.findViewById(R.id.title)).setText("\u8bf7\u5148\u540c\u610f" + CommonUtil.showPermissionName);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_privacy);
        textView2.setOnClickListener(new F(activity));
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_service);
        textView3.setOnClickListener(new G(activity));
        com.acse.ottn.util.I.a().c(activity, textView3);
        com.acse.ottn.util.I.a().c(activity, textView2);
        com.acse.ottn.util.I.a().c(activity, textView);
        AlertDialog create = builder.create();
        f5076a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5076a);
        return f5076a;
    }

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception unused) {
        }
    }
}
