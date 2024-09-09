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
public class f extends w {
    private final Context sr;
    private com.bytedance.sdk.component.r.w.sr.w.c ux;

    /* renamed from: w  reason: collision with root package name */
    protected com.bytedance.sdk.component.r.c.ux f30060w;
    protected List<String> xv;

    public f(Context context, com.bytedance.sdk.component.r.w.sr.w.c cVar, com.bytedance.sdk.component.r.c.ux uxVar) {
        super(context, uxVar, cVar == null ? com.bytedance.sdk.component.r.w.sr.w.c.xv() : cVar);
        this.xv = new ArrayList();
        this.sr = context;
        this.ux = cVar;
        this.f30060w = uxVar;
        if (cVar == null) {
            this.ux = com.bytedance.sdk.component.r.w.sr.w.c.xv();
        }
    }

    private void sr(List<com.bytedance.sdk.component.r.c.w> list) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.r.c.w wVar : list) {
            linkedList.add(wVar.xv());
        }
        com.bytedance.sdk.component.r.w.c.c.w.c(getContext(), "UPDATE " + c() + " SET " + AdLogEventRepo.COL_RETRY_COUNT + " = " + AdLogEventRepo.COL_RETRY_COUNT + "+1 WHERE " + c("id", (List<?>) linkedList, 1000, true), this.f30060w);
    }

    public static String ux(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0";
    }

    @Override // com.bytedance.sdk.component.r.w.c.c
    public boolean c(com.bytedance.sdk.component.r.c.w wVar) {
        return com.bytedance.sdk.component.r.w.xv.c.xv(wVar);
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.xv
    public String delete(List<com.bytedance.sdk.component.r.c.w> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.sdk.component.r.c.w wVar : list) {
            linkedList.add(wVar.xv());
            com.bytedance.sdk.component.r.w.xv.c.gd(wVar, this.f30060w);
        }
        com.bytedance.sdk.component.r.w.xv.xv.c("PADLT", c() + " adevent repo delete: " + linkedList.size(), this.f30060w);
        String c4 = com.bytedance.sdk.component.r.w.c.c.w.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) linkedList, 1000, true), this.f30060w);
        c(linkedList);
        return c4;
    }

    public byte w() {
        return (byte) 2;
    }

    public byte xv() {
        return (byte) 0;
    }

    protected String xv(List<String> list) {
        com.bytedance.sdk.component.r.w.xv.xv.c("PADLT", c() + " adevent repo delete: " + list.size(), this.f30060w);
        String c4 = com.bytedance.sdk.component.r.w.c.c.w.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) list, 1000, true), this.f30060w);
        com.bytedance.sdk.component.r.w.xv.w.c(com.bytedance.sdk.component.r.w.w.w.f30136c.fz(), list.size(), this.f30060w);
        c(list);
        return c4;
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.w
    public String c() {
        com.bytedance.sdk.component.r.c.f w3 = this.f30060w.w();
        if (w3 != null) {
            return w3.w();
        }
        return null;
    }

    /* JADX WARN: Finally extract failed */
    @Override // com.bytedance.sdk.component.r.w.c.c.w.xv
    public List<com.bytedance.sdk.component.r.c.w> c(int i4, String str, int i5) {
        com.bytedance.sdk.component.r.c.sr srVar;
        String str2;
        String str3;
        String string;
        String str4;
        String string2;
        int i6;
        long c4 = com.bytedance.sdk.component.r.w.w.c.c(i4, getContext(), this.f30060w);
        com.bytedance.sdk.component.r.w.xv.xv.xv("" + c() + " query db max :" + c4 + " limit:" + i4, this.f30060w);
        if (c4 <= 0) {
            c4 = 1;
        } else if (c4 > 100) {
            c4 = 100;
        }
        String str5 = str + " DESC limit " + c4;
        List<com.bytedance.sdk.component.r.c.w> arrayList = new ArrayList<>();
        this.xv.clear();
        Context context = getContext();
        String c5 = c();
        String[] strArr = {"id", "value", AdLogEventRepo.COL_ENCRYPT_TYPE, AdLogEventRepo.COL_RETRY_COUNT};
        com.bytedance.sdk.component.r.c.ux uxVar = this.f30060w;
        String str6 = AdLogEventRepo.COL_RETRY_COUNT;
        String str7 = AdLogEventRepo.COL_ENCRYPT_TYPE;
        String str8 = "value";
        Cursor query = com.bytedance.sdk.component.r.w.c.c.w.query(context, c5, strArr, null, null, null, null, str5, uxVar);
        if (query != null) {
            try {
                com.bytedance.sdk.component.r.c.sr sr = this.f30060w.sr();
                while (query.moveToNext()) {
                    try {
                        string = query.getString(query.getColumnIndex("id"));
                        str4 = str8;
                    } catch (Throwable th) {
                        th = th;
                        srVar = sr;
                    }
                    try {
                        string2 = query.getString(query.getColumnIndex(str4));
                        str3 = str7;
                        try {
                            int i7 = query.getInt(query.getColumnIndex(str3));
                            str2 = str6;
                            try {
                                i6 = query.getInt(query.getColumnIndex(str2));
                                if (i7 == 1) {
                                    string2 = sr.c(string2);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                srVar = sr;
                                str8 = str4;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            srVar = sr;
                            str8 = str4;
                            str2 = str6;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        srVar = sr;
                        str8 = str4;
                        str2 = str6;
                        str3 = str7;
                        com.bytedance.sdk.component.r.w.xv.xv.sr(th.getMessage(), this.f30060w);
                        str6 = str2;
                        str7 = str3;
                        sr = srVar;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        com.bytedance.sdk.component.r.w.xv.xv.c("log_show_query : value is null", this.f30060w);
                        this.xv.add(string);
                        str6 = str2;
                        str8 = str4;
                        str7 = str3;
                    } else if (arrayList.size() > 100) {
                        break;
                    } else {
                        JSONObject jSONObject = new JSONObject(string2);
                        String optString = jSONObject.optString("ad_extra_data");
                        if (TextUtils.isEmpty(optString)) {
                            srVar = sr;
                            str8 = str4;
                        } else {
                            JSONObject jSONObject2 = new JSONObject(optString);
                            jSONObject2.put("retry_count", i6);
                            srVar = sr;
                            str8 = str4;
                            try {
                                jSONObject2.put("db_rd", System.currentTimeMillis());
                                jSONObject.put("ad_extra_data", jSONObject2.toString());
                            } catch (Throwable th5) {
                                th = th5;
                                com.bytedance.sdk.component.r.w.xv.xv.sr(th.getMessage(), this.f30060w);
                                str6 = str2;
                                str7 = str3;
                                sr = srVar;
                            }
                        }
                        com.bytedance.sdk.component.r.w.sr.c.c cVar = new com.bytedance.sdk.component.r.w.sr.c.c(string, jSONObject);
                        cVar.c(xv());
                        cVar.w(w());
                        com.bytedance.sdk.component.r.w.xv.c.c(jSONObject, cVar, this.f30060w, i6);
                        arrayList.add(cVar);
                        str6 = str2;
                        str7 = str3;
                        sr = srVar;
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
                } catch (Exception unused) {
                }
            } catch (Throwable th6) {
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
                throw th6;
            }
        }
        com.bytedance.sdk.component.r.w.xv.xv.xv("" + c() + " query db actually size :" + arrayList.size(), this.f30060w);
        return arrayList;
    }

    public static String sr(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ," + AdLogEventRepo.COL_GEN_TIME + " TEXT , " + AdLogEventRepo.COL_RETRY_COUNT + " INTEGER default 0 , " + AdLogEventRepo.COL_ENCRYPT_TYPE + " INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.component.r.w.c.c.w.xv
    public List<com.bytedance.sdk.component.r.c.w> c(String str, int i4) {
        com.bytedance.sdk.component.r.w.sr.w.c cVar = this.ux;
        if (cVar == null) {
            return new ArrayList();
        }
        return c(cVar.w(), str, i4);
    }

    private void c(int i4, long j4) {
        long currentTimeMillis = System.currentTimeMillis() - j4;
        Context context = getContext();
        String c4 = c();
        com.bytedance.sdk.component.r.w.c.c.w.delete(context, c4, "gen_time <? OR retry >?", new String[]{currentTimeMillis + "", i4 + ""}, this.f30060w);
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
