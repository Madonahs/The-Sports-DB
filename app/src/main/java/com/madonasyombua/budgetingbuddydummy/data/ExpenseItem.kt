package com.madonasyombua.budgetingbuddydummy.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

class ExpenseItem : Parcelable {

    var name: String? = null
        private set
    var type: String? = null
    var imageContentId = -1
        private set
    var colorContentId: Int = 0
        private set

    constructor(name: String, type: String, imageContentId: Int, colorContentId: Int) {
        this.name = name
        this.type = type
        this.imageContentId = imageContentId
        this.colorContentId = colorContentId
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        type = `in`.readString()
        imageContentId = `in`.readInt()
        colorContentId = `in`.readInt()
    }

    fun hasImage(): Boolean {
        return imageContentId != -1
    }

    override fun toString(): String {
        return "ExpenseItem{" +
                "name='" + name + '\''.toString() +
                ", type='" + type + '\''.toString() +
                ", imageContentId=" + imageContentId +
                ", colorContentId=" + colorContentId +
                '}'.toString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeString(type)
        parcel.writeInt(imageContentId)
        parcel.writeInt(colorContentId)
    }

    companion object {

        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<ExpenseItem> = object : Parcelable.Creator<ExpenseItem> {
            override fun createFromParcel(`in`: Parcel): ExpenseItem {
                return ExpenseItem(`in`)
            }

            override fun newArray(size: Int): Array<ExpenseItem?> {
                return arrayOfNulls(size)
            }
        }
    }
}
