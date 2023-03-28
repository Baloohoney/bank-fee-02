fun main() {
    if (bankFeeCalculation(
            paymentSystem = "VK Pay",
            monthTotal = 30_000,
            transactionAmount = 1_000
        ) == -1) println("Перевод невозможен")
    else println(bankFeeCalculation(
            paymentSystem = "VK Pay",
            monthTotal = 30_000,
            transactionAmount = 1_000
        )
    )
}

fun bankFeeCalculation(
    paymentSystem: String,
    monthTotal: Int,
    transactionAmount: Int
): Int {
    return when (paymentSystem) {
        "MasterCard" -> when {
            transactionAmount > 150_000 || transactionAmount + monthTotal > 600_000 -> -1
            transactionAmount + monthTotal <= 75000.0 -> 0
            else -> (transactionAmount * 0.006).toInt() + 20
        }

        "Maestro" -> when {
            transactionAmount > 150_000 || transactionAmount + monthTotal > 600_000 -> -1
            transactionAmount + monthTotal <= 75000.0 -> 0
            else -> (transactionAmount * 0.006).toInt() + 20
        }

        "Visa" -> when {
            transactionAmount > 150_000 || transactionAmount + monthTotal > 600_000 -> -1
            else -> (transactionAmount * 0.0075).toInt()
        }

        "Mir" -> when {
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