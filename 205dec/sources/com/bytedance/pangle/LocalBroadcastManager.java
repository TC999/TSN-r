package com.bytedance.pangle;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.pangle.receiver.PluginBroadcastReceiver;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<b>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<b>> mActions = new HashMap<>();
    private final ArrayList<a> mPendingBroadcasts = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f28605a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<b> f28606b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.f28605a = intent;
            this.f28606b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f28607a;

        /* renamed from: b  reason: collision with root package name */
        final PluginBroadcastReceiver f28608b;

        /* renamed from: c  reason: collision with root package name */
        boolean f28609c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28610d;

        b(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.f28607a = intentFilter;
            this.f28608b = pluginBroadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f28608b);
            sb.append(" filter=");
            sb.append(this.f28607a);
            if (this.f28610d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.bytedance.pangle.LocalBroadcastManager.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    final void executePendingBroadcasts() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.mPendingBroadcasts.toArray(aVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = aVarArr[i4];
                int size2 = aVar.f28606b.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    b bVar = aVar.f28606b.get(i5);
                    if (!bVar.f28610d) {
                        bVar.f28608b.onReceive(this.mAppContext, aVar.f28605a);
                    }
                }
            }
        }
    }

    public final void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            b bVar = new b(intentFilter, pluginBroadcastReceiver);
            ArrayList<b> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i4 = 0; i4 < intentFilter.countActions(); i4++) {
                String action = intentFilter.getAction(i4);
                ArrayList<b> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final boolean sendBroadcast(Intent intent) {
        int i4;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z3 = (intent.getFlags() & 8) != 0;
            if (z3) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z3) {
                    Log.v("LocalBroadcastManager", "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i5 = 0;
                while (i5 < arrayList3.size()) {
                    b bVar = arrayList3.get(i5);
                    if (z3) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + bVar.f28607a);
                    }
                    if (bVar.f28609c) {
                        if (z3) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i4 = i5;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i4 = i5;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = bVar.f28607a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z3) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.f28609c = true;
                            i5 = i4 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z3) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                        }
                    }
                    arrayList4 = arrayList;
                    i5 = i4 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i6 = 0; i6 < arrayList5.size(); i6++) {
                        ((b) arrayList5.get(i6)).f28609c = false;
                    }
                    this.mPendingBroadcasts.add(new a(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public final void unregisterReceiver(PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList<b> remove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                b bVar = remove.get(size);
                bVar.f28610d = true;
                for (int i4 = 0; i4 < bVar.f28607a.countActions(); i4++) {
                    String action = bVar.f28607a.getAction(i4);
                    ArrayList<b> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.f28608b == pluginBroadcastReceiver) {
                                bVar2.f28610d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
