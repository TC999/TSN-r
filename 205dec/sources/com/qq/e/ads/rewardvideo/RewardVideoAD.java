package com.qq.e.ads.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.NFBI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.pi.RVADI;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RewardVideoAD extends LiteAbstractAD<RVADI> implements NFBI {
    public static final int REWARD_TYPE_PAGE = 1;
    public static final int REWARD_TYPE_VIDEO = 0;

    /* renamed from: g  reason: collision with root package name */
    private final RewardVideoADListener f41562g;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f41563h;

    /* renamed from: i  reason: collision with root package name */
    private LoadAdParams f41564i;

    /* renamed from: j  reason: collision with root package name */
    private ServerSideVerificationOptions f41565j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f41566k;

    /* renamed from: l  reason: collision with root package name */
    private final ADListenerAdapter f41567l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private NegativeFeedbackListener f41568a;
        public RewardVideoADListener adListener;

        public ADListenerAdapter(RewardVideoADListener rewardVideoADListener) {
            this.adListener = rewardVideoADListener;
        }

        static void a(ADListenerAdapter aDListenerAdapter, NegativeFeedbackListener negativeFeedbackListener) {
            aDListenerAdapter.f41568a = negativeFeedbackListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            int type = aDEvent.getType();
            if (type == 100) {
                this.adListener.onADLoad();
            } else if (type == 201) {
                this.adListener.onVideoCached();
            } else if (type == 206) {
                this.adListener.onVideoComplete();
            } else if (type == 304) {
                NegativeFeedbackListener negativeFeedbackListener = this.f41568a;
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

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z3) {
        this(rewardVideoADListener, z3);
        a(context, str);
    }

    public RewardVideoAD(Context context, String str, RewardVideoADListener rewardVideoADListener, boolean z3, String str2) {
        this(rewardVideoADListener, z3);
        a(context, str, str2);
    }

    private RewardVideoAD(RewardVideoADListener rewardVideoADListener, boolean z3) {
        this.f41564i = null;
        this.f41566k = z3;
        this.f41562g = rewardVideoADListener;
        this.f41567l = new ADListenerAdapter(rewardVideoADListener);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getRewardVideoADDelegate(context, str, str2, str3, this.f41567l);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i4) {
        RewardVideoADListener rewardVideoADListener = this.f41562g;
        if (rewardVideoADListener != null) {
            rewardVideoADListener.onError(AdErrorConvertor.formatErrorCode(i4));
        }
    }

    public String getAdNetWorkName() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((RVADI) obj).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public int getRewardAdType() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((RVADI) obj).getRewardAdType();
        }
        a("getRewardAdType");
        return 0;
    }

    public int getVideoDuration() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((RVADI) obj).getVideoDuration();
        }
        a("getVideoDuration");
        return 0;
    }

    public boolean hasShown() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((RVADI) obj).hasShown();
        }
        a("hasShown");
        return false;
    }

    public void loadAD() {
        if (a()) {
            if (!b()) {
                this.f41563h = true;
                return;
            }
            Object obj = this.f41434a;
            if (obj != null) {
                ((RVADI) obj).loadAD();
            } else {
                a("loadAD");
            }
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f41564i = loadAdParams;
        Object obj = this.f41434a;
        if (obj != null) {
            ((RVADI) obj).setLoadAdParams(loadAdParams);
        }
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        ADListenerAdapter.a(this.f41567l, negativeFeedbackListener);
    }

    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f41565j = serverSideVerificationOptions;
        Object obj = this.f41434a;
        if (obj != null) {
            ((RVADI) obj).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAD() {
        Object obj = this.f41434a;
        if (obj != null) {
            ((RVADI) obj).showAD();
        } else {
            a("showAD");
        }
    }

    public void showAD(Activity activity) {
        Object obj = this.f41434a;
        if (obj != null) {
            ((RVADI) obj).showAD(activity);
        } else {
            a("showAD");
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        RVADI rvadi = (RVADI) obj;
        rvadi.setVolumeOn(this.f41566k);
        rvadi.setLoadAdParams(this.f41564i);
        rvadi.setServerSideVerificationOptions(this.f41565j);
        if (this.f41563h) {
            loadAD();
        }
    }
}
