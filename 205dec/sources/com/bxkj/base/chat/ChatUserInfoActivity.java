package com.bxkj.base.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ChatUserInfoActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private ImageView f18200k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f18201l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f18202m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f18203n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f18204o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f18205p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f18206q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f18207r;

    /* renamed from: s  reason: collision with root package name */
    private Button f18208s;

    /* renamed from: t  reason: collision with root package name */
    private String f18209t;

    /* renamed from: u  reason: collision with root package name */
    private String f18210u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ChatUserInfoActivity.this.R().setVisibility(0);
            com.bumptech.glide.d.C(((BaseActivity) ChatUserInfoActivity.this).f1656h).a(JsonParse.getString(map, "collectPhoto")).i1(ChatUserInfoActivity.this.f18200k);
            TextView textView = ChatUserInfoActivity.this.f18201l;
            textView.setText("\u59d3\u540d\uff1a" + JsonParse.getString(map, "name"));
            TextView textView2 = ChatUserInfoActivity.this.f18202m;
            StringBuilder sb = new StringBuilder();
            sb.append("\u6027\u522b\uff1a");
            sb.append(JsonParse.getInt(map, "sex") == 1 ? "\u7537" : "\u5973");
            textView2.setText(sb.toString());
            TextView textView3 = ChatUserInfoActivity.this.f18203n;
            textView3.setText("\u5b66\u53f7\uff1a" + JsonParse.getString(map, "userNum"));
            TextView textView4 = ChatUserInfoActivity.this.f18204o;
            textView4.setText("\u5e74\u7ea7\uff1a" + JsonParse.getString(map, "grade"));
            TextView textView5 = ChatUserInfoActivity.this.f18205p;
            textView5.setText("\u9662\u7cfb\uff1a" + JsonParse.getString(map, "faculty"));
            TextView textView6 = ChatUserInfoActivity.this.f18206q;
            textView6.setText("\u4e13\u4e1a\uff1a" + JsonParse.getString(map, "profession"));
            TextView textView7 = ChatUserInfoActivity.this.f18207r;
            textView7.setText("\u73ed\u7ea7\uff1a" + JsonParse.getString(map, "class"));
        }
    }

    private void s0() {
        Http.with(this.f1656h).setObservable(((q.a) Http.getApiService(q.a.class)).d(this.f18209t)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(View view) {
        startActivity(new Intent(this.f1656h, ChatActivity.class).setFlags(TTAdConstant.KEY_CLICK_AREA).putExtra("chatName", this.f18210u).putExtra("chatType", 1).putExtra("userId", this.f18209t));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18208s.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatUserInfoActivity.this.t0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_chat_user_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("userId")) {
            this.f18209t = getIntent().getStringExtra("userId");
        }
        if (getIntent().hasExtra("userName")) {
            String stringExtra = getIntent().getStringExtra("userName");
            this.f18210u = stringExtra;
            this.f18201l.setText(stringExtra);
        }
        s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7528\u6237\u4fe1\u606f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        this.f18200k = (ImageView) findViewById(R.id.iv_head);
        this.f18201l = (TextView) findViewById(R.id.tv_name);
        this.f18202m = (TextView) findViewById(R.id.tv_sex);
        this.f18203n = (TextView) findViewById(R.id.tv_number);
        this.f18204o = (TextView) findViewById(R.id.tv_grade);
        this.f18205p = (TextView) findViewById(R.id.tv_compus);
        this.f18206q = (TextView) findViewById(R.id.tv_post);
        this.f18207r = (TextView) findViewById(R.id.tv_class);
        this.f18208s = (Button) findViewById(R.id.bt_chat);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
