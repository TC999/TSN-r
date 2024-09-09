package com.bytedance.sdk.component.panglearmor.c;

import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {
    public static float[] c(List<Float> list, List<Float> list2, List<Float> list3, List<Float> list4, List<Float> list5, List<Float> list6) {
        float[] fArr;
        int min = Math.min(list.size(), list4.size());
        float f4 = 0.0f;
        char c4 = 0;
        float f5 = 0.0f;
        float f6 = 0.0f;
        int i4 = 0;
        while (i4 < min) {
            float[] fArr2 = new float[3];
            fArr2[c4] = list.get(i4).floatValue();
            fArr2[1] = list2.get(i4).floatValue();
            fArr2[2] = list3.get(i4).floatValue();
            float[] fArr3 = new float[3];
            fArr3[c4] = list4.get(i4).floatValue();
            fArr3[1] = list5.get(i4).floatValue();
            fArr3[2] = list6.get(i4).floatValue();
            float[] fArr4 = new float[9];
            SensorManager.getRotationMatrix(fArr4, null, fArr2, fArr3);
            SensorManager.getOrientation(fArr4, new float[3]);
            f4 += (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
            f5 += (((float) Math.toDegrees(fArr[1])) + 360.0f) % 360.0f;
            f6 += (((float) Math.toDegrees(fArr[2])) + 360.0f) % 360.0f;
            i4++;
            c4 = 0;
        }
        float f7 = min;
        return new float[]{f4 / f7, f5 / f7, f6 / f7};
    }

    @NonNull
    public static int[][] c(List<JSONObject> list, long j4, long j5) throws JSONException {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        double[] dArr3 = new double[size];
        for (int i4 = 0; i4 < size; i4++) {
            JSONArray optJSONArray = list.get(i4).optJSONArray("val");
            if (optJSONArray != null && optJSONArray.length() == 3) {
                dArr[i4] = optJSONArray.getDouble(0);
                dArr2[i4] = optJSONArray.getDouble(1);
                dArr3[i4] = optJSONArray.getDouble(2);
            }
        }
        return new int[][]{c(dArr, j4), c(dArr2, j5), c(dArr3, j5)};
    }

    @NonNull
    public static int[] c(double[] dArr, long j4) {
        if (j4 <= 0 || j4 > 360) {
            return new int[0];
        }
        int[] iArr = new int[(int) (360 / j4)];
        for (double d4 : dArr) {
            double d5 = j4;
            Double.isNaN(d5);
            int i4 = (int) (d4 / d5);
            iArr[i4] = iArr[i4] + 1;
        }
        return iArr;
    }

    @NonNull
    public static int[] c(LinkedList<JSONObject> linkedList, int i4) {
        int[] iArr = new int[i4];
        if (linkedList.size() < 1) {
            return iArr;
        }
        int optLong = (int) (((linkedList.getLast().optLong("t", 0L) / 1000) / 60) / 60);
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            int optLong2 = optLong - ((int) (((it.next().optLong("t", 0L) / 1000) / 60) / 60));
            if (optLong2 >= 0 && optLong2 < i4) {
                iArr[optLong2] = iArr[optLong2] + 1;
            }
        }
        return iArr;
    }
}
