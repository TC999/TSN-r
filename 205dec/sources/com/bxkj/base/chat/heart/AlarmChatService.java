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
import com.orhanobut.logger.j;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class AlarmChatService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private com.bxkj.base.chat.heart.a f18250a;

    /* renamed from: b  reason: collision with root package name */
    private long f18251b;

    /* renamed from: c  reason: collision with root package name */
    private BroadcastReceiver f18252c = new a();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("NOTIFY_HEART_CALLBACK_SUCCESS")) {
                AlarmChatService.this.d(System.currentTimeMillis());
                LoginUser.getLoginUser().setChatConnectStatus(true);
            } else if (!intent.getAction().equalsIgnoreCase("NOTIFY_CONNECT_CLOSE") || AlarmChatService.this.f18250a == null) {
            } else {
                AlarmChatService.this.f18250a.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f18255a;

            a(Map map) {
                this.f18255a = map;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(this.f18255a, "collectPhoto"));
                String string = JsonParse.getString(this.f18255a, "school");
                LoginUser.getLoginUser().setSchoolCode(string);
                y0.a.a().l(BaseApp.b());
                String string2 = JsonParse.getString(this.f18255a, "serverIp");
                String string3 = JsonParse.getString(this.f18255a, "port");
                if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string)) {
                    try {
                        y0.a.a().g(LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getSchoolCode(), string2, string3);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    AlarmChatService.this.f18250a = new com.bxkj.base.chat.heart.a(BaseApp.b());
                    AlarmChatService.this.f18250a.b();
                    j.c("\u8fde\u63a5\u804a\u5929\u670d\u52a1\u5668");
                    return;
                }
                AlarmChatService.this.stopSelf();
                j.c("\u4e0d\u8fdb\u884c\u8fde\u63a5");
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            new a(map).start();
        }
    }

    private void c() {
        Http.with(this).hideLoadingDialog().hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((q.a) Http.getApiService(q.a.class)).a()).setDataListener(new b());
    }

    public void d(long j4) {
        this.f18251b = j4;
        LoginUser.getLoginUser().setLastHeartCallBackTime(j4);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        j.c("AlarmChatService\u5fc3\u8df3\u670d\u52a1\u91cd\u65b0\u521b\u5efa");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFY_HEART_CALLBACK_SUCCESS");
        intentFilter.addAction("NOTIFY_CONNECT_CLOSE");
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f18252c, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f18252c != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f18252c);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        if (LoginUser.getLoginUser().isLogin()) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean f4 = BaseApp.f();
            StringBuilder sb = new StringBuilder();
            sb.append("\u5fc3\u8df3\u5305");
            sb.append(f4 ? "\u5728\u540e\u53f0" : "\u5728\u524d\u53f0");
            sb.append("\u8fd0\u884c");
            j.c(sb.toString());
            y0.a.a().l(BaseApp.b());
            if (currentTimeMillis - this.f18251b > 15000) {
                j.c("\u8d85\u8fc715\u79d23\u6b64\u672a\u6536\u5230\u5fc3\u8df3\u56de\u8c03\u91cd\u8fde");
                LoginUser.getLoginUser().setChatConnectStatus(false);
                c();
                d(System.currentTimeMillis());
            } else {
                if (BaseApp.f()) {
                    y0.a.a().i();
                } else {
                    y0.a.a().c();
                }
                if (this.f18250a == null) {
                    this.f18250a = new com.bxkj.base.chat.heart.a(this);
                }
                this.f18250a.b();
            }
        }
        return super.onStartCommand(intent, i4, i5);
    }
}
