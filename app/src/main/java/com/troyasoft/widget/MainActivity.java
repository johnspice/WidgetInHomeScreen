package com.troyasoft.widget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendWidget(View view){
        Log.i("sendWidget()", "out");

        int number = (new Random().nextInt(500));
            /*

            int numberop = (new Random().nextInt(2));

            Intent intent = new Intent(WidgetDeApp.ACTION_TEXT_CHANGED);
            intent.putExtra("val1", "" + number);

            if (numberop == 1) intent.putExtra("val2", "Completo Full!!");
            else intent.putExtra("val2", "Vacio");
            Log.i("sendWidget()", "try");
            //getApplicationContext().sendBroadcast(intent);
            sendBroadcast(intent);
            Log.i("sendWidget()", "try pass");
             */

        Context context = this;
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_de_app);
        ComponentName thisWidget = new ComponentName(context, WidgetDeApp.class);
        remoteViews.setTextViewText(R.id.tv_val1,"value1:"+number);
        remoteViews.setTextViewText(R.id.tv_val2, "Status: Complete!!");
        appWidgetManager.updateAppWidget(thisWidget, remoteViews);


    }


}