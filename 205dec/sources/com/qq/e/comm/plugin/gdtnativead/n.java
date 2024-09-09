package com.qq.e.comm.plugin.gdtnativead;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.plugin.util.e1;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n extends NativeExpressADView {

    /* renamed from: c  reason: collision with root package name */
    private AdData f43907c;

    /* renamed from: d  reason: collision with root package name */
    private NativeExpressADView.ViewBindStatusListener f43908d;

    /* renamed from: e  reason: collision with root package name */
    private NEADVI f43909e;

    /* renamed from: f  reason: collision with root package name */
    private DownloadConfirmListener f43910f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f43911g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f43912h;

    /* renamed from: i  reason: collision with root package name */
    private NativeExpressMediaListener f43913i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f43914j;

    /* renamed from: k  reason: collision with root package name */
    private NativeExpressAD.ADListenerAdapter f43915k;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ NEADI f43916c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.u.a f43917d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f43918e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ADSize f43919f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f43920g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f43921h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ JSONObject f43922i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ HashMap f43923j;

        a(NEADI neadi, com.qq.e.comm.plugin.u.a aVar, Context context, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap hashMap) {
            this.f43916c = neadi;
            this.f43917d = aVar;
            this.f43918e = context;
            this.f43919f = aDSize;
            this.f43920g = str;
            this.f43921h = str2;
            this.f43922i = jSONObject;
            this.f43923j = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            n nVar = n.this;
            nVar.f43909e = nVar.a(this.f43916c, this.f43917d, this.f43918e, nVar, this.f43919f, this.f43920g, this.f43921h, this.f43922i, this.f43923j);
            n.this.a();
        }
    }

    public n(NEADI neadi, com.qq.e.comm.plugin.u.a aVar, Context context, ADSize aDSize, String str, String str2, String str3, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        super(context);
        this.f43911g = false;
        this.f43912h = false;
        this.f43914j = false;
        new Handler(Looper.getMainLooper()).post(new a(neadi, aVar, context, aDSize, str, str2, jSONObject, hashMap));
        this.f43907c = a(hashMap);
        this.f43915k = new NativeExpressAD.ADListenerAdapter(this.f43913i);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void destroy() {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.destroy();
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NEADVI neadvi = this.f43909e;
        return neadvi != null ? neadvi.getApkInfoUrl() : "";
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public AdData getBoundData() {
        return this.f43907c;
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            return neadvi.getECPM();
        }
        return -1;
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            return neadvi.getECPMLevel();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        AdData adData = this.f43907c;
        if (adData != null) {
            return adData.getExtraInfo();
        }
        return null;
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            return neadvi.isValid();
        }
        return false;
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void negativeFeedback() {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.reportAdNegative();
        } else {
            this.f43914j = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f43908d;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f43908d;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onDetachedFromWindow();
        }
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i4, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f43910f;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i4, str, downloadConfirmCallBack);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f43908d;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onFinishTemporaryDetach();
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        NativeExpressADView.ViewBindStatusListener viewBindStatusListener = this.f43908d;
        if (viewBindStatusListener != null) {
            viewBindStatusListener.onStartTemporaryDetach();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void preloadVideo() {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.preloadVideo();
        } else {
            this.f43911g = true;
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void render() {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.render();
        } else {
            this.f43912h = true;
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.sendLossNotification(i4, i5, str);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.sendWinNotification(i4);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    @Deprecated
    public void setAdSize(ADSize aDSize) {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.setAdSize(aDSize);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.setBidECPM(i4);
        }
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f43910f = downloadConfirmListener;
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
        if (nativeExpressMediaListener == null) {
            return;
        }
        if (e1.h() >= 450) {
            this.f43915k.setMediaListener(nativeExpressMediaListener);
        } else if (this.f43909e != null) {
            NativeExpressAD.ADListenerAdapter aDListenerAdapter = new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener);
            this.f43915k = aDListenerAdapter;
            this.f43909e.setAdListener(aDListenerAdapter);
        } else {
            this.f43913i = nativeExpressMediaListener;
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        if (negativeFeedbackListener != null) {
            this.f43915k.setNegativeFeedbackListener(negativeFeedbackListener);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressADView
    public void setViewBindStatusListener(NativeExpressADView.ViewBindStatusListener viewBindStatusListener) {
        this.f43908d = viewBindStatusListener;
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.sendLossNotification(map);
        }
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.sendWinNotification(map);
        }
    }

    public void a(ADListener aDListener) {
        NEADVI neadvi = this.f43909e;
        if (neadvi != null) {
            neadvi.setAdListener(aDListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.qq.e.comm.pi.AdData a(java.util.HashMap<java.lang.String, java.lang.Object> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "adinfo"
            r1 = 0
            if (r3 == 0) goto Lc
            java.lang.Object r3 = r3.get(r0)     // Catch: org.json.JSONException -> L14
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch: org.json.JSONException -> L14
            goto Ld
        Lc:
            r3 = r1
        Ld:
            if (r3 == 0) goto L14
            java.lang.Object r3 = r3.get(r0)     // Catch: org.json.JSONException -> L14
            goto L15
        L14:
            r3 = r1
        L15:
            boolean r0 = r3 instanceof com.qq.e.comm.pi.AdData
            if (r0 == 0) goto L1c
            r1 = r3
            com.qq.e.comm.pi.AdData r1 = (com.qq.e.comm.pi.AdData) r1
        L1c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.gdtnativead.n.a(java.util.HashMap):com.qq.e.comm.pi.AdData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NEADVI a(NEADI neadi, com.qq.e.comm.plugin.u.a aVar, Context context, ViewGroup viewGroup, ADSize aDSize, String str, String str2, JSONObject jSONObject, HashMap<String, Object> hashMap) {
        if (aVar != null) {
            return new k(neadi, aVar, viewGroup, hashMap);
        }
        return new j(neadi, context, viewGroup, aDSize, str, str2, jSONObject, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        NativeExpressMediaListener nativeExpressMediaListener = this.f43913i;
        if (nativeExpressMediaListener != null) {
            this.f43915k = new NativeExpressAD.ADListenerAdapter(nativeExpressMediaListener);
        }
        this.f43909e.setAdListener(this.f43915k);
        if (this.f43911g) {
            preloadVideo();
        }
        if (this.f43912h) {
            render();
        }
        if (this.f43914j) {
            negativeFeedback();
        }
        if (this.f43910f != null) {
            this.f43909e.setDownloadConfirmListener(this);
        }
    }
}
