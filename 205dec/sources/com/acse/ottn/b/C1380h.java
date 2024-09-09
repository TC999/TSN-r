package com.acse.ottn.b;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.R;
import com.acse.ottn.activity.AcseHelpManager;

/* renamed from: com.acse.ottn.b.h  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1380h {

    /* renamed from: a  reason: collision with root package name */
    private static AlertDialog f5122a;

    /* renamed from: b  reason: collision with root package name */
    private static ImageView f5123b;

    /* renamed from: c  reason: collision with root package name */
    private static TextView f5124c;

    /* renamed from: d  reason: collision with root package name */
    private static TextView f5125d;

    /* renamed from: e  reason: collision with root package name */
    private static TextView f5126e;

    /* renamed from: f  reason: collision with root package name */
    private static TextView f5127f;

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, null, null, null, null, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, str, str2, str3, str4, onClickCallBack);
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

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.custon_dialog, (ViewGroup) null);
        f5123b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f5124c = (TextView) inflate.findViewById(R.id.tv_button);
        f5125d = (TextView) inflate.findViewById(R.id.tv_but2);
        f5126e = (TextView) inflate.findViewById(R.id.tv_content);
        f5127f = (TextView) inflate.findViewById(R.id.tv_version_info);
        if (!TextUtils.isEmpty(str3)) {
            f5125d.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            f5124c.setText(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            f5126e.setText(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            f5127f.setText(str);
        }
        com.acse.ottn.util.I.a().a(activity, f5125d);
        f5124c.setOnClickListener(new View$OnClickListenerC1377e(activity, str3, str4, onClickCallBack));
        f5125d.setOnClickListener(new View$OnClickListenerC1378f(activity, str3, str4, onClickCallBack));
        f5123b.setOnClickListener(new View$OnClickListenerC1379g(str3, str4, activity, onClickCallBack));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5122a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5122a);
        return f5122a;
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
