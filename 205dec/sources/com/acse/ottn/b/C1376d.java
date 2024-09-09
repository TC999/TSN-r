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

/* renamed from: com.acse.ottn.b.d  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1376d {

    /* renamed from: a  reason: collision with root package name */
    private static AlertDialog f5099a;

    /* renamed from: b  reason: collision with root package name */
    private static ImageView f5100b;

    /* renamed from: c  reason: collision with root package name */
    private static TextView f5101c;

    /* renamed from: d  reason: collision with root package name */
    private static TextView f5102d;

    /* renamed from: e  reason: collision with root package name */
    private static TextView f5103e;

    /* renamed from: f  reason: collision with root package name */
    private a f5104f;

    /* renamed from: com.acse.ottn.b.d$a */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public interface a {
        void onDismiss();

        void onOpen();
    }

    public static AlertDialog a(Activity activity, String str, a aVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.accessiblity_seeding_green_fragment_dialog, (ViewGroup) null);
        f5100b = (ImageView) inflate.findViewById(R.id.iv_dissmiss);
        f5102d = (TextView) inflate.findViewById(R.id.tv_button);
        f5103e = (TextView) inflate.findViewById(R.id.tv_but2);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_version_info);
        f5101c = textView;
        textView.setText(str + "\u1f62d");
        f5100b.setOnClickListener(new View$OnClickListenerC1373a(activity));
        f5102d.setOnClickListener(new View$OnClickListenerC1374b(activity, aVar));
        f5103e.setOnClickListener(new View$OnClickListenerC1375c(activity, aVar));
        com.acse.ottn.util.I.a().a(activity, f5103e);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5099a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5099a);
        return f5099a;
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
