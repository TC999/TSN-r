package com.bxkj.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.common.utils.C4249g;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SecretActivity extends BaseActivity {

    /* renamed from: k */
    List<String> f16052k = new ArrayList();

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_secret;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16052k.add("e56b888b-b2fc-32c8-83da-7eb52687835a");
        this.f16052k.add("0801e54a-a7ca-336a-b609-ca6ac126952b");
        this.f16052k.add("28523735-bfaf-3bc2-aa09-7e98b083b790");
        this.f16052k.add("6c3141fb-0c80-3d6f-805d-63381dd5c59e");
        this.f16052k.add("b1f4540e-210e-38c9-be3e-3bdb68eaa485");
        this.f16052k.add("2a4965bb-5f90-38aa-887c-18b2b7d47a04");
        this.f16052k.add("c9f0a9cd-f563-35fa-a3b8-b440228f1f44");
        this.f16052k.add("6b53cbf2-d6c8-3ee9-8909-d90f2eefb9e9");
        if (!this.f16052k.contains(C4249g.m42833a(this.f1669h))) {
            m57919h0("你想干什么？");
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
            this.f1669h.startActivity(new Intent(this.f1669h, MainActivity.class));
        } else {
            this.f1669h.startActivity(new Intent(this.f1669h, LoginActivity.class));
        }
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
