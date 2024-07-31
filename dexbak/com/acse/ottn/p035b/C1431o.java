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

/* renamed from: com.acse.ottn.b.o */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1431o {

    /* renamed from: a */
    private static AlertDialog f2580a;

    /* renamed from: b */
    private static ImageView f2581b;

    /* renamed from: c */
    private static TextView f2582c;

    /* renamed from: d */
    private static TextView f2583d;

    /* renamed from: e */
    private static ImageView f2584e;

    /* renamed from: a */
    public static AlertDialog m56818a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return m56816a(activity, null, null, null, null, false, onClickCallBack);
    }

    /* renamed from: a */
    public static AlertDialog m56817a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return m56816a(activity, str, str2, str3, str4, false, onClickCallBack);
    }

    /* renamed from: a */
    public static AlertDialog m56816a(Activity activity, String str, String str2, String str3, String str4, boolean z, AcseHelpManager.OnClickCallBack onClickCallBack) {
        TextView textView;
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.seeding_running_dialog, (ViewGroup) null);
        TextView textView2 = (TextView) inflate.findViewById(C1239R.C1242id.tv_version_info);
        if (TextUtils.isEmpty(str)) {
            str = activity.getString(C1239R.C1245string.invite_title);
        }
        textView2.setText(str);
        f2581b = (ImageView) inflate.findViewById(C1239R.C1242id.iv_dismiss);
        f2583d = (TextView) inflate.findViewById(C1239R.C1242id.tv_but2);
        if (TextUtils.isEmpty(str3)) {
            textView = f2583d;
            str3 = activity.getString(C1239R.C1245string.invite_commit);
        } else {
            textView = f2583d;
        }
        textView.setText(str3);
        ImageView imageView = (ImageView) inflate.findViewById(C1239R.C1242id.iv_icon);
        f2584e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        f2582c = (TextView) inflate.findViewById(C1239R.C1242id.tv_button);
        if (TextUtils.isEmpty(str4)) {
            f2582c.setText(activity.getString(C1239R.C1245string.invite_cancle));
        } else {
            f2582c.setText(str4);
        }
        TextView textView3 = (TextView) inflate.findViewById(C1239R.C1242id.tv_content);
        if (TextUtils.isEmpty(str2)) {
            str2 = activity.getString(C1239R.C1245string.invite_message);
        }
        textView3.setText(str2);
        C1633I.m56254a().m56244b(activity, f2582c);
        C1633I.m56254a().m56248a(activity, f2583d);
        C1633I.m56254a().m56245b(activity, f2584e);
        f2582c.setOnClickListener(new View$OnClickListenerC1428l(z, activity, onClickCallBack));
        f2581b.setOnClickListener(new View$OnClickListenerC1429m(onClickCallBack, activity));
        f2583d.setOnClickListener(new View$OnClickListenerC1430n(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f2580a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56814b(activity, f2580a);
        return f2580a;
    }

    /* renamed from: a */
    public static AlertDialog m56815a(Activity activity, boolean z, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return m56816a(activity, null, null, null, null, z, onClickCallBack);
    }

    /* renamed from: a */
    public static void m56819a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m56814b(Activity activity, Dialog dialog) {
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
