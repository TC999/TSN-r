package com.bxkj.base.chat.heart;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.orhanobut.logger.C11792j;
import java.util.Map;
import p635q.ChatApiService;
import p660y0.BaseApplication;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AlarmChatService extends Service {

    /* renamed from: a */
    private AlarmChatTimer f14765a;

    /* renamed from: b */
    private long f14766b;

    /* renamed from: c */
    private BroadcastReceiver f14767c = new C3856a();

    /* renamed from: com.bxkj.base.chat.heart.AlarmChatService$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3856a extends BroadcastReceiver {
        C3856a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS)) {
                AlarmChatService.this.m44223d(System.currentTimeMillis());
                LoginUser.getLoginUser().setChatConnectStatus(true);
            } else if (!intent.getAction().equalsIgnoreCase(ChatBroadcastActionType.NOTIFY_CONNECT_CLOSE) || AlarmChatService.this.f14765a == null) {
            } else {
                AlarmChatService.this.f14765a.m44222a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.chat.heart.AlarmChatService$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3857b extends HttpCallBack {

        /* renamed from: com.bxkj.base.chat.heart.AlarmChatService$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class C3858a extends Thread {

            /* renamed from: a */
            final /* synthetic */ Map f14770a;

            C3858a(Map map) {
                this.f14770a = map;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(this.f14770a, "collectPhoto"));
                String string = JsonParse.getString(this.f14770a, "school");
                LoginUser.getLoginUser().setSchoolCode(string);
                BaseApplication.m38a().mo32l(BaseApp.m44341b());
                String string2 = JsonParse.getString(this.f14770a, "serverIp");
                String string3 = JsonParse.getString(this.f14770a, "port");
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string)) {
                    try {
                        BaseApplication.m38a().mo35g(LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getSchoolCode(), string2, string3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    AlarmChatService.this.f14765a = new AlarmChatTimer(BaseApp.m44341b());
                    AlarmChatService.this.f14765a.m44221b();
                    C11792j.m20470c("连接聊天服务器");
                    return;
                }
                AlarmChatService.this.stopSelf();
                C11792j.m20470c("不进行连接");
            }
        }

        C3857b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            new C3858a(map).start();
        }
    }

    /* renamed from: c */
    private void m44224c() {
        Http.with(this).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((ChatApiService) Http.getApiService(ChatApiService.class)).m2318a()).setDataListener(new C3857b());
    }

    /* renamed from: d */
    public void m44223d(long j) {
        this.f14766b = j;
        LoginUser.getLoginUser().setLastHeartCallBackTime(j);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C11792j.m20470c("AlarmChatService心跳服务重新创建");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_HEART_CALLBACK_SUCCESS);
        intentFilter.addAction(ChatBroadcastActionType.NOTIFY_CONNECT_CLOSE);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f14767c, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f14767c != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f14767c);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (LoginUser.getLoginUser().isLogin()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean m44337f = BaseApp.m44337f();
            StringBuilder sb = new StringBuilder();
            sb.append("心跳包");
            sb.append(m44337f ? "在后台" : "在前台");
            sb.append("运行");
            C11792j.m20470c(sb.toString());
            BaseApplication.m38a().mo32l(BaseApp.m44341b());
            if (currentTimeMillis - this.f14766b > 15000) {
                C11792j.m20470c("超过15秒3此未收到心跳回调重连");
                LoginUser.getLoginUser().setChatConnectStatus(false);
                m44224c();
                m44223d(System.currentTimeMillis());
            } else {
                if (BaseApp.m44337f()) {
                    BaseApplication.m38a().mo33i();
                } else {
                    BaseApplication.m38a().mo37c();
                }
                if (this.f14765a == null) {
                    this.f14765a = new AlarmChatTimer(this);
                }
                this.f14765a.m44221b();
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}
