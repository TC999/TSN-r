package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends AlertDialog {

    /* renamed from: c  reason: collision with root package name */
    private TextView f35434c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f35435f;
    private String gd;

    /* renamed from: k  reason: collision with root package name */
    private c f35436k;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f35437p;

    /* renamed from: r  reason: collision with root package name */
    private String f35438r;
    private Button sr;
    private Context ux;

    /* renamed from: w  reason: collision with root package name */
    private TextView f35439w;
    private Button xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);

        void w(Dialog dialog);
    }

    public k(Context context) {
        super(context, i.ux(context, "tt_custom_dialog"));
        this.ux = context;
    }

    private void w() {
        TextView textView = this.f35434c;
        if (textView != null) {
            textView.setText(this.f35435f);
            Drawable drawable = this.f35437p;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = this.f35437p.getIntrinsicHeight();
                int ux = xk.ux(this.ux, 45.0f);
                if (intrinsicWidth > ux || intrinsicWidth < ux) {
                    intrinsicWidth = ux;
                }
                if (intrinsicHeight > ux || intrinsicHeight < ux) {
                    intrinsicHeight = ux;
                }
                this.f35437p.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.f35434c.setCompoundDrawables(this.f35437p, null, null, null);
                this.f35434c.setCompoundDrawablePadding(xk.ux(this.ux, 10.0f));
            }
        }
        TextView textView2 = this.f35439w;
        if (textView2 != null) {
            textView2.setText(this.f35438r);
        }
        Button button = this.xv;
        if (button != null) {
            button.setText(this.ev);
        }
        Button button2 = this.sr;
        if (button2 != null) {
            button2.setText(this.gd);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.bytedance.sdk.openadsdk.res.ux.ok(this.ux));
        setCanceledOnTouchOutside(true);
        c();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        w();
    }

    public k sr(String str) {
        this.gd = str;
        return this;
    }

    public k xv(String str) {
        this.ev = str;
        return this;
    }

    private void c() {
        this.f35434c = (TextView) findViewById(2114387855);
        this.f35439w = (TextView) findViewById(2114387653);
        this.xv = (Button) findViewById(2114387753);
        this.sr = (Button) findViewById(2114387893);
        this.xv.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.k.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dismiss();
                if (k.this.f35436k != null) {
                    k.this.f35436k.c(k.this);
                }
            }
        });
        this.sr.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.k.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                k.this.dismiss();
                if (k.this.f35436k != null) {
                    k.this.f35436k.w(k.this);
                }
            }
        });
    }

    public k c(String str) {
        this.f35435f = str;
        return this;
    }

    public k c(Drawable drawable) {
        this.f35437p = drawable;
        return this;
    }

    public k c(c cVar) {
        this.f35436k = cVar;
        return this;
    }

    public k c(DialogInterface.OnCancelListener onCancelListener) {
        setOnCancelListener(onCancelListener);
        return this;
    }

    public k w(String str) {
        this.f35438r = str;
        return this;
    }
}
