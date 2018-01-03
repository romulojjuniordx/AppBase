package dextra.android.appbase.base

class GenericError(var message: String, var type: Types = GenericError.Types.UNKNOWN, var isHandled: Boolean = false) {
    enum class Types {
        UNKNOWN,
        NO_RESULT
    }
}