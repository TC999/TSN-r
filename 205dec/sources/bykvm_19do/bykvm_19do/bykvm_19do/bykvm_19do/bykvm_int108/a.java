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

/* compiled from: TTAdapterConfigurationManager.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, ITTAdapterConfiguration> f440a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private List<c> f441b = new CopyOnWriteArrayList();

    private void b() {
        synchronized (this.f441b) {
            for (c cVar : this.f441b) {
                if (cVar != null) {
                    cVar.a();
                }
            }
            this.f441b.clear();
        }
    }

    public void a(Context context, Set<String> set, Map<String, Map<String, String>> map, Map<String, Map<String, String>> map2, c cVar) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(set);
        Preconditions.checkNotNull(map);
        Preconditions.checkNotNull(map2);
        a(cVar);
        AsyncTasks.safeExecuteOnExecutor(new AsyncTaskC0024a(StubApp.getOrigApplicationContext(context.getApplicationContext()), set, map, map2, this, this.f440a, cVar != null), new Void[0]);
    }

    @Override // com.bytedance.msdk.adapter.config.TTOnNetworkInitializationFinishedListener
    public void onNetworkInitializationFinished(@NonNull Class<? extends ITTAdapterConfiguration> cls, @NonNull AdError adError) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls);
        sb.append(" initialized status: ");
        sb.append(adError instanceof InitSdkError ? ((InitSdkError) adError).printMsg() : "");
        Logger.i("TTMediationSDK", sb.toString());
    }

    public String a(Context context, Map<String, Object> map, String str) {
        Preconditions.checkNotNull(context);
        ITTAdapterConfiguration a4 = a(str);
        if (a4 == null) {
            return null;
        }
        return a4.getBiddingToken(context, map);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b
    public void a(Map<String, ITTAdapterConfiguration> map) {
        b();
    }

    private void a(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (this.f441b) {
            if (!this.f441b.contains(cVar)) {
                this.f441b.add(cVar);
            }
        }
    }

    public Map<String, ITTAdapterConfiguration> a() {
        ITTAdapterConfiguration iTTAdapterConfiguration;
        for (String str : DefaultAdapterClasses.getClassNamesSet()) {
            try {
                if ((this.f440a.containsKey(str) ? this.f440a.get(str) : null) == null && (iTTAdapterConfiguration = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(str, ITTAdapterConfiguration.class)) != null) {
                    this.f440a.put(str, iTTAdapterConfiguration);
                }
            } catch (Exception unused) {
            }
        }
        return this.f440a;
    }

    /* compiled from: TTAdapterConfigurationManager.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    private static class AsyncTaskC0024a extends AsyncTask<Void, Void, Map<String, ITTAdapterConfiguration>> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private Context f442a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final Set<String> f443b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Map<String, String>> f444c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private final Map<String, Map<String, String>> f445d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private final b f446e;

        /* renamed from: f  reason: collision with root package name */
        private final Map<String, ITTAdapterConfiguration> f447f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f448g;

        AsyncTaskC0024a(@NonNull Context context, @NonNull Set<String> set, @NonNull Map<String, Map<String, String>> map, @NonNull Map<String, Map<String, String>> map2, @NonNull b bVar, Map<String, ITTAdapterConfiguration> map3, boolean z3) {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(set);
            Preconditions.checkNotNull(map);
            Preconditions.checkNotNull(map2);
            Preconditions.checkNotNull(bVar);
            this.f442a = context;
            this.f443b = set;
            this.f444c = map;
            this.f445d = map2;
            this.f446e = bVar;
            this.f447f = map3;
            this.f448g = z3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Map<String, ITTAdapterConfiguration> doInBackground(Void... voidArr) {
            Map<String, ITTAdapterConfiguration> map;
            synchronized (a.class) {
                for (String str : this.f443b) {
                    try {
                        ITTAdapterConfiguration iTTAdapterConfiguration = this.f447f.containsKey(str) ? this.f447f.get(str) : null;
                        if (iTTAdapterConfiguration == null) {
                            iTTAdapterConfiguration = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(str, ITTAdapterConfiguration.class);
                        }
                        if (iTTAdapterConfiguration != null) {
                            if (this.f442a == null) {
                                Logger.e("TTAdapterConfigurationManager", "Context null. Unable to initialize adapter configuration " + str);
                            } else {
                                Map<String, String> map2 = this.f444c.get(str);
                                Map<String, String> map3 = this.f445d.get(str);
                                if (map3 != null) {
                                    iTTAdapterConfiguration.setMsdkRequestOptions(map3);
                                }
                                Logger.e("TTAdapterConfigurationManager", String.format(Locale.US, "Initializing %s version %s with network sdk version %s and with params %s", str, iTTAdapterConfiguration.getAdapterVersion(), iTTAdapterConfiguration.getNetworkSdkVersion(), map2));
                                iTTAdapterConfiguration.initializeNetwork(this.f442a, map2, this.f446e);
                                if (this.f447f.get(str) == null) {
                                    this.f447f.put(str, iTTAdapterConfiguration);
                                }
                            }
                        }
                    } catch (Exception e4) {
                        Logger.i("TTAdapterConfigurationManager", "Unable to find class " + str, e4);
                    }
                }
                map = this.f447f;
            }
            return map;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(@NonNull Map<String, ITTAdapterConfiguration> map) {
            if (this.f448g) {
                this.f446e.a(map);
            }
        }
    }

    public ITTAdapterConfiguration a(String str) {
        String classNameByAdnName = DefaultAdapterClasses.getClassNameByAdnName(str);
        if (TextUtils.isEmpty(classNameByAdnName)) {
            return null;
        }
        ITTAdapterConfiguration iTTAdapterConfiguration = this.f440a.get(classNameByAdnName);
        if (iTTAdapterConfiguration == null) {
            try {
                ITTAdapterConfiguration iTTAdapterConfiguration2 = (ITTAdapterConfiguration) Reflection.instantiateClassWithEmptyConstructor(classNameByAdnName, ITTAdapterConfiguration.class);
                if (iTTAdapterConfiguration2 != null) {
                    try {
                        this.f440a.put(classNameByAdnName, iTTAdapterConfiguration2);
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
