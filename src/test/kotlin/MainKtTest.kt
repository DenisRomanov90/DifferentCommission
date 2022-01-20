import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun test_main() {
        val d = Users("Den")
        d.printCommission(d.transferCommission(60000.0, "Mastercard"))

    }
}