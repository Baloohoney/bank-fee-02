fun main() {
    if (bankFeeCalculation(
            paymentSystem = "Maestro",
            monthTotal = 40_000,
            transactionAmount = 50_000
        ) == -1
    ) println("Перевод невозможен")
    else println(
        bankFeeCalculation(
            paymentSystem = "Maestro",
            monthTotal = 40_000,
            transactionAmount = 50_000
        )
    )
}

fun bankFeeCalculation(
    paymentSystem: String = "VK Pay",
    monthTotal: Int = 0,
    transactionAmount: Int
): Int {
    return when (paymentSystem) {
        "MasterCard", "Maestro" -> when {
            transactionAmount > 150_000 || transactionAmount + monthTotal > 600_000 -> -1
            transactionAmount + monthTotal <= 75000.0 -> 0
            else -> (transactionAmount * 0.006).toInt() + 20
        }

        "Visa", "Mir" -> when {
            transactionAmount > 150_000 || transactionAmount + monthTotal > 600_000 -> -1
            else -> (transactionAmount * 0.0075).toInt()
        }

        "VK Pay" -> when {
            transactionAmount > 15_000 || transactionAmount + monthTotal > 40_000 -> -1
            else -> 0
        }

        else -> 0

    }
}