package cn.jiguang.cd;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.ce.h;
import cn.jiguang.internal.ActionManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.amps.common.AMPSConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static cn.jiguang.ce.d f3285a;

    private static JSONArray a(Throwable th) {
        try {
            if (th instanceof c) {
                l lVar = new l(new k());
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.valueOf(((c) th).c().getId()));
                List<cn.jiguang.ce.g> a4 = lVar.a(arrayList);
                if (a4 == null || a4.size() <= 0) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                int size = a4.size();
                for (int i4 = 0; i4 < size; i4++) {
                    JSONObject jSONObject = new JSONObject();
                    cn.jiguang.ce.g gVar = a4.get(i4);
                    if (gVar != null) {
                        if (gVar.c() != null) {
                            jSONObject.put("crashed", gVar.c());
                        }
                        if (gVar.d() != null) {
                            jSONObject.put("current", gVar.d());
                        }
                        if (gVar.b() != null) {
                            jSONObject.put("name", gVar.b());
                        }
                        if (gVar.g() != null) {
                            jSONObject.put("daemon", gVar.g());
                        }
                        if (gVar.a() != null) {
                            jSONObject.put("id", gVar.a());
                        }
                        if (gVar.f() != null) {
                            jSONObject.put("priority", gVar.f());
                        }
                        if (gVar.e() != null) {
                            a(jSONObject, gVar.e());
                        }
                        if (gVar.h() != null) {
                            jSONObject.put("state", gVar.h());
                        }
                        if (jSONObject.length() > 0) {
                            jSONArray.put(jSONObject);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    return jSONArray;
                }
                return null;
            }
            return null;
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse Exception.", e4);
            return null;
        }
    }

    public static JSONObject a(Context context, cn.jiguang.ce.h hVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (hVar.b() != null) {
                jSONObject.put("sid", hVar.b().toString());
            }
            jSONObject.put("did", cn.jiguang.cn.c.a(context));
            if (hVar.c() != null) {
                jSONObject.put("init", hVar.c());
            }
            Date a4 = hVar.a();
            if (a4 != null) {
                jSONObject.put("started", cn.jiguang.f.b.a(a4));
            }
            h.a e4 = hVar.e();
            if (e4 != null) {
                jSONObject.put("status", e4.name().toLowerCase(Locale.ROOT));
            }
            if (hVar.f() != null) {
                jSONObject.put("seq", hVar.f());
            }
            int d4 = hVar.d();
            if (d4 > 0) {
                jSONObject.put("errors", d4);
            }
            if (hVar.g() != null) {
                jSONObject.put("duration", hVar.g());
            }
            if (hVar.h() != null) {
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, cn.jiguang.f.b.a(hVar.h()));
            }
            return jSONObject;
        } catch (Throwable th) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse SentrySessionEnvelopeItem.", th);
            return null;
        }
    }

    public static JSONObject a(Context context, Throwable th) {
        cn.jiguang.ce.b a4;
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray c4 = c(context, th);
            if (c4 == null || c4.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("values", c4);
            jSONObject.put("exception", jSONObject2);
            if ((th instanceof c) && (a4 = ((c) th).a()) != null && a4.a().equalsIgnoreCase("UncaughtExceptionHandler")) {
                jSONObject.put("level", "fatal");
            }
            JSONArray a5 = a(th);
            if (a5 != null && a5.length() > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("values", a5);
                jSONObject.put("threads", jSONObject3);
            }
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, cn.jiguang.f.b.a(cn.jiguang.f.b.c()));
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("app", cn.jiguang.cj.b.c(context));
            jSONObject4.put("os", cn.jiguang.cj.b.d(context));
            jSONObject4.put("device", cn.jiguang.cj.b.b(context));
            jSONObject.put("contexts", jSONObject4);
            jSONObject.put("dist", Integer.toString(cn.jiguang.a.a.f2011c));
            jSONObject.put("environment", "production");
            jSONObject.put("platform", "java");
            cn.jiguang.ce.d dVar = new cn.jiguang.ce.d();
            f3285a = dVar;
            jSONObject.put("event_id", dVar.toString());
            jSONObject.put("sdk", cn.jiguang.cj.b.a());
            jSONObject.put("user", cn.jiguang.cj.b.e(context));
            return jSONObject;
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse SentryEventEnvelopeItem.", e4);
            return null;
        }
    }

    public static JSONObject a(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("content_type", "application/json");
            jSONObject.put("type", str);
            return jSONObject;
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse SentryEnvelopeItemHeader.", e4);
            return null;
        }
    }

    public static JSONObject a(boolean z3) {
        cn.jiguang.ce.d dVar;
        try {
            JSONObject jSONObject = new JSONObject();
            if (z3 && (dVar = f3285a) != null) {
                jSONObject.put("event_id", dVar.toString());
            }
            JSONObject jSONObject2 = new JSONObject();
            ActionManager.getInstance().wrapSdkVersionInfo(jSONObject2);
            jSONObject2.put("core_sdk_ver", cn.jiguang.a.a.f2010b);
            jSONObject.put("sdks", jSONObject2);
            return jSONObject;
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse SentryEnvelopeHeader.", e4);
            return null;
        }
    }

    private static void a(JSONObject jSONObject, cn.jiguang.ce.b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (bVar.a() != null) {
                jSONObject2.put("type", bVar.a());
            }
            if (bVar.b() != null) {
                jSONObject2.put("handled", bVar.b());
            }
            jSONObject.put("mechanism", jSONObject2);
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse writeMechanism.", e4);
        }
    }

    private static void a(JSONObject jSONObject, cn.jiguang.ce.e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            if (eVar.n() != null) {
                jSONObject.put(AMPSConstants.AdType.AD_TYPE_NATIVE, eVar.n());
            }
            if (eVar.a() != null) {
                jSONObject.put("filename", eVar.a());
            }
            if (eVar.b() != null) {
                jSONObject.put("function", eVar.b());
            }
            if (eVar.h() != null) {
                jSONObject.put("in_app", eVar.h());
            }
            if (eVar.d() != null) {
                jSONObject.put("lineno", eVar.d());
            }
            if (eVar.c() != null) {
                jSONObject.put("module", eVar.c());
            }
            if (eVar.i() != null) {
                jSONObject.put("package", eVar.i());
            }
            if (eVar.f() != null) {
                jSONObject.put("abs_path", eVar.f());
            }
            if (eVar.e() != null) {
                jSONObject.put("colno", eVar.e());
            }
            if (eVar.g() != null) {
                jSONObject.put("context_line", eVar.g());
            }
            if (eVar.j() != null) {
                jSONObject.put("platform", eVar.j());
            }
            if (eVar.k() != null) {
                jSONObject.put("image_addr", eVar.k());
            }
            if (eVar.l() != null) {
                jSONObject.put("symbol_addr", eVar.l());
            }
            if (eVar.m() != null) {
                jSONObject.put("instruction_addr", eVar.m());
            }
            if (eVar.o() != null) {
                jSONObject.put("raw_function", eVar.o());
            }
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse StackFrame.", e4);
        }
    }

    private static void a(JSONObject jSONObject, cn.jiguang.ce.f fVar) {
        if (fVar == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (fVar.a() != null && fVar.a().size() > 0) {
                if (fVar.b() != null) {
                    jSONObject2.put("snapshot", fVar.b());
                }
                int size = fVar.a().size();
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < size; i4++) {
                    JSONObject jSONObject3 = new JSONObject();
                    cn.jiguang.ce.e eVar = fVar.a().get(i4);
                    if (eVar != null) {
                        a(jSONObject3, eVar);
                        if (jSONObject3.length() > 0) {
                            jSONArray.put(jSONObject3);
                        }
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject2.put("frames", jSONArray);
                }
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("stacktrace", jSONObject2);
            }
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse StackTrace.", e4);
        }
    }

    public static void b(Context context, Throwable th) {
        try {
            for (cn.jiguang.ce.c cVar : new j(new k()).a(th)) {
                if (cVar.e() != null && cVar.e().a() != null) {
                    List<cn.jiguang.ce.e> a4 = cVar.e().a();
                    boolean z3 = false;
                    for (int i4 = 0; i4 < a4.size(); i4++) {
                        cn.jiguang.ce.e eVar = a4.get(i4);
                        if (eVar != null) {
                            String a5 = cn.jiguang.cj.b.a(eVar.c());
                            if (!TextUtils.isEmpty(a5)) {
                                if (cVar.f() != null && TextUtils.equals("ANR", cVar.f().a())) {
                                    z3 = true;
                                }
                                cn.jiguang.cf.a.a().a(context, a5, z3 ? "EX_ANR" : "EX_CRASH");
                                cn.jiguang.bq.d.i("ExceptionParseUtils", "sdk exception occurred, anr " + z3);
                                return;
                            }
                        }
                    }
                    continue;
                }
            }
        } catch (Throwable th2) {
            cn.jiguang.bq.d.i("ExceptionParseUtils", "count ex failed, " + th2.getMessage());
        }
    }

    private static JSONArray c(Context context, Throwable th) {
        try {
            List<cn.jiguang.ce.c> a4 = new j(new k()).a(th);
            if (a4 == null || a4.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            int size = a4.size();
            for (int i4 = 0; i4 < size; i4++) {
                JSONObject jSONObject = new JSONObject();
                cn.jiguang.ce.c cVar = a4.get(i4);
                if (cVar != null) {
                    a(jSONObject, cVar.f());
                    if (cVar.c() != null) {
                        jSONObject.put("module", cVar.c());
                    }
                    if (cVar.d() != null) {
                        jSONObject.put("thread_id", cVar.d());
                    }
                    if (cVar.a() != null) {
                        jSONObject.put("type", cVar.a());
                    }
                    if (cVar.b() != null) {
                        jSONObject.put("value", cVar.b());
                    }
                    if (cVar.e() != null) {
                        a(jSONObject, cVar.e());
                    }
                    if (jSONObject.length() > 0) {
                        jSONArray.put(jSONObject);
                    }
                }
            }
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException e4) {
            cn.jiguang.bq.d.a("ExceptionParseUtils", "Error parse Exception.", e4);
            return null;
        }
    }
}
