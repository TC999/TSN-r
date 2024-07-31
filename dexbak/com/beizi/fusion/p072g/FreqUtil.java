package com.beizi.fusion.p072g;

import android.content.Context;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.FreqItem;
import com.beizi.fusion.p063a.DaoManager;
import com.beizi.fusion.p066d.AdManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.beizi.fusion.g.y */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FreqUtil {

    /* renamed from: a */
    private static HashMap<String, Object> f11471a = new HashMap<>();

    /* renamed from: b */
    private static HashMap<String, Object> f11472b = new HashMap<>();

    /* renamed from: c */
    private static Comparator<EventItem> f11473c = new Comparator<EventItem>() { // from class: com.beizi.fusion.g.y.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(EventItem eventItem, EventItem eventItem2) {
            return eventItem.getTimeStamp().compareTo(eventItem2.getTimeStamp());
        }
    };

    /* renamed from: d */
    private static HashMap<String, Long> f11474d = new HashMap<>();

    /* renamed from: e */
    private static HashMap<String, FreqItem> f11475e = new HashMap<>();

    /* renamed from: f */
    private static HashSet<String> f11476f = new HashSet<>();

    /* renamed from: a */
    public static void m48167a(Context context, String str) {
        try {
            ArrayList arrayList = (ArrayList) DaoManager.m48999a(context).m48996a(str);
            f11471a.put(str, m48161a(arrayList));
            f11472b.put(str, m48157b(arrayList));
            m48154d("adUnitId = " + str + ",platFormMap get = " + f11471a.get(str) + ",channelMap get = " + f11472b.get(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public static void m48159b(Context context, String str) {
        if (m48165a(str)) {
            return;
        }
        m48156c(context, str);
        int i = 0;
        while (!m48165a(str) && i < 100) {
            m48154d("currentWaitInitTime = " + i);
            try {
                Thread.sleep(5L);
                i += 5;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private static void m48156c(final Context context, final String str) {
        C3145h.m48264b().m48263c().execute(new Runnable() { // from class: com.beizi.fusion.g.y.2
            @Override // java.lang.Runnable
            public void run() {
                FreqUtil.m48167a(context, str);
            }
        });
    }

    /* renamed from: d */
    public static void m48154d(String str) {
        C3116af.m48495b("FreqUtil", str);
    }

    /* renamed from: c */
    public static FreqItem m48155c(String str) {
        return f11475e.get(str);
    }

    /* renamed from: a */
    public static int m48163a(String str, String str2) {
        ArrayList arrayList;
        int i = 0;
        if (str2 == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("enter getTodayEventTimes channelMap != null ?  ");
        sb.append(f11472b != null);
        sb.append(",eventCode = ");
        sb.append(str2);
        m48154d(sb.toString());
        m48159b(AdManager.m48786a().m48778e(), str);
        String valueOf = String.valueOf(m48168a());
        if ("200.000".equalsIgnoreCase(str2)) {
            HashMap<String, Object> hashMap = f11471a;
            if (hashMap != null && hashMap.get(str) != null) {
                m48154d("getSpaceTodayEventTimes platFormMap.containsKey(adUnitId) = " + f11471a.containsKey(str));
                HashMap hashMap2 = (HashMap) f11471a.get(str);
                if (hashMap2 != null && (arrayList = (ArrayList) hashMap2.get(str2)) != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((EventItem) it.next()).getTimeStamp().compareTo(valueOf) > 0) {
                            i++;
                        }
                    }
                }
            }
        } else {
            HashMap<String, Object> hashMap3 = f11472b;
            if (hashMap3 != null && hashMap3.get(str) != null) {
                m48154d("getSpaceTodayEventTimes channelMap.containsKey(adUnitId) = " + f11472b.containsKey(str));
                HashMap hashMap4 = (HashMap) f11472b.get(str);
                Iterator<String> it2 = f11476f.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (hashMap4 != null && hashMap4.get(next) != null) {
                        HashMap hashMap5 = (HashMap) hashMap4.get(next);
                        m48154d("getSpaceTodayEventTimes eventMap = " + hashMap5);
                        if (hashMap5 != null && hashMap5.get(str2) != null) {
                            ArrayList arrayList2 = (ArrayList) hashMap5.get(str2);
                            m48154d("getSpaceTodayEventTimes itemList = " + arrayList2 + ",eventCode = " + str2);
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                C3116af.m48494c("BeiZis", arrayList2.toString());
                                Iterator it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    if (((EventItem) it3.next()).getTimeStamp().compareTo(valueOf) > 0) {
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        C3116af.m48494c("BeiZis", "todayEventTimes = " + i);
        return i;
    }

    /* renamed from: b */
    public static long m48158b(String str) {
        Long l = f11474d.get(str);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    /* renamed from: b */
    private static Map<String, Map<String, List<EventItem>>> m48157b(List<EventItem> list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (list != null && list.size() != 0) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (EventItem eventItem : list) {
                String spaceId = eventItem.getSpaceId();
                if (spaceId != null) {
                    if (!hashMap.containsKey(spaceId)) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(eventItem);
                    } else {
                        arrayList2 = (ArrayList) hashMap.get(spaceId);
                        if (arrayList2 != null) {
                            arrayList2.add(eventItem);
                        }
                    }
                    hashMap.put(spaceId, arrayList2);
                }
                String channel = eventItem.getChannel();
                f11476f.add(channel);
                if (channel != null) {
                    if (!hashMap2.containsKey(channel)) {
                        arrayList = new ArrayList();
                        arrayList.add(eventItem);
                    } else {
                        arrayList = (ArrayList) hashMap2.get(channel);
                        if (arrayList != null) {
                            arrayList.add(eventItem);
                        }
                    }
                    hashMap2.put(channel, arrayList);
                }
            }
            HashMap hashMap3 = new HashMap();
            for (String str : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                if (arrayList3 != null) {
                    hashMap3.put(str, (HashMap) m48161a(arrayList3));
                }
            }
            for (String str2 : hashMap2.keySet()) {
                ArrayList arrayList4 = (ArrayList) hashMap2.get(str2);
                if (arrayList4 != null) {
                    hashMap3.put(str2, (HashMap) m48161a(arrayList4));
                }
            }
            return hashMap3;
        }
        return new HashMap();
    }

    /* renamed from: a */
    public static long m48168a() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    /* renamed from: a */
    public static boolean m48165a(String str) {
        return f11471a.containsKey(str) && f11472b.containsKey(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0148, code lost:
        return true;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m48160a(java.util.List<com.beizi.fusion.model.FreqItem> r18, java.lang.String r19, java.lang.String r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.FreqUtil.m48160a(java.util.List, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    private static void m48162a(String str, List<FreqItem> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        long m48158b = m48158b(str);
        for (FreqItem freqItem : list) {
            m48158b = Math.max(freqItem.getInterval(), m48158b);
        }
        m48154d("maxInterval = " + m48158b);
        f11474d.put(str, Long.valueOf(m48158b));
    }

    /* renamed from: a */
    private static Map<String, List<EventItem>> m48161a(List<EventItem> list) {
        ArrayList arrayList;
        if (list != null && list.size() != 0) {
            HashMap hashMap = new HashMap();
            String str = null;
            ArrayList arrayList2 = null;
            for (EventItem eventItem : list) {
                String code = eventItem.getCode();
                if (!code.equals(str)) {
                    if (str != null && arrayList2 != null) {
                        hashMap.put(str, arrayList2);
                    }
                    if (!hashMap.containsKey(code)) {
                        arrayList = new ArrayList();
                        arrayList.add(eventItem);
                    } else {
                        arrayList = (ArrayList) hashMap.get(code);
                        if (arrayList != null) {
                            arrayList.add(eventItem);
                        }
                    }
                    hashMap.put(code, arrayList);
                    arrayList2 = arrayList;
                } else if (arrayList2 != null) {
                    arrayList2.add(eventItem);
                }
                str = code;
            }
            for (String str2 : hashMap.keySet()) {
                ArrayList arrayList3 = (ArrayList) hashMap.get(str2);
                Collections.sort(arrayList3, f11473c);
                hashMap.put(str2, arrayList3);
            }
            return hashMap;
        }
        return new HashMap();
    }

    /* renamed from: a */
    public static void m48164a(String str, EventItem eventItem) {
        try {
            HashMap hashMap = (HashMap) f11471a.get(str);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            String code = eventItem.getCode();
            m48166a(eventItem, hashMap, code);
            String spaceId = eventItem.getSpaceId();
            if (spaceId != null) {
                HashMap hashMap2 = (HashMap) f11472b.get(str);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap();
                }
                HashMap hashMap3 = (HashMap) hashMap2.get(spaceId);
                if (hashMap3 == null) {
                    hashMap3 = new HashMap();
                }
                m48166a(eventItem, hashMap3, code);
                hashMap2.put(spaceId, hashMap3);
            }
            String channel = eventItem.getChannel();
            f11476f.add(channel);
            if (channel != null) {
                HashMap hashMap4 = (HashMap) f11472b.get(str);
                if (hashMap4 == null) {
                    hashMap4 = new HashMap();
                }
                HashMap hashMap5 = (HashMap) hashMap4.get(channel);
                if (hashMap5 == null) {
                    hashMap5 = new HashMap();
                }
                m48166a(eventItem, hashMap5, code);
                hashMap4.put(channel, hashMap5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m48166a(EventItem eventItem, HashMap<String, List<EventItem>> hashMap, String str) {
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                if (str != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(eventItem);
                    hashMap.put(str, arrayList);
                    return;
                }
                return;
            }
            ArrayList arrayList2 = (ArrayList) hashMap.get(str);
            if (arrayList2 != null) {
                arrayList2.add(eventItem);
                Collections.sort(arrayList2, f11473c);
                hashMap.put(str, arrayList2);
            }
        }
    }
}
