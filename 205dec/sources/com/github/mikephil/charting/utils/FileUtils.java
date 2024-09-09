package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    /* JADX WARN: Multi-variable type inference failed */
    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager assetManager, String str) {
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        bufferedReader = null;
        bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                    try {
                        String readLine = bufferedReader3.readLine();
                        while (readLine != null) {
                            String[] split = readLine.split("#");
                            float parseFloat = Float.parseFloat(split[1]);
                            arrayList.add(new BarEntry(parseFloat, Float.parseFloat(split[0])));
                            readLine = bufferedReader3.readLine();
                            bufferedReader2 = parseFloat;
                        }
                        bufferedReader3.close();
                        bufferedReader = bufferedReader2;
                    } catch (IOException e4) {
                        e = e4;
                        bufferedReader = bufferedReader3;
                        Log.e("MPChart-FileUtils", e.toString());
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            bufferedReader = bufferedReader;
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                Log.e("MPChart-FileUtils", e5.toString());
                            }
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                Log.e("MPChart-FileUtils", e7.toString());
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [float[]] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v14, types: [float] */
    public static List<Entry> loadEntriesFromAssets(AssetManager assetManager, String str) {
        ?? r22;
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = null;
        try {
        } catch (IOException e4) {
            Log.e("MPChart-FileUtils", e4.toString());
        }
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(assetManager.open(str), "UTF-8"));
                try {
                    String readLine = bufferedReader2.readLine();
                    while (readLine != null) {
                        String[] split = readLine.split("#");
                        if (split.length <= 2) {
                            r22 = Float.parseFloat(split[1]);
                            arrayList.add(new Entry(r22, Float.parseFloat(split[0])));
                        } else {
                            int length = split.length - 1;
                            r22 = new float[length];
                            for (int i4 = 0; i4 < length; i4++) {
                                r22[i4] = Float.parseFloat(split[i4]);
                            }
                            arrayList.add(new BarEntry(Integer.parseInt(split[split.length - 1]), (float[]) r22));
                        }
                        readLine = bufferedReader2.readLine();
                        bufferedReader = r22;
                    }
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                    Log.e("MPChart-FileUtils", e.toString());
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            Log.e("MPChart-FileUtils", e6.toString());
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<Entry> loadEntriesFromFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.split("#");
                if (split.length <= 2) {
                    arrayList.add(new Entry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                } else {
                    int length = split.length - 1;
                    float[] fArr = new float[length];
                    for (int i4 = 0; i4 < length; i4++) {
                        fArr[i4] = Float.parseFloat(split[i4]);
                    }
                    arrayList.add(new BarEntry(Integer.parseInt(split[split.length - 1]), fArr));
                }
            }
        } catch (IOException e4) {
            Log.e("MPChart-FileUtils", e4.toString());
        }
        return arrayList;
    }

    public static void saveToSdCard(List<Entry> list, String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e4) {
                Log.e("MPChart-FileUtils", e4.toString());
            }
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            for (Entry entry : list) {
                bufferedWriter.append((CharSequence) (entry.getY() + "#" + entry.getX()));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e5) {
            Log.e("MPChart-FileUtils", e5.toString());
        }
    }
}
