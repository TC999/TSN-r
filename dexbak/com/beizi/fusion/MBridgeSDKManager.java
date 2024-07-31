package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import java.util.Map;

/* renamed from: com.beizi.fusion.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MBridgeSDKManager {

    /* renamed from: e */
    private static EnumC3041d f10856e;

    /* renamed from: a */
    private Context f10857a;

    /* renamed from: b */
    private volatile String f10858b;

    /* renamed from: c */
    private volatile String f10859c;

    /* renamed from: d */
    private volatile InterfaceC3040c f10860d;

    /* renamed from: f */
    private MBridgeSDK f10861f;

    /* compiled from: MBridgeSDKManager.java */
    /* renamed from: com.beizi.fusion.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3038a {

        /* renamed from: a */
        private static final MBridgeSDKManager f10862a = new MBridgeSDKManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MBridgeSDKManager.java */
    /* renamed from: com.beizi.fusion.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3039b implements SDKInitStatusListener {

        /* renamed from: a */
        private String f10863a;

        /* renamed from: b */
        private String f10864b;

        /* renamed from: c */
        private InterfaceC3040c f10865c;

        public C3039b(String str, String str2, InterfaceC3040c interfaceC3040c) {
            this.f10863a = str;
            this.f10864b = str2;
            this.f10865c = interfaceC3040c;
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitFail(String str) {
            EnumC3041d unused = MBridgeSDKManager.f10856e = EnumC3041d.SDK_STATE_INITIALIZE_FAILURE;
            InterfaceC3040c interfaceC3040c = this.f10865c;
            if (interfaceC3040c != null) {
                interfaceC3040c.mo46034a("sdk initialize failed： an exception occurs");
            }
        }

        @Override // com.mbridge.msdk.out.SDKInitStatusListener
        public void onInitSuccess() {
            EnumC3041d unused = MBridgeSDKManager.f10856e = EnumC3041d.SDK_STATE_INITIALIZE_SUCCESS;
            InterfaceC3040c interfaceC3040c = this.f10865c;
            if (interfaceC3040c != null) {
                interfaceC3040c.mo46033a(this.f10863a, this.f10864b);
            }
        }
    }

    /* compiled from: MBridgeSDKManager.java */
    /* renamed from: com.beizi.fusion.b$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3040c {
        /* renamed from: a */
        void mo46034a(String str);

        /* renamed from: a */
        void mo46033a(String str, String str2);
    }

    /* compiled from: MBridgeSDKManager.java */
    /* renamed from: com.beizi.fusion.b$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC3041d {
        SDK_STATE_UN_INITIALIZE,
        SDK_STATE_INITIALIZING,
        SDK_STATE_INITIALIZE_SUCCESS,
        SDK_STATE_INITIALIZE_FAILURE
    }

    private MBridgeSDKManager() {
        f10856e = EnumC3041d.SDK_STATE_UN_INITIALIZE;
    }

    /* renamed from: a */
    public static MBridgeSDKManager m48989a() {
        return C3038a.f10862a;
    }

    /* renamed from: a */
    public synchronized void m48987a(Context context, String str, String str2, boolean z, Map<String, String> map, InterfaceC3040c interfaceC3040c) {
        EnumC3041d enumC3041d = f10856e;
        EnumC3041d enumC3041d2 = EnumC3041d.SDK_STATE_INITIALIZING;
        if (enumC3041d == enumC3041d2) {
            if (interfaceC3040c != null) {
                interfaceC3040c.mo46034a("sdk is initializing");
            }
            return;
        }
        this.f10860d = interfaceC3040c;
        if (m48988a(context, str, str2)) {
            if (f10856e == EnumC3041d.SDK_STATE_INITIALIZE_SUCCESS && TextUtils.equals(this.f10859c, str2) && TextUtils.equals(this.f10858b, str)) {
                if (this.f10860d != null) {
                    this.f10860d.mo46033a(this.f10858b, this.f10859c);
                }
                return;
            }
            f10856e = enumC3041d2;
            this.f10857a = context;
            this.f10858b = str;
            this.f10859c = str2;
            m48985a(z, map, this.f10860d);
        }
    }

    /* renamed from: a */
    private void m48985a(boolean z, Map<String, String> map, InterfaceC3040c interfaceC3040c) {
        try {
            MBridgeConstans.DEBUG = z;
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            this.f10861f = mBridgeSDK;
            Map<String, String> mBConfigurationMap = mBridgeSDK.getMBConfigurationMap(this.f10859c, this.f10858b);
            if (map != null && !map.isEmpty()) {
                mBConfigurationMap.putAll(map);
            }
            this.f10861f.init(mBConfigurationMap, this.f10857a, new C3039b(this.f10858b, this.f10859c, this.f10860d));
        } catch (Exception e) {
            f10856e = EnumC3041d.SDK_STATE_INITIALIZE_FAILURE;
            if (this.f10860d != null) {
                interfaceC3040c.mo46034a(e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private boolean m48988a(Context context, String str, String str2) {
        String str3;
        boolean z;
        boolean z2 = false;
        if (context == null) {
            str3 = "context must not null";
            z = false;
        } else {
            str3 = "";
            z = true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            z2 = z;
        } else if (TextUtils.isEmpty(str3)) {
            str3 = "appKey or appID must not null";
        } else {
            str3 = str3 + " & appKey or appID must not null";
        }
        if (!z2 && !TextUtils.isEmpty(str3) && this.f10860d != null) {
            f10856e = EnumC3041d.SDK_STATE_INITIALIZE_FAILURE;
            this.f10860d.mo46034a(str3);
        }
        return z2;
    }
}
