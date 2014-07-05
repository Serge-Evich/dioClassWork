package dio.clsswrk.leftjoin;

/*
Алтернатива классу dio.homework.ex1pojo.Product, с сеттерами шаблона Builder
Пример создания объекта:
        Product telephone = new Product.Builder("Samsung S4", Category.SMARTPHONE)
        .setPrice(599.99)
        .setHeight(30)
        .setLength(40)
        .setWidth(2)
        .setWeight(150)
        .build();
        */

public class Product {
    private final String name;
    private final double price;
    private final int height;
    private final int length;
    private final int width;
    private final int weight;
    private final Category category;

    private Product(Builder builder) {
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.height = builder.height;
        this.length = builder.length;
        this.width = builder.width;
        this.weight = builder.weight;

    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getWeight() {
        return this.weight;
    }

    public Category getCategory() {
        return this.category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (height != product.height) return false;
        if (length != product.length) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (weight != product.weight) return false;
        if (width != product.width) return false;
        if (category != product.category) return false;
        if (!name.equals(product.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + height;
        result = 31 * result + length;
        result = 31 * result + width;
        result = 31 * result + weight;
        result = 31 * result + category.hashCode();
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append(", height=").append(height);
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", weight=").append(weight);
        sb.append(", category=").append(category);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder {

        private String name;
        private Category category;
        private double price;
        private int height;
        private int length;
        private int width;
        private int weight;

        public Builder() {

        }
        public Builder(Product product) {
            this.name = product.name;
            this.category = product.category;
            this.height = product.height;
            this.length = product.length;
            this.price = product.price;
            this.weight = product.weight;
            this.width = product.width;

        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder category(Category category) {
            this.category = category;
            return this;
        }
        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public Builder width(int width) {
            this.weight = width;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }



}