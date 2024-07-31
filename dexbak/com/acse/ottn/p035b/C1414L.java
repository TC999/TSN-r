package com.acse.ottn.p035b;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.C1239R;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1633I;

/* renamed from: com.acse.ottn.b.L */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1414L {

    /* renamed from: a */
    private static AlertDialog f2532a;

    /* renamed from: b */
    private static ImageView f2533b;

    /* renamed from: c */
    private static ImageView f2534c;

    /* renamed from: d */
    private static TextView f2535d;

    /* renamed from: e */
    private static TextView f2536e;

    /* renamed from: f */
    private static TextView f2537f;

    /* renamed from: g */
    private static TextView f2538g;

    /* renamed from: a */
    public static AlertDialog m56839a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return m56835b(activity, null, null, null, null, onClickCallBack);
    }

    /* renamed from: a */
    public static AlertDialog m56838a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return m56835b(activity, str, str2, str3, str4, onClickCallBack);
    }

    /* renamed from: a */
    public static void m56840a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static AlertDialog m56835b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.warning_dialog, (ViewGroup) null);
        f2533b = (ImageView) inflate.findViewById(C1239R.C1242id.iv_dismiss);
        f2535d = (TextView) inflate.findViewById(C1239R.C1242id.tv_button);
        f2536e = (TextView) inflate.findViewById(C1239R.C1242id.tv_but2);
        f2534c = (ImageView) inflate.findViewById(C1239R.C1242id.iv_icon);
        f2537f = (TextView) inflate.findViewById(C1239R.C1242id.tv_content);
        f2538g = (TextView) inflate.findViewById(C1239R.C1242id.tv_version_info);
        f2536e.setVisibility(0);
        f2535d.setTextColor(Color.parseColor("#999999"));
        f2535d.setBackground(null);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            f2538g.setText(activity.getString(C1239R.C1245string.warning_dialog_title));
            f2537f.setText(activity.getString(C1239R.C1245string.warning_message));
            f2535d.setText(activity.getString(C1239R.C1245string.warning_commit));
            f2536e.setText(activity.getString(C1239R.C1245string.warning_cancle));
        } else {
            f2536e.setText(str3);
            f2535d.setText(str4);
            f2537f.setText(str2);
            f2538g.setText(str);
        }
        C1633I.m56254a().m56248a(activity, f2536e);
        C1633I.m56254a().m56242c(activity, f2534c);
        f2535d.setOnClickListener(new View$OnClickListenerC1411I(onClickCallBack, activity));
        f2536e.setOnClickListener(new View$OnClickListenerC1412J(onClickCallBack, activity));
        f2533b.setOnClickListener(new View$OnClickListenerC1413K(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f2532a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56836b(activity, f2532a);
        return f2532a;
    }

    /* renamed from: b */
    public static void m56836b(Activity activity, Dialog dialog) {
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
