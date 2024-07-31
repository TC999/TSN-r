package com.baidu.mobads.sdk.internal.p050a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.C2634bs;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.baidu.mobads.sdk.internal.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2576c implements InterfaceC2574a {

    /* renamed from: a */
    public static final String f8502a = "ViewPager2";

    /* renamed from: b */
    public static final String f8503b = "RVAdapter";

    /* renamed from: c */
    public static final String f8504c = "RVViewHolder";

    /* renamed from: d */
    public static final String f8505d = "ViewCompat";

    /* renamed from: e */
    public static final String f8506e = "Fragment";

    /* renamed from: f */
    public static final String f8507f = "FragmentV4";

    /* renamed from: g */
    public static final String f8508g = "RLRecyclerView";

    /* renamed from: h */
    public static final String f8509h = "p_e";

    /* renamed from: i */
    private static final String f8510i = "p_init";

    /* renamed from: j */
    private static final String f8511j = "p_set_class";

    /* renamed from: k */
    private static final String f8512k = "e_t";

    /* renamed from: l */
    private static final String f8513l = "e_n";

    /* renamed from: m */
    private static final String f8514m = "e_a";

    /* renamed from: n */
    private static final String f8515n = "e_r";

    /* renamed from: o */
    private static final String f8516o = "e_d";

    /* renamed from: p */
    private final IAdInterListener f8517p;

    /* renamed from: com.baidu.mobads.sdk.internal.a.c$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2577a implements IOAdEventListener {
        /* renamed from: a */
        private InterfaceC2574a m51070a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if (C2576c.f8502a.equals(str) && C2576c.m51071a(objArr, Context.class)) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if (C2576c.f8503b.equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if (C2576c.f8504c.equals(str) && C2576c.m51071a(objArr, View.class)) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if (C2576c.f8505d.equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            if (C2576c.f8506e.equals(str)) {
                return new FragmentDelegate().setDispatcher(iAdInterListener);
            }
            if (C2576c.f8507f.equals(str)) {
                return new FragmentV4Delegate().setDispatcher(iAdInterListener);
            }
            if (C2576c.f8508g.equals(str)) {
                return new RLRecyclerViewDelegate(iAdInterListener, objArr);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            InterfaceC2574a m51070a;
            if (iOAdEvent != null) {
                try {
                    if (C2576c.f8509h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(C2576c.f8512k);
                        Object obj2 = data.get(C2576c.f8513l);
                        Object obj3 = data.get(C2576c.f8514m);
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (C2576c.f8510i.equals((String) obj2)) {
                                Object obj4 = data.get(C2576c.f8516o);
                                if (!(obj4 instanceof IAdInterListener) || (m51070a = m51070a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put(C2576c.f8515n, m51070a);
                            } else if (C2576c.f8511j.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(C2576c.f8502a, ViewPager2.class);
                                map.put(C2576c.f8503b, RecyclerView.Adapter.class);
                                map.put(C2576c.f8504c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    C2634bs.m50744a().m50736b(th.getMessage());
                }
            }
        }
    }

    private C2576c(@NonNull IAdInterListener iAdInterListener, @NonNull InterfaceC2574a interfaceC2574a) {
        this.f8517p = iAdInterListener;
        iAdInterListener.addEventListener(f8509h, new C2578d(this, interfaceC2574a));
    }

    /* renamed from: a */
    public static C2576c m51074a(@NonNull IAdInterListener iAdInterListener, @NonNull InterfaceC2574a interfaceC2574a) {
        return new C2576c(iAdInterListener, interfaceC2574a);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f8517p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f8517p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.p050a.InterfaceC2574a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }

    /* renamed from: a */
    public final void m51073a(String str) {
        this.f8517p.onAdTaskProcess(str);
    }

    /* renamed from: a */
    public final Object m51072a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(f8514m, objArr);
        this.f8517p.onAdTaskProcess(str, hashMap);
        return hashMap.get(f8515n);
    }

    /* renamed from: a */
    public static boolean m51071a(Object[] objArr, Class<?>... clsArr) {
        boolean z = objArr == null || objArr.length == 0;
        boolean z2 = clsArr == null || clsArr.length == 0;
        if (z && z2) {
            return true;
        }
        if (z || z2 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!clsArr[i].isInstance(objArr[i])) {
                return false;
            }
        }
        return true;
    }
}
