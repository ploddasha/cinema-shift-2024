package com.ploddasha.cinemashiftapp.common.presentation

import androidx.navigation.NavType
import com.ploddasha.cinemashiftapp.common.presentation.SelectedData
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object SelectedDataNavType : NavType<SelectedData>(isNullableAllowed = false) {
    override fun get(bundle: android.os.Bundle, key: String): SelectedData? {
        return bundle.getString(key)?.let { decode(it) }
    }

    override fun parseValue(value: String): SelectedData {
        return decode(value)
    }

    override fun put(bundle: android.os.Bundle, key: String, value: SelectedData) {
        bundle.putString(key, encode(value))
    }

    private fun encode(value: SelectedData): String {
        return Json.encodeToString(value)
    }

    private fun decode(value: String): SelectedData {
        return Json.decodeFromString(value)
    }
}
