package br.com.test.claro.net.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import br.com.test.claro.net.views.MainActivity;

public class PreferencesApp {
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public PreferencesApp(Context context) {
        this.context = context;
        this.preferences = context.getSharedPreferences(MainActivity.class.getSimpleName(), Activity.MODE_PRIVATE);
    }

    public void setIntByKey(String key, int value){
        editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntByKey(String key){
        return preferences.getInt(key, 0);
    }

}
