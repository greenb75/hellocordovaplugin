package com.example.plugin;

import android.widget.Toast;

import java.time.Duration;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HelloPlugin extends CordovaPlugin {
    private static final String DURATION_LONG = "long";

    @Override
    public boolean execute(final String action, final JSONArray args, final CallbackContext callbackContext)
            throws JSONException {

        JSONObject options = args.getJSONObject(0);

        if (action.equals("hello")) {

            String name = options.getString("name");            
            String message = "こんにちは, " + name + "さん！これは Plugin から返したメッセージですよー";

            callbackContext.success(message);

            return true;

        }         
        else if (action.equals("toast")){
            
            String message = options.getString("message");
            String duration = options.getString("duration");

            Toast toast = Toast.makeText(cordova.getActivity(), message, DURATION_LONG.equals(duration) ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
            toast.show();

            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            callbackContext.sendPluginResult(pluginResult);

            return true;
        }
        else {
            
            return false;

        }
    }
}