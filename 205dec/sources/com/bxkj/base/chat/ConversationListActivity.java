package com.bxkj.base.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.R;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.y;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ConversationListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f18219k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f18220l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f18221m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f18222n;

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18224p;

    /* renamed from: q  reason: collision with root package name */
    private com.bxkj.base.chat.heart.a f18225q;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f18223o = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private BroadcastReceiver f18226r = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConversationListActivity.this.t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int i4, List list) {
            super(context, i4, list);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder viewHolder, Map<String, Object> map) {
            int i4 = JsonParse.getInt(map, "type") == 1 ? R.mipmap.ease_default_avatar : R.mipmap.ease_group_icon;
            viewHolder.t(R.id.avatar, JsonParse.getString(map, "photo"), i4, i4);
            viewHolder.J(R.id.name, JsonParse.getString(map, "userName"));
            viewHolder.J(R.id.message, JsonParse.getString(map, "lastMsg"));
            viewHolder.J(R.id.time, JsonParse.getString(map, "createTime"));
            viewHolder.N(R.id.msg_status, JsonParse.getBoolean(map, "local"));
            viewHolder.N(R.id.unread_msg_number, JsonParse.getInt(map, "status") == 0);
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (ConversationListActivity.this.f18219k == null || !ConversationListActivity.this.f18219k.S()) {
                return;
            }
            ConversationListActivity.this.f18219k.y();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ConversationListActivity.this.f18223o = JsonParse.getList(map, "data");
            for (int i4 = 0; i4 < ConversationListActivity.this.f18223o.size(); i4++) {
                Map map2 = (Map) ConversationListActivity.this.f18223o.get(i4);
                List u02 = ConversationListActivity.this.u0(JsonParse.getString(map2, "createTime"), com.tsn.chat.utils.a.c(), JsonParse.getInt(map2, "type"), JsonParse.getString(map2, "userId"), JsonParse.getString(map2, "groupId"), JsonParse.getString(map2, "userName"), JsonParse.getString(map2, "photo"));
                if (u02.size() > 0) {
                    ConversationListActivity.this.f18223o.set(i4, (Map) u02.get(u02.size() - 1));
                }
            }
            ConversationListActivity.this.f18224p.g(ConversationListActivity.this.f18223o);
        }
    }

    private void s0() {
        if (cn.bluemobi.dylan.base.utils.a.n().getActivity(ChatActivity.class) != null) {
            return;
        }
        com.bxkj.base.chat.heart.a aVar = this.f18225q;
        if (aVar != null) {
            aVar.a();
        }
        y0.a.a().l(this.f1656h);
        y0.a.a().e();
        if (y.a(this.f1656h, AlarmChatService.class.getName())) {
            com.orhanobut.logger.j.c("AlarmChatService----------isServiceRunning");
            stopService(new Intent(this.f1656h, AlarmChatService.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((q.a) Http.getApiService(q.a.class)).f()).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Map<String, Object>> u0(String str, String str2, int i4, String str3, String str4, String str5, String str6) {
        com.orhanobut.logger.j.c("\u67e5\u8be2\u5f00\u59cb\u65f6\u95f4=" + str + "\u7ed3\u675f\u65f6\u95f4=" + str2 + "\u7684\u79bb\u7ebf\u6d88\u606f");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("fromUserId = ? and ");
        String[] strArr = new String[4];
        strArr[0] = LoginUser.getLoginUser().getUserId();
        if (i4 == 1) {
            sb.append("toUserId = ?");
            strArr[1] = str3;
        } else {
            sb.append("groupId = ?");
            strArr[1] = str4;
        }
        sb.append(" and createTime >= ? and createTime < ?");
        strArr[2] = str;
        strArr[3] = str2;
        List<ChatMessageDb> query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ChatMessageDb.class, sb.toString(), strArr);
        if (query != null && query.size() > 0) {
            for (ChatMessageDb chatMessageDb : query) {
                String messageId = chatMessageDb.getMessageId();
                String msg = chatMessageDb.getMsg();
                String createTime = chatMessageDb.getCreateTime();
                HashMap hashMap = new HashMap();
                hashMap.put("messageId", messageId);
                hashMap.put("userId", str3);
                hashMap.put("groupId", str4);
                hashMap.put("userName", str5);
                hashMap.put("type", Integer.valueOf(i4));
                hashMap.put("photo", str6);
                hashMap.put("createTime", createTime);
                hashMap.put("lastMsg", msg);
                hashMap.put("local", Boolean.TRUE);
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    private void v0() {
        this.f18219k.O(false);
        this.f18220l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        b bVar = new b(this.f1656h, R.layout.item_for_conversation_list, this.f18223o);
        this.f18224p = bVar;
        this.f18220l.setAdapter(bVar);
        this.f18221m.setText("\u6682\u65e0\u6d88\u606f,\u4f60\u53ef\u4ee5\u70b9\u51fb\u53f3\u4e0a\u89d2\u8054\u7cfb\u4eba\u6309\u94ae\u53d1\u8d77\u4e92\u52a8\u804a\u5929\u6d88\u606f");
        this.f18220l.setEmptyView(this.f18221m);
        this.f18219k.m1(new s0.d() { // from class: com.bxkj.base.chat.n
            @Override // s0.d
            public final void q(r0.h hVar) {
                ConversationListActivity.this.y0(hVar);
            }
        });
        this.f18219k.a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(ViewGroup viewGroup, View view, Object obj, int i4) {
        t0();
        startActivity(new Intent(this.f1656h, ChatActivity.class).setFlags(TTAdConstant.KEY_CLICK_AREA).putExtra("chatName", JsonParse.getString(this.f18224p.getItem(i4), "userName")).putExtra("chatType", JsonParse.getInt(this.f18224p.getItem(i4), "type")).putExtra("groupId", JsonParse.getString(this.f18224p.getItem(i4), "groupId")).putExtra("userId", JsonParse.getString(this.f18224p.getItem(i4), "userId")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(boolean z3) {
        this.f18222n.setVisibility(z3 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y0(r0.h hVar) {
        t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0() {
        startActivity(new Intent(this.f1656h, ContactListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18224p.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.base.chat.l
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                ConversationListActivity.this.w0(viewGroup, view, obj, i4);
            }
        });
        LoginUser.getLoginUser().addChatConnectListener(new LoginUser.ChatConnectListener() { // from class: com.bxkj.base.chat.m
            @Override // com.bxkj.base.user.LoginUser.ChatConnectListener
            public final void connectStatusChange(boolean z3) {
                ConversationListActivity.this.x0(z3);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_conversation_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f18222n.setVisibility(LoginUser.getLoginUser().isChatConnectStatus() ? 8 : 0);
        v0();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS");
        intentFilter.addAction("NOTIFY_RECEIVER_MESSAGE");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f18226r, intentFilter);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f1a\u8bdd\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        this.f18219k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f18220l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.f18221m = (TextView) findViewById(R.id.tv_emptyView);
        int i4 = R.id.ll_status;
        this.f18222n = (LinearLayout) findViewById(i4);
        this.f18222n = (LinearLayout) findViewById(i4);
        b0(R.mipmap.my_write, new BaseActivity.c() { // from class: com.bxkj.base.chat.k
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ConversationListActivity.this.z0();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f18226r != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f18226r);
        }
        s0();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!y.a(this.f1656h, AlarmChatService.class.getName())) {
            com.orhanobut.logger.j.c("AlarmChatService----------isServiceStop");
            com.bxkj.base.chat.heart.a aVar = new com.bxkj.base.chat.heart.a(this.f1656h);
            this.f18225q = aVar;
            aVar.b();
        } else if (System.currentTimeMillis() - LoginUser.getLoginUser().getLastHeartCallBackTime() > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            com.orhanobut.logger.j.c("AlarmChatService----------timeout");
            com.bxkj.base.chat.heart.a aVar2 = new com.bxkj.base.chat.heart.a(this.f1656h);
            this.f18225q = aVar2;
            aVar2.b();
        } else {
            com.orhanobut.logger.j.c("AlarmChatService----------isServiceRunning");
        }
    }
}
