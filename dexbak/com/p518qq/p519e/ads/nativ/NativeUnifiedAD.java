package com.p518qq.p519e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.p518qq.p519e.ads.NativeAbstractAD;
import com.p518qq.p519e.comm.adevent.ADEvent;
import com.p518qq.p519e.comm.adevent.ADListener;
import com.p518qq.p519e.comm.constants.LoadAdParams;
import com.p518qq.p519e.comm.p520pi.NUADI;
import com.p518qq.p519e.comm.p520pi.POFactory;
import com.p518qq.p519e.comm.util.AdErrorConvertor;
import com.p518qq.p519e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.qq.e.ads.nativ.NativeUnifiedAD */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: f */
    private AdListenerAdapter f32820f;

    /* renamed from: g */
    private NativeADUnifiedListener f32821g;

    /* renamed from: h */
    private List<Integer> f32822h = new ArrayList();

    /* renamed from: i */
    private List<String> f32823i;

    /* renamed from: j */
    private volatile int f32824j;

    /* renamed from: k */
    private volatile int f32825k;

    /* renamed from: l */
    private String f32826l;

    /* renamed from: m */
    private LoadAdParams f32827m;

    /* renamed from: com.qq.e.ads.nativ.NativeUnifiedAD$AdListenerAdapter */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class AdListenerAdapter implements ADListener {

        /* renamed from: a */
        private NativeADUnifiedListener f32828a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f32828a = nativeADUnifiedListener;
        }

        @Override // com.p518qq.p519e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f32828a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f32828a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                        return;
                    }
                    return;
                }
                List<NativeUnifiedADData> list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    arrayList.add(new NativeUnifiedADDataAdapter(nativeUnifiedADData));
                }
                this.f32828a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f32821g = nativeADUnifiedListener;
        this.f32820f = new AdListenerAdapter(nativeADUnifiedListener);
        m20414a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f32821g = nativeADUnifiedListener;
        this.f32820f = new AdListenerAdapter(nativeADUnifiedListener);
        m20413a(context, str, str2);
    }

    /* renamed from: a */
    private void m20378a(int i, boolean z) {
        if (m20416a()) {
            if (!m20409b()) {
                if (z) {
                    this.f32822h.add(Integer.valueOf(i));
                    return;
                }
                return;
            }
            T t = this.f32719a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.f32827m;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        }
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected Object mo20371a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f32820f);
    }

    @Override // com.p518qq.p519e.ads.AbstractAD
    /* renamed from: b */
    protected void mo20366b(int i) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f32821g;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public String getAdNetWorkName() {
        T t = this.f32719a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        m20410a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i) {
        m20378a(i, true);
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        this.f32827m = loadAdParams;
        loadData(i);
    }

    public void setCategories(List<String> list) {
        this.f32823i = list;
        T t = this.f32719a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.f32825k = i;
        if (this.f32825k > 0 && this.f32824j > this.f32825k) {
            GDTLogger.m20307e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f32719a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.f32825k);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f32824j = i;
        if (this.f32825k > 0 && this.f32824j > this.f32825k) {
            GDTLogger.m20307e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f32719a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.f32824j);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.m20307e("Vast class name 不能为空");
            return;
        }
        this.f32826l = str;
        T t = this.f32719a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }

    @Override // com.p518qq.p519e.ads.NativeAbstractAD, com.p518qq.p519e.ads.AbstractAD
    /* renamed from: a */
    protected void mo20368a(Object obj) {
        NUADI nuadi = (NUADI) obj;
        nuadi.setMinVideoDuration(this.f32824j);
        nuadi.setMaxVideoDuration(this.f32825k);
        nuadi.setVastClassName(this.f32826l);
        List<String> list = this.f32823i;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.f32822h) {
            m20378a(num.intValue(), false);
        }
    }
}
