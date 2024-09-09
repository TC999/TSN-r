package com.beizi.ad.internal.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.beizi.ad.AdActivity;
import com.beizi.ad.DownloadService;
import com.beizi.ad.R;
import com.beizi.ad.internal.h;
import com.beizi.ad.internal.utilities.ImageManager;
import com.beizi.ad.internal.utilities.ReportEventUtil;
import com.beizi.ad.internal.utilities.WebviewUtil;
import com.beizi.ad.lance.ApkBean;
import com.beizi.ad.lance.a.i;
import com.beizi.ad.lance.a.n;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BeiZiDownloadDialogActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private RelativeLayout f13553a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f13554b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13555c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f13556d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f13557e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f13558f;

    /* renamed from: g  reason: collision with root package name */
    private ExpandableListView f13559g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f13560h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f13561i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f13562j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f13563k;

    /* renamed from: l  reason: collision with root package name */
    private ApkBean f13564l;

    /* renamed from: m  reason: collision with root package name */
    private int f13565m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f13566n = 1;

    /* renamed from: o  reason: collision with root package name */
    private List<String> f13567o;

    /* renamed from: p  reason: collision with root package name */
    private String f13568p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f13569q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f13570r;

    static {
        StubApp.interface11(8942);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f13566n == 2 && !TextUtils.isEmpty(this.f13568p) && this.f13568p.startsWith("http")) {
            Class a4 = AdActivity.a();
            try {
                WebView webView = new WebView(this);
                WebviewUtil.setWebViewSettings(webView);
                webView.loadUrl(this.f13568p, i.a());
                a.f13657a.add(webView);
                Intent intent = new Intent(h.a().e(), a4);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.f13569q);
                intent.putExtra("ACTIVITY_CAN_DOWNLOAD", this.f13570r);
                startActivity(intent);
            } catch (Exception unused) {
                a.f13657a.remove();
            }
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    private void b() {
        try {
            this.f13553a = (RelativeLayout) findViewById(R.id.beizi_download_dialog_container_rl);
            this.f13557e = (ImageView) findViewById(R.id.beizi_download_dialog_close_iv);
            this.f13558f = (ImageView) findViewById(R.id.beizi_download_dialog_icon_iv);
            this.f13554b = (TextView) findViewById(R.id.beizi_download_dialog_name_tv);
            this.f13555c = (TextView) findViewById(R.id.beizi_download_dialog_version_tv);
            this.f13556d = (TextView) findViewById(R.id.beizi_download_dialog_developer_tv);
            this.f13559g = (ExpandableListView) findViewById(R.id.beizi_download_dialog_expand_lv);
            this.f13560h = (LinearLayout) findViewById(R.id.beizi_download_dialog_download_container_ll);
            this.f13561i = (LinearLayout) findViewById(R.id.beizi_download_dialog_market_container_ll);
            this.f13562j = (TextView) findViewById(R.id.beizi_download_dialog_market_cancel_tv);
            this.f13563k = (TextView) findViewById(R.id.beizi_download_dialog_market_confirm_tv);
            this.f13559g.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.1
                @Override // android.widget.ExpandableListView.OnGroupExpandListener
                public void onGroupExpand(int i4) {
                    try {
                        if (BeiZiDownloadDialogActivity.this.f13565m != -1) {
                            BeiZiDownloadDialogActivity.this.f13559g.collapseGroup(BeiZiDownloadDialogActivity.this.f13565m);
                        }
                        BeiZiDownloadDialogActivity.this.f13565m = i4;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void c() {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            Point point = new Point();
            getWindow().getWindowManager().getDefaultDisplay().getSize(point);
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = point.x;
            double d4 = point.y;
            Double.isNaN(d4);
            attributes.height = (int) (d4 * 0.45d);
            attributes.gravity = 80;
            window.setAttributes(attributes);
            layoutParams.width = point.x;
            double d5 = point.y;
            Double.isNaN(d5);
            layoutParams.height = (int) (d5 * 0.45d);
            layoutParams.gravity = 80;
            this.f13553a.setLayoutParams(layoutParams);
            this.f13553a.requestLayout();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void d() {
        try {
            if (this.f13564l == null) {
                return;
            }
            if (this.f13566n == 1) {
                this.f13557e.setVisibility(0);
                this.f13557e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f13560h.setVisibility(0);
                this.f13560h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.e();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f13561i.setVisibility(8);
            } else {
                this.f13557e.setVisibility(8);
                this.f13560h.setVisibility(8);
                this.f13561i.setVisibility(0);
                this.f13562j.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.f();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f13563k.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.e();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
            }
            if (this.f13558f != null && !TextUtils.isEmpty(this.f13564l.getAppIconURL())) {
                try {
                    ImageManager.with(null).getBitmap(this.f13564l.getAppIconURL(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.6
                        @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                        public void onBitmapLoadFailed() {
                        }

                        @Override // com.beizi.ad.internal.utilities.ImageManager.BitmapLoadedListener
                        public void onBitmapLoaded(Bitmap bitmap) {
                            try {
                                BeiZiDownloadDialogActivity.this.f13558f.setImageBitmap(bitmap);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
            if (this.f13554b != null && !TextUtils.isEmpty(this.f13564l.getApkTittleName())) {
                this.f13554b.setText(this.f13564l.getApkTittleName());
            }
            if (this.f13555c != null && !TextUtils.isEmpty(this.f13564l.getAppVersion())) {
                TextView textView = this.f13555c;
                textView.setText("\u7248\u672c\u53f7 \uff1a" + this.f13564l.getAppVersion());
            }
            if (this.f13556d != null && !TextUtils.isEmpty(this.f13564l.getAppDeveloper())) {
                TextView textView2 = this.f13556d;
                textView2.setText("\u5f00\u53d1\u8005 \uff1a" + this.f13564l.getAppDeveloper());
            }
            ArrayList arrayList = new ArrayList();
            com.beizi.ad.internal.download.b bVar = new com.beizi.ad.internal.download.b();
            bVar.a("\u5e94\u7528\u6743\u9650");
            if (!TextUtils.isEmpty(this.f13564l.getAppPermissionsUrl())) {
                bVar.c(this.f13564l.getAppPermissionsUrl());
                bVar.b("h5");
            } else if (!TextUtils.isEmpty(this.f13564l.getAppPermissionsDesc())) {
                bVar.c(this.f13564l.getAppPermissionsDesc());
                bVar.b("text");
            }
            arrayList.add(bVar);
            com.beizi.ad.internal.download.b bVar2 = new com.beizi.ad.internal.download.b();
            bVar2.a("\u9690\u79c1\u534f\u8bae");
            String appPrivacyUrl = this.f13564l.getAppPrivacyUrl();
            if (!TextUtils.isEmpty(appPrivacyUrl)) {
                if (appPrivacyUrl.startsWith("http")) {
                    bVar2.c(appPrivacyUrl);
                    bVar2.b("h5");
                } else {
                    bVar2.c(appPrivacyUrl);
                    bVar2.b("text");
                }
            }
            arrayList.add(bVar2);
            com.beizi.ad.internal.download.b bVar3 = new com.beizi.ad.internal.download.b();
            bVar3.a("\u4ea7\u54c1\u529f\u80fd\u4ecb\u7ecd");
            String appintro = this.f13564l.getAppintro();
            if (!TextUtils.isEmpty(appintro)) {
                if (appintro.startsWith("http")) {
                    bVar3.c(appintro);
                    bVar3.b("h5");
                } else {
                    bVar3.c(appintro);
                    bVar3.b("text");
                }
            }
            arrayList.add(bVar3);
            this.f13559g.setAdapter(new com.beizi.ad.internal.download.a(this, arrayList));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f13564l == null) {
                return;
            }
            if (this.f13566n == 2) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f13564l.getApkUrl()));
                intent.setFlags(268435456);
                startActivity(intent);
                List<String> list = this.f13567o;
                if (list != null) {
                    ReportEventUtil.report(list);
                }
            } else if (!n.a(this)) {
                Log.d("lance", "startDownloadService:checkStoragePermission false");
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("apkBean", this.f13564l);
                Intent intent2 = new Intent(this, DownloadService.class);
                intent2.putExtra("data", bundle);
                startService(intent2);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void a() {
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra == null) {
                return;
            }
            if (bundleExtra.containsKey("apkBean")) {
                this.f13564l = (ApkBean) bundleExtra.getSerializable("apkBean");
            }
            if (bundleExtra.containsKey("type")) {
                this.f13566n = bundleExtra.getInt("type");
            }
            if (bundleExtra.containsKey("openList")) {
                this.f13567o = bundleExtra.getStringArrayList("openList");
            }
            if (bundleExtra.containsKey("landingPageUrl")) {
                this.f13568p = bundleExtra.getString("landingPageUrl");
            }
            if (bundleExtra.containsKey("isCanJump")) {
                this.f13569q = bundleExtra.getBoolean("isCanJump", false);
            }
            if (bundleExtra.containsKey("isDownload")) {
                this.f13570r = bundleExtra.getBoolean("isDownload", false);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
