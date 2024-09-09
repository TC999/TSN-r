package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MBridgeSDKManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    private static d f14420e;

    /* renamed from: a  reason: collision with root package name */
    private Context f14421a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f14422b;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f14423c;

    /* renamed from: d  reason: collision with root package name */
    private volatile c f14424d;

    /* renamed from: f  reason: collision with root package name */
    private MBridgeSDK f14425f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MBridgeSDKManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private static final b f14440a = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MBridgeSDKManager.java */
    /* renamed from: com.beizi.fusion.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class C0133b implements SDKInitStatusListener {

        /* renamed from: a  reason: collision with root package name */
        private String f14482a;

        /* renamed from: b  reason: collision with root package name */
        private String f14483b;

        /* renamed from: c  reason: collision with root package name */
        private c f14484c;

        public C0133b(String str, String str2, c cVar) {
            this.f14482a = str;
            this.f14483b = str2;
            this.f14484c = cVar;
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitFail(String str) {
            d unused = b.f14420e = d.SDK_STATE_INITIALIZE_FAILURE;
            c cVar = this.f14484c;
            if (cVar != null) {
                cVar.a("sdk initialize failed\uff1a an exception occurs");
            }
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitSuccess() {
            d unused = b.f14420e = d.SDK_STATE_INITIALIZE_SUCCESS;
            c cVar = this.f14484c;
            if (cVar != null) {
                cVar.a(this.f14482a, this.f14483b);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MBridgeSDKManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface c {
        void a(String str);

        void a(String str, String str2);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: MBridgeSDKManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum d {
        SDK_STATE_UN_INITIALIZE,
        SDK_STATE_INITIALIZING,
        SDK_STATE_INITIALIZE_SUCCESS,
        SDK_STATE_INITIALIZE_FAILURE
    }

    private b() {
        f14420e = d.SDK_STATE_UN_INITIALIZE;
    }

    public static b a() {
        return a.f14440a;
    }

    public synchronized void a(Context context, String str, String str2, boolean z3, Map<String, String> map, c cVar) {
        d dVar = f14420e;
        d dVar2 = d.SDK_STATE_INITIALIZING;
        if (dVar == dVar2) {
            if (cVar != null) {
                cVar.a("sdk is initializing");
            }
            return;
        }
        this.f14424d = cVar;
        if (a(context, str, str2)) {
            if (f14420e == d.SDK_STATE_INITIALIZE_SUCCESS && TextUtils.equals(this.f14423c, str2) && TextUtils.equals(this.f14422b, str)) {
                if (this.f14424d != null) {
                    this.f14424d.a(this.f14422b, this.f14423c);
                }
                return;
            }
            f14420e = dVar2;
            this.f14421a = context;
            this.f14422b = str;
            this.f14423c = str2;
            a(z3, map, this.f14424d);
        }
    }

    private void a(boolean z3, Map<String, String> map, c cVar) {
        try {
            MBridgeConstans.DEBUG = z3;
            com.mbridge.msdk.system.a mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            this.f14425f = mBridgeSDK;
            Map<String, String> mBConfigurationMap = mBridgeSDK.getMBConfigurationMap(this.f14423c, this.f14422b);
            if (map != null && !map.isEmpty()) {
                mBConfigurationMap.putAll(map);
            }
            this.f14425f.init(mBConfigurationMap, this.f14421a, new C0133b(this.f14422b, this.f14423c, this.f14424d));
        } catch (Exception e4) {
            f14420e = d.SDK_STATE_INITIALIZE_FAILURE;
            if (this.f14424d != null) {
                cVar.a(e4.getMessage());
            }
        }
    }

    private boolean a(Context context, String str, String str2) {
        String str3;
        boolean z3;
        boolean z4 = false;
        if (context == null) {
            str3 = "context must not null";
            z3 = false;
        } else {
            str3 = "";
            z3 = true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            z4 = z3;
        } else if (TextUtils.isEmpty(str3)) {
            str3 = "appKey or appID must not null";
        } else {
            str3 = str3 + " & appKey or appID must not null";
        }
        if (!z4 && !TextUtils.isEmpty(str3) && this.f14424d != null) {
            f14420e = d.SDK_STATE_INITIALIZE_FAILURE;
            this.f14424d.a(str3);
        }
        return z4;
    }
}
