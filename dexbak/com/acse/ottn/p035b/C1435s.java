package com.acse.ottn.p035b;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.C1239R;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.C1648S;

/* renamed from: com.acse.ottn.b.s */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1435s {

    /* renamed from: a */
    private static AlertDialog f2591a;

    /* renamed from: b */
    private static TextView f2592b;

    /* renamed from: c */
    private static TextView f2593c;

    /* renamed from: a */
    public static AlertDialog m56811a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(C1239R.C1244layout.save_monery_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C1239R.C1246style.AlertDialogCustom);
        builder.setView(inflate);
        Spanned fromHtml = Html.fromHtml("<b><big><big><big><font color=#4D230A> 购物省钱神器</font></big></big></big></b><font color=#90713A>  体验机会</font>");
        TextView textView = (TextView) inflate.findViewById(C1239R.C1242id.tv_content);
        f2592b = textView;
        textView.setText(fromHtml);
        ((TextView) inflate.findViewById(C1239R.C1242id.tv_content2)).setText("自动发现隐藏优惠券,淘宝、京东最高省80%!");
        f2593c = (TextView) inflate.findViewById(C1239R.C1242id.iv_dismiss);
        inflate.findViewById(C1239R.C1242id.rl_content).setOnClickListener(new View$OnClickListenerC1432p(activity, onClickCallBack));
        C1648S.m56165a().m56163b(11000, 1000, new C1433q(activity, onClickCallBack));
        inflate.findViewById(C1239R.C1242id.tv_open).setOnClickListener(new View$OnClickListenerC1434r(activity, onClickCallBack));
        AlertDialog create = builder.create();
        f2591a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        m56809b(activity, f2591a);
        return f2591a;
    }

    /* renamed from: a */
    public static void m56812a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public static void m56809b(Activity activity, Dialog dialog) {
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
