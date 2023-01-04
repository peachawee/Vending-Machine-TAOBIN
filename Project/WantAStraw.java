public class WantAStraw extends BeverageDecorator
{
    private final Beverage temp;
    WantAStraw(Beverage input){
        temp = input;
    }
    String getDesc(){
        return temp.getDesc()+" + a Straw (FREE)";
    }
    double getPrice(){
        return temp.getPrice()+0;
    }
}
