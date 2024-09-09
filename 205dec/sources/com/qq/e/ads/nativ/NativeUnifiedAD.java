package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: f  reason: collision with root package name */
    private AdListenerAdapter f41535f;

    /* renamed from: g  reason: collision with root package name */
    private NativeADUnifiedListener f41536g;

    /* renamed from: h  reason: collision with root package name */
    private List<Integer> f41537h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private List<String> f41538i;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f41539j;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f41540k;

    /* renamed from: l  reason: collision with root package name */
    private String f41541l;

    /* renamed from: m  reason: collision with root package name */
    private LoadAdParams f41542m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class AdListenerAdapter implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private NativeADUnifiedListener f41543a;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f41543a = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            Integer num;
            if (this.f41543a != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type == 101 && (num = (Integer) aDEvent.getParam(Integer.class)) != null) {
                        this.f41543a.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
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
                this.f41543a.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f41536g = nativeADUnifiedListener;
        this.f41535f = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f41536g = nativeADUnifiedListener;
        this.f41535f = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    private void a(int i4, boolean z3) {
        if (a()) {
            if (!b()) {
                if (z3) {
                    this.f41537h.add(Integer.valueOf(i4));
                    return;
                }
                return;
            }
            Object obj = this.f41434a;
            if (obj != null) {
                LoadAdParams loadAdParams = this.f41542m;
                NUADI nuadi = (NUADI) obj;
                if (loadAdParams != null) {
                    nuadi.loadData(i4, loadAdParams);
                } else {
                    nuadi.loadData(i4);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    protected Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f41535f);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i4) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f41536g;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i4));
        }
    }

    public String getAdNetWorkName() {
        Object obj = this.f41434a;
        if (obj != null) {
            return ((NUADI) obj).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i4) {
        a(i4, true);
    }

    public void loadData(int i4, LoadAdParams loadAdParams) {
        this.f41542m = loadAdParams;
        loadData(i4);
    }

    public void setCategories(List<String> list) {
        this.f41538i = list;
        Object obj = this.f41434a;
        if (obj == null || list == null) {
            return;
        }
        ((NUADI) obj).setCategories(list);
    }

    public void setMaxVideoDuration(int i4) {
        this.f41540k = i4;
        if (this.f41540k > 0 && this.f41539j > this.f41540k) {
            GDTLogger.e("maxVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5c0f\u4e8eminVideoDuration");
        }
        Object obj = this.f41434a;
        if (obj != null) {
            ((NUADI) obj).setMaxVideoDuration(this.f41540k);
        }
    }

    public void setMinVideoDuration(int i4) {
        this.f41539j = i4;
        if (this.f41540k > 0 && this.f41539j > this.f41540k) {
            GDTLogger.e("minVideoDuration \u8bbe\u7f6e\u503c\u975e\u6cd5\uff0c\u4e0d\u5f97\u5927\u4e8emaxVideoDuration");
        }
        Object obj = this.f41434a;
        if (obj != null) {
            ((NUADI) obj).setMinVideoDuration(this.f41539j);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name \u4e0d\u80fd\u4e3a\u7a7a");
            return;
        }
        this.f41541l = str;
        Object obj = this.f41434a;
        if (obj != null) {
            ((NUADI) obj).setVastClassName(str);
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    protected void a(Object obj) {
        NUADI nuadi = (NUADI) obj;
        nuadi.setMinVideoDuration(this.f41539j);
        nuadi.setMaxVideoDuration(this.f41540k);
        nuadi.setVastClassName(this.f41541l);
        List<String> list = this.f41538i;
        if (list != null) {
            setCategories(list);
        }
        for (Integer num : this.f41537h) {
            a(num.intValue(), false);
        }
    }
}
