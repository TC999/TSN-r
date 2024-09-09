package com.qq.e.ads.nativ;

import android.content.Context;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NEADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* renamed from: f  reason: collision with root package name */
    private volatile int f41522f;

    /* renamed from: g  reason: collision with root package name */
    private volatile int f41523g;

    /* renamed from: h  reason: collision with root package name */
    private List<Integer> f41524h = Collections.synchronizedList(new ArrayList());

    /* renamed from: i  reason: collision with root package name */
    private VideoOption f41525i;

    /* renamed from: j  reason: collision with root package name */
    private ADSize f41526j;

    /* renamed from: k  reason: collision with root package name */
    private NativeExpressADListener f41527k;

    /* renamed from: l  reason: collision with root package name */
    private final ADListenerAdapter f41528l;

    /* renamed from: m  reason: collision with root package name */
    private LoadAdParams f41529m;

    /* renamed from: n  reason: collision with root package name */
    private volatile ServerSideVerificationOptions f41530n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private NativeExpressADListener f41531a;

        /* renamed from: b  reason: collision with root package name */
        private NativeExpressMediaListener f41532b;

        /* renamed from: c  reason: collision with root package name */
        private NegativeFeedbackListener f41533c;

        /* renamed from: d  reason: collision with root package name */
        private ADRewardListener f41534d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f41531a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f41532b = nativeExpressMediaListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.a(this.f41531a, aDEvent) || NativeExpressAD.a(this.f41532b, aDEvent) || NativeExpressAD.a(this.f41533c, aDEvent)) {
                return;
            }
            NativeExpressAD.a(this.f41534d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f41534d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f41532b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f41533c = negativeFeedbackListener;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface NativeExpressADListener extends NativeAbstractAD.BasicADListener {
        void onADClicked(NativeExpressADView nativeExpressADView);

        void onADClosed(NativeExpressADView nativeExpressADView);

        void onADExposure(NativeExpressADView nativeExpressADView);

        void onADLeftApplication(NativeExpressADView nativeExpressADView);

        void onADLoaded(List<NativeExpressADView> list);

        void onRenderFail(NativeExpressADView nativeExpressADView);

        void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener) {
        this.f41527k = nativeExpressADListener;
        this.f41528l = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f41527k = nativeExpressADListener;
        this.f41528l = new ADListenerAdapter(nativeExpressADListener);
        if (a(aDSize)) {
            return;
        }
        a(context, str, str2);
    }

    private boolean a(ADSize aDSize) {
        if (aDSize != null) {
            this.f41526j = aDSize;
            return false;
        }
        GDTLogger.e("\u521d\u59cb\u5316\u9519\u8bef\uff1a\u53c2\u6570adSize\u4e0d\u80fd\u4e3a\u7a7a");
        a(2001);
        return true;
    }

    static boolean a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
        if (nativeExpressADListener != null) {
            int type = aDEvent.getType();
            if (type == 100) {
                List<NativeExpressADView> list = (List) aDEvent.getParam(List.class);
                if (list != null) {
                    nativeExpressADListener.onADLoaded(list);
                }
            } else if (type == 101) {
                Integer num = (Integer) aDEvent.getParam(Integer.class);
                if (num != null) {
                    nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 103) {
                NativeExpressADView nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView != null) {
                    nativeExpressADListener.onADExposure(nativeExpressADView);
                }
            } else if (type == 303) {
                NativeExpressADView nativeExpressADView2 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView2 != null) {
                    nativeExpressADListener.onADLeftApplication(nativeExpressADView2);
                }
            } else if (type == 105) {
                NativeExpressADView nativeExpressADView3 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView3 != null) {
                    nativeExpressADListener.onADClicked(nativeExpressADView3);
                }
            } else if (type == 106) {
                NativeExpressADView nativeExpressADView4 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView4 != null) {
                    nativeExpressADListener.onADClosed(nativeExpressADView4);
                    nativeExpressADView4.negativeFeedback();
                }
            } else if (type == 109) {
                NativeExpressADView nativeExpressADView5 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView5 != null) {
                    nativeExpressADListener.onRenderSuccess(nativeExpressADView5);
                }
            } else if (type == 110) {
                NativeExpressADView nativeExpressADView6 = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class);
                if (nativeExpressADView6 != null) {
                    nativeExpressADListener.onRenderFail(nativeExpressADView6);
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i4) {
        NativeExpressADListener nativeExpressADListener = this.f41527k;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i4));
        }
    }

    public String getAdNetWorkName() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((NEADI) obj).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i4) {
        loadAD(i4, null);
    }

    public void loadAD(int i4, LoadAdParams loadAdParams) {
        if (a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!b()) {
                synchronized (this.f41524h) {
                    this.f41524h.add(Integer.valueOf(i4));
                }
                return;
            }
            Object obj = this.f41434a;
            if (obj == null) {
                a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f41529m;
            NEADI neadi = (NEADI) obj;
            if (loadAdParams2 != null) {
                neadi.loadAd(i4, loadAdParams2);
            } else {
                neadi.loadAd(i4);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f41529m = loadAdParams;
    }

    public void setMaxVideoDuration(int i4) {
        this.f41523g = i4;
        if (this.f41523g > 0 && this.f41522f > this.f41523g) {
            GDTLogger.e("maxVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5c0f\u4e8eminVideoDuration");
        }
        Object obj = this.f41434a;
        if (obj != null) {
            ((NEADI) obj).setMaxVideoDuration(this.f41523g);
        }
    }

    public void setMinVideoDuration(int i4) {
        this.f41522f = i4;
        if (this.f41523g > 0 && this.f41522f > this.f41523g) {
            GDTLogger.e("minVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5927\u4e8emaxVideoDuration");
        }
        Object obj = this.f41434a;
        if (obj != null) {
            ((NEADI) obj).setMinVideoDuration(this.f41522f);
        }
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f41528l.setAdRewardListener(aDRewardListener);
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f41530n = serverSideVerificationOptions;
        Object obj = this.f41434a;
        if (obj != null) {
            ((NEADI) obj).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f41525i = videoOption;
        Object obj = this.f41434a;
        if (obj == null || videoOption == null) {
            return;
        }
        ((NEADI) obj).setVideoOption(videoOption);
    }

    static boolean a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
        NativeExpressADView nativeExpressADView;
        if (nativeExpressMediaListener != null && (nativeExpressADView = (NativeExpressADView) aDEvent.getParam(NativeExpressADView.class)) != null) {
            int type = aDEvent.getType();
            if (type == 201) {
                nativeExpressMediaListener.onVideoCached(nativeExpressADView);
                return true;
            } else if (type == 202) {
                nativeExpressMediaListener.onVideoStart(nativeExpressADView);
                return true;
            } else if (type == 204) {
                nativeExpressMediaListener.onVideoPause(nativeExpressADView);
                return true;
            } else if (type == 206) {
                nativeExpressMediaListener.onVideoComplete(nativeExpressADView);
                return true;
            } else if (type == 207) {
                Integer num = (Integer) aDEvent.getParam(1, Integer.class);
                if (num != null) {
                    nativeExpressMediaListener.onVideoError(nativeExpressADView, AdErrorConvertor.formatErrorCode(num.intValue()));
                    return true;
                }
                return true;
            } else if (type == 301) {
                nativeExpressMediaListener.onVideoPageOpen(nativeExpressADView);
                return true;
            } else if (type == 302) {
                nativeExpressMediaListener.onVideoPageClose(nativeExpressADView);
                return true;
            } else {
                switch (type) {
                    case 209:
                        nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                        return true;
                    case 210:
                        Integer num2 = (Integer) aDEvent.getParam(1, Integer.class);
                        if (num2 != null) {
                            nativeExpressMediaListener.onVideoReady(nativeExpressADView, num2.intValue());
                            return true;
                        }
                        return true;
                    case 211:
                        nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                        return true;
                }
            }
        }
        return false;
    }

    static boolean a(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener != null && aDEvent.getType() == 304) {
            negativeFeedbackListener.onComplainSuccess();
            return true;
        }
        return false;
    }

    static boolean a(ADRewardListener aDRewardListener, ADEvent aDEvent) {
        if (aDRewardListener != null && aDEvent.getType() == 104) {
            String str = (String) aDEvent.getParam(String.class);
            if (str != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("transId", str);
                aDRewardListener.onReward(hashMap);
            }
            return true;
        }
        return false;
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f41526j, str, str2, str3, this.f41528l);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NEADI neadi = (NEADI) obj;
        neadi.setMinVideoDuration(this.f41522f);
        neadi.setMaxVideoDuration(this.f41523g);
        ((NEADI) this.f41434a).setServerSideVerificationOptions(this.f41530n);
        VideoOption videoOption = this.f41525i;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f41524h) {
            Iterator<Integer> it = this.f41524h.iterator();
            while (it.hasNext()) {
                Object obj2 = this.f41434a;
                if (obj2 != null) {
                    if (this.f41529m != null) {
                        ((NEADI) obj2).loadAd(it.next().intValue(), this.f41529m);
                    } else {
                        ((NEADI) obj2).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }
}
