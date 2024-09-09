package com.bytedance.pangle.res.a;

import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c {
    public final int a(File file, boolean z3, StringBuilder sb) {
        ZipFile zipFile;
        String byteArrayOutputStream;
        ZipFile zipFile2 = null;
        try {
            zipFile = new ZipFile(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            ZipEntry entry = zipFile.getEntry("assets/ZeusResMapping");
            if (entry == null) {
                com.bytedance.pangle.util.g.a(zipFile);
                return 200;
            }
            if (z3) {
                File file2 = new File(file.getParentFile(), "resMappingBak");
                if (file2.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    FileChannel channel = fileInputStream.getChannel();
                    byteArrayOutputStream = Charset.defaultCharset().newDecoder().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer()).toString();
                    channel.close();
                    fileInputStream.close();
                } else {
                    ZeusLogger.errReport("Zeus/install_pangle", "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                    sb.append("resMappingBakFile is not exists. ");
                    sb.append(file2.getAbsolutePath());
                    com.bytedance.pangle.util.g.a(zipFile);
                    return 300;
                }
            } else {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                InputStream inputStream = zipFile.getInputStream(entry);
                if (inputStream != null) {
                    ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                    WritableByteChannel newChannel2 = Channels.newChannel(byteArrayOutputStream2);
                    com.bytedance.pangle.util.h.a(newChannel, newChannel2);
                    newChannel.close();
                    newChannel2.close();
                }
                byteArrayOutputStream = byteArrayOutputStream2.toString();
            }
            if (TextUtils.isEmpty(byteArrayOutputStream)) {
                ZeusLogger.errReport("Zeus/install_pangle", "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z3)));
                sb.append("zeusResMappingContent isEmpty. useBakFile:");
                sb.append(z3);
                com.bytedance.pangle.util.g.a(zipFile);
                return 300;
            }
            JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
            JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream);
            JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
            final HashSet hashSet = new HashSet();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                hashSet.add((String) jSONArray.get(i4));
            }
            final JSONObject jSONObject3 = (JSONObject) jSONObject.get("resMapping");
            final JSONObject jSONObject4 = (JSONObject) jSONObject2.get("resMapping");
            final int[] iArr = {0};
            a(file, hashSet, new h() { // from class: com.bytedance.pangle.res.a.c.1
                @Override // com.bytedance.pangle.res.a.h
                public final int a(int i5) {
                    String str = "0x" + Integer.toHexString(i5);
                    String str2 = (String) jSONObject3.opt(str);
                    if (str2 == null) {
                        return i5;
                    }
                    int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                    if (identifier == 0) {
                        identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll("_", "."), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                    }
                    if (identifier == 0) {
                        ZeusLogger.w("Zeus/install_pangle", "getIdentifier failed. resName is ".concat(str2));
                        return i5;
                    }
                    String str3 = "0x" + Integer.toHexString(identifier);
                    if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                        jSONObject4.remove(str);
                    }
                    try {
                        jSONObject4.put(str3, str2);
                    } catch (Throwable th2) {
                        ZeusLogger.errReport("Zeus/install_pangle", "update resMappingBak failed.", th2);
                    }
                    if (identifier != i5) {
                        int[] iArr2 = iArr;
                        iArr2[0] = iArr2[0] + 1;
                    }
                    return identifier;
                }

                @Override // com.bytedance.pangle.res.a.h
                public final boolean a(String str) {
                    return hashSet.contains(str);
                }
            });
            ZeusLogger.d("Zeus/install_pangle", "modifyRes count = " + iArr[0]);
            if (com.bytedance.pangle.util.h.a(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb)) {
                com.bytedance.pangle.util.g.a(zipFile);
                return 100;
            }
            ZeusLogger.errReport("Zeus/install_pangle", "writeText failed." + sb.toString());
            sb.append("writeText failed.");
            com.bytedance.pangle.util.g.a(zipFile);
            return 300;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            try {
                ZeusLogger.errReport("Zeus/install_pangle", "modifyRes failed. catch: " + th.getMessage(), th);
                sb.append("modifyRes failed. catch: ");
                sb.append(th.getMessage());
                return 300;
            } finally {
                if (zipFile2 != null) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                }
            }
        }
    }

    private static void a(File file, HashSet<String> hashSet, h hVar) {
        int i4;
        MappedByteBuffer a4 = a(file);
        int capacity = a4.capacity();
        if (capacity >= 22) {
            int i5 = capacity - 22;
            int min = Math.min(i5, 65535);
            for (int i6 = 0; i6 < min; i6++) {
                i4 = i5 - i6;
                if (a4.getInt(i4) == 101010256 && a4.getShort(i4 + 20) == i6) {
                    break;
                }
            }
        }
        i4 = -1;
        if (i4 != -1) {
            int i7 = a4.getInt(i4 + 12);
            int i8 = a4.getInt(i4 + 16);
            int i9 = i7 + i8;
            while (i8 < i9) {
                if (a4.getInt(i8) == 33639248) {
                    int i10 = a4.getShort(i8 + 28);
                    short s3 = a4.getShort(i8 + 30);
                    byte[] bArr = new byte[i10];
                    for (int i11 = 0; i11 < i10; i11++) {
                        bArr[i11] = a4.get(i8 + 46 + i11);
                    }
                    String str = new String(bArr);
                    int i12 = a4.getInt(i8 + 20);
                    int i13 = a4.getInt(i8 + 24);
                    if (hashSet.contains(str)) {
                        if (i12 == i13) {
                            com.bytedance.pangle.util.e<Integer, byte[]> a5 = a(a4, a4.getInt(i8 + 42), str);
                            try {
                                byte[] bArr2 = a5.f29004b;
                                if (!TextUtils.isEmpty(str) && hVar.a(str)) {
                                    if (str.equals("AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if (str.equals("resources.arsc")) {
                                        new a(bArr2, hVar).a();
                                    }
                                }
                                for (int i14 = 0; i14 < a5.f29004b.length; i14++) {
                                    a4.put(a5.f29003a.intValue() + i14, a5.f29004b[i14]);
                                }
                            } catch (Throwable th) {
                                throw new RuntimeException(th);
                            }
                        } else {
                            throw new Throwable(str + " is compressed.");
                        }
                    }
                    i8 += i10 + 46 + s3;
                } else {
                    throw new RuntimeException("Expected: 0x02014b50, got: " + a4.getInt(i8));
                }
            }
            return;
        }
        throw new Throwable("endOfCentralPosition == -1");
    }

    private static com.bytedance.pangle.util.e<Integer, byte[]> a(MappedByteBuffer mappedByteBuffer, int i4, String str) {
        if (mappedByteBuffer.getInt(i4) == 67324752) {
            int i5 = mappedByteBuffer.getInt(i4 + 18);
            int i6 = mappedByteBuffer.getInt(i4 + 22);
            if (i5 == i6) {
                byte[] bArr = new byte[i6];
                int i7 = i4 + 30 + mappedByteBuffer.getShort(i4 + 26) + mappedByteBuffer.getShort(i4 + 28);
                for (int i8 = 0; i8 < i6; i8++) {
                    bArr[i8] = mappedByteBuffer.get(i7 + i8);
                }
                return new com.bytedance.pangle.util.e<>(Integer.valueOf(i7), bArr);
            }
            throw new RuntimeException(str + " is compressed. compressSize:" + i5 + " size:" + i6);
        }
        throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i4) + " FileName:" + str);
    }

    private static MappedByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
        }
        try {
            FileChannel channel = randomAccessFile.getChannel();
            long size = channel.size();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
            byte[] bArr = new byte[4194304];
            long j4 = size / 4194304;
            int i4 = (int) (size % 4194304);
            for (int i5 = 0; i5 < j4; i5++) {
                map.get(bArr);
            }
            if (i4 > 0) {
                map.get(new byte[i4]);
            }
            map.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.close();
            return map;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }
}
