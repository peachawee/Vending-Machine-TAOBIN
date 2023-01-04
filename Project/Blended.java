public class Blended extends BeverageDecorator
{
    private final Beverage temp;
    Blended(Beverage input){
        temp = input;
    }
    String getDesc(){
        return temp.getDesc()+" + Smoothie (5 Baht)";
    }
    double getPrice(){
        return temp.getPrice()+5;
    }
}
