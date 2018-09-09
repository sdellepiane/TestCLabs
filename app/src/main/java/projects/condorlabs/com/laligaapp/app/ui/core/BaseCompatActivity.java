package projects.condorlabs.com.laligaapp.app.ui.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by sergio on 26/6/16.
 *
 * Clase que se utiliza para manejar todos los eventos de la actividad
 */
public class BaseCompatActivity extends AppCompatActivity {


    private static final String TAG = "BaseCompatActivity";

    protected void nextActivity(Class<?> activity, boolean destroy) {
        this.startActivity(new Intent(this, activity));
        if(destroy) {
            this.finish();
        }
    }

    protected void nextData(Class<?> activity, Bundle bundle, boolean destroy) {
        Intent intent = new Intent(this, activity);
        if(bundle!=null){    intent.putExtras(bundle);}
        this.startActivity(intent);
        if(destroy) {
            this.finish();
        }
    }
}
