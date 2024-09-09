package com.acse.ottn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.acse.ottn.activity.SeedWebViewActivity;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class v3 {

    /* renamed from: a  reason: collision with root package name */
    public static AlertDialog f6913a;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f6914a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f6915b;

        public a(e eVar, Activity activity) {
            this.f6914a = eVar;
            this.f6915b = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f6914a.onOpen();
            v3.a(this.f6915b, v3.f6913a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6916a;

        public b(Activity activity) {
            this.f6916a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v3.a(this.f6916a, v3.f6913a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6917a;

        public c(Activity activity) {
            this.f6917a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f6917a, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().b(this.f6917a));
            this.f6917a.startActivity(intent);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f6918a;

        public d(Activity activity) {
            this.f6918a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(this.f6918a, SeedWebViewActivity.class);
            intent.putExtra("url", g0.a().d(this.f6918a));
            this.f6918a.startActivity(intent);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface e {
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

    public static AlertDialog a(Activity activity, e eVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.main_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.AlertDialogCustom);
        builder.setView(inflate);
        builder.setCancelable(true);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_but2);
        textView.setOnClickListener(new a(eVar, activity));
        ((TextView) inflate.findViewById(R.id.tv_button)).setOnClickListener(new b(activity));
        ((TextView) inflate.findViewById(R.id.title)).setText("\u8bf7\u5148\u540c\u610f" + j0.f5760b);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_privacy);
        textView2.setOnClickListener(new c(activity));
        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_service);
        textView3.setOnClickListener(new d(activity));
        g0.a().c(activity, textView3);
        g0.a().c(activity, textView2);
        g0.a().c(activity, textView);
        AlertDialog create = builder.create();
        f6913a = create;
        create.getWindow().setBackgroundDrawableResource(17170445);
        b(activity, f6913a);
        return f6913a;
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
