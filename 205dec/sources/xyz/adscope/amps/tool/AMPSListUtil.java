package xyz.adscope.amps.tool;

import java.util.List;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AMPSListUtil {
    public static void addDataToList(List list, List list2) {
        if (list == null || list2 == null || list2.size() <= 0) {
            return;
        }
        list.addAll(list2);
    }

    public static void addDataToList(List list, Object obj) {
        if (list == null || obj == null) {
            return;
        }
        list.add(obj);
    }
}
