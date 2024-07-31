package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.config.DefaultAdapterClasses;
import com.bytedance.msdk.adapter.config.ITTAdapterConfiguration;
import com.bytedance.msdk.adapter.util.AsyncTasks;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.Preconditions;
import com.bytedance.msdk.adapter.util.Reflection;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.error.InitSdkError;
import com.stub.StubApp;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TTAdapterConfigurationManager implements TTAdapterConfigurationsInitializationListener {

    /* renamed from: a */
    private final Map<String, ITTAdapterConfiguration> f447a = new ConcurrentHashMap();

    /* renamed from: b */
    private List<TTSdkInitializationListener> f448b = new CopyOnWriteArrayList();

    /* renamed from: b */
    private void m59637b() {
        synchronized (this.f448b) {
            for (TTSdkInitializationListener tTSdkInitializationListener : this.f448b) {
                if (tTSdkInitializationListener != null) {
                    tTSdkInitializationListener.mo59268a();
                }
            }
            this.f448b.clear();
        }
    }

    /* renamed from: a */
    public void m59640a(Context context, Set<String> set, Map<String, Map<String, String>> map, Map<String, Map<String, String>> map2, TTSdkInitializationListener tTSdkInitializationListener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(map);
        Preconditions.checkNotNull(map2);
        m59639a(tTSdkInitializationListener);
        AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC0965a(StubApp.getOrigApplicationContext(context.getApplicationContext()), set, map, map2, this, this.f447a, tTSdkInitializationListener != null), new Void[0]);
    }

    @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
    public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls);
        sb.append(" initialized status: ");
        sb.append(adError instanceof InitSdkError ? ((InitSdkError) adError).printMsg() : "");
        Logger.m37554i("TTMediationSDK", sb.toString());
    }

    /* renamed from: a */
    public String m59641a(Context context, Map<String, Object> map, String str) {
        Preconditions.checkNotNull(context);
        ITTAdapterConfiguration m59638a = m59638a(str);
        if (m59638a == null) {
            return null;
        }
        return m59638a.getBiddingToken(context, map);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.TTAdapterConfigurationsInitializationListener
    /* renamed from: a */
    public void mo59634a(Map<String, ITTAdapterConfiguration> map) {
        m59637b();
    }

    /* renamed from: a */
    private void m59639a(TTSdkInitializationListener tTSdkInitializationListener) {
        if (tTSdkInitializationListener == null) {
            return;
        }
        synchronized (this.f448b) {
            if (!this.f448b.contains(tTSdkInitializationListener)) {
                this.f448b.add(tTSdkInitializationListener);
            }
        }
    }

    /* renamed from: a */
    public Map<String, ITTAdapterConfiguration> m59642a() {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        for (String str : DefaultAdapterClasses.getClassNamesSet()) {
            try {
                if ((this.f447a.containsKey(str) ? this.f447a.get(str) : null) == null && (iTTAdapterConfiguration = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(str, ITTAdapterConfiguration.class)) != null) {
                    this.f447a.put(str, iTTAdapterConfiguration);
                }
            } catch (Exception unused) {
            }
        }
        return this.f447a;
    }

    /* compiled from: TTAdapterConfigurationManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    private static class AsyncTaskC0965a extends AsyncTask<Void, Void, Map<String, ITTAdapterConfiguration>> {
        @NonNull

        /* renamed from: a */
        private Context f449a;
        @NonNull

        /* renamed from: b */
        private final Set<String> f450b;
        @NonNull

        /* renamed from: c */
        private final Map<String, Map<String, String>> f451c;
        @NonNull

        /* renamed from: d */
        private final Map<String, Map<String, String>> f452d;
        @NonNull

        /* renamed from: e */
        private final TTAdapterConfigurationsInitializationListener f453e;

        /* renamed from: f */
        private final Map<String, ITTAdapterConfiguration> f454f;

        /* renamed from: g */
        private boolean f455g;

        AsyncTaskC0965a(@NonNull Context context, @NonNull Set<String> set, @NonNull Map<String, Map<String, String>> map, @NonNull Map<String, Map<String, String>> map2, @NonNull TTAdapterConfigurationsInitializationListener tTAdapterConfigurationsInitializationListener, Map<String, ITTAdapterConfiguration> map3, boolean z) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(set);
            Preconditions.checkNotNull(map);
            Preconditions.checkNotNull(map2);
            Preconditions.checkNotNull(tTAdapterConfigurationsInitializationListener);
            this.f449a = context;
            this.f450b = set;
            this.f451c = map;
            this.f452d = map2;
            this.f453e = tTAdapterConfigurationsInitializationListener;
            this.f454f = map3;
            this.f455g = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Map<String, ITTAdapterConfiguration> doInBackground(Void... voidArr) {
            Map<String, ITTAdapterConfiguration> map;
            synchronized (TTAdapterConfigurationManager.class) {
                for (String str : this.f450b) {
                    try {
                        ITTAdapterConfiguration iTTAdapterConfiguration = this.f454f.containsKey(str) ? this.f454f.get(str) : null;
                        if (iTTAdapterConfiguration == null) {
                            iTTAdapterConfiguration = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(str, ITTAdapterConfiguration.class);
                        }
                        if (iTTAdapterConfiguration != null) {
                            if (this.f449a == null) {
                                Logger.m37557e("TTAdapterConfigurationManager", "Context null. Unable to initialize adapter configuration " + str);
                            } else {
                                Map<String, String> map2 = this.f451c.get(str);
                                Map<String, String> map3 = this.f452d.get(str);
                                if (map3 != null) {
                                    iTTAdapterConfiguration.setMsdkRequestOptions(map3);
                                }
                                Logger.m37557e("TTAdapterConfigurationManager", String.format(Locale.US, "Initializing %s version %s with network sdk version %s and with params %s", str, iTTAdapterConfiguration.getAdapterVersion(), iTTAdapterConfiguration.getNetworkSdkVersion(), map2));
                                iTTAdapterConfiguration.initializeNetwork(this.f449a, map2, this.f453e);
                                if (this.f454f.get(str) == null) {
                                    this.f454f.put(str, iTTAdapterConfiguration);
                                }
                            }
                        }
                    } catch (Exception e) {
                        Logger.m37553i("TTAdapterConfigurationManager", "Unable to find class " + str, e);
                    }
                }
                map = this.f454f;
            }
            return map;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(@NonNull Map<String, ITTAdapterConfiguration> map) {
            if (this.f455g) {
                this.f453e.mo59634a(map);
            }
        }
    }

    /* renamed from: a */
    public ITTAdapterConfiguration m59638a(String str) {
        String classNameByAdnName = DefaultAdapterClasses.getClassNameByAdnName(str);
        if (TextUtils.isEmpty(classNameByAdnName)) {
            return null;
        }
        ITTAdapterConfiguration iTTAdapterConfiguration = this.f447a.get(classNameByAdnName);
        if (iTTAdapterConfiguration == null) {
            try {
                ITTAdapterConfiguration iTTAdapterConfiguration2 = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(classNameByAdnName, ITTAdapterConfiguration.class);
                if (iTTAdapterConfiguration2 != null) {
                    try {
                        this.f447a.put(classNameByAdnName, iTTAdapterConfiguration2);
                    } catch (Throwable unused) {
                    }
                }
                return iTTAdapterConfiguration2;
            } catch (Throwable unused2) {
                return iTTAdapterConfiguration;
            }
        }
        return iTTAdapterConfiguration;
    }
}
