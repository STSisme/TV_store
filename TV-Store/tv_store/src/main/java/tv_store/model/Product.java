package tv_store.model;

public class Product {
	private int id;
	private String name;
	private String image;
	private float price;
	private String description;
	
    public Product() {
    }

    public Product(String name, String image, float price, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
    }

    public Product(int id, String name, String image, float price, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
