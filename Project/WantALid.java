public class WantALid extends BeverageDecorator
{
    private final Beverage temp;
    WantALid(Beverage input){
        temp = input;
    }
    String getDesc(){
        return temp.getDesc()+" + a LID (FREE)";
    }
    double getPrice(){
        return temp.getPrice()+0;
    }
}
