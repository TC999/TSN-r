package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.bv;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c implements com.baidu.mobads.sdk.internal.a.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12298a = "ViewPager2";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12299b = "RVAdapter";

    /* renamed from: c  reason: collision with root package name */
    public static final String f12300c = "RVViewHolder";

    /* renamed from: d  reason: collision with root package name */
    public static final String f12301d = "ViewCompat";

    /* renamed from: e  reason: collision with root package name */
    public static final String f12302e = "Fragment";

    /* renamed from: f  reason: collision with root package name */
    public static final String f12303f = "FragmentV4";

    /* renamed from: g  reason: collision with root package name */
    public static final String f12304g = "RLRecyclerView";

    /* renamed from: h  reason: collision with root package name */
    public static final String f12305h = "p_e";

    /* renamed from: i  reason: collision with root package name */
    private static final String f12306i = "p_init";

    /* renamed from: j  reason: collision with root package name */
    private static final String f12307j = "p_set_class";

    /* renamed from: k  reason: collision with root package name */
    private static final String f12308k = "e_t";

    /* renamed from: l  reason: collision with root package name */
    private static final String f12309l = "e_n";

    /* renamed from: m  reason: collision with root package name */
    private static final String f12310m = "e_a";

    /* renamed from: n  reason: collision with root package name */
    private static final String f12311n = "e_r";

    /* renamed from: o  reason: collision with root package name */
    private static final String f12312o = "e_d";

    /* renamed from: p  reason: collision with root package name */
    private final IAdInterListener f12313p;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements IOAdEventListener {
        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            if ("ViewPager2".equals(str) && c.a(objArr, Context.class)) {
                return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
            }
            if ("RVAdapter".equals(str)) {
                return new RVAdapterDelegate(iAdInterListener);
            }
            if ("RVViewHolder".equals(str) && c.a(objArr, View.class)) {
                return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
            }
            if ("ViewCompat".equals(str)) {
                return new ViewCompatDelegate(iAdInterListener);
            }
            if ("Fragment".equals(str)) {
                return new FragmentDelegate().setDispatcher(iAdInterListener);
            }
            if ("FragmentV4".equals(str)) {
                return new FragmentV4Delegate().setDispatcher(iAdInterListener);
            }
            if ("RLRecyclerView".equals(str)) {
                return new RLRecyclerViewDelegate(iAdInterListener, objArr);
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a4;
            if (iOAdEvent != null) {
                try {
                    if ("p_e".equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get("e_t");
                        Object obj2 = data.get("e_n");
                        Object obj3 = data.get("e_a");
                        Object[] objArr = obj3 instanceof Object[] ? (Object[]) obj3 : null;
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if ("p_init".equals((String) obj2)) {
                                Object obj4 = data.get("e_d");
                                if (!(obj4 instanceof IAdInterListener) || (a4 = a((String) obj, (IAdInterListener) obj4, objArr)) == null) {
                                    return;
                                }
                                data.put("e_r", a4);
                            } else if ("p_set_class".equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put("ViewPager2", ViewPager2.class);
                                map.put("RVAdapter", RecyclerView.Adapter.class);
                                map.put("RVViewHolder", RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    bv.a().b(th.getMessage());
                }
            }
        }
    }

    private c(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        this.f12313p = iAdInterListener;
        iAdInterListener.addEventListener("p_e", new d(this, aVar));
    }

    public static c a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        return new c(iAdInterListener, aVar);
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        return this.f12313p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.f12313p;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
    }

    public final void a(String str) {
        this.f12313p.onAdTaskProcess(str);
    }

    public final Object a(String str, Object... objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("e_a", objArr);
        this.f12313p.onAdTaskProcess(str, hashMap);
        return hashMap.get("e_r");
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        boolean z3 = objArr == null || objArr.length == 0;
        boolean z4 = clsArr == null || clsArr.length == 0;
        if (z3 && z4) {
            return true;
        }
        if (z3 || z4 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < clsArr.length; i4++) {
            if (!clsArr[i4].isInstance(objArr[i4])) {
                return false;
            }
        }
        return true;
    }
}
