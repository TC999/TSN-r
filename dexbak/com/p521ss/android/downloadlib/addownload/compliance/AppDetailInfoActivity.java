package com.p521ss.android.downloadlib.addownload.compliance;

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
import com.bytedance.sdk.openadsdk.C6266R;
import com.p521ss.android.downloadlib.addownload.p528a.C12029a;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.stub.StubApp;
import java.util.List;

/* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class AppDetailInfoActivity extends Activity {

    /* renamed from: a */
    private TextView f34120a;

    /* renamed from: bl */
    private LinearLayout f34121bl;

    /* renamed from: h */
    private List<Pair<String, String>> f34122h;

    /* renamed from: kf */
    private long f34123kf;

    /* renamed from: n */
    private long f34124n;

    /* renamed from: ok */
    private ImageView f34125ok;

    /* renamed from: s */
    private RecyclerView f34126s;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private class C12055ok extends RecyclerView.Adapter<Object> {
        private C12055ok() {
        }
    }

    static {
        StubApp.interface11(22636);
    }

    /* renamed from: a */
    private void m19240a() {
        this.f34125ok = (ImageView) findViewById(C6266R.C6269id.iv_detail_back);
        this.f34120a = (TextView) findViewById(C6266R.C6269id.tv_empty);
        this.f34126s = (RecyclerView) findViewById(C6266R.C6269id.permission_list);
        this.f34121bl = (LinearLayout) findViewById(C6266R.C6269id.ll_download);
        if (this.f34122h.isEmpty()) {
            this.f34126s.setVisibility(8);
            this.f34120a.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f34126s.setLayoutManager(linearLayoutManager);
            this.f34126s.setAdapter(new C12055ok());
        }
        this.f34125ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C12066h.m19210ok("lp_app_detail_click_close", AppDetailInfoActivity.this.f34123kf);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f34121bl.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C12066h.m19210ok("lp_app_detail_click_download", AppDetailInfoActivity.this.f34123kf);
                C12058a.m19228ok().m19229a(AppDetailInfoActivity.this.f34123kf);
                C12293bl.m18426ok((Activity) AppDetailInfoActivity.this);
                C12293bl.m18426ok(C12058a.m19228ok().m19230a());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C12066h.m19210ok("lp_app_detail_click_close", this.f34123kf);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    /* renamed from: ok */
    public static void m19238ok(Activity activity, long j) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j);
        activity.startActivity(intent);
    }

    /* renamed from: ok */
    private boolean m19239ok() {
        this.f34124n = getIntent().getLongExtra("app_info_id", 0L);
        C12029a m19217ok = C12063bl.m19218ok().m19217ok(this.f34124n);
        if (m19217ok == null) {
            return false;
        }
        this.f34123kf = m19217ok.f34048a;
        this.f34122h = m19217ok.f34054p;
        return true;
    }
}
