package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.l0;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class o3 {

    /* renamed from: a  reason: collision with root package name */
    public static AlertDialog f6105a;

    /* renamed from: b  reason: collision with root package name */
    public static TextView f6106b;

    /* renamed from: c  reason: collision with root package name */
    public static TextView f6107c;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6108a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6109b;

        public a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f6108a = activity;
            this.f6109b = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o3.a(this.f6108a, o3.f6105a);
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f6108a, 10010);
            this.f6109b.onOpen();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6110a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6111b;

        public b(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f6110a = activity;
            this.f6111b = onClickCallBack;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            TextView textView = o3.f6107c;
            textView.setText(((j4 / 1000) - 1) + "\u79d2");
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            if (this.f6110a.isFinishing() || !o3.f6105a.isShowing()) {
                return;
            }
            o3.a(this.f6110a, o3.f6105a);
            this.f6111b.onDismiss();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6113b;

        public c(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f6112a = activity;
            this.f6113b = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o3.a(this.f6112a, o3.f6105a);
            AcseHelpManager.startAccessibilityIntroduceActivityForResult(this.f6112a, 10010);
            this.f6113b.onOpen();
        }
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.save_monery_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        Spanned fromHtml = Html.fromHtml("<b><big><big><big><font color=#4D230A> \u8d2d\u7269\u7701\u94b1\u795e\u5668</font></big></big></big></b><font color=#90713A>  \u4f53\u9a8c\u673a\u4f1a</font>");
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        f6106b = textView;
        textView.setText(fromHtml);
        ((TextView) inflate.findViewById(R.id.tv_content2)).setText("\u81ea\u52a8\u53d1\u73b0\u9690\u85cf\u4f18\u60e0\u5238,\u6dd8\u5b9d\u3001\u4eac\u4e1c\u6700\u9ad8\u770180%!");
        f6107c = (TextView) inflate.findViewById(R.id.iv_dismiss);
        inflate.findViewById(R.id.rl_content).setOnClickListener(new a(activity, onClickCallBack));
        l0.a().b(11000, 1000, new b(activity, onClickCallBack));
        inflate.findViewById(R.id.tv_open).setOnClickListener(new c(activity, onClickCallBack));
        AlertDialog create = builder.create();
        f6105a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f6105a);
        return f6105a;
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

    public static void a(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || !dialog.isShowing()) {
                return;
            }
            dialog.dismiss();
        } catch (Exception unused) {
        }
    }
}
