package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.ad.h;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentLinkedQueue<Long> f4217a = new ConcurrentLinkedQueue<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f4218c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static d f4219d;

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<Long, a> f4220b = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f4221a;

        /* renamed from: b  reason: collision with root package name */
        public String f4222b;

        public a(int i4, String str) {
            this.f4221a = i4;
            this.f4222b = str;
        }

        public String toString() {
            return "MobileBean{sequence=" + this.f4221a + ", mobileNumber='" + this.f4222b + "'}";
        }
    }

    private static int a(long j4) {
        if (f4217a.size() >= 3) {
            long longValue = j4 - f4217a.element().longValue();
            if (longValue < 0) {
                f4217a.clear();
                return 2;
            } else if (longValue <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                return 1;
            } else {
                while (f4217a.size() >= 3) {
                    f4217a.poll();
                }
            }
        }
        f4217a.offer(Long.valueOf(j4));
        return 0;
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f4219d == null) {
                synchronized (f4218c) {
                    if (f4219d == null) {
                        f4219d = new d();
                    }
                }
            }
            dVar = f4219d;
        }
        return dVar;
    }

    public JPushMessage a(Context context, Intent intent) {
        JPushMessage jPushMessage;
        Object th;
        int intExtra;
        int intExtra2;
        String stringExtra;
        if (intent != null) {
            try {
                intExtra = intent.getIntExtra(InAppSlotParams.SLOT_KEY.SEQ, -1);
                intExtra2 = intent.getIntExtra("code", -1);
                stringExtra = intent.getStringExtra("mobile");
                jPushMessage = new JPushMessage();
            } catch (Throwable th2) {
                jPushMessage = null;
                th = th2;
            }
            try {
                jPushMessage.setSequence(intExtra);
                jPushMessage.setErrorCode(intExtra2);
                jPushMessage.setMobileNumber(stringExtra);
            } catch (Throwable th3) {
                th = th3;
                Logger.w("MobileNumberHelper", "parese mobile number response to JPushMessage failed, error:" + th);
                return jPushMessage;
            }
            return jPushMessage;
        }
        return null;
    }

    public void a(Context context, int i4, int i5, String str) {
        try {
            Logger.d("MobileNumberHelper", "Action - onResult,sequence:" + i4 + ",code:" + i5 + ",mobileNumber:" + str);
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            Intent intent = new Intent();
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("MobileNumberHelper", "not found messageReceiver");
            } else {
                intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction("mobile_result");
                intent.putExtra(InAppSlotParams.SLOT_KEY.SEQ, i4);
                intent.putExtra("code", i5);
                intent.putExtra("mobile", str);
            }
            cn.jpush.android.helper.a.a(context, intent);
        } catch (Throwable th) {
            Logger.ww("MobileNumberHelper", "onResult error:" + th);
        }
    }

    public void a(Context context, int i4, String str) {
        Logger.dd("MobileNumberHelper", "action - setMobileNubmer, sequence:" + i4 + ",mobileNumber:" + str);
        Bundle bundle = new Bundle();
        bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i4);
        bundle.putString("mobile", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "set_mobile", bundle);
    }

    public void a(Context context, long j4, int i4) {
        if (this.f4220b.size() != 0) {
            a remove = this.f4220b.remove(Long.valueOf(j4));
            Logger.d("MobileNumberHelper", "mobileBean:" + remove);
            if (remove == null) {
                Logger.d("MobileNumberHelper", "#unexcepted, do not find mobile number request cache");
                return;
            }
            if (i4 == 0) {
                cn.jpush.android.cache.a.a(context, remove.f4222b);
            } else if (i4 == 11) {
                i4 = JPushInterface.ErrorCode.ERROR_CODE_INTERNEL_SERVER_ERROR;
            } else if (i4 == 10) {
                i4 = JPushInterface.ErrorCode.ERROR_CODE_INVALID_MOBILENUMBER;
            }
            a(context, remove.f4221a, i4, remove.f4222b);
        }
    }

    public void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.ww("MobileNumberHelper", "[setMobileNum] bundle is bull");
            return;
        }
        int i4 = bundle.getInt(InAppSlotParams.SLOT_KEY.SEQ, 0);
        String string = bundle.getString("mobile");
        String e4 = cn.jpush.android.cache.a.e(context);
        Logger.dd("MobileNumberHelper", "action:setMobileNum sequence:" + i4 + ",mobileNumber:" + string + ",lastMobileNumber:" + e4);
        if (e4 != null && TextUtils.equals(string, e4)) {
            Logger.dd("MobileNumberHelper", "already set this mobile number");
            a(context, i4, JPushInterface.ErrorCode.SUCCESS, string);
        } else if (cn.jpush.android.cache.a.b(context) == 1) {
            a(context, i4, JPushInterface.ErrorCode.PUSH_STOPED, string);
        } else {
            if (e4 != null) {
                cn.jpush.android.cache.a.a(context, (String) null);
            }
            int a4 = a(System.currentTimeMillis());
            if (a4 != 0) {
                Logger.w("MobileNumberHelper", a4 == 1 ? "set mobile number too soon,over 3 times in 10s" : "set mobile number failed,time shaft error\uff0cplease try again");
                a(context, i4, a4 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, string);
                return;
            }
            int c4 = h.c(string);
            if (c4 == 0) {
                byte[] a5 = cn.jpush.android.z.b.a(string);
                long a6 = f.a();
                this.f4220b.put(Long.valueOf(a6), new a(i4, string));
                JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 26, 1, a6, 0L, a5);
                return;
            }
            Logger.dd("MobileNumberHelper", "Invalid mobile number: " + string + ", will not set mobile number this time.");
            a(context, i4, c4, string);
        }
    }
}
