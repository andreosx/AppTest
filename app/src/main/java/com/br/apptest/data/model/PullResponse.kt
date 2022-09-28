package com.br.apptest.data.model

import android.os.Parcelable
import com.br.apptest.domain.model.pull.PullItem
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class PullResponse(
    @SerializedName("items") var items: @RawValue List<PullItem>
): Parcelable