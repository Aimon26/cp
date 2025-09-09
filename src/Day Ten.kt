// Library Management System
open class Book(
    var title: String,
    var author: String,
    var isbn: String,
    var availableCopies: Int
) {
    open fun displayBookInfo() {
        println("Title: $title | Author: $author | ISBN: $isbn | Available: $availableCopies")
    }

    fun borrowBook(): Boolean {
        return if (availableCopies > 0) {
            availableCopies--
            true
        } else {
            false
        }
    }

    fun returnBook() {
        availableCopies++
    }
}

// Member class
class Member(
    var name: String,
    var memberId: Int
) {
    private val borrowedBooks = mutableListOf<Book>()

    fun borrowBook(book: Book) {
        if (book.borrowBook()) {
            borrowedBooks.add(book)
            println("$name borrowed '${book.title}'")
        } else {
            println("Sorry, '${book.title}' is not available")
        }
    }

    fun returnBook(book: Book) {
        if (borrowedBooks.remove(book)) {
            book.returnBook()
            println("$name returned '${book.title}'")
        } else {
            println("$name did not borrow '${book.title}'")
        }
    }

    fun showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            println("$name has no borrowed books.")
        } else {
            println("$name's borrowed books:")
            borrowedBooks.forEach { it.displayBookInfo() }
        }
    }
}

// Library class
class Library {
    private val books = mutableListOf<Book>()
    private val members = mutableListOf<Member>()

    fun addBook(book: Book) {
        books.add(book)
        println("Book '${book.title}' added to library.")
    }

    fun registerMember(member: Member) {
        members.add(member)
        println("Member '${member.name}' registered.")
    }

    fun showAllBooks() {
        if (books.isEmpty()) {
            println("No books available in the library.")
        } else {
            println("Books available in the library:")
            books.forEach { it.displayBookInfo() }
        }
    }
}

// Main function to test
fun main() {
    val library = Library()

    // Adding books
    val book1 = Book("1984", "George Orwell", "ISBN123", 3)
    val book2 = Book("The Hobbit", "J.R.R. Tolkien", "ISBN456", 2)
    library.addBook(book1)
    library.addBook(book2)

    // Register members
    val member1 = Member("Alice", 101)
    val member2 = Member("Bob", 102)
    library.registerMember(member1)
    library.registerMember(member2)

    // Borrowing books
    library.showAllBooks()
    member1.borrowBook(book1)
    member2.borrowBook(book2)
    member2.borrowBook(book2) // Borrow again

    // Show borrowed books
    member1.showBorrowedBooks()
    member2.showBorrowedBooks()

    // Returning books
    member1.returnBook(book1)
    member1.showBorrowedBooks()
    library.showAllBooks()
}
