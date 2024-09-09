package com.bytedance.c.w.xv;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.c.w.b;
import com.bytedance.c.w.ux.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected JSONObject f26647a;

    public a() {
        this.f26647a = new JSONObject();
    }

    public static a c(long j4, Context context, @Nullable Thread thread, @NonNull Throwable th) {
        if (j4 == 0) {
            j4 = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.k("isJava", 1);
        aVar.k("event_type", "java_crash");
        aVar.k(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
        aVar.k("data", b.n.a(th));
        aVar.k("isOOM", Boolean.valueOf(b.n.h(th)));
        aVar.k("crash_time", Long.valueOf(j4));
        aVar.k("process_name", b.e.i(context));
        if (!b.e.l(context)) {
            aVar.k("remote_process", 1);
        }
        b.e.c(context, aVar.j());
        String name = thread == null ? null : thread.getName();
        if (name != null) {
            aVar.k("crash_thread_name", name);
        }
        aVar.k("all_thread_stacks", b.n.d(name));
        return aVar;
    }

    public a a(int i4, String str) {
        try {
            this.f26647a.put("miniapp_id", i4);
            this.f26647a.put("miniapp_version", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public a b(long j4) {
        try {
            k("start_time", Long.valueOf(j4));
            k("app_start_time_readable", new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j4)));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return this;
    }

    public a d(f fVar) {
        k("activity_trace", fVar.d());
        k("running_tasks", fVar.x());
        return this;
    }

    public a e(b bVar) {
        k("header", bVar.b());
        return this;
    }

    public a f(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            k("session_id", str);
        }
        return this;
    }

    public a g(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                jSONArray.put(str);
            }
            k("patch_info", jSONArray);
            return this;
        }
        k("patch_info", jSONArray);
        return this;
    }

    public a h(Map<String, Integer> map) {
        JSONArray jSONArray = new JSONArray();
        if (map == null) {
            this.f26647a.put("plugin_info", jSONArray);
            return this;
        }
        for (String str : map.keySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("package_name", str);
            jSONObject.put("version_code", map.get(str));
            jSONArray.put(jSONObject);
        }
        this.f26647a.put("plugin_info", jSONArray);
        return this;
    }

    public a i(JSONObject jSONObject) {
        k("storage", jSONObject);
        return this;
    }

    public JSONObject j() {
        return this.f26647a;
    }

    public void k(@NonNull String str, @Nullable Object obj) {
        try {
            this.f26647a.put(str, obj);
        } catch (Exception e4) {
            b.k.c(e4);
        }
    }

    public a l(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        for (String str : list) {
            jSONArray.put(str);
        }
        k("logcat", jSONArray);
        return this;
    }

    public a m(Map<Integer, String> map) {
        if (map != null && map.size() > 0) {
            JSONObject jSONObject = new JSONObject();
            for (Integer num : map.keySet()) {
                try {
                    jSONObject.put(String.valueOf(num), map.get(num));
                } catch (JSONException e4) {
                    b.k.c(e4);
                }
            }
            try {
                this.f26647a.put("sdk_info", jSONObject);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        return this;
    }

    public a n(Map<? extends String, ? extends String> map) {
        if (map != null) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                try {
                    jSONObject.put(str, map.get(str));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            k("filters", jSONObject);
        }
        return this;
    }

    public a(JSONObject jSONObject) {
        this.f26647a = jSONObject;
    }
}
