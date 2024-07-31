package com.p521ss.android.downloadlib.addownload.compliance;

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
import com.bytedance.sdk.openadsdk.C6266R;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.compliance.C12084s;
import com.p521ss.android.downloadlib.addownload.p528a.C12029a;
import com.p521ss.android.downloadlib.guide.install.ClipImageView;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.socialbase.appdownloader.C12293bl;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DialogC12076ok extends Dialog {

    /* renamed from: a */
    private TextView f34191a;

    /* renamed from: bl */
    private TextView f34192bl;

    /* renamed from: h */
    private ClipImageView f34193h;

    /* renamed from: j */
    private final C12029a f34194j;

    /* renamed from: k */
    private final long f34195k;

    /* renamed from: kf */
    private TextView f34196kf;

    /* renamed from: n */
    private TextView f34197n;

    /* renamed from: ok */
    private TextView f34198ok;

    /* renamed from: p */
    private LinearLayout f34199p;

    /* renamed from: q */
    private Activity f34200q;

    /* renamed from: r */
    private long f34201r;

    /* renamed from: s */
    private TextView f34202s;

    public DialogC12076ok(@NonNull Activity activity, long j) {
        super(activity);
        this.f34200q = activity;
        this.f34195k = j;
        this.f34194j = C12063bl.m19218ok().get(Long.valueOf(j));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        C12293bl.m18426ok(this.f34200q);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f34194j == null) {
            dismiss();
            return;
        }
        requestWindowFeature(1);
        setContentView(C6266R.C6270layout.ttdownloader_dialog_appinfo);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(C6266R.C6268drawable.ttdownloader_bg_transparent);
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.f34201r = this.f34194j.f34048a;
        m19133ok();
        C12066h.m19213a("lp_app_dialog_show", this.f34201r);
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                C12066h.m19210ok("lp_app_dialog_cancel", DialogC12076ok.this.f34201r);
            }
        });
    }

    /* renamed from: ok */
    private void m19133ok() {
        this.f34198ok = (TextView) findViewById(C6266R.C6269id.tv_app_name);
        this.f34191a = (TextView) findViewById(C6266R.C6269id.tv_app_version);
        this.f34192bl = (TextView) findViewById(C6266R.C6269id.tv_app_developer);
        this.f34202s = (TextView) findViewById(C6266R.C6269id.tv_app_detail);
        this.f34197n = (TextView) findViewById(C6266R.C6269id.tv_app_privacy);
        this.f34196kf = (TextView) findViewById(C6266R.C6269id.tv_give_up);
        this.f34193h = (ClipImageView) findViewById(C6266R.C6269id.iv_app_icon);
        this.f34199p = (LinearLayout) findViewById(C6266R.C6269id.ll_download);
        this.f34198ok.setText(C12197j.m18774ok(this.f34194j.f34052n, "--"));
        TextView textView = this.f34191a;
        textView.setText("版本号：" + C12197j.m18774ok(this.f34194j.f34051kf, "--"));
        TextView textView2 = this.f34192bl;
        textView2.setText("开发者：" + C12197j.m18774ok(this.f34194j.f34050h, "应用信息正在完善中"));
        this.f34193h.setRoundRadius(C12197j.m18792ok(C12128r.getContext(), 8.0f));
        this.f34193h.setBackgroundColor(Color.parseColor("#EBEBEB"));
        C12084s.m19129ok().m19126ok(this.f34195k, new C12084s.InterfaceC12088ok() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.2
            @Override // com.p521ss.android.downloadlib.addownload.compliance.C12084s.InterfaceC12088ok
            /* renamed from: ok */
            public void mo19123ok(Bitmap bitmap) {
                if (bitmap != null) {
                    DialogC12076ok.this.f34193h.setImageBitmap(bitmap);
                } else {
                    C12066h.m19212ok(8, DialogC12076ok.this.f34201r);
                }
            }
        });
        this.f34202s.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C12058a.m19228ok().m19225ok(DialogC12076ok.this.f34200q);
                AppDetailInfoActivity.m19238ok(DialogC12076ok.this.f34200q, DialogC12076ok.this.f34195k);
                C12066h.m19210ok("lp_app_dialog_click_detail", DialogC12076ok.this.f34201r);
            }
        });
        this.f34197n.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C12058a.m19228ok().m19225ok(DialogC12076ok.this.f34200q);
                AppPrivacyPolicyActivity.m19234ok(DialogC12076ok.this.f34200q, DialogC12076ok.this.f34195k);
                C12066h.m19210ok("lp_app_dialog_click_privacy", DialogC12076ok.this.f34201r);
            }
        });
        this.f34196kf.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC12076ok.this.dismiss();
                C12066h.m19210ok("lp_app_dialog_click_giveup", DialogC12076ok.this.f34201r);
            }
        });
        this.f34199p.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.ok.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C12066h.m19210ok("lp_app_dialog_click_download", DialogC12076ok.this.f34201r);
                C12058a.m19228ok().m19229a(DialogC12076ok.this.f34201r);
                DialogC12076ok.this.dismiss();
            }
        });
    }
}
