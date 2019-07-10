package fiofoundation.io.fiosdk.models.fionetworkprovider

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fiofoundation.io.fiosdk.models.fionetworkprovider.response.FIOResponse

class RegisterFIOAddressAction(@Expose(serialize = false, deserialize = false) var fioAddress: String,
                               @Expose(serialize = false, deserialize = false) var ownerPublicKey: String,
                               @Expose(serialize = false, deserialize = false) var walletFioAddress: String,
                               @Expose(serialize = false, deserialize = false) var maxFee: Int,
                               @Expose(serialize = false, deserialize = false) var actorPublicKey: String) : Action("fio.system","regaddress",
    ArrayList(),"")
{
    init
    {
        val authorization = Authorization(actorPublicKey,"active")
        var requestData = FIOAddressRequestData(
            fioAddress,
            ownerPublicKey,
            maxFee,
            walletFioAddress,
            authorization.actor
        )

        this.authorization = listOf(authorization)
        this.data = requestData.toJson()
    }

    class FIOAddressRequestData(@field:SerializedName("fio_address") var fioAddress:String,
                                @field:SerializedName("owner_fio_public_key") var ownerPublicKey:String,
                                @field:SerializedName("max_fee") var max_fee:Int,
                                @field:SerializedName("tpid") var walletFioAddress:String,
                                @field:SerializedName("actor") var actor:String): FIOResponse()
}