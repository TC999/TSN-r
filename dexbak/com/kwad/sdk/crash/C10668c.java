package com.kwad.sdk.crash;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.model.C10690a;
import com.kwad.sdk.crash.model.C10692c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10668c {
    private static final String TAG = "c";
    public final double aFb;
    public final boolean aFf;
    public final boolean aFg;
    public final C10692c aFj;
    public final C10690a aFk;
    public final InterfaceC10677h aFl;
    public final String[] aFm;
    public final String[] aFn;
    public final boolean aFo;
    public final InterfaceC10673f aFp;
    public final String aFq;
    public final String aFr;
    public final String aFs;
    public final String aFt;
    public final String aFu;
    public final String aFv;
    public final String aFw;
    public final String aFx;
    public final List<C10654a> aFy;
    public final boolean akW;
    public final String azp;
    public final String channel;
    public final Context context;
    public final String platform;
    public final String sdkVersion;

    /* renamed from: com.kwad.sdk.crash.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C10669a {

        /* renamed from: WQ */
        private String f29655WQ;

        /* renamed from: WR */
        private int f29656WR;
        private InterfaceC10677h aFA;
        private String[] aFB;
        public String[] aFC;
        private InterfaceC10673f aFp;
        private String aFq;
        private String aFr;
        private String aFs;
        private String aFt;
        private String aFz;
        private String appId;
        private String appName;
        private String appPackageName;
        private String appVersion;
        private int ayM;
        private String azp;
        private String channel;
        private Context context;
        private String platform;
        public int sdkType;
        private String sdkVersion;
        private boolean aFo = false;
        private boolean aFf = false;
        private boolean aFg = false;
        private boolean akW = false;
        private String aFu = "";
        private String aFv = "";
        private String aFw = "";
        private String aFx = "";
        private List<C10654a> aFy = new ArrayList();
        private double aFb = 1.0d;

        /* renamed from: E */
        public final C10669a m25193E(List<String> list) {
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        C10654a c10654a = new C10654a();
                        c10654a.parseJson(jSONObject);
                        this.aFy.add(c10654a);
                    } catch (Exception e) {
                        C10331c.m26246w(C10668c.TAG, Log.getStackTraceString(e));
                    }
                }
            }
            return this;
        }

        /* renamed from: Ht */
        public final C10668c m25192Ht() {
            return new C10668c(this, (byte) 0);
        }

        /* renamed from: bv */
        public final C10669a m25187bv(Context context) {
            this.context = context;
            return this;
        }

        /* renamed from: bx */
        public final C10669a m25186bx(boolean z) {
            this.aFf = z;
            return this;
        }

        /* renamed from: by */
        public final C10669a m25185by(boolean z) {
            this.aFg = z;
            return this;
        }

        /* renamed from: bz */
        public final C10669a m25184bz(boolean z) {
            this.akW = z;
            return this;
        }

        /* renamed from: dA */
        public final C10669a m25180dA(int i) {
            this.sdkType = 1;
            return this;
        }

        /* renamed from: dy */
        public final C10669a m25179dy(int i) {
            this.ayM = i;
            return this;
        }

        /* renamed from: dz */
        public final C10669a m25178dz(int i) {
            this.f29656WR = i;
            return this;
        }

        /* renamed from: eZ */
        public final C10669a m25175eZ(String str) {
            this.aFu = str;
            return this;
        }

        /* renamed from: fa */
        public final C10669a m25173fa(String str) {
            this.aFv = str;
            return this;
        }

        /* renamed from: fb */
        public final C10669a m25172fb(String str) {
            this.platform = str;
            return this;
        }

        /* renamed from: fc */
        public final C10669a m25171fc(String str) {
            this.aFq = str;
            return this;
        }

        /* renamed from: fd */
        public final C10669a m25170fd(String str) {
            this.azp = str;
            return this;
        }

        /* renamed from: fe */
        public final C10669a m25169fe(String str) {
            this.channel = str;
            return this;
        }

        /* renamed from: ff */
        public final C10669a m25168ff(String str) {
            this.aFt = str;
            return this;
        }

        /* renamed from: fg */
        public final C10669a m25167fg(String str) {
            this.aFz = str;
            return this;
        }

        /* renamed from: fh */
        public final C10669a m25166fh(String str) {
            this.sdkVersion = str;
            return this;
        }

        /* renamed from: fi */
        public final C10669a m25165fi(String str) {
            this.f29655WQ = str;
            return this;
        }

        /* renamed from: fj */
        public final C10669a m25164fj(String str) {
            this.appPackageName = str;
            return this;
        }

        /* renamed from: fk */
        public final C10669a m25163fk(String str) {
            this.appId = str;
            return this;
        }

        /* renamed from: fl */
        public final C10669a m25162fl(String str) {
            this.appName = str;
            return this;
        }

        /* renamed from: fm */
        public final C10669a m25161fm(String str) {
            this.appVersion = str;
            return this;
        }

        /* renamed from: fn */
        public final C10669a m25160fn(String str) {
            this.aFr = str;
            return this;
        }

        /* renamed from: fo */
        public final C10669a m25159fo(String str) {
            this.aFw = str;
            return this;
        }

        /* renamed from: fp */
        public final C10669a m25158fp(String str) {
            this.aFx = str;
            return this;
        }

        /* renamed from: a */
        public final C10669a m25190a(InterfaceC10673f interfaceC10673f) {
            this.aFp = interfaceC10673f;
            return this;
        }

        /* renamed from: d */
        public final C10669a m25181d(String[] strArr) {
            this.aFB = strArr;
            return this;
        }

        /* renamed from: e */
        public final C10669a m25176e(String[] strArr) {
            this.aFC = strArr;
            return this;
        }

        /* renamed from: m */
        public final C10669a m25151m(double d) {
            this.aFb = d;
            return this;
        }

        /* renamed from: a */
        public final C10669a m25189a(InterfaceC10677h interfaceC10677h) {
            this.aFA = interfaceC10677h;
            return this;
        }
    }

    /* synthetic */ C10668c(C10669a c10669a, byte b) {
        this(c10669a);
    }

    /* renamed from: Hq */
    public final InterfaceC10673f m25200Hq() {
        return this.aFp;
    }

    /* renamed from: Hr */
    public final boolean m25199Hr() {
        return this.aFo;
    }

    private C10668c(C10669a c10669a) {
        C10692c c10692c = new C10692c();
        this.aFj = c10692c;
        C10690a c10690a = new C10690a();
        this.aFk = c10690a;
        ArrayList arrayList = new ArrayList();
        this.aFy = arrayList;
        this.aFo = c10669a.aFo;
        this.aFf = c10669a.aFf;
        this.aFg = c10669a.aFg;
        this.akW = c10669a.akW;
        this.aFu = c10669a.aFu;
        this.aFv = c10669a.aFv;
        this.aFw = c10669a.aFw;
        this.aFx = c10669a.aFx;
        this.context = c10669a.context;
        this.aFp = c10669a.aFp;
        this.platform = c10669a.platform;
        this.aFq = c10669a.aFq;
        this.aFr = c10669a.aFr;
        this.sdkVersion = c10669a.sdkVersion;
        this.azp = c10669a.azp;
        this.channel = c10669a.channel;
        this.aFs = c10669a.aFs;
        this.aFt = c10669a.aFt;
        c10690a.aGc = c10669a.appId;
        c10690a.mAppName = c10669a.appName;
        c10690a.aGe = c10669a.appVersion;
        c10690a.aGd = c10669a.appPackageName;
        c10692c.aGn = c10669a.f29655WQ;
        c10692c.aGo = c10669a.f29656WR;
        c10692c.mSdkVersion = c10669a.sdkVersion;
        c10692c.aGm = c10669a.ayM;
        c10692c.aGl = c10669a.aFz;
        c10692c.aGp = c10669a.sdkType;
        this.aFl = c10669a.aFA;
        this.aFm = c10669a.aFB;
        this.aFn = c10669a.aFC;
        arrayList.addAll(c10669a.aFy);
        this.aFb = c10669a.aFb;
    }
}
