package cn.jpush.android.u;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.ad.g;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.u.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class e extends b {

    /* renamed from: f  reason: collision with root package name */
    protected View f4413f;

    public e(Context context, cn.jpush.android.t.a aVar, cn.jpush.android.d.d dVar, int i4) {
        super(context, aVar, dVar, i4);
    }

    private void a(int i4, boolean z3) {
        a(i4 != 1 ? i4 != 2 ? -1L : z3 ? 4002L : 4001L : z3 ? 4004L : 4003L);
    }

    private void a(long j4) {
        Logger.d("BaseInAppWrapper", "report code=" + j4);
        if (j4 > 0) {
            cn.jpush.android.helper.c.a(this.f4384d, this.f4382b.f4127d, j4, 4);
        }
    }

    private void d(int i4) {
        a(i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? -1L : 4013L : 4014L : 4012L : 4011L : 4000L);
    }

    private int e(int i4) {
        if (i4 != 2) {
            return i4 != 3 ? 17 : 5;
        }
        return 3;
    }

    public View a(String str) {
        int identifier = this.f4384d.getResources().getIdentifier(str, "layout", this.f4384d.getPackageName());
        if (identifier <= 0) {
            throw new IllegalArgumentException("\"" + str + ".xml\" not found,please check res-layout file!!");
        }
        View inflate = LayoutInflater.from(this.f4384d).inflate(identifier, (ViewGroup) null);
        if (inflate != null) {
            return inflate;
        }
        throw new IllegalArgumentException("\"" + str + ".xml\" not found,please check res-layout file!!");
    }

    protected abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4, String str, int i5) {
        if (i4 == 1 || i4 == 2) {
            cn.jpush.android.k.a.a(this.f4384d, this.f4382b);
            cn.jpush.android.x.b.a(this.f4384d, JPushInterface.ACTION_IN_APP_MSG_CLICK, this.f4382b, (Intent) null, str);
            a(i4, g.a().a(this.f4384d, -1, str, (String) null, (String) null));
        }
        b.a aVar = this.f4381a;
        if (aVar != null) {
            aVar.a(this.f4384d, e(), this.f4382b);
        }
        d(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ImageView imageView, String str, JSONObject jSONObject, final int i4, int i5, int i6) {
        try {
            if (!TextUtils.isEmpty(str)) {
                imageView.setImageBitmap(cn.jpush.android.ad.e.a(str, i5, i6));
            }
            if (jSONObject != null) {
                final int optInt = jSONObject.optInt("type");
                final String optString = jSONObject.optString("action");
                imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.e.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.a(optInt, optString, i4);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "native updateImage throwable=" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView) {
        String charSequence = textView.getText().toString();
        int b4 = m.b(charSequence);
        if (b4 <= 1) {
            this.f4381a.a(this.f4384d, this.f4413f, this.f4382b);
            return;
        }
        textView.setText(charSequence.replace("" + b4, "" + (b4 - 1)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(TextView textView, JSONObject jSONObject, final int i4) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        try {
            String optString = jSONObject.optString("text");
            if (jSONObject.has("duration")) {
                textView.setText((jSONObject.optInt("duration") / 1000) + "s" + optString);
            } else {
                textView.setText(optString);
            }
            if (jSONObject.has("style") && (optJSONArray = jSONObject.optJSONArray("style")) != null && optJSONArray.length() == 4) {
                if (optJSONArray.optInt(0) == 1) {
                    textView.setTypeface(Typeface.DEFAULT_BOLD);
                }
                int optInt = optJSONArray.optInt(1);
                if (optInt > 0) {
                    textView.setTextSize(optInt);
                }
                int optInt2 = optJSONArray.optInt(2);
                if (optInt2 > 0) {
                    textView.setGravity(e(optInt2));
                }
                String optString2 = optJSONArray.optString(3);
                if (!TextUtils.isEmpty(optString2) && optString2.startsWith("#")) {
                    textView.setTextColor(Color.parseColor(optString2));
                }
            }
            if (jSONObject.has("click") && (optJSONObject = jSONObject.optJSONObject("click")) != null) {
                final int optInt3 = optJSONObject.optInt("type");
                final String optString3 = optJSONObject.optString("action");
                textView.setOnClickListener(new View.OnClickListener() { // from class: cn.jpush.android.u.e.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        e.this.a(optInt3, optString3, i4);
                    }
                });
            }
            if (jSONObject.has("bg_color")) {
                String optString4 = jSONObject.optString("bg_color");
                if (TextUtils.isEmpty(optString4) || !optString4.startsWith("#")) {
                    return;
                }
                ((GradientDrawable) textView.getBackground()).setColor(Color.parseColor(optString4));
            }
        } catch (Throwable th) {
            Logger.d("BaseInAppWrapper", "native updateTextView throwable=" + th);
        }
    }

    public final <T extends View> T b(String str) {
        int identifier = this.f4384d.getResources().getIdentifier(str, "id", this.f4384d.getPackageName());
        if (identifier <= 0) {
            throw new IllegalArgumentException("view id=\"" + str + "\" not found, check layout.xml or not confused keep it");
        }
        T t3 = (T) this.f4413f.findViewById(identifier);
        if (t3 != null) {
            return t3;
        }
        throw new IllegalArgumentException("view id=\"" + str + "\" not found, check layout.xml or not confused keep it");
    }

    protected abstract String b();

    @Override // cn.jpush.android.u.b
    public View e() {
        return this.f4413f;
    }

    @Override // cn.jpush.android.u.b
    public boolean f() {
        long j4;
        try {
            this.f4413f = a(b());
            try {
                a();
                return true;
            } catch (Throwable th) {
                Logger.ke("BaseInAppWrapper", "findViewByName throwable =" + th.getMessage());
                j4 = 3014;
                a(j4);
                return false;
            }
        } catch (Throwable th2) {
            Logger.ke("BaseInAppWrapper", "inflateLayout throwable " + th2.getMessage());
            j4 = 3013;
        }
    }

    @Override // cn.jpush.android.u.b
    public void g() {
    }
}
