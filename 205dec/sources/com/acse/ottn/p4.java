package com.acse.ottn;

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
import com.acse.ottn.activity.AcseHelpManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class p4 {

    /* renamed from: a  reason: collision with root package name */
    public static AlertDialog f6135a;

    /* renamed from: b  reason: collision with root package name */
    public static ImageView f6136b;

    /* renamed from: c  reason: collision with root package name */
    public static ImageView f6137c;

    /* renamed from: d  reason: collision with root package name */
    public static TextView f6138d;

    /* renamed from: e  reason: collision with root package name */
    public static TextView f6139e;

    /* renamed from: f  reason: collision with root package name */
    public static TextView f6140f;

    /* renamed from: g  reason: collision with root package name */
    public static TextView f6141g;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6142a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f6143b;

        public a(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f6142a = onClickCallBack;
            this.f6143b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (p4.f6139e.getVisibility() == 0) {
                AcseHelpManager.OnClickCallBack onClickCallBack = this.f6142a;
                if (onClickCallBack != null) {
                    onClickCallBack.onDismiss();
                }
            } else {
                AcseHelpManager.OnClickCallBack onClickCallBack2 = this.f6142a;
                if (onClickCallBack2 != null) {
                    onClickCallBack2.onOpen();
                }
            }
            p4.a(this.f6143b, p4.f6135a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6144a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f6145b;

        public b(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f6144a = onClickCallBack;
            this.f6145b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i2.a().a("warning_start_run");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f6144a;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
            p4.a(this.f6145b, p4.f6135a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6146a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f6147b;

        public c(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f6146a = onClickCallBack;
            this.f6147b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f6146a;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
            p4.a(this.f6147b, p4.f6135a);
        }
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return b(activity, null, null, null, null, onClickCallBack);
    }

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.warning_dialog, (ViewGroup) null);
        f6136b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f6138d = (TextView) inflate.findViewById(R.id.tv_button);
        f6139e = (TextView) inflate.findViewById(R.id.tv_but2);
        f6137c = (ImageView) inflate.findViewById(R.id.iv_icon);
        f6140f = (TextView) inflate.findViewById(R.id.tv_content);
        f6141g = (TextView) inflate.findViewById(R.id.tv_version_info);
        f6139e.setVisibility(0);
        f6138d.setTextColor(Color.parseColor("#999999"));
        f6138d.setBackground(null);
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            f6139e.setText(str3);
            f6138d.setText(str4);
            f6140f.setText(str2);
            f6141g.setText(str);
        } else {
            f6141g.setText(activity.getString(R.string.warning_dialog_title));
            f6140f.setText(activity.getString(R.string.warning_message));
            f6138d.setText(activity.getString(R.string.warning_commit));
            f6139e.setText(activity.getString(R.string.warning_cancle));
        }
        g0.a().a(activity, f6139e);
        g0.a().b(activity, f6137c);
        f6138d.setOnClickListener(new a(onClickCallBack, activity));
        f6139e.setOnClickListener(new b(onClickCallBack, activity));
        f6136b.setOnClickListener(new c(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f6135a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f6135a);
        return f6135a;
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
