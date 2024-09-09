package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.adhost.R;
import com.ss.android.downloadlib.addownload.compliance.sr;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.guide.install.ClipImageView;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private final com.ss.android.downloadlib.addownload.w.w f48431a;

    /* renamed from: c  reason: collision with root package name */
    private TextView f48432c;
    private LinearLayout ev;

    /* renamed from: f  reason: collision with root package name */
    private TextView f48433f;
    private Activity gd;

    /* renamed from: k  reason: collision with root package name */
    private long f48434k;

    /* renamed from: p  reason: collision with root package name */
    private final long f48435p;

    /* renamed from: r  reason: collision with root package name */
    private ClipImageView f48436r;
    private TextView sr;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    private TextView f48437w;
    private TextView xv;

    public c(@NonNull Activity activity, long j4) {
        super(activity);
        this.gd = activity;
        this.f48435p = j4;
        this.f48431a = xv.c().get(Long.valueOf(j4));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.xv.c(this.gd);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f48431a == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(R.layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(R.drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f48434k = this.f48431a.f48727w;
        c();
        r.w("lp_app_dialog_show", this.f48434k);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.c.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                r.c("lp_app_dialog_cancel", c.this.f48434k);
            }
        });
    }

    private void c() {
        this.f48432c = (TextView) findViewById(R.id.tv_app_name);
        this.f48437w = (TextView) findViewById(R.id.tv_app_version);
        this.xv = (TextView) findViewById(R.id.tv_app_developer);
        this.sr = (TextView) findViewById(R.id.tv_app_detail);
        this.ux = (TextView) findViewById(R.id.tv_app_privacy);
        this.f48433f = (TextView) findViewById(R.id.tv_give_up);
        this.f48436r = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.ev = (LinearLayout) findViewById(R.id.ll_download);
        this.f48432c.setText(com.ss.android.downloadlib.r.a.c(this.f48431a.ux, "--"));
        TextView textView = this.f48437w;
        textView.setText("\u7248\u672c\u53f7\uff1a" + com.ss.android.downloadlib.r.a.c(this.f48431a.f48725f, "--"));
        TextView textView2 = this.xv;
        textView2.setText("\u5f00\u53d1\u8005\uff1a" + com.ss.android.downloadlib.r.a.c(this.f48431a.f48726r, "\u5e94\u7528\u4fe1\u606f\u6b63\u5728\u5b8c\u5584\u4e2d"));
        this.f48436r.setRoundRadius(com.ss.android.downloadlib.r.a.c(k.getContext(), 8.0f));
        this.f48436r.setBackgroundColor(Color.parseColor("#EBEBEB"));
        sr.c().c(this.f48435p, new sr.c() { // from class: com.ss.android.downloadlib.addownload.compliance.c.2
            @Override // com.ss.android.downloadlib.addownload.compliance.sr.c
            public void c(Bitmap bitmap) {
                if (bitmap != null) {
                    c.this.f48436r.setImageBitmap(bitmap);
                } else {
                    r.c(8, c.this.f48434k);
                }
            }
        });
        this.sr.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                w.c().c(c.this.gd);
                AppDetailInfoActivity.c(c.this.gd, c.this.f48435p);
                r.c("lp_app_dialog_click_detail", c.this.f48434k);
            }
        });
        this.ux.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                w.c().c(c.this.gd);
                AppPrivacyPolicyActivity.c(c.this.gd, c.this.f48435p);
                r.c("lp_app_dialog_click_privacy", c.this.f48434k);
            }
        });
        this.f48433f.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.dismiss();
                r.c("lp_app_dialog_click_giveup", c.this.f48434k);
            }
        });
        this.ev.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                r.c("lp_app_dialog_click_download", c.this.f48434k);
                w.c().w(c.this.f48434k);
                c.this.dismiss();
            }
        });
    }
}
