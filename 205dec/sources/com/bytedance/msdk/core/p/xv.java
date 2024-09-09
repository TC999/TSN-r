package com.bytedance.msdk.core.p;

import android.text.TextUtils;
import com.bytedance.msdk.core.k.p;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    /* JADX INFO: Access modifiers changed from: protected */
    public static List<p> c(com.bytedance.msdk.core.k.w wVar, String str) {
        return c(wVar, str, 0.0d, 0.0d);
    }

    private static void w(double d4, double d5, double d6, com.bytedance.msdk.core.k.w wVar, List<p> list) {
        if (d5 < d6 || d5 <= 0.0d || d4 < wVar.gb()) {
            return;
        }
        if (d4 > wVar.ls() && d6 <= 0.0d) {
            list.addAll(wVar.up());
            return;
        }
        double doubleValue = BigDecimal.valueOf(d4 * d5).setScale(2, RoundingMode.HALF_UP).doubleValue();
        double doubleValue2 = BigDecimal.valueOf(d4 * d6).setScale(2, RoundingMode.HALF_UP).doubleValue();
        List<p> up = wVar.up();
        double d7 = -1.0d;
        double d8 = -1.0d;
        for (int i4 = 0; i4 < up.size(); i4++) {
            p pVar = up.get(i4);
            if (pVar.s() == 0) {
                double doubleValue3 = BigDecimal.valueOf(pVar.q()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                if (doubleValue3 <= doubleValue && doubleValue3 >= doubleValue2) {
                    if (d7 == -1.0d || d7 < pVar.q()) {
                        d7 = pVar.q();
                    }
                    if (d8 == -1.0d || d8 > pVar.q()) {
                        d8 = pVar.q();
                    }
                    list.add(pVar);
                }
            } else {
                list.add(pVar);
            }
        }
        wVar.ux().put("max_ecpm", Double.valueOf(d7));
        wVar.ux().put("min_ecpm", Double.valueOf(d8));
        wVar.ux().put("upper_cpm_x", Double.valueOf(doubleValue));
    }

    public static List<p> c(com.bytedance.msdk.core.k.w wVar, String str, double d4, double d5) {
        int i4;
        double d6;
        if (wVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        com.bytedance.msdk.core.k.ux ux = com.bytedance.msdk.core.c.w().ux(str);
        if (ux != null) {
            double c4 = ux.c();
            double w3 = ux.w();
            int xv = ux.xv();
            if (wVar.f() != 3 && wVar.f() != 4) {
                d6 = wVar.f() == 2 ? w.sr().c(3, str, xv) : 0.0d;
                i4 = 1;
            } else {
                i4 = 1;
                double[] c5 = w.sr().c(wVar.f(), d4, d5, wVar.me(), str);
                double d7 = c5[0];
                wVar.ux().put("price_from", Integer.valueOf((int) c5[1]));
                d6 = d7;
            }
            if (!ux.ux() && d6 > 0.0d) {
                if (ux.getType() == i4) {
                    w(d6, c4, w3, wVar, copyOnWriteArrayList);
                } else if (ux.getType() == 2) {
                    c(d6, c4, w3, wVar, copyOnWriteArrayList);
                }
                List<com.bytedance.msdk.core.k.sr> f4 = com.bytedance.msdk.core.c.w().f(String.valueOf(wVar.yu()));
                if (f4 != null) {
                    Iterator<com.bytedance.msdk.core.k.sr> it = f4.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bytedance.msdk.core.k.sr next = it.next();
                        if (d6 > next.f() && d6 <= next.ux()) {
                            wVar.ux().put("user_label_value", next);
                            break;
                        }
                    }
                }
            }
            wVar.ux().put("rule_id", ux.sr());
            wVar.ux().put("ecpm", Double.valueOf(d6));
            wVar.ux().put("rule_in_use", Integer.valueOf(copyOnWriteArrayList.size() == 0 ? 0 : 1));
            wVar.ux().put("group_type", Integer.valueOf(wVar.f()));
        }
        if (com.bytedance.msdk.adapter.sr.xv.w()) {
            if (copyOnWriteArrayList.size() != 0) {
                for (int i5 = 0; i5 < copyOnWriteArrayList.size(); i5++) {
                    com.bytedance.msdk.adapter.sr.xv.c("DynamicRuleCalculate", "rit\uff1a" + ((p) copyOnWriteArrayList.get(i5)).ia() + ",level\uff1a" + ((p) copyOnWriteArrayList.get(i5)).j());
                }
            } else {
                com.bytedance.msdk.adapter.sr.xv.c("DynamicRuleCalculate", "\u8d70\u539fwaterfall\uff0cinUse \uff1a \u4e0d\u751f\u6548");
            }
        }
        return copyOnWriteArrayList.size() != 0 ? copyOnWriteArrayList : wVar.up();
    }

    private static void c(double d4, double d5, double d6, com.bytedance.msdk.core.k.w wVar, List<p> list) {
        if (wVar == null || d5 == 0.0d || d4 < wVar.gb()) {
            return;
        }
        if (d4 > wVar.ls() && d6 <= 0.0d) {
            list.addAll(wVar.up());
        } else {
            c(wVar, d4, d5, d6, list);
        }
    }

    public static void c(com.bytedance.msdk.core.k.w wVar, double d4, double d5, double d6, List<p> list) {
        Map<Integer, List<p>> vc = wVar.vc();
        if (vc != null) {
            ArrayList arrayList = new ArrayList(vc.keySet());
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                if (((Integer) arrayList.get(i5)).intValue() > 0) {
                    arrayList2.add(arrayList.get(i5));
                } else {
                    List<p> list2 = vc.get(arrayList.get(i5));
                    if (list2 != null) {
                        list.addAll(list2);
                    }
                }
            }
            com.bytedance.msdk.core.r.w.c(arrayList2);
            int size = arrayList2.size();
            if (size <= 0) {
                return;
            }
            int i6 = -1;
            int i7 = size;
            for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                double d7 = i8;
                List<p> list3 = vc.get(arrayList2.get(i8));
                if (list3 != null) {
                    int i9 = 0;
                    while (true) {
                        if (i9 >= list3.size()) {
                            break;
                        }
                        p pVar = list3.get(i9);
                        if (pVar != null && pVar.s() == 0) {
                            double doubleValue = BigDecimal.valueOf(pVar.q()).setScale(2, RoundingMode.HALF_UP).doubleValue();
                            if (d4 == doubleValue) {
                                if (i6 < 0) {
                                    Double.isNaN(d7);
                                    i6 = Math.max((int) (d7 - d5), 0);
                                }
                                if (i7 == size || d4 == doubleValue) {
                                    if (d6 > 0.0d) {
                                        Double.isNaN(d7);
                                        i7 = Math.min((int) (d7 + d6), size - 1);
                                    }
                                }
                            } else if (d4 > doubleValue) {
                                if (i6 < 0) {
                                    Double.isNaN(d7);
                                    Double.isNaN(d7);
                                    i6 = Math.max((int) Math.ceil(((d7 + (d7 - 1.0d)) / 2.0d) - d5), 0);
                                }
                                if (i7 == size) {
                                    if (d6 > 0.0d) {
                                        Double.isNaN(d7);
                                        Double.isNaN(d7);
                                        i7 = Math.min((int) Math.floor(((d7 + (d7 - 1.0d)) / 2.0d) + d6), size - 1);
                                    }
                                }
                            }
                        }
                        i9++;
                    }
                    i7 = size - 1;
                }
            }
            if (i6 < 0) {
                i6 = 0;
            }
            if (i7 >= size) {
                i7 = size - 1;
            }
            int i10 = i6;
            double d8 = -1.0d;
            double d9 = -1.0d;
            double d10 = -1.0d;
            while (i10 <= i7) {
                List<p> list4 = vc.get(arrayList2.get(i10));
                if (list4 != null && list4.size() != 0) {
                    while (i4 < list4.size()) {
                        p pVar2 = list4.get(i4);
                        if (pVar2 != null) {
                            if (d9 < pVar2.q() || d9 == -1.0d) {
                                d9 = pVar2.q();
                            }
                            if (d10 > pVar2.q() || d10 == -1.0d) {
                                d10 = pVar2.q();
                            }
                            list.add(pVar2);
                            if (i10 == i6) {
                                d8 = d9;
                            }
                        }
                        i4++;
                    }
                }
                i10++;
                i4 = 0;
            }
            wVar.ux().put("upper_cpm_x", Double.valueOf(d8));
            wVar.ux().put("max_ecpm", Double.valueOf(d9));
            wVar.ux().put("min_ecpm", Double.valueOf(d10));
        }
    }
}
