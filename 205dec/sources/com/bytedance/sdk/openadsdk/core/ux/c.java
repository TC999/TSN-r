package com.bytedance.sdk.openadsdk.core.ux;

import android.content.Context;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.repo.AdLogEventRepo;
import com.bytedance.sdk.component.gd.ev;
import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f35101c;

    public static void sr(String str, String str2) {
        if (f35101c) {
            xv.sr(str, str2);
        }
    }

    public static void ux(String str, String str2) {
        if (f35101c) {
            xv.ux(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w() {
        ev.w(new p("fetch_lg_command") { // from class: com.bytedance.sdk.openadsdk.core.ux.c.2
            @Override // java.lang.Runnable
            public void run() {
                xv.w();
            }
        });
    }

    public static void xv(String str, String str2) {
        if (f35101c) {
            xv.xv(str, str2);
        }
    }

    private static void c(Context context, w wVar) {
        if (wVar == null) {
            a.w("ACL", "CL not init for no setting config");
        } else if (LogAdapter.sAdapter != null) {
            a.w("ACL", "Log to tools");
        } else if (!s.c(ls.getContext())) {
            a.w("ACL", "only main process init CL");
        } else if (!wVar.sr()) {
            a.w("ACL", "setting not open CL");
        } else {
            String path = com.bytedance.sdk.openadsdk.api.plugin.w.w(context).getPath();
            String file = com.bytedance.sdk.openadsdk.api.plugin.w.c(context).toString();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("buffer_dir_path", path + "/aa");
                jSONObject.putOpt("log_dir_path", file + "/aa");
                Boolean bool = Boolean.TRUE;
                jSONObject.putOpt("compress", bool);
                jSONObject.putOpt(AdLogEventRepo.COL_ENCRYPT_TYPE, bool);
                jSONObject.putOpt("level", Integer.valueOf(wVar.c()));
                jSONObject.putOpt("log_file_exp_days", Integer.valueOf(wVar.w()));
                jSONObject.putOpt("max_dir_size", Integer.valueOf(wVar.xv() * 1024 * 1024));
                jSONObject.putOpt("per_size", 2097152);
                jSONObject.putOpt("offload_main_write", bool);
                if (xv.c(context, jSONObject)) {
                    a.c(new ux());
                    xv.c(context, "3892", r.c().w());
                    xv.c("mon.zijieapi.com");
                    f35101c = true;
                    xv.xv();
                } else {
                    a.f("ACL", "init failed");
                }
            } catch (JSONException e4) {
                a.f("ACL", "init failed:" + e4.getMessage());
            }
        }
    }

    public static void w(String str, String str2) {
        if (f35101c) {
            xv.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f35101c) {
            xv.w(str, str2, th);
        }
    }

    public static void c(w wVar) {
        if (!f35101c) {
            c(ls.getContext(), wVar);
        } else if (wVar != null && wVar.sr()) {
            xv.c(wVar.c());
            com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ux.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.w();
                }
            }, 5000L);
        } else {
            xv.c();
        }
    }

    public static void c(String str, String str2) {
        if (f35101c) {
            xv.c(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f35101c) {
            xv.c(str, str2, th);
        }
    }

    public static void c(String str, Throwable th) {
        if (f35101c) {
            xv.c(str, th);
        }
    }
}
