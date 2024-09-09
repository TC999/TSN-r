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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.HttpRequest;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.base.BaseApp;
import com.bxkj.base.R;
import com.bxkj.base.chat.ChatActivity;
import com.bxkj.base.chat.db.ChatMessageDb;
import com.bxkj.base.chat.heart.AlarmChatService;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.y;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tsn.chat.model.ChatModel;
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
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ChatActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f18169k;

    /* renamed from: l  reason: collision with root package name */
    private Button f18170l;

    /* renamed from: m  reason: collision with root package name */
    private ImageView f18171m;

    /* renamed from: n  reason: collision with root package name */
    private MultiItemCommonAdapter<Map<String, Object>> f18172n;

    /* renamed from: p  reason: collision with root package name */
    private String f18174p;

    /* renamed from: q  reason: collision with root package name */
    private String f18175q;

    /* renamed from: r  reason: collision with root package name */
    private Handler f18176r;

    /* renamed from: s  reason: collision with root package name */
    private Runnable f18177s;

    /* renamed from: t  reason: collision with root package name */
    private String f18178t;

    /* renamed from: u  reason: collision with root package name */
    private String f18179u;

    /* renamed from: v  reason: collision with root package name */
    private com.bxkj.base.chat.heart.a f18180v;

    /* renamed from: w  reason: collision with root package name */
    private RecyclerView f18181w;

    /* renamed from: x  reason: collision with root package name */
    private SmartRefreshLayout f18182x;

    /* renamed from: o  reason: collision with root package name */
    private int f18173o = 1;

    /* renamed from: y  reason: collision with root package name */
    private List<Map<String, Object>> f18183y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private BroadcastReceiver f18184z = new e();
    protected int A = 20;
    protected int B = 1;
    protected int C = 1;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int i4) {
            if (i4 == 1) {
                return R.layout.item_for_send_message;
            }
            return R.layout.item_for_receive_message;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c */
        public int a(int i4, Map<String, Object> map) {
            return LoginUser.getLoginUser().getUserId().equals(JsonParse.getString(map, "userId")) ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ChatMessageDb f18187a;

            a(ChatMessageDb chatMessageDb) {
                this.f18187a = chatMessageDb;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void b() {
                ChatActivity.this.f18172n.notifyDataSetChanged();
            }

            private void c() {
                ChatModel chatModel = new ChatModel();
                String messageId = this.f18187a.getMessageId();
                String c4 = com.tsn.chat.utils.a.c();
                String userId = LoginUser.getLoginUser().getUserId();
                String realName = LoginUser.getLoginUser().getRealName();
                String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                String valueOf = String.valueOf(ChatActivity.this.f18173o);
                String schoolCode = LoginUser.getLoginUser().getSchoolCode();
                chatModel.setMessageId(messageId);
                chatModel.setCreateTime(c4);
                chatModel.setFromUserId(userId);
                chatModel.setFromUserName(realName);
                chatModel.setPhoto(headImageUrl);
                chatModel.setType(valueOf);
                chatModel.setToUserId(ChatActivity.this.f18175q);
                chatModel.setToUserName(ChatActivity.this.f18179u);
                chatModel.setSchoolId(schoolCode);
                chatModel.setMsg(this.f18187a.getMsg());
                chatModel.setGroupId(ChatActivity.this.f18174p);
                if (ChatActivity.this.f18173o == 1) {
                    y0.a.a().o(chatModel);
                } else {
                    y0.a.a().m(chatModel);
                }
                this.f18187a.setCreateTime(c4);
                cn.bluemobi.dylan.sqlitelibrary.c.h().update(this.f18187a, "messageId=?", new String[]{messageId});
                b.this.notifyDataSetChanged();
                new Handler().postDelayed(new Runnable() { // from class: com.bxkj.base.chat.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatActivity.b.a.this.b();
                    }
                }, 60000L);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c();
            }
        }

        b(Context context, List list, cn.bluemobi.dylan.base.adapter.common.recyclerview.a aVar) {
            super(context, list, aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(Map map, View view) {
            String string = JsonParse.getString(map, "userId");
            if (LoginUser.getLoginUser().getUserId().equalsIgnoreCase(string) || LoginUser.getLoginUser().getUserType() != 2) {
                return;
            }
            ChatActivity.this.startActivity(new Intent(this.f1707a, ChatUserInfoActivity.class).putExtra("userId", string).putExtra("userName", JsonParse.getString(map, "userName")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(ViewHolder viewHolder, final Map<String, Object> map) {
            viewHolder.s(R.id.iv_head, JsonParse.getString(map, "photo"));
            viewHolder.J(R.id.tv_msg, JsonParse.getString(map, "msg"));
            if (getItemViewType(viewHolder.f()) == 1) {
                List query = cn.bluemobi.dylan.sqlitelibrary.c.h().query(ChatMessageDb.class, "messageId=?", new String[]{JsonParse.getString(map, "messageId")});
                if (query != null && query.size() > 0) {
                    ChatMessageDb chatMessageDb = (ChatMessageDb) query.get(0);
                    try {
                        if (System.currentTimeMillis() - new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(chatMessageDb.getCreateTime()).getTime() > 60000) {
                            int i4 = R.id.msg_status;
                            viewHolder.N(i4, true);
                            viewHolder.N(R.id.progress_bar, false);
                            viewHolder.w(i4, new a(chatMessageDb));
                        } else {
                            viewHolder.N(R.id.msg_status, false);
                            viewHolder.N(R.id.progress_bar, true);
                        }
                    } catch (ParseException e4) {
                        viewHolder.N(R.id.msg_status, true);
                        viewHolder.N(R.id.progress_bar, false);
                        e4.printStackTrace();
                    }
                } else {
                    viewHolder.N(R.id.progress_bar, false);
                    viewHolder.N(R.id.msg_status, false);
                }
            }
            viewHolder.J(R.id.tv_user, JsonParse.getString(map, "userName"));
            viewHolder.J(R.id.tv_date, JsonParse.getString(map, "createTime"));
            viewHolder.w(R.id.ll_user, new View.OnClickListener() { // from class: com.bxkj.base.chat.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatActivity.b.this.o(map, view);
                }
            });
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class c implements ViewTreeObserver.OnGlobalLayoutListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z3 = ChatActivity.this.f18181w.computeVerticalScrollRange() > ChatActivity.this.f18181w.computeVerticalScrollExtent();
            if (z3 && !((LinearLayoutManager) ChatActivity.this.f18181w.getLayoutManager()).getStackFromEnd()) {
                ((LinearLayoutManager) ChatActivity.this.f18181w.getLayoutManager()).setStackFromEnd(true);
            } else if (z3 || !((LinearLayoutManager) ChatActivity.this.f18181w.getLayoutManager()).getStackFromEnd()) {
            } else {
                ((LinearLayoutManager) ChatActivity.this.f18181w.getLayoutManager()).setStackFromEnd(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS")) {
                if (intent.hasExtra("messageId")) {
                    ChatActivity.this.getIntent().getStringExtra("messageId");
                    ChatActivity.this.f18172n.notifyDataSetChanged();
                }
            } else if (intent.getAction().equalsIgnoreCase("NOTIFY_RECEIVER_MESSAGE") && intent.hasExtra("chatType")) {
                int intExtra = intent.getIntExtra("chatType", 1);
                String stringExtra = intent.getStringExtra("userId");
                String stringExtra2 = intent.getStringExtra("userName");
                String stringExtra3 = intent.getStringExtra("photo");
                intent.getStringExtra("toUserName");
                String stringExtra4 = intent.getStringExtra("createTime");
                String stringExtra5 = intent.getStringExtra("msg");
                String stringExtra6 = intent.getStringExtra("groupId");
                if (intExtra == ChatActivity.this.f18173o && ChatActivity.this.f18173o == 1 && ChatActivity.this.f18175q.equalsIgnoreCase(stringExtra)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("userId", stringExtra);
                    hashMap.put("userName", stringExtra2);
                    hashMap.put("photo", stringExtra3);
                    hashMap.put("createTime", stringExtra4);
                    hashMap.put("msg", stringExtra5);
                    ChatActivity.this.f18183y.add(hashMap);
                    ChatActivity.this.f18172n.g(ChatActivity.this.f18183y);
                } else if (intExtra == ChatActivity.this.f18173o && ChatActivity.this.f18173o == 2 && ChatActivity.this.f18174p.equalsIgnoreCase(stringExtra6) && !LoginUser.getLoginUser().getUserId().equalsIgnoreCase(stringExtra)) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("userId", stringExtra);
                    hashMap2.put("userName", stringExtra2);
                    hashMap2.put("photo", stringExtra3);
                    hashMap2.put("createTime", stringExtra4);
                    hashMap2.put("msg", stringExtra5);
                    ChatActivity.this.f18183y.add(hashMap2);
                    ChatActivity.this.f18172n.g(ChatActivity.this.f18183y);
                }
            }
            ((LinearLayoutManager) ChatActivity.this.f18181w.getLayoutManager()).scrollToPositionWithOffset(ChatActivity.this.f18172n.getItemCount() - 1, Integer.MIN_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class f implements s0.e {
        f() {
        }

        @Override // s0.d
        public void q(r0.h hVar) {
            ChatActivity chatActivity = ChatActivity.this;
            int i4 = chatActivity.C;
            int i5 = chatActivity.A;
            int i6 = i4 / i5;
            int i7 = chatActivity.B;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                chatActivity.f18182x.y();
                Toast.makeText(((BaseActivity) ChatActivity.this).f1656h, "\u5df2\u5168\u90e8\u52a0\u8f7d\u5b8c\u6bd5", 0).show();
                return;
            }
            chatActivity.B = i7 + 1;
            chatActivity.w0();
        }

        @Override // s0.b
        public void s(r0.h hVar) {
            ChatActivity.this.C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class g extends HttpCallBack {
        g() {
        }

        private List<Map<String, Object>> b(String str, String str2) {
            com.orhanobut.logger.j.c("\u67e5\u8be2\u5f00\u59cb\u65f6\u95f4=" + str + "\u7ed3\u675f\u65f6\u95f4=" + str2 + "\u7684\u79bb\u7ebf\u6d88\u606f");
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("fromUserId = ? and ");
            String[] strArr = new String[4];
            strArr[0] = LoginUser.getLoginUser().getUserId();
            if (ChatActivity.this.f18173o == 1) {
                sb.append("toUserId = ?");
                strArr[1] = ChatActivity.this.f18175q;
            } else {
                sb.append("groupId = ?");
                strArr[1] = ChatActivity.this.f18174p;
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
        public static /* synthetic */ int c(Map map, Map map2) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(map, "createTime")).after(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(map2, "createTime"))) ? 1 : -1;
            } catch (ParseException e4) {
                e4.printStackTrace();
                return 0;
            }
        }

        private void d(List<Map<String, Object>> list) {
            Collections.sort(list, new Comparator() { // from class: com.bxkj.base.chat.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int c4;
                    c4 = ChatActivity.g.c((Map) obj, (Map) obj2);
                    return c4;
                }
            });
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            ChatActivity.this.f18182x.V(0);
            ChatActivity.this.f18182x.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            String str;
            ChatActivity.this.f18175q = JsonParse.getString(map, "userIds");
            Map<String, Object> map2 = JsonParse.getMap(map, "messages");
            ChatActivity.this.C = Integer.parseInt(u.O(map2, "total"));
            List<Map<String, Object>> list = JsonParse.getList(map2, "data");
            String c4 = com.tsn.chat.utils.a.c();
            str = "0";
            if (ChatActivity.this.B == 1) {
                c4 = com.tsn.chat.utils.a.c();
                str = list.size() != 0 ? JsonParse.getString(list.get(list.size() - 1), "createTime") : "0";
                ChatActivity.this.f18183y.clear();
            } else if (list.size() > 0) {
                str = JsonParse.getString(list.get(list.size() - 1), "createTime");
                c4 = JsonParse.getString((Map) ChatActivity.this.f18183y.get(ChatActivity.this.f18183y.size() - 1), "createTime");
            }
            list.addAll(b(str, c4));
            d(list);
            ChatActivity.this.f18183y.addAll(0, list);
            ChatActivity.this.f18172n.g(ChatActivity.this.f18183y);
            ChatActivity chatActivity = ChatActivity.this;
            if (chatActivity.B == 1) {
                ((LinearLayoutManager) chatActivity.f18181w.getLayoutManager()).scrollToPositionWithOffset(ChatActivity.this.f18172n.getItemCount() - 1, Integer.MIN_VALUE);
            } else {
                ((LinearLayoutManager) chatActivity.f18181w.getLayoutManager()).scrollToPositionWithOffset(list.size(), 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0() {
        this.f18172n.notifyDataSetChanged();
        LocalBroadcastManager.getInstance(this.f1656h).sendBroadcast(new Intent("NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS"));
    }

    private void B0(String str) {
        if (this.f18183y == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f18183y.size(); i4++) {
            if (JsonParse.getString(this.f18183y.get(i4), "isImg").equals("1")) {
                arrayList.add(JsonParse.getString(this.f18183y.get(i4), "content"));
            }
        }
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra("image_index", arrayList.indexOf(str));
        startActivity(intent);
        overridePendingTransition(R.anim.zoom_ente, R.anim.zoom_exit);
    }

    private void D0(File file) {
        String trim;
        Runnable runnable;
        if (file != null && file.exists()) {
            trim = cn.bluemobi.dylan.base.utils.b.b(F0(file.getPath()));
        } else {
            trim = this.f18169k.getText().toString().trim();
            if (trim.isEmpty()) {
                h0("\u5185\u5bb9\u4e0d\u80fd\u4e3a\u7a7a");
                return;
            }
        }
        ChatModel chatModel = new ChatModel();
        String uuid = UUID.randomUUID().toString();
        String c4 = com.tsn.chat.utils.a.c();
        String userId = LoginUser.getLoginUser().getUserId();
        String realName = LoginUser.getLoginUser().getRealName();
        String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
        String valueOf = String.valueOf(this.f18173o);
        String schoolCode = LoginUser.getLoginUser().getSchoolCode();
        chatModel.setMessageId(uuid);
        chatModel.setCreateTime(c4);
        chatModel.setFromUserId(userId);
        chatModel.setFromUserName(realName);
        chatModel.setPhoto(headImageUrl);
        chatModel.setType(valueOf);
        chatModel.setToUserId(this.f18175q);
        chatModel.setToUserName(this.f18179u);
        chatModel.setSchoolId(schoolCode);
        chatModel.setMsg(trim);
        chatModel.setGroupId(this.f18174p);
        if (this.f18173o == 1) {
            y0.a.a().o(chatModel);
        } else {
            y0.a.a().m(chatModel);
        }
        ChatMessageDb chatMessageDb = new ChatMessageDb();
        chatMessageDb.setFromUserId(userId);
        chatMessageDb.setFromUserName(realName);
        chatMessageDb.setToUserId(this.f18175q);
        chatMessageDb.setToUserName(this.f18179u);
        chatMessageDb.setCreateTime(c4);
        chatMessageDb.setGroupId(this.f18174p);
        chatMessageDb.setMessageId(uuid);
        chatMessageDb.setMsg(trim);
        chatMessageDb.setPhoto(headImageUrl);
        chatMessageDb.setType(valueOf);
        cn.bluemobi.dylan.sqlitelibrary.c.h().insert((cn.bluemobi.dylan.sqlitelibrary.c) chatMessageDb);
        HashMap hashMap = new HashMap();
        hashMap.put("messageId", uuid);
        hashMap.put("userId", userId);
        hashMap.put("userName", realName);
        hashMap.put("createTime", c4);
        hashMap.put("photo", headImageUrl);
        hashMap.put("msg", trim);
        this.f18183y.add(hashMap);
        this.f18172n.g(this.f18183y);
        this.f18169k.setText("");
        ((LinearLayoutManager) this.f18181w.getLayoutManager()).scrollToPositionWithOffset(this.f18172n.getItemCount() - 1, Integer.MIN_VALUE);
        Handler handler = this.f18176r;
        if (handler != null && (runnable = this.f18177s) != null) {
            handler.removeCallbacks(runnable);
        }
        this.f18176r = new Handler();
        Runnable runnable2 = new Runnable() { // from class: com.bxkj.base.chat.b
            @Override // java.lang.Runnable
            public final void run() {
                ChatActivity.this.A0();
            }
        };
        this.f18177s = runnable2;
        this.f18176r.postDelayed(runnable2, 60000L);
    }

    private void E0() {
        Http.with(this.f1656h).hideLoadingDialog().hideOtherStatusMessage().hideSuccessMessage().hideFailMessage().setObservable(((q.a) Http.getApiService(q.a.class)).b(this.f18173o, this.f18175q, this.f18174p)).setDataListener(new d());
    }

    public static byte[] F0(String str) {
        Throwable th;
        FileChannel fileChannel;
        try {
            fileChannel = new RandomAccessFile(str, "r").getChannel();
        } catch (IOException e4) {
            e = e4;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
            try {
                fileChannel.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                fileChannel.close();
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            e.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e8) {
                e8.printStackTrace();
            }
            return null;
        }
    }

    private void v0() {
        if (cn.bluemobi.dylan.base.utils.a.n().getActivity(ConversationListActivity.class) != null) {
            return;
        }
        com.bxkj.base.chat.heart.a aVar = this.f18180v;
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
    public /* synthetic */ void y0() {
        startActivity(getIntent().setClass(this.f1656h, ChatInfoActivity.class).putExtra("groupId", this.f18174p));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 z0(File file) {
        D0(file);
        return null;
    }

    public void C0() {
        this.B = 1;
        w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18170l.setOnClickListener(this);
        this.f18171m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_chat;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f18178t = com.tsn.chat.utils.a.c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS");
        intentFilter.addAction("NOTIFY_RECEIVER_MESSAGE");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f18184z, intentFilter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f1656h);
        linearLayoutManager.setStackFromEnd(true);
        this.f18181w.setLayoutManager(linearLayoutManager);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(1);
        this.f18181w.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, this.f18183y, new a());
        this.f18172n = bVar;
        this.f18181w.setAdapter(bVar);
        this.f18181w.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        x0();
        this.f18182x.q();
        E0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5e08\u751f\u4e92\u52a8");
        if (getIntent().hasExtra("chatName")) {
            String stringExtra = getIntent().getStringExtra("chatName");
            this.f18179u = stringExtra;
            setTitle(stringExtra);
        }
        if (getIntent().hasExtra("chatType")) {
            this.f18173o = getIntent().getIntExtra("chatType", 1);
        }
        if (getIntent().hasExtra("groupId")) {
            this.f18174p = getIntent().getStringExtra("groupId");
        }
        if (getIntent().hasExtra("userId")) {
            this.f18175q = getIntent().getStringExtra("userId");
        }
        if (this.f18173o == 2) {
            b0(R.mipmap.setting_white, new BaseActivity.c() { // from class: com.bxkj.base.chat.a
                @Override // cn.bluemobi.dylan.base.BaseActivity.c
                public final void onClick() {
                    ChatActivity.this.y0();
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle bundle) {
        this.f18181w = (RecyclerView) findViewById(R.id.recyclerView);
        this.f18182x = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f18169k = (EditText) findViewById(R.id.et_reply);
        this.f18170l = (Button) findViewById(R.id.bt_ok);
        this.f18171m = (ImageView) findViewById(R.id.bt_add);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bt_ok) {
            D0(null);
        } else if (id == R.id.bt_add) {
            com.bxkj.base.v2.common.utils.k.f18613a.p(this.f1657i, new l1.l() { // from class: com.bxkj.base.chat.c
                @Override // l1.l
                public final Object invoke(Object obj) {
                    f1 z02;
                    z02 = ChatActivity.this.z0((File) obj);
                    return z02;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Runnable runnable;
        Handler handler = this.f18176r;
        if (handler != null && (runnable = this.f18177s) != null) {
            handler.removeCallbacks(runnable);
        }
        if (this.f18184z != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f18184z);
        }
        v0();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BaseApp.g(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BaseApp.g(false);
        if (!y.a(this.f1656h, AlarmChatService.class.getName())) {
            com.orhanobut.logger.j.c("AlarmChatService----------isServiceStop");
            com.bxkj.base.chat.heart.a aVar = new com.bxkj.base.chat.heart.a(this.f1656h);
            this.f18180v = aVar;
            aVar.b();
        } else if (System.currentTimeMillis() - LoginUser.getLoginUser().getLastHeartCallBackTime() > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            com.orhanobut.logger.j.c("AlarmChatService----------timeout");
            com.bxkj.base.chat.heart.a aVar2 = new com.bxkj.base.chat.heart.a(this.f1656h);
            this.f18180v = aVar2;
            aVar2.b();
        } else {
            com.orhanobut.logger.j.c("AlarmChatService----------isServiceRunning");
        }
    }

    public void w0() {
        HttpRequest hideLoadingDialog = Http.with(this.f1656h).hideLoadingDialog();
        q.a aVar = (q.a) Http.getApiService(q.a.class);
        int i4 = this.f18173o;
        hideLoadingDialog.setObservable(aVar.c(i4, i4 == 1 ? this.f18175q : null, i4 == 2 ? this.f18174p : null, Integer.valueOf(this.A), Integer.valueOf(this.B), this.B == 1 ? null : this.f18178t)).setDataListener(new g());
    }

    public void x0() {
        this.f18182x.Y(2.0f);
        this.f18182x.G(u.a(50.0f, this.f1656h));
        this.f18182x.n1(new f());
    }
}
