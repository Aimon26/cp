(Run in single kt file of individual system)



ride sharing

open class User(var name: String, var phone: String) {
   open fun displayInfo() {
       println("User Name: $name   Phone: $phone")
   }
}

class Driver(
   name: String,
   phone: String,
   var carModel: String,
   var licensePlate: String,
   var rating: Int
) : User(name, phone) {
   override fun displayInfo() {
       println("Driver Name: $name   Phone: $phone CarModel: $carModel LicensePlate: $licensePlate Rating: $rating")
   }
}

class Passenger(name: String, phone: String, var paymentMethod: String) : User(name, phone) {
   override fun displayInfo() {
       println("Passenger Name: $name   Phone: $phone PaymentMethod: $paymentMethod")
   }
}

class Ride(
   var rideId: Int,
   var driver: Driver,
   var passenger: Passenger,
   var pickupLocation: String,
   var dropLocation: String,
   var fare: Int
) {
   fun startRide() {
       println("${driver.name} with Ride Id: $rideId started ride with passenger ${passenger.name} from $pickupLocation")
   }

   fun endRide() {
       println("${driver.name} with Ride Id: $rideId dropped passenger ${passenger.name} to $dropLocation and received fare $fare")
   }

   fun rideDetails() {
       println("Ride Id: $rideId")
       println("Driver Name: ${driver.name}")
       println("Passenger Name: ${passenger.name}")
       println("PickUp Location: $pickupLocation")
       println("Drop Location: $dropLocation")
       println("Fare: $fare")
   }
}

class RideSharingApp(var name: String) {
   var drivers = mutableListOf<Driver>()
   var passengers = mutableListOf<Passenger>()
   var rides = mutableListOf<Ride>()

   fun registerDriver(driver: Driver) {
       drivers.add(driver)
   }

   fun registerPassenger(passenger: Passenger) {
       passengers.add(passenger)
   }

   fun requestRide(pickup: String, drop: String, fare: Int) {
       if (drivers.isEmpty() || passengers.isEmpty()) {
           println("No drivers or passengers available to start a ride.")
           return
       }

       val driver = drivers.first()
       val passenger = passengers.first()
       val rideId = rides.size + 1

       val newRide = Ride(rideId, driver, passenger, pickup, drop, fare)
       rides.add(newRide)

       println("Ride #$rideId created for passenger ${passenger.name} with driver ${driver.name}.")
       newRide.startRide()
   }
}


//hospital management system (Run in single kt file)

open class User(
   var Id: Int,
   var Name: String,
   var Phone: String,
   var Gender: String
) {
   open fun showDetails() {
       println("Id: $Id Name: $Name Phone: $Phone Gender: $Gender")
   }
}

class Patient(
   Id: Int,
   Name: String,
   Phone: String,
   var patientAge: Int,
   Gender: String,
   var patientContext: String
) : User(Id, Name, Phone, Gender) {
   override fun showDetails() {
       println("Id: $Id Name: $Name Phone: $Phone Age: $patientAge Gender: $Gender Issue: $patientContext")
   }
}

class Doctor(
   Id: Int,
   Name: String,
   Phone: String,
   Gender: String,
   var doctorSpecialization: String,
   var availability: String
) : User(Id, Name, Phone, Gender) {
   override fun showDetails() {
       println("Id: $Id Name: $Name Phone: $Phone Gender: $Gender Specialization: $doctorSpecialization Availability: $availability")
   }
}

class Appointment(
   val appointmentID: Int,
   val patient: Patient,
   val doctor: Doctor,
   var appointmentDate: String,
   var appointmentTime: String,
   var status: String = "Scheduled"
) {
   fun displayAppointmentInfo() {
       println("Appointment ID: $appointmentID")
       println("Patient: ${patient.Name}, Doctor: ${doctor.Name}")
       println("Date: $appointmentDate, Time: $appointmentTime, Status: $status")
       println("-------------------------")
   }
}

// Main function to test
fun main() {
   val patient1 = Patient(101, "Alice", "0293", 23, "Female", "Flu symptoms")
   val doctor1 = Doctor(201, "Dr. Bob", "0990", "Male", "Medicine", "Mon-Fri 9AM-5PM")
   val appointment1 = Appointment(301, patient1, doctor1, "2025-09-10", "10:00 AM")

   patient1.showDetails()
   doctor1.showDetails()
   appointment1.displayAppointmentInfo()
}


//Todo Management System

class Todo(
    var id:Int,
    var name: String,
    var description: String,
    var isCompleted: Boolean=false
){
    fun markComplete()
    {
        isCompleted=true
    }
    fun show()
    {
        if(isCompleted==true)
            println("Task id $id is completed!")
        else
            println("Task id $id is not completed!")
        println("Task Id: $id       Task name: $name")
        println("description: $description")
        println("-----------------------------------------------------")
    }
}
class todoManager() {
    var x = mutableListOf<Todo>()
    fun adding(task: Todo) {
        x.add(task)
    }

     fun delete(id: Int) {
        var p = x.find { it.id == id }
        if (p != null)
            x.remove(p)
        else
            println("No such task!")
    }
    fun update(id:Int, new_id:Int, new_name:String, new_description:String, new_isCompleted:Boolean)
    {
        val p = x.find { it.id == id }
        if (p != null)
        {
            p.id=new_id;
            p.name=new_name
            p.description=new_description
            p.isCompleted = new_isCompleted
        }
        else

        {
            println("No such task!")
        }

    }
    fun showAll() {
        if(x.size>0) {
            for (task in x) {
                task.show()
            }
        }
        else
            println("No task available!")
    }

}
fun main()
{
    var p=Todo(1,"ParkEase","This is a parking app",false)
    var q=Todo(2,"The Pera","This is a task scheduling app",false)
    var r=Todo(3,"Attendence Tracker","This is a attendence tracker app",false)
    var z=Todo(4,"PhyMatics","This is my first app",false)
    q.markComplete()
    var x=todoManager()
    x.adding(p)
    x.adding(q)
    x.adding(r)
    x.adding(z)
    x.delete(2)
    r.markComplete()
    x.update(4,5,"xoxo","This is tic-tac-toe game",false)
    x.showAll()

}








