import kotlin.random.Random
import kotlin.math.sqrt
data class Trip(
    val duration: Long,
    val dayOfWeek: Int,
    val date: Int
)

fun main() {
    val items = mutableListOf<Trip>()
    for (i in 1..30){
        items.add(
            Trip(
                duration = Random.nextLong(22L, 38L),
                dayOfWeek = Random.nextInt(1, 7),
                date = i
            )
        )
    }
    val dayOfWeek =5
    val result = getPredictDuration(items,dayOfWeek)
    println("Predict: $result Min")
}

fun getPredictDuration(items : List<Trip>, dayOfWeek: Int): Long {
    if(items.isEmpty())
        return 30L
    var cnt=0
    var duration=0L
    for(trip in items){
        if(trip.dayOfWeek==dayOfWeek){
            duration+=trip.duration
            cnt++
        }
    }
    if(cnt==0)
    {
        for(trip in items){
            duration+=trip.duration
            cnt++
        }
    }
    duration=duration/cnt

    var p=0.0
    var pr=0.0
    for(i in 1 .. items.size)
        pr=pr+i
    pr=pr/items.size
    items.forEach {
        p+=it.duration
    }
    p=p/items.size
    var sum=0.0
    var c=1.0
    for(trip in items)
    {
        sum=sum+(c-pr)*(trip.duration-p)
        c++;
    }
    c=1.0
    var sum1=0.0
    var sum2=0.0
    for(i in 0 until items.size)
    {
        sum1=sum1+(c-pr)*(c-pr)
        c++;
    }
    for(trip in items)
    {
        sum2=sum2+(trip.duration-p)*(trip.duration-p)
    }
    var r= sum/sqrt(sum1*sum2)

    if(r>=0.5) {
        duration = duration + 5
        println("Strongly Upward")
    }
    else if(r>=0.3) {
        duration = duration + 3
        println("Moderate Upward")
    }
    else if(r>=0.1) {
        duration = duration + 1
        println("Less Upward")
    }
    else if(r<=-0.7) {
        duration -= 2
        println("Strong Downward")
    }
    else
    {
        println("The generated data may be linear")
    }

    return duration
}