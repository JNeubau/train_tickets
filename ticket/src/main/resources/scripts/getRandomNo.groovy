import java.util.Random

def start = execution.getVariable('start').toString()
def end = execution.getVariable('end').toString()
def type = execution.getVariable('type').toString()

int startInt = Integer.parseInt(start)
int endInt = Integer.parseInt(end)
int randomNo = 0;

Random random = new Random()

if (type == "odd") {
    randomNo = ((random.nextInt(endInt.intdiv(2)) + startInt) * 2) -1
} else if (type == "even") {
    randomNo = (random.nextInt(endInt.intdiv(2)) + startInt) * 2
} else {
    randomNo = random.nextInt(endInt) + startInt
}

execution.setVariable('randomNo', randomNo)