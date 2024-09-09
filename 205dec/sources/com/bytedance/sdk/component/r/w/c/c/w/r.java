package com.bytedance.sdk.component.r.w.c.c.w;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r extends w {
    private com.bytedance.sdk.component.r.w.sr.w.c sr;

    /* renamed from: w  reason: collision with root package name */
    protected com.bytedance.sdk.component.r.c.ux f30061w;
    protected List<String> xv;

    public r(Context context, com.bytedance.sdk.component.r.w.sr.w.c cVar, com.bytedance.sdk.component.r.c.ux uxVar) {
        super(context, uxVar, cVar == null ? com.bytedance.sdk.component.r.w.sr.w.c.xv() : cVar);
        this.xv = new ArrayList();
        this.sr = cVar;
        this.f30061w = uxVar;
        if (cVar == null) {
            this.sr = com.bytedance.sdk.component.r.w.sr.w.c.xv();
        }
    }

    private void sr(List<com.bytedance.sdk.component.r.c.w> list) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.r.c.w wVar : list) {
            linkedList.add(wVar.xv());
        }
        com.bytedance.sdk.component.r.w.c.c.w.c(getContext(), "UPDATE " + c() + " SET " + AdLogEventRepo.COL_RETRY_COUNT + " = " + AdLogEventRepo.COL_RETRY_COUNT + "+1 WHERE " + c("id", (List<?>) linkedList, 1000, true), this.f30061w);
    }

    public static String ux(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public boolean c(com.bytedance.sdk.component.r.c.w wVar) {
        return com.bytedance.sdk.component.r.w.xv.c.sr(wVar);
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.xv
    public String delete(List<com.bytedance.sdk.component.r.c.w> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.r.c.w wVar : list) {
            linkedList.add(wVar.xv());
            com.bytedance.sdk.component.r.w.xv.c.gd(wVar, this.f30061w);
        }
        com.bytedance.sdk.component.r.w.xv.xv.c("PADLT", c() + " stats repo delete: " + linkedList.size(), this.f30061w);
        String c4 = com.bytedance.sdk.component.r.w.c.c.w.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) linkedList, 1000, true), this.f30061w);
        c(linkedList);
        return c4;
    }

    public byte w() {
        return (byte) 1;
    }

    public byte xv() {
        return (byte) 2;
    }

    protected void xv(List<String> list) {
        com.bytedance.sdk.component.r.w.xv.xv.c("PADLT", c() + " stats repo delete: " + list.size(), this.f30061w);
        com.bytedance.sdk.component.r.w.c.c.w.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) list, 1000, true), this.f30061w);
        com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.fz(), list.size(), this.f30061w);
        c(list);
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.w
    public String c() {
        return this.f30061w.w().sr();
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.xv
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, String str, int i5) {
        long c4 = com.bytedance.sdk.component.r.w.w.c.c(i4, getContext(), this.f30061w);
        if (c4 <= 0) {
            c4 = 1;
        } else if (c4 > 100) {
            c4 = 100;
        }
        String str2 = str + " DESC limit " + c4;
        ArrayList arrayList = new ArrayList();
        this.xv.clear();
        Cursor query = com.bytedance.sdk.component.r.w.c.c.w.query(getContext(), c(), new String[]{"id", "value", AdLogEventRepo.COL_ENCRYPT_TYPE}, null, null, null, null, str2, this.f30061w);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    try {
                        String string = query.getString(query.getColumnIndex("id"));
                        String string2 = query.getString(query.getColumnIndex("value"));
                        if (query.getInt(query.getColumnIndex(AdLogEventRepo.COL_ENCRYPT_TYPE)) == 1) {
                            string2 = this.f30061w.sr().c(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.xv.add(string);
                        } else if (arrayList.size() > 100) {
                            break;
                        } else {
                            com.bytedance.sdk.component.r.w.sr.c.c cVar = new com.bytedance.sdk.component.r.w.sr.c.c(string, new JSONObject(string2));
                            cVar.w(xv());
                            cVar.c(w());
                            arrayList.add(cVar);
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable th) {
                    try {
                        query.close();
                        if (!this.xv.isEmpty()) {
                            xv(this.xv);
                            this.xv.clear();
                        }
                        if (i5 == 2 || i5 == 1) {
                            c(arrayList, 5, 604800000L);
                        }
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            }
            try {
                query.close();
                if (!this.xv.isEmpty()) {
                    xv(this.xv);
                    this.xv.clear();
                }
                if (i5 == 2 || i5 == 1) {
                    c(arrayList, 5, 604800000L);
                }
            } catch (Exception unused3) {
            }
        }
        return arrayList;
    }

    public static String sr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0 , " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.xv
    public List<com.bytedance.sdk.component.r.c.w> c(String str, int i4) {
        com.bytedance.sdk.component.r.w.sr.w.c cVar = this.sr;
        if (cVar == null) {
            return new ArrayList();
        }
        return c(cVar.w(), str, i4);
    }

    private void c(int i4, long j4) {
        long currentTimeMillis = System.currentTimeMillis() - j4;
        Context context = getContext();
        String c4 = c();
        com.bytedance.sdk.component.r.w.c.c.w.delete(context, c4, "gen_time <? OR retry >?", new String[]{currentTimeMillis + "", i4 + ""}, this.f30061w);
    }

    public void c(List<com.bytedance.sdk.component.r.c.w> list, int i4, long j4) {
        if (list != null && list.size() != 0) {
            try {
                sr(list);
                c(i4, j4);
            } catch (Exception unused) {
            }
        }
    }

    private static String c(String str, List<?> list, int i4, boolean z3) {
        int i5;
        String str2 = z3 ? " IN " : " NOT IN ";
        String str3 = z3 ? " OR " : " AND ";
        int min = Math.min(i4, 1000);
        int size = list.size();
        if (size % min == 0) {
            i5 = size / min;
        } else {
            i5 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i6 * min;
            String c4 = c(TextUtils.join("','", list.subList(i7, Math.min(i7 + min, size))), "");
            if (i6 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(c4);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return c(sb2, str + str2 + "('')");
    }

    private static String c(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
