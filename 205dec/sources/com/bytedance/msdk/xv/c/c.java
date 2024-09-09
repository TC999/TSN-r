package com.bytedance.msdk.xv.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.f.gb;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final Context f28473c;

    /* renamed from: w  reason: collision with root package name */
    private final r f28474w;

    public static String c() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0, " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    private String c(int i4) {
        return (i4 != 1 && i4 == 2) ? "adevent_applog" : "adevent";
    }

    public static String sr() {
        return "ALTER TABLE adevent_applog ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    public static String w() {
        return "CREATE TABLE IF NOT EXISTS adevent_applog (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0, " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    public static String xv() {
        return "ALTER TABLE adevent ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    public synchronized void delete(int i4, List<com.bytedance.msdk.xv.c> list) {
        if (gb.c(list)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.msdk.xv.c cVar : list) {
            linkedList.add(cVar.f28471c);
        }
        this.f28474w.c().c("DELETE FROM " + c(i4) + " WHERE " + c("id", linkedList, 1000, true));
    }

    public Context getContext() {
        Context context = this.f28473c;
        return context == null ? com.bytedance.msdk.core.c.getContext() : context;
    }

    private static String c(String str, List<?> list, int i4, boolean z3) {
        int i5;
        String str2 = z3 ? " IN " : " NOT IN ";
        String str3 = z3 ? " OR " : " AND ";
        int min = Math.min(i4, 1000);
        int size = list.size();
        int i6 = size % min;
        com.bytedance.msdk.adapter.sr.xv.c("", "len=" + size + ",size=" + i6);
        if (i6 == 0) {
            i5 = size / min;
        } else {
            i5 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = i7 * min;
            String c4 = c(TextUtils.join("','", list.subList(i8, Math.min(i8 + min, size))), "");
            if (i7 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(c4);
            sb.append("')");
        }
        String sb2 = sb.toString();
        String c5 = c(sb2, str + str2 + "('')");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("sql=");
        sb3.append(c5);
        com.bytedance.msdk.adapter.sr.xv.c("", sb3.toString());
        return c5;
    }

    private static String c(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
