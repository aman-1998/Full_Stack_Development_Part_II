package personal.learning.model;

import java.util.List;

public class Brand {
	private String brandName;
	private String brandId;
	private List<Link> links;
	
	public Brand() {}

	public Brand(String brandName) {
		this.brandName = brandName;
	}

	public Brand(String brandName, String brandId) {
		this.brandName = brandName;
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
