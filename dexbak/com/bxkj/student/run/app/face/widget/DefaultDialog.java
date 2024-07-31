package com.bxkj.student.run.app.face.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bxkj.student.C4215R;

/* renamed from: com.bxkj.student.run.app.face.widget.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class DefaultDialog extends Dialog {

    /* compiled from: DefaultDialog.java */
    /* renamed from: com.bxkj.student.run.app.face.widget.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C5237a {

        /* renamed from: a */
        private Context f19121a;

        /* renamed from: b */
        private String f19122b;

        /* renamed from: c */
        private String f19123c;

        /* renamed from: d */
        private String f19124d;

        /* renamed from: e */
        private DialogInterface.OnClickListener f19125e;

        /* compiled from: DefaultDialog.java */
        /* renamed from: com.bxkj.student.run.app.face.widget.a$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC5238a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ DefaultDialog f19126a;

            View$OnClickListenerC5238a(final DefaultDialog val$dialog) {
                this.f19126a = val$dialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C5237a.this.f19125e.onClick(this.f19126a, -2);
            }
        }

        public C5237a(Context context) {
            this.f19121a = context;
        }

        /* renamed from: b */
        public DefaultDialog m40027b() {
            DefaultDialog defaultDialog = new DefaultDialog(this.f19121a, 2131886331);
            View inflate = ((LayoutInflater) this.f19121a.getSystemService("layout_inflater")).inflate(C4215R.C4221layout.widget_face_dialog, (ViewGroup) null);
            defaultDialog.addContentView(inflate, new ViewGroup.LayoutParams(-2, -2));
            ((TextView) inflate.findViewById(C4215R.C4219id.dialog_title)).setText(this.f19122b);
            if (this.f19124d != null) {
                ((TextView) inflate.findViewById(2131231200)).setText(this.f19124d);
                if (this.f19125e != null) {
                    inflate.findViewById(2131231200).setOnClickListener(new View$OnClickListenerC5238a(defaultDialog));
                }
            } else {
                inflate.findViewById(2131231200).setVisibility(8);
            }
            if (this.f19123c != null) {
                ((TextView) inflate.findViewById(C4215R.C4219id.dialog_message)).setText(this.f19123c);
            }
            defaultDialog.setContentView(inflate);
            return defaultDialog;
        }

        /* renamed from: c */
        public C5237a m40026c(int message) {
            this.f19123c = (String) this.f19121a.getText(message);
            return this;
        }

        /* renamed from: d */
        public C5237a m40025d(String message) {
            this.f19123c = message;
            return this;
        }

        /* renamed from: e */
        public C5237a m40024e(int negativeButtonText, DialogInterface.OnClickListener listener) {
            this.f19124d = (String) this.f19121a.getText(negativeButtonText);
            this.f19125e = listener;
            return this;
        }

        /* renamed from: f */
        public C5237a m40023f(String negativeButtonText, DialogInterface.OnClickListener listener) {
            this.f19124d = negativeButtonText;
            this.f19125e = listener;
            return this;
        }

        /* renamed from: g */
        public C5237a m40022g(int title) {
            this.f19122b = (String) this.f19121a.getText(title);
            return this;
        }

        /* renamed from: h */
        public C5237a m40021h(String title) {
            this.f19122b = title;
            return this;
        }
    }

    public DefaultDialog(Context context) {
        super(context);
    }

    public DefaultDialog(Context context, int theme) {
        super(context, theme);
    }
}
