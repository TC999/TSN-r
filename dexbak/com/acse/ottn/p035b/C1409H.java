package com.acse.ottn.p035b;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.C1239R;
import com.acse.ottn.util.C1633I;
import com.acse.ottn.util.CommonUtil;

/* renamed from: com.acse.ottn.b.H */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1409H {

    /* renamed from: a */
    private static AlertDialog f2525a;

    /* renamed from: com.acse.ottn.b.H$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1410a {
        void onDismiss();

        void onOpen();
    }

    /* renamed from: a */
    public static AlertDialog m56843a(Activity activity, InterfaceC1410a interfaceC1410a) {
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.main_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        TextView textView = (TextView) inflate.findViewById(C1239R.C1242id.tv_but2);
        textView.setOnClickListener(new View$OnClickListenerC1405D(interfaceC1410a, activity));
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_button)).setOnClickListener(new View$OnClickListenerC1406E(activity));
        ((TextView) inflate.findViewById(C1239R.C1242id.title)).setText("请先同意" + CommonUtil.showPermissionName);
        TextView textView2 = (TextView) inflate.findViewById(C1239R.C1242id.tv_privacy);
        textView2.setOnClickListener(new View$OnClickListenerC1407F(activity));
        TextView textView3 = (TextView) inflate.findViewById(C1239R.C1242id.tv_service);
        textView3.setOnClickListener(new View$OnClickListenerC1408G(activity));
        C1633I.m56254a().m56241c(activity, textView3);
        C1633I.m56254a().m56241c(activity, textView2);
        C1633I.m56254a().m56241c(activity, textView);
        AlertDialog create = builder.create();
        f2525a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56842b(activity, f2525a);
        return f2525a;
    }

    /* renamed from: a */
    public static void m56844a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m56842b(Activity activity, Dialog dialog) {
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
