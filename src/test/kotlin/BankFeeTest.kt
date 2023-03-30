import org.junit.Test
import kotlin.test.assertEquals

class BankFeeTest {

    @Test
    fun testMasterCardFree() {
        val paymentSystem = "MasterCard"
        val monthTotal = 0
        val transactionAmount = 500

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(0, result)
    }

    @Test
    fun testMaestroFree() {
        val paymentSystem = "Maestro"
        val monthTotal = 0
        val transactionAmount = 500

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(0, result)
    }

    @Test
    fun testMasterCardCommission() {
        val paymentSystem = "MasterCard"
        val monthTotal = 70_000
        val transactionAmount = 10_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testMaestroCommission() {
        val paymentSystem = "Maestro"
        val monthTotal = 80_000
        val transactionAmount = 1000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(26, result)
    }

    @Test
    fun testMasterCardExceeding() {
        val paymentSystem = "MasterCard"
        val monthTotal = 550_000
        val transactionAmount = 100_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testMaestroExceeding() {
        val paymentSystem = "Maestro"
        val monthTotal = 550_000
        val transactionAmount = 100_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testMasterCardExceedingAmount() {
        val paymentSystem = "MasterCard"
        val monthTotal = 50_000
        val transactionAmount = 200_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testMaestroExceedingAmount() {
        val paymentSystem = "Maestro"
        val monthTotal = 50_000
        val transactionAmount = 200_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }


    @Test
    fun testVisaCommission() {
        val paymentSystem = "Visa"
        val monthTotal = 100_000
        val transactionAmount = 10_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(75, result)
    }

    @Test
    fun testMirCommission() {
        val paymentSystem = "Mir"
        val monthTotal = 10_000
        val transactionAmount = 1000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(7, result)
    }

    @Test
    fun testVisaExceeding() {
        val paymentSystem = "Visa"
        val monthTotal = 700_000
        val transactionAmount = 10_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testMirExceeding() {
        val paymentSystem = "Mir"
        val monthTotal = 800_000
        val transactionAmount = 1000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testVisaExceedingAmount() {
        val paymentSystem = "Visa"
        val monthTotal = 200_000
        val transactionAmount = 200_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testMirExceedingAmount() {
        val paymentSystem = "Mir"
        val monthTotal = 100_000
        val transactionAmount = 200_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testVKpayFree() {
        val paymentSystem = "VK Pay"
        val monthTotal = 5_000
        val transactionAmount = 10_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(0, result)
    }

    @Test
    fun testVKpayExceeding() {
        val paymentSystem = "VK Pay"
        val monthTotal = 100_000
        val transactionAmount = 1000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testVKpayExceedingAmount() {
        val paymentSystem = "VK Pay"
        val monthTotal = 10_000
        val transactionAmount = 20_000

        val result = bankFeeCalculation(
            paymentSystem = paymentSystem, monthTotal = monthTotal,
            transactionAmount = transactionAmount
        )
        assertEquals(-1, result)
    }

    @Test
    fun testDefaultData() {
        val transactionAmount = 1000

        val result = bankFeeCalculation(transactionAmount = transactionAmount)
        assertEquals(0, result)
    }

}