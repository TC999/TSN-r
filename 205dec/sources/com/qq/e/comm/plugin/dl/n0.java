package com.qq.e.comm.plugin.dl;

import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.util.b1;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class n0 {

    /* renamed from: a  reason: collision with root package name */
    private final File f42491a = b1.i();

    /* renamed from: b  reason: collision with root package name */
    private final Map<com.qq.e.comm.plugin.b.g, Map<String, Integer>> f42492b = new HashMap(6);

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f42493c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends com.qq.e.comm.plugin.dl.a {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ File f42494f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(n0 n0Var, File file, String str, boolean z3, File file2) {
            super(file, str, z3);
            this.f42494f = file2;
        }

        @Override // com.qq.e.comm.plugin.dl.a
        public void a(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    b1.b(new File(this.f42494f, next), jSONObject.optString(next));
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.b.g f42495c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.g0.y f42496d;

        b(com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.g0.y yVar) {
            this.f42495c = gVar;
            this.f42496d = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] list;
            File a4 = n0.this.a(this.f42495c, false);
            String a5 = n0.this.a(this.f42496d, false);
            File file = new File(a4, a5);
            try {
                byte[] bytes = this.f42496d.n().getBytes(com.qq.e.comm.plugin.k.a.f44515a);
                if (bytes != null && bytes.length != 0) {
                    b1.a(file, bytes);
                    if (file.length() == 0) {
                        n.a(this.f42495c, this.f42496d, 3, (Exception) null);
                        file.delete();
                        return;
                    } else if (bytes.length != file.length()) {
                        n.a(this.f42495c, this.f42496d, 4, (Exception) null);
                        file.delete();
                        return;
                    } else {
                        n.a(this.f42495c, this.f42496d, 0, (Exception) null);
                        String j4 = this.f42496d.j();
                        for (String str : a4.list()) {
                            if (str.startsWith(j4) && !a5.equals(str)) {
                                new File(a4, str).delete();
                            }
                        }
                        return;
                    }
                }
                n.a(this.f42495c, this.f42496d, 2, (Exception) null);
            } catch (Exception e4) {
                file.delete();
                int i4 = -1;
                if ((e4 instanceof IOException) && e4.getMessage().contains("No space left on device")) {
                    i4 = 1;
                }
                n.a(this.f42495c, this.f42496d, i4, e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c extends com.qq.e.comm.plugin.dl.a {
        c(File file, String str, boolean z3) {
            super(file, str, z3);
        }

        @Override // com.qq.e.comm.plugin.dl.a
        void a(JSONObject jSONObject) {
            n0.this.f42493c = jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n0() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(com.qq.e.comm.plugin.b.g gVar) {
        if (this.f42492b.get(gVar) != null) {
            n.a(gVar, 4);
            return;
        }
        String[] list = a(gVar, false).list();
        int length = list == null ? 0 : list.length;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(length);
        if (length > 0) {
            for (String str : list) {
                String[] split = str.split("_");
                try {
                    Integer valueOf = Integer.valueOf(split[1]);
                    Integer num = (Integer) concurrentHashMap.get(split[0]);
                    if (num == null || valueOf.intValue() > num.intValue()) {
                        concurrentHashMap.put(split[0], valueOf);
                    }
                } catch (Exception unused) {
                }
            }
        }
        this.f42492b.put(gVar, concurrentHashMap);
        JSONObject jSONObject = this.f42493c;
        if (jSONObject == null || jSONObject.length() <= 0) {
            return;
        }
        File a4 = a(gVar, true);
        new a(this, a4, this.f42493c.optString(String.valueOf(gVar.f42000e)), false, a4).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONArray a(com.qq.e.comm.plugin.b.g gVar) {
        Map<String, Integer> map;
        if (this.f42492b.size() > 0 && (map = this.f42492b.get(gVar)) != null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                com.qq.e.comm.plugin.util.j0 j0Var = new com.qq.e.comm.plugin.util.j0();
                j0Var.a("id", entry.getKey());
                j0Var.a("ver", entry.getValue());
                jSONArray.put(j0Var.a());
            }
            return jSONArray;
        }
        n.a(gVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009e, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.qq.e.comm.plugin.g0.y a(com.qq.e.comm.plugin.b.g r10, com.qq.e.comm.plugin.g0.y r11, boolean r12) {
        /*
            r9 = this;
            java.io.File r0 = new java.io.File
            java.io.File r1 = r9.a(r10, r12)
            java.lang.String r2 = r9.a(r11, r12)
            r0.<init>(r1, r2)
            boolean r1 = r0.exists()
            r2 = 0
            r3 = 10
            r4 = 0
            if (r1 == 0) goto L3d
            if (r12 != 0) goto L38
            long r5 = r0.length()
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 != 0) goto L38
            r0.delete()
            java.util.Map<com.qq.e.comm.plugin.b.g, java.util.Map<java.lang.String, java.lang.Integer>> r12 = r9.f42492b
            java.lang.Object r10 = r12.get(r10)
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r12 = r11.j()
            r10.remove(r12)
            r11.f43747j = r3
            return r4
        L38:
            java.lang.String r1 = com.qq.e.comm.plugin.util.b1.d(r0)
            goto L8a
        L3d:
            if (r12 != 0) goto L89
            java.util.Map<com.qq.e.comm.plugin.b.g, java.util.Map<java.lang.String, java.lang.Integer>> r12 = r9.f42492b
            java.lang.Object r12 = r12.get(r10)
            java.util.Map r12 = (java.util.Map) r12
            if (r12 != 0) goto L4e
            r10 = 14
            r11.f43747j = r10
            goto L87
        L4e:
            java.lang.String r0 = r11.j()
            java.lang.Object r12 = r12.get(r0)
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 != 0) goto L5f
            r10 = 13
            r11.f43747j = r10
            goto L87
        L5f:
            int r0 = r12.intValue()
            int r1 = r11.s()
            if (r0 != r1) goto L6e
            r10 = 15
            r11.f43747j = r10
            goto L87
        L6e:
            com.qq.e.comm.plugin.g0.y r0 = new com.qq.e.comm.plugin.g0.y
            java.lang.String r1 = r11.j()
            int r12 = r12.intValue()
            r0.<init>(r1, r12)
            com.qq.e.comm.plugin.g0.y r10 = r9.a(r10, r0, r2)
            if (r10 != 0) goto L88
            int r10 = r0.f43747j
            int r10 = r10 + 100
            r11.f43747j = r10
        L87:
            return r4
        L88:
            return r10
        L89:
            r1 = r4
        L8a:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto La3
            if (r12 == 0) goto La0
            java.lang.String r1 = r11.j()
            java.lang.String r1 = com.qq.e.comm.plugin.dl.k0.a(r10, r1)
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto La3
        La0:
            r11.f43747j = r3
            return r4
        La3:
            r3 = 5
            if (r12 != 0) goto Lc3
            char r2 = r1.charAt(r2)
            r6 = 123(0x7b, float:1.72E-43)
            if (r6 == r2) goto Lc3
            r0.delete()
            java.util.Map<com.qq.e.comm.plugin.b.g, java.util.Map<java.lang.String, java.lang.Integer>> r12 = r9.f42492b
            java.lang.Object r10 = r12.get(r10)
            java.util.Map r10 = (java.util.Map) r10
            java.lang.String r12 = r11.j()
            r10.remove(r12)
            r11.f43747j = r3
            return r4
        Lc3:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch: org.json.JSONException -> Lda
            r10.<init>(r1)     // Catch: org.json.JSONException -> Lda
            if (r12 == 0) goto Ld0
            if (r5 == 0) goto Lce
            r12 = 3
            goto Ld4
        Lce:
            r12 = 2
            goto Ld4
        Ld0:
            int r12 = r11.k()     // Catch: org.json.JSONException -> Lda
        Ld4:
            com.qq.e.comm.plugin.g0.y r0 = new com.qq.e.comm.plugin.g0.y     // Catch: org.json.JSONException -> Lda
            r0.<init>(r10, r12)     // Catch: org.json.JSONException -> Lda
            return r0
        Lda:
            r11.f43747j = r3
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.n0.a(com.qq.e.comm.plugin.b.g, com.qq.e.comm.plugin.g0.y, boolean):com.qq.e.comm.plugin.g0.y");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.g0.y yVar) {
        if (this.f42492b.size() <= 0) {
            n.a(gVar, 2);
            return true;
        }
        Map<String, Integer> map = this.f42492b.get(gVar);
        if (map != null && map.size() > 0) {
            Integer num = map.get(yVar.j());
            return num == null || yVar.s() > num.intValue();
        }
        n.a(gVar, 2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pair<Integer, JSONObject> a(com.qq.e.comm.plugin.b.g gVar, String str) {
        Map<String, Integer> map = this.f42492b.get(gVar);
        if (map == null) {
            return new Pair<>(14, null);
        }
        Integer num = map.get(str);
        if (num == null) {
            return new Pair<>(13, null);
        }
        File file = new File(a(gVar, false), a(str, num.intValue()));
        if (!file.exists()) {
            return new Pair<>(15, null);
        }
        String d4 = b1.d(file);
        if (TextUtils.isEmpty(d4)) {
            return new Pair<>(10, null);
        }
        try {
            return new Pair<>(0, new JSONObject(d4));
        } catch (JSONException unused) {
            return new Pair<>(5, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.qq.e.comm.plugin.g0.y a(com.qq.e.comm.plugin.b.g gVar, String str, boolean z3) {
        int i4;
        int i5;
        File file = new File(a(gVar, true), str);
        if (file.exists()) {
            if (file.length() != 0) {
                String d4 = b1.d(file);
                if (!TextUtils.isEmpty(d4)) {
                    if ('{' == d4.charAt(0)) {
                        try {
                            return new com.qq.e.comm.plugin.g0.y(new JSONObject(d4), 2);
                        } catch (JSONException unused) {
                            i4 = 5;
                        }
                    }
                    i4 = 5;
                }
            }
            i4 = 10;
        } else {
            i4 = z3 ? 13 : 0;
        }
        int i6 = i4 * 100;
        if (z3) {
            com.qq.e.comm.plugin.g0.y yVar = new com.qq.e.comm.plugin.g0.y(str);
            yVar.f43747j = i6;
            return yVar;
        }
        String a4 = k0.a(gVar, str);
        if (TextUtils.isEmpty(a4)) {
            i5 = i6 + 10;
        } else {
            if ('{' == a4.charAt(0)) {
                try {
                    return new com.qq.e.comm.plugin.g0.y(new JSONObject(a4), 3);
                } catch (JSONException unused2) {
                    i5 = i6 + 5;
                }
            }
            i5 = i6 + 5;
        }
        com.qq.e.comm.plugin.g0.y yVar2 = new com.qq.e.comm.plugin.g0.y(str);
        yVar2.f43747j = i5;
        return yVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.qq.e.comm.plugin.b.g gVar, com.qq.e.comm.plugin.g0.y yVar) {
        Map<String, Integer> map = this.f42492b.get(gVar);
        if (map == null) {
            n.a(gVar, 3);
            return;
        }
        Integer num = map.get(yVar.j());
        if (num == null || num.intValue() < yVar.s()) {
            map.put(yVar.j(), Integer.valueOf(yVar.s()));
            com.qq.e.comm.plugin.util.d0.f46407c.submit(new b(gVar, yVar));
        }
    }

    private void a() {
        new c(this.f42491a, com.qq.e.comm.plugin.d0.a.d().f().b("bpts", ""), true).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.qq.e.comm.plugin.g0.y yVar, boolean z3) {
        if (z3) {
            return yVar.j();
        }
        return yVar.j() + "_" + yVar.s();
    }

    private String a(String str, int i4) {
        return str + "_" + i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File a(com.qq.e.comm.plugin.b.g gVar, boolean z3) {
        File file = this.f42491a;
        StringBuilder sb = new StringBuilder();
        sb.append(gVar.f42000e);
        sb.append(z3 ? "_fb" : "_ol");
        return new File(file, sb.toString());
    }
}
