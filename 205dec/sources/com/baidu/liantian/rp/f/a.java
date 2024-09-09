package com.baidu.liantian.rp.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.liantian.b;
import com.baidu.liantian.b.f;
import com.baidu.liantian.b.h;
import com.baidu.liantian.b.l;
import com.baidu.liantian.b.o;
import com.baidu.liantian.e;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Service.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    e f12265a;

    /* renamed from: b  reason: collision with root package name */
    public Context f12266b;

    /* renamed from: c  reason: collision with root package name */
    com.baidu.liantian.rp.d.a.a f12267c;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.liantian.rp.e.a f12268d;

    /* renamed from: e  reason: collision with root package name */
    private HandlerC0111a f12269e = new HandlerC0111a(l.a());

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Service.java */
    /* renamed from: com.baidu.liantian.rp.f.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class HandlerC0111a extends Handler {
        public HandlerC0111a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        a.b(a.this);
                        return;
                    case 1:
                        com.baidu.liantian.rp.b.a.a(a.this.f12266b).a((com.baidu.liantian.rp.c.a) message.obj);
                        b.a();
                        Message message2 = new Message();
                        message2.what = 10;
                        sendMessage(message2);
                        return;
                    case 2:
                        b.a();
                        a.a(a.this);
                        a.b(a.this);
                        int o4 = com.baidu.liantian.b.e.o(a.this.f12266b);
                        b.a();
                        a.a(a.this, 0, o4);
                        return;
                    case 3:
                        com.baidu.liantian.rp.a.a aVar = (com.baidu.liantian.rp.a.a) message.obj;
                        if (aVar == null) {
                            return;
                        }
                        a aVar2 = a.this;
                        String b4 = aVar2.f12265a.b(aVar.f12244e);
                        com.baidu.liantian.rp.c.a aVar3 = new com.baidu.liantian.rp.c.a();
                        aVar3.f12252b = aVar.f12244e;
                        aVar3.f12257g = 0;
                        aVar3.f12253c = 1;
                        aVar3.f12255e = System.currentTimeMillis();
                        aVar3.f12256f = 1;
                        aVar3.f12254d = com.baidu.liantian.b.e.a(aVar2.f12266b, aVar, b4, false).toString();
                        com.baidu.liantian.rp.b.a.a(aVar2.f12266b).a(aVar3);
                        e eVar = aVar2.f12265a;
                        String str = aVar.f12244e;
                        eVar.f12233f.putBoolean("re_net_ins_" + str, true);
                        eVar.f12233f.commit();
                        String a4 = o.a(com.baidu.liantian.b.e.n(aVar2.f12266b).toString());
                        if (com.baidu.liantian.rp.b.a.a(aVar2.f12266b).b(a4)) {
                            aVar3.f12252b = "1001001";
                            Context context = aVar2.f12266b;
                            aVar3.f12254d = com.baidu.liantian.b.e.a(context, aVar.f12240a, aVar.f12242c, "1001001", com.baidu.liantian.b.e.n(context).toString()).toString();
                            com.baidu.liantian.rp.b.a.a(aVar2.f12266b).a(aVar3);
                            com.baidu.liantian.rp.b.a.a(aVar2.f12266b).a(a4);
                            return;
                        }
                        return;
                    case 4:
                        String valueOf = String.valueOf(message.obj);
                        if (TextUtils.isEmpty(valueOf)) {
                            return;
                        }
                        com.baidu.liantian.rp.b.a.a(a.this.f12266b).a(o.a(valueOf));
                        return;
                    case 5:
                        a.a(a.this);
                        a aVar4 = a.this;
                        e eVar2 = new e(aVar4.f12266b);
                        int x3 = eVar2.x();
                        Integer.toString(x3);
                        b.a();
                        long currentTimeMillis = System.currentTimeMillis() - eVar2.f12232e.getLong("re_last_ofline_time", 0L);
                        long j4 = x3 * 3600000;
                        if (currentTimeMillis >= j4) {
                            f.a(aVar4.f12266b).c();
                            com.baidu.liantian.b.e.a(aVar4.f12266b, j4);
                            eVar2.d(System.currentTimeMillis());
                        } else {
                            com.baidu.liantian.b.e.a(aVar4.f12266b, j4 - currentTimeMillis);
                        }
                        Message message3 = new Message();
                        message3.what = 10;
                        sendMessage(message3);
                        return;
                    case 6:
                        a aVar5 = a.this;
                        a.a(aVar5, 1, com.baidu.liantian.b.e.o(aVar5.f12266b));
                        return;
                    case 7:
                        a.b(a.this);
                        a aVar6 = a.this;
                        a.a(aVar6, 1, com.baidu.liantian.b.e.o(aVar6.f12266b));
                        return;
                    case 8:
                        b.a();
                        a aVar7 = a.this;
                        a.a(aVar7, 3, com.baidu.liantian.b.e.o(aVar7.f12266b));
                        return;
                    case 9:
                        a.a(a.this, 0, 2);
                        return;
                    case 10:
                        int o5 = com.baidu.liantian.b.e.o(a.this.f12266b);
                        if (2 != o5) {
                            if (1 == o5) {
                                b.a();
                                a.a(a.this, 4, o5);
                                return;
                            }
                            return;
                        }
                        b.a();
                        if (com.baidu.liantian.rp.b.a.a(a.this.f12266b).b() >= new e(a.this.f12266b).f12232e.getInt("up_nu_co", 50)) {
                            b.a();
                            a.a(a.this, 0, o5);
                            return;
                        }
                        List<com.baidu.liantian.rp.c.a> a5 = com.baidu.liantian.rp.b.a.a(a.this.f12266b).a(true, o5);
                        a5.size();
                        b.a();
                        if (a5.size() > 0) {
                            b.a();
                            a.a(a.this, 0, o5);
                            return;
                        }
                        return;
                    case 11:
                        String valueOf2 = String.valueOf(message.obj);
                        if (a.this.f12267c.a(new JSONArray().put(com.baidu.liantian.b.e.a(a.this.f12266b, new JSONObject(valueOf2))).toString(), a.a(new JSONObject(valueOf2)))) {
                            return;
                        }
                        com.baidu.liantian.b.e.c(a.this.f12266b, valueOf2);
                        return;
                    default:
                        return;
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
        }
    }

    public a(Context context) {
        this.f12266b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f12265a = new e(this.f12266b);
        this.f12267c = new com.baidu.liantian.rp.d.a.a(this.f12266b);
    }

    static /* synthetic */ void b(a aVar) {
        List<com.baidu.liantian.rp.a.a> w3 = aVar.f12265a.w();
        if (w3 != null) {
            for (com.baidu.liantian.rp.a.a aVar2 : w3) {
                if (aVar.a(aVar.f12265a.f12232e.getString("li_pk_s", ""), aVar2.f12241b)) {
                    e eVar = aVar.f12265a;
                    String str = aVar2.f12243d;
                    SharedPreferences sharedPreferences = eVar.f12232e;
                    String string = sharedPreferences.getString("re_net_ali2_" + str, "");
                    String c4 = com.baidu.liantian.b.e.c();
                    if (!string.equals(c4)) {
                        String b4 = aVar.f12265a.b(aVar2.f12243d);
                        com.baidu.liantian.rp.c.a aVar3 = new com.baidu.liantian.rp.c.a();
                        aVar3.f12252b = aVar2.f12243d;
                        aVar3.f12257g = 0;
                        aVar3.f12253c = 2;
                        aVar3.f12255e = System.currentTimeMillis();
                        aVar3.f12256f = 1;
                        aVar3.f12259i = 5;
                        aVar3.f12254d = com.baidu.liantian.b.e.a(aVar.f12266b, aVar2, b4, true).toString();
                        com.baidu.liantian.rp.b.a.a(aVar.f12266b).a(aVar3);
                        String a4 = o.a(com.baidu.liantian.b.e.n(aVar.f12266b).toString());
                        if (com.baidu.liantian.rp.b.a.a(aVar.f12266b).b(a4)) {
                            aVar3.f12252b = "1001001";
                            aVar3.f12259i = 0;
                            Context context = aVar.f12266b;
                            aVar3.f12254d = com.baidu.liantian.b.e.a(context, aVar2.f12240a, aVar2.f12242c, "1001001", com.baidu.liantian.b.e.n(context).toString()).toString();
                            com.baidu.liantian.rp.b.a.a(aVar.f12266b).a(aVar3);
                            com.baidu.liantian.rp.b.a.a(aVar.f12266b).a(a4);
                        }
                        e eVar2 = aVar.f12265a;
                        String str2 = aVar2.f12243d;
                        SharedPreferences.Editor editor = eVar2.f12233f;
                        editor.putString("re_net_ali2_" + str2, c4);
                        eVar2.f12233f.commit();
                    }
                }
            }
        }
    }

    public final void a(Message message) {
        this.f12269e.sendMessage(message);
    }

    static String a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("Common_section");
            if (jSONObject2 != null && jSONObject2.has("12")) {
                return jSONObject2.optString("12", "");
            }
            return null;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return null;
        }
    }

    private void a(List<com.baidu.liantian.rp.c.a> list, int i4, long j4) {
        JSONObject jSONObject;
        int length;
        int i5 = this.f12265a.f12232e.getInt("re_net_one_lt", 5);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.baidu.liantian.rp.c.a> it = list.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.baidu.liantian.rp.c.a next = it.next();
            try {
                String jSONObject2 = com.baidu.liantian.b.e.a(this.f12266b, new JSONObject(next.f12254d)).toString();
                try {
                    jSONObject = new JSONObject(jSONObject2);
                    length = jSONObject2.length() + i6;
                } catch (Exception unused) {
                    com.baidu.liantian.b.e.a();
                }
            } catch (Exception unused2) {
                com.baidu.liantian.b.e.a();
            }
            if (length >= 1048576 * i5) {
                b.a();
                break;
            }
            arrayList.add(Integer.valueOf(next.f12251a));
            arrayList2.add(new com.baidu.liantian.rp.c.b(jSONObject, next.f12260j, next.f12251a));
            i6 = length;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList3 = new ArrayList();
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            com.baidu.liantian.rp.c.b bVar = (com.baidu.liantian.rp.c.b) arrayList2.get(i7);
            if (bVar != null) {
                String str = bVar.f12262b;
                if (TextUtils.isEmpty(str)) {
                    jSONArray.put(bVar.f12261a);
                    arrayList3.add(Integer.valueOf(bVar.f12263c));
                } else {
                    if (hashMap.containsKey(str)) {
                        JSONArray jSONArray2 = (JSONArray) hashMap.get(str);
                        if (jSONArray2 == null) {
                            jSONArray2 = new JSONArray();
                        }
                        jSONArray2.put(bVar.f12261a);
                        hashMap.put(str, jSONArray2);
                    } else {
                        JSONArray jSONArray3 = new JSONArray();
                        jSONArray3.put(bVar.f12261a);
                        hashMap.put(str, jSONArray3);
                    }
                    ArrayList arrayList4 = (ArrayList) hashMap2.get(str);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(Integer.valueOf(bVar.f12263c));
                    hashMap2.put(str, arrayList4);
                }
            }
        }
        b.a();
        if (jSONArray.length() > 0) {
            if (this.f12267c.a(jSONArray.toString(), null)) {
                b.a();
                com.baidu.liantian.rp.b.a.a(this.f12266b).a(arrayList3);
            }
        } else {
            b.a();
        }
        if (hashMap.size() > 0) {
            for (String str2 : hashMap.keySet()) {
                JSONArray jSONArray4 = (JSONArray) hashMap.get(str2);
                if (jSONArray4 != null && jSONArray4.length() > 0 && this.f12267c.a(jSONArray4.toString(), str2)) {
                    b.a();
                    com.baidu.liantian.rp.b.a.a(this.f12266b).a((List) hashMap2.get(str2));
                }
            }
        } else {
            b.a();
        }
        com.baidu.liantian.rp.b.a.a(this.f12266b).c();
        if (2 != i4) {
            this.f12265a.e(i6 + j4);
        }
    }

    private boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str2.equals(this.f12266b.getPackageName())) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                if (str2.equals(jSONArray.get(i4))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    static /* synthetic */ void a(a aVar) {
        if (System.currentTimeMillis() - aVar.f12265a.f12232e.getLong("re_net_pu_de", 0L) >= 86400000) {
            com.baidu.liantian.rp.d.a.a aVar2 = aVar.f12267c;
            try {
                String a4 = h.a(aVar2.f12264a, com.baidu.liantian.b.e.b() + "p/1/rs", "", false, true);
                b.a();
                JSONObject jSONObject = new JSONObject(a4).getJSONObject("c");
                e eVar = new e(aVar2.f12264a);
                int optInt = jSONObject.optInt("n");
                if (optInt > 0) {
                    eVar.f12233f.putInt("re_net_ty", optInt);
                    eVar.f12233f.commit();
                }
                int optInt2 = jSONObject.optInt("i");
                if (optInt2 > 0) {
                    eVar.f12233f.putInt("re_net_hr", optInt2);
                    eVar.f12233f.commit();
                }
                int optInt3 = jSONObject.optInt("i2");
                if (optInt3 > 0) {
                    eVar.f12233f.putInt("re_net_hr_bc", optInt3);
                    eVar.f12233f.commit();
                }
                int optInt4 = jSONObject.optInt("w");
                if (optInt4 > 0) {
                    eVar.f12233f.putInt("re_net_wt", optInt4);
                    eVar.f12233f.commit();
                }
                if (jSONObject.optInt("s1") > 0) {
                    eVar.f12233f.putInt("re_net_one_lt", jSONObject.optInt("s1"));
                    eVar.f12233f.commit();
                }
                int optInt5 = jSONObject.optInt("s2");
                if (optInt5 > 0) {
                    eVar.f12233f.putInt("re_net_dy_lt", optInt5);
                    eVar.f12233f.commit();
                }
                int optInt6 = jSONObject.optInt("t");
                if (optInt6 > 0) {
                    eVar.f12233f.putInt("re_net_over", optInt6);
                    eVar.f12233f.commit();
                }
                int optInt7 = jSONObject.optInt("l1");
                if (optInt7 > 0) {
                    eVar.f12233f.putInt("up_nu_co", optInt7);
                    eVar.f12233f.commit();
                }
                int optInt8 = jSONObject.optInt("l2");
                if (optInt8 > 0) {
                    eVar.f12233f.putInt("up_nu_li", optInt8);
                    eVar.f12233f.commit();
                }
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
            }
            e eVar2 = aVar.f12265a;
            eVar2.f12233f.putLong("re_net_pu_de", System.currentTimeMillis());
            eVar2.f12233f.commit();
        }
    }

    static /* synthetic */ void a(a aVar, int i4, int i5) {
        List<com.baidu.liantian.rp.c.a> a4;
        if (i5 == 0) {
            b.a();
            return;
        }
        if (i4 == 1) {
            a4 = com.baidu.liantian.rp.b.a.a(aVar.f12266b).a();
            if (1 == i5) {
                a4.size();
                b.a();
            }
        } else if (i4 == 3) {
            a4 = com.baidu.liantian.rp.b.a.a(aVar.f12266b).a(false, i5);
        } else if (i4 == 4) {
            a4 = com.baidu.liantian.rp.b.a.a(aVar.f12266b).a(true, i5);
            a4.size();
            b.a();
        } else {
            a4 = com.baidu.liantian.rp.b.a.a(aVar.f12266b).a(i5);
        }
        if (a4.size() <= 0) {
            b.a();
            return;
        }
        long j4 = aVar.f12265a.f12232e.getLong("re_day_len", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j5 = aVar.f12265a.f12232e.getLong("re_day_b_t", 0L);
        int i6 = aVar.f12265a.f12232e.getInt("re_net_dy_lt", 50);
        if (j5 == 0) {
            aVar.f12265a.f(currentTimeMillis);
            j5 = currentTimeMillis;
        }
        b.a();
        b.a();
        if (currentTimeMillis - j5 < 86400000) {
            b.a();
            if (i4 == 3) {
                int i7 = aVar.f12265a.f12232e.getInt("g_r_d_d_n", 0);
                b.a();
                if (i7 >= 5) {
                    b.a();
                    return;
                }
                aVar.f12265a.h(i7 + 1);
            }
            if (j4 > i6 * 1048576) {
                b.a();
                return;
            }
        } else {
            aVar.f12265a.e(0L);
            aVar.f12265a.f(currentTimeMillis);
            if (i4 == 3) {
                aVar.f12265a.h(0);
            }
        }
        do {
            aVar.a(a4, i5, j4);
            List<com.baidu.liantian.rp.c.a> list = null;
            if (i4 == 0 && i5 == 2) {
                list = com.baidu.liantian.rp.b.a.a(aVar.f12266b).a(i5);
            }
            a4 = list;
            if (a4 == null) {
                return;
            }
        } while (a4.size() != 0);
    }
}
