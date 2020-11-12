package com.troyasoft.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Implementation of App Widget functionality.
 */
public class WidgetDeApp extends AppWidgetProvider{

    public static final String ACTION_TEXT_CHANGED = "com.troyasoft.widget.TEXT_CHANGED";
    private static String value1 ="0.0";
    private static String value2 ="vacio";


    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {


        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_de_app);

        views.setTextViewText(R.id.tv_val1,"value1:" +value1);
        views.setTextViewText(R.id.tv_val2, "status:"+value2);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        views.setOnClickPendingIntent(R.id.btn1, pendingIntent);


        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int appWidgetId : appWidgetIds) {
            Log.i("gab","onUpdate()  id:"+appWidgetId);
            updateAppWidget(context,appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created and add to home
        // como crear una base de datos o un servicio.
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled to home
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        Log.i("onReceive()","");
        if (intent.getAction().equals(ACTION_TEXT_CHANGED)) {
            value1 =intent.getStringExtra("val1");
            value2 =intent.getStringExtra("val2");
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            int[] ids = appWidgetManager.getAppWidgetIds(new ComponentName(context,WidgetDeApp.class));
            onUpdate(context,appWidgetManager,ids);
        }

        



    }








}