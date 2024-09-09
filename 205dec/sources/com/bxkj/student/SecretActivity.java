package com.bxkj.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SecretActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    List<String> f19452k = new ArrayList();

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427488;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f19452k.add("e56b888b-b2fc-32c8-83da-7eb52687835a");
        this.f19452k.add("0801e54a-a7ca-336a-b609-ca6ac126952b");
        this.f19452k.add("28523735-bfaf-3bc2-aa09-7e98b083b790");
        this.f19452k.add("6c3141fb-0c80-3d6f-805d-63381dd5c59e");
        this.f19452k.add("b1f4540e-210e-38c9-be3e-3bdb68eaa485");
        this.f19452k.add("2a4965bb-5f90-38aa-887c-18b2b7d47a04");
        this.f19452k.add("c9f0a9cd-f563-35fa-a3b8-b440228f1f44");
        this.f19452k.add("6b53cbf2-d6c8-3ee9-8909-d90f2eefb9e9");
        if (!this.f19452k.contains(com.bxkj.student.common.utils.g.a(this.f1656h))) {
            h0("\u4f60\u60f3\u5e72\u4ec0\u4e48\uff1f");
            finish();
            return;
        }
        if (getIntent().hasExtra("school_name") && getIntent().hasExtra("school_url") && getIntent().hasExtra("school_id")) {
            String stringExtra = getIntent().getStringExtra("school_name");
            String stringExtra2 = getIntent().getStringExtra("school_url");
            String stringExtra3 = getIntent().getStringExtra("school_id");
            LoginUser.getLoginUser().setSchoolName(stringExtra);
            LoginUser.getLoginUser().setServerUrl(stringExtra2);
            LoginUser.getLoginUser().setSchoolId(stringExtra3);
            if (getIntent().hasExtra("openId")) {
                LoginUser.getLoginUser().setAppId(getIntent().getStringExtra("openId"));
            }
            Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
        }
        if (getIntent().hasExtra("userId") && getIntent().hasExtra("name") && getIntent().hasExtra("userNum")) {
            String stringExtra4 = getIntent().getStringExtra("userId");
            String stringExtra5 = getIntent().getStringExtra("name");
            String stringExtra6 = getIntent().getStringExtra("userNum");
            LoginUser.getLoginUser().setLogin(true);
            LoginUser.getLoginUser().setUserId(stringExtra4);
            LoginUser.getLoginUser().setRealName(stringExtra5);
            LoginUser.getLoginUser().setAccount(stringExtra6);
            this.f1656h.startActivity(new Intent(this.f1656h, MainActivity.class));
        } else {
            this.f1656h.startActivity(new Intent(this.f1656h, LoginActivity.class));
        }
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
