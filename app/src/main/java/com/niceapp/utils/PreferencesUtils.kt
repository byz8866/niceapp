package com.niceapp.utils


import android.content.Context


/**
 * PreferencesUtils, easy to get or put data
 *
 * **Preference Name**
 *  * you can change preference name by [.PREFERENCE_NAME]
 *
 *
 * **Put Value**
 *  * put string [.putString]
 *  * put int [.putInt]
 *  * put long [.putLong]
 *  * put float [.putFloat]
 *  * put boolean [.putBoolean]
 *
 *
 * **Get Value**
 *  * get string [.getString], [.getString]
 *  * get int [.getInt], [.getInt]
 *  * get long [.getLong], [.getLong]
 *  * get float [.getFloat], [.getFloat]
 *  * get boolean [.getBoolean], [.getBoolean]
 *
 *
 * @author mateng
 * @date 2018/2/1
 */
object PreferencesUtils {

    private var PREFERENCE_NAME = "cache_coinplay_default"

    /**
     * put string preferences
     *
     * @param context
     * @param key     The name of the preference to modify
     * @param value   The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    fun putString(context: Context, key: String, value: String): Boolean {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putString(key, value)
        return editor.commit()
    }


    fun putString(context: Context, key: String, value: String, spName: String): Boolean {
        val settings = context.getSharedPreferences(spName, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putString(key, value)
        return editor.commit()
    }

    fun putInt(context: Context, key: String, value: Int, spName: String): Boolean {
        val settings = context.getSharedPreferences(spName, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    fun getString(context: Context, key: String, defaultValue: String?, spName: String): String? {
        val settings = context.getSharedPreferences(spName, Context.MODE_PRIVATE)
        return settings.getString(key, defaultValue)
    }

    fun getInt(context: Context, key: String, defaultValue: Int, spName: String): Int {
        val settings = context.getSharedPreferences(spName, Context.MODE_PRIVATE)
        return settings.getInt(key, defaultValue)
    }

    /**
     * get string preferences
     *
     * @param context
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a string
     */
    @JvmOverloads
    fun getString(context: Context, key: String, defaultValue: String? = null): String? {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return settings.getString(key, defaultValue)
    }

    /**
     * put int preferences
     *
     * @param context
     * @param key     The name of the preference to modify
     * @param value   The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    fun putInt(context: Context, key: String, value: Int): Boolean {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putInt(key, value)
        return editor.commit()
    }

    /**
     * get int preferences
     *
     * @param context
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a int
     */
    @JvmOverloads
    fun getInt(context: Context, key: String, defaultValue: Int = -1): Int {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return settings.getInt(key, defaultValue)
    }

    /**
     * put long preferences
     *
     * @param context
     * @param key     The name of the preference to modify
     * @param value   The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    fun putLong(context: Context, key: String, value: Long): Boolean {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putLong(key, value)
        return editor.commit()
    }

    /**
     * get long preferences
     *
     * @param context
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a long
     */
    @JvmOverloads
    fun getLong(context: Context, key: String, defaultValue: Long = -1): Long {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return settings.getLong(key, defaultValue)
    }

    /**
     * put float preferences
     *
     * @param context
     * @param key     The name of the preference to modify
     * @param value   The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    fun putFloat(context: Context, key: String, value: Float): Boolean {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putFloat(key, value)
        return editor.commit()
    }

    /**
     * get float preferences
     *
     * @param context
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a float
     */
    @JvmOverloads
    fun getFloat(context: Context, key: String, defaultValue: Float = -1f): Float {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return settings.getFloat(key, defaultValue)
    }

    /**
     * put boolean preferences
     *
     * @param context
     * @param key     The name of the preference to modify
     * @param value   The new value for the preference
     * @return True if the new values were successfully written to persistent storage.
     */
    fun putBoolean(context: Context, key: String, value: Boolean): Boolean {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = settings.edit()
        editor.putBoolean(key, value)
        return editor.commit()
    }

    /**
     * get boolean preferences
     *
     * @param context
     * @param key          The name of the preference to retrieve
     * @param defaultValue Value to return if this preference does not exist
     * @return The preference value if it exists, or defValue. Throws ClassCastException if there is a preference with
     * this name that is not a boolean
     */
    @JvmOverloads
    fun getBoolean(context: Context, key: String, defaultValue: Boolean = false): Boolean {
        val settings = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        return settings.getBoolean(key, defaultValue)
    }

    /**
     * 清除sp
     */
    fun clearSp(context: Context) {
        val sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        sp.edit().clear().apply()
    }

    /**
     * 清除指定sp
     */
    fun clearSp(context: Context, sp_name: String) {
        val sp = context.getSharedPreferences(sp_name, Context.MODE_PRIVATE)
        sp.edit().clear().apply()
    }

    fun remove(context: Context, key: String, sp_name: String) {
        val sp = context.getSharedPreferences(sp_name, Context.MODE_PRIVATE)
        sp.edit().remove(key).apply()
    }

}
