package com.acse.ottn.b;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.R;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.S;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static AlertDialog f5151a;

    /* renamed from: b  reason: collision with root package name */
    private static TextView f5152b;

    /* renamed from: c  reason: collision with root package name */
    private static TextView f5153c;

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.save_monery_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        Spanned fromHtml = Html.fromHtml("<b><big><big><big><font color=#4D230A> \u8d2d\u7269\u7701\u94b1\u795e\u5668</font></big></big></big></b><font color=#90713A>  \u4f53\u9a8c\u673a\u4f1a</font>");
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        f5152b = textView;
        textView.setText(fromHtml);
        ((TextView) inflate.findViewById(R.id.tv_content2)).setText("\u81ea\u52a8\u53d1\u73b0\u9690\u85cf\u4f18\u60e0\u5238,\u6dd8\u5b9d\u3001\u4eac\u4e1c\u6700\u9ad8\u770180%!");
        f5153c = (TextView) inflate.findViewById(R.id.iv_dismiss);
        inflate.findViewById(R.id.rl_content).setOnClickListener(new p(activity, onClickCallBack));
        S.a().b(11000, 1000, new q(activity, onClickCallBack));
        inflate.findViewById(R.id.tv_open).setOnClickListener(new r(activity, onClickCallBack));
        AlertDialog create = builder.create();
        f5151a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5151a);
        return f5151a;
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
