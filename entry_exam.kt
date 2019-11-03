/*
Calculate the total ordered quantity for every weekday
Implement OrdersAnalyzer#totalDailySales method that returns a map with a DayOfWeek as a key and the sum of
ordered quantity for all products, as a value.

The method should always return a map. If there are no orders for some weekdays, then skip this day entry in the map.
Example output
Your implementation should return the following output for example data:
{
  "DayOfWeek.MONDAY" : 17,
  "DayOfWeek.SATURDAY" : 6,
  "DayOfWeek.SUNDAY" : 9
}

In the example above, there are three orders placed on Saturday: first with a quantity equal to 3 and second with
quantity equal to 2, and third with a quantity equal to 1 so the sum of quantities is 6. For Monday the total quantity
is equal to 17, and for Sunday it's 9.
*/

package entry_exam
import java.time.LocalDateTime
import java.time.DayOfWeek
import java.math.BigDecimal


class OrdersAnalyzer {

    data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)

    data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: BigDecimal)

    private fun getOrderTotalQuantity(order: OrdersAnalyzer.Order): Int {
        var quantity = 0
        for (orderLine in order.orderLines){
            quantity += orderLine.quantity
        }
        return quantity
    }

    fun totalDailySales(orders: List<Order>): Map<DayOfWeek, Int> {
        var res = mutableMapOf<DayOfWeek, Int>()
        for (order in orders){
            // check quantity for this order
            val quantity = this.getOrderTotalQuantity(order)

            // if quantity > 0, add to res
            if (quantity > 0) {
                val dayOfWeek = order.creationDate.dayOfWeek
                val currentTotalSales = res.getOrDefault(dayOfWeek, 0)
                res[dayOfWeek] =  if (currentTotalSales == 0) quantity else currentTotalSales + quantity
            }
        }
        return res.toMap()
    }
}




