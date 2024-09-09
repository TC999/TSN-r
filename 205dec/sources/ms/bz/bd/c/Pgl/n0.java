package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n0 implements SensorEventListener {

    /* renamed from: f  reason: collision with root package name */
    private static volatile n0 f61419f;

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f61420a;

    /* renamed from: b  reason: collision with root package name */
    private int f61421b;

    /* renamed from: c  reason: collision with root package name */
    private int f61422c = 0;

    /* renamed from: d  reason: collision with root package name */
    private float[] f61423d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    private List<JSONArray> f61424e = new ArrayList();

    static {
        new DecimalFormat((String) pblk.a(16777217, 0, 0L, "d21dbb", new byte[]{37, 126, 18}));
        f61419f = null;
    }

    private n0(Context context) {
        this.f61420a = null;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (origApplicationContext != null) {
            this.f61420a = (SensorManager) origApplicationContext.getSystemService((String) pblk.a(16777217, 0, 0L, "f6043d", new byte[]{100, 49, 77, 83, 3, 97}));
        }
    }

    public static n0 a(Context context) {
        if (f61419f == null) {
            synchronized (n0.class) {
                if (f61419f == null) {
                    f61419f = new n0(context);
                }
            }
        }
        return f61419f;
    }

    private synchronized void d() {
        try {
            SensorManager sensorManager = this.f61420a;
            if (sensorManager != null) {
                int i4 = this.f61421b - 1;
                this.f61421b = i4;
                if (i4 == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            String str = (String) pblk.a(16777217, 0, 0L, "e3b267", new byte[]{103, 34, 18, 121, 28});
        }
    }

    public synchronized void b() {
        char c4;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            c4 = pbly.b() != null ? (char) 1 : (char) 0;
        } catch (Throwable unused) {
            c4 = '\uffff';
        }
        if (c4 != 1) {
            jSONArray2 = null;
        } else {
            synchronized (this) {
                try {
                    SensorManager sensorManager = this.f61420a;
                    if (sensorManager != null && (this.f61421b != 0 || this.f61420a.registerListener(this, sensorManager.getDefaultSensor(1), 3))) {
                        this.f61421b++;
                    }
                } catch (Exception unused2) {
                }
                try {
                    synchronized (this) {
                        int i4 = 0;
                        while (this.f61422c == 0 && i4 < 10) {
                            i4++;
                            wait(1000L);
                        }
                    }
                } catch (Exception unused3) {
                    String str = (String) pblk.a(16777217, 0, 0L, "aba50f", new byte[]{99, 115, 17, 126, 8});
                    jSONArray = new JSONArray();
                    jSONArray.put(new BigDecimal(this.f61423d[0]).setScale(2, 4));
                    jSONArray.put(new BigDecimal(this.f61423d[1]).setScale(2, 4));
                    jSONArray.put(new BigDecimal(this.f61423d[2]).setScale(2, 4));
                    d();
                }
            }
            jSONArray = new JSONArray();
            jSONArray.put(new BigDecimal(this.f61423d[0]).setScale(2, 4));
            jSONArray.put(new BigDecimal(this.f61423d[1]).setScale(2, 4));
            jSONArray.put(new BigDecimal(this.f61423d[2]).setScale(2, 4));
            d();
            this.f61422c = 0;
            jSONArray2 = jSONArray;
        }
        if (jSONArray2 == null) {
            return;
        }
        this.f61424e.add(jSONArray2);
        try {
            int size = this.f61424e.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.f61424e.subList(size - 50, size));
                this.f61424e.clear();
                this.f61424e = arrayList;
            }
        } catch (Throwable unused4) {
        }
    }

    public synchronized String c() {
        StringBuilder sb = new StringBuilder();
        int size = this.f61424e.size();
        if (size <= 0) {
            return null;
        }
        try {
            List<JSONArray> list = this.f61424e;
            int i4 = size - 50;
            if (i4 <= 0) {
                i4 = 0;
            }
            List<JSONArray> subList = list.subList(i4, size);
            if (subList.size() > 0) {
                for (JSONArray jSONArray : subList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) pblk.a(16777217, 0, 0L, "c0ff29", new byte[]{62}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) pblk.a(16777217, 0, 0L, "9d7f45", new byte[]{100}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) pblk.a(16777217, 0, 0L, "65d9ee", new byte[]{59}));
                    }
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f61423d = sensorEvent.values;
        this.f61422c = 1;
    }
}
