package cn.jpush.android.local;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.ad.f;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.JPushMessageReceiver;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ActionHelper {
    private static final String TAG = "ActionHelper";
    private static volatile ActionHelper actionHelper;
    private static final Object locker = new Object();
    private JPushAction jPushAction;
    private cn.jpush.android.y.a loadedResource;
    int sequence = 10;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class a extends f {

        /* renamed from: b  reason: collision with root package name */
        private Context f4239b;

        /* renamed from: c  reason: collision with root package name */
        private String f4240c;

        /* renamed from: d  reason: collision with root package name */
        private Object f4241d;

        public a(Context context, String str, Object obj) {
            this.f4239b = context;
            this.f4240c = str;
            this.f4241d = obj;
            this.f3984e = "ActionHelper#Action";
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f4239b);
                ActionHelper.this.jPushAction.handleAction(this.f4239b, this.f4240c, this.f4241d);
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class b extends f {

        /* renamed from: b  reason: collision with root package name */
        private Context f4243b;

        /* renamed from: c  reason: collision with root package name */
        private String f4244c;

        /* renamed from: d  reason: collision with root package name */
        private int f4245d;

        /* renamed from: f  reason: collision with root package name */
        private Set<String> f4246f;

        /* renamed from: g  reason: collision with root package name */
        private CallBackParams f4247g;

        public b(Context context, String str, Set<String> set, int i4, CallBackParams callBackParams) {
            this.f4247g = callBackParams;
            this.f4244c = str;
            this.f4245d = i4;
            this.f4243b = context;
            this.f4246f = set;
            this.f3984e = "ActionHelper#TagAliasAction";
        }

        @Override // cn.jpush.android.ad.f
        public void a() {
            try {
                ActionHelper.this.initLoad(this.f4243b);
                ActionHelper.this.jPushAction.setAliasAndTags(this.f4243b, this.f4244c, this.f4246f, this.f4247g);
            } catch (Throwable unused) {
            }
        }
    }

    private ActionHelper() {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 13, TAG, null, new Object[0]);
    }

    public static ActionHelper getInstance() {
        if (actionHelper == null) {
            synchronized (locker) {
                if (actionHelper == null) {
                    actionHelper = new ActionHelper();
                }
            }
        }
        return actionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initLoad(Context context) {
        if (this.jPushAction != null) {
            return;
        }
        if (JPushConstants.SUPPORT_DY && JConstants.SDK_VERSION_INT >= 220) {
            long currentTimeMillis = System.currentTimeMillis();
            this.loadedResource = cn.jpush.android.y.a.a(context);
            Logger.d(TAG, "load use time:" + (System.currentTimeMillis() - currentTimeMillis) + ",lr:" + this.loadedResource);
            cn.jpush.android.y.a aVar = this.loadedResource;
            if (aVar != null) {
                Class b4 = aVar.b("cn.p.jpush.JPushActionImpl");
                Logger.d(TAG, "load from cloud");
                this.jPushAction = (JPushAction) b4.newInstance();
            }
        }
        if (this.jPushAction == null) {
            Logger.d(TAG, "load from local");
            this.jPushAction = new cn.jpush.android.l.a();
        }
    }

    public Object beforLogin(Context context, String str, int i4, String str2) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.beforLogin(context, str, i4, str2);
        }
        return null;
    }

    public void doAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doAction:" + str);
        JCoreHelper.majorExecutor(context, TAG, new a(context, str, obj));
    }

    public void doSingleAction(Context context, String str, Object obj) {
        Logger.dd(TAG, "doSingleAction: " + str);
        JCoreHelper.futureExecutor(context, TAG, new a(context, str, obj));
    }

    public Class getClassInPlugin(String str) {
        try {
            cn.jpush.android.y.a aVar = this.loadedResource;
            if (aVar != null) {
                Class b4 = aVar.b(str);
                Logger.d(TAG, "load class from p");
                if (b4 != null) {
                    return b4;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            Logger.w(TAG, "[getClassInPlugin] error:" + th);
            return null;
        }
    }

    public ProxyActivityAction getPopWinActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPopWinActivity(context);
        }
        return null;
    }

    public ProxyActivityAction getPushActivity(Context context) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            return jPushAction.getPushActivity(context);
        }
        return null;
    }

    public int getResourceID(Context context, String str, String str2, String str3) {
        int identifier;
        StringBuilder sb;
        String str4;
        cn.jpush.android.y.a aVar = this.loadedResource;
        if (aVar != null) {
            identifier = aVar.a(str2, str);
            sb = new StringBuilder();
            str4 = "[getResourceID] try load:";
        } else {
            identifier = context.getResources().getIdentifier(str, str2, str3);
            sb = new StringBuilder();
            str4 = "[getResourceID]:";
        }
        sb.append(str4);
        sb.append(identifier);
        Logger.d(TAG, sb.toString());
        return identifier;
    }

    public String getSdkVersion(String str) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.getSdkVersion(str) : JPushConstants.SDK_VERSION_NAME;
    }

    public void handleNotificationIntent(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.handleNotificationIntent(context, intent);
        }
    }

    public boolean isSupportedCMD(String str, int i4) {
        JPushAction jPushAction = this.jPushAction;
        return jPushAction != null ? jPushAction.isSupportedCMD(str, i4) : i4 == 3 || i4 == 29 || i4 == 28 || i4 == 27 || i4 == 10 || i4 == 26 || i4 == 25 || i4 == 34 || i4 == 36 || i4 == 37;
    }

    public void onActivityLifeCallback(Activity activity, String str) {
        JPushAction jPushAction;
        if (activity == null || (jPushAction = this.jPushAction) == null) {
            return;
        }
        jPushAction.onActivityLifeCallback(activity, str);
    }

    public void onEvent(Thread thread, Throwable th) {
        JCoreManager.onEvent(null, JPushConstants.SDK_TYPE, 93, null, null, thread, th);
    }

    public void onInAppMessageClick(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageClick(context, notificationMessage);
        }
    }

    public void onInAppMessageShow(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onInAppMessageShow(context, notificationMessage);
        }
    }

    public void onJPushMessageReceive(Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, jPushMessageReceiver, intent);
        }
    }

    public void onJPushMessageReceive(Context context, String str, String str2, Bundle bundle) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onJPushMessageReceive(context, str, str2, bundle);
        }
    }

    public void onMessage(Context context, CustomMessage customMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMessage(context, customMessage);
        }
    }

    public void onMultiAction(Context context, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onMultiAction(context, intent);
        }
    }

    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageArrived(context, notificationMessage);
        }
    }

    public void onNotifyMessageOpened(Context context, NotificationMessage notificationMessage) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onNotifyMessageOpened(context, notificationMessage);
        }
    }

    public void onTagAliasResponse(Context context, long j4, int i4, Intent intent) {
        initLoad(context);
        JPushAction jPushAction = this.jPushAction;
        if (jPushAction != null) {
            jPushAction.onTagAliasResponse(context, j4, i4, intent);
        }
    }

    public void setAliasAndTagsWithCallBack(Context context, String str, Set<String> set, TagAliasCallback tagAliasCallback, int i4, int i5) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, set, 0, new CallBackParams(str, set, tagAliasCallback, System.currentTimeMillis(), i4, i5)));
    }

    public void setAliasWithCallBack(Context context, int i4, String str, int i5, int i6) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, str, null, i4, new CallBackParams(i4, str, System.currentTimeMillis(), i5, i6)));
    }

    public void setPropertyWithCallBack(Context context, int i4, Map<String, Object> map, int i5, int i6) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, null, i4, new CallBackParams(i4, map, System.currentTimeMillis(), i5, i6)));
    }

    public void setPushStatusWithCallBack(Context context, int i4, int i5) {
        int i6 = this.sequence + 1;
        this.sequence = i6;
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, null, this.sequence, new CallBackParams(i6, System.currentTimeMillis(), i4, i5)));
    }

    public void setTagsWithCallBack(Context context, int i4, Set<String> set, int i5, int i6) {
        JCoreHelper.majorExecutor(context, TAG, new b(context, null, set, i4, new CallBackParams(i4, set, System.currentTimeMillis(), i5, i6)));
    }
}
