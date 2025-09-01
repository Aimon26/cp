import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
    var x=mutableListOf<Int>()
    var c=0
    for(i in 0 until baskets.size)
    {
        x.add(baskets[i])

    }
    for(i in 0 until fruits.size)
    {
        for(j in 0 until x.size)
        {
            if(x[j]>=fruits[i])
            {
                c++
                x.remove(x[j])
                break;
            }
        }

    }
    return fruits.size-c;

}

fun thirdMax(nums: IntArray): Int
{
    var x=mutableListOf<Int>()
    for(i in 0 until nums.size)
        x.add(nums[i])

    x.sort()
    x.reverse()
    var y =x.distinct()
    if(y.size<3)
        return y[0]
    else
        return y[2]
}


fun minimumPairRemoval(nums: IntArray): Int {
    var x=mutableListOf<Int>()
    var c=0
    for(i in 0 until nums.size)
        x.add(nums[i])
    x.sort()
    for(j in nums.indices)
    {
        if(nums[j]!=x[j])
            c++;
    }
    return c;
}

fun isThree(n: Int): Boolean {
    var x=mutableListOf<Int>()
    for(i in 1  until n/2+1)
    {
        if(n%i==0)
        {
           x.add(i)
        }
    }
    if(x.size+1==3)
        return true

else
return false
}



fun checkPrimeFrequency(nums: IntArray): Boolean {
    var c=0
    var x=mutableListOf<Int>()
    var z=mutableListOf<Int>()
    for(i in 0 until nums.size)
    {
        x.add(nums[i])
    }
    x.sort()
    var y =x.distinct()
    for(i in 0 until y.size)
    {
        c=0
        for(j in 0 until x.size)
        {
            if(y[i]==x[j])
                c++;
        }
        z.add(c)
    }
    println(z)
    var t=0
    var p=0
    var cc=0
    for(i in 0 until z.size)
    {
        cc=0
        t = sqrt(z[i].toDouble()).toInt()
        println(t)
        if(z[i]==2||z[i]==3||z[i]==5)
        {
        p=1
        break// fix: convert sqrt result to Int
        }
        else if(z[i]==1)
        {
            p=0
        }
        else{
        for(j in 1..t+1)
        {
            if(z[i] % j != 0)   // fix: check divisibility properly
                cc++
        }
        if(cc==t)
        {
            p=1
            break
        }
        else
        {
            p=0
        }

    }}
    if(p==1)
        return true
    else
        return false
}


fun numberOfCuts(n: Int): Int {
    var p=-1
    if(n==1||n==2)
        p=n-1
    else if(n%6==0)
        p=3+(n/6-1)*6
    else if(n%5==0)
        p=5+((n/5)-1)*5
    else if(n%4==0)
        p=n/2
    else if(n%3==0)
        p=3+(n/3-1)*3
    else
        p=n
    return p

}


fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
    val list2D = mutableListOf<MutableList<Int>>()
    val list2D1 = mutableListOf<MutableList<Int>>()
    var c=0

    for (i in 0 until items1.size) {
        c=0;
        for (j in 0 until items2.size) {
            if (items1[i][0] == items2[j][0]) {
                val newRow = mutableListOf(
                    items1[i][0],
                    items1[i][1] + items2[j][1]
                )
                list2D.add(newRow)
                c++
                break
            }
        }
        if(c==0)
            list2D1.add(mutableListOf(items1[i][0],items1[i][1]))
    }
    var p=0
    for(i in 0 until items2.size) {
        p=0;
        for(j in 0 until list2D.size)
        {
            if(items2[i][0] == list2D[j][0]) {
                break;
            }
            else
                p++;
            if(p==list2D[j].size)
            {
                list2D1.add(mutableListOf(items2[i][0],items2[i][1]))
            }
        }
    }
    var z=0
    for(i in 0 until items1.size) {
        z=0;
        for(j in 0 until list2D.size)
        {
            if(items1[i][0] == list2D[j][0]) {
                break;
            }
            else
                z++;
            if(z==list2D[j].size)
            {
                list2D1.add(mutableListOf(items1[i][0],items1[i][1]))
            }
        }
    }

    for(i in 0 until list2D1.size)
        list2D.add(mutableListOf(list2D1[i][0],list2D1[i][1]))
    list2D.sortBy{it[0]}


return list2D}


fun hammingWeight(n: Int): Int {
    var x=mutableListOf<Int>()
    var str= n.toString(2)
    var c=0

        for(j in  0 until str.length)
        {
            if(str[j]=='1')

                c++;
        }

    return c;
}


fun toLowerCase(s: String): String {
    val lowercaseString = s.lowercase()
    return lowercaseString;
}


fun shortestToChar(s: String, c: Char): IntArray {
    var x=mutableListOf<Int>()
    var y=mutableListOf<Int>()
    for(i in 0 until s.length)
    {
        if(s[i]==c)
            x.add(i)
    }
    var mn=-2
    var p=-2
    for(i in 0 until s.length)
    {
        mn=x[0]-i
        if(mn<0)
            mn=-mn;
        for(j in 1..x.size-1)
        {
            p=x[j]-i
            if(p<0)
                p=-p
            mn= min(mn,p)
        }
        y.add(mn)

    }
    return y.toIntArray()

}
fun main()
{
    val s = "loveleetcode"
    val c = 'e'

    println(shortestToChar(s,c).contentToString())

}
