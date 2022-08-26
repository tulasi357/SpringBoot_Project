/**
 * 
 */
package com.DSSystem.model;

/**
 * @author mekai
 *
 */
public class Genres {
	
	private Integer genresId;
	private String genresName;
	
	public Genres(Integer genresId, String genresName) {
		super();
		this.genresId = genresId;
		this.genresName = genresName;
	}

	public Integer getGenresId() {
		return genresId;
	}

	public void setGenresId(Integer genresId) {
		this.genresId = genresId;
	}

	public String getGenresName() {
		return genresName;
	}

	public void setGenresName(String genresName) {
		this.genresName = genresName;
	}

	

}
