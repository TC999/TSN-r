package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.openadsdk.CodeGroupRitObject;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.live.ILiveAdCustomConfig;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class me extends com.bytedance.sdk.openadsdk.ys.c.c implements Bridge, Manager {

    /* renamed from: c  reason: collision with root package name */
    private final ValueSet f33896c = b.a().g(11, new b.c() { // from class: com.bytedance.sdk.openadsdk.core.me.1
        @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
        /* renamed from: c */
        public Integer get() {
            return Integer.valueOf(k.sr().me());
        }
    }).i(12, "6.1.0.6").l();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public final class c implements Bridge {

        /* renamed from: w  reason: collision with root package name */
        private ILiveAdCustomConfig f33901w;

        public c(ILiveAdCustomConfig iLiveAdCustomConfig) {
            this.f33901w = iLiveAdCustomConfig;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                return null;
                            }
                            this.f33901w.onEventV3(valueSet.stringValue(0), (JSONObject) valueSet.objectValue(1, JSONObject.class));
                            return null;
                        }
                        return (T) this.f33901w.invoke(valueSet.intValue(0), (Bundle) valueSet.objectValue(1, Bundle.class));
                    }
                    return (T) this.f33901w.convertToEnterMethod(valueSet.intValue(0), valueSet.booleanValue(1));
                }
                return (T) this.f33901w.convertToEnterFromMerge(valueSet.intValue(0));
            }
            return (T) Integer.valueOf(this.f33901w.openLR(valueSet.stringValue(0)));
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return b.a().e(10000, 1).l();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public void c(Object obj) {
        if (obj instanceof TTDownloadEventLogger) {
            k.sr().c((TTDownloadEventLogger) obj);
        } else if (obj instanceof Bundle) {
            Bundle bundle = (Bundle) obj;
            if (bundle.containsKey("_pl_config_info_")) {
                k.sr().c(bundle.getBundle("_pl_config_info_"));
                if (k.sr().fz().length() == 0 || com.bytedance.sdk.openadsdk.core.eq.t.w()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.gb.c.c.w().xv();
            }
        } else if ((eq.sr() || com.bytedance.sdk.openadsdk.core.eq.wv.ev().equals("com.pangolin_demo.toutiao")) && obj != null && ((TTC) obj.getClass().getAnnotation(TTC.class)) != null) {
            com.bytedance.sdk.openadsdk.f.w.c(obj);
        } else if (obj instanceof Bridge) {
            c((Bridge) obj);
        } else if (obj instanceof CodeGroupRitObject) {
            com.bytedance.sdk.openadsdk.core.f.c.c((CodeGroupRitObject) obj);
        } else if (eq.sr() && (obj instanceof ILiveAdCustomConfig)) {
            TTLiveCommerceHelper.getInstance().setLiveAdBridge(new c((ILiveAdCustomConfig) obj));
        } else if (obj instanceof ValueSet) {
            ValueSet valueSet = (ValueSet) obj;
            try {
                if (valueSet.intValue(0) != 1) {
                    return;
                }
                c((ClassLoader) valueSet.objectValue(2, ClassLoader.class), valueSet.stringValue(1));
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.c("TTAdManagerImpl", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 != 16) {
            switch (i4) {
                case 1:
                    c((valueSet != null ? Integer.valueOf(valueSet.intValue(11)) : null).intValue());
                    break;
                case 2:
                    return cls.cast(c(valueSet, valueSet.booleanValue(13), valueSet.intValue(14)));
                case 3:
                    c(valueSet != null ? (Context) valueSet.objectValue(7, Context.class) : null);
                    break;
                case 4:
                    c(valueSet != null ? valueSet.objectValue(8, Object.class) : null);
                    break;
                case 5:
                    w(valueSet != null ? valueSet.objectValue(8, Object.class) : null);
                    break;
                case 6:
                    return (T) c(valueSet != null ? (Class) valueSet.objectValue(9, Class.class) : null, valueSet != null ? (Bundle) valueSet.objectValue(10, Bundle.class) : null);
                default:
                    return null;
            }
            return null;
        }
        k.sr().f(valueSet != null ? valueSet.booleanValue(17, false) : false);
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Loader createLoader(Context context) {
        return new wv(context);
    }

    @Override // com.bykv.vk.openvk.api.proto.Manager
    public Bridge getBridge(int i4) {
        return this;
    }

    public void sr() {
        com.bytedance.sdk.openadsdk.core.eq.ba.c("sp_full_screen_video").w();
        com.bytedance.sdk.openadsdk.core.eq.ba.c("sp_reward_video").w();
        com.bytedance.sdk.openadsdk.core.eq.ba.c("tt_materialMeta").w();
        com.bytedance.sdk.openadsdk.core.eq.ba.c("tt_splash").w();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f33896c;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public String w() {
        return "6.1.0.6";
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public void w(Object obj) {
        if (obj instanceof TTDownloadEventLogger) {
            k.sr().c((TTDownloadEventLogger) null);
        }
        if ((!eq.sr() && !com.bytedance.sdk.openadsdk.core.eq.wv.ev().equals("com.pangolin_demo.toutiao")) || obj == null || ((TTC) obj.getClass().getAnnotation(TTC.class)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.f.w.w(obj);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public int xv() {
        return k.sr().me();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public com.bytedance.sdk.openadsdk.ys.c.w w(Context context) {
        return new wv(context);
    }

    private void c(ClassLoader classLoader, String str) throws Throwable {
        Method method;
        Class<?> loadClass = classLoader.loadClass("com.bytedance.sdk.openadsdk.ats.AutoService");
        if (loadClass == AutoService.class || (method = loadClass.getMethod("init", Bridge.class)) == null) {
            return;
        }
        Bridge bridge = (Bridge) method.invoke(null, AutoService.init(null));
        if (bridge != null) {
            AutoService.init(bridge);
        }
        if (TextUtils.equals(str, "com.byted.csj.ext")) {
            com.bytedance.sdk.openadsdk.core.ux.xv.c(ls.w().ok());
        }
    }

    private void c(Bridge bridge) {
        if (bridge == null) {
            return;
        }
        ValueSet values = bridge.values();
        if (values == null) {
            k.sr().c(bridge);
        } else if (values.intValue(10000) != 1) {
            k.sr().c(bridge);
        } else if (eq.sr()) {
            TTLiveCommerceHelper.getInstance().setLiveAdBridge(bridge);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public <T> T c(Class<T> cls, Bundle bundle) {
        int i4 = bundle != null ? bundle.getInt("type") : 0;
        if (cls == ITTProvider.class) {
            return (T) com.bytedance.sdk.openadsdk.core.multipro.f.c(ls.getContext());
        }
        if (cls != ValueSet.class && (cls == null || !"com.bytedance.sdk.openadsdk.AdConfig".equals(cls.getName()))) {
            if (cls == ITTDownloadVisitor.class && i4 == 1) {
                return (T) com.bytedance.sdk.openadsdk.core.p.c.c.c();
            }
            if (cls == Bundle.class) {
                if (bundle == null) {
                    return null;
                }
                int i5 = bundle.getInt("action", 0);
                if (i5 == 0) {
                    k.sr().c(bundle.getString("plugin_pkg_name"), bundle.getString("plugin_version"));
                } else if (i5 == 1) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c().w(bundle.getString("event_name"), bundle.getString(EventMonitor.EVENT_EXTRA));
                } else if (i5 == 2) {
                    sr();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("splash", 0);
                        jSONObject.put("reward", 0);
                        jSONObject.put("brand", 0);
                        jSONObject.put("other", 0);
                        com.bykv.vk.openvk.component.video.c.c.c(jSONObject);
                        com.bytedance.sdk.openadsdk.n.ev.c(0).ux();
                        com.bykv.vk.openvk.component.video.c.c.c(ls.w().lw());
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.a.xv(th.getMessage());
                    }
                } else if (i5 == 3) {
                    com.bytedance.sdk.component.gd.ev.c(-1);
                }
            } else if (cls == ExecutorService.class) {
                if (bundle != null) {
                    int i6 = bundle.getInt("action", 0);
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 3) {
                                return (T) com.bytedance.sdk.component.gd.a.f29806w.a();
                            }
                            return (T) com.bytedance.sdk.component.gd.a.f29806w.k();
                        }
                        return (T) com.bytedance.sdk.component.gd.a.f29806w.gd();
                    }
                    return (T) com.bytedance.sdk.component.gd.a.f29806w.p();
                }
            } else if (cls == Handler.class && bundle != null && bundle.getInt("action", 0) == 1) {
                return (T) com.bytedance.sdk.component.utils.ev.c();
            }
        } else if (bundle != null && !bundle.keySet().isEmpty()) {
            if (bundle.containsKey("is_paid")) {
                k.sr().ux(bundle.getBoolean("is_paid"));
            }
            if (bundle.containsKey("extra_data")) {
                k.sr().ux(bundle.getString("extra_data"));
            }
            if (bundle.containsKey("keywords")) {
                k.sr().f(bundle.getString("keywords"));
            }
            if (bundle.containsKey("quit_work")) {
                k.sr().f(bundle.getBoolean("quit_work", false));
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public void c(Context context) {
        if (context == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr f4 = k.sr().f();
        if (f4 != null) {
            boolean c4 = f4.c();
            boolean xv = f4.xv();
            boolean ux = f4.ux();
            if (!c4 && !xv && !ux) {
                return;
            }
        }
        Intent intent = new Intent(context, TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        com.bytedance.sdk.component.utils.w.c(context, intent, null);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public String c() {
        return eq.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public String c(ValueSet valueSet, boolean z3, int i4) {
        if (valueSet == null || ls.c() == null) {
            return null;
        }
        return ls.c().c(new com.bytedance.sdk.openadsdk.ys.w.xv.w(valueSet), z3, i4);
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public boolean c(Activity activity, final EventListener eventListener) {
        Bridge u3 = k.sr().u();
        if (u3 != null) {
            return ((Boolean) u3.call(0, b.b(1).h(0, new com.bytedance.sdk.openadsdk.core.eq.y().c("activity", activity).c("exitInstallListener", new ExitInstallListener() { // from class: com.bytedance.sdk.openadsdk.core.me.2
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener
                public void onExitInstall() {
                    eventListener.onEvent(0, com.bykv.c.c.c.c.a.a().e(true).f());
                }
            })).l(), Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.c.c
    public void c(int i4) {
        if (i4 != k.sr().me()) {
            k.sr().ux(i4);
            Intent intent = new Intent();
            intent.setAction("com.bytedance.openadsdk.themeTypeChangeReceiver");
            intent.putExtra("theme_status_change", i4);
            ls.getContext().sendBroadcast(intent, com.bytedance.sdk.openadsdk.core.eq.wv.ls());
        }
    }
}
