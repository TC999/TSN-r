package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UMCommonContent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ListIterator;

/* renamed from: com.kuaishou.weapon.p0.bo */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7199bo {
    /* renamed from: a */
    public static int m34150a(Context context) {
        SensorManager sensorManager;
        try {
            if (Build.VERSION.SDK_INT >= 23 && (sensorManager = (SensorManager) context.getSystemService(UMCommonContent.f37799ac)) != null) {
                List<Sensor> sensorList = sensorManager.getSensorList(-1);
                if (sensorList.size() > 0) {
                    ListIterator<Sensor> listIterator = sensorList.listIterator();
                    while (listIterator.hasNext()) {
                        if (listIterator.next().getType() == 9) {
                            return 0;
                        }
                    }
                    return 1;
                }
                return 0;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public static long m34148b() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                double d = Utils.DOUBLE_EPSILON;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = m34149a(readLine).split(";");
                        if (split != null && split.length != 0) {
                            d = Double.valueOf(split[0]).doubleValue();
                        }
                    } catch (Throwable unused) {
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return -1L;
                    }
                }
                System.currentTimeMillis();
                long j = (long) (d * 1000.0d);
                try {
                    dataInputStream2.close();
                } catch (IOException unused4) {
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                    return j;
                }
            } catch (Throwable unused6) {
                bufferedReader = null;
            }
        } catch (Throwable unused7) {
            bufferedReader = null;
        }
    }

    /* renamed from: a */
    public static long m34151a() {
        BufferedReader bufferedReader;
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(Runtime.getRuntime().exec("cat /proc/uptime").getInputStream());
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream2));
                double d = Utils.DOUBLE_EPSILON;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = m34149a(readLine).split(";");
                        if (split != null && split.length != 0) {
                            d = Double.valueOf(split[0]).doubleValue();
                        }
                    } catch (Throwable unused) {
                        dataInputStream = dataInputStream2;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return -1L;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis() - ((long) (d * 1000.0d));
                try {
                    dataInputStream2.close();
                } catch (IOException unused4) {
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused5) {
                    return currentTimeMillis;
                }
            } catch (Throwable unused6) {
                bufferedReader = null;
            }
        } catch (Throwable unused7) {
            bufferedReader = null;
        }
    }

    /* renamed from: a */
    public static String m34149a(String str) {
        try {
            return str.replace("      ", ";").replace("     ", ";").replace("    ", ";").replace("   ", ";").replace("  ", ";").replace(" ", ";");
        } catch (Throwable unused) {
            return null;
        }
    }
}
