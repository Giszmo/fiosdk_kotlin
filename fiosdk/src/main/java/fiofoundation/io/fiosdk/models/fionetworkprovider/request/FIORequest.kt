package fiofoundation.io.fiosdk.models.fionetworkprovider.request

import com.google.gson.GsonBuilder

open class FIORequest {
    fun toJson(): String {
        val gson = GsonBuilder().create()
        return gson.toJson(this,this.javaClass)
    }
}