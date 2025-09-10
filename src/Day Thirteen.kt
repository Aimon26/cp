//ZOO ECOSYSTEM PROBLEM

abstract class Animal(
    val name: String
) {
    abstract fun eat()
    abstract fun makeSound()
    abstract fun performAction()
}

class Lion(name: String) : Animal(name) {
    override fun eat() {
        println("$name eats (Carnivore)")
    }
    override fun makeSound() {
        println("$name roars loudly")
    }
    override fun performAction() {
        println("$name shows dominance by roaring")
    }
}

class Monkey(name: String) : Animal(name) {
    override fun eat() {
        println("$name eats (Herbivore)")
    }
    override fun makeSound() {
        println("$name chatters and gibbers")
    }
    override fun performAction() {
        println("$name climbs trees")
    }
}

class Parrot(name: String) : Animal(name) {
    override fun eat() {
        println("$name eats (Omnivore)")
    }
    override fun makeSound() {
        println("$name says 'Tia Tia'")
    }
    override fun performAction() {
        println("$name mimics human speech")
    }
}

abstract class Enclosure(
    val name: String
) {
    val animals = mutableListOf<Animal>()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
        println("${animal.name} added to $name enclosure")
    }

    abstract fun describe()
}

// Concrete Enclosures
class Cage(name: String) : Enclosure(name) {
    override fun describe() {
        println("Cage enclosure ($name) is secure with iron bars.")
    }
}

class Aviary(name: String) : Enclosure(name) {
    override fun describe() {
        println("Aviary enclosure ($name) has open space and nets for birds.")
    }
}

class OpenField(name: String) : Enclosure(name) {
    override fun describe() {
        println("OpenField enclosure ($name) is a wide open area for large animals.")
    }
}


fun main() {
    val lion = Lion("Simba")
    val monkey = Monkey("George")
    val parrot = Parrot("Polly")

    val lionCage = OpenField("Savannah Zone")
    val monkeyCage = Cage("Primate House")
    val parrotAviary = Aviary("Tropical Birds")

    lionCage.addAnimal(lion)
    monkeyCage.addAnimal(monkey)
    parrotAviary.addAnimal(parrot)

    println("\n--- Zoo Enclosures ---")
    lionCage.describe()
    monkeyCage.describe()
    parrotAviary.describe()

    println("\n--- Animal Behaviors ---")
    for (enclosure in listOf(lionCage, monkeyCage, parrotAviary)) {
        for (animal in enclosure.animals) {
            animal.eat()
            animal.makeSound()
            animal.performAction()
            println("-----")
        }
    }
}

//import kotlin.random.Random
data class Browse(
    var url: String,
    //var id: Double = Random.nextDouble(1.0, 1000.0)
)

interface SearchHere {
    fun search(browse: Browse)
    fun serve(url: String)
    fun closeAllTabs()
    fun delete(browse: Browse)
    fun showAlltab()
    fun historyShow()
    fun deleteTabinHistory(browse: Browse)
    fun clearHistory()
    fun showCount(browse: Browse)
}

class BrowseManager : SearchHere {
    var x = mutableListOf<Browse>()
    var y = mutableListOf<Browse>()

    override fun search(browse: Browse) {
        x.add(browse)
        y.add(browse)
    }
    override fun serve(url: String) {
        val brouse = Browse(url)
        search(brouse)
        println("Opened '${brouse.url}'")
    }



    override fun delete(browse: Browse) {
        var i=x.size-1
        while(i>=0) {
            if(browse.url == x[i].url){
                x.remove(x[i])
                break
            }
            i--
        }
        println("After deleting given tab from Aimon browser:")
    }

    override fun showAlltab() {
        println("Here are all open tabs:")
        println("-----------------------------------")
        if(x.isEmpty())
            println("No open tab")
        else{
        for (i in x.indices)
            println(x[i].url)
        }
        println("-----------------------------------")
    }

