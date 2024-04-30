import java.util.Random;

class FractionArray implements Array{

    ComplexFraction[] fractions;
    public int n=10;
    FractionArray(int n){
        this.n=n;
        fractions = new ComplexFraction[n];
    }

    public void setFractions() {
        Random rand = new Random();
        for (int i=0; i<n; i++){
            int realUp= rand.nextInt(20)+1;
            int realDown= rand.nextInt(20)+1;
            int imaginarUp= rand.nextInt(20)+1;
            int imaginarDown= rand.nextInt(20)+1;
            fractions[i]= new ComplexFraction(realUp,realDown,imaginarUp,imaginarDown);
        }
    }
    public void show() {
        for (int i=0; i<n; i++){
            System.out.println("ComplexFraction "+i);
            fractions[i].print();

        }
    }
    public int lungime(){
        return fractions.length;
    }

    public void invers(){
        int i;
        ComplexFraction t;
        for (i = 0; i < n / 2; i++) {
            t = fractions[i];
            fractions[i] = fractions[n - i - 1];
            fractions[n - i - 1] = t;
        }
        System.out.println("Tabloul inversat: ");
        show();
    }

}

class ComplexFraction{
    public int realUp;
    public int imaginarUp;
    public int realDown;
    public int imaginarDown;

    ComplexFraction(int realUp, int realDown, int imaginarUp,int imaginarDown) {

        this.realUp = realUp;
        this.realDown = realDown;
        this.imaginarUp= imaginarUp;
        this.imaginarDown=imaginarDown;
    }


    public int getRealNumarator() { return realUp; }
    public int getRealNumitor() { return realDown; }
    public int getImaginarNumarator() { return imaginarUp; }
    public int getImaginarNumitor() { return imaginarDown; }


    public void print(){
        System.out.println(realUp +"+" +imaginarUp+"i / "+realDown+"+"+imaginarDown+"i");
    }
}

class ArrayArbuser{
    Array fractionArray;

    ArrayArbuser(Array fractionArray)
    {
        this.fractionArray = fractionArray;

    }
    public void boo(){
        fractionArray.show();
    }

}


public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(20)+1;
        FractionArray fractionArray = new FractionArray(n);
        fractionArray.setFractions();
        fractionArray.show();
        ArrayArbuser array=new ArrayArbuser(fractionArray);
        array.boo();
        System.out.println("Lungimea tabloului este: "+fractionArray.lungime());
        fractionArray.invers();

    }
}