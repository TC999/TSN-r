package com.bxkj.base.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.C3801R;
import com.bxkj.base.user.LoginUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.ChatApiService;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ChatInfoActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f14708k;

    /* renamed from: l */
    private List<Map<String, Object>> f14709l = new ArrayList();

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f14710m;

    /* renamed from: n */
    private String f14711n;

    /* renamed from: com.bxkj.base.chat.ChatInfoActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3837a extends CommonAdapter<Map<String, Object>> {
        C3837a(Context context, int i, List list) {
            super(context, i, list);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder viewHolder, Map<String, Object> map) {
            viewHolder.m57851s(C3801R.C3805id.iv_head, JsonParse.getString(map, "photo"));
            viewHolder.m57874J(C3801R.C3805id.tv_name, JsonParse.getString(map, "name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ChatInfoActivity$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3838b extends HttpCallBack {
        C3838b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ChatInfoActivity.this.f14710m.m57836g(JsonParse.getList(map, "data"));
        }
    }

    /* renamed from: l0 */
    private void m44282l0() {
        Http.with(this.f1669h).setObservable(((ChatApiService) Http.getApiService(ChatApiService.class)).m2314e(this.f14711n)).setDataListener(new C3838b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m44281m0(ViewGroup viewGroup, View view, Object obj, int i) {
        String string = JsonParse.getString(this.f14710m.getItem(i), "id");
        if (LoginUser.getLoginUser().getUserId().equalsIgnoreCase(string) || LoginUser.getLoginUser().getUserType() != 2) {
            return;
        }
        startActivity(new Intent(this.f1669h, ChatUserInfoActivity.class).putExtra("userId", string).putExtra("userName", JsonParse.getString(this.f14710m.getItem(i), "name")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void m44280n0(View view) {
        startActivity(getIntent().setClass(this.f1669h, ReportChatActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f14710m.m57834k(new OnItemClickListener() { // from class: com.bxkj.base.chat.h
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                ChatInfoActivity.this.m44281m0(viewGroup, view, obj, i);
            }
        });
        findViewById(C3801R.C3805id.bt_report).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatInfoActivity.this.m44280n0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_chat_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("groupId")) {
            this.f14711n = getIntent().getStringExtra("groupId");
        }
        this.f14708k.setLayoutManager(new GridLayoutManager(this.f1669h, 5));
        C3837a c3837a = new C3837a(this.f1669h, C3801R.C3807layout.item_for_menmber, this.f14709l);
        this.f14710m = c3837a;
        this.f14708k.setAdapter(c3837a);
        m44282l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("聊天信息");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        this.f14708k = (RecyclerView) findViewById(C3801R.C3805id.rv_user);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
