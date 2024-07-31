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
import com.umeng.ccg.CcgConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Keep
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<PluginBroadcastReceiver, ArrayList<C6055b>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<C6055b>> mActions = new HashMap<>();
    private final ArrayList<C6054a> mPendingBroadcasts = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.LocalBroadcastManager$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6054a {

        /* renamed from: a */
        final Intent f21836a;

        /* renamed from: b */
        final ArrayList<C6055b> f21837b;

        C6054a(Intent intent, ArrayList<C6055b> arrayList) {
            this.f21836a = intent;
            this.f21837b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.pangle.LocalBroadcastManager$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C6055b {

        /* renamed from: a */
        final IntentFilter f21838a;

        /* renamed from: b */
        final PluginBroadcastReceiver f21839b;

        /* renamed from: c */
        boolean f21840c;

        /* renamed from: d */
        boolean f21841d;

        C6055b(IntentFilter intentFilter, PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.f21838a = intentFilter;
            this.f21839b = pluginBroadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f21839b);
            sb.append(" filter=");
            sb.append(this.f21838a);
            if (this.f21841d) {
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
        C6054a[] c6054aArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                c6054aArr = new C6054a[size];
                this.mPendingBroadcasts.toArray(c6054aArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                C6054a c6054a = c6054aArr[i];
                int size2 = c6054a.f21837b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    C6055b c6055b = c6054a.f21837b.get(i2);
                    if (!c6055b.f21841d) {
                        c6055b.f21839b.onReceive(this.mAppContext, c6054a.f21836a);
                    }
                }
            }
        }
    }

    public final void registerReceiver(PluginBroadcastReceiver pluginBroadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            C6055b c6055b = new C6055b(intentFilter, pluginBroadcastReceiver);
            ArrayList<C6055b> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(c6055b);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C6055b> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(c6055b);
            }
        }
    }

    public final boolean sendBroadcast(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<C6055b> arrayList2;
        String str2;
        synchronized (this.mReceivers) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v(TAG, "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<C6055b> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v(TAG, "Action list: ".concat(String.valueOf(arrayList3)));
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    C6055b c6055b = arrayList3.get(i2);
                    if (z) {
                        Log.v(TAG, "Matching against filter " + c6055b.f21838a);
                    }
                    if (c6055b.f21840c) {
                        if (z) {
                            Log.v(TAG, "  Filter's target already added");
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
                        int match = c6055b.f21838a.match(action, resolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (match >= 0) {
                            if (z) {
                                Log.v(TAG, "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(c6055b);
                            c6055b.f21840c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v(TAG, "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : CcgConstant.f38549t : "category"));
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
                        ((C6055b) arrayList5.get(i3)).f21840c = false;
                    }
                    this.mPendingBroadcasts.add(new C6054a(intent, arrayList5));
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
            ArrayList<C6055b> remove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                C6055b c6055b = remove.get(size);
                c6055b.f21841d = true;
                for (int i = 0; i < c6055b.f21838a.countActions(); i++) {
                    String action = c6055b.f21838a.getAction(i);
                    ArrayList<C6055b> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            C6055b c6055b2 = arrayList.get(size2);
                            if (c6055b2.f21839b == pluginBroadcastReceiver) {
                                c6055b2.f21841d = true;
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
