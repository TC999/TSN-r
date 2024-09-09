package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {
    public static cn.jpush.android.d.d a(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2;
        boolean z3;
        try {
            String str3 = dVar.bh;
            if (TextUtils.isEmpty(str3)) {
                str3 = cn.jpush.android.ad.a.d(dVar.bi);
            }
            String str4 = str3;
            String str5 = dVar.f4127d;
            LinkedHashMap<String, cn.jpush.android.t.b> a4 = a(context);
            cn.jpush.android.t.b bVar = a4.get(str4);
            str = "";
            if (bVar != null) {
                str2 = bVar.f4369b;
                if (cn.jpush.android.ad.c.a(str2)) {
                    dVar.bd = "file://" + str2;
                    bVar.f4370c = System.currentTimeMillis();
                    Logger.d("InAppTplHelper", "use cache template, templateId: " + str4 + ", webPagePath: " + str2 + ", totalTemplateCount: " + a4.values().size() + ", update template file time: " + new File(str2).setLastModified(bVar.f4370c));
                } else {
                    a4.remove(str4);
                    Logger.d("InAppTplHelper", "local config has template path, but the template file is not exist, will download again.");
                    str2 = "";
                }
                a(context, a4);
            } else {
                str2 = "";
            }
            String str6 = dVar.bi;
            if (TextUtils.isEmpty(str2)) {
                Logger.d("InAppTplHelper", "no local template cache, start download template, url: " + str6);
                if (TextUtils.isEmpty(str6)) {
                    Logger.w("InAppTplHelper", "template url is Empty! Give up to download!");
                    z3 = false;
                } else {
                    String a5 = cn.jpush.android.w.b.a(context, str6, "inapp_tpl", 5, 5000L);
                    boolean isEmpty = TextUtils.isEmpty(a5);
                    str = isEmpty ? "" : a5;
                    z3 = !isEmpty;
                }
                if (!z3) {
                    Logger.w("InAppTplHelper", "NOTE: failed to download html page. Give up this.");
                    return null;
                }
                String str7 = cn.jpush.android.ad.c.a(context, "h5_tpls", 20) + str4 + ".html";
                Logger.d("InAppTplHelper", "download template success, will save to local of path: " + str7);
                if (cn.jpush.android.ad.c.b(str7, str)) {
                    dVar.bd = "file://" + str7;
                    Logger.d("InAppTplHelper", "cache h5 template to local success, templateId: " + str4 + ", path: " + dVar.bd);
                    a4.put(str4, cn.jpush.android.t.b.a(str4, str7, System.currentTimeMillis()));
                    a(context, a4);
                } else {
                    dVar.bd = dVar.bi;
                }
            }
            if (dVar.bm.size() > 0) {
                Logger.d("InAppTplHelper", "template has image resource, start download image to local, images: " + dVar.bm.toString());
                ArrayList<String> a6 = a(dVar.bm, context, str6.substring(0, str6.lastIndexOf(TTPathConst.sSeparator) + 1), str5);
                if (a6 == null) {
                    Logger.w("InAppTplHelper", "Load notify in-app message image resources failed, give up this in app!");
                    return null;
                }
                Logger.d("InAppTplHelper", "Load notify in-app message image succeed, webView will open cache!");
                JSONObject jSONObject = new JSONObject(dVar.bk);
                int i4 = 0;
                while (i4 < a6.size()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("in_pic_path");
                    int i5 = i4 + 1;
                    sb.append(i5);
                    jSONObject.put(sb.toString(), a6.get(i4));
                    i4 = i5;
                }
                dVar.bk = jSONObject.toString();
                Logger.d("InAppTplHelper", "http image resources replace local path, new templateData: " + dVar.bk);
            } else {
                Logger.d("InAppTplHelper", "template no image resource.");
            }
        } catch (Throwable unused) {
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0067 A[Catch: all -> 0x00b9, TryCatch #2 {all -> 0x00d5, blocks: (B:3:0x0002, B:20:0x00c0, B:5:0x0010, B:7:0x002d, B:12:0x003c, B:14:0x0067, B:16:0x009c, B:11:0x0038), top: B:26:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009c A[Catch: all -> 0x00b9, TRY_LEAVE, TryCatch #2 {all -> 0x00d5, blocks: (B:3:0x0002, B:20:0x00c0, B:5:0x0010, B:7:0x002d, B:12:0x003c, B:14:0x0067, B:16:0x009c, B:11:0x0038), top: B:26:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "InAppTplHelper"
            java.lang.String r3 = "inapp_image"
            r4 = 3
            r5 = 3145728(0x300000, float:4.408104E-39)
            r6 = 1
            r1 = r7
            r2 = r8
            byte[] r1 = cn.jpush.android.w.b.a(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> Ld5
            if (r1 == 0) goto Lc0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r2.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r3 = "download image resource success, path: "
            r2.append(r3)     // Catch: java.lang.Throwable -> Lb9
            r2.append(r8)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb9
            cn.jpush.android.helper.Logger.d(r0, r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r2 = "http://"
            boolean r2 = r8.startsWith(r2)     // Catch: java.lang.Throwable -> Lb9
            r3 = 1
            if (r2 != 0) goto L38
            java.lang.String r2 = "https://"
            boolean r2 = r8.startsWith(r2)     // Catch: java.lang.Throwable -> Lb9
            if (r2 == 0) goto L36
            goto L38
        L36:
            r2 = r8
            goto L3c
        L38:
            java.lang.String r2 = cn.jpush.android.ad.c.a(r8, r3)     // Catch: java.lang.Throwable -> Lb9
        L3c:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r4.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r5.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r6 = "j_in_app_"
            r5.append(r6)     // Catch: java.lang.Throwable -> Lb9
            r5.append(r9)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r9 = r5.toString()     // Catch: java.lang.Throwable -> Lb9
            r5 = 0
            java.lang.String r7 = cn.jpush.android.ad.c.a(r7, r9, r5, r3)     // Catch: java.lang.Throwable -> Lb9
            r4.append(r7)     // Catch: java.lang.Throwable -> Lb9
            r4.append(r2)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> Lb9
            boolean r9 = cn.jpush.android.ad.c.a(r7, r1)     // Catch: java.lang.Throwable -> Lb9
            if (r9 == 0) goto L9c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r9.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r1 = "download image resource cache to local success, path: "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lb9
            r9.append(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb9
            cn.jpush.android.helper.Logger.d(r0, r9)     // Catch: java.lang.Throwable -> Lb9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r9.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r1 = "download image resource cache to local success, Uri.fromFile: "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lb9
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> Lb9
            r1.<init>(r2)     // Catch: java.lang.Throwable -> Lb9
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch: java.lang.Throwable -> Lb9
            r9.append(r1)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lb9
            cn.jpush.android.helper.Logger.d(r0, r9)     // Catch: java.lang.Throwable -> Lb9
            cn.jpush.android.ad.e.a(r7, r8)     // Catch: java.lang.Throwable -> Lb9
            return r7
        L9c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb9
            r8.<init>()     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r1 = "Succeed to load image - "
            r8.append(r1)     // Catch: java.lang.Throwable -> Lb9
            r8.append(r7)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = ", cache local status: "
            r8.append(r7)     // Catch: java.lang.Throwable -> Lb9
            r8.append(r9)     // Catch: java.lang.Throwable -> Lb9
            java.lang.String r7 = r8.toString()     // Catch: java.lang.Throwable -> Lb9
            cn.jpush.android.helper.Logger.v(r0, r7)     // Catch: java.lang.Throwable -> Lb9
            goto Lee
        Lb9:
            r7 = move-exception
            java.lang.String r8 = "Write storage error,  create img file fail."
            cn.jpush.android.helper.Logger.ww(r0, r8, r7)     // Catch: java.lang.Throwable -> Ld5
            goto Lee
        Lc0:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r7.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r9 = "download image resource failed, path: "
            r7.append(r9)     // Catch: java.lang.Throwable -> Ld5
            r7.append(r8)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Ld5
            cn.jpush.android.helper.Logger.w(r0, r7)     // Catch: java.lang.Throwable -> Ld5
            goto Lee
        Ld5:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "load h5 template image resource failed, "
            r8.append(r9)
            java.lang.String r7 = r7.getMessage()
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            cn.jpush.android.helper.Logger.w(r0, r7)
        Lee:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.c.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    private static ArrayList<String> a(ArrayList<String> arrayList, Context context, String str, String str2) {
        return a(arrayList, context, str, str2, true);
    }

    private static ArrayList<String> a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z3) {
        String str3;
        String str4;
        ArrayList<String> arrayList2 = new ArrayList<>();
        Logger.v("InAppTplHelper", "action:loadH5TemplateImageResources - urlPrefix:" + str);
        boolean z4 = false;
        try {
            boolean z5 = true;
            if (!cn.jpush.android.ad.a.c(str) || context == null || arrayList.size() <= 0 || TextUtils.isEmpty(str2)) {
                z4 = true;
            } else {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isEmpty(next) || next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                        str3 = next;
                    } else {
                        str3 = str + next;
                    }
                    if (cn.jpush.android.ad.a.a(str3, false)) {
                        byte[] a4 = cn.jpush.android.w.b.a(context, str3, "h5_tpl", 3, 1048576);
                        if (a4 != null) {
                            Logger.d("InAppTplHelper", "download image resource success, path: " + next);
                            if (next.startsWith(JPushConstants.HTTP_PRE) || next.startsWith(JPushConstants.HTTPS_PRE)) {
                                next = cn.jpush.android.ad.c.a(next, false);
                            }
                            String str5 = cn.jpush.android.ad.c.a(context, "h5_noti_imgs", 0, z3) + next;
                            boolean a5 = cn.jpush.android.ad.c.a(str5, a4);
                            if (a5) {
                                arrayList2.add(str5);
                                Logger.d("InAppTplHelper", "download image resource cache to local success, path: " + str5);
                            }
                            Logger.v("InAppTplHelper", "Succeed to load image - " + str5 + ", cache local status: " + a5);
                        } else {
                            str4 = "download image resource failed, path: " + str3;
                        }
                    } else {
                        str4 = "image url " + str3 + " is not image url";
                    }
                    Logger.w("InAppTplHelper", str4);
                    z5 = false;
                }
                Logger.i("InAppTplHelper", "template image resource download completed. local image list: " + arrayList2.toString());
                z4 = z5;
            }
        } catch (Throwable th) {
            Logger.w("InAppTplHelper", "load h5 template image resource failed, " + th.getMessage());
        }
        if (z4) {
            return arrayList2;
        }
        return null;
    }

    private static LinkedHashMap<String, cn.jpush.android.t.b> a(Context context) {
        LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap = new LinkedHashMap<>();
        if (context == null) {
            Logger.w("InAppTplHelper", "readTemplateConfig context is null");
            return linkedHashMap;
        }
        try {
            File a4 = cn.jpush.android.ad.c.a(context, "tpl.cache");
            if (a4 != null && a4.exists()) {
                String c4 = cn.jpush.android.ad.c.c(a4);
                if (!TextUtils.isEmpty(c4)) {
                    JSONObject jSONObject = new JSONObject(c4);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.t.b a5 = cn.jpush.android.t.b.a(jSONObject.getJSONObject(keys.next()));
                        if (a5 != null) {
                            linkedHashMap.put(a5.f4368a, a5);
                        }
                    }
                }
            }
        } finally {
            try {
                return linkedHashMap;
            } finally {
            }
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static LinkedHashMap<String, cn.jpush.android.t.b> a(LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap) {
        LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap2 = new LinkedHashMap<>();
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, cn.jpush.android.t.b>>() { // from class: cn.jpush.android.r.c.1
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(Map.Entry<String, cn.jpush.android.t.b> entry, Map.Entry<String, cn.jpush.android.t.b> entry2) {
                    if (entry2.getValue().f4370c > entry.getValue().f4370c) {
                        return 1;
                    }
                    return entry2.getValue().f4370c < entry.getValue().f4370c ? -1 : 0;
                }
            });
            for (Map.Entry entry : arrayList) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th) {
            Logger.w("InAppTplHelper", "sortHashMap failed, " + th.getMessage());
        }
        return linkedHashMap2;
    }

    private static void a(Context context, LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap) {
        try {
            File a4 = cn.jpush.android.ad.c.a(context, "tpl.cache");
            if (a4 == null) {
                Logger.w("InAppTplHelper", "saveTemplateConfig file is null");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (linkedHashMap.size() > 20) {
                linkedHashMap = a(linkedHashMap);
            }
            int i4 = 0;
            for (Map.Entry<String, cn.jpush.android.t.b> entry : linkedHashMap.entrySet()) {
                cn.jpush.android.t.b value = entry.getValue();
                if (i4 < 20) {
                    jSONObject.put(entry.getKey(), value.a());
                } else {
                    String str = value.f4369b;
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                        Logger.d("InAppTplHelper", "exceed max template cache count, delete old template file: " + str + ", maxCacheCount: 20");
                    }
                }
                i4++;
            }
            Logger.d("InAppTplHelper", "[saveTemplateConfig] template config info: " + jSONObject.toString() + ", templateSize: " + linkedHashMap.values().size());
            cn.jpush.android.ad.c.a(a4.getAbsolutePath(), jSONObject.toString());
        } catch (Throwable th) {
            Logger.w("InAppTplHelper", "saveTemplateConfig failed, " + th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a4 A[Catch: all -> 0x0119, TryCatch #0 {all -> 0x0119, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x002b, B:10:0x0045, B:12:0x004b, B:14:0x006b, B:16:0x0071, B:22:0x0090, B:24:0x0094, B:26:0x009a, B:28:0x00a4, B:30:0x00ae, B:32:0x00c8, B:34:0x00cf, B:36:0x00ef, B:38:0x00f5, B:43:0x0112, B:39:0x00fa, B:17:0x0076, B:19:0x007a), top: B:48:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112 A[Catch: all -> 0x0119, TRY_LEAVE, TryCatch #0 {all -> 0x0119, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x002b, B:10:0x0045, B:12:0x004b, B:14:0x006b, B:16:0x0071, B:22:0x0090, B:24:0x0094, B:26:0x009a, B:28:0x00a4, B:30:0x00ae, B:32:0x00c8, B:34:0x00cf, B:36:0x00ef, B:38:0x00f5, B:43:0x0112, B:39:0x00fa, B:17:0x0076, B:19:0x007a), top: B:48:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jpush.android.d.d b(android.content.Context r17, cn.jpush.android.d.d r18) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.c.b(android.content.Context, cn.jpush.android.d.d):cn.jpush.android.d.d");
    }

    private static void b(Context context, String str, String str2) {
        Logger.d("InAppTplHelper", "handleImage   downImage is null ");
        String a4 = cn.jpush.android.w.b.a(str);
        Logger.d("InAppTplHelper", "handleImage   downImage is null,errorCode= " + a4);
        if (!TextUtils.isEmpty(a4)) {
            Logger.d("InAppTplHelper", "downImage fail by network,so save it,wait network change good to show ");
            cn.jpush.android.w.b.b(str);
            return;
        }
        Logger.d("InAppTplHelper", "downImage fail by other reason\uff0cso delete message");
        cn.jpush.android.helper.c.a(context, str2, 3008L, 4);
        cn.jpush.android.p.b.a().c(str2);
    }
}
