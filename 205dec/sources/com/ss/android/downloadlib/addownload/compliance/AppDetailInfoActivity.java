package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import com.stub.StubApp;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class AppDetailInfoActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f48420a;
    private LinearLayout bl;

    /* renamed from: h  reason: collision with root package name */
    private List<Pair<String, String>> f48421h;
    private long kf;

    /* renamed from: n  reason: collision with root package name */
    private long f48422n;
    private ImageView ok;

    /* renamed from: s  reason: collision with root package name */
    private RecyclerView f48423s;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private class c extends RecyclerView.Adapter<Object> {
        private c() {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private class ok extends RecyclerView.Adapter<Object> {
        private ok() {
        }
    }

    static {
        StubApp.interface11(22636);
    }

    private void a() {
        this.ok = (ImageView) findViewById(R.id.iv_detail_back);
        this.f48420a = (TextView) findViewById(R.id.tv_empty);
        this.f48423s = (RecyclerView) findViewById(R.id.permission_list);
        this.bl = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f48421h.isEmpty()) {
            this.f48423s.setVisibility(8);
            this.f48420a.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f48423s.setLayoutManager(linearLayoutManager);
            this.f48423s.setAdapter(new ok());
        }
        this.ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_detail_click_close", AppDetailInfoActivity.this.kf);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.bl.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.ok("lp_app_detail_click_download", AppDetailInfoActivity.this.kf);
                a.ok().a(AppDetailInfoActivity.this.kf);
                com.ss.android.socialbase.appdownloader.bl.ok((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.bl.ok(a.ok().a());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        h.ok("lp_app_detail_click_close", this.kf);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void ok(Activity activity, long j4) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j4);
        activity.startActivity(intent);
    }

    private boolean ok() {
        this.f48422n = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.a.a ok2 = bl.ok().ok(this.f48422n);
        if (ok2 == null) {
            return false;
        }
        this.kf = ok2.f48355a;
        this.f48421h = ok2.f48358p;
        return true;
    }
}
