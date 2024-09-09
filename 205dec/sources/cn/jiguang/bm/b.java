package cn.jiguang.bm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static Object a(Context context, String str, Bundle bundle) {
        cn.jiguang.bp.h.b("JOperateEventDispatch", "onEvent:" + str + ",bundle:" + bundle);
        try {
            h.a(context);
        } catch (Throwable th) {
            cn.jiguang.bp.h.a("JOperateEventDispatch", "type:" + str, th);
        }
        if (!h.b(context)) {
            h.a(context, str, bundle);
            return null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        i.a(context, "start_app_wake_save".equals(str));
        if ("init".equals(str)) {
            c.a(context);
        } else if ("login".equals(str)) {
            return c.a(context, new JSONObject(bundle.getString("login_property")));
        } else {
            if ("set_channel".equals(str)) {
                return c.b(context, new JSONObject(bundle.getString("data")));
            }
            if ("test_demo".equals(str)) {
                return c.a(context, bundle.getInt("dataType", -1), new JSONObject());
            }
            if ("set_report_debug".equals(str)) {
                i.a(context, (Intent) bundle.getParcelable("intent"));
            } else if ("set_debug".equals(str)) {
                bundle.getBoolean("debug");
            } else if ("jcore_register".equals(str)) {
                c.a(context, bundle.getLong("uid"), bundle.getString("rid"));
            } else if ("jcore_login".equals(str)) {
                c.b(context, bundle.getLong("uid"), bundle.getString("rid"));
            } else if ("user_profile".equals(str)) {
                return c.a(context, bundle.getString("type"), new JSONObject(bundle.getString("properties")));
            } else {
                if ("un_user_profile".equals(str)) {
                    return c.a(context, bundle.getString("property"));
                }
                if ("period_task".equals(str)) {
                    c.b(context);
                    i.f(context);
                } else if ("start_app".equals(str)) {
                    i.b(context);
                    i.g(context);
                } else if ("start_app_wake_save".equals(str)) {
                    i.c(context);
                } else if ("exit_app".equals(str)) {
                    i.d(context);
                } else if ("report_custom".equals(str)) {
                    i.b(context, bundle);
                } else if ("report_reserved".equals(str)) {
                    i.c(context, bundle);
                } else if ("report_interval".equals(str)) {
                    i.a(bundle);
                } else if ("flush".equals(str)) {
                    i.e(context);
                } else if ("set_network_type".equals(str)) {
                    i.b(bundle);
                } else if ("set_max_event_cache_count".equals(str)) {
                    i.c(bundle);
                } else if ("get_cuid".equals(str)) {
                    return cn.jiguang.bp.g.c(context);
                } else {
                    if ("get_peripheral_property".equals(str)) {
                        return i.b(context, false);
                    }
                    if ("activity_lifecycle".equals(str)) {
                        return i.a(context, bundle);
                    }
                    if ("super_properties".equals(str)) {
                        return i.e(context, bundle);
                    }
                    if ("set_utm".equals(str)) {
                        return i.d(bundle);
                    }
                    if ("on_event_timer".equals(str)) {
                        return i.a(context, bundle, true);
                    }
                    if ("get_report_debug".equals(str)) {
                        return i.d(context, bundle);
                    }
                    if ("is_fore_ground".equals(str)) {
                        return Boolean.valueOf(i.f2771b ? false : true);
                    }
                }
            }
        }
        return null;
    }
}
