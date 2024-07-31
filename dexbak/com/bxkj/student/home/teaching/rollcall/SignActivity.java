package com.bxkj.student.home.teaching.rollcall;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.student.C4215R;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SignActivity extends BaseActivity {

    /* renamed from: k */
    private Button f17932k;

    /* renamed from: l */
    private String f17933l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.rollcall.SignActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4843a extends HttpCallBack {
        C4843a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(((BaseActivity) SignActivity.this).f1669h).setMessage("签到成功").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void m41184k0(View view) {
        m41183l0();
    }

    /* renamed from: l0 */
    private void m41183l0() {
        Http.with(this.f1669h).hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m94l1(this.f17933l)).setDataListener(new C4843a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17932k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.rollcall.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignActivity.this.m41184k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_teach_sigin;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f17933l = getIntent().getStringExtra("id");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("上课签到");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17932k = (Button) findViewById(C4215R.C4219id.bt_in);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
