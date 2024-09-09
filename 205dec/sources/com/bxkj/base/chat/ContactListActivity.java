package com.bxkj.base.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.SideBar;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ContactListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f18212k;

    /* renamed from: l  reason: collision with root package name */
    private SideBar f18213l;

    /* renamed from: m  reason: collision with root package name */
    private List<r.b> f18214m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<r.b> f18215n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements SideBar.a {
        a() {
        }

        @Override // com.bxkj.base.view.SideBar.a
        public void a(int i4, String str) {
            for (int i5 = 0; i5 < ContactListActivity.this.f18214m.size(); i5++) {
                if (str.equalsIgnoreCase(((r.b) ContactListActivity.this.f18214m.get(i5)).b())) {
                    ContactListActivity.this.f18212k.scrollToPosition(i5);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class b extends CommonAdapter<r.b> {
        b(Context context, int i4, List list) {
            super(context, i4, list);
        }

        private int n(String str) {
            for (int i4 = 0; i4 < getItemCount(); i4++) {
                if (str.equalsIgnoreCase(((r.b) ContactListActivity.this.f18214m.get(i4)).b())) {
                    return i4;
                }
            }
            return -1;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder viewHolder, r.b bVar) {
            if (viewHolder.f() == n(bVar.b())) {
                int i4 = R.id.catalog;
                viewHolder.N(i4, true);
                viewHolder.J(i4, bVar.b().toUpperCase());
            } else {
                viewHolder.N(R.id.catalog, false);
            }
            viewHolder.J(R.id.name, bVar.getName());
            int i5 = Integer.parseInt(bVar.getType()) == 1 ? R.mipmap.ease_default_avatar : R.mipmap.ease_group_icon;
            viewHolder.t(R.id.avatar, bVar.d(), i5, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            ContactListActivity.this.f18214m.clear();
            for (Map<String, Object> map2 : list) {
                r.b bVar = new r.b();
                bVar.f(JsonParse.getString(map2, "id"));
                bVar.i(JsonParse.getString(map2, "type"));
                bVar.g(JsonParse.getString(map2, "name"));
                bVar.h(JsonParse.getString(map2, "photo"));
                ContactListActivity.this.f18214m.add(bVar);
            }
            Collections.sort(ContactListActivity.this.f18214m);
            ContactListActivity.this.f18215n.g(ContactListActivity.this.f18214m);
        }
    }

    private void m0() {
        Http.with(this.f1656h).setObservable(((q.a) Http.getApiService(q.a.class)).e(null)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(ViewGroup viewGroup, View view, Object obj, int i4) {
        r.b item = this.f18215n.getItem(i4);
        int parseInt = Integer.parseInt(item.getType());
        if (parseInt == 1 && LoginUser.getLoginUser().getUserType() == 2) {
            startActivity(new Intent(this.f1656h, ChatUserInfoActivity.class).putExtra("userId", item.c()).putExtra("userName", item.getName()));
        } else {
            startActivity(new Intent(this.f1656h, ChatActivity.class).setFlags(TTAdConstant.KEY_CLICK_AREA).putExtra("chatName", item.getName()).putExtra("chatType", parseInt).putExtra("groupId", item.c()).putExtra("userId", item.c()));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18215n.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.base.chat.j
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                ContactListActivity.this.n0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_contact;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f18213l.setOnStrSelectCallBack(new a());
        this.f18212k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        b bVar = new b(this.f1656h, R.layout.item_for_contact_list, this.f18214m);
        this.f18215n = bVar;
        this.f18212k.setAdapter(bVar);
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8054\u7cfb\u4eba\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        this.f18212k = (RecyclerView) findViewById(R.id.recyclerView);
        this.f18213l = (SideBar) findViewById(R.id.side_bar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
