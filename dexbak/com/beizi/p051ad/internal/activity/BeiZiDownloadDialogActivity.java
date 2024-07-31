package com.beizi.p051ad.internal.activity;

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
import com.baidu.mobads.sdk.internal.C2573a;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.DownloadService;
import com.beizi.p051ad.internal.BeiZiImpl;
import com.beizi.p051ad.internal.download.BeiZiExpandableListviewAdapter;
import com.beizi.p051ad.internal.download.ExpandableGroupBean;
import com.beizi.p051ad.internal.utilities.ImageManager;
import com.beizi.p051ad.internal.utilities.ReportEventUtil;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.beizi.p051ad.lance.ApkBean;
import com.beizi.p051ad.lance.p062a.C3023n;
import com.beizi.p051ad.lance.p062a.HeaderUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiDownloadDialogActivity extends Activity {

    /* renamed from: a */
    private RelativeLayout f9855a;

    /* renamed from: b */
    private TextView f9856b;

    /* renamed from: c */
    private TextView f9857c;

    /* renamed from: d */
    private TextView f9858d;

    /* renamed from: e */
    private ImageView f9859e;

    /* renamed from: f */
    private ImageView f9860f;

    /* renamed from: g */
    private ExpandableListView f9861g;

    /* renamed from: h */
    private LinearLayout f9862h;

    /* renamed from: i */
    private LinearLayout f9863i;

    /* renamed from: j */
    private TextView f9864j;

    /* renamed from: k */
    private TextView f9865k;

    /* renamed from: l */
    private ApkBean f9866l;

    /* renamed from: m */
    private int f9867m = -1;

    /* renamed from: n */
    private int f9868n = 1;

    /* renamed from: o */
    private List<String> f9869o;

    /* renamed from: p */
    private String f9870p;

    /* renamed from: q */
    private boolean f9871q;

    static {
        StubApp.interface11(8088);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m49735f() {
        if (this.f9868n == 2 && !TextUtils.isEmpty(this.f9870p) && this.f9870p.startsWith(IDataSource.f43971a)) {
            Class m50215a = AdActivity.m50215a();
            try {
                WebView webView = new WebView(this);
                WebviewUtil.setWebViewSettings(webView);
                webView.loadUrl(this.f9870p, HeaderUtil.m49052a());
                BrowserAdActivity.f9980a.add(webView);
                Intent intent = new Intent(BeiZiImpl.m49492a().m49473e(), m50215a);
                intent.setFlags(268435456);
                intent.putExtra("ACTIVITY_TYPE", "DOWNLOADBROWSER");
                intent.putExtra("ACTIVITY_CAN_JUMP", this.f9871q);
                startActivity(intent);
            } catch (Exception unused) {
                BrowserAdActivity.f9980a.remove();
            }
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    /* renamed from: b */
    private void m49743b() {
        try {
            this.f9855a = (RelativeLayout) findViewById(C2750R.C2753id.beizi_download_dialog_container_rl);
            this.f9859e = (ImageView) findViewById(C2750R.C2753id.beizi_download_dialog_close_iv);
            this.f9860f = (ImageView) findViewById(C2750R.C2753id.beizi_download_dialog_icon_iv);
            this.f9856b = (TextView) findViewById(C2750R.C2753id.beizi_download_dialog_name_tv);
            this.f9857c = (TextView) findViewById(C2750R.C2753id.beizi_download_dialog_version_tv);
            this.f9858d = (TextView) findViewById(C2750R.C2753id.beizi_download_dialog_developer_tv);
            this.f9861g = (ExpandableListView) findViewById(C2750R.C2753id.beizi_download_dialog_expand_lv);
            this.f9862h = (LinearLayout) findViewById(C2750R.C2753id.beizi_download_dialog_download_container_ll);
            this.f9863i = (LinearLayout) findViewById(C2750R.C2753id.beizi_download_dialog_market_container_ll);
            this.f9864j = (TextView) findViewById(C2750R.C2753id.beizi_download_dialog_market_cancel_tv);
            this.f9865k = (TextView) findViewById(C2750R.C2753id.beizi_download_dialog_market_confirm_tv);
            this.f9861g.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.1
                @Override // android.widget.ExpandableListView.OnGroupExpandListener
                public void onGroupExpand(int i) {
                    try {
                        if (BeiZiDownloadDialogActivity.this.f9867m != -1) {
                            BeiZiDownloadDialogActivity.this.f9861g.collapseGroup(BeiZiDownloadDialogActivity.this.f9867m);
                        }
                        BeiZiDownloadDialogActivity.this.f9867m = i;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m49741c() {
        try {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            Point point = new Point();
            getWindow().getWindowManager().getDefaultDisplay().getSize(point);
            Window window = getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = point.x;
            double d = point.y;
            Double.isNaN(d);
            attributes.height = (int) (d * 0.45d);
            attributes.gravity = 80;
            window.setAttributes(attributes);
            layoutParams.width = point.x;
            double d2 = point.y;
            Double.isNaN(d2);
            layoutParams.height = (int) (d2 * 0.45d);
            layoutParams.gravity = 80;
            this.f9855a.setLayoutParams(layoutParams);
            this.f9855a.requestLayout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m49739d() {
        try {
            if (this.f9866l == null) {
                return;
            }
            if (this.f9868n == 1) {
                this.f9859e.setVisibility(0);
                this.f9859e.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f9862h.setVisibility(0);
                this.f9862h.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.m49737e();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f9863i.setVisibility(8);
            } else {
                this.f9859e.setVisibility(8);
                this.f9862h.setVisibility(8);
                this.f9863i.setVisibility(0);
                this.f9864j.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.m49735f();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
                this.f9865k.setOnClickListener(new View.OnClickListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        BeiZiDownloadDialogActivity.this.m49737e();
                        BeiZiDownloadDialogActivity.this.finish();
                    }
                });
            }
            if (this.f9860f != null && !TextUtils.isEmpty(this.f9866l.getAppIconURL())) {
                try {
                    ImageManager.with(null).getBitmap(this.f9866l.getAppIconURL(), new ImageManager.BitmapLoadedListener() { // from class: com.beizi.ad.internal.activity.BeiZiDownloadDialogActivity.6
                        @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                        public void onBitmapLoadFailed() {
                        }

                        @Override // com.beizi.p051ad.internal.utilities.ImageManager.BitmapLoadedListener
                        public void onBitmapLoaded(Bitmap bitmap) {
                            try {
                                BeiZiDownloadDialogActivity.this.f9860f.setImageBitmap(bitmap);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception unused) {
                }
            }
            if (this.f9856b != null && !TextUtils.isEmpty(this.f9866l.getApkTittleName())) {
                this.f9856b.setText(this.f9866l.getApkTittleName());
            }
            if (this.f9857c != null && !TextUtils.isEmpty(this.f9866l.getAppVersion())) {
                TextView textView = this.f9857c;
                textView.setText("版本号 ：" + this.f9866l.getAppVersion());
            }
            if (this.f9858d != null && !TextUtils.isEmpty(this.f9866l.getAppDeveloper())) {
                TextView textView2 = this.f9858d;
                textView2.setText("开发者 ：" + this.f9866l.getAppDeveloper());
            }
            ArrayList arrayList = new ArrayList();
            ExpandableGroupBean expandableGroupBean = new ExpandableGroupBean();
            expandableGroupBean.m49524a("应用权限");
            if (!TextUtils.isEmpty(this.f9866l.getAppPermissionsUrl())) {
                expandableGroupBean.m49520c(this.f9866l.getAppPermissionsUrl());
                expandableGroupBean.m49522b("h5");
            } else if (!TextUtils.isEmpty(this.f9866l.getAppPermissionsDesc())) {
                expandableGroupBean.m49520c(this.f9866l.getAppPermissionsDesc());
                expandableGroupBean.m49522b(C2573a.f8443b);
            }
            arrayList.add(expandableGroupBean);
            ExpandableGroupBean expandableGroupBean2 = new ExpandableGroupBean();
            expandableGroupBean2.m49524a("隐私协议");
            if (!TextUtils.isEmpty(this.f9866l.getAppPrivacyUrl())) {
                expandableGroupBean2.m49520c(this.f9866l.getAppPrivacyUrl());
                expandableGroupBean2.m49522b("h5");
            }
            arrayList.add(expandableGroupBean2);
            ExpandableGroupBean expandableGroupBean3 = new ExpandableGroupBean();
            expandableGroupBean3.m49524a("产品功能介绍");
            if (!TextUtils.isEmpty(this.f9866l.getAppintro())) {
                expandableGroupBean3.m49520c(this.f9866l.getAppintro());
                expandableGroupBean3.m49522b(C2573a.f8443b);
            }
            arrayList.add(expandableGroupBean3);
            this.f9861g.setAdapter(new BeiZiExpandableListviewAdapter(this, arrayList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m49737e() {
        try {
            if (this.f9866l == null) {
                return;
            }
            if (this.f9868n == 2) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.f9866l.getApkUrl()));
                intent.setFlags(268435456);
                startActivity(intent);
                List<String> list = this.f9869o;
                if (list != null) {
                    ReportEventUtil.report(list);
                }
            } else if (!C3023n.m49040a(this)) {
                Log.d("lance", "startDownloadService:checkStoragePermission false");
            } else {
                Bundle bundle = new Bundle();
                bundle.putSerializable("apkBean", this.f9866l);
                Intent intent2 = new Intent(this, DownloadService.class);
                intent2.putExtra("data", bundle);
                startService(intent2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m49746a() {
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("data");
            if (bundleExtra == null) {
                return;
            }
            if (bundleExtra.containsKey("apkBean")) {
                this.f9866l = (ApkBean) bundleExtra.getSerializable("apkBean");
            }
            if (bundleExtra.containsKey("type")) {
                this.f9868n = bundleExtra.getInt("type");
            }
            if (bundleExtra.containsKey("openList")) {
                this.f9869o = bundleExtra.getStringArrayList("openList");
            }
            if (bundleExtra.containsKey("landingPageUrl")) {
                this.f9870p = bundleExtra.getString("landingPageUrl");
            }
            if (bundleExtra.containsKey("isCanJump")) {
                this.f9871q = bundleExtra.getBoolean("isCanJump", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
