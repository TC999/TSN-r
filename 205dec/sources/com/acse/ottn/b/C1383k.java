package com.acse.ottn.b;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.R;
import com.acse.ottn.util.ra;

/* renamed from: com.acse.ottn.b.k  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1383k {

    /* renamed from: a  reason: collision with root package name */
    private static AlertDialog f5132a;

    /* renamed from: com.acse.ottn.b.k$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void a();

        void b();
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, boolean z3, a aVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_single_green_button_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_button2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_version_info);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_dissmiss);
        if (str == null) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
            textView3.setGravity(1);
        } else {
            textView.setText(str);
        }
        textView3.setText(str2);
        textView2.setText(str3);
        com.acse.ottn.util.I.a().a(activity, textView2);
        textView2.setOnClickListener(new View$OnClickListenerC1381i(activity, aVar));
        imageView.setOnClickListener(new View$OnClickListenerC1382j(activity, aVar));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5132a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5132a);
        return f5132a;
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
        } catch (Exception e4) {
            ra.a("samop", "error =" + e4.getMessage());
        }
    }
}
