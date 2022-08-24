package com.ecom.Payloads;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {

	private List<ProductDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean isLast;

}
