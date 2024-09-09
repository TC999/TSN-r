package com.bxkj.student.home.teaching.rollcall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SignActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Button f21270k;

    /* renamed from: l  reason: collision with root package name */
    private String f21271l;

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
            new iOSOneButtonDialog(((BaseActivity) SignActivity.this).f1656h).setMessage("\u7b7e\u5230\u6210\u529f").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        l0();
    }

    private void l0() {
        Http.with(this.f1656h).hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).l1(this.f21271l)).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21270k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignActivity.this.k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427501;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f21271l = getIntent().getStringExtra("id");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4e0a\u8bfe\u7b7e\u5230");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21270k = (Button) findViewById(2131230981);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
