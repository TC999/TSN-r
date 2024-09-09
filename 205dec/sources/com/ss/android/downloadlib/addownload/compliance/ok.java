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
import com.bytedance.sdk.openadsdk.R;
import com.ss.android.downloadlib.addownload.compliance.s;
import com.ss.android.downloadlib.guide.install.ClipImageView;
import com.ss.android.downloadlib.h.j;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f48479a;
    private TextView bl;

    /* renamed from: h  reason: collision with root package name */
    private ClipImageView f48480h;

    /* renamed from: j  reason: collision with root package name */
    private final com.ss.android.downloadlib.addownload.a.a f48481j;

    /* renamed from: k  reason: collision with root package name */
    private final long f48482k;
    private TextView kf;

    /* renamed from: n  reason: collision with root package name */
    private TextView f48483n;
    private TextView ok;

    /* renamed from: p  reason: collision with root package name */
    private LinearLayout f48484p;

    /* renamed from: q  reason: collision with root package name */
    private Activity f48485q;

    /* renamed from: r  reason: collision with root package name */
    private long f48486r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f48487s;

    public ok(@NonNull Activity activity, long j4) {
        super(activity);
        this.f48485q = activity;
        this.f48482k = j4;
        this.f48481j = bl.ok().get(Long.valueOf(j4));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        com.ss.android.socialbase.appdownloader.bl.ok(this.f48485q);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f48481j == null) {
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
        this.f48486r = this.f48481j.f48355a;
        ok();
        h.a("lp_app_dialog_show", this.f48486r);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                h.ok("lp_app_dialog_cancel", ok.this.f48486r);
            }
        });
    }

    private void ok() {
        this.ok = (TextView) findViewById(R.id.tv_app_name);
        this.f48479a = (TextView) findViewById(R.id.tv_app_version);
        this.bl = (TextView) findViewById(R.id.tv_app_developer);
        this.f48487s = (TextView) findViewById(R.id.tv_app_detail);
        this.f48483n = (TextView) findViewById(R.id.tv_app_privacy);
        this.kf = (TextView) findViewById(R.id.tv_give_up);
        this.f48480h = (ClipImageView) findViewById(R.id.iv_app_icon);
        this.f48484p = (LinearLayout) findViewById(R.id.ll_download);
        this.ok.setText(j.ok(this.f48481j.f48357n, "--"));
        TextView textView = this.f48479a;
        textView.setText("\u7248\u672c\u53f7\uff1a" + j.ok(this.f48481j.kf, "--"));
        TextView textView2 = this.bl;
        textView2.setText("\u5f00\u53d1\u8005\uff1a" + j.ok(this.f48481j.f48356h, "\u5e94\u7528\u4fe1\u606f\u6b63\u5728\u5b8c\u5584\u4e2d"));
        this.f48480h.setRoundRadius(j.ok(com.ss.android.downloadlib.addownload.r.getContext(), 8.0f));
        this.f48480h.setBackgroundColor(Color.parseColor("#EBEBEB"));
        s.ok().ok(this.f48482k, new s.ok() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.2
            @Override // com.ss.android.downloadlib.addownload.compliance.s.ok
            public void ok(Bitmap bitmap) {
                if (bitmap != null) {
                    ok.this.f48480h.setImageBitmap(bitmap);
                } else {
                    h.ok(8, ok.this.f48486r);
                }
            }
        });
        this.f48487s.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.ok().ok(ok.this.f48485q);
                AppDetailInfoActivity.ok(ok.this.f48485q, ok.this.f48482k);
                h.ok("lp_app_dialog_click_detail", ok.this.f48486r);
            }
        });
        this.f48483n.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.ok().ok(ok.this.f48485q);
                AppPrivacyPolicyActivity.ok(ok.this.f48485q, ok.this.f48482k);
                h.ok("lp_app_dialog_click_privacy", ok.this.f48486r);
            }
        });
        this.kf.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ok.this.dismiss();
                h.ok("lp_app_dialog_click_giveup", ok.this.f48486r);
            }
        });
        this.f48484p.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_dialog_click_download", ok.this.f48486r);
                a.ok().a(ok.this.f48486r);
                ok.this.dismiss();
            }
        });
    }
}
