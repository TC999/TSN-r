package com.bxkj.student.run.app.face.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DefaultDialog.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a extends Dialog {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DefaultDialog.java */
    /* renamed from: com.bxkj.student.run.app.face.widget.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class C0278a {

        /* renamed from: a  reason: collision with root package name */
        private Context f22367a;

        /* renamed from: b  reason: collision with root package name */
        private String f22368b;

        /* renamed from: c  reason: collision with root package name */
        private String f22369c;

        /* renamed from: d  reason: collision with root package name */
        private String f22370d;

        /* renamed from: e  reason: collision with root package name */
        private DialogInterface.OnClickListener f22371e;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: DefaultDialog.java */
        /* renamed from: com.bxkj.student.run.app.face.widget.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class View$OnClickListenerC0279a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f22372a;

            View$OnClickListenerC0279a(final a val$dialog) {
                this.f22372a = val$dialog;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                C0278a.this.f22371e.onClick(this.f22372a, -2);
            }
        }

        public C0278a(Context context) {
            this.f22367a = context;
        }

        public a b() {
            a aVar = new a(this.f22367a, 2131886331);
            View inflate = ((LayoutInflater) this.f22367a.getSystemService("layout_inflater")).inflate(2131428123, (ViewGroup) null);
            aVar.addContentView(inflate, new ViewGroup.LayoutParams(-2, -2));
            ((TextView) inflate.findViewById(2131231203)).setText(this.f22368b);
            if (this.f22370d != null) {
                ((TextView) inflate.findViewById(2131231200)).setText(this.f22370d);
                if (this.f22371e != null) {
                    inflate.findViewById(2131231200).setOnClickListener(new View$OnClickListenerC0279a(aVar));
                }
            } else {
                inflate.findViewById(2131231200).setVisibility(8);
            }
            if (this.f22369c != null) {
                ((TextView) inflate.findViewById(2131231202)).setText(this.f22369c);
            }
            aVar.setContentView(inflate);
            return aVar;
        }

        public C0278a c(int message) {
            this.f22369c = (String) this.f22367a.getText(message);
            return this;
        }

        public C0278a d(String message) {
            this.f22369c = message;
            return this;
        }

        public C0278a e(int negativeButtonText, DialogInterface.OnClickListener listener) {
            this.f22370d = (String) this.f22367a.getText(negativeButtonText);
            this.f22371e = listener;
            return this;
        }

        public C0278a f(String negativeButtonText, DialogInterface.OnClickListener listener) {
            this.f22370d = negativeButtonText;
            this.f22371e = listener;
            return this;
        }

        public C0278a g(int title) {
            this.f22368b = (String) this.f22367a.getText(title);
            return this;
        }

        public C0278a h(String title) {
            this.f22368b = title;
            return this;
        }
    }

    public a(Context context) {
        super(context);
    }

    public a(Context context, int theme) {
        super(context, theme);
    }
}
