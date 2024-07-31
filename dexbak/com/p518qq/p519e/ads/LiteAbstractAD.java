package com.p518qq.p519e.ads;

import android.app.Activity;
import com.p518qq.p519e.comm.compliance.DownloadConfirmCallBack;
import com.p518qq.p519e.comm.compliance.DownloadConfirmListener;
import com.p518qq.p519e.comm.p520pi.LADI;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.qq.e.ads.LiteAbstractAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class LiteAbstractAD<T extends LADI> extends AbstractAD<T> implements LADI, DownloadConfirmListener {

    /* renamed from: f */
    private DownloadConfirmListener f32733f;

    @Override // com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        T t = this.f32719a;
        if (t != 0) {
            return ((LADI) t).getApkInfoUrl();
        }
        m20410a("getApkInfoUrl");
        return null;
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public int getECPM() {
        T t = this.f32719a;
        if (t != 0) {
            return ((LADI) t).getECPM();
        }
        m20410a("getECPM");
        return -1;
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public String getECPMLevel() {
        T t = this.f32719a;
        if (t != 0) {
            return ((LADI) t).getECPMLevel();
        }
        m20410a("getECPMLevel");
        return null;
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public Map<String, Object> getExtraInfo() {
        T t = this.f32719a;
        if (t != 0) {
            return ((LADI) t).getExtraInfo();
        }
        m20410a("getExtraInfo");
        return new HashMap();
    }

    @Override // com.p518qq.p519e.comm.p520pi.LADI
    public boolean isValid() {
        T t = this.f32719a;
        if (t != 0) {
            return ((LADI) t).isValid();
        }
        m20410a("isValid");
        return false;
    }

    @Override // com.p518qq.p519e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f32733f;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendLossNotification(int i, int i2, String str) {
        T t = this.f32719a;
        if (t != 0) {
            ((LADI) t).sendLossNotification(i, i2, str);
        } else {
            m20410a("sendLossNotification");
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendLossNotification(Map<String, Object> map) {
        T t = this.f32719a;
        if (t != 0) {
            ((LADI) t).sendLossNotification(map);
        } else {
            m20410a("sendLossNotification");
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendWinNotification(int i) {
        T t = this.f32719a;
        if (t != 0) {
            ((LADI) t).sendWinNotification(i);
        } else {
            m20410a("sendWinNotification");
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void sendWinNotification(Map<String, Object> map) {
        T t = this.f32719a;
        if (t != 0) {
            ((LADI) t).sendWinNotification(map);
        } else {
            m20410a("sendWinNotification");
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.IBidding
    public void setBidECPM(int i) {
        T t = this.f32719a;
        if (t != 0) {
            ((LADI) t).setBidECPM(i);
        } else {
            m20410a("setBidECPM");
        }
    }

    @Override // com.p518qq.p519e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f32733f = downloadConfirmListener;
        T t = this.f32719a;
        if (t != 0) {
            ((LADI) t).setDownloadConfirmListener(this);
        }
    }
}