    override fun historyShow() {
        println("Here are the history tabs:")
        for (i in y.indices)
            println(y[i].url)
        println("----------------------------------")
        println("Total browser open in history: ${y.size}")
        println("----------------------------------------------")
    }

    override fun clearHistory() {
        y.clear()
        println("History cleared.")
        println("Total browser open in history: ${y.size}")
    }

    override fun showCount(browse: Browse) {
        var cnt=0
        for (i in x.indices){
        if(browse.url in x[i].url) {
            cnt++
        }}
        println("Opened ${browse.url} opened in ${cnt} tabs")
    }

    override fun deleteTabinHistory(browse: Browse) {
        for (i in y.indices) {
            if(browse.url in y[i].url){
                y.remove(y[i])
                break
            }
        }
    }
    override fun closeAllTabs() {
        x.clear()
        println("All tabs have been closed.")
    }
}

// Example main function demonstrating usage
fun main() {
    println("------------WELCOME TO AIMON BROWSER-------------")
    println(" WHAT'S NEW TODAY? We Create, We Explore & We Deploy ")
    println("-----------------------------------------------------")
    val manager: SearchHere = BrowseManager()

    manager.serve("https://google.com")
    manager.serve("https://stackoverflow.com")

    manager.showAlltab()
    manager.historyShow()

    manager.serve("https://kotlinlang.org")
    manager.serve("https://google.com")
    manager.serve("https://stackoverflow.com")

    manager.showAlltab()

    val tab1 = Browse("https://google.com")
    val tab2 = Browse("https://stackoverflow.com")

    manager.showCount(tab1)
    manager.showCount(tab2)

    manager.delete(tab1)
    manager.showAlltab()

    manager.historyShow()
    manager.deleteTabinHistory(tab2)
    manager.historyShow()

    manager.clearHistory()
    manager.closeAllTabs()
    manager.showAlltab()
}


//Smart Music Playback System

class Song(
    var id: Int,
    var title: String,
    var artist: String,
    var duration: Int
) {
    fun play() {
        println("Now playing: $title by $artist")
    }

    override fun toString(): String {
        return "Song(id=$id, title='$title', artist='$artist', duration=$duration)"
    }
}

class Playlist {
    private val songs = mutableListOf<Song>()

    fun addSong(song: Song) {
        songs.add(song)
    }

    fun removeSong(id: Int) {
        val p = songs.find { it.id == id }
        if (p != null) {
            songs.remove(p)
        }
    }

    fun showAllSongs() {
        for (i in songs.indices) {
            println(songs[i])
        }
    }

    fun playAll() {
        for (i in songs.indices) {
            println("${songs[i]} is playing at position ${i + 1}")
        }
    }

    fun getSongs(): MutableList<Song> = songs
}

class Strategy(private val playlist: Playlist) {

    fun normalPlayback() {
        val songs = playlist.getSongs()
        for (i in songs.indices) {
            songs[i].play()
        }
    }

    fun shufflePlayback() {
        val songs = playlist.getSongs().toMutableList()
        songs.shuffle()
        for (i in songs.indices) {
            songs[i].play()
        }
    }

    fun repeatPlayback(times: Int = 2) {
        val songs = playlist.getSongs()
        repeat(times) {
            println("Repeat round ${it + 1}")
            for (song in songs) {
                song.play()
            }
        }
    }
}

fun main() {
    val playlist = Playlist()
    playlist.addSong(Song(1, "Song A", "Artist A", 210))
    playlist.addSong(Song(2, "Song B", "Artist B", 180))
    playlist.addSong(Song(3, "Song C", "Artist C", 240))

    val strategy = Strategy(playlist)

    println("\nNormal Playback:")
    strategy.normalPlayback()

    println("\nShuffle Playback:")
    strategy.shufflePlayback()

    println("\nRepeat Playback (2 times):")
    strategy.repeatPlayback(2)
}


