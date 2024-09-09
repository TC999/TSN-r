package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Utility.java */
/* renamed from: com.amap.api.col.3l.z0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class z0 {
    public static long a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getFreeBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    public static long b(File file) {
        long length;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j4 = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = b(file2);
            } else {
                length = file2.length();
            }
            j4 += length;
        }
        return j4;
    }

    private static OfflineMapProvince c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(e(jSONObject, "url"));
        offlineMapProvince.setProvinceName(e(jSONObject, "name"));
        offlineMapProvince.setJianpin(e(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(e(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(o(e(jSONObject, "adcode")));
        offlineMapProvince.setVersion(e(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(e(jSONObject, "size")));
        offlineMapProvince.setCityList(j(jSONObject));
        return offlineMapProvince;
    }

    public static String d(Context context, String str) {
        try {
            return a3.x(new GZIPInputStream(u2.b(context).open(str)));
        } catch (Throwable th) {
            u5.p(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    private static String e(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    public static List<OfflineMapProvince> f(String str, Context context) throws JSONException {
        if (str != null && !"".equals(str)) {
            return g(new JSONObject(str), context);
        }
        return new ArrayList();
    }

    public static List<OfflineMapProvince> g(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                p(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject("result");
            } catch (JSONException e4) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("result");
                u5.p(e4, "Utility", "parseJson");
                e4.printStackTrace();
                optJSONObject = optJSONObject3;
            }
        } else {
            optJSONObject = jSONObject.optJSONObject("result");
        }
        if (optJSONObject != null) {
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject4 == null) {
                return arrayList;
            }
            optJSONObject2 = optJSONObject4.optJSONObject("offlinemapinfo_with_province");
        } else {
            optJSONObject2 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (optJSONObject2 == null) {
            return arrayList;
        }
        if (optJSONObject2.has("version")) {
            b0.f7177r = e(optJSONObject2, "version");
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i4);
            if (optJSONObject5 != null) {
                arrayList.add(c(optJSONObject5));
            }
        }
        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
        JSONObject jSONObject3 = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            jSONObject3 = optJSONArray2.getJSONObject(0);
        }
        if (jSONObject3 == null) {
            return arrayList;
        }
        arrayList.add(c(jSONObject3));
        return arrayList;
    }

    public static void h(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    String[] list = file2.list();
                    if (list == null) {
                        file2.delete();
                    } else if (list.length == 0) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static String i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.substring(str.lastIndexOf(TTPathConst.sSeparator) + 1, str.indexOf(".zip"));
        } catch (Throwable th) {
            u5.p(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    private static ArrayList<OfflineMapCity> j(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(m(jSONObject));
        }
        for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject != null) {
                arrayList.add(m(optJSONObject));
            }
        }
        return arrayList;
    }

    public static void k(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(a3.f0(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.exists() && file.getName().contains(str)) {
                l(file);
            }
        }
        h(a3.f0(context));
    }

    public static boolean l(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i4 = 0; i4 < listFiles.length; i4++) {
                if (listFiles[i4].isFile()) {
                    if (!listFiles[i4].delete()) {
                        return false;
                    }
                } else if (!l(listFiles[i4])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static OfflineMapCity m(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(o(e(jSONObject, "adcode")));
        offlineMapCity.setUrl(e(jSONObject, "url"));
        offlineMapCity.setCity(e(jSONObject, "name"));
        offlineMapCity.setCode(e(jSONObject, "citycode"));
        offlineMapCity.setPinyin(e(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(e(jSONObject, "jianpin"));
        offlineMapCity.setVersion(e(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(e(jSONObject, "size")));
        return offlineMapCity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static String n(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        ?? r22 = 0;
        r22 = 0;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (FileNotFoundException e4) {
                                e = e4;
                                u5.p(e, "MapDownloadManager", "readOfflineSD filenotfound");
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (IOException e6) {
                                e = e6;
                                u5.p(e, "MapDownloadManager", "readOfflineSD io");
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                        return stringBuffer2;
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        bufferedReader = null;
                    } catch (IOException e11) {
                        e = e11;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r22 != 0) {
                            try {
                                r22.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                    bufferedReader = null;
                    fileInputStream = null;
                } catch (IOException e15) {
                    e = e15;
                    bufferedReader = null;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                r22 = file;
            }
        } catch (IOException e16) {
            e16.printStackTrace();
        }
    }

    private static String o(String str) {
        return "000001".equals(str) ? "100000" : str;
    }

    public static void p(String str, Context context) {
        if ("".equals(a3.f0(context))) {
            return;
        }
        File file = new File(a3.f0(context) + "offlinemapv4.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e4) {
                u5.p(e4, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
                e4.printStackTrace();
            }
        }
        if (a() <= 1048576) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes("utf-8"));
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    fileOutputStream = fileOutputStream2;
                    u5.p(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                } catch (IOException e8) {
                    e = e8;
                    fileOutputStream = fileOutputStream2;
                    u5.p(e, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e11) {
                e = e11;
            } catch (IOException e12) {
                e = e12;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
