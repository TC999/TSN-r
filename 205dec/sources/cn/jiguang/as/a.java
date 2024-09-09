package cn.jiguang.as;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends cn.jiguang.ah.b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f2380d;

    /* renamed from: a  reason: collision with root package name */
    private Context f2381a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicBoolean f2382b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f2383c = new AtomicBoolean(true);

    private List<Pair<JSONArray, JSONArray>> a(JSONArray jSONArray) {
        StringBuilder sb;
        String message;
        try {
            JSONArray jSONArray2 = new JSONArray();
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i5);
                if (optJSONObject != null && optJSONObject.length() != 0) {
                    int length = optJSONObject.toString().getBytes("UTF-8").length;
                    i4 += length;
                    if (i4 > 102400) {
                        if (jSONArray2.length() > 0) {
                            arrayList.add(new Pair(jSONArray2, new JSONArray()));
                        }
                        jSONArray2 = new JSONArray();
                        jSONArray2.put(optJSONObject);
                        i4 = length;
                    } else {
                        jSONArray2.put(optJSONObject);
                    }
                }
            }
            if (jSONArray2.length() > 0) {
                arrayList.add(new Pair(jSONArray2, new JSONArray()));
            }
            return arrayList;
        } catch (UnsupportedEncodingException e4) {
            sb = new StringBuilder();
            sb.append("partition exception:");
            message = e4.getMessage();
            sb.append(message);
            cn.jiguang.w.a.f("JAppActive", sb.toString());
            return null;
        } catch (Throwable th) {
            sb = new StringBuilder();
            sb.append("partition throwable:");
            message = th.getMessage();
            sb.append(message);
            cn.jiguang.w.a.f("JAppActive", sb.toString());
            return null;
        }
    }

    private JSONArray a(List<cn.jiguang.common.m.c> list) {
        JSONArray jSONArray = new JSONArray();
        for (cn.jiguang.common.m.c cVar : list) {
            JSONObject b4 = cVar.b(128);
            if (b4 != null) {
                jSONArray.put(b4);
            }
        }
        return jSONArray;
    }

    public static a d() {
        if (f2380d == null) {
            synchronized (a.class) {
                if (f2380d == null) {
                    f2380d = new a();
                }
            }
        }
        return f2380d;
    }

    @Override // cn.jiguang.ah.b
    protected String a(Context context) {
        this.f2381a = context;
        return "JAppActive";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean a(Context context, String str) {
        if (this.f2383c.get()) {
            cn.jiguang.w.a.b("JAppActive", "first start, business is enable");
            return true;
        }
        return cn.jiguang.ah.c.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void b(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1104)) {
            cn.jiguang.y.a.a(context, "app_active", -3);
            return;
        }
        cn.jiguang.common.n.c.a().a(context);
        this.f2383c.set(false);
        super.b(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public void c(Context context, String str) {
        if (cn.jiguang.ar.a.a().g(1104)) {
            return;
        }
        try {
            JSONArray a4 = a(new ArrayList(cn.jiguang.common.n.c.a().b(context).values()));
            if (a4.length() == 0) {
                cn.jiguang.w.a.b("JAppActive", "there's no app active data to report");
            }
            if (a4.length() == 0) {
                cn.jiguang.w.a.b("JAppActive", "no active data to report");
                return;
            }
            List<Pair<JSONArray, JSONArray>> a5 = a(a4);
            if (a5 != null && !a5.isEmpty()) {
                int i4 = 0;
                int size = a5.size();
                while (i4 < size) {
                    JSONObject jSONObject = new JSONObject();
                    i4++;
                    jSONObject.put("slice_index", i4);
                    jSONObject.put("slice_count", size);
                    jSONObject.put("data", a5.get(i4).first);
                    cn.jiguang.ah.d.a(context, jSONObject, "app_active");
                    cn.jiguang.ah.d.a(context, (Object) jSONObject);
                    this.f2382b.set(true);
                    super.c(context, str);
                }
                if (a4.length() > 0) {
                    cn.jiguang.common.n.c.a().c(context);
                    return;
                }
                return;
            }
            cn.jiguang.w.a.f("JAppActive", "it can't report, because partition active data failed");
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JAppActive", "package json exception:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.ah.b
    protected boolean c() {
        cn.jiguang.w.a.b("JAppActive", "for googlePlay:false");
        return cn.jiguang.ar.a.a().e(1104);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.ah.b
    public boolean d(Context context, String str) {
        return !this.f2382b.get();
    }
}
