package com.bxkj.student.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OpenUDID.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f19622a = "gank_device_id.xml";

    /* renamed from: b  reason: collision with root package name */
    protected static final String f19623b = "gank_device_id";

    /* renamed from: c  reason: collision with root package name */
    protected static String f19624c;

    /* compiled from: PageUtils.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class a implements k1.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SmartRefreshLayout f19625a;

        a(final SmartRefreshLayout val$refreshLayout) {
            this.f19625a = val$refreshLayout;
        }

        @Override // k1.d
        public void b(j1.h refreshlayout) {
            g gVar = g.this;
            gVar.f = 1;
            gVar.d();
        }

        @Override // k1.b
        public void q(j1.h refreshlayout) {
            g gVar = g.this;
            int i4 = gVar.g;
            int i5 = gVar.e;
            int i6 = i4 / i5;
            int i7 = gVar.f;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                this.f19625a.h();
                Toast.makeText(g.a(g.this), "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            gVar.f = i7 + 1;
            gVar.d();
        }
    }

    /* compiled from: PageUtils.java */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            g.c(g.this).y();
            g.c(g.this).h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            g.this.g = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            List d4 = g.b(g.this).d();
            if (g.this.f != 1) {
                d4.addAll(list);
                list = d4;
            }
            g.b(g.this).g(list);
        }
    }

    public static synchronized String a(Context mContext) {
        String str;
        synchronized (g.class) {
            String str2 = f19624c;
            if (str2 == null && str2 == null) {
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(mContext.getApplicationContext()).getSharedPreferences(f19622a, 0);
                String string = sharedPreferences.getString(f19623b, null);
                if (string != null) {
                    f19624c = string;
                } else {
                    String string2 = Settings.Secure.getString(mContext.getContentResolver(), "android_id");
                    if (string2 != null) {
                        try {
                            if (!"9774d56d682e549c".equals(string2)) {
                                f19624c = UUID.nameUUIDFromBytes(string2.getBytes("utf8")).toString();
                                sharedPreferences.edit().putString(f19623b, f19624c).commit();
                            }
                        } catch (UnsupportedEncodingException e4) {
                            throw new RuntimeException(e4);
                        }
                    }
                    String deviceId = ((TelephonyManager) mContext.getSystemService("phone")).getDeviceId();
                    f19624c = (deviceId != null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID()).toString();
                    sharedPreferences.edit().putString(f19623b, f19624c).commit();
                }
            }
            str = f19624c;
        }
        return str;
    }
}
