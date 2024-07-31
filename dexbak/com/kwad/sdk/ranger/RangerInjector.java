package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.common.utility.Logger;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11124s;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.umeng.commonsdk.framework.UMModuleRegister;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RangerInjector {

    /* renamed from: com.kwad.sdk.ranger.RangerInjector$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10942a {
    }

    /* renamed from: com.kwad.sdk.ranger.RangerInjector$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10943b {
        /* renamed from: a */
        void mo24397a(String str, long j, long j2, String str2, String str3);

        void onError(String str);
    }

    /* renamed from: a */
    public static void m24408a(String str, final String str2, final InterfaceC10943b interfaceC10943b) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                interfaceC10943b.onError("getPluginByClass is null");
                return;
            }
            final PluginListener pluginListener = (PluginListener) C11124s.getField(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    C11124s.m23707a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.ranger.RangerInjector.1
                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    C10331c.m26248i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th) {
                                    InterfaceC10943b interfaceC10943b2 = interfaceC10943b;
                                    if (interfaceC10943b2 != null) {
                                        interfaceC10943b2.onError(Log.getStackTraceString(th));
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(str2)) {
                                Issue issue = (Issue) objArr[0];
                                C10331c.m26248i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String m24407p = RangerInjector.m24407p(content);
                                    long m24406q = RangerInjector.m24406q(content);
                                    long m24405r = RangerInjector.m24405r(content);
                                    String m24404s = RangerInjector.m24404s(content);
                                    String m24403t = RangerInjector.m24403t(content);
                                    InterfaceC10943b interfaceC10943b3 = interfaceC10943b;
                                    if (interfaceC10943b3 != null) {
                                        interfaceC10943b3.mo24397a(m24407p, m24405r, m24406q, m24404s, m24403t);
                                    }
                                } catch (Throwable unused) {
                                }
                                pluginListener.onReportIssue(issue);
                            } else if (TextUtils.equals(method.getName(), "onInit")) {
                                pluginListener.onInit((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStart")) {
                                pluginListener.onStart((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStop")) {
                                pluginListener.onStop((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onDestroy")) {
                                pluginListener.onDestroy((Plugin) objArr[0]);
                            } else {
                                method.invoke(pluginListener, objArr);
                            }
                            return null;
                        }
                    }));
                } catch (Exception e) {
                    interfaceC10943b.onError(Log.getStackTraceString(e));
                }
            }
        } catch (Exception e2) {
            interfaceC10943b.onError(Log.getStackTraceString(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public static String m24407p(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static long m24406q(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static long m24405r(JSONObject jSONObject) {
        try {
            return jSONObject.optLong(RtspHeaders.Values.TIME);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static String m24404s(JSONObject jSONObject) {
        try {
            return jSONObject.optString("scene");
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public static String m24403t(JSONObject jSONObject) {
        try {
            return jSONObject.optString(UMModuleRegister.PROCESS);
        } catch (Exception unused) {
            return "";
        }
    }

    @Keep
    public static void tryProxyOtherOutput(String str, String str2, String str3, final String str4, final InterfaceC10942a interfaceC10942a) {
        try {
            final Logger.ILogWritter iLogWritter = (Logger.ILogWritter) C11124s.m23702aq(str, str2);
            if (iLogWritter == null) {
                return;
            }
            Integer num = (Integer) C11124s.m23702aq(str, str3);
            final int intValue = num != null ? num.intValue() : 4;
            C11124s.setStaticField(Class.forName(str), str2, new Logger.ILogWritter() { // from class: com.kwad.sdk.ranger.RangerInjector.2
                @Keep
                public final boolean isLoggable(int i) {
                    return true;
                }

                @Keep
                public final void logD(String str5, String str6) {
                    try {
                        if (intValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6, Throwable th) {
                    try {
                        if (TextUtils.equals(str5, str4) && interfaceC10942a != null) {
                            Log.getStackTraceString(th);
                        }
                        if (intValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6) {
                    try {
                        if (intValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logK(String str5, String str6) {
                    try {
                        iLogWritter.logK(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6) {
                    try {
                        if (intValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6) {
                    try {
                        if (intValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logD(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str6, Throwable th) {
                    try {
                        if (intValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str6, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str6) {
                    try {
                        if (intValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str6);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            C10331c.m26246w("perfMonitor.RangerInjector", Log.getStackTraceString(th));
        }
    }
}
