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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.bxkj.base.C3801R;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.chat.heart.AlarmChatTimer;
import com.bxkj.base.chat.heart.ChatBroadcastActionType;
import com.bxkj.base.chat.p084db.ChatMessageDb;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3919y;
import com.orhanobut.logger.C11792j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tsn.chat.utils.DateHelp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p635q.ChatApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshListener;
import p660y0.BaseApplication;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ConversationListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f14733k;

    /* renamed from: l */
    private EmptyRecyclerView f14734l;

    /* renamed from: m */
    private TextView f14735m;

    /* renamed from: n */
    private LinearLayout f14736n;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f14738p;

    /* renamed from: q */
    private AlarmChatTimer f14739q;

    /* renamed from: o */
    private List<Map<String, Object>> f14737o = new ArrayList();

    /* renamed from: r */
    private BroadcastReceiver f14740r = new C3843a();

    /* renamed from: com.bxkj.base.chat.ConversationListActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3843a extends BroadcastReceiver {
        C3843a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ConversationListActivity.this.m44247t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ConversationListActivity$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3844b extends CommonAdapter<Map<String, Object>> {
        C3844b(Context context, int i, List list) {
            super(context, i, list);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder viewHolder, Map<String, Object> map) {
            int i = JsonParse.getInt(map, "type") == 1 ? C3801R.mipmap.ease_default_avatar : C3801R.mipmap.ease_group_icon;
            viewHolder.m57850t(C3801R.C3805id.avatar, JsonParse.getString(map, "photo"), i, i);
            viewHolder.m57874J(C3801R.C3805id.name, JsonParse.getString(map, "userName"));
            viewHolder.m57874J(C3801R.C3805id.message, JsonParse.getString(map, "lastMsg"));
            viewHolder.m57874J(C3801R.C3805id.time, JsonParse.getString(map, "createTime"));
            viewHolder.m57870N(C3801R.C3805id.msg_status, JsonParse.getBoolean(map, "local"));
            viewHolder.m57870N(C3801R.C3805id.unread_msg_number, JsonParse.getInt(map, "status") == 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ConversationListActivity$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3845c extends HttpCallBack {
        C3845c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (ConversationListActivity.this.f14733k == null || !ConversationListActivity.this.f14733k.mo2061S()) {
                return;
            }
            ConversationListActivity.this.f14733k.mo2078B();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            ConversationListActivity.this.f14737o = JsonParse.getList(map, "data");
            for (int i = 0; i < ConversationListActivity.this.f14737o.size(); i++) {
                Map map2 = (Map) ConversationListActivity.this.f14737o.get(i);
                List m44246u0 = ConversationListActivity.this.m44246u0(JsonParse.getString(map2, "createTime"), DateHelp.m14863c(), JsonParse.getInt(map2, "type"), JsonParse.getString(map2, "userId"), JsonParse.getString(map2, "groupId"), JsonParse.getString(map2, "userName"), JsonParse.getString(map2, "photo"));
                if (m44246u0.size() > 0) {
                    ConversationListActivity.this.f14737o.set(i, (Map) m44246u0.get(m44246u0.size() - 1));
                }
            }
            ConversationListActivity.this.f14738p.m57836g(ConversationListActivity.this.f14737o);
        }
    }

    /* renamed from: s0 */
    private void m44248s0() {
        if (AppManager.m57776n().getActivity(ChatActivity.class) != null) {
            return;
        }
        AlarmChatTimer alarmChatTimer = this.f14739q;
        if (alarmChatTimer != null) {
            alarmChatTimer.m44222a();
        }
        BaseApplication.m38a().mo32l(this.f1669h);
        BaseApplication.m38a().mo36e();
        if (C3919y.m44006a(this.f1669h, AlarmChatService.class.getName())) {
            C11792j.m20470c("AlarmChatService----------isServiceRunning");
            stopService(new Intent(this.f1669h, AlarmChatService.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m44247t0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((ChatApiService) Http.getApiService(ChatApiService.class)).m2313f()).setDataListener(new C3845c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public List<Map<String, Object>> m44246u0(String str, String str2, int i, String str3, String str4, String str5, String str6) {
        C11792j.m20470c("查询开始时间=" + str + "结束时间=" + str2 + "的离线消息");
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder("fromUserId = ? and ");
        String[] strArr = new String[4];
        strArr[0] = LoginUser.getLoginUser().getUserId();
        if (i == 1) {
            sb.append("toUserId = ?");
            strArr[1] = str3;
        } else {
            sb.append("groupId = ?");
            strArr[1] = str4;
        }
        sb.append(" and createTime >= ? and createTime < ?");
        strArr[2] = str;
        strArr[3] = str2;
        List<ChatMessageDb> query = SQLiteDbUtil.m57474h().query(ChatMessageDb.class, sb.toString(), strArr);
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
                hashMap.put("type", Integer.valueOf(i));
                hashMap.put("photo", str6);
                hashMap.put("createTime", createTime);
                hashMap.put("lastMsg", msg);
                hashMap.put("local", Boolean.TRUE);
                arrayList.add(hashMap);
            }
        }
        return arrayList;
    }

    /* renamed from: v0 */
    private void m44245v0() {
        this.f14733k.mo2064P(false);
        this.f14734l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C3844b c3844b = new C3844b(this.f1669h, C3801R.C3807layout.item_for_conversation_list, this.f14737o);
        this.f14738p = c3844b;
        this.f14734l.setAdapter(c3844b);
        this.f14735m.setText("暂无消息,你可以点击右上角联系人按钮发起互动聊天消息");
        this.f14734l.setEmptyView(this.f14735m);
        this.f14733k.mo2035j(new OnRefreshListener() { // from class: com.bxkj.base.chat.n
            @Override // p642s0.OnRefreshListener
            /* renamed from: q */
            public final void mo322q(RefreshLayout refreshLayout) {
                ConversationListActivity.this.m44242y0(refreshLayout);
            }
        });
        this.f14733k.mo2052a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public /* synthetic */ void m44244w0(ViewGroup viewGroup, View view, Object obj, int i) {
        m44247t0();
        startActivity(new Intent(this.f1669h, ChatActivity.class).setFlags(67108864).putExtra("chatName", JsonParse.getString(this.f14738p.getItem(i), "userName")).putExtra("chatType", JsonParse.getInt(this.f14738p.getItem(i), "type")).putExtra("groupId", JsonParse.getString(this.f14738p.getItem(i), "groupId")).putExtra("userId", JsonParse.getString(this.f14738p.getItem(i), "userId")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public /* synthetic */ void m44243x0(boolean z) {
        this.f14736n.setVisibility(z ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y0 */
    public /* synthetic */ void m44242y0(RefreshLayout refreshLayout) {
        m44247t0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ void m44241z0() {
        startActivity(new Intent(this.f1669h, ContactListActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f14738p.m57834k(new OnItemClickListener() { // from class: com.bxkj.base.chat.l
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                ConversationListActivity.this.m44244w0(viewGroup, view, obj, i);
            }
        });
        LoginUser.getLoginUser().addChatConnectListener(new LoginUser.ChatConnectListener() { // from class: com.bxkj.base.chat.m
            @Override // com.bxkj.base.user.LoginUser.ChatConnectListener
            public final void connectStatusChange(boolean z) {
                ConversationListActivity.this.m44243x0(z);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_conversation_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f14736n.setVisibility(LoginUser.getLoginUser().isChatConnectStatus() ? 8 : 0);
        m44245v0();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS);
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f14740r, intentFilter);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("会话列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        this.f14733k = (SmartRefreshLayout) findViewById(C3801R.C3805id.refresh);
        this.f14734l = (EmptyRecyclerView) findViewById(C3801R.C3805id.recyclerView);
        this.f14735m = (TextView) findViewById(C3801R.C3805id.tv_emptyView);
        int i = C3801R.C3805id.ll_status;
        this.f14736n = (LinearLayout) findViewById(i);
        this.f14736n = (LinearLayout) findViewById(i);
        m57925b0(C3801R.mipmap.my_write, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.base.chat.k
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                ConversationListActivity.this.m44241z0();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f14740r != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f14740r);
        }
        m44248s0();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!C3919y.m44006a(this.f1669h, AlarmChatService.class.getName())) {
            C11792j.m20470c("AlarmChatService----------isServiceStop");
            AlarmChatTimer alarmChatTimer = new AlarmChatTimer(this.f1669h);
            this.f14739q = alarmChatTimer;
            alarmChatTimer.m44221b();
        } else if (System.currentTimeMillis() - LoginUser.getLoginUser().getLastHeartCallBackTime() > 10000) {
            C11792j.m20470c("AlarmChatService----------timeout");
            AlarmChatTimer alarmChatTimer2 = new AlarmChatTimer(this.f1669h);
            this.f14739q = alarmChatTimer2;
            alarmChatTimer2.m44221b();
        } else {
            C11792j.m20470c("AlarmChatService----------isServiceRunning");
        }
    }
}
