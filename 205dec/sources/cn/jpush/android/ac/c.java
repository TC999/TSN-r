package cn.jpush.android.ac;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.f;
import cn.jpush.android.local.JPushConstants;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f3935c;

    /* renamed from: a  reason: collision with root package name */
    private Map<Byte, a> f3936a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map<Byte, String> f3937b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public byte f3938a;

        /* renamed from: b  reason: collision with root package name */
        public String f3939b;

        /* renamed from: c  reason: collision with root package name */
        public long f3940c;

        /* renamed from: d  reason: collision with root package name */
        public byte[] f3941d;

        /* renamed from: e  reason: collision with root package name */
        public int f3942e = 0;

        public a(byte b4, String str, long j4, byte[] bArr) {
            this.f3938a = b4;
            this.f3939b = str;
            this.f3940c = j4;
            this.f3941d = bArr;
        }

        public String toString() {
            return "PluginPlatformRegIDBean{pluginPlatformType=" + ((int) this.f3938a) + ", regid='" + this.f3939b + "', rid=" + this.f3940c + ", retryCount=" + this.f3942e + '}';
        }
    }

    private c() {
    }

    private a a(long j4) {
        for (Map.Entry<Byte, a> entry : this.f3936a.entrySet()) {
            if (entry.getValue().f3940c == j4) {
                return entry.getValue();
            }
        }
        Logger.d("PluginPlatformRidUpdate", "can not find uploadBean by rid");
        return null;
    }

    public static c a() {
        if (f3935c == null) {
            synchronized (c.class) {
                if (f3935c == null) {
                    f3935c = new c();
                }
            }
        }
        return f3935c;
    }

    private synchronized void a(Context context, a aVar) {
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 27, 2, aVar.f3940c, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, aVar.f3941d);
    }

    private void b(Context context, byte b4, String str, boolean z3) {
        long a4 = f.a();
        Logger.v("PluginPlatformRidUpdate", "sendUpdateRidInfo regid:" + str + ",rid:" + a4 + ",whichPlatform:" + ((int) b4) + " unBindToken:" + z3);
        a aVar = new a(b4, str, a4, cn.jpush.android.z.b.a(str, b4, z3));
        this.f3936a.put(Byte.valueOf(b4), aVar);
        a(context, aVar);
    }

    public synchronized void a(Context context, byte b4, String str, boolean z3) {
        if (b4 != 0) {
            if (!JPushConstants.isTcpConnected()) {
                Logger.d("PluginPlatformRidUpdate", "tcp disconnected");
                cn.jpush.android.helper.c.a("99999363732041973", 1109L, context);
            }
            if (this.f3936a.containsKey(Byte.valueOf(b4)) && TextUtils.equals(this.f3936a.get(Byte.valueOf(b4)).f3939b, str)) {
                Logger.d("PluginPlatformRidUpdate", "same regid request, drop it");
            } else if (this.f3937b.containsKey(Byte.valueOf(b4)) && TextUtils.equals(this.f3937b.get(Byte.valueOf(b4)), str)) {
                Logger.ke("PluginPlatformRidUpdate", "rom is " + ((int) b4) + " regId had report success,not need report again");
            } else {
                b(context, b4, str, z3);
            }
        } else {
            Logger.w("PluginPlatformRidUpdate", "unknown plugin platform type");
        }
    }

    public void a(Context context, long j4) {
        a a4 = a(j4);
        Logger.ki("PluginPlatformRidUpdate", "onUpdateRidSuccess rid:" + j4 + " ,pluginPlatformRegIDBean:" + a4);
        if (a4 != null) {
            Sp.set(context, Key.ThirdPush_RegID(a4.f3938a).set(a4.f3939b));
            Sp.set(context, Key.ThirdPush_RegUpload(a4.f3938a).set(Boolean.TRUE));
            this.f3936a.remove(Byte.valueOf(a4.f3938a));
            this.f3937b.put(Byte.valueOf(a4.f3938a), a4.f3939b);
            e.a().a(context, (int) a4.f3938a, a4.f3939b);
        }
    }

    public void a(Context context, long j4, int i4) {
        a a4 = a(j4);
        Logger.ki("PluginPlatformRidUpdate", "onUpdateRidFailed rid:" + j4 + ",errorCode:" + i4 + " ,pluginPlatformRegIDBean:" + a4);
        if (a4 != null) {
            int i5 = a4.f3942e;
            if (i5 < 3) {
                a4.f3942e = i5 + 1;
                a(context, a4);
                return;
            }
            Logger.d("PluginPlatformRidUpdate", "updateRegId failed");
            this.f3936a.remove(Byte.valueOf(a4.f3938a));
        }
    }

    public void b(Context context, long j4) {
        a a4 = a(j4);
        Logger.ki("PluginPlatformRidUpdate", "onUpdateRidTimeout rid:" + j4 + " ,pluginPlatformRegIDBean:" + a4);
        if (a4 != null) {
            int i4 = a4.f3942e;
            if (i4 < 3) {
                a4.f3942e = i4 + 1;
                a(context, a4);
                return;
            }
            Logger.d("PluginPlatformRidUpdate", "updateRegId failed by timeout");
            this.f3936a.remove(Byte.valueOf(a4.f3938a));
        }
    }
}
