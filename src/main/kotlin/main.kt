fun main() {
    println(
        bankFeeCalculation(
            paymentSystem = "MasterCard",
            monthTotal = 75000.0,
            transactionAmount = 5000.0
        )
    )
}

fun bankFeeCalculation(
    paymentSystem: String = "VK",
    monthTotal: Double = 0.0,
    transactionAmount: Double
) = when (paymentSystem) {
    "MasterCard" -> if (monthTotal < 75000.0) 0.0
    else (transactionAmount * 0.006) + 20.0

    "Visa_Mir" -> transactionAmount * 0.0075
    else -> 0.0
}
