package com.bxkj.competition.newsletter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PostActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f15426k;

    /* renamed from: l */
    private Button f15427l;

    /* renamed from: m */
    private String f15428m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.newsletter.PostActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4045a extends HttpCallBack {
        C4045a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ((NewsLetterListActivity) AppManager.m57776n().getActivity(NewsLetterListActivity.class)).m43376x0();
            PostActivity.this.finish();
        }
    }

    /* renamed from: i0 */
    private void m43374i0() {
        String trim = this.f15426k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            m57919h0("请输入内容");
        } else {
            Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43433x(this.f15428m, LoginUser.getLoginUser().getUserId(), trim)).setDataListener(new C4045a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15427l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_post_newletter;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f15428m = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("content")) {
            this.f15426k.setText(getIntent().getStringExtra("content"));
            this.f15426k.setFocusable(false);
            this.f15426k.setFocusableInTouchMode(false);
            this.f15427l.setVisibility(8);
            setTitle("我的通讯稿");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("发布通讯稿");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15426k = (EditText) findViewById(C4017R.C4021id.et_content);
        this.f15427l = (Button) findViewById(C4017R.C4021id.bt_commit);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == C4017R.C4021id.bt_commit) {
            m43374i0();
        }
    }
}
