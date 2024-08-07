package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.umeng.socialize.net.dplus.CommonNetImpl;
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
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.z0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Utility {
    /* renamed from: a */
    public static long m53353a() {
        if (Environment.getExternalStorageState().equals("mounted")) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getFreeBlocks() * statFs.getBlockSize();
        }
        return 0L;
    }

    /* renamed from: b */
    public static long m53352b(File file) {
        long length;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = m53352b(file2);
            } else {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    /* renamed from: c */
    private static OfflineMapProvince m53351c(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(m53349e(jSONObject, "url"));
        offlineMapProvince.setProvinceName(m53349e(jSONObject, "name"));
        offlineMapProvince.setJianpin(m53349e(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(m53349e(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(m53339o(m53349e(jSONObject, "adcode")));
        offlineMapProvince.setVersion(m53349e(jSONObject, ConstantHelper.LOG_VS));
        offlineMapProvince.setSize(Long.parseLong(m53349e(jSONObject, "size")));
        offlineMapProvince.setCityList(m53344j(jSONObject));
        return offlineMapProvince;
    }

    /* renamed from: d */
    public static String m53350d(Context context, String str) {
        try {
            return C1732a3.m55686x(new GZIPInputStream(ResourcesUtil.m53805b(context).open(str)));
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    private static String m53349e(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    /* renamed from: f */
    public static List<OfflineMapProvince> m53348f(String str, Context context) throws JSONException {
        if (str != null && !"".equals(str)) {
            return m53347g(new JSONObject(str), context);
        }
        return new ArrayList();
    }

    /* renamed from: g */
    public static List<OfflineMapProvince> m53347g(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has(CommonNetImpl.RESULT)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(CommonNetImpl.RESULT, new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                m53338p(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject(CommonNetImpl.RESULT);
            } catch (JSONException e) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject(CommonNetImpl.RESULT);
                SDKLogHandler.m53863p(e, "Utility", "parseJson");
                e.printStackTrace();
                optJSONObject = optJSONObject3;
            }
        } else {
            optJSONObject = jSONObject.optJSONObject(CommonNetImpl.RESULT);
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
        if (optJSONObject2.has(ConstantHelper.LOG_VS)) {
            OfflineDownloadManager.f3616r = m53349e(optJSONObject2, ConstantHelper.LOG_VS);
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i);
            if (optJSONObject5 != null) {
                arrayList.add(m53351c(optJSONObject5));
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
        arrayList.add(m53351c(jSONObject3));
        return arrayList;
    }

    /* renamed from: h */
    public static void m53346h(String str) {
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

    /* renamed from: i */
    public static String m53345i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.substring(str.lastIndexOf("/") + 1, str.indexOf(".zip"));
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    /* renamed from: j */
    private static ArrayList<OfflineMapCity> m53344j(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(m53341m(jSONObject));
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m53341m(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: k */
    public static void m53343k(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(C1732a3.m55707f0(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.exists() && file.getName().contains(str)) {
                m53342l(file);
            }
        }
        m53346h(C1732a3.m55707f0(context));
    }

    /* renamed from: l */
    public static boolean m53342l(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!m53342l(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    /* renamed from: m */
    private static OfflineMapCity m53341m(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(m53339o(m53349e(jSONObject, "adcode")));
        offlineMapCity.setUrl(m53349e(jSONObject, "url"));
        offlineMapCity.setCity(m53349e(jSONObject, "name"));
        offlineMapCity.setCode(m53349e(jSONObject, "citycode"));
        offlineMapCity.setPinyin(m53349e(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(m53349e(jSONObject, "jianpin"));
        offlineMapCity.setVersion(m53349e(jSONObject, ConstantHelper.LOG_VS));
        offlineMapCity.setSize(Long.parseLong(m53349e(jSONObject, "size")));
        return offlineMapCity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* renamed from: n */
    public static String m53340n(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        ?? r2 = 0;
        r2 = 0;
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
                            } catch (FileNotFoundException e) {
                                e = e;
                                SDKLogHandler.m53863p(e, "MapDownloadManager", "readOfflineSD filenotfound");
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (IOException e3) {
                                e = e3;
                                SDKLogHandler.m53863p(e, "MapDownloadManager", "readOfflineSD io");
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
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
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                        return stringBuffer2;
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        bufferedReader = null;
                    } catch (IOException e8) {
                        e = e8;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e9) {
                                e9.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    bufferedReader = null;
                    fileInputStream = null;
                } catch (IOException e12) {
                    e = e12;
                    bufferedReader = null;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                r2 = file;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
    }

    /* renamed from: o */
    private static String m53339o(String str) {
        return "000001".equals(str) ? "100000" : str;
    }

    /* renamed from: p */
    public static void m53338p(String str, Context context) {
        if ("".equals(C1732a3.m55707f0(context))) {
            return;
        }
        File file = new File(C1732a3.m55707f0(context) + "offlinemapv4.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                SDKLogHandler.m53863p(e, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
                e.printStackTrace();
            }
        }
        if (m53353a() <= 1048576) {
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
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    SDKLogHandler.m53863p(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileOutputStream = fileOutputStream2;
                    SDKLogHandler.m53863p(e, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
