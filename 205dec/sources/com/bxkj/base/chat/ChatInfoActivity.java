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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ChatInfoActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f18194k;

    /* renamed from: l  reason: collision with root package name */
    private List<Map<String, Object>> f18195l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18196m;

    /* renamed from: n  reason: collision with root package name */
    private String f18197n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int i4, List list) {
            super(context, i4, list);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder viewHolder, Map<String, Object> map) {
            viewHolder.s(R.id.iv_head, JsonParse.getString(map, "photo"));
            viewHolder.J(R.id.tv_name, JsonParse.getString(map, "name"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ChatInfoActivity.this.f18196m.g(JsonParse.getList(map, "data"));
        }
    }

    private void l0() {
        Http.with(this.f1656h).setObservable(((q.a) Http.getApiService(q.a.class)).e(this.f18197n)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(ViewGroup viewGroup, View view, Object obj, int i4) {
        String string = JsonParse.getString(this.f18196m.getItem(i4), "id");
        if (LoginUser.getLoginUser().getUserId().equalsIgnoreCase(string) || LoginUser.getLoginUser().getUserType() != 2) {
            return;
        }
        startActivity(new Intent(this.f1656h, ChatUserInfoActivity.class).putExtra("userId", string).putExtra("userName", JsonParse.getString(this.f18196m.getItem(i4), "name")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        startActivity(getIntent().setClass(this.f1656h, ReportChatActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18196m.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.base.chat.h
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                ChatInfoActivity.this.m0(viewGroup, view, obj, i4);
            }
        });
        findViewById(R.id.bt_report).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.chat.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatInfoActivity.this.n0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_chat_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("groupId")) {
            this.f18197n = getIntent().getStringExtra("groupId");
        }
        this.f18194k.setLayoutManager(new GridLayoutManager(this.f1656h, 5));
        a aVar = new a(this.f1656h, R.layout.item_for_menmber, this.f18195l);
        this.f18196m = aVar;
        this.f18194k.setAdapter(aVar);
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u804a\u5929\u4fe1\u606f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        this.f18194k = (RecyclerView) findViewById(R.id.rv_user);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
