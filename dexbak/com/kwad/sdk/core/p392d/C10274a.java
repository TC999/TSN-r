package com.kwad.sdk.core.p392d;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.request.model.C10480f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11126t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.d.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10274a {
    private static volatile C10274a avh;
    public static ThreadLocal<SimpleDateFormat> avi = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.d.a.1
        @Nullable
        /* renamed from: DK */
        private static SimpleDateFormat m26464DK() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        @Nullable
        protected final /* synthetic */ SimpleDateFormat initialValue() {
            return m26464DK();
        }
    };

    /* renamed from: DF */
    public static C10274a m26475DF() {
        if (avh == null) {
            synchronized (C10274a.class) {
                if (avh == null) {
                    avh = new C10274a();
                }
            }
        }
        return avh;
    }

    /* renamed from: DG */
    public static boolean m26474DG() {
        List<C10480f> m26466de = m26466de(15);
        if (m26466de.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (C10480f c10480f : m26466de) {
            i += c10480f.count;
            long j2 = c10480f.azP;
            if (j2 > j) {
                j = j2;
            }
        }
        C10331c.m26254d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > m26472DI()) {
            return false;
        }
        return j + (m26471DJ() * 1000) <= System.currentTimeMillis();
    }

    /* renamed from: DH */
    public static List<C10480f> m26473DH() {
        if (((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<C10480f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                C10480f c10480f = new C10480f();
                c10480f.parseJson(jSONObject);
                arrayList.add(c10480f);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (C10480f c10480f2 : arrayList) {
            if (m26469a(c10480f2)) {
                arrayList2.add(c10480f2);
            }
        }
        return arrayList2;
    }

    /* renamed from: DI */
    private static int m26472DI() {
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    /* renamed from: DJ */
    private static long m26471DJ() {
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    /* renamed from: Q */
    private static void m26470Q(String str, String str2) {
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    /* renamed from: a */
    private static boolean m26469a(@NonNull C10480f c10480f) {
        long j = c10480f.azP;
        if (j <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = avi.get();
        return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date()));
    }

    /* renamed from: bU */
    public static void m26468bU(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            C10331c.m26254d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            m26467bV(adTemplate);
        }
    }

    /* renamed from: bV */
    private static void m26467bV(AdTemplate adTemplate) {
        int m25633dY = C10487e.m25633dY(adTemplate);
        int m25647dK = C10487e.m25647dK(adTemplate);
        List m26473DH = m26473DH();
        if (m26473DH != null && m26473DH.size() != 0) {
            boolean z = false;
            Iterator it = m26473DH.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C10480f c10480f = (C10480f) it.next();
                if (c10480f.adStyle == m25647dK && c10480f.taskType == m25633dY) {
                    c10480f.count++;
                    if (!m26469a(c10480f)) {
                        c10480f.count = 1;
                        c10480f.m25983ar(System.currentTimeMillis());
                    }
                    z = true;
                }
            }
            if (!z) {
                m26473DH.add(new C10480f(m25647dK, m25633dY, 1, System.currentTimeMillis()));
            }
        } else {
            m26473DH = new ArrayList();
            m26473DH.add(new C10480f(m25647dK, m25633dY, 1, System.currentTimeMillis()));
        }
        m26470Q("ksadsdk_local_ad_task_info_adstyle_data", C11126t.m23681O(m26473DH).toString());
        adTemplate.watched = true;
    }

    @NonNull
    /* renamed from: de */
    private static List<C10480f> m26466de(int i) {
        ArrayList arrayList = new ArrayList();
        List<C10480f> m26473DH = m26473DH();
        if (m26473DH != null && m26473DH.size() != 0) {
            for (C10480f c10480f : m26473DH) {
                if (15 == c10480f.adStyle) {
                    arrayList.add(c10480f);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static void m26465e(int i, long j) {
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static String getString(String str) {
        Context context = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
    }
}
