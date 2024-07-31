package com.acse.ottn.p035b;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.C1239R;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.C1694ra;

/* renamed from: com.acse.ottn.b.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1426k {

    /* renamed from: a */
    private static AlertDialog f2572a;

    /* renamed from: com.acse.ottn.b.k$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1427a {
        /* renamed from: a */
        void mo56522a();

        /* renamed from: b */
        void mo56521b();
    }

    /* renamed from: a */
    public static AlertDialog m56822a(Activity activity, String str, String str2, String str3, boolean z, InterfaceC1427a interfaceC1427a) {
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.dialog_single_green_button_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(C1239R.C1242id.tv_content);
        TextView textView2 = (TextView) inflate.findViewById(C1239R.C1242id.tv_button2);
        TextView textView3 = (TextView) inflate.findViewById(C1239R.C1242id.tv_version_info);
        ImageView imageView = (ImageView) inflate.findViewById(C1239R.C1242id.iv_dissmiss);
        if (str == null) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
            textView3.setGravity(1);
        } else {
            textView.setText(str);
        }
        textView3.setText(str2);
        textView2.setText(str3);
        C1633I.m56254a().m56248a(activity, textView2);
        textView2.setOnClickListener(new View$OnClickListenerC1424i(activity, interfaceC1427a));
        imageView.setOnClickListener(new View$OnClickListenerC1425j(activity, interfaceC1427a));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f2572a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56821b(activity, f2572a);
        return f2572a;
    }

    /* renamed from: a */
    public static void m56823a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m56821b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception e) {
            C1694ra.m55917a("samop", "error =" + e.getMessage());
        }
    }
}
