package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    public static AlertDialog f6041a;

    /* renamed from: b  reason: collision with root package name */
    public static ImageView f6042b;

    /* renamed from: c  reason: collision with root package name */
    public static TextView f6043c;

    /* renamed from: d  reason: collision with root package name */
    public static TextView f6044d;

    /* renamed from: e  reason: collision with root package name */
    public static TextView f6045e;

    /* renamed from: f  reason: collision with root package name */
    public static TextView f6046f;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6047a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6049c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6050d;

        public a(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f6047a = activity;
            this.f6048b = str;
            this.f6049c = str2;
            this.f6050d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n0.a(this.f6047a, n0.f6041a);
            i2 a4 = i2.a();
            a4.a(this.f6048b + "_" + this.f6049c + "_close");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f6050d;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6051a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6052b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6053c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6054d;

        public b(Activity activity, String str, String str2, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f6051a = activity;
            this.f6052b = str;
            this.f6053c = str2;
            this.f6054d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            n0.a(this.f6051a, n0.f6041a);
            i2 a4 = i2.a();
            a4.a(this.f6052b + "_" + this.f6053c + "_open");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f6054d;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6055a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6056b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f6057c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f6058d;

        public c(String str, String str2, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f6055a = str;
            this.f6056b = str2;
            this.f6057c = activity;
            this.f6058d = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i2 a4 = i2.a();
            a4.a(this.f6055a + "_" + this.f6056b + "_dismiss");
            n0.a(this.f6057c, n0.f6041a);
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f6058d;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
        }
    }

    public static AlertDialog b(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.custon_dialog, (ViewGroup) null);
        f6042b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f6043c = (TextView) inflate.findViewById(R.id.tv_button);
        f6044d = (TextView) inflate.findViewById(R.id.tv_but2);
        f6045e = (TextView) inflate.findViewById(R.id.tv_content);
        f6046f = (TextView) inflate.findViewById(R.id.tv_version_info);
        if (!TextUtils.isEmpty(str3)) {
            f6044d.setText(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            f6043c.setText(str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            f6045e.setText(str2);
        }
        if (!TextUtils.isEmpty(str)) {
            f6046f.setText(str);
        }
        g0.a().a(activity, f6044d);
        f6043c.setOnClickListener(new a(activity, str3, str4, onClickCallBack));
        f6044d.setOnClickListener(new b(activity, str3, str4, onClickCallBack));
        f6042b.setOnClickListener(new c(str3, str4, activity, onClickCallBack));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f6041a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f6041a);
        return f6041a;
    }

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
