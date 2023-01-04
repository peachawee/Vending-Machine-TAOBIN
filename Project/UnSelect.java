public class UnSelect implements State
{
    private Vendingmachine v;
    public UnSelect(Vendingmachine v){
        this.v = v;      
    }
    public void selectAndCreate(){
        int want = selectProduct();
        int temperat = temperature();
        createProduct(want,temperat);
        v.setState(v.decorateState);
        //addTopping();
    }
    private void createProduct(int want, int temperat){
        v.beverageFactory = FactoryProducer.getFactory(want);
        String temp = "HOT";
        if(temperat==2) temp = "ICE";
        v.beverage = v.beverageFactory.getBeverage(temp);
    }
    
    private int selectProduct(){
        System.out.println("press a number to select a products you want.");
        System.out.println("(press 5 to cancel.)");
        v.showAllProduct();
        int temp = v.kb.nextInt();
        while(temp!=1 && temp!=2 && temp!=3 && temp!=5){
            System.out.println("Please press only (1),(2),(3) or (5) !!");
            System.out.println("press a number to select a products you want.");
            System.out.println("(press 5 to cancel.)");
            temp = v.kb.nextInt();
            }
        if(temp == 5){
            v.cancel();
        }
        return temp;
    }
    private int temperature(){
        System.out.println("-prees 1 for hot.");
        System.out.println("-prees 2 for ice.");
        int temp = v.kb.nextInt();
        while(temp!=1 && temp!=2){
            System.out.println("Please press only (1) or (2) !!");
            System.out.println("press a number to select a products you want.");
            temp = v.kb.nextInt();
            }
        return temp;
    }
    public void addTopping(){
        throw new RuntimeException("Can't add topping.\nYou're in unselect state.");
    }
    public void choosePaymentMethod(){
        throw new RuntimeException("Can't choose payment method.\nYou're in unselect state.");
    }
    public void collectAPoint(){
        throw new RuntimeException("Can't collect a point.\nYou're in unselect state.");
    }
}
