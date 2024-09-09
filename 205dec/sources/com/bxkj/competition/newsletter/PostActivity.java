package com.bxkj.competition.newsletter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.b;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PostActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f18970k;

    /* renamed from: l  reason: collision with root package name */
    private Button f18971l;

    /* renamed from: m  reason: collision with root package name */
    private String f18972m;

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
            ((NewsLetterListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(NewsLetterListActivity.class)).x0();
            PostActivity.this.finish();
        }
    }

    private void i0() {
        String trim = this.f18970k.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            h0("\u8bf7\u8f93\u5165\u5185\u5bb9");
        } else {
            Http.with(this.f1656h).setObservable(((b) Http.getApiService(b.class)).x(this.f18972m, LoginUser.getLoginUser().getUserId(), trim)).setDataListener(new a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18971l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_post_newletter;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f18972m = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("content")) {
            this.f18970k.setText(getIntent().getStringExtra("content"));
            this.f18970k.setFocusable(false);
            this.f18970k.setFocusableInTouchMode(false);
            this.f18971l.setVisibility(8);
            setTitle("\u6211\u7684\u901a\u8baf\u7a3f");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u53d1\u5e03\u901a\u8baf\u7a3f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18970k = (EditText) findViewById(R.id.et_content);
        this.f18971l = (Button) findViewById(R.id.bt_commit);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() == R.id.bt_commit) {
            i0();
        }
    }
}
