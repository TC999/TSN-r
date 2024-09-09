package com.beizi.fusion.g;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LocalBroadcastManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class ae {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f14745f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private static ae f14746g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f14747a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<b>> f14748b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, ArrayList<b>> f14749c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f14750d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f14751e;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f14753a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<b> f14754b;

        a(Intent intent, ArrayList<b> arrayList) {
            this.f14753a = intent;
            this.f14754b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final IntentFilter f14755a;

        /* renamed from: b  reason: collision with root package name */
        final BroadcastReceiver f14756b;

        /* renamed from: c  reason: collision with root package name */
        boolean f14757c;

        /* renamed from: d  reason: collision with root package name */
        boolean f14758d;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f14755a = intentFilter;
            this.f14756b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f14756b);
            sb.append(" filter=");
            sb.append(this.f14755a);
            if (this.f14758d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private ae(Context context) {
        this.f14747a = context;
        this.f14751e = new Handler(context.getMainLooper()) { // from class: com.beizi.fusion.g.ae.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    ae.this.a();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    @NonNull
    public static ae a(@NonNull Context context) {
        ae aeVar;
        synchronized (f14745f) {
            if (f14746g == null) {
                f14746g = new ae(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            aeVar = f14746g;
        }
        return aeVar;
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        synchronized (this.f14748b) {
            try {
                b bVar = new b(intentFilter, broadcastReceiver);
                ArrayList<b> arrayList = this.f14748b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.f14748b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(bVar);
                for (int i4 = 0; i4 < intentFilter.countActions(); i4++) {
                    String action = intentFilter.getAction(i4);
                    ArrayList<b> arrayList2 = this.f14749c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.f14749c.put(action, arrayList2);
                    }
                    arrayList2.add(bVar);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void a(@NonNull BroadcastReceiver broadcastReceiver) {
        ArrayList<b> remove;
        synchronized (this.f14748b) {
            try {
                remove = this.f14748b.remove(broadcastReceiver);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                b bVar = remove.get(size);
                bVar.f14758d = true;
                for (int i4 = 0; i4 < bVar.f14755a.countActions(); i4++) {
                    String action = bVar.f14755a.getAction(i4);
                    ArrayList<b> arrayList = this.f14749c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.f14756b == broadcastReceiver) {
                                bVar2.f14758d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f14749c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a(@NonNull Intent intent) {
        int i4;
        String str;
        ArrayList arrayList;
        ArrayList<b> arrayList2;
        String str2;
        synchronized (this.f14748b) {
            try {
                try {
                    String action = intent.getAction();
                    String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f14747a.getContentResolver());
                    Uri data = intent.getData();
                    String scheme = intent.getScheme();
                    Set<String> categories = intent.getCategories();
                    boolean z3 = (intent.getFlags() & 8) != 0;
                    if (z3) {
                        Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                    }
                    ArrayList<b> arrayList3 = this.f14749c.get(intent.getAction());
                    if (arrayList3 != null) {
                        if (z3) {
                            Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                        }
                        ArrayList arrayList4 = null;
                        int i5 = 0;
                        while (i5 < arrayList3.size()) {
                            b bVar = arrayList3.get(i5);
                            if (z3) {
                                Log.v("LocalBroadcastManager", "Matching against filter " + bVar.f14755a);
                            }
                            if (bVar.f14757c) {
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
                                int match = bVar.f14755a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                                if (match >= 0) {
                                    if (z3) {
                                        Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                                    }
                                    arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                                    arrayList4.add(bVar);
                                    bVar.f14757c = true;
                                    i5 = i4 + 1;
                                    action = str;
                                    arrayList3 = arrayList2;
                                    resolveTypeIfNeeded = str2;
                                } else if (z3) {
                                    Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
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
                                ((b) arrayList5.get(i6)).f14757c = false;
                            }
                            this.f14750d.add(new a(intent, arrayList5));
                            if (!this.f14751e.hasMessages(1)) {
                                this.f14751e.sendEmptyMessage(1);
                            }
                            return true;
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int size;
        a[] aVarArr;
        while (true) {
            synchronized (this.f14748b) {
                size = this.f14750d.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new a[size];
                this.f14750d.toArray(aVarArr);
                this.f14750d.clear();
            }
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = aVarArr[i4];
                int size2 = aVar.f14754b.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    b bVar = aVar.f14754b.get(i5);
                    if (!bVar.f14758d) {
                        bVar.f14756b.onReceive(this.f14747a, aVar.f14753a);
                    }
                }
            }
        }
    }
}
