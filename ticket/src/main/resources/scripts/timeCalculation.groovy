import java.text.SimpleDateFormat
import java.util.Calendar

def departureDate = execution.getVariable('departureDate').toString()
def form_type = execution.getVariable('form_type').toString()
// def departureDate = "2024-11-11T11:45+01:00"
// def form_type = "2"
// def returnDate = "2024-11-12T14:30+01:00"

// Combine date and time into a single Date object 2024-11-11T11:45+01:00
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmXXX")
Date departureDateTime = dateFormat.parse("${departureDate}")

// Create a Calendar instance and set the date and time
Calendar calendar = Calendar.getInstance()

// Add 10 minutes
calendar.setTime(departureDateTime)
calendar.add(Calendar.MINUTE, 15)
Date departureDateTimePlus15 = calendar.getTime()

// Add 30 minutes (from the original time, so reset the calendar)
calendar.setTime(departureDateTime)
calendar.add(Calendar.MINUTE, 38)
Date departureDateTimePlus38 = calendar.getTime()

// Format the results back to string if needed
String departureTimePlus15 = dateFormat.format(departureDateTimePlus15)
String departureTimePlus38 = dateFormat.format(departureDateTimePlus38)

// Set the results as process variables
execution.setVariable('departureDate1', departureTimePlus15)
execution.setVariable('departureDate2', departureTimePlus38)


if (form_type == "2") {
   def returnDate = execution.getVariable('form_returnDate').toString()

    Date returnDateTime = dateFormat.parse("${returnDate}")

    // Add 10 minutes
    calendar.setTime(returnDateTime)
    calendar.add(Calendar.MINUTE, 8)
    Date returnDateTimePlus08 = calendar.getTime()

    // Add 30 minutes (from the original time, so reset the calendar)
    calendar.setTime(returnDateTime)
    calendar.add(Calendar.MINUTE, 29)
    Date returnDateTimePlus29 = calendar.getTime()

    // Format the results back to string if needed
    String returnTimePlus08 = dateFormat.format(returnDateTimePlus08)
    String returnTimePlus29 = dateFormat.format(returnDateTimePlus29)

    execution.setVariable('returnDate1', returnDateTimePlus08)
    execution.setVariable('returnDate2', returnDateTimePlus29)

} else {
    execution.setVariable('returnDate1', null)
    execution.setVariable('returnDate2', null)
}