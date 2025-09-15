public class Main {
    public static void main(String[] args) {
        Factory laptopFactory = new AbstractFactory().createFactory(FactoryType.LAPTOP);
        Factory pcFactory     = new AbstractFactory().createFactory(FactoryType.PERSONAL_COMPUTER);
        Laptop gaming          = laptopFactory.createLaptop(LaptopType.GAMING);
        Laptop ultrabook       = laptopFactory.createLaptop(LaptopType.ULTRABOOK);
        Laptop netbook         = laptopFactory.createLaptop(LaptopType.NETBOOK);
        Laptop transformer     = laptopFactory.createLaptop(LaptopType.TRANSFORMER);

        System.out.println("=== Laptop factory created ===");

        System.out.println("\nGaming Laptop:");
        gaming.cpu(); gaming.gpu(); gaming.os(); gaming.sold();

        System.out.println("\nUltrabook:");
        ultrabook.cpu(); ultrabook.gpu(); ultrabook.os(); ultrabook.sold();

        System.out.println("\nNetbook:");
        netbook.cpu(); netbook.gpu(); netbook.os(); netbook.sold();

        System.out.println("\nTransformer Laptop:");
        transformer.cpu(); transformer.gpu(); transformer.os(); transformer.sold();

        System.out.println("\n=== Personal Computer factory created ===");

        PersonalComputer gamingPc  = pcFactory.createPersonalComputer(PcType.GAMING);
        PersonalComputer officePc  = pcFactory.createPersonalComputer(PcType.OFFICE);
        PersonalComputer monoblock = pcFactory.createPersonalComputer(PcType.MONOBLOCK);

        System.out.println("\nGaming PC:");
        gamingPc.cpu(); gamingPc.gpu(); gamingPc.os(); gamingPc.sold();

        System.out.println("\nOffice PC:");
        officePc.cpu(); officePc.gpu(); officePc.os(); officePc.sold();

        System.out.println("\nMonoblock:");
        monoblock.cpu(); monoblock.gpu(); monoblock.os(); monoblock.sold();
    }
}

enum LaptopType { GAMING, ULTRABOOK, NETBOOK, TRANSFORMER }
enum PcType { GAMING, OFFICE, MONOBLOCK }
enum FactoryType { LAPTOP, PERSONAL_COMPUTER }

interface Laptop {
    void cpu();
    void gpu();
    void os();
    void sold();
}

class Gaming implements Laptop {
    @Override public void cpu()  { System.out.println("CPU installed in Gaming Laptop"); }
    @Override public void gpu()  { System.out.println("Discrete GPU installed in Gaming Laptop"); }
    @Override public void os()   { System.out.println("OS installed in Gaming Laptop"); }
    @Override public void sold() { System.out.println("Gaming Laptop is being sold"); }
}

class UltraBook implements Laptop {
    @Override public void cpu()  { System.out.println("CPU installed in Ultrabook"); }
    @Override public void gpu()  { System.out.println("No discrete GPU (integrated) in Ultrabook"); }
    @Override public void os()   { System.out.println("OS installed in Ultrabook"); }
    @Override public void sold() { System.out.println("Ultrabook is being sold"); }
}

class NetBook implements Laptop {
    @Override public void cpu()  { System.out.println("CPU installed in Netbook"); }
    @Override public void gpu()  { System.out.println("No discrete GPU (integrated) in Netbook"); }
    @Override public void os()   { System.out.println("OS installed in Netbook"); }
    @Override public void sold() { System.out.println("Netbook is being sold"); }
}

class TransformerLaptop implements Laptop {
    @Override public void cpu()  { System.out.println("CPU installed in Transformer Laptop"); }
    @Override public void gpu()  { System.out.println("No discrete GPU (integrated) in Transformer Laptop"); }
    @Override public void os()   { System.out.println("OS installed in Transformer Laptop"); }
    @Override public void sold() { System.out.println("Transformer Laptop is being sold"); }
}

interface PersonalComputer {
    void cpu();
    void gpu();
    void os();
    void sold();
}

class GamingPC implements PersonalComputer {
    @Override public void cpu()  { System.out.println("CPU installed in Gaming PC"); }
    @Override public void gpu()  { System.out.println("Discrete GPU installed in Gaming PC"); }
    @Override public void os()   { System.out.println("OS installed in Gaming PC"); }
    @Override public void sold() { System.out.println("Gaming PC is being sold"); }
}

class OfficePc implements PersonalComputer {
    @Override public void cpu()  { System.out.println("CPU installed in Office PC"); }
    @Override public void gpu()  { System.out.println("Integrated GPU used in Office PC"); }
    @Override public void os()   { System.out.println("OS installed in Office PC"); }
    @Override public void sold() { System.out.println("Office PC is being sold"); }
}

class Monoblock implements PersonalComputer {
    @Override public void cpu()  { System.out.println("CPU installed in Monoblock"); }
    @Override public void gpu()  { System.out.println("GPU installed in Monoblock"); }
    @Override public void os()   { System.out.println("OS installed in Monoblock"); }
    @Override public void sold() { System.out.println("Monoblock is being sold"); }
}

interface Factory {
    default Laptop createLaptop(LaptopType type) {
        throw new UnsupportedOperationException("This factory does not produce laptops.");
    }
    default PersonalComputer createPersonalComputer(PcType type) {
        throw new UnsupportedOperationException("This factory does not produce personal computers.");
    }
}

class LaptopFactory implements Factory {
    @Override
    public Laptop createLaptop(LaptopType type) {
        switch (type) {
            case GAMING:      return new Gaming();
            case ULTRABOOK:   return new UltraBook();
            case NETBOOK:     return new NetBook();
            case TRANSFORMER: return new TransformerLaptop();
            default: throw new IllegalArgumentException("Unknown LaptopType: " + type);
        }
    }
}

class PersonalComputersFactory implements Factory {
    @Override
    public PersonalComputer createPersonalComputer(PcType type) {
        switch (type) {
            case GAMING:    return new GamingPC();
            case OFFICE:    return new OfficePc();
            case MONOBLOCK: return new Monoblock();
            default: throw new IllegalArgumentException("Unknown PcType: " + type);
        }
    }
}

class AbstractFactory {
    Factory createFactory(FactoryType type) {
        switch (type) {
            case LAPTOP:             return new LaptopFactory();
            case PERSONAL_COMPUTER:  return new PersonalComputersFactory();
            default: throw new IllegalArgumentException("Unknown FactoryType: " + type);
        }
    }
}