package com.beizi.fusion.p072g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import com.stub.StubApp;
import com.umeng.ccg.CcgConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* renamed from: com.beizi.fusion.g.ae */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class LocalBroadcastManager {

    /* renamed from: f */
    private static final Object f11227f = new Object();

    /* renamed from: g */
    private static LocalBroadcastManager f11228g;

    /* renamed from: a */
    private final Context f11229a;

    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<C3115b>> f11230b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C3115b>> f11231c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C3114a> f11232d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f11233e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: com.beizi.fusion.g.ae$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3114a {

        /* renamed from: a */
        final Intent f11235a;

        /* renamed from: b */
        final ArrayList<C3115b> f11236b;

        C3114a(Intent intent, ArrayList<C3115b> arrayList) {
            this.f11235a = intent;
            this.f11236b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: com.beizi.fusion.g.ae$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3115b {

        /* renamed from: a */
        final IntentFilter f11237a;

        /* renamed from: b */
        final BroadcastReceiver f11238b;

        /* renamed from: c */
        boolean f11239c;

        /* renamed from: d */
        boolean f11240d;

        C3115b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f11237a = intentFilter;
            this.f11238b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f11238b);
            sb.append(" filter=");
            sb.append(this.f11237a);
            if (this.f11240d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.f11229a = context;
        this.f11233e = new Handler(context.getMainLooper()) { // from class: com.beizi.fusion.g.ae.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBroadcastManager.this.m48502a();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    @NonNull
    /* renamed from: a */
    public static LocalBroadcastManager m48499a(@NonNull Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (f11227f) {
            if (f11228g == null) {
                f11228g = new LocalBroadcastManager(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            localBroadcastManager = f11228g;
        }
        return localBroadcastManager;
    }

    /* renamed from: a */
    public void m48500a(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f11230b) {
            try {
                C3115b c3115b = new C3115b(intentFilter, broadcastReceiver);
                ArrayList<C3115b> arrayList = this.f11230b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f11230b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(c3115b);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList<C3115b> arrayList2 = this.f11231c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f11231c.put(action, arrayList2);
                    }
                    arrayList2.add(c3115b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void m48501a(@NonNull BroadcastReceiver broadcastReceiver) {
        ArrayList<C3115b> remove;
        synchronized (this.f11230b) {
            try {
                remove = this.f11230b.remove(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                C3115b c3115b = remove.get(size);
                c3115b.f11240d = true;
                for (int i = 0; i < c3115b.f11237a.countActions(); i++) {
                    String action = c3115b.f11237a.getAction(i);
                    ArrayList<C3115b> arrayList = this.f11231c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            C3115b c3115b2 = arrayList.get(size2);
                            if (c3115b2.f11238b == broadcastReceiver) {
                                c3115b2.f11240d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f11231c.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public boolean m48498a(@NonNull Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<C3115b> arrayList2;
        String str2;
        synchronized (this.f11230b) {
            try {
                try {
                    String action = intent.getAction();
                    String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f11229a.getContentResolver());
                    Uri data = intent.getData();
                    String scheme = intent.getScheme();
                    Set<String> categories = intent.getCategories();
                    boolean z = (intent.getFlags() & 8) != 0;
                    if (z) {
                        Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                    }
                    ArrayList<C3115b> arrayList3 = this.f11231c.get(intent.getAction());
                    if (arrayList3 != null) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                        }
                        ArrayList arrayList4 = null;
                        int i2 = 0;
                        while (i2 < arrayList3.size()) {
                            C3115b c3115b = arrayList3.get(i2);
                            if (z) {
                                Log.v("LocalBroadcastManager", "Matching against filter " + c3115b.f11237a);
                            }
                            if (c3115b.f11239c) {
                                if (z) {
                                    Log.v("LocalBroadcastManager", "  Filter's target already added");
                                }
                                i = i2;
                                arrayList2 = arrayList3;
                                str = action;
                                str2 = resolveTypeIfNeeded;
                                arrayList = arrayList4;
                            } else {
                                i = i2;
                                str = action;
                                arrayList = arrayList4;
                                arrayList2 = arrayList3;
                                str2 = resolveTypeIfNeeded;
                                int match = c3115b.f11237a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                                if (match >= 0) {
                                    if (z) {
                                        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                    }
                                    arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                    arrayList4.add(c3115b);
                                    c3115b.f11239c = true;
                                    i2 = i + 1;
                                    action = str;
                                    arrayList3 = arrayList2;
                                    resolveTypeIfNeeded = str2;
                                } else if (z) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : CcgConstant.f38549t : "category"));
                                }
                            }
                            arrayList4 = arrayList;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        }
                        ArrayList arrayList5 = arrayList4;
                        if (arrayList5 != null) {
                            for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                                ((C3115b) arrayList5.get(i3)).f11239c = false;
                            }
                            this.f11232d.add(new C3114a(intent, arrayList5));
                            if (!this.f11233e.hasMessages(1)) {
                                this.f11233e.sendEmptyMessage(1);
                            }
                            return true;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m48502a() {
        int size;
        C3114a[] c3114aArr;
        while (true) {
            synchronized (this.f11230b) {
                size = this.f11232d.size();
                if (size <= 0) {
                    return;
                }
                c3114aArr = new C3114a[size];
                this.f11232d.toArray(c3114aArr);
                this.f11232d.clear();
            }
            for (int i = 0; i < size; i++) {
                C3114a c3114a = c3114aArr[i];
                int size2 = c3114a.f11236b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    C3115b c3115b = c3114a.f11236b.get(i2);
                    if (!c3115b.f11240d) {
                        c3115b.f11238b.onReceive(this.f11229a, c3114a.f11235a);
                    }
                }
            }
        }
    }
}
