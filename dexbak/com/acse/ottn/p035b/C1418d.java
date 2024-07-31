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

/* renamed from: com.acse.ottn.b.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1418d {

    /* renamed from: a */
    private static AlertDialog f2544a;

    /* renamed from: b */
    private static ImageView f2545b;

    /* renamed from: c */
    private static TextView f2546c;

    /* renamed from: d */
    private static TextView f2547d;

    /* renamed from: e */
    private static TextView f2548e;

    /* renamed from: f */
    private InterfaceC1419a f2549f;

    /* renamed from: com.acse.ottn.b.d$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1419a {
        void onDismiss();

        void onOpen();
    }

    /* renamed from: a */
    public static AlertDialog m56832a(Activity activity, String str, InterfaceC1419a interfaceC1419a) {
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.accessiblity_seeding_green_fragment_dialog, (ViewGroup) null);
        f2545b = (ImageView) inflate.findViewById(C1239R.C1242id.iv_dissmiss);
        f2547d = (TextView) inflate.findViewById(C1239R.C1242id.tv_button);
        f2548e = (TextView) inflate.findViewById(C1239R.C1242id.tv_but2);
        TextView textView = (TextView) inflate.findViewById(C1239R.C1242id.tv_version_info);
        f2546c = textView;
        textView.setText(str + "😭");
        f2545b.setOnClickListener(new View$OnClickListenerC1415a(activity));
        f2547d.setOnClickListener(new View$OnClickListenerC1416b(activity, interfaceC1419a));
        f2548e.setOnClickListener(new View$OnClickListenerC1417c(activity, interfaceC1419a));
        C1633I.m56254a().m56248a(activity, f2548e);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f2544a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56831b(activity, f2544a);
        return f2544a;
    }

    /* renamed from: a */
    public static void m56833a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m56831b(Activity activity, Dialog dialog) {
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
