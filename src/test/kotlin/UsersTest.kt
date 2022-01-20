import junit.framework.TestCase.assertEquals
import org.junit.Test

class UsersTest {

    @Test
    fun test_commission_Else() {
        val d = Users("Den")
        val summ = 500.0
        val cardType = "Qiwi"

        val expectedCommission = 0
        val commission = d.transferCommission(summ, cardType)
        assertEquals(expectedCommission, commission )
    }

    @Test
    fun test_commission_MasterMaestro() {
        val d = Users("Den")
        val summ = 500.0
        val cardType = "Maestro"

        val expectedCommission = 2300
        val commission = d.transferCommission(summ, cardType)
        assertEquals(expectedCommission, commission )
    }

    @Test
    fun test_commission_VisaMir() {
        val d = Users("Den")
        val summ = 9785.0
        val cardType = "Мир"

        val expectedCommission = 7338
        val commission = d.transferCommission(summ, cardType)
        assertEquals(expectedCommission, commission )
    }

    @Test
    fun test_commission_VisaMir_minCommission() {
        val d = Users("Den")
        val summ = 3000.0
        val cardType = "Мир"

        val expectedCommission = 3500
        val commission = d.transferCommission(summ, cardType)
        assertEquals(expectedCommission, commission )
    }

    @Test
    fun test_commission_Limit() {
        val d = Users("Den")
        val summ = 500.0
        val cardType = "Qiwi"
        d.dayLimit = 200000.0

        val expectedCommission = 0
        val commission = d.transferCommission(summ, cardType)
        assertEquals(expectedCommission, commission )
    }

    @Test
    fun test_printCommission() {
        val d = Users("Den")
        val commission = 9785.0
        d.printCommission(commission.toInt())

    }

    @Test
    fun test_printCommissionZero() {
        val d = Users("Den")
        val commission = 0.0
        d.printCommission(commission.toInt())

    }
}