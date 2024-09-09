package com.iab.omid.library.mmadbridge.walking;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.mmadbridge.adsession.h;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<View, String> f37778a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<View, a> f37779b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, View> f37780c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<View> f37781d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<String> f37782e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashSet<String> f37783f = new HashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<String, String> f37784g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final Map<View, Boolean> f37785h = new WeakHashMap();

    /* renamed from: i  reason: collision with root package name */
    private boolean f37786i;

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.iab.omid.library.mmadbridge.b.c f37787a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<String> f37788b = new ArrayList<>();

        public a(com.iab.omid.library.mmadbridge.b.c cVar, String str) {
            this.f37787a = cVar;
            b(str);
        }

        public com.iab.omid.library.mmadbridge.b.c a() {
            return this.f37787a;
        }

        public void b(String str) {
            this.f37788b.add(str);
        }

        public ArrayList<String> c() {
            return this.f37788b;
        }
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public abstract class AbstractAsyncTaskC0550b extends c {

        /* renamed from: c  reason: collision with root package name */
        protected final HashSet<String> f37789c;

        /* renamed from: d  reason: collision with root package name */
        protected final JSONObject f37790d;

        /* renamed from: e  reason: collision with root package name */
        protected final long f37791e;

        public AbstractAsyncTaskC0550b(c.InterfaceC0551b interfaceC0551b, HashSet<String> hashSet, JSONObject jSONObject, long j4) {
            super(interfaceC0551b);
            this.f37789c = new HashSet<>(hashSet);
            this.f37790d = jSONObject;
            this.f37791e = j4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public abstract class c extends AsyncTask<Object, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        private a f37792a;

        /* renamed from: b  reason: collision with root package name */
        protected final InterfaceC0551b f37793b;

        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public interface a {
            void a(c cVar);
        }

        /* renamed from: com.iab.omid.library.mmadbridge.walking.b$c$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6520572.dex */
        public interface InterfaceC0551b {
            void a(JSONObject jSONObject);

            JSONObject b();
        }

        public c(InterfaceC0551b interfaceC0551b) {
            this.f37793b = interfaceC0551b;
        }

        public void a(a aVar) {
            this.f37792a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            a aVar = this.f37792a;
            if (aVar != null) {
                aVar.a(this);
            }
        }

        public void c(ThreadPoolExecutor threadPoolExecutor) {
            executeOnExecutor(threadPoolExecutor, new Object[0]);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class d implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final BlockingQueue<Runnable> f37794a;

        /* renamed from: b  reason: collision with root package name */
        private final ThreadPoolExecutor f37795b;

        /* renamed from: c  reason: collision with root package name */
        private final ArrayDeque<c> f37796c = new ArrayDeque<>();

        /* renamed from: d  reason: collision with root package name */
        private c f37797d = null;

        public d() {
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            this.f37794a = linkedBlockingQueue;
            this.f37795b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
        }

        private void b() {
            c poll = this.f37796c.poll();
            this.f37797d = poll;
            if (poll != null) {
                poll.c(this.f37795b);
            }
        }

        @Override // com.iab.omid.library.mmadbridge.walking.b.c.a
        public void a(c cVar) {
            this.f37797d = null;
            b();
        }

        public void c(c cVar) {
            cVar.a(this);
            this.f37796c.add(cVar);
            if (this.f37797d == null) {
                b();
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class e extends c {
        public e(c.InterfaceC0551b interfaceC0551b) {
            super(interfaceC0551b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            this.f37793b.a(null);
            return null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class f extends AbstractAsyncTaskC0550b {
        public f(c.InterfaceC0551b interfaceC0551b, HashSet<String> hashSet, JSONObject jSONObject, long j4) {
            super(interfaceC0551b, hashSet, jSONObject, j4);
        }

        private void e(String str) {
            com.iab.omid.library.mmadbridge.b.a a4 = com.iab.omid.library.mmadbridge.b.a.a();
            if (a4 != null) {
                for (h hVar : a4.c()) {
                    if (this.f37789c.contains(hVar.e())) {
                        hVar.f().p(str, this.f37791e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.iab.omid.library.mmadbridge.walking.b.c, android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            e(str);
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            return this.f37790d.toString();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public class g extends AbstractAsyncTaskC0550b {
        public g(c.InterfaceC0551b interfaceC0551b, HashSet<String> hashSet, JSONObject jSONObject, long j4) {
            super(interfaceC0551b, hashSet, jSONObject, j4);
        }

        private void e(String str) {
            com.iab.omid.library.mmadbridge.b.a a4 = com.iab.omid.library.mmadbridge.b.a.a();
            if (a4 != null) {
                for (h hVar : a4.c()) {
                    if (this.f37789c.contains(hVar.e())) {
                        hVar.f().k(str, this.f37791e);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.iab.omid.library.mmadbridge.walking.b.c, android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(String str) {
            if (!TextUtils.isEmpty(str)) {
                e(str);
            }
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d */
        public String doInBackground(Object... objArr) {
            if (com.iab.omid.library.mmadbridge.d.b.m(this.f37790d, this.f37793b.b())) {
                return null;
            }
            this.f37793b.a(this.f37790d);
            return this.f37790d.toString();
        }
    }

    private void d(h hVar) {
        for (com.iab.omid.library.mmadbridge.b.c cVar : hVar.m()) {
            e(cVar, hVar);
        }
    }

    private void e(com.iab.omid.library.mmadbridge.b.c cVar, h hVar) {
        View view = cVar.a().get();
        if (view == null) {
            return;
        }
        a aVar = this.f37779b.get(view);
        if (aVar != null) {
            aVar.b(hVar.e());
        } else {
            this.f37779b.put(view, new a(cVar, hVar.e()));
        }
    }

    private String m(View view) {
        if (Build.VERSION.SDK_INT < 19 || view.isAttachedToWindow()) {
            if (o(view).booleanValue()) {
                return "noWindowFocus";
            }
            HashSet hashSet = new HashSet();
            while (view != null) {
                String e4 = com.iab.omid.library.mmadbridge.d.f.e(view);
                if (e4 != null) {
                    return e4;
                }
                hashSet.add(view);
                ViewParent parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            this.f37781d.addAll(hashSet);
            return null;
        }
        return "notAttached";
    }

    private Boolean o(View view) {
        if (view.hasWindowFocus()) {
            this.f37785h.remove(view);
            return Boolean.FALSE;
        } else if (this.f37785h.containsKey(view)) {
            return this.f37785h.get(view);
        } else {
            Map<View, Boolean> map = this.f37785h;
            Boolean bool = Boolean.FALSE;
            map.put(view, bool);
            return bool;
        }
    }

    public String a(View view) {
        if (this.f37778a.size() == 0) {
            return null;
        }
        String str = this.f37778a.get(view);
        if (str != null) {
            this.f37778a.remove(view);
        }
        return str;
    }

    public String b(String str) {
        return this.f37784g.get(str);
    }

    public HashSet<String> c() {
        return this.f37782e;
    }

    public View f(String str) {
        return this.f37780c.get(str);
    }

    public a g(View view) {
        a aVar = this.f37779b.get(view);
        if (aVar != null) {
            this.f37779b.remove(view);
        }
        return aVar;
    }

    public HashSet<String> h() {
        return this.f37783f;
    }

    public com.iab.omid.library.mmadbridge.walking.c i(View view) {
        return this.f37781d.contains(view) ? com.iab.omid.library.mmadbridge.walking.c.PARENT_VIEW : this.f37786i ? com.iab.omid.library.mmadbridge.walking.c.OBSTRUCTION_VIEW : com.iab.omid.library.mmadbridge.walking.c.UNDERLYING_VIEW;
    }

    public void j() {
        com.iab.omid.library.mmadbridge.b.a a4 = com.iab.omid.library.mmadbridge.b.a.a();
        if (a4 != null) {
            for (h hVar : a4.e()) {
                View w3 = hVar.w();
                if (hVar.x()) {
                    String e4 = hVar.e();
                    if (w3 != null) {
                        String m4 = m(w3);
                        if (m4 == null) {
                            this.f37782e.add(e4);
                            this.f37778a.put(w3, e4);
                            d(hVar);
                        } else if (m4 != "noWindowFocus") {
                            this.f37783f.add(e4);
                            this.f37780c.put(e4, w3);
                            this.f37784g.put(e4, m4);
                        }
                    } else {
                        this.f37783f.add(e4);
                        this.f37784g.put(e4, "noAdView");
                    }
                }
            }
        }
    }

    public void k() {
        this.f37778a.clear();
        this.f37779b.clear();
        this.f37780c.clear();
        this.f37781d.clear();
        this.f37782e.clear();
        this.f37783f.clear();
        this.f37784g.clear();
        this.f37786i = false;
    }

    public boolean l(View view) {
        if (this.f37785h.containsKey(view)) {
            this.f37785h.put(view, Boolean.TRUE);
            return false;
        }
        return true;
    }

    public void n() {
        this.f37786i = true;
    }
}
