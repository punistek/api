package com.tflix.live.app;

import E4.f;
import H5.r;
import J5.a;
import android.app.Application;
import com.tflix.live.PlayerActivity;
import com.tflix.live.tv.TvPlayerActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ProApplication extends Application {
    public static ProApplication J;
    public ArrayList A;
    public ArrayList B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public boolean I;
    public PlayerActivity u;
    public TvPlayerActivity v;
    public r w;
    public a x;
    public JSONArray y;
    public List z;

    public final void onCreate() {
        super.onCreate();
        J = this;
        f.f(getApplicationContext());
    }
}
