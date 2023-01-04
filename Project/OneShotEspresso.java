public class OneShotEspresso extends BeverageDecorator
{
    private final Beverage temp;
    OneShotEspresso(Beverage input){
        temp = input;
    }
    String getDesc(){
        return temp.getDesc()+" + 1 Shot of Espresso (15 Baht)";
    }
    double getPrice(){
        return temp.getPrice()+15;
    }
}
