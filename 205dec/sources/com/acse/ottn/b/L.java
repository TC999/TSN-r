package com.acse.ottn.b;

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
import com.acse.ottn.R;
import com.acse.ottn.activity.AcseHelpManager;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class L {

    /* renamed from: a  reason: collision with root package name */
    private static AlertDialog f5083a;

    /* renamed from: b  reason: collision with root package name */
    private static ImageView f5084b;

    /* renamed from: c  reason: collision with root package name */
    private static ImageView f5085c;

    /* renamed from: d  reason: collision with root package name */
    private static TextView f5086d;

    /* renamed from: e  reason: collision with root package name */
    private static TextView f5087e;

    /* renamed from: f  reason: collision with root package name */
    private static TextView f5088f;

    /* renamed from: g  reason: collision with root package name */
    private static TextView f5089g;

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
        View inflate = LayoutInflater.from(activity).inflate(R.layout.warning_dialog, (ViewGroup) null);
        f5084b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f5086d = (TextView) inflate.findViewById(R.id.tv_button);
        f5087e = (TextView) inflate.findViewById(R.id.tv_but2);
        f5085c = (ImageView) inflate.findViewById(R.id.iv_icon);
        f5088f = (TextView) inflate.findViewById(R.id.tv_content);
        f5089g = (TextView) inflate.findViewById(R.id.tv_version_info);
        f5087e.setVisibility(0);
        f5086d.setTextColor(Color.parseColor("#999999"));
        f5086d.setBackground(null);
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            f5089g.setText(activity.getString(R.string.warning_dialog_title));
            f5088f.setText(activity.getString(R.string.warning_message));
            f5086d.setText(activity.getString(R.string.warning_commit));
            f5087e.setText(activity.getString(R.string.warning_cancle));
        } else {
            f5087e.setText(str3);
            f5086d.setText(str4);
            f5088f.setText(str2);
            f5089g.setText(str);
        }
        com.acse.ottn.util.I.a().a(activity, f5087e);
        com.acse.ottn.util.I.a().c(activity, f5085c);
        f5086d.setOnClickListener(new I(onClickCallBack, activity));
        f5087e.setOnClickListener(new J(onClickCallBack, activity));
        f5084b.setOnClickListener(new K(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5083a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5083a);
        return f5083a;
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
