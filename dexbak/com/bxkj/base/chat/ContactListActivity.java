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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.C3801R;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.SideBar;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p635q.ChatApiService;
import p637r.User;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ContactListActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f14726k;

    /* renamed from: l */
    private SideBar f14727l;

    /* renamed from: m */
    private List<User> f14728m = new ArrayList();

    /* renamed from: n */
    private CommonAdapter<User> f14729n;

    /* renamed from: com.bxkj.base.chat.ContactListActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3840a implements SideBar.InterfaceC3999a {
        C3840a() {
        }

        @Override // com.bxkj.base.view.SideBar.InterfaceC3999a
        /* renamed from: a */
        public void mo43522a(int i, String str) {
            for (int i2 = 0; i2 < ContactListActivity.this.f14728m.size(); i2++) {
                if (str.equalsIgnoreCase(((User) ContactListActivity.this.f14728m.get(i2)).m2132b())) {
                    ContactListActivity.this.f14726k.scrollToPosition(i2);
                    return;
                }
            }
        }
    }

    /* renamed from: com.bxkj.base.chat.ContactListActivity$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3841b extends CommonAdapter<User> {
        C3841b(Context context, int i, List list) {
            super(context, i, list);
        }

        /* renamed from: n */
        private int m44259n(String str) {
            for (int i = 0; i < getItemCount(); i++) {
                if (str.equalsIgnoreCase(((User) ContactListActivity.this.f14728m.get(i)).m2132b())) {
                    return i;
                }
            }
            return -1;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder viewHolder, User user) {
            if (viewHolder.m57864f() == m44259n(user.m2132b())) {
                int i = C3801R.C3805id.catalog;
                viewHolder.m57870N(i, true);
                viewHolder.m57874J(i, user.m2132b().toUpperCase());
            } else {
                viewHolder.m57870N(C3801R.C3805id.catalog, false);
            }
            viewHolder.m57874J(C3801R.C3805id.name, user.getName());
            int i2 = Integer.parseInt(user.getType()) == 1 ? C3801R.mipmap.ease_default_avatar : C3801R.mipmap.ease_group_icon;
            viewHolder.m57850t(C3801R.C3805id.avatar, user.m2130d(), i2, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ContactListActivity$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3842c extends HttpCallBack {
        C3842c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            List<Map<String, Object>> list = JsonParse.getList(map, "data");
            ContactListActivity.this.f14728m.clear();
            for (Map<String, Object> map2 : list) {
                User user = new User();
                user.m2128f(JsonParse.getString(map2, "id"));
                user.m2125i(JsonParse.getString(map2, "type"));
                user.m2127g(JsonParse.getString(map2, "name"));
                user.m2126h(JsonParse.getString(map2, "photo"));
                ContactListActivity.this.f14728m.add(user);
            }
            Collections.sort(ContactListActivity.this.f14728m);
            ContactListActivity.this.f14729n.m57836g(ContactListActivity.this.f14728m);
        }
    }

    /* renamed from: m0 */
    private void m44262m0() {
        Http.with(this.f1669h).setObservable(((ChatApiService) Http.getApiService(ChatApiService.class)).m2314e(null)).setDataListener(new C3842c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void m44261n0(ViewGroup viewGroup, View view, Object obj, int i) {
        User item = this.f14729n.getItem(i);
        int parseInt = Integer.parseInt(item.getType());
        if (parseInt == 1 && LoginUser.getLoginUser().getUserType() == 2) {
            startActivity(new Intent(this.f1669h, ChatUserInfoActivity.class).putExtra("userId", item.m2131c()).putExtra("userName", item.getName()));
        } else {
            startActivity(new Intent(this.f1669h, ChatActivity.class).setFlags(67108864).putExtra("chatName", item.getName()).putExtra("chatType", parseInt).putExtra("groupId", item.m2131c()).putExtra("userId", item.m2131c()));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f14729n.m57834k(new OnItemClickListener() { // from class: com.bxkj.base.chat.j
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                ContactListActivity.this.m44261n0(viewGroup, view, obj, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_contact;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f14727l.setOnStrSelectCallBack(new C3840a());
        this.f14726k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C3841b c3841b = new C3841b(this.f1669h, C3801R.C3807layout.item_for_contact_list, this.f14728m);
        this.f14729n = c3841b;
        this.f14726k.setAdapter(c3841b);
        m44262m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("联系人列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        this.f14726k = (RecyclerView) findViewById(C3801R.C3805id.recyclerView);
        this.f14727l = (SideBar) findViewById(C3801R.C3805id.side_bar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
