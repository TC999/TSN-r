package com.bytedance.sdk.component.panglearmor.c;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.utils.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f30002c;

    /* renamed from: f  reason: collision with root package name */
    private long f30003f;
    private LinkedList<JSONObject> sr;
    private LinkedList<JSONObject> ux;

    /* renamed from: w  reason: collision with root package name */
    private SharedPreferences f30004w;
    private LinkedList<JSONObject> xv;

    public w() {
        this.f30004w = null;
        this.xv = null;
        this.sr = null;
        this.ux = null;
        this.f30003f = 0L;
        this.f30004w = SoftDecTool.getSharedPreferences("pithar");
        this.xv = xv("sp_angle");
        this.sr = xv("sp_screen");
        this.ux = xv("sp_net");
        this.f30003f = ux.c().xv() / ux.c().sr();
    }

    public static w c() {
        if (f30002c == null) {
            synchronized (w.class) {
                if (f30002c == null) {
                    f30002c = new w();
                }
            }
        }
        return f30002c;
    }

    private LinkedList<JSONObject> xv(String str) {
        String[] split;
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.f30004w;
        if (sharedPreferences == null) {
            return linkedList;
        }
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        linkedList.add(new JSONObject(str2));
                    } catch (Exception unused) {
                        a.w("ccrlog", "add list item failed");
                    }
                }
            }
        }
        return linkedList;
    }

    public synchronized void w(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> c4 = c("sp_screen");
            int i4 = 1;
            if (c4 != null && c4.size() > 0) {
                JSONObject last = c4.getLast();
                if (last.optLong("t", 0L) / 3600000 == currentTimeMillis / 3600000) {
                    i4 = 1 + last.optInt("val", 0);
                    c4.removeLast();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("t", currentTimeMillis);
                jSONObject.put("val", i4);
                c(jSONObject, "sp_screen");
            } catch (JSONException e4) {
                throw new RuntimeException(e4);
            }
        }
    }

    public LinkedList<JSONObject> c(String str) {
        if ("sp_angle".equals(str)) {
            return this.xv;
        }
        if ("sp_screen".equals(str)) {
            return this.sr;
        }
        if ("sp_net".equals(str)) {
            return this.ux;
        }
        return null;
    }

    public void c(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> c4 = c(str);
        if (c4 == null) {
            return;
        }
        c4.add(jSONObject);
        if (c4.size() > this.f30003f) {
            c4.removeFirst();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long xv = currentTimeMillis - ux.c().xv();
        JSONObject jSONObject2 = null;
        Iterator<JSONObject> it = c4.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            long optLong = next.optLong("t", 0L);
            if (optLong < xv) {
                it.remove();
                jSONObject2 = next;
            } else if (optLong > currentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && c4.size() < 2) {
            c4.addFirst(jSONObject2);
        }
        c(str, c4);
    }

    public synchronized void c(int i4) {
        long currentTimeMillis = System.currentTimeMillis();
        int i5 = i4 == 4 ? 1 : i4 > 0 ? 2 : 0;
        LinkedList<JSONObject> c4 = c("sp_net");
        if (c4 != null && c4.size() > 0) {
            JSONObject last = c4.getLast();
            if (last.optLong("t", 0L) / 3600000 == currentTimeMillis / 3600000) {
                i5 |= last.optInt("val", 0);
                c4.removeLast();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", currentTimeMillis);
            jSONObject.put("val", i5);
            c(jSONObject, "sp_net");
        } catch (JSONException e4) {
            throw new RuntimeException(e4);
        }
    }

    public void c(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.f30004w == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor edit = this.f30004w.edit();
        edit.putString(str, sb.toString());
        edit.apply();
    }

    public LinkedList<JSONObject> c(long j4) {
        if (j4 == 0) {
            return this.xv;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        Iterator<JSONObject> it = this.xv.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (currentTimeMillis - next.optLong("t", 0L) < j4) {
                linkedList.add(next);
            } else {
                jSONObject = next;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.addFirst(jSONObject);
        }
        return linkedList;
    }
}
