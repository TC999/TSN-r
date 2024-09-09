package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.AcseHelpManager;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class m3 {

    /* renamed from: a  reason: collision with root package name */
    public static AlertDialog f5933a;

    /* renamed from: b  reason: collision with root package name */
    public static ImageView f5934b;

    /* renamed from: c  reason: collision with root package name */
    public static TextView f5935c;

    /* renamed from: d  reason: collision with root package name */
    public static TextView f5936d;

    /* renamed from: e  reason: collision with root package name */
    public static ImageView f5937e;

    /* renamed from: f  reason: collision with root package name */
    public static ImageView f5938f;

    /* renamed from: g  reason: collision with root package name */
    public static RelativeLayout f5939g;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5940a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f5941b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5942c;

        public a(boolean z3, Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
            this.f5940a = z3;
            this.f5941b = activity;
            this.f5942c = onClickCallBack;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f5940a) {
                try {
                    m3.f5933a.dismiss();
                } catch (Exception unused) {
                }
                p4.a(this.f5941b, this.f5942c);
                return;
            }
            i2.a().a("not_now");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5942c;
            if (onClickCallBack != null) {
                onClickCallBack.onDismiss();
            }
            try {
                m3.f5933a.dismiss();
            } catch (Exception unused2) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5943a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f5944b;

        public b(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f5943a = onClickCallBack;
            this.f5944b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i2.a().a("not_now");
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5943a;
            if (onClickCallBack != null) {
                onClickCallBack.onClose();
            }
            m3.a(this.f5944b, m3.f5933a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnClickCallBack f5945a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f5946b;

        public c(AcseHelpManager.OnClickCallBack onClickCallBack, Activity activity) {
            this.f5945a = onClickCallBack;
            this.f5946b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AcseHelpManager.OnClickCallBack onClickCallBack = this.f5945a;
            if (onClickCallBack != null) {
                onClickCallBack.onOpen();
            }
            m3.a(this.f5946b, m3.f5933a);
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

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, str, str2, str3, str4, false, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, false, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, boolean z3, AcseHelpManager.OnClickCallBack onClickCallBack) {
        return a(activity, null, null, null, null, z3, onClickCallBack);
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, String str4, boolean z3, AcseHelpManager.OnClickCallBack onClickCallBack) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.seeding_running_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_version_info);
        if (!TextUtils.isEmpty(str)) {
            textView.setText(str);
        } else {
            textView.setText(activity.getString(R.string.invite_title));
        }
        f5934b = (ImageView) inflate.findViewById(R.id.iv_dismiss);
        f5936d = (TextView) inflate.findViewById(R.id.tv_but2);
        if (!TextUtils.isEmpty(str3)) {
            f5936d.setText(str3);
        } else {
            f5936d.setText(activity.getString(R.string.invite_commit));
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
        f5937e = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        f5935c = (TextView) inflate.findViewById(R.id.tv_button);
        f5938f = (ImageView) inflate.findViewById(R.id.iv_icon1);
        f5939g = (RelativeLayout) inflate.findViewById(R.id.rl_bg);
        if (!TextUtils.isEmpty(str4)) {
            f5935c.setText(str4);
        } else {
            f5935c.setText(activity.getString(R.string.invite_cancle));
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_content);
        if (!TextUtils.isEmpty(str2)) {
            textView2.setText(str2);
        } else {
            textView2.setText(activity.getString(R.string.invite_message));
        }
        g0.a().b(activity, f5935c);
        g0.a().a(activity, f5936d);
        g0.a().a(activity, f5937e, f5938f);
        g0.a().a(activity, textView, f5939g);
        f5935c.setOnClickListener(new a(z3, activity, onClickCallBack));
        f5934b.setOnClickListener(new b(onClickCallBack, activity));
        f5936d.setOnClickListener(new c(onClickCallBack, activity));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5933a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5933a);
        return f5933a;
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
