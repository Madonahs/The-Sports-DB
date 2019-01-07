package com.madonasyombua.budgetingbuddydummy.Data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import java.io.Serializable


class ExpenseData : Parcelable, Serializable {

    var id: Int = 0
    var expenseName: String? = null
    var expenseType: String? = null
    var expenseAmount: Double = 0.toDouble()
    var note: String? = null
    var expenseDate: String? = null
    var latitude: Double = 0.toDouble()
    var longitude: Double = 0.toDouble()

    constructor() {

    }

    constructor(id: Int, expenseName: String, expenseType: String,
                expenseAmount: Double, expenseDate: String, note: String, latitude: Double, longitude: Double) {
        this.id = id
        this.expenseName = expenseName
        this.expenseType = expenseType
        this.expenseAmount = expenseAmount
        this.expenseDate = expenseDate
        this.note = note
        this.longitude = longitude
        this.latitude = latitude
    }

    constructor(`in`: Parcel) : super() {
        readFromParcel(`in`)
    }

    override fun toString(): String {
        return "ExpenseData{" +
                "id=" + id +
                ", expenseName='" + expenseName + '\''.toString() +
                ", expenseType='" + expenseType + '\''.toString() +
                ", expenseAmount=" + expenseAmount +
                ", note='" + note + '\''.toString() +
                ", expenseDate='" + expenseDate + '\''.toString() +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}'.toString()
    }

    fun readFromParcel(`in`: Parcel) {
        id = `in`.readInt()
        expenseName = `in`.readString()
        expenseType = `in`.readString()
        expenseAmount = `in`.readDouble()
        note = `in`.readString()
        expenseDate = `in`.readString()
        latitude = `in`.readDouble()
        latitude = `in`.readDouble()

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeInt(id)
        parcel.writeString(expenseName)
        parcel.writeString(expenseType)
        parcel.writeDouble(expenseAmount)
        parcel.writeString(note)
        parcel.writeString(expenseDate)
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
    }

    companion object {

        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<ExpenseData> = object : Parcelable.Creator<ExpenseData> {
            override fun createFromParcel(`in`: Parcel): ExpenseData {
                return ExpenseData(`in`)
            }

            override fun newArray(size: Int): Array<ExpenseData?> {

                return arrayOfNulls(size)
            }

        }
    }
}
