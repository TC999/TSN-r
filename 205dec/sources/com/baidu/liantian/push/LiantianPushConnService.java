package com.baidu.liantian.push;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Pair;
import com.amap.api.col.p0003l.f4;
import com.baidu.liantian.ac.Callback;
import com.baidu.liantian.b;
import com.baidu.liantian.b.e;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.d;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LiantianPushConnService extends Service {
    private static final int ERROR_CODE_KILL = 2;
    public static final String PUSH_SERVICE_ACTION = "com.baidu.liantian.push.service.action";
    private static int sPushPluginId = -1;
    private d mFha;
    private String mPushPluginVersion = "";
    private Callback dataServerCallback = new Callback() { // from class: com.baidu.liantian.push.LiantianPushConnService.2
        @Override // com.baidu.liantian.ac.Callback
        public final Object onError(Object... objArr) {
            try {
                int intValue = ((Integer) objArr[0]).intValue();
                b.a();
                if (intValue != 2) {
                    return null;
                }
                LiantianPushConnService.this.reportKillSelf(4);
                LiantianPushConnService.this.stopSelf();
                return null;
            } catch (Throwable unused) {
                e.a();
                return null;
            }
        }

        @Override // com.baidu.liantian.ac.Callback
        public final Object onProgress1(Object... objArr) {
            return null;
        }
    };
    private IBinder mBinder = new Binder() { // from class: com.baidu.liantian.push.LiantianPushConnService.3
    };

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, Object> startDataServer(int i4) {
        try {
            Pair<Integer, Object> a4 = this.mFha.a(i4, "startDataServer", new Class[]{Callback.class}, this.dataServerCallback);
            f4.a(a4.first);
            f4.a(a4.second);
            b.a();
            if (((Integer) a4.first).intValue() != 0) {
                reportMethodFail("startDataServer", (Integer) a4.first);
            }
            return a4;
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            getPackageName();
            b.a();
            if (PUSH_SERVICE_ACTION.equals(intent.getAction())) {
                b.a();
                return this.mBinder;
            }
            return null;
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
            this.mFha = d.a(StubApp.getOrigApplicationContext(getApplicationContext()));
            getPackageName();
            b.a();
            new Thread(new Runnable() { // from class: com.baidu.liantian.push.LiantianPushConnService.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        boolean c4 = LiantianPushConnService.this.mFha.c();
                        b.a();
                        boolean z3 = false;
                        if (!c4) {
                            try {
                                Thread.sleep(3000L);
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                            if (!LiantianPushConnService.this.mFha.c()) {
                                LiantianPushConnService.this.reportInitPushModuleResult(false);
                                LiantianPushConnService.this.reportKillSelf(1);
                                LiantianPushConnService.this.stopSelf();
                                return;
                            }
                            LiantianPushConnService.this.reportInitPushModuleResult(true);
                        } else {
                            LiantianPushConnService.this.reportInitPushModuleResult(true);
                        }
                        ApkInfo d4 = g.a(LiantianPushConnService.this).d("com.baidu.liantian.x18");
                        f4.a(LiantianPushConnService.this.mFha);
                        f4.a(d4);
                        b.a();
                        if (d4 == null) {
                            LiantianPushConnService.this.reportKillSelf(2);
                            LiantianPushConnService.this.stopSelf();
                            return;
                        }
                        LiantianPushConnService.this.mPushPluginVersion = d4.versionName;
                        int unused = LiantianPushConnService.sPushPluginId = d4.key;
                        Pair startDataServer = LiantianPushConnService.this.startDataServer(LiantianPushConnService.sPushPluginId);
                        boolean z4 = startDataServer != null && ((Boolean) startDataServer.second).booleanValue();
                        if (((Integer) startDataServer.first).intValue() != 0 || !z4) {
                            startDataServer = LiantianPushConnService.this.startDataServer(LiantianPushConnService.sPushPluginId);
                            if (startDataServer != null && ((Boolean) startDataServer.second).booleanValue()) {
                                z3 = true;
                            }
                            z4 = z3;
                        }
                        if (((Integer) startDataServer.first).intValue() == 0 && z4) {
                            return;
                        }
                        LiantianPushConnService.this.reportKillSelf(3);
                        LiantianPushConnService.this.stopSelf();
                    } catch (Throwable unused2) {
                        e.a();
                    }
                }
            }).start();
        } catch (Throwable unused) {
            e.a();
        }
    }

    protected void reportInitPushModuleResult(boolean z3) {
        b.a();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.6.7");
            hashMap.put("2", com.baidu.liantian.b.g.c(StubApp.getOrigApplicationContext(getApplicationContext())));
            hashMap.put("3", Integer.valueOf(z3 ? 1 : 2));
            e.a(StubApp.getOrigApplicationContext(getApplicationContext()), "1003130", hashMap);
        } catch (Throwable unused) {
            e.a();
        }
    }

    protected void reportKillSelf(int i4) {
        b.a();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.6.7");
            hashMap.put("2", com.baidu.liantian.b.g.c(StubApp.getOrigApplicationContext(getApplicationContext())));
            hashMap.put("3", this.mPushPluginVersion);
            hashMap.put("4", Integer.valueOf(i4));
            e.a(StubApp.getOrigApplicationContext(getApplicationContext()), "1003133", hashMap);
        } catch (Throwable unused) {
            e.a();
        }
    }

    protected void reportMethodFail(String str, Integer num) {
        f4.a(num);
        b.a();
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("0", Long.valueOf(System.currentTimeMillis()));
            hashMap.put("1", "3.1.6.7");
            hashMap.put("2", com.baidu.liantian.b.g.c(StubApp.getOrigApplicationContext(getApplicationContext())));
            hashMap.put("3", this.mPushPluginVersion);
            hashMap.put("4", str);
            hashMap.put("5", num);
            e.a(StubApp.getOrigApplicationContext(getApplicationContext()), "1003131", hashMap);
        } catch (Throwable unused) {
            e.a();
        }
    }
}
