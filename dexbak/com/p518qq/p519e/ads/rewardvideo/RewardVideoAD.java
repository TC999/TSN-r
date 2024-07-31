package com.p518qq.p519e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.p518qq.p519e.ads.LiteAbstractAD;
import com.p518qq.p519e.comm.adevent.ADEvent;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.constants.LoadAdParams;
import com.p518qq.p519e.comm.listeners.NegativeFeedbackListener;
import com.p518qq.p519e.comm.p520pi.NFBI;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.p520pi.RVADI;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: g */
    private final RewardVideoADListener f32847g;

    /* renamed from: h */
    private volatile boolean f32848h;

    /* renamed from: i */
    private LoadAdParams f32849i;

    /* renamed from: j */
    private ServerSideVerificationOptions f32850j;

    /* renamed from: k */
    private final boolean f32851k;

    /* renamed from: l */
    private final ADListenerAdapter f32852l;

    /* renamed from: com.qq.e.ads.rewardvideo.RewardVideoAD$ADListenerAdapter */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a */
        private NegativeFeedbackListener f32853a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        /* renamed from: a */
        static void m20374a(ADListenerAdapter aDListenerAdapter, NegativeFeedbackListener negativeFeedbackListener) {
            aDListenerAdapter.f32853a = negativeFeedbackListener;
        }

        @Override // com.p518qq.p519e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
            } else if (type == 201) {
                this.adListener.onVideoCached();
            } else if (type == 206) {
                this.adListener.onVideoComplete();
            } else if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.f32853a;
                if (negativeFeedbackListener != null) {
                    negativeFeedbackListener.onComplainSuccess();
                }
            } else {
                switch (type) {
                    case 102:
                        this.adListener.onADShow();
                        return;
                    case 103:
                        this.adListener.onADExpose();
                        return;
                    case 104:
                        String str = (String) aDEvent.getParam(String.class);
                        if (str != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("transId", str);
                            this.adListener.onReward(hashMap);
                            return;
                        }
                        return;
                    case 105:
                        this.adListener.onADClick();
                        return;
                    case 106:
                        this.adListener.onADClose();
                        return;
                    case 107:
                        Integer num = (Integer) aDEvent.getParam(Integer.class);
                        if (num != null) {
                            this.adListener.onError(AdErrorConvertor.formatErrorCode(num.intValue()));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener) {
        this(context, str, rewardVideoADListener, true);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z) {
        this(rewardVideoADListener, z);
        m20414a(context, str);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z, String str2) {
        this(rewardVideoADListener, z);
        m20413a(context, str, str2);
    }

    private RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z) {
        this.f32849i = null;
        this.f32851k = z;
        this.f32847g = rewardVideoADListener;
        this.f32852l = new ADListenerAdapter(rewardVideoADListener);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected Object mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.f32852l);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: b */
    protected void mo20366b(int i) {
        RewardVideoADListener rewardVideoADListener = this.f32847g;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f32719a;
        if (t != 0) {
            return ((RVADI) t).getAdNetWorkName();
        }
        m20410a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        T t = this.f32719a;
        if (t != 0) {
            return ((RVADI) t).getRewardAdType();
        }
        m20410a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        T t = this.f32719a;
        if (t != 0) {
            return ((RVADI) t).getVideoDuration();
        }
        m20410a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        T t = this.f32719a;
        if (t != 0) {
            return ((RVADI) t).hasShown();
        }
        m20410a("hasShown");
        return false;
    }

    public void loadAD() {
        if (m20416a()) {
            if (!m20409b()) {
                this.f32848h = true;
                return;
            }
            T t = this.f32719a;
            if (t != 0) {
                ((RVADI) t).loadAD();
            } else {
                m20410a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f32849i = loadAdParams;
        T t = this.f32719a;
        if (t != 0) {
            ((RVADI) t).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        ADListenerAdapter.m20374a(this.f32852l, negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f32850j = serverSideVerificationOptions;
        T t = this.f32719a;
        if (t != 0) {
            ((RVADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        T t = this.f32719a;
        if (t != 0) {
            ((RVADI) t).showAD();
        } else {
            m20410a("showAD");
        }
    }

    public void showAD(Activity activity) {
        T t = this.f32719a;
        if (t != 0) {
            ((RVADI) t).showAD(activity);
        } else {
            m20410a("showAD");
        }
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected void mo20368a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.f32851k);
        rvadi.setLoadAdParams(this.f32849i);
        rvadi.setServerSideVerificationOptions(this.f32850j);
        if (this.f32848h) {
            loadAD();
        }
    }
}
