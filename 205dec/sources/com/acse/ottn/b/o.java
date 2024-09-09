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

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private static AlertDialog f5140a;

    /* renamed from: b  reason: collision with root package name */
    private static ImageView f5141b;

    /* renamed from: c  reason: collision with root package name */
    private static TextView f5142c;

    /* renamed from: d  reason: collision with root package name */
    private static TextView f5143d;

    /* renamed from: e  reason: collision with root package name */
    private static ImageView f5144e;

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, false, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, str, str2, str3, str4, false, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, boolean z3, AcseHelpManager.OnClickCallBack onClickCallBack) {
        TextView textView;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.seeding_running_dialog, (ViewGroup) null);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_version_info);
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(R.string.invite_title);
        }
        textView2.setText(str);
        f5141b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f5143d = (TextView) inflate.findViewById(R.id.tv_but2);
        if (TextUtils.isEmpty(str3)) {
            textView = f5143d;
            str3 = activity.getString(R.string.invite_commit);
        } else {
            textView = f5143d;
        }
        textView.setText(str3);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
        f5144e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        f5142c = (TextView) inflate.findViewById(R.id.tv_button);
        if (TextUtils.isEmpty(str4)) {
            f5142c.setText(activity.getString(R.string.invite_cancle));
        } else {
            f5142c.setText(str4);
        }
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_content);
        if (TextUtils.isEmpty(str2)) {
            str2 = activity.getString(R.string.invite_message);
        }
        textView3.setText(str2);
        com.acse.ottn.util.I.a().b(activity, f5142c);
        com.acse.ottn.util.I.a().a(activity, f5143d);
        com.acse.ottn.util.I.a().b(activity, f5144e);
        f5142c.setOnClickListener(new View$OnClickListenerC1384l(z3, activity, onClickCallBack));
        f5141b.setOnClickListener(new m(onClickCallBack, activity));
        f5143d.setOnClickListener(new n(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5140a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5140a);
        return f5140a;
    }

    public static AlertDialog a(Activity activity, boolean z3, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, z3, onClickCallBack);
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
