package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f35456a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    TTProgressBar f35457c;
    private Button ev;

    /* renamed from: f  reason: collision with root package name */
    private TextView f35458f;
    private String fp;
    private boolean fz;
    private Button gd;
    private int ia;

    /* renamed from: k  reason: collision with root package name */
    private ViewGroup f35459k;

    /* renamed from: p  reason: collision with root package name */
    private View f35460p;

    /* renamed from: r  reason: collision with root package name */
    private Button f35461r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f35462s;
    private ImageView sr;

    /* renamed from: t  reason: collision with root package name */
    private String f35463t;

    /* renamed from: u  reason: collision with root package name */
    private View f35464u;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    public c f35465w;
    public View.OnClickListener xv;
    private String ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void w();
    }

    public r(Context context) {
        super(context);
        this.ia = -1;
        this.fz = false;
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f35456a = context;
    }

    private void sr() {
        this.f35461r = (Button) findViewById(2114387832);
        this.ev = (Button) findViewById(2114387919);
        this.ux = (TextView) findViewById(2114387804);
        this.f35458f = (TextView) findViewById(2114387860);
        this.sr = (ImageView) findViewById(2114387835);
        this.f35460p = findViewById(2114387777);
        this.f35459k = (ViewGroup) findViewById(2114387852);
        this.gd = (Button) findViewById(2114387751);
    }

    private void w() {
        xk.c(this.ev, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.r.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = r.this.f35465w;
                if (cVar != null) {
                    cVar.c();
                }
            }
        }, "positiveBn");
        xk.c(this.f35461r, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.r.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c cVar = r.this.f35465w;
                if (cVar != null) {
                    cVar.w();
                }
            }
        }, "negtiveBn");
        xk.c(this.gd, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.r.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                View.OnClickListener onClickListener = r.this.xv;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
            }
        }, "dialog_change_btn");
    }

    private void xv() {
        Button button;
        if (this.ux != null) {
            if (!TextUtils.isEmpty(this.f35463t)) {
                this.ux.setText(this.f35463t);
                this.ux.setVisibility(0);
            } else {
                this.ux.setVisibility(8);
            }
        }
        if (this.f35458f != null && !TextUtils.isEmpty(this.bk)) {
            this.f35458f.setText(this.bk);
        }
        if (this.ev != null) {
            if (!TextUtils.isEmpty(this.ys)) {
                this.ev.setText(this.ys);
            } else {
                this.ev.setText("\u786e\u5b9a");
            }
            int i4 = this.ia;
            if (i4 != -1) {
                this.ev.setBackgroundColor(i4);
            }
        }
        if (this.f35461r != null) {
            if (!TextUtils.isEmpty(this.fp)) {
                this.f35461r.setText(this.fp);
            } else {
                this.f35461r.setText("\u53d6\u6d88");
            }
        }
        ImageView imageView = this.sr;
        if (imageView != null) {
            Drawable drawable = this.f35462s;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                this.sr.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        View view = this.f35460p;
        if (view == null || (button = this.f35461r) == null) {
            return;
        }
        if (this.fz) {
            view.setVisibility(8);
            this.f35461r.setVisibility(8);
            return;
        }
        button.setVisibility(0);
        View view2 = this.f35460p;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public r c(c cVar) {
        this.f35465w = cVar;
        return this;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(false);
        View view = this.f35464u;
        if (view == null) {
            view = com.bytedance.sdk.openadsdk.res.ux.h(this.f35456a);
        }
        setContentView(view);
        sr();
        xv();
        w();
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            xv();
        } catch (Exception unused) {
        }
    }

    public r c(View.OnClickListener onClickListener) {
        this.xv = onClickListener;
        return this;
    }

    public r c(String str) {
        this.bk = str;
        return this;
    }

    public r c(int i4) {
        this.ia = i4;
        return this;
    }

    public r w(String str) {
        this.f35463t = str;
        return this;
    }

    public r c(Drawable drawable) {
        this.f35462s = drawable;
        return this;
    }

    public r c(View view) {
        this.f35464u = view;
        return this;
    }

    public void c(TTProgressBar tTProgressBar) {
        ViewGroup viewGroup = this.f35459k;
        if (viewGroup == null) {
            return;
        }
        if (this.f35457c == null) {
            this.f35457c = tTProgressBar;
            viewGroup.addView(tTProgressBar);
        }
        this.f35459k.setVisibility(0);
    }

    public r sr(String str) {
        this.fp = str;
        return this;
    }

    public void c() {
        ViewGroup viewGroup = this.f35459k;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public r xv(String str) {
        this.ys = str;
        return this;
    }
}
