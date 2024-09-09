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
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static AlertDialog f5303b;

    /* renamed from: c  reason: collision with root package name */
    public static ImageView f5304c;

    /* renamed from: d  reason: collision with root package name */
    public static TextView f5305d;

    /* renamed from: e  reason: collision with root package name */
    public static TextView f5306e;

    /* renamed from: f  reason: collision with root package name */
    public static TextView f5307f;

    /* renamed from: a  reason: collision with root package name */
    public d f5308a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f5309a;

        public a(Activity activity) {
            this.f5309a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a(this.f5309a, c.f5303b);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f5310a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f5311b;

        public b(Activity activity, d dVar) {
            this.f5310a = activity;
            this.f5311b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a(this.f5310a, c.f5303b);
            d dVar = this.f5311b;
            if (dVar != null) {
                dVar.onDismiss();
            }
        }
    }

    /* renamed from: com.acse.ottn.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class View$OnClickListenerC0086c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f5313a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f5314b;

        public View$OnClickListenerC0086c(Activity activity, d dVar) {
            this.f5313a = activity;
            this.f5314b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.a(this.f5313a, c.f5303b);
            d dVar = this.f5314b;
            if (dVar != null) {
                dVar.onOpen();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface d {
        void onDismiss();

        void onOpen();
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

    public static AlertDialog a(Activity activity, String str, d dVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.accessiblity_seeding_green_fragment_dialog, (ViewGroup) null);
        f5304c = (ImageView) inflate.findViewById(R.id.iv_dissmiss);
        f5306e = (TextView) inflate.findViewById(R.id.tv_button);
        f5307f = (TextView) inflate.findViewById(R.id.tv_but2);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_version_info);
        f5305d = textView;
        textView.setText(str + "\u1f62d");
        f5304c.setOnClickListener(new a(activity));
        f5306e.setOnClickListener(new b(activity, dVar));
        f5307f.setOnClickListener(new View$OnClickListenerC0086c(activity, dVar));
        g0.a().a(activity, f5307f);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        f5303b = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f5303b);
        return f5303b;
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
