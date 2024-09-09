package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static AlertDialog f6643a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6644a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f6645b;

        public a(Activity activity, c cVar) {
            this.f6644a = activity;
            this.f6645b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u0.a(this.f6644a, u0.f6643a);
            this.f6645b.b();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f6647b;

        public b(Activity activity, c cVar) {
            this.f6646a = activity;
            this.f6647b = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u0.a(this.f6646a, u0.f6643a);
            this.f6647b.a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface c {
        void a();

        void b();
    }

    public static void b(Activity activity, Dialog dialog) {
        try {
            if (activity.isFinishing() || dialog == null || dialog.isShowing()) {
                return;
            }
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        } catch (Exception e4) {
            z1.a("samop", "error =" + e4.getMessage());
        }
    }

    public static AlertDialog a(Activity activity, String str, String str2, String str3, boolean z3, c cVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dialog_single_green_button_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_content);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_button2);
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_version_info);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_dissmiss);
        if (str == null) {
            textView.setVisibility(8);
            imageView.setVisibility(8);
            textView3.setGravity(1);
        } else {
            textView.setText(str);
        }
        textView3.setText(str2);
        textView2.setText(str3);
        g0.a().a(activity, textView2);
        textView2.setOnClickListener(new a(activity, cVar));
        imageView.setOnClickListener(new b(activity, cVar));
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f6643a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f6643a);
        return f6643a;
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
