package com.bxkj.student.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.util.a0;
import com.devlin_n.floatWindowPermission.b;
import com.devlin_n.videoplayer.controller.StandardVideoController;
import com.devlin_n.videoplayer.player.IjkVideoView;
import com.stub.StubApp;
import java.util.Map;
import q.f;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class VideoPlayActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f23103k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f23104l;

    /* renamed from: m  reason: collision with root package name */
    private SmartWebView f23105m;

    /* renamed from: n  reason: collision with root package name */
    private IjkVideoView f23106n;

    /* renamed from: o  reason: collision with root package name */
    private String f23107o = "https://media.w3.org/2010/05/sintel/trailer.mp4";

    /* renamed from: p  reason: collision with root package name */
    private String f23108p;

    /* renamed from: q  reason: collision with root package name */
    private String f23109q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            VideoPlayActivity.this.f23103k.setText("\u6807\u9898\uff1a" + JsonParse.getString(data, "title"));
            VideoPlayActivity.this.f23105m.h(JsonParse.getString(data, "memo"));
            VideoPlayActivity.this.f23107o = JsonParse.getString(data, "videoPath");
            TextView textView = VideoPlayActivity.this.f23104l;
            textView.setText("\u64ad\u653e\u91cf\uff1a" + JsonParse.getString(data, "playNum"));
            VideoPlayActivity.this.o0();
        }
    }

    static {
        StubApp.interface11(12256);
    }

    private void n0() {
        Http.with(this.f1656h).setObservable(((f) Http.getApiService(f.class)).i(this.f23108p)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.f23106n.U().S().f0(a0.a(this.f23107o)).g0(new StandardVideoController(this)).start();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427520;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("videoName")) {
            String stringExtra = getIntent().getStringExtra("videoName");
            this.f23109q = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("videoId")) {
            this.f23108p = getIntent().getStringExtra("videoId");
        }
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle(this.f23109q);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f23103k = (TextView) findViewById(2131233225);
        this.f23105m = (SmartWebView) findViewById(2131232631);
        this.f23106n = (IjkVideoView) findViewById(2131232455);
        this.f23104l = (TextView) findViewById(2131233096);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (b.f().c(this)) {
                this.f23106n.d();
            } else {
                Toast.makeText(this.f1656h, "\u6743\u9650\u6388\u4e88\u5931\u8d25\uff0c\u65e0\u6cd5\u5f00\u542f\u60ac\u6d6e\u7a97", 0).show();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f23106n.Y()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle savedInstanceState);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f23106n.a0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f23106n.pause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f23106n.h();
    }
}
