package com.p518qq.p519e.ads.nativ;

import android.content.Context;
import com.p518qq.p519e.ads.NativeAbstractAD;
import com.p518qq.p519e.ads.cfg.VideoOption;
import com.p518qq.p519e.ads.rewardvideo.ServerSideVerificationOptions;
import com.p518qq.p519e.comm.adevent.ADEvent;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.p518qq.p519e.comm.constants.LoadAdParams;
import com.p518qq.p519e.comm.listeners.ADRewardListener;
import com.p518qq.p519e.comm.listeners.NegativeFeedbackListener;
import com.p518qq.p519e.comm.p520pi.IReward;
import com.p518qq.p519e.comm.p520pi.NEADI;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeExpressAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NativeExpressAD extends NativeAbstractAD<NEADI> implements IReward {

    /* renamed from: f */
    private volatile int f32807f;

    /* renamed from: g */
    private volatile int f32808g;

    /* renamed from: h */
    private List<Integer> f32809h = Collections.synchronizedList(new ArrayList());

    /* renamed from: i */
    private VideoOption f32810i;

    /* renamed from: j */
    private ADSize f32811j;

    /* renamed from: k */
    private NativeExpressADListener f32812k;

    /* renamed from: l */
    private final ADListenerAdapter f32813l;

    /* renamed from: m */
    private LoadAdParams f32814m;

    /* renamed from: n */
    private volatile ServerSideVerificationOptions f32815n;

    /* renamed from: com.qq.e.ads.nativ.NativeExpressAD$ADListenerAdapter */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class ADListenerAdapter implements ADListener {

        /* renamed from: a */
        private NativeExpressADListener f32816a;

        /* renamed from: b */
        private NativeExpressMediaListener f32817b;

        /* renamed from: c */
        private NegativeFeedbackListener f32818c;

        /* renamed from: d */
        private ADRewardListener f32819d;

        public ADListenerAdapter(NativeExpressADListener nativeExpressADListener) {
            this.f32816a = nativeExpressADListener;
        }

        public ADListenerAdapter(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f32817b = nativeExpressMediaListener;
        }

        @Override // com.p518qq.p519e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (NativeExpressAD.m20382a(this.f32816a, aDEvent) || NativeExpressAD.m20381a(this.f32817b, aDEvent) || NativeExpressAD.m20379a(this.f32818c, aDEvent)) {
                return;
            }
            NativeExpressAD.m20380a(this.f32819d, aDEvent);
        }

        public void setAdRewardListener(ADRewardListener aDRewardListener) {
            this.f32819d = aDRewardListener;
        }

        public void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener) {
            this.f32817b = nativeExpressMediaListener;
        }

        public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
            this.f32818c = negativeFeedbackListener;
        }
    }

    /* renamed from: com.qq.e.ads.nativ.NativeExpressAD$NativeExpressADListener */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
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
        this.f32812k = nativeExpressADListener;
        this.f32813l = new ADListenerAdapter(nativeExpressADListener);
        if (m20383a(aDSize)) {
            return;
        }
        m20414a(context, str);
    }

    public NativeExpressAD(Context context, ADSize aDSize, String str, NativeExpressADListener nativeExpressADListener, String str2) {
        this.f32812k = nativeExpressADListener;
        this.f32813l = new ADListenerAdapter(nativeExpressADListener);
        if (m20383a(aDSize)) {
            return;
        }
        m20413a(context, str, str2);
    }

    /* renamed from: a */
    private boolean m20383a(ADSize aDSize) {
        if (aDSize != null) {
            this.f32811j = aDSize;
            return false;
        }
        GDTLogger.m20307e("初始化错误：参数adSize不能为空");
        m20415a(2001);
        return true;
    }

    /* renamed from: a */
    static boolean m20382a(NativeExpressADListener nativeExpressADListener, ADEvent aDEvent) {
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

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: b */
    protected void mo20366b(int i) {
        NativeExpressADListener nativeExpressADListener = this.f32812k;
        if (nativeExpressADListener != null) {
            nativeExpressADListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f32719a;
        if (t != 0) {
            return ((NEADI) t).getAdNetWorkName();
        }
        m20410a("getAdNetWorkName");
        return null;
    }

    public void loadAD(int i) {
        loadAD(i, null);
    }

    public void loadAD(int i, LoadAdParams loadAdParams) {
        if (m20416a()) {
            if (loadAdParams != null) {
                setAdParams(loadAdParams);
            }
            if (!m20409b()) {
                synchronized (this.f32809h) {
                    this.f32809h.add(Integer.valueOf(i));
                }
                return;
            }
            T t = this.f32719a;
            if (t == 0) {
                m20410a("loadAD");
                return;
            }
            LoadAdParams loadAdParams2 = this.f32814m;
            NEADI neadi = (NEADI) t;
            if (loadAdParams2 != null) {
                neadi.loadAd(i, loadAdParams2);
            } else {
                neadi.loadAd(i);
            }
        }
    }

    public void setAdParams(LoadAdParams loadAdParams) {
        this.f32814m = loadAdParams;
    }

    public void setMaxVideoDuration(int i) {
        this.f32808g = i;
        if (this.f32808g > 0 && this.f32807f > this.f32808g) {
            GDTLogger.m20307e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f32719a;
        if (t != 0) {
            ((NEADI) t).setMaxVideoDuration(this.f32808g);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f32807f = i;
        if (this.f32808g > 0 && this.f32807f > this.f32808g) {
            GDTLogger.m20307e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f32719a;
        if (t != 0) {
            ((NEADI) t).setMinVideoDuration(this.f32807f);
        }
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f32813l.setAdRewardListener(aDRewardListener);
    }

    @Override // com.p518qq.p519e.comm.p520pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.f32815n = serverSideVerificationOptions;
        T t = this.f32719a;
        if (t != 0) {
            ((NEADI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void setVideoOption(VideoOption videoOption) {
        this.f32810i = videoOption;
        T t = this.f32719a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((NEADI) t).setVideoOption(videoOption);
    }

    /* renamed from: a */
    static boolean m20381a(NativeExpressMediaListener nativeExpressMediaListener, ADEvent aDEvent) {
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
                    case AdEventType.VIDEO_INIT /* 209 */:
                        nativeExpressMediaListener.onVideoInit(nativeExpressADView);
                        return true;
                    case AdEventType.VIDEO_READY /* 210 */:
                        Integer num2 = (Integer) aDEvent.getParam(1, Integer.class);
                        if (num2 != null) {
                            nativeExpressMediaListener.onVideoReady(nativeExpressADView, num2.intValue());
                            return true;
                        }
                        return true;
                    case AdEventType.VIDEO_LOADING /* 211 */:
                        nativeExpressMediaListener.onVideoLoading(nativeExpressADView);
                        return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    static boolean m20379a(NegativeFeedbackListener negativeFeedbackListener, ADEvent aDEvent) {
        if (negativeFeedbackListener != null && aDEvent.getType() == 304) {
            negativeFeedbackListener.onComplainSuccess();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    static boolean m20380a(ADRewardListener aDRewardListener, ADEvent aDEvent) {
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

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected Object mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeExpressADDelegate(context, this.f32811j, str, str2, str3, this.f32813l);
    }

    @Override // com.p518qq.p519e.ads.NativeAbstractAD, com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected void mo20368a(Object obj) {
        NEADI neadi = (NEADI) obj;
        neadi.setMinVideoDuration(this.f32807f);
        neadi.setMaxVideoDuration(this.f32808g);
        ((NEADI) this.f32719a).setServerSideVerificationOptions(this.f32815n);
        VideoOption videoOption = this.f32810i;
        if (videoOption != null) {
            setVideoOption(videoOption);
        }
        synchronized (this.f32809h) {
            Iterator<Integer> it = this.f32809h.iterator();
            while (it.hasNext()) {
                T t = this.f32719a;
                if (t != 0) {
                    if (this.f32814m != null) {
                        ((NEADI) t).loadAd(it.next().intValue(), this.f32814m);
                    } else {
                        ((NEADI) t).loadAd(it.next().intValue());
                    }
                }
            }
        }
    }
}
