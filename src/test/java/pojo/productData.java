package pojo;

public class productData {
    private String name;
    private String EuroPrice;
    private String DollarPrice;
    private String PoundSterlingPrice;

        // falta crear las monedas para validar private String

    public productData(String _name,String _EuroPrice,String _DollarPrice, String _PoundSterlingPrice) {
        this.name = _name;
        this.EuroPrice = _EuroPrice;
        this.DollarPrice= _DollarPrice;
        this.PoundSterlingPrice= _PoundSterlingPrice;
    }

    public String getName() {
        return this.name;
    }
    public String getEuroPrice() {
        return this.EuroPrice;
    }
    public String getDollarPrice() {
        return this.DollarPrice;
    }
    public String getPoundSterlingPrice() {
        return this.PoundSterlingPrice;
    }


}
