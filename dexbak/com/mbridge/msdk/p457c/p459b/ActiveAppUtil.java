package com.mbridge.msdk.p457c.p459b;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.ActiveAppConfigEntity;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import java.util.List;

/* renamed from: com.mbridge.msdk.c.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ActiveAppUtil {

    /* renamed from: a */
    private final String f29878a;

    /* renamed from: b */
    private List<ActiveAppConfigEntity> f29879b;

    /* renamed from: c */
    private boolean f29880c;

    /* renamed from: d */
    private Handler f29881d;

    /* compiled from: ActiveAppUtil.java */
    /* renamed from: com.mbridge.msdk.c.b.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    private static class C11197a {

        /* renamed from: a */
        private static final ActiveAppUtil f29883a = new ActiveAppUtil();
    }

    /* renamed from: a */
    public static ActiveAppUtil m23238a() {
        return C11197a.f29883a;
    }

    /* renamed from: b */
    public final void m23236b() {
        Handler handler = this.f29881d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* renamed from: c */
    public final boolean m23235c() {
        return this.f29880c;
    }

    /* renamed from: d */
    public final synchronized void m23234d() {
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b != null) {
            if (m23252b.m23384aN() == 2) {
                m23236b();
            } else {
                List<ActiveAppConfigEntity> m23382aP = m23252b.m23382aP();
                if (m23382aP != null && m23382aP.size() != 0) {
                    this.f29879b = m23382aP;
                }
                m23236b();
            }
        }
    }

    /* renamed from: e */
    public final synchronized void m23233e() {
        if (MBSDKContext.m22865f().m22861j() == null) {
            return;
        }
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b != null && m23252b.m23384aN() != 2) {
            List<ActiveAppConfigEntity> m23382aP = m23252b.m23382aP();
            this.f29879b = m23382aP;
            if (m23382aP != null && m23382aP.size() != 0) {
                long longValue = ((Long) C11400ae.m21961b(MBSDKContext.m22865f().m22861j(), "active_last_time", 0L)).longValue();
                Message obtain = Message.obtain();
                if (longValue == 0) {
                    obtain.what = 1;
                    obtain.arg1 = m23252b.m23383aO() * 1000;
                } else {
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    int m23383aO = m23252b.m23383aO() * 1000;
                    long j = m23383aO;
                    if (currentTimeMillis > j) {
                        obtain.what = 1;
                        obtain.arg1 = m23383aO;
                    } else {
                        obtain.what = 2;
                        obtain.arg1 = (int) (j - currentTimeMillis);
                        obtain.arg2 = m23383aO;
                    }
                }
                this.f29881d.sendMessage(obtain);
                this.f29880c = true;
                SameLogTool.m21733d("ActiveAppUtil", "init");
            }
        }
    }

    private ActiveAppUtil() {
        this.f29878a = "ActiveAppUtil";
        this.f29880c = false;
        this.f29881d = new Handler() { // from class: com.mbridge.msdk.c.b.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                synchronized (ActiveAppUtil.this) {
                    Message obtain = Message.obtain();
                    int i = message.what;
                    if (i == 1) {
                        ActiveAppUtil.m23237a(ActiveAppUtil.this);
                        obtain.what = 1;
                        obtain.arg1 = message.arg1;
                        sendMessageDelayed(obtain, message.arg1);
                    } else if (i == 2) {
                        obtain.what = 1;
                        obtain.arg1 = message.arg2;
                        sendMessageDelayed(obtain, message.arg1);
                    }
                }
            }
        };
    }

    /* renamed from: a */
    static /* synthetic */ void m23237a(ActiveAppUtil activeAppUtil) {
        if (MBSDKContext.m22865f().m22861j() == null) {
            return;
        }
        List<ActiveAppConfigEntity> list = activeAppUtil.f29879b;
        if (list == null || list.size() == 0) {
            activeAppUtil.m23236b();
        }
        C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), "active_last_time", Long.valueOf(System.currentTimeMillis()));
        try {
            for (ActiveAppConfigEntity activeAppConfigEntity : activeAppUtil.f29879b) {
                Intent intent = new Intent();
                if (activeAppConfigEntity.m22630b().contains(NotificationCompat.CATEGORY_SERVICE)) {
                    if (!TextUtils.isEmpty(activeAppConfigEntity.m22632a()) && !TextUtils.isEmpty(activeAppConfigEntity.m22628c())) {
                        intent.setComponent(new ComponentName(activeAppConfigEntity.m22632a(), activeAppConfigEntity.m22628c()));
                        if (!TextUtils.isEmpty(activeAppConfigEntity.m22626d())) {
                            intent.setAction(activeAppConfigEntity.m22626d());
                        }
                        if (Build.VERSION.SDK_INT >= 26) {
                            MBSDKContext.m22865f().m22861j().startForegroundService(intent);
                        } else {
                            MBSDKContext.m22865f().m22861j().startService(intent);
                        }
                    }
                    return;
                }
                if (activeAppConfigEntity.m22630b().contains("broadcast")) {
                    if (!TextUtils.isEmpty(activeAppConfigEntity.m22632a()) && !TextUtils.isEmpty(activeAppConfigEntity.m22628c()) && !TextUtils.isEmpty(activeAppConfigEntity.m22626d())) {
                        intent.setComponent(new ComponentName(activeAppConfigEntity.m22632a(), activeAppConfigEntity.m22628c()));
                        intent.setAction(activeAppConfigEntity.m22626d());
                        MBSDKContext.m22865f().m22861j().sendBroadcast(intent);
                    }
                    return;
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21733d("ActiveAppUtil", th.getMessage());
        }
    }
}
