package scripts

def reservedSeats = execution.getVariable('reservedSeats').toString()
def carNo = execution.getVariable('carNo').toString()
def seatNo = execution.getVariable('seatNo').toString()
def toReplace = carNo + "_" + seatNo +  ","
def result = reservedSeats.replace(toReplace, "")
execution.setVariable('reservedSeats', result)