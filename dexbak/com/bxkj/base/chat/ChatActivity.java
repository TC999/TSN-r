package com.bxkj.base.chat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.C1138b;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.bxkj.base.BaseApp;
import com.bxkj.base.C3801R;
import com.bxkj.base.chat.ChatActivity;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.chat.heart.AlarmChatTimer;
import com.bxkj.base.chat.heart.ChatBroadcastActionType;
import com.bxkj.base.chat.p084db.ChatMessageDb;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3919y;
import com.orhanobut.logger.C11792j;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tsn.chat.model.ChatModel;
import com.tsn.chat.utils.DateHelp;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p635q.ChatApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p660y0.BaseApplication;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ChatActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f14683k;

    /* renamed from: l */
    private Button f14684l;

    /* renamed from: m */
    private ImageView f14685m;

    /* renamed from: n */
    private MultiItemCommonAdapter<Map<String, Object>> f14686n;

    /* renamed from: p */
    private String f14688p;

    /* renamed from: q */
    private String f14689q;

    /* renamed from: r */
    private Handler f14690r;

    /* renamed from: s */
    private Runnable f14691s;

    /* renamed from: t */
    private String f14692t;

    /* renamed from: u */
    private String f14693u;

    /* renamed from: v */
    private AlarmChatTimer f14694v;

    /* renamed from: w */
    private RecyclerView f14695w;

    /* renamed from: x */
    private SmartRefreshLayout f14696x;

    /* renamed from: o */
    private int f14687o = 1;

    /* renamed from: y */
    private List<Map<String, Object>> f14697y = new ArrayList();

    /* renamed from: z */
    private BroadcastReceiver f14698z = new C3834e();

    /* renamed from: A */
    protected int f14680A = 20;

    /* renamed from: B */
    protected int f14681B = 1;

    /* renamed from: C */
    protected int f14682C = 1;

    /* renamed from: com.bxkj.base.chat.ChatActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3829a implements InterfaceC1125a<Map<String, Object>> {
        C3829a() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: b */
        public int mo40464b(int i) {
            if (i == 1) {
                return C3801R.C3807layout.item_for_send_message;
            }
            return C3801R.C3807layout.item_for_receive_message;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: c */
        public int mo40465a(int i, Map<String, Object> map) {
            return LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(map, "userId")) ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ChatActivity$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3830b extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.base.chat.ChatActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public class View$OnClickListenerC3831a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ ChatMessageDb f14701a;

            View$OnClickListenerC3831a(ChatMessageDb chatMessageDb) {
                this.f14701a = chatMessageDb;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: b */
            public /* synthetic */ void m44291b() {
                ChatActivity.this.f14686n.notifyDataSetChanged();
            }

            /* renamed from: c */
            private void m44290c() {
                ChatModel chatModel = new ChatModel();
                String messageId = this.f14701a.getMessageId();
                String m14863c = DateHelp.m14863c();
                String userId = LoginUser.getLoginUser().getUserId();
                String realName = LoginUser.getLoginUser().getRealName();
                String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                String valueOf = String.valueOf(ChatActivity.this.f14687o);
                String schoolCode = LoginUser.getLoginUser().getSchoolCode();
                chatModel.setMessageId(messageId);
                chatModel.setCreateTime(m14863c);
                chatModel.setFromUserId(userId);
                chatModel.setFromUserName(realName);
                chatModel.setPhoto(headImageUrl);
                chatModel.setType(valueOf);
                chatModel.setToUserId(ChatActivity.this.f14689q);
                chatModel.setToUserName(ChatActivity.this.f14693u);
                chatModel.setSchoolId(schoolCode);
                chatModel.setMsg(this.f14701a.getMsg());
                chatModel.setGroupId(ChatActivity.this.f14688p);
                if (ChatActivity.this.f14687o == 1) {
                    BaseApplication.m38a().mo29o(chatModel);
                } else {
                    BaseApplication.m38a().mo31m(chatModel);
                }
                this.f14701a.setCreateTime(m14863c);
                SQLiteDbUtil.m57474h().update(this.f14701a, "messageId=?", new String[]{messageId});
                C3830b.this.notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() { // from class: com.bxkj.base.chat.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatActivity.C3830b.View$OnClickListenerC3831a.this.m44291b();
                    }
                }, 60000L);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m44290c();
            }
        }

        C3830b(Context context, List list, InterfaceC1125a interfaceC1125a) {
            super(context, list, interfaceC1125a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void m44293o(Map map, View view) {
            String string = JsonParse.getString(map, "userId");
            if (LoginUser.getLoginUser().getUserId().equalsIgnoreCase(string) || LoginUser.getLoginUser().getUserType() != 2) {
                return;
            }
            ChatActivity.this.startActivity(new Intent(this.f1721a, ChatUserInfoActivity.class).putExtra("userId", string).putExtra("userName", JsonParse.getString(map, "userName")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void mo39408c(ViewHolder viewHolder, final Map<String, Object> map) {
            viewHolder.m57851s(C3801R.C3805id.iv_head, JsonParse.getString(map, "photo"));
            viewHolder.m57874J(C3801R.C3805id.tv_msg, JsonParse.getString(map, "msg"));
            if (getItemViewType(viewHolder.m57864f()) == 1) {
                List query = SQLiteDbUtil.m57474h().query(ChatMessageDb.class, "messageId=?", new String[]{JsonParse.getString(map, "messageId")});
                if (query != null && query.size() > 0) {
                    ChatMessageDb chatMessageDb = (ChatMessageDb) query.get(0);
                    try {
                        if (System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(chatMessageDb.getCreateTime()).getTime() > 60000) {
                            int i = C3801R.C3805id.msg_status;
                            viewHolder.m57870N(i, true);
                            viewHolder.m57870N(C3801R.C3805id.progress_bar, false);
                            viewHolder.m57847w(i, new View$OnClickListenerC3831a(chatMessageDb));
                        } else {
                            viewHolder.m57870N(C3801R.C3805id.msg_status, false);
                            viewHolder.m57870N(C3801R.C3805id.progress_bar, true);
                        }
                    } catch (ParseException e) {
                        viewHolder.m57870N(C3801R.C3805id.msg_status, true);
                        viewHolder.m57870N(C3801R.C3805id.progress_bar, false);
                        e.printStackTrace();
                    }
                } else {
                    viewHolder.m57870N(C3801R.C3805id.progress_bar, false);
                    viewHolder.m57870N(C3801R.C3805id.msg_status, false);
                }
            }
            viewHolder.m57874J(C3801R.C3805id.tv_user, JsonParse.getString(map, "userName"));
            viewHolder.m57874J(C3801R.C3805id.tv_date, JsonParse.getString(map, "createTime"));
            viewHolder.m57847w(C3801R.C3805id.ll_user, new View.OnClickListener() { // from class: com.bxkj.base.chat.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatActivity.C3830b.this.m44293o(map, view);
                }
            });
        }
    }

    /* renamed from: com.bxkj.base.chat.ChatActivity$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class ViewTreeObserver$OnGlobalLayoutListenerC3832c implements ViewTreeObserver.OnGlobalLayoutListener {
        ViewTreeObserver$OnGlobalLayoutListenerC3832c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z = ChatActivity.this.f14695w.computeVerticalScrollRange() > ChatActivity.this.f14695w.computeVerticalScrollExtent();
            if (z && !((LinearLayoutManager) ChatActivity.this.f14695w.getLayoutManager()).getStackFromEnd()) {
                ((LinearLayoutManager) ChatActivity.this.f14695w.getLayoutManager()).setStackFromEnd(true);
            } else if (z || !((LinearLayoutManager) ChatActivity.this.f14695w.getLayoutManager()).getStackFromEnd()) {
            } else {
                ((LinearLayoutManager) ChatActivity.this.f14695w.getLayoutManager()).setStackFromEnd(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ChatActivity$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3833d extends HttpCallBack {
        C3833d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
        }
    }

    /* renamed from: com.bxkj.base.chat.ChatActivity$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3834e extends BroadcastReceiver {
        C3834e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS)) {
                if (intent.hasExtra("messageId")) {
                    ChatActivity.this.getIntent().getStringExtra("messageId");
                    ChatActivity.this.f14686n.notifyDataSetChanged();
                }
            } else if (intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE) && intent.hasExtra("chatType")) {
                int intExtra = intent.getIntExtra("chatType", 1);
                String stringExtra = intent.getStringExtra("userId");
                String stringExtra2 = intent.getStringExtra("userName");
                String stringExtra3 = intent.getStringExtra("photo");
                intent.getStringExtra("toUserName");
                String stringExtra4 = intent.getStringExtra("createTime");
                String stringExtra5 = intent.getStringExtra("msg");
                String stringExtra6 = intent.getStringExtra("groupId");
                if (intExtra == ChatActivity.this.f14687o && ChatActivity.this.f14687o == 1 && ChatActivity.this.f14689q.equalsIgnoreCase(stringExtra)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("userId", stringExtra);
                    hashMap.put("userName", stringExtra2);
                    hashMap.put("photo", stringExtra3);
                    hashMap.put("createTime", stringExtra4);
                    hashMap.put("msg", stringExtra5);
                    ChatActivity.this.f14697y.add(hashMap);
                    ChatActivity.this.f14686n.m57836g(ChatActivity.this.f14697y);
                } else if (intExtra == ChatActivity.this.f14687o && ChatActivity.this.f14687o == 2 && ChatActivity.this.f14688p.equalsIgnoreCase(stringExtra6) && !LoginUser.getLoginUser().getUserId().equalsIgnoreCase(stringExtra)) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("userId", stringExtra);
                    hashMap2.put("userName", stringExtra2);
                    hashMap2.put("photo", stringExtra3);
                    hashMap2.put("createTime", stringExtra4);
                    hashMap2.put("msg", stringExtra5);
                    ChatActivity.this.f14697y.add(hashMap2);
                    ChatActivity.this.f14686n.m57836g(ChatActivity.this.f14697y);
                }
            }
            ((LinearLayoutManager) ChatActivity.this.f14695w.getLayoutManager()).scrollToPositionWithOffset(ChatActivity.this.f14686n.getItemCount() - 1, Integer.MIN_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ChatActivity$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3835f implements OnRefreshLoadmoreListener {
        C3835f() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshLayout) {
            ChatActivity chatActivity = ChatActivity.this;
            int i = chatActivity.f14682C;
            int i2 = chatActivity.f14680A;
            int i3 = i / i2;
            int i4 = chatActivity.f14681B;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                chatActivity.f14696x.mo2078B();
                Toast.makeText(((BaseActivity) ChatActivity.this).f1669h, "已全部加载完毕", 0).show();
                return;
            }
            chatActivity.f14681B = i4 + 1;
            chatActivity.m44300w0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshLayout) {
            ChatActivity.this.m44318C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.ChatActivity$g */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3836g extends HttpCallBack {
        C3836g() {
        }

        /* renamed from: b */
        private List<Map<String, Object>> m44288b(String str, String str2) {
            C11792j.m20470c("查询开始时间=" + str + "结束时间=" + str2 + "的离线消息");
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("fromUserId = ? and ");
            String[] strArr = new String[4];
            strArr[0] = LoginUser.getLoginUser().getUserId();
            if (ChatActivity.this.f14687o == 1) {
                sb.append("toUserId = ?");
                strArr[1] = ChatActivity.this.f14689q;
            } else {
                sb.append("groupId = ?");
                strArr[1] = ChatActivity.this.f14688p;
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
                    String userId = LoginUser.getLoginUser().getUserId();
                    String realName = LoginUser.getLoginUser().getRealName();
                    String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                    HashMap hashMap = new HashMap();
                    hashMap.put("messageId", messageId);
                    hashMap.put("userId", userId);
                    hashMap.put("userName", realName);
                    hashMap.put("photo", headImageUrl);
                    hashMap.put("createTime", createTime);
                    hashMap.put("msg", msg);
                    arrayList.add(hashMap);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public static /* synthetic */ int m44287c(Map map, Map map2) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(map, "createTime")).after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(map2, "createTime"))) ? 1 : -1;
            } catch (ParseException e) {
                e.printStackTrace();
                return 0;
            }
        }

        /* renamed from: d */
        private void m44286d(List<Map<String, Object>> list) {
            Collections.sort(list, new Comparator() { // from class: com.bxkj.base.chat.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int m44287c;
                    m44287c = ChatActivity.C3836g.m44287c((Map) obj, (Map) obj2);
                    return m44287c;
                }
            });
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ChatActivity.this.f14696x.mo2057W(0);
            ChatActivity.this.f14696x.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            String str;
            ChatActivity.this.f14689q = JsonParse.getString(map, "userIds");
            Map<String, Object> map2 = JsonParse.getMap(map, "messages");
            ChatActivity.this.f14682C = Integer.parseInt(Tools.m57632O(map2, "total"));
            List<Map<String, Object>> list = JsonParse.getList(map2, "data");
            String m14863c = DateHelp.m14863c();
            str = "0";
            if (ChatActivity.this.f14681B == 1) {
                m14863c = DateHelp.m14863c();
                str = list.size() != 0 ? JsonParse.getString(list.get(list.size() - 1), "createTime") : "0";
                ChatActivity.this.f14697y.clear();
            } else if (list.size() > 0) {
                str = JsonParse.getString(list.get(list.size() - 1), "createTime");
                m14863c = JsonParse.getString((Map) ChatActivity.this.f14697y.get(ChatActivity.this.f14697y.size() - 1), "createTime");
            }
            list.addAll(m44288b(str, m14863c));
            m44286d(list);
            ChatActivity.this.f14697y.addAll(0, list);
            ChatActivity.this.f14686n.m57836g(ChatActivity.this.f14697y);
            ChatActivity chatActivity = ChatActivity.this;
            if (chatActivity.f14681B == 1) {
                ((LinearLayoutManager) chatActivity.f14695w.getLayoutManager()).scrollToPositionWithOffset(ChatActivity.this.f14686n.getItemCount() - 1, Integer.MIN_VALUE);
            } else {
                ((LinearLayoutManager) chatActivity.f14695w.getLayoutManager()).scrollToPositionWithOffset(list.size(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public /* synthetic */ void m44320A0() {
        this.f14686n.notifyDataSetChanged();
        LocalBroadcastManager.getInstance(this.f1669h).sendBroadcast(new Intent(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS));
    }

    /* renamed from: B0 */
    private void m44319B0(String str) {
        if (this.f14697y == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f14697y.size(); i++) {
            if (JsonParse.getString(this.f14697y.get(i), "isImg").equals("1")) {
                arrayList.add(JsonParse.getString(this.f14697y.get(i), "content"));
            }
        }
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra(ImagePagerActivity.f1868g, arrayList.indexOf(str));
        startActivity(intent);
        overridePendingTransition(C3801R.anim.zoom_ente, C3801R.anim.zoom_exit);
    }

    /* renamed from: D0 */
    private void m44317D0(File file) {
        String trim;
        Runnable runnable;
        if (file != null && file.exists()) {
            trim = C1138b.m57768b(m44315F0(file.getPath()));
        } else {
            trim = this.f14683k.getText().toString().trim();
            if (trim.isEmpty()) {
                m57919h0("内容不能为空");
                return;
            }
        }
        ChatModel chatModel = new ChatModel();
        String uuid = UUID.randomUUID().toString();
        String m14863c = DateHelp.m14863c();
        String userId = LoginUser.getLoginUser().getUserId();
        String realName = LoginUser.getLoginUser().getRealName();
        String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
        String valueOf = String.valueOf(this.f14687o);
        String schoolCode = LoginUser.getLoginUser().getSchoolCode();
        chatModel.setMessageId(uuid);
        chatModel.setCreateTime(m14863c);
        chatModel.setFromUserId(userId);
        chatModel.setFromUserName(realName);
        chatModel.setPhoto(headImageUrl);
        chatModel.setType(valueOf);
        chatModel.setToUserId(this.f14689q);
        chatModel.setToUserName(this.f14693u);
        chatModel.setSchoolId(schoolCode);
        chatModel.setMsg(trim);
        chatModel.setGroupId(this.f14688p);
        if (this.f14687o == 1) {
            BaseApplication.m38a().mo29o(chatModel);
        } else {
            BaseApplication.m38a().mo31m(chatModel);
        }
        ChatMessageDb chatMessageDb = new ChatMessageDb();
        chatMessageDb.setFromUserId(userId);
        chatMessageDb.setFromUserName(realName);
        chatMessageDb.setToUserId(this.f14689q);
        chatMessageDb.setToUserName(this.f14693u);
        chatMessageDb.setCreateTime(m14863c);
        chatMessageDb.setGroupId(this.f14688p);
        chatMessageDb.setMessageId(uuid);
        chatMessageDb.setMsg(trim);
        chatMessageDb.setPhoto(headImageUrl);
        chatMessageDb.setType(valueOf);
        SQLiteDbUtil.m57474h().insert((SQLiteDbUtil) chatMessageDb);
        HashMap hashMap = new HashMap();
        hashMap.put("messageId", uuid);
        hashMap.put("userId", userId);
        hashMap.put("userName", realName);
        hashMap.put("createTime", m14863c);
        hashMap.put("photo", headImageUrl);
        hashMap.put("msg", trim);
        this.f14697y.add(hashMap);
        this.f14686n.m57836g(this.f14697y);
        this.f14683k.setText("");
        ((LinearLayoutManager) this.f14695w.getLayoutManager()).scrollToPositionWithOffset(this.f14686n.getItemCount() - 1, Integer.MIN_VALUE);
        Handler handler = this.f14690r;
        if (handler != null && (runnable = this.f14691s) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f14690r = new Handler();
        Runnable runnable2 = new Runnable() { // from class: com.bxkj.base.chat.b
            @Override // java.lang.Runnable
            public final void run() {
                ChatActivity.this.m44320A0();
            }
        };
        this.f14691s = runnable2;
        this.f14690r.postDelayed(runnable2, 60000L);
    }

    /* renamed from: E0 */
    private void m44316E0() {
        Http.with(this.f1669h).hideLoadingDialog().hideOtherStatusMessage().hideSuccessMessage().hideFailMessage().setObservable(((ChatApiService) Http.getApiService(ChatApiService.class)).m2317b(this.f14687o, this.f14689q, this.f14688p)).setDataListener(new C3833d());
    }

    /* renamed from: F0 */
    public static byte[] m44315F0(String str) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(str, "r").getChannel();
        } catch (IOException e) {
            e = e;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                C11792j.m20470c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: v0 */
    private void m44301v0() {
        if (AppManager.m57776n().getActivity(ConversationListActivity.class) != null) {
            return;
        }
        AlarmChatTimer alarmChatTimer = this.f14694v;
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
    /* renamed from: y0 */
    public /* synthetic */ void m44298y0() {
        startActivity(getIntent().setClass(this.f1669h, ChatInfoActivity.class).putExtra("groupId", this.f14688p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public /* synthetic */ Unit m44297z0(File file) {
        m44317D0(file);
        return null;
    }

    /* renamed from: C0 */
    public void m44318C0() {
        this.f14681B = 1;
        m44300w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f14684l.setOnClickListener(this);
        this.f14685m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C3801R.C3807layout.ac_chat;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f14692t = DateHelp.m14863c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS);
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_RECEIVER_MESSAGE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f14698z, intentFilter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f1669h);
        linearLayoutManager.setStackFromEnd(true);
        this.f14695w.setLayoutManager(linearLayoutManager);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C3801R.anim.zoom_in));
        layoutAnimationController.setOrder(1);
        this.f14695w.setLayoutAnimation(layoutAnimationController);
        C3830b c3830b = new C3830b(this.f1669h, this.f14697y, new C3829a());
        this.f14686n = c3830b;
        this.f14695w.setAdapter(c3830b);
        this.f14695w.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC3832c());
        m44299x0();
        this.f14696x.mo2024q();
        m44316E0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("师生互动");
        if (getIntent().hasExtra("chatName")) {
            String stringExtra = getIntent().getStringExtra("chatName");
            this.f14693u = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("chatType")) {
            this.f14687o = getIntent().getIntExtra("chatType", 1);
        }
        if (getIntent().hasExtra("groupId")) {
            this.f14688p = getIntent().getStringExtra("groupId");
        }
        if (getIntent().hasExtra("userId")) {
            this.f14689q = getIntent().getStringExtra("userId");
        }
        if (this.f14687o == 2) {
            m57925b0(C3801R.mipmap.setting_white, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.base.chat.a
                @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
                public final void onClick() {
                    ChatActivity.this.m44298y0();
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle bundle) {
        this.f14695w = (RecyclerView) findViewById(C3801R.C3805id.recyclerView);
        this.f14696x = (SmartRefreshLayout) findViewById(C3801R.C3805id.refresh);
        this.f14683k = (EditText) findViewById(C3801R.C3805id.et_reply);
        this.f14684l = (Button) findViewById(C3801R.C3805id.bt_ok);
        this.f14685m = (ImageView) findViewById(C3801R.C3805id.bt_add);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == C3801R.C3805id.bt_ok) {
            m44317D0(null);
        } else if (id == C3801R.C3805id.bt_add) {
            ImageSelectUtils.f15123a.m43786p(this.f1670i, new InterfaceC15280l() { // from class: com.bxkj.base.chat.c
                @Override // p617l1.InterfaceC15280l
                public final Object invoke(Object obj) {
                    Unit m44297z0;
                    m44297z0 = ChatActivity.this.m44297z0((File) obj);
                    return m44297z0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Runnable runnable;
        Handler handler = this.f14690r;
        if (handler != null && (runnable = this.f14691s) != null) {
            handler.removeCallbacks(runnable);
        }
        if (this.f14698z != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f14698z);
        }
        m44301v0();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BaseApp.m44336g(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BaseApp.m44336g(false);
        if (!C3919y.m44006a(this.f1669h, AlarmChatService.class.getName())) {
            C11792j.m20470c("AlarmChatService----------isServiceStop");
            AlarmChatTimer alarmChatTimer = new AlarmChatTimer(this.f1669h);
            this.f14694v = alarmChatTimer;
            alarmChatTimer.m44221b();
        } else if (System.currentTimeMillis() - LoginUser.getLoginUser().getLastHeartCallBackTime() > 10000) {
            C11792j.m20470c("AlarmChatService----------timeout");
            AlarmChatTimer alarmChatTimer2 = new AlarmChatTimer(this.f1669h);
            this.f14694v = alarmChatTimer2;
            alarmChatTimer2.m44221b();
        } else {
            C11792j.m20470c("AlarmChatService----------isServiceRunning");
        }
    }

    /* renamed from: w0 */
    public void m44300w0() {
        HttpRequest hideLoadingDialog = Http.with(this.f1669h).hideLoadingDialog();
        ChatApiService chatApiService = (ChatApiService) Http.getApiService(ChatApiService.class);
        int i = this.f14687o;
        hideLoadingDialog.setObservable(chatApiService.m2316c(i, i == 1 ? this.f14689q : null, i == 2 ? this.f14688p : null, Integer.valueOf(this.f14680A), Integer.valueOf(this.f14681B), this.f14681B == 1 ? null : this.f14692t)).setDataListener(new C3836g());
    }

    /* renamed from: x0 */
    public void m44299x0() {
        this.f14696x.mo2054Z(2.0f);
        this.f14696x.mo2070J(Tools.m57620a(50.0f, this.f1669h));
        this.f14696x.mo2019v(new C3835f());
    }
}
