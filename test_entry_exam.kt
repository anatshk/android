package entry_exam

import java.time.LocalDateTime
import java.math.BigDecimal
import java.time.DayOfWeek
import kotlin.test.assertEquals

// create the input collection
val order1 = OrdersAnalyzer.Order(
    orderId = 554,
    creationDate = LocalDateTime.parse("2017-03-25T10:35:20"),  // Saturday
    orderLines = listOf(
        OrdersAnalyzer.OrderLine(productId = 9872, name = "Pencil", quantity = 3, unitPrice = BigDecimal(3.00))
    )
)

val order2 = OrdersAnalyzer.Order(
    orderId = 555,
    creationDate = LocalDateTime.parse("2017-03-25T11:24:20"),  // Saturday
    orderLines = listOf(
        OrdersAnalyzer.OrderLine(productId = 9872, name = "Pencil", quantity = 2, unitPrice = BigDecimal(3.00)),
        OrdersAnalyzer.OrderLine(productId = 1746, name = "Eraser", quantity = 1, unitPrice = BigDecimal(1.00))
    )
)

val order3 = OrdersAnalyzer.Order(
    orderId = 453,
    creationDate = LocalDateTime.parse("2017-03-27T14:53:12"),  // Monday
    orderLines = listOf(
        OrdersAnalyzer.OrderLine(productId = 5723, name = "Pen", quantity = 4, unitPrice = BigDecimal(4.22)),
        OrdersAnalyzer.OrderLine(productId = 9872, name = "Pencil", quantity = 3, unitPrice = BigDecimal(3.12)),
        OrdersAnalyzer.OrderLine(productId = 3433, name = "Erasers Set", quantity = 1, unitPrice = BigDecimal(6.15))
    )
)

val order4 = OrdersAnalyzer.Order(
    orderId = 431,
    creationDate = LocalDateTime.parse("2017-03-20T12:15:02"),  // Monday
    orderLines = listOf(
        OrdersAnalyzer.OrderLine(productId = 5723, name = "Pen", quantity = 7, unitPrice = BigDecimal(4.22)),
        OrdersAnalyzer.OrderLine(productId = 3433, name = "Erasers Set", quantity = 2, unitPrice = BigDecimal(6.15))
    )
)

val order5 = OrdersAnalyzer.Order(
    orderId = 690,
    creationDate = LocalDateTime.parse("2017-03-26T11:14:00"), // Sunday
    orderLines = listOf(
        OrdersAnalyzer.OrderLine(productId = 9872, name = "Pencil", quantity = 4, unitPrice = BigDecimal(3.12)),
        OrdersAnalyzer.OrderLine(productId = 4098, name = "Marker", quantity = 5, unitPrice = BigDecimal(4.50))
    )
)

val inputCollection = listOf(order1, order2, order3, order4, order5)

// Expected output
val expectedOutput = mapOf(
    DayOfWeek.MONDAY to 17,
    DayOfWeek.SATURDAY to 6,
    DayOfWeek.SUNDAY to 9
)

fun main() {
    // Calculate result for inputCollection
    val result = OrdersAnalyzer().totalDailySales(inputCollection)
    // Compare result with expectedOutput and print errors / success
    assertEquals(expected = expectedOutput, actual = result, message = "Result differs from expected")
    println("Test Passed")
}