package com.qq.e.comm.plugin.m.c;

import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.s0;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private static volatile JSONObject f44653a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f44654a;

        /* renamed from: b  reason: collision with root package name */
        private final String f44655b;

        public a(int i4, String str) {
            this.f44654a = i4;
            this.f44655b = str;
        }

        public int b() {
            return this.f44654a;
        }

        public String a() {
            return this.f44655b;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00d3 A[Catch: Exception -> 0x00cd, all -> 0x00eb, TRY_LEAVE, TryCatch #1 {Exception -> 0x00cd, blocks: (B:40:0x00c7, B:43:0x00cf, B:45:0x00d3), top: B:58:0x00c7, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized org.json.JSONObject a(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.m.c.g.a(java.lang.String):org.json.JSONObject");
    }

    private static List<a> b(String str) throws JSONException {
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i4);
            arrayList.add(new a(jSONObject.getInt("v"), jSONObject.getString("s")));
        }
        return arrayList;
    }

    private static JSONObject a(byte[] bArr, List<a> list) throws Exception {
        JSONObject jSONObject = new JSONObject(new String(bArr, 0, bArr.length, "UTF-8"));
        int i4 = jSONObject.getInt("v");
        String string = jSONObject.getString("u");
        long j4 = jSONObject.getLong("t");
        String string2 = jSONObject.getString("m");
        for (a aVar : list) {
            if (aVar.f44654a == i4) {
                String a4 = a(aVar, string, j4);
                if (string2.equals(a4)) {
                    return jSONObject;
                }
                throw new Exception("file signature:" + string2 + " not match calculate signature:" + a4);
            }
        }
        throw new Exception("file version not exist:" + i4);
    }

    private static JSONObject a(a aVar) throws Exception {
        JSONObject jSONObject = new JSONObject();
        String uuid = UUID.randomUUID().toString();
        long currentTimeMillis = System.currentTimeMillis();
        jSONObject.put("v", aVar.f44654a);
        jSONObject.put("u", uuid);
        jSONObject.put("t", currentTimeMillis);
        jSONObject.put("m", a(aVar, uuid, currentTimeMillis));
        return jSONObject;
    }

    private static byte[] a(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        FileLock fileLock = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rwd");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            fileLock = randomAccessFile.getChannel().lock();
            long length = randomAccessFile.length();
            if (length > 10240) {
                length = 10240;
            }
            int i4 = (int) length;
            byte[] bArr = new byte[i4];
            int read = randomAccessFile.read(bArr, 0, i4);
            if (read == i4) {
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (IOException unused) {
                    }
                }
                randomAccessFile.close();
                return bArr;
            }
            throw new Exception("read file length\uff1a" + read + "file length:" + i4 + " not match " + file.getAbsolutePath());
        } catch (Throwable th2) {
            th = th2;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused2) {
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static void a(File file, String str, byte[] bArr) throws Exception {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileLock lock;
        if (!file.exists() && !file.mkdirs()) {
            d1.a("create dir error", new Object[0]);
        }
        FileLock fileLock = null;
        try {
            randomAccessFile = new RandomAccessFile(new File(file, str), "rwd");
            try {
                lock = randomAccessFile.getChannel().lock();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
        try {
            randomAccessFile.setLength(0L);
            randomAccessFile.write(bArr);
            if (lock != null) {
                try {
                    lock.release();
                } catch (IOException unused) {
                }
            }
            randomAccessFile.close();
        } catch (Throwable th4) {
            th = th4;
            fileLock = lock;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (IOException unused2) {
                }
            }
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static String a(a aVar, String str, long j4) throws Exception {
        return s0.a(String.format("%s%d%d%s", str, Integer.valueOf(aVar.b()), Long.valueOf(j4), aVar.a())).toUpperCase();
    }
}
