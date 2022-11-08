public class RejseKort {

    private boolean checkout, checkin, checkinOnce;
    private int balance, travelPrice, initialTS, xInit, yInit, maxX, minX, maxY, minY;

    public RejseKort(){

        this.balance = 100;
        this.checkout = true;
        this.checkin = false;
        this.initialTS = 0;
        this.xInit = 0;
        this.yInit = 0;
        this.travelPrice = 0;
        this.maxX = -10000;
        this.maxY = -10000;
        this.minY = 10000;
        this.minX = 10000;
        this.checkinOnce = true;
    }


    public void depositMoney(int dkk){

        if(dkk>=0){

            this.balance += dkk;
            System.out.printf("%s DKK deposited. New balance: %s DKK%n", dkk, this.balance);

        }
        else{
            System.out.println("Error: Cannot deposit negative amount");
        }

    }

    public boolean isCheckedIn(int timeStamp){

        if(timeDif(timeStamp) >= 0 && timeDif(timeStamp) <= 120 && this.checkin){

            this.checkout = false;
            return true;

        }
        else{
            this.checkout = true;
            return false;

        }

    }

    public void checkIn(int x, int y, int timeStamp){

        if(this.balance < 100){

            System.out.printf("Not enough money in account to check in. Please deposit at least %s DKK%n", (100 - this.balance));
            return;
        }

        this.checkout = false;

        if(!this.checkin){

            this.checkin = true;
            this.initialTS = timeStamp;
            this.xInit = x;
            this.yInit = y;
            System.out.println("Checked in");
        }
        else if (this.checkin && isCheckedIn(timeStamp)){
            
            updateMaxMinDistance(x, y);
            System.out.printf("Continued journey (%s minutes since last check in)%n", timeDif(timeStamp));
            this.initialTS = timeStamp;

        }

    }

    public void checkOut(int x, int y, int timeStamp){

        int deltaX, deltaY;

        this.checkin = isCheckedIn(timeStamp);

        if (this.checkout){

            System.out.println("Error: Cannot check out; Not currently checked in");

        }
        else{

            if(this.checkinOnce){
                
                deltaX = x >= this.xInit ? (x - this.xInit) : (this.xInit - x);
                deltaY = y >= this.yInit ? (y - this.yInit) : (this.yInit - y);
            
            }
            else{

                updateMaxMinDistance(this.xInit, this.yInit);
                deltaX = (this.maxX - this.minX);
                deltaY = (this.maxY - this.minY);

            }

            this.travelPrice = 12 + (deltaX + deltaY) * 3;

            if(this.travelPrice>50) this.travelPrice = 50;

            this.balance -= this.travelPrice;
           

            System.out.printf("Checked out! %s minutes since last check in. Price is %s DKK, remaining balance is %s DKK%n", timeDif(timeStamp), this.travelPrice, this.balance) ;
            this.travelPrice = 0;
            this.checkin = false;
            this.checkout = true;

        }
    }


    public int timeDif(int timeStamp){

        return (timeStamp - this.initialTS);

    }    


    public void updateMaxMinDistance(int x, int y){

        this.maxX = x > this.maxX ? this.maxX = x : this.maxX;
        this.maxY = y > this.maxY ? this.maxY = y : this.maxY;
        this.minX = this.minX > x ? this.minX = x : this.minX;
        this.minY = this.minY > y ? this.minY = y : this.minY;

        this.checkinOnce = false;

    }

    public static void main(String[] args) throws Exception {
       
        /* RejseKort card = new RejseKort();

        card.checkIn(0, 0, 10);
        card.checkOut(30, 20, 100);
        card.checkOut(30, 20, 110);
        card.checkIn(30, 20, 120);
        card.checkOut(0,0,140);

        card.depositMoney(200);
        card.checkIn(30, 20, 120);
        card.checkIn(15, 10, 130);
        card.checkOut(0,0,140); */


        /* RejseKort r;
        r = new RejseKort();
        r.checkIn(3, 4, 200);
		r.checkIn(1, 2, 300);
		r.checkIn(4, 5, 400);
		r.checkOut(3, 4, 500); */

    }
}
