package com.example.livecode_kotlin_android.transaction

import java.util.*

class Transaction(
                  var user_owner_id:Int = 1,
                  var trans_date:Date,
                  var destination:String = "",
                  var amount:Int,
                  var description: String="") {
}