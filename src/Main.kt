fun main() {
    println("hello world");
    println(5 + 8);
    var name = "john";

    name = "mitu";
    println(name);

    val birth = 2019;
    println(birth);

    var names = "John";
    println("Hello " + names);


    var fn = "asim ";
    var ln = "aimon";
    var fullname = fn + ln;
    println(fullname);

    val myNum = 9;
    val mydoublenum = 99.29;
    println(myNum + mydoublenum);

    val mystring = "noob at kotlin ";
    val myletter = 'D';
    val con = mystring + myletter;
    println(con);

    val iskotlinfun: Boolean = true;
    val isfishtasty: Boolean = false;
    println(iskotlinfun);
    println(isfishtasty);

    var x = 5
    println(x > 3 && x < 10)

    var p = 18
    println(p > 3 || p < 10)

    var nam = "punit";
    println(nam);

    var name2: String;
    name2 = "piu";
    println(name2);

    var txt = "hello world";
    println(txt[0]);
    println(txt[1]);
    println(txt[5]);

    var twxt = "abjsbjsuhidijdiw";
    println("the text length = " + twxt.length);


    var str = "banglAdeshE thako";
    println(str.uppercase());
    println(str.lowercase());
    println(str[0].uppercase());
    println(str[5].lowercase());

    var tx = "i am indian";
    var px = "i am indian";
    println(tx.compareTo(px));

    var text2 = " i am german";
    println(text2.indexOf("german"));

    var dx = "asim"
    var dy = "aimon";
    println("$dx $dy")
    println(dx + dy)

    println(10 == 15)

    val m = 11;
    println(m == 10)

    var pr = "teenage"
    println(pr == "tinage")

    val a: Int = 14
    val b = 25
    val c = 22
    if (a > b && a > c)
        println("a is larger than b & c");
    else if (b > a && b > c)
        println("b is greater then a & c");
    else
        println("c is greater than a and b");


    val day = 8;
    val result = when (day) {
        1 -> "monday";
        2 -> "tuesday";
        3 -> "wednesday";
        4 -> "thursday";
        5 -> "friday";
        6 -> "saturday";
        7 -> "sunday";
        else -> "error";
    }
    println(result);

    var t = 10;
    var sum = 0;
    while (t > 0) {
        sum += t;
        t--;
    }
    println(sum);


    var pt = 10;
    while (pt > 5) {
        if (pt == 7)
            break;
        println(pt)
        pt--;
    }

    var i = 0
    while (i < 10) {
        if (i == 4) {
            i++
            continue
        }
        println(i)
        i++
    }

    val tea= arrayOf("green","red","blue","yellow","pink");
    println(tea[1])
    for(array in tea)
    {
        println(array)
    }


    val number=readLine()!!.toInt();
    println(2*number)


    val arr=IntArray(10)
    var ptr=0;
    for(i in arr.indices)
    {
        arr[i] = readLine()!!.toInt();
        ptr+=arr[i];
    }
    println(ptr);


    val ax=arrayOf(2,3,4,5,6,7,8,9,10)
    if(5 in ax)
        println("it exist")
    else
        println("it not exist")



}