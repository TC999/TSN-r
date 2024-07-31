package com.p518qq.p519e.ads.banner2;

import com.p518qq.p519e.comm.adevent.ADEvent;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.listeners.ADRewardListener;
import com.p518qq.p519e.comm.listeners.NegativeFeedbackListener;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* renamed from: com.qq.e.ads.banner2.ADListenerAdapter */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class ADListenerAdapter implements ADListener {

    /* renamed from: a */
    private final UnifiedBannerADListener f32734a;

    /* renamed from: b */
    private NegativeFeedbackListener f32735b;

    /* renamed from: c */
    private ADRewardListener f32736c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f32734a = unifiedBannerADListener;
    }

    @Override // com.p518qq.p519e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        UnifiedBannerADListener unifiedBannerADListener;
        String str;
        if (aDEvent == null) {
            return;
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.f32734a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onADReceive();
            }
        } else if (type == 101) {
            Integer num = (Integer) aDEvent.getParam(Integer.class);
            if (num == null || (unifiedBannerADListener = this.f32734a) == null) {
                return;
            }
            unifiedBannerADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
        } else if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.f32734a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
            }
        } else if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.f32735b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
            }
        } else {
            switch (type) {
                case 103:
                    UnifiedBannerADListener unifiedBannerADListener4 = this.f32734a;
                    if (unifiedBannerADListener4 != null) {
                        unifiedBannerADListener4.onADExposure();
                        return;
                    }
                    return;
                case 104:
                    if (this.f32736c == null || (str = (String) aDEvent.getParam(String.class)) == null) {
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("transId", str);
                    this.f32736c.onReward(hashMap);
                    return;
                case 105:
                    UnifiedBannerADListener unifiedBannerADListener5 = this.f32734a;
                    if (unifiedBannerADListener5 != null) {
                        unifiedBannerADListener5.onADClicked();
                        return;
                    }
                    return;
                case 106:
                    UnifiedBannerADListener unifiedBannerADListener6 = this.f32734a;
                    if (unifiedBannerADListener6 != null) {
                        unifiedBannerADListener6.onADClosed();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.f32736c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.f32735b = negativeFeedbackListener;
    }
}
