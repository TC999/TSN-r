package com.acse.ottn.p035b;

import android.app.Activity;
import android.app.Dialog;
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

/* renamed from: com.acse.ottn.b.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1423h {

    /* renamed from: a */
    private static AlertDialog f2562a;

    /* renamed from: b */
    private static ImageView f2563b;

    /* renamed from: c */
    private static TextView f2564c;

    /* renamed from: d */
    private static TextView f2565d;

    /* renamed from: e */
    private static TextView f2566e;

    /* renamed from: f */
    private static TextView f2567f;

    /* renamed from: a */
    public static AlertDialog m56828a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return m56825b(activity, null, null, null, null, onClickCallBack);
    }

    /* renamed from: a */
    public static AlertDialog m56827a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return m56825b(activity, str, str2, str3, str4, onClickCallBack);
    }

    /* renamed from: a */
    public static void m56829a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static AlertDialog m56825b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.custon_dialog, (ViewGroup) null);
        f2563b = (ImageView) inflate.findViewById(C1239R.C1242id.iv_dismiss);
        f2564c = (TextView) inflate.findViewById(C1239R.C1242id.tv_button);
        f2565d = (TextView) inflate.findViewById(C1239R.C1242id.tv_but2);
        f2566e = (TextView) inflate.findViewById(C1239R.C1242id.tv_content);
        f2567f = (TextView) inflate.findViewById(C1239R.C1242id.tv_version_info);
        if (!TextUtils.isEmpty(str3)) {
            f2565d.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            f2564c.setText(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            f2566e.setText(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            f2567f.setText(str);
        }
        C1633I.m56254a().m56248a(activity, f2565d);
        f2564c.setOnClickListener(new View$OnClickListenerC1420e(activity, str3, str4, onClickCallBack));
        f2565d.setOnClickListener(new View$OnClickListenerC1421f(activity, str3, str4, onClickCallBack));
        f2563b.setOnClickListener(new View$OnClickListenerC1422g(str3, str4, activity, onClickCallBack));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f2562a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56826b(activity, f2562a);
        return f2562a;
    }

    /* renamed from: b */
    public static void m56826b(Activity activity, Dialog dialog) {
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
