package com.waracle.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "cakes")
@Entity
public class CakeDTO {
	
	static final int MAX_NAME_LENGTH = 100;
	static final int MAX_DESCRIPTION_LENGTH = 100;
	static final int MAX_IMAGE_URL_LENGTH = 300;
	
	public CakeDTO() {
		
	}
	
    public CakeDTO(String name, String description, String imageURL) {

        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", unique = true, nullable = false, length = MAX_NAME_LENGTH)
	private String name;

	@Column(name = "description", nullable = false, length = MAX_DESCRIPTION_LENGTH)
	private String description;

	@Column(name = "imageURL", nullable = false, length = MAX_IMAGE_URL_LENGTH)
	private String imageURL;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == null) return false;
		if (o.getClass() != this.getClass()) {
            return false;
        }
		if(this == o) return true;
		
		CakeDTO cake = (CakeDTO) o;
		return this.getName().equals(cake.getName()) && 
				this.getDescription().equals(cake.getDescription()) &&
				this.getImageURL().equals(cake.getImageURL());		
		
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(name, description, imageURL);
    }

	

}
