package com.qq.e.comm.plugin.gdtnativead;

import android.view.ViewGroup;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.NEADVI;
import com.qq.e.comm.plugin.util.d1;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k implements NEADVI {

    /* renamed from: f  reason: collision with root package name */
    private static final String f43890f = k.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private final com.qq.e.comm.plugin.u.i f43891c;

    /* renamed from: d  reason: collision with root package name */
    private b f43892d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f43893e;

    public k(NEADI neadi, com.qq.e.comm.plugin.u.i iVar, ViewGroup viewGroup, HashMap<String, Object> hashMap) {
        this.f43891c = iVar;
        this.f43893e = neadi instanceof com.qq.e.comm.plugin.intersitial2.h;
        ADListener k4 = neadi instanceof g ? ((g) neadi).k() : null;
        com.qq.e.comm.plugin.b.n a4 = a.a(hashMap);
        if (this.f43893e) {
            return;
        }
        b bVar = new b(k4, viewGroup, a4, iVar);
        this.f43892d = bVar;
        if (iVar instanceof ADEventListener) {
            ((ADEventListener) iVar).setAdListener(bVar);
        }
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void destroy() {
        d1.a(f43890f, "destroy");
        this.f43891c.destroy();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        d1.a(f43890f, "getApkInfoUrl");
        return this.f43891c.getApkInfoUrl();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.f43891c.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public String getECPMLevel() {
        return this.f43891c.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public Map<String, Object> getExtraInfo() {
        return this.f43891c.getExtraInfo();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.f43891c.isValid();
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void preloadVideo() {
        d1.a(f43890f, "preloadVideo");
        this.f43891c.preloadVideo();
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void render() {
        d1.a(f43890f, "render");
        this.f43891c.render();
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void reportAdNegative() {
        d1.a(f43890f, "reportAdNegative");
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i4, int i5, String str) {
        this.f43891c.sendLossNotification(i4, i5, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i4) {
        this.f43891c.sendWinNotification(i4);
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void setAdListener(ADListener aDListener) {
        b bVar = this.f43892d;
        if (bVar != null) {
            bVar.a(aDListener);
        }
    }

    @Override // com.qq.e.comm.pi.NEADVI
    public void setAdSize(ADSize aDSize) {
        d1.a(f43890f, "setAdSize");
        this.f43891c.setAdSize(aDSize);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i4) {
        this.f43891c.setBidECPM(i4);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        d1.a(f43890f, "setDownloadConfirmListener");
        this.f43891c.setDownloadConfirmListener(downloadConfirmListener);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        this.f43891c.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        this.f43891c.sendWinNotification(map);
    }
}
