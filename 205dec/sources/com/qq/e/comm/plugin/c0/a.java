package com.qq.e.comm.plugin.c0;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f42139c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f42140d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f42141e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f42142f;

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f42141e = new ImageView(context);
        int a4 = f1.a(context, 29);
        int a5 = f1.a(context, 35);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a4, a5);
        layoutParams.gravity = 19;
        layoutParams.leftMargin = f1.a(context, 7);
        this.f42141e.setLayoutParams(layoutParams);
        int a6 = (a5 - f1.a(context, 15)) / 2;
        this.f42141e.setPadding(0, a6, 0, a6);
        this.f42141e.setVisibility(4);
        this.f42141e.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAAEEfUpiAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAIKADAAQAAAABAAAAIAAAAACshmLzAAACQElEQVRYCdVXP0/jMBS3U3QLQiwsRejWlhbMkCKmWxGsSIidL4IEH4iZBQZggVailNyVheUkGG68SkALMe9FfSZOnNSx1CCy2H7v/f7YtZ2UsfEjxOYs9Vlj1ZdqoGUoKkSrRn2Ltrnq/0+VGYNYpcnHYZkJKPKwcIbzeiZtnAn9N0TrPh7T+s3d3R9aAAaRBAZ936+y+4dBsiAaY7Ip/GHxJCLypqgYp1vElU6igzN7HrJHzvjfoNf+mUirYYpAATkbBbed1MIq5LijCIoCiYjjzyf7D6/cUpGA1EYOcJO8SdmHwSDodeYoadOqKWCxC5FGQIouRITVWljYBSE2lrRgkcHKmr85qX4mq6ApWv0wlDUppcc5/7xrEgB14OJxBAOw5nmVnTwwYlKLGAffda+O48SmvkZQFKw5cAErAldwRAAX4h9Y4joumM2ck+vgAXgeg5K9/0smbcbRIsKd9QjFVe6xX0G3c2EDpBr1K7iSKAJkdCHRCFxIUgRFSYxn4XevswhETzJk53AmjCIoNPFZWWvtTypyYscb/GXITnEDwnujDe+N9UlCWfnM+8QEiIRH/Ox5KKMvFXwTQN2RqdY2ZrUCJIx3FBKjMOeVPZejlzSWa2CawmTEaKAMYaOBMoU1A18hrAzgqzcM2YkKeN5B0L0+pPG022gPjL9EzkCsioIQHMAH8nbRq93FrLYJv8KIZoBmUKYRo4EyjeQaKMOIlYFcIxW+Fdy0L6mmaFvIAJHH9wgQ9OFfxTLlvl37AXeFOzBY4qGXAAAAAElFTkSuQmCC"));
        addView(this.f42141e);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#ffe4e5e7"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) f1.a(context, 0.67f));
        layoutParams2.gravity = 80;
        view.setLayoutParams(layoutParams2);
        addView(view);
        this.f42140d = new ProgressBar(context, null, 16842872);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, (int) f1.a(context, 1.34f));
        layoutParams3.gravity = 80;
        this.f42140d.setLayoutParams(layoutParams3);
        this.f42140d.setMax(100);
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(0), 3, 1);
        ClipDrawable clipDrawable2 = new ClipDrawable(new ColorDrawable(Color.parseColor("#ff008de8")), 3, 1);
        clipDrawable.setLevel(10000);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{clipDrawable, clipDrawable2, clipDrawable2});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f42140d.setProgressDrawable(layerDrawable);
        addView(this.f42140d);
        this.f42139c = new TextView(context);
        int a7 = f1.a(context, 55);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 17;
        layoutParams4.leftMargin = a7;
        layoutParams4.rightMargin = a7;
        this.f42139c.setLayoutParams(layoutParams4);
        this.f42139c.setTextSize(2, 15.33f);
        this.f42139c.setTextColor(Color.parseColor("#ff2a2d33"));
        this.f42139c.setSingleLine();
        this.f42139c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        addView(this.f42139c);
        ImageView imageView = new ImageView(context);
        this.f42142f = imageView;
        imageView.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAAB8AAAAfCAYAAAFoqSavAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAH6ADAAQAAAABAAAAHwAAAABwh9X2AAAC+0lEQVRIDa1XvW/TQBS/56QMwFoxQJH4mJrWUDmUCVTgD+iE2MvHH8DKkokVsbeFuWyIqUNXJJpI4DRZAMGAGECMdKiaHPc7513O57Nju3jo3b33fh/35bhC+J7F5UgivhRFV0yegzrAmVQQmda16I6BtMLob4kBl2TIwKcoIEZchBaFROKQ5kR40Ot9RSzAHzxABKfE1UHcOzM+El+SKBLKGvs2wUlHS4dhdNNN2OPgWNKTxeX2lh1EP2UcBXaRnTSzmBbIjWG/Z+IpZiCnhUnKTBNJRrpFaUPaoOXJNmTrGRasg0/bLnb7WHUmNrNJGOWGELQ97HcfuiCMAZRSnMaW8V4aAgb4iHxArs8QcGJKpE6Mpch5bhvcsVsoqvEqgHJEZ+VIvJo/d/7i718/39p16KccFFmdOkqvkSYoArqKeURuXflxGK5eKl+dVK6s3JrvdDoB8WEYxN2AiPT7pIgMt1OOxR4F4jVJKakVtscAzCIwQKIfqnZBL1wZAhcIMbNtRQQ+YAqMgY8gD5gBuwRqUe7qxZnMEXn7MbbtoO1A7YBeHDvPffNK4QDapevtNR4rogsg47HdZsDOHHUeW+kjSDE6wAWo2FNwz4EB+4BsMY9Ag4uARQRUBphLgItRtB0M5Naawg7HarWE+zwS48+KsaEcbB182n9c5mpWVcPyCCne4bUuiJ4P4+6zZMHD9qYSt34HaHsQ7z/6HyZSosoxlrghgttx/OGbOSrJWt7YVCdL/SjxU9+ET5Tm5Br/kEHBiLPcSU2UEWWtjDgnqpqoIsoaueJcMMtEHVHmninOhT4T6uPyWJ3eJmpwkNw9ZWxeW1qcCSYz3WVRHQ/Em8HH7oOqt6O0uG95Jcn3YizuszE1/0pXdKa4T9ReXt92lDWRKz5LdDrbpFfHREa8quhJTBjxk4rWMUH46DsaHX7XL3zFUOfKuML22LcdJOjpoN99Eayv3/ujpv8SH45NalzGN6D9/rWJ6vRx/fDPi/7+UKKKY6cZ0C64/gH25kow2R+kgwAAAABJRU5ErkJggg=="));
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(a4, a5);
        layoutParams5.gravity = 8388629;
        layoutParams5.rightMargin = f1.a(context, 7);
        this.f42142f.setLayoutParams(layoutParams5);
        this.f42142f.setPadding(0, a6, 0, a6);
        addView(this.f42142f);
    }

    public void b() {
        if (this.f42141e.getVisibility() != 0) {
            this.f42141e.setVisibility(0);
        }
    }

    public void b(int i4) {
        if (this.f42140d.getVisibility() != 0) {
            this.f42140d.setVisibility(0);
        }
        a(i4);
    }

    public void b(View.OnClickListener onClickListener) {
        this.f42142f.setOnClickListener(onClickListener);
    }

    public void a(String str) {
        this.f42139c.setText(str);
    }

    public void a() {
        if (this.f42140d.getVisibility() == 0) {
            this.f42140d.setVisibility(8);
            this.f42140d.setProgress(0);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.f42141e.setClickable(true);
        this.f42141e.setOnClickListener(onClickListener);
    }

    private void a(int i4) {
        ProgressBar progressBar = this.f42140d;
        if (i4 < 0) {
            i4 = 0;
        } else if (i4 > 100) {
            i4 = 100;
        }
        progressBar.setProgress(i4);
    }
}
