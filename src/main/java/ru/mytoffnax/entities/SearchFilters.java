package ru.mytoffnax.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Фильтры поиска 
 *
 */
@Getter
@Setter
@ToString
public class SearchFilters {

	/* Поиск по наименованию */
	private String title;

}
