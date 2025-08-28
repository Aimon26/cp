import kotlin.math.abs
import kotlin.math.min

fun lemonadeChange(bills: IntArray): Boolean {
    var c5=0
    var c10=0
    var x=0
    for(i in 0 until bills.size) {
        if(bills[i]==5) {
            c5++;
        }
        else if(bills[i]==10) {
            c10++;
            c5--;
        }
        else {
            if(c10>0 && c5>0){
               c10--;
                c5--}
            else if(c10==0 && c5>2){
            c5-=3;
            }
            else
            {
                x=1
            }
        }
        if(c5<0||c10<0){
            x=1
            break;
        }
    }

    if(x==1)
        return false
    else
        return true;
}


fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
    for(i in 0 until k)
    {
        var p=nums.min()
        for(j in 0 until nums.size)
        {
            if(nums[j]==p)
                nums[j]=-p
        }
    }
    return nums.sum()

}

fun canThreePartsEqualSum(arr: IntArray): Boolean {
    var p=arr.sum()
    if(p%3==0)
        return true
    else
        return false

}

/*fun maximum69Number (num: Int): Int {
    var x=0
    var p=num
    while(p>0) {
        x=p%10
        p/=10
        if(x==6)
    }
    var s=x.size
    var c=0
    x.reverse()
    for(i in 0 until x.size)
    {
        if(x[i]==6)
        {
            c++;
            s=s-i-1
            break
        }
    }
    if(c==0)
        return num;
    else {
        var t = 3
        for (i in 0 until s) {
            t = t * 10
        }
        return num + t
    }}
*/
fun maximum69Number(num: Int): Int {
    var n = num
    var place = 1
    var left= 0

    while (n > 0) {
        val digit = n % 10
        if (digit == 6)
            left = place
        n /= 10
        place =place* 10
    }
    if (left > 0)
        return num + 3 * left
    else
        return num
}


fun isPowerOfThree(n: Int): Boolean {
    var p=n
    if(n<0)
        p=-n;
    if(n==1)
        return true
    else if(p%3 !=0 && n<0)
        return false
    else
    {
        while(p>1)
        {
            if((p-1) %3==0)
                p=p/3+1;
            else
                p=p/3
            if(p%3 !=0 && p>1) {
                p = 2
                break;
            }
        }
        if(p==1)
            return true
        else return false
    }

}


fun isPowerOfFour(n: Int): Boolean {
    var p=0
    var x=0
    if(n==1)
        return true
    else {
        if(n%4!=0)
            x=0
        else
        {
            p=n
            while(p>1)
            {
                p=p/4
            }
            if(p==1)
                x=2
        }
    }
    if(x==2)
        return true
    else
        return false

}

fun hammingDistance(x: Int, y: Int): Int {

    var cnt=0
    var cnt2=0
    var str1= x.toString(2)
    var str2= y.toString(2)
    var len1 = str1.length
    var len2 = str2.length
    var sz= min(len1, len2)
    while(sz>0)
    {
        if(str1[len1-1] != str2[len2-1]) {
            cnt++;
            len1--
            len2--
        }
        else
        {
            len1--
            len2--
        }
        sz--

    }
    var x=len1-len2
    var y=abs(x)
    if(len1>len2)
    {
        for(i in 0 until y)
        {
            if(str1[i]=='1')
                cnt2++
        }
    }
    else if(len2>len1)
    {
        for(i in 0 until y)
        {
            if(str2[i]=='1')
                cnt2++
        }
    }
    return cnt+cnt2

}


fun heightChecker(heights: IntArray): Int {
    var cnt=0
    var lst = mutableListOf<Int>()
    for(i in 0 until heights.size)
        lst.add(heights[i])
    heights.sort()
    for(i in 0 until heights.size)
    {
        if(lst[i]!=heights[i])
            cnt++
    }
    return cnt



}


fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    var cnt=0
    seats.sort()
    students.sort()
    for(i in 0 until seats.size)
    {
        var m=seats[i]-students[i]
        cnt=cnt+abs(m)
    }

    return cnt
}


fun maxIceCream(costs: IntArray, coins: Int): Int {
    var cnt=coins
    var cnt2=0
    costs.sort()
    for(i in 0 until costs.size)
    {
        if(costs[i]<=cnt) {
            //cnt += costs[i]
            cnt2++
            cnt-=costs[i]
        }
        else
            break
    }
    return cnt2

}

fun convertToBase7(num: Int): String {
    var str1= num.toString(7)
    return str1
}


fun checkDivisibility(n: Int): Boolean {
    var lst = mutableListOf<Int>()
    var num=n;
        while(num>0)
        {
            lst.add(num%10)
            num=num/10
        }
    println(lst)
    var sum=0
    var mul=1
    for(i in 0 until lst.size)
    {
        sum=sum+lst[i]
        mul=mul*lst[i]
    }
    if(n%(sum+mul)==0)
        return true
    else
        return false
}


fun winningPlayer(x: Int, y: Int): String {
    var m=1;
    var bx=x
    var by=y
    while(m>0)
    {
        if(bx>=1 && by>=4 )
        {
            m++;
            bx--;
            by-=4;
        }
        else
            break
    }
    if(m%2==0)
        return "Alice"
    else
        return "Bob"


}

fun arrangeCoins(n: Int): Int {
    var cnt=1
    var p=0
    var i=n
    while(i>0)
    {
        i-=cnt
        if(i>0)
        p++
        cnt++;
    }
    return p;

}


fun minSubsequence(nums: IntArray): List<Int> {
    var cnt=0
    var cnt2=0
    nums.sort()
    nums.reverse()
    var x=mutableListOf<Int>()
    for(i in 0 until nums.size)
    {
        cnt+=nums[i];
        for(j in i+1 until nums.size)
            cnt2+=nums[j];
        if(cnt <= cnt2){
            x.add(nums[i]);
            cnt2=0}
        else if(cnt > cnt2){
            x.add(nums[i]);
            break;
        }

    }
    return x

}
fun main() {
    var x=intArrayOf(4,3,10,9,8)
    println(minSubsequence(x))
}

