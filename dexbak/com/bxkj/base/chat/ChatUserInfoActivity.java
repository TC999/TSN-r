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
import com.bumptech.glide.Glide;
import com.bxkj.base.C3801R;
import java.util.Map;
import p635q.ChatApiService;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ChatUserInfoActivity extends BaseActivity {

    /* renamed from: k */
    private ImageView f14714k;

    /* renamed from: l */
    private TextView f14715l;

    /* renamed from: m */
    private TextView f14716m;

    /* renamed from: n */
    private TextView f14717n;

    /* renamed from: o */
    private TextView f14718o;

    /* renamed from: p */
    private TextView f14719p;

    /* renamed from: q */
    private TextView f14720q;

    /* renamed from: r */
    private TextView f14721r;

    /* renamed from: s */
    private Button f14722s;

    /* renamed from: t */
    private String f14723t;

    /* renamed from: u */
    private String f14724u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ChatUserInfoActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3839a extends HttpCallBack {
        C3839a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ChatUserInfoActivity.this.m57932R().setVisibility(0);
            Glide.m45751C(((BaseActivity) ChatUserInfoActivity.this).f1669h).mo45507a(JsonParse.getString(map, "collectPhoto")).m45551i1(ChatUserInfoActivity.this.f14714k);
            TextView textView = ChatUserInfoActivity.this.f14715l;
            textView.setText("姓名：" + JsonParse.getString(map, "name"));
            TextView textView2 = ChatUserInfoActivity.this.f14716m;
            StringBuilder sb = new StringBuilder();
            sb.append("性别：");
            sb.append(JsonParse.getInt(map, "sex") == 1 ? "男" : "女");
            textView2.setText(sb.toString());
            TextView textView3 = ChatUserInfoActivity.this.f14717n;
            textView3.setText("学号：" + JsonParse.getString(map, "userNum"));
            TextView textView4 = ChatUserInfoActivity.this.f14718o;
            textView4.setText("年级：" + JsonParse.getString(map, "grade"));
            TextView textView5 = ChatUserInfoActivity.this.f14719p;
            textView5.setText("院系：" + JsonParse.getString(map, "faculty"));
            TextView textView6 = ChatUserInfoActivity.this.f14720q;
            textView6.setText("专业：" + JsonParse.getString(map, "profession"));
            TextView textView7 = ChatUserInfoActivity.this.f14721r;
            textView7.setText("班级：" + JsonParse.getString(map, "class"));
        }
    }

    /* renamed from: s0 */
    private void m44268s0() {
        Http.with(this.f1669h).setObservable(((ChatApiService) Http.getApiService(ChatApiService.class)).m2315d(this.f14723t)).setDataListener(new C3839a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void m44267t0(View view) {
        startActivity(new Intent(this.f1669h, ChatActivity.class).setFlags(67108864).putExtra("chatName", this.f14724u).putExtra("chatType", 1).putExtra("userId", this.f14723t));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f14722s.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatUserInfoActivity.this.m44267t0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_chat_user_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("userId")) {
            this.f14723t = getIntent().getStringExtra("userId");
        }
        if (getIntent().hasExtra("userName")) {
            String stringExtra = getIntent().getStringExtra("userName");
            this.f14724u = stringExtra;
            this.f14715l.setText(stringExtra);
        }
        m44268s0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("用户信息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        this.f14714k = (ImageView) findViewById(C3801R.C3805id.iv_head);
        this.f14715l = (TextView) findViewById(C3801R.C3805id.tv_name);
        this.f14716m = (TextView) findViewById(C3801R.C3805id.tv_sex);
        this.f14717n = (TextView) findViewById(C3801R.C3805id.tv_number);
        this.f14718o = (TextView) findViewById(C3801R.C3805id.tv_grade);
        this.f14719p = (TextView) findViewById(C3801R.C3805id.tv_compus);
        this.f14720q = (TextView) findViewById(C3801R.C3805id.tv_post);
        this.f14721r = (TextView) findViewById(C3801R.C3805id.tv_class);
        this.f14722s = (Button) findViewById(C3801R.C3805id.bt_chat);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
